package com.sec.chaton.settings;

import android.content.ContentValues;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p013a.C0197aj;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p025d.C0667t;
import com.sec.widget.C1619g;

/* compiled from: RelationHideFragment.java */
/* renamed from: com.sec.chaton.settings.bh */
/* loaded from: classes.dex */
class HandlerC1037bh extends Handler {

    /* renamed from: a */
    final /* synthetic */ RelationHideFragment f3641a;

    HandlerC1037bh(RelationHideFragment relationHideFragment) {
        this.f3641a = relationHideFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0259g c0259g = (C0259g) message.obj;
        if (message.what == 1102) {
            if (!c0259g.m927a() || c0259g.m928b() == EnumC0518y.ERROR) {
                C1619g.m5888a(this.f3641a.f3581h, R.string.popup_no_network_connection, 0).show();
            }
            if (RelationHideFragment.f3575b != null) {
                RelationHideFragment.f3575b.dismiss();
            }
        }
        if (message.what == 1103) {
            if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
                new C0197aj(this.f3641a.f3589p).m746a();
            } else {
                if (RelationHideFragment.f3575b != null) {
                    RelationHideFragment.f3575b.dismiss();
                }
                C1619g.m5888a(this.f3641a.f3581h, R.string.popup_no_network_connection, 0).show();
            }
        }
        if (message.what == 1101) {
            if (!c0259g.m927a() || c0259g.m928b() == EnumC0518y.ERROR) {
                C1619g.m5888a(this.f3641a.f3581h, R.string.popup_no_network_connection, 0).show();
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put("buddy_relation_hide", "N");
                this.f3641a.f3587n.startUpdate(0, null, C0667t.f2310a, contentValues, "buddy_no = ? ", new String[]{this.f3641a.f3588o});
            }
            if (RelationHideFragment.f3575b != null) {
                RelationHideFragment.f3575b.dismiss();
            }
        }
    }
}
