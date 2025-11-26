package com.sec.chaton.trunk;

import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.trunk.p121c.C4641f;
import com.sec.chaton.trunk.p121c.EnumC4642g;
import com.sec.chaton.util.C4904y;

/* compiled from: TrunkPageActivity.java */
/* renamed from: com.sec.chaton.trunk.bx */
/* loaded from: classes.dex */
class C4632bx implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ TrunkPageActivity f16809a;

    C4632bx(TrunkPageActivity trunkPageActivity) {
        this.f16809a = trunkPageActivity;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) throws Resources.NotFoundException {
        if (i == 1) {
            if (cursor != null) {
                this.f16809a.f16579B = cursor.getCount();
                this.f16809a.f16580C = cursor;
                int i2 = 0;
                this.f16809a.f16603p.clear();
                int i3 = 0;
                while (this.f16809a.f16580C.moveToNext()) {
                    String string = this.f16809a.f16580C.getString(this.f16809a.f16580C.getColumnIndex("sender_uid"));
                    String string2 = this.f16809a.f16580C.getString(this.f16809a.f16580C.getColumnIndex("sender_name"));
                    long j = this.f16809a.f16580C.getLong(this.f16809a.f16580C.getColumnIndex("registration_time"));
                    String string3 = this.f16809a.f16580C.getString(this.f16809a.f16580C.getColumnIndex("item_id"));
                    String string4 = this.f16809a.f16580C.getString(this.f16809a.f16580C.getColumnIndex("down_url"));
                    String string5 = this.f16809a.f16580C.getString(this.f16809a.f16580C.getColumnIndex("isams"));
                    EnumC4642g enumC4642gM17614a = C4641f.m17614a(this.f16809a.f16580C.getString(this.f16809a.f16580C.getColumnIndex("content_type")), "true".equals(string5));
                    int i4 = this.f16809a.f16580C.getInt(this.f16809a.f16580C.getColumnIndex("total_comment_count"));
                    String string6 = this.f16809a.f16580C.getString(this.f16809a.f16580C.getColumnIndex("item_description"));
                    int i5 = this.f16809a.f16580C.getInt(this.f16809a.f16580C.getColumnIndex("unread_comment_count"));
                    int i6 = this.f16809a.f16607u.equals(string3) ? i3 : i2;
                    if (this.f16809a.f16609w == null) {
                        this.f16809a.f16609w = this.f16809a.f16580C.getString(this.f16809a.f16580C.getColumnIndex("message_session_id"));
                    }
                    C4645cc c4645cc = new C4645cc(this.f16809a, this.f16809a.f16609w, this.f16809a.f16608v, string, string2, j, string3, string5, string4, enumC4642gM17614a, i4, this.f16809a.f16604q, string6, i5);
                    if (C4904y.f17872b) {
                        C4904y.m18639b("add item : " + c4645cc, TrunkPageActivity.f16577s);
                    }
                    this.f16809a.f16603p.add(c4645cc);
                    i3++;
                    i2 = i6;
                }
                this.f16809a.f16610x.m617c();
                this.f16809a.f16606t.setCurrentItem(i2, false);
                this.f16809a.m17434a(i2);
                return;
            }
            return;
        }
        if (i == 2 && cursor != null && cursor.getCount() > 0) {
            cursor.moveToNext();
            int i7 = cursor.getInt(cursor.getColumnIndex("total_comment_count"));
            if (this.f16809a.f16581D < this.f16809a.f16603p.size()) {
                this.f16809a.f16603p.get(this.f16809a.f16581D).f16837j = i7;
            }
            this.f16809a.m17438b(i7);
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7101a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7099a(int i, Object obj, int i2) {
        if (i == 1) {
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: b */
    public void mo7102b(int i, Object obj, int i2) {
    }
}
