package com.sec.chaton.multimedia.image;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.util.C3250y;

/* compiled from: PostONImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.af */
/* loaded from: classes.dex */
class C1855af implements InterfaceC1378v {

    /* renamed from: a */
    final /* synthetic */ PostONImagePagerActivity f7083a;

    C1855af(PostONImagePagerActivity postONImagePagerActivity) {
        this.f7083a = postONImagePagerActivity;
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        int i2;
        if (i == this.f7083a.f6972a && cursor != null) {
            int i3 = 0;
            int i4 = 0;
            while (cursor.moveToNext()) {
                try {
                    if (this.f7083a.f6975f.equals(this.f7083a.f6976g)) {
                        string = cursor.getString(cursor.getColumnIndex("poston_no"));
                        string2 = cursor.getString(cursor.getColumnIndex("poston_metaid"));
                        string3 = cursor.getString(cursor.getColumnIndex("poston_metatype"));
                        string4 = cursor.getString(cursor.getColumnIndex("poston_url"));
                        string5 = cursor.getString(cursor.getColumnIndex("joined_my_poston"));
                        string6 = cursor.getString(cursor.getColumnIndex("joined_buddy_name"));
                        string7 = cursor.getString(cursor.getColumnIndex("poston_seq"));
                        string8 = cursor.getString(cursor.getColumnIndex("joined_my_poston_time"));
                        string9 = cursor.getString(cursor.getColumnIndex("joined_my_poston_comment_read"));
                        string10 = cursor.getString(cursor.getColumnIndex("joined_my_poston_comment_unread"));
                        string11 = cursor.getString(cursor.getColumnIndex("joined_buddy_no"));
                    } else {
                        string = cursor.getString(cursor.getColumnIndex("poston_no"));
                        string2 = cursor.getString(cursor.getColumnIndex("poston_metaid"));
                        string3 = cursor.getString(cursor.getColumnIndex("poston_metatype"));
                        string4 = cursor.getString(cursor.getColumnIndex("poston_url"));
                        string5 = cursor.getString(cursor.getColumnIndex("joined_buddy_poston"));
                        string6 = cursor.getString(cursor.getColumnIndex("joined_buddy_name"));
                        string7 = cursor.getString(cursor.getColumnIndex("poston_seq"));
                        string8 = cursor.getString(cursor.getColumnIndex("joined_buddy_poston_time"));
                        string9 = cursor.getString(cursor.getColumnIndex("joined_buddy_poston_comment_read"));
                        string10 = cursor.getString(cursor.getColumnIndex("joined_buddy_poston_comment_unread"));
                        string11 = cursor.getString(cursor.getColumnIndex("joined_buddy_no"));
                    }
                    if (string4.equals(this.f7083a.f6977h)) {
                        this.f7083a.f6980k = string;
                        i2 = i3;
                    } else {
                        i2 = i4;
                    }
                    C3250y.m11456e("getUrl(): " + string4, getClass().getSimpleName());
                    if (string3.equals("3")) {
                        this.f7083a.f6988s.put(string, string4);
                        i4 = i2;
                    } else {
                        if (C3250y.f11733a) {
                            C3250y.m11456e("PostON description : " + string5, PostONImagePagerActivity.f6962b);
                        }
                        this.f7083a.f6986q.put(string4, new C1859aj(this.f7083a, string, string2, string3, string4, string5, string6, string7, string8, string9, string10, string11));
                        this.f7083a.f6987r.put(Integer.valueOf(i3), string4);
                        i3++;
                        i4 = i2;
                    }
                } finally {
                    cursor.close();
                }
            }
            this.f7083a.f6973d.setCurrentItem(i4);
            this.f7083a.f6979j = i4;
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
