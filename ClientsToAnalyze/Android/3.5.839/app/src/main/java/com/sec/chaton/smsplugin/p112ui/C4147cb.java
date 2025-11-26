package com.sec.chaton.smsplugin.p112ui;

import android.os.PowerManager;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p110g.C3855a;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

/* compiled from: MessageOptions.java */
/* renamed from: com.sec.chaton.smsplugin.ui.cb */
/* loaded from: classes.dex */
class C4147cb extends Thread {

    /* renamed from: a */
    ArrayList<C3855a> f15431a;

    /* renamed from: b */
    final /* synthetic */ C4132bn f15432b;

    /* renamed from: c */
    private final PowerManager.WakeLock f15433c;

    /* renamed from: d */
    private final long f15434d;

    public C4147cb(C4132bn c4132bn, String str, ArrayList<C3855a> arrayList, long j) {
        this.f15432b = c4132bn;
        this.f15431a = arrayList;
        this.f15434d = j;
        this.f15433c = ((PowerManager) c4132bn.f15387c.getSystemService("power")).newWakeLock(536870918, "Mms/MessageOptions");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws IOException {
        String message;
        this.f15433c.acquire();
        OutputStream outputStream = null;
        for (int i = 0; i < this.f15431a.size(); i++) {
            try {
                C3855a c3855a = this.f15431a.get(i);
                if (!"text/plain".equals(c3855a.m14744a()) && !"application/smil".equals(c3855a.m14744a()) && this.f15434d > 0) {
                    try {
                        message = this.f15432b.f15387c.getString(this.f15432b.m16366a(this.f15434d, c3855a) ? R.string.copy_to_sdcard_success : R.string.copy_to_sdcard_fail);
                    } catch (IOException e) {
                        message = e.getMessage();
                        if ("No space left on device".equals(message)) {
                            message = this.f15432b.f15387c.getString(R.string.not_enough_memory_msg);
                        }
                    }
                    this.f15432b.f15402x.post(new RunnableC4144bz(this.f15432b, message));
                }
            } finally {
                if (0 != 0) {
                    try {
                        outputStream.close();
                    } catch (IOException e2) {
                    }
                }
                this.f15433c.release();
            }
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.f15433c != null && this.f15433c.isHeld()) {
            this.f15433c.release();
        }
    }
}
