package tk.mbondos.yora.fragments;

import android.app.Fragment;
import android.os.Bundle;

import tk.mbondos.yora.infrastructure.YoraApplication;

/**
 * Created by maksy on 30.09.2016.
 */
public abstract class BaseFragment extends Fragment  {
    protected YoraApplication application;

    @Override
    public void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        application = (YoraApplication) getActivity().getApplication();

    }
}
