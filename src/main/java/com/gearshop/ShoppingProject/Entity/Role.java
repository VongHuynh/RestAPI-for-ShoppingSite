package com.gearshop.ShoppingProject.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "roles")
public class Role implements Serializable {
    @Id
    @Column(length=10)
    private String id;
    private String name;
    //
    @JsonIgnore
    @OneToMany(mappedBy = "role")
    List<Authority> authorities;
}
