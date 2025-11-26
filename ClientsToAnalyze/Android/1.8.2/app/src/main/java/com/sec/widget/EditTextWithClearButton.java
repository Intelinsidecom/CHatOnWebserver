package com.sec.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import com.sec.chaton.C0229at;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1722ae;

/* loaded from: classes.dex */
public class EditTextWithClearButton extends EditText {

    /* renamed from: a */
    private Drawable f7711a;

    /* renamed from: b */
    private Drawable f7712b;

    /* renamed from: c */
    private boolean f7713c;

    /* renamed from: d */
    private boolean f7714d;

    /* renamed from: e */
    private int f7715e;

    /* renamed from: f */
    private int f7716f;

    /* renamed from: g */
    private View.OnTouchListener f7717g;

    /* renamed from: h */
    private TextWatcher f7718h;

    public EditTextWithClearButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7713c = true;
        this.f7714d = false;
        this.f7715e = -1;
        this.f7717g = new ViewOnTouchListenerC2146r(this);
        this.f7718h = new C2147s(this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0229at.EditTextWithClearButton);
        this.f7715e = typedArrayObtainStyledAttributes.getInt(0, this.f7715e);
        typedArrayObtainStyledAttributes.recycle();
        if (GlobalApplication.m3265f()) {
            this.f7711a = getResources().getDrawable(R.drawable.input_field_delete_xml);
            this.f7712b = getResources().getDrawable(R.drawable.icon_search);
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight() == 0 ? (int) C1722ae.m5894a(7.0f) : getPaddingRight(), getPaddingBottom());
        } else {
            this.f7711a = getResources().getDrawable(R.drawable.btn_del);
            this.f7712b = getResources().getDrawable(R.drawable.ic_btn_search);
        }
        addTextChangedListener(this.f7718h);
        m7453a(getText().length() > 0);
    }

    public void setMaxLengthString(int i) {
        this.f7716f = i;
    }

    public void setShowClear(boolean z) {
        this.f7713c = z;
        m7453a(getText().length() > 0);
    }

    public void setShowSearch(boolean z) {
        this.f7714d = z;
        m7453a(getText().length() > 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7453a(boolean z) {
        if (z && this.f7713c) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.f7711a, (Drawable) null);
            setCompoundDrawablePadding(0);
            setOnTouchListener(this.f7717g);
            return;
        }
        if (this.f7714d) {
            if (GlobalApplication.m3265f()) {
                setCompoundDrawablesWithIntrinsicBounds(this.f7712b, (Drawable) null, (Drawable) null, (Drawable) null);
                setCompoundDrawablePadding(7);
            } else {
                setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.f7712b, (Drawable) null);
            }
        } else {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        setOnTouchListener(null);
    }
}
