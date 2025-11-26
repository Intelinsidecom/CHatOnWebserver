package com.sec.chaton.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;

/* loaded from: classes.dex */
public class EllipsisTextView extends TextView {

    /* renamed from: a */
    private int f6278a;

    /* renamed from: b */
    private int f6279b;

    /* renamed from: c */
    private CharSequence f6280c;

    /* renamed from: d */
    private String f6281d;

    public EllipsisTextView(Context context) {
        super(context);
        this.f6278a = -1;
        this.f6279b = -1;
        this.f6280c = "";
        this.f6281d = "...";
    }

    public EllipsisTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6278a = -1;
        this.f6279b = -1;
        this.f6280c = "";
        this.f6281d = "...";
        m5838a(attributeSet);
    }

    public EllipsisTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6278a = -1;
        this.f6279b = -1;
        this.f6280c = "";
        this.f6281d = "...";
        m5838a(attributeSet);
    }

    public void setEllipsisText(String str) {
        if (str != null) {
            this.f6281d = str;
        }
    }

    /* renamed from: a */
    private void m5838a(AttributeSet attributeSet) {
        for (int i = 0; i < attributeSet.getAttributeCount(); i++) {
            if ("maxLines".equals(attributeSet.getAttributeName(i))) {
                this.f6278a = attributeSet.getAttributeIntValue(i, -1);
            } else if ("lines".equals(attributeSet.getAttributeName(i))) {
                this.f6279b = attributeSet.getAttributeIntValue(i, -1);
            }
        }
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.f6278a = i;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.f6278a;
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        super.setLines(i);
        this.f6279b = i;
    }

    /* renamed from: a */
    public int m5839a() {
        return this.f6279b;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        if (bufferType != TextView.BufferType.SPANNABLE) {
            this.f6280c = charSequence;
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x008a, code lost:
    
        setText(r0.substring(0, r2 - 1).trim() + r9.f6281d + r5, android.widget.TextView.BufferType.SPANNABLE);
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onDraw(android.graphics.Canvas r10) {
        /*
            r9 = this;
            r3 = 4
            r8 = -1
            r4 = 0
            java.lang.CharSequence r0 = r9.f6280c
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto Lb1
            java.lang.String r1 = " "
            java.lang.String r2 = ""
            java.lang.String r1 = r0.replaceAll(r1, r2)
            java.lang.String r2 = "\n"
            java.lang.String r5 = ""
            java.lang.String r1 = r1.replaceAll(r2, r5)
            int r1 = r1.length()
            if (r1 == 0) goto Lb1
            int r1 = r9.getMaxLines()
            int r2 = r9.m5839a()
            int r6 = r0.length()
            java.lang.String r5 = ""
            r7 = 1
            if (r2 <= r7) goto L38
            if (r6 <= r3) goto L38
            int r5 = r6 + (-4)
            java.lang.String r5 = r0.substring(r5, r6)
        L38:
            if (r2 == r8) goto L3b
            r1 = r2
        L3b:
            int r7 = r9.getLineCount()
            if (r7 <= r1) goto Lb1
            if (r1 == r8) goto Lb1
            android.text.Layout r7 = r9.getLayout()
            if (r7 == 0) goto Lb1
            int r8 = r1 + (-1)
            int r7 = r7.getLineEnd(r8)
            r8 = 2
            if (r2 != r8) goto Lca
            r2 = r3
        L53:
            java.lang.String r3 = r9.f6281d     // Catch: java.lang.IndexOutOfBoundsException -> Lb8
            int r3 = r3.length()     // Catch: java.lang.IndexOutOfBoundsException -> Lb8
            int r3 = r7 - r3
            int r2 = r3 - r2
        L5d:
            if (r2 >= r6) goto Lb1
            r3 = 0
            java.lang.String r3 = r0.substring(r3, r2)     // Catch: java.lang.IndexOutOfBoundsException -> Lb8
            java.lang.String r3 = r3.trim()     // Catch: java.lang.IndexOutOfBoundsException -> Lb8
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.IndexOutOfBoundsException -> Lb8
            r4.<init>()     // Catch: java.lang.IndexOutOfBoundsException -> Lb8
            java.lang.StringBuilder r3 = r4.append(r3)     // Catch: java.lang.IndexOutOfBoundsException -> Lb8
            java.lang.String r4 = r9.f6281d     // Catch: java.lang.IndexOutOfBoundsException -> Lb8
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.IndexOutOfBoundsException -> Lb8
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch: java.lang.IndexOutOfBoundsException -> Lb8
            java.lang.String r3 = r3.toString()     // Catch: java.lang.IndexOutOfBoundsException -> Lb8
            android.widget.TextView$BufferType r4 = android.widget.TextView.BufferType.SPANNABLE     // Catch: java.lang.IndexOutOfBoundsException -> Lb8
            r9.setText(r3, r4)     // Catch: java.lang.IndexOutOfBoundsException -> Lb8
            int r3 = r9.getLineCount()     // Catch: java.lang.IndexOutOfBoundsException -> Lb8
            if (r3 <= r1) goto Lb5
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.IndexOutOfBoundsException -> Lb8
            r1.<init>()     // Catch: java.lang.IndexOutOfBoundsException -> Lb8
            r3 = 0
            int r2 = r2 + (-1)
            java.lang.String r2 = r0.substring(r3, r2)     // Catch: java.lang.IndexOutOfBoundsException -> Lb8
            java.lang.String r2 = r2.trim()     // Catch: java.lang.IndexOutOfBoundsException -> Lb8
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.IndexOutOfBoundsException -> Lb8
            java.lang.String r2 = r9.f6281d     // Catch: java.lang.IndexOutOfBoundsException -> Lb8
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.IndexOutOfBoundsException -> Lb8
            java.lang.StringBuilder r1 = r1.append(r5)     // Catch: java.lang.IndexOutOfBoundsException -> Lb8
            java.lang.String r1 = r1.toString()     // Catch: java.lang.IndexOutOfBoundsException -> Lb8
            android.widget.TextView$BufferType r2 = android.widget.TextView.BufferType.SPANNABLE     // Catch: java.lang.IndexOutOfBoundsException -> Lb8
            r9.setText(r1, r2)     // Catch: java.lang.IndexOutOfBoundsException -> Lb8
        Lb1:
            super.onDraw(r10)
            return
        Lb5:
            int r2 = r2 + 1
            goto L5d
        Lb8:
            r1 = move-exception
            java.lang.Class r2 = r9.getClass()
            java.lang.String r2 = r2.getSimpleName()
            com.sec.chaton.util.C1786r.m6056a(r1, r2)
            android.widget.TextView$BufferType r1 = android.widget.TextView.BufferType.SPANNABLE
            r9.setText(r0, r1)
            goto Lb1
        Lca:
            r2 = r4
            goto L53
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.EllipsisTextView.onDraw(android.graphics.Canvas):void");
    }
}
