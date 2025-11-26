package com.sec.chaton.msgbox;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import com.sec.chaton.C1071bk;
import com.sec.chaton.EnumC1094bm;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.p057e.C2220ah;
import com.sec.common.CommonApplication;
import com.sec.common.actionbar.AbstractC4946a;

/* loaded from: classes.dex */
public class MsgboxSelectionActivity extends BaseSinglePaneActivity implements InterfaceC2653br {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        return new MsgboxSelectionFragment();
    }

    /* renamed from: h */
    public AbstractC4946a m11100h() {
        return m18784t();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportCreateOptionsMenu(Menu menu) {
        super.onSupportCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.activity_msgbox_delete_menu, menu);
        return true;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        boolean zOnSupportOptionsItemSelected = super.onSupportOptionsItemSelected(menuItem);
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        return zOnSupportOptionsItemSelected;
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
        if (TextUtils.isEmpty(string4) || string4.equals(string3)) {
            string4 = null;
        }
        Intent intentM3014a = TabActivity.m3014a(this);
        intentM3014a.putExtra("callChatList", true);
        intentM3014a.putExtra("inboxNO", string2);
        intentM3014a.putExtra("chatType", i);
        intentM3014a.putExtra("inboxValid", zEquals);
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
        startActivity(intentM3014a);
    }

    /* renamed from: i */
    public void m11101i() {
        finish();
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        super.onResume();
        BaseActivity.m6159a(this);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        BaseActivity.m6159a(this);
    }
}
