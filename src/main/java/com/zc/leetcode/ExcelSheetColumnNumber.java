package com.zc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CoreyChen Zhang
 * @date 2021/7/30 20:28
 * @modified
 */
public class ExcelSheetColumnNumber {

    public int titleToNumber(String columnTitle) {
        int length = columnTitle.length();
        int base = 1, result = 0;
        for (int i = 1; i <= length; i++) {
            char c = columnTitle.charAt(length - i);
            result +=  (c - 'A' + 1) * base;
            base *= 26;
        }
        return result;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber excelSheetColumnNumber = new ExcelSheetColumnNumber();
        excelSheetColumnNumber.titleToNumber("AA");
    }
}
