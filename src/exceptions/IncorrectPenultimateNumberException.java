
package exceptions;

public class IncorrectPenultimateNumberException extends Exception {
    
    private char incorrectNumber;
    
    public IncorrectPenultimateNumberException(char number){
        super("El penultimo numero de su identificacion no coincide con el mes: "+number);
        incorrectNumber = number;
    }

    public char getIncorrectNumber() {
        return incorrectNumber;
    }
}
