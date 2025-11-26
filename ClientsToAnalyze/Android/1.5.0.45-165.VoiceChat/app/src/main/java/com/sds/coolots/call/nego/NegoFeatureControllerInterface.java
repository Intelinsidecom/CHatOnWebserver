package com.sds.coolots.call.nego;

import com.sds.coolots.call.model.Destination;
import java.util.List;

/* loaded from: classes.dex */
public interface NegoFeatureControllerInterface {
    boolean isConfHandwritingInDocView();

    boolean isConfHandwritingInShareScreen();

    boolean isConfShareCamera();

    boolean isConfShareDocView();

    boolean isConfShareRemoteControl();

    boolean isConfShareScreen();

    boolean isConfTranslation();

    boolean isConfVideoToVoiceCallSwitching();

    boolean isConfVoiceToVideoCallSwitching();

    boolean isP2pHandwritingInDocView();

    boolean isP2pHandwritingInShareScreen();

    boolean isP2pShareCamera();

    boolean isP2pShareDocView();

    boolean isP2pShareRemoteControl();

    boolean isP2pShareScreen();

    boolean isP2pTranslation();

    boolean isP2pVideoToVoiceCallSwitching();

    boolean isP2pVoiceToVideoCallSwitching();

    void printResultOnLog();

    void setConfHandwritingInDocView(boolean z);

    void setConfHandwritingInShareScreen(boolean z);

    void setConfShareCamera(boolean z);

    void setConfShareDocView(boolean z);

    void setConfShareRemoteControl(boolean z);

    void setConfShareScreen(boolean z);

    void setConfTranslation(boolean z);

    void setConfVideoToVoiceCallSwitching(boolean z);

    void setConfVoiceToVideoCallSwitching(boolean z);

    void setP2pHandwritingInDocView(boolean z);

    void setP2pHandwritingInShareScreen(boolean z);

    void setP2pShareCamera(boolean z);

    void setP2pShareDocView(boolean z);

    void setP2pShareRemoteControl(boolean z);

    void setP2pShareScreen(boolean z);

    void setP2pTranslation(boolean z);

    void setP2pVideoToVoiceCallSwitching(boolean z);

    void setP2pVoiceToVideoCallSwitching(boolean z);

    void setResult(List list);

    void updateDestination(Destination destination);
}
