package com.coolots.chaton.common.util;

import android.R;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.common.controller.ChatOnResourceInterface;
import com.sds.coolots.MainApplication;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Resources implements ChatOnResourceInterface {
    public static final int LAYOUT_AUDIO_SETTING = 1000;

    @Override // com.sds.coolots.common.controller.ResourceInterface
    public int getXmlAudioSetting() {
        return C0000R.xml.audio_setting;
    }

    @Override // com.sds.coolots.common.controller.ResourceInterface
    public int getStringCheckExternalStorage() {
        return C0000R.string.check_external_storage;
    }

    @Override // com.sds.coolots.common.controller.ResourceInterface
    public int getStringCalllogUserCount() {
        return C0000R.string.calllog_user_count;
    }

    @Override // com.sds.coolots.common.controller.ResourceInterface
    public int getStringCalllogMissedCall() {
        return C0000R.string.calllog_missed_call;
    }

    @Override // com.sds.coolots.common.controller.ResourceInterface
    public int getStringCalllogDuration() {
        return C0000R.string.calllog_duration;
    }

    @Override // com.sds.coolots.common.controller.ResourceInterface
    public int getStringCalllogMin() {
        return C0000R.string.calllog_min;
    }

    @Override // com.sds.coolots.common.controller.ResourceInterface
    public int getStringCalllogSec() {
        return C0000R.string.calllog_sec;
    }

    @Override // com.sds.coolots.common.controller.ResourceInterface
    public int getRawRingBackTone() {
        return C0000R.raw.ring;
    }

    @Override // com.sds.coolots.common.controller.ResourceInterface
    public int getRawMusicOnHold() {
        return C0000R.raw.music_on_hold;
    }

    @Override // com.sds.coolots.common.controller.ResourceInterface
    public int getDrawableLuncher() {
        return C0000R.drawable.luncher_03;
    }

    @Override // com.sds.coolots.common.controller.ResourceInterface
    public int getXmlNationalCodeList() {
        return C0000R.xml.nationalcodelist;
    }

    @Override // com.sds.coolots.common.controller.ResourceInterface
    public int getXmlEngineeringConfig() {
        return C0000R.xml.engineeringconfig;
    }

    @Override // com.sds.coolots.common.controller.ResourceInterface
    public int getStringLogOut() {
        return C0000R.string.information_str_msg_7;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface
    public int getDrawableSPPAlert() {
        return C0000R.drawable.call_icon_rec;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface
    public int getStringLowBattery() {
        return C0000R.string.information_str_msg_10;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface
    public int getStringLoginToServer() {
        return C0000R.string.information_str_msg_7;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface
    public int getStringRecordStopPopup() {
        return C0000R.string.call_btn_record_stop_popup;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface, com.sds.coolots.common.controller.ResourceInterface
    public int getRawConnected() {
        return C0000R.raw.call_connect;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface, com.sds.coolots.common.controller.ResourceInterface
    public int getRawDisconnected() {
        return C0000R.raw.call_disconnect;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface, com.sds.coolots.common.controller.ResourceInterface
    public int getRawRingtone() {
        return C0000R.raw.ringtone;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface
    public int getCallLogTypeReject() {
        return 0;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface
    public int getCallLogTypeVoiceCall() {
        return 0;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface
    public int getCallLogTypeVideoCall() {
        return 0;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface
    public String getExtraVoipCallstate() {
        return "is_voip_callstate";
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface
    public int getUnknownUserString() {
        return C0000R.string.unknown_user;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface
    public int getHideMeDefaultLandscapeImage() {
        return C0000R.drawable.vt_img_unknown_h;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface
    public int getHideMeDefaultPortraitImage() {
        return C0000R.drawable.vt_hideme_bg_still_01;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface
    public int getMissedCallIcon() {
        return C0000R.drawable.buddies_missed_call;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface, com.sds.coolots.common.controller.ResourceInterface
    public int getMissedCallTicker() {
        return C0000R.string.notification_missedCallTicker;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface, com.sds.coolots.common.controller.ResourceInterface
    public int getMissedCallTitle() {
        return C0000R.string.notification_missedCallTitle;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface, com.sds.coolots.common.controller.ResourceInterface
    public int getMissedCallsMsg() {
        return C0000R.string.notification_missedCallsMsg;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface, com.sds.coolots.common.controller.ResourceInterface
    public int getMissedCallsTitle() {
        return C0000R.string.notification_missedCallsTitle;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface, com.sds.coolots.common.controller.ResourceInterface
    public int getStatNotifyMissedCall() {
        return R.drawable.stat_notify_missed_call;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface
    public int getFavoriteTitle() {
        return C0000R.string.buddy_main_list_favorite_title;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface
    public int getGroupTitle() {
        return C0000R.string.buddy_main_list_group_title;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface
    public int getMeTitle() {
        return C0000R.string.buddy_main_list_me_title;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface
    public int getNewTitle() {
        return C0000R.string.buddy_main_list_new_title;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface
    public int getCallLogTodaySeperator() {
        return C0000R.string.calllog_seperator_1;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface
    public int getCallLogYesterdatSeperator() {
        return C0000R.string.calllog_seperator_2;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface
    public int getCallTypeCancelled() {
        return C0000R.string.calllog_cancelled_call;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface
    public int getCallTypeMissed() {
        return C0000R.string.calllog_missed_call;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface
    public int getCallTypeRejected() {
        return C0000R.string.calllog_rejected_call;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface
    public int getJoinServerAccessErrorString() {
        return C0000R.string.join_server_access_error;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface
    public int getStringChangeToConferenceWait() {
        return C0000R.string.change_to_conference_wait;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface
    public int getStringChangeToP2PWait() {
        return C0000R.string.change_to_p2p_start;
    }

    @Override // com.coolots.chaton.common.controller.ChatOnResourceInterface
    public List<String> getDefaultRejectMsg() {
        List<String> defaultRejectMsgs = new ArrayList<>();
        defaultRejectMsgs.add(MainApplication.mContext.getString(C0000R.string.reject_msg_default1));
        defaultRejectMsgs.add(MainApplication.mContext.getString(C0000R.string.reject_msg_default2));
        defaultRejectMsgs.add(MainApplication.mContext.getString(C0000R.string.reject_msg_default3));
        defaultRejectMsgs.add(MainApplication.mContext.getString(C0000R.string.reject_msg_default4));
        defaultRejectMsgs.add(MainApplication.mContext.getString(C0000R.string.reject_msg_default5));
        return defaultRejectMsgs;
    }

    @Override // com.sds.coolots.common.controller.ResourceInterface
    public int get_reject_msg_default1() {
        return C0000R.string.reject_msg_default1;
    }

    @Override // com.sds.coolots.common.controller.ResourceInterface
    public int get_reject_msg_default2() {
        return C0000R.string.reject_msg_default2;
    }

    @Override // com.sds.coolots.common.controller.ResourceInterface
    public int get_reject_msg_default3() {
        return C0000R.string.reject_msg_default3;
    }

    @Override // com.sds.coolots.common.controller.ResourceInterface
    public int get_reject_msg_default4() {
        return C0000R.string.reject_msg_default4;
    }

    @Override // com.sds.coolots.common.controller.ResourceInterface
    public int get_reject_msg_default5() {
        return C0000R.string.reject_msg_default5;
    }
}
