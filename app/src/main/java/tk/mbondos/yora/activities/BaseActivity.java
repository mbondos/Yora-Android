package tk.mbondos.yora.activities;



import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import tk.mbondos.yora.R;
import tk.mbondos.yora.infrastructure.YoraApplication;
import tk.mbondos.yora.views.NavDrawer;

public abstract class BaseActivity extends AppCompatActivity {
    protected YoraApplication application;
    protected Toolbar toolbar;
    protected NavDrawer navDrawer;

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        application = (YoraApplication) getApplication();
    }
    @Override
    public void setContentView(@LayoutRes int layoutResId) {
        super.setContentView(layoutResId);

        toolbar = (Toolbar) findViewById(R.id.include_toolbar);

        if(toolbar != null)
            setSupportActionBar(toolbar);
    }
    protected void setNavDrawer(NavDrawer drawer) {
        this.navDrawer = drawer;
        this.navDrawer.create();
    }
    public Toolbar getToolbar() {
        return toolbar;
    }
    public YoraApplication getYoraApplication() {
        return application;
    }
}
