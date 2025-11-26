package com.sec.chaton.trunk.control.task;

import android.os.Handler;
import android.util.Xml;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.control.task.AbstractHttpTask2;
import com.sec.chaton.database.helper.InBoxDatabaseHelper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.trunk.database.helper.TrunkDatabaseHelper;
import com.sec.chaton.trunk.entry.GetTrunkListEntry;
import com.sec.chaton.trunk.entry.inner.Trunk;
import com.sec.chaton.util.ChatONLogWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: classes.dex */
public class GetTrunkListTask extends AbstractHttpTask2 {
    private static final String TAG = GetTrunkListTask.class.getSimpleName();
    private List sessionIdList;

    public GetTrunkListTask(Handler handler, HttpEnvelope httpEnvelope, List list) {
        super(handler, httpEnvelope);
        this.sessionIdList = list;
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) {
        if (httpEntry.m1951b() == HttpResultCode.SUCCESS) {
            TrunkDatabaseHelper trunkDatabaseHelper = new TrunkDatabaseHelper(GlobalApplication.m2387e());
            GetTrunkListEntry getTrunkListEntry = (GetTrunkListEntry) httpEntry.m1955d();
            if (getTrunkListEntry == null) {
                ChatONLogWriter.m3499a("Http result object is null", TAG);
                return;
            }
            List<Trunk> list = getTrunkListEntry.trunks;
            ChatONLogWriter.m3506b("Save trunk to database", TAG);
            for (Trunk trunk : list) {
                ChatONLogWriter.m3506b(trunk.toString(), TAG);
                trunkDatabaseHelper.saveTrunk(trunk);
                InBoxDatabaseHelper.m2239a(GlobalApplication.m2387e().getContentResolver(), trunk.sessionid, trunk.unreaditemcnt);
            }
        }
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() throws IllegalStateException, IOException, IllegalArgumentException {
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        try {
            xmlSerializerNewSerializer.setOutput(stringWriter);
            xmlSerializerNewSerializer.startDocument("UTF-8", true);
            xmlSerializerNewSerializer.startTag("", "param");
            for (String str : this.sessionIdList) {
                xmlSerializerNewSerializer.startTag("", "sessionid");
                xmlSerializerNewSerializer.text(str);
                xmlSerializerNewSerializer.endTag("", "sessionid");
            }
            xmlSerializerNewSerializer.endTag("", "param");
            xmlSerializerNewSerializer.endDocument();
            ChatONLogWriter.m3506b(stringWriter.toString(), TAG);
            return stringWriter.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
