
package exceptions;

public class IncorrectIDException extends Exception{
    
    private String incorrectTI;
    
    public IncorrectIDException(String id){
        super("EL DOCUMENTO DE IDENTIFICACIÓN NO COINCIDE CON EL REQUERIDO POR EL MINIMERCADO (CC,PP,CE): "+id.toUpperCase());
        incorrectTI = id;
    }

    public String getIncorrectTI() {
        return incorrectTI;
    }
}
