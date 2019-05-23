package com.zc.Lambdas.stream.optional;

import java.util.Optional;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2019-05-22 20:53
 */
public class Main {
    public static void main(String[] args) {

    }

    public String getCarInsurance(Optional<Person> person){
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }
}
