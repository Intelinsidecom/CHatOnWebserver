package com.sec.chaton.calllog.common.view.layout;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;

/* loaded from: classes.dex */
public class SearchLayout extends RelativeLayout implements TextWatcher, View.OnClickListener, TextView.OnEditorActionListener {

    /* renamed from: a */
    private EditText f5135a;

    /* renamed from: b */
    private View f5136b;

    /* renamed from: c */
    private TextView f5137c;

    /* renamed from: d */
    private ImageButton f5138d;

    /* renamed from: e */
    private Context f5139e;

    public SearchLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5139e = context;
        m7540a(context);
    }

    /* renamed from: a */
    private void m7540a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.search_layout, (ViewGroup) this, true);
        this.f5135a = (EditText) findViewById(R.id.search_edit);
        this.f5136b = findViewById(R.id.hint_layout);
        this.f5137c = (TextView) findViewById(R.id.hint_text);
        this.f5138d = (ImageButton) findViewById(R.id.clear_btn);
        this.f5138d.setOnClickListener(this);
        this.f5135a.addTextChangedListener(this);
        m7539a();
    }

    public void setDefaultLanguageEnglish() {
        this.f5135a.setPrivateImeOptions("defaultInputmode=english;");
    }

    /* renamed from: a */
    private void m7539a() {
        if (this.f5135a.getText() == null || this.f5135a.getText().length() == 0) {
            this.f5136b.setVisibility(0);
            this.f5138d.setVisibility(8);
        } else {
            this.f5136b.setVisibility(8);
            this.f5138d.setVisibility(0);
        }
    }

    public void setOnEditorActionListener(TextView.OnEditorActionListener onEditorActionListener) {
        this.f5135a.setOnEditorActionListener(onEditorActionListener);
    }

    public void setHintText(String str) {
        this.f5137c.setText(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f5135a.setText("");
    }

    public void setInputNumberType(boolean z) {
        if (z) {
            this.f5135a.setInputType(2);
        } else {
            this.f5135a.setInputType(1);
        }
    }

    public void setInputEmailArrdessType() {
        this.f5135a.setInputType(32);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence == null || charSequence.length() == 0) {
            this.f5136b.setVisibility(0);
            this.f5138d.setVisibility(8);
        } else {
            this.f5136b.setVisibility(8);
            this.f5138d.setVisibility(0);
        }
    }

    public void setEditText(String str) {
        this.f5135a.setText(str);
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }
}
