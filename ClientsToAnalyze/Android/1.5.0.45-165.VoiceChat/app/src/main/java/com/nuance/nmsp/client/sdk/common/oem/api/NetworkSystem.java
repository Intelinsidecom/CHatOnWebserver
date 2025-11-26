package com.nuance.nmsp.client.sdk.common.oem.api;

import java.util.Vector;

/* loaded from: classes.dex */
public interface NetworkSystem {

    public interface CloseSocketCallback {
        void closeSocketCallback(NetworkStatus networkStatus, Object obj, Object obj2);
    }

    public static class NetworkReadMode {
        public static final NetworkReadMode NETWORK_READ_PARTIAL = new NetworkReadMode();
        public static final NetworkReadMode NETWORK_READ_FULL = new NetworkReadMode();

        private NetworkReadMode() {
        }
    }

    public static class NetworkStatus {
        public static final NetworkStatus NETWORK_OK = new NetworkStatus();
        public static final NetworkStatus NETWORK_ERROR = new NetworkStatus();
        public static final NetworkStatus NETWORK_MEMORY_ERROR = new NetworkStatus();

        private NetworkStatus() {
        }
    }

    public interface OpenSocketCallback {
        void openSocketCallback(NetworkStatus networkStatus, Object obj, Object obj2);
    }

    public interface ReadSocketCallback {
        void readSocketCallback(NetworkStatus networkStatus, Object obj, byte[] bArr, int i, int i2, int i3, Object obj2);
    }

    public interface WriteSocketCallback {
        void writeSocketCallback(NetworkStatus networkStatus, Object obj, byte[] bArr, int i, int i2, int i3, Object obj2);
    }

    void clearPendingOps(Object obj);

    void closeSocket(Object obj);

    boolean isNetworkHealthy();

    void openSSLSocket(String str, int i, Vector vector, OpenSocketCallback openSocketCallback, CloseSocketCallback closeSocketCallback, Object obj);

    void openSocket(String str, int i, OpenSocketCallback openSocketCallback, CloseSocketCallback closeSocketCallback, Object obj);

    void setSessionId(Object obj, byte[] bArr);

    NetworkStatus socketRead(Object obj, NetworkReadMode networkReadMode, byte[] bArr, int i, int i2, ReadSocketCallback readSocketCallback, Object obj2);

    NetworkStatus socketWrite(Object obj, byte[] bArr, int i, int i2, WriteSocketCallback writeSocketCallback, Object obj2);
}
