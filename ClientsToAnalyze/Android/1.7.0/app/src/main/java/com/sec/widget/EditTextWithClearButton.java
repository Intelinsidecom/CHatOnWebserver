package com.sec.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import com.sec.chaton.C0122a;
import com.sec.chaton.R;
import com.sec.chaton.util.C1301ax;

/* loaded from: classes.dex */
public class EditTextWithClearButton extends EditText {

    /* renamed from: a */
    private Drawable f5652a;

    /* renamed from: b */
    private Drawable f5653b;

    /* renamed from: c */
    private boolean f5654c;

    /* renamed from: d */
    private boolean f5655d;

    /* renamed from: e */
    private int f5656e;

    /* renamed from: f */
    private int f5657f;

    /* renamed from: g */
    private View.OnTouchListener f5658g;

    /* renamed from: h */
    private TextWatcher f5659h;

    public EditTextWithClearButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5654c = true;
        this.f5655d = false;
        this.f5656e = -1;
        this.f5658g = new ViewOnTouchListenerC1630r(this);
        this.f5659h = new C1631s(this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0122a.EditTextWithClearButton);
        this.f5656e = typedArrayObtainStyledAttributes.getInt(0, this.f5656e);
        setPadding((int) C1301ax.m4544a(12.0f), 0, (int) C1301ax.m4544a(7.0f), 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f5652a = getResources().getDrawable(R.drawable.input_filed_delete_xml);
        this.f5653b = getResources().getDrawable(R.drawable.icon_search);
        addTextChangedListener(this.f5659h);
        m5839a();
    }

    public void setMaxLengthString(int i) {
        this.f5657f = i;
    }

    public void setShowClear(boolean z) {
        this.f5654c = z;
        m5839a();
    }

    public void setShowSearch(boolean z) {
        this.f5655d = z;
        m5839a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5839a() {
        if (this.f5654c && getText().length() > 0 && isFocused()) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.f5652a, (Drawable) null);
            setOnTouchListener(this.f5658g);
        } else {
            if (this.f5655d) {
                setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.f5653b, (Drawable) null);
            } else {
                setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            setOnTouchListener(null);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        m5839a();
    }
}
