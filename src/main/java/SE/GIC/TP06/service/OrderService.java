package SE.GIC.TP06.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SE.GIC.TP06.entity.MyOrder;
import SE.GIC.TP06.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<MyOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<MyOrder> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public MyOrder saveOrder(MyOrder order) {
        // Additional logic or validation can be added here
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
    
    public Optional<MyOrder> getOrderByOrderNumber(String orderNumber) {
        System.out.println("Searching for order with order number: " + orderNumber);
        Optional<MyOrder> order = orderRepository.findByOrderNumber(orderNumber);
        
        if (order.isPresent()) {
            System.out.println("Order found: " + order.get());
        } else {
            System.out.println("Order not found");
        }
        
        return order;
    }  
}
