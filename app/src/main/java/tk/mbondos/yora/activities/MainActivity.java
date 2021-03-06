package tk.mbondos.yora.activities;


import android.os.Bundle;

import tk.mbondos.yora.R;
import tk.mbondos.yora.views.MainNavDrawer;

public class MainActivity extends BaseAuthenticatedActivity {

    @Override
    protected void onYoraCreate(Bundle savedState) {
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Inbox");
        setNavDrawer(new MainNavDrawer(this));
    }
}
