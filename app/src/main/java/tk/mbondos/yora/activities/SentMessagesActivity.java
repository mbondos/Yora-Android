package tk.mbondos.yora.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import tk.mbondos.yora.R;
import tk.mbondos.yora.services.Messages;
import tk.mbondos.yora.services.entities.Message;
import tk.mbondos.yora.views.MainNavDrawer;
import tk.mbondos.yora.views.MessagesAdapter;


public class SentMessagesActivity extends BaseAuthenticatedActivity implements MessagesAdapter.OnMessageClickedListener {
    private static final int REQUEST_VIEW_MESSAGE = 1;

    private MessagesAdapter adapter;
    private ArrayList<Message> messages;
    private View progressFrame;

    @Override
    protected void onYoraCreate(Bundle savedState) {
        setContentView(R.layout.activity_sent_messages);
        setNavDrawer(new MainNavDrawer(this));
        getSupportActionBar().setTitle("Sent Messages");
        adapter = new MessagesAdapter(this, this);
        messages = adapter.getMessages();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.activity_sent_messages_messages);
        recyclerView.setAdapter(adapter);

        if (isTablet) {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }

        progressFrame = findViewById(R.id.activity_sent_messages_progressFrame);

        scheduler.postEveryMilliseconds(new Messages.SearchMessagesRequest(true, false), 1000 * 60 * 3);
    }

    @Override
    public void onMessageClicked(Message message) {
        Intent intent = new Intent(this, MessageActivity.class);
        intent.putExtra(MessageActivity.EXTRA_MESSAGE, message);
        startActivityForResult(intent, REQUEST_VIEW_MESSAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != REQUEST_VIEW_MESSAGE || requestCode != MessageActivity.REQUEST_IMAGE_DELETED) {
            return;
        }

        int messageId = data.getIntExtra(MessageActivity.RESULT_EXTRA_MESSAGE_ID, -1);
        if (messageId == -1) {
            return;
        }

        for (int i = 0; i < messages.size(); i++) {
            Message message = messages.get(i);
            if (message.getId() != messageId) {
                continue;
            }

            messages.remove(i);
            adapter.notifyItemRemoved(i);
            break;
        }

    }

    @Subscribe
    public void onMessagesLoaded(Messages.SearchMessagesResponse response) {
        response.showErrorToast(this);

        int oldMessagesSize = messages.size();

        messages.clear();
        adapter.notifyItemRangeRemoved(0, oldMessagesSize);

        messages.addAll(response.Messages);
        adapter.notifyItemRangeInserted(0, messages.size());

        progressFrame.setVisibility(View.GONE);
    }
}
