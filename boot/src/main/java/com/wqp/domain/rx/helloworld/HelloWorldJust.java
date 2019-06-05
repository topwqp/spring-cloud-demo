package com.wqp.domain.rx.helloworld;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * @Description TODO
 * @Author Wang QiuPeng
 * Date 19/4/13 18:03
 **/
public class HelloWorldJust {
    public static void main(String args[]) {
        Observable.just("Hello world").map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return s + "  add handle ";
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println("final output is " + s);
            }
        });
    }
}
