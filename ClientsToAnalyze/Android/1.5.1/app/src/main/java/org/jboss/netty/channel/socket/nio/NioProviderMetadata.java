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
import java.util.concurrent.ExecutorService;
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
    static final InternalLogger logger = InternalLoggerFactory.getInstance(NioProviderMetadata.class);

    final class ConstraintLevelAutodetector {
        ConstraintLevelAutodetector() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.concurrent.ExecutorService] */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v16 */
        /* JADX WARN: Type inference failed for: r0v17, types: [int] */
        /* JADX WARN: Type inference failed for: r0v18 */
        /* JADX WARN: Type inference failed for: r0v22 */
        /* JADX WARN: Type inference failed for: r0v26 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v10, types: [java.nio.channels.ServerSocketChannel] */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16, types: [java.lang.NullPointerException] */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v20 */
        /* JADX WARN: Type inference failed for: r1v21, types: [org.jboss.netty.logging.InternalLogger] */
        /* JADX WARN: Type inference failed for: r1v22, types: [java.nio.channels.Selector] */
        /* JADX WARN: Type inference failed for: r1v23, types: [java.lang.InterruptedException] */
        /* JADX WARN: Type inference failed for: r1v24 */
        /* JADX WARN: Type inference failed for: r1v26, types: [boolean] */
        /* JADX WARN: Type inference failed for: r1v27 */
        /* JADX WARN: Type inference failed for: r1v28 */
        /* JADX WARN: Type inference failed for: r1v32 */
        /* JADX WARN: Type inference failed for: r1v33 */
        /* JADX WARN: Type inference failed for: r1v34, types: [java.lang.NullPointerException] */
        /* JADX WARN: Type inference failed for: r1v35 */
        /* JADX WARN: Type inference failed for: r1v36 */
        /* JADX WARN: Type inference failed for: r1v37 */
        /* JADX WARN: Type inference failed for: r1v38 */
        /* JADX WARN: Type inference failed for: r1v39, types: [org.jboss.netty.logging.InternalLogger] */
        /* JADX WARN: Type inference failed for: r1v40, types: [java.nio.channels.Selector] */
        /* JADX WARN: Type inference failed for: r1v41, types: [java.lang.InterruptedException] */
        /* JADX WARN: Type inference failed for: r1v42 */
        /* JADX WARN: Type inference failed for: r1v44, types: [boolean] */
        /* JADX WARN: Type inference failed for: r1v46 */
        /* JADX WARN: Type inference failed for: r1v47 */
        /* JADX WARN: Type inference failed for: r1v48, types: [java.lang.NullPointerException] */
        /* JADX WARN: Type inference failed for: r1v49 */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v50 */
        /* JADX WARN: Type inference failed for: r1v51 */
        /* JADX WARN: Type inference failed for: r1v52 */
        /* JADX WARN: Type inference failed for: r1v53, types: [org.jboss.netty.logging.InternalLogger] */
        /* JADX WARN: Type inference failed for: r1v54, types: [java.nio.channels.Selector] */
        /* JADX WARN: Type inference failed for: r1v56, types: [java.lang.InterruptedException] */
        /* JADX WARN: Type inference failed for: r1v57 */
        /* JADX WARN: Type inference failed for: r1v58, types: [boolean] */
        /* JADX WARN: Type inference failed for: r1v59, types: [java.lang.Throwable] */
        /* JADX WARN: Type inference failed for: r1v60 */
        /* JADX WARN: Type inference failed for: r1v61 */
        /* JADX WARN: Type inference failed for: r1v62, types: [java.lang.NullPointerException] */
        /* JADX WARN: Type inference failed for: r1v63 */
        /* JADX WARN: Type inference failed for: r1v64 */
        /* JADX WARN: Type inference failed for: r1v65 */
        /* JADX WARN: Type inference failed for: r1v66 */
        /* JADX WARN: Type inference failed for: r1v67, types: [org.jboss.netty.logging.InternalLogger] */
        /* JADX WARN: Type inference failed for: r1v68, types: [java.nio.channels.Selector] */
        /* JADX WARN: Type inference failed for: r1v69, types: [java.lang.InterruptedException] */
        /* JADX WARN: Type inference failed for: r1v70 */
        /* JADX WARN: Type inference failed for: r1v72, types: [boolean] */
        /* JADX WARN: Type inference failed for: r1v73 */
        /* JADX WARN: Type inference failed for: r1v74 */
        /* JADX WARN: Type inference failed for: r1v75 */
        /* JADX WARN: Type inference failed for: r1v76 */
        /* JADX WARN: Type inference failed for: r1v77 */
        /* JADX WARN: Type inference failed for: r1v78 */
        /* JADX WARN: Type inference failed for: r1v79 */
        /* JADX WARN: Type inference failed for: r1v80 */
        /* JADX WARN: Type inference failed for: r1v81 */
        /* JADX WARN: Type inference failed for: r1v82 */
        /* JADX WARN: Type inference failed for: r1v83 */
        /* JADX WARN: Type inference failed for: r2v0, types: [org.jboss.netty.channel.socket.nio.NioProviderMetadata$SelectorLoop] */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v18 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v27 */
        /* JADX WARN: Type inference failed for: r2v28 */
        /* JADX WARN: Type inference failed for: r2v29, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v35 */
        /* JADX WARN: Type inference failed for: r2v36 */
        /* JADX WARN: Type inference failed for: r2v39 */
        /* JADX WARN: Type inference failed for: r2v40 */
        /* JADX WARN: Type inference failed for: r2v42 */
        /* JADX WARN: Type inference failed for: r2v47 */
        /* JADX WARN: Type inference failed for: r2v48 */
        /* JADX WARN: Type inference failed for: r2v49 */
        /* JADX WARN: Type inference failed for: r2v50 */
        /* JADX WARN: Type inference failed for: r2v51 */
        /* JADX WARN: Type inference failed for: r4v19, types: [org.jboss.netty.logging.InternalLogger] */
        int autodetect() throws Throwable {
            ServerSocketChannel serverSocketChannel;
            SelectorLoop selectorLoop;
            ServerSocketChannel serverSocketChannel2;
            Throwable th;
            ExecutorService executorService;
            ExecutorService executorService2;
            boolean z;
            boolean z2;
            ?? NewCachedThreadPool = Executors.newCachedThreadPool();
            ?? e = 0;
            ?? r2 = 0;
            str = null;
            String str = null;
            str = null;
            String str2 = null;
            r2 = 0;
            SelectorLoop selectorLoop2 = null;
            try {
                try {
                    e = ServerSocketChannel.open();
                    try {
                        try {
                            e.socket().bind(new InetSocketAddress(0));
                            e.configureBlocking(false);
                            try {
                                try {
                                    try {
                                        SelectorLoop selectorLoop3 = new SelectorLoop();
                                        try {
                                            e.register(selectorLoop3.selector, 0);
                                            SelectionKey selectionKeyKeyFor = e.keyFor(selectorLoop3.selector);
                                            NewCachedThreadPool.execute(selectorLoop3);
                                            int i = 0;
                                            while (true) {
                                                if (i >= 10) {
                                                    z = true;
                                                    break;
                                                }
                                                while (true) {
                                                    if (selectorLoop3.selecting) {
                                                        try {
                                                            Thread.sleep(50L);
                                                        } catch (InterruptedException e2) {
                                                        }
                                                        if (selectorLoop3.selecting) {
                                                            break;
                                                        }
                                                    } else {
                                                        Thread.yield();
                                                    }
                                                }
                                                long jNanoTime = System.nanoTime();
                                                selectionKeyKeyFor.interestOps(selectionKeyKeyFor.interestOps() | 16);
                                                selectionKeyKeyFor.interestOps(selectionKeyKeyFor.interestOps() & (-17));
                                                if (System.nanoTime() - jNanoTime >= 500000000) {
                                                    z = false;
                                                    break;
                                                }
                                                i++;
                                            }
                                            if (z) {
                                                r2 = 0;
                                            } else {
                                                int i2 = 0;
                                                while (true) {
                                                    if (i2 >= 10) {
                                                        z2 = true;
                                                        break;
                                                    }
                                                    while (true) {
                                                        if (selectorLoop3.selecting) {
                                                            try {
                                                                Thread.sleep(50L);
                                                            } catch (InterruptedException e3) {
                                                            }
                                                            if (selectorLoop3.selecting) {
                                                                break;
                                                            }
                                                        } else {
                                                            Thread.yield();
                                                        }
                                                    }
                                                    long jNanoTime2 = System.nanoTime();
                                                    int iInterestOps = selectionKeyKeyFor.interestOps();
                                                    synchronized (selectorLoop3) {
                                                        selectorLoop3.selector.wakeup();
                                                        selectionKeyKeyFor.interestOps(iInterestOps | 16);
                                                        selectionKeyKeyFor.interestOps(iInterestOps & (-17));
                                                    }
                                                    if (System.nanoTime() - jNanoTime2 >= 500000000) {
                                                        z2 = false;
                                                        break;
                                                    }
                                                    i2++;
                                                }
                                                r2 = z2 ? 1 : 2;
                                            }
                                            if (e != 0) {
                                                try {
                                                    e.close();
                                                } catch (Throwable th2) {
                                                    e = th2;
                                                    NioProviderMetadata.logger.warn("Failed to close a temporary socket.", e);
                                                }
                                            }
                                            if (selectorLoop3 != null) {
                                                selectorLoop3.done = true;
                                                try {
                                                    NewCachedThreadPool.shutdownNow();
                                                } catch (NullPointerException e4) {
                                                    e = e4;
                                                }
                                                while (true) {
                                                    try {
                                                        e = selectorLoop3.selector;
                                                        e.wakeup();
                                                        try {
                                                            e = NewCachedThreadPool.awaitTermination(1L, TimeUnit.SECONDS);
                                                        } catch (InterruptedException e5) {
                                                            e = e5;
                                                        }
                                                        if (e == 0) {
                                                        }
                                                    } catch (Throwable th3) {
                                                    }
                                                    try {
                                                        break;
                                                    } catch (Throwable th4) {
                                                        e = NioProviderMetadata.logger;
                                                        e.warn("Failed to close a temporary selector.", th4);
                                                    }
                                                }
                                                selectorLoop3.selector.close();
                                            }
                                            NewCachedThreadPool = r2;
                                        } catch (Throwable th5) {
                                            NioProviderMetadata.logger.warn("Failed to register a temporary selector.", th5);
                                            e = e;
                                            r2 = th5;
                                            if (e != 0) {
                                                try {
                                                    e.close();
                                                    e = e;
                                                    r2 = th5;
                                                } catch (Throwable th6) {
                                                    InternalLogger internalLogger = NioProviderMetadata.logger;
                                                    internalLogger.warn("Failed to close a temporary socket.", th6);
                                                    e = th6;
                                                    r2 = internalLogger;
                                                }
                                            }
                                            if (selectorLoop3 != null) {
                                                selectorLoop3.done = true;
                                                try {
                                                    NewCachedThreadPool.shutdownNow();
                                                } catch (NullPointerException e6) {
                                                    e = e6;
                                                }
                                                while (true) {
                                                    try {
                                                        e = selectorLoop3.selector;
                                                        e.wakeup();
                                                        try {
                                                            e = NewCachedThreadPool.awaitTermination(1L, TimeUnit.SECONDS);
                                                        } catch (InterruptedException e7) {
                                                            e = e7;
                                                        }
                                                        if (e == 0) {
                                                        }
                                                    } catch (Throwable th7) {
                                                    }
                                                    try {
                                                        break;
                                                    } catch (Throwable th8) {
                                                        e = NioProviderMetadata.logger;
                                                        r2 = "Failed to close a temporary selector.";
                                                        e.warn("Failed to close a temporary selector.", th8);
                                                    }
                                                }
                                                selectorLoop3.selector.close();
                                            }
                                            NewCachedThreadPool = -1;
                                        }
                                    } catch (Throwable th9) {
                                        selectorLoop2 = null;
                                        serverSocketChannel2 = e;
                                        th = th9;
                                        executorService = NewCachedThreadPool;
                                        if (serverSocketChannel2 != null) {
                                            try {
                                                serverSocketChannel2.close();
                                            } catch (Throwable th10) {
                                                NioProviderMetadata.logger.warn("Failed to close a temporary socket.", th10);
                                            }
                                        }
                                        if (selectorLoop2 == null) {
                                            throw th;
                                        }
                                        selectorLoop2.done = true;
                                        try {
                                            executorService.shutdownNow();
                                        } catch (NullPointerException e8) {
                                        }
                                        while (true) {
                                            try {
                                                selectorLoop2.selector.wakeup();
                                                if (!executorService.awaitTermination(1L, TimeUnit.SECONDS)) {
                                                }
                                            } catch (Throwable th11) {
                                            }
                                            try {
                                                selectorLoop2.selector.close();
                                                throw th;
                                            } catch (Throwable th12) {
                                                NioProviderMetadata.logger.warn("Failed to close a temporary selector.", th12);
                                                throw th;
                                            }
                                        }
                                    }
                                } catch (Throwable th13) {
                                    serverSocketChannel = e;
                                    selectorLoop = null;
                                    executorService2 = NewCachedThreadPool;
                                    if (serverSocketChannel != null) {
                                        try {
                                            serverSocketChannel.close();
                                        } catch (Throwable th14) {
                                            NioProviderMetadata.logger.warn("Failed to close a temporary socket.", th14);
                                        }
                                    }
                                    if (selectorLoop != null) {
                                        selectorLoop.done = true;
                                        try {
                                            executorService2.shutdownNow();
                                        } catch (NullPointerException e9) {
                                        }
                                        while (true) {
                                            try {
                                                selectorLoop.selector.wakeup();
                                                if (!executorService2.awaitTermination(1L, TimeUnit.SECONDS)) {
                                                }
                                            } catch (Throwable th15) {
                                            }
                                            try {
                                                break;
                                            } catch (Throwable th16) {
                                                NioProviderMetadata.logger.warn("Failed to close a temporary selector.", th16);
                                            }
                                        }
                                        selectorLoop.selector.close();
                                    }
                                    return -1;
                                }
                            } catch (Throwable th17) {
                                NioProviderMetadata.logger.warn("Failed to open a temporary selector.", th17);
                                ?? e10 = e;
                                if (e != 0) {
                                    try {
                                        e.close();
                                        e10 = e;
                                    } catch (Throwable th18) {
                                        NioProviderMetadata.logger.warn("Failed to close a temporary socket.", th18);
                                        e10 = th18;
                                    }
                                }
                                if (0 != 0) {
                                    r2.done = true;
                                    try {
                                        NewCachedThreadPool.shutdownNow();
                                    } catch (NullPointerException e11) {
                                        e10 = e11;
                                    }
                                    while (true) {
                                        try {
                                            e10 = r2.selector;
                                            e10.wakeup();
                                            try {
                                                e10 = NewCachedThreadPool.awaitTermination(1L, TimeUnit.SECONDS);
                                            } catch (InterruptedException e12) {
                                                e10 = e12;
                                            }
                                            if (e10 == 0) {
                                            }
                                        } catch (Throwable th19) {
                                        }
                                        try {
                                            break;
                                        } catch (Throwable th20) {
                                            e10 = NioProviderMetadata.logger;
                                            str = "Failed to close a temporary selector.";
                                            e10.warn("Failed to close a temporary selector.", th20);
                                        }
                                    }
                                    r2.selector.close();
                                }
                                NewCachedThreadPool = -1;
                                e = e10;
                                r2 = str;
                                return NewCachedThreadPool;
                            }
                        } catch (Throwable th21) {
                            serverSocketChannel2 = e;
                            th = th21;
                            executorService = NewCachedThreadPool;
                            selectorLoop2 = r2;
                        }
                    } catch (Throwable th22) {
                        NioProviderMetadata.logger.warn("Failed to configure a temporary socket.", th22);
                        ?? e13 = e;
                        if (e != 0) {
                            try {
                                e.close();
                                e13 = e;
                            } catch (Throwable th23) {
                                NioProviderMetadata.logger.warn("Failed to close a temporary socket.", th23);
                                e13 = th23;
                            }
                        }
                        if (0 != 0) {
                            r2.done = true;
                            try {
                                NewCachedThreadPool.shutdownNow();
                            } catch (NullPointerException e14) {
                                e13 = e14;
                            }
                            while (true) {
                                try {
                                    e13 = r2.selector;
                                    e13.wakeup();
                                    try {
                                        e13 = NewCachedThreadPool.awaitTermination(1L, TimeUnit.SECONDS);
                                    } catch (InterruptedException e15) {
                                        e13 = e15;
                                    }
                                    if (e13 == 0) {
                                    }
                                } catch (Throwable th24) {
                                }
                                try {
                                    break;
                                } catch (Throwable th25) {
                                    e13 = NioProviderMetadata.logger;
                                    str2 = "Failed to close a temporary selector.";
                                    e13.warn("Failed to close a temporary selector.", th25);
                                }
                            }
                            r2.selector.close();
                        }
                        NewCachedThreadPool = -1;
                        e = e13;
                        r2 = str2;
                    }
                    return NewCachedThreadPool;
                } catch (Throwable th26) {
                    serverSocketChannel = null;
                    selectorLoop = null;
                    executorService2 = NewCachedThreadPool;
                }
            } catch (Throwable th27) {
                SelectorLoop selectorLoop4 = r2;
                serverSocketChannel = e;
                selectorLoop = selectorLoop4;
                executorService2 = NewCachedThreadPool;
            }
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

    private NioProviderMetadata() {
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

    public static void main(String[] strArr) {
        for (Map.Entry entry : System.getProperties().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
        System.out.println("Hard-coded Constraint Level: " + CONSTRAINT_LEVEL);
        System.out.println("Auto-detected Constraint Level: " + new ConstraintLevelAutodetector().autodetect());
    }
}
