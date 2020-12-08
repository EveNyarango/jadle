package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FoodtypeTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getName() {
        Foodtype testFoodtype = setUpFoodtype();
        assertEquals("dessert", testFoodtype.getName());
    }

    public Foodtype setUpFoodtype() {
        return new Foodtype("dessert");
    }

    @Test
    public void getId() {
    }

    @Test
    public void setName() {
        Foodtype testFoodtype = setUpFoodtype();
        testFoodtype.setName("breakfast");
        assertNotEquals("dessert", testFoodtype.getName());
    }

    @Test
    public void setId() {
        Foodtype testFoodtype = setUpFoodtype();
        testFoodtype.setId(5);
        assertEquals(5, testFoodtype.getId());
    }
}