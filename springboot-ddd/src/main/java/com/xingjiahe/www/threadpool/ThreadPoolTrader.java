package com.xingjiahe.www.threadpool;





import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/6/30 4:20 PM
 */
public class ThreadPoolTrader  implements Executor {
    private final AtomicInteger  ctl = new AtomicInteger(0);
    static ReentrantLock    lock = new ReentrantLock(true);
    private volatile int corePoolSize;
    private volatile int maximumPoolSize;

    private  final BlockingQueue<Runnable> workQueue;

    public ThreadPoolTrader (int corePoolSize ,int maximumPoolSize,BlockingQueue<Runnable>workQueue){
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.workQueue = workQueue;
    }


    @Override
    public void  execute(Runnable command) {
            int c = ctl.get();
            if(c<corePoolSize){
                if(!addWorker(command)){
                    reject();
                }
                return;
            }
            if(!workQueue.offer(command)){
                if(!addWorker(command)){
                    reject();
                }
            }
    }

    private   boolean  addWorker(Runnable firstTask){
       if(ctl.get()>=maximumPoolSize) return  false;
        Worker worker = new Worker( firstTask);
        worker.thread.start();
        ctl.incrementAndGet();
        return true;
    }

    private  final class Worker implements  Runnable{
       final Thread thread;
       Runnable firstTask;

       public  Worker (Runnable firstTask){
           this.thread= new Thread(this);
           this.firstTask = firstTask;
       }

        @Override
        public void run() {
            Runnable task = firstTask;
            try{
                while(task != null || (task = getTask())!=null){
                    task.run();
                    if(ctl.get()>maximumPoolSize){
                        break;
                    }
                    task = null;
                }
            }  finally {
                ctl.decrementAndGet();
            }
        }
    }

    private  Runnable getTask(){
        for(;;){
            try {
                System.out.println("workQueue.size"+workQueue.size());
                return  workQueue.take();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }



    private  void  reject(){
        throw  new RuntimeException("Error ctl.count:" +ctl.get()+"workQueue.size" +workQueue.size());
    }

  public static void main(String args[]) {
      ThreadPoolTrader threadPoolTrader = new ThreadPoolTrader(10, 10, new ArrayBlockingQueue<Runnable>(100));

      for (int i = 0; i < 10; i++) {
          int finalI = i;
              threadPoolTrader.execute(() -> {
//               lock.lock();
                  try {
                      Thread.sleep(1000);
                      System.out.println("任务编号：" + finalI);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  } finally {
//                  lock.unlock();
                  }

              });
          }
      }
}
