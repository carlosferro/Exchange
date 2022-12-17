package com.ferro.exchange;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ferro.exchange.model.orderbook.Order;
import com.ferro.exchange.model.orderbook.OrderSide;
import com.ferro.exchange.repository.OrderCRUDRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OrderTest {

    @Autowired
    private OrderCRUDRepository orderCRUDRepository;

    @Test
    public void givenCreateOrderWhenLoadTheOrderThenExpectSameOrder() {
        Order order = new Order(1L, 2L, OrderSide.ASK);
        Order savedOrder = orderCRUDRepository.save(order);
        assertThat(orderCRUDRepository.findById(savedOrder.getId()).get()).isEqualTo(order);
    }
    
    @Test
    public void givenUpdateOrderWhenLoadTheOrderThenExpectUpdatedOrder() {
    	Order course = new Order(1L, 2L, OrderSide.ASK);
    	orderCRUDRepository.save(course);
        course.setPrice(5L);
        Order savedOrder = orderCRUDRepository.save(course);
        assertThat(orderCRUDRepository.findById(savedOrder.getId()).get().getPrice()).isEqualTo(5L);
    }
    
    @Test
    public void givenDeleteCourseWhenLoadTheCourseThenExpectNoCourse() {
    	Order course = new Order(1L, 2L, OrderSide.ASK);
    	Order savedCourse  = orderCRUDRepository.save(course);
        assertThat(orderCRUDRepository.findById(savedCourse.getId()).get()).isEqualTo(course);
        orderCRUDRepository.delete(course);
        assertThat(orderCRUDRepository.findById(savedCourse.getId()).isPresent()).isFalse();
    }
}