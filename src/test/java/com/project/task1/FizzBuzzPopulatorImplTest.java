package com.project.task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Arrays;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.io.BufferedOutputStream;

class FizzBuzzPopulatorImplTest {

    private static final int DATA_SIZE = 100;
    private static final char TEST_DELIMITER = ' ';

    private static FizzBuzzPopulator fizzBuzzPopulator;
    private static FizzBuzzWordGenerator fizzBuzzWordGenerator;

    private static PrintStream defaultSystemOut;
    private static ByteArrayOutputStream testBuffer;
    private FizzBuzz fizzBuzz;

    private String[] data;

    @BeforeAll
    static void createPopulator() {
        fizzBuzzPopulator = new FizzBuzzPopulatorImpl(TEST_DELIMITER);
        fizzBuzzWordGenerator = new FizzBuzzWordGeneratorImpl();
    }

    @BeforeAll
    static void overrideOut() {
        defaultSystemOut = System.out;
        testBuffer = new ByteArrayOutputStream();
        System.setOut(
                new PrintStream(
                        new BufferedOutputStream(
                                testBuffer
                        )
                )
        );
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

    @Test
    void testSystemOut() {
        new FizzBuzzPopulatorImpl('-').print(0, 2);
        String res = testBuffer.toString();
        assertEquals("FizzBuzz-1-2", res);
    }

    @AfterEach
    void resetBuffer() {
        testBuffer.reset();
    }

    @AfterAll()
    static void resetOut() {
        System.setOut(defaultSystemOut);
    }
}