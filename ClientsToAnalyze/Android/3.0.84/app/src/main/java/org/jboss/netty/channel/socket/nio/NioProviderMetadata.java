package org.jboss.netty.channel.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.util.internal.SystemPropertyUtil;

/* loaded from: classes.dex */
class NioProviderMetadata {
    static final int CONSTRAINT_LEVEL;
    private static final String CONSTRAINT_LEVEL_PROPERTY = "org.jboss.netty.channel.socket.nio.constraintLevel";
    private static final String OLD_CONSTRAINT_LEVEL_PROPERTY = "java.nio.channels.spi.constraintLevel";
    static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) NioProviderMetadata.class);

    static {
        int iDetectConstraintLevelFromSystemProperties = SystemPropertyUtil.get(CONSTRAINT_LEVEL_PROPERTY, -1);
        if (iDetectConstraintLevelFromSystemProperties < 0 || iDetectConstraintLevelFromSystemProperties > 2) {
            iDetectConstraintLevelFromSystemProperties = SystemPropertyUtil.get(OLD_CONSTRAINT_LEVEL_PROPERTY, -1);
            if (iDetectConstraintLevelFromSystemProperties < 0 || iDetectConstraintLevelFromSystemProperties > 2) {
                iDetectConstraintLevelFromSystemProperties = -1;
            } else {
                logger.warn("System property 'java.nio.channels.spi.constraintLevel' has been deprecated.  Use 'org.jboss.netty.channel.socket.nio.constraintLevel' instead.");
            }
        }
        if (iDetectConstraintLevelFromSystemProperties >= 0) {
            logger.debug("Setting the NIO constraint level to: " + iDetectConstraintLevelFromSystemProperties);
        }
        if (iDetectConstraintLevelFromSystemProperties < 0) {
            iDetectConstraintLevelFromSystemProperties = detectConstraintLevelFromSystemProperties();
            if (iDetectConstraintLevelFromSystemProperties < 0) {
                logger.debug("Couldn't determine the NIO constraint level from the system properties; using the safest level (2)");
                iDetectConstraintLevelFromSystemProperties = 2;
            } else if (iDetectConstraintLevelFromSystemProperties != 0) {
                logger.info("Using the autodetected NIO constraint level: " + iDetectConstraintLevelFromSystemProperties + " (Use better NIO provider for better performance)");
            } else {
                logger.debug("Using the autodetected NIO constraint level: " + iDetectConstraintLevelFromSystemProperties);
            }
        }
        CONSTRAINT_LEVEL = iDetectConstraintLevelFromSystemProperties;
        if (CONSTRAINT_LEVEL < 0 || CONSTRAINT_LEVEL > 2) {
            throw new Error("Unexpected NIO constraint level: " + CONSTRAINT_LEVEL + ", please report this error.");
        }
    }

    private static int detectConstraintLevelFromSystemProperties() {
        String name;
        String str = SystemPropertyUtil.get("java.specification.version");
        String str2 = SystemPropertyUtil.get("java.vm.info", "");
        String str3 = SystemPropertyUtil.get("os.name");
        String str4 = SystemPropertyUtil.get("java.vm.vendor");
        try {
            name = SelectorProvider.provider().getClass().getName();
        } catch (Exception e) {
            name = null;
        }
        if (str == null || str3 == null || str4 == null || name == null) {
            return -1;
        }
        String lowerCase = str3.toLowerCase();
        String lowerCase2 = str4.toLowerCase();
        if (lowerCase2.indexOf("sun") >= 0) {
            if (lowerCase.indexOf("linux") >= 0) {
                if (name.equals("sun.nio.ch.EPollSelectorProvider") || name.equals("sun.nio.ch.PollSelectorProvider")) {
                    return 0;
                }
            } else if (lowerCase.indexOf("windows") >= 0) {
                if (name.equals("sun.nio.ch.WindowsSelectorProvider")) {
                    return 0;
                }
            } else if ((lowerCase.indexOf("sun") >= 0 || lowerCase.indexOf("solaris") >= 0) && name.equals("sun.nio.ch.DevPollSelectorProvider")) {
                return 0;
            }
        } else if (lowerCase2.indexOf("apple") >= 0) {
            if (lowerCase.indexOf("mac") >= 0 && lowerCase.indexOf("os") >= 0 && name.equals("sun.nio.ch.KQueueSelectorProvider")) {
                return 0;
            }
        } else if (lowerCase2.indexOf("ibm") >= 0) {
            if (lowerCase.indexOf("linux") >= 0 || lowerCase.indexOf("aix") >= 0) {
                if (str.equals("1.5") || str.matches("^1\\.5\\D.*$")) {
                    if (name.equals("sun.nio.ch.PollSelectorProvider")) {
                        return 1;
                    }
                } else if (str.equals("1.6") || str.matches("^1\\.6\\D.*$")) {
                    Matcher matcher = Pattern.compile("(?:^|[^0-9])([2-9][0-9]{3}(?:0[1-9]|1[0-2])(?:0[1-9]|[12][0-9]|3[01]))(?:$|[^0-9])").matcher(str2);
                    if (matcher.find()) {
                        if (Long.parseLong(matcher.group(1)) < 20081105) {
                            return 2;
                        }
                        if (name.equals("sun.nio.ch.EPollSelectorProvider")) {
                            return 0;
                        }
                        if (name.equals("sun.nio.ch.PollSelectorProvider")) {
                            return 1;
                        }
                    }
                }
            }
        } else if (lowerCase2.indexOf("bea") >= 0 || lowerCase2.indexOf("oracle") >= 0) {
            if (lowerCase.indexOf("linux") >= 0) {
                if (name.equals("sun.nio.ch.EPollSelectorProvider") || name.equals("sun.nio.ch.PollSelectorProvider")) {
                    return 0;
                }
            } else if (lowerCase.indexOf("windows") >= 0 && name.equals("sun.nio.ch.WindowsSelectorProvider")) {
                return 0;
            }
        } else if (lowerCase2.indexOf("apache") >= 0 && name.equals("org.apache.harmony.nio.internal.SelectorProviderImpl")) {
            return 1;
        }
        return -1;
    }

    final class ConstraintLevelAutodetector {
        ConstraintLevelAutodetector() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v27, types: [java.net.ServerSocket] */
        /* JADX WARN: Type inference failed for: r2v20, types: [java.net.InetSocketAddress, java.net.SocketAddress] */
        /* JADX WARN: Type inference failed for: r3v0, types: [org.jboss.netty.channel.socket.nio.NioProviderMetadata$SelectorLoop] */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v14 */
        /* JADX WARN: Type inference failed for: r3v15 */
        /* JADX WARN: Type inference failed for: r3v17 */
        /* JADX WARN: Type inference failed for: r3v19, types: [java.nio.channels.SelectionKey] */
        /* JADX WARN: Type inference failed for: r3v20, types: [org.jboss.netty.logging.InternalLogger] */
        /* JADX WARN: Type inference failed for: r3v21 */
        /* JADX WARN: Type inference failed for: r3v22 */
        /* JADX WARN: Type inference failed for: r3v23 */
        /* JADX WARN: Type inference failed for: r3v25 */
        /* JADX WARN: Type inference failed for: r3v26 */
        /* JADX WARN: Type inference failed for: r3v27 */
        /* JADX WARN: Type inference failed for: r3v28 */
        /* JADX WARN: Type inference failed for: r3v29 */
        /* JADX WARN: Type inference failed for: r3v30 */
        /* JADX WARN: Type inference failed for: r3v31 */
        /* JADX WARN: Type inference failed for: r3v7 */
        /* JADX WARN: Type inference failed for: r3v9 */
        /* JADX WARN: Type inference failed for: r4v0 */
        /* JADX WARN: Type inference failed for: r4v10 */
        /* JADX WARN: Type inference failed for: r4v11 */
        /* JADX WARN: Type inference failed for: r4v12 */
        /* JADX WARN: Type inference failed for: r4v13 */
        /* JADX WARN: Type inference failed for: r4v14, types: [java.util.concurrent.TimeUnit] */
        /* JADX WARN: Type inference failed for: r4v15 */
        /* JADX WARN: Type inference failed for: r4v16 */
        /* JADX WARN: Type inference failed for: r4v18 */
        /* JADX WARN: Type inference failed for: r4v19 */
        /* JADX WARN: Type inference failed for: r4v20 */
        /* JADX WARN: Type inference failed for: r4v21 */
        /* JADX WARN: Type inference failed for: r4v22 */
        /* JADX WARN: Type inference failed for: r4v23, types: [java.util.concurrent.TimeUnit] */
        /* JADX WARN: Type inference failed for: r4v25 */
        /* JADX WARN: Type inference failed for: r4v26, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r4v27 */
        /* JADX WARN: Type inference failed for: r4v28 */
        /* JADX WARN: Type inference failed for: r4v29 */
        /* JADX WARN: Type inference failed for: r4v30 */
        /* JADX WARN: Type inference failed for: r4v31 */
        /* JADX WARN: Type inference failed for: r4v32 */
        /* JADX WARN: Type inference failed for: r4v33 */
        /* JADX WARN: Type inference failed for: r4v34 */
        /* JADX WARN: Type inference failed for: r4v35 */
        /* JADX WARN: Type inference failed for: r4v36 */
        /* JADX WARN: Type inference failed for: r4v4, types: [java.nio.channels.ServerSocketChannel] */
        /* JADX WARN: Type inference failed for: r4v6, types: [java.nio.channels.ServerSocketChannel] */
        /* JADX WARN: Type inference failed for: r4v7 */
        /* JADX WARN: Type inference failed for: r4v9 */
        /* JADX WARN: Type inference failed for: r7v0, types: [java.util.concurrent.ExecutorService] */
        int autodetect() throws Throwable {
            SelectorLoop selectorLoop;
            ?? Open;
            ServerSocketChannel serverSocketChannel;
            SelectorLoop selectorLoop2;
            InternalLogger internalLogger;
            String str;
            boolean z;
            int i = -1;
            boolean z2 = false;
            ?? NewCachedThreadPool = Executors.newCachedThreadPool();
            ?? KeyFor = 0;
            KeyFor = 0;
            try {
                try {
                    Open = ServerSocketChannel.open();
                    try {
                        try {
                            ?? Socket = Open.socket();
                            ?? inetSocketAddress = new InetSocketAddress(0);
                            Socket.bind(inetSocketAddress);
                            Open.configureBlocking(false);
                            try {
                                try {
                                    selectorLoop = new SelectorLoop();
                                    try {
                                        try {
                                            Open.register(selectorLoop.selector, 0);
                                            KeyFor = Open.keyFor(selectorLoop.selector);
                                            NewCachedThreadPool.execute(selectorLoop);
                                            int i2 = 0;
                                            while (true) {
                                                if (i2 >= 10) {
                                                    z = true;
                                                    break;
                                                }
                                                while (true) {
                                                    if (selectorLoop.selecting) {
                                                        try {
                                                            Thread.sleep(50L);
                                                        } catch (InterruptedException e) {
                                                        }
                                                        if (selectorLoop.selecting) {
                                                            break;
                                                        }
                                                    } else {
                                                        Thread.yield();
                                                    }
                                                }
                                                long jNanoTime = System.nanoTime();
                                                KeyFor.interestOps(KeyFor.interestOps() | 16);
                                                KeyFor.interestOps(KeyFor.interestOps() & (-17));
                                                if (System.nanoTime() - jNanoTime >= 500000000) {
                                                    z = false;
                                                    break;
                                                }
                                                i2++;
                                            }
                                            if (z) {
                                                i = 0;
                                            } else {
                                                int i3 = 0;
                                                while (true) {
                                                    if (i3 >= 10) {
                                                        z2 = true;
                                                        break;
                                                    }
                                                    while (true) {
                                                        if (selectorLoop.selecting) {
                                                            try {
                                                                Thread.sleep(50L);
                                                            } catch (InterruptedException e2) {
                                                            }
                                                            if (selectorLoop.selecting) {
                                                                break;
                                                            }
                                                        } else {
                                                            Thread.yield();
                                                        }
                                                    }
                                                    long jNanoTime2 = System.nanoTime();
                                                    int iInterestOps = KeyFor.interestOps();
                                                    synchronized (selectorLoop) {
                                                        selectorLoop.selector.wakeup();
                                                        KeyFor.interestOps(iInterestOps | 16);
                                                        KeyFor.interestOps(iInterestOps & (-17));
                                                    }
                                                    if (System.nanoTime() - jNanoTime2 >= 500000000) {
                                                        break;
                                                    }
                                                    i3++;
                                                }
                                                i = z2 ? 1 : 2;
                                            }
                                            if (Open != 0) {
                                                try {
                                                    Open.close();
                                                } catch (Throwable th) {
                                                    KeyFor = NioProviderMetadata.logger;
                                                    Open = "Failed to close a temporary socket.";
                                                    KeyFor.warn("Failed to close a temporary socket.", th);
                                                }
                                            }
                                            if (selectorLoop != null) {
                                                selectorLoop.done = true;
                                                try {
                                                    NewCachedThreadPool.shutdownNow();
                                                } catch (NullPointerException e3) {
                                                }
                                                while (true) {
                                                    try {
                                                        selectorLoop.selector.wakeup();
                                                        KeyFor = 1;
                                                        KeyFor = 1;
                                                        if (!NewCachedThreadPool.awaitTermination(1L, TimeUnit.SECONDS)) {
                                                        }
                                                    } catch (Throwable th2) {
                                                    }
                                                    try {
                                                        break;
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        internalLogger = NioProviderMetadata.logger;
                                                        str = "Failed to close a temporary selector.";
                                                        internalLogger.warn(str, th);
                                                        return i;
                                                    }
                                                }
                                                selectorLoop.selector.close();
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            if (Open != 0) {
                                                try {
                                                    Open.close();
                                                } catch (Throwable th5) {
                                                    NioProviderMetadata.logger.warn("Failed to close a temporary socket.", th5);
                                                }
                                            }
                                            if (selectorLoop != null) {
                                                selectorLoop.done = true;
                                                try {
                                                    NewCachedThreadPool.shutdownNow();
                                                } catch (NullPointerException e4) {
                                                }
                                                while (true) {
                                                    try {
                                                        selectorLoop.selector.wakeup();
                                                        if (!NewCachedThreadPool.awaitTermination(1L, TimeUnit.SECONDS)) {
                                                        }
                                                    } catch (Throwable th6) {
                                                    }
                                                    try {
                                                        break;
                                                    } catch (Throwable th7) {
                                                        NioProviderMetadata.logger.warn("Failed to close a temporary selector.", th7);
                                                    }
                                                }
                                                selectorLoop.selector.close();
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th8) {
                                        InternalLogger internalLogger2 = NioProviderMetadata.logger;
                                        internalLogger2.warn("Failed to register a temporary selector.", th8);
                                        KeyFor = internalLogger2;
                                        Open = Open;
                                        if (Open != 0) {
                                            try {
                                                Open.close();
                                                KeyFor = internalLogger2;
                                                Open = Open;
                                            } catch (Throwable th9) {
                                                InternalLogger internalLogger3 = NioProviderMetadata.logger;
                                                internalLogger3.warn("Failed to close a temporary socket.", th9);
                                                KeyFor = internalLogger3;
                                                Open = "Failed to close a temporary socket.";
                                            }
                                        }
                                        if (selectorLoop != null) {
                                            selectorLoop.done = true;
                                            try {
                                                NewCachedThreadPool.shutdownNow();
                                            } catch (NullPointerException e5) {
                                            }
                                            while (true) {
                                                try {
                                                    selectorLoop.selector.wakeup();
                                                    KeyFor = 1;
                                                    KeyFor = 1;
                                                    if (!NewCachedThreadPool.awaitTermination(1L, TimeUnit.SECONDS)) {
                                                    }
                                                } catch (Throwable th10) {
                                                }
                                                try {
                                                    break;
                                                } catch (Throwable th11) {
                                                    th = th11;
                                                    internalLogger = NioProviderMetadata.logger;
                                                    str = "Failed to close a temporary selector.";
                                                    internalLogger.warn(str, th);
                                                    return i;
                                                }
                                            }
                                            selectorLoop.selector.close();
                                        }
                                    }
                                } catch (Throwable th12) {
                                    selectorLoop2 = inetSocketAddress;
                                    serverSocketChannel = Open;
                                    if (serverSocketChannel != null) {
                                        try {
                                            serverSocketChannel.close();
                                        } catch (Throwable th13) {
                                            NioProviderMetadata.logger.warn("Failed to close a temporary socket.", th13);
                                        }
                                    }
                                    if (selectorLoop2 != null) {
                                        selectorLoop2.done = true;
                                        try {
                                            NewCachedThreadPool.shutdownNow();
                                        } catch (NullPointerException e6) {
                                        }
                                        while (true) {
                                            try {
                                                selectorLoop2.selector.wakeup();
                                                if (!NewCachedThreadPool.awaitTermination(1L, TimeUnit.SECONDS)) {
                                                }
                                            } catch (Throwable th14) {
                                            }
                                            try {
                                                break;
                                            } catch (Throwable th15) {
                                                th = th15;
                                                internalLogger = NioProviderMetadata.logger;
                                                str = "Failed to close a temporary selector.";
                                                internalLogger.warn(str, th);
                                                return i;
                                            }
                                        }
                                        selectorLoop2.selector.close();
                                    }
                                    return i;
                                }
                            } catch (Throwable th16) {
                                NioProviderMetadata.logger.warn("Failed to open a temporary selector.", th16);
                                Open = Open;
                                if (Open != 0) {
                                    try {
                                        Open.close();
                                        Open = Open;
                                    } catch (Throwable th17) {
                                        NioProviderMetadata.logger.warn("Failed to close a temporary socket.", th17);
                                        Open = "Failed to close a temporary socket.";
                                    }
                                }
                                if (0 != 0) {
                                    KeyFor.done = true;
                                    try {
                                        NewCachedThreadPool.shutdownNow();
                                    } catch (NullPointerException e7) {
                                    }
                                    while (true) {
                                        try {
                                            KeyFor.selector.wakeup();
                                            try {
                                                Open = TimeUnit.SECONDS;
                                            } catch (InterruptedException e8) {
                                            }
                                            if (!NewCachedThreadPool.awaitTermination(1L, Open)) {
                                            }
                                        } catch (Throwable th18) {
                                        }
                                        try {
                                            break;
                                        } catch (Throwable th19) {
                                            th = th19;
                                            internalLogger = NioProviderMetadata.logger;
                                            str = "Failed to close a temporary selector.";
                                            internalLogger.warn(str, th);
                                            return i;
                                        }
                                    }
                                    KeyFor.selector.close();
                                }
                                return i;
                            }
                        } catch (Throwable th20) {
                            th = th20;
                            selectorLoop = KeyFor;
                        }
                    } catch (Throwable th21) {
                        NioProviderMetadata.logger.warn("Failed to configure a temporary socket.", th21);
                        Open = Open;
                        if (Open != 0) {
                            try {
                                Open.close();
                                Open = Open;
                            } catch (Throwable th22) {
                                NioProviderMetadata.logger.warn("Failed to close a temporary socket.", th22);
                                Open = "Failed to close a temporary socket.";
                            }
                        }
                        if (0 != 0) {
                            KeyFor.done = true;
                            try {
                                NewCachedThreadPool.shutdownNow();
                            } catch (NullPointerException e9) {
                            }
                            while (true) {
                                try {
                                    KeyFor.selector.wakeup();
                                    try {
                                        Open = TimeUnit.SECONDS;
                                    } catch (InterruptedException e10) {
                                    }
                                    if (!NewCachedThreadPool.awaitTermination(1L, Open)) {
                                    }
                                } catch (Throwable th23) {
                                }
                                try {
                                    break;
                                } catch (Throwable th24) {
                                    th = th24;
                                    internalLogger = NioProviderMetadata.logger;
                                    str = "Failed to close a temporary selector.";
                                    internalLogger.warn(str, th);
                                    return i;
                                }
                            }
                            KeyFor.selector.close();
                        }
                    }
                } catch (Throwable th25) {
                    th = th25;
                    selectorLoop = null;
                    Open = 0;
                }
            } catch (Throwable th26) {
                selectorLoop2 = null;
                serverSocketChannel = Open;
            }
            return i;
        }
    }

    final class SelectorLoop implements Runnable {
        volatile boolean done;
        volatile boolean selecting;
        final Selector selector = Selector.open();

        SelectorLoop() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!this.done) {
                synchronized (this) {
                }
                try {
                    this.selecting = true;
                    try {
                        this.selector.select(1000L);
                        this.selecting = false;
                        Set<SelectionKey> setSelectedKeys = this.selector.selectedKeys();
                        Iterator<SelectionKey> it = setSelectedKeys.iterator();
                        while (it.hasNext()) {
                            it.next().interestOps(0);
                        }
                        setSelectedKeys.clear();
                    } catch (Throwable th) {
                        this.selecting = false;
                        throw th;
                    }
                } catch (IOException e) {
                    NioProviderMetadata.logger.warn("Failed to wait for a temporary selector.", e);
                }
            }
        }
    }

    public static void main(String[] strArr) {
        for (Map.Entry entry : System.getProperties().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
        System.out.println("Hard-coded Constraint Level: " + CONSTRAINT_LEVEL);
        System.out.println("Auto-detected Constraint Level: " + new ConstraintLevelAutodetector().autodetect());
    }

    private NioProviderMetadata() {
    }
}
