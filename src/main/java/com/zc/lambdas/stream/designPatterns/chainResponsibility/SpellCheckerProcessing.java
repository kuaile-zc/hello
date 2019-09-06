package com.zc.lambdas.stream.designPatterns.chainResponsibility;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2019-05-09 20:38
 */
public class SpellCheckerProcessing extends ProcessingObject<String> {
    @Override
    protected String handWork(String text) {
        return text.replaceAll("labda","lambda");
    }
}
