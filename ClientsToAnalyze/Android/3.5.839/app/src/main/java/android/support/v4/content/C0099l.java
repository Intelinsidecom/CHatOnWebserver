package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

/* compiled from: LocalBroadcastManager.java */
/* renamed from: android.support.v4.content.l */
/* loaded from: classes.dex */
class C0099l {

    /* renamed from: a */
    final IntentFilter f326a;

    /* renamed from: b */
    final BroadcastReceiver f327b;

    /* renamed from: c */
    boolean f328c;

    C0099l(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
        this.f326a = intentFilter;
        this.f327b = broadcastReceiver;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("Receiver{");
        sb.append(this.f327b);
        sb.append(" filter=");
        sb.append(this.f326a);
        sb.append("}");
        return sb.toString();
    }
}
