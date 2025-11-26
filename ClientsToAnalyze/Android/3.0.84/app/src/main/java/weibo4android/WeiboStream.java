package weibo4android;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import weibo4android.http.PostParameter;

/* loaded from: classes.dex */
public class WeiboStream extends WeiboSupport {
    private static final boolean DEBUG = Configuration.getDebug();
    private StreamHandlingThread handler;
    private int retryPerMinutes;
    private StatusListener statusListener;

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ void forceUsePost(boolean z) {
        super.forceUsePost(z);
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ String getClientURL() {
        return super.getClientURL();
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ String getClientVersion() {
        return super.getClientVersion();
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ String getPassword() {
        return super.getPassword();
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ String getSource() {
        return super.getSource();
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ String getUserAgent() {
        return super.getUserAgent();
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ String getUserId() {
        return super.getUserId();
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ boolean isUsePostForced() {
        return super.isUsePostForced();
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ void setClientURL(String str) {
        super.setClientURL(str);
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ void setClientVersion(String str) {
        super.setClientVersion(str);
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ void setHttpConnectionTimeout(int i) {
        super.setHttpConnectionTimeout(i);
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ void setHttpProxy(String str, int i) {
        super.setHttpProxy(str, i);
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ void setHttpProxyAuth(String str, String str2) {
        super.setHttpProxyAuth(str, str2);
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ void setHttpReadTimeout(int i) {
        super.setHttpReadTimeout(i);
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ void setPassword(String str) {
        super.setPassword(str);
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ void setRequestHeader(String str, String str2) {
        super.setRequestHeader(str, str2);
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ void setRetryCount(int i) {
        super.setRetryCount(i);
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ void setRetryIntervalSecs(int i) {
        super.setRetryIntervalSecs(i);
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ void setSource(String str) {
        super.setSource(str);
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ void setUserAgent(String str) {
        super.setUserAgent(str);
    }

    @Override // weibo4android.WeiboSupport
    public /* bridge */ /* synthetic */ void setUserId(String str) {
        super.setUserId(str);
    }

    public WeiboStream() {
        this.handler = null;
        this.retryPerMinutes = 1;
    }

    public WeiboStream(String str, String str2) {
        super(str, str2);
        this.handler = null;
        this.retryPerMinutes = 1;
    }

    public WeiboStream(String str, String str2, StatusListener statusListener) {
        super(str, str2);
        this.handler = null;
        this.retryPerMinutes = 1;
        this.statusListener = statusListener;
    }

    public void firehose(int i) {
        startHandler(new StreamHandlingThread(new Object[]{Integer.valueOf(i)}) { // from class: weibo4android.WeiboStream.1
            @Override // weibo4android.WeiboStream.StreamHandlingThread
            public StatusStream getStream() {
                return WeiboStream.this.getFirehoseStream(((Integer) this.args[0]).intValue());
            }
        });
    }

    public StatusStream getFirehoseStream(int i) throws WeiboException {
        try {
            return new StatusStream(this.http.post(getStreamBaseURL() + "1/statuses/firehose.json", new PostParameter[]{new PostParameter("count", String.valueOf(i))}, true));
        } catch (IOException e) {
            throw new WeiboException(e);
        }
    }

    public void retweet() {
        startHandler(new StreamHandlingThread(new Object[0]) { // from class: weibo4android.WeiboStream.2
            @Override // weibo4android.WeiboStream.StreamHandlingThread
            public StatusStream getStream() {
                return WeiboStream.this.getRetweetStream();
            }
        });
    }

    public StatusStream getRetweetStream() throws WeiboException {
        try {
            return new StatusStream(this.http.post(getStreamBaseURL() + "1/statuses/retweet.json", new PostParameter[0], true));
        } catch (IOException e) {
            throw new WeiboException(e);
        }
    }

    public void sample() {
        startHandler(new StreamHandlingThread(null) { // from class: weibo4android.WeiboStream.3
            @Override // weibo4android.WeiboStream.StreamHandlingThread
            public StatusStream getStream() {
                return WeiboStream.this.getSampleStream();
            }
        });
    }

    public StatusStream getSampleStream() throws WeiboException {
        try {
            return new StatusStream(this.http.get(getStreamBaseURL() + "1/statuses/sample.json", true));
        } catch (IOException e) {
            throw new WeiboException(e);
        }
    }

    public void filter(int i, int[] iArr, String[] strArr) {
        startHandler(new StreamHandlingThread(new Object[]{Integer.valueOf(i), iArr, strArr}) { // from class: weibo4android.WeiboStream.4
            @Override // weibo4android.WeiboStream.StreamHandlingThread
            public StatusStream getStream() {
                return WeiboStream.this.getFilterStream(((Integer) this.args[0]).intValue(), (int[]) this.args[1], (String[]) this.args[2]);
            }
        });
    }

    public StatusStream getFilterStream(int i, int[] iArr, String[] strArr) throws WeiboException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PostParameter("count", i));
        if (iArr != null && iArr.length > 0) {
            arrayList.add(new PostParameter("follow", toFollowString(iArr)));
        }
        if (strArr != null && strArr.length > 0) {
            arrayList.add(new PostParameter("track", toTrackString(strArr)));
        }
        try {
            return new StatusStream(this.http.post(getStreamBaseURL() + "1/statuses/filter.json", (PostParameter[]) arrayList.toArray(new PostParameter[0]), true));
        } catch (IOException e) {
            throw new WeiboException(e);
        }
    }

    @Deprecated
    public void gardenhose() {
        startHandler(new StreamHandlingThread(null) { // from class: weibo4android.WeiboStream.5
            @Override // weibo4android.WeiboStream.StreamHandlingThread
            public StatusStream getStream() {
                return WeiboStream.this.getGardenhoseStream();
            }
        });
    }

    @Deprecated
    public StatusStream getGardenhoseStream() {
        return getSampleStream();
    }

    @Deprecated
    public void spritzer() {
        startHandler(new StreamHandlingThread(null) { // from class: weibo4android.WeiboStream.6
            @Override // weibo4android.WeiboStream.StreamHandlingThread
            public StatusStream getStream() {
                return WeiboStream.this.getSpritzerStream();
            }
        });
    }

    @Deprecated
    public StatusStream getSpritzerStream() {
        return getSampleStream();
    }

    @Deprecated
    public void birddog(int i, int[] iArr) {
        startHandler(new StreamHandlingThread(new Object[]{Integer.valueOf(i), iArr}) { // from class: weibo4android.WeiboStream.7
            @Override // weibo4android.WeiboStream.StreamHandlingThread
            public StatusStream getStream() {
                return WeiboStream.this.getBirddogStream(((Integer) this.args[0]).intValue(), (int[]) this.args[1]);
            }
        });
    }

    @Deprecated
    public StatusStream getBirddogStream(int i, int[] iArr) {
        return getFilterStream(i, iArr, null);
    }

    @Deprecated
    public void shadow(int i, int[] iArr) {
        startHandler(new StreamHandlingThread(new Object[]{Integer.valueOf(i), iArr}) { // from class: weibo4android.WeiboStream.8
            @Override // weibo4android.WeiboStream.StreamHandlingThread
            public StatusStream getStream() {
                return WeiboStream.this.getShadowStream(((Integer) this.args[0]).intValue(), (int[]) this.args[1]);
            }
        });
    }

    @Deprecated
    public StatusStream getShadowStream(int i, int[] iArr) {
        return getFilterStream(i, iArr, null);
    }

    @Deprecated
    public void follow(int[] iArr) {
        startHandler(new StreamHandlingThread(new Object[]{iArr}) { // from class: weibo4android.WeiboStream.9
            @Override // weibo4android.WeiboStream.StreamHandlingThread
            public StatusStream getStream() {
                return WeiboStream.this.getFollowStream((int[]) this.args[0]);
            }
        });
    }

    @Deprecated
    public StatusStream getFollowStream(int[] iArr) {
        return getFilterStream(0, iArr, null);
    }

    private String toFollowString(int[] iArr) {
        StringBuffer stringBuffer = new StringBuffer(iArr.length * 11);
        for (int i : iArr) {
            if (stringBuffer.length() != 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append(i);
        }
        return stringBuffer.toString();
    }

    @Deprecated
    public void track(final String[] strArr) {
        startHandler(new StreamHandlingThread(null) { // from class: weibo4android.WeiboStream.10
            @Override // weibo4android.WeiboStream.StreamHandlingThread
            public StatusStream getStream() {
                return WeiboStream.this.getTrackStream(strArr);
            }
        });
    }

    @Deprecated
    public StatusStream getTrackStream(String[] strArr) {
        return getFilterStream(0, null, strArr);
    }

    private String toTrackString(String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer(strArr.length * 20 * 4);
        for (String str : strArr) {
            if (stringBuffer.length() != 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    private synchronized void startHandler(StreamHandlingThread streamHandlingThread) {
        cleanup();
        if (this.statusListener == null) {
            throw new IllegalStateException("StatusListener is not set.");
        }
        this.handler = streamHandlingThread;
        this.handler.start();
    }

    public synchronized void cleanup() {
        if (this.handler != null) {
            try {
                this.handler.close();
            } catch (IOException e) {
            }
        }
    }

    public StatusListener getStatusListener() {
        return this.statusListener;
    }

    public void setStatusListener(StatusListener statusListener) {
        this.statusListener = statusListener;
    }

    abstract class StreamHandlingThread extends Thread {
        private static final String NAME = "Weibo Stream Handling Thread";
        Object[] args;
        private boolean closed;
        private List<Long> retryHistory;
        StatusStream stream;

        abstract StatusStream getStream();

        StreamHandlingThread(Object[] objArr) {
            super("Weibo Stream Handling Thread[initializing]");
            this.stream = null;
            this.closed = false;
            this.args = objArr;
            this.retryHistory = new ArrayList(WeiboStream.this.retryPerMinutes);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws InterruptedException {
            Status next;
            while (!this.closed) {
                try {
                    if (this.retryHistory.size() > 0 && System.currentTimeMillis() - this.retryHistory.get(0).longValue() > 60000) {
                        this.retryHistory.remove(0);
                    }
                    if (this.retryHistory.size() < WeiboStream.this.retryPerMinutes) {
                        setStatus("[establishing connection]");
                        while (!this.closed && this.stream == null) {
                            if (this.retryHistory.size() < WeiboStream.this.retryPerMinutes) {
                                this.retryHistory.add(Long.valueOf(System.currentTimeMillis()));
                                this.stream = getStream();
                            }
                        }
                    } else {
                        long jCurrentTimeMillis = 60000 - (System.currentTimeMillis() - this.retryHistory.get(this.retryHistory.size() - 1).longValue());
                        setStatus("[retry limit reached. sleeping for " + (jCurrentTimeMillis / 1000) + " secs]");
                        try {
                            Thread.sleep(jCurrentTimeMillis);
                        } catch (InterruptedException e) {
                        }
                    }
                    if (this.stream != null) {
                        setStatus("[receiving stream]");
                        while (!this.closed && (next = this.stream.next()) != null) {
                            WeiboStream.this.log("received:", next.toString());
                            if (WeiboStream.this.statusListener != null) {
                                WeiboStream.this.statusListener.onStatus(next);
                            }
                        }
                    }
                } catch (WeiboException e2) {
                    this.stream = null;
                    e2.printStackTrace();
                    WeiboStream.this.log(e2.getMessage());
                    WeiboStream.this.statusListener.onException(e2);
                }
            }
        }

        public synchronized void close() {
            setStatus("[disposing thread]");
            if (this.stream != null) {
                this.stream.close();
                this.closed = true;
            }
        }

        private void setStatus(String str) {
            String str2 = NAME + str;
            setName(str2);
            WeiboStream.this.log(str2);
        }
    }

    private String getStreamBaseURL() {
        return this.USE_SSL ? "https://stream.t.sina.com.cn/" : "http://stream.t.sina.com.cn/";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        if (DEBUG) {
            System.out.println("[" + new Date() + "]" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str, String str2) {
        if (DEBUG) {
            log(str + str2);
        }
    }
}
