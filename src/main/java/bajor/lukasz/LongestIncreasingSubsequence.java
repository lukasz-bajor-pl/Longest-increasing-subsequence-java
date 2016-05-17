package bajor.lukasz;

import java.util.*;

/**
 * Created by lbajor on 2016-05-18.
 */
public class LongestIncreasingSubsequence {
    public List<Integer> findContinous(List<Integer> input) {
        if (input.size() <= 1) {
            return input;
        }

        List<Integer> longest = Collections.EMPTY_LIST;

        for (int i=0;i<input.size()-1;++i) {
            int j = i;
            for (;j<input.size()-1;++j) {
                if (input.get(j+1) <= input.get(j)) {
                    if (j - i + 1 > longest.size()) {
                        longest = input.subList(i, j+1);
                    }

                    i = j;
                    break;
                }
            }

            if (j == input.size()-1) {
                if (j - i + 1 > longest.size()) {
                    longest = input.subList(i, j+1);
                }
            }
        }

        return longest;
    }

    public List<Integer> findNonContinous(List<Integer> input) {
        if (input.size() <= 1) {
            return input;
        }

        class Value implements Comparable<Value> {
            final int length;
            final List<Integer> sequence;

            public Value(int length, List<Integer> sequence) {
                this.length = length;
                this.sequence = sequence;
            }

            @Override
            public int compareTo(Value o) {
                return Integer.compare(length, o.length) * -1;
            }
        }

        List<Integer> longest = Collections.EMPTY_LIST;

        NavigableMap<Integer, Value> longestPerValue = new TreeMap<Integer, Value>();

        for (int i=0;i<input.size();++i) {
            Integer currentValue = input.get(i);

            Map.Entry<Integer, Value> longestPathThatCanMergeInto = longestPerValue.lowerEntry(currentValue);

            if (longestPathThatCanMergeInto == null) {
                longestPerValue.put(currentValue, new Value(1, input.subList(i, i+1)));
            } else {
                Value previousPathStep = longestPathThatCanMergeInto.getValue();

                final LinkedList<Integer> newPath = new LinkedList<>(previousPathStep.sequence);
                newPath.add(currentValue);

                longestPerValue.put(currentValue, new Value(previousPathStep.length + 1, newPath));

                if (newPath.size() > longest.size()) {
                    longest = newPath;
                }
            }
        }

        return longest;
    }
}
