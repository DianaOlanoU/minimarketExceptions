
package exceptions;

public class IncorrectIDException extends Exception{
    
    private String incorrectTI;
    
    public IncorrectIDException(String id){
    super("El documento de identifacion no coincide con el requerido en el minimercado");
    incorrectTI = id;
    }

    public String getIncorrectTI() {
        return incorrectTI;
    }
}
