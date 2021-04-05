
package exceptions;

public class IncorrectPenultimateNumberException extends Exception {
    
    private int incorrectNumber;
    
    public IncorrectPenultimateNumberException(int number){
    super("El penultimo numero de su identificacion no coincide con el mes");
    incorrectNumber = number;
    }

    public int getIncorrectNumber() {
        return incorrectNumber;
    }
}
