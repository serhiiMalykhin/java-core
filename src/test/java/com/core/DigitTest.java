package com.core;

import org.junit.Assert;
import org.junit.Test;

public class DigitTest {
    private DigitActions digitActions = new DigitActions();

    @Test
    public void plusIntegerPositiveDigits(){
        String result = digitActions.plusStringIntegerDigits("12", "15");
        Assert.assertEquals("27", result);
    }

    @Test
    public void plusIntegerNegativeDigits(){
        String result = digitActions.plusStringIntegerDigits("-12", "-15");
        Assert.assertEquals("-27", result);
    }

    @Test
    public void plusIntegerNegativeAndPositiveDigits(){
        String result = digitActions.plusStringIntegerDigits("12", "-15");
        Assert.assertEquals("-3", result);
    }

    @Test
    public void plusDoublePositiveDigits(){
        String result = digitActions.plusStringDoubleDigits("0.15", "15");
        Assert.assertEquals("15.15", result);

        result = digitActions.plusStringDoubleDigits(".15", "15");
        Assert.assertEquals("15.15", result);
    }

    @Test
    public void plusDoublePositiveDigitsWithLetterD(){
        String result = digitActions.plusStringDoubleDigits("0.15d", "15");
        Assert.assertEquals("15.15", result);

        result = digitActions.plusStringDoubleDigits("0.15D", "15");
        Assert.assertEquals("15.15", result);

        result = digitActions.plusStringDoubleDigits("15.15d", "15");
        Assert.assertEquals("30.15", result);
    }

    @Test
    public void plusDoubleNegativeDigitsWithLetterD(){
        String result = digitActions.plusStringDoubleDigits("-0.15d", "15");
        Assert.assertEquals("14.85", result);

        result = digitActions.plusStringDoubleDigits("-0.15D", "15");
        Assert.assertEquals("14.85", result);

        result = digitActions.plusStringDoubleDigits("-15.15d", "15");
        Assert.assertEquals("-0.15000000000000036", result);
    }

}
