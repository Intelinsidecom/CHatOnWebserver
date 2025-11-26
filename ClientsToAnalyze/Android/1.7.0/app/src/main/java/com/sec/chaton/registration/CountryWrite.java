package com.sec.chaton.registration;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;

/* loaded from: classes.dex */
public class CountryWrite extends BaseActivity {

    /* renamed from: a */
    Context f3301a;

    /* renamed from: b */
    private String f3302b;

    /* renamed from: c */
    private EditText f3303c;

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3301a = this;
        setContentView(R.layout.layout_write_country);
        this.f3303c = (EditText) findViewById(R.id.editCountryCode);
        Button button = (Button) findViewById(R.id.done);
        ((Button) findViewById(R.id.btnCancel)).setOnClickListener(new ViewOnClickListenerC0985q(this));
        button.setOnClickListener(new ViewOnClickListenerC0986r(this));
    }
}
