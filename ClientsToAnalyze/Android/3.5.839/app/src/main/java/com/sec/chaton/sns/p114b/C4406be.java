package com.sec.chaton.sns.p114b;

import com.p137vk.sdk.api.VKError;
import com.p137vk.sdk.api.VKRequest;
import com.p137vk.sdk.api.VKResponse;
import com.p137vk.sdk.api.model.VKUsersArray;

/* compiled from: VKontakteManager.java */
/* renamed from: com.sec.chaton.sns.b.be */
/* loaded from: classes.dex */
class C4406be extends VKRequest.VKRequestListener {

    /* renamed from: a */
    final /* synthetic */ int f15949a;

    /* renamed from: b */
    final /* synthetic */ C4403bb f15950b;

    C4406be(C4403bb c4403bb, int i) {
        this.f15950b = c4403bb;
        this.f15949a = i;
    }

    @Override // com.vk.sdk.api.VKRequest.VKRequestListener
    public void onComplete(VKResponse vKResponse) {
        if (vKResponse.parsedModel instanceof VKUsersArray) {
            VKUsersArray vKUsersArray = (VKUsersArray) vKResponse.parsedModel;
            long[] jArr = new long[vKUsersArray.size()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= vKUsersArray.size()) {
                    this.f15950b.f15943e.mo16563a(this.f15949a, -1, jArr);
                    return;
                } else {
                    jArr[i2] = vKUsersArray.get(i2).f18976id;
                    i = i2 + 1;
                }
            }
        }
    }

    @Override // com.vk.sdk.api.VKRequest.VKRequestListener
    public void onError(VKError vKError) {
        this.f15950b.m16719a(vKError, this.f15949a);
    }
}
