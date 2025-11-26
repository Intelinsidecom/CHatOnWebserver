package twitter4j.api;

import twitter4j.DirectMessage;
import twitter4j.Paging;
import twitter4j.ResponseList;

/* loaded from: classes.dex */
public interface DirectMessageMethods {
    DirectMessage destroyDirectMessage(long j);

    ResponseList getDirectMessages();

    ResponseList getDirectMessages(Paging paging);

    ResponseList getSentDirectMessages();

    ResponseList getSentDirectMessages(Paging paging);

    DirectMessage sendDirectMessage(long j, String str);

    DirectMessage sendDirectMessage(String str, String str2);

    DirectMessage showDirectMessage(long j);
}
