package weibo4android;

/* loaded from: classes.dex */
public interface StatusListener {
    void onException(Exception exc);

    void onStatus(Status status);
}
