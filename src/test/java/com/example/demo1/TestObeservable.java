//package com.example.demo1;
//
//import io.reactivex.*;
//import io.reactivex.disposables.Disposable;
//import io.reactivex.functions.Action;
//import io.reactivex.functions.Consumer;
//import io.reactivex.functions.Function;
//import io.reactivex.functions.Predicate;
//import io.reactivex.observables.ConnectableObservable;
//import io.reactivex.observables.GroupedObservable;
//import io.reactivex.schedulers.Schedulers;
//import org.assertj.core.util.Lists;
//import org.junit.Test;
//import rx.Observable;
//import rx.Observer;
//
//import java.util.List;
//import java.util.concurrent.*;
//import java.util.concurrent.atomic.AtomicInteger;
//
//
//public class TestObeservable {
//
//    @Test
//    public void test(){
//        Observable.just(1,2,3,4,5)
//                .all(new Predicate <Integer>() {
//                    @Override
//                    public boolean test(Integer integer) throws Exception {
//                        return integer<10;
//                    }
//                })
//                .subscribe(new Consumer <Boolean>() {
//                    @Override
//                    public void accept(Boolean aBoolean) throws Exception {
//                        System.out.println(aBoolean);
//                    }
//                });
//    }
//
//    @Test
//    public void test1(){
//
//        Observable.just("helloword").subscribe(new Consumer <String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                System.out.println(s);
//            }
//        });
//    }
//    @Test
//    public void test2(){
//        Observable.just("HELLO").map(new Function <String,String>() {
//            @Override
//            public String apply(String s) throws Exception {
//                return s.toLowerCase();
//            }
//        }).map(new Function <String, String>() {
//            @Override
//            public String apply(String s) throws Exception {
//                return s+" word";
//            }
//        }).subscribe(new Consumer <String>() {
//            @Override
//            public void accept(String s) throws Exception {
//               System.out.println(s);
//            }
//        });
//    }
//
//
//
//
//    @Test
//    public   void creat3() {
//
//       final Integer mTestNum = 100;
//
//        final int c=2;
//
//
//        // ExecutorService newCachedThreadPool = Executors.newFixedThreadPool(3);
//
//        //defer() 只有观察者订阅的时候才会创建_新的_被观察者，所以每订阅一次就会打印一次，并且都是打印 i 最新的值。
//        Observable<Integer> observable1 = Observable.defer(new Callable<ObservableSource<? extends Integer>>() {
//            @Override
//            public ObservableSource<? extends Integer> call() throws Exception {
//                return Observable.just(mTestNum);
//            }
//        });
//       // mTestNum = 200;
//        Observer<Integer> observer = new Observer<Integer>() {
//            @Override public void onSubscribe(Disposable d) {
//
//            }
//            @Override public void onNext(Integer integer) {
//
//                System.out.println( "================onNext " + integer+"Current Thread Name="+Thread.currentThread().getName());
//            }
//            @Override public void onError(Throwable e) {
//
//            }
//            @Override public void onComplete() {}
//        };
//        Observer<Integer> observer1 = new Observer<Integer>() {
//            @Override public void onSubscribe(Disposable d) {
//
//            }
//            @Override public void onNext(Integer integer) {
//
//                System.out.println( "================onNext1 " + integer+1+"Current Thread Name="+Thread.currentThread().getName());
//            }
//            @Override public void onError(Throwable e) {
//
//            }
//            @Override public void onComplete() {}
//        };
//        System.out.println("hhhhhhhhh");
//        observable1.subscribe(observer);
//        System.out.println("zzzzzzzzz");
//        observable1.subscribe(observer1);
//        System.out.println("wwwwwwwww");
//        /* 打印结果：
//        ================onNext 200
//        ================onNext 300
//        */
//    }
//    @Test
//    public  void  create5(){
//
//        ExecutorService executorService= Executors.newFixedThreadPool(2);
//        Callable<String> task = new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                Thread.sleep(200);
//                return "OK";
//            }
//        };
//        Callable<String> task1 = new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                Thread.sleep(200);
//                return "OK1";
//            }
//        };
//
//        Future<String> future=executorService.submit(task);
//        Future<String> future1=executorService.submit(task1);
//        try {
//
//            System.out.println("111111111111111111");
//            String futures= future.get();
//            System.out.println("futures:"+futures);
//            System.out.println("middle");
//            String future1s= future1.get();
//            System.out.println("future1s:"+future1s);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//
//    }
//    @Test
//    public void create4(){
//        Long t=12L;
//        Consumer<Long > subscriber1  = new Consumer <Long>() {
//            @Override
//            public void accept(Long aLong) throws Exception {
//                System.out.println("consumer1:"+aLong+1+"Current Thread Name="+Thread.currentThread().getName());
//            }
//        };
//        Consumer<Long > subscriber2  = new Consumer <Long>() {
//            @Override
//            public void accept(Long aLong) throws Exception {
//                System.out.println("consumer2:"+aLong+2+"Current Thread Name="+Thread.currentThread().getName());
//            }
//        };
//        Consumer<Long > subscriber3  = new Consumer <Long>() {
//            @Override
//            public void accept(Long aLong) throws Exception {
//                System.out.println("consumer3:"+aLong+3+"Current Thread Name="+Thread.currentThread().getName());
//            }
//        };
//
//        ConnectableObservable<Long> observable = Observable.create(new ObservableOnSubscribe <Long>() {
//            //
//            @Override
//            public void subscribe(ObservableEmitter <Long> observableEmitter) throws Exception {
//                Observable.
//                        interval(50,TimeUnit.MILLISECONDS,Schedulers.computation())
//                        .take(3)
//                        .subscribe(observableEmitter::onNext);//observableEmitter::onNext
//            }
//        }).subscribeOn(Schedulers.newThread()).publish();
//                //.observeOn(Schedulers.newThread()).publish();
//
//        System.out.println("eeeeeeeeeeeee");
//        observable.connect();
//        observable.subscribe(subscriber1);
//        observable.subscribe(subscriber2);
//        observable.subscribe(subscriber3);
//        System.out.println("ffffffffffff");
//    }
//
//
//    public String result1 = "";
//    public  String result2="";
//    @Test
//    public void create20(){
//
//        Consumer<Integer> subscriber1  = new Consumer <Integer>() {
//            @Override
//            public void accept(Integer aLong) throws Exception {
//                Thread.sleep(15000);
//                result1 ="我在测试1";
//                System.out.println("consumer1:"+aLong+"Current Thread Name="+Thread.currentThread().getName());
//            }
//        };
//        Consumer<Integer > subscriber2  = new Consumer <Integer>() {
//            @Override
//            public void accept(Integer aLong) throws Exception {
//                Thread.sleep(15000);
//                result2="我在测试2";
//                System.out.println("consumer2:"+aLong+"Current Thread Name="+Thread.currentThread().getName());
//            }
//        };
//        ConnectableObservable<Integer> observable = Observable.just(100)
//                .subscribeOn(Schedulers.newThread())
//                .publish(); // 使用 publish() 操作符转换成一个 Connectable Observable
//        ConnectableObservable<Integer> observable1 = Observable.just(100)
//                .subscribeOn(Schedulers.newThread())
//                .publish(); // 使用 publish() 操作符转换成一个 Connectable Observable
//
//
//        observable.subscribe(subscriber1);
//        observable1.subscribe(subscriber2);
//        observable.connect();
//        observable1.connect();
//        System.out.println("result1:"+result1);
//        System.out.println("result2:"+result2);
//        System.out.println("eeeeeee");
//        System.out.println("ddddddd");
//        try {
//            Thread.sleep(300);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("result11:"+result1);
//        System.out.println("result22:"+result2);
//
//
//
//    }
//    @Test
//    public  void create6(){
//
//        List<Integer> orderIdList = Lists.newArrayList(263, 264,3634,3434,12,324,3434,22,33,53,23,66,5677,32445,43445);
//        Observable.fromIterable(orderIdList)
//                .flatMap(new Function <Integer, ObservableSource <String>>() {
//                    @Override
//                    public ObservableSource <String> apply(Integer integer) throws Exception {
//                        return Observable.just(integer)
//                                .subscribeOn(Schedulers.computation())
//                                .map(new Function <Integer, String>() {
//                                    @Override
//                                    public String apply(Integer integer) throws Exception {
//                                        return integer.toString();
//                                    }
//                                });
//                    }
//                }).subscribe(new Consumer <String>() {
//                    @Override
//                    public void accept(String s) throws Exception {
//                        System.out.println("s="+s+" ; Current Thread Name="+Thread.currentThread().getName());
//                    }
//                });
//    }
//    @Test
//    public void create7(){
//        int threadname= Runtime.getRuntime().availableProcessors()+1;
//        ExecutorService executorService = Executors.newFixedThreadPool(threadname);
//        final Scheduler schedulers = Schedulers.from(executorService);
//        Observable.range(1,100)
//                .flatMap(new Function <Integer, ObservableSource <String>>() {
//                    @Override
//                    public ObservableSource <String> apply(Integer integer) throws Exception {
//                        return Observable.just(integer)
//                                .subscribeOn(schedulers)
//                                .map(new Function <Integer, String>() {
//                                    @Override
//                                    public String apply(Integer integer) throws Exception {
//                                        return integer.toString();
//                                    }
//                                });
//                    }
//                }).doFinally(new Action() {
//                    @Override
//                   public void run() throws Exception {
//                        executorService.shutdown();
//                 }
//              })
//                .subscribe(new Consumer <String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                System.out.println("s="+s+" ; Current Thread Name="+Thread.currentThread().getName());
//            }
//        });
//
//    }
//    @Test
//    public void create8(){
//            ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap <>();
//            int threadname= Runtime.getRuntime().availableProcessors()+1;
//            ExecutorService executorService = Executors.newFixedThreadPool(threadname);
//            final Scheduler schedulers = Schedulers.from(executorService);
//            List<Integer> orderIdList = Lists.newArrayList(263, 264,3634,3434,12,324,3434,22,33,53,23,66,5677,32445,43445);
//            Observable.fromIterable(orderIdList)
//                 .flatMap(new Function <Integer, ObservableSource <String>>() {
//                     @Override
//                     public ObservableSource <String> apply(Integer integer) throws Exception {
//                         return Observable.just(integer)
//                                 .subscribeOn(schedulers)
//                                 .map(new Function <Integer, String>() {
//                                     @Override
//                                     public String apply(Integer integer) throws Exception {
//                                         System.out.println(" Observable Current Thread Name="+Thread.currentThread().getName());
//                                         return integer.toString();
//                                     }
//                                 });
//                     }
//                 }).doFinally(new Action() {
//             @Override
//             public void run() throws Exception {
//                 executorService.shutdown();
//             }
//         }).subscribe(new Consumer <String>() {
//
//             @Override
//             public void accept(String s) throws Exception {
//                 concurrentHashMap.put(s,s+"hello");
//                 System.out.println("s="+s+" ; Consumer Current Thread Name="+Thread.currentThread().getName());
//             }
//         });
//
//
//        for(String value : concurrentHashMap.values()) {
//            System.out.println("value = " + value);
//        }
//
//    }
////    @Test
////    public void create23(){
////             Result result = new Result();
////
////            Observable<String> sender= Observable.create(new ObservableOnSubscribe <String>() {
////                @Override
////                public void subscribe(ObservableEmitter <String> observableEmitter) throws Exception {
////
////                    observableEmitter.onNext("1sdsdsd");
////                    observableEmitter.onNext("2sdsdsd");
////                    observableEmitter.onNext("3sdsdsd");
////                    observableEmitter.onNext("4sdsdsd");
////
////                    observableEmitter.onNext("5sdsdsd");
////                    observableEmitter.onNext("6sdsdsd");
////
////                    observableEmitter.onNext("7sdsdsd");
////                    observableEmitter.onNext("8sdsdsd");
////                    int i=1/0;
////                    observableEmitter.onNext(String.valueOf(i));
////
////
////                    observableEmitter.onNext("hhhhhhhhhh");
////
////
////                    System.out.println("Observavle Current Thread Name="+Thread.currentThread().getName());
////
////                }
////            }).subscribeOn(Schedulers.newThread());
////            Observer <String> observer = new Observer <String>() {
////                @Override
////                public void onSubscribe(Disposable disposable) {
////                }
////
////                @Override
////                public void onNext(String s) {
////                    try {
////                        Thread.sleep(10);
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
////                    System.out.println(s +"111Consumer Current Thread Name="+Thread.currentThread().getName());
////
////                }
////
////                @Override
////                public void onError(Throwable throwable) {
////                    System.out.println( throwable +"~~~~");
////
////                }
////
////                @Override
////                public void onComplete() {
////
////                }
////            };
////
////            Observer <String> observer1 = new Observer <String>() {
////                @Override
////                public void onSubscribe(Disposable disposable) {
////                }
////
////                @Override
////                public void onNext(String s) {
////                    try {
////                        Thread.sleep(10);
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
////                    System.out.println(s+"222Consumer Current Thread Name="+Thread.currentThread().getName());
////
////                }
////
////                @Override
////                public void onError(Throwable throwable) {
////                    System.out.println( throwable +"-------");
////
////                }
////
////                @Override
////                public void onComplete() {
////
////                }
////            };
////            sender.subscribe(observer1);
////            sender.subscribe(observer);
////            System.out.println("~~~~~~~~~~~~~~~~~~");
////            try {
////                Thread.sleep(300);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
////            System.out.println("----------------");
////
////
////        }
//
//    @Test
//    public void create9(){
//        Observable.create(new ObservableOnSubscribe <String>() {
//            @Override
//            public void subscribe(ObservableEmitter <String> observableEmitter) throws Exception {
//                System.out.println("1 Current Thread Name="+Thread.currentThread().getName());
//                observableEmitter.onNext("hello");
//                observableEmitter.onNext("world");
//            }
//        }).observeOn(Schedulers.newThread())
//                .subscribe(new Consumer <String>() {
//                    @Override
//                    public void accept(String s) throws Exception {
//                        System.out.println("2 Current Thread Name="+Thread.currentThread().getName());
//                        System.out.println(" s="+s);
//                        }});
//    }
//    @Test
//    public void create10(){
//        Observable.just("aaa","bbb")
//                .observeOn(Schedulers.newThread())
//                .map(new Function <String, String>() {
//                    @Override
//                    public String apply(String s) throws Exception {
//                        System.out.println("1 Current Thread Name="+Thread.currentThread().getName());
//                        return s.toUpperCase();
//                    }
//                }).subscribeOn(Schedulers.single())
//                .observeOn(Schedulers.io())
//                .subscribe(new Consumer <String>() {
//                    @Override
//                    public void accept(String s) throws Exception {
//                        System.out.println("2 Current Thread Name="+Thread.currentThread().getName());
//                        System.out.println(s);
//                    }
//                });
//    }
//    @Test
//    public void create11(){
//        final AtomicInteger batch = new AtomicInteger(0);
//        Observable.range(1,100)
//                .groupBy(new Function <Integer, Integer>() {
//
//                    @Override
//                    public Integer apply(Integer integer) throws Exception {
//                        return batch.getAndIncrement()%5;
//                    }
//                })
//                .flatMap(new Function <GroupedObservable <Integer, Integer>, ObservableSource <?>>() {
//                    @Override
//                    public ObservableSource <?> apply(GroupedObservable <Integer, Integer> integerIntegerGroupedObservable) throws Exception {
//                        return integerIntegerGroupedObservable.observeOn(Schedulers.io())
//                                .map(new Function <Integer, String>() {
//                                    @Override
//                                    public String apply(Integer integer) throws Exception {
//                                        return integer.toString();
//                                    }
//                                });
//                    }
//                }).subscribe(new Consumer <Object>() {
//            @Override
//            public void accept(Object o) throws Exception {
//                System.out.println("o:"+o+"  3 Current Thread Name="+Thread.currentThread().getName());
//            }
//        });
//
//    }
//    @Test
//    public void create12(){
//        final AtomicInteger batch = new AtomicInteger(0);
//        int threadNum = 5;
//        final ExecutorService executorService = Executors.newFixedThreadPool(threadNum );
//        final Scheduler scheduler = Schedulers.from(executorService);
//        Observable.range(1,100)
//                .groupBy(new Function <Integer, Integer>() {
//                    @Override
//                    public Integer apply(Integer integer) throws Exception {
//                        return batch.getAndIncrement()%threadNum;
//                    }
//                })
//                .flatMap(new Function <GroupedObservable <Integer, Integer>, ObservableSource <?>>() {
//                    @Override
//                    public ObservableSource <?> apply(GroupedObservable <Integer, Integer> integerIntegerGroupedObservable) throws Exception {
//                        return integerIntegerGroupedObservable.observeOn(scheduler)
//                                .map(new Function <Integer, String>() {
//                                    @Override
//                                    public String apply(Integer integer) throws Exception {
//                                        return integer.toString();
//                                    }
//                                });
//                    }
//                })
//                .subscribe(new Consumer <Object>() {
//
//                    @Override
//                    public void accept(Object o) throws Exception {
//                        System.out.println("o:"+o+"  3 Current Thread Name="+Thread.currentThread().getName());
//                    }
//                });
//    }
//    @Test
//    public void create13(){
//        List<Integer> orderIdList = Lists.newArrayList(263, 264,3634,3434,12,324,3434,22,33,53,23,66,5677,32445,43445);
//        Observable.fromIterable(orderIdList)
//                .subscribe(new Consumer <Integer>() {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        System.out.println(integer);
//                    }
//                });
//
//    }
//    @Test
//    public void create14(){
//            Observable.create(new ObservableOnSubscribe<Integer>() {
//                @Override
//                public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
//                    emitter.onNext(1);
//                    emitter.onNext(2);
//                    emitter.onNext(3);
//                }
//            }).subscribe(new Consumer <Integer>() {
//                @Override
//                public void accept(Integer integer) throws Exception {
//                    System.out.println(integer);
//                }
//            });
//    }
//
//     @Test
//     public void create15(){
//        Observable.just("hello word")
//                .subscribe(new Observer <String>() {
//                    @Override
//                    public void onSubscribe(Disposable disposable) {
//
//                    }
//                    @Override
//                    public void onNext(String s) {
//                        try {
//                            Thread.sleep(15000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//
//                        System.out.println("s:"+s);
//
//                    }
//                    @Override
//                    public void onError(Throwable throwable) {
//                    }
//
//                    @Override
//                    public void onComplete() {
//                    }
//                });
//
//        System.out.println("测试测试测试");
//     }
//     @Test
//     public void create24(){
//         ConnectableObservable<Integer> connectableObservable = Observable.just(1,2,3,4,5).publish();
//         connectableObservable.subscribe(new Consumer <Integer>() {
//             @Override
//             public void accept(Integer integer) throws Exception {
//                 System.out.println("Caught by 1st : "+ integer);
//             }
//         });
//         connectableObservable.subscribe(new Consumer <Integer>() {
//             @Override
//             public void accept(Integer integer) throws Exception {
//                 System.out.println("Caught by 2nd : "+ integer);
//             }
//         });
//
//         connectableObservable.connect();
//     }
//
//
//    public static void main(String[] args) {
//
//
//
//    }
//}
