package com.wms.Storage.Management.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.Storage.Management.Repository.OrderRepository;
import com.wms.Storage.Management.dto.OrderDto;
import com.wms.Storage.Management.entity.Order;


@Service
public class OrderServiceImp implements OrderService{

	@Autowired
    private OrderRepository repository;

    @Override
    public Order createOrder(OrderDto dto) {

        Order order = new Order();
        order.setProductName(dto.getProductName());
        order.setQuantity(dto.getQuantity());
        order.setPrice(dto.getPrice());
        order.setStatus(dto.getStatus());
        order.setOrderDate(LocalDate.now());

        return repository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public Order updateOrder(Long id, OrderDto dto) {

        Order order = getOrderById(id);

        order.setProductName(dto.getProductName());
        order.setQuantity(dto.getQuantity());
        order.setPrice(dto.getPrice());
        order.setStatus(dto.getStatus());

        return repository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }
}
