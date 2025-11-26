package com.sec.chaton.trunk;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.trunk.util.TrunkUtil;

/* loaded from: classes.dex */
public class ContentActivity extends BaseSinglePaneActivity {
    static final String EXTRA_CONTENT_TYPE_ID = "contentType";
    static final String EXTRA_DOWNLOAD_URL_ID = "downloadUrl";
    static final String EXTRA_INBOX_NO_ID = "inboxNO";
    static final String EXTRA_ITEM_ID = "itemId";
    static final String EXTRA_SESSION_ID = "sessionId";

    public static void ActionStartContentActivity(Context context, String str, String str2, String str3, String str4, TrunkUtil.ContentType contentType) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_SESSION_ID, str);
        intent.putExtra(EXTRA_INBOX_NO_ID, str2);
        intent.putExtra(EXTRA_ITEM_ID, str3);
        intent.putExtra(EXTRA_DOWNLOAD_URL_ID, str4);
        intent.putExtra(EXTRA_CONTENT_TYPE_ID, contentType);
        intent.setClass(context, ContentActivity.class);
        context.startActivity(intent);
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    protected Fragment onCreatePane() {
        return new ContentFragment3();
    }
}
