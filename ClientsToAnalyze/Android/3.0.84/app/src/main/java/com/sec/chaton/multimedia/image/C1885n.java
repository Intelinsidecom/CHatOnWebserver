package com.sec.chaton.multimedia.image;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p027e.C1454v;
import com.sec.chaton.p027e.EnumC1455w;

/* compiled from: ImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.n */
/* loaded from: classes.dex */
class C1885n extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ImagePagerActivity f7168a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1885n(ImagePagerActivity imagePagerActivity, Handler handler) {
        super(handler);
        this.f7168a = imagePagerActivity;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f7168a.f6914h.startQuery(2, null, C1454v.f5393a, null, "message_inbox_no=? AND ( message_content_type=? OR message_content_type=? OR message_content_type=? ) AND message_is_truncated = 'N'", new String[]{this.f7168a.f6911e, String.valueOf(EnumC1455w.AMS.m6364a()), String.valueOf(EnumC1455w.VIDEO.m6364a()), String.valueOf(EnumC1455w.IMAGE.m6364a())}, "message_is_failed , message_time , _id");
        super.onChange(z);
    }
}
