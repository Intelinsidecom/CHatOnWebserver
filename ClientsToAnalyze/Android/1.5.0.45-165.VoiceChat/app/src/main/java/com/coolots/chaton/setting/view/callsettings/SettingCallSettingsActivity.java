package com.coolots.chaton.setting.view.callsettings;

import android.os.Bundle;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.setting.view.ChatONSettingTitleTabActivity;
import com.coolots.chaton.setting.view.ringtone.RadioButtonRingtoneListDialog;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class SettingCallSettingsActivity extends ChatONSettingTitleTabActivity implements DisposeInterface {
    @Override // com.coolots.chaton.setting.view.ChatONSettingTitleTabActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActionBarTitle(C0000R.string.preference_3_title);
        setFragment(new SettingCallSettingsFragment());
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() throws IllegalStateException {
        super.onUserLeaveHint();
        RadioButtonRingtoneListDialog.mPlayer.stop();
    }
}
