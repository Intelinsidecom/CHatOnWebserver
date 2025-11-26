package com.sec.chaton.trunk;

import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0502i;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.trunk.database.C1174b;
import com.sec.chaton.trunk.database.p046a.C1172a;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;

/* compiled from: TrunkView.java */
/* renamed from: com.sec.chaton.trunk.j */
/* loaded from: classes.dex */
class HandlerC1184j extends Handler {

    /* renamed from: a */
    final /* synthetic */ TrunkView f4054a;

    HandlerC1184j(TrunkView trunkView) {
        this.f4054a = trunkView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f4054a.f3854w) {
            if (C1341p.f4580d) {
                C1341p.m4661d("TrunkView is destoried.", TrunkView.f3825b);
                return;
            }
            return;
        }
        C0259g c0259g = (C0259g) message.obj;
        this.f4054a.f3852u = null;
        switch (message.what) {
            case 902:
                if (C1341p.f4578b) {
                    C1341p.m4658b("Response: TrunkMessageControl.METHOD_GET_ITEM_LIST", TrunkView.f3825b);
                }
                if (c0259g.m928b() == EnumC0518y.SUCCESS) {
                    if (this.f4054a.f3849r) {
                        this.f4054a.m4069c();
                    }
                    if (!this.f4054a.f3828C) {
                        this.f4054a.f3828C = true;
                        Cursor cursorM4246a = new C1174b().m4247a("trunk_item").m4246a(C1172a.m4229a().getWritableDatabase(), null, null, "registration_time DESC");
                        try {
                            if (cursorM4246a.getCount() < 30) {
                                this.f4054a.f3827B = null;
                            } else {
                                cursorM4246a.moveToPosition(29);
                                this.f4054a.f3827B = cursorM4246a.getString(cursorM4246a.getColumnIndex("item_id"));
                            }
                            this.f4054a.f3841j.setOnScrollListener(new C1116an(this));
                        } finally {
                            if (cursorM4246a != null) {
                                cursorM4246a.close();
                            }
                        }
                    }
                } else {
                    this.f4054a.m4076f();
                    if (this.f4054a.f3846o != null) {
                        this.f4054a.f3846o.setSelection(this.f4054a.f3848q.ordinal());
                    }
                    if (this.f4054a.f3847p.getCount() == 0) {
                        this.f4054a.m4060a(EnumC1182h.NetworkError);
                    }
                    int iM2526a = C0502i.m2526a(GlobalApplication.m3100a());
                    if (-3 == iM2526a || -2 == iM2526a) {
                        this.f4054a.m4065b();
                    } else {
                        C1619g.m5889a(this.f4054a.f3836e, this.f4054a.f3836e.getResources().getString(R.string.toast_network_unable), 1).show();
                    }
                }
                this.f4054a.f3849r = false;
                return;
            default:
                return;
        }
    }
}
