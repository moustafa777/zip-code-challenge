package com.williams.main;

import com.williams.model.Range;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Test class for Main Class
 */
public class MainTest {

    @Test
    public void findMinNumberOfRangesTestOne() {
        List<Range> given = new ArrayList<>();
        List<Range> expected = new ArrayList<>();

        given.add(new Range(94133, 94133));
        given.add(new Range(94200, 94299));
        given.add(new Range(94226, 94399));

        expected.add(new Range(94133, 94133));
        expected.add(new Range(94200, 94399));
        Main  main = new Main();
        List<Range> result=  main.findMinNumberOfRanges(given);
        assertEquals(2, result.size());
        assertEquals(expected, result);
    }

    @Test
    public void findMinNumberOfRangesTestTwo() {
        List<Range> given = new ArrayList<>();
        List<Range> expected = new ArrayList<>();

        given.add(new Range(94133, 94133));
        given.add(new Range(94200, 94299));
        given.add(new Range(94600, 94699));

        expected.add(new Range(94133, 94133));
        expected.add(new Range(94200, 94299));
        expected.add(new Range(94600, 94699));
        Main  main = new Main();
        List<Range> result=  main.findMinNumberOfRanges(given);
        assertEquals(3, result.size());
        assertEquals(expected, result);



    }
}
