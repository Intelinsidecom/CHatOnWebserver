package com.sec.chaton;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.p025d.C0667t;
import com.sec.chaton.p025d.C0671x;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;

/* loaded from: classes.dex */
public class ShortcutActivity extends BaseActivity {
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        Cursor cursorQuery;
        Intent intent = null;
        super.onCreate(bundle);
        if (C1323bs.m4575a().contains("uid")) {
            if (getIntent().getAction() != null && getIntent().getAction().equals("android.intent.action.VIEW") && getIntent().getData() != null) {
                C1341p.m4660c("Shocrcut from contact", getClass().getSimpleName());
                Cursor cursorQuery2 = getContentResolver().query(getIntent().getData(), null, null, null, null);
                if (cursorQuery2.moveToFirst()) {
                    String string = cursorQuery2.getString(cursorQuery2.getColumnIndex("data1"));
                    intent = new Intent(HomeActivity.m630a(getApplicationContext(), true));
                    intent.putExtra("inboxNO", string);
                    intent.putExtra("chatType", EnumC0665r.ONETOONE.m3012a());
                    intent.putExtra("contact", 1);
                    intent.putExtra("receivers", new String[]{string});
                }
                cursorQuery2.close();
                if (intent != null) {
                    startActivity(intent);
                    finish();
                    return;
                } else {
                    C1619g.m5889a(this, getResources().getString(R.string.shortcut_buddy_notfound), 0).show();
                    finish();
                    return;
                }
            }
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                C1341p.m4660c("Shocrcut from homescreen", getClass().getSimpleName());
                String string2 = extras.getString("inboxNO");
                int i = extras.getInt("chatType");
                if (i == EnumC0665r.ONETOONE.m3012a()) {
                    cursorQuery = getContentResolver().query(C0667t.f2310a, new String[]{"buddy_no"}, "buddy_no=?", new String[]{string2}, null);
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
                    C1619g.m5889a(this, getResources().getString(R.string.shortcut_buddy_notfound), 0).show();
                    finish();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                        return;
                    }
                    return;
                }
                cursorQuery = getContentResolver().query(C0671x.f2315a, new String[]{"inbox_no"}, "inbox_no=?", new String[]{string2}, null);
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
                C1619g.m5889a(this, getResources().getString(R.string.shortcut_buddy_notfound), 0).show();
                finish();
                if (cursorQuery != null) {
                    cursorQuery.close();
                    return;
                }
                return;
                Intent intent2 = new Intent(HomeActivity.m630a(getApplicationContext(), true));
                if (i == EnumC0665r.ONETOONE.m3012a()) {
                    intent2.putExtra("receivers", new String[]{string2});
                }
                intent2.putExtra("inboxNO", string2);
                intent2.putExtra("chatType", i);
                startActivity(intent2);
                finish();
                return;
            }
            C1619g.m5889a(this, getResources().getString(R.string.shortcut_buddy_notfound), 0).show();
            finish();
            return;
        }
        startActivity(new Intent(this, (Class<?>) HomeActivity.class));
        finish();
    }
}
