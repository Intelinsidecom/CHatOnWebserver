package twitter4j.api;

import twitter4j.User;

/* loaded from: classes.dex */
public interface NotificationMethods {
    User disableNotification(long j);

    User disableNotification(String str);

    User enableNotification(long j);

    User enableNotification(String str);
}
