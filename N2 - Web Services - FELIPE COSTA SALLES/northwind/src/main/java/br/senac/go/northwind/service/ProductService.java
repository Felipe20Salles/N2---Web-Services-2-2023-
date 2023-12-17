package br.senac.go.northwind.service;

import br.senac.go.northwind.model.Product;
import br.senac.go.northwind.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    public Product updateProduct(Integer id, Product updatedProduct) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            // Atualize os campos conforme necessário
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setQuantity_per_unit(updatedProduct.getQuantity_per_unit());
            existingProduct.setUnit_price(updatedProduct.getUnit_price());
            existingProduct.setUnits_in_stock(updatedProduct.getUnits_in_stock());
            existingProduct.setUnits_on_order(updatedProduct.getUnits_on_order());
            existingProduct.setReorder_level(updatedProduct.getReorder_level());
            existingProduct.setDiscontinued(updatedProduct.isDiscontinued());
            existingProduct.setCategory(updatedProduct.getCategory());
            existingProduct.setSupplier(updatedProduct.getSupplier());

            return productRepository.save(existingProduct);
        } else {
            // Lidar com o produto não encontrado
            return null;
        }
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
