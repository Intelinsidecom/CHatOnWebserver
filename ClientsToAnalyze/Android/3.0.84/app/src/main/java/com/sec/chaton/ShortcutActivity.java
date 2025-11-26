package com.sec.chaton;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.p027e.C1441i;
import com.sec.chaton.p027e.C1449q;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;

/* loaded from: classes.dex */
public class ShortcutActivity extends BaseActivity {
    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        Cursor cursorQuery;
        Intent intent = null;
        super.onCreate(bundle);
        if (!C3159aa.m10962a().m10987b("uid")) {
            startActivity(new Intent(this, (Class<?>) TabActivity.class));
            finish();
            return;
        }
        if (getIntent().getAction() != null && getIntent().getAction().equals("android.intent.action.VIEW") && getIntent().getData() != null) {
            C3250y.m11453c("Shocrcut from contact", getClass().getSimpleName());
            Cursor cursorQuery2 = getContentResolver().query(getIntent().getData(), null, null, null, null);
            if (cursorQuery2.moveToFirst()) {
                String string = cursorQuery2.getString(cursorQuery2.getColumnIndex("data1"));
                intent = new Intent(TabActivity.m1228a(getApplicationContext(), true));
                intent.putExtra("inboxNO", string);
                intent.putExtra("chatType", EnumC1450r.ONETOONE.m6342a());
                intent.putExtra("contact", 1);
                intent.putExtra("receivers", new String[]{string});
            }
            cursorQuery2.close();
            if (intent != null) {
                startActivity(intent);
                finish();
                return;
            } else {
                C3641ai.m13211a(this, getResources().getString(R.string.shortcut_buddy_notfound), 0).show();
                finish();
                return;
            }
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            C3641ai.m13211a(this, getResources().getString(R.string.shortcut_buddy_notfound), 0).show();
            finish();
            return;
        }
        C3250y.m11453c("Shocrcut from homescreen", getClass().getSimpleName());
        String string2 = extras.getString("inboxNO");
        int i = extras.getInt("chatType");
        if (i == EnumC1450r.ONETOONE.m6342a()) {
            cursorQuery = getContentResolver().query(C1441i.f5369a, new String[]{"buddy_no"}, "buddy_no=?", new String[]{string2}, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() != 0) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                } finally {
                }
            }
            C3641ai.m13211a(this, getResources().getString(R.string.shortcut_buddy_notfound), 0).show();
            finish();
            if (cursorQuery != null) {
                cursorQuery.close();
                return;
            }
            return;
        }
        cursorQuery = getContentResolver().query(C1449q.f5381a, new String[]{"inbox_no"}, "inbox_no=?", new String[]{string2}, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() != 0) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            } finally {
            }
        }
        C3641ai.m13211a(this, getResources().getString(R.string.shortcut_buddy_notfound), 0).show();
        finish();
        if (cursorQuery != null) {
            cursorQuery.close();
            return;
        }
        return;
        Intent intent2 = new Intent(TabActivity.m1228a(getApplicationContext(), true));
        if (i == EnumC1450r.ONETOONE.m6342a()) {
            intent2.putExtra("receivers", new String[]{string2});
        }
        intent2.putExtra("inboxNO", string2);
        intent2.putExtra("chatType", i);
        startActivity(intent2);
        finish();
    }
}
