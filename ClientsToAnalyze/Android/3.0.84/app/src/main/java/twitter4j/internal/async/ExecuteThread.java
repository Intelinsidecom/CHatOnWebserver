package twitter4j.internal.async;

import twitter4j.internal.logging.Logger;

/* compiled from: DispatcherImpl.java */
/* loaded from: classes.dex */
class ExecuteThread extends Thread {
    static Class class$twitter4j$internal$async$ExecuteThread;
    private static Logger logger;
    private boolean alive;

    /* renamed from: q */
    DispatcherImpl f13731q;

    static {
        Class clsClass$;
        if (class$twitter4j$internal$async$ExecuteThread == null) {
            clsClass$ = class$("twitter4j.internal.async.ExecuteThread");
            class$twitter4j$internal$async$ExecuteThread = clsClass$;
        } else {
            clsClass$ = class$twitter4j$internal$async$ExecuteThread;
        }
        logger = Logger.getLogger(clsClass$);
    }

    static Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    ExecuteThread(String str, DispatcherImpl dispatcherImpl, int i) {
        super(new StringBuffer().append(str).append("[").append(i).append("]").toString());
        this.alive = true;
        this.f13731q = dispatcherImpl;
    }

    public void shutdown() {
        this.alive = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (this.alive) {
            Runnable runnablePoll = this.f13731q.poll();
            if (runnablePoll != null) {
                try {
                    runnablePoll.run();
                } catch (Exception e) {
                    logger.error("Got an exception while running a taks:", e);
                }
            }
        }
    }
}
