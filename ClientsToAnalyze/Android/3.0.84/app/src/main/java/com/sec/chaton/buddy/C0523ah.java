package com.sec.chaton.buddy;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.ah */
/* loaded from: classes.dex */
class C0523ah extends LruCache<String, Bitmap> {

    /* renamed from: a */
    final /* synthetic */ C0522ag f2464a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0523ah(C0522ag c0522ag, int i) {
        super(i);
        this.f2464a = c0522ag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.util.LruCache
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int sizeOf(String str, Bitmap bitmap) {
        return bitmap.getByteCount();
    }
}
