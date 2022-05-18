package it.sevenbits.courses.testing.practice.web.service.order;

import it.sevenbits.courses.testing.practice.core.model.Food;
import it.sevenbits.courses.testing.practice.core.model.Order;
import it.sevenbits.courses.testing.practice.core.repository.orderrepository.IOrderRepository;
import it.sevenbits.courses.testing.practice.core.repository.orderrepository.MapOrderRepository;
import it.sevenbits.courses.testing.practice.web.model.OrderRequestBody;
import it.sevenbits.courses.testing.practice.web.service.food.FoodService;
import it.sevenbits.courses.testing.practice.web.service.food.IFoodService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Or;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class OrderServiceTest {
    private IOrderService orderService;

    private IFoodService mockFoodService;
    private IOrderRepository mockOrderRepository;

    @Before
    public void setUp() {
        mockFoodService = mock(FoodService.class);
        mockOrderRepository = mock(MapOrderRepository.class);

        orderService = new OrderService(mockOrderRepository, mockFoodService);
    }

    @Test
    public void getAllOrdersTest() {
        List<Order> mockOrderList = mock(List.class);

        when(mockOrderRepository.getAllOrders()).thenReturn(mockOrderList);

        List<Order> resultOrderList = orderService.getAllOrders();

        verify(mockOrderRepository, times(1)).getAllOrders();

        Assert.assertEquals(mockOrderList, resultOrderList);
    }

    @Test
    public void getOrderByIdTest() {
        final long orderId = 1;

        Order mockOrder = mock(Order.class);

        when(mockOrderRepository.getOrderById(orderId)).thenReturn(mockOrder);

        Order resultOrder = orderService.getOrderById(orderId);

        verify(mockOrderRepository, times(1)).getOrderById(orderId);

        Assert.assertEquals(mockOrder, resultOrder);
    }

    @Test
    public void createNewOrderTest() {
        OrderRequestBody mockOrderRequestBody = mock(OrderRequestBody.class);
        
        List<Long> foodIdList = new ArrayList<>();

        foodIdList.add(1L);
        foodIdList.add(2L);

        List<Food> foodList = new ArrayList<>();

        foodList.add(mock(Food.class));
        foodList.add(mock(Food.class));

        final long orderId = 0;
        final long price = 250;

        Order order = new Order(orderId, foodList, price);
        
        when(mockOrderRequestBody.getFoodIdList()).thenReturn(foodIdList);

        when(mockFoodService.getFoodById(foodIdList.get(0))).thenReturn(foodList.get(0));
        when(foodList.get(0).getPrice()).thenReturn(200L);

        when(mockFoodService.getFoodById(foodIdList.get(1))).thenReturn(foodList.get(1));
        when(foodList.get(1).getPrice()).thenReturn(50L);

        when(mockOrderRepository.addOrder(order)).thenReturn(order);

        Order resultOrder = orderService.createNewOrder(mockOrderRequestBody);

        verify(mockOrderRequestBody, times(1)).getFoodIdList();

        verify(mockFoodService, times(1)).getFoodById(foodIdList.get(0));
        verify(foodList.get(0), times(1)).getPrice();

        verify(mockFoodService, times(1)).getFoodById(foodIdList.get(1));
        verify(foodList.get(1), times(1)).getPrice();

        Assert.assertEquals(order, resultOrder);
    }
}
