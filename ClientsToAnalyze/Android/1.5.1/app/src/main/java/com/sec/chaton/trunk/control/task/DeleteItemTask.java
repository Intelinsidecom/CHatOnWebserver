package com.sec.chaton.trunk.control.task;

import android.os.Handler;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.control.task.AbstractHttpTask2;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.trunk.database.helper.TrunkDatabaseHelper;
import com.sec.chaton.util.ChatONLogWriter;
import java.util.Iterator;
import org.apache.http.NameValuePair;

/* loaded from: classes.dex */
public class DeleteItemTask extends AbstractHttpTask2 {
    private static final String TAG = DeleteItemTask.class.getSimpleName();
    private TrunkDatabaseHelper trunkDatabaseHelper;

    public DeleteItemTask(Handler handler, HttpEnvelope httpEnvelope) {
        super(handler, httpEnvelope);
        this.trunkDatabaseHelper = new TrunkDatabaseHelper(GlobalApplication.m2387e());
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) {
        String value;
        if (httpEntry.m1951b() == HttpResultCode.SUCCESS) {
            Iterator it = this.mHttpEnvelope.m2731d().iterator();
            while (true) {
                if (!it.hasNext()) {
                    value = null;
                    break;
                }
                NameValuePair nameValuePair = (NameValuePair) it.next();
                if (nameValuePair.getName().equals("itemid")) {
                    value = nameValuePair.getValue();
                    break;
                }
            }
            ChatONLogWriter.m3506b("Delete trunk item in database: " + value, TAG);
            this.trunkDatabaseHelper.removeTrunkItem(value);
        }
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() {
        return null;
    }
}
