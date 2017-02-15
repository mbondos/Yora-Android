package tk.mbondos.yora.fragments;

import android.app.Fragment;
import android.os.Bundle;

import tk.mbondos.yora.infrastructure.YoraApplication;

public abstract class BaseFragment extends Fragment  {
    protected YoraApplication application;

    @Override
    public void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        application = (YoraApplication) getActivity().getApplication();

    }
}
