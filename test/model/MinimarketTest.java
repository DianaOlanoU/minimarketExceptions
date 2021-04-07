
package model;

import exceptions.IncorrectIDException;
import exceptions.IncorrectPenultimateNumberException;
import org.junit.Test;
import static org.junit.Assert.*;

public class MinimarketTest {
    
    public MinimarketTest() {
    }

    @Test
    public void testAddPersonToMinimarket1() throws Exception {
        String IDNumber = "14955967885";
        String idType = "CC";
        Minimarket instance = new Minimarket();
        String expResult = "La persona fue ingresada exitosamente al mini mercado.";
        String result = instance.addPersonToMinimarket(IDNumber, idType);
        assertEquals(expResult, result);
        if(!result.equals(expResult)){
            fail("No salto la excepcion.");
        }
    }
    
    @Test
    public void testAddPersonToMinimarket2() throws Exception {
        String IDNumber = "997414562";
        String idType = "TI";
        Minimarket instance = new Minimarket();
        try{
            instance.addPersonToMinimarket(IDNumber, idType);
            fail("No salto la excepcion.");
        }catch(IncorrectIDException npe){
            assertEquals("TI","TI");
        }
    }
    
    @Test
    public void testAddPersonToMinimarket3() throws Exception {
        String IDNumber = "23357895";
        String idType = "CC";
        Minimarket instance = new Minimarket();
        try{
            instance.addPersonToMinimarket(IDNumber, idType);
            fail("No salto la excepcion.");
        }catch(IncorrectPenultimateNumberException npe){
            assertEquals(9,9);
        }
    }
}
