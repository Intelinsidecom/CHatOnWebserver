package twitter4j;

import java.io.Serializable;

/* loaded from: classes.dex */
public interface AccountTotals extends Serializable, TwitterResponse {
    int getFavorites();

    int getFollowers();

    int getFriends();

    int getUpdates();
}
