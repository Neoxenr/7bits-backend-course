package it.sevenbits.courses.testing.practice.web.controller;

import it.sevenbits.courses.testing.practice.core.model.Order;
import it.sevenbits.courses.testing.practice.web.model.OrderRequestBody;
import it.sevenbits.courses.testing.practice.web.service.order.IOrderService;
import it.sevenbits.courses.testing.practice.web.service.order.OrderService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.*;

public class OrderControllerTest {
    private OrderController orderController;

    private IOrderService mockOrderService;

    @Before
    public void setUp() {
        mockOrderService = mock(OrderService.class);
        orderController = new OrderController(mockOrderService);
    }

    @Test
    public void getAllOrdersTest() {
        List<Order> mockOrderList = mock(List.class);

        when(mockOrderService.getAllOrders()).thenReturn(mockOrderList);

        ResponseEntity<List<Order>> response = orderController.getAllOrders();

        verify(mockOrderService, times(1)).getAllOrders();

        Assert.assertEquals(mockOrderList, response.getBody());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getAllOrdersExceptionTest() {
        when(mockOrderService.getAllOrders()).thenThrow(new RuntimeException());

        ResponseEntity<List<Order>> response = orderController.getAllOrders();

        verify(mockOrderService, times(1)).getAllOrders();

        Assert.assertNull(response.getBody());
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    public void getOrderByIdTest() {
        final long orderId = 1;

        Order mockOrder = mock(Order.class);

        when(mockOrderService.getOrderById(orderId)).thenReturn(mockOrder);

        ResponseEntity<Order> response = orderController.getOrderById(orderId);

        verify(mockOrderService, times(1)).getOrderById(1);

        Assert.assertEquals(mockOrder, response.getBody());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getOrderByIdExceptionTest() {
        final long orderId = 1;

        when(mockOrderService.getOrderById(orderId)).thenThrow(new RuntimeException());

        ResponseEntity<Order> response = orderController.getOrderById(orderId);

        verify(mockOrderService, times(1)).getOrderById(1);

        Assert.assertNull(response.getBody());
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    public void getNewOrderTest() {
        OrderRequestBody mockRequestBody = mock(OrderRequestBody.class);

        Order mockOrder = mock(Order.class);

        when(mockOrderService.createNewOrder(mockRequestBody)).thenReturn(mockOrder);

        ResponseEntity<Order> response = orderController.getNewOrder(mockRequestBody);

        verify(mockOrderService, times(1)).createNewOrder(mockRequestBody);

        Assert.assertEquals(mockOrder, response.getBody());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getNewOrderExceptionTest() {
        OrderRequestBody mockRequestBody = mock(OrderRequestBody.class);

        when(mockOrderService.createNewOrder(mockRequestBody)).thenThrow(new RuntimeException());

        ResponseEntity<Order> response = orderController.getNewOrder(mockRequestBody);

        verify(mockOrderService, times(1)).createNewOrder(mockRequestBody);

        Assert.assertNull(response.getBody());
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
}
