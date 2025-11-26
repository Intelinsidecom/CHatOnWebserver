package com.sec.chaton.msgbox;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.R;
import com.sec.chaton.p025d.p026a.InterfaceC0626f;
import com.sec.chaton.util.C1341p;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.q */
/* loaded from: classes.dex */
class C0752q implements InterfaceC0626f {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f2556a;

    C0752q(MsgboxFragment msgboxFragment) {
        this.f2556a = msgboxFragment;
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo879a(int i, Object obj, int i2) {
        C1341p.m4659c("result:" + i2);
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo880a(int i, Object obj, Cursor cursor) {
        if (this.f2556a.f2494H) {
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        if (this.f2556a.getActivity() != null) {
            if (i == 1) {
                if (cursor == null || cursor.getCount() == 0) {
                    this.f2556a.getView().findViewById(R.id.msg_no).setVisibility(0);
                    this.f2556a.getView().findViewById(R.id.linList).setVisibility(8);
                } else {
                    this.f2556a.getView().findViewById(R.id.msg_no).setVisibility(8);
                    this.f2556a.getView().findViewById(R.id.linList).setVisibility(0);
                }
                this.f2556a.f2502h = cursor;
                this.f2556a.f2502h = this.f2556a.f2501g.swapCursor(cursor);
                if (this.f2556a.f2502h != null) {
                    this.f2556a.f2502h.close();
                    return;
                }
                return;
            }
            if (i == 2) {
                this.f2556a.f2505k.clear();
                if (cursor == null || cursor.getCount() == 0) {
                    if (cursor != null) {
                        cursor.close();
                    }
                } else {
                    while (cursor.moveToNext()) {
                        this.f2556a.f2505k.add(cursor.getString(cursor.getColumnIndex("participants_buddy_no")));
                    }
                    cursor.close();
                }
            }
        }
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo881a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: b */
    public void mo882b(int i, Object obj, int i2) {
    }
}
