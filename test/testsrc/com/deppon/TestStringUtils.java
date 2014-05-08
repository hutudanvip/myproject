package com.deppon;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class) 
public class TestStringUtils extends TestCase{
    private String expected; 
    
    private String target; 

    @Parameters 
    public static Collection words(){ 
        return Arrays.asList(new Object[][]{ 
            {"A", "a"}    // 测试一般的处理情况
//            {"b", "B"},                               // 测试空字符串时的处理情况
//            {"a", "a"},      // 测试当首字母大写时的情况
//            {"A", "A"},   // 测试当尾字母为大写时的情况
//            {"B", "B"}    // 测试多个相连字母大写时的情况
        }); 
    } 
    
    public TestStringUtils(String expected, String target) {
		this.expected = expected;
		this.target = target;
	}
  
    @Test
    public void testTrans() {
    	assertEquals(expected, StringUtils.transform(target)); 
    }

}
