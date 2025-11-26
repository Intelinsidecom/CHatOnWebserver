package twitter4j.api;

import java.util.Date;
import twitter4j.ResponseList;
import twitter4j.Trends;

/* loaded from: classes.dex */
public interface TrendsMethods {
    ResponseList<Trends> getDailyTrends();

    ResponseList<Trends> getDailyTrends(Date date, boolean z);

    ResponseList<Trends> getWeeklyTrends();

    ResponseList<Trends> getWeeklyTrends(Date date, boolean z);
}
