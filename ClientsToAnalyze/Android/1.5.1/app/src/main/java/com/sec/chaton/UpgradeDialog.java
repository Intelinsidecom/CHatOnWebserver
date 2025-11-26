package com.sec.chaton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;

/* loaded from: classes.dex */
public class UpgradeDialog extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(C0062R.layout.upgrade_dialog);
        if (!getIntent().getBooleanExtra("wantShow", false)) {
            finish();
            return;
        }
        ((TextView) findViewById(C0062R.id.dialog_title)).setText(C0062R.string.upgrade_dialog_title);
        TextView textView = (TextView) findViewById(C0062R.id.dialog_message);
        Button button = (Button) findViewById(C0062R.id.dialog_btn_yes);
        button.setText(getString(C0062R.string.dialog_ok));
        button.setOnClickListener(new ViewOnClickListenerC0351o(this));
        Button button2 = (Button) findViewById(C0062R.id.dialog_btn_no);
        button2.setText(getString(C0062R.string.dialog_cancel));
        if (getIntent().getBooleanExtra("isCritical", false)) {
            textView.setText(C0062R.string.upgrade_dialog_critical_message);
            button2.setOnClickListener(new ViewOnClickListenerC0245m(this));
        } else {
            textView.setText(C0062R.string.upgrade_dialog_basic_message);
            button2.setOnClickListener(new ViewOnClickListenerC0338n(this));
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (getIntent().getBooleanExtra("wantShow", false)) {
            return;
        }
        finish();
    }
}
