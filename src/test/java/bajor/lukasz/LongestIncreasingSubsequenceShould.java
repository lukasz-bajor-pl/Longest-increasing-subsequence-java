package bajor.lukasz;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Created by lbajor on 2016-05-18.
 */
public class LongestIncreasingSubsequenceShould {
    private LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();

    private List<Integer> performanceTestInput = asList(
            7, 8, 0, 3, 7, 4, 9, 9, 0, 2, 5, 7, 0, 8, 7, 4, 1, 6, 1, 0, 3, 2, 2, 9,
            4, 6, 2, 3, 5, 6, 4, 8, 1, 5, 1, 5, 2, 2, 5, 2, 2, 3, 4, 9, 7, 4, 9, 8,
            4, 5, 9, 9, 5, 3, 8, 3, 2, 4, 5, 7, 2, 8, 1, 5, 2, 3, 0, 8, 3, 5, 0, 5,
            5, 9, 6, 6, 4, 3, 8, 2, 7, 8, 9, 5, 0, 3, 3, 6, 7, 1, 9, 3, 7, 4, 7, 6, 1, 4, 3, 2);

    @Test
    public void returnEmptyListGivenEmptyList() throws Exception {
        assertEquals(0, longestIncreasingSubsequence.findContinous(Collections.EMPTY_LIST).size());
    }

    @Test
    public void returnInputListGivenOneElement() throws Exception {
        List<Integer> oneElementList = asList(1);

        assertEquals(oneElementList, longestIncreasingSubsequence.findContinous(oneElementList));
    }

    @Test
    public void return123From12324() throws Exception {
        assertEquals(asList(1,2,3), longestIncreasingSubsequence.findContinous(asList(1,2,3,2,4)));
    }

    @Test
    public void return124From12124() throws Exception {
        assertEquals(asList(1,2,4), longestIncreasingSubsequence.findContinous(asList(1,2,1,2,4)));
    }

    @Test
    public void performanceTestContinous() throws Exception {
        assertEquals(asList(0,2,5,7), longestIncreasingSubsequence.findContinous(performanceTestInput));
    }

    @Test
    public void returnInputForNonContinousFindForSize0() {
        assertEquals(0, longestIncreasingSubsequence.findNonContinous(Collections.EMPTY_LIST).size());
    }

    @Test
    public void returnInputForNonContinousFindForSize1() {
        List<Integer> oneElementList = asList(1);

        assertEquals(oneElementList, longestIncreasingSubsequence.findNonContinous(oneElementList));
    }

    @Test
    public void return1234From12324() throws Exception {
        assertEquals(asList(1,2,3,4), longestIncreasingSubsequence.findNonContinous(asList(1,2,3,2,4)));
    }

    @Test
    public void return1234From121234123() throws Exception {

        assertEquals(asList(1,2,3,4), longestIncreasingSubsequence.findNonContinous(asList(1,2,1,2,3,4,1,2,3)));
    }

    @Test
    public void performanceTestNonContinous() throws Exception {
        List<Integer> performanceTestExpectedResult = asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

       assertEquals(performanceTestExpectedResult, longestIncreasingSubsequence.findNonContinous(performanceTestInput));
    }
}