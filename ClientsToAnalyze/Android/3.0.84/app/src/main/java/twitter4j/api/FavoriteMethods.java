package twitter4j.api;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;

/* loaded from: classes.dex */
public interface FavoriteMethods {
    Status createFavorite(long j);

    Status destroyFavorite(long j);

    ResponseList<Status> getFavorites();

    ResponseList<Status> getFavorites(int i);

    ResponseList<Status> getFavorites(String str);

    ResponseList<Status> getFavorites(String str, int i);

    ResponseList<Status> getFavorites(String str, Paging paging);

    ResponseList<Status> getFavorites(Paging paging);
}
