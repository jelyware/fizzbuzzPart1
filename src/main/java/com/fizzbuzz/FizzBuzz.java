package com.fizzbuzz;

/**
 * FizzBuzz (Step 1) API
 * @author Jessica lynch
 * Purpose: Use to execute Step 1 FizzBuzz and print string output to std out.
 * Example output:
 *    1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz
 *
 */
public class FizzBuzz
{
    /**
     * Runs FizzBuzz (Step 1)
     * @param min start of range of contiguous numbers
     * @param max end of range of contiguous numbers
     */
    public void runFizzBuzz(int min, int max)
    {
        StringBuilder sb = new StringBuilder();
        for(int i= min; i < max+1; i++)
        {
            if (i % 15 == 0)
            {
                sb.append("fizzbuzz ");
            }
            else
            {
                if (i % 3 == 0)
                {
                    sb.append("fizz ");
                }
                else if (i % 5 == 0)
                {
                    sb.append("buzz ");
                }
                else
                {
                    sb.append(Integer.toString(i));
                    sb.append(" ");
                }
            }
        }
        System.out.println(sb.toString().strip());
    }
}
