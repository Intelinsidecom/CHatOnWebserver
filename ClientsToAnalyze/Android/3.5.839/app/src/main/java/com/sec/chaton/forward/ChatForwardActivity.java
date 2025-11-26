package com.sec.chaton.forward;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.sec.chaton.C1071bk;
import com.sec.chaton.EnumC1094bm;
import com.sec.chaton.TabActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.msgbox.InterfaceC2653br;
import com.sec.chaton.p057e.C2220ah;
import com.sec.common.CommonApplication;

/* loaded from: classes.dex */
public class ChatForwardActivity extends BaseSinglePaneActivity implements InterfaceC2653br {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        return new ChatForwardFragment();
    }

    @Override // com.sec.chaton.msgbox.InterfaceC2653br
    /* renamed from: a */
    public void mo10255a(Cursor cursor, Bundle bundle, EnumC1094bm enumC1094bm) {
        String string;
        Cursor cursorQuery = null;
        String string2 = cursor.getString(cursor.getColumnIndex("inbox_no"));
        String string3 = cursor.getString(cursor.getColumnIndex("buddy_no"));
        int i = cursor.getInt(cursor.getColumnIndex("inbox_chat_type"));
        boolean zEquals = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_valid")));
        String string4 = cursor.getString(cursor.getColumnIndex("relation_buddy_no"));
        int i2 = cursor.getInt(cursor.getColumnIndex("inbox_room_type"));
        if (TextUtils.isEmpty(string4) || string4.equals(string3)) {
            string4 = null;
        }
        Intent intentM3014a = TabActivity.m3014a(this);
        intentM3014a.putExtra("callChatList", true);
        intentM3014a.putExtra("inboxNO", string2);
        intentM3014a.putExtra("chatType", i);
        intentM3014a.putExtra("inboxValid", zEquals);
        intentM3014a.putExtra("roomType", i2);
        if (!TextUtils.isEmpty(string4)) {
            intentM3014a.putExtra("groupId", string4);
        }
        if (TextUtils.isEmpty(string3)) {
            try {
                cursorQuery = CommonApplication.m18732r().getContentResolver().query(C2220ah.m10086a(string2), new String[]{"buddy_no"}, null, null, "rowid DESC");
                if (cursorQuery == null || cursorQuery.getCount() <= 0) {
                    string = string3;
                } else {
                    cursorQuery.moveToFirst();
                    string = cursorQuery.getString(0);
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        } else {
            string = string3;
        }
        if (!TextUtils.isEmpty(string)) {
            intentM3014a.putExtra("receivers", new String[]{string});
        }
        if (bundle.containsKey("isForwardSelected") && bundle.getBoolean("isForwardSelected")) {
            intentM3014a.putExtra("content_type", bundle.getInt("content_type", 0));
            intentM3014a.putExtra("download_uri", bundle.getString("download_uri"));
            intentM3014a.putExtra("sub_content", bundle.getString("sub_content"));
            intentM3014a.putExtra("forward_sender_name", bundle.getString("forward_sender_name"));
            intentM3014a.putExtra("is_forward_mode", bundle.getBoolean("is_forward_mode"));
            intentM3014a.putExtra(C1071bk.f3371e, enumC1094bm);
        }
        if (bundle.containsKey("forward_chat_message") && bundle.getBoolean("forward_chat_message")) {
            intentM3014a.putExtra("forward_chat_message", bundle.getBoolean("forward_chat_message"));
        }
        startActivity(intentM3014a);
    }

    /* renamed from: h */
    public void m10256h() {
        finish();
    }
}
