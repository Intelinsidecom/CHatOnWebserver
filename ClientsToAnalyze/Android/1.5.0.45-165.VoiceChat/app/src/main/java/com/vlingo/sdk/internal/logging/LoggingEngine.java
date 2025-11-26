package com.vlingo.sdk.internal.logging;

import java.util.Date;
import java.util.Vector;

/* loaded from: classes.dex */
public class LoggingEngine {
    public static final String LEVEL_DEBUG = "DEBUG";
    public static final String LEVEL_ERROR = "ERROR";
    public static final String LEVEL_INFO = "INFO ";
    protected static volatile LoggingEngine instance = null;
    private String logMsgPrefix = "";
    protected final Vector<Object> logTargets = new Vector<>();
    private boolean filterClasses = false;
    private final Vector<Object> classFilter = new Vector<>();
    private boolean filterThreads = false;
    private final Vector<Object> threadFilter = new Vector<>();
    private boolean loggingEnabled = true;

    protected LoggingEngine() {
    }

    public static synchronized LoggingEngine getInstance() {
        if (instance == null) {
            instance = new LoggingEngine();
        }
        return instance;
    }

    protected void log(String className, String level, String msg) {
        if (this.loggingEnabled) {
            if (!this.filterClasses || !this.classFilter.contains(className)) {
                if (!this.filterThreads || !this.threadFilter.contains(Thread.currentThread().getName())) {
                    int numTargets = this.logTargets.size();
                    String finalMessage = formatLogMessage(className, level, msg);
                    for (int i = 0; i < numTargets; i++) {
                        LogTarget target = (LogTarget) this.logTargets.elementAt(i);
                        target.log(finalMessage, level.equals(LEVEL_ERROR));
                    }
                }
            }
        }
    }

    protected String formatLogMessage(String className, String level, String msg) {
        long curTime = System.currentTimeMillis();
        long msecs = curTime % 1000;
        Date date = new Date(curTime);
        StringBuffer sb = new StringBuffer(80);
        sb.append(this.logMsgPrefix);
        sb.append(date.toString());
        sb.append(" +" + msecs + "ms");
        sb.append(" - ");
        sb.append(level);
        sb.append(" [");
        sb.append(Thread.currentThread().getName());
        sb.append("] ");
        if (className != null) {
            sb.append(className);
            sb.append(": ");
        }
        sb.append(msg);
        return sb.toString();
    }

    public static synchronized boolean isInitialized() {
        return instance != null;
    }

    public synchronized void closeLoggers() {
        int numTargets = this.logTargets.size();
        for (int i = 0; i < numTargets; i++) {
            LogTarget target = (LogTarget) this.logTargets.elementAt(i);
            target.close();
        }
    }

    public synchronized void setEnabled(boolean enabled) {
        this.loggingEnabled = enabled;
    }

    public synchronized void enableClassFilter(boolean enabled) {
        this.filterClasses = enabled;
    }

    public synchronized void addClassToFilter(String s) {
        this.classFilter.addElement(s);
    }

    public synchronized void enableThreadFilter(boolean enabled) {
        this.filterThreads = enabled;
    }

    public synchronized void addThreadToFilter(String t) {
        this.threadFilter.addElement(t);
    }

    public synchronized void addTarget(LogTarget target) {
        this.logTargets.addElement(target);
    }

    public synchronized Vector<Object> getTargets() {
        return this.logTargets;
    }

    public synchronized void removeTarget(LogTarget target) {
        this.logTargets.removeElement(target);
    }

    public synchronized String getLogMessagePrefix() {
        return this.logMsgPrefix;
    }

    public synchronized void setLogMessagePrefix(String prefix) {
        this.logMsgPrefix = prefix;
    }
}
