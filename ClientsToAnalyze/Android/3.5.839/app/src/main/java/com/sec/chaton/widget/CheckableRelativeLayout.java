package com.sec.chaton.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;

/* loaded from: classes.dex */
public class CheckableRelativeLayout extends RelativeLayout implements Checkable {

    /* renamed from: a */
    private boolean f17879a;

    /* renamed from: b */
    private int f17880b;

    /* renamed from: c */
    private int f17881c;

    /* renamed from: d */
    private CompoundButton f17882d;

    public CheckableRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17880b = 0;
        this.f17881c = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res-auto", "checkable_widget", -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        View viewFindViewById = findViewById(this.f17881c);
        if (viewFindViewById != null) {
            this.f17882d = (CompoundButton) viewFindViewById;
        }
        setChoiceMode(this.f17880b);
        setChecked(this.f17879a);
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f17882d = null;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        this.f17879a = z;
        if (this.f17882d != null) {
            this.f17882d.setChecked(z);
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f17879a;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f17879a = !this.f17879a;
        if (this.f17882d != null) {
            this.f17882d.toggle();
        }
    }

    public void setChoiceMode(int i) {
        this.f17880b = i;
        if (this.f17882d != null) {
            switch (i) {
                case 0:
                    this.f17882d.setVisibility(8);
                    break;
                case 1:
                    this.f17882d.setVisibility(0);
                    TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.listChoiceIndicatorSingle});
                    this.f17882d.setButtonDrawable(typedArrayObtainStyledAttributes.getDrawable(0));
                    typedArrayObtainStyledAttributes.recycle();
                    break;
                case 2:
                    this.f17882d.setVisibility(0);
                    TypedArray typedArrayObtainStyledAttributes2 = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.listChoiceIndicatorMultiple});
                    this.f17882d.setButtonDrawable(typedArrayObtainStyledAttributes2.getDrawable(0));
                    typedArrayObtainStyledAttributes2.recycle();
                    break;
            }
        }
    }
}
