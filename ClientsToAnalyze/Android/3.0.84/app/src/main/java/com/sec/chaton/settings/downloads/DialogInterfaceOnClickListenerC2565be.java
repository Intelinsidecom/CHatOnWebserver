package com.sec.chaton.settings.downloads;

import android.content.DialogInterface;
import com.sec.chaton.p035io.entry.inner.FontFilter;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;

/* compiled from: FontDownloads.java */
/* renamed from: com.sec.chaton.settings.downloads.be */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2565be implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FontDownloads f9744a;

    DialogInterfaceOnClickListenerC2565be(FontDownloads fontDownloads) {
        this.f9744a = fontDownloads;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        FontFilter fontFilter;
        if (C3250y.f11734b) {
            C3250y.m11450b("download_font : clicked. choice filter : " + i, FontDownloads.f9522b);
        }
        if (i <= 0) {
            C3159aa.m10962a().m10984b("setting_used_font_filter_id", (Integer) (-1));
            fontFilter = null;
        } else {
            fontFilter = this.f9744a.f9523a.get(i - 1);
            C3159aa.m10962a().m10984b("setting_used_font_filter_id", fontFilter.f5644id);
        }
        this.f9744a.getLoaderManager().destroyLoader(-1);
        this.f9744a.getLoaderManager().restartLoader(-1, null, this.f9744a);
        dialogInterface.dismiss();
        if (C3250y.f11734b) {
            Object[] objArr = new Object[2];
            objArr[0] = fontFilter == null ? "(all selected)" : fontFilter.f5644id;
            objArr[1] = fontFilter == null ? "(all selected)" : fontFilter.title;
            C3250y.m11450b(String.format("download_font, showSelectFilterPopup(), dismiss. restartLoader()\n - selected filter id :  %s\n - selected fileter title : %s", objArr), FontDownloads.f9522b);
        }
    }
}
