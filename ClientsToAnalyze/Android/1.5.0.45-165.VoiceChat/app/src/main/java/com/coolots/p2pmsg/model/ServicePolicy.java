package com.coolots.p2pmsg.model;

import com.coolots.p2pmsg.validator.StringCase;
import javax.validation.constraints.NotNull;

/* loaded from: classes.dex */
public class ServicePolicy {

    @StringCase(caseArray = {"Y", "N"})
    @NotNull
    private String VideoEnable;

    @StringCase(caseArray = {"Y", "N"})
    @NotNull
    private String VoiceEnable;

    public String getVoiceEnable() {
        return this.VoiceEnable;
    }

    public void setVoiceEnable(String voiceEnable) {
        this.VoiceEnable = voiceEnable;
    }

    public String getVideoEnable() {
        return this.VideoEnable;
    }

    public void setVideoEnable(String videoEnable) {
        this.VideoEnable = videoEnable;
    }
}
