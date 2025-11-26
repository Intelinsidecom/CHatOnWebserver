package com.vlingo.sdk.internal.http.custom;

import com.vlingo.sdk.internal.http.URL;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.recognizer.Queue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class MultiplexHttpConnection extends VHttpConnection {
    private static Logger log = Logger.getLogger(MultiplexHttpConnection.class);
    private HttpRequest ivActiveRequest;
    private HttpResponse ivActiveResponse;
    private DataInputStream ivIn;
    private DataOutputStream ivOut;
    private Queue ivRequestQueue;
    private Queue ivResponseQueue;

    public MultiplexHttpConnection(URL url) {
        super(url);
        this.ivRequestQueue = new Queue();
        this.ivResponseQueue = new Queue();
    }

    @Override // com.vlingo.sdk.internal.http.custom.VHttpConnection
    public DataInputStream getInputStream(HttpResponse response) throws IOException {
        synchronized (this) {
            if (this.ivIn == null) {
                this.ivIn = this.ivCon.getInputStream();
            }
        }
        return new MultiplexInputStream(this.ivIn, response);
    }

    @Override // com.vlingo.sdk.internal.http.custom.VHttpConnection
    public DataOutputStream getOutputStream(HttpRequest request) throws IOException {
        synchronized (this) {
            if (this.ivOut == null) {
                this.ivOut = this.ivCon.getOutputStream();
            }
        }
        return new MultiplexOutputStream(this.ivOut, request);
    }

    @Override // com.vlingo.sdk.internal.http.custom.VHttpConnection
    public synchronized HttpInteraction openInteraction(String path) throws IOException {
        HttpInteraction dhi;
        dhi = new HttpInteraction(this);
        dhi.getRequest().setPath(path);
        this.ivRequestQueue.add(dhi.getRequest());
        this.ivResponseQueue.add(dhi.getResponse());
        return dhi;
    }

    @Override // com.vlingo.sdk.internal.http.custom.VHttpConnection
    void notifyRequestDone(HttpRequest request) throws IOException {
        synchronized (this.ivOut) {
            if (this.ivActiveRequest != request) {
                throw new IOException("HTTP requests finished out of order");
            }
            log.debug("request " + request + " done");
            assignWriteLock();
        }
    }

    @Override // com.vlingo.sdk.internal.http.custom.VHttpConnection
    void notifyResponseDone(HttpResponse response) throws IOException {
        synchronized (this.ivIn) {
            if (this.ivActiveResponse != response) {
                throw new IOException("HTTP responses finished out of order");
            }
            log.debug("response " + response + " done");
            assignReadLock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int read(HttpResponse response) throws IOException {
        getReadLock(response);
        return this.ivIn.read();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void write(HttpRequest request, byte[] b, int off, int len) throws IOException {
        getWriteLock(request);
        this.ivOut.write(b, off, len);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void write(HttpRequest request, byte[] b) throws IOException {
        getWriteLock(request);
        this.ivOut.write(b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void write(HttpRequest request, int b) throws IOException {
        getWriteLock(request);
        this.ivOut.write(b);
    }

    private void assignReadLock() {
        synchronized (this.ivIn) {
            HttpResponse nextResponse = (HttpResponse) this.ivResponseQueue.pop();
            this.ivActiveResponse = nextResponse;
            log.debug("assigning read lock to " + this.ivActiveResponse);
            this.ivIn.notifyAll();
        }
    }

    private void getReadLock(HttpResponse response) {
        while (this.ivActiveResponse != response) {
            synchronized (this.ivIn) {
                if (this.ivActiveResponse == null) {
                    assignReadLock();
                }
                if (this.ivActiveResponse != response) {
                    log.debug("response " + response + " waiting for read lock (held by " + this.ivActiveResponse + ")");
                    try {
                        this.ivIn.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }

    private void assignWriteLock() {
        synchronized (this.ivOut) {
            HttpRequest nextRequest = (HttpRequest) this.ivRequestQueue.pop();
            this.ivActiveRequest = nextRequest;
            log.debug("assigned write lock to " + this.ivActiveRequest);
            this.ivOut.notifyAll();
        }
    }

    private void getWriteLock(HttpRequest request) throws IOException {
        while (this.ivActiveRequest != request) {
            synchronized (this.ivOut) {
                if (this.ivActiveRequest == null) {
                    assignWriteLock();
                }
                if (this.ivActiveRequest != request) {
                    log.debug("request " + request + " waiting for write lock (held by " + this.ivActiveRequest + ")");
                    try {
                        this.ivOut.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }

    private class MultiplexInputStream extends DataInputStream {
        private HttpResponse ivResponse;

        MultiplexInputStream(InputStream in, HttpResponse response) {
            super(in);
            this.ivResponse = response;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            return MultiplexHttpConnection.this.read(this.ivResponse);
        }
    }

    private class MultiplexOutputStream extends DataOutputStream {
        private HttpRequest ivRequest;

        MultiplexOutputStream(OutputStream out, HttpRequest request) {
            super(out);
            this.ivRequest = request;
        }

        @Override // java.io.DataOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.DataOutput
        public void write(byte[] b, int off, int len) throws IOException {
            MultiplexHttpConnection.this.write(this.ivRequest, b, off, len);
        }

        @Override // java.io.DataOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.DataOutput
        public void write(int b) throws IOException {
            MultiplexHttpConnection.this.write(this.ivRequest, b);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.DataOutput
        public void write(byte[] b) throws IOException {
            MultiplexHttpConnection.this.write(this.ivRequest, b);
        }
    }
}
