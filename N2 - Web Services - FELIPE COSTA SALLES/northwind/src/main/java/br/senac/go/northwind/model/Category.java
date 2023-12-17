package br.senac.go.northwind.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "category_id")
    private Integer id;

    @Column(name = "category_name", length = 15)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;
    private byte[] picture;

    @OneToMany(
            mappedBy = "category",//bi-direcional
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    //Quando você indicar o uso do mappedBy para relacionamento bi-direcional,
    //nao é necessário usar a anotação @JoinColumn. Se você usar a aplicação irá apresentar erro:
    //Association 'br.senac.go.northwind.model.Category.products' is 'mappedBy' another entity and may not
    //specify the '@JoinColumn'
    //@JoinColumn(name = "categories_id")
    //indica a chave estrageira dentro da tabela products
    private List<Product> products = new ArrayList<>();
}
