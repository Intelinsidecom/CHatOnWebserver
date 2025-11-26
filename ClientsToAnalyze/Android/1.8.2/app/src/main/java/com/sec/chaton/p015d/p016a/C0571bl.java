package com.sec.chaton.p015d.p016a;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Xml;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p017e.p018a.C0660d;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.NotificationEntry;
import com.sec.chaton.p028io.entry.inner.Badge;
import com.sec.chaton.trunk.p048b.p049a.C1548f;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: NotificationTask.java */
/* renamed from: com.sec.chaton.d.a.bl */
/* loaded from: classes.dex */
public class C0571bl extends AbstractRunnableC0532a {

    /* renamed from: d */
    private static final String f2287d = C0571bl.class.getSimpleName();

    public C0571bl(Handler handler, C0798h c0798h) {
        super(handler, c0798h);
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() throws IllegalStateException, IOException, IllegalArgumentException {
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        try {
            xmlSerializerNewSerializer.setOutput(stringWriter);
            xmlSerializerNewSerializer.startDocument("UTF-8", true);
            xmlSerializerNewSerializer.startTag("", "param");
            xmlSerializerNewSerializer.startTag("", "timestamp");
            xmlSerializerNewSerializer.text(String.valueOf(C1789u.m6075a().getLong("notification_api_timestamp", 0L)));
            xmlSerializerNewSerializer.endTag("", "timestamp");
            xmlSerializerNewSerializer.startTag("", "options");
            xmlSerializerNewSerializer.startTag("", "option");
            xmlSerializerNewSerializer.text("badge.new_anicon_count");
            xmlSerializerNewSerializer.endTag("", "option");
            xmlSerializerNewSerializer.startTag("", "option");
            xmlSerializerNewSerializer.text("service.trunklist");
            xmlSerializerNewSerializer.endTag("", "option");
            xmlSerializerNewSerializer.endTag("", "options");
            xmlSerializerNewSerializer.startTag("", "option");
            xmlSerializerNewSerializer.text("badge.new_skin_count");
            xmlSerializerNewSerializer.endTag("", "option");
            xmlSerializerNewSerializer.endTag("", "options");
            ArrayList<String> arrayListM3016a = C0660d.m3016a(GlobalApplication.m3260b().getContentResolver());
            if (arrayListM3016a.size() != 0) {
                xmlSerializerNewSerializer.startTag("", "trunklist");
                for (String str : arrayListM3016a) {
                    xmlSerializerNewSerializer.startTag("", "sessionid");
                    xmlSerializerNewSerializer.text(str);
                    xmlSerializerNewSerializer.endTag("", "sessionid");
                }
                xmlSerializerNewSerializer.endTag("", "trunklist");
            }
            xmlSerializerNewSerializer.endTag("", "param");
            xmlSerializerNewSerializer.endDocument();
            if (C1786r.f6452b) {
                C1786r.m6061b(stringWriter.toString(), f2287d);
            }
            return stringWriter.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
        if (c0101b.m665b() == EnumC0803m.SUCCESS) {
            NotificationEntry notificationEntry = (NotificationEntry) c0101b.m671d();
            if (notificationEntry == null) {
                if (C1786r.f6455e) {
                    C1786r.m6054a("Http result object is null.", f2287d);
                    return;
                }
                return;
            }
            if (C1786r.f6452b) {
                C1786r.m6061b("Save trunk to database.", f2287d);
            }
            C1789u.m6075a().edit().putLong("notification_api_timestamp", Long.parseLong(notificationEntry.utctimestamp)).commit();
            for (Badge badge : notificationEntry.badges) {
                if ("new_anicon_count".equals(badge.name)) {
                    C1789u.m6075a().edit().putInt("new_anicon_count", Integer.parseInt(badge.value)).commit();
                    LocalBroadcastManager.getInstance(GlobalApplication.m3260b()).sendBroadcast(new Intent("setting_tab_badge_update"));
                }
                if ("new_skin_count".equals(badge.name)) {
                    C1789u.m6075a().edit().putInt("new_skin_count", Integer.parseInt(badge.value));
                    LocalBroadcastManager.getInstance(GlobalApplication.m3260b()).sendBroadcast(new Intent("setting_tab_badge_update"));
                }
            }
            C1548f.m5404a(notificationEntry.trunks);
        }
    }
}
