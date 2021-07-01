package com.kantar.survey.surveyapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kantar.survey.surveyapplication.model.Order;
import com.kantar.survey.surveyapplication.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/bookOrder")
	public Order bookOrder(@RequestBody Order order) {
		return orderService.bookOrder(order);
	}
	
	@GetMapping("/getOrders")
	public List<Order> getOrders() {
		return orderService.getOrders();
	}
	
	@GetMapping("/getOrder/{id}")
	public Order getOrder(@PathVariable Integer id) {
		return orderService.getOrder(id);
	}
	
	@DeleteMapping("/deleteOrder/{id}")
	public String deleteOrder(@PathVariable Integer id) {
		orderService.deleteOrder(id);
		return "Order deleted successfully: "+id;
	}
	
	@PostMapping("/updateOrder")
	public String  updateOrder(@RequestBody Order order) {
		orderService.updateOrder(order);
		return "Order upddated successfully: "+order;	
	}
}
