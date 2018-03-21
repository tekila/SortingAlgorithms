/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesortteste;

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pegai
 */
public class MergeSortTesteTest {
    
    private int[] numbers;
    private final static int SIZE = 300;
    private final static int MAX = 400;
    
    public MergeSortTesteTest() {
        for(int i = 0; i<numbers.length - 1; i++)
        {
            if(numbers[i]<numbers[i+1])
            {
                fail("essa merda desse sort");
            }
        }
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception{
        numbers = new int [SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class MergeSortTeste.
     */
    
    
    
    @Test
    public void testMain() {
        
        int k = 0;
        while(k < 10000)
        {
            MergeSort ms = new MergeSort(numbers);
            ms.sort(0, numbers.length-1);
            for(int i = 0; i<numbers.length - 1; i++)
            {
                if(numbers[i]<numbers[i+1])
                {
                    fail("essa merda desse sort");
                }
            }

            k++;
            assertTrue(true);
        }
    }
    
}
