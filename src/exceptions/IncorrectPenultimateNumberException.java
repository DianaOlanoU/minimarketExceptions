
package exceptions;

public class IncorrectPenultimateNumberException extends Exception {
    
    private char incorrectNumber;
    
    public IncorrectPenultimateNumberException(char number){
        super("EL PENÚLTIMO NUMERO DE SU IDENTIFICACIÓN NO COINCIDE CON EL DÍA ACTUAL: "+number);
        incorrectNumber = number;
    }

    public char getIncorrectNumber() {
        return incorrectNumber;
    }
}
