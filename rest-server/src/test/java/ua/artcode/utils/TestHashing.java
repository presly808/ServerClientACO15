package ua.artcode.utils;

import org.junit.Assert;
import org.junit.Test;
import ua.artcode.utils.SecurityUtils;

/**
 * Created by serhii on 9/25/16.
 */
public class TestHashing {

    @Test
    public void simpleTest() {
        String adminHash1 = SecurityUtils.hash("admin");
        String adminHash2 = SecurityUtils.hash("admin");
        Assert.assertEquals(adminHash1,adminHash2);
    }
}
