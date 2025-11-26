package twitter4j.api;

import twitter4j.ResponseList;
import twitter4j.SavedSearch;

/* loaded from: classes.dex */
public interface SavedSearchesMethods {
    SavedSearch createSavedSearch(String str);

    SavedSearch destroySavedSearch(int i);

    ResponseList<SavedSearch> getSavedSearches();

    SavedSearch showSavedSearch(int i);
}
