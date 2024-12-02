package com.project.task1;

public interface FizzBuzzSimple {

    /**
     * Написать программу, которой на вход подаётся число от 1 до 100
     * Если число кратно трём, то программа должна вернуть слово "Fizz".
     * Если число кратно пяти, то программа должна вернуть слово "Buzz".
     * Если число кратно и трём, и пяти,
     *     то программа должна вернуть слово "FizzBuzz".
     * Иначе программа должна вернуть само число в виде строки.
     * @param number - входной параметр
     */
    String print(int number);
}