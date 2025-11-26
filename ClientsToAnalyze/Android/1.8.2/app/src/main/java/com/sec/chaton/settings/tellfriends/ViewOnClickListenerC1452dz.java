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

/* compiled from: WeiboTextInputLayout.java */
/* renamed from: com.sec.chaton.settings.tellfriends.dz */
/* loaded from: classes.dex */
public class ViewOnClickListenerC1452dz implements View.OnClickListener {

    /* renamed from: b */
    private Context f5348b;

    /* renamed from: d */
    private EditText f5350d;

    /* renamed from: c */
    private TextView f5349c = null;

    /* renamed from: e */
    private String f5351e = null;

    /* renamed from: f */
    private int f5352f = 0;

    /* renamed from: g */
    private Toast f5353g = null;

    /* renamed from: h */
    private boolean f5354h = true;

    /* renamed from: i */
    private C1455eb f5355i = null;

    /* renamed from: j */
    private C1456ec f5356j = null;

    /* renamed from: a */
    TextWatcher f5347a = new C1454ea(this);

    /* renamed from: a */
    public boolean m5193a() {
        return this.f5354h;
    }

    public ViewOnClickListenerC1452dz(Context context, EditText editText, int i) {
        this.f5350d = null;
        this.f5348b = context;
        this.f5350d = editText;
        m5184a(context, i);
    }

    /* renamed from: a */
    private void m5184a(Context context, int i) {
        this.f5350d.setImeOptions(6);
        this.f5349c = (TextView) ((Activity) context).findViewById(R.id.text_remain);
        if (i > 0) {
            this.f5352f = i;
            this.f5350d.addTextChangedListener(this.f5347a);
            this.f5349c.setText(String.format("(%d/%d)", Integer.valueOf(this.f5350d.getText().length()), Integer.valueOf(this.f5352f)));
        }
        this.f5350d.requestFocus();
        this.f5356j = new C1456ec(this, this.f5351e);
        this.f5355i = new C1455eb(this, this.f5352f, "KSC5601");
        this.f5350d.setFilters(new InputFilter[]{this.f5356j, this.f5355i});
    }

    /* renamed from: a */
    public void m5192a(String str) {
        this.f5350d.setText(str);
        this.f5350d.setSelection(this.f5350d.getText().length());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
