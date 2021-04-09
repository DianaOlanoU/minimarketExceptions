package model;

import exceptions.IncorrectIDException;
import exceptions.IncorrectPenultimateNumberException;
import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

public class MinimarketTest {
    
    public void minimarketTestScenary(){
    }

    @Test
    public void testAddPersonToMinimarket1() throws Exception {
        minimarketTestScenary();
        Minimarket instance = new Minimarket();
        int currentDay =LocalDate.now().getDayOfMonth();
        String idType = "CE";
        String result ="";
        String expResult = "La persona fue ingresada exitosamente al mini mercado.";
        if(currentDay%2==0){
            String IDNumber = "14955967885";
            result = instance.addPersonToMinimarket(IDNumber, idType);
        }
        else if(currentDay%2!=0){
            String IDNumber = "14955967895";
            result = instance.addPersonToMinimarket(IDNumber, idType);
        }
        assertEquals(expResult, result);
        if(!result.equals(expResult)){
            fail("No salto el mensaje esperado.");
        }
    }
    
    @Test
    public void testAddPersonToMinimarket2() throws Exception {
        minimarketTestScenary();
        String IDNumber = "997414562";
        String idType = "TI";
        Minimarket instance = new Minimarket();
        try{
            instance.addPersonToMinimarket(IDNumber, idType);
            fail("No salto la excepcion.");
        }catch(IncorrectIDException npe){
            assertEquals("El documento de identifacion no coincide con el requerido en el minimercado: "+npe.getIncorrectTI(),npe.getMessage());
        }
    }
    
    @Test
    public void testAddPersonToMinimarket3() throws Exception {
        minimarketTestScenary();
        Minimarket instance = new Minimarket();
        int currentDay =LocalDate.now().getDayOfMonth();
        String idType = "PP";
        try{
            if(currentDay%2==0){
            String IDNumber = "2335795";
            instance.addPersonToMinimarket(IDNumber, idType);
            }
            else if(currentDay%2!=0){
                String IDNumber = "2335785";
                instance.addPersonToMinimarket(IDNumber, idType);
            }
            fail("No salto la excepcion.");
        }catch(IncorrectPenultimateNumberException npe){
            assertEquals("El penultimo numero de su identificacion no coincide con el mes: "+npe.getIncorrectNumber(),npe.getMessage());
        }
    }
}
