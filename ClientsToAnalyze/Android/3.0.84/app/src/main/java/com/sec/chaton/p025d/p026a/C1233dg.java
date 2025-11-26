package com.sec.chaton.p025d.p026a;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Xml;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p035io.entry.NotificationEntry;
import com.sec.chaton.p035io.entry.inner.Badge;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.trunk.p058a.p059a.C2955f;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3364o;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: NotificationTask.java */
/* renamed from: com.sec.chaton.d.a.dg */
/* loaded from: classes.dex */
public class C1233dg extends AbstractC1145a {

    /* renamed from: b */
    private static final String f4775b = C1233dg.class.getSimpleName();

    public C1233dg(Handler handler, C1580h c1580h) {
        super(handler, c1580h);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() throws IllegalStateException, IOException, IllegalArgumentException {
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        try {
            long jM10976a = C3159aa.m10962a().m10976a("notification_api_timestamp", 0L);
            xmlSerializerNewSerializer.setOutput(stringWriter);
            xmlSerializerNewSerializer.startDocument("UTF-8", true);
            xmlSerializerNewSerializer.startTag("", "param");
            xmlSerializerNewSerializer.startTag("", "timestamp");
            xmlSerializerNewSerializer.text(String.valueOf(jM10976a));
            xmlSerializerNewSerializer.endTag("", "timestamp");
            xmlSerializerNewSerializer.startTag("", "iso2");
            xmlSerializerNewSerializer.text(C3171am.m11082t());
            xmlSerializerNewSerializer.endTag("", "iso2");
            xmlSerializerNewSerializer.startTag("", "language");
            xmlSerializerNewSerializer.text(C3171am.m11074l());
            xmlSerializerNewSerializer.endTag("", "language");
            xmlSerializerNewSerializer.startTag("", "platform");
            xmlSerializerNewSerializer.text("android");
            xmlSerializerNewSerializer.endTag("", "platform");
            xmlSerializerNewSerializer.startTag("", "appversion");
            xmlSerializerNewSerializer.text(C0816a.f3112a);
            xmlSerializerNewSerializer.endTag("", "appversion");
            xmlSerializerNewSerializer.startTag("", "model");
            xmlSerializerNewSerializer.text(URLEncoder.encode(C3171am.m11055b()));
            xmlSerializerNewSerializer.endTag("", "model");
            xmlSerializerNewSerializer.startTag("", "options");
            xmlSerializerNewSerializer.startTag("", "option");
            xmlSerializerNewSerializer.text("badge.new_anicon_count");
            xmlSerializerNewSerializer.endTag("", "option");
            xmlSerializerNewSerializer.startTag("", "option");
            xmlSerializerNewSerializer.text("service.trunklist");
            xmlSerializerNewSerializer.endTag("", "option");
            xmlSerializerNewSerializer.startTag("", "option");
            xmlSerializerNewSerializer.text("badge.new_poston_count");
            xmlSerializerNewSerializer.endTag("", "option");
            xmlSerializerNewSerializer.startTag("", "option");
            xmlSerializerNewSerializer.text("badge.new_skin_count");
            xmlSerializerNewSerializer.endTag("", "option");
            xmlSerializerNewSerializer.startTag("", "option");
            xmlSerializerNewSerializer.text("badge.new_font_count");
            xmlSerializerNewSerializer.endTag("", "option");
            xmlSerializerNewSerializer.startTag("", "option");
            xmlSerializerNewSerializer.text("badge.new_sound_count");
            xmlSerializerNewSerializer.endTag("", "option");
            xmlSerializerNewSerializer.startTag("", "option");
            xmlSerializerNewSerializer.text("badge.new_ams_template_count");
            xmlSerializerNewSerializer.endTag("", "option");
            xmlSerializerNewSerializer.startTag("", "option");
            xmlSerializerNewSerializer.text("badge.new_ams_background_count");
            xmlSerializerNewSerializer.endTag("", "option");
            xmlSerializerNewSerializer.startTag("", "option");
            xmlSerializerNewSerializer.text("badge.new_ams_stamp_count");
            xmlSerializerNewSerializer.endTag("", "option");
            xmlSerializerNewSerializer.startTag("", "option");
            if (!C3159aa.m10962a().m10987b("notification_api_event_timestamp")) {
                xmlSerializerNewSerializer.attribute("", "timestamp", String.valueOf(C3159aa.m10962a().m10976a("notification_api_event_timestamp", 1L)));
            }
            xmlSerializerNewSerializer.text("badge.new_event_count");
            xmlSerializerNewSerializer.endTag("", "option");
            xmlSerializerNewSerializer.startTag("", "option");
            if (jM10976a <= 0) {
                xmlSerializerNewSerializer.attribute("", "timestamp", "1");
            }
            xmlSerializerNewSerializer.text("badge.new_live_buddy_count");
            xmlSerializerNewSerializer.endTag("", "option");
            xmlSerializerNewSerializer.startTag("", "option");
            xmlSerializerNewSerializer.attribute("", "timestamp", String.valueOf(C3159aa.m10962a().m10976a("new_feature_dont_show_check_time", 137109010100L)));
            xmlSerializerNewSerializer.text("badge.new_feature_notice_count");
            xmlSerializerNewSerializer.endTag("", "option");
            xmlSerializerNewSerializer.endTag("", "options");
            xmlSerializerNewSerializer.endTag("", "param");
            xmlSerializerNewSerializer.endDocument();
            if (C3250y.f11734b) {
                C3250y.m11450b(stringWriter.toString(), f4775b);
            }
            return stringWriter.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) throws JSONException, NumberFormatException {
        if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
            NotificationEntry notificationEntry = (NotificationEntry) c0267d.m1354e();
            if (notificationEntry == null) {
                if (C3250y.f11737e) {
                    C3250y.m11442a("Http result object is null.", f4775b);
                    return;
                }
                return;
            }
            if (C3250y.f11734b) {
                C3250y.m11450b("Save trunk to database.", f4775b);
            }
            C3159aa.m10962a().m10982a("notification_api_timestamp", Long.valueOf(Long.parseLong(notificationEntry.utctimestamp)));
            C3159aa.m10962a().m10982a("notification_api_event_timestamp", Long.valueOf(Long.parseLong(notificationEntry.utctimestamp)));
            for (Badge.Content content : notificationEntry.badge.contents) {
                if (C3250y.f11734b) {
                    C3250y.m11450b(C3364o.m11849a("Name: ", content.name, ", Count: " + content._value), f4775b);
                }
                if ("new_anicon_count".equals(content.name)) {
                    C3159aa.m10962a().m10984b("new_anicon_count", Integer.valueOf(C3159aa.m10962a().m10978a("new_anicon_count", (Integer) 0).intValue() + Integer.parseInt(content._value)));
                    LocalBroadcastManager.getInstance(CommonApplication.m11493l()).sendBroadcast(new Intent("more_tab_badge_update"));
                }
                if ("new_skin_count".equals(content.name)) {
                    C3159aa.m10962a().m10984b("new_skin_count", Integer.valueOf(C3159aa.m10962a().m10978a("new_skin_count", (Integer) 0).intValue() + Integer.parseInt(content._value)));
                    LocalBroadcastManager.getInstance(CommonApplication.m11493l()).sendBroadcast(new Intent("more_tab_badge_update"));
                }
                if ("new_font_count".equals(content.name)) {
                    C3159aa.m10962a().m10984b("new_font_count", Integer.valueOf(C3159aa.m10962a().m10978a("new_font_count", (Integer) 0).intValue() + Integer.parseInt(content._value)));
                    LocalBroadcastManager.getInstance(CommonApplication.m11493l()).sendBroadcast(new Intent("more_tab_badge_update"));
                }
                if ("new_sound_count".equals(content.name)) {
                    C3159aa.m10962a().m10984b("new_sound_count", Integer.valueOf(C3159aa.m10962a().m10978a("new_sound_count", (Integer) 0).intValue() + Integer.parseInt(content._value)));
                    LocalBroadcastManager.getInstance(CommonApplication.m11493l()).sendBroadcast(new Intent("more_tab_badge_update"));
                }
                if ("new_ams_template_count".equals(content.name)) {
                    C3159aa.m10962a().m10984b("new_ams_item_template_count", Integer.valueOf(C3159aa.m10962a().m10978a("new_ams_item_template_count", (Integer) 0).intValue() + Integer.parseInt(content._value)));
                    LocalBroadcastManager.getInstance(CommonApplication.m11493l()).sendBroadcast(new Intent("more_tab_badge_update"));
                }
                if ("new_ams_background_count".equals(content.name)) {
                    C3159aa.m10962a().m10984b("new_ams_item_background_count", Integer.valueOf(C3159aa.m10962a().m10978a("new_ams_item_background_count", (Integer) 0).intValue() + Integer.parseInt(content._value)));
                    LocalBroadcastManager.getInstance(CommonApplication.m11493l()).sendBroadcast(new Intent("more_tab_badge_update"));
                }
                if ("new_ams_stamp_count".equals(content.name)) {
                    C3159aa.m10962a().m10984b("new_ams_item_stamp_count", Integer.valueOf(C3159aa.m10962a().m10978a("new_ams_item_stamp_count", (Integer) 0).intValue() + Integer.parseInt(content._value)));
                    LocalBroadcastManager.getInstance(CommonApplication.m11493l()).sendBroadcast(new Intent("more_tab_badge_update"));
                }
                if ("new_poston_count".equals(content.name)) {
                    C3159aa.m10962a().m10984b("new_post_on_count", Integer.valueOf(Integer.parseInt(content._value) + C3159aa.m10962a().m10978a("new_post_on_count", (Integer) 0).intValue()));
                    C3250y.m11456e("My page totalNumBadge in Task: " + content._value, getClass().getSimpleName());
                    LocalBroadcastManager.getInstance(CommonApplication.m11493l()).sendBroadcast(new Intent("mypage_badge_update"));
                }
                if ("new_event_count".equals(content.name)) {
                    C3159aa.m10962a().m10984b("new_event_count", Integer.valueOf(C3159aa.m10962a().m10978a("new_event_count", (Integer) 0).intValue() + Integer.parseInt(content._value)));
                    LocalBroadcastManager.getInstance(CommonApplication.m11493l()).sendBroadcast(new Intent("more_event_update"));
                }
                if ("new_live_buddy_count".equals(content.name)) {
                    if (Integer.parseInt(content._value) > 0) {
                        new C1330h(null).m5752g();
                    }
                    C3159aa.m10962a().m10984b("new_livepartner_count", Integer.valueOf(Integer.parseInt(content._value) + C3159aa.m10962a().m10978a("new_livepartner_count", (Integer) 0).intValue()));
                    LocalBroadcastManager.getInstance(CommonApplication.m11493l()).sendBroadcast(new Intent("more_tab_badge_update"));
                }
                if ("new_feature_notice_count".equals(content.name)) {
                    int i = Integer.parseInt(content._value);
                    C3159aa.m10962a().m10984b("new_feature_count", Integer.valueOf(i));
                    JSONObject jSONObject = new JSONObject();
                    for (int i2 = 0; i2 < i; i2++) {
                        jSONObject.put(String.valueOf(i2), notificationEntry.newfeaturelist.feature.get(i2).value);
                    }
                    C3159aa.m10962a().m10986b("new_feature_url_list", jSONObject.toString());
                    LocalBroadcastManager.getInstance(CommonApplication.m11493l()).sendBroadcast(new Intent("new_feature_update"));
                }
            }
            if (!notificationEntry.trunklist.trunks.isEmpty()) {
                C2955f.m10432a(notificationEntry.trunklist.trunks);
            }
        }
    }
}
