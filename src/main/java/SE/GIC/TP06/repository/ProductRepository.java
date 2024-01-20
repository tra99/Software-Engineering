package SE.GIC.TP06.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SE.GIC.TP06.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{
    
}
