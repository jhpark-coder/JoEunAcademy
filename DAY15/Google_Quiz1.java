/*
package WEEK04.DAY15;

interface Notifier{

    public boolean send(String recipient, String message);
    default String getNotificationType(){
        return "기본 알림";
    }
}

abstract class AbstractNotifier implements Notifier{

    protected String notificationCountent;
    void prepareMessage(String message){}
    abstract void validateRecipient(String recipient);
}

class EmailNotifier extends AbstractNotifier{

    @Override
    void validateRecipient(String recipient){

    }

    @Override
    boolean send(String recipient, String message){

    }
}


public class Google_Quiz1 {
}
*/