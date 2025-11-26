package com.samsung.spen.lib.input.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.samsung.spensdk.applistener.SPenDetachmentListener;

/* loaded from: classes.dex */
public class SPenDetachmentReceiver extends BroadcastReceiver {

    /* renamed from: a */
    SPenDetachmentListener f2042a = null;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null && action.equals("com.samsung.pen.INSERT")) {
            boolean booleanExtra = intent.getBooleanExtra("penInsert", false);
            if (this.f2042a != null) {
                this.f2042a.onSPenDetached(booleanExtra ? false : true);
            }
        }
    }

    /* renamed from: a */
    public void m1991a(SPenDetachmentListener sPenDetachmentListener) {
        this.f2042a = sPenDetachmentListener;
    }
}
