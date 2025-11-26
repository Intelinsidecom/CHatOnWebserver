package com.sec.chaton.util;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.widget.AlertDialogBuilderC1625m;

/* loaded from: classes.dex */
public class EnhancedNotification extends BaseActivity {

    /* renamed from: a */
    private String f4426a;

    /* renamed from: b */
    private String f4427b;

    /* renamed from: c */
    private String f4428c;

    /* renamed from: d */
    private int f4429d;

    /* renamed from: e */
    private Dialog f4430e;

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().addFlags(2621568);
        Bundle extras = getIntent().getExtras();
        this.f4426a = extras.getString("Sender");
        this.f4427b = extras.getString("Content");
        this.f4428c = extras.getString("InboxNO");
        this.f4429d = extras.getInt("Chattype");
        m4460a();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (this.f4430e != null) {
            this.f4430e.dismiss();
        }
        Bundle extras = getIntent().getExtras();
        this.f4426a = extras.getString("Sender");
        this.f4427b = extras.getString("Content");
        this.f4428c = extras.getString("InboxNO");
        this.f4429d = extras.getInt("Chattype");
        m4460a();
    }

    /* renamed from: a */
    private void m4460a() {
        this.f4430e = new AlertDialogBuilderC1625m(this).setTitle(R.string.app_name).setMessage(this.f4427b).setIcon(R.drawable.popup_chat_icon).setPositiveButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1345t(this)).setNegativeButton(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1347v(this)).create();
        this.f4430e.show();
    }
}
