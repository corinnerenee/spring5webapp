package guru.springframework.spring5webapp.domain;

import javax.persistence.*;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String addressLine1;
    private String city;
    private String state;
    private String zipcode;

    public Publisher(){
    }

    public Publisher(String name, String addressLine1, String city, String state, String zipcode){
        this.name = name;
        this.addressLine1 = addressLine1;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAddressLine(String addresLine1){
        this.addressLine1 = addresLine1;
    }

    public String getAddressLine(){
        return addressLine1;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getCity(){
        return city;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }

    public void setZip(String zipcode){
        this.zipcode = zipcode;
    }

    public String getZip(){
        return zipcode;
    }

    //override equals, hashcode, and toString
    @Override
    public String toString(){
        return "Publisher {" + 
        "id=" + id +
        ", Name'" + name + '\'' + 
        ", Address'" + addressLine1 +
        "City " + city +
        "State" + state +
        "Zipcode" + zipcode +
        '}';
    }

    @Override
    public boolean equals(Object o){
        if(this == o)return false;
        if (o == null || getClass() != o.getClass()) return false;
        
        Publisher publisher = (Publisher) o;

        return id != null ? id.equals(publisher.id) : publisher.id == null;
    }

    @Override
    public int hashCode(){
        return id != null ? id.hashCode() : 0;
    }
}

 


    

