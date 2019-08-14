package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2019-08-13 10:42
 */
public enum Frequency {
    QUARTERLY(4), HALF_YEARLY(2), ANNUALLY(1);

    private  final int value;
    private static Map<Integer, Frequency> map = new HashMap<>();
    Frequency(int value) {
        this.value = value;
    }

    static {
        for(Frequency frequency:Frequency.values()){
            map.put(frequency.value, frequency);
        }
    }
    public static Frequency valueOf(Integer value) {
        Frequency frequency = map.get(value);
        if (frequency == null) {
            throw new IllegalArgumentException("Incorrect frequency value.");
        }
        return frequency;
    }

    public int getValue() {
        return value;
    }

    public static Set<Integer> getValues() {
        return Arrays.stream(Frequency.values()).map(frequency -> frequency.getValue()).collect(Collectors.toSet());
    }
}
