package com.xingjiahe.www.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/1/19 下午5:34
 */
public class HitchWorkFactory  implements ThreadFactory {
    private static final String NAME_THREAD_PREFIX = "hampool-";
    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    private final AtomicInteger threadNumber;
    private ThreadGroup group;
    private String namePrefix;
    private int priority;
    private String threadPoolName;

    public HitchWorkFactory(String name) {
        this(name, 5);
    }

    public HitchWorkFactory(String name, int priority) {
        this.threadNumber = new AtomicInteger(1);
        SecurityManager s = System.getSecurityManager();
        this.group = s != null ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.namePrefix = "hampool-" + poolNumber.getAndIncrement() + "-" + name + "-thread-";
        this.priority = priority;
        this.threadPoolName = name;
    }
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(this.group, r, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
        if (t.isDaemon()) {
            t.setDaemon(false);
        }

        if (this.priority < 1) {
            t.setPriority(5);
        } else {
            t.setPriority(this.priority);
        }

        return t;
    }

    public String getThreadPoolName() {
        return this.threadPoolName;
    }
}
