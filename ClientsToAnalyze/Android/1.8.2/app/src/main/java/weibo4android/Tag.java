package weibo4android;

import java.io.Serializable;
import java.util.ArrayList;
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
    private static final long serialVersionUID = 2177657076940291492L;

    /* renamed from: id */
    private String f7917id;
    private String value;

    public Tag(Response response, Element element) {
        ensureRootNodeNameIs("tag", element);
        this.f7917id = getChildText("id", element);
        this.value = getChildText("value", element);
    }

    public Tag(Response response, Element element, Weibo weibo, String str) {
        ensureRootNodeNameIs("tagid", element);
        this.f7917id = element.getNodeName();
        this.value = element.getNodeValue();
    }

    public Tag(Response response, Element element, Weibo weibo) {
        ensureRootNodeNameIs("tagid", element);
        this.f7917id = element.getNodeName();
        this.value = element.getNodeValue();
    }

    public Tag(JSONObject jSONObject) {
        if (jSONObject.getString("id") != null && jSONObject.getString("id").length() != 0) {
            this.f7917id = jSONObject.getString("id");
        } else if (jSONObject.getString("tagid") != null && jSONObject.getString("tagid").length() != 0) {
            this.f7917id = jSONObject.getString("tagid");
        }
        if (jSONObject.getString("value") != null && jSONObject.getString("value").length() != 0) {
            this.value = jSONObject.getString("value");
        }
    }

    public static List constructTags(Response response, Weibo weibo) throws WeiboException {
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

    public static List createTags(Response response, Weibo weibo) throws WeiboException {
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

    public static List destroyTags(Response response, Weibo weibo) throws WeiboException {
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

    static List constructTags(Response response) throws WeiboException {
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
        return (((this.f7917id == null ? 0 : this.f7917id.hashCode()) + 31) * 31) + (this.value != null ? this.value.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Tag tag = (Tag) obj;
            if (this.f7917id == null) {
                if (tag.f7917id != null) {
                    return false;
                }
            } else if (!this.f7917id.equals(tag.f7917id)) {
                return false;
            }
            return this.value == null ? tag.value == null : this.value.equals(tag.value);
        }
        return false;
    }

    public String getId() {
        return this.f7917id;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return "tags{ " + this.f7917id + "," + this.value + '}';
    }
}
