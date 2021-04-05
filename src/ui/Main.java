
package ui;
import exceptions.IncorrectIDException;
import exceptions.IncorrectPenultimateNumberException;
import java.util.Scanner;
import model.Minimarket;

public class Main {
    public static Scanner lector = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.print("_____________________________________INGRESAR DATOS AL MINI MERCADO________________________________________________________\n");
        Minimarket information= new Minimarket();
        
        boolean finalMenu=false;
        
        while(!finalMenu){
            System.out.print("\n¿Cual opcion desea escoger?"+
                     "\n"+
                     "\nEscriba 1, si quiere registrar el ingreso de una persona"+
                     "\nEscriba 2, si quiere saber la cantidad de personas que han intentado ingresar al mini mercado"+
                     "\nEscriba 0, si desea salir de la aplicacion"+
                     "\nEscriba aqui: ");
                    int userOption=lector.nextInt();
                    lector.nextLine();
                    
            switch(userOption){
        
            case 0:{
               finalMenu=true;
               System.out.print("\n");
               System.out.print("_____________________________________CERRANDO APLICACION________________________________________________________\n");
               System.out.print("\n");
               break;
            }
            
            case 1:{
               System.out.print("\n");
               System.out.print("_____________________________________INGRESAR PERSONA AL MINI MERCADO___________________________________________________\n");
               accessPersonToTheMinimarket(information);   
               System.out.print("\n");
               break;
            }
            
            case 2:{
               System.out.print("\n");
               System.out.print("_____________________________________DESPEDIR EMPLEADO DEL CLUB___________________________________________________\n");
               //fireEmployee(information);
               System.out.print("\n");
               break;
            }
        }
        }
    }
    
    public static void accessPersonToTheMinimarket(Minimarket minimarketInformation){
        
        System.out.print("\n");
        System.out.print("¿Que tipo de identificacion tiene la persona?"+
                     "\n"+
                     "\nEscriba TI, si es tarjeta de identidad"+
                     "\nEscriba CC, si es cédula de ciudadanía"+
                     "\nEscriba PP, si es pasaporte"+
                     "\nEscriba CE, si es cédula de extranjería"+
                     "\nEscriba aqui: ");
        String IDOption=lector.nextLine();
        System.out.print("\n");
        
        System.out.print("Escriba la identifiacion de la persona: ");
        String personIDNumber=lector.nextLine();
        
        try{
            minimarketInformation.addPersonToMinimarket(personIDNumber, IDOption);
            System.out.println("La persona fue ingresada exitosamente al mini mercado.");
        }catch(IncorrectIDException npe){
            System.err.println(npe.getMessage());
        }catch(IncorrectPenultimateNumberException npe){
            System.err.println(npe.getMessage());
        }
    }
    
}
