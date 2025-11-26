package com.sec.chaton.shop;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.R;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.widget.C5179v;

/* compiled from: ShopMultiDownloadRingTone.java */
/* renamed from: com.sec.chaton.shop.z */
/* loaded from: classes.dex */
class C3777z implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ C3773v f13543a;

    C3777z(C3773v c3773v) {
        this.f13543a = c3773v;
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
                                if (this.f13543a.f13526d.contains(string)) {
                                    this.f13543a.f13526d.remove(string);
                                }
                            } while (cursor.moveToNext());
                        }
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
                this.f13543a.f13531i = this.f13543a.f13526d.size();
                if (this.f13543a.f13531i > 0) {
                    if (!((Activity) this.f13543a.f13525c).isFinishing()) {
                        this.f13543a.m14175c();
                        return;
                    }
                    return;
                }
                C5179v.m19810a(this.f13543a.f13525c, R.string.already_downloaded, 0).show();
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
