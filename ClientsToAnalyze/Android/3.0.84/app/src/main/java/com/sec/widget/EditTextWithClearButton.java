package com.sec.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.sec.chaton.C0432aj;
import com.sec.chaton.R;

@SuppressLint({"NewApi"})
@Deprecated
/* loaded from: classes.dex */
public class EditTextWithClearButton extends RelativeLayout {

    /* renamed from: a */
    public ImageButton f13380a;

    /* renamed from: b */
    public ImageButton f13381b;

    /* renamed from: c */
    public EditText f13382c;

    /* renamed from: d */
    private Drawable f13383d;

    /* renamed from: e */
    private Drawable f13384e;

    /* renamed from: f */
    private boolean f13385f;

    /* renamed from: g */
    private boolean f13386g;

    /* renamed from: h */
    private int f13387h;

    /* renamed from: i */
    private int f13388i;

    /* renamed from: j */
    private CharSequence f13389j;

    /* renamed from: k */
    private View.OnClickListener f13390k;

    /* renamed from: l */
    private View.OnFocusChangeListener f13391l;

    /* renamed from: m */
    private View.OnTouchListener f13392m;

    /* renamed from: n */
    private TextWatcher f13393n;

    public EditTextWithClearButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13385f = true;
        this.f13386g = false;
        this.f13382c = null;
        this.f13387h = -1;
        this.f13389j = null;
        this.f13390k = new ViewOnClickListenerC3690x(this);
        this.f13391l = new ViewOnFocusChangeListenerC3691y(this);
        this.f13392m = new ViewOnTouchListenerC3692z(this);
        this.f13393n = new C3633aa(this);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.edit_text_with_clear_button, (ViewGroup) this, true);
        this.f13380a = (ImageButton) viewInflate.findViewById(R.id.clear_btn);
        this.f13381b = (ImageButton) viewInflate.findViewById(R.id.search_btn);
        this.f13382c = (EditText) viewInflate.findViewById(R.id.buddy_search_editText);
        this.f13382c.setSingleLine();
        this.f13382c.setOnFocusChangeListener(this.f13391l);
        this.f13382c.setOnTouchListener(this.f13392m);
        this.f13380a.setOnClickListener(this.f13390k);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0432aj.EditTextWithClearButton);
        this.f13387h = typedArrayObtainStyledAttributes.getInt(1, this.f13387h);
        m13097a(7);
        this.f13389j = typedArrayObtainStyledAttributes.getText(0);
        if (this.f13389j != null) {
            this.f13382c.setHint(this.f13389j);
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f13383d = getResources().getDrawable(R.drawable.chat_btn_icon_cancel);
        this.f13384e = getResources().getDrawable(R.drawable.input_btn_ic_search);
        this.f13382c.addTextChangedListener(this.f13393n);
        m13096a();
    }

    /* renamed from: a */
    private void m13097a(int i) {
    }

    public void setMaxLengthString(int i) {
        this.f13388i = i;
    }

    public void setShowClear(boolean z) {
        this.f13385f = z;
        m13096a();
    }

    public void setShowSearch(boolean z) {
        this.f13386g = z;
        m13096a();
    }

    public void setMaxLenth(int i) {
        this.f13387h = i;
        this.f13382c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m13096a() {
        if (this.f13385f && this.f13382c.getText().length() > 0) {
            this.f13380a.setBackgroundDrawable(this.f13383d);
            this.f13380a.setOnClickListener(this.f13390k);
            this.f13380a.setFocusable(true);
            this.f13381b.setBackgroundDrawable(null);
            return;
        }
        if (this.f13386g) {
            this.f13380a.setBackgroundDrawable(null);
            this.f13380a.setFocusable(false);
            this.f13381b.setVisibility(0);
            this.f13381b.setBackgroundDrawable(this.f13384e);
        } else {
            this.f13380a.setBackgroundDrawable(null);
            this.f13381b.setVisibility(8);
        }
        this.f13380a.setOnClickListener(null);
        this.f13380a.setFocusable(false);
        this.f13381b.setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m13100b() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }
}
