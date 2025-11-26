package com.sec.chaton.registration;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;

/* loaded from: classes.dex */
public class CountryWrite extends BaseActivity {

    /* renamed from: n */
    Context f11611n;

    /* renamed from: o */
    private String f11612o;

    /* renamed from: p */
    private EditText f11613p;

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11611n = this;
        setContentView(R.layout.layout_write_country);
        this.f11613p = (EditText) findViewById(R.id.editCountryCode);
        Button button = (Button) findViewById(R.id.done);
        ((Button) findViewById(R.id.btnCancel)).setOnClickListener(new ViewOnClickListenerC3132aa(this));
        button.setOnClickListener(new ViewOnClickListenerC3133ab(this));
    }
}
