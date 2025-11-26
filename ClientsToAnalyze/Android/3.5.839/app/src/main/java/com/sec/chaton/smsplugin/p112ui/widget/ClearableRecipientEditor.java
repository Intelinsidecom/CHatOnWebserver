package com.sec.chaton.smsplugin.p112ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import com.sec.chaton.C1880ci;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p112ui.RecipientsEditor;
import com.sec.chaton.widget.InterfaceC4917j;
import com.sec.chaton.widget.InterfaceC4918k;

/* loaded from: classes.dex */
public class ClearableRecipientEditor extends FrameLayout implements TextWatcher, View.OnClickListener, InterfaceC4918k {

    /* renamed from: a */
    private ViewGroup f15798a;

    /* renamed from: b */
    private RecipientsEditor f15799b;

    /* renamed from: c */
    private ImageButton f15800c;

    /* renamed from: d */
    private int f15801d;

    /* renamed from: e */
    private int f15802e;

    /* renamed from: f */
    @Deprecated
    private InterfaceC4359c f15803f;

    /* renamed from: g */
    private View.OnClickListener f15804g;

    /* renamed from: h */
    private CharSequence f15805h;

    public ClearableRecipientEditor(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.clearableEditTextStyle);
    }

    public ClearableRecipientEditor(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        super(context, attributeSet, i);
        m16541a(context, attributeSet, i);
    }

    @Deprecated
    public void setOnMaxLengthReachListener(InterfaceC4359c interfaceC4359c) {
        this.f15803f = interfaceC4359c;
    }

    public void setClearButtonClickListener(View.OnClickListener onClickListener) {
        this.f15804g = onClickListener;
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        super.setMinimumHeight(i);
        this.f15798a.setMinimumHeight(i);
    }

    @Override // android.view.View
    public void setOnKeyListener(View.OnKeyListener onKeyListener) {
        this.f15799b.setOnKeyListener(onKeyListener);
    }

    public void setText(CharSequence charSequence) {
        this.f15799b.setText(charSequence);
    }

    public void setHint(CharSequence charSequence) {
        this.f15805h = charSequence;
        this.f15799b.setHint(m16539a(charSequence));
    }

    public void setHint(int i) {
        setHint(getContext().getResources().getText(i));
    }

    public void setMaxLength(int i) {
        this.f15802e = i;
        this.f15799b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.f15802e)});
    }

    public void setSelection(int i) {
        this.f15799b.setSelection(i);
    }

    public void setSelection(int i, int i2) {
        this.f15799b.setSelection(i, i2);
    }

    public void setImeOptions(int i) {
        this.f15799b.setImeOptions(i);
    }

    public void setOnEditorActionListener(TextView.OnEditorActionListener onEditorActionListener) {
        this.f15799b.setOnEditorActionListener(onEditorActionListener);
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        this.f15799b.setFilters(inputFilterArr);
    }

    public void setInputType(int i) {
        this.f15799b.setInputType(i);
    }

    public void setSearchIcon(int i) {
        this.f15801d = i;
        setHint(this.f15805h);
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f15799b.setOnFocusChangeListener(onFocusChangeListener);
    }

    /* renamed from: a */
    private void m16541a(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1880ci.ClearableEditText, i, 0);
        this.f15798a = (ViewGroup) LayoutInflater.from(getContext()).inflate(typedArrayObtainStyledAttributes.getResourceId(5, R.layout.layout_recipient_clearable_edit_text), (ViewGroup) this, false);
        addView(this.f15798a);
        if (this.f15798a instanceof InterfaceC4917j) {
            ((InterfaceC4917j) this.f15798a).setOnDrawableStateChanged(this);
            Drawable background = getBackground();
            if (background != null) {
                background.setState(this.f15798a.getDrawableState());
            }
        }
        this.f15799b = (RecipientsEditor) this.f15798a.findViewById(R.id.clearable_text1);
        this.f15799b.setSingleLine();
        this.f15799b.addTextChangedListener(this);
        this.f15798a.setMinimumHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0));
        int i2 = typedArrayObtainStyledAttributes.getInt(2, 0);
        String string = getResources().getString(R.string.join_country_search_hint);
        int i3 = typedArrayObtainStyledAttributes.getInt(3, this.f15799b.getInputType());
        int i4 = typedArrayObtainStyledAttributes.getInt(4, this.f15799b.getImeOptions());
        this.f15801d = typedArrayObtainStyledAttributes.getResourceId(6, 0);
        typedArrayObtainStyledAttributes.recycle();
        if (i2 > 0) {
            setMaxLength(i2);
        }
        setHint(string);
        this.f15799b.setInputType(i3);
        this.f15799b.setImeOptions(i4);
        this.f15800c = (ImageButton) this.f15798a.findViewById(R.id.clearable_button1);
        this.f15800c.setOnClickListener(this);
        m16540a();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f15802e > 0 && charSequence.length() == this.f15802e && this.f15803f != null) {
            this.f15803f.m16545a();
        }
        m16540a();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f15799b.setText("");
        if (this.f15804g != null) {
            this.f15804g.onClick(this);
        }
        this.f15799b.requestFocus();
    }

    @Override // com.sec.chaton.widget.InterfaceC4918k
    /* renamed from: a */
    public void mo16542a(View view, int[] iArr) {
        Drawable background = getBackground();
        if (background != null) {
            background.setState(iArr);
        }
    }

    /* renamed from: a */
    private void m16540a() {
        Editable text = this.f15799b.getText();
        if (text == null || text.length() == 0) {
            this.f15800c.setVisibility(8);
        } else {
            this.f15800c.setVisibility(0);
        }
    }

    /* renamed from: a */
    private CharSequence m16539a(CharSequence charSequence) throws Resources.NotFoundException {
        if (this.f15801d != 0 && charSequence != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.append(charSequence);
            Drawable drawable = getContext().getResources().getDrawable(this.f15801d);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            spannableStringBuilder.setSpan(new ImageSpan(drawable), 1, 2, 33);
            return spannableStringBuilder;
        }
        return charSequence;
    }
}
