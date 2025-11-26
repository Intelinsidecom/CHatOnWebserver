package com.nuance.nmsp.client.sdk.components.resource.internal.nmas;

import com.nuance.nmsp.client.sdk.common.protocols.ProtocolDefines;
import com.nuance.nmsp.client.sdk.components.resource.nmas.NMASResource;

/* loaded from: classes.dex */
public class PDXEnrollmentSegment extends PDXMessage {
    public PDXEnrollmentSegment(String str, String str2) {
        super(ProtocolDefines.XMODE_VAP_COMMAND_PLAY_END);
        put("text", str, NMASResource.PDX_DATA_TYPE_UTF8);
        put("buffer_id", str2, NMASResource.PDX_DATA_TYPE_UTF8);
    }
}
