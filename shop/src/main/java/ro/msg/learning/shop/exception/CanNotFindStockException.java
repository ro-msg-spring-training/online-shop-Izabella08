package ro.msg.learning.shop.exception;

public class CanNotFindStockException extends RuntimeException{
    String errorMessage;

    public CanNotFindStockException(String errorMessage){
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}
