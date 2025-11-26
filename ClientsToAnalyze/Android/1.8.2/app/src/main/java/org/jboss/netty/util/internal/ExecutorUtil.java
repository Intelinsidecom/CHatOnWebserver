package org.jboss.netty.util.internal;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class ExecutorUtil {
    public static boolean isShutdown(Executor executor) {
        return (executor instanceof ExecutorService) && ((ExecutorService) executor).isShutdown();
    }

    public static void terminate(Executor... executorArr) {
        boolean z = false;
        if (executorArr == null) {
            throw new NullPointerException("executors");
        }
        Executor[] executorArr2 = new Executor[executorArr.length];
        for (int i = 0; i < executorArr.length; i++) {
            if (executorArr[i] == null) {
                throw new NullPointerException("executors[" + i + "]");
            }
            executorArr2[i] = executorArr[i];
        }
        Executor executor = (Executor) DeadLockProofWorker.PARENT.get();
        if (executor != null) {
            for (Executor executor2 : executorArr2) {
                if (executor2 == executor) {
                    throw new IllegalStateException("An Executor cannot be shut down from the thread acquired from itself.  Please make sure you are not calling releaseExternalResources() from an I/O worker thread.");
                }
            }
        }
        int length = executorArr2.length;
        int i2 = 0;
        while (i2 < length) {
            Executor executor3 = executorArr2[i2];
            if (executor3 instanceof ExecutorService) {
                ExecutorService executorService = (ExecutorService) executor3;
                while (true) {
                    try {
                        executorService.shutdownNow();
                    } catch (NullPointerException e) {
                    } catch (SecurityException e2) {
                        try {
                            executorService.shutdown();
                        } catch (NullPointerException e3) {
                        } catch (SecurityException e4) {
                        }
                    }
                    try {
                    } catch (InterruptedException e5) {
                        z = true;
                    }
                    if (executorService.awaitTermination(100L, TimeUnit.MILLISECONDS)) {
                        break;
                    }
                }
            }
            i2++;
            z = z;
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private ExecutorUtil() {
    }
}
