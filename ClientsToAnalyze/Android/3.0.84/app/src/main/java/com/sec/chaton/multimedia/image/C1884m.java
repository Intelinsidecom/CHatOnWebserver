package com.sec.chaton.multimedia.image;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.util.C3250y;

/* compiled from: ImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.m */
/* loaded from: classes.dex */
class C1884m implements InterfaceC1378v {

    /* renamed from: a */
    final /* synthetic */ ImagePagerActivity f7167a;

    C1884m(ImagePagerActivity imagePagerActivity) {
        this.f7167a = imagePagerActivity;
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        if (i == 1) {
            if (cursor != null) {
                try {
                    this.f7167a.f6915i = cursor.getCount();
                    int i2 = 0;
                    int i3 = 0;
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(cursor.getColumnIndex("message_sender"));
                        long j = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
                        long j2 = cursor.getLong(cursor.getColumnIndex("_id"));
                        String string2 = cursor.getString(cursor.getColumnIndex("message_content"));
                        String string3 = cursor.getString(cursor.getColumnIndex("message_download_uri"));
                        EnumC1455w enumC1455wM6358a = EnumC1455w.m6358a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
                        int i4 = cursor.getInt(cursor.getColumnIndex("message_type"));
                        int i5 = this.f7167a.f6910d == j ? i2 : i3;
                        C1891t c1891t = new C1891t(this.f7167a, string, j, j2, string2, string3, enumC1455wM6358a, i4);
                        if (C3250y.f11734b) {
                            C3250y.m11450b("add item : " + c1891t, ImagePagerActivity.f6898b);
                        }
                        this.f7167a.f6924r.put(Integer.valueOf(i2), Long.valueOf(j));
                        this.f7167a.f6923q.put(Long.valueOf(j), c1891t);
                        i2++;
                        i3 = i5;
                    }
                    this.f7167a.f6909c.setCurrentItem(i3);
                    this.f7167a.f6916j = i3;
                    this.f7167a.m7579a(i3);
                    return;
                } finally {
                }
            }
            return;
        }
        if (i == 2 && cursor != null) {
            try {
                if (cursor.getCount() > this.f7167a.f6915i) {
                    this.f7167a.f6915i = cursor.getCount();
                    int i6 = 0;
                    while (true) {
                        int i7 = i6;
                        if (!cursor.moveToNext()) {
                            break;
                        }
                        String string4 = cursor.getString(cursor.getColumnIndex("message_sender"));
                        long j3 = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
                        C1891t c1891t2 = new C1891t(this.f7167a, string4, j3, cursor.getLong(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("message_content")), cursor.getString(cursor.getColumnIndex("message_download_uri")), EnumC1455w.m6358a(cursor.getInt(cursor.getColumnIndex("message_content_type"))), cursor.getInt(cursor.getColumnIndex("message_type")));
                        if (C3250y.f11734b) {
                            C3250y.m11450b("add item : " + c1891t2, ImagePagerActivity.f6898b);
                        }
                        this.f7167a.f6924r.put(Integer.valueOf(i7), Long.valueOf(j3));
                        this.f7167a.f6923q.put(Long.valueOf(j3), c1891t2);
                        i6 = i7 + 1;
                    }
                }
            } finally {
            }
        }
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onUpdateComplete(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
