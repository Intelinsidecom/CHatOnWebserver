package twitter4j.api;

import java.io.File;
import java.io.InputStream;
import twitter4j.AccountSettings;
import twitter4j.AccountTotals;
import twitter4j.RateLimitStatus;
import twitter4j.User;

/* loaded from: classes.dex */
public interface AccountMethods {
    AccountSettings getAccountSettings();

    AccountTotals getAccountTotals();

    RateLimitStatus getRateLimitStatus();

    AccountSettings updateAccountSettings(Integer num, Boolean bool, String str, String str2, String str3, String str4);

    User updateProfile(String str, String str2, String str3, String str4);

    User updateProfileBackgroundImage(File file, boolean z);

    User updateProfileBackgroundImage(InputStream inputStream, boolean z);

    User updateProfileColors(String str, String str2, String str3, String str4, String str5);

    User updateProfileImage(File file);

    User updateProfileImage(InputStream inputStream);

    User verifyCredentials();
}
