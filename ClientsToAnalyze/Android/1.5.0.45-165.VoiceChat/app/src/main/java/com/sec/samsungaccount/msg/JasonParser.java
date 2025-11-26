package com.sec.samsungaccount.msg;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class JasonParser {
    public static final int CREATE_ACCESS_TOKEN = 90003;
    public static final int CREATE_AUTH_CODE = 90002;
    public static final int CREATE_AUTH_TOKEN = 90001;
    public static final int DELETE_ACCESS_TOKEN = 90006;
    public static final int DELETE_USER_AUTH_TOKEN = 90005;
    private static final String TAG_ERROR = "error";
    private static final String TAG_ERROR_CODE = "error_code";
    private static final String TAG_ERROR_DESCRIPTION = "error_description";
    public static final int UPDATE_ACCESS_TOKEN = 90004;
    private static JSONObject mJasonMessage = null;

    public JasonParser(String msg) {
        try {
            mJasonMessage = new JSONObject(msg);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean isErrorMessage() {
        String errorMsg = parseString("error");
        return !errorMsg.isEmpty();
    }

    public String parseError() {
        return parseString("error");
    }

    public String parseErrorCode() {
        return parseString(TAG_ERROR_CODE);
    }

    public String parseErrorDescription() {
        return parseString(TAG_ERROR_DESCRIPTION);
    }

    protected String parseString(String tag) {
        if (mJasonMessage == null) {
            return "";
        }
        try {
            return mJasonMessage.getString(tag);
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    protected int parseInteger(String tag) {
        if (mJasonMessage == null) {
            return 0;
        }
        try {
            return mJasonMessage.getInt(tag);
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
