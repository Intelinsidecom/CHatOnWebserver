package twitter4j;

import java.lang.management.ManagementFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import twitter4j.conf.ConfigurationContext;
import twitter4j.internal.logging.Logger;
import twitter4j.management.APIStatistics;
import twitter4j.management.APIStatisticsMBean;
import twitter4j.management.APIStatisticsOpenMBean;

/* loaded from: classes.dex */
public class TwitterAPIMonitor {
    private static final TwitterAPIMonitor SINGLETON;
    static Class class$twitter4j$TwitterAPIMonitor;
    private static final Logger logger;
    private static final Pattern pattern;
    private final APIStatistics STATISTICS = new APIStatistics(100);

    static {
        Class clsClass$;
        boolean z = true;
        if (class$twitter4j$TwitterAPIMonitor == null) {
            clsClass$ = class$("twitter4j.TwitterAPIMonitor");
            class$twitter4j$TwitterAPIMonitor = clsClass$;
        } else {
            clsClass$ = class$twitter4j$TwitterAPIMonitor;
        }
        logger = Logger.getLogger(clsClass$);
        pattern = Pattern.compile("https?:\\/\\/[^\\/]+\\/([a-zA-Z_\\.]*).*");
        SINGLETON = new TwitterAPIMonitor();
        try {
            String property = System.getProperty("java.specification.version");
            boolean z2 = property != null && 1.5d > Double.parseDouble(property);
            if (ConfigurationContext.getInstance().isDalvik()) {
                System.setProperty("http.keepAlive", "false");
            }
            z = z2;
        } catch (SecurityException e) {
        }
        try {
            MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
            APIStatistics aPIStatistics = new APIStatistics(100);
            if (z) {
                platformMBeanServer.registerMBean(aPIStatistics, new ObjectName("twitter4j.mbean:type=APIStatistics"));
            } else {
                platformMBeanServer.registerMBean(new APIStatisticsOpenMBean(aPIStatistics), new ObjectName("twitter4j.mbean:type=APIStatisticsOpenMBean"));
            }
        } catch (MalformedObjectNameException e2) {
            e2.printStackTrace();
            logger.error(e2.getMessage());
        } catch (InstanceAlreadyExistsException e3) {
            e3.printStackTrace();
            logger.error(e3.getMessage());
        } catch (NotCompliantMBeanException e4) {
            e4.printStackTrace();
            logger.error(e4.getMessage());
        } catch (MBeanRegistrationException e5) {
            e5.printStackTrace();
            logger.error(e5.getMessage());
        }
    }

    static Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private TwitterAPIMonitor() {
    }

    public static TwitterAPIMonitor getInstance() {
        return SINGLETON;
    }

    public APIStatisticsMBean getStatistics() {
        return this.STATISTICS;
    }

    void methodCalled(String str, long j, boolean z) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches() && matcher.groupCount() > 0) {
            this.STATISTICS.methodCalled(matcher.group(), j, z);
        }
    }
}
