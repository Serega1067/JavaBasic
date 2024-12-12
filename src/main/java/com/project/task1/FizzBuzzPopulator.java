package com.project.task1;

public interface FizzBuzzPopulator {

    // from and to inside [0, 100]
    void populate(String[] array);

    void populate(int from, int to, String[] array);

    String generateAnswerWithoutNull(int from, int to);
}
