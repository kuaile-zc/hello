package com.zc.Lambdas.CreatBufferedReader;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 描述:
 *
 * @author zc
 * @create 2019-03-06 20:54
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader b ) throws IOException;
}
