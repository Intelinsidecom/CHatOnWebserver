package twitter4j.api;

import twitter4j.IDs;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.User;

/* loaded from: classes.dex */
public interface StatusMethods {
    Status destroyStatus(long j);

    ResponseList<User> getRetweetedBy(long j);

    ResponseList<User> getRetweetedBy(long j, Paging paging);

    IDs getRetweetedByIDs(long j);

    IDs getRetweetedByIDs(long j, Paging paging);

    ResponseList<Status> getRetweets(long j);

    Status retweetStatus(long j);

    Status showStatus(long j);

    Status updateStatus(String str);

    Status updateStatus(StatusUpdate statusUpdate);
}
