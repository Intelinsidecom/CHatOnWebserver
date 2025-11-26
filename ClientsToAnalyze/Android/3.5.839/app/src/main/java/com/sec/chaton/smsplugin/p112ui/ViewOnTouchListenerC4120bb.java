package com.sec.chaton.smsplugin.p112ui;

import android.graphics.Rect;
import android.os.Message;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.util.C4904y;

/* compiled from: MessageListItem.java */
/* renamed from: com.sec.chaton.smsplugin.ui.bb */
/* loaded from: classes.dex */
class ViewOnTouchListenerC4120bb implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ MessageListItem f15359a;

    ViewOnTouchListenerC4120bb(MessageListItem messageListItem) {
        this.f15359a = messageListItem;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        CharSequence text;
        int iMeasureText;
        int i;
        URLSpan[] uRLSpanArr;
        int action = motionEvent.getAction();
        TextView textView = (TextView) view;
        CharSequence text2 = textView.getText();
        if (!(text2 instanceof Spannable)) {
            return false;
        }
        Spannable spannable = (Spannable) text2;
        if (action == 0 || action == 2) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int scrollX = x + (textView.getScrollX() - textView.getTotalPaddingLeft());
            int scrollY = y + (textView.getScrollY() - textView.getTotalPaddingTop());
            Layout layout = textView.getLayout();
            if (layout == null) {
                return false;
            }
            int lineForVertical = layout.getLineForVertical(scrollY);
            int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, scrollX);
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            if (clickableSpanArr != null && clickableSpanArr.length > 0) {
                TextPaint paint = textView.getPaint();
                int lineStart = layout.getLineStart(lineForVertical);
                int lineEnd = layout.getLineEnd(lineForVertical);
                int spanStart = spannable.getSpanStart(clickableSpanArr[0]);
                int spanEnd = spannable.getSpanEnd(clickableSpanArr[0]);
                int i2 = lineStart < 0 ? 0 : lineStart;
                int i3 = lineEnd < 0 ? 0 : lineEnd;
                try {
                    text = spannable.subSequence(i2, i3);
                } catch (StringIndexOutOfBoundsException e) {
                    C3890m.m14996b("MessageListItem", "StringIndexOutOfBoundsException!! lineStart= " + i2 + ", lineEnd= " + i3 + ", spanStart= " + spanStart + ", spanEnd= " + spanEnd);
                    text = layout.getText();
                }
                CharSequence charSequenceSubSequence = spannable.subSequence(spanStart, spanEnd);
                Rect rect = new Rect();
                layout.getLineBounds(lineForVertical, rect);
                if (C4149cd.m16417a(text2)) {
                    try {
                        int i4 = rect.right;
                        int iMeasureText2 = i4 - ((int) paint.measureText(text.toString()));
                        if (spanStart >= i2) {
                            if (lineForVertical > 0) {
                                if (spanEnd > i3) {
                                    iMeasureText = (int) paint.measureText(text.subSequence(i2, spanStart).toString());
                                    i = iMeasureText2;
                                } else if (layout.getParagraphDirection(lineForVertical) == -1) {
                                    iMeasureText = (int) paint.measureText(text.subSequence(spanEnd - i2, i3 - i2).toString());
                                    i = iMeasureText2;
                                } else {
                                    iMeasureText = (int) paint.measureText(text.subSequence(0, spanStart - i2).toString());
                                    i = 0;
                                }
                            } else if (spanEnd > i3) {
                                iMeasureText = i4 - ((int) paint.measureText(text.subSequence(0, i3).toString()));
                                i = iMeasureText2;
                            } else {
                                iMeasureText = (int) paint.measureText(text.subSequence(spanEnd, i3).toString());
                                i = iMeasureText2;
                            }
                            rect.left = iMeasureText + i;
                            rect.right = rect.left + ((int) paint.measureText(charSequenceSubSequence.toString()));
                        } else {
                            rect.left = ((int) paint.measureText(text.subSequence(spanEnd - i2, i3 - i2).toString())) + iMeasureText2;
                            rect.right = rect.left + ((int) paint.measureText(charSequenceSubSequence.toString()));
                        }
                    } catch (StringIndexOutOfBoundsException e2) {
                    }
                } else if (spanStart >= i2) {
                    rect.left += (int) paint.measureText(text.subSequence(0, spanStart - i2).toString());
                    rect.right = rect.left + ((int) paint.measureText(charSequenceSubSequence.toString()));
                } else {
                    rect.right = rect.left + ((int) paint.measureText(charSequenceSubSequence.subSequence(i2 - spanStart, spanEnd - spanStart).toString()));
                }
                if (rect.contains(scrollX, scrollY) && (uRLSpanArr = (URLSpan[]) ((Spanned) charSequenceSubSequence).getSpans(0, charSequenceSubSequence.length(), URLSpan.class)) != null && uRLSpanArr.length > 0) {
                    if (action == 0) {
                        this.f15359a.f14811M = charSequenceSubSequence.toString();
                        this.f15359a.f14810L = uRLSpanArr[0].getURL();
                        spannable.setSpan(this.f15359a.f14812N, spanStart, spanEnd, 0);
                        this.f15359a.f14823ad.removeMessages(1000);
                        this.f15359a.f14823ad.sendEmptyMessageAtTime(1000, motionEvent.getDownTime() + MessageListItem.f14798ac + MessageListItem.f14797ab);
                        this.f15359a.f14821a.playSoundEffect(0);
                    }
                    return true;
                }
            }
        } else if (action == 1) {
            if (this.f15359a.f14841s == null && C4904y.f17873c) {
                C4904y.m18641c("Handler null on MessageListItem", "MessageListItem");
            }
            if (!TextUtils.isEmpty(this.f15359a.f14810L) && this.f15359a.f14841s != null) {
                Message.obtain(this.f15359a.f14841s, 3, new String[]{this.f15359a.f14810L, this.f15359a.f14811M}).sendToTarget();
            }
        }
        this.f15359a.f14823ad.removeMessages(1000);
        this.f15359a.f14810L = "";
        spannable.removeSpan(this.f15359a.f14812N);
        return false;
    }
}
