package com.project.task1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Arrays;

class FizzBuzzPopulatorImplTest {

    private static final int DATA_SIZE = 100;
    private static final char TEST_DELIMITER = ' ';

    private static FizzBuzzPopulator fizzBuzzPopulator;
    private static FizzBuzzWordGenerator fizzBuzzWordGenerator;

    private String[] data;

    @BeforeAll
    static void createPopulator() {
        fizzBuzzPopulator = new FizzBuzzPopulatorImpl(TEST_DELIMITER);
        fizzBuzzWordGenerator = new FizzBuzzWordGeneratorImpl();
    }

    @BeforeEach
    void createData() {
        data = new String[DATA_SIZE];
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

//        assertThrows(
//                IllegalArgumentException.class,
//                () -> fizzBuzzPopulator.populate(new String[99])
//        );

        assertThrows(
                IllegalArgumentException.class,
                () -> fizzBuzzPopulator.populate(new String[101])
        );
    }



    @Test
    void testPopulator() {
//        String[] data = new String[100];
        fizzBuzzPopulator.populate(data);
        for (int i = 0; i < 100; i++) {
            assertEquals(
                    fizzBuzzWordGenerator.generate(i),
                    data[i],
                    "i = " + i + ",\n array = " + Arrays.toString(data)
            );
        }
    }

    @Test
    void testPopulateWithBounds() {
//        String[] data = new String[100];
//        fizzBuzzPopulator.populate(-2, -1, data);
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    fizzBuzzPopulator.populate(-1, -2, data);
                }
        );
    }

    @Test
    void testRange() {
        String[] expected = new String[100];
        expected[10] = "Buzz";
        expected[11] = "11";
        expected[12] = "Fizz";
        expected[13] = "13";
        expected[14] = "14";
        expected[15] = "FizzBuzz";
        fizzBuzzPopulator.populate(10, 15, data);
        assertArrayEquals(expected, data);
    }

    @Test
    void testGenerateAnswer1() {
        String res = fizzBuzzPopulator.generateAnswerWithoutNull(0, 1);
        System.out.println(res);
    }

    @Test
    void testGenerateAnswer2() {
        String res = fizzBuzzPopulator.generateAnswerWithoutNull(0, 15);
        System.out.println(res);
    }

    @Test
    void testGenerateAnswerWithoutNull() {
        assertEquals(
                "FizzBuzz"
                        + TEST_DELIMITER
                        + "1"
                        + TEST_DELIMITER
                        + "2",
                fizzBuzzPopulator.generateAnswerWithoutNull(0, 2)
                );
    }
}