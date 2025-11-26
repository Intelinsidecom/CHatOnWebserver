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
    private EditText f3166a;

    /* renamed from: b */
    private View f3167b;

    /* renamed from: c */
    private TextView f3168c;

    /* renamed from: d */
    private ImageButton f3169d;

    /* renamed from: e */
    private Context f3170e;

    public SearchLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3170e = context;
        m4386a(context);
    }

    /* renamed from: a */
    private void m4386a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.search_layout, (ViewGroup) this, true);
        this.f3166a = (EditText) findViewById(R.id.search_edit);
        this.f3167b = findViewById(R.id.hint_layout);
        this.f3168c = (TextView) findViewById(R.id.hint_text);
        this.f3169d = (ImageButton) findViewById(R.id.clear_btn);
        this.f3169d.setOnClickListener(this);
        this.f3166a.addTextChangedListener(this);
        m4385a();
    }

    public void setDefaultLanguageEnglish() {
        this.f3166a.setPrivateImeOptions("defaultInputmode=english;");
    }

    /* renamed from: a */
    private void m4385a() {
        if (this.f3166a.getText() == null || this.f3166a.getText().length() == 0) {
            this.f3167b.setVisibility(0);
            this.f3169d.setVisibility(8);
        } else {
            this.f3167b.setVisibility(8);
            this.f3169d.setVisibility(0);
        }
    }

    public void setOnEditorActionListener(TextView.OnEditorActionListener onEditorActionListener) {
        this.f3166a.setOnEditorActionListener(onEditorActionListener);
    }

    public void setHintText(String str) {
        this.f3168c.setText(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3166a.setText("");
    }

    public void setInputNumberType(boolean z) {
        if (z) {
            this.f3166a.setInputType(2);
        } else {
            this.f3166a.setInputType(1);
        }
    }

    public void setInputEmailArrdessType() {
        this.f3166a.setInputType(32);
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
            this.f3167b.setVisibility(0);
            this.f3169d.setVisibility(8);
        } else {
            this.f3167b.setVisibility(8);
            this.f3169d.setVisibility(0);
        }
    }

    public void setEditText(String str) {
        this.f3166a.setText(str);
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }
}
