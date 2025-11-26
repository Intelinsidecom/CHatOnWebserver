package com.sec.chaton.smsplugin.p112ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;

/* loaded from: classes.dex */
public class EditSlideDurationActivity extends Activity {

    /* renamed from: a */
    private TextView f14776a;

    /* renamed from: b */
    private Button f14777b;

    /* renamed from: c */
    private EditText f14778c;

    /* renamed from: d */
    private int f14779d;

    /* renamed from: e */
    private int f14780e;

    /* renamed from: f */
    private Bundle f14781f;

    /* renamed from: g */
    private final View.OnKeyListener f14782g = new ViewOnKeyListenerC4360x(this);

    /* renamed from: h */
    private final View.OnClickListener f14783h = new ViewOnClickListenerC4361y(this);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        int intExtra;
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.edit_slide_duration);
        if (bundle == null) {
            Intent intent = getIntent();
            this.f14779d = intent.getIntExtra("slide_index", 1);
            this.f14780e = intent.getIntExtra("slide_total", 1);
            intExtra = intent.getIntExtra("dur", 8);
        } else {
            this.f14781f = bundle.getBundle("state");
            this.f14779d = this.f14781f.getInt("slide_index", 1);
            this.f14780e = this.f14781f.getInt("slide_total", 1);
            intExtra = this.f14781f.getInt("dur", 8);
        }
        this.f14776a = (TextView) findViewById(R.id.label);
        this.f14776a.setText(getString(R.string.duration_selector_title) + " " + (this.f14779d + 1) + "/" + this.f14780e);
        this.f14778c = (EditText) findViewById(R.id.text);
        this.f14778c.setText(String.valueOf(intExtra));
        this.f14778c.setOnKeyListener(this.f14782g);
        this.f14777b = (Button) findViewById(R.id.done);
        this.f14777b.setOnClickListener(this.f14783h);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) throws NumberFormatException {
        int i;
        super.onSaveInstanceState(bundle);
        this.f14781f = new Bundle();
        this.f14781f.putInt("slide_index", this.f14779d);
        this.f14781f.putInt("slide_total", this.f14780e);
        try {
            i = Integer.parseInt(this.f14778c.getText().toString());
        } catch (NumberFormatException e) {
            i = 5;
        }
        this.f14781f.putInt("dur", i);
        bundle.putBundle("state", this.f14781f);
    }

    /* renamed from: a */
    protected void m15770a() {
        try {
            if (Integer.valueOf(this.f14778c.getText().toString()).intValue() <= 0) {
                m15769a(R.string.duration_zero);
            } else {
                setResult(-1, new Intent(this.f14778c.getText().toString()));
                finish();
            }
        } catch (NumberFormatException e) {
            m15769a(R.string.duration_not_a_number);
        }
    }

    /* renamed from: a */
    private void m15769a(int i) {
        this.f14778c.requestFocus();
        this.f14778c.selectAll();
        Toast.makeText(this, i, 0).show();
    }
}
