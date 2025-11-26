package com.sec.chaton.forward;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.sec.chaton.C2310s;
import com.sec.chaton.EnumC3073u;
import com.sec.chaton.TabActivity;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgbox.InterfaceC1713aq;
import com.sec.chaton.p027e.C1457y;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.common.CommonApplication;

/* loaded from: classes.dex */
public class ChatForwardActivity extends BaseSinglePaneActivity implements InterfaceC1713aq {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() throws Resources.NotFoundException {
        if (GlobalApplication.m6456e()) {
            BaseActivity.m3080a(this);
        }
        return new ChatForwardFragment();
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        super.onResume();
        if (GlobalApplication.m6456e()) {
            BaseActivity.m3080a(this);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        if (GlobalApplication.m6456e()) {
            BaseActivity.m3080a(this);
        }
    }

    @Override // com.sec.chaton.msgbox.InterfaceC1713aq
    /* renamed from: c */
    public void mo6412c() {
        Intent intent = new Intent(this, (Class<?>) ActivityPasswordLockSet.class);
        intent.putExtra("MODE", "HOME");
        startActivity(intent);
    }

    @Override // com.sec.chaton.msgbox.InterfaceC1713aq
    /* renamed from: a */
    public void mo6411a(Cursor cursor, Bundle bundle, EnumC3073u enumC3073u) {
        String string;
        Cursor cursorQuery = null;
        String string2 = cursor.getString(cursor.getColumnIndex("inbox_no"));
        String string3 = cursor.getString(cursor.getColumnIndex("buddy_no"));
        int i = cursor.getInt(cursor.getColumnIndex("inbox_chat_type"));
        boolean zEquals = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_valid")));
        String string4 = cursor.getString(cursor.getColumnIndex("relation_buddy_no"));
        if (TextUtils.isEmpty(string4) || string4.equals(string3)) {
            string4 = null;
        }
        Intent intentM1226a = TabActivity.m1226a(this);
        intentM1226a.putExtra("callChatList", true);
        intentM1226a.putExtra("inboxNO", string2);
        intentM1226a.putExtra("chatType", i);
        intentM1226a.putExtra("inboxValid", zEquals);
        if (!TextUtils.isEmpty(string4)) {
            intentM1226a.putExtra("groupId", string4);
        }
        if (TextUtils.isEmpty(string3)) {
            try {
                cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1457y.m6367a(string2), new String[]{"buddy_no"}, null, null, "rowid DESC");
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
            intentM1226a.putExtra("receivers", new String[]{string});
        }
        if (bundle.containsKey("isForwardSelected") && bundle.getBoolean("isForwardSelected")) {
            intentM1226a.putExtra("content_type", bundle.getInt("content_type", 0));
            intentM1226a.putExtra("download_uri", bundle.getString("download_uri"));
            intentM1226a.putExtra("sub_content", bundle.getString("sub_content"));
            intentM1226a.putExtra("forward_sender_name", bundle.getString("forward_sender_name"));
            intentM1226a.putExtra("is_forward_mode", bundle.getBoolean("is_forward_mode"));
            intentM1226a.putExtra(C2310s.f8621e, enumC3073u);
        }
        startActivity(intentM1226a);
    }

    /* renamed from: d */
    public void m6413d() {
        finish();
    }
}
