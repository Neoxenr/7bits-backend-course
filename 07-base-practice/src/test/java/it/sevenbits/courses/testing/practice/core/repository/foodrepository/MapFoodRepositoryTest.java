package it.sevenbits.courses.testing.practice.core.repository.foodrepository;

import it.sevenbits.courses.testing.practice.core.model.Food;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.*;

import static org.mockito.Mockito.*;

public class MapFoodRepositoryTest {
    private IFoodRepository foodRepository;

    private Map<Long, Food> mockFoodMap;

    @Before
    public void setUp() {
        mockFoodMap = mock(Map.class);
        foodRepository = new MapFoodRepository(mockFoodMap);
    }

    @Test
    public void getAllFoodTest() {
        List<Food> foodList = new ArrayList<>();

        foodList.add(new Food(1, "apple", 100));
        foodList.add(new Food(2, "orange", 200));

        when(foodRepository.getAllFood()).thenReturn(foodList);

        List<Food> resultFoodsList = foodRepository.getAllFood();

        verify(mockFoodMap, times(1)).values();

        Assert.assertEquals(resultFoodsList, new ArrayList<>(foodList));
    }

    @Test
    public void getFoodByIdTest() {
        final long foodId = 1;

        final Food defaultFood = new Food(-1, "Unavailable dish", 0);

        Food mockFood = mock(Food.class);

        when(mockFoodMap.getOrDefault(foodId, defaultFood)).thenReturn(mockFood);

        Food resultFood = foodRepository.getFoodById(foodId);

        verify(mockFoodMap, times(1)).getOrDefault(foodId, defaultFood);

        Assert.assertEquals(resultFood, mockFood);
    }

    @Test
    public void getFoodByIdDefaultTest() {
        final long foodUnknownId = 5;

        final Food defaultFood = new Food(-1, "Unavailable dish", 0);

        when(mockFoodMap.getOrDefault(foodUnknownId, defaultFood)).thenReturn(defaultFood);

        Food resultDefaultFood = foodRepository.getFoodById(foodUnknownId);

        verify(mockFoodMap, times(1)).getOrDefault(foodUnknownId, defaultFood);

        Assert.assertEquals(resultDefaultFood, defaultFood);
    }

    @Test
    public void addNewFoodTest() {
        final long mockFoodId = 1;

        Food mockFood = mock(Food.class);

        when(mockFood.getFoodId()).thenReturn(mockFoodId);
        when(mockFoodMap.put(mockFoodId, mockFood)).thenReturn(mockFood);
        when(mockFoodMap.get(mockFoodId)).thenReturn(mockFood);

        Food resultFood = foodRepository.addNewFood(mockFood);

        verify(mockFood, times(2)).getFoodId();
        verify(mockFoodMap, times(1)).put(mockFoodId, mockFood);
        verify(mockFoodMap, times(1)).get(mockFoodId);

        Assert.assertEquals(resultFood, mockFood);
    }
}
