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
/* renamed from: com.sec.vip.amschaton.as */
/* loaded from: classes.dex */
public class ViewOnClickListenerC1382as implements View.OnClickListener {

    /* renamed from: b */
    private Context f4839b;

    /* renamed from: d */
    private AMSEditText f4841d;

    /* renamed from: c */
    private TextView f4840c = null;

    /* renamed from: e */
    private String f4842e = null;

    /* renamed from: f */
    private int f4843f = 0;

    /* renamed from: g */
    private Toast f4844g = null;

    /* renamed from: h */
    private InterfaceC1397bg f4845h = null;

    /* renamed from: i */
    private InterfaceC1368ae f4846i = null;

    /* renamed from: j */
    private C1549n f4847j = null;

    /* renamed from: k */
    private C1387ax f4848k = null;

    /* renamed from: a */
    TextWatcher f4838a = new C1554s(this);

    public ViewOnClickListenerC1382as(Context context, int i) {
        this.f4841d = null;
        this.f4839b = context;
        this.f4841d = (AMSEditText) ((Activity) context).findViewById(R.id.edit_text_input);
        m4951a(context, i);
    }

    /* renamed from: a */
    private void m4951a(Context context, int i) {
        this.f4841d.setImeOptions(6);
        this.f4840c = (TextView) ((Activity) context).findViewById(R.id.text_remain);
        if (i > 0) {
            this.f4843f = i;
            this.f4841d.addTextChangedListener(this.f4838a);
            this.f4840c.setText(String.format("(%d/%d)", Integer.valueOf(this.f4841d.getText().length()), Integer.valueOf(this.f4843f)));
        }
        this.f4841d.requestFocus();
        this.f4848k = new C1387ax(this, this.f4842e);
        this.f4847j = new C1549n(this, this.f4843f, "KSC5601");
        this.f4841d.setFilters(new InputFilter[]{this.f4848k, this.f4847j});
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m4954d() {
        boolean z;
        if (this.f4846i != null) {
            String string = this.f4841d.getText().toString();
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
            this.f4846i.mo4899a(length > 0 && !z);
        }
    }

    /* renamed from: a */
    public void m4961a(String str) {
        this.f4841d.setText(str);
        this.f4841d.setSelection(this.f4841d.getText().length());
    }

    /* renamed from: a */
    public void m4960a(InterfaceC1397bg interfaceC1397bg) {
        this.f4845h = interfaceC1397bg;
    }

    /* renamed from: a */
    public void m4959a(InterfaceC1368ae interfaceC1368ae) {
        this.f4846i = interfaceC1368ae;
        m4954d();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnOK /* 2131427468 */:
                if (this.f4841d.getText().toString().length() > 0 && this.f4845h != null) {
                    this.f4845h.mo4927b();
                    break;
                }
                break;
        }
    }

    /* renamed from: a */
    public String m4958a() {
        return this.f4841d.getText().toString();
    }

    /* renamed from: b */
    public EditText m4962b() {
        return this.f4841d;
    }

    /* renamed from: c */
    public void m4963c() {
        this.f4841d.setText((CharSequence) null);
    }
}
