package tk.mbondos.yora.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import tk.mbondos.yora.R;
import tk.mbondos.yora.activities.BaseActivity;
import tk.mbondos.yora.activities.ContactsActivity;
import tk.mbondos.yora.activities.MainActivity;
import tk.mbondos.yora.activities.ProfileActivity;
import tk.mbondos.yora.activities.SentMessagesActivity;
import tk.mbondos.yora.infrastructure.User;
import tk.mbondos.yora.services.Account;

/**
 * Created by maksy on 15.02.2017.
 */

public class MainNavDrawer extends NavDrawer {
    private final TextView displayNameText;
    private final ImageView avatarImage;


    public MainNavDrawer(final BaseActivity activity) {
        super(activity);

        addItem(new ActivityNavDrawerItem(MainActivity.class, "Inbox", null, R.drawable.ic_contact_mail_black_24dp , R.id.include_main_nav_drawer_topItems));
        addItem(new ActivityNavDrawerItem(SentMessagesActivity.class, "Sent Messages", null, R.drawable.ic_arrow_back_black_24dp,R.id.include_main_nav_drawer_topItems));
        addItem(new ActivityNavDrawerItem(ContactsActivity.class,"Contacts", null, R.drawable.ic_menu_black_24dp,R.id.include_main_nav_drawer_topItems));
        addItem(new ActivityNavDrawerItem(ProfileActivity.class, "Profile", null, R.drawable.ic_mood_black_24dp,R.id.include_main_nav_drawer_topItems));
        addItem(new BasicNavDrawerItem("Logout", null, R.drawable.ic_cancel_black_24dp, R.id.include_main_nav_drawer_bottomItems) {
            @Override
            public void onClick(View view) {
                activity.getYoraApplication().getAuth().logout();
                Toast.makeText(activity, "You have logged out!", Toast.LENGTH_SHORT).show();
            }
        });

        displayNameText = (TextView) navDrawerView.findViewById(R.id.include_main_nav_drawer_displayName);
        avatarImage = (ImageView) navDrawerView.findViewById(R.id.include_main_nav_drawer_avatar);

        User loggedInUser = activity.getYoraApplication().getAuth().getUser();
        displayNameText.setText(loggedInUser.getDisplayName());

        //// TODO: 15.02.2017 change avatar image from loggedInUser

    }

    @Subscribe
    public void onUserDetailsUpdated(Account.UserDetailsUpdateEvent event) {
        // // TODO: 17.02.2017 udpate avatar url
        displayNameText.setText(event.User.getDisplayName());
    }
}
