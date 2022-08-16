package com.gearshop.ShoppingProject.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orderdetail")
public class OrderDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Double price;
    @Column
    private Integer quantity;
    //
    @ManyToOne
    @JoinColumn(name = "Product")//Productid
    private Product product;
    //
    @ManyToOne
    @JoinColumn(name = "Orders")//Odersid
    private Orders orders;
}
