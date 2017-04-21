package tk.mbondos.yora.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.squareup.otto.Subscribe;

import tk.mbondos.yora.R;
import tk.mbondos.yora.activities.BaseActivity;
import tk.mbondos.yora.services.Contacts;
import tk.mbondos.yora.views.ContactRequestsAdapter;

public class PendingContactRequestsFragment extends BaseFragment {
    private View progressFrame;
    private ContactRequestsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pending_contact_requests, container, false);
        progressFrame = view.findViewById(R.id.fragment_pending_contact_requests_progressFrame);
        adapter = new ContactRequestsAdapter((BaseActivity) getActivity());

        ListView listView = (ListView) view.findViewById(R.id.fragment_pending_contact_requests_list);
        listView.setAdapter(adapter);

        bus.post(new Contacts.GetContactRequestsRequest(true));

        return view;
    }

    @Subscribe
    public void onGetContactRequests(Contacts.GetContactRequestsResponse response) {
        response.showErrorToast(getActivity());

        progressFrame.animate()
                .alpha(0)
                .setDuration(250)
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        progressFrame.setVisibility(View.GONE);
                    }
                })
                .start();

        adapter.clear();
        adapter.addAll(response.Requests);
    }
}
