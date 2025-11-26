package com.vlingo.sdk.internal.lmtt;

import com.vlingo.sdk.internal.AndroidServerDetails;
import com.vlingo.sdk.internal.http.HttpCallback;
import com.vlingo.sdk.internal.http.HttpResponse;
import com.vlingo.sdk.internal.http.URL;
import com.vlingo.sdk.internal.lmtt.LMTTItem;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.util.StringUtils;
import com.vlingo.sdk.internal.vlservice.VLHttpServiceRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class LMTTComm {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$vlingo$sdk$internal$lmtt$LMTTItem$LmttItemType = null;
    public static final int LMTT_ERROR = 3;
    public static final int LMTT_OK = 1;
    public static final int LMTT_REQUIRES_FULL_RESYNC = 2;
    private static final String SERVER_COUNT_CONTACT = "contact";
    private static final String SERVER_COUNT_PLAYLIST = "playlist";
    private static final String SERVER_COUNT_SONG = "song";
    private static final Logger log = Logger.getLogger(LMTTComm.class);

    static /* synthetic */ int[] $SWITCH_TABLE$com$vlingo$sdk$internal$lmtt$LMTTItem$LmttItemType() {
        int[] iArr = $SWITCH_TABLE$com$vlingo$sdk$internal$lmtt$LMTTItem$LmttItemType;
        if (iArr == null) {
            iArr = new int[LMTTItem.LmttItemType.valuesCustom().length];
            try {
                iArr[LMTTItem.LmttItemType.TYPE_CONTACT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[LMTTItem.LmttItemType.TYPE_PLAYLIST.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[LMTTItem.LmttItemType.TYPE_SONG.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[LMTTItem.LmttItemType.TYPE_UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $SWITCH_TABLE$com$vlingo$sdk$internal$lmtt$LMTTItem$LmttItemType = iArr;
        }
        return iArr;
    }

    public static VLHttpServiceRequest createLMTTRequest(List<LMTTItem> itemsToSend, boolean doWhole, String language, HttpCallback callback) {
        log.debug("createLMTTRequest: creating request " + itemsToSend.size());
        String xml = generateXML(itemsToSend, doWhole);
        log.debug("sendLMTT: generating request...");
        log.debug(xml);
        URL url = AndroidServerDetails.getLMTTURL();
        VLHttpServiceRequest request = VLHttpServiceRequest.createVLRequest("LMTT", callback, url, xml, language);
        request.setGzipPostData(true);
        request.setMaxRetry(0);
        return request;
    }

    private static String generateXML(List<LMTTItem> itemsToSend, boolean doWhole) {
        List<LMTTItem> contactItems = new ArrayList<>();
        List<LMTTItem> songItems = new ArrayList<>();
        List<LMTTItem> playlistItems = new ArrayList<>();
        for (LMTTItem item : itemsToSend) {
            switch ($SWITCH_TABLE$com$vlingo$sdk$internal$lmtt$LMTTItem$LmttItemType()[item.type.ordinal()]) {
                case 1:
                    contactItems.add(item);
                    break;
                case 2:
                    songItems.add(item);
                    break;
                case 3:
                    playlistItems.add(item);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder(itemsToSend.size() * 20);
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        sb.append("<LMTT>");
        if (contactItems.size() > 0) {
            if (doWhole) {
                sb.append("<PIM t=\"w\">");
            } else {
                sb.append("<PIM t=\"p\">");
            }
            getListItemsXML(contactItems, sb);
            sb.append("</PIM>");
        }
        if (songItems.size() > 0 || playlistItems.size() > 0) {
            if (doWhole) {
                sb.append("<MU t=\"w\">");
            } else {
                sb.append("<MU t=\"p\">");
            }
            if (songItems.size() > 0) {
                sb.append("<SUS>");
                getListItemsXML(songItems, sb);
                sb.append("</SUS>");
            }
            if (playlistItems.size() > 0) {
                sb.append("<PUS>");
                getListItemsXML(playlistItems, sb);
                sb.append("</PUS>");
            }
            sb.append("</MU>");
        }
        sb.append("</LMTT>");
        return sb.toString();
    }

    private static void getListItemsXML(List<LMTTItem> list, StringBuilder sb) {
        for (LMTTItem item : list) {
            String xml = item.getXML();
            log.debug("adding xml " + xml);
            sb.append(xml);
        }
    }

    public static HashMap<LMTTItem.LmttItemType, Integer> parseLMTTResponse(HttpResponse res) {
        String checkResponse = res.getDataAsString().trim();
        log.debug("Checking response from LMTT server: '" + checkResponse + "'");
        try {
            String countValue = StringUtils.getSubstring(checkResponse, "count=\"", "\"");
            String typeValue = StringUtils.getSubstring(checkResponse, "type=\"", "\"");
            if (countValue != null && typeValue != null) {
                String[] serverCounts = StringUtils.split(countValue, ',');
                String[] types = StringUtils.split(typeValue, ',');
                if (serverCounts.length >= 1 && types.length >= 1 && serverCounts.length == types.length) {
                    HashMap<LMTTItem.LmttItemType, Integer> countHash = new HashMap<>();
                    for (int i = 0; i < types.length; i++) {
                        int serverCount = Integer.valueOf(serverCounts[i]).intValue();
                        LMTTItem.LmttItemType clientType = mapServerType2ClientType(types[i]);
                        countHash.put(clientType, Integer.valueOf(serverCount));
                    }
                    return countHash;
                }
            }
        } catch (Throwable t) {
            log.error("LMT2", "Error parsing LMTT response: " + t + " Response: " + checkResponse);
        }
        return null;
    }

    private static LMTTItem.LmttItemType mapServerType2ClientType(String serverLmttItemType) {
        LMTTItem.LmttItemType toReturn = LMTTItem.LmttItemType.TYPE_UNKNOWN;
        if (SERVER_COUNT_PLAYLIST.equalsIgnoreCase(serverLmttItemType)) {
            LMTTItem.LmttItemType toReturn2 = LMTTItem.LmttItemType.TYPE_PLAYLIST;
            return toReturn2;
        }
        if (SERVER_COUNT_SONG.equalsIgnoreCase(serverLmttItemType)) {
            LMTTItem.LmttItemType toReturn3 = LMTTItem.LmttItemType.TYPE_SONG;
            return toReturn3;
        }
        if (SERVER_COUNT_CONTACT.equalsIgnoreCase(serverLmttItemType)) {
            LMTTItem.LmttItemType toReturn4 = LMTTItem.LmttItemType.TYPE_CONTACT;
            return toReturn4;
        }
        return toReturn;
    }
}
