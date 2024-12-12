package com.project.task1;

public class FizzBuzzPopulatorImpl implements FizzBuzzPopulator, FizzBuzz {

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 100;

    private static final FizzBuzzWordGenerator fizzBuzzWordGenerator
            = new FizzBuzzWordGeneratorImpl();

    private final char DELIMITER;

    public FizzBuzzPopulatorImpl(char DELIMITER) {
        this.DELIMITER = DELIMITER;
    }

    // [0, 100]
    @Override
    public void populate(String[] data) {
//        throw new UnsupportedOperationException("todo: implement this");
        checkArrayConstraints(data);
        populate(LOWER_BOUND, data.length, data);
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
        checkArrayConstraints(data);
        if (from < LOWER_BOUND || from > UPPER_BOUND) {
            throw new IllegalArgumentException("bound");
        }

//        if (data.length > UPPER_BOUND) {
//            throw new IllegalArgumentException("array length should be equal 100");
//        }
        int shift = calcShift(data);
//        if ( data.length < 100) {
//            shift = UPPER_BOUND - data.length;
//        }
        for (int index = from; index <= to && index < UPPER_BOUND; index++) {
            data[index] = fizzBuzzWordGenerator.generate(index);
        }
    }

    @Override
    public String generateAnswerWithoutNull(int from, int to) {
        int length = to - from + 1;
        String[] answer = new String[length];
        populate(from, to, answer);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < answer.length - 1; i++) {
            stringBuilder.append(answer[i]);
            stringBuilder.append(DELIMITER);
        }
        stringBuilder.append(answer[answer.length - 1]);
//        for (String res : answer) {
//            stringBuilder.append(res);
//            stringBuilder.append(" ");
//        }
        return stringBuilder.toString();
    }

    @Override
    public void print(int from, int to) {
//        System.out.println(generateAnswerWithoutNull(from, to));
        System.out.print(generateAnswerWithoutNull(from, to));
        System.out.flush(); // для проверки работы System.out.print
    }

    private void checkArrayConstraints(String[] data) {
        if (data == null) {
            throw new IllegalArgumentException("array should be not null");
        }
        if (data.length == 0) {
            throw new IllegalArgumentException("data is empty");
        }

        if (data.length > UPPER_BOUND) {
            throw new IllegalArgumentException("data.length > 100");
        }
    }

    private int calcShift(String[] data) {
        return UPPER_BOUND - data.length;
    }
}
