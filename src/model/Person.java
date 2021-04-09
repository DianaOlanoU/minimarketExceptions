
package model;

public class Person {
    
  public IDType ID;
  private String IDNumber;

    public Person(String IDNumber, String idType) {
        this.IDNumber = IDNumber;
        
        if(idType.equalsIgnoreCase("CC")){
        ID=IDType.CC;
        }
        
        else if(idType.equalsIgnoreCase("TI")){
        ID=IDType.TI;
        }
        
        else if(idType.equalsIgnoreCase("PP")){
        ID=IDType.PP;
        }
        
        else{
        ID=IDType.CE;
        }
    }

    public String getIDNumber() {
        return IDNumber;
    }
}
