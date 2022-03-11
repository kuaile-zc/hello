package com.zc.rxjava;

import rx.Observable;
import rx.Subscriber;

import java.util.Arrays;
import java.util.List;


/**
 * @author CoreyChen Zhang
 * @date 2022/3/3 14:44
 * @modified
 */
public class CreateTest {

    public static void main(String[] args) {
        final List<String> list = Arrays.asList(new String[]{"one","two","three"});

        Observable observable = Observable.create(new Observable.OnSubscribe<Object>() {
            @Override
            public void call(Subscriber<? super Object> subscriber) {

            }
        });
    }



}
