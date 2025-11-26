package com.sec.chaton.shop;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.R;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.widget.C5179v;

/* compiled from: ShopMultiDownloadSkin.java */
/* renamed from: com.sec.chaton.shop.ae */
/* loaded from: classes.dex */
class C3714ae implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ C3711ab f13365a;

    C3714ae(C3711ab c3711ab) {
        this.f13365a = c3711ab;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) {
        switch (i) {
            case 0:
                if (cursor != null) {
                    try {
                        if (cursor.getCount() > 0) {
                            cursor.moveToFirst();
                            do {
                                String string = cursor.getString(cursor.getColumnIndex("item_id"));
                                if (this.f13365a.f13351d.contains(string)) {
                                    this.f13365a.f13351d.remove(string);
                                }
                            } while (cursor.moveToNext());
                        }
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
                this.f13365a.f13356i = this.f13365a.f13351d.size();
                if (this.f13365a.f13356i > 0) {
                    if (!((Activity) this.f13365a.f13350c).isFinishing()) {
                        this.f13365a.m14014c();
                        return;
                    }
                    return;
                }
                C5179v.m19810a(this.f13365a.f13350c, R.string.already_downloaded, 0).show();
                return;
            default:
                return;
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
