package twitter4j.auth;

import java.io.Serializable;
import twitter4j.internal.http.HttpRequest;

/* loaded from: classes.dex */
public class NullAuthorization implements Serializable, Authorization {
    private static NullAuthorization SINGLETON = new NullAuthorization();
    private static final long serialVersionUID = -8748173338942663960L;

    private NullAuthorization() {
    }

    public static NullAuthorization getInstance() {
        return SINGLETON;
    }

    @Override // twitter4j.auth.Authorization
    public String getAuthorizationHeader(HttpRequest httpRequest) {
        return null;
    }

    @Override // twitter4j.auth.Authorization
    public boolean isEnabled() {
        return false;
    }

    public boolean equals(Object obj) {
        return SINGLETON == obj;
    }

    public String toString() {
        return "NullAuthentication{SINGLETON}";
    }

    private Object readResolve() {
        return SINGLETON;
    }
}
