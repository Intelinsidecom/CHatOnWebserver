package twitter4j.api;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;

/* loaded from: classes.dex */
public interface FavoriteMethods {
    Status createFavorite(long j);

    Status destroyFavorite(long j);

    ResponseList getFavorites();

    ResponseList getFavorites(int i);

    ResponseList getFavorites(String str);

    ResponseList getFavorites(String str, int i);

    ResponseList getFavorites(String str, Paging paging);

    ResponseList getFavorites(Paging paging);
}
