package com.sec.chaton.registration;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import com.sec.chaton.C0062R;
import com.sec.chaton.base.BaseActivity;

/* loaded from: classes.dex */
public class CountryWrite extends BaseActivity {

    /* renamed from: a */
    Context f2907a;

    /* renamed from: b */
    private String f2908b;

    /* renamed from: c */
    private EditText f2909c;

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2907a = this;
        setContentView(C0062R.layout.layout_write_country);
        this.f2909c = (EditText) findViewById(C0062R.id.editCountryCode);
        Button button = (Button) findViewById(C0062R.id.done);
        ((Button) findViewById(C0062R.id.btnCancel)).setOnClickListener(new ViewOnClickListenerC0449y(this));
        button.setOnClickListener(new ViewOnClickListenerC0450z(this));
    }
}
