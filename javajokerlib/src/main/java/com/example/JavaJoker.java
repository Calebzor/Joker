package com.example;

import java.util.Random;

public class JavaJoker {

    /**
     * Source: https://www.reddit.com/r/AskReddit/comments/1kvhmz/whats_the_best_programming_joke_that_you_know/
     */
    private String[] mJavaJokes = {"Java and C were telling jokes. It was C's turn, " +
            "so he writes something on the wall, points to it" +
            " and says \"Do you get the reference?\" But Java didn't.",
            "Why C gets all the chicks and Java doesn't? Because C doesn't treat them like " +
                    "objects.",
            "Some people see a problem and think \"I know, I'll use Java!\". Now they have a " +
                    "ProblemFactory.",
            "Why do Java programmers wear glasses?\n Because they don't C#!",
            "If you put a million monkeys at a million keyboards, one of them will eventually " +
                    "write a Java program.\n The rest of them will write Perl programs."};

    public String getRandomJavaJoke() {
        return mJavaJokes[new Random().nextInt(mJavaJokes.length)];
    }
}
