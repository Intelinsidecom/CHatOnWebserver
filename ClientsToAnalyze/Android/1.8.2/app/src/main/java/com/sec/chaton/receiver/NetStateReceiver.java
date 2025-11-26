package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.content.LocalBroadcastManager;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.C0639k;
import com.sec.chaton.p015d.p016a.AsyncTaskC0534ab;
import com.sec.chaton.p017e.C0694i;
import com.sec.chaton.p017e.p018a.C0665i;
import com.sec.chaton.p022h.C0810t;
import com.sec.chaton.util.C1786r;

/* loaded from: classes.dex */
public class NetStateReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        LocalBroadcastManager.getInstance(GlobalApplication.m3260b()).sendBroadcast(intent);
        if (intent.getAction() != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            C1786r.m6061b("NetStateReceiver_onReceive", getClass().getSimpleName());
            C0810t.m3429c();
            Cursor cursorQuery = GlobalApplication.m3260b().getContentResolver().query(C0694i.f2616a, new String[]{"inbox_no"}, null, null, null);
            if (cursorQuery != null && cursorQuery.getCount() != 0) {
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(0);
                    if (C0639k.m2914b(string) != null && C0639k.m2914b(string).f2485c != null) {
                        C1786r.m6068g("NetStateReceiver_onReceive", "Inbox No: " + string);
                        for (Long l : C0639k.m2914b(string).f2485c.keySet()) {
                            if (C0639k.m2914b(string).f2485c.containsKey(l)) {
                                ((AsyncTaskC0534ab) C0639k.m2914b(string).f2485c.get(l)).cancel(true);
                                C0665i.m3049a(GlobalApplication.m3260b().getContentResolver(), l);
                            }
                        }
                    }
                }
            }
        }
    }
}
