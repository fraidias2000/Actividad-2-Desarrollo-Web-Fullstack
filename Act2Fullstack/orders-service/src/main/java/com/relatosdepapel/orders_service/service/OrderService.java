package com.relatosdepapel.orders_service.service;

import com.relatosdepapel.orders_service.model.Order;
import com.relatosdepapel.orders_service.model.OrderItem;
import com.relatosdepapel.orders_service.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order findById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada con id: " + id));
    }

    public List<Order> findRecentOrdersByUserId(String userId) {
        return orderRepository.findTop10ByUserIdOrderByCreatedAtDesc(userId);
    }

    @Transactional
    public Order create(Order order) {
        BigDecimal totalAmount = BigDecimal.ZERO;

        for (OrderItem item : order.getItems()) {
            item.setOrder(order);

            BigDecimal subtotal = item.getUnitPrice()
                    .multiply(BigDecimal.valueOf(item.getQuantity()));

            item.setSubtotal(subtotal);
            totalAmount = totalAmount.add(subtotal);
        }

        order.setTotalAmount(totalAmount);
        order.setStatus("CONFIRMED");

        return orderRepository.save(order);
    }
}
