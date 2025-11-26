package com.sec.chaton.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import com.sec.chaton.p044l.C1603b;
import com.sec.chaton.p044l.C1605d;
import com.sec.chaton.p044l.C1607f;
import com.sec.chaton.p044l.C1608g;

/* loaded from: classes.dex */
public class ClearableEditText extends FrameLayout implements TextWatcher, View.OnClickListener, InterfaceC3258e {

    /* renamed from: a */
    private ViewGroup f11748a;

    /* renamed from: b */
    private EditText f11749b;

    /* renamed from: c */
    private ImageButton f11750c;

    /* renamed from: d */
    private int f11751d;

    /* renamed from: e */
    @Deprecated
    private InterfaceC3255b f11752e;

    /* renamed from: f */
    private View.OnClickListener f11753f;

    /* renamed from: g */
    private Drawable f11754g;

    public ClearableEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1603b.clearableEditTextStyle);
    }

    public ClearableEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11461a(context, attributeSet, i);
    }

    @Deprecated
    public void setOnMaxLengthReachListener(InterfaceC3255b interfaceC3255b) {
        this.f11752e = interfaceC3255b;
    }

    public void setClearButtonClickListener(View.OnClickListener onClickListener) {
        this.f11753f = onClickListener;
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        super.setMinimumHeight(i);
        this.f11748a.setMinimumHeight(i);
    }

    /* renamed from: a */
    public CharSequence m11463a() {
        return this.f11749b.getText();
    }

    public void setText(CharSequence charSequence) {
        this.f11749b.setText(charSequence);
    }

    /* renamed from: a */
    public void m11466a(CharSequence charSequence) {
        this.f11749b.append(charSequence);
    }

    public void setHint(CharSequence charSequence) {
        this.f11749b.setHint(charSequence);
    }

    public void setHint(int i) {
        this.f11749b.setHint(i);
    }

    public void setMaxLength(int i) {
        this.f11751d = i;
        this.f11749b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.f11751d)});
    }

    public void setSelection(int i) {
        this.f11749b.setSelection(i);
    }

    public void setSelection(int i, int i2) {
        this.f11749b.setSelection(i, i2);
    }

    /* renamed from: a */
    public void m11464a(TextWatcher textWatcher) {
        this.f11749b.addTextChangedListener(textWatcher);
    }

    /* renamed from: b */
    public void m11467b(TextWatcher textWatcher) {
        this.f11749b.removeTextChangedListener(textWatcher);
    }

    public void setImeOptions(int i) {
        this.f11749b.setImeOptions(i);
    }

    public void setOnEditorActionListener(TextView.OnEditorActionListener onEditorActionListener) {
        this.f11749b.setOnEditorActionListener(onEditorActionListener);
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        this.f11749b.setFilters(inputFilterArr);
    }

    /* renamed from: b */
    public InputFilter[] m11468b() {
        return this.f11749b.getFilters();
    }

    public void setInputType(int i) {
        this.f11749b.setInputType(i);
    }

    /* renamed from: a */
    private void m11461a(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1608g.ClearableEditText, i, 0);
        this.f11748a = (ViewGroup) LayoutInflater.from(getContext()).inflate(typedArrayObtainStyledAttributes.getResourceId(5, C1607f.layout_common_clearable_edit_text), (ViewGroup) this, false);
        addView(this.f11748a);
        if (this.f11748a instanceof InterfaceC3257d) {
            ((InterfaceC3257d) this.f11748a).setOnDrawableStateChanged(this);
            Drawable background = getBackground();
            if (background != null) {
                background.setState(this.f11748a.getDrawableState());
            }
        }
        this.f11749b = (EditText) this.f11748a.findViewById(C1605d.clearable_text1);
        this.f11749b.setSingleLine();
        this.f11749b.addTextChangedListener(this);
        this.f11748a.setMinimumHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0));
        int i2 = typedArrayObtainStyledAttributes.getInt(2, 0);
        String string = typedArrayObtainStyledAttributes.getString(1);
        int i3 = typedArrayObtainStyledAttributes.getInt(3, this.f11749b.getInputType());
        int i4 = typedArrayObtainStyledAttributes.getInt(4, this.f11749b.getImeOptions());
        typedArrayObtainStyledAttributes.recycle();
        if (i2 > 0) {
            setMaxLength(i2);
        }
        this.f11749b.setHint(string);
        this.f11749b.setInputType(i3);
        this.f11749b.setImeOptions(i4);
        this.f11750c = (ImageButton) this.f11748a.findViewById(C1605d.clearable_button1);
        this.f11750c.setOnClickListener(this);
        this.f11754g = this.f11749b.getCompoundDrawables()[0];
        m11462c();
    }

    /* renamed from: c */
    private void m11462c() {
        Editable text = this.f11749b.getText();
        if (text == null || text.length() == 0) {
            this.f11749b.setCompoundDrawables(this.f11754g, null, null, null);
            this.f11750c.setVisibility(8);
        } else {
            this.f11749b.setCompoundDrawables(null, null, null, null);
            this.f11750c.setVisibility(0);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f11751d > 0 && charSequence.length() == this.f11751d && this.f11752e != null) {
            this.f11752e.m11480a();
        }
        m11462c();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f11749b.setText("");
        if (this.f11753f != null) {
            this.f11753f.onClick(this);
        }
        this.f11749b.requestFocus();
    }

    @Override // com.sec.chaton.widget.InterfaceC3258e
    /* renamed from: a */
    public void mo11465a(View view, int[] iArr) {
        Drawable background = getBackground();
        if (background != null) {
            background.setState(iArr);
        }
    }
}
