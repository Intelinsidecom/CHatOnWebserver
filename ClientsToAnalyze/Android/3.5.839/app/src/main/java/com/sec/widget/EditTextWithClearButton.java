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
import com.sec.chaton.C1880ci;
import com.sec.chaton.R;

@SuppressLint({"NewApi"})
@Deprecated
/* loaded from: classes.dex */
public class EditTextWithClearButton extends RelativeLayout {

    /* renamed from: a */
    public ImageButton f18747a;

    /* renamed from: b */
    public ImageButton f18748b;

    /* renamed from: c */
    public EditText f18749c;

    /* renamed from: d */
    private Drawable f18750d;

    /* renamed from: e */
    private Drawable f18751e;

    /* renamed from: f */
    private boolean f18752f;

    /* renamed from: g */
    private boolean f18753g;

    /* renamed from: h */
    private int f18754h;

    /* renamed from: i */
    private int f18755i;

    /* renamed from: j */
    private CharSequence f18756j;

    /* renamed from: k */
    private View.OnClickListener f18757k;

    /* renamed from: l */
    private View.OnFocusChangeListener f18758l;

    /* renamed from: m */
    private View.OnTouchListener f18759m;

    /* renamed from: n */
    private TextWatcher f18760n;

    public EditTextWithClearButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18752f = true;
        this.f18753g = false;
        this.f18749c = null;
        this.f18754h = -1;
        this.f18756j = null;
        this.f18757k = new ViewOnClickListenerC5168k(this);
        this.f18758l = new ViewOnFocusChangeListenerC5169l(this);
        this.f18759m = new ViewOnTouchListenerC5170m(this);
        this.f18760n = new C5171n(this);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.edit_text_with_clear_button, (ViewGroup) this, true);
        this.f18747a = (ImageButton) viewInflate.findViewById(R.id.clear_btn);
        this.f18748b = (ImageButton) viewInflate.findViewById(R.id.search_btn);
        this.f18749c = (EditText) viewInflate.findViewById(R.id.buddy_search_editText);
        this.f18749c.setSingleLine();
        this.f18749c.setOnFocusChangeListener(this.f18758l);
        this.f18749c.setOnTouchListener(this.f18759m);
        this.f18747a.setOnClickListener(this.f18757k);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1880ci.EditTextWithClearButton);
        this.f18754h = typedArrayObtainStyledAttributes.getInt(1, this.f18754h);
        m19629a(7);
        this.f18756j = typedArrayObtainStyledAttributes.getText(0);
        if (this.f18756j != null) {
            this.f18749c.setHint(this.f18756j);
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f18750d = getResources().getDrawable(R.drawable.chat_btn_icon_cancel);
        this.f18751e = getResources().getDrawable(R.drawable.input_btn_ic_search);
        this.f18749c.addTextChangedListener(this.f18760n);
        m19628a();
    }

    /* renamed from: a */
    private void m19629a(int i) {
    }

    public void setMaxLengthString(int i) {
        this.f18755i = i;
    }

    public void setShowClear(boolean z) {
        this.f18752f = z;
        m19628a();
    }

    public void setShowSearch(boolean z) {
        this.f18753g = z;
        m19628a();
    }

    public void setMaxLenth(int i) {
        this.f18754h = i;
        this.f18749c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m19628a() {
        if (this.f18752f && this.f18749c.getText().length() > 0) {
            this.f18747a.setBackgroundDrawable(this.f18750d);
            this.f18747a.setOnClickListener(this.f18757k);
            this.f18747a.setFocusable(true);
            this.f18748b.setBackgroundDrawable(null);
            return;
        }
        if (this.f18753g) {
            this.f18747a.setBackgroundDrawable(null);
            this.f18747a.setFocusable(false);
            this.f18748b.setVisibility(0);
            this.f18748b.setBackgroundDrawable(this.f18751e);
        } else {
            this.f18747a.setBackgroundDrawable(null);
            this.f18748b.setVisibility(8);
        }
        this.f18747a.setOnClickListener(null);
        this.f18747a.setFocusable(false);
        this.f18748b.setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m19632b() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }
}
