package com.sec.chaton.settings.downloads;

import android.content.DialogInterface;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;

/* compiled from: AniconPackageDownloads.java */
/* renamed from: com.sec.chaton.settings.downloads.ap */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2549ap implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AniconPackageDownloads f9696a;

    DialogInterfaceOnClickListenerC2549ap(AniconPackageDownloads aniconPackageDownloads) {
        this.f9696a = aniconPackageDownloads;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        EnumC2554au enumC2554auM9485a = EnumC2554au.m9485a(i);
        if (C3250y.f11734b) {
            C3250y.m11450b("anicon_list, user clicked : " + enumC2554auM9485a, AniconPackageDownloads.f9479a);
        }
        switch (enumC2554auM9485a) {
            case SORT_BY_TIME:
            case SORT_BY_TITLE:
            case SORT_BY_CHARACTER:
            case SORT_BY_POPULARITY:
                C3159aa.m10962a().m10984b("setting_anicon_sortby", Integer.valueOf(i));
                this.f9696a.getLoaderManager().restartLoader(0, null, this.f9696a);
                break;
        }
        dialogInterface.dismiss();
    }
}
