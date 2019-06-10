package com.wqp.domain.rx.helloworld;

import rx.Observable;

/**
 * @Description RX初探之Hello World
 * @Author Wang QiuPeng
 * Date 19/4/13 17:47
 **/
public class HelloWorld {
    public static void main(String args[]){
         hello("Tom","Bob");
    }

    public static void hello(String... names){
        Observable.from(names).subscribe(
                s -> System.out.println("hello " + s +" !")
        );
    }
}