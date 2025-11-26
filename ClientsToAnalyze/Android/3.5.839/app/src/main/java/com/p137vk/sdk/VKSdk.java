package com.p137vk.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.p137vk.sdk.api.VKError;
import com.p137vk.sdk.util.VKStringJoiner;
import com.p137vk.sdk.util.VKUtil;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class VKSdk {
    private static final String VK_APP_AUTH_ACTION = "com.vkontakte.android.action.SDK_AUTH";
    private static final String VK_APP_FINGERPRINT = "48761EEF50EE53AFC4CC9C5F10E6BDE7F8F5B82F";
    private static final String VK_APP_PACKAGE_ID = "com.vkontakte.android";
    public static final int VK_SDK_REQUEST_CODE = 61992;
    private static VKSdk sInstance;
    private VKAccessToken mAccessToken;
    private String mCurrentAppId;
    private VKSdkListener mListener;

    private VKSdk() {
    }

    Context getContext() {
        return VKUIHelper.getTopActivity();
    }

    private static void checkConditions() {
        if (sInstance == null) {
            throw new NullPointerException("VK Sdk not yet initialized");
        }
        if (sInstance.getContext() == null) {
            throw new NullPointerException("Context must not be null");
        }
    }

    public static VKSdk instance() {
        return sInstance;
    }

    public static void initialize(VKSdkListener vKSdkListener, String str) {
        if (vKSdkListener == null) {
            throw new NullPointerException("VK SDK listener cannot be null");
        }
        if (str == null) {
            throw new NullPointerException("Application ID cannot be null");
        }
        if (sInstance == null) {
            sInstance = new VKSdk();
        }
        sInstance.mListener = vKSdkListener;
        sInstance.mCurrentAppId = str;
    }

    public static void initialize(VKSdkListener vKSdkListener, String str, VKAccessToken vKAccessToken) {
        initialize(vKSdkListener, str);
        sInstance.mAccessToken = vKAccessToken;
        if (vKAccessToken != null && !vKAccessToken.isExpired() && vKAccessToken.accessToken != null) {
            vKSdkListener.onAcceptUserToken(vKAccessToken);
        }
    }

    public static void authorize(String... strArr) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException {
        authorize(strArr, false, false);
    }

    public static void authorize(String[] strArr, boolean z, boolean z2) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException {
        Intent intent;
        try {
            checkConditions();
            if (strArr == null) {
                strArr = new String[0];
            }
            String[] certificateFingerprint = VKUtil.getCertificateFingerprint(sInstance.getContext(), VK_APP_PACKAGE_ID);
            if (!z2 && VKUtil.isAppInstalled(sInstance.getContext(), VK_APP_PACKAGE_ID) && certificateFingerprint[0].equals(VK_APP_FINGERPRINT)) {
                intent = new Intent(VK_APP_AUTH_ACTION, (Uri) null);
            } else {
                intent = new Intent(sInstance.getContext(), (Class<?>) VKOpenAuthActivity.class);
            }
            intent.putExtra(VKOpenAuthActivity.VK_EXTRA_API_VERSION, VKSdkVersion.API_VERSION);
            intent.putExtra(VKOpenAuthActivity.VK_EXTRA_CLIENT_ID, Integer.parseInt(sInstance.mCurrentAppId));
            if (z) {
                intent.putExtra(VKOpenAuthActivity.VK_EXTRA_REVOKE, true);
            }
            intent.putExtra(VKOpenAuthActivity.VK_EXTRA_SCOPE, VKStringJoiner.join(strArr, ","));
            if (VKUIHelper.getTopActivity() != null) {
                VKUIHelper.getTopActivity().startActivityForResult(intent, VK_SDK_REQUEST_CODE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public VKSdkListener sdkListener() {
        return sInstance.mListener;
    }

    public void setSdkListener(VKSdkListener vKSdkListener) {
        sInstance.mListener = vKSdkListener;
    }

    public static boolean processActivityResult(int i, Intent intent) {
        if (intent != null && i == -1) {
            if (VKOpenAuthActivity.VK_RESULT_INTENT_NAME.equals(intent.getAction())) {
                if (intent.hasExtra(VKOpenAuthActivity.VK_EXTRA_TOKEN_DATA)) {
                    checkAndSetToken(VKUtil.explodeQueryString(intent.getStringExtra(VKOpenAuthActivity.VK_EXTRA_TOKEN_DATA)), intent.getBooleanExtra(VKOpenAuthActivity.VK_EXTRA_VALIDATION_URL, false));
                } else if (intent.getExtras() != null) {
                    setAccessTokenError(new VKError(VKError.VK_API_CANCELED));
                }
                return true;
            }
            if (intent.getExtras() != null) {
                HashMap map = new HashMap();
                for (String str : intent.getExtras().keySet()) {
                    map.put(str, String.valueOf(intent.getExtras().get(str)));
                }
                checkAndSetToken(map, false);
            }
        }
        return false;
    }

    private static void checkAndSetToken(Map<String, String> map, boolean z) {
        VKAccessToken vKAccessToken = VKAccessToken.tokenFromParameters(map);
        if (vKAccessToken == null || vKAccessToken.accessToken == null) {
            setAccessTokenError(new VKError(map));
        } else {
            setAccessToken(vKAccessToken, z);
        }
    }

    public static void setAccessToken(VKAccessToken vKAccessToken, boolean z) {
        sInstance.mAccessToken = vKAccessToken;
        if (sInstance.mListener != null) {
            if (!z) {
                sInstance.mListener.onReceiveNewToken(vKAccessToken);
            } else {
                sInstance.mListener.onReceiveNewToken(vKAccessToken);
            }
        }
    }

    public static VKAccessToken getAccessToken() {
        if (sInstance.mAccessToken == null) {
            return null;
        }
        if (sInstance.mAccessToken.isExpired() && sInstance.mListener != null) {
            sInstance.mListener.onTokenExpired(sInstance.mAccessToken);
        }
        return sInstance.mAccessToken;
    }

    public static void setAccessTokenError(VKError vKError) {
        sInstance.mAccessToken = null;
        if (sInstance.mListener != null) {
            sInstance.mListener.onAccessDenied(vKError);
        }
    }
}
