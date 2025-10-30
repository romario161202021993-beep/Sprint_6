package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AlexTest {

    @Mock
    Feline feline;

    private Alex alex;

    @Before
    public void setUp() throws Exception {
        alex = new Alex(feline);
    }

    @Test
    public void getKittensReturnsZero() {
        assertEquals(0, alex.getKittens());
    }

    @Test
    public void getFriendsReturnsCorrectList() {
        List<String> expected = Arrays.asList("Марти", "Глория", "Мелман");
        assertEquals(expected, alex.getFriends());
    }

    @Test
    public void getPlaceOfLivingReturnsNewYorkZoo() {
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void constructorSetsSexToMale() {
        assertTrue(alex.doesHaveMane());
    }
}