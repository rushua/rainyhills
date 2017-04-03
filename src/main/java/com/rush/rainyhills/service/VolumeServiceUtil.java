package com.rush.rainyhills.service;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ruslan Khalikov
 * Date: 17.06.2016
 * Time: 15:01
 */
public abstract class VolumeServiceUtil {
    private final static Pattern arrayPattern = Pattern.compile("\\[([\\d,]*)\\]");

    public static int[] toArray(String hills) {
        Matcher matcher = arrayPattern.matcher(hills);
        if (matcher.matches()) {
            return Arrays
                    .stream(matcher.group(1).split(","))
                    .filter(hill -> !hill.isEmpty())
                    .mapToInt(Integer::valueOf)
                    .toArray();
        }
        return new int[]{};
    }

    public static boolean isArray(String hills) {
        return arrayPattern.matcher(hills).matches();
    }

    public static boolean isPositive(int[] hills) {
        return Arrays.stream(hills).noneMatch(hill -> hill < 0);
    }
}
