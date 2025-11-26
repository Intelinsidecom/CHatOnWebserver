package com.sec.chaton.smsplugin.p112ui;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;

/* compiled from: MessageListItem.java */
/* renamed from: com.sec.chaton.smsplugin.ui.bf */
/* loaded from: classes.dex */
class C4124bf implements LineHeightSpan {

    /* renamed from: a */
    final /* synthetic */ MessageListItem f15363a;

    C4124bf(MessageListItem messageListItem) {
        this.f15363a = messageListItem;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        fontMetricsInt.ascent -= 10;
    }
}
