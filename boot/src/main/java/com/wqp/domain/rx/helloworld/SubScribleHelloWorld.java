package com.wqp.domain.rx.helloworld;

import rx.Observable;
import rx.Subscriber;

/**
 * @Description TODO
 * @Author Wang QiuPeng
 * Date 19/4/13 17:52
 **/
public class SubScribleHelloWorld {
    public static void main(String args[]) {
        //观察者，订阅者
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("completed");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };

        //被观察者
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hello world");
                subscriber.onCompleted();
            }
        });

        //建立调用关系
        observable.subscribe(subscriber);

    }
}
