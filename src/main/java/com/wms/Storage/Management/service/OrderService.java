package com.wms.Storage.Management.service;

import java.util.List;

import com.wms.Storage.Management.dto.OrderDto;
import com.wms.Storage.Management.entity.Order;

public interface OrderService {


    List<Order> getAllOrders();

    Order getOrderById(Long id);

    Order updateOrder(Long id, OrderDto dto);

    void deleteOrder(Long id);

	Order createOrder(OrderDto dto);
}
