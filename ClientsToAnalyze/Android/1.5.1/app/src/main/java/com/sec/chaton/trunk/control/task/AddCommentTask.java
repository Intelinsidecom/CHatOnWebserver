package com.sec.chaton.trunk.control.task;

import android.os.Handler;
import android.util.Xml;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.control.task.AbstractHttpTask2;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.util.ChatONLogWriter;
import java.io.IOException;
import java.io.StringWriter;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: classes.dex */
public class AddCommentTask extends AbstractHttpTask2 {
    private String comment;
    private String itemId;
    private String sessionId;

    public AddCommentTask(Handler handler, HttpEnvelope httpEnvelope, String str, String str2, String str3) {
        super(handler, httpEnvelope);
        this.sessionId = str;
        this.itemId = str2;
        this.comment = str3;
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) {
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() throws IllegalStateException, IOException, IllegalArgumentException {
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        try {
            xmlSerializerNewSerializer.setOutput(stringWriter);
            xmlSerializerNewSerializer.startDocument("UTF-8", true);
            xmlSerializerNewSerializer.startTag("", "param");
            xmlSerializerNewSerializer.startTag("", "sessionid");
            xmlSerializerNewSerializer.text(this.sessionId);
            xmlSerializerNewSerializer.endTag("", "sessionid");
            xmlSerializerNewSerializer.startTag("", "itemid");
            xmlSerializerNewSerializer.text(this.itemId);
            xmlSerializerNewSerializer.endTag("", "itemid");
            xmlSerializerNewSerializer.startTag("", "comment");
            xmlSerializerNewSerializer.cdsect(this.comment);
            xmlSerializerNewSerializer.endTag("", "comment");
            xmlSerializerNewSerializer.endTag("", "param");
            xmlSerializerNewSerializer.endDocument();
            ChatONLogWriter.m3506b(stringWriter.toString(), AddCommentTask.class.getSimpleName());
            return stringWriter.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
