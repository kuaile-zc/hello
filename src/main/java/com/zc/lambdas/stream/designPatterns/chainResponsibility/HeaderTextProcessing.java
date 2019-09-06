package com.zc.lambdas.stream.designPatterns.chainResponsibility;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2019-05-09 20:36
 */
public class HeaderTextProcessing extends ProcessingObject<String> {
    @Override
    protected String handWork(String test) {
        return "From Raoul, Mario and Alan: "+test;
    }
}
