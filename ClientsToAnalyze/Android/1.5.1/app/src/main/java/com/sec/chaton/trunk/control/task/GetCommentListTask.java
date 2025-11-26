package com.sec.chaton.trunk.control.task;

import android.os.Handler;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.control.task.AbstractHttpTask2;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.trunk.database.helper.TrunkDatabaseHelper;
import com.sec.chaton.trunk.entry.GetCommentListEntry;
import com.sec.chaton.trunk.entry.inner.Comment;
import com.sec.chaton.util.ChatONLogWriter;
import org.apache.http.NameValuePair;

/* loaded from: classes.dex */
public class GetCommentListTask extends AbstractHttpTask2 {
    private static final String TAG = GetCommentListTask.class.getSimpleName();
    private boolean isCanceled;

    public GetCommentListTask(Handler handler, HttpEnvelope httpEnvelope) {
        super(handler, httpEnvelope);
        this.isCanceled = false;
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) throws NumberFormatException {
        httpEntry.m1953b(this);
        if (this.isCanceled) {
            ChatONLogWriter.m3506b("GetCommentListTask is canceled.", TAG);
            return;
        }
        if (httpEntry.m1951b() != HttpResultCode.SUCCESS) {
            return;
        }
        String value = "";
        int i = Integer.MAX_VALUE;
        for (NameValuePair nameValuePair : httpEntry.m1954c().m2731d()) {
            if (nameValuePair.getName().equals("itemid")) {
                value = nameValuePair.getValue();
            }
            if (nameValuePair.getName().equals("startcommentid")) {
                i = Integer.parseInt(nameValuePair.getValue());
            }
        }
        TrunkDatabaseHelper trunkDatabaseHelper = new TrunkDatabaseHelper(GlobalApplication.m2387e());
        GetCommentListEntry getCommentListEntry = (GetCommentListEntry) httpEntry.m1955d();
        if (getCommentListEntry == null) {
            ChatONLogWriter.m3499a("Http result object is null", TAG);
            return;
        }
        ChatONLogWriter.m3506b("Save comment to database", TAG);
        int i2 = i == Integer.MAX_VALUE ? 0 : 1;
        while (true) {
            int i3 = i2;
            if (i3 >= getCommentListEntry.comments.size()) {
                return;
            }
            Comment comment = (Comment) getCommentListEntry.comments.get(i3);
            comment.itemid = value;
            ChatONLogWriter.m3506b(" Comment Id: " + comment.cid, TAG);
            trunkDatabaseHelper.saveTrunkComment(comment);
            i2 = i3 + 1;
        }
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() {
        return null;
    }

    public void cancel() {
        this.isCanceled = true;
    }
}
