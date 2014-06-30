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
            {"A", "a"}    // ����һ��Ĵ������
//            {"b", "B"},                               // ���Կ��ַ�ʱ�Ĵ������
//            {"a", "a"},      // ���Ե�����ĸ��дʱ�����
//            {"A", "A"},   // ���Ե�β��ĸΪ��дʱ�����
//            {"B", "B"}    // ���Զ��������ĸ��дʱ�����
        }); 
    } 
    
    public TestStringUtils(String expected, String target) {
		this.expected = expected;
		this.target = target;
	}
  
    @Test
    public void testTrans() {
//    	assertEquals(expected, StringUtils.transform(target)); 
    }

}
