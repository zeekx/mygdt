/*
 * Copyright 2018, Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.SimpleCalcTestHomework;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * JUnit4 unit tests for the calculator logic.
 * These are local unit tests; no device needed.
 */
@RunWith(JUnit4.class)
@SmallTest
public class CalculatorTest {

    private Calculator mCalculator;

    /**
     * Sets up the environment for testing.
     */
    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    /**
     * Tests for simple addition.
     */
    @Test
    public void addTwoNumbers() {
        double resultAdd = mCalculator.add(1d, 1d);
        assertThat(resultAdd, is(equalTo(2d)));
    }
    /**
     * Tests for addition with a negative operand.
     */
    @Test
    public void addTwoNumbersNegative() {
//        double resultAdd = mCalculator.add(-1d, 2d);
        double resultAdd = mCalculator.add(-3d, 1d);
        assertThat(resultAdd, is(equalTo(-2d)));
    }
    /**
     * Tests for addition where the result is negative.
     */
    @Test
    public void addTwoNumbersWorksWithNegativeResult() {
        double resultAdd = mCalculator.add(-1d, -17d);
        assertThat(resultAdd, is(equalTo(-18d)));
    }
    /**
     * Tests for floating-point addition.
     */
    @Test
    public void addTwoNumbersFloats() {
        double resultAdd = mCalculator.add(1.111d, 1.111d);
        assertThat(resultAdd, is(equalTo(2.222)));
    }

    /**
     * Tests for especially large numbers.
     */
    @Test
    public void addTwoNumbersBignums() {
        double resultAdd = mCalculator.add(123456781d, 111111111d);
        assertThat(resultAdd, is(equalTo(234567892d)));
    }
    /**
     * Tests for simple subtraction.
     */
    @Test
    public void subTwoNumbers() {
        double resultSub = mCalculator.sub(1d, 1d);
        assertThat(resultSub, is(equalTo(0d)));
    }

    /**
     * Tests for simple subtraction with a negative result.
     */
    @Test
    public void subWorksWithNegativeResult() {
        double resultSub = mCalculator.sub(1d, 17d);
        assertThat(resultSub, is(equalTo(-16d)));
    }

    /**
     * Tests for simple division.
     */
    @Test
    public void divTwoNumbers() {
        double resultDiv = mCalculator.div(32d,2d);
        assertThat(resultDiv, is(equalTo(16d)));
    }

    /**
     * Tests for divide by zero; always fails, so removed.
     */
    /*@Test
    public void divTwoNumbersZero() {
        double resultDiv = mCalculator.div(32d,0);
        assertThat(resultDiv, is(equalTo(Double.POSITIVE_INFINITY)));
    }*/

    /*
    * Test for divide by 0, must throws IllegalArgument Exception*/
    @Test(expected = IllegalArgumentException.class)
    public void divByZeroThrows() {
        mCalculator.div(33, 0);
    }

    /**
     * Tests for simple multiplication.
     */
    @Test
    public void mulTwoNumbers() {
        double resultMul = mCalculator.mul(32d, 2d);
        assertThat(resultMul, is(equalTo(64d)));
    }

    @Test
    public void powTwoPositiveNumbers() {
        final double resultPow = mCalculator.pow(2d, 3d);
        assertThat(resultPow, is(equalTo(8d)));
    }


    @Test
    public void powNegativeIntegerBaseNumbers() {
        final double resultPow = mCalculator.pow(-3d, 2d);
        assertThat(resultPow, is(equalTo(9d)));
    }

    @Test
    public void powNegativeIntegerExpNumbers() {
        final double resultPow = mCalculator.pow(3d, -2d);
        assertThat(resultPow, is(equalTo(1/9d)));
    }

    @Test
    public void powZeroWasBasePositiveExpNumbers() {
        final double resultPow = mCalculator.pow(0, 2d);
        assertThat(resultPow, is(equalTo(0d)));
    }

    /*
    * pow(0, -1)*/
    @Test
    public void powZeroWasBaseNegativeOneNumbers() {
        final double resultPow = mCalculator.pow(0, -1d);
        assertThat(resultPow, is(equalTo(Double.POSITIVE_INFINITY)));
    }

    @Test
    public void powZeroWasExpNumbers() {
        final double resultPow = mCalculator.pow(3d, 0d);
        assertThat(resultPow, is(equalTo(1d)));
    }

    /*
    * pow(-0, -3)*/
    @Test
    public void powNegativeZeroWasBaseNegativeExpNumbers() {
        final double resultPow = mCalculator.pow(-0, -2d);
        assertThat(resultPow, is(equalTo(Double.POSITIVE_INFINITY)));
    }

}