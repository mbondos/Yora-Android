package tk.mbondos.yora.services;

import android.net.Uri;

import tk.mbondos.yora.infrastructure.ServiceResponse;


public final class Account {
    private Account() {
    }

    public static class ChangeAvatarRequest {
        public Uri NewAvatarUri;

        public ChangeAvatarRequest(Uri newAvatarUri) {
            NewAvatarUri = newAvatarUri;
        }
    }
    public static class ChangeAvatarResponse extends ServiceResponse{

    }
    public static class UpdateProfileRequest {
        public String DisplayName;
        public String Email;

        public UpdateProfileRequest(String displayName, String email) {
            DisplayName = displayName;
            Email = email;
        }

    }
    public static class  UpdateProfileResponse extends ServiceResponse {

    }
    public static class ChangePasswordRequest {
        public String CurrentPassword;
        public String NewPassword;
        public String ConfirmNewPassword;

        public ChangePasswordRequest(String currentPassword, String newPassword, String confirmNewPassword) {
            CurrentPassword = currentPassword;
            NewPassword = newPassword;
            ConfirmNewPassword = confirmNewPassword;
        }
    }
    public static class ChangePasswordResponse extends ServiceResponse {

    }

}
