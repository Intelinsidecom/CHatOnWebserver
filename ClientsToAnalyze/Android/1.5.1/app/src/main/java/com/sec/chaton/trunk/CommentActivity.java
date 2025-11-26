package com.sec.chaton.trunk;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.sec.chaton.base.BaseSinglePaneActivity;

/* loaded from: classes.dex */
public class CommentActivity extends BaseSinglePaneActivity {
    static final String EXTRA_CONTENT_ID = "contentId";
    static final String EXTRA_FILE_PATH_ID = "filePath";
    static final String EXTRA_IS_SHARE_ID = "isShare";
    static final String EXTRA_SESSION_ID = "sessionId";

    public static void ActionStartCommentActivity(Context context, Fragment fragment, int i, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_SESSION_ID, str);
        intent.putExtra(EXTRA_CONTENT_ID, str2);
        intent.putExtra(EXTRA_FILE_PATH_ID, str3);
        intent.putExtra(EXTRA_IS_SHARE_ID, false);
        intent.setClass(context, CommentActivity.class);
        fragment.startActivityForResult(intent, i);
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    protected Fragment onCreatePane() {
        return new CommentFragment();
    }
}
