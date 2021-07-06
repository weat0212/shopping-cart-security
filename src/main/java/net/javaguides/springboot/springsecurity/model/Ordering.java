package net.javaguides.springboot.springsecurity.model;


import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "purchase_record")
public class Ordering {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long user_id;

    @Column(name = "symbol_id")
    private Long product_id;

    private int trading_price;
    private boolean status;
    private Timestamp createTime;
    private Timestamp updateTime;
}
