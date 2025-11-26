package com.sds.coolots.call;

import com.coolots.p2pmsg.model.ConferenceInfo;
import com.sds.coolots.call.model.Destination;
import java.util.Date;

/* loaded from: classes.dex */
public interface BlockCallHandler {
    void denyConference(String str, int i);

    void handleBlockedCall(Destination destination, int i, boolean z, boolean z2, boolean z3, String str, Date date);

    void handleBlockedConference(Destination destination, ConferenceInfo conferenceInfo, Date date);

    int startIncomingCall(Destination destination, short s, int i, boolean z, boolean z2, boolean z3, boolean z4, String str, Date date);

    int startIncomingConference(Destination destination, ConferenceInfo conferenceInfo, Date date, String str, String str2);
}
