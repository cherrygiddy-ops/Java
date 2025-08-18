package Concurrency_Multithreading;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class Demo {


    public static void numberOfProcessors() {
        System.out.println(Thread.activeCount());
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    public static void  concurrentCollections(){
        Map<Integer,String> map = new ConcurrentHashMap<>();//Many threads can access and modify this collection
        Collection<Integer>list = Collections.synchronizedList(new ArrayList<>());
        Thread thread1 = new Thread(()->{
        //map.put(5,"a");
            list.addAll(Arrays.asList(5,7));
        });
        Thread thread2 = new Thread(()->{
        //map.put(7,"b");
            list.addAll(Arrays.asList(9,10,45));
        });
        thread1.start();
        thread2.start();

        try {
            thread2.join();
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(list);
    }
    public static void raceCondition() {
        final List<Thread> threads = new ArrayList<>();
        final DownloadStatus status = new DownloadStatus();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new DownloadTask(status));
            thread.start();
            threads.add(thread);
        }

        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(status.getTotalBytes());
    }
    //one Thread changes data and the other thread can not see the changes hence waiting for each other indefinitely leading to deadLock
    public static void visibilityProblem(){
        final DownloadStatus status = new DownloadStatus();

        Thread thread1 = new Thread(new DownloadTask(status));
        Thread thread2 = new Thread(()-> {
            while (!status.isDone()) {
                synchronized (status){
                    try {
                        status.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            System.out.println(status.getTotalBytes());
        });
        thread1.start();
        thread2.start();

    }

//  public static void confinement(){
//       final List<Thread> threads = new ArrayList<>();
//       final List<DownloadTask> tasks = new ArrayList<>();
//
//
//        for (int i=0;i<10;i++) {
//            var task = new DownloadTask();
//            tasks.add(task);
//            Thread thread = new Thread(task);
//            thread.start();
//            threads.add(thread);
//        }
//
//        for (var thread:threads ){
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        var status =tasks.stream().map(t->t.getStatus().getTotalBytes()).reduce(Integer::sum);
//
//        System.out.println(status);
//}
}
