package com.testyfood.omf.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Orders")//order is a predefined keyword in sql, so it can't be used
public class Order {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID orderId;

    private int quantity;
    private double totalPrice;
    private String status;

//    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
//    @JoinColumn(name = "order_id")
    @OneToMany(targetEntity = OrderedItem.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId",referencedColumnName = "orderId")
    private List<OrderedItem> items;
}
