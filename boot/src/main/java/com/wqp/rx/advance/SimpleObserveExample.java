package com.wqp.rx.advance;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
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

    Observer<String> observer = new Observer<String>() {
        /**
         * 在事件还未发送之前被调用，可以用来做一些准备操作。里面的Disposable则是用来切断上下游关系的。
         * @param disposable
         */
        @Override
        public void onSubscribe(Disposable disposable) {
            logger.info("onSubscribe: " + disposable);
        }

        /**
         * onNext：普通的事件
         * @param s
         */
        @Override
        public void onNext(String s) {
            logger.info("onNext: " + s);
        }

        /**
         * 事件队列异常，在事件处理过程中出现异常情况时，此方法会被调用。同时队列将会终止，也就是不允许再有事件发出。
         * @param throwable
         */
        @Override
        public void onError(Throwable throwable) {
            logger.info("onError: " + throwable);
        }

        /**
         * 事件队列完成
         */
        @Override
        public void onComplete() {
            logger.info("onComplete: ");
        }
    };

    Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
        @Override
        public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
            observableEmitter.onNext("Hello");
            observableEmitter.onNext("Rxjava2");
            observableEmitter.onNext("My name is Silence");
            observableEmitter.onNext("What's your name");
            observableEmitter.onComplete();
        }
    });
}
