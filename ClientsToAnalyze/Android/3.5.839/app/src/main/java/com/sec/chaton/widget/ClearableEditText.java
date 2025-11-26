package com.sec.chaton.widget;

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
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import com.sec.chaton.p076m.C2570b;
import com.sec.chaton.p076m.C2572d;
import com.sec.chaton.p076m.C2574f;
import com.sec.chaton.p076m.C2575g;

/* loaded from: classes.dex */
public class ClearableEditText extends FrameLayout implements TextWatcher, View.OnClickListener, InterfaceC4918k {

    /* renamed from: a */
    private ViewGroup f17883a;

    /* renamed from: b */
    private EditText f17884b;

    /* renamed from: c */
    private ImageButton f17885c;

    /* renamed from: d */
    private int f17886d;

    /* renamed from: e */
    private int f17887e;

    /* renamed from: f */
    @Deprecated
    private InterfaceC4909b f17888f;

    /* renamed from: g */
    private View.OnClickListener f17889g;

    /* renamed from: h */
    private CharSequence f17890h;

    public ClearableEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C2570b.clearableEditTextStyle);
    }

    public ClearableEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18655a(context, attributeSet, i);
    }

    @Deprecated
    public void setOnMaxLengthReachListener(InterfaceC4909b interfaceC4909b) {
        this.f17888f = interfaceC4909b;
    }

    public void setClearButtonClickListener(View.OnClickListener onClickListener) {
        this.f17889g = onClickListener;
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        super.setMinimumHeight(i);
        this.f17883a.setMinimumHeight(i);
    }

    @Override // android.view.View
    public void setOnKeyListener(View.OnKeyListener onKeyListener) {
        this.f17884b.setOnKeyListener(onKeyListener);
    }

    /* renamed from: a */
    public CharSequence m18658a() {
        return this.f17884b.getText();
    }

    public void setText(CharSequence charSequence) {
        this.f17884b.setText(charSequence);
    }

    /* renamed from: a */
    public void m18660a(CharSequence charSequence) {
        this.f17884b.append(charSequence);
    }

    public void setHint(CharSequence charSequence) {
        this.f17890h = charSequence;
        this.f17884b.setHint(m18656b(charSequence));
    }

    public void setHint(int i) {
        setHint(getContext().getResources().getText(i));
    }

    public void setMaxLength(int i) {
        this.f17887e = i;
        this.f17884b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.f17887e)});
    }

    public void setSelection(int i) {
        this.f17884b.setSelection(i);
    }

    public void setSelection(int i, int i2) {
        this.f17884b.setSelection(i, i2);
    }

    /* renamed from: a */
    public void m18659a(TextWatcher textWatcher) {
        this.f17884b.addTextChangedListener(textWatcher);
    }

    /* renamed from: b */
    public void m18661b(TextWatcher textWatcher) {
        this.f17884b.removeTextChangedListener(textWatcher);
    }

    public void setImeOptions(int i) {
        this.f17884b.setImeOptions(i);
    }

    public void setOnEditorActionListener(TextView.OnEditorActionListener onEditorActionListener) {
        this.f17884b.setOnEditorActionListener(onEditorActionListener);
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        this.f17884b.setFilters(inputFilterArr);
    }

    /* renamed from: b */
    public InputFilter[] m18662b() {
        return this.f17884b.getFilters();
    }

    public void setInputType(int i) {
        this.f17884b.setInputType(i);
    }

    public void setSearchIcon(int i) {
        this.f17886d = i;
        setHint(this.f17890h);
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f17884b.setOnFocusChangeListener(onFocusChangeListener);
    }

    /* renamed from: a */
    private void m18655a(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2575g.ClearableEditText, i, 0);
        this.f17883a = (ViewGroup) LayoutInflater.from(getContext()).inflate(typedArrayObtainStyledAttributes.getResourceId(5, C2574f.layout_common_clearable_edit_text), (ViewGroup) this, false);
        addView(this.f17883a);
        if (this.f17883a instanceof InterfaceC4917j) {
            ((InterfaceC4917j) this.f17883a).setOnDrawableStateChanged(this);
            Drawable background = getBackground();
            if (background != null) {
                background.setState(this.f17883a.getDrawableState());
            }
        }
        this.f17884b = (EditText) this.f17883a.findViewById(C2572d.clearable_text1);
        this.f17884b.setSingleLine();
        this.f17884b.addTextChangedListener(this);
        this.f17883a.setMinimumHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0));
        int i2 = typedArrayObtainStyledAttributes.getInt(2, 0);
        String string = typedArrayObtainStyledAttributes.getString(1);
        int i3 = typedArrayObtainStyledAttributes.getInt(3, this.f17884b.getInputType());
        int i4 = typedArrayObtainStyledAttributes.getInt(4, this.f17884b.getImeOptions());
        this.f17886d = typedArrayObtainStyledAttributes.getResourceId(6, 0);
        typedArrayObtainStyledAttributes.recycle();
        if (i2 > 0) {
            setMaxLength(i2);
        }
        setHint(string);
        this.f17884b.setInputType(i3);
        this.f17884b.setImeOptions(i4);
        this.f17885c = (ImageButton) this.f17883a.findViewById(C2572d.clearable_button1);
        this.f17885c.setOnClickListener(this);
        m18657c();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f17887e > 0 && charSequence.length() == this.f17887e && this.f17888f != null) {
            this.f17888f.mo15183a();
        }
        m18657c();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f17884b.setText("");
        if (this.f17889g != null) {
            this.f17889g.onClick(this);
        }
        this.f17884b.requestFocus();
    }

    @Override // com.sec.chaton.widget.InterfaceC4918k
    /* renamed from: a */
    public void mo16542a(View view, int[] iArr) {
        Drawable background = getBackground();
        if (background != null) {
            background.setState(iArr);
        }
    }

    /* renamed from: c */
    private void m18657c() {
        Editable text = this.f17884b.getText();
        if (text == null || text.length() == 0) {
            this.f17885c.setVisibility(8);
        } else {
            this.f17885c.setVisibility(0);
        }
    }

    /* renamed from: b */
    private CharSequence m18656b(CharSequence charSequence) throws Resources.NotFoundException {
        ImageSpan imageSpan;
        if (this.f17886d != 0 && charSequence != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.append(charSequence);
            Drawable drawable = getContext().getResources().getDrawable(this.f17886d);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            if ((getContext().getResources().getConfiguration().screenLayout & 15) >= 3) {
                imageSpan = new ImageSpan(drawable, 1);
            } else {
                imageSpan = new ImageSpan(drawable, 0);
            }
            spannableStringBuilder.setSpan(imageSpan, 1, 2, 33);
            return spannableStringBuilder;
        }
        return charSequence;
    }
}
