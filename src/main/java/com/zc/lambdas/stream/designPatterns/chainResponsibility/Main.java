package com.zc.lambdas.stream.designPatterns.chainResponsibility;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2019-05-09 20:39
 */
public class Main {
    public static void main(String[] args) {
        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();

        p1.setSuccessor(p2);
        String result = p1.handle("Aren't labdas really sexy?!!");
        System.out.println(result);
    }
}
