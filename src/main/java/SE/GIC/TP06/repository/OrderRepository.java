package SE.GIC.TP06.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import SE.GIC.TP06.entity.MyOrder;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<MyOrder, Long> {
    Optional<MyOrder> findByOrderNumber(String orderNumber);
}
