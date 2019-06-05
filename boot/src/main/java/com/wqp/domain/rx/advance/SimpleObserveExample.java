package com.wqp.domain.rx.advance;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;
import rx.Observer;

/**
 * @Description simple demo
 * RxJava就是Java对Rx的实现，一个在JVM上使用可观测的序列来组成异步的、基于事件的程序的库。
 * Observer即观察者，它决定事件触发的时候将有怎样的行为
 * @Author Wang QiuPeng
 * Date 19/4/16 09:06
 **/
public class SimpleObserveExample  {
    private static final Logger logger = LoggerFactory.getLogger(SimpleObserveExample.class);

    public static void main(String args[]){

        Observer<String> observer = new Observer<String>() {

            /**
             * onNext：普通的事件
             * @param
             */
            @Override
            public void onNext(String s) {
                if ("error".equalsIgnoreCase(s)){
                    throw new RuntimeException("occur error");
                }else{
                    logger.info("onNext: " + s);
                }

            }

            /**
             * 事件队列完成
             */
            @Override
            public void onCompleted() {

                logger.info("final onComplete ");
            }

            /**
             * 事件队列异常，在事件处理过程中出现异常情况时，此方法会被调用。同时队列将会终止，也就是不允许再有事件发出。
             * @param throwable
             */
            @Override
            public void onError(Throwable throwable) {
                logger.info("onError: " + throwable);
            }
        };
        Observable<String> observable = Observable.just("Hello", "Rx java", "error", "What's your name");
        //Observable.defer();

        observable.subscribe(observer);
    }

}
