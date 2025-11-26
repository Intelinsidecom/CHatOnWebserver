package com.nuance.nmsp.client.sdk.components.resource.internal.nmas;

import com.nuance.nmsp.client.sdk.common.defines.NMSPDefines;
import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;
import com.nuance.nmsp.client.sdk.components.resource.nmas.Dictionary;
import com.nuance.nmsp.client.sdk.components.resource.nmas.NMASResource;
import com.sds.coolots.common.controller.DatabaseHelper;
import java.util.Enumeration;

/* loaded from: classes.dex */
public class PDXQueryBegin extends PDXMessage {

    /* renamed from: a */
    private static final LogFactory.Log f175a = LogFactory.getLog(PDXQueryBegin.class);

    public PDXQueryBegin(String str, String str2, String str3, String str4, String str5, String str6, NMSPDefines.Codec codec, String str7, short s, short s2, String str8, String str9, String str10, String str11, byte[] bArr, String str12, String str13, Dictionary dictionary) {
        super((short) 514);
        if (f175a.isDebugEnabled()) {
            f175a.debug("PDXQueryBegin()");
        }
        put("uid", str, NMASResource.PDX_DATA_TYPE_UTF8);
        put("pdx_version", str2, NMASResource.PDX_DATA_TYPE_UTF8);
        put("client_version", str3, NMASResource.PDX_DATA_TYPE_UTF8);
        put("script_version", str4, NMASResource.PDX_DATA_TYPE_UTF8);
        put("language", str5, NMASResource.PDX_DATA_TYPE_UTF8);
        put(DatabaseHelper.KEY_REGION, str6, NMASResource.PDX_DATA_TYPE_UTF8);
        put("device_codec", codec.getValue(), NMASResource.PDX_DATA_TYPE_INT);
        put("dictation_language", str7, NMASResource.PDX_DATA_TYPE_UTF8);
        put("lcd_width", s, NMASResource.PDX_DATA_TYPE_INT);
        put("lcd_height", s2, NMASResource.PDX_DATA_TYPE_INT);
        if (str8 == null) {
            put("carrier", new byte[0], (short) 5);
        } else {
            put("carrier", str8, NMASResource.PDX_DATA_TYPE_UTF8);
        }
        put("phone_model", str9, NMASResource.PDX_DATA_TYPE_UTF8);
        put("phone_number", str10, NMASResource.PDX_DATA_TYPE_UTF8);
        put("original_session_id", str11, (short) 22);
        if (bArr != null) {
            put("new_session_id", bArr, (short) 22);
        }
        put("application", str12, (short) 22);
        put("nmaid", str12, (short) 22);
        put("command", str13, (short) 22);
        if (dictionary != null) {
            Enumeration enumerationKeys = dictionary.keys();
            while (enumerationKeys.hasMoreElements()) {
                String str14 = (String) enumerationKeys.nextElement();
                switch (((PDXDictionary) dictionary).getClass(str14).getType()) {
                    case 4:
                        put(str14, dictionary.getByteString(str14), (short) 4);
                        break;
                    case 5:
                        put(str14, (byte[]) null, (short) 5);
                        break;
                    case 16:
                        f175a.error("PDXQueryBegin() Sequence not accepted in optionalKeys");
                        break;
                    case 22:
                        put(str14, dictionary.getAsciiString(str14), (short) 22);
                        break;
                    case 192:
                        put(str14, dictionary.getInteger(str14), NMASResource.PDX_DATA_TYPE_INT);
                        break;
                    case 193:
                        put(str14, dictionary.getUTF8String(str14), NMASResource.PDX_DATA_TYPE_UTF8);
                        break;
                    case 224:
                        f175a.error("PDXQueryBegin() Dictionary not accepted in optionalKeys");
                        break;
                }
            }
        }
    }
}
