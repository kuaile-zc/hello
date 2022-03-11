package com.zc.leetcode;

/**
 * @author CoreyChen Zhang
 * @date 2022/3/1 16:46
 * @modified
 */
public class ConversionLetter {

    public String convert(String s, int numRows) {
        int length = s.length(), cur = 0, curRow = 0;
        char[] chars = s.toCharArray();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; ) {
            if (cur < length && curRow == 0) {
                result.append(chars[cur]);
                i++;
            }else if (cur < length && curRow  >= 0) {
                if (cur - curRow >= 0 && cur - curRow < length) {
                    result.append(chars[cur - curRow]);
                    i++;
                }
                if (cur + curRow >= 0 && cur + curRow < length) {
                    result.append(chars[cur + curRow]);
                    i++;
                }
            }else {
                cur = 0;
                curRow++;
                continue;
            }
            cur += (numRows-1)*2;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        ConversionLetter conversionLetter = new ConversionLetter();
        conversionLetter.convert("PAYPALISHIRING", 3);
    }
}
