
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
    
    public Person findPersonID(String id){
        Person foundPersonID=null;
        boolean finish=true;
        for(int i=0;i<people.size() && finish;i++){
            if(people.get(i).getIDNumber().equals(id)){
                finish=false;
                foundPersonID=people.get(i);
            } 
        }
        return foundPersonID;
    }
    
    public String addPersonToMinimarket(String IDNumber, String idType) throws IncorrectIDException,IncorrectPenultimateNumberException{
        int currentDay =LocalDate.now().getDayOfMonth();
        char penultimateNumber=searchPenultimateNumber(IDNumber);
        Person foundPersonID=findPersonID(IDNumber);
        String message="La persona fue ingresada exitosamente al mini mercado.";
        
        if(idType.equalsIgnoreCase("TI")){
            count++;
            totalAmounOfPeople(count);
            throw new IncorrectIDException(idType);
        }
        else if(currentDay%2==0 &&  penultimateNumber%2!=0 || currentDay%2!=0 &&  penultimateNumber%2==0){
            count++;
            totalAmounOfPeople(count);
            throw new IncorrectPenultimateNumberException(penultimateNumber);
        }
        
        if(foundPersonID==null){
            if(currentDay%2==0 && penultimateNumber%2==0){
                people.add(new Person(IDNumber,idType));
                count++;
                totalAmounOfPeople(count);
            }
            else if(currentDay%2!=0 && penultimateNumber%2!=0){
                people.add(new Person(IDNumber,idType));
                count++;
                totalAmounOfPeople(count);
            }
        }
        else{
            message="Lo siento, la persona que intenta ingresar ya existe en el mini mercado";
        }
        return message;
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
