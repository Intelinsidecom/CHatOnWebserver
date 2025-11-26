package com.sec.chaton.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.sec.chaton.p044l.C1605d;
import com.sec.chaton.p044l.C1607f;

/* loaded from: classes.dex */
public class SearchView extends LinearLayout implements TextWatcher {

    /* renamed from: a */
    private EditText f11764a;

    /* renamed from: b */
    private ImageButton f11765b;

    public SearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(C1607f.search_view, this);
        this.f11764a = (EditText) findViewById(C1605d.search_edit_text);
        this.f11765b = (ImageButton) findViewById(C1605d.search_icon);
        this.f11764a.addTextChangedListener(this);
        m11474a();
    }

    /* renamed from: a */
    private void m11474a() {
        if (TextUtils.isEmpty(this.f11764a.getText())) {
            this.f11765b.setEnabled(false);
        } else {
            this.f11765b.setEnabled(true);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        m11474a();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
