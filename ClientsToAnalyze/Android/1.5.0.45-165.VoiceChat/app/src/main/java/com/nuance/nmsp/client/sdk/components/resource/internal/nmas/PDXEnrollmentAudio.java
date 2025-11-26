package com.nuance.nmsp.client.sdk.components.resource.internal.nmas;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;

/* loaded from: classes.dex */
public class PDXEnrollmentAudio extends PDXMessage {
    public PDXEnrollmentAudio(byte[] bArr) {
        super((short) 1026);
        put(SlookAirButtonFrequentContactAdapter.DATA, bArr, (short) 4);
    }
}
