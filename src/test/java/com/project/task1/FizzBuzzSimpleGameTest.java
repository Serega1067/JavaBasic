package com.project.task1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzSimpleGameTest {

    private static FizzBuzzSimple fizzBuzzSimple;

    @BeforeAll
    static void createFizzBuzz() {
        fizzBuzzSimple = new FizzBuzzSimpleGame();
    }

    @Test
    void testCorrectInput() {
        fizzBuzzSimple.print(0);
        fizzBuzzSimple.print(100);
    }

    @Test
    void testIncorrectInput() {
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    fizzBuzzSimple.print(-1);
                }
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    fizzBuzzSimple.print(101);
                }
        );
    }

    @Test
    void testFizz() {
        assertEquals("Fizz", fizzBuzzSimple.print(3));
        assertEquals("Fizz", fizzBuzzSimple.print(6));
        assertEquals("Fizz", fizzBuzzSimple.print(9));
        assertEquals("Fizz", fizzBuzzSimple.print(12));
//        assertEquals("Fizz", fizzBuzzSimple.print(15));
    }

    @Test
    void testBuzz() {
        assertEquals("Buzz", fizzBuzzSimple.print(5));
        assertEquals("Buzz", fizzBuzzSimple.print(10));
    }

    @Test
    void testFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzzSimple.print(15));
    }

    @Test
    void testNumber() {
        assertEquals("1", fizzBuzzSimple.print(1));
        assertEquals("2", fizzBuzzSimple.print(2));
        assertEquals("4", fizzBuzzSimple.print(4));
        assertEquals("7", fizzBuzzSimple.print(7));
        assertEquals("8", fizzBuzzSimple.print(8));
    }
}
