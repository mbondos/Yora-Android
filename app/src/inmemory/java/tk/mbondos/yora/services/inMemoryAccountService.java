package tk.mbondos.yora.services;

import com.squareup.otto.Subscribe;

import tk.mbondos.yora.infrastructure.YoraApplication;


public class InMemoryAccountService extends BaseInMemoryService {
    public InMemoryAccountService(YoraApplication application) {
        super(application);
    }

    @Subscribe
    public void updateProfile(Account.UpdateProfileRequest request) {
        Account.UpdateProfileResponse response = new Account.UpdateProfileResponse();
        postDelayed(response, 4000);
    }

    @Subscribe
    public void updateAvatar(Account.ChangeAvatarRequest request) {
        postDelayed(new Account.ChangePasswordResponse());
    }

    @Subscribe
    public void changePassword(Account.ChangePasswordRequest request) {
        Account.ChangePasswordResponse response = new Account.ChangePasswordResponse();

        if (!request.NewPassword.equals(request.ConfirmNewPassword))
            response.setPropertyError("confirmNewPassword", "Passwords must match!");

        if (request.NewPassword.length() < 3)
            response.setPropertyError("newPassword", "Password must be larger than 3 characters");

        postDelayed(response);
    }

}
