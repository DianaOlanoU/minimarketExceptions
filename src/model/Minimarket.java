
package model;

import exceptions.IncorrectIDException;
import exceptions.IncorrectPenultimateNumberException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Minimarket {
    private List<Person> people;
    private int count;

    public Minimarket() {
        people = new ArrayList<>();
    }
    
    public void addPersonToMinimarket(String IDNumber, String idType) throws IncorrectIDException,IncorrectPenultimateNumberException{
    
        int durrentDay =LocalDate.now().getDayOfMonth();
        char penultimateNumber=searchPenultimateNumber(IDNumber);
        
        if(idType.equalsIgnoreCase("TI")){
            count++;
            totalAmounOfPeople(count);
            throw new IncorrectIDException(idType);
        }
        else if(durrentDay%2==0 &&  penultimateNumber%2!=0 || durrentDay%2!=0 &&  penultimateNumber%2==0){
            count++;
            totalAmounOfPeople(count);
            throw new IncorrectPenultimateNumberException(penultimateNumber);
        }
        else if(durrentDay%2==0 && penultimateNumber%2==0){
            people.add(new Person(idType,IDNumber));
            count++;
            totalAmounOfPeople(count);
        }
        else if(durrentDay%2!=0 && penultimateNumber%2!=0){
            people.add(new Person(idType,IDNumber));
            count++;
            totalAmounOfPeople(count);
        }
    }
    
    public static char searchPenultimateNumber(String IDnumber) {
        char finalNumber = 0;
        for (int i=0; i<IDnumber.length();i++){
            finalNumber = IDnumber.charAt(IDnumber.length()-2);
        }
        return finalNumber ;
    }
    
    public int totalAmounOfPeople(int count){
        int total = 0;
        if(count>0){
          total++;
        }
        return total;
    }

    public int getCount() {
        return count;
    }
}
