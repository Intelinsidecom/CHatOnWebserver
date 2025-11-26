package twitter4j.internal.http;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class RequestMethod implements Serializable {
    private static final long serialVersionUID = -4399222582680270381L;
    private final String name;
    private static final Map<String, RequestMethod> instances = new HashMap(5);
    public static final RequestMethod GET = new RequestMethod("GET");
    public static final RequestMethod POST = new RequestMethod("POST");
    public static final RequestMethod DELETE = new RequestMethod("DELETE");
    public static final RequestMethod HEAD = new RequestMethod("HEAD");
    public static final RequestMethod PUT = new RequestMethod("PUT");

    private RequestMethod(String str) {
        this.name = str;
        instances.put(str, this);
    }

    public final String name() {
        return this.name;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RequestMethod) && this.name.equals(((RequestMethod) obj).name);
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return new StringBuffer().append("RequestMethod{name='").append(this.name).append('\'').append('}').toString();
    }

    private static RequestMethod getInstance(String str) {
        return instances.get(str);
    }

    private Object readResolve() {
        return getInstance(this.name);
    }
}
