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
    final String f11742a;

    /* renamed from: b */
    final String f11743b;

    /* renamed from: c */
    private boolean f11744c;

    /* renamed from: d */
    private int f11745d;

    /* renamed from: e */
    private int f11746e;

    /* renamed from: f */
    private CompoundButton f11747f;

    public CheckableRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11742a = "http://schemas.android.com/apk/res-auto";
        this.f11743b = "checkable_widget";
        this.f11745d = 0;
        this.f11746e = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res-auto", "checkable_widget", -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        View viewFindViewById = findViewById(this.f11746e);
        if (viewFindViewById != null) {
            this.f11747f = (CompoundButton) viewFindViewById;
        }
        setChoiceMode(this.f11745d);
        setChecked(this.f11744c);
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f11747f = null;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        this.f11744c = z;
        if (this.f11747f != null) {
            this.f11747f.setChecked(z);
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f11744c;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f11744c = !this.f11744c;
        if (this.f11747f != null) {
            this.f11747f.toggle();
        }
    }

    public void setChoiceMode(int i) {
        this.f11745d = i;
        if (this.f11747f != null) {
            switch (i) {
                case 0:
                    this.f11747f.setVisibility(8);
                    break;
                case 1:
                    this.f11747f.setVisibility(0);
                    TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.listChoiceIndicatorSingle});
                    this.f11747f.setButtonDrawable(typedArrayObtainStyledAttributes.getDrawable(0));
                    typedArrayObtainStyledAttributes.recycle();
                    break;
                case 2:
                    this.f11747f.setVisibility(0);
                    TypedArray typedArrayObtainStyledAttributes2 = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.listChoiceIndicatorMultiple});
                    this.f11747f.setButtonDrawable(typedArrayObtainStyledAttributes2.getDrawable(0));
                    typedArrayObtainStyledAttributes2.recycle();
                    break;
            }
        }
    }
}
