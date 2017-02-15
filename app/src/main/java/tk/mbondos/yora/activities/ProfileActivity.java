package tk.mbondos.yora.activities;

import android.os.Bundle;

import tk.mbondos.yora.R;
import tk.mbondos.yora.views.MainNavDrawer;

/**
 * Created by maksy on 15.02.2017.
 */

public class ProfileActivity extends BaseAuthenticatedActivity {

    @Override
    protected void onYoraCreate(Bundle savedState) {
        setContentView(R.layout.activity_profile);
        setNavDrawer(new MainNavDrawer(this));
    }
}
