package com.vlingo.sdk.internal.recognizer;

import com.coolots.sso.util.ChatONVAPII;
import java.util.Vector;

/* loaded from: classes.dex */
public class TimingRepository {
    private final Vector<String> eventTimings = new Vector<>();
    private volatile long timeZero;

    public void clear() {
        this.eventTimings.removeAllElements();
        this.timeZero = 0L;
    }

    public void markTimeZero() {
        this.timeZero = System.currentTimeMillis();
    }

    public void recordAndTimeStampEvent(String event) {
        this.eventTimings.addElement(String.valueOf(event) + ChatONVAPII.USERID_DELEMETER + (System.currentTimeMillis() - this.timeZero));
    }

    public String getStatString() {
        StringBuffer buff = new StringBuffer();
        buff.append("ZERO:" + this.timeZero);
        int size = this.eventTimings.size();
        for (int i = 0; i < size; i++) {
            buff.append(",");
            buff.append(this.eventTimings.elementAt(i));
        }
        return buff.toString();
    }
}
