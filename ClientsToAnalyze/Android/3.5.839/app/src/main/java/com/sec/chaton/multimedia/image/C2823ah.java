package com.sec.chaton.multimedia.image;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p057e.C2221ai;
import com.sec.chaton.p057e.C2224al;

/* compiled from: PostONImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.ah */
/* loaded from: classes.dex */
class C2823ah extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ PostONImagePagerActivity f10393a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2823ah(PostONImagePagerActivity postONImagePagerActivity, Handler handler) {
        super(handler);
        this.f10393a = postONImagePagerActivity;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.f10393a.f10295s.equals(this.f10393a.f10296t)) {
            this.f10393a.f10283P.startQuery(this.f10393a.f10292n, null, C2224al.f7950b, new String[]{"buddy_no"}, null, null, null);
        } else {
            this.f10393a.f10283P.startQuery(this.f10393a.f10292n, null, C2221ai.f7944b, new String[]{"buddy_no"}, null, null, null);
        }
    }
}
