package com.sec.chaton.widget;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.StateSet;
import android.widget.TextView;
import com.sec.chaton.p076m.C2575g;

/* compiled from: StateTextView.java */
/* renamed from: com.sec.chaton.widget.r */
/* loaded from: classes.dex */
public final class C4925r {

    /* renamed from: a */
    private TextView f17982a;

    /* renamed from: b */
    private int f17983b;

    /* renamed from: c */
    private int f17984c;

    /* renamed from: d */
    private int f17985d;

    /* renamed from: e */
    private int f17986e;

    /* renamed from: f */
    private int f17987f;

    /* renamed from: a */
    public static C4925r m18725a(TextView textView, AttributeSet attributeSet, int i) {
        return new C4925r(textView, attributeSet, i);
    }

    private C4925r(TextView textView, AttributeSet attributeSet, int i) {
        this.f17982a = textView;
        TypedArray typedArrayObtainStyledAttributes = textView.getContext().obtainStyledAttributes(attributeSet, C2575g.StateTextView, i, 0);
        this.f17983b = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        this.f17984c = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        this.f17985d = typedArrayObtainStyledAttributes.getResourceId(2, -1);
        this.f17986e = typedArrayObtainStyledAttributes.getResourceId(3, -1);
        this.f17987f = typedArrayObtainStyledAttributes.getResourceId(4, -1);
        typedArrayObtainStyledAttributes.recycle();
        m18726a();
    }

    /* renamed from: a */
    public void m18726a() {
        int[] drawableState = this.f17982a.getDrawableState();
        if (this.f17985d != -1 && StateSet.stateSetMatches(StateTextView.PRESSED_ENABLED_STATE_SET, drawableState)) {
            this.f17982a.setTextAppearance(this.f17982a.getContext(), this.f17985d);
            return;
        }
        if (this.f17986e != -1 && StateSet.stateSetMatches(StateTextView.ENABLED_FOCUSED_STATE_SET, drawableState)) {
            this.f17982a.setTextAppearance(this.f17982a.getContext(), this.f17986e);
            return;
        }
        if (this.f17984c == -1 || !StateSet.stateSetMatches(StateTextView.ENABLED_SELECTED_STATE_SET, drawableState)) {
            if (StateSet.stateSetMatches(StateTextView.ENABLED_STATE_SET, drawableState)) {
                this.f17982a.setTextAppearance(this.f17982a.getContext(), this.f17983b);
                return;
            } else if (this.f17987f != -1) {
                this.f17982a.setTextAppearance(this.f17982a.getContext(), this.f17987f);
                return;
            } else {
                this.f17982a.setTextAppearance(this.f17982a.getContext(), this.f17983b);
                return;
            }
        }
        this.f17982a.setTextAppearance(this.f17982a.getContext(), this.f17984c);
    }
}
