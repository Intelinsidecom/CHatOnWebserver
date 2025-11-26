package com.sds.coolots.call.consent.handler;

import com.coolots.p2pmsg.model.NotifyConsentAsk;
import com.coolots.p2pmsg.model.ProposeConsentAsk;
import com.coolots.p2pmsg.model.ProposeConsentRep;
import com.coolots.p2pmsg.model.RequestConsentAsk;
import com.coolots.p2pmsg.model.RequestConsentRep;
import com.sds.coolots.call.model.Destination;

/* loaded from: classes.dex */
public interface CallConsentInterface {
    public static final String CONFERENCETYPE_SEMINAR_SHARECAMERA = "S";
    public static final String CONFERENCETYPE_VIDEO = "V";
    public static final String CONFERENCETYPE_VOICE = "A";
    public static final int REJECT_BY_DUPLICATED_REQUEST = 1;
    public static final int REJECT_BY_TIMEOUT = 2;
    public static final int REJECT_BY_USER = 0;

    boolean acceptConsent();

    int getConsentType();

    void handleNotifyConsentAsk(NotifyConsentAsk notifyConsentAsk);

    void handleProposeConsentAsk(ProposeConsentAsk proposeConsentAsk);

    void handleProposeConsentRep(ProposeConsentRep proposeConsentRep);

    void handleRequestConsentAsk(RequestConsentAsk requestConsentAsk);

    void handleRequestConsentRep(RequestConsentRep requestConsentRep);

    void processTimeoutResult(boolean z, boolean z2, int i, int i2);

    boolean rejectConsent(int i);

    boolean requestConsent();

    void updateDestination(Destination destination);
}
