package it.sevenbits.courses.testing.practice.core.repository.orderrepository;

import it.sevenbits.courses.testing.practice.core.model.Food;
import it.sevenbits.courses.testing.practice.core.model.Order;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class MapOrderRepositoryTest {
    private IOrderRepository orderRepository;

    private Map<Long, Order> mockOrderMap;

    @Before
    public void setUp() {
        mockOrderMap = mock(Map.class);
        orderRepository = new MapOrderRepository(mockOrderMap);
    }

    @Test
    public void getAllOrdersTest() {
        List<Order> orderList = new ArrayList<>();

        orderList.add(new Order(1, new ArrayList<>(), 200));
        orderList.add(new Order(2, new ArrayList<>(), 200));

        when(orderRepository.getAllOrders()).thenReturn(orderList);

        List<Order> resultOrdersList = orderRepository.getAllOrders();

        verify(mockOrderMap, times(1)).values();

        Assert.assertEquals(resultOrdersList, orderList);
    }

    @Test
    public void getOrderByIdTest() {
        final long orderId = 1;

        final Order defaultOrder = new Order(-1, new ArrayList<>(), 0);

        Order mockOrder = mock(Order.class);

        when(mockOrderMap.getOrDefault(orderId, defaultOrder)).thenReturn(mockOrder);

        Order resultOrder = orderRepository.getOrderById(orderId);

        verify(mockOrderMap, times(1)).getOrDefault(orderId, defaultOrder);

        Assert.assertEquals(mockOrder, resultOrder);
    }

    @Test
    public void getOrderByIdDefaultTest() {
        final long orderUnknownId = 3;

        final Order defaultOrder = new Order(-1, new ArrayList<>(), 0);

        when(mockOrderMap.getOrDefault(orderUnknownId, defaultOrder)).thenReturn(defaultOrder);

        Order resultDefaultOrder = orderRepository.getOrderById(orderUnknownId);

        verify(mockOrderMap, times(1)).getOrDefault(orderUnknownId, defaultOrder);

        Assert.assertEquals(defaultOrder,resultDefaultOrder);
    }

    @Test
    public void addOrderTest() {
        final long mockOrderId = 1;

        Order mockOrder = mock(Order.class);

        when(mockOrder.getOrderId()).thenReturn(mockOrderId);
        when(mockOrderMap.put(mockOrderId, mockOrder)).thenReturn(mockOrder);
        when(mockOrderMap.get(mockOrderId)).thenReturn(mockOrder);

        Order resultOrder = orderRepository.addOrder(mockOrder);

        verify(mockOrder, times(2)).getOrderId();
        verify(mockOrderMap, times(1)).put(mockOrderId, mockOrder);
        verify(mockOrderMap, times(1)).get(mockOrderId);

        Assert.assertEquals(resultOrder, mockOrder);
    }
}
