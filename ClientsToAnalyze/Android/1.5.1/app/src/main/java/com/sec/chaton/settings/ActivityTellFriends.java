package com.sec.chaton.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONLogWriter;

/* loaded from: classes.dex */
public class ActivityTellFriends extends Activity {

    /* renamed from: a */
    Context f3075a = this;

    /* renamed from: b */
    String f3076b = "Setting";

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3195a() throws Resources.NotFoundException {
        String string = getResources().getString(C0062R.string.setting_chaton_tell_friends_email_subject);
        String string2 = getResources().getString(C0062R.string.setting_chaton_tell_friends_email_text);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.SUBJECT", string);
        intent.putExtra("android.intent.extra.TEXT", string2);
        intent.setType("vnd.android-dir/mms-sms");
        startActivityForResult(intent, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m3197b() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.putExtra("sms_body", getResources().getString(C0062R.string.setting_chaton_tell_friends_sms_text));
        intent.setType("vnd.android-dir/mms-sms");
        startActivityForResult(intent, 2);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x003f. Please report as an issue. */
    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ChatONLogWriter.m3506b("requestCode=" + i, getClass().getSimpleName());
        ChatONLogWriter.m3506b("resultCode=" + i2, getClass().getSimpleName());
        switch (i) {
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0062R.layout.layout_tell_friends);
        ((Button) findViewById(C0062R.id.btn_email)).setOnClickListener(new ViewOnClickListenerC0472au(this));
        ((Button) findViewById(C0062R.id.btn_sms)).setOnClickListener(new ViewOnClickListenerC0471at(this));
        ((LinearLayout) findViewById(C0062R.id.llayoutEmail)).setOnClickListener(new ViewOnClickListenerC0474aw(this));
        ((LinearLayout) findViewById(C0062R.id.llayoutSms)).setOnClickListener(new ViewOnClickListenerC0473av(this));
    }
}
