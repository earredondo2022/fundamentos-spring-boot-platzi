package com.fundamentosplatzi.springboot.fundamentos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", length = 50, nullable = true)
    private String name;

    @Column(name = "email", length =50, unique = true)
    private String email;

    @Column
    private LocalDate birthDate;

    // Un user puede tener muchos post
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference  /// Esta anotación es para poder acceder al servicio y no nos de error (start overflow)
    @JsonIgnore            /// Para los que tengan el error “Unsupported Media Type” se agrega @JsonIgnore
    private List<Post> posts = new ArrayList<>();

    /// Paso 1: crear contructor VACIO.
    public User() {
    }

    /// Paso 2: crear contructor con todos los parametros excepto el ID.
    public User(String name, String email, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    /// Delete
    public User(Long id) {
        this.id = id;
    }

    /// Paso 3: crear Getter y Setter
    public Long getId_user() {
        return id;
    }

    public void setId_user(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    /// Paso 4: crear METODO toString con todos los parametros.
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", posts=" + posts +
                '}';
    }
}
