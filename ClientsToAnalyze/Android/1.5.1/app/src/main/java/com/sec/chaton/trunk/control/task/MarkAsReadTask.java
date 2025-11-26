package com.sec.chaton.trunk.control.task;

import android.os.Handler;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.control.task.AbstractHttpTask2;
import com.sec.chaton.database.helper.InBoxDatabaseHelper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.trunk.database.helper.TrunkDatabaseHelper;
import com.sec.chaton.util.ChatONLogWriter;
import org.apache.http.NameValuePair;

/* loaded from: classes.dex */
public class MarkAsReadTask extends AbstractHttpTask2 {
    private static final String TAG = MarkAsReadTask.class.getSimpleName();

    public MarkAsReadTask(Handler handler, HttpEnvelope httpEnvelope) {
        super(handler, httpEnvelope);
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) {
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() {
        String value = "";
        String value2 = "";
        for (NameValuePair nameValuePair : this.mHttpEnvelope.m2731d()) {
            if (nameValuePair.getName().equals("itemid")) {
                value = nameValuePair.getValue();
            } else if (nameValuePair.getName().equals("sessionid")) {
                value2 = nameValuePair.getValue();
            }
        }
        ChatONLogWriter.m3506b("MarkAsRead ItemId: " + value, TAG);
        new TrunkDatabaseHelper(GlobalApplication.m2387e()).markAsReadTrunkItem(value);
        InBoxDatabaseHelper.m2256b(GlobalApplication.m2387e().getContentResolver(), value2, 1);
        return null;
    }
}
