package org.jboss.netty.channel.socket.nio;

import java.nio.channels.spi.SelectorProvider;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.util.internal.SystemPropertyUtil;

/* loaded from: classes.dex */
class NioProviderMetadata {
    static final int CONSTRAINT_LEVEL;
    static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) NioProviderMetadata.class);

    static {
        int iDetectConstraintLevelFromSystemProperties = SystemPropertyUtil.get("org.jboss.netty.channel.socket.nio.constraintLevel", -1);
        if (iDetectConstraintLevelFromSystemProperties < 0 || iDetectConstraintLevelFromSystemProperties > 2) {
            iDetectConstraintLevelFromSystemProperties = SystemPropertyUtil.get("java.nio.channels.spi.constraintLevel", -1);
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

    private NioProviderMetadata() {
    }
}
