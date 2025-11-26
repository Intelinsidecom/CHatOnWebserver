package com.sec.chaton;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;

/* loaded from: classes.dex */
public class ShortcutActivity extends BaseActivity {
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        Cursor cursorQuery;
        Intent intent;
        super.onCreate(bundle);
        if (!ChatONPref.m3519a().contains("uid")) {
            startActivity(new Intent(this, (Class<?>) HomeActivity.class));
            finish();
            return;
        }
        if (getIntent().getAction() != null && getIntent().getAction().equals("android.intent.action.VIEW") && getIntent().getData() != null) {
            ChatONLogWriter.m3508c("Shocrcut from contact", getClass().getSimpleName());
            Cursor cursorQuery2 = getContentResolver().query(getIntent().getData(), null, null, null, null);
            if (cursorQuery2.moveToFirst()) {
                String string = cursorQuery2.getString(cursorQuery2.getColumnIndex("data1"));
                Intent intent2 = new Intent(HomeActivity.m358a(getApplicationContext(), true));
                intent2.putExtra("inboxNO", string);
                intent2.putExtra("chatType", ChatONContract.InBoxTable.ChatType.ONETOONE.m2189a());
                intent2.putExtra("contact", 1);
                intent2.putExtra("receivers", new String[]{string});
                intent = intent2;
            } else {
                intent = null;
            }
            cursorQuery2.close();
            if (intent != null) {
                startActivity(intent);
                finish();
                return;
            } else {
                Toast.makeText(this, getResources().getString(C0062R.string.shortcut_buddy_notfound), 0).show();
                finish();
                return;
            }
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Toast.makeText(this, getResources().getString(C0062R.string.shortcut_buddy_notfound), 0).show();
            finish();
            return;
        }
        ChatONLogWriter.m3508c("Shocrcut from homescreen", getClass().getSimpleName());
        String string2 = extras.getString("inboxNO");
        int i = extras.getInt("chatType");
        if (i == ChatONContract.InBoxTable.ChatType.ONETOONE.m2189a()) {
            cursorQuery = getContentResolver().query(ChatONContract.BuddyTable.f1713a, new String[]{"buddy_no"}, "buddy_no=?", new String[]{string2}, null);
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
            Toast.makeText(this, getResources().getString(C0062R.string.shortcut_buddy_notfound), 0).show();
            finish();
            if (cursorQuery != null) {
                cursorQuery.close();
                return;
            }
            return;
        }
        cursorQuery = getContentResolver().query(ChatONContract.InBoxTable.f1717a, new String[]{"inbox_no"}, "inbox_no=?", new String[]{string2}, null);
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
        Toast.makeText(this, getResources().getString(C0062R.string.shortcut_buddy_notfound), 0).show();
        finish();
        if (cursorQuery != null) {
            cursorQuery.close();
            return;
        }
        return;
        Intent intent3 = new Intent(HomeActivity.m358a(getApplicationContext(), true));
        if (i == ChatONContract.InBoxTable.ChatType.ONETOONE.m2189a()) {
            intent3.putExtra("receivers", new String[]{string2});
        }
        intent3.putExtra("inboxNO", string2);
        intent3.putExtra("chatType", i);
        startActivity(intent3);
        finish();
    }
}
