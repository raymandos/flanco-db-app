package com.lungu.flancodb.service;

import com.lungu.flancodb.entity.Department;
import com.lungu.flancodb.entity.Employee;
import com.lungu.flancodb.entity.Sales;
import com.lungu.flancodb.models.EmployeeModel;
import com.lungu.flancodb.models.SalesModel;
import com.lungu.flancodb.repository.BranchRepository;
import com.lungu.flancodb.repository.ProductRepository;
import com.lungu.flancodb.repository.SalesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SalesService {

    final SalesRepository salesRepository;
    final BranchRepository branchRepository;
    final ProductRepository productRepository;

    public List<SalesModel> getAllSalesModels() {
        List<Sales> sales = salesRepository.findAll();
        List<SalesModel> salesModels = new ArrayList<>();
        for (Sales sale : sales) {
            salesModels.add(new SalesModel(
                    sale.getId(),
                    sale.getStock(),
                    sale.getSold(),
                    productRepository.findProductById(sale.getProduct_id()).get().getName(),
                    branchRepository.findById(sale.getBranch_id()).get().getName()
            ));
        }
        return salesModels;
    }

    public void saveSales(Sales sales) {
        salesRepository.save(sales);
    }

    public void deleteSalesById(String id)
            throws EntityNotFoundException {

        Optional<Sales> sales = salesRepository.findById(id);
        if (sales.isPresent()) {
            salesRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException
                    ("No sales record exists for this ID.");
        }
    }
}
