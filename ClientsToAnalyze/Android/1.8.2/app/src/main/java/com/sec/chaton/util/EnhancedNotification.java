package com.sec.chaton.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;

/* loaded from: classes.dex */
public class EnhancedNotification extends BaseActivity {

    /* renamed from: a */
    private String f6282a;

    /* renamed from: b */
    private String f6283b;

    /* renamed from: c */
    private String f6284c;

    /* renamed from: d */
    private int f6285d;

    /* renamed from: e */
    private Dialog f6286e;

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().addFlags(2621568);
        Bundle extras = getIntent().getExtras();
        this.f6282a = extras.getString("Sender");
        this.f6283b = extras.getString("Content");
        this.f6284c = extras.getString("InboxNO");
        this.f6285d = extras.getInt("Chattype");
        m5841a();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (this.f6286e != null) {
            this.f6286e.dismiss();
        }
        Bundle extras = getIntent().getExtras();
        this.f6282a = extras.getString("Sender");
        this.f6283b = extras.getString("Content");
        this.f6284c = extras.getString("InboxNO");
        this.f6285d = extras.getInt("Chattype");
        m5841a();
    }

    /* renamed from: a */
    private void m5841a() {
        this.f6286e = new AlertDialog.Builder(this).setTitle(R.string.app_name).setMessage(this.f6283b).setIcon(R.drawable.popup_chat_icon).setNegativeButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1724ag(this)).setPositiveButton(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1723af(this)).create();
        this.f6286e.show();
    }
}
