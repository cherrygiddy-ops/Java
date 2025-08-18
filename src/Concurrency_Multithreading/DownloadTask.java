package Concurrency_Multithreading;

public class DownloadTask implements Runnable{


    private DownloadStatus status;

    public DownloadTask(DownloadStatus status) {
        this.status = status;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        System.out.println("downloing a task "+Thread.currentThread().getName());
        for (var i=0;i<10_000_000;i++){
            if (Thread.currentThread().isInterrupted())return;
            status.incrementTotal();
        }
        status.setDone();

        synchronized (status){
            status.notifyAll();
        }
        System.out.println("download Complete"+Thread.currentThread().getName());
    }
    public DownloadStatus getStatus() {
        return status;
    }
}
