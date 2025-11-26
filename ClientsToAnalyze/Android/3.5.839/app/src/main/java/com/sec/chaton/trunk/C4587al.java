package com.sec.chaton.trunk;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.sec.chaton.R;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: TrunkDetailActivity.java */
/* renamed from: com.sec.chaton.trunk.al */
/* loaded from: classes.dex */
class C4587al implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ TrunkDetailActivity f16696a;

    C4587al(TrunkDetailActivity trunkDetailActivity) {
        this.f16696a = trunkDetailActivity;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) {
        if (i == 0) {
            Bundle bundle = new Bundle();
            if (cursor == null || cursor.getCount() < 1) {
                C5179v.m19810a(CommonApplication.m18732r(), R.string.shortcut_group_broadcast_chat_room_closed, 0).show();
                this.f16696a.finish();
                return;
            }
            try {
                cursor.moveToFirst();
                boolean zEquals = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_valid")));
                String string = cursor.getString(cursor.getColumnIndex("inbox_no"));
                if (string != null) {
                    bundle.putString("sessionId", this.f16696a.f16464t);
                    bundle.putString("inboxNo", string);
                    bundle.putString("itemId", this.f16696a.f16465u);
                    bundle.putBoolean("isvalid", zEquals);
                    if (C4904y.f17872b) {
                        C4904y.m18639b("session id : " + this.f16696a.f16464t, TrunkDetailActivity.f16458p);
                        C4904y.m18639b("inbox no : " + string, TrunkDetailActivity.f16458p);
                        C4904y.m18639b("item id : " + this.f16696a.f16465u, TrunkDetailActivity.f16458p);
                        C4904y.m18639b("isvalid : " + zEquals, TrunkDetailActivity.f16458p);
                    }
                    this.f16696a.f16461q.setArguments(bundle);
                    this.f16696a.m17293a(bundle);
                }
            } finally {
                cursor.close();
            }
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7101a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7099a(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: b */
    public void mo7102b(int i, Object obj, int i2) {
    }
}
