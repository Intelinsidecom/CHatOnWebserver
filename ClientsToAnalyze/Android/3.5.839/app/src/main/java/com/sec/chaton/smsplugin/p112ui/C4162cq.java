package com.sec.chaton.smsplugin.p112ui;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.R;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;

/* compiled from: MessagingInfoActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.cq */
/* loaded from: classes.dex */
class C4162cq implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ MessagingInfoActivity f15466a;

    C4162cq(MessagingInfoActivity messagingInfoActivity) {
        this.f15466a = messagingInfoActivity;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) {
        if (i == MessagingInfoActivity.f14854H) {
            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();
                if (this.f15466a.f14889aa == EnumC2300t.ONETOONE) {
                    this.f15466a.f14890ab = cursor.getString(cursor.getColumnIndex("buddy_no"));
                    this.f15466a.f14891ac = cursor.getInt(cursor.getColumnIndex("buddy_contact_buddy"));
                }
                this.f15466a.f14879Q.setText(this.f15466a.getString(R.string.chat_info_buddy_title, new Object[]{Integer.valueOf(cursor.getCount())}));
                this.f15466a.f14879Q.setVisibility(0);
            }
            this.f15466a.m15854h();
            Cursor cursorB = this.f15466a.f14888Z.mo877b(cursor);
            if (cursorB != null) {
                this.f15466a.m15842a(cursorB);
            }
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
