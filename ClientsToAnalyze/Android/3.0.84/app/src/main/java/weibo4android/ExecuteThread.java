package weibo4android;

/* compiled from: Dispatcher.java */
/* loaded from: classes.dex */
class ExecuteThread extends Thread {
    private boolean alive;

    /* renamed from: q */
    Dispatcher f13750q;

    ExecuteThread(String str, Dispatcher dispatcher, int i) {
        super(str + "[" + i + "]");
        this.alive = true;
        this.f13750q = dispatcher;
    }

    public void shutdown() {
        this.alive = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (this.alive) {
            Runnable runnablePoll = this.f13750q.poll();
            if (runnablePoll != null) {
                try {
                    runnablePoll.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
