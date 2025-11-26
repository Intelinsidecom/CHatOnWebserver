package com.sec.chaton;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import com.sec.chaton.global.GlobalApplication;

/* loaded from: classes.dex */
public class UpgradeDialog extends Activity {

    /* renamed from: a */
    private LocalBroadcastManager f287a;

    /* renamed from: b */
    private BroadcastReceiver f288b;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.upgrade_dialog);
        if (Build.VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        this.f287a = LocalBroadcastManager.getInstance(GlobalApplication.m3100a());
        this.f288b = new C0246ai(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.sec.chaton.ACTION_DISMISS");
        this.f287a.registerReceiver(this.f288b, intentFilter);
        TextView textView = (TextView) findViewById(R.id.dialog_message);
        ((Button) findViewById(R.id.dialog_btn_yes)).setOnClickListener(new ViewOnClickListenerC0244ag(this));
        Button button = (Button) findViewById(R.id.dialog_btn_no);
        if (getIntent().getBooleanExtra("isCritical", false)) {
            textView.setText(R.string.upgrade_dialog_critical_message);
            button.setOnClickListener(new ViewOnClickListenerC0245ah(this));
        } else {
            button.setOnClickListener(new ViewOnClickListenerC0243af(this));
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f287a.unregisterReceiver(this.f288b);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
