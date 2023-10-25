package pojos;

public class Users {

	private int id;
	
    private String name;

    private String username;

    private String email;

    private UserAddress address;

    private String phone;

    private String website;

    private UserCompany company;
    
    public void setId(int id){
        this.id = id;
    }   
    public int getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setAddress(UserAddress address){
        this.address = address;
    }
    public UserAddress getAddress(){
        return this.address;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return this.phone;
    }
    public void setWebsite(String website){
        this.website = website;
    }
    public String getWebsite(){
        return this.website;
    }
    public void setCompany(UserCompany company){
        this.company = company;
    }
    public UserCompany getCompany(){
        return this.company;
    }
}
