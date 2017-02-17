package tk.mbondos.yora.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.squareup.otto.Subscribe;

import tk.mbondos.yora.R;
import tk.mbondos.yora.services.Account;

/**
 * Created by maksy on 30.09.2016.
 */
public class LoginFragment extends BaseFragment implements View.OnClickListener {
    private Button loginButton;
    private Callbacks callbacks;
    private View progressBar;
    private EditText usernameText;
    private EditText passwordText;
    private String defaultLoginButtonText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup root, Bundle savedState) {
        View view = inflater.inflate(R.layout.fragment_login, root, false);

        loginButton = (Button) view.findViewById(R.id.fragment_login_loginButton);
        loginButton.setOnClickListener(this);

        progressBar = view.findViewById(R.id.fragment_login_progress);
        usernameText = (EditText) view.findViewById(R.id.fragment_login_userName);
        passwordText = (EditText) view.findViewById(R.id.fragment_login_password);

        defaultLoginButtonText = loginButton.getText().toString();

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view == loginButton) {
            progressBar.setVisibility(View.VISIBLE);
            loginButton.setText("");
            loginButton.setEnabled(false);
            usernameText.setEnabled(false);
            passwordText.setEnabled(false);

            bus.post(new Account.LoginWithUsernameRequest(
                    usernameText.getText().toString(),
                    passwordText.getText().toString()));

        }


    }

    @Subscribe
    public void onLoginWithUsername(Account.LoginWithUsernameResponse response) {
        response.showErrorToast(getActivity());

        if (response.didSucceed()) {
            callbacks.onLoggedIn();
            return;
        }

        usernameText.setError(response.getPropertyError("userName"));
        usernameText.setEnabled(true);

        passwordText.setError(response.getPropertyError("password"));
        passwordText.setEnabled(true);

        progressBar.setVisibility(View.GONE);
        loginButton.setText(defaultLoginButtonText);

        loginButton.setEnabled(true);

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
