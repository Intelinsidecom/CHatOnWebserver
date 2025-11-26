package twitter4j.internal.async;

import java.util.LinkedList;
import java.util.List;
import twitter4j.conf.Configuration;

/* loaded from: classes.dex */
final class DispatcherImpl implements Dispatcher {
    private ExecuteThread[] threads;

    /* renamed from: q */
    private final List f7894q = new LinkedList();
    final Object ticket = new Object();
    private boolean active = true;

    public DispatcherImpl(Configuration configuration) {
        this.threads = new ExecuteThread[configuration.getAsyncNumThreads()];
        for (int i = 0; i < this.threads.length; i++) {
            this.threads[i] = new ExecuteThread("Twitter4J Async Dispatcher", this, i);
            this.threads[i].setDaemon(true);
            this.threads[i].start();
        }
        Runtime.getRuntime().addShutdownHook(new Thread(this) { // from class: twitter4j.internal.async.DispatcherImpl.1
            private final DispatcherImpl this$0;

            {
                this.this$0 = this;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                if (this.this$0.active) {
                    this.this$0.shutdown();
                }
            }
        });
    }

    @Override // twitter4j.internal.async.Dispatcher
    public synchronized void invokeLater(Runnable runnable) {
        synchronized (this.f7894q) {
            this.f7894q.add(runnable);
        }
        synchronized (this.ticket) {
            this.ticket.notify();
        }
    }

    public Runnable poll() {
        Runnable runnable;
        while (this.active) {
            synchronized (this.f7894q) {
                if (this.f7894q.size() > 0 && (runnable = (Runnable) this.f7894q.remove(0)) != null) {
                    return runnable;
                }
            }
            synchronized (this.ticket) {
                try {
                    this.ticket.wait();
                } catch (InterruptedException e) {
                }
            }
        }
        return null;
    }

    @Override // twitter4j.internal.async.Dispatcher
    public synchronized void shutdown() {
        synchronized (this) {
            if (this.active) {
                this.active = false;
                for (ExecuteThread executeThread : this.threads) {
                    executeThread.shutdown();
                }
                synchronized (this.ticket) {
                    this.ticket.notify();
                }
            }
        }
    }
}
