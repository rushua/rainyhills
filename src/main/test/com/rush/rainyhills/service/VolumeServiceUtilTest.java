package com.rush.rainyhills.service;

import org.junit.Assert;
import org.junit.Test;

import static com.rush.rainyhills.service.VolumeServiceUtil.*;

/**
 * Created by Ruslan Khalikov
 * Date: 16.06.2016
 * Time: 20:16
 */
public class VolumeServiceUtilTest {

    @Test
    public void parseTest() {
        Assert.assertArrayEquals(new int[]{}, toArray("[]"));
        Assert.assertArrayEquals(new int[]{}, toArray("[,]"));
        Assert.assertArrayEquals(new int[]{}, toArray("[,,]"));
        Assert.assertArrayEquals(new int[]{0}, toArray("[0]"));
        Assert.assertArrayEquals(new int[]{0, 1, 2}, toArray("[0,1,2]"));
        Assert.assertArrayEquals(new int[]{0, 1, 2}, toArray("[,0,1,2,]"));
        Assert.assertArrayEquals(new int[]{0, 1, 2}, toArray("[,0,1,2,]"));
        Assert.assertArrayEquals(new int[]{0, 1, 2}, toArray("[0,,1,,2]"));
        Assert.assertArrayEquals(new int[]{0, 1, 2}, toArray("[,,0,1,2,,]"));
    }

    @Test
    public void isArrayTest() {
        Assert.assertFalse(isArray(""));
        Assert.assertFalse(isArray("]["));
        Assert.assertFalse(isArray("[s]"));
        Assert.assertFalse(isArray("[1 2]"));
        Assert.assertFalse(isArray("[1;2]"));
        Assert.assertFalse(isArray("[-12]"));
        Assert.assertFalse(isArray("[,-1,2,0,]"));

        Assert.assertTrue(isArray("[]"));
        Assert.assertTrue(isArray("[,]"));
        Assert.assertTrue(isArray("[,,]"));
        Assert.assertTrue(isArray("[12]"));
        Assert.assertTrue(isArray("[1,2]"));
        Assert.assertTrue(isArray("[,12,]"));
        Assert.assertTrue(isArray("[,1,2,]"));
    }

    @Test
    public void isPositiveTest() {
        Assert.assertFalse(isPositive(new int[]{-1}));
        Assert.assertFalse(isPositive(new int[]{-1, 0, 1}));
        Assert.assertFalse(isPositive(new int[]{1, 0, -1}));

        Assert.assertTrue(isPositive(new int[]{0}));
        Assert.assertTrue(isPositive(new int[]{1}));
        Assert.assertTrue(isPositive(new int[]{0, 1, 2}));
        Assert.assertTrue(isPositive(new int[]{1, 2, 0}));
    }
}
