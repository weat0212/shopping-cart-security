package net.javaguides.springboot.springsecurity.web.dto;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class OrderingDto {

    private Long id;
    private Long user_id;
    private Long product_id;

    @Size(min = 0, max = 10, message = "不可超過10單位")
    private Long purchasedNum;
    private int trading_price;
    private boolean status;
}
