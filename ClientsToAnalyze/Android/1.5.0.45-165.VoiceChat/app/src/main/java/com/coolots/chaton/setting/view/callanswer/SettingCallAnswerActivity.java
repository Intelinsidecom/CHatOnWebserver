package com.coolots.chaton.setting.view.callanswer;

import android.os.Bundle;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.setting.view.ChatONSettingTitleTabActivity;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class SettingCallAnswerActivity extends ChatONSettingTitleTabActivity implements DisposeInterface {
    private static final String CLASSNAME = "[SettingCallAnswerActivity]";

    private static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    @Override // com.coolots.chaton.setting.view.ChatONSettingTitleTabActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActionBarTitle(C0000R.string.preference_call_answering_ending_title);
        setFragment(new SettingCallAnswerFragment());
    }
}
