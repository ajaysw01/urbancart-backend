package com.ajaysw.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @NotBlank
    @Size(max=20)
    @Column(name = "username")
    private String username;

    @NotBlank
    @Size(max=50)
    @Email
    @Column(name = "email")
    private String email;

    @NotBlank
    @Size(max=120)
    @Column(name = "password")
    private String password;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.EAGER,
    cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> roles = new HashSet<>();


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "user_address",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "address_d")
    )
    @Getter
    @Setter
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(
            mappedBy = "user",
            cascade = {CascadeType.PERSIST,CascadeType.MERGE},
            orphanRemoval = true)
    @ToString.Exclude
    private Set<Product> products;

}
