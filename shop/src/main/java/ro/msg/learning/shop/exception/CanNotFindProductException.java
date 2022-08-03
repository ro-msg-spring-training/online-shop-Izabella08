package ro.msg.learning.shop.exception;

public class CanNotFindProductException extends RuntimeException{
    String errorMessage;

    public CanNotFindProductException(String errorMessage){
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}
