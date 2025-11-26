package com.vlingo.sdk.internal.http;

import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.util.Future;
import com.vlingo.sdk.internal.util.ThreadPoolExecutor;
import com.vlingo.sdk.internal.util.ThreadPoolRunnable;
import com.vlingo.sdk.internal.util.TimerSingleton;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class HttpManager {
    private static final int DEFAULT_BACKGROUND_TASK_DELAY = 5000;
    private static final Logger log = Logger.getLogger(HttpManager.class);
    private static HttpManager s_HttpManager = null;
    private final Timer timeoutTimer;
    private final ThreadPoolExecutor onDemandExecutor = new ThreadPoolExecutor("OnDemandHttpManager");
    private final ThreadPoolExecutor backgroundExecutor = new ThreadPoolExecutor("BackgroundHttpManager");
    private volatile boolean backgroundExecutorPaused = false;
    private final Object backgroudExecutorLock = new Object();
    private final HashMap<HttpRequest, HttpRequestFetchTask> requestTable = new HashMap<>();

    public static synchronized HttpManager getInstance() {
        if (s_HttpManager == null) {
            s_HttpManager = new HttpManager();
        }
        return s_HttpManager;
    }

    public static void destroy() {
        s_HttpManager = null;
    }

    protected HttpManager() {
        this.onDemandExecutor.setMinPoolSize(1);
        this.onDemandExecutor.setMaxPoolSize(3);
        this.onDemandExecutor.setDynamicSizing(true);
        this.onDemandExecutor.setThreadPriority(10);
        this.backgroundExecutor.setMinPoolSize(0);
        this.backgroundExecutor.setMaxPoolSize(1);
        this.backgroundExecutor.setDynamicSizing(true);
        this.backgroundExecutor.setThreadPriority(1);
        this.timeoutTimer = TimerSingleton.getTimer();
    }

    public void doRequestNow(HttpRequest request) {
        doRequestNowInternal(request);
    }

    public void doBackgroundRequest(HttpRequest request, boolean highPriority, boolean ordered) {
        doBackgroundRequestInternal(request, highPriority, ordered);
    }

    public void doBackgroundRequestLater(HttpRequest request, long delay, boolean highPriority, boolean ordered) {
        doBackgroundRequestLaterInternal(request, delay, highPriority, ordered);
    }

    public void cancelRequest(HttpRequest request) {
        cancelRequestInternal(request);
    }

    private synchronized void doRequestNowInternal(HttpRequest request) {
        HttpRequestFetchTask fetcher = new HttpRequestFetchTask(this, request, null);
        fetcher.start();
        this.requestTable.put(request, fetcher);
    }

    private synchronized void doBackgroundRequestInternal(HttpRequest request, boolean highPriority, boolean ordered) {
        HttpRequestFetchTask fetcher = new HttpRequestFetchTask(this, request, true, highPriority, ordered, null);
        fetcher.start();
        this.requestTable.put(request, fetcher);
    }

    private synchronized void doBackgroundRequestLaterInternal(HttpRequest request, long delay, boolean highPriority, boolean ordered) {
        if (delay == 0) {
            doBackgroundRequest(request, highPriority, ordered);
        } else {
            HttpRequestFetchTask fetcher = new HttpRequestFetchTask(this, request, true, highPriority, ordered, null);
            fetcher.schedule(delay);
            this.requestTable.put(request, fetcher);
        }
    }

    protected synchronized void cancelRequestInternal(HttpRequest request) {
        if (this.requestTable.containsKey(request)) {
            HttpRequestFetchTask fetcher = this.requestTable.remove(request);
            fetcher.cancel();
        } else {
            log.info("cancelRequest: request does not exist");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void requestHasTimedOut(HttpRequest request, HttpRequestFetchTimeoutTask originatingTimeoutTask) {
        if (this.requestTable.containsKey(request)) {
            HttpRequestFetchTask fetcher = this.requestTable.get(request);
            boolean timedOut = fetcher.timeout(originatingTimeoutTask);
            if (timedOut) {
                this.requestTable.remove(request);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void requestWasRan(HttpRequest request) {
        this.requestTable.remove(request);
    }

    public void pause() {
        synchronized (this.backgroudExecutorLock) {
            if (!this.backgroundExecutorPaused) {
                this.backgroundExecutorPaused = true;
                this.backgroundExecutor.pause();
            }
        }
    }

    public void resume() {
        synchronized (this.backgroudExecutorLock) {
            if (this.backgroundExecutorPaused) {
                this.backgroundExecutorPaused = false;
                this.backgroundExecutor.resume();
            }
        }
    }

    private class HttpRequestFetchTask implements ThreadPoolRunnable {
        private final boolean background;
        private boolean finished;
        private Future future;
        private final boolean highPriority;
        private final boolean ordered;
        private final HttpRequest parentRequest;
        private HttpRequestFetchTimeoutTask timeoutTask;
        private volatile long waitTime;

        /* synthetic */ HttpRequestFetchTask(HttpManager httpManager, HttpRequest httpRequest, HttpRequestFetchTask httpRequestFetchTask) {
            this(httpManager, httpRequest);
        }

        private HttpRequestFetchTask(HttpManager httpManager, HttpRequest request) {
            this(request, false, false, false);
        }

        private HttpRequestFetchTask(HttpRequest request, boolean background, boolean highPriority, boolean ordered) {
            this.future = null;
            this.timeoutTask = null;
            this.finished = false;
            this.waitTime = 0L;
            this.parentRequest = request;
            this.background = background;
            this.highPriority = highPriority;
            this.ordered = ordered;
        }

        /* synthetic */ HttpRequestFetchTask(HttpManager httpManager, HttpRequest httpRequest, boolean z, boolean z2, boolean z3, HttpRequestFetchTask httpRequestFetchTask) {
            this(httpRequest, z, z2, z3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void start() {
            if (!this.finished) {
                HttpManager.log.debug("Queing high priority http request: " + this.parentRequest.getTaskName());
                if (!this.background) {
                    this.future = HttpManager.this.onDemandExecutor.execute(this);
                } else {
                    this.future = HttpManager.this.backgroundExecutor.execute(this);
                }
                if (this.timeoutTask != null) {
                    this.timeoutTask.cancel();
                    this.timeoutTask = null;
                }
                if (this.parentRequest.getTimeout() > 0) {
                    this.timeoutTask = new HttpRequestFetchTimeoutTask(HttpManager.this, this.parentRequest, null);
                    HttpManager.this.timeoutTimer.schedule(this.timeoutTask, this.parentRequest.getTimeout());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void schedule(long delay) {
            if (!this.finished) {
                HttpManager.log.debug("Queing background http request: " + this.parentRequest.getTaskName());
                if (delay <= 0) {
                    this.future = HttpManager.this.backgroundExecutor.execute(this);
                } else {
                    this.waitTime = delay;
                    this.future = HttpManager.this.backgroundExecutor.executeLater(this, delay);
                }
                if (this.timeoutTask != null) {
                    this.timeoutTask.cancel();
                    this.timeoutTask = null;
                }
                if (this.parentRequest.getTimeout() > 0) {
                    this.timeoutTask = new HttpRequestFetchTimeoutTask(HttpManager.this, this.parentRequest, null);
                    HttpManager.this.timeoutTimer.schedule(this.timeoutTask, this.parentRequest.getTimeout());
                }
            }
        }

        public synchronized void cancel() {
            if (!this.finished) {
                this.parentRequest.notifyCancelled();
                finish();
            }
        }

        public synchronized boolean timeout(HttpRequestFetchTimeoutTask originatingTask) {
            boolean z;
            if (originatingTask == this.timeoutTask) {
                if (!this.finished) {
                    finish();
                    this.finished = this.parentRequest.notifyTimeout();
                }
                z = this.finished;
            } else {
                z = false;
            }
            return z;
        }

        private synchronized void finish() {
            this.finished = true;
            if (this.timeoutTask != null) {
                this.timeoutTask.cancel();
                this.timeoutTask = null;
            }
            if (this.future != null) {
                this.future.cancel();
                this.future = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.parentRequest.notifyWillExecute();
            HttpManager.log.debug("Calling fetchReponse for parent " + this.parentRequest);
            HttpResponse response = this.parentRequest.fetchResponse();
            synchronized (this) {
                if (!this.finished) {
                    finish();
                    this.parentRequest.notifyResponse(response);
                }
            }
            HttpManager.this.requestWasRan(this.parentRequest);
        }

        @Override // com.vlingo.sdk.internal.util.ThreadPoolRunnable
        public boolean isHighPriority() {
            return this.background && this.highPriority;
        }

        @Override // com.vlingo.sdk.internal.util.ThreadPoolRunnable
        public boolean isOrdered() {
            return this.background && this.ordered;
        }

        @Override // com.vlingo.sdk.internal.util.ThreadPoolRunnable
        public synchronized boolean isRetry() {
            boolean z = true;
            synchronized (this) {
                if (this.finished || !this.parentRequest.isRetry()) {
                    z = false;
                } else if (this.background && this.waitTime > 0) {
                    schedule(this.waitTime * 2);
                    z = false;
                }
            }
            return z;
        }
    }

    private class HttpRequestFetchTimeoutTask extends TimerTask {
        private final HttpRequest request;

        private HttpRequestFetchTimeoutTask(HttpRequest request) {
            this.request = request;
        }

        /* synthetic */ HttpRequestFetchTimeoutTask(HttpManager httpManager, HttpRequest httpRequest, HttpRequestFetchTimeoutTask httpRequestFetchTimeoutTask) {
            this(httpRequest);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            HttpManager.this.requestHasTimedOut(this.request, this);
        }
    }
}
