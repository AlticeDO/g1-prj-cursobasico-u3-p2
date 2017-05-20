package my_exception;

/**
 * Created by eduardorodriguez on 5/20/17.
 */

public class RequireFieldException extends MyException {

    public RequireFieldException(String field)  {

        this.setMyMessage("Require field: " + field);
    }
}
