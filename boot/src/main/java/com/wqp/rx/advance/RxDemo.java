package com.wqp.rx.advance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * @Description Rx base operation
 * @Author Wang QiuPeng
 * Date 19/4/17 10:24
 **/
public class RxDemo {
    private static final Logger logger = LoggerFactory.getLogger(SimpleObserveExample.class);


    public static void main(String args[]){

        String value = "yc_log={\"no\":\"460110538842494\"}}&appkey=yiche&enc=0&ltype=view&";
        String keyPreFlag = "yc_log";


        String[]  array = value.split("\\&");
        Arrays.stream(array).filter(single -> single.startsWith(keyPreFlag)).forEach(s -> System.out.println(s));


        logger.info("-----------------just----------------------");
        just();
        logger.info("-----------------array----------------------");
        array();
        logger.info("------------------map---------------------");
        map();
        logger.info("------------------flatMap------------------");
        flatMap();
        logger.info("-------------------concatMap----------------");
        concatMap();
        logger.info("--------------------filter-------------------");
        filter();
        logger.info("---------------------distinct---------------");
        distinct();
        logger.info("---------------------buffer---------------");
        buffer();
        logger.info("---------------------skip---------------");
        skip();
        logger.info("---------------------skipLast---------------");
        skipLast();
        logger.info("---------------------take---------------");
        take();
        logger.info("---------------------takeLast---------------");
        takeLast();
        logger.info("---------------------defer---------------");
        defer();
        logger.info("---------------------last---------------");
        last();
        logger.info("---------------------merge---------------");
        merge();
        logger.info("---------------------reduce---------------");
        reduce();
    }

    public static void  just(){
         Observable<String> observable = Observable.just("Hello", "Rx java", "name wqp", "What's your name");
         observable.subscribe(s -> logger.info(s));
    }

    public static void  array(){
        String[] words = {"Hello", "Rx java", " name wqp", "What's your name"};
        Observable<String> observable = Observable.from(words);
        observable.subscribe(s -> logger.info(s));
    }


    public static  void map(){
        Observable<String> observable = Observable.just("Hello", "Rx java ", " name wqp ", "What's your name");
        observable.map(s -> "this result is " + s).subscribe(s -> logger.info(s));
    }

    public static void flatMap(){
        Observable.create((Observable.OnSubscribe<Integer>) subscriber -> {
            subscriber.onNext(1);
            subscriber.onNext(2);
            subscriber.onNext(3);
            subscriber.onNext(4);
        }).flatMap((Func1<Integer, Observable<?>>) integer -> {
            final List<String> list = new ArrayList();
            for (int i = 0; i < 5;i++){
                list.add("I am value  " + integer);
            }
            return Observable.from(list).delay(100,TimeUnit.MICROSECONDS);
        }).subscribe(s -> logger.info(s.toString()));
    }

    public static void concatMap(){
        Observable.create((Observable.OnSubscribe<Integer>) subscriber -> {
            subscriber.onNext(1);
            subscriber.onNext(2);
            subscriber.onNext(3);
            subscriber.onNext(4);
        }).concatMap((Func1<Integer, Observable<?>>) integer -> {
            final List<String> list = new ArrayList();
            for (int i = 0; i < 5;i++){
                list.add("I am value  " + integer);
            }
            return Observable.from(list);
        }).subscribe(s -> logger.info(s.toString()));
    }


    public static void filter(){
        Observable.just(1,2,3,4,5).filter(integer -> integer > 3).subscribe(integer -> logger.info("result is {}",integer));
    }


    public static void distinct(){
        Integer[] source = {1,2,3,4,5,2,3,6,7,3,8};
        Observable.from(source).distinct().subscribe(integer -> logger.info("result is {}",integer));
    }


    public static void buffer(){
        Integer[] source = {1,2,3,4,5,6};
        Observable.from(source).buffer(2).subscribe(integers -> {
            for (Integer integer : integers) {
                logger.info("accept: " + integer);
            }
            logger.info("accept:-------------->");
        });
    }


    public static void skip(){
        Integer[] source = {1,2,3,4,5,6};
        Observable.from(source).skip(2).subscribe((integer -> {
            logger.info("result is {} ",integer);
        }));
    }


    public static void skipLast(){
        Integer[] source = {1,2,3,4,5,6};
        Observable.from(source).skipLast(2).subscribe((integer -> {
            logger.info("result is {} ",integer);
        }));
    }

    public static void take(){
        Integer[] source = {1,2,3,4,5,6};
        Observable.from(source).take(2).subscribe((integer -> {
            logger.info("result is {} ",integer);
        }));
    }


    public static void takeLast(){
        Integer[] source = {1,2,3,4,5,6};
        Observable.from(source).takeLast(2).subscribe((integer -> {
            logger.info("result is {} ",integer);
        }));
    }

    public static void doOnEach(){
        Integer[] source = {1,2,3,4,5,6};
//        Observable.from(source).doOnEach().subscribe((integer -> {
//            logger.info("result is {} ",integer);
//        }));
    }

    public static  void defer(){
        Observable<Integer> observable = Observable.defer(() -> Observable.just(1,2,3,4));

        Observer observer =  new Observer() {
            @Override
            public void onCompleted() {
                logger.info("onComplete");
            }

            @Override
            public void onError(Throwable e) {
                logger.error("onError: {}",e.getMessage(),e);
            }

            @Override
            public void onNext(Object o) {
                logger.info("onNext: {}",o);

            }
        };
        observable.subscribe(observer);
        observable.subscribe(observer);
    }

    public static  void last(){
        Observable.just(1, 2, 3)
                .last()
                .subscribe(integer -> logger.info("result is {} ",integer));

    }

    public static void merge(){
        Observable<Integer> observable1 = Observable.just(1, 2, 3);
        Observable<Integer> observable2 = Observable.just(4, 5, 6);
        Observable.merge(observable1, observable2).subscribe(integer -> logger.info("result is {} ",integer));
    }


    public static void reduce(){
        Observable.just(1, 2, 3)
                .reduce((integer, integer2) -> integer + integer2).subscribe(integer -> logger.info("result is {} ",integer));
    }





}
