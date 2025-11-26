package com.sec.chaton.settings;

import android.database.Cursor;
import android.net.Uri;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.util.C3250y;

/* compiled from: ActivityChat.java */
/* renamed from: com.sec.chaton.settings.s */
/* loaded from: classes.dex */
class C2721s implements InterfaceC1378v {

    /* renamed from: a */
    final /* synthetic */ ActivityChat f10044a;

    C2721s(ActivityChat activityChat) {
        this.f10044a = activityChat;
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onUpdateComplete(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onDeleteComplete(int i, Object obj, int i2) {
        if (i == 1) {
            this.f10044a.f8944f.dismiss();
            switch (i2) {
                case -1:
                    Toast.makeText(this.f10044a.f8941c, R.string.settings_chat_delete_old_chat_rooms_failed_toast, 0).show();
                    if (C3250y.f11733a) {
                        C3250y.m11456e("No old Chatroom", getClass().getSimpleName());
                        break;
                    }
                    break;
                case 0:
                    Toast.makeText(this.f10044a.f8941c, R.string.settings_chat_delete_old_chat_rooms_success_toast, 0).show();
                    if (C3250y.f11733a) {
                        C3250y.m11456e("Delete old Chat Rooms", getClass().getSimpleName());
                        break;
                    }
                    break;
                case 1:
                case 2:
                    Toast.makeText(this.f10044a.f8941c, R.string.settings_chat_delete_old_chat_rooms_no_chatroom_toast, 0).show();
                    if (C3250y.f11733a) {
                        C3250y.m11456e("No old Chatroom", getClass().getSimpleName());
                        break;
                    }
                    break;
                default:
                    if (C3250y.f11733a) {
                        C3250y.m11456e("Delete old failed", getClass().getSimpleName());
                        break;
                    }
                    break;
            }
        }
    }
}
