package com.p137vk.sdk;

import com.p137vk.sdk.api.VKError;

/* loaded from: classes.dex */
public abstract class VKSdkListener {
    public abstract void onAccessDenied(VKError vKError);

    public abstract void onCaptchaError(VKError vKError);

    public abstract void onTokenExpired(VKAccessToken vKAccessToken);

    public void onReceiveNewToken(VKAccessToken vKAccessToken) {
    }

    public void onAcceptUserToken(VKAccessToken vKAccessToken) {
    }

    public void onRenewAccessToken(VKAccessToken vKAccessToken) {
    }
}
