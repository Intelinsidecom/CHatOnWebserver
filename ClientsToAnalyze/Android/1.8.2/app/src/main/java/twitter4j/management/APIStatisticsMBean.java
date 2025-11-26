package twitter4j.management;

import java.util.Map;

/* loaded from: classes.dex */
public interface APIStatisticsMBean extends InvocationStatistics {
    Iterable getInvocationStatistics();

    Map getMethodLevelSummariesAsString();

    String getMethodLevelSummary(String str);
}
