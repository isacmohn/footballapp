package com.isak.footballapp.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import com.isak.footballapp.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@Table(name = "users")
public class User {
    //Primary key i databasen
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Datafields tilsvarer egenskaper for brukere
    private String userName;
    
    @JsonIgnore
    private String password;
    private LocalDate dateOfBirth;
    private String email;
    private Long mobileNr;

    @Enumerated(EnumType.STRING)
    private Role role;
     

    //Konstruktører
    public User(){}  //tom konstruktør 

    public User(String userName, String password, LocalDate dateOfBirth, String email, Role role, Long mobileNr){
        this.userName = userName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.role = role;
        this.mobileNr = mobileNr;
    }   

    //gettere(+return, +samme datatype ) og settere(+void, +innargs)
    public Long getId() {return id;} public void setId(Long id) {this.id = id;}
    public String getUserName(){return userName;} public void setUserName(String userName){this.userName=userName;}
    public String getPassword(){return password;} public void setPassword(String password){this.password = password;}
    public LocalDate getDateOfBirth(){return dateOfBirth;} public void setDateOfBirth(LocalDate dateOfBirth){this.dateOfBirth = dateOfBirth;}
    public String getEmail(){return email;} public void setEmail(String email){this.email = email;}
    public Long getMobileNr(){return mobileNr;} public void setMobileNr(Long mobileNr){this.mobileNr = mobileNr;}
    public Role getRole(){return role;} public void setRole(Role role){ this.role = role;}

}
