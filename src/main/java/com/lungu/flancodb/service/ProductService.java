package com.lungu.flancodb.service;

import com.lungu.flancodb.entity.Branch;
import com.lungu.flancodb.entity.Department;
import com.lungu.flancodb.entity.Product;
import com.lungu.flancodb.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository productRepository;
    public List<Product> getAllProducts() {
        List<Product> result = productRepository.findAllOrderByName();
        if(result.size() > 0) return result; else
            return new ArrayList<>();
    }
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProductById(String id)
            throws EntityNotFoundException {

        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException
                    ("No product record exists for this ID.");
        }
    }
}
