package twitter4j.internal.http;

/* loaded from: classes.dex */
public interface HttpClient {
    HttpResponse request(HttpRequest httpRequest);

    void shutdown();
}
