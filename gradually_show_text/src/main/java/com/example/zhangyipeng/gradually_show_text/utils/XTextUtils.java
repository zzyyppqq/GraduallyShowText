package com.example.zhangyipeng.gradually_show_text.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhangyipeng on 16/3/16.
 */
public class XTextUtils {
    private static final String TAG = "XTextUtils";

    public static ArrayList<String> getContentList(String content) {
        ArrayList<String> list = new ArrayList<>();
        String s = "";
        String n = "";
        int sn = 0;
        content+=" ";
        int len = (content).length();

        for (int i = 0; i < len; i++) {

            char c = content.charAt(i);
            if (isEnglish(c + "")) {
                s += c;
                sn = 1;
            }else if (isNumber(c + "")) {
                n += c;
                sn = 2;
            } else {
                if (!s.equals("") && !n.equals("") & sn==1) {
                    list.add(n+s);

                }else if (!s.equals("") && !n.equals("") & sn==2) {
                    list.add(s+n);

                }else if (!s.equals("") && n.equals("")) {
                    list.add(s);
                }else if (!n.equals("") && s.equals("")) {
                    list.add(n);
                }
                list.add(c + "");
                sn = 0;
                n = "";
                s = "";

            }
        }
        return list;
    }

    public static boolean isEnglish(String s) {

        Pattern p = Pattern.compile("^[a-zA-Z]*$");
        Matcher m = p.matcher(s);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }


    public static boolean isNumber(String s) {

        Pattern p = Pattern.compile("^[0-9]*$");
        Matcher m = p.matcher(s);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isChinese(String s) {

        Pattern p = Pattern.compile("^[\\u4E00-\\u9FA5\\uF900-\\uFA2D]*$");
        Matcher m = p.matcher(s);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }
}