
package ui;

import exceptions.IncorrectIDException;
import exceptions.IncorrectPenultimateNumberException;
import java.util.Scanner;
import model.Minimarket;

public class Main {
    public static Scanner lector = new Scanner(System.in);
    
    public static void main(String[] args) {
        Minimarket information= new Minimarket();
        boolean finalMenu=false;
        
        while(!finalMenu){
            System.out.print("_____________________________________INGRESAR OPCION DEL MINiMERCADO________________________________________________________\n");
            System.out.print("\n¿Cual opcion desea escoger?"+
                            "\n"+
                            "\nEscriba 1, si quiere registrar el ingreso de una persona"+
                            "\nEscriba 2, si quiere saber la cantidad de personas que han intentado ingresar al minimercado y las que ingresaron"+
                            "\nEscriba 0, si desea salir de la aplicacion"+
                            "\nEscriba aqui: ");
                            int userOption=lector.nextInt();
                            lector.nextLine();
                    
            switch(userOption){
                case 0:{
                   finalMenu=true;
                   System.out.print("\n");
                   System.out.print("_____________________________________APLICACION CERRADA________________________________________________________\n");
                   System.out.print("\n");
                   break;
                }
                case 1:{
                   System.out.print("\n");
                   System.out.print("_____________________________________INGRESAR PERSONA AL MINIMERCADO___________________________________________________\n");
                   accessPersonToTheMinimarket(information);   
                   System.out.print("\n");
                   break;
                }
                case 2:{
                   System.out.print("\n");
                   System.out.print("_____________________________________CANTIDAD TOTAL DE PERSONAS___________________________________________________\n");
                   peopleCounter(information);
                   System.out.print("\n");
                   break;
                }
            }
        }
    }
    
    public static void accessPersonToTheMinimarket(Minimarket minimarketInformation){
        System.out.print("\n");
        String IDOption = null;
        boolean repeatMenuKindOfIdentification=false;
        
        while(!repeatMenuKindOfIdentification){
            System.out.print("\n");
            System.out.print("¿Que tipo de identificacion tiene la persona?"+
                             "\n"+
                             "\nEscriba TI, si es tarjeta de identidad"+
                             "\nEscriba CC, si es cédula de ciudadanía"+
                             "\nEscriba PP, si es pasaporte"+
                             "\nEscriba CE, si es cédula de extranjería"+
                             "\nEscriba aqui: ");
            IDOption=lector.nextLine();
            if(IDOption.equalsIgnoreCase("TI") || IDOption.equalsIgnoreCase("CC") || IDOption.equalsIgnoreCase("PP") || IDOption.equalsIgnoreCase("CE")){
                repeatMenuKindOfIdentification=true;
            }
        }
        System.out.print("\n");
        System.out.print("Escriba la identifiacion de la persona: ");
        String personIDNumber=lector.nextLine();
        
        try{
            System.out.println(minimarketInformation.addPersonToMinimarket(personIDNumber, IDOption));
        }catch(IncorrectIDException npe){
            System.err.println(npe.getMessage());
        }
        catch(IncorrectPenultimateNumberException npe){
            System.err.println(npe.getMessage());
        }
    }
    
    public static void peopleCounter(Minimarket minimarketInformation){
        System.out.print("\n");
        System.out.print("La cantidad total de personas que han intentado ingresar y las que ingresaron son: "+minimarketInformation.getCount());
        System.out.print("\n");
    }
}
