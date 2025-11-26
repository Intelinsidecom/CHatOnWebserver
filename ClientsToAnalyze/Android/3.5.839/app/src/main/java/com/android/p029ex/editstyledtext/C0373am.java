package com.android.p029ex.editstyledtext;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.ArrowKeyMovementMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: EditStyledText.java */
/* renamed from: com.android.ex.editstyledtext.am */
/* loaded from: classes.dex */
class C0373am extends ArrowKeyMovementMethod {

    /* renamed from: a */
    C0371ak f913a;

    /* renamed from: b */
    String f914b = "StyledTextArrowKeyMethod";

    C0373am(C0371ak c0371ak) {
        this.f913a = c0371ak;
    }

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onKeyDown(TextView textView, Spannable spannable, int i, KeyEvent keyEvent) {
        Log.d(this.f914b, "---onkeydown:" + i);
        this.f913a.m1404h();
        return (this.f913a.m1411o() == 1 || this.f913a.m1411o() == 2) ? m1422a(textView, spannable, i) : super.onKeyDown(textView, spannable, i, keyEvent);
    }

    /* renamed from: a */
    private int m1421a(TextView textView) {
        if (textView.getSelectionStart() == this.f913a.m1412p()) {
            return textView.getSelectionEnd();
        }
        return textView.getSelectionStart();
    }

    @Override // android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod
    protected boolean up(TextView textView, Spannable spannable) {
        int lineStart;
        Log.d(this.f914b, "--- up:");
        Layout layout = textView.getLayout();
        int iM1421a = m1421a(textView);
        int lineForOffset = layout.getLineForOffset(iM1421a);
        if (lineForOffset > 0) {
            if (layout.getParagraphDirection(lineForOffset) == layout.getParagraphDirection(lineForOffset - 1)) {
                lineStart = layout.getOffsetForHorizontal(lineForOffset - 1, layout.getPrimaryHorizontal(iM1421a));
            } else {
                lineStart = layout.getLineStart(lineForOffset - 1);
            }
            this.f913a.m1400d(lineStart);
            this.f913a.m1383a();
            return true;
        }
        return true;
    }

    @Override // android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod
    protected boolean down(TextView textView, Spannable spannable) {
        int lineStart;
        Log.d(this.f914b, "--- down:");
        Layout layout = textView.getLayout();
        int iM1421a = m1421a(textView);
        int lineForOffset = layout.getLineForOffset(iM1421a);
        if (lineForOffset < layout.getLineCount() - 1) {
            if (layout.getParagraphDirection(lineForOffset) == layout.getParagraphDirection(lineForOffset + 1)) {
                lineStart = layout.getOffsetForHorizontal(lineForOffset + 1, layout.getPrimaryHorizontal(iM1421a));
            } else {
                lineStart = layout.getLineStart(lineForOffset + 1);
            }
            this.f913a.m1400d(lineStart);
            this.f913a.m1383a();
            return true;
        }
        return true;
    }

    @Override // android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod
    protected boolean left(TextView textView, Spannable spannable) {
        Log.d(this.f914b, "--- left:");
        this.f913a.m1400d(textView.getLayout().getOffsetToLeftOf(m1421a(textView)));
        this.f913a.m1383a();
        return true;
    }

    @Override // android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod
    protected boolean right(TextView textView, Spannable spannable) {
        Log.d(this.f914b, "--- right:");
        this.f913a.m1400d(textView.getLayout().getOffsetToRightOf(m1421a(textView)));
        this.f913a.m1383a();
        return true;
    }

    /* renamed from: a */
    private boolean m1422a(TextView textView, Spannable spannable, int i) {
        Log.d(this.f914b, "--- executeDown: " + i);
        switch (i) {
            case 19:
                return false | up(textView, spannable);
            case 20:
                return false | down(textView, spannable);
            case 21:
                return false | left(textView, spannable);
            case 22:
                return false | right(textView, spannable);
            case 23:
                this.f913a.m1390b();
                return true;
            default:
                return false;
        }
    }
}
