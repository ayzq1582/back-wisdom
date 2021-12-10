package com.zhy.wisdom;

import com.zhy.wisdom.utils.ZStringUtils;
import org.junit.Test;

public class testFunction {

    @Test
    public void testCreateToken(){
        String token = ZStringUtils.createToken();
        System.out.println(token);
    }
}
