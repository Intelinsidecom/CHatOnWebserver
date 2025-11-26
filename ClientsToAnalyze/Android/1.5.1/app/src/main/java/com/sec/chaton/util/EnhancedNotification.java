package com.sec.chaton.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import com.sec.chaton.C0062R;
import com.sec.chaton.base.BaseActivity;

/* loaded from: classes.dex */
public class EnhancedNotification extends BaseActivity {

    /* renamed from: a */
    private String f3668a;

    /* renamed from: b */
    private String f3669b;

    /* renamed from: c */
    private String f3670c;

    /* renamed from: d */
    private int f3671d;

    /* renamed from: e */
    private Dialog f3672e;

    /* renamed from: a */
    private void m3577a() {
        this.f3672e = new AlertDialog.Builder(this).setTitle(C0062R.string.app_name).setMessage(this.f3669b).setIcon(C0062R.drawable.popup_chat_icon).setPositiveButton(C0062R.string.dialog_ok, new DialogInterfaceOnClickListenerC0609g(this)).setNegativeButton(C0062R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0610h(this)).create();
        this.f3672e.show();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().addFlags(2621568);
        Bundle extras = getIntent().getExtras();
        this.f3668a = extras.getString("Sender");
        this.f3669b = extras.getString("Content");
        this.f3670c = extras.getString("InboxNO");
        this.f3671d = extras.getInt("Chattype");
        m3577a();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (this.f3672e != null) {
            this.f3672e.dismiss();
        }
        Bundle extras = getIntent().getExtras();
        this.f3668a = extras.getString("Sender");
        this.f3669b = extras.getString("Content");
        this.f3670c = extras.getString("InboxNO");
        this.f3671d = extras.getInt("Chattype");
        m3577a();
    }
}
