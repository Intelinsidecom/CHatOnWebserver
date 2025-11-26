package com.sec.chaton;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.p057e.C2289i;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;

/* loaded from: classes.dex */
public class ShortcutActivity extends BaseActivity {
    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        Cursor cursorQuery;
        Intent intent = null;
        super.onCreate(bundle);
        if (!C4809aa.m18104a().m18129b("uid")) {
            startActivity(new Intent(this, (Class<?>) TabActivity.class));
            finish();
            return;
        }
        if (getIntent().getAction() != null && getIntent().getAction().equals("android.intent.action.VIEW") && getIntent().getData() != null) {
            C4904y.m18641c("Shocrcut from contact", getClass().getSimpleName());
            Cursor cursorQuery2 = getContentResolver().query(getIntent().getData(), null, null, null, null);
            if (cursorQuery2.moveToFirst()) {
                String string = cursorQuery2.getString(cursorQuery2.getColumnIndex("data1"));
                intent = new Intent(TabActivity.m3017a(getApplicationContext(), true));
                intent.putExtra("inboxNO", string);
                intent.putExtra("chatType", EnumC2300t.ONETOONE.m10210a());
                intent.putExtra("contact", 1);
                intent.putExtra("receivers", new String[]{string});
            }
            cursorQuery2.close();
            if (intent != null) {
                startActivity(intent);
                finish();
                return;
            } else {
                C5179v.m19811a(this, getResources().getString(R.string.shortcut_contact_blocked_or_notfound), 0).show();
                finish();
                return;
            }
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            C5179v.m19811a(this, getResources().getString(R.string.shortcut_contact_blocked_or_notfound), 0).show();
            finish();
            return;
        }
        C4904y.m18641c("Shocrcut from homescreen", getClass().getSimpleName());
        String string2 = extras.getString("inboxNO");
        int i = extras.getInt("chatType");
        if (i == EnumC2300t.ONETOONE.m10210a()) {
            cursorQuery = getContentResolver().query(C2289i.f8196a, new String[]{"buddy_no"}, "buddy_no=?", new String[]{string2}, null);
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
            C5179v.m19811a(this, getResources().getString(R.string.shortcut_contact_blocked_or_notfound), 0).show();
            finish();
            if (cursorQuery != null) {
                cursorQuery.close();
                return;
            }
            return;
        }
        cursorQuery = getContentResolver().query(C2299s.f8209a, new String[]{"inbox_no"}, "inbox_no=?", new String[]{string2}, null);
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
        C5179v.m19811a(this, getResources().getString(R.string.shortcut_contact_blocked_or_notfound), 0).show();
        finish();
        if (cursorQuery != null) {
            cursorQuery.close();
            return;
        }
        return;
        Intent intent2 = new Intent(TabActivity.m3017a(getApplicationContext(), true));
        if (i == EnumC2300t.ONETOONE.m10210a()) {
            intent2.putExtra("receivers", new String[]{string2});
        }
        intent2.putExtra("inboxNO", string2);
        intent2.putExtra("chatType", i);
        startActivity(intent2);
        finish();
    }
}
