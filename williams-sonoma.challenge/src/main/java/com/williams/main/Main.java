package com.williams.main;

import com.williams.model.Range;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Moustafa Sayed
 */
public class Main {

    /**
     * given a list of ranges to find the min number of required ranges to cover the given one
     * @param ranges
     * @return list of @Range represents the min number of ranges
     */
    public List<Range> findMinNumberOfRanges(List<Range> ranges) {

        List<Range> finalResult = new ArrayList<Range>();
        //Compare by startValue and then endValue
        Comparator<Range> compareRanges= Comparator
                .comparing(Range::getStartValue)
                .thenComparing(Range::getEndValue);

        // sort ranges, first by startZipCode then endZipCode if there is an equality in startZipCodeValue
        List<Range> sortedRanges = ranges.stream()
                .sorted(compareRanges)
                .collect(Collectors.toList());

        // this is the current range that we will check against it while iterating through he list
            Range currentRangeToCompare = ranges.get(0);

            for (int i = 0; i <ranges.size(); i++) {

                // check against range startZipCodeValue value to see if we can skip range[i] or we need to include it in our result
                if (  ranges.get(i).getStartValue() <= currentRangeToCompare.getEndValue()
                        || ranges.get(i).getStartValue() -1 == currentRangeToCompare.getEndValue()) {

                    // check against range endZipCode
                    if (currentRangeToCompare.getEndValue() < ranges.get(i).getEndValue()
                            && currentRangeToCompare.getStartValue() != ranges.get(i).getStartValue()) {

                        currentRangeToCompare.setEndValue(ranges.get(i).getEndValue());
                    }

                } else {
                    // if we can't skip it, then we have to include it in our final result
                    finalResult.add(currentRangeToCompare);
                    currentRangeToCompare = ranges.get(i);
                }
            }
            // if it's only one range given as a input, then return it
            finalResult.add(currentRangeToCompare);

        return finalResult;
    }

}
