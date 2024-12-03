package com.project.task1;

public class FizzBuzzSimpleGame implements FizzBuzzSimple {

    @Override
    public String print(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(
                    "number should be great or equal 0"
            );
        }
        if (number > 100) {
            throw new IllegalArgumentException(
                    "number should be less or equal 100"
            );
        }
//        throw new UnsupportedOperationException("todo: implement this");

        if (number % 3 == 0) {
            return "Fizz";
        }

        return "";
    }
}
