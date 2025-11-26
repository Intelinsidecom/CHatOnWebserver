package com.sec.chaton.trunk;

import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.trunk.database.C3050f;
import com.sec.chaton.trunk.database.p062a.C3045b;
import com.sec.chaton.util.C3228cp;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;

/* compiled from: TrunkView.java */
/* renamed from: com.sec.chaton.trunk.cf */
/* loaded from: classes.dex */
class HandlerC3032cf extends Handler {

    /* renamed from: a */
    final /* synthetic */ TrunkView f10913a;

    HandlerC3032cf(TrunkView trunkView) {
        this.f10913a = trunkView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f10913a.f10685a) {
            if (C3250y.f11736d) {
                C3250y.m11455d("TrunkView is destoried.", TrunkView.f10665c);
                return;
            }
            return;
        }
        C0267d c0267d = (C0267d) message.obj;
        this.f10913a.f10707x = null;
        switch (message.what) {
            case 902:
                if (C3250y.f11734b) {
                    C3250y.m11450b("Response: TrunkMessageControl.METHOD_GET_ITEM_LIST", TrunkView.f10665c);
                }
                if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                    if (this.f10913a.f10704u) {
                        this.f10913a.m10387d();
                    }
                    if (!this.f10913a.f10668C) {
                        this.f10913a.f10668C = true;
                        Cursor cursorM10576a = new C3050f().m10577a("trunk_item").m10576a(C3045b.m10571a().getWritableDatabase(), null, null, "registration_time DESC");
                        try {
                            if (cursorM10576a.getCount() < 30) {
                                this.f10913a.f10667B = null;
                            } else {
                                cursorM10576a.moveToPosition(29);
                                this.f10913a.f10667B = cursorM10576a.getString(cursorM10576a.getColumnIndex("item_id"));
                            }
                            this.f10913a.f10696m.setOnScrollListener(new C3033cg(this));
                        } finally {
                            if (cursorM10576a != null) {
                                cursorM10576a.close();
                            }
                        }
                    }
                } else {
                    this.f10913a.m10394g();
                    if (this.f10913a.f10701r != null) {
                        this.f10913a.f10701r.setSelection(this.f10913a.f10703t.ordinal());
                    }
                    if (this.f10913a.f10702s.getCount() == 0) {
                        this.f10913a.m10373a(EnumC3041co.NetworkError);
                    }
                    int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
                    if (-3 == iM6733a || -2 == iM6733a) {
                        this.f10913a.m10372a(EnumC3040cn.Nonetwork);
                    } else {
                        this.f10913a.m10372a(EnumC3040cn.NetworkErr);
                    }
                }
                this.f10913a.f10704u = false;
                return;
            case 908:
                if (this.f10913a.f10674I != null) {
                    this.f10913a.f10674I.dismiss();
                }
                if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                    C3641ai.m13210a(this.f10913a.f10690g, R.string.trunk_toast_deleted, 1).show();
                    this.f10913a.f10677L = false;
                    this.f10913a.f10702s.m10606b();
                    this.f10913a.f10671F.setChecked(false);
                    this.f10913a.m10373a(EnumC3041co.TrunkMode);
                } else {
                    int iM6733a2 = C1594v.m6733a(CommonApplication.m11493l());
                    if (-3 == iM6733a2 || -2 == iM6733a2) {
                        this.f10913a.m10372a(EnumC3040cn.Nonetwork);
                    } else if (c0267d.m1355f() == 80210) {
                        C3641ai.m13210a(this.f10913a.f10690g, R.string.buddy_information_changed, 1).show();
                        this.f10913a.f10695l = false;
                        this.f10913a.f10702s.m10606b();
                        this.f10913a.f10671F.setChecked(false);
                        this.f10913a.m10373a(EnumC3041co.TrunkMode);
                        this.f10913a.f10675J.findItem(R.id.btnDeleteMode).setEnabled(false);
                        C3228cp.m11343a(this.f10913a.f10675J.findItem(R.id.btnDeleteMode));
                        this.f10913a.m10381b(false);
                    } else {
                        this.f10913a.m10372a(EnumC3040cn.NetworkErr);
                    }
                }
                if (GlobalApplication.m6456e()) {
                    this.f10913a.f10681P.setVisibility(0);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
