
package model;

import exceptions.IncorrectIDException;
import exceptions.IncorrectPenultimateNumberException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Minimarket {
    private List<Person> people;

    public Minimarket() {
        people = new ArrayList<>();
    }
    
    public void addPersonToMinimarket(String IDNumber, String idType) throws IncorrectIDException,IncorrectPenultimateNumberException{
    
        int durrentDay =LocalDate.now().getDayOfMonth();
        char penultimateNumber=searchPenultimateNumber(IDNumber);
        
        if(idType.equalsIgnoreCase("TI")){
            throw new IncorrectIDException(idType);
        }
        else if(durrentDay%2==0 &&  penultimateNumber%2!=0 || durrentDay%2!=0 &&  penultimateNumber%2==0){
            throw new IncorrectPenultimateNumberException(penultimateNumber);
        }
        else if(durrentDay%2==0 && penultimateNumber%2==0){
            Person person = new Person(idType,IDNumber);
            people.add(person);
        }
        else if(durrentDay%2!=0 && penultimateNumber%2!=0){
            Person person = new Person(idType,IDNumber);
            people.add(person);
        }
    }
    
    public static char searchPenultimateNumber(String IDnumber) {
        char finalNumber = 0;
        for (int i=0; i<IDnumber.length();i++){
            finalNumber = IDnumber.charAt(IDnumber.length()-2);
        }
        return finalNumber ;
    }
    
    public List<Person> getPeople(){
        return people;
    }
}
