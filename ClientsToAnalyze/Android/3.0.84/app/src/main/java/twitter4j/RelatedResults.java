package twitter4j;

import java.io.Serializable;

/* loaded from: classes.dex */
public interface RelatedResults extends Serializable, TwitterResponse {
    ResponseList<Status> getTweetsFromUser();

    ResponseList<Status> getTweetsWithConversation();

    ResponseList<Status> getTweetsWithReply();
}
