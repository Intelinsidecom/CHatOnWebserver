package com.sec.chaton;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import com.sec.chaton.global.GlobalApplication;

/* loaded from: classes.dex */
public class UpgradeDialog extends Activity {

    /* renamed from: b */
    private LocalBroadcastManager f300b;

    /* renamed from: c */
    private BroadcastReceiver f301c;

    /* renamed from: d */
    private Context f302d;

    /* renamed from: e */
    private ProgressDialog f303e = null;

    /* renamed from: a */
    public Handler f299a = new HandlerC0235az(this);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.upgrade_dialog);
        if (Build.VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        this.f302d = this;
        if (GlobalApplication.m3265f()) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        this.f300b = LocalBroadcastManager.getInstance(GlobalApplication.m3260b());
        this.f301c = new C0231av(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.sec.chaton.ACTION_DISMISS");
        this.f300b.registerReceiver(this.f301c, intentFilter);
        TextView textView = (TextView) findViewById(R.id.dialog_message);
        ((Button) findViewById(R.id.dialog_btn_yes)).setOnClickListener(new ViewOnClickListenerC0232aw(this));
        Button button = (Button) findViewById(R.id.dialog_btn_no);
        if (getIntent().getBooleanExtra("isCritical", false)) {
            textView.setText(R.string.upgrade_dialog_critical_message);
            button.setOnClickListener(new ViewOnClickListenerC0233ax(this));
        } else {
            button.setOnClickListener(new ViewOnClickListenerC0234ay(this));
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f300b.unregisterReceiver(this.f301c);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
