package net.javaguides.springboot.springsecurity.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String product;
    private int price;
    private int inventory;
    private Timestamp createTime;
    private Timestamp updateTime;

}
