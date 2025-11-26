package twitter4j.api;

import twitter4j.ResponseList;
import twitter4j.TwitterAPIConfiguration;

/* loaded from: classes.dex */
public interface HelpMethods {

    public interface Language {
        String getCode();

        String getName();

        String getStatus();
    }

    TwitterAPIConfiguration getAPIConfiguration();

    ResponseList<Language> getLanguages();

    boolean test();
}
