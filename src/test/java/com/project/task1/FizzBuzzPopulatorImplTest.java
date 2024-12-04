package com.project.task1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzPopulatorImplTest {

    private static FizzBuzzPopulator fizzBuzzPopulator;
    private static FizzBuzzWordGenerator fizzBuzzWordGenerator;

    @BeforeAll
    static void createPopulator() {
        fizzBuzzPopulator = new FizzBuzzPopulatorImpl();
        fizzBuzzWordGenerator = new FizzBuzzWordGeneratorImpl();
    }

    @Test
    void testNullArray() {
        assertThrows(
                IllegalArgumentException.class,
                () -> fizzBuzzPopulator.populate(null)
        );
    }

    @Test
    void testIncorrectArray() {
        assertThrows(
                IllegalArgumentException.class,
                () -> fizzBuzzPopulator.populate(new String[0])
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> fizzBuzzPopulator.populate(new String[99])
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> fizzBuzzPopulator.populate(new String[101])
        );
    }

    @Test
    void testPopulator() {
        String[] data = new String[100];
        fizzBuzzPopulator.populate(data);
        for (int i = 0; i < 100; i++) {
            assertEquals(
                    fizzBuzzWordGenerator.generate(i),
                    data[i]
            );
        }
    }
}