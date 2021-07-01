package com.kantar.survey.surveyapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kantar.survey.surveyapplication.model.Order;
import com.kantar.survey.surveyapplication.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	public Order bookOrder(Order order) {
		return orderRepository.save(order);
	}

	public Order getOrder(Integer id) {
		return orderRepository.getById(id);
	}

	public void deleteOrder(Integer id) {
		orderRepository.deleteById(id);
		
	}

	public Order updateOrder(Order order) {
		return orderRepository.save(order);
	}
	
	public List<Order> getOrders(){
		return orderRepository.findAll();
	}
}
