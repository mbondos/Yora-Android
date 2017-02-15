package tk.mbondos.yora.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import tk.mbondos.yora.R;

/**
 * Created by maksy on 30.09.2016.
 */
public class LoginFragment extends BaseFragment implements View.OnClickListener {
    private Button loginButton;
    private Callbacks callbacks;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup root, Bundle savedState) {
        View view = inflater.inflate(R.layout.fragment_login, root, false);

        loginButton = (Button) view.findViewById(R.id.fragment_login_loginButton);
        loginButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view == loginButton) {
            application.getAuth().getUser().setLoggedIn(true);
            application.getAuth().getUser().setDisplayName("Nelson LaQuet");
            callbacks.onLoggedIn();

        }


    }
    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = null;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity;
        if (context instanceof Activity) {
            activity = (Activity) context;
            callbacks = (Callbacks) activity;
        } else
            throw new RuntimeException("Context not instanceof Activity in onAttach method in LoginFragment");


    }

    public interface Callbacks {
        void onLoggedIn();
    }
}
