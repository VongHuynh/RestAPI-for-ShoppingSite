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
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Double price;
    @Temporal(TemporalType.DATE)
    @Column(name = "createdate")
    private Date createDate = new Date();
    @Column
    private Boolean available;
    //category
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;
    //OrderDetails
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderdetail;
}

