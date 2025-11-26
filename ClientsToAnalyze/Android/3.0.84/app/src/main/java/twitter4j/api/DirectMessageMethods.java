package twitter4j.api;

import twitter4j.DirectMessage;
import twitter4j.Paging;
import twitter4j.ResponseList;

/* loaded from: classes.dex */
public interface DirectMessageMethods {
    DirectMessage destroyDirectMessage(long j);

    ResponseList<DirectMessage> getDirectMessages();

    ResponseList<DirectMessage> getDirectMessages(Paging paging);

    ResponseList<DirectMessage> getSentDirectMessages();

    ResponseList<DirectMessage> getSentDirectMessages(Paging paging);

    DirectMessage sendDirectMessage(long j, String str);

    DirectMessage sendDirectMessage(String str, String str2);

    DirectMessage showDirectMessage(long j);
}
