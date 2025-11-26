package com.sec.chaton.sns.p114b;

import com.p137vk.sdk.api.VKError;
import com.p137vk.sdk.api.VKRequest;
import com.p137vk.sdk.api.VKResponse;
import com.p137vk.sdk.api.model.VKUser;
import com.p137vk.sdk.api.model.VKUsersArray;
import com.sec.spp.push.dlc.api.DlcApi;

/* compiled from: VKontakteManager.java */
/* renamed from: com.sec.chaton.sns.b.bh */
/* loaded from: classes.dex */
class C4409bh extends VKRequest.VKRequestListener {

    /* renamed from: a */
    final /* synthetic */ C4408bg f15955a;

    C4409bh(C4408bg c4408bg) {
        this.f15955a = c4408bg;
    }

    @Override // com.vk.sdk.api.VKRequest.VKRequestListener
    public void onComplete(VKResponse vKResponse) {
        if (!(vKResponse.parsedModel instanceof VKUsersArray)) {
            this.f15955a.f15953a.f15943e.mo16563a(this.f15955a.f15954b, DlcApi.RC_SVC_NOT_CONNECTED, vKResponse.parsedModel);
            return;
        }
        VKUser vKUser = ((VKUsersArray) vKResponse.parsedModel).get(0);
        this.f15955a.f15953a.f15944f.m16831a(this.f15955a.f15953a.f15942d, vKUser.first_name + " " + vKUser.last_name);
        this.f15955a.f15953a.f15944f.m16835b(this.f15955a.f15953a.f15942d, vKUser.getApproProfileUrl());
        this.f15955a.f15953a.f15943e.mo16563a(this.f15955a.f15954b, -1, vKResponse.parsedModel);
    }

    @Override // com.vk.sdk.api.VKRequest.VKRequestListener
    public void onError(VKError vKError) {
        this.f15955a.f15953a.m16719a(vKError, this.f15955a.f15954b);
    }
}
