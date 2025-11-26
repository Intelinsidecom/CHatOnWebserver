package com.sec.chaton.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.CheckedTextView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* loaded from: classes.dex */
public class FontSizeListViewItemLayout extends RelativeLayout implements Checkable {

    /* renamed from: a */
    private boolean f6469a;

    /* renamed from: b */
    private TextView f6470b;

    /* renamed from: c */
    private CheckedTextView f6471c;

    public FontSizeListViewItemLayout(Context context) {
        super(context);
    }

    public FontSizeListViewItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FontSizeListViewItemLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f6470b = (TextView) findViewById(R.id.text1);
        this.f6471c = (CheckedTextView) findViewById(R.id.text2);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f6469a;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.f6469a != z) {
            this.f6469a = z;
            if (this.f6471c != null) {
                this.f6471c.setChecked(this.f6469a);
            }
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f6469a);
    }

    /* renamed from: a */
    public void m6115a(int i, float f) {
        if (this.f6470b != null) {
            this.f6470b.setTextSize(i, f);
        }
    }

    /* renamed from: a */
    public void m6116a(String str) {
        if (this.f6470b != null) {
            this.f6470b.setText(str);
        }
    }
}
