package android.support.v4.net;

import android.os.Build;
import java.net.Socket;
import java.net.SocketException;

/* loaded from: classes.dex */
public class TrafficStatsCompat {
    private static final TrafficStatsCompatImpl IMPL;

    interface TrafficStatsCompatImpl {
        void clearThreadStatsTag();

        int getThreadStatsTag();

        void incrementOperationCount(int i);

        void incrementOperationCount(int i, int i2);

        void setThreadStatsTag(int i);

        void tagSocket(Socket socket);

        void untagSocket(Socket socket);
    }

    class BaseTrafficStatsCompatImpl implements TrafficStatsCompatImpl {
        private ThreadLocal<SocketTags> mThreadSocketTags = new ThreadLocal<SocketTags>() { // from class: android.support.v4.net.TrafficStatsCompat.BaseTrafficStatsCompatImpl.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.lang.ThreadLocal
            public SocketTags initialValue() {
                return new SocketTags();
            }
        };

        class SocketTags {
            public int statsTag;

            private SocketTags() {
                this.statsTag = -1;
            }
        }

        BaseTrafficStatsCompatImpl() {
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void clearThreadStatsTag() {
            this.mThreadSocketTags.get().statsTag = -1;
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public int getThreadStatsTag() {
            return this.mThreadSocketTags.get().statsTag;
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void incrementOperationCount(int i) {
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void incrementOperationCount(int i, int i2) {
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void setThreadStatsTag(int i) {
            this.mThreadSocketTags.get().statsTag = i;
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void tagSocket(Socket socket) {
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void untagSocket(Socket socket) {
        }
    }

    class IcsTrafficStatsCompatImpl implements TrafficStatsCompatImpl {
        IcsTrafficStatsCompatImpl() {
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void clearThreadStatsTag() {
            TrafficStatsCompatIcs.clearThreadStatsTag();
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public int getThreadStatsTag() {
            return TrafficStatsCompatIcs.getThreadStatsTag();
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void incrementOperationCount(int i) {
            TrafficStatsCompatIcs.incrementOperationCount(i);
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void incrementOperationCount(int i, int i2) {
            TrafficStatsCompatIcs.incrementOperationCount(i, i2);
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void setThreadStatsTag(int i) {
            TrafficStatsCompatIcs.setThreadStatsTag(i);
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void tagSocket(Socket socket) throws SocketException {
            TrafficStatsCompatIcs.tagSocket(socket);
        }

        @Override // android.support.v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void untagSocket(Socket socket) throws SocketException {
            TrafficStatsCompatIcs.untagSocket(socket);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new IcsTrafficStatsCompatImpl();
        } else {
            IMPL = new BaseTrafficStatsCompatImpl();
        }
    }

    public static void clearThreadStatsTag() {
        IMPL.clearThreadStatsTag();
    }

    public static int getThreadStatsTag() {
        return IMPL.getThreadStatsTag();
    }

    public static void incrementOperationCount(int i) {
        IMPL.incrementOperationCount(i);
    }

    public static void incrementOperationCount(int i, int i2) {
        IMPL.incrementOperationCount(i, i2);
    }

    public static void setThreadStatsTag(int i) {
        IMPL.setThreadStatsTag(i);
    }

    public static void tagSocket(Socket socket) {
        IMPL.tagSocket(socket);
    }

    public static void untagSocket(Socket socket) {
        IMPL.untagSocket(socket);
    }
}
