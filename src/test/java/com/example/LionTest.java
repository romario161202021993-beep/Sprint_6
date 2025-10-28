package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void lionMale_HasMane() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void lionFemale_NoMane() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void lionInvalidSex_ThrowsException() throws Exception {
        new Lion("Неизвестно", feline);
    }

    @Test
    public void getKittens_DelegatesToFeline() throws Exception {
        when(feline.getKittens()).thenReturn(4);
        Lion lion = new Lion("Самка", feline);
        assertEquals(4, lion.getKittens());
        verify(feline).getKittens();
    }

    @Test
    public void getFood_DelegatesToFeline() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(List.of("Зебра", "Антилопа"));
        Lion lion = new Lion("Самец", feline);
        assertEquals(List.of("Зебра", "Антилопа"), lion.getFood());
        verify(feline).getFood("Хищник");
    }
}