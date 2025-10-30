package com.example;

import org.junit.Before;
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

    private Lion lionMale;
    private Lion lionFemale;

    @Before
    public void setUp() throws Exception {
        lionMale = new Lion("Самец", feline);
        lionFemale = new Lion("Самка", feline);
    }

    @Test
    public void lionMaleHasMane() throws Exception {
        assertTrue(lionMale.doesHaveMane());
    }

    @Test
    public void lionFemaleNoMane() throws Exception {
        assertFalse(lionFemale.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void lionInvalidSexThrowsException() throws Exception {
        new Lion("Неизвестно", feline);
    }

    @Test
    public void getKittensDelegatesToFeline() throws Exception {
        when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lionFemale.getKittens());
    }

    @Test
    public void getFoodDelegatesToFeline() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lionMale.getFood());
    }
}