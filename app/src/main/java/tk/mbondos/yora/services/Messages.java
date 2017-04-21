package tk.mbondos.yora.services;

import java.util.List;

import tk.mbondos.yora.infrastructure.ServiceResponse;
import tk.mbondos.yora.services.entities.Message;

public class Messages {
    private Messages() {

    }

    public static class DeleteMessageRequest {
        public int MessageId;

        public DeleteMessageRequest(int messageId) {
            MessageId = messageId;
        }
    }

    public static class DeleteMessageResponse extends ServiceResponse {
        public int MessageId;

    }

    public static class SearchMessagesRequest {
        public int FromContactId;
        public boolean IncludeSentMessages;
        public boolean IncludeRecievedMessages;

        public SearchMessagesRequest(int fromContactId, boolean includeSentMessages, boolean includeRecievedMessages) {
            FromContactId = fromContactId;
            IncludeSentMessages = includeSentMessages;
            IncludeRecievedMessages = includeRecievedMessages;
        }

        public SearchMessagesRequest(boolean includeSentMessages, boolean includeRecievedMessages) {
            IncludeSentMessages = includeSentMessages;
            IncludeRecievedMessages = includeRecievedMessages;
        }


    }

    public static class SearchMessagesResponse extends ServiceResponse {
        public List<Message> Messages;
    }

}
