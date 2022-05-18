package it.sevenbits.courses.testing.practice.web.controller;

import it.sevenbits.courses.testing.practice.core.model.Food;
import it.sevenbits.courses.testing.practice.web.model.FoodRequestBody;
import it.sevenbits.courses.testing.practice.web.service.food.FoodService;
import it.sevenbits.courses.testing.practice.web.service.food.IFoodService;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.*;

public class FoodControllerTest {
    private FoodController foodController;

    private IFoodService mockFoodService;

    @Before
    public void setUp() {
        mockFoodService = mock(FoodService.class);
        foodController = new FoodController(mockFoodService);
    }

    @Test
    public void getAllFoodTest() {
        List<Food> mockFoodList = mock(List.class);

        when(mockFoodService.getAllFood()).thenReturn(mockFoodList);

        ResponseEntity<List<Food>> response = foodController.getAllFood();

        verify(mockFoodService, times(1)).getAllFood();

        Assert.assertEquals(mockFoodList, response.getBody());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getAllFoodExceptionTest() {
        when(mockFoodService.getAllFood()).thenThrow(new RuntimeException());

        ResponseEntity<List<Food>> response = foodController.getAllFood();

        verify(mockFoodService, times(1)).getAllFood();

        Assert.assertNull(response.getBody());
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    public void getNewFoodTest() {
        FoodRequestBody mockFoodRequestBody = mock(FoodRequestBody.class);

        Food mockFood = mock(Food.class);

        when(mockFoodService.createNewFood(mockFoodRequestBody)).thenReturn(mockFood);

        ResponseEntity<Food> response = foodController.getNewFood(mockFoodRequestBody);

        verify(mockFoodService, times(1)).createNewFood(mockFoodRequestBody);

        Assert.assertEquals(mockFood, response.getBody());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getNewFoodExceptionTest() {
        FoodRequestBody mockFoodRequestBody = mock(FoodRequestBody.class);

        when(mockFoodService.createNewFood(mockFoodRequestBody)).thenThrow(new RuntimeException());

        ResponseEntity<Food> response = foodController.getNewFood(mockFoodRequestBody);

        verify(mockFoodService, times(1)).createNewFood(mockFoodRequestBody);

        Assert.assertNull(response.getBody());
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
}
