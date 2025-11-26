package com.vlingo.sdk.internal.util;

import com.vlingo.sdk.internal.logging.Logger;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

/* loaded from: classes.dex */
public class ThreadPoolExecutor {
    private static final Logger log = Logger.getLogger(ThreadPoolExecutor.class);
    private volatile int availWorkers;
    private volatile boolean dynamic;
    private volatile int maxPoolSize;
    private volatile int minPoolSize;
    private volatile int nextThreadID;
    private volatile boolean paused;
    private volatile int priority;
    private final Vector<Future> queue;
    private volatile boolean shutDown;
    private final String workerName;
    private final Vector<Thread> workers;

    public ThreadPoolExecutor() {
        this("Worker");
    }

    public ThreadPoolExecutor(String workerName) {
        this.queue = new Vector<>();
        this.workers = new Vector<>();
        this.availWorkers = 0;
        this.maxPoolSize = 1;
        this.minPoolSize = 1;
        this.shutDown = false;
        this.priority = 5;
        this.dynamic = false;
        this.nextThreadID = 1;
        this.paused = false;
        this.workerName = workerName;
    }

    public boolean isBusy() {
        return this.availWorkers == 0 && this.workers.size() == this.maxPoolSize;
    }

    public void setMaxPoolSize(int s) {
        this.maxPoolSize = s;
    }

    public void setMinPoolSize(int s) {
        this.minPoolSize = s;
    }

    public void setDynamicSizing(boolean dynamic) {
        this.dynamic = dynamic;
    }

    public void setThreadPriority(int priority) {
        this.priority = priority;
    }

