package cinema.demo.api.model;

public class User {
    private int id;
    private String name;
    private String email;

    public User(int id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId(){
        return id;
    }

    public int setId(int id){
        return this.id = id;
    }

    public String getName(){
        return name;
    }

    public String setName(String name){
        return this.name = name;
    }
    public String getEmail(){
        return email;
    }

    public String setEmail(String email){
        return this.email = email;
    }

}
