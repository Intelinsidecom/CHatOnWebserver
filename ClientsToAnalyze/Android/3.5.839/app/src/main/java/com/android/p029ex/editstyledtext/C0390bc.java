package com.android.p029ex.editstyledtext;

import android.text.Html;
import android.text.Spanned;

/* compiled from: EditStyledText.java */
/* renamed from: com.android.ex.editstyledtext.bc */
/* loaded from: classes.dex */
class C0390bc implements InterfaceC0389bb {

    /* renamed from: a */
    final /* synthetic */ EditStyledText f946a;

    private C0390bc(EditStyledText editStyledText) {
        this.f946a = editStyledText;
    }

    @Override // com.android.p029ex.editstyledtext.InterfaceC0389bb
    /* renamed from: a */
    public Spanned mo1451a(String str, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
        return Html.fromHtml(str, imageGetter, tagHandler);
    }
}
