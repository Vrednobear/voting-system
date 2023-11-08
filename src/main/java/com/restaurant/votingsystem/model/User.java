package com.restaurant.votingsystem.model;


import org.hibernate.validator.constraints.Length;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "unique_email")})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "password")
    @Length(min = 5)
    @NotBlank
    private String password;

    @Column(name = "email")
    @Email
    @NotBlank
    private String email;

    @Column(name = "restaurant_voted_id")
    private Integer restaurantVotedId;

    @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "role")
    private Set<Role> roles;

    public User() {
    }

    public User(Integer id, String name, String password, String email, Integer restaurantVotedId, Collection<Role> roles) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.restaurantVotedId = restaurantVotedId;
        setRoles(roles);
    }

    public User(Integer id, String name, String password, String email, Integer restaurantVotedId, Role...roles) {
       this(id, name, password, email, restaurantVotedId, Arrays.asList(roles));
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = CollectionUtils.isEmpty(roles) ? EnumSet.noneOf(Role.class) : EnumSet.copyOf(roles);
    }

    public  boolean isNew(){
        return id == null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRestaurantVotedId() {
        return restaurantVotedId;
    }

    public void setRestaurantVotedId(Integer restaurantVotedId) {
        this.restaurantVotedId = restaurantVotedId;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
