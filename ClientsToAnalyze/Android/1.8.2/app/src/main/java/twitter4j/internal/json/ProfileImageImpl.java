package twitter4j.internal.json;

import org.jboss.netty.handler.codec.http.HttpHeaders;
import twitter4j.ProfileImage;
import twitter4j.internal.http.HttpResponse;

/* loaded from: classes.dex */
class ProfileImageImpl extends TwitterResponseImpl implements ProfileImage {
    private static final long serialVersionUID = -3710458112877311569L;
    private String url;

    ProfileImageImpl(HttpResponse httpResponse) {
        super(httpResponse);
        this.url = httpResponse.getResponseHeader(HttpHeaders.Names.LOCATION);
    }

    @Override // twitter4j.ProfileImage
    public String getURL() {
        return this.url;
    }
}
