package org.jboss.netty.util;

import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;

/* loaded from: classes.dex */
public class ThreadRenamingRunnable implements Runnable {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ThreadRenamingRunnable.class);
    private static volatile ThreadNameDeterminer threadNameDeterminer = ThreadNameDeterminer.PROPOSED;
    private final String proposedThreadName;
    private final Runnable runnable;

    public static ThreadNameDeterminer getThreadNameDeterminer() {
        return threadNameDeterminer;
    }

    public ThreadRenamingRunnable(Runnable runnable, String str) {
        if (runnable == null) {
            throw new NullPointerException("runnable");
        }
        if (str == null) {
            throw new NullPointerException("proposedThreadName");
        }
        this.runnable = runnable;
        this.proposedThreadName = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        String newThreadName = getNewThreadName(name);
        if (name.equals(newThreadName)) {
            z = false;
        } else {
            try {
                threadCurrentThread.setName(newThreadName);
                z = true;
            } catch (SecurityException e) {
                logger.debug("Failed to rename a thread due to security restriction.", e);
            }
        }
        try {
            this.runnable.run();
        } finally {
            if (z) {
                threadCurrentThread.setName(name);
            }
        }
    }

    private String getNewThreadName(String str) {
        String strDetermineThreadName;
        try {
            strDetermineThreadName = getThreadNameDeterminer().determineThreadName(str, this.proposedThreadName);
        } catch (Throwable th) {
            logger.warn("Failed to determine the thread name", th);
            strDetermineThreadName = null;
        }
        return strDetermineThreadName == null ? str : strDetermineThreadName;
    }
}
