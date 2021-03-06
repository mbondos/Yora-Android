package tk.mbondos.yora.services;

import java.util.List;

import tk.mbondos.yora.infrastructure.ServiceResponse;
import tk.mbondos.yora.services.entities.ContactRequest;
import tk.mbondos.yora.services.entities.UserDetails;

public final class Contacts {
    private Contacts() {
    }

    public static class GetContactRequestsRequest {
        public boolean FromUs;

        public GetContactRequestsRequest(boolean fromUs) {
            FromUs = fromUs;
        }
    }

    public static class GetContactRequestsResponse extends ServiceResponse {
        public List<ContactRequest> Requests;
    }

    public static class GetContactsRequest {
        public boolean IncludePendingContacts;

        public GetContactsRequest(boolean includePendingContacts) {
            IncludePendingContacts = includePendingContacts;
        }
    }

    public static class GetContactsResponse extends ServiceResponse {
        public List<UserDetails> Contacts;
    }

    public static class SendContactRequestRequest {
        public int UserId;

        public SendContactRequestRequest(int userId) {
            UserId = userId;
        }
    }

    public static class SendContactRequestResponse extends ServiceResponse {

    }

    public static class RespondToContactRequestRequest {
        public int ContactRequestId;
        public boolean Accept;

        public RespondToContactRequestRequest(int contactRequestId, boolean accept) {
            ContactRequestId = contactRequestId;
            Accept = accept;
        }
    }

    public static class RespondToContactRequestResponse extends ServiceResponse {

    }

    public static class RemoveContactRequest {
        public int ContactId;

        public RemoveContactRequest(int contactId) {
            ContactId = contactId;
        }
    }

    public static class RemoveContactResponse extends ServiceResponse {
        public int RemovedContactId;
    }

    public static class SearchUsersRequest {
        public String Query;

        public SearchUsersRequest(String query) {
            Query = query;
        }
    }

    public static class SearchUsersResponse extends ServiceResponse {
        public List<UserDetails> Users;
        public String Query;
    }
}
