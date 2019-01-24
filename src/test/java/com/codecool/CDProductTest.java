package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CDProductTest {

    CDProduct cd1;
    CDProduct cd2;

    @BeforeEach
    void setUp() {

        cd1 = new CDProduct("egy cédé", 32431, 0);
        cd2 = new CDProduct("", 0, 21432);

    }

    @Test
    void getName() {
        assertEquals("egy cédé", cd1.getName());
        assertEquals("", cd2.getName());
    }
}
