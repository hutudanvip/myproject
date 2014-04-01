package com.common.util.string;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *<pre>
 * 功能: String 字符串处理类
 * 作者: 陈林林
 * 日期: 2013-8-14上午10:21:46
 *</pre>
 */
public class StringUtils {
	
	/**
	 * 默认编码格式
	 */
	private static final String DEFAULT_ENCODING = "UTF-8";
	//校验汉字
	public final static String REGEX_CHINESE = "\\p{InCJK Unified Ideographs}";		
	
	
	public static void main(String[] args) {
		try {

			String str = "abc";
			int endCount = 2;
			String replaceStr = "...";
			System.out.println(StringUtils.replaceStr(str, endCount, replaceStr));
			
			/*************************************************************************/
			
			String sb = "1,2,3,4,";
			System.out.println(StringUtils.delEndChar(sb));
			
			/*************************************************************************/
			
			String string = "abc";
			System.out.println(StringUtils.isIncludeChinese(string));
			
			/*************************************************************************/
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *<pre>
	 *方法体说明: 根据传入的字符串，超过指定范围的用指定字符替换
	 *应用场景: 当界面上的某一列只能容纳50个字符时，那么多余的字符就不需要显示，以免影响美观
	 *作者: 陈林林
	 *日期: 2013-8-14 上午10:26:46
	 *@param str	要处理的字符串， 例: abc
	 *@param endCount 结束范围值，超过则用指定字符代替， 例: 2
	 *@param replaceStr 代替的字符，例: ...
	 *@return
	 *@示例结果 ab...
	 *</pre>
	 */
	public static String replaceStr(String str, int endCount,
			String replaceStr) throws Exception {
		if (str == null || str.trim().equals("") || endCount <= 0 || endCount > str.length()) {
			return null;
		}
		return str.substring(0, endCount) + replaceStr;
	}
	
	/**
	 *<pre>
	 *方法体说明: 根据传入的字符串，删除最后一个字符 
	 *应用场景: 拼接字符串，比如拼接多个ID用逗号分隔
	 *作者: Vickey
	 *日期: 2013-8-14 下午01:59:56
	 *@param sb 传入的字符串, 例:abc,
	 *@return
	 *@throws Exception
	 *@示例结果 abc
	 *</pre>
	 */
	public static String delEndChar(String sb) throws Exception{
		if(sb == null || sb.trim().length() == 0){
			return null;
		}
		return sb.substring(0, sb.length()-1);
	}
	
	/**
	 *<pre>
	 *方法体说明: 判断字符串中是否包含汉字
	 *应用场景: 
	 *作者: Vickey
	 *日期: 2013-8-14 下午01:57:21
	 *@param str 传入的字符串, 例:abc中国 
	 *@return null: 输入数据不合法,true : 有中文,false : 无中文
	 *@throws Exception
	 *@示例结果 true
	 *</pre>
	 */
	public static Boolean isIncludeChinese(String str) throws Exception{
		if (str == null || str.trim().length() == 0) {
			return null;
		}
		String regex = REGEX_CHINESE;
		
		for (String s : str.split("")) {
			if (s.trim().length() > 0) {
				if(s.matches(regex)){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Function  : 检查字符串的格式
	 * @author   : bless<505629625@qq.com>
	 * @param str           ：  被检查的字符串
	 * @param isCN         ：  允许有中文
	 * @param isNum        ： 允许有数字
	 * @param isLetter     ： 允许有字母
	 * @param specialChars  :  允许有特殊字符,输入方式:假设允许下划线则参数为,"_"  假如允许下划线和问号则参数为,"_","?"
	 * example : 字母、数字、问号、句号和感叹号组成的字符串：isRealChar("xxxx",false,true,true,"?","。","!")
	 * @return   匹配则返回true,不匹配返回false
	 */
	public static boolean isRealChar(String str,boolean isCN,boolean isNum,boolean isLetter,String... specialChars){
		String regex_start = "^[";
		String regex_end = "]+$";
		
		if(isCN == true){
			regex_start = regex_start + "|\u4e00-\u9fa5";
		}if(isNum == true){
			regex_start = regex_start + "|0-9";
		}if(isLetter == true){
			regex_start = regex_start + "|a-zA-Z";
		}if(specialChars != null){
    		for(int i = 0;i<specialChars.length;i++){
    			regex_start = regex_start +"|"+specialChars[i];
    		}
    	}
		return match(regex_start+regex_end,str);
	}
	
	
	
	/**
	 * @param str
	 * @return
	 * author  : bless<505629625@qq.com>
	 * about version ：1.00
	 * create time   : 2011-2-22-下午04:37:22
	 * Description ： 验证邮箱的有效性
	 *         成功匹配则返回true
	 *         不匹配则返回false           
	 */
    public static boolean isEmail(String str) 
    {
    	//return str.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+") ;
        String regex = "^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$"; 
        return match(regex, str); 
    } 

    /**
     * @param str
     * @return
     * author  : bless<505629625@qq.com>
     * about version ：1.00
     * create time   : 2011-2-22-下午04:38:38
     * Description ：验证IP地址
     *         匹配返回true
     *         不匹配返回false
     */
    public static boolean isIP(String str) 
    { 
        String num = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)"; 
        String regex = "^" + num + "\\." + num + "\\." + num + "\\." + num + "$"; 
        return match(regex, str); 
    } 

    /**
     *  
     * @param str
     * @return
     * author  : bless<505629625@qq.com>
     * about version ：1.00
     * create time   : 2011-2-22-下午04:47:59
     * Description ： 校验网址(规则：以http://或https://开头)
     *         匹配则返回true
     *         不匹配则返回false
     */
    public static boolean isUrl(String str)
    { 
        String regex = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?"; 
        return match(regex, str); 
    } 

    /**
     * @param str
     * @return
     * author  : bless<505629625@qq.com>
     * about version ：1.00
     * create time   : 2011-2-22-下午04:49:46
     * Description ：验证是否是固定电话(规则：xxxx(区号，3或4位)-(连接线，必备)xxxxxx(电话，6到8位),如028-83035137)
     *         匹配则返回true
     *         不匹配则返回false              
     */
    public static boolean isTelephone(String str) 
    { 
        String regex = "^(\\d{3,4}-)?\\d{6,8}$"; 
        return match(regex, str); 
    } 

    /**
     * @param value
     * @return
     * author  : bless<505629625@qq.com>
     * about version ：1.00
     * create time   : 2011-2-22-下午04:51:00
     * Description ： 验证是否是手机号(规则：以1开头，接任意数字，11位)
     *         匹配则返回true
     *         不匹配则返回false
     */
    public static boolean isMobilePhone(String value)
    {
    	//String regex = "^[1]+[3,5]+\\d{9}$"; 
    	String regex = "^[1]+\\d{10}"; 
    	return value.matches(regex);
    } 
    
    /**
     * @param str
     * @return
     * author  : bless<505629625@qq.com>
     * about version ：1.00
     * create time   : 2011-2-22-下午05:01:02
     * Description ：邮编地址
     *         匹配则返回true
     *         不匹配则返回false
     */
    public static boolean isPostalcode(String str) 
    { 
        String regex = "^\\d{6}$"; 
        return match(regex, str); 
    } 

    /**
     * @param str
     * @return
     * author  : bless<505629625@qq.com>
     * about version ：1.00
     * create time   : 2011-2-22-下午05:03:46
     * Description ：验证15位或18位身份证号
     *         匹配则返回true
     *         不匹配则返回false
     */
    public static boolean isIDcard(String str) 
    { 
        String regex = "(^\\d{18}$)|(^\\d{15}$)"; 
        return match(regex, str); 
    } 

    /**
     * @param str     被验证数据
     * @param digit   验证长度：小数点后几位
     * @return
     * author  : bless<505629625@qq.com>
     * about version ：1.00
     * create time   : 2011-2-22-下午05:12:03
     * Description ： 验证是否符合指定位数的小数
     *         匹配则返回true
     *         不匹配则返回false
     */
    public static boolean isDecimal(String str,int digit) 
    { 
        String regex = "^[0-9]+(.[0-9]{"+digit+"})?$"; 
        return match(regex, str); 
    } 
    
    /** 
     * @param str
     * @return
     * author  : bless<505629625@qq.com>
     * about version ：1.00
     * create time   : 2011-2-22-下午05:18:49
     * Description ：验证是否是1~12月
     *         匹配则返回true
     *         不匹配则返回false
     */
    public static boolean isMonth(String str) 
    { 
        String regex = "^(0?[1-9]|1[0-2])$"; 
        return match(regex, str); 
    } 

    /**
     * @param str
     * @param sign  : 三种"+","-","all",分别表示正数、负数、正负都行,默认全部
     * @return
     * author  : bless<505629625@qq.com>
     * about version ：1.00
     * create time   : 2011-2-22-下午05:31:02
     * Description ：校验正负整数
     *         匹配则返回true
     *         不匹配则返回false
     */
    public static boolean isIntNumber(String str,String sign) 
    {
    	String regex = "";
    	if("+".equals(sign)){
    		regex = "^[+]?[0-9]*$";
    	}else if("-".equals(sign)){
    		regex = "^[-][0-9]*$";
    	}else{
    		regex = "^[+-]?[0-9]*$";
    	}
        return match(regex, str);
    } 
 

    /**
     * @param str
     * @return
     * author  : bless<505629625@qq.com>
     * about version ：1.00
     * create time   : 2011-2-22-下午05:38:38
     * Description ：验证大写字母
     *         匹配则返回true
     *         不匹配则返回false
     */
    public static boolean isUpChar(String str) 
    { 
        String regex = "^[A-Z]+$"; 
        return match(regex, str); 
    } 

    /**
     * @param str
     * @return
     * author  : bless<505629625@qq.com>
     * about version ：1.00
     * create time   : 2011-2-22-下午05:39:14
     * Description ： 验证小写字母
     *         匹配则返回true
     *         不匹配则返回false
     */
    public static boolean isLowChar(String str) 
    { 
        String regex = "^[a-z]+$"; 
        return match(regex, str); 
    } 

    /**
     * @param str
     * @return
     * author  : bless<505629625@qq.com>
     * about version ：1.00
     * create time   : 2011-2-22-下午05:39:57
     * Description ：验证输入的是字母
     *         匹配则返回true
     *         不匹配则返回false
     */
    public static boolean isLetter(String str) 
    { 
        String regex = "^[A-Za-z]+$"; 
        return match(regex, str); 
    } 

    /**
     * @param str
     * @param encoding : 编码格式,如GBK,   不输入默认为UTF-8
     * @return ：返回指定编码格式下字符串的长度
     * author  : bless<505629625@qq.com>
     * about version ：1.00
     * create time   : 2011-2-22-下午05:54:16
     * Description ：选择不同编码，返回字符串长度
     */
    public static int checkLength(String str,String encoding) {
        int length;
        try {
        	if(encoding == null||"".equals(encoding)){
        		length = str.getBytes(DEFAULT_ENCODING).length;
        	}else{
        		length = str.getBytes(encoding).length;
        	}
        } catch (UnsupportedEncodingException e) {
            length = str.getBytes().length;
        }
        return length;
    }
    


    
    /**
     * @param regex
     * @param str
     * @return
     * author  : bless<505629625@qq.com>
     * about version ：1.00
     * create time   : 2011-2-22-下午04:41:57
     * Description ： 正则表达式验证方法
     *         匹配表达式则返回true
     *         不匹配则返回false
     */
    private static boolean match(String regex, String str)
    { 
        Pattern pattern = Pattern.compile(regex); 
        Matcher matcher = pattern.matcher(str); 
        return matcher.matches(); 
    }

}
