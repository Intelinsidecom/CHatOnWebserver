package com.sec.chaton;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.C0096i;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.util.C4822an;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.ea */
/* loaded from: classes.dex */
class C2307ea implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ TabActivity f8230a;

    C2307ea(TabActivity tabActivity) {
        this.f8230a = tabActivity;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) {
        int i2 = 0;
        if (this.f8230a.f2032A) {
            if (cursor != null) {
                this.f8230a.m3020a(cursor);
            }
            this.f8230a.f2033B = true;
            this.f8230a.f2036E = true;
            this.f8230a.f2034C = true;
            this.f8230a.f2035D = true;
            return;
        }
        if (i == 1) {
            if (cursor != null) {
                this.f8230a.f2037F = cursor.getCount();
                this.f8230a.m3020a(cursor);
                if (this.f8230a.f2037F > 0) {
                    C0991aa.m6037a().m18962d(new C0993ac(EnumC1005ad.ADDED, ""));
                }
            }
            this.f8230a.m3061o();
            return;
        }
        if (i == 2) {
            this.f8230a.f2039H = 0;
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    TabActivity.m3035c(this.f8230a, cursor.getInt(cursor.getColumnIndex("inbox_unread_count")));
                    TabActivity.m3035c(this.f8230a, cursor.getInt(cursor.getColumnIndex("sms_unread_count")));
                }
                this.f8230a.m3020a(cursor);
            }
            this.f8230a.m3061o();
            return;
        }
        if (i == 3) {
            if (cursor != null) {
                this.f8230a.f2038G = cursor.getCount();
                this.f8230a.m3020a(cursor);
                if (this.f8230a.f2038G > 0) {
                    C0096i.m358a(this.f8230a.getApplicationContext()).m363a(new Intent("buddy_tab_badge_update"));
                }
            }
            this.f8230a.m3061o();
            return;
        }
        if (i == 4) {
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    i2 = i2 + cursor.getInt(cursor.getColumnIndex("inbox_unread_count")) + cursor.getInt(cursor.getColumnIndex("sms_unread_count"));
                }
                this.f8230a.m3020a(cursor);
            }
            C4822an.m18222b(this.f8230a.f2040I);
            C4822an.m18210a(i2);
            C4822an.m18200J();
            this.f8230a.m3061o();
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7099a(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7101a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: b */
    public void mo7102b(int i, Object obj, int i2) {
    }
}
