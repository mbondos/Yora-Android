package tk.mbondos.yora.activities;

import android.os.Bundle;

import tk.mbondos.yora.R;
import tk.mbondos.yora.fragments.LoginFragment;

/**
 * Created by maksy on 30.09.2016.
 */
public class LoginNarrowActivity extends BaseActivity implements LoginFragment.Callbacks {
    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        setContentView(R.layout.activity_login_narrow);
    }

    @Override
    public void onLoggedIn() {
        setResult(RESULT_OK);
        finish();
    }
}
