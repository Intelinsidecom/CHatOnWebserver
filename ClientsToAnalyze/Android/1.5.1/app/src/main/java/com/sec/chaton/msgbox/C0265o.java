package com.sec.chaton.msgbox;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.C0062R;
import com.sec.chaton.database.helper.NotifyingAsyncQueryHandler;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.msgbox.o */
/* loaded from: classes.dex */
class C0265o implements NotifyingAsyncQueryHandler.AsyncQueryListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f2006a;

    C0265o(MsgboxFragment msgboxFragment) {
        this.f2006a = msgboxFragment;
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: a */
    public void mo529a(int i, Object obj, int i2) {
        ChatONLogWriter.m3509d("result:" + i2);
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: a */
    public void mo530a(int i, Object obj, Cursor cursor) {
        if (this.f2006a.getActivity() == null) {
            return;
        }
        if (i == 1) {
            if (cursor == null || cursor.getCount() == 0) {
                this.f2006a.getView().findViewById(C0062R.id.msg_no).setVisibility(0);
                this.f2006a.getView().findViewById(C0062R.id.linList).setVisibility(8);
            } else {
                this.f2006a.getView().findViewById(C0062R.id.msg_no).setVisibility(8);
                this.f2006a.getView().findViewById(C0062R.id.linList).setVisibility(0);
            }
            this.f2006a.f1977p = cursor;
            this.f2006a.f1977p = this.f2006a.f1976o.swapCursor(cursor);
            if (this.f2006a.f1977p != null) {
                this.f2006a.f1977p.close();
                return;
            }
            return;
        }
        if (i == 2) {
            this.f2006a.f1980s.clear();
            if (cursor == null || cursor.getCount() == 0) {
                if (cursor != null) {
                    cursor.close();
                }
            } else {
                while (cursor.moveToNext()) {
                    this.f2006a.f1980s.add(cursor.getString(cursor.getColumnIndex("participants_buddy_no")));
                }
                cursor.close();
            }
        }
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: a */
    public void mo531a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: b */
    public void mo534b(int i, Object obj, int i2) {
    }
}
