package com.kantar.survey.surveyapplication.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.kantar.survey.surveyapplication.model.Order;
import com.kantar.survey.surveyapplication.repository.OrderRepository;
import com.kantar.survey.surveyapplication.service.OrderService;

@RunWith(SpringRunner.class)
public class OrderControllerTest {
	
	@Mock
	private OrderRepository OrderRepository;

	@Mock
	private OrderService orderService;
	
	@InjectMocks
	private OrderController orderController;
	
	@Test
	public void shouldReturnOrderList() {
		
		List<Order> orderList = new ArrayList<Order>();
		Order order = new Order();
		order.setId(111);
		order.setAmount(999);
		order.setItemName("mobile");
		
		Order order1 = new Order();
		order1.setId(1);
		order1.setAmount(2345);
		order1.setItemName("fridge");
		
		Order order2 = new Order();
		order2.setId(11);
		order2.setAmount(1234);
		order2.setItemName("tv");
		
		orderList.add(order);
		orderList.add(order1);
		orderList.add(order2);
		
		Mockito.when(orderService.getOrders()).thenReturn(orderList);
		List<Order> expectedOrderList = orderController.getOrders();
		
		assertEquals(expectedOrderList.size(), 3);
	}
	
	@Test
	public void shouldReturnOrder() {
		
		Order order = new Order();
		order.setId(111);
		order.setAmount(999);
		order.setItemName("mobile");
		
		
		Mockito.when(orderService.getOrder(ArgumentMatchers.anyInt())).thenReturn(order);
		Order expectedOrder = orderController.getOrder(111);
		
		assertEquals(expectedOrder.getItemName(), order.getItemName());
	}
}
