package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.utils;

import android.annotation.SuppressLint;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式判断手机号、邮箱、身份证号码、密码、Url、邮编等工具类
 * Created by lenovo on 2017/3/30.
 */

public class RegexUtils {
    private static Log log;

    /**
     * 判断手机号码是否合法
     *
     * @param mobiles
     * @return
     */
    public static boolean checkMobile(String mobiles) {
        if (null == mobiles || "".equals(mobiles))
            return false;
        Pattern p = Pattern
                .compile("^((13[0-9])|(15[^4,\\D])|(17[0])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 验证固定电话号码
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkPhone(String phone) {
        String regex = "(\\+\\d+)?(\\d{3,4}\\-?)?\\d{7,8}$";
        return Pattern.matches(regex, phone);
    }
    /**
     * 验证中文名称
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkZhongwenMingChen(String phone) {
        String regex = "/^[\\u4E00-\\u9FA5]{1,6}$/";
        return Pattern.matches(regex, phone);
    }

    /**
     * 验证营业执照
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkYenYeZhiZHao(String phone) {
        String regex = "\\d{15}";
        return Pattern.matches(regex, phone);
    }

    /**
     * 验证验证码
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkYenZenMa(String phone) {
        String regex = "[a-zA-Z]";
        return Pattern.matches(regex, phone);
    }

    /**
     * 验证整数（正整数和负整数）
     *
     * @param digit
     *            一位或多位0-9之间的整数
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkDigit(String digit) {
        String regex = "\\-?[1-9]\\d+";
        return Pattern.matches(regex, digit);
    }

    /**
     * 验证整数和浮点数（正负整数和正负浮点数）
     *
     * @param decimals
     *            一位或多位0-9之间的浮点数，如：1.23，233.30
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkDecimals(String decimals) {
        String regex = "\\-?[1-9]\\d+(\\.\\d+)?";
        return Pattern.matches(regex, decimals);
    }

    /**
     * 验证空白字符
     *
     * @param blankSpace
     *            空白字符，包括：空格、\t、\n、\r、\f、\x0B
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkBlankSpace(String blankSpace) {
        String regex = "\\s+";
        return Pattern.matches(regex, blankSpace);
    }

    /**
     * 验证中文
     *
     * @param chinese
     *            中文字符
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkChinese(String chinese) {
        String regex = "^[\u4E00-\u9FA5]+$";
        return Pattern.matches(regex, chinese);
    }

    /**
     * 验证URL地址
     *
     * @param url
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkURL(String url) {
        String regex = "(https?://(w{3}\\.)?)?\\w+\\.\\w+(\\.[a-zA-Z]+)*(:\\d{1,5})?(/\\w*)*(\\??(.+=.*)?(&.+=.*)?)?";
        return Pattern.matches(regex, url);
    }

    /**
     * 获取网址 URL 的一级域名
     * @param url
     * @return
     */
    public static String getDomain(String url) {
        Pattern p = Pattern.compile(
                "(?<=http://|\\.)[^.]*?\\.(com|cn|net|org|biz|info|cc|tv)",
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(url);
        matcher.find();
        return matcher.group();
    }

    /**
     * 匹配中国邮政编码
     *
     * @param postcode
     *            邮政编码
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkPostcode(String postcode) {
        String regex = "[1-9]\\d{5}";
        return Pattern.matches(regex, postcode);
    }

    /**
     * 判断邮箱是否合法
     *
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        if (null == email || "".equals(email))
            return false;
        Pattern p = Pattern
                .compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");// 复杂匹配
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * 判断密码： 6-20 位，字母、数字、字符
     *
     * @return
     */
    public static boolean checkPassword(String pwdString) {
        if (null == pwdString || "".equals(pwdString))
            return false;
        Pattern p = Pattern.compile("^([A-Z]|[a-z]|[0-9]|[`~!@#$%^&*()+=|{}':;',\\\\\\\\[\\\\\\\\].~！@#￥%……&*]){6,20}$");
        Matcher m = p.matcher(pwdString);
        return m.matches();
    }

    /**
     * 判断IP地址格式和范围
     *
     * @return
     */
    public static boolean checkIP(String ip) {
        if (ip.length() < 7 || ip.length() > 15 || "".equals(ip))
            return false;
        Pattern p = Pattern
                .compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}");
        Matcher mat = p.matcher(ip);
        return mat.find();
    }

    /**
     * 功能：身份证的有效验证
     *
     * @param IDStr
     *            身份证号
     * @return 有效：true 无效：false
     * @throws java.text.ParseException
     * @throws NumberFormatException
     * @throws java.text.ParseException
     */
    @SuppressLint("SimpleDateFormat")
    public boolean IDCardValidate(String IDStr) throws NumberFormatException,
            java.text.ParseException {
        String errorInfo = "";// 记录错误信息
        String[] ValCodeArr = { "1", "0", "x", "9", "8", "7", "6", "5", "4",
                "3", "2" };
        String[] Wi = { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7",
                "9", "10", "5", "8", "4", "2" };
        String Ai = "";

        // ================ 号码的长度 15位或18位 ================
        if (IDStr.length() != 15 && IDStr.length() != 18) {
            errorInfo = "号码长度应该为15位或18位。";
            System.out.println(errorInfo);
            return false;
        }

        // ================ 数字 除最后以外都为数字 ================
        if (IDStr.length() == 18) {
            Ai = IDStr.substring(0, 17);
        } else if (IDStr.length() == 15) {
            Ai = IDStr.substring(0, 6) + "19" + IDStr.substring(6, 15);
        }
        if (isNumeric(Ai) == false) {
            errorInfo = "15位号码都应为数字 ; 18位号码除最后一位外，都应为数字。";
            System.out.println(errorInfo);
            return false;
        }

        // ================ 出生年月是否有效 ================
        String strYear = Ai.substring(6, 10);// 年份
        String strMonth = Ai.substring(10, 12);// 月份
        String strDay = Ai.substring(12, 14);// 月份

        if (this.isDate(strYear + "-" + strMonth + "-" + strDay) == false) {
            errorInfo = "生日无效。";
            System.out.println(errorInfo);
            return false;
        }

        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150
                || (gc.getTime().getTime() - s.parse(
                strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {
            errorInfo = "生日不在有效范围。";
            System.out.println(errorInfo);
            return false;
        }
        if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {
            errorInfo = "月份无效";
            System.out.println(errorInfo);
            return false;
        }
        if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {
            errorInfo = "日期无效";
            System.out.println(errorInfo);
            return false;
        }

        // ================ 地区码是否有效 ================
        @SuppressWarnings("rawtypes")
        Hashtable h = GetAreaCode();
        if (h.get(Ai.substring(0, 2)) == null) {
            errorInfo = "地区编码错误。";
            System.out.println(errorInfo);
            return false;
        }

        // ================ 判断最后一位的值 ================
        int TotalmulAiWi = 0;
        for (int i = 0; i < 17; i++) {
            TotalmulAiWi = TotalmulAiWi
                    + Integer.parseInt(String.valueOf(Ai.charAt(i)))
                    * Integer.parseInt(Wi[i]);
        }
        int modValue = TotalmulAiWi % 11;
        String strVerifyCode = ValCodeArr[modValue];
        Ai = Ai + strVerifyCode;

        if (IDStr.length() == 18) {
            if (Ai.equals(IDStr) == false) {
                errorInfo = "身份证无效，最后一位字母错误";
                System.out.println(errorInfo);
                return false;
            }
        } else {
            System.out.println("所在地区:" + h.get(Ai.substring(0, 2).toString()));
            System.out.println("新身份证号:" + Ai);
            return true;
        }
        System.out.println("所在地区:" + h.get(Ai.substring(0, 2).toString()));
        return true;
    }

    /**
     * 功能：设置地区编码
     *
     * @return Hashtable 对象
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private Hashtable GetAreaCode() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("11", "北京");
        hashtable.put("12", "天津");
        hashtable.put("13", "河北");
        hashtable.put("14", "山西");
        hashtable.put("15", "内蒙古");
        hashtable.put("21", "辽宁");
        hashtable.put("22", "吉林");
        hashtable.put("23", "黑龙江");
        hashtable.put("31", "上海");
        hashtable.put("32", "江苏");
        hashtable.put("33", "浙江");
        hashtable.put("34", "安徽");
        hashtable.put("35", "福建");
        hashtable.put("36", "江西");
        hashtable.put("37", "山东");
        hashtable.put("41", "河南");
        hashtable.put("42", "湖北");
        hashtable.put("43", "湖南");
        hashtable.put("44", "广东");
        hashtable.put("45", "广西");
        hashtable.put("46", "海南");
        hashtable.put("50", "重庆");
        hashtable.put("51", "四川");
        hashtable.put("52", "贵州");
        hashtable.put("53", "云南");
        hashtable.put("54", "西藏");
        hashtable.put("61", "陕西");
        hashtable.put("62", "甘肃");
        hashtable.put("63", "青海");
        hashtable.put("64", "宁夏");
        hashtable.put("65", "新疆");
        hashtable.put("71", "台湾");
        hashtable.put("81", "香港");
        hashtable.put("82", "澳门");
        hashtable.put("91", "国外");
        return hashtable;
    }

    /**
     *
     * 功能：判断字符串是否为数字
     *
     * @param str
     * @return
     */
    private static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (isNum.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * 功能：判断字符串是否为日期格式
     *
     * @return
     */
    public boolean isDate(String strDate) {
        Pattern pattern = Pattern
                .compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
        Matcher m = pattern.matcher(strDate);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * 功能:在判定已经是正确的身份证号码之后,查找出身份证所在地区 idCard 身份证号码 所在地区
     */
    @SuppressWarnings("unchecked")
    public String GetArea(String idCard) {
        Hashtable<String, String> ht = GetAreaCode();
        String area = ht.get(idCard.substring(0, 2));
        return area;
    }

    /**
     * 功能:在判定已经是正确的身份证号码之后,查找出此人性别 idCard 身份证号码 男或者女
     */
    public String GetSex(String idCard) {
        String sex = "";
        if (idCard.length() == 15)
            sex = idCard.substring(idCard.length() - 3, idCard.length());

        if (idCard.length() == 18)
            sex = idCard.substring(idCard.length() - 4, idCard.length() - 1);

        System.out.println(sex);
        int sexNum = Integer.parseInt(sex) % 2;
        if (sexNum == 0) {
            return "女";
        }
        return "男";
    }

    /**
     * 功能:在判定已经是正确的身份证号码之后,查找出此人出生日期 idCard 身份证号码 出生日期 XXXX MM-DD
     */
    public String GetBirthday(String idCard) {
        String Ain = "";
        if (idCard.length() == 18) {
            Ain = idCard.substring(0, 17);
        } else if (idCard.length() == 15) {
            Ain = idCard.substring(0, 6) + "19" + idCard.substring(6, 15);
        }

        // ================ 出生年月是否有效 ================
        String strYear = Ain.substring(6, 10);// 年份
        String strMonth = Ain.substring(10, 12);// 月份
        String strDay = Ain.substring(12, 14);// 日期
        return strYear + "-" + strMonth + "-" + strDay;
    }

    /**
     *
     * 功能：判断银行卡是否正确
     *

     // 这个只能简单判断银行卡格式
     // 银行卡有可能是16位也有可能是19位
     /^\d{16}|\d{19}$/

     // 如果你只要带空格的16位
     /^\d{4}(?:\s\d{4}){3}$/


     * @return
     */
    public static boolean isYenhang(String strDate) {
        Pattern pattern = Pattern
                .compile("/^\\d{16}|\\d{19}$/");
        Matcher m = pattern.matcher(strDate);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }

}
