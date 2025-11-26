package com.sec.chaton.msgbox;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.R;
import com.sec.chaton.chat.notification.C1103a;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.util.C3250y;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.k */
/* loaded from: classes.dex */
class C1724k implements InterfaceC1378v {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f6390a;

    C1724k(MsgboxFragment msgboxFragment) {
        this.f6390a = msgboxFragment;
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onUpdateComplete(int i, Object obj, int i2) {
        C3250y.m11454d("result:" + i2);
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        if (this.f6390a.f6237F) {
            C3250y.m11456e("[MSGBOX] onQueryComplete() mIsPause start close cursor", getClass().getSimpleName());
            if (cursor != null) {
                this.f6390a.m7031e(cursor);
            }
            C3250y.m11456e("[MSGBOX] onQueryComplete() mIsPause end close cursor", getClass().getSimpleName());
            if (i == 1) {
                this.f6390a.f6243L = true;
                return;
            }
            return;
        }
        if (this.f6390a.getActivity() == null) {
            this.f6390a.f6243L = true;
            return;
        }
        switch (i) {
            case 1:
                this.f6390a.f6270j.setVisibility(8);
                C3250y.m11456e("[MSGBOX] onQueryComplete() QUERY_MSGBOX", getClass().getSimpleName());
                if (cursor == null || cursor.getCount() == 0) {
                    this.f6390a.f6269i.setVisibility(0);
                    this.f6390a.f6268h.setVisibility(8);
                    if (this.f6390a.f6252U != null) {
                        this.f6390a.f6252U.setEnabled(false);
                        this.f6390a.f6252U.setImageResource(R.drawable.input_ic_delete_disable);
                    }
                } else {
                    this.f6390a.f6269i.setVisibility(8);
                    this.f6390a.f6268h.setVisibility(0);
                    if (this.f6390a.f6252U != null && !this.f6390a.f6252U.isEnabled()) {
                        this.f6390a.f6252U.setEnabled(true);
                        this.f6390a.f6252U.setImageResource(R.drawable.input_ic_delete);
                    }
                }
                if (this.f6390a.f6248Q) {
                    this.f6390a.m7035f(cursor);
                } else {
                    Cursor cursorSwapCursor = this.f6390a.f6274n.swapCursor(cursor);
                    this.f6390a.m7035f(cursor);
                    if (cursorSwapCursor != null) {
                        this.f6390a.m7031e(cursorSwapCursor);
                    }
                }
                this.f6390a.m7040h();
                break;
            case 2:
                this.f6390a.f6277q.clear();
                if (cursor == null || cursor.getCount() == 0) {
                    if (cursor != null) {
                        this.f6390a.m7031e(cursor);
                        return;
                    }
                    return;
                } else {
                    while (cursor.moveToNext()) {
                        this.f6390a.f6277q.add(cursor.getString(cursor.getColumnIndex("participants_buddy_no")));
                    }
                    if (cursor != null) {
                        this.f6390a.m7031e(cursor);
                        break;
                    }
                }
                break;
            default:
                if ((cursor == null || cursor.getCount() == 0) && cursor != null) {
                    this.f6390a.m7031e(cursor);
                    break;
                }
                break;
        }
        if (this.f6390a.f6244M) {
            this.f6390a.f6244M = false;
        }
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onDeleteComplete(int i, Object obj, int i2) throws Throwable {
        if (i == 1) {
            C1103a.m5432a(this.f6390a.getActivity()).m5454a(this.f6390a.f6278r, C1103a.f4446h);
        }
    }
}
