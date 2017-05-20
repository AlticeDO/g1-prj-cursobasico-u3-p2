package my_exception;

/**
 * Created by eduardorodriguez on 5/20/17.
 */

public class MyException extends Exception {

    private String myMessage;

    public MyException() {

    }

    @Override
    public  String getMessage() {
        return getMyMessage();
    }

    public String getMyMessage() {
        return myMessage;
    }

    public void setMyMessage(String myMessage) {
        this.myMessage = myMessage;
    }
}
