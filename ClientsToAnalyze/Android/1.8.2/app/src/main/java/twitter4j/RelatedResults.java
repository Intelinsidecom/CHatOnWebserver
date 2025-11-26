package twitter4j;

import java.io.Serializable;

/* loaded from: classes.dex */
public interface RelatedResults extends Serializable, TwitterResponse {
    ResponseList getTweetsFromUser();

    ResponseList getTweetsWithConversation();

    ResponseList getTweetsWithReply();
}
