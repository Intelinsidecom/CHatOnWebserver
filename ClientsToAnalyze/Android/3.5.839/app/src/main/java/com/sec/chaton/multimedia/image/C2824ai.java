package com.sec.chaton.multimedia.image;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.util.C4904y;

/* compiled from: PostONImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.ai */
/* loaded from: classes.dex */
class C2824ai implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ PostONImagePagerActivity f10394a;

    C2824ai(PostONImagePagerActivity postONImagePagerActivity) {
        this.f10394a = postONImagePagerActivity;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) {
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
        if (i == this.f10394a.f10292n && cursor != null) {
            int i3 = 0;
            int i4 = 0;
            while (cursor.moveToNext()) {
                try {
                    if (this.f10394a.f10295s.equals(this.f10394a.f10296t)) {
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
                    if (string4.equals(this.f10394a.f10297u)) {
                        this.f10394a.f10300x = string;
                        i2 = i3;
                    } else {
                        i2 = i4;
                    }
                    C4904y.m18646e("getUrl(): " + string4, getClass().getSimpleName());
                    if (string3.equals("3")) {
                        this.f10394a.f10274G.put(string, string4);
                        i4 = i2;
                    } else {
                        if (C4904y.f17871a) {
                            C4904y.m18646e("PostON description : " + string5, PostONImagePagerActivity.f10266o);
                        }
                        this.f10394a.f10272E.put(string4, new C2828am(this.f10394a, string, string2, string3, string4, string5, string6, string7, string8, string9, string10, string11));
                        this.f10394a.f10273F.put(Integer.valueOf(i3), string4);
                        i3++;
                        i4 = i2;
                    }
                } finally {
                    cursor.close();
                }
            }
            this.f10394a.f10294r.m617c();
            this.f10394a.f10293q.setCurrentItem(i4, false);
            this.f10394a.f10299w = i4;
            this.f10394a.m11849a(i4);
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
