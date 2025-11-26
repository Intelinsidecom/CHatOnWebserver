package com.sec.chaton.util;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;

/* loaded from: classes.dex */
public class EllipsisTextView extends TextView {

    /* renamed from: a */
    private int f3664a;

    /* renamed from: b */
    private int f3665b;

    /* renamed from: c */
    private CharSequence f3666c;

    /* renamed from: d */
    private String f3667d;

    public EllipsisTextView(Context context) {
        super(context);
        this.f3664a = -1;
        this.f3665b = -1;
        this.f3666c = "";
        this.f3667d = "...";
    }

    public EllipsisTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3664a = -1;
        this.f3665b = -1;
        this.f3666c = "";
        this.f3667d = "...";
        m3573a(attributeSet);
    }

    public EllipsisTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3664a = -1;
        this.f3665b = -1;
        this.f3666c = "";
        this.f3667d = "...";
        m3573a(attributeSet);
    }

    /* renamed from: a */
    private void m3573a(AttributeSet attributeSet) {
        for (int i = 0; i < attributeSet.getAttributeCount(); i++) {
            if ("maxLines".equals(attributeSet.getAttributeName(i))) {
                this.f3664a = attributeSet.getAttributeIntValue(i, -1);
            } else if ("lines".equals(attributeSet.getAttributeName(i))) {
                this.f3665b = attributeSet.getAttributeIntValue(i, -1);
            }
        }
    }

    /* renamed from: a */
    public int m3574a() {
        return this.f3664a;
    }

    /* renamed from: b */
    public int m3575b() {
        return this.f3665b;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Layout layout;
        super.onDraw(canvas);
        String str = (String) this.f3666c;
        if (str == null || str.replaceAll(" ", "").replaceAll("\n", "").length() == 0) {
            return;
        }
        int iM3574a = m3574a();
        int iM3575b = m3575b();
        int length = str.length();
        String strSubstring = "";
        if (iM3575b > 1 && length > 4) {
            strSubstring = str.substring(length - 4, length);
        }
        if (iM3575b != -1) {
            iM3574a = iM3575b;
        }
        if (getLineCount() <= iM3574a || iM3574a == -1 || (layout = getLayout()) == null) {
            return;
        }
        for (int lineEnd = (layout.getLineEnd(iM3574a - 1) - this.f3667d.length()) - (iM3575b == 2 ? 4 : 0); lineEnd < length; lineEnd++) {
            setText(str.substring(0, lineEnd).trim() + this.f3667d + strSubstring, TextView.BufferType.SPANNABLE);
            if (getLineCount() > iM3574a) {
                setText(str.substring(0, lineEnd - 1).trim() + this.f3667d + strSubstring, TextView.BufferType.SPANNABLE);
                return;
            }
        }
    }

    public void setEllipsisText(String str) {
        if (str != null) {
            this.f3667d = str;
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        super.setLines(i);
        this.f3665b = i;
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.f3664a = i;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        if (bufferType != TextView.BufferType.SPANNABLE) {
            this.f3666c = charSequence;
        }
    }
}
