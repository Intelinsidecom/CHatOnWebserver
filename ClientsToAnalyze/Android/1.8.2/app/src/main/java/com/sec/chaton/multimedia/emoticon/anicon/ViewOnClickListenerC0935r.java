package com.sec.chaton.multimedia.emoticon.anicon;

import android.text.TextUtils;
import android.view.View;

/* compiled from: AniconPackageListAdapter.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.r */
/* loaded from: classes.dex */
class ViewOnClickListenerC0935r implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0934q f3492a;

    ViewOnClickListenerC0935r(C0934q c0934q) {
        this.f3492a = c0934q;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C0937t c0937t = (C0937t) view.getTag();
        if (!TextUtils.isEmpty(c0937t.f3494a) && this.f3492a.f3489e != null) {
            this.f3492a.f3489e.mo3763a(c0937t.f3494a);
        }
    }
}
