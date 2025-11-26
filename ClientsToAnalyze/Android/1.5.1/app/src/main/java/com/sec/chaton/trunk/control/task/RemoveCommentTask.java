package com.sec.chaton.trunk.control.task;

import android.os.Handler;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.control.task.AbstractHttpTask2;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.trunk.database.helper.TrunkDatabaseHelper;
import com.sec.chaton.util.ChatONLogWriter;
import org.apache.http.NameValuePair;

/* loaded from: classes.dex */
public class RemoveCommentTask extends AbstractHttpTask2 {
    private static final String TAG = RemoveCommentTask.class.getSimpleName();

    public RemoveCommentTask(Handler handler, HttpEnvelope httpEnvelope) {
        super(handler, httpEnvelope);
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) {
        if (httpEntry.m1951b() == HttpResultCode.SUCCESS) {
            String value = "";
            String value2 = "";
            for (NameValuePair nameValuePair : httpEntry.m1954c().m2731d()) {
                if (nameValuePair.getName().equals("commentid")) {
                    value = nameValuePair.getValue();
                } else if (nameValuePair.getName().equals("itemid")) {
                    value2 = nameValuePair.getValue();
                }
            }
            TrunkDatabaseHelper trunkDatabaseHelper = new TrunkDatabaseHelper(GlobalApplication.m2387e());
            ChatONLogWriter.m3506b("Decrease total comment count of trunk item: " + value2, TAG);
            trunkDatabaseHelper.decreaseTotalCommentCountOfTrunkItem(value2);
            ChatONLogWriter.m3506b("Remove comment in database: " + value, TAG);
            trunkDatabaseHelper.removeTrunkComment(value);
        }
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() {
        return null;
    }
}
