package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*;
import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class AlexTest {

    @Mock
    Feline feline;

    @Test
    public void getKittens_ReturnsZero() throws Exception {
        Alex alex = new Alex(feline);
        assertEquals(0, alex.getKittens());
    }

    @Test
    public void getFriends_ReturnsCorrectList() throws Exception {
        Alex alex = new Alex(feline);
        assertTrue(alex.getFriends().containsAll(
                Arrays.asList("Марти", "Глория", "Мелман")
        ));
        assertEquals(3, alex.getFriends().size());
    }

    @Test
    public void getPlaceOfLiving_ReturnsZoo() throws Exception {
        Alex alex = new Alex(feline);
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void constructor_SetsSexToMale() throws Exception {
        Alex alex = new Alex(feline);
        assertTrue(alex.doesHaveMane());
    }
}