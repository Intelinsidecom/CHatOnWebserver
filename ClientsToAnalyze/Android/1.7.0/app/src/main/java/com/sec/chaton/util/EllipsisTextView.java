package com.sec.chaton.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;

/* loaded from: classes.dex */
public class EllipsisTextView extends TextView {

    /* renamed from: a */
    private int f4421a;

    /* renamed from: b */
    private int f4422b;

    /* renamed from: c */
    private CharSequence f4423c;

    /* renamed from: d */
    private boolean f4424d;

    /* renamed from: e */
    private String f4425e;

    public EllipsisTextView(Context context) {
        super(context);
        this.f4421a = -1;
        this.f4422b = -1;
        this.f4423c = "";
        this.f4424d = false;
        this.f4425e = "...";
    }

    public EllipsisTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4421a = -1;
        this.f4422b = -1;
        this.f4423c = "";
        this.f4424d = false;
        this.f4425e = "...";
        m4456a(attributeSet);
    }

    public EllipsisTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4421a = -1;
        this.f4422b = -1;
        this.f4423c = "";
        this.f4424d = false;
        this.f4425e = "...";
        m4456a(attributeSet);
    }

    public void setEllipsisText(String str) {
        if (str != null) {
            this.f4425e = str;
        }
    }

    /* renamed from: a */
    private void m4456a(AttributeSet attributeSet) {
        for (int i = 0; i < attributeSet.getAttributeCount(); i++) {
            if ("maxLines".equals(attributeSet.getAttributeName(i))) {
                this.f4421a = attributeSet.getAttributeIntValue(i, -1);
            } else if ("lines".equals(attributeSet.getAttributeName(i))) {
                this.f4422b = attributeSet.getAttributeIntValue(i, -1);
            }
        }
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.f4421a = i;
    }

    /* renamed from: a */
    public int m4457a() {
        return this.f4421a;
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        super.setLines(i);
        this.f4422b = i;
    }

    /* renamed from: b */
    public int m4458b() {
        return this.f4422b;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        if (bufferType != TextView.BufferType.SPANNABLE) {
            this.f4423c = charSequence;
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
        this.f4424d = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0091, code lost:
    
        setText(r0.substring(0, r2 - 1).trim() + r8.f4425e + r3, android.widget.TextView.BufferType.SPANNABLE);
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onDraw(android.graphics.Canvas r9) {
        /*
            r8 = this;
            r7 = -1
            boolean r0 = r8.f4424d
            if (r0 != 0) goto Lb8
            java.lang.CharSequence r0 = r8.f4423c
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto Lb8
            java.lang.String r1 = " "
            java.lang.String r2 = ""
            java.lang.String r1 = r0.replaceAll(r1, r2)
            java.lang.String r2 = "\n"
            java.lang.String r3 = ""
            java.lang.String r1 = r1.replaceAll(r2, r3)
            int r1 = r1.length()
            if (r1 == 0) goto Lb8
            int r2 = r8.m4457a()
            int r1 = r8.m4458b()
            int r3 = r0.length()
            java.lang.String r4 = "("
            int r4 = r0.lastIndexOf(r4)
            int r4 = r3 - r4
            int r5 = r0.length()
            java.lang.String r3 = ""
            r6 = 1
            if (r1 <= r6) goto L46
            if (r5 <= r4) goto L46
            int r3 = r5 - r4
            java.lang.String r3 = r0.substring(r3, r5)
        L46:
            if (r1 == r7) goto Ld1
        L48:
            int r2 = r8.getLineCount()
            if (r2 <= r1) goto Lb8
            if (r1 == r7) goto Lb8
            android.text.Layout r2 = r8.getLayout()
            if (r2 == 0) goto Lb8
            int r6 = r1 + (-1)
            int r2 = r2.getLineEnd(r6)
            java.lang.String r6 = r8.f4425e     // Catch: java.lang.IndexOutOfBoundsException -> Lbf
            int r6 = r6.length()     // Catch: java.lang.IndexOutOfBoundsException -> Lbf
            int r2 = r2 - r6
            int r2 = r2 - r4
        L64:
            if (r2 >= r5) goto Lb8
            r4 = 0
            java.lang.String r4 = r0.substring(r4, r2)     // Catch: java.lang.IndexOutOfBoundsException -> Lbf
            java.lang.String r4 = r4.trim()     // Catch: java.lang.IndexOutOfBoundsException -> Lbf
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.IndexOutOfBoundsException -> Lbf
            r6.<init>()     // Catch: java.lang.IndexOutOfBoundsException -> Lbf
            java.lang.StringBuilder r4 = r6.append(r4)     // Catch: java.lang.IndexOutOfBoundsException -> Lbf
            java.lang.String r6 = r8.f4425e     // Catch: java.lang.IndexOutOfBoundsException -> Lbf
            java.lang.StringBuilder r4 = r4.append(r6)     // Catch: java.lang.IndexOutOfBoundsException -> Lbf
            java.lang.StringBuilder r4 = r4.append(r3)     // Catch: java.lang.IndexOutOfBoundsException -> Lbf
            java.lang.String r4 = r4.toString()     // Catch: java.lang.IndexOutOfBoundsException -> Lbf
            android.widget.TextView$BufferType r6 = android.widget.TextView.BufferType.SPANNABLE     // Catch: java.lang.IndexOutOfBoundsException -> Lbf
            r8.setText(r4, r6)     // Catch: java.lang.IndexOutOfBoundsException -> Lbf
            int r4 = r8.getLineCount()     // Catch: java.lang.IndexOutOfBoundsException -> Lbf
            if (r4 <= r1) goto Lbc
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.IndexOutOfBoundsException -> Lbf
            r1.<init>()     // Catch: java.lang.IndexOutOfBoundsException -> Lbf
            r4 = 0
            int r2 = r2 + (-1)
            java.lang.String r2 = r0.substring(r4, r2)     // Catch: java.lang.IndexOutOfBoundsException -> Lbf
            java.lang.String r2 = r2.trim()     // Catch: java.lang.IndexOutOfBoundsException -> Lbf
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.IndexOutOfBoundsException -> Lbf
            java.lang.String r2 = r8.f4425e     // Catch: java.lang.IndexOutOfBoundsException -> Lbf
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.IndexOutOfBoundsException -> Lbf
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.IndexOutOfBoundsException -> Lbf
            java.lang.String r1 = r1.toString()     // Catch: java.lang.IndexOutOfBoundsException -> Lbf
            android.widget.TextView$BufferType r2 = android.widget.TextView.BufferType.SPANNABLE     // Catch: java.lang.IndexOutOfBoundsException -> Lbf
            r8.setText(r1, r2)     // Catch: java.lang.IndexOutOfBoundsException -> Lbf
        Lb8:
            super.onDraw(r9)
            return
        Lbc:
            int r2 = r2 + 1
            goto L64
        Lbf:
            r1 = move-exception
            java.lang.Class r2 = r8.getClass()
            java.lang.String r2 = r2.getSimpleName()
            com.sec.chaton.util.C1341p.m4653a(r1, r2)
            android.widget.TextView$BufferType r1 = android.widget.TextView.BufferType.SPANNABLE
            r8.setText(r0, r1)
            goto Lb8
        Ld1:
            r1 = r2
            goto L48
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.EllipsisTextView.onDraw(android.graphics.Canvas):void");
    }
}
