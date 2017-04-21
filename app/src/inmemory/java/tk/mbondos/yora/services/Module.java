package tk.mbondos.yora.services;


import tk.mbondos.yora.infrastructure.YoraApplication;

public class Module {
    public static void register(YoraApplication application) {
        new InMemoryAccountService(application);
        new InMemoryContactService(application);
        new InMemoryMessagesService(application);

    }
}