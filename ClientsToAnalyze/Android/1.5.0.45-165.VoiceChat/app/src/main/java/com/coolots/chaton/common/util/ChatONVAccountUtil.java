package com.coolots.chaton.common.util;

import android.content.Context;
import com.coolots.chaton.common.view.ConfigActivity;

/* loaded from: classes.dex */
public class ChatONVAccountUtil {
    public static boolean checkCooLotsAccountValidity(Context context) {
        String userID = ConfigActivity.getProfileUserID(context);
        return (userID == null || userID.isEmpty()) ? false : true;
    }
}
