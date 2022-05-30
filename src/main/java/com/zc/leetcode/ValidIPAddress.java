package com.zc.leetcode;

/**
 * @author corey
 * @creat 2022/5/29 17:51
 * @describe https://leetcode.cn/problems/validate-ip-address/
 */
public class ValidIPAddress {

    public static void main(String[] args) {
        ValidIPAddress validIPAddress = new ValidIPAddress();
        validIPAddress.validIPAddress("11.4.5.6.1.");
    }

    public String validIPAddress(String queryIP) {
        if (isIPV4(queryIP)) {
            return "IPv4";
        }else if (isIPV6(queryIP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean isIPV4 (String ip) {
        boolean result = true;
        int last = -1;
        for (int i = 0; i < 4; i++) {
            int cur = (i == 3 ? ip.length() : ip.indexOf('.', last + 1));
            if (cur < 0) {
                return false;
            }
            if (cur - last - 1 < 1 || cur - last - 1 > 3) {
                return false;
            }
            String s = ip.substring(last == -1 ? 0 : last, cur);
            if (!s.matches("\\d{1,3}") || s.charAt(0) == '0' || Integer.parseInt(s) < 0 || Integer.parseInt(s) > 255) {
                return false;
            }
            last = cur;
        }
        return result;
    }

    private boolean isIPV6 (String ip) {
        boolean result = true;
        int last = -1;
        for (int i = 0; i < 8; i++) {
            int cur = (i == 7 ? ip.length() : ip.indexOf(':', last + 1));
            if (cur < 0) {
                result = false;
            }
            if (cur - last - 1 < 1 || cur - last - 1 > 4) {
                result = false;
            }
            for (int j = last + 1; j < cur; ++j) {
                if (!Character.isDigit(ip.charAt(j)) && !('a' <= Character.toLowerCase(ip.charAt(j)) && Character.toLowerCase(ip.charAt(j)) <= 'f')) {
                    result = false;
                }
            }
            last = cur;
        }
        return result;
    }

}
