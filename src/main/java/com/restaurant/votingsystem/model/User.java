package com.restaurant.votingsystem.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "unique_email")})
public class User {

    @Id
    private Integer id;

    @Column
    @NotBlank
    private String name;

    @Column
    @Email
    @NotBlank
    private String email;

    @Column
    private Integer restaurantVotedId;

    //check n+1 problem
    @CollectionTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "role")
    private Set<Role> roles;

    public User() {
    }

    public User(int id, String name, String email, Integer restaurantVotedId, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.restaurantVotedId = restaurantVotedId;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
