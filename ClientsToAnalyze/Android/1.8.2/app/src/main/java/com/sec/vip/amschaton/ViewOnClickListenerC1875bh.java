package com.sec.vip.amschaton;

import android.app.Activity;
import android.content.Context;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: TextInputLayout.java */
/* renamed from: com.sec.vip.amschaton.bh */
/* loaded from: classes.dex */
public class ViewOnClickListenerC1875bh implements View.OnClickListener {

    /* renamed from: b */
    private Context f6853b;

    /* renamed from: d */
    private AMSEditText f6855d;

    /* renamed from: c */
    private TextView f6854c = null;

    /* renamed from: e */
    private String f6856e = null;

    /* renamed from: f */
    private int f6857f = 0;

    /* renamed from: g */
    private Toast f6858g = null;

    /* renamed from: h */
    private InterfaceC1872be f6859h = null;

    /* renamed from: i */
    private InterfaceC1879bl f6860i = null;

    /* renamed from: j */
    private C1877bj f6861j = null;

    /* renamed from: k */
    private C1878bk f6862k = null;

    /* renamed from: a */
    TextWatcher f6852a = new C1876bi(this);

    public ViewOnClickListenerC1875bh(Context context, int i) {
        this.f6855d = null;
        this.f6853b = context;
        this.f6855d = (AMSEditText) ((Activity) context).findViewById(R.id.edit_text_input);
        m6484a(context, i);
    }

    public ViewOnClickListenerC1875bh(Context context, AMSEditText aMSEditText, int i) {
        this.f6855d = null;
        this.f6853b = context;
        this.f6855d = aMSEditText;
        m6484a(context, i);
    }

    /* renamed from: a */
    private void m6484a(Context context, int i) {
        this.f6855d.setImeOptions(6);
        this.f6854c = (TextView) ((Activity) context).findViewById(R.id.text_remain);
        if (i > 0) {
            this.f6857f = i;
            this.f6855d.addTextChangedListener(this.f6852a);
            this.f6854c.setText(String.format("(%d/%d)", Integer.valueOf(this.f6855d.getText().length()), Integer.valueOf(this.f6857f)));
        }
        this.f6855d.requestFocus();
        this.f6862k = new C1878bk(this, this.f6856e);
        this.f6861j = new C1877bj(this, this.f6857f, "KSC5601");
        this.f6855d.setFilters(new InputFilter[]{this.f6862k, this.f6861j});
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m6487d() {
        boolean z;
        if (this.f6860i != null) {
            String string = this.f6855d.getText().toString();
            int length = string.length();
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = true;
                    break;
                } else {
                    if (string.charAt(i) != ' ') {
                        z = false;
                        break;
                    }
                    i++;
                }
            }
            this.f6860i.mo6499a(length > 0 && !z);
        }
    }

    /* renamed from: a */
    public void m6494a(String str) {
        this.f6855d.setText(str);
        this.f6855d.setSelection(this.f6855d.getText().length());
    }

    /* renamed from: a */
    public void m6492a(InterfaceC1872be interfaceC1872be) {
        this.f6859h = interfaceC1872be;
    }

    /* renamed from: a */
    public void m6493a(InterfaceC1879bl interfaceC1879bl) {
        this.f6860i = interfaceC1879bl;
        m6487d();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnOK /* 2131493036 */:
                if (this.f6855d.getText().toString().length() > 0 && this.f6859h != null) {
                    this.f6859h.mo6436d_();
                    break;
                }
                break;
        }
    }

    /* renamed from: a */
    public String m6491a() {
        return this.f6855d.getText().toString();
    }

    /* renamed from: b */
    public EditText m6495b() {
        return this.f6855d;
    }

    /* renamed from: c */
    public void m6496c() {
        this.f6855d.setText((CharSequence) null);
    }
}
