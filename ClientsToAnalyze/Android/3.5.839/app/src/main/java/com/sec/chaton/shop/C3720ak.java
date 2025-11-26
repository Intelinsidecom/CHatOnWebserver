package com.sec.chaton.shop;

import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import com.sec.chaton.R;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.p057e.p058a.C2182ah;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ShopMultiDownloadSticker.java */
/* renamed from: com.sec.chaton.shop.ak */
/* loaded from: classes.dex */
class C3720ak implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ C3717ah f13387a;

    C3720ak(C3717ah c3717ah) {
        this.f13387a = c3717ah;
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
                                if (this.f13387a.f13373d.contains(string)) {
                                    this.f13387a.f13373d.remove(string);
                                }
                            } while (cursor.moveToNext());
                        }
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
                this.f13387a.f13378i = this.f13387a.f13373d.size();
                if (this.f13387a.f13378i > 0) {
                    if (!((Activity) this.f13387a.f13372c).isFinishing()) {
                        this.f13387a.m14036c();
                    }
                    ArrayList arrayList = new ArrayList();
                    Iterator it = this.f13387a.f13373d.iterator();
                    while (it.hasNext()) {
                        arrayList.add(C2182ah.m9742a(EnumC2258bd.Anicon.m10123a(), (String) it.next()));
                    }
                    try {
                        C4821am.m18190a(this.f13387a.f13372c, "com.sec.chaton.provider2", (ArrayList<ContentProviderOperation>) arrayList);
                        return;
                    } catch (OperationApplicationException e) {
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e, C3717ah.f13370b);
                            return;
                        }
                        return;
                    } catch (RemoteException e2) {
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e2, C3717ah.f13370b);
                            return;
                        }
                        return;
                    }
                }
                C5179v.m19810a(this.f13387a.f13372c, R.string.already_downloaded, 1).show();
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
