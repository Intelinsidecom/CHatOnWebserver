package com.sec.chaton.msgbox;

import android.content.res.Resources;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButton;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.w */
/* loaded from: classes.dex */
class C1736w implements SlookAirButton.ItemSelectListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f6409a;

    C1736w(MsgboxFragment msgboxFragment) {
        this.f6409a = msgboxFragment;
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButton.ItemSelectListener
    public void onItemSelected(View view, int i, Object obj) throws Resources.NotFoundException {
        if (obj != null) {
            Cursor cursor = (Cursor) this.f6409a.getListAdapter().getItem(((Integer) obj).intValue());
            String string = cursor.getString(cursor.getColumnIndex("buddy_no"));
            if (!TextUtils.isEmpty(string) && string.startsWith("0999")) {
                if (i == 0) {
                    this.f6409a.m7017b(cursor);
                    return;
                } else if (i == 1) {
                    this.f6409a.m7022c(cursor);
                    return;
                } else {
                    if (i == 2) {
                        this.f6409a.m7027d(cursor);
                        return;
                    }
                    return;
                }
            }
            if (i == 0) {
                this.f6409a.m7001a(cursor);
                return;
            }
            if (i == 1) {
                this.f6409a.m7017b(cursor);
            } else if (i == 2) {
                this.f6409a.m7022c(cursor);
            } else if (i == 3) {
                this.f6409a.m7027d(cursor);
            }
        }
    }
}
