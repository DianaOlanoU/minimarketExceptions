package model;

import exceptions.IncorrectIDException;
import exceptions.IncorrectPenultimateNumberException;
import org.junit.Test;
import static org.junit.Assert.*;

public class MinimarketTest {
    
    public void MinimarketTestScenary(){
    }

    @Test
    public void testAddPersonToMinimarket1() throws Exception {
        MinimarketTestScenary();
        String IDNumber = "14955967895";
        String idType = "CE";
        Minimarket instance = new Minimarket();
        String expResult = "La persona fue ingresada exitosamente al mini mercado.";
        String result = instance.addPersonToMinimarket(IDNumber, idType);
        assertEquals(expResult, result);
        if(!result.equals(expResult)){
            fail("No salto el mensaje esperado.");
        }
    }
    
    @Test
    public void testAddPersonToMinimarket2() throws Exception {
        MinimarketTestScenary();
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
        MinimarketTestScenary();
        String IDNumber = "2335785";
        String idType = "PP";
        Minimarket instance = new Minimarket();
        try{
            instance.addPersonToMinimarket(IDNumber, idType);
            fail("No salto la excepcion.");
        }catch(IncorrectPenultimateNumberException npe){
            assertEquals("El penultimo numero de su identificacion no coincide con el mes: "+npe.getIncorrectNumber(),npe.getMessage());
        }
    }
}
