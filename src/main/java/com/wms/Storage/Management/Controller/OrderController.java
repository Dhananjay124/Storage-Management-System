package com.wms.Storage.Management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wms.Storage.Management.dto.OrderDto;
import com.wms.Storage.Management.entity.Order;
import com.wms.Storage.Management.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	  @Autowired
	    private OrderService service;

	    @PostMapping("/add")
	    public Order createOrder(@Valid @RequestBody OrderDto dto) {
	        return service.createOrder(dto);
	    }

	    @GetMapping
	    public List<Order> getAllOrders() {
	        return service.getAllOrders();
	    }

	    @GetMapping("/{id}")
	    public Order getOrder(@PathVariable Long id) {
	        return service.getOrderById(id);
	    }

	    @PutMapping("/{id}")
	    public Order updateOrder(@PathVariable Long id,
	                             @RequestBody OrderDto dto) {

	        return service.updateOrder(id, dto);
	    }

	    @DeleteMapping("/{id}")
	    public String deleteOrder(@PathVariable Long id) {

	        service.deleteOrder(id);
	        return "Order deleted successfully";
	    }

	
}