    public Future execute(Runnable run) throws Throwable {
        log.debug("Execute " + run + " (avail=" + this.availWorkers + ")");
        if (this.shutDown) {
            throw new IllegalStateException();
        }
        synchronized (this.queue) {
            try {
                synchronized (this.workers) {
                    log.debug("workers=" + this.workers.size() + " availWorkers=" + this.availWorkers);
                    if (this.workers.size() < this.maxPoolSize && this.availWorkers == 0) {
                        log.debug("adding worker thread to pool");
                        Worker worker = new Worker(this, null);
                        StringBuilder sb = new StringBuilder(String.valueOf(this.workerName));
                        int i = this.nextThreadID;
                        this.nextThreadID = i + 1;
                        Thread thread = new Thread(worker, sb.append(i).toString());
                        thread.setPriority(this.priority);
                        this.workers.addElement(thread);
                        this.availWorkers++;
                        thread.start();
                    }
                }
                Future fut = new Future(run);
                try {
                    if (isRunnableHighPriority(run)) {
                        boolean added = false;
                        int size = this.queue.size();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= size) {
                                break;
                            }
                            Future queuedFuture = this.queue.elementAt(i2);
                            if (!isRunnableHighPriority(queuedFuture.getRunnable())) {
                                this.queue.insertElementAt(fut, i2);
                                added = true;
                                break;
                            }
                            i2++;
                        }
                        if (!added) {
                            this.queue.addElement(fut);
                        }
                    } else {
                        this.queue.addElement(fut);
                    }
                    this.queue.notifyAll();
                    return fut;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public Future executeLater(Runnable runnable, long wait) {
        final Future fut = new Future(runnable);
        Timer timer = TimerSingleton.getTimer();
        TimerTask task = new TimerTask() { // from class: com.vlingo.sdk.internal.util.ThreadPoolExecutor.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() throws Throwable {
                fut.setScheduleTask(null);
                ThreadPoolExecutor.this.execute(fut.getRunnable());
            }
        };
        fut.setScheduleTask(task);
        timer.schedule(task, wait);
        return fut;
    }

    public void shutdown() {
        synchronized (this.queue) {
            this.shutDown = true;
            this.queue.notifyAll();
        }
    }

    public boolean isEmpty() {
        boolean zIsEmpty;
        synchronized (this.queue) {
            zIsEmpty = this.queue.isEmpty();
        }
        return zIsEmpty;
    }

    public void pause() {
        if (!this.paused) {
            synchronized (this.queue) {
                this.paused = true;
                this.queue.notifyAll();
            }
        }
    }

    public void resume() {
        if (this.paused) {
            synchronized (this.queue) {
                this.paused = false;
                this.queue.notifyAll();
            }
        }
    }

    public void clear() {
        synchronized (this.queue) {
            this.queue.removeAllElements();
            this.queue.notifyAll();
        }
    }

    private class Worker implements Runnable {
        private Worker() {
        }

        /* synthetic */ Worker(ThreadPoolExecutor threadPoolExecutor, Worker worker) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                synchronized (ThreadPoolExecutor.this.queue) {
                    while (true) {
                        if ((!ThreadPoolExecutor.this.paused && !ThreadPoolExecutor.this.queue.isEmpty()) || ThreadPoolExecutor.this.shutDown) {
                            break;
                        }
                        try {
                            if (ThreadPoolExecutor.this.paused) {
                                ThreadPoolExecutor.log.debug("paused, waiting for resume");
                            }
                            if (ThreadPoolExecutor.this.queue.isEmpty()) {
                                ThreadPoolExecutor.log.debug("waiting for more jobs");
                            }
                            ThreadPoolExecutor.this.queue.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                    if (!ThreadPoolExecutor.this.shutDown) {
                        Future fut = (Future) ThreadPoolExecutor.this.queue.firstElement();
                        ThreadPoolExecutor.this.queue.removeElement(fut);
                        Runnable task = null;
                        synchronized (fut) {
                            if (!fut.isCancelled()) {
                                ThreadPoolExecutor threadPoolExecutor = ThreadPoolExecutor.this;
                                threadPoolExecutor.availWorkers--;
                                task = fut.getRunnable();
                                fut.setThread(Thread.currentThread());
                            }
                        }
                        if (task != null) {
                            boolean completedTask = true;
                            try {
                                ThreadPoolExecutor.log.debug("executing worker: " + task);
                                task.run();
                                ThreadPoolExecutor.log.debug("finished worker execution: " + task);
                                if (ThreadPoolExecutor.isRunnableRetry(task)) {
                                    ThreadPoolExecutor.log.debug("retry marked, adding task back into queue");
                                    synchronized (ThreadPoolExecutor.this.queue) {
                                        if (ThreadPoolExecutor.isRunnableOrdered(task) || ThreadPoolExecutor.isRunnableHighPriority(task)) {
                                            ThreadPoolExecutor.this.queue.insertElementAt(fut, 0);
                                        } else {
                                            ThreadPoolExecutor.this.queue.addElement(fut);
                                        }
                                    }
                                    completedTask = false;
                                }
                            } catch (Throwable t) {
                                ThreadPoolExecutor.log.error("GEN1", "Exception executing task " + task.toString() + ", Exception: " + t.getClass() + ", Message: " + t.getMessage());
                                t.printStackTrace();
                            }
                            synchronized (fut) {
                                if (completedTask) {
                                    fut.complete();
                                }
                                fut.setThread(null);
                            }
                            ThreadPoolExecutor.this.availWorkers++;
                            if (ThreadPoolExecutor.this.dynamic) {
                                synchronized (ThreadPoolExecutor.this.queue) {
                                    if (ThreadPoolExecutor.this.queue.isEmpty()) {
                                        synchronized (ThreadPoolExecutor.this.workers) {
                                            if (ThreadPoolExecutor.this.workers.size() > ThreadPoolExecutor.this.minPoolSize) {
                                                ThreadPoolExecutor.log.debug("removing worker thread from pool, workers=" + ThreadPoolExecutor.this.workers.size() + " avail=" + ThreadPoolExecutor.this.availWorkers);
                                                ThreadPoolExecutor threadPoolExecutor2 = ThreadPoolExecutor.this;
                                                threadPoolExecutor2.availWorkers--;
                                                ThreadPoolExecutor.this.workers.removeElement(Thread.currentThread());
                                                return;
                                            }
                                        }
                                    }
                                }
                            } else {
                                continue;
                            }
                        }
                    } else {
                        synchronized (ThreadPoolExecutor.this.workers) {
                            ThreadPoolExecutor.this.workers.removeElement(Thread.currentThread());
                            ThreadPoolExecutor threadPoolExecutor3 = ThreadPoolExecutor.this;
                            threadPoolExecutor3.availWorkers--;
                        }
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isRunnableHighPriority(Runnable run) {
        if (run instanceof ThreadPoolRunnable) {
            return ((ThreadPoolRunnable) run).isHighPriority();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isRunnableOrdered(Runnable run) {
        if (run instanceof ThreadPoolRunnable) {
            return ((ThreadPoolRunnable) run).isOrdered();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isRunnableRetry(Runnable run) {
        if (run instanceof ThreadPoolRunnable) {
            return ((ThreadPoolRunnable) run).isRetry();
        }
        return false;
    }
}
