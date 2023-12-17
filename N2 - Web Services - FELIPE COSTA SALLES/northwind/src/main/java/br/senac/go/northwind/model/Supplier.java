package br.senac.go.northwind.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy =
            GenerationType.AUTO)
    //@Column(name = "supplier_id")
    private Integer id;

    @NotNull
    @NotBlank
    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "contact_title")
    private String contactTitle;

    private String address;

    private String city;

    private String region;

    @Column(name = "postal_code")
    private String postalCode;

    private String country;

    private String phone;

    private String fax;

    @Column(name = "homepage")
    private String homePage;

    @OneToMany(
            mappedBy = "suppliers",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Product> product = new ArrayList<>();

}