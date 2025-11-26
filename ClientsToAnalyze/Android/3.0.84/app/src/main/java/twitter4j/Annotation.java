package twitter4j;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Annotation implements Serializable, Comparable<Annotation> {
    private static final long serialVersionUID = -6515375141284988754L;
    private Map<String, String> attributes;
    private String type;

    @Override // java.lang.Comparable
    public int compareTo(Annotation annotation) {
        return compareTo2(annotation);
    }

    public Annotation(String str) {
        this.type = null;
        this.attributes = null;
        setType(str);
        setAttributes(null);
    }

    public Annotation(String str, Map<String, String> map) {
        this.type = null;
        this.attributes = null;
        setType(str);
        setAttributes(map);
    }

    Annotation(JSONObject jSONObject) throws JSONException {
        LinkedHashMap linkedHashMap;
        String str = null;
        this.type = null;
        this.attributes = null;
        Iterator<String> itKeys = jSONObject.keys();
        if (itKeys.hasNext()) {
            String next = itKeys.next();
            if (itKeys.hasNext()) {
                this.type = null;
                str = next;
                linkedHashMap = null;
            } else {
                try {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    Iterator<String> itKeys2 = jSONObject2.keys();
                    while (itKeys2.hasNext()) {
                        String next2 = itKeys2.next();
                        linkedHashMap2.put(next2, jSONObject2.getString(next2));
                    }
                    str = next;
                    linkedHashMap = linkedHashMap2;
                } catch (JSONException e) {
                    linkedHashMap = null;
                }
            }
        } else {
            linkedHashMap = null;
        }
        setType(str);
        setAttributes(linkedHashMap);
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        if (str == null) {
            str = "";
        }
        this.type = str;
    }

    public Annotation type(String str) {
        setType(str);
        return this;
    }

    public Map<String, String> getAttributes() {
        return this.attributes;
    }

    public void setAttributes(Map<String, String> map) {
        if (map == null) {
            map = new LinkedHashMap<>();
        }
        this.attributes = map;
    }

    public Annotation attributes(Map<String, String> map) {
        setAttributes(map);
        return this;
    }

    public void addAttribute(String str, String str2) {
        this.attributes.put(str, str2);
    }

    public Annotation attribute(String str, String str2) {
        addAttribute(str, str2);
        return this;
    }

    public boolean isEmpty() {
        return this.attributes.isEmpty();
    }

    public Integer size() {
        return new Integer(this.attributes.size());
    }

    String asParameterValue() {
        return asJSONObject().toString();
    }

    JSONObject asJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(this.type, (Map) this.attributes);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Annotation annotation) {
        if (annotation == null) {
            return 1;
        }
        if (this == annotation) {
            return 0;
        }
        int iCompareTo = getType().compareTo(annotation.getType());
        if (iCompareTo == 0) {
            int iCompareTo2 = size().compareTo(annotation.size());
            if (iCompareTo2 == 0) {
                Iterator<String> it = annotation.sortedNames().iterator();
                for (String str : sortedNames()) {
                    String next = it.next();
                    int iCompareTo3 = str.compareTo(next);
                    if (iCompareTo3 != 0) {
                        return iCompareTo3;
                    }
                    int iCompareTo4 = getAttributes().get(str).compareTo(annotation.getAttributes().get(next));
                    if (iCompareTo4 != 0) {
                        return iCompareTo4;
                    }
                }
                return 0;
            }
            return iCompareTo2;
        }
        return iCompareTo;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Annotation)) {
            return false;
        }
        Annotation annotation = (Annotation) obj;
        return getType().equals(annotation.getType()) && getAttributes().equals(annotation.getAttributes());
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.attributes.hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("Annotation{type='");
        stringBuffer.append(this.type).append("', attributes={");
        Iterator<String> it = this.attributes.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            stringBuffer.append('\'').append(next).append("'='").append(this.attributes.get(next)).append('\'');
            if (it.hasNext()) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append("}}");
        return stringBuffer.toString();
    }

    private SortedSet<String> sortedNames() {
        TreeSet treeSet = new TreeSet();
        treeSet.addAll(getAttributes().keySet());
        return treeSet;
    }
}
