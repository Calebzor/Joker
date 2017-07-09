package com.example;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class JavaJokerTest {

    @Test
    public void getRandomJavaJoke() throws Exception {
        JavaJoker javaJoker = new JavaJoker();
        assertNotNull(javaJoker.getRandomJavaJoke());
    }

}