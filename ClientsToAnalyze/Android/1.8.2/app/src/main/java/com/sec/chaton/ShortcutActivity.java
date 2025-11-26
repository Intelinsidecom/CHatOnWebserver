package com.sec.chaton;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.p017e.C0688c;
import com.sec.chaton.p017e.C0694i;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;

/* loaded from: classes.dex */
public class ShortcutActivity extends BaseActivity {
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        Cursor cursorQuery;
        Intent intent = null;
        super.onCreate(bundle);
        if (C1789u.m6075a().contains("uid")) {
            if (getIntent().getAction() != null && getIntent().getAction().equals("android.intent.action.VIEW") && getIntent().getData() != null) {
                C1786r.m6063c("Shocrcut from contact", getClass().getSimpleName());
                Cursor cursorQuery2 = getContentResolver().query(getIntent().getData(), null, null, null, null);
                if (cursorQuery2.moveToFirst()) {
                    String string = cursorQuery2.getString(cursorQuery2.getColumnIndex("data1"));
                    intent = new Intent(HomeActivity.m585a(getApplicationContext(), true));
                    intent.putExtra("inboxNO", string);
                    intent.putExtra("chatType", EnumC0695j.ONETOONE.m3146a());
                    intent.putExtra("contact", 1);
                    intent.putExtra("receivers", new String[]{string});
                }
                cursorQuery2.close();
                if (intent != null) {
                    startActivity(intent);
                    finish();
                    return;
                } else {
                    Toast.makeText(this, getResources().getString(R.string.shortcut_buddy_notfound), 0).show();
                    finish();
                    return;
                }
            }
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                C1786r.m6063c("Shocrcut from homescreen", getClass().getSimpleName());
                String string2 = extras.getString("inboxNO");
                int i = extras.getInt("chatType");
                if (i == EnumC0695j.ONETOONE.m3146a()) {
                    cursorQuery = getContentResolver().query(C0688c.f2606a, new String[]{"buddy_no"}, "buddy_no=?", new String[]{string2}, null);
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
                    Toast.makeText(this, getResources().getString(R.string.shortcut_buddy_notfound), 0).show();
                    finish();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                        return;
                    }
                    return;
                }
                cursorQuery = getContentResolver().query(C0694i.f2616a, new String[]{"inbox_no"}, "inbox_no=?", new String[]{string2}, null);
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
                Toast.makeText(this, getResources().getString(R.string.shortcut_buddy_notfound), 0).show();
                finish();
                if (cursorQuery != null) {
                    cursorQuery.close();
                    return;
                }
                return;
                Intent intent2 = new Intent(HomeActivity.m585a(getApplicationContext(), true));
                if (i == EnumC0695j.ONETOONE.m3146a()) {
                    intent2.putExtra("receivers", new String[]{string2});
                }
                intent2.putExtra("inboxNO", string2);
                intent2.putExtra("chatType", i);
                startActivity(intent2);
                finish();
                return;
            }
            Toast.makeText(this, getResources().getString(R.string.shortcut_buddy_notfound), 0).show();
            finish();
            return;
        }
        startActivity(new Intent(this, (Class<?>) HomeActivity.class));
        finish();
    }
}
