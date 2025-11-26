package com.sec.chaton.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.sec.chaton.p076m.C2572d;
import com.sec.chaton.p076m.C2574f;

/* loaded from: classes.dex */
public class SearchView extends LinearLayout implements TextWatcher {

    /* renamed from: a */
    private ClearableEditText f17927a;

    /* renamed from: b */
    private ImageButton f17928b;

    public SearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(C2574f.search_view, this);
        this.f17927a = (ClearableEditText) findViewById(C2572d.search_edit_text);
        this.f17928b = (ImageButton) findViewById(C2572d.search_icon);
        this.f17927a.m18659a(this);
        m18705a();
    }

    /* renamed from: a */
    private void m18705a() {
        if (TextUtils.isEmpty(this.f17927a.m18658a())) {
            this.f17928b.setEnabled(false);
        } else {
            this.f17928b.setEnabled(true);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        m18705a();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
