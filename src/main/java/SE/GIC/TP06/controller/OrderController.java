package SE.GIC.TP06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import SE.GIC.TP06.entity.MyOrder;
import SE.GIC.TP06.service.OrderService;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired 
    private OrderService orderService;

    @GetMapping("/list")
    public List<MyOrder> listOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public MyOrder getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

    @PostMapping("/add")
    public MyOrder addOrder(@RequestBody MyOrder order) {
       order.setOrderDate(LocalDateTime.now());
        return orderService.saveOrder(order);
    }

    @PutMapping("/update/{id}")
    public MyOrder updateOrder(@PathVariable Long id, @RequestBody MyOrder order) {
        order.setOrderDate(LocalDateTime.now());
        order.setId(id);
        return orderService.saveOrder(order);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    @GetMapping("/search/{orderNumber}")
    public ResponseEntity<MyOrder> searchOrderByOrderNumber(@PathVariable String orderNumber) {
        try {
            Optional<MyOrder> order = orderService.getOrderByOrderNumber(orderNumber);
            
            if (order.isPresent()) {
                return ResponseEntity.ok(order.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
