package com.nuance.nmsp.client.sdk.components.resource.internal.nmas;

import com.coolots.chaton.common.coolotsinterface.ChatONNativeCallLog;
import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;
import com.nuance.nmsp.client.sdk.components.resource.nmas.NMASResource;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.sec.chaton.clientapi.GraphAPI;

/* loaded from: classes.dex */
public class PDXQueryParameter extends PDXMessage {

    /* renamed from: a */
    private static final LogFactory.Log f178a = LogFactory.getLog(PDXQueryParameter.class);

    public PDXQueryParameter(PDXParam pDXParam) {
        super((short) 515);
        if (f178a.isDebugEnabled()) {
            f178a.debug("PDXQueryParameter()");
        }
        put(GraphAPI.ME_NAME, pDXParam.getName(), NMASResource.PDX_DATA_TYPE_UTF8);
        if (pDXParam.getType() == 127) {
            put(ChatONNativeCallLog.CHATON_CALLLOG_TYPE, 5, NMASResource.PDX_DATA_TYPE_INT);
        } else {
            put(ChatONNativeCallLog.CHATON_CALLLOG_TYPE, pDXParam.getType(), NMASResource.PDX_DATA_TYPE_INT);
        }
        switch (pDXParam.getType()) {
            case 1:
                put("buffer_id", ((PDXAudioParam) pDXParam).getBufferId(), NMASResource.PDX_DATA_TYPE_INT);
                break;
            case 2:
                put("text", ((PDXTextParam) pDXParam).getText(), NMASResource.PDX_DATA_TYPE_UTF8);
                break;
            case 3:
                put("text", ((PDXChoiceParam) pDXParam).getChoicename(), NMASResource.PDX_DATA_TYPE_UTF8);
                break;
            case 4:
                put(SlookAirButtonFrequentContactAdapter.DATA, ((PDXDataParam) pDXParam).getData(), NMASResource.PDX_DATA_TYPE_UTF8);
                break;
            case 5:
                put("dict", ((PDXDictParam) pDXParam).getContent(), NMASResource.PDX_DATA_TYPE_DICT);
                break;
            case 6:
            case 7:
            case 8:
                put("dict", ((PDXSeqParam) pDXParam).getContent(), NMASResource.PDX_DATA_TYPE_DICT);
                break;
            case 127:
                put("dict", ((PDXTTSParam) pDXParam).getContent(), NMASResource.PDX_DATA_TYPE_DICT);
                break;
            default:
                f178a.error("PDXQueryParameter() Unknown parameter type: " + ((int) pDXParam.getType()) + ". ");
                break;
        }
    }
}
