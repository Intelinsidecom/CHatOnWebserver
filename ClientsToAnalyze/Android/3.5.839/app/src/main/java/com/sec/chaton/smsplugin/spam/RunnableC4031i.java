package com.sec.chaton.smsplugin.spam;

import android.os.Message;
import com.sec.chaton.R;
import java.util.ArrayList;

/* compiled from: ManageSpamMessages.java */
/* renamed from: com.sec.chaton.smsplugin.spam.i */
/* loaded from: classes.dex */
class RunnableC4031i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ DialogInterfaceOnClickListenerC4030h f14536a;

    RunnableC4031i(DialogInterfaceOnClickListenerC4030h dialogInterfaceOnClickListenerC4030h) {
        this.f14536a = dialogInterfaceOnClickListenerC4030h;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f14536a.f14533a.size(); i++) {
            if (this.f14536a.f14534b.moveToPosition(((Integer) this.f14536a.f14533a.get(i)).intValue())) {
                arrayList.add(new C4034l(this.f14536a.f14535c, this.f14536a.f14534b.getLong(this.f14536a.f14534b.getColumnIndexOrThrow("_id")), this.f14536a.f14534b.getString(this.f14536a.f14534b.getColumnIndexOrThrow("transport_type"))));
            }
        }
        for (int i2 = 0; i2 < this.f14536a.f14533a.size(); i2++) {
            this.f14536a.f14535c.m15299b((C4034l) arrayList.get(i2));
        }
        this.f14536a.f14535c.m15296b();
        this.f14536a.f14535c.getResources();
        this.f14536a.f14535c.f14294l.setText(R.string.delete_complete);
        this.f14536a.f14535c.f14294l.show();
        Message.obtain(this.f14536a.f14535c.f14298p, 0).sendToTarget();
    }
}
