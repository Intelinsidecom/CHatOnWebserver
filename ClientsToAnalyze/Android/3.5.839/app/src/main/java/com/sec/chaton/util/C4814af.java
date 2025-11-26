package com.sec.chaton.util;

import android.graphics.Bitmap;
import com.sec.common.util.AbstractC5016a;
import java.util.concurrent.ExecutorService;

/* compiled from: ChatOnGraphics.java */
/* renamed from: com.sec.chaton.util.af */
/* loaded from: classes.dex */
public class C4814af extends AbstractC5016a<InterfaceC4837bb, Void, Void> {

    /* renamed from: a */
    String f17578a;

    /* renamed from: b */
    C4831aw f17579b;

    public C4814af(String str, ExecutorService executorService) {
        super(executorService);
        this.f17578a = str;
    }

    @Override // com.sec.common.util.AbstractC5016a
    /* renamed from: a */
    protected void mo6107a() {
        this.f17579b = C4831aw.m18293a();
        super.mo6107a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.common.util.AbstractC5016a
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Void mo6106a(InterfaceC4837bb... interfaceC4837bbArr) {
        InterfaceC4837bb interfaceC4837bb = interfaceC4837bbArr[0];
        String strM18357e = C4855bt.m18357e(this.f17578a);
        C4904y.m18646e("[getBigProfile] : " + strM18357e, C4812ad.f17576a);
        this.f17579b.m18299a(this.f17578a, strM18357e, "//profile", String.format("%s_big.jpeg_", this.f17578a), Bitmap.CompressFormat.JPEG, interfaceC4837bb);
        return null;
    }
}
