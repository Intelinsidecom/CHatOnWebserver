package com.coolots.p2pmsg.model;

import com.coolots.chaton.call.screenshare.util.ScreenSharePacket;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class DeviceConfigInfo {
    public static final String CONFERENCE_MEMBER_AUDIO_MAX = "conference.member.audio.max";
    public static final String CONFERENCE_MEMBER_VIDEO_MAX = "conference.member.video.max";

    @NotNull
    @Size(max = 30, min = 1)
    private String ConfigKey;

    @Size(max = ScreenSharePacket.SCREEN_SHARE_CMD_SETTING_MATRIXINFO, min = 0)
    private String ConfigValue;

    public String getConfigKey() {
        return this.ConfigKey;
    }

    public void setConfigKey(String configKey) {
        this.ConfigKey = configKey;
    }

    public String getConfigValue() {
        return this.ConfigValue;
    }

    public void setConfigValue(String configValue) {
        this.ConfigValue = configValue;
    }
}
