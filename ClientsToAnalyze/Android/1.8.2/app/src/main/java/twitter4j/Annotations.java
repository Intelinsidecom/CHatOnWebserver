package twitter4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
public class Annotations implements Serializable {
    public static final int lengthLimit = 512;
    private static final long serialVersionUID = 7928827620306593741L;
    private List annotations = null;

    public Annotations() {
        setAnnotations(null);
    }

    public Annotations(List list) {
        setAnnotations(list);
    }

    public Annotations(JSONArray jSONArray) {
        setAnnotations(null);
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                addAnnotation(new Annotation(jSONArray.getJSONObject(i)));
            } catch (JSONException e) {
                this.annotations.clear();
                return;
            }
        }
    }

    public List getAnnotations() {
        return this.annotations;
    }

    public void setAnnotations(List list) {
        if (list == null) {
            list = new ArrayList();
        }
        this.annotations = list;
    }

    public void addAnnotation(Annotation annotation) {
        this.annotations.add(annotation);
    }

    public Annotations annotation(Annotation annotation) {
        addAnnotation(annotation);
        return this;
    }

    public boolean isEmpty() {
        return this.annotations.isEmpty();
    }

    public Integer size() {
        return new Integer(this.annotations.size());
    }

    public static boolean isExceedingLengthLimit(Annotations annotations) {
        return annotations.asParameterValue().length() > 512;
    }

    public boolean isExceedingLengthLimit() {
        return isExceedingLengthLimit(this);
    }

    String asParameterValue() {
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.annotations.iterator();
        while (it.hasNext()) {
            jSONArray.put(((Annotation) it.next()).asJSONObject());
        }
        return jSONArray.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this != obj) {
            return (obj instanceof Annotations) && ((Annotations) obj).getSortedAnnotations().equals(getSortedAnnotations());
        }
        return true;
    }

    public int hashCode() {
        return getSortedAnnotations().hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("Annotations{");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size().intValue()) {
                if (i2 > 0) {
                    stringBuffer.append(", ");
                }
                stringBuffer.append(((Annotation) this.annotations.get(i2)).toString());
                i = i2 + 1;
            } else {
                stringBuffer.append('}');
                return stringBuffer.toString();
            }
        }
    }

    private List getSortedAnnotations() {
        ArrayList arrayList = new ArrayList(size().intValue());
        arrayList.addAll(this.annotations);
        Collections.sort(arrayList);
        return arrayList;
    }
}
