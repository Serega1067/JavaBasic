package com.project.task1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzWordGeneratorImplTest {

    private static FizzBuzzWordGenerator fizzBuzzWordGenerator;

    @BeforeAll
    static void createFizzBuzz() {
        fizzBuzzWordGenerator = new FizzBuzzWordGeneratorImpl();
    }

    @Test
    void testCorrectInput() {
        fizzBuzzWordGenerator.generate(0);
        fizzBuzzWordGenerator.generate(100);
    }

    @Test
    void testIncorrectInput() {
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    fizzBuzzWordGenerator.generate(-1);
                }
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    fizzBuzzWordGenerator.generate(101);
                }
        );
    }

    @Test
    void testFizz() {
        assertEquals("Fizz", fizzBuzzWordGenerator.generate(3));
        assertEquals("Fizz", fizzBuzzWordGenerator.generate(6));
        assertEquals("Fizz", fizzBuzzWordGenerator.generate(9));
        assertEquals("Fizz", fizzBuzzWordGenerator.generate(12));
//        assertEquals("Fizz", fizzBuzzSimple.print(15));
    }

    @Test
    void testBuzz() {
        assertEquals("Buzz", fizzBuzzWordGenerator.generate(5));
        assertEquals("Buzz", fizzBuzzWordGenerator.generate(10));
    }

    @Test
    void testFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzzWordGenerator.generate(15));
    }

    @Test
    void testNumber() {
        assertEquals("1", fizzBuzzWordGenerator.generate(1));
        assertEquals("2", fizzBuzzWordGenerator.generate(2));
        assertEquals("4", fizzBuzzWordGenerator.generate(4));
        assertEquals("7", fizzBuzzWordGenerator.generate(7));
        assertEquals("8", fizzBuzzWordGenerator.generate(8));
    }
}
