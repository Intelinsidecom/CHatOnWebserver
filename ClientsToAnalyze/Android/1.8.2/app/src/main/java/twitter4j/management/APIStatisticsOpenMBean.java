package twitter4j.management;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.AttributeNotFoundException;
import javax.management.DynamicMBean;
import javax.management.MBeanInfo;
import javax.management.MBeanNotificationInfo;
import javax.management.ReflectionException;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.openmbean.CompositeType;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.OpenMBeanAttributeInfoSupport;
import javax.management.openmbean.OpenMBeanConstructorInfoSupport;
import javax.management.openmbean.OpenMBeanInfoSupport;
import javax.management.openmbean.OpenMBeanOperationInfoSupport;
import javax.management.openmbean.OpenMBeanParameterInfoSupport;
import javax.management.openmbean.OpenType;
import javax.management.openmbean.SimpleType;
import javax.management.openmbean.TabularDataSupport;
import javax.management.openmbean.TabularType;

/* loaded from: classes.dex */
public class APIStatisticsOpenMBean implements DynamicMBean {
    private final APIStatisticsMBean API_STATISTICS;
    private final TabularType API_STATISTICS_TYPE;
    private final CompositeType METHOD_STATS_TYPE;
    private static final String[] ITEM_NAMES = {"methodName", "callCount", "errorCount", "totalTime", "avgTime"};
    private static final OpenType[] ITEM_TYPES = {SimpleType.STRING, SimpleType.LONG, SimpleType.LONG, SimpleType.LONG, SimpleType.LONG};
    private static final String[] ITEM_DESCRIPTIONS = {"The method name", "The number of times this method has been called", "The number of calls that failed", "The total amount of time spent invoking this method in milliseconds", "The average amount of time spent invoking this method in milliseconds"};

    public APIStatisticsOpenMBean(APIStatistics aPIStatistics) {
        this.API_STATISTICS = aPIStatistics;
        try {
            this.METHOD_STATS_TYPE = new CompositeType("method statistics", "method statistics", ITEM_NAMES, ITEM_DESCRIPTIONS, ITEM_TYPES);
            this.API_STATISTICS_TYPE = new TabularType("API statistics", "list of methods", this.METHOD_STATS_TYPE, new String[]{"methodName"});
        } catch (OpenDataException e) {
            throw new RuntimeException((Throwable) e);
        }
    }

    public MBeanInfo getMBeanInfo() {
        return new OpenMBeanInfoSupport(getClass().getName(), "API Statistics Open MBean", new OpenMBeanAttributeInfoSupport[]{new OpenMBeanAttributeInfoSupport("callCount", "Total number of API calls", SimpleType.LONG, true, false, false), new OpenMBeanAttributeInfoSupport("errorCount", "The number of failed API calls", SimpleType.LONG, true, false, false), new OpenMBeanAttributeInfoSupport("averageTime", "Average time spent invoking any API method", SimpleType.LONG, true, false, false), new OpenMBeanAttributeInfoSupport("totalTime", "Average time spent invoking any API method", SimpleType.LONG, true, false, false), new OpenMBeanAttributeInfoSupport("statisticsTable", "Table of statisics for all API methods", this.API_STATISTICS_TYPE, true, false, false)}, new OpenMBeanConstructorInfoSupport[]{new OpenMBeanConstructorInfoSupport("APIStatisticsOpenMBean", "Constructs an APIStatisticsOpenMBean instance", new OpenMBeanParameterInfoSupport[0])}, new OpenMBeanOperationInfoSupport[]{new OpenMBeanOperationInfoSupport("reset", "reset the statistics", new OpenMBeanParameterInfoSupport[0], SimpleType.VOID, 0)}, new MBeanNotificationInfo[0]);
    }

    public synchronized TabularDataSupport getStatistics() {
        TabularDataSupport tabularDataSupport;
        tabularDataSupport = new TabularDataSupport(this.API_STATISTICS_TYPE);
        for (InvocationStatistics invocationStatistics : this.API_STATISTICS.getInvocationStatistics()) {
            try {
                tabularDataSupport.put(new CompositeDataSupport(this.METHOD_STATS_TYPE, ITEM_NAMES, new Object[]{invocationStatistics.getName(), new Long(invocationStatistics.getCallCount()), new Long(invocationStatistics.getErrorCount()), new Long(invocationStatistics.getTotalTime()), new Long(invocationStatistics.getAverageTime())}));
            } catch (OpenDataException e) {
                throw new RuntimeException((Throwable) e);
            }
        }
        return tabularDataSupport;
    }

    public void reset() {
        this.API_STATISTICS.reset();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.management.AttributeNotFoundException */
    public Object getAttribute(String str) throws AttributeNotFoundException {
        if (str.equals("statisticsTable")) {
            return getStatistics();
        }
        if (str.equals("callCount")) {
            return new Long(this.API_STATISTICS.getCallCount());
        }
        if (str.equals("errorCount")) {
            return new Long(this.API_STATISTICS.getErrorCount());
        }
        if (str.equals("totalTime")) {
            return new Long(this.API_STATISTICS.getTotalTime());
        }
        if (str.equals("averageTime")) {
            return new Long(this.API_STATISTICS.getAverageTime());
        }
        throw new AttributeNotFoundException(new StringBuffer().append("Cannot find ").append(str).append(" attribute ").toString());
    }

    public AttributeList getAttributes(String[] strArr) throws AttributeNotFoundException {
        AttributeList attributeList = new AttributeList();
        if (strArr.length == 0) {
            return attributeList;
        }
        for (int i = 0; i < strArr.length; i++) {
            try {
                attributeList.add(new Attribute(strArr[i], getAttribute(strArr[i])));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return attributeList;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.management.ReflectionException */
    public Object invoke(String str, Object[] objArr, String[] strArr) throws ReflectionException {
        if (str.equals("reset")) {
            reset();
            return "Statistics reset";
        }
        throw new ReflectionException(new NoSuchMethodException(str), new StringBuffer().append("Cannot find the operation ").append(str).toString());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.management.AttributeNotFoundException */
    public void setAttribute(Attribute attribute) throws AttributeNotFoundException {
        throw new AttributeNotFoundException("No attributes can be set in this MBean");
    }

    public AttributeList setAttributes(AttributeList attributeList) {
        return new AttributeList();
    }
}
