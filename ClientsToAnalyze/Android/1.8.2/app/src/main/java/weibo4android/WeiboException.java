package weibo4android;

/* loaded from: classes.dex */
public class WeiboException extends Exception {
    private static final long serialVersionUID = -2623309261327598087L;
    private int statusCode;

    public WeiboException(String str) {
        super(str);
        this.statusCode = -1;
    }

    public WeiboException(Exception exc) {
        super(exc);
        this.statusCode = -1;
    }

    public WeiboException(String str, int i) {
        super(str);
        this.statusCode = -1;
        this.statusCode = i;
    }

    public WeiboException(String str, Exception exc) {
        super(str, exc);
        this.statusCode = -1;
    }

    public WeiboException(String str, Exception exc, int i) {
        super(str, exc);
        this.statusCode = -1;
        this.statusCode = i;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
