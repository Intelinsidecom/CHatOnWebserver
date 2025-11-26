package com.sec.chaton.multimedia.image;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p027e.C1385ac;
import com.sec.chaton.p027e.C1458z;

/* compiled from: PostONImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.ae */
/* loaded from: classes.dex */
class C1854ae extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ PostONImagePagerActivity f7082a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1854ae(PostONImagePagerActivity postONImagePagerActivity, Handler handler) {
        super(handler);
        this.f7082a = postONImagePagerActivity;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.f7082a.f6975f.equals(this.f7082a.f6976g)) {
            this.f7082a.f6965B.startQuery(this.f7082a.f6972a, null, C1385ac.f5181b, new String[]{"buddy_no"}, null, null, null);
        } else {
            this.f7082a.f6965B.startQuery(this.f7082a.f6972a, null, C1458z.f5417b, new String[]{"buddy_no"}, null, null, null);
        }
    }
}
