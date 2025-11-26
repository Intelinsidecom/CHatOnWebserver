package com.sec.chaton.p074l;

import android.os.Build;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ProfileImageManager.java */
/* renamed from: com.sec.chaton.l.x */
/* loaded from: classes.dex */
final class C2506x extends ThreadPoolExecutor {
    public C2506x(BlockingQueue<Runnable> blockingQueue) {
        super(1, 1, 0L, TimeUnit.MILLISECONDS, blockingQueue, new ThreadFactoryC2507y());
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        if (Build.VERSION.SDK_INT > 8) {
            return super.submit(runnable);
        }
        if (runnable == null) {
            throw new NullPointerException();
        }
        RunnableFuture runnableFutureNewTaskFor = newTaskFor(runnable, null);
        execute(runnableFutureNewTaskFor);
        return runnableFutureNewTaskFor;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        if (Build.VERSION.SDK_INT > 8) {
            return super.submit(runnable, t);
        }
        if (runnable == null) {
            throw new NullPointerException();
        }
        RunnableFuture<T> runnableFutureNewTaskFor = newTaskFor(runnable, t);
        execute(runnableFutureNewTaskFor);
        return runnableFutureNewTaskFor;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        if (Build.VERSION.SDK_INT > 8) {
            return super.submit(callable);
        }
        if (callable == null) {
            throw new NullPointerException();
        }
        RunnableFuture<T> runnableFutureNewTaskFor = newTaskFor(callable);
        execute(runnableFutureNewTaskFor);
        return runnableFutureNewTaskFor;
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new C2503u(runnable, t);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new C2503u(callable);
    }
}
