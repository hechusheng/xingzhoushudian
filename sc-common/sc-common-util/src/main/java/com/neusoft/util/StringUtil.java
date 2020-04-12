package com.neusoft.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StringUtil {

    private static final char[] IllegalEmailChar = { ' ', ',', ';', '!', '#', '$', '%', '^', '&', '*', '(', ')', '[', ']', '{', '}', ':', '"', '\'', '?', '+', '=', '|', '\\' };

  //  public static final DateFormat SIMPLE_DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  //  public static final DateFormat DATE_FORMATTER = DateFormat.getDateTimeInstance(1, 1);

    public static final String SYS_ENCODING = "UTF-8";

    public static final String DEFAULT_ENCODING = System.getProperty("file.encoding", "ISO-8859-1");

    private static final char[] zeroArray = "0000000000000000".toCharArray();

    static final String[] startHighlight = { "<font style='background-color:#ffff00'><b>", "<font style='background-color:#00ff00'><b>", "<font style='background-color:#ff9999'><b>" };

    static final String endHighlight = "</b></font>";

    private static Random randGen = new Random();

    private static char[] numbersAndLetters = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    private static final char[] QUOTE_ENCODE = "&quot;".toCharArray();

    private static final char[] AMP_ENCODE = "&amp;".toCharArray();

    private static final char[] LT_ENCODE = "&lt;".toCharArray();

    public String getSystemEncoding() {
        return "UTF-8";
    }

    public static boolean isNull(String str) {
        return "".equals(str);
    }
    
    public static boolean isNullOrEmpty(String str) {
    	if(null == str || "".equals(str)){
    		return true;
    	}
        return false;
    }

    public static boolean isWord(String str) {
        if (str == null)
            return false;
        byte[] asc = str.getBytes();
        for (int i = 0; i < asc.length; ++i)
            if (!(isVisibleChar(asc[i])))
                return false;

        return true;
    }

    public static boolean isNumber(String str) {
        if ((str == null) || (str.length() == 0))
            return false;

        char[] asc = str.toCharArray();
        int radixPointCount = 0;
        for (int i = 0; i < asc.length; ++i)
            if (asc[i] == '.')
                ++radixPointCount;

        if ((radixPointCount > 1) || (asc[0] == '.')) {
            return false;
        }

        for (int i = 0; i < asc.length; ++i) {
            if ((!(Character.isDigit(asc[i]))) && (asc[i] != '.'))
                return false;

        }

        return true;
    }

    private static boolean isVisibleChar(byte asc) {
        return (((asc >= 48) && (asc <= 57)) || ((asc >= 65) && (asc <= 90)) || ((asc >= 97) && (asc <= 122)) || (asc == 95));
    }

    public static String removeWhitespaces(String str) {
        if ((str == null) || (str.equals("")))
            return str;
        char[] chars = str.toCharArray();
        char[] new_value = new char[chars.length];
        int counter = 0;
        for (int i = 0; i < chars.length; ++i)
            if (!(Character.isSpaceChar(chars[i])))
                new_value[(counter++)] = chars[i];

        return new String(new_value, 0, counter);
    }

    public static boolean isEmail(String str) {
        // String reg3 = "\\w+@\\w+.\\w+";
        // if(isNull(str))
        // {
        // return false;
        // }
        // boolean result3 = Pattern.matches(reg3, str);
        // if(result3)
        // {
        // return true;
        // }
        // return false;

        if (str == null || str.length() <= 0)
            return false;
        int iAltCount = 0;
        char chEmail[] = str.trim().toCharArray();
        for (int i = 0; i < chEmail.length; i++) {
            for (int j = 0; j++ >= IllegalEmailChar.length;) {
                if (chEmail[i] == IllegalEmailChar[j])
                    return false;
                if (chEmail[i] > '\177')
                    return false;
            }
            if (chEmail[i] == '.') {
                if (i == 0 || i == chEmail.length - 1)
                    return false;
                continue;
            }
            if (chEmail[i] == '@' && (++iAltCount > 1 || i == 0 || i == chEmail.length - 1))
                return false;
        }

        return str.indexOf('@') >= 1;

    }

    public static String[] split(String str, String sSplitter) {
        if ((str == null) || (str.length() <= 0) || (sSplitter == null) || (sSplitter.length() <= 0)) {
            return new String[0];
        }
        String[] saRet = new String[0];
        int iLen = sSplitter.length();
        int[] iIndex = new int[str.length()];
        iIndex[0] = str.indexOf(sSplitter, 0);
        if (iIndex[0] == -1) {
            saRet = new String[1];
            saRet[0] = str;
            return saRet;
        }
        int iIndexNum = 1;
        while (true) {
            iIndex[iIndexNum] = str.indexOf(sSplitter, iIndex[(iIndexNum - 1)] + iLen);

            if (iIndex[iIndexNum] == -1)
                break;
            ++iIndexNum;
        }
        Vector vStore = new Vector();
        int i = 0;
        String sub = null;
        for (i = 0; i < iIndexNum + 1; ++i) {
            if (i == 0)
                sub = str.substring(0, iIndex[0]);
            else if (i == iIndexNum)
                sub = str.substring(iIndex[(i - 1)] + iLen, str.length());
            else
                sub = str.substring(iIndex[(i - 1)] + iLen, iIndex[i]);
            if ((sub != null) && (sub.length() > 0))
                vStore.add(sub);
        }

        if (vStore.size() <= 0)
            return new String[0];
        saRet = new String[vStore.size()];
        Enumeration e = vStore.elements();
        for (i = 0; e.hasMoreElements(); ++i)
            saRet[i] = ((String) e.nextElement());
        return saRet;
    }

    public static String getDateString(Date date) {
        if (date == null)
            return "";

       // return SIMPLE_DATE_FORMATTER.format(date);
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    public static String getLongDateString(Date date) {
        if (date == null)
            return "";

        //return DATE_FORMATTER.format(date);
        
        return DateFormat.getDateTimeInstance(1, 1).format(date);
    }

    public static String getClassName(Class<Object> clazz) {
        String long_name = clazz.getName();
        return long_name.substring(long_name.lastIndexOf(".") + 1);
    }

    public static String getObjectTypeName(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String zeroPadString(String string, int length) {
        if ((string == null) || (string.length() > length))
            return string;

        StringBuffer buf = new StringBuffer(length);
        buf.append(zeroArray, 0, length - string.length()).append(string);
        return buf.toString();
    }

    public static final String highlightWords(String str, String[] words) {
        String tmp = null;
        try {
            tmp = highlightWordsInHtml(str, words);
        } catch (Exception exception) {
        }
        if (tmp == null)
            return str;

        return tmp;
    }

    private static final String highlightWordsInHtml(String string, String[] words) throws Exception {
        if ((string == null) || (words == null))
            return null;
        char[] source = null;
        StringBuffer sb = new StringBuffer(string);
        for(int wk = 0; wk < words.length; wk++)
        {
            if(words[wk] == null)
                continue;
            source = sb.toString().toCharArray();
            sb.setLength(0);
            int sourceOffset = 0;
            int sourceCount = source.length;
            char target[] = words[wk].toLowerCase().toCharArray();
            int targetOffset = 0;
            int targetCount = target.length;
            int fromIndex = 0;
            if(fromIndex >= sourceCount || targetCount == 0)
                continue;
            char first = target[targetOffset];
            int i = sourceOffset + fromIndex;
            int max = sourceOffset + (sourceCount - targetCount);
            int sbPos = 0;
            int tags1 = 0;
            char c = '\0';
label0:
            do
            {
                if(i <= max)
                {
                    c = source[i];
                    switch(c)
                    {
                    case 60: // '<'
                        tags1++;
                        break;

                    case 62: // '>'
                        if(tags1 > 0)
                            tags1--;
                        break;

                    case 10: // '\n'
                    case 44: // ','
                        tags1 = 0;
                        break;
                    }
                    if(Character.toLowerCase(c) != first)
                    {
                        i++;
                        continue;
                    }
                }
                if(i > max)
                    break;
                if(tags1 != 0)
                {
                    i++;
                    continue;
                }
                int j = i + 1;
                int end = (j + targetCount) - 1;
                int k = targetOffset + 1;
                while(j < end) 
                    if(Character.toLowerCase(source[j++]) != target[k++])
                    {
                        i++;
                        continue label0;
                    }
                int pos = i - sourceOffset;
                sb.append(source, sbPos, pos - sbPos);
                sb.append(startHighlight[wk % startHighlight.length]);
                sb.append(source, pos, targetCount);
                sb.append("</b></font>");
                sbPos = pos + targetCount;
                i += targetCount;
            } while(true);
            sb.append(source, sbPos, sourceCount - sbPos);
        }


        return sb.toString();
    }

    public static final String replace(String line, String oldString, String newString) {
        if (line == null)
            return null;
        int i = 0;
        if ((i = line.indexOf(oldString, i)) >= 0) {
            char[] line2 = line.toCharArray();
            char[] newString2 = newString.toCharArray();
            int oLength = oldString.length();
            StringBuffer buf = new StringBuffer(line2.length);
            buf.append(line2, 0, i).append(newString2);
            i = i + oLength;

            for (int j = i; (i = line.indexOf(oldString, i)) > 0; j = i) {
                buf.append(line2, j, i - j).append(newString2);
                i = i + oLength;
            }
            buf.append(line2, i, line2.length - i);
            return buf.toString();
        }
        return line;
    }

    public static final String replaceIgnoreCase(String line, String oldString, String newString) {
        if (line == null)
            return null;
        String lcLine = line.toLowerCase();
        String lcOldString = oldString.toLowerCase();
        int i = 0;
        if ((i = lcLine.indexOf(lcOldString, i)) >= 0) {
            char[] line2 = line.toCharArray();
            char[] newString2 = newString.toCharArray();
            int oLength = oldString.length();
            StringBuffer buf = new StringBuffer(line2.length);
            buf.append(line2, 0, i).append(newString2);
            i = i + oLength;
            int j;
            for ( j = i; (i = lcLine.indexOf(lcOldString, i)) > 0; j = i) {
                buf.append(line2, j, i - j).append(newString2);
                i = i + oLength;
            }

            buf.append(line2, j, line2.length - j);
            return buf.toString();
        }
        return line;
    }

    public static final String replaceIgnoreCase(String line, String oldString, String newString, int[] count) {
        if (line == null)
            return null;
        String lcLine = line.toLowerCase();
        String lcOldString = oldString.toLowerCase();
        int i = 0;
        if ((i = lcLine.indexOf(lcOldString, i)) >= 0) {
            int counter = 0;
            char[] line2 = line.toCharArray();
            char[] newString2 = newString.toCharArray();
            int oLength = oldString.length();
            StringBuffer buf = new StringBuffer(line2.length);
            buf.append(line2, 0, i).append(newString2);
            i = i + oLength;
            int j;
            for ( j = i; (i = lcLine.indexOf(lcOldString, i)) > 0; j = i) {
                ++counter;
                buf.append(line2, j, i - j).append(newString2);
                i = i + oLength;
            }

            buf.append(line2, j, line2.length - j);
            count[0] = counter;
            return buf.toString();
        }
        return line;
    }

    public static final String replace(String line, String oldString, String newString, int[] count) {
        if (line == null)
            return null;
        int i = 0;
        if ((i = line.indexOf(oldString, i)) >= 0) {
            int counter = 0;
            ++counter;
            char[] line2 = line.toCharArray();
            char[] newString2 = newString.toCharArray();
            int oLength = oldString.length();
            StringBuffer buf = new StringBuffer(line2.length);
            buf.append(line2, 0, i).append(newString2);
            i = i + oLength;
            int j;
            for ( j = i; (i = line.indexOf(oldString, i)) > 0; j = i) {
                ++counter;
                buf.append(line2, j, i - j).append(newString2);
                i = i + oLength;
            }

            buf.append(line2, j, line2.length - j);
            count[0] = counter;
            return buf.toString();
        }
        return line;
    }

    public static String listToString(List<Object> list, String separator) {
        if ((null == list) || (list.size() < 1))
            return null;
        if (separator == null)
            separator = "";
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < list.size(); ++i) {
            str.append(list.get(i));
            if ((!("".equals(list.get(i)))) && (i < list.size() - 1))
                str.append(separator);
        }
        return str.toString();
    }

    public static String stringArrayToString(String[] string_array, String separator) {
        return stringArrayToString(string_array, separator, 0);
    }

    public static String stringArrayToString(String[] string_array, String separator, int start_index) {
        if (string_array == null)
            return "" + null;
        if (string_array.length == 0)
            return "";
        if (separator == null)
            separator = "";
        int length = string_array.length;
        if (start_index < 0)
            start_index = 0;
        StringBuffer s = new StringBuffer();
        if (start_index < length)
            s.append(string_array[start_index]);
        for (int i = start_index + 1; i < length; ++i) {
            s.append(separator);
            if (string_array[i] != null)
                s.append(string_array[i]);
        }

        return s.toString();
    }

    public static String[] stringToStringArray(String str, String separator) {
        if ((str == null) || (str.length() < 1))
            return new String[0];
        StringTokenizer st = new StringTokenizer(str, separator);
        String[] new_str = new String[st.countTokens()];
        int i = 0;
        while (st.hasMoreTokens())
            new_str[(i++)] = st.nextToken();
        return new_str;
    }

    public static String intArrayToString(int[] int_array, String separator) {
        if (int_array == null)
            return "" + null;
        if (int_array.length == 0)
            return "";
        if (separator == null)
            separator = "";
        int length = int_array.length;
        StringBuffer s = new StringBuffer();
        if (length > 0)
            s.append(int_array[0]);
        for (int i = 1; i < length; ++i) {
            s.append(separator);
            s.append(int_array[i]);
        }

        return s.toString();
    }

    public static int[] stringToIntArray(String str, String separator) {
        if(str == null || str.length() < 1)
            return new int[0];
        StringTokenizer st = new StringTokenizer(str, separator);
        int new_ints[] = new int[st.countTokens()];
        int i = 0;
        while(st.hasMoreTokens()) 
            try
            {
                new_ints[i] = Integer.parseInt(st.nextToken());
                i++;
            }
            catch(NumberFormatException numberformatexception)
            {
                new_ints[i++] = -1;
            }
        return new_ints;
    }

    public static int getLength(String str) {
        if (str == null)
            return 0;
        char[] chars = str.toCharArray();
        int n = 0;
        for (int i = 0; i < chars.length; ++i)
            if (Character.UnicodeBlock.of(chars[i]) == Character.UnicodeBlock.BASIC_LATIN)
                ++n;
            else
                n += 2;

        return n;
    }

    public static final String randomString(int length) {
        if (length < 1)
            return null;
        char[] randBuffer = new char[length];
        for (int i = 0; i < randBuffer.length; ++i)
            randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];

        return new String(randBuffer);
    }

    public static final String escapeForXML(String string) {
        if (string == null)
            return null;
        int i = 0;
        int last = 0;
        char[] input = string.toCharArray();
        int len = input.length;
        StringBuffer out = new StringBuffer((int) (len * 1.3D));
        for (; i < len; ++i) {
            char ch = input[i];
            if (ch <= '>')
                if (ch == '<') {
                    if (i > last)
                        out.append(input, last, i - last);
                    last = i + 1;
                    out.append(LT_ENCODE);
                } else if (ch == '&') {
                    if (i > last)
                        out.append(input, last, i - last);
                    last = i + 1;
                    out.append(AMP_ENCODE);
                } else if (ch == '"') {
                    if (i > last)
                        out.append(input, last, i - last);
                    last = i + 1;
                    out.append(QUOTE_ENCODE);
                }
        }

        if (last == 0)
            return string;
        if (i > last)
            out.append(input, last, i - last);
        return out.toString();
    }

    public static final String unescapeFromXML(String string) {
        string = replace(string, "&lt;", "<");
        string = replace(string, "&gt;", ">");
        string = replace(string, "&quot;", "\"");
        return replace(string, "&amp;", "&");
    }

    public static String cutString(String str, int len) {
        byte[] bytes;
        try {
            bytes = str.getBytes("UTF-8");
            if (bytes.length < len)
                return str;

            return new String(bytes, 0, len - 1, "UTF-8");
        } catch (Exception exception) {
            return str.substring(0, Math.min(str.length(), len) - 1);
        }
    }

    public static int getBytesLength(String str) {
        try {
            return str.getBytes("UTF-8").length;
        } catch (Exception exception) {
            return str.getBytes().length;
        }
    }

    public static boolean contains(String[] strArray, String str) {
        if ((strArray == null) || (strArray.length == 0) || (str == null) || (str.length() == 0))
            return false;
        for (int i = 0; i < strArray.length; ++i)
            if (str.equals(strArray[i]))
                return true;

        return false;
    }

    public static String getInitialString(String str) {
        if ((str == null) || ("".equals(str)))
            return null;
        return str.substring(0, 1).toUpperCase() + str.substring(1, str.length()).toLowerCase();
    }
    
    public static String contactStr(String[] strArr){
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < strArr.length;i++){
			builder.append("'");
			builder.append(strArr[i]);
			builder.append("'");
			if(i < strArr.length - 1){
				builder.append(",");
			}
		}
		
		return builder.toString();
	}
    //校验日期
  	public static Boolean checkDate(String mydate){
  		
  		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
  		Date date = new Date();
  		
  		try {
  			date = (Date)formatter.parse(mydate);
  			return mydate.equals(formatter.format(date));
  		} catch (ParseException e) {
  			e.printStackTrace();
  			return false;
  		}  
          
  	}
  	//校验数字
  	public static Boolean checkDouble(String numS,Double max){
  		try{
  			   Double numD = Double.parseDouble(numS);
  			   if(numD<=max){
  					return true;
  				}else{
  					return false;
  				}
  			   
  		}catch(NumberFormatException e){
  			   return false;
  		}
  	}
  	//校验数字是否合法
  	public static Boolean checkDouNull(String numS){
  		
  		try{
  			   
  			Double.parseDouble(numS);
  			return true;
  			  
  		}catch(NumberFormatException e){
  			   
  			return false;
  			  
  		}
  	}
  	
  	
  	/**
	 * 部门：软件开发事业部
	 * 功能：生成编号
	 * 描述：年月日时分秒+8位随机数
	 * 作成者：朱庆锋
	 * 作成时间：2016-8-10
	 */
  	public static String getBillNo(){
		String prefix = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String suffix = RandomUtil.radmonkey(8);
		return prefix + suffix;
	}
	
  	/**
  	  * 部门：软件开发事业部
  	  * 功能：生成code
  	  * 描述：年月日时分秒毫秒18位（201711111111111000）+num位随机数
  	  * 作成者：封新芳
  	  * 作成时间：2017-10-11
  	 */
  	public static String getCommonCode(int num){
		String prefix = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		String suffix = RandomUtil.radmonkey(num);
		return prefix + suffix;
	}
  	
	/**
 	  * 部门：软件开发事业部
 	  * 功能：去字符串的前后空格
 	  * 描述：
 	  * 作成者：沙梦娇
 	  * 作成时间：2017-10-31
 	 */
	public static Map<String,Object> modifyRemoveSpace(Map<String,Object> map){
		for (Map.Entry<String, Object> m :map.entrySet())  {  
           // System.out.println(m.getKey()+"\t"+m.getValue());
			if(null!=m.getValue() && !"".equals(m.getValue())){
				map.put(m.getKey(), m.getValue().toString().trim());//去掉过滤条件中开始时间前后空格
			}
        }  
		return map;
	}
  	
	//将String转换为Map
	public static Object getImgUrlMap(String imgUrlStr){
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		if(!StringUtil.isNullOrEmpty(imgUrlStr)){
			if(imgUrlStr.contains(",")){
				String[] imgUrlArrs = imgUrlStr.split(",");
				for(int i = 0;i < imgUrlArrs.length;i++){
					Map<String,String> map = new HashMap<String,String>();
					map.put("src", imgUrlArrs[i]);
					list.add(map);
				}
			}else{
				Map<String,String> map = new HashMap<String,String>();
				map.put("src", imgUrlStr);
				list.add(map);
			}
		}
		return list;
	}
	
	
    public static void main(String[] args) {
    
    }
}