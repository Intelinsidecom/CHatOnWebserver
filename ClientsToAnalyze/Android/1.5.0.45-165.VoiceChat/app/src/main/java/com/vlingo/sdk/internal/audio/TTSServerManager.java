package com.vlingo.sdk.internal.audio;

import com.vlingo.sdk.internal.AndroidServerDetails;
import com.vlingo.sdk.internal.http.HttpCallback;
import com.vlingo.sdk.internal.http.HttpResponse;
import com.vlingo.sdk.internal.http.HttpUtil;
import com.vlingo.sdk.internal.http.URL;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.util.StringUtils;
import com.vlingo.sdk.internal.util.XmlUtils;
import com.vlingo.sdk.internal.vlservice.VLHttpServiceRequest;
import java.util.Hashtable;

/* loaded from: classes.dex */
public class TTSServerManager {
    private static Logger log = Logger.getLogger(TTSServerManager.class);
    private static int ttsSequenceId = 0;

    public static VLHttpServiceRequest createTTSRequest(TTSRequest ttsRequest, String language, HttpCallback callback) {
        String xml = getTTSRequestXML(ttsRequest, language);
        log.debug("sendTTS: generating request...");
        log.debug(xml);
        Hashtable<String, String> headers = new Hashtable<>(2);
        headers.put(HttpUtil.HEADER_CONTENT_TYPE, "application/x-www-form-urlencoded");
        headers.put("X-vlrequest", "CL=true; RequestID=" + ttsSequenceId);
        ttsSequenceId++;
        URL url = AndroidServerDetails.getTTSURL();
        VLHttpServiceRequest request = VLHttpServiceRequest.createVLRequest("TTS", callback, url, xml, language);
        request.setExtraHeaders(headers);
        request.setMaxRetry(0);
        return request;
    }

    public static byte[] parseTTSResponse(HttpResponse res) {
        byte[] data = res.getDataAsBytes();
        if (data != null) {
            if (data.length < 400) {
                return (byte[]) null;
            }
            if (data[0] == 60 && data[1] == 63 && data[2] == 120 && data[3] == 109 && data[4] == 108) {
                return (byte[]) null;
            }
            return data;
        }
        return data;
    }

    private static String getTTSRequestXML(TTSRequest request, String lang) {
        StringBuffer sb = new StringBuffer();
        String language = StringUtils.isNullOrWhiteSpace(lang) ? "en-US" : lang;
        sb.append("<").append(TTSRequestParams.REQUEST).append(" ");
        sb.append(TTSRequestParams.SENDER_ONLY).append("=\"").append(request.senderOnly).append("\" ");
        sb.append(TTSRequestParams.GENDER).append("=\"").append(request.gender).append("\" ");
        sb.append(TTSRequestParams.LANG).append("=\"").append(language).append("\" ");
        sb.append(TTSRequestParams.AUDIO).append("=\"").append(TTSRequestParams.AUDIO_MP3).append("\" ");
        sb.append(TTSRequestParams.TYPE).append("=\"").append(request.type).append("\" ");
        sb.append(TTSRequestParams.SPEECHRATE).append("=\"").append(request.speechRate).append("\" ");
        if (request.wordLimit > 0) {
            sb.append(TTSRequestParams.WORD_COUNT).append("=\"").append(request.wordLimit).append("\" ");
        }
        sb.append(TTSRequestParams.VOLUME).append("=\"").append(100).append("\" ");
        sb.append(TTSRequestParams.VERSION).append("=\"").append("1.0").append("\" ");
        sb.append(TTSRequestParams.PRESILENCE).append("=\"").append("0").append("\"");
        sb.append(">");
        if (!StringUtils.isNullOrWhiteSpace(request.senderDisplayName)) {
            sb.append("<").append(TTSRequestParams.FROM).append(">");
            sb.append(XmlUtils.wrapInCDATA(request.senderDisplayName));
            sb.append("</").append(TTSRequestParams.FROM).append(">");
        }
        if (!StringUtils.isNullOrWhiteSpace(request.subject)) {
            sb.append("<").append(TTSRequestParams.SUBJ).append(">");
            sb.append(XmlUtils.wrapInCDATA(request.subject));
            sb.append("</").append(TTSRequestParams.SUBJ).append(">");
        }
        if (!StringUtils.isNullOrWhiteSpace(request.body)) {
            sb.append("<").append(TTSRequestParams.BODY).append(">");
            sb.append(XmlUtils.wrapInCDATA(request.body));
            sb.append("</").append(TTSRequestParams.BODY).append(">");
        }
        sb.append("</").append(TTSRequestParams.REQUEST).append(">");
        return sb.toString();
    }
}
