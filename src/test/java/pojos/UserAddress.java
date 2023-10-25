package pojos;


public class UserAddress {

    private String street;

    private String suite;

    private String city;

    private String zipcode;

    private UserGeo geo;

    public void setStreet(String street){
        this.street = street;
    }
    public String getStreet(){
        return this.street;
    }
    public void setSuite(String suite){
        this.suite = suite;
    }
    public String getSuite(){
        return this.suite;
    }
    public void setCity(String city){
        this.city = city;
    }
    public String getCity(){
        return this.city;
    }
    public void setZipcode(String zipcode){
        this.zipcode = zipcode;
    }
    public String getZipcode(){
        return this.zipcode;
    }
    public void setGeo(UserGeo geo){
        this.geo = geo;
    }
    public UserGeo getGeo(){
        return this.geo;
    }
}
