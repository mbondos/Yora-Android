package tk.mbondos.yora.services;

import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import tk.mbondos.yora.infrastructure.YoraApplication;
import tk.mbondos.yora.services.entities.Message;
import tk.mbondos.yora.services.entities.UserDetails;

public class InMemoryMessagesService extends BaseInMemoryService {


    public InMemoryMessagesService(YoraApplication application) {
        super(application);
    }

    @Subscribe
    public void deleteMessage(Messages.DeleteMessageRequest request) {
        Messages.DeleteMessageResponse response = new Messages.DeleteMessageResponse();
        response.MessageId = request.MessageId;
        postDelayed(response);
    }

    @Subscribe
    public void searchMessages(Messages.SearchMessagesRequest request) {
        Messages.SearchMessagesResponse response = new Messages.SearchMessagesResponse();
        response.Messages = new ArrayList<>();

        UserDetails[] users = new UserDetails[10];
        for (int i = 0; i < users.length; i++) {
            String stringId = Integer.toString(i);
            users[i] = new UserDetails(
                    i,
                    true,
                    "User" + stringId,
                    "user_" + stringId,
                    "http://www.gravatar.com/avatar/" + stringId + "?d=identicon");
        }

        Random random = new Random();
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DATE, -100);

        for (int i = 0; i < 100; i++) {
            boolean isFromUs;

            if (request.IncludeRecievedMessages && request.IncludeSentMessages) {
                isFromUs = random.nextBoolean();
            } else {
                isFromUs = !request.IncludeRecievedMessages;
            }

            date.set(Calendar.MINUTE, random.nextInt(60 * 24));

            String numberString = Integer.toString(i);

            response.Messages.add(new Message(
                    i,
                    (Calendar) date.clone(),
                    "Short Message " + numberString,
                    "Long Message " + numberString,
                    "",
                    users[random.nextInt(users.length)],
                    isFromUs,
                    i > 4));
        }

        postDelayed(response, 2000);


    }

}
