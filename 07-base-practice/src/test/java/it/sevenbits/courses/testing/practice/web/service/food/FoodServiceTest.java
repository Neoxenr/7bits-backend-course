package it.sevenbits.courses.testing.practice.web.service.food;

import it.sevenbits.courses.testing.practice.core.model.Food;
import it.sevenbits.courses.testing.practice.core.repository.foodrepository.IFoodRepository;
import it.sevenbits.courses.testing.practice.core.repository.foodrepository.MapFoodRepository;
import it.sevenbits.courses.testing.practice.web.model.FoodRequestBody;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class FoodServiceTest {
    private IFoodService foodService;

    private IFoodRepository mockFoodRepository;

    @Before
    public void setUp() {
        mockFoodRepository = mock(MapFoodRepository.class);
        foodService = new FoodService(mockFoodRepository);
    }

    @Test
    public void getAllFoodTest() {
        List<Food> mockFoodList = mock(List.class);

        when(mockFoodRepository.getAllFood()).thenReturn(mockFoodList);

        List<Food> resultFoodList = foodService.getAllFood();

        verify(mockFoodRepository, times(1)).getAllFood();

        Assert.assertEquals(mockFoodList, resultFoodList);
    }

    @Test
    public void getFoodByIdTest() {
        final long foodId = 1;
        Food mockFood = mock(Food.class);

        when(mockFoodRepository.getFoodById(foodId)).thenReturn(mockFood);

        Food resultFood = foodService.getFoodById(foodId);

        verify(mockFoodRepository, times(1)).getFoodById(foodId);

        Assert.assertEquals(mockFood, resultFood);
    }

    @Test
    public void createNewFoodTest() {
        FoodRequestBody mockFoodRequestBody = mock(FoodRequestBody.class);

        final long foodId = 0;
        final String foodName = "pizza";
        final long foodPrice = 200;

        Food food = new Food(foodId, foodName, foodPrice);

        when(mockFoodRequestBody.getName()).thenReturn(foodName);
        when(mockFoodRequestBody.getPrice()).thenReturn(foodPrice);
        when(mockFoodRepository.addNewFood(food)).thenReturn(food);

        Food resultFood = foodService.createNewFood(mockFoodRequestBody);

        verify(mockFoodRequestBody, times(1)).getName();
        verify(mockFoodRequestBody, times(1)).getPrice();
        verify(mockFoodRepository, times(1)).addNewFood(food);

        Assert.assertEquals(food, resultFood);
    }
}
