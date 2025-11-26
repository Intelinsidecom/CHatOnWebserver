package com.sec.chaton.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sec.chaton.widget.AdaptableTextView;

/* loaded from: classes.dex */
public class EllipsisTextView extends AdaptableTextView {

    /* renamed from: a */
    private int f17557a;

    /* renamed from: b */
    private int f17558b;

    /* renamed from: c */
    private CharSequence f17559c;

    /* renamed from: d */
    private boolean f17560d;

    /* renamed from: e */
    private String f17561e;

    public EllipsisTextView(Context context) {
        super(context);
        this.f17557a = -1;
        this.f17558b = -1;
        this.f17559c = "";
        this.f17560d = false;
        this.f17561e = "...";
    }

    public EllipsisTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17557a = -1;
        this.f17558b = -1;
        this.f17559c = "";
        this.f17560d = false;
        this.f17561e = "...";
        m18093a(attributeSet);
    }

    public EllipsisTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17557a = -1;
        this.f17558b = -1;
        this.f17559c = "";
        this.f17560d = false;
        this.f17561e = "...";
        m18093a(attributeSet);
    }

    public void setEllipsisText(String str) {
        if (str != null) {
            this.f17561e = str;
        }
    }

    /* renamed from: a */
    private void m18093a(AttributeSet attributeSet) {
        for (int i = 0; i < attributeSet.getAttributeCount(); i++) {
            if ("maxLines".equals(attributeSet.getAttributeName(i))) {
                this.f17557a = attributeSet.getAttributeIntValue(i, -1);
            } else if ("lines".equals(attributeSet.getAttributeName(i))) {
                this.f17558b = attributeSet.getAttributeIntValue(i, -1);
            }
        }
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.f17557a = i;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.f17557a;
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        super.setLines(i);
        this.f17558b = i;
    }

    /* renamed from: a */
    public int m18094a() {
        return this.f17558b;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        if (bufferType != TextView.BufferType.SPANNABLE) {
            this.f17559c = charSequence;
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
        this.f17560d = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0097, code lost:
    
        setText(r0.substring(0, r2 - 1).trim() + r8.f17561e + r3, android.widget.TextView.BufferType.SPANNABLE);
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
            boolean r0 = r8.f17560d
            if (r0 != 0) goto Lbe
            java.lang.CharSequence r0 = r8.f17559c
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto Lbe
            java.lang.String r1 = " "
            java.lang.String r2 = ""
            java.lang.String r1 = r0.replaceAll(r1, r2)
            java.lang.String r2 = "\n"
            java.lang.String r3 = ""
            java.lang.String r1 = r1.replaceAll(r2, r3)
            int r1 = r1.length()
            if (r1 == 0) goto Lbe
            int r2 = r8.getMaxLines()
            int r1 = r8.m18094a()
            int r3 = r0.length()
            java.lang.String r4 = "("
            int r4 = r0.lastIndexOf(r4)
            int r4 = r3 - r4
            int r5 = r0.length()
            java.lang.String r3 = ""
            r6 = 1
            if (r1 <= r6) goto L4c
            if (r5 <= r4) goto L4c
            int r3 = r5 - r4
            java.lang.String r3 = r0.substring(r3, r5)
        L4c:
            if (r1 == r7) goto Ld7
        L4e:
            int r2 = r8.getLineCount()
            if (r2 <= r1) goto Lbe
            if (r1 == r7) goto Lbe
            android.text.Layout r2 = r8.getLayout()
            if (r2 == 0) goto Lbe
            int r6 = r1 + (-1)
            int r2 = r2.getLineEnd(r6)
            java.lang.String r6 = r8.f17561e     // Catch: java.lang.IndexOutOfBoundsException -> Lc5
            int r6 = r6.length()     // Catch: java.lang.IndexOutOfBoundsException -> Lc5
            int r2 = r2 - r6
            int r2 = r2 - r4
        L6a:
            if (r2 >= r5) goto Lbe
            r4 = 0
            java.lang.String r4 = r0.substring(r4, r2)     // Catch: java.lang.IndexOutOfBoundsException -> Lc5
            java.lang.String r4 = r4.trim()     // Catch: java.lang.IndexOutOfBoundsException -> Lc5
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.IndexOutOfBoundsException -> Lc5
            r6.<init>()     // Catch: java.lang.IndexOutOfBoundsException -> Lc5
            java.lang.StringBuilder r4 = r6.append(r4)     // Catch: java.lang.IndexOutOfBoundsException -> Lc5
            java.lang.String r6 = r8.f17561e     // Catch: java.lang.IndexOutOfBoundsException -> Lc5
            java.lang.StringBuilder r4 = r4.append(r6)     // Catch: java.lang.IndexOutOfBoundsException -> Lc5
            java.lang.StringBuilder r4 = r4.append(r3)     // Catch: java.lang.IndexOutOfBoundsException -> Lc5
            java.lang.String r4 = r4.toString()     // Catch: java.lang.IndexOutOfBoundsException -> Lc5
            android.widget.TextView$BufferType r6 = android.widget.TextView.BufferType.SPANNABLE     // Catch: java.lang.IndexOutOfBoundsException -> Lc5
            r8.setText(r4, r6)     // Catch: java.lang.IndexOutOfBoundsException -> Lc5
            int r4 = r8.getLineCount()     // Catch: java.lang.IndexOutOfBoundsException -> Lc5
            if (r4 <= r1) goto Lc2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.IndexOutOfBoundsException -> Lc5
            r1.<init>()     // Catch: java.lang.IndexOutOfBoundsException -> Lc5
            r4 = 0
            int r2 = r2 + (-1)
            java.lang.String r2 = r0.substring(r4, r2)     // Catch: java.lang.IndexOutOfBoundsException -> Lc5
            java.lang.String r2 = r2.trim()     // Catch: java.lang.IndexOutOfBoundsException -> Lc5
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.IndexOutOfBoundsException -> Lc5
            java.lang.String r2 = r8.f17561e     // Catch: java.lang.IndexOutOfBoundsException -> Lc5
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.IndexOutOfBoundsException -> Lc5
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.IndexOutOfBoundsException -> Lc5
            java.lang.String r1 = r1.toString()     // Catch: java.lang.IndexOutOfBoundsException -> Lc5
            android.widget.TextView$BufferType r2 = android.widget.TextView.BufferType.SPANNABLE     // Catch: java.lang.IndexOutOfBoundsException -> Lc5
            r8.setText(r1, r2)     // Catch: java.lang.IndexOutOfBoundsException -> Lc5
        Lbe:
            super.onDraw(r9)
            return
        Lc2:
            int r2 = r2 + 1
            goto L6a
        Lc5:
            r1 = move-exception
            java.lang.Class r2 = r8.getClass()
            java.lang.String r2 = r2.getSimpleName()
            com.sec.chaton.util.C4904y.m18635a(r1, r2)
            android.widget.TextView$BufferType r1 = android.widget.TextView.BufferType.SPANNABLE
            r8.setText(r0, r1)
            goto Lbe
        Ld7:
            r1 = r2
            goto L4e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.EllipsisTextView.onDraw(android.graphics.Canvas):void");
    }
}
