package com.sec.chaton.widget;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.StateSet;
import android.widget.TextView;
import com.sec.chaton.p044l.C1608g;

/* compiled from: StateTextView.java */
/* renamed from: com.sec.chaton.widget.k */
/* loaded from: classes.dex */
public final class C3264k {

    /* renamed from: a */
    private TextView f11785a;

    /* renamed from: b */
    private int f11786b;

    /* renamed from: c */
    private int f11787c;

    /* renamed from: d */
    private int f11788d;

    /* renamed from: e */
    private int f11789e;

    /* renamed from: f */
    private int f11790f;

    public C3264k(TextView textView, AttributeSet attributeSet, int i) {
        this.f11785a = textView;
        TypedArray typedArrayObtainStyledAttributes = textView.getContext().obtainStyledAttributes(attributeSet, C1608g.StateTextView, i, 0);
        this.f11786b = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        this.f11787c = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        this.f11788d = typedArrayObtainStyledAttributes.getResourceId(2, -1);
        this.f11789e = typedArrayObtainStyledAttributes.getResourceId(3, -1);
        this.f11790f = typedArrayObtainStyledAttributes.getResourceId(4, -1);
        typedArrayObtainStyledAttributes.recycle();
        m11488a();
    }

    /* renamed from: a */
    public void m11488a() {
        int[] drawableState = this.f11785a.getDrawableState();
        if (this.f11788d != -1 && StateSet.stateSetMatches(StateTextView.PRESSED_ENABLED_STATE_SET, drawableState)) {
            this.f11785a.setTextAppearance(this.f11785a.getContext(), this.f11788d);
            return;
        }
        if (this.f11789e != -1 && StateSet.stateSetMatches(StateTextView.ENABLED_FOCUSED_STATE_SET, drawableState)) {
            this.f11785a.setTextAppearance(this.f11785a.getContext(), this.f11789e);
            return;
        }
        if (this.f11787c == -1 || !StateSet.stateSetMatches(StateTextView.ENABLED_SELECTED_STATE_SET, drawableState)) {
            if (StateSet.stateSetMatches(StateTextView.ENABLED_STATE_SET, drawableState)) {
                this.f11785a.setTextAppearance(this.f11785a.getContext(), this.f11786b);
                return;
            } else if (this.f11790f != -1) {
                this.f11785a.setTextAppearance(this.f11785a.getContext(), this.f11790f);
                return;
            } else {
                this.f11785a.setTextAppearance(this.f11785a.getContext(), this.f11786b);
                return;
            }
        }
        this.f11785a.setTextAppearance(this.f11785a.getContext(), this.f11787c);
    }
}
