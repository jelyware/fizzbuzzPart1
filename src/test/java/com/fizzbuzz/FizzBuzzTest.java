package com.fizzbuzz;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Unit test suite for FizzBuzz (Part 1).
 */
public class FizzBuzzTest
{
    /**
     * Base test function to execute FizzBuzz and store std out into buffer
     * @param min start of range of contiguous numbers
     * @param max end of range of contiguous numbers
     * @return string containing std out from FizzBuzz execution
     */
    public String getRunFizzBuzzResponseFromStandardOut(int min, int max)
    {
        PrintStream stdOut = System.out;
        FizzBuzz fb = new FizzBuzz();
        ByteArrayOutputStream stdOutBuffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdOutBuffer));
        fb.runFizzBuzz(min, max);
        System.setOut(stdOut);
        return (stdOutBuffer.toString().replaceAll("\r", "").strip());
    }

    @Test
    public void test0_OutputFrom0To0()
    {
        System.out.println("TEST #0: Get Expected Output From 0 to 0");
        int minNum = 0;
        int maxNum = 0;
        String response = getRunFizzBuzzResponseFromStandardOut(minNum, maxNum);
        String expected = "fizzbuzz";
        assertEquals(response, expected);
    }

    @Test
    public void test1_OutputFrom21To21()
    {
        System.out.println("TEST #1: Verify Output From 21 to 21");
        int minNum = 21;
        int maxNum = 21;
        String response = getRunFizzBuzzResponseFromStandardOut(minNum, maxNum);
        String expected = "fizz";
        assertEquals(response, expected);
    }

    @Test
    public void test2_OutputFrom22To22()
    {
        System.out.println("TEST #2: Verify Output From 22 to 22");
        int minNum = 22;
        int maxNum = 22;
        String response = getRunFizzBuzzResponseFromStandardOut(minNum, maxNum);
        String expected = "22";
        assertEquals(response, expected);
    }

    @Test
    public void test3_OutputFrom0To20()
    {
        System.out.println("TEST #3: Verify Output From 0 to 20");
        int minNum = 0;
        int maxNum = 20;
        String response = getRunFizzBuzzResponseFromStandardOut(minNum, maxNum);
        String expected = "fizzbuzz 1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz";
        assertEquals(response, expected);
    }

    @Test
    public void test4_OutputFrom45To60()
    {
        System.out.println("TEST #4: Verify Output From 45 to 60");
        int minNum = 45;
        int maxNum = 60;
        String response = getRunFizzBuzzResponseFromStandardOut(minNum, maxNum);
        String expected = "fizzbuzz 46 47 fizz 49 buzz fizz 52 53 fizz buzz 56 fizz 58 59 fizzbuzz";
        assertEquals(response, expected);
    }

    @Test
    public void test5_FizzbuzzCountInOutputFrom0To30()
    {
        System.out.println("TEST #5: Get Expected 'fizzbuzz' Count in Output From 0 to 30");
        int minNum = 0;
        int maxNum = 30; // A multiple of both 3 and 5 and therefore 15
        int fizzbuzzCountExpected = (30/15) + 1; // Add 1 for 0
        String response = getRunFizzBuzzResponseFromStandardOut(minNum, maxNum);
        String [] respArr = response.split(" ");
        int fizzbuzzCountActual = 0;
        for(String i : respArr)
        {
            if (i.equals("fizzbuzz"))
            {
                fizzbuzzCountActual++;
            }
        }
        assertEquals(fizzbuzzCountExpected, fizzbuzzCountActual);
    }

    @Test
    public void test6_FizzCountInOutputFrom0To30()
    {
        System.out.println("TEST #6: Verify 'fizz' Count in Output From 0 to 30");
        int minNum = 0;
        int maxNum = 30; // A multiple of both 3 and 5 and therefore 15
        int fizzbuzzCount = (30/15); // Exclude 0
        int fizzCountExpected = (30/3) - fizzbuzzCount;
        String response = getRunFizzBuzzResponseFromStandardOut(minNum, maxNum);
        String [] respArr = response.split(" ");
        int fizzCountActual = 0;
        for(String i : respArr)
        {
            if (i.equals("fizz"))
            {
                fizzCountActual++;
            }
        }
        assertEquals(fizzCountExpected, fizzCountActual);
    }

    @Test
    public void test7_BuzzCountInOutputFrom0To20()
    {
        System.out.println("TEST #7: Verify 'buzz' Count in Output From 0 to 30");
        int minNum = 0;
        int maxNum = 30; // A multiple of both 3 and 5 and therefore 15
        int fizzbuzzCount = (30/15); // Exclude 0
        int buzzCountExpected = (30/5) - fizzbuzzCount;
        String response = getRunFizzBuzzResponseFromStandardOut(minNum, maxNum);
        String [] respArr = response.split(" ");
        int buzzCountActual = 0;
        for(String i : respArr)
        {
            if (i.equals("buzz"))
            {
                buzzCountActual++;
            }
        }
        assertEquals(buzzCountExpected, buzzCountActual);
    }

    @Test
    public void test8_FizzbuzzCountInOutputFrom0To999990()
    {
        System.out.println("TEST #8: Verify 'fizzbuzz' Count in Output From 0 to 999990");
        int minNum = 0;
        int maxNum = 999990; // A large multiple of both 3 and 5 and therefore 15
        int fizzbuzzCountExpected = (999990/15) + 1; // Add 1 for 0
        String response = getRunFizzBuzzResponseFromStandardOut(minNum, maxNum);
        String [] respArr = response.split(" ");
        int fizzbuzzCountActual = 0;
        for(String i : respArr)
        {
            if (i.equals("fizzbuzz"))
            {
                fizzbuzzCountActual++;
            }
        }
        assertEquals(fizzbuzzCountExpected, fizzbuzzCountActual);
    }

    @Test
    public void test9_FizzCountInOutputFrom0To999990()
    {
        System.out.println("TEST #9: Verify 'fizz' Count in Output From 0 to 999990");
        int minNum = 0;
        int maxNum = 999990; // A large multiple of both 3 and 5 and therefore 15
        int fizzbuzzCount = (999990/15); // Exclude 0
        int fizzCountExpected = (999990/3) - fizzbuzzCount;
        String response = getRunFizzBuzzResponseFromStandardOut(minNum, maxNum);
        String [] respArr = response.split(" ");
        int fizzCountActual = 0;
        for(String i : respArr)
        {
            if (i.equals("fizz"))
            {
                fizzCountActual++;
            }
        }
        assertEquals(fizzCountExpected, fizzCountActual);
    }

    @Test
    public void test10_BuzzCountInOutputFrom0To999990()
    {
        System.out.println("TEST #10: Verify 'buzz' Count in Output From 0 to 999990");
        int minNum = 0;
        int maxNum = 999990; // A large multiple of both 3 and 5 and therefore 15
        int fizzbuzzCount = (999990/15); // Exclude 0
        int buzzCountExpected = (999990/5) - fizzbuzzCount;
        String response = getRunFizzBuzzResponseFromStandardOut(minNum, maxNum);
        String [] respArr = response.split(" ");
        int buzzCountActual = 0;
        for(String i : respArr)
        {
            if (i.equals("buzz"))
            {
                buzzCountActual++;
            }
        }
        assertEquals(buzzCountExpected, buzzCountActual);
    }

    @Test
    public void test11_StartAndEndOutputFrom0To999990()
    {
        System.out.println("TEST #11: Verify Start and End Output From 0 to 999990");
        int minNum = 0;
        int maxNum = 999990; // A large multiple of both 3 and 5 and therefore 15
        String response = getRunFizzBuzzResponseFromStandardOut(minNum, maxNum);
        String [] respArr = response.split(" ");
        int arrLen = respArr.length;
        String startOfStringReceived = respArr[0];
        String endOfStringReceived = respArr[arrLen-1];
        String startOfStringExpected = "fizzbuzz";
        String endOfStringExpected = "fizzbuzz";
        assertEquals(startOfStringReceived, startOfStringExpected);
        assertEquals(endOfStringReceived, endOfStringExpected);
    }

}
