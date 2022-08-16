package com.gearshop.ShoppingProject.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username")
    private String userName;
    @Column
    private String password;
    @Column(name = "fullname")
    private String fullName;
    @Column
    private String email;
    @Column
    private String photo;
    @Column
    private String address;
    @Column
    private Boolean activated;
    //
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<Orders> order;
    //
    @JsonIgnore
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    List<Authority> authorities;
}
