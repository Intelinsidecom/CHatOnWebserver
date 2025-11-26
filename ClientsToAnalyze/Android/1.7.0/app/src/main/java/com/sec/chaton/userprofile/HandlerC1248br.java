package com.sec.chaton.userprofile;

import android.content.ContentValues;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p025d.C0667t;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;

/* compiled from: RelationshipRankFragment2.java */
/* renamed from: com.sec.chaton.userprofile.br */
/* loaded from: classes.dex */
class HandlerC1248br extends Handler {

    /* renamed from: a */
    final /* synthetic */ RelationshipRankFragment2 f4330a;

    HandlerC1248br(RelationshipRankFragment2 relationshipRankFragment2) {
        this.f4330a = relationshipRankFragment2;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0259g c0259g = (C0259g) message.obj;
        if (message.what == 1103) {
            if (!c0259g.m927a() || c0259g.m928b() == EnumC0518y.ERROR) {
                if (this.f4330a.f4216x != null) {
                    this.f4330a.f4216x.dismiss();
                }
                C1619g.m5888a(this.f4330a.f4195b, R.string.popup_no_network_connection, 0).show();
            } else {
                this.f4330a.f4218z.m746a();
                C1341p.m4658b("Start InteractionSyncTask", getClass().getSimpleName());
            }
        }
        if (message.what == 1101) {
            if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("buddy_relation_hide", "Y");
                RelationshipRankFragment2.f4189g.startUpdate(0, null, C0667t.f2310a, contentValues, "buddy_no = ? ", new String[]{this.f4330a.f4217y});
            } else {
                C1619g.m5888a(this.f4330a.f4195b, R.string.popup_no_network_connection, 0).show();
            }
            if (this.f4330a.f4216x != null) {
                this.f4330a.f4216x.dismiss();
            }
        }
    }
}
