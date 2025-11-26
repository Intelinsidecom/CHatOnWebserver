package weibo4android;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import weibo4android.http.HTMLEntity;
import weibo4android.http.Response;
import weibo4android.org.json.JSONException;
import weibo4android.org.json.JSONObject;

/* loaded from: classes.dex */
public class WeiboResponse implements Serializable {
    private static final long serialVersionUID = 3519962197957449562L;
    private transient int rateLimitLimit;
    private transient int rateLimitRemaining;
    private transient long rateLimitReset;
    private static Map formatMap = new HashMap();
    private static final boolean IS_DALVIK = Configuration.isDalvik();

    public WeiboResponse() {
        this.rateLimitLimit = -1;
        this.rateLimitRemaining = -1;
        this.rateLimitReset = -1L;
    }

    public WeiboResponse(Response response) {
        this.rateLimitLimit = -1;
        this.rateLimitRemaining = -1;
        this.rateLimitReset = -1L;
        String responseHeader = response.getResponseHeader("X-RateLimit-Limit");
        if (responseHeader != null) {
            this.rateLimitLimit = Integer.parseInt(responseHeader);
        }
        String responseHeader2 = response.getResponseHeader("X-RateLimit-Remaining");
        if (responseHeader2 != null) {
            this.rateLimitRemaining = Integer.parseInt(responseHeader2);
        }
        String responseHeader3 = response.getResponseHeader("X-RateLimit-Reset");
        if (responseHeader3 != null) {
            this.rateLimitReset = Long.parseLong(responseHeader3);
        }
    }

    protected static void ensureRootNodeNameIs(String str, Element element) throws WeiboException {
        if (!str.equals(element.getNodeName())) {
            throw new WeiboException("Unexpected root node name:" + element.getNodeName() + ". Expected:" + str + ". Check the availability of the Weibo API at http://open.t.sina.com.cn/.");
        }
    }

    protected static void ensureRootNodeNameIs(String[] strArr, Element element) throws WeiboException {
        String nodeName = element.getNodeName();
        for (String str : strArr) {
            if (str.equals(nodeName)) {
                return;
            }
        }
        String str2 = "";
        int i = 0;
        while (i < strArr.length) {
            if (i != 0) {
                str2 = String.valueOf(str2) + " or ";
            }
            String str3 = String.valueOf(str2) + strArr[i];
            i++;
            str2 = str3;
        }
        throw new WeiboException("Unexpected root node name:" + element.getNodeName() + ". Expected:" + str2 + ". Check the availability of the Weibo API at http://open.t.sina.com.cn/.");
    }

    protected static void ensureRootNodeNameIs(String str, Document document) throws WeiboException {
        Element documentElement = document.getDocumentElement();
        if (!str.equals(documentElement.getNodeName())) {
            throw new WeiboException("Unexpected root node name:" + documentElement.getNodeName() + ". Expected:" + str + ". Check the availability of the Weibo API at http://open.t.sina.com.cn/");
        }
    }

    protected static boolean isRootNodeNilClasses(Document document) {
        String nodeName = document.getDocumentElement().getNodeName();
        return "nil-classes".equals(nodeName) || "nilclasses".equals(nodeName);
    }

    protected static String getChildText(String str, Element element) {
        return HTMLEntity.unescape(getTextContent(str, element));
    }

    protected static String getTextContent(String str, Element element) {
        Node firstChild;
        String nodeValue;
        NodeList elementsByTagName = element.getElementsByTagName(str);
        if (elementsByTagName.getLength() <= 0 || (firstChild = elementsByTagName.item(0).getFirstChild()) == null || (nodeValue = firstChild.getNodeValue()) == null) {
            return "";
        }
        return nodeValue;
    }

    protected static int getChildInt(String str, Element element) {
        String textContent = getTextContent(str, element);
        if (textContent == null || "".equals(textContent) || "null".equals(str)) {
            return -1;
        }
        return Integer.valueOf(textContent).intValue();
    }

    protected static long getChildLong(String str, Element element) {
        String textContent = getTextContent(str, element);
        if (textContent == null || "".equals(textContent) || "null".equals(str)) {
            return -1L;
        }
        return Long.valueOf(textContent).longValue();
    }

    protected static String getString(String str, JSONObject jSONObject, boolean z) {
        try {
            String string = jSONObject.getString(str);
            if (z) {
                try {
                    return URLDecoder.decode(string, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    return string;
                }
            }
            return string;
        } catch (JSONException e2) {
            return null;
        }
    }

    protected static boolean getChildBoolean(String str, Element element) {
        return Boolean.valueOf(getTextContent(str, element)).booleanValue();
    }

    protected static Date getChildDate(String str, Element element) {
        return getChildDate(str, element, "EEE MMM d HH:mm:ss z yyyy");
    }

    protected static Date getChildDate(String str, Element element, String str2) {
        return parseDate(getChildText(str, element), str2);
    }

    protected static Date parseDate(String str, String str2) throws WeiboException {
        SimpleDateFormat simpleDateFormat;
        Date date;
        if (str == null || "".equals(str)) {
            return null;
        }
        SimpleDateFormat simpleDateFormat2 = (SimpleDateFormat) formatMap.get(str2);
        if (simpleDateFormat2 == null) {
            SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat(str2, Locale.ENGLISH);
            simpleDateFormat3.setTimeZone(TimeZone.getTimeZone("GMT"));
            formatMap.put(str2, simpleDateFormat3);
            simpleDateFormat = simpleDateFormat3;
        } else {
            simpleDateFormat = simpleDateFormat2;
        }
        try {
            synchronized (simpleDateFormat) {
                date = simpleDateFormat.parse(str);
            }
            return date;
        } catch (ParseException e) {
            throw new WeiboException("Unexpected format(" + str + ") returned from sina.com.cn");
        }
    }

    protected static int getInt(String str, JSONObject jSONObject) {
        String string = jSONObject.getString(str);
        if (string == null || "".equals(string) || "null".equals(string)) {
            return -1;
        }
        return Integer.parseInt(string);
    }

    protected static long getLong(String str, JSONObject jSONObject) {
        String string = jSONObject.getString(str);
        if (string == null || "".equals(string) || "null".equals(string)) {
            return -1L;
        }
        return Long.parseLong(string);
    }

    protected static boolean getBoolean(String str, JSONObject jSONObject) {
        String string = jSONObject.getString(str);
        if (string == null || "".equals(string) || "null".equals(string)) {
            return false;
        }
        return Boolean.valueOf(string).booleanValue();
    }

    public int getRateLimitLimit() {
        return this.rateLimitLimit;
    }

    public int getRateLimitRemaining() {
        return this.rateLimitRemaining;
    }

    public long getRateLimitReset() {
        return this.rateLimitReset;
    }
}
