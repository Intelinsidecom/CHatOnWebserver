package com.p137vk.sdk.api;

import android.net.Uri;
import com.p137vk.sdk.util.VKJsonHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class VKError implements Serializable {
    public static final int VK_API_CANCELED = -102;
    public static final int VK_API_ERROR = -101;
    public static final int VK_API_JSON_FAILED = -104;
    public static final int VK_API_REQUEST_HTTP_FAILED = -105;
    public static final int VK_API_REQUEST_NOT_PREPARED = -103;
    private static final long serialVersionUID = -2244555883847360546L;
    public VKError apiError;
    public String captchaImg;
    public String captchaSid;
    public int errorCode;
    public String errorMessage;
    public String errorReason;
    public Exception httpError;
    public String redirectUri;
    public VKRequest request;
    public ArrayList<Map<String, String>> requestParams;

    public VKError(int i) {
        this.errorCode = i;
    }

    public VKError(JSONObject jSONObject) {
        VKError vKError = new VKError(jSONObject.getInt(VKApiConst.ERROR_CODE));
        vKError.errorMessage = jSONObject.getString(VKApiConst.ERROR_MSG);
        vKError.requestParams = (ArrayList) VKJsonHelper.toList(jSONObject.getJSONArray(VKApiConst.REQUEST_PARAMS));
        if (vKError.errorCode == 14) {
            vKError.captchaImg = jSONObject.getString(VKApiConst.CAPTCHA_IMG);
            vKError.captchaSid = jSONObject.getString(VKApiConst.CAPTCHA_SID);
        }
        this.errorCode = VK_API_ERROR;
        this.apiError = vKError;
    }

    public VKError(Map<String, String> map) {
        this.errorCode = VK_API_ERROR;
        this.errorReason = map.get("error_reason");
        this.errorMessage = Uri.decode(map.get("error_description"));
    }

    public void answerCaptcha(String str) {
        VKParameters vKParameters = new VKParameters();
        vKParameters.put(VKApiConst.CAPTCHA_SID, this.captchaSid);
        vKParameters.put(VKApiConst.CAPTCHA_KEY, str);
        this.request.addExtraParameters(vKParameters);
        this.request.repeat();
    }
}
