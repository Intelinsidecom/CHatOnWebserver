package com.sec.vip.amschaton;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: TextInputLayout.java */
/* renamed from: com.sec.vip.amschaton.bl */
/* loaded from: classes.dex */
public class ViewOnClickListenerC3437bl implements View.OnClickListener {

    /* renamed from: b */
    private Context f12576b;

    /* renamed from: d */
    private AMSEditText f12578d;

    /* renamed from: c */
    private TextView f12577c = null;

    /* renamed from: e */
    private String f12579e = null;

    /* renamed from: f */
    private int f12580f = 0;

    /* renamed from: g */
    private Toast f12581g = null;

    /* renamed from: h */
    private InterfaceC3434bi f12582h = null;

    /* renamed from: i */
    private InterfaceC3441bp f12583i = null;

    /* renamed from: j */
    private C3439bn f12584j = null;

    /* renamed from: k */
    private C3440bo f12585k = null;

    /* renamed from: a */
    TextWatcher f12575a = new C3438bm(this);

    public ViewOnClickListenerC3437bl(RelativeLayout relativeLayout, Context context, int i) {
        this.f12578d = null;
        this.f12576b = context;
        this.f12578d = (AMSEditText) relativeLayout.findViewById(R.id.edit_text_input);
        m12306a(relativeLayout, context, i);
    }

    /* renamed from: a */
    private void m12306a(RelativeLayout relativeLayout, Context context, int i) {
        this.f12578d.setImeOptions(268435462);
        this.f12577c = (TextView) relativeLayout.findViewById(R.id.text_remain);
        if (i > 0) {
            this.f12580f = i;
            this.f12578d.addTextChangedListener(this.f12575a);
            this.f12577c.setText(String.format("(%d/%d)", Integer.valueOf(this.f12578d.getText().length()), Integer.valueOf(this.f12580f)));
        }
        this.f12578d.requestFocus();
        this.f12585k = new C3440bo(this, this.f12579e, null);
        this.f12584j = new C3439bn(this, this.f12580f, "KSC5601");
        this.f12578d.setFilters(new InputFilter[]{this.f12585k, this.f12584j});
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m12309d() {
        boolean z;
        if (this.f12583i != null) {
            String string = this.f12578d.getText().toString();
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
            this.f12583i.mo12321a(length > 0 && !z);
        }
    }

    /* renamed from: a */
    public void m12316a(String str) {
        this.f12578d.setText(str);
        this.f12578d.setSelection(this.f12578d.getText().length());
    }

    /* renamed from: a */
    public void m12314a(InterfaceC3434bi interfaceC3434bi) {
        this.f12582h = interfaceC3434bi;
    }

    /* renamed from: a */
    public void m12315a(InterfaceC3441bp interfaceC3441bp) {
        this.f12583i = interfaceC3441bp;
        m12309d();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnOK /* 2131165297 */:
                if (this.f12578d.getText().toString().length() > 0 && this.f12582h != null) {
                    this.f12582h.mo12235b();
                    break;
                }
                break;
        }
    }

    /* renamed from: a */
    public String m12313a() {
        return this.f12578d.getText().toString();
    }

    /* renamed from: b */
    public EditText m12317b() {
        return this.f12578d;
    }

    /* renamed from: c */
    public void m12318c() {
        this.f12578d.setText((CharSequence) null);
    }
}
