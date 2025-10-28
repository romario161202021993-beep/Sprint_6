package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class CatTest {

    @Test
    public void getSound_ReturnsMeow() {
        Cat cat = new Cat();
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getKittens_InheritedFromFeline_ReturnsOne() {
        Cat cat = new Cat();
        assertEquals(1, cat.getKittens());
    }

    @Test
    public void getFamily_ReturnsCatFamily() {
        Cat cat = new Cat();
        assertEquals("Кошачьи", cat.getFamily());
    }
}