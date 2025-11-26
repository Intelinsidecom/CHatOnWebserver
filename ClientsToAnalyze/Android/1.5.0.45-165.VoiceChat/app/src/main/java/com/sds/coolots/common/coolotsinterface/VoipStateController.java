package com.sds.coolots.common.coolotsinterface;

import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.Destination;

/* loaded from: classes.dex */
public interface VoipStateController {
    boolean registVoipCallState(Destination destination);

    void resetForRecovery();

    void unregistVoipCallState();

    void updateVoipCallState(boolean z, Destination destination, CallState callState);
}
