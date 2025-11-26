package twitter4j.api;

import twitter4j.Paging;
import twitter4j.ResponseList;

/* loaded from: classes.dex */
public interface TimelineMethods {
    ResponseList getFriendsTimeline();

    ResponseList getFriendsTimeline(Paging paging);

    ResponseList getHomeTimeline();

    ResponseList getHomeTimeline(Paging paging);

    ResponseList getMentions();

    ResponseList getMentions(Paging paging);

    ResponseList getPublicTimeline();

    ResponseList getRetweetedByMe();

    ResponseList getRetweetedByMe(Paging paging);

    ResponseList getRetweetedByUser(long j, Paging paging);

    ResponseList getRetweetedByUser(String str, Paging paging);

    ResponseList getRetweetedToMe();

    ResponseList getRetweetedToMe(Paging paging);

    ResponseList getRetweetedToUser(long j, Paging paging);

    ResponseList getRetweetedToUser(String str, Paging paging);

    ResponseList getRetweetsOfMe();

    ResponseList getRetweetsOfMe(Paging paging);

    ResponseList getUserTimeline();

    ResponseList getUserTimeline(long j);

    ResponseList getUserTimeline(long j, Paging paging);

    ResponseList getUserTimeline(String str);

    ResponseList getUserTimeline(String str, Paging paging);

    ResponseList getUserTimeline(Paging paging);
}
