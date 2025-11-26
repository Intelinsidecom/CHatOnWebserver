package weibo4android;

import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
class Dispatcher {
    private boolean active;

    /* renamed from: q */
    private List<Runnable> f13749q;
    private ExecuteThread[] threads;
    Object ticket;

    public Dispatcher(String str) {
        this(str, 1);
    }

    public Dispatcher(String str, int i) {
        this.f13749q = new LinkedList();
        this.ticket = new Object();
        this.active = true;
        this.threads = new ExecuteThread[i];
        for (int i2 = 0; i2 < this.threads.length; i2++) {
            this.threads[i2] = new ExecuteThread(str, this, i2);
            this.threads[i2].setDaemon(true);
            this.threads[i2].start();
        }
        Runtime.getRuntime().addShutdownHook(new Thread() { // from class: weibo4android.Dispatcher.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                if (Dispatcher.this.active) {
                    Dispatcher.this.shutdown();
                }
            }
        });
    }

    public synchronized void invokeLater(Runnable runnable) {
        synchronized (this.f13749q) {
            this.f13749q.add(runnable);
        }
        synchronized (this.ticket) {
            this.ticket.notify();
        }
    }

    public Runnable poll() {
        Runnable runnableRemove;
        while (this.active) {
            synchronized (this.f13749q) {
                if (this.f13749q.size() > 0 && (runnableRemove = this.f13749q.remove(0)) != null) {
                    return runnableRemove;
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
            } else {
                throw new IllegalStateException("Already shutdown");
            }
        }
    }
}
