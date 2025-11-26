package com.sec.chaton.multimedia.emoticon.anicon;

import android.text.TextUtils;
import android.view.View;

/* compiled from: AniconPackageListAdapter.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.s */
/* loaded from: classes.dex */
class ViewOnClickListenerC0936s implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0934q f3493a;

    ViewOnClickListenerC0936s(C0934q c0934q) {
        this.f3493a = c0934q;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = (String) view.getTag();
        if (!TextUtils.isEmpty(str) && this.f3493a.f3489e != null) {
            this.f3493a.f3489e.mo3764b(str);
        }
    }
}
