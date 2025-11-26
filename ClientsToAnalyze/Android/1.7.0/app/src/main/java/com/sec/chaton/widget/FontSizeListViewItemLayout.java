package com.sec.chaton.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: classes.dex */
public class FontSizeListViewItemLayout extends LinearLayout implements Checkable {

    /* renamed from: a */
    private boolean f4604a;

    /* renamed from: b */
    private TextView f4605b;

    /* renamed from: c */
    private CheckedTextView f4606c;

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
        this.f4605b = (TextView) findViewById(R.id.text1);
        this.f4606c = (CheckedTextView) findViewById(R.id.text2);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f4604a;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.f4604a != z) {
            this.f4604a = z;
            if (this.f4606c != null) {
                this.f4606c.setChecked(this.f4604a);
            }
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f4604a);
    }

    /* renamed from: a */
    public void m4717a(int i, float f) {
        if (this.f4605b != null) {
            this.f4605b.setTextSize(i, f);
        }
    }

    /* renamed from: a */
    public void m4718a(String str) {
        if (this.f4605b != null) {
            this.f4605b.setText(str);
        }
    }
}
