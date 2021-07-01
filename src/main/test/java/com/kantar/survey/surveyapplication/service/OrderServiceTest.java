package com.kantar.survey.surveyapplication.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.base.Verify;
import com.kantar.survey.surveyapplication.model.Order;
import com.kantar.survey.surveyapplication.repository.OrderRepository;

@RunWith(SpringRunner.class)
public class OrderServiceTest {

	@Mock
	private OrderRepository orderRepository;
	
	@InjectMocks
	private OrderService orderService;
	
	@Test
	public void whenBookOrderShouldReturnOrder() {
		Order order = new Order();
		order.setId(121);
		order.setAmount(1123);
		order.setItemName("tv");
	when(orderRepository.save(any(Order.class))).thenReturn(order);

	Order bookedOrder = orderService.bookOrder(order);
	assertEquals(order,bookedOrder);
	}
	
	@Test
	public void shouldDeleteOrder() {
		Order order = new Order();
		order.setId(234);
		order.setAmount(9999);
		order.setItemName("mobile");
		
		when(orderRepository.findById(order.getId())).thenReturn(Optional.of(order));
		orderService.deleteOrder(order.getId());
		System.out.println(order.getId());
	}
}
