package com.sec.chaton.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;

/* loaded from: classes.dex */
public class ActivityTellFriends extends Activity {

    /* renamed from: a */
    Context f4571a = this;

    /* renamed from: b */
    String f4572b = "Setting";

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_tell_friends);
        ((Button) findViewById(R.id.btn_email)).setOnClickListener(new ViewOnClickListenerC1251bc(this));
        ((Button) findViewById(R.id.btn_sms)).setOnClickListener(new ViewOnClickListenerC1252bd(this));
        ((LinearLayout) findViewById(R.id.llayoutEmail)).setOnClickListener(new ViewOnClickListenerC1253be(this));
        ((LinearLayout) findViewById(R.id.llayoutSms)).setOnClickListener(new ViewOnClickListenerC1254bf(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4568a() throws Resources.NotFoundException {
        String string = getResources().getString(R.string.setting_chaton_tell_friends_email_subject);
        String string2 = getResources().getString(R.string.setting_chaton_tell_friends_email_text);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.SUBJECT", string);
        intent.putExtra("android.intent.extra.TEXT", string2);
        intent.setType("vnd.android-dir/mms-sms");
        startActivityForResult(intent, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m4570b() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.putExtra("sms_body", getResources().getString(R.string.setting_chaton_tell_friends_sms_text));
        intent.setType("vnd.android-dir/mms-sms");
        startActivityForResult(intent, 2);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x003f. Please report as an issue. */
    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C1786r.m6061b("requestCode=" + i, getClass().getSimpleName());
        C1786r.m6061b("resultCode=" + i2, getClass().getSimpleName());
        switch (i) {
        }
    }
}
