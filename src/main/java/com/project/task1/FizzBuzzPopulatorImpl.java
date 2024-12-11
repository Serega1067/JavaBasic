package com.project.task1;

public class FizzBuzzPopulatorImpl implements FizzBuzzPopulator, FizzBuzz {

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 100;

    private static final FizzBuzzWordGenerator fizzBuzzWordGenerator
            = new FizzBuzzWordGeneratorImpl();

    // [0, 100]
    @Override
    public void populate(String[] data) {
//        throw new UnsupportedOperationException("todo: implement this");
        populate(LOWER_BOUND, UPPER_BOUND, data);
//        if (data == null) {
//            throw new IllegalArgumentException(
//                    "array should be not null"
//            );
//        }
//        if (data.length != UPPER_BOUND) {
//            throw new IllegalArgumentException(
//                    "array length should be equal 100"
//            );
//        }
//        for (int number = LOWER_BOUND; number < UPPER_BOUND; number++) {
//            data[number] = fizzBuzzWordGenerator.generate(number);
//        }
    }

    @Override
    public void populate(int from, int to, String[] data) {
        if (from < LOWER_BOUND || from > UPPER_BOUND) {
            throw new IllegalArgumentException("bound");
        }
        if (data == null) {
            throw new IllegalArgumentException("array should be not null");
        }
        if (data.length != UPPER_BOUND) {
            throw new IllegalArgumentException("array length should be equal 100");
        }
        for (int number = from; number <= to && number < UPPER_BOUND; number++) {
            data[number] = fizzBuzzWordGenerator.generate(number);
        }
    }

    @Override
    public String generateAnswerWithoutNull(int from, int to) {
        String[] answer = new String[100];
        populate(from, to, answer);
        StringBuilder stringBuilder = new StringBuilder();
        for (String res : answer) {
            stringBuilder.append(res);
        }
        return stringBuilder.toString();
    }

    @Override
    public void print(int from, int to) {
        System.out.println(generateAnswerWithoutNull(from, to));
    }
}
