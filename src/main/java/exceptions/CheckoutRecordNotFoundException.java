package exceptions;

public class CheckoutRecordNotFoundException extends Exception{
    public CheckoutRecordNotFoundException(String message){
        super(message);
    }
}
