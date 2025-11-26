package com.sec.chaton.chat;

import com.sec.chaton.util.C4904y;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: TypingStateInfoToReceive.java */
/* renamed from: com.sec.chaton.chat.hx */
/* loaded from: classes.dex */
public class C1778hx {

    /* renamed from: a */
    private String f6671a;

    /* renamed from: b */
    private long f6672b;

    /* renamed from: c */
    private long f6673c;

    /* renamed from: d */
    private Timer f6674d;

    public C1778hx(String str, long j, long j2) {
        this.f6671a = str;
        this.f6672b = j;
        this.f6673c = j2;
    }

    /* renamed from: a */
    public String m8791a() {
        return this.f6671a;
    }

    /* renamed from: b */
    public long m8794b() {
        return this.f6672b;
    }

    /* renamed from: c */
    public long m8796c() {
        return this.f6673c;
    }

    /* renamed from: a */
    public void m8792a(long j) {
        this.f6672b = j;
    }

    /* renamed from: b */
    public void m8795b(long j) {
        this.f6673c = j;
    }

    /* renamed from: a */
    public void m8793a(TimerTask timerTask, long j) {
        if (this.f6674d == null) {
            this.f6674d = new Timer();
        }
        if (C4904y.f17873c) {
            StringBuilder sb = new StringBuilder();
            sb.append("[Start timer] ").append("sender : ").append(this.f6671a).append(", ").append("refreshTime : ").append(String.valueOf(this.f6672b)).append(", ").append("receivedTime : ").append(String.valueOf(this.f6673c));
            C4904y.m18641c(sb.toString(), "TypingStateInfoToReceive");
        }
        this.f6674d.schedule(timerTask, j, this.f6672b);
    }

    /* renamed from: d */
    public void m8797d() {
        if (this.f6674d != null) {
            this.f6674d.cancel();
            this.f6674d = null;
            if (C4904y.f17873c) {
                StringBuilder sb = new StringBuilder();
                sb.append("[Stop timer] ").append("sender : ").append(this.f6671a);
                C4904y.m18641c(sb.toString(), "TypingStateInfoToReceive");
            }
        }
    }
}
