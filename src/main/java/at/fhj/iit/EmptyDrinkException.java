package at.fhj.iit;

public class EmptyDrinkException extends Exception{
    @Override
    public String getMessage() {
        return "It seems like your Drink is empty.";
    }
}
