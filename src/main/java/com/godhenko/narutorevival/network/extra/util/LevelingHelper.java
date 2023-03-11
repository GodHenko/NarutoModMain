package com.godhenko.narutorevival.network.extra.util;

import java.util.ArrayList;

public class LevelingHelper {
    public static int byRanges(ArrayList<Range> ranges, int level) {
        for (int i = 0; i < ranges.size(); i++) {
            Range range = ranges.get(i);
            if (range.isIn(level)) {
                return i;
            }
        }

        return 0;
    }

    public static int linear(float amount, float div) {
        return (int) Math.floor(amount / div) + 1;
    }

    public static int exponential(float level, float base) {
        level = level + 1;
        return (int) Math.floor(Math.log(level) / Math.log(base));
    }

    public static int exponentialRaw(float level, float base) {
        return (int) Math.pow(base, exponential(level-1, base));
    }

    public static int progressExponential(float level, float base) {
        double previous = Math.pow(base, exponential(level-1, base));
        double next = previous * base;

        return (int) (((level - previous)/(next - previous)) * 100);
    }

    public static boolean shouldLevelUpExponential(float level, float base) {
        return Math.pow(base, exponential(level, base)) == Math.floor(level+1);
    }
}
