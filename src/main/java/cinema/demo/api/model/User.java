package cinema.demo.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    private String password;

    public User(){}

    public User(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
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

    public String getPassword(){
        return password;
    }

}
