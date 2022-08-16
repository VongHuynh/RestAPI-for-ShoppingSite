package com.gearshop.ShoppingProject.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Authorities", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"Userid", "Roleid"})
})
public class Authority implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Userid")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "Roleid")
    private Role role;
}
