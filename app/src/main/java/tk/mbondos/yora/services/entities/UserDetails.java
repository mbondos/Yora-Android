package tk.mbondos.yora.services.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class UserDetails implements Parcelable {
    private int id;
    private boolean isContact;
    private String displayName;
    private String username;
    private String avatarUrl;

    public UserDetails(int id, boolean isContact, String displayName, String username, String avatarUrl) {
        this.id = id;
        this.isContact = isContact;
        this.displayName = displayName;
        this.username = username;
        this.avatarUrl = avatarUrl;
    }

    public int getId() {
        return id;
    }

    public boolean isContact() {
        return isContact;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getUsername() {
        return username;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public static final Creator<UserDetails> CREATOR = new Creator<UserDetails>() {
        @Override
        public UserDetails createFromParcel(Parcel source) {
            return new UserDetails(0, false, null, null, null);
        }

        @Override
        public UserDetails[] newArray(int size) {
            return new UserDetails[0];
        }
    };
}
