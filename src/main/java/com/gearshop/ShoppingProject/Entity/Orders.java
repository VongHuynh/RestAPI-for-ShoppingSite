package com.gearshop.ShoppingProject.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
@SuppressWarnings("serial")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Orders implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String address;
    @Column
    private Integer status;
//    @Temporal(TemporalType.DATE)
//    @Column(name = "createDate")
//    private Date createDate = new Date();
    @ManyToOne
    @JoinColumn(name = "accountid")
    private Account account;
    //
    @JsonIgnore
    @OneToMany(mappedBy = "orders")
    List<OrderDetail> orderdetail;

}

