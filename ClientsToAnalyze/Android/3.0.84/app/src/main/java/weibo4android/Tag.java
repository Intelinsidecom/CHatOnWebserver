package weibo4android;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import weibo4android.http.Response;
import weibo4android.org.json.JSONArray;
import weibo4android.org.json.JSONException;
import weibo4android.org.json.JSONObject;

/* loaded from: classes.dex */
public class Tag extends WeiboResponse implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: id */
    private String f13756id;
    private String value;

    public Tag(Response response, Element element) {
        ensureRootNodeNameIs("tag", element);
        this.f13756id = getChildText("id", element);
        this.value = getChildText("value", element);
    }

    public Tag(Response response, Element element, Weibo weibo, String str) {
        ensureRootNodeNameIs("tagid", element);
        this.f13756id = element.getNodeName();
        this.value = element.getTextContent();
    }

    public Tag(Response response, Element element, Weibo weibo) {
        ensureRootNodeNameIs("tagid", element);
        this.f13756id = element.getNodeName();
        this.value = element.getTextContent();
    }

    public Tag(JSONObject jSONObject) {
        if (jSONObject.getString("id").isEmpty()) {
            Iterator itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                this.f13756id = (String) itKeys.next();
                this.value = jSONObject.getString(this.f13756id);
            }
            return;
        }
        this.f13756id = jSONObject.getString("id");
        this.value = jSONObject.getString("value");
    }

    public static List<Tag> constructTags(Response response, Weibo weibo) throws WeiboException {
        Document documentAsDocument = response.asDocument();
        if (isRootNodeNilClasses(documentAsDocument)) {
            return new ArrayList(0);
        }
        try {
            ensureRootNodeNameIs("tags", documentAsDocument);
            NodeList elementsByTagName = documentAsDocument.getDocumentElement().getElementsByTagName("tag");
            int length = elementsByTagName.getLength();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(new Tag(response, (Element) elementsByTagName.item(i)));
            }
            return arrayList;
        } catch (WeiboException e) {
            ensureRootNodeNameIs("nil-classes", documentAsDocument);
            return new ArrayList(0);
        }
    }

    public static List<Tag> createTags(Response response, Weibo weibo) throws WeiboException {
        Document documentAsDocument = response.asDocument();
        if (isRootNodeNilClasses(documentAsDocument)) {
            return new ArrayList(0);
        }
        try {
            ensureRootNodeNameIs("tagids", documentAsDocument);
            NodeList elementsByTagName = documentAsDocument.getDocumentElement().getElementsByTagName("tagid");
            int length = elementsByTagName.getLength();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(new Tag(response, (Element) elementsByTagName.item(i), null));
            }
            return arrayList;
        } catch (WeiboException e) {
            ensureRootNodeNameIs("nil-classes", documentAsDocument);
            return new ArrayList(0);
        }
    }

    public static List<Tag> destroyTags(Response response, Weibo weibo) throws WeiboException {
        Document documentAsDocument = response.asDocument();
        if (isRootNodeNilClasses(documentAsDocument)) {
            return new ArrayList(0);
        }
        try {
            ensureRootNodeNameIs("tags", documentAsDocument);
            NodeList elementsByTagName = documentAsDocument.getDocumentElement().getElementsByTagName("tagid");
            int length = elementsByTagName.getLength();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(new Tag(response, (Element) elementsByTagName.item(i), null, null));
            }
            return arrayList;
        } catch (WeiboException e) {
            ensureRootNodeNameIs("nil-classes", documentAsDocument);
            return new ArrayList(0);
        }
    }

    static List<Tag> constructTags(Response response) throws WeiboException {
        try {
            JSONArray jSONArrayAsJSONArray = response.asJSONArray();
            int length = jSONArrayAsJSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(new Tag(jSONArrayAsJSONArray.getJSONObject(i)));
            }
            return arrayList;
        } catch (WeiboException e) {
            throw e;
        } catch (JSONException e2) {
            throw new WeiboException(e2);
        }
    }

    public int hashCode() {
        return Integer.parseInt(this.f13756id);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this != obj) {
            return (obj instanceof Tag) && ((Tag) obj).f13756id == this.f13756id;
        }
        return true;
    }

    public String getId() {
        return this.f13756id;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return "tags{ " + this.f13756id + "," + this.value + '}';
    }
}
