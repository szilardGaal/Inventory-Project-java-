package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookProductTest {

    BookProduct book1;
    BookProduct book2;

    @BeforeEach
    void setUp() {
        book1 = new BookProduct("normal name", 123, 32);
        book2 = new BookProduct("", 234, 54321231);

    }

    @Test
    void getSize() {
        assertEquals(32, book1.getSize());
        assertEquals(54321231, book2.getSize());
    }

}
