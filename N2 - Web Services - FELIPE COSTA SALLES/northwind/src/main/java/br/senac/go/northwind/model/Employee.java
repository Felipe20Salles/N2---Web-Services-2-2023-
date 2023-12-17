package br.senac.go.northwind.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String last_name;

    private String first_name;

    private String title;

    private String title_of_courtesy;

    private LocalDate birth_date;

    private LocalDate hire_date;

    private String adress;

    private String city;

    private String region;

    private String postal_code;

    private String country;

    private String home_phone;

    private String extension;

    private byte[] photo;

    private String notes;

    private int reports_to;


    //relacionamento "um pra muitos"
    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<Order> orders = new ArrayList<>();

    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<Employee> employees = new ArrayList<>();

}