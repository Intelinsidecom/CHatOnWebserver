package com.sec.chaton.p055d.p056a;

import android.content.Intent;
import android.support.v4.content.C0096i;
import android.text.TextUtils;
import android.util.Xml;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p057e.p058a.C2177ac;
import com.sec.chaton.p065io.entry.NotificationEntry;
import com.sec.chaton.p065io.entry.inner.Badge;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.trunk.p118a.p119a.C4571f;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5034k;
import com.sec.common.util.C5052r;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: NotificationTask.java */
/* renamed from: com.sec.chaton.d.a.dw */
/* loaded from: classes.dex */
public class C2004dw extends AbstractC1900a {

    /* renamed from: b */
    private static final String f7365b = C2004dw.class.getSimpleName();

    public C2004dw(C2454e c2454e) {
        super(c2454e);
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() throws IllegalStateException, IOException, IllegalArgumentException {
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        try {
            long jM18118a = C4809aa.m18104a().m18118a("notification_api_timestamp", 0L);
            xmlSerializerNewSerializer.setOutput(stringWriter);
            xmlSerializerNewSerializer.startDocument("UTF-8", true);
            xmlSerializerNewSerializer.startTag("", "param");
            xmlSerializerNewSerializer.startTag("", "timestamp");
            xmlSerializerNewSerializer.text(String.valueOf(jM18118a));
            xmlSerializerNewSerializer.endTag("", "timestamp");
            xmlSerializerNewSerializer.startTag("", "iso2");
            xmlSerializerNewSerializer.text(C4822an.m18257y());
            xmlSerializerNewSerializer.endTag("", "iso2");
            xmlSerializerNewSerializer.startTag("", "language");
            xmlSerializerNewSerializer.text(C4822an.m18247o());
            xmlSerializerNewSerializer.endTag("", "language");
            xmlSerializerNewSerializer.startTag("", "platform");
            xmlSerializerNewSerializer.text("android");
            xmlSerializerNewSerializer.endTag("", "platform");
            xmlSerializerNewSerializer.startTag("", "appversion");
            xmlSerializerNewSerializer.text(C1427a.f5063a);
            xmlSerializerNewSerializer.endTag("", "appversion");
            xmlSerializerNewSerializer.startTag("", "model");
            xmlSerializerNewSerializer.text(URLEncoder.encode(C4822an.m18231e()));
            xmlSerializerNewSerializer.endTag("", "model");
            xmlSerializerNewSerializer.startTag("", "width");
            xmlSerializerNewSerializer.text(String.valueOf(C5034k.m19100e()));
            xmlSerializerNewSerializer.endTag("", "width");
            xmlSerializerNewSerializer.startTag("", "height");
            xmlSerializerNewSerializer.text(String.valueOf(C5034k.m19101f()));
            xmlSerializerNewSerializer.endTag("", "height");
            xmlSerializerNewSerializer.startTag("", "themeid");
            xmlSerializerNewSerializer.text(C4809aa.m18104a().m18121a("seasonal_theme_last_downloaded_id", ""));
            xmlSerializerNewSerializer.endTag("", "themeid");
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
            if (!C4809aa.m18104a().m18129b("notification_api_event_timestamp")) {
                xmlSerializerNewSerializer.attribute("", "timestamp", String.valueOf(C4809aa.m18104a().m18118a("notification_api_event_timestamp", 1L)));
            }
            xmlSerializerNewSerializer.text("badge.new_event_count");
            xmlSerializerNewSerializer.endTag("", "option");
            xmlSerializerNewSerializer.startTag("", "option");
            if (jM18118a <= 0) {
                xmlSerializerNewSerializer.attribute("", "timestamp", Spam.ACTIVITY_REPORT);
            }
            xmlSerializerNewSerializer.text("badge.new_live_buddy_count");
            xmlSerializerNewSerializer.endTag("", "option");
            xmlSerializerNewSerializer.startTag("", "option");
            xmlSerializerNewSerializer.attribute("", "timestamp", String.valueOf(C4809aa.m18104a().m18118a("new_feature_dont_show_check_time", 137109010100L)));
            xmlSerializerNewSerializer.text("badge.new_feature_notice_count");
            xmlSerializerNewSerializer.endTag("", "option");
            xmlSerializerNewSerializer.startTag("", "option");
            xmlSerializerNewSerializer.attribute("", "timestamp", String.valueOf(System.currentTimeMillis()));
            xmlSerializerNewSerializer.text("badge.new_seasonal_theme_count");
            xmlSerializerNewSerializer.endTag("", "option");
            xmlSerializerNewSerializer.startTag("", "option");
            xmlSerializerNewSerializer.text("badge.new_game_count");
            xmlSerializerNewSerializer.endTag("", "option");
            xmlSerializerNewSerializer.startTag("", "option");
            xmlSerializerNewSerializer.attribute("", "timestamp", String.valueOf(C4809aa.m18104a().m18118a("get_myfollowing_buddies_timestamp", 0L)));
            xmlSerializerNewSerializer.text("badge.new_live_following_count");
            xmlSerializerNewSerializer.endTag("", "option");
            if (C2349a.m10301a("web_login_info_feature")) {
                xmlSerializerNewSerializer.startTag("", "option");
                xmlSerializerNewSerializer.text("service.web_login_info");
                xmlSerializerNewSerializer.endTag("", "option");
            }
            xmlSerializerNewSerializer.startTag("", "option");
            xmlSerializerNewSerializer.text("badge.new_promotion_count");
            xmlSerializerNewSerializer.endTag("", "option");
            xmlSerializerNewSerializer.endTag("", "options");
            xmlSerializerNewSerializer.endTag("", "param");
            xmlSerializerNewSerializer.endDocument();
            if (C4904y.f17872b) {
                C4904y.m18639b(stringWriter.toString(), f7365b);
            }
            return stringWriter.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) throws JSONException, NumberFormatException {
        if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
            NotificationEntry notificationEntry = (NotificationEntry) c0778b.m3110e();
            if (notificationEntry == null) {
                if (C4904y.f17875e) {
                    C4904y.m18634a("Http result object is null.", f7365b);
                    return;
                }
                return;
            }
            if (C4904y.f17872b) {
                C4904y.m18639b("Save trunk to database.", f7365b);
            }
            C4809aa.m18104a().m18124a("notification_api_timestamp", Long.valueOf(Long.parseLong(notificationEntry.utctimestamp)));
            C4809aa.m18104a().m18124a("notification_api_event_timestamp", Long.valueOf(Long.parseLong(notificationEntry.utctimestamp)));
            for (Badge.Content content : notificationEntry.badge.contents) {
                if (C4904y.f17872b) {
                    C4904y.m18639b(C5052r.m19199a("Name: ", content.name, ", Count: " + content._value), f7365b);
                }
                if ("new_anicon_count".equals(content.name)) {
                    C4809aa.m18104a().m18126b("new_anicon_count", Integer.valueOf(C4809aa.m18104a().m18120a("new_anicon_count", (Integer) 0).intValue() + Integer.parseInt(content._value)));
                    C0096i.m358a(CommonApplication.m18732r()).m363a(new Intent("more_tab_badge_update"));
                }
                if ("new_skin_count".equals(content.name)) {
                    C4809aa.m18104a().m18126b("new_skin_count", Integer.valueOf(C4809aa.m18104a().m18120a("new_skin_count", (Integer) 0).intValue() + Integer.parseInt(content._value)));
                    C0096i.m358a(CommonApplication.m18732r()).m363a(new Intent("more_tab_badge_update"));
                }
                if ("new_font_count".equals(content.name)) {
                    C4809aa.m18104a().m18126b("new_font_count", Integer.valueOf(C4809aa.m18104a().m18120a("new_font_count", (Integer) 0).intValue() + Integer.parseInt(content._value)));
                    C0096i.m358a(CommonApplication.m18732r()).m363a(new Intent("more_tab_badge_update"));
                }
                if ("new_sound_count".equals(content.name)) {
                    C4809aa.m18104a().m18126b("new_sound_count", Integer.valueOf(C4809aa.m18104a().m18120a("new_sound_count", (Integer) 0).intValue() + Integer.parseInt(content._value)));
                    C0096i.m358a(CommonApplication.m18732r()).m363a(new Intent("more_tab_badge_update"));
                }
                if ("new_ams_template_count".equals(content.name)) {
                    C4809aa.m18104a().m18126b("new_ams_item_template_count", Integer.valueOf(C4809aa.m18104a().m18120a("new_ams_item_template_count", (Integer) 0).intValue() + Integer.parseInt(content._value)));
                    C0096i.m358a(CommonApplication.m18732r()).m363a(new Intent("more_tab_badge_update"));
                }
                if ("new_ams_background_count".equals(content.name)) {
                    C4809aa.m18104a().m18126b("new_ams_item_background_count", Integer.valueOf(C4809aa.m18104a().m18120a("new_ams_item_background_count", (Integer) 0).intValue() + Integer.parseInt(content._value)));
                    C0096i.m358a(CommonApplication.m18732r()).m363a(new Intent("more_tab_badge_update"));
                }
                if ("new_ams_stamp_count".equals(content.name)) {
                    C4809aa.m18104a().m18126b("new_ams_item_stamp_count", Integer.valueOf(C4809aa.m18104a().m18120a("new_ams_item_stamp_count", (Integer) 0).intValue() + Integer.parseInt(content._value)));
                    C0096i.m358a(CommonApplication.m18732r()).m363a(new Intent("more_tab_badge_update"));
                }
                if ("new_poston_count".equals(content.name)) {
                    C4809aa.m18104a().m18126b("new_post_on_count", Integer.valueOf(Integer.parseInt(content._value) + C4809aa.m18104a().m18120a("new_post_on_count", (Integer) 0).intValue()));
                    C4904y.m18646e("My page totalNumBadge in Task: " + content._value, getClass().getSimpleName());
                    C0096i.m358a(CommonApplication.m18732r()).m363a(new Intent("mypage_badge_update"));
                }
                if ("new_event_count".equals(content.name)) {
                    C4809aa.m18104a().m18126b("new_event_count", Integer.valueOf(C4809aa.m18104a().m18120a("new_event_count", (Integer) 0).intValue() + Integer.parseInt(content._value)));
                    C0096i.m358a(CommonApplication.m18732r()).m363a(new Intent("more_event_update"));
                }
                if ("new_live_buddy_count".equals(content.name)) {
                    if (Integer.parseInt(content._value) > 0) {
                    }
                    C4809aa.m18104a().m18126b("new_livepartner_count", Integer.valueOf(Integer.parseInt(content._value) + C4809aa.m18104a().m18120a("new_livepartner_count", (Integer) 0).intValue()));
                    C0096i.m358a(CommonApplication.m18732r()).m363a(new Intent("more_tab_badge_update"));
                }
                if ("new_feature_notice_count".equals(content.name)) {
                    int i = Integer.parseInt(content._value);
                    C4809aa.m18104a().m18126b("new_feature_count", Integer.valueOf(i));
                    JSONObject jSONObject = new JSONObject();
                    for (int i2 = 0; i2 < i; i2++) {
                        jSONObject.put(String.valueOf(i2), notificationEntry.newfeaturelist.feature.get(i2).value);
                    }
                    C4809aa.m18104a().m18128b("new_feature_url_list", jSONObject.toString());
                    C4809aa.m18104a().m18125b("new_feature_ready_to_show", (Boolean) true);
                }
                if ("new_seasonal_theme_count".equals(content.name)) {
                    int i3 = Integer.parseInt(content._value);
                    C4809aa.m18104a().m18126b("new_seasonal_theme_count", Integer.valueOf(i3));
                    String strM18121a = C4809aa.m18104a().m18121a("seasonal_theme_last_downloaded_id", "");
                    for (int i4 = 0; i4 < i3; i4++) {
                        String str = notificationEntry.themelist.theme.get(i4)._id;
                        if (!TextUtils.isEmpty(str) && !str.equals(strM18121a)) {
                            C4809aa.m18104a().m18128b("new_seasonal_theme_id", notificationEntry.themelist.theme.get(i4)._id);
                            C4809aa.m18104a().m18128b("new_seasonal_theme_start", notificationEntry.themelist.theme.get(i4)._from);
                            C4809aa.m18104a().m18128b("new_seasonal_theme_end", notificationEntry.themelist.theme.get(i4)._to);
                            C4809aa.m18104a().m18128b("new_seasonal_theme_url", notificationEntry.themelist.theme.get(i4).value);
                            C0096i.m358a(CommonApplication.m18732r()).m363a(new Intent("splash_update"));
                        }
                    }
                }
                if ("new_game_count".equals(content.name)) {
                    C4809aa.m18104a().m18126b("new_game_count", Integer.valueOf(C4809aa.m18104a().m18120a("new_game_count", (Integer) 0).intValue() + Integer.parseInt(content._value)));
                    C0096i.m358a(CommonApplication.m18732r()).m363a(new Intent("more_tab_badge_update"));
                }
                if ("new_live_following_count".equals(content.name) && Integer.parseInt(content._value) > 0) {
                    new C2128i(null).m9515c();
                }
                if ("new_promotion_count".equals(content.name)) {
                    if (notificationEntry.promotionlist != null && notificationEntry.promotionlist.promotions != null && notificationEntry.promotionlist.promotions.size() > 0) {
                        C2177ac.m9707a(notificationEntry.promotionlist.promotions);
                    }
                    C4809aa.m18104a().m18126b("new_promotion_count", Integer.valueOf(Integer.parseInt(content._value) + C4809aa.m18104a().m18120a("new_promotion_count", (Integer) 0).intValue()));
                    C0096i.m358a(CommonApplication.m18732r()).m363a(new Intent("promotion_event_update"));
                }
            }
            if (!notificationEntry.trunklist.trunks.isEmpty()) {
                C4571f.m17528a(notificationEntry.trunklist.trunks);
            }
            if (C2349a.m10301a("web_login_info_feature")) {
                if (C4904y.f17872b) {
                    C4904y.m18639b(String.valueOf(notificationEntry.weblogininfo.needsync), f7365b);
                }
                C4809aa.m18104a().m18125b("weblogin_info_needsync", notificationEntry.weblogininfo.needsync);
            }
        }
    }
}
