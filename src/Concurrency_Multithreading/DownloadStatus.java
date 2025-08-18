package Concurrency_Multithreading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {
    private final LongAdder totalBytes = new LongAdder();//Suitable for many Threads updating totalbytes field
   // private final AtomicInteger totalBytes = new AtomicInteger();//atomic types are like atoms they are unbreakable:::Suitable for few Threads
    private volatile  boolean isDone;//Volatile key word solves Visibility problem but not race condition
   // private Lock lock = new ReentrantLock();//Using locks to implements Synchronization to remove Race Conditions


    public void   incrementTotal() {
               totalBytes.increment();
    }
    public int getTotalBytes() {
        return totalBytes.intValue();
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone() {
        isDone = true;
    }
    //using Synchronization keyWord

    //public void   incrementTotal() {
    //           synchronized (this) {
    //               totalBytes++;
    //           }
    //
    //    }

    //implementation of Locks (Synchronization)

//        public void   incrementTotal(){
//            lock.lock();
//            try {
//                totalBytes++;
//            }
//            finally {
//                lock.unlock();
//            }
//   }
}
