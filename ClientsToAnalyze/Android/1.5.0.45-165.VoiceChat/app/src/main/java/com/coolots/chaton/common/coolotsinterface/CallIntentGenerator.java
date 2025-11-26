package com.coolots.chaton.common.coolotsinterface;

import android.content.Intent;
import com.coolots.chaton.CoolotsChatOn;
import com.coolots.chaton.call.view.LiveScreenShareActivity;
import com.coolots.chaton.call.view.LiveShareViewActivity;
import com.coolots.chaton.call.view.VideoCallActivity;
import com.coolots.chaton.call.view.VoiceCallActivity;
import com.sds.coolots.common.coolotsinterface.CallIntentGeneratorInterface;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class CallIntentGenerator implements CallIntentGeneratorInterface {
    private static final String CLASSNAME = "[CallIntentGenerator]";

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    @Override // com.sds.coolots.common.coolotsinterface.CallIntentGeneratorInterface
    public Intent getCallIntent(boolean useVideo, boolean isLiveShare, boolean isSIPCall) {
        logI("getCallIntent(" + useVideo + ")");
        if (useVideo) {
            if (isLiveShare) {
                Intent intent = new Intent(CoolotsChatOn.mContext, (Class<?>) LiveShareViewActivity.class);
                return intent;
            }
            Intent intent2 = new Intent(CoolotsChatOn.mContext, (Class<?>) VideoCallActivity.class);
            return intent2;
        }
        if (isLiveShare) {
            Intent intent3 = new Intent(CoolotsChatOn.mContext, (Class<?>) LiveScreenShareActivity.class);
            return intent3;
        }
        Intent intent4 = new Intent(CoolotsChatOn.mContext, (Class<?>) VoiceCallActivity.class);
        return intent4;
    }

    @Override // com.sds.coolots.common.coolotsinterface.CallIntentGeneratorInterface
    public String getCallClassName(boolean useVideo, boolean isLiveShare, boolean isSIPCall) {
        if (useVideo) {
            if (isLiveShare) {
                return "com.coolots.chaton.call.view.LiveShareViewActivity";
            }
            return "com.coolots.chaton.call.view.VideoCallActivity";
        }
        if (isLiveShare) {
            return "com.coolots.chaton.call.view.LiveScreenShareActivity";
        }
        return "com.coolots.chaton.call.view.VoiceCallActivity";
    }
}
