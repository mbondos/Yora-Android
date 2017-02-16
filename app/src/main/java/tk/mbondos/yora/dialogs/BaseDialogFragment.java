package tk.mbondos.yora.dialogs;

import android.app.DialogFragment;
import android.os.Bundle;

import tk.mbondos.yora.infrastructure.YoraApplication;



public abstract class BaseDialogFragment extends DialogFragment {
    protected YoraApplication application;

    @Override
    public void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        application = (YoraApplication) getActivity().getApplication();
    }
}
