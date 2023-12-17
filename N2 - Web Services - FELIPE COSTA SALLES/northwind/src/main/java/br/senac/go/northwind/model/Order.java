package br.senac.go.northwind.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String customer_id;

    private int employee_id;

    private LocalDate order_date;

    private LocalDate required_date;

    private LocalDate shipped_date;

    private int ship_via;

    private int freight;

    private String ship_name;

    private String ship_address;

    private String ship_city;

    private String ship_region;

    private String ship_postal_code;

    private String ship_country;

    //Relacionamento muitos para um

    @ManyToOne (fetch = FetchType.LAZY)
    private Employee employee;

}