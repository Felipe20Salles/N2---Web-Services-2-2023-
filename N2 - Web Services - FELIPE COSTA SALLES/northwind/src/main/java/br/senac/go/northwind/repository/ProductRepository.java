package br.senac.go.northwind.repository;

import br.senac.go.northwind.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}
