package com.sec.chaton.settings.tellfriends;

import android.app.Activity;
import android.content.Context;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;

/* loaded from: classes.dex */
public class WeiboTextInputLayout implements View.OnClickListener {

    /* renamed from: b */
    private Context f10071b;

    /* renamed from: d */
    private EditText f10073d;

    /* renamed from: c */
    private TextView f10072c = null;

    /* renamed from: e */
    private String f10074e = null;

    /* renamed from: f */
    private int f10075f = 0;

    /* renamed from: g */
    private Toast f10076g = null;

    /* renamed from: h */
    private C2783cf f10077h = null;

    /* renamed from: i */
    private C2784cg f10078i = null;

    /* renamed from: a */
    TextWatcher f10070a = new C2782ce(this);

    public WeiboTextInputLayout(Context context, EditText editText, int i) {
        this.f10073d = null;
        this.f10071b = context;
        this.f10073d = editText;
        m9759a(context, i);
    }

    /* renamed from: a */
    private void m9759a(Context context, int i) {
        this.f10073d.setImeOptions(268435462);
        this.f10072c = (TextView) ((Activity) context).findViewById(R.id.text_remain);
        if (i > 0) {
            this.f10075f = i;
            this.f10073d.addTextChangedListener(this.f10070a);
            this.f10072c.setText(String.format("(%d/%d)", Integer.valueOf(this.f10073d.getText().length()), Integer.valueOf(this.f10075f)));
        }
        this.f10073d.requestFocus();
        this.f10078i = new C2784cg(this, this.f10074e);
        this.f10077h = new C2783cf(this, this.f10075f, "KSC5601");
        this.f10073d.setFilters(new InputFilter[]{this.f10078i, this.f10077h});
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
