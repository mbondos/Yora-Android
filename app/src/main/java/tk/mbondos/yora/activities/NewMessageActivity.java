package tk.mbondos.yora.activities;

import android.os.Bundle;

import tk.mbondos.yora.R;

public class NewMessageActivity extends BaseAuthenticatedActivity {
    public static final String EXTRA_CONTACT = "EXTRA_CONTACT";

    @Override
    protected void onYoraCreate(Bundle savedState) {
        setContentView(R.layout.activity_contact);

    }
}
