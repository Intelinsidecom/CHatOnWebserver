package com.sec.chaton.trunk.control.task;

import android.os.Handler;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.control.task.AbstractHttpTask2;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.trunk.database.helper.TrunkDatabaseHelper;
import com.sec.chaton.trunk.entry.GetItemEntry;
import com.sec.chaton.trunk.entry.inner.Comment;
import com.sec.chaton.util.ChatONLogWriter;
import org.apache.http.NameValuePair;

/* loaded from: classes.dex */
public class GetItemTask extends AbstractHttpTask2 {
    private static final String TAG = GetItemTask.class.getSimpleName();
    private boolean isCanceled;

    public GetItemTask(Handler handler, HttpEnvelope httpEnvelope) {
        super(handler, httpEnvelope);
        this.isCanceled = false;
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) {
        httpEntry.m1953b(this);
        if (this.isCanceled) {
            ChatONLogWriter.m3506b("GetItemTask is canceled.", TAG);
            return;
        }
        if (httpEntry.m1951b() == HttpResultCode.SUCCESS) {
            String value = "";
            String value2 = "";
            for (NameValuePair nameValuePair : httpEntry.m1954c().m2731d()) {
                if (nameValuePair.getName().equals("itemid")) {
                    value = nameValuePair.getValue();
                }
                if (nameValuePair.getName().equals("sessionid")) {
                    value2 = nameValuePair.getValue();
                }
            }
            TrunkDatabaseHelper trunkDatabaseHelper = new TrunkDatabaseHelper(GlobalApplication.m2387e());
            GetItemEntry getItemEntry = (GetItemEntry) httpEntry.m1955d();
            if (getItemEntry == null) {
                ChatONLogWriter.m3499a("Http result object is null", TAG);
                return;
            }
            ChatONLogWriter.m3506b("Save trunk item to database", TAG);
            getItemEntry.item.sessionid = value2;
            trunkDatabaseHelper.saveTrunkItem(getItemEntry.item);
            ChatONLogWriter.m3506b("Save trunk comment to database", TAG);
            for (Comment comment : getItemEntry.item.comment) {
                comment.itemid = value;
                trunkDatabaseHelper.saveTrunkComment(comment);
                ChatONLogWriter.m3506b("===========================", GetItemTask.class.getSimpleName());
                ChatONLogWriter.m3506b(comment.toString(), GetItemTask.class.getSimpleName());
            }
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
