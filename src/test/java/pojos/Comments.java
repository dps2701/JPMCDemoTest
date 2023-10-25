package pojos;

public class Comments {

	private int id ;
    private int postId;

    private String name;

    private String email;

    private String body;

    public void setId(int id){
        this.id = id;
    }   
    public int getId(){
        return this.id;
    }   
    public void setPostId(int postId){
        this.postId = postId;
    }
    public int getPostId(){
        return this.postId;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setBody(String body){
        this.body = body;
    }
    public String getBody(){
        return this.body;
    }
}
