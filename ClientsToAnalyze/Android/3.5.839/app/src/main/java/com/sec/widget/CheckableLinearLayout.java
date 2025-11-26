package com.sec.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class CheckableLinearLayout extends LinearLayout implements Checkable {

    /* renamed from: a */
    final String f18723a;

    /* renamed from: b */
    final String f18724b;

    /* renamed from: c */
    final String f18725c;

    /* renamed from: d */
    int f18726d;

    /* renamed from: e */
    int f18727e;

    /* renamed from: f */
    Checkable f18728f;

    public CheckableLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18723a = "http://schemas.android.com/apk/res/com.sec.chaton";
        this.f18724b = "checkable_single";
        this.f18725c = "checkable_multiple";
        this.f18726d = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/com.sec.chaton", "checkable_single", -1);
        this.f18727e = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/com.sec.chaton", "checkable_multiple", -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        View viewFindViewById = findViewById(this.f18726d);
        View viewFindViewById2 = findViewById(this.f18727e);
        if (viewFindViewById != 0 && viewFindViewById.getVisibility() == 0) {
            this.f18728f = (Checkable) viewFindViewById;
        } else if (viewFindViewById2 != 0 && viewFindViewById2.getVisibility() == 0) {
            this.f18728f = (Checkable) viewFindViewById2;
        } else {
            this.f18728f = null;
        }
        super.onAttachedToWindow();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.f18728f != null) {
            this.f18728f.setChecked(z);
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        if (this.f18728f == null) {
            return false;
        }
        return this.f18728f.isChecked();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (this.f18728f != null) {
            this.f18728f.toggle();
        }
    }
}
