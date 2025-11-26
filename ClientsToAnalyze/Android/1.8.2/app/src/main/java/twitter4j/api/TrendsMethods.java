package twitter4j.api;

import java.util.Date;
import twitter4j.ResponseList;

/* loaded from: classes.dex */
public interface TrendsMethods {
    ResponseList getDailyTrends();

    ResponseList getDailyTrends(Date date, boolean z);

    ResponseList getWeeklyTrends();

    ResponseList getWeeklyTrends(Date date, boolean z);
}
