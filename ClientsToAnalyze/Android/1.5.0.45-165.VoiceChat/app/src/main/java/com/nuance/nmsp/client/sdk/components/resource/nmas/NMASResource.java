package com.nuance.nmsp.client.sdk.components.resource.nmas;

import com.nuance.nmsp.client.sdk.components.general.NMSPAudioSink;
import com.nuance.nmsp.client.sdk.components.resource.common.Resource;
import com.nuance.nmsp.client.sdk.components.resource.common.ResourceException;

/* loaded from: classes.dex */
public interface NMASResource extends Resource {
    public static final short PDX_DATA_TYPE_ASCII = 22;
    public static final short PDX_DATA_TYPE_BYTES = 4;
    public static final short PDX_DATA_TYPE_DICT = 224;
    public static final short PDX_DATA_TYPE_INT = 192;
    public static final short PDX_DATA_TYPE_NULL = 5;
    public static final short PDX_DATA_TYPE_SEQ = 16;
    public static final short PDX_DATA_TYPE_UTF8 = 193;

    Command createCommand(PDXCommandListener pDXCommandListener, String str, String str2, String str3, String str4, String str5, Dictionary dictionary, long j) throws ResourceException;

    AudioParam createPDXAudioParam(String str);

    Parameter createPDXChoiceParam(String str, String str2);

    Parameter createPDXDataParam(String str, byte[] bArr);

    Parameter createPDXDictParam(String str, Dictionary dictionary);

    Dictionary createPDXDictionary();

    Parameter createPDXSeqChunkParam(String str, Dictionary dictionary);

    Parameter createPDXSeqEndParam(String str, Dictionary dictionary);

    Parameter createPDXSeqStartParam(String str, Dictionary dictionary);

    Sequence createPDXSequence();

    Parameter createPDXTTSParam(String str, Dictionary dictionary, NMSPAudioSink nMSPAudioSink);

    Parameter createPDXTextParam(String str, String str2);
}
