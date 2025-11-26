package com.sec.chaton.trunk;

import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.trunk.p061c.C3025f;
import com.sec.chaton.trunk.p061c.EnumC3026g;
import com.sec.chaton.util.C3250y;

/* compiled from: TrunkPageActivity.java */
/* renamed from: com.sec.chaton.trunk.bu */
/* loaded from: classes.dex */
class C3013bu implements InterfaceC1378v {

    /* renamed from: a */
    final /* synthetic */ TrunkPageActivity f10861a;

    C3013bu(TrunkPageActivity trunkPageActivity) {
        this.f10861a = trunkPageActivity;
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onQueryComplete(int i, Object obj, Cursor cursor) throws Resources.NotFoundException {
        if (i == 1) {
            if (cursor != null) {
                this.f10861a.f10654p = cursor.getCount();
                this.f10861a.f10655q = cursor;
                int i2 = 0;
                this.f10861a.f10642c.clear();
                int i3 = 0;
                while (this.f10861a.f10655q.moveToNext()) {
                    String string = this.f10861a.f10655q.getString(this.f10861a.f10655q.getColumnIndex("sender_uid"));
                    String string2 = this.f10861a.f10655q.getString(this.f10861a.f10655q.getColumnIndex("sender_name"));
                    long j = this.f10861a.f10655q.getLong(this.f10861a.f10655q.getColumnIndex("registration_time"));
                    String string3 = this.f10861a.f10655q.getString(this.f10861a.f10655q.getColumnIndex("item_id"));
                    String string4 = this.f10861a.f10655q.getString(this.f10861a.f10655q.getColumnIndex("down_url"));
                    String string5 = this.f10861a.f10655q.getString(this.f10861a.f10655q.getColumnIndex("isams"));
                    EnumC3026g enumC3026gM10537a = C3025f.m10537a(this.f10861a.f10655q.getString(this.f10861a.f10655q.getColumnIndex("content_type")), "true".equals(string5));
                    int i4 = this.f10861a.f10655q.getInt(this.f10861a.f10655q.getColumnIndex("total_comment_count"));
                    String string6 = this.f10861a.f10655q.getString(this.f10861a.f10655q.getColumnIndex("item_description"));
                    int i5 = this.f10861a.f10655q.getInt(this.f10861a.f10655q.getColumnIndex("unread_comment_count"));
                    int i6 = this.f10861a.f10646h.equals(string3) ? i3 : i2;
                    if (this.f10861a.f10648j == null) {
                        this.f10861a.f10648j = this.f10861a.f10655q.getString(this.f10861a.f10655q.getColumnIndex("message_session_id"));
                    }
                    C3017by c3017by = new C3017by(this.f10861a, this.f10861a.f10648j, this.f10861a.f10647i, string, string2, j, string3, string5, string4, enumC3026gM10537a, i4, this.f10861a.f10643d, string6, i5);
                    if (C3250y.f11734b) {
                        C3250y.m11450b("add item : " + c3017by, TrunkPageActivity.f10632f);
                    }
                    this.f10861a.f10642c.add(c3017by);
                    i3++;
                    i2 = i6;
                }
                this.f10861a.f10645g.setCurrentItem(i2);
                this.f10861a.m10337a(i2);
                return;
            }
            return;
        }
        if (i == 2 && cursor != null && cursor.getCount() > 0) {
            cursor.moveToNext();
            int i7 = cursor.getInt(cursor.getColumnIndex("total_comment_count"));
            this.f10861a.f10642c.get(this.f10861a.f10656r).f10874j = i7;
            this.f10861a.m10343b(i7);
        }
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onUpdateComplete(int i, Object obj, int i2) {
        if (i == 1) {
        }
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
