package com.sec.chaton.global;

import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.sec.chaton.p049b.C1057b;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.plugin.C2948h;
import com.sec.chaton.plugin.EnumC2949i;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5034k;
import com.sec.common.util.C5052r;
import com.sec.spp.push.Config;
import java.util.HashMap;
import java.util.StringTokenizer;

/* compiled from: ChatOnFeature.java */
/* renamed from: com.sec.chaton.global.a */
/* loaded from: classes.dex */
public class C2349a {

    /* renamed from: a */
    private static boolean f8379a = false;

    /* renamed from: b */
    private static boolean f8380b = false;

    /* renamed from: c */
    private static HashMap<String, Boolean> f8381c = new HashMap<>();

    /* renamed from: a */
    public static void m10298a() {
        Boolean.valueOf(false);
        Boolean boolValueOf = Boolean.valueOf(m10309f());
        f8381c.put("tablet_enable_feature", boolValueOf);
        f8381c.put("logcollector_feature", false);
        f8381c.put("wifi_80_port", true);
        f8381c.put("auto_regi_feature", true);
        f8381c.put("local_backup_feature", true);
        f8381c.put("poll", false);
        f8381c.put("chatonv_feature", true);
        f8381c.put("for_wifi_only_device", Boolean.valueOf(m10308e()));
        f8381c.put("support_contact_auto_sync", false);
        f8381c.put("support_facebook", true);
        f8381c.put("broadcast2_feature", true);
        f8381c.put("live_chat_feature", true);
        f8381c.put("tabletdb_interg_feature", boolValueOf);
        f8381c.put("push_message_encrypt_feature", true);
        f8381c.put("main_icon_badge_feature", true);
        f8381c.put("full_image_feature", true);
        f8381c.put("active_connection_feature", true);
        f8381c.put("chatroom_web_only_feature", false);
        f8381c.put("mirror_ack_feature", true);
        f8381c.put("chat_receiver_1000", true);
        f8381c.put("chatroom_draw_menu_feature", false);
        f8381c.put("privacy_lite_feature", false);
        f8381c.put("gcm_push_feature", true);
        f8381c.put("chat_batch_push_feature", true);
        f8381c.put("web_login_info_feature", true);
        f8381c.put("chat_message_withdraw", true);
        if (boolValueOf.booleanValue() && Build.VERSION.SDK_INT >= 17) {
            long jM6155a = C1057b.m6155a();
            if (jM6155a >= 0) {
                f8381c.put("mum_enable_feature", true);
                if (jM6155a > 0) {
                    f8381c.put("for_wifi_only_device", true);
                }
            } else {
                f8381c.put("mum_enable_feature", false);
            }
        } else {
            f8381c.put("mum_enable_feature", false);
        }
        f8381c.put("log_by_shipbuild", false);
        f8381c.put("chaton_qmlog_sending", Boolean.valueOf(m10307d()));
        if (C1427a.f5070h && !C4809aa.m18104a().m18119a("sms_feature", (Boolean) false).booleanValue()) {
            if (C4904y.f17872b) {
                C4904y.m18639b("re-checking SMS feature due to ChatON upgrading", "ChatOnFeature");
            }
            C4809aa.m18104a().m18123a("sms_feature");
        }
        f8381c.put("log_collector", true);
        f8381c.put("sms_feature", C4809aa.m18104a().m18119a("sms_feature", (Boolean) false));
        f8381c.put("default_sms_feature", C4809aa.m18104a().m18119a("chaton_default_sms_feature", (Boolean) false));
        f8381c.put("chaton_translator", C4809aa.m18104a().m18119a("chaton_trans_enable_feature", (Boolean) true));
        f8381c.put("translate_language_arabic", C4809aa.m18104a().m18119a("chaton_trans_arabic_feature", (Boolean) false));
        f8381c.put("translate_language_hindi", C4809aa.m18104a().m18119a("chaton_trans_hindi_feature", (Boolean) false));
        f8381c.put("translate_language_turkish", C4809aa.m18104a().m18119a("chaton_trans_turkish_feature", (Boolean) false));
        f8381c.put("translate_language_farsi", C4809aa.m18104a().m18119a("chaton_trans_farsi_feature", (Boolean) false));
    }

    /* renamed from: d */
    private static boolean m10307d() {
        int length;
        String[] strArrSplit = C1427a.f5064b.split("[.]");
        return strArrSplit.length == 3 && (length = strArrSplit[2].length()) > 1 && strArrSplit[2].substring(length + (-1), length).equals("L");
    }

    /* renamed from: a */
    public static void m10300a(boolean z, boolean z2) {
        f8379a = z;
        f8380b = z2;
    }

    /* renamed from: a */
    public static boolean m10302a(boolean z) {
        if (C4822an.m18196F() || f8380b) {
            z = false;
        }
        if (f8379a && !m10308e()) {
            z = true;
        }
        if (Build.VERSION.SDK_INT < 14) {
            return false;
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m10301a(String str) {
        if (str == null || !f8381c.containsKey(str)) {
            return false;
        }
        return f8381c.get(str).booleanValue();
    }

    /* renamed from: e */
    private static boolean m10308e() {
        boolean z;
        TelephonyManager telephonyManager = (TelephonyManager) GlobalApplication.m18732r().getSystemService("phone");
        String deviceId = telephonyManager.getDeviceId();
        boolean zHasSystemFeature = GlobalApplication.m18732r().getPackageManager().hasSystemFeature("android.hardware.telephony");
        if (TextUtils.isEmpty(deviceId)) {
            z = true;
        } else {
            z = (Build.MANUFACTURER == null || !Build.MANUFACTURER.contains("samsung") || C5034k.m19095a(GlobalApplication.m18732r(), "com.android.mms")) ? false : true;
            if (m10309f() && telephonyManager.getSimState() != 5) {
                z = true;
            }
        }
        if (C4904y.f17872b) {
            C4904y.m18639b(C5052r.m19199a(" IMEI : ", deviceId, " supportTEL : ", Boolean.valueOf(zHasSystemFeature), " manufacturer : ", Build.MANUFACTURER, " isSimCard : ", Integer.valueOf(telephonyManager.getSimState()), " isWifiOnlyDevice : ", Boolean.valueOf(z)), "isWifiOnlyDevice");
        }
        return z;
    }

    /* renamed from: f */
    private static boolean m10309f() {
        Boolean bool = false;
        return bool.booleanValue();
    }

    /* renamed from: b */
    public static void m10303b() {
        if (f8381c.containsKey("sms_feature")) {
            f8381c.remove("sms_feature");
        }
        C4809aa.m18104a().m18125b("sms_feature", (Boolean) false);
        f8381c.put("sms_feature", false);
    }

    /* renamed from: c */
    public static void m10305c() {
        if (f8381c.containsKey("sms_feature")) {
            f8381c.remove("sms_feature");
        }
        C4809aa.m18104a().m18125b("sms_feature", (Boolean) true);
        f8381c.put("sms_feature", true);
    }

    /* renamed from: a */
    public static void m10299a(String str, String str2, boolean z) {
        if (str.equals("sms_feature")) {
            if (f8381c.containsKey("sms_feature")) {
                f8381c.remove("sms_feature");
            }
            boolean zBooleanValue = C4809aa.m18104a().m18119a("sms_feature", (Boolean) false).booleanValue();
            boolean zM10302a = m10302a(Boolean.parseBoolean(str2));
            if (str.equals("sms_feature")) {
                C4904y.m18639b("SMSFEATURE newPolicy:  " + zM10302a, "ChatOnFeature");
                C4904y.m18639b("SMSFEATURE currentPolicy:  " + zBooleanValue, "ChatOnFeature");
                if (zBooleanValue && !zM10302a) {
                    C4809aa.m18104a().m18128b("sms_feature_changes_gld", Spam.ACTIVITY_REPORT);
                    C4904y.m18639b("SMSFEATURE deleteAllContactBuddy ", "ChatOnFeature");
                } else if (!zBooleanValue && zM10302a) {
                    C4809aa.m18104a().m18128b("sms_feature_changes_gld", Spam.ACTIVITY_CHECK);
                    C4904y.m18639b("SMSFEATURE deleteAllContact ", "ChatOnFeature");
                }
            }
            C4809aa.m18104a().m18125b("sms_feature", Boolean.valueOf(zM10302a));
            f8381c.put("sms_feature", Boolean.valueOf(zM10302a));
            return;
        }
        if (str.equals("default_sms_feature")) {
            if (f8381c.containsKey("default_sms_feature")) {
                f8381c.remove("default_sms_feature");
            }
            C4809aa.m18104a().m18125b("chaton_default_sms_feature", Boolean.valueOf(Boolean.parseBoolean(str2)));
            f8381c.put("default_sms_feature", Boolean.valueOf(Boolean.parseBoolean(str2)));
            return;
        }
        if (str.equals("large_file_enable")) {
            if (f8379a) {
                C4809aa.m18104a().m18125b("large_file_enable", (Boolean) true);
                return;
            } else {
                C4809aa.m18104a().m18125b("large_file_enable", Boolean.valueOf(Boolean.parseBoolean(str2)));
                return;
            }
        }
        if (str.equals("free_message_enable")) {
            C4809aa.m18104a().m18125b("free_message_enable", Boolean.valueOf(Boolean.parseBoolean(str2)));
            return;
        }
        if (str.equals("free_message_count")) {
            C4809aa.m18104a().m18126b("free_message_count", Integer.valueOf(Integer.parseInt(str2)));
            return;
        }
        if (str.equals("sns_facebook_feature")) {
            if (f8379a) {
                C4809aa.m18104a().m18125b("chaton_sns_facebook_feature", (Boolean) true);
                return;
            } else {
                C4809aa.m18104a().m18125b("chaton_sns_facebook_feature", Boolean.valueOf(Boolean.parseBoolean(str2)));
                return;
            }
        }
        if (str.equals("sns_vkontakte_feature")) {
            if (f8379a) {
                C4809aa.m18104a().m18125b("chaton_sns_vkontakte_feature", (Boolean) true);
                return;
            } else {
                C4809aa.m18104a().m18125b("chaton_sns_vkontakte_feature", Boolean.valueOf(Boolean.parseBoolean(str2)));
                return;
            }
        }
        if (str.equals("sns_odnok_feature")) {
            if (f8379a) {
                C4809aa.m18104a().m18125b("chaton_sns_odnok_feature", (Boolean) true);
                return;
            } else {
                C4809aa.m18104a().m18125b("chaton_sns_odnok_feature", Boolean.valueOf(Boolean.parseBoolean(str2)));
                return;
            }
        }
        if (str.equals("translate_language_list")) {
            m10306c(str2);
        } else if (str.equals("chaton_translate_enable")) {
            m10304b(str2);
        }
    }

    /* renamed from: b */
    public static void m10304b(String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("Translation Enable Policy : " + str, "ChatOnFeature");
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                boolean z = Boolean.parseBoolean(str);
                if (f8381c.containsKey("chaton_translator")) {
                    if (f8381c.get("chaton_translator").booleanValue() != z) {
                        f8381c.remove("chaton_translator");
                    } else {
                        return;
                    }
                }
                C4809aa.m18104a().m18125b("chaton_trans_enable_feature", Boolean.valueOf(z));
                f8381c.put("chaton_translator", Boolean.valueOf(z));
                if (!z && !C2948h.m12190a().m12192a(CommonApplication.m18732r(), EnumC2949i.STranslator)) {
                    C2198l.m9927a();
                }
            }
        } catch (Exception e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, "ChatOnFeature");
            }
        }
    }

    /* renamed from: c */
    public static void m10306c(String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("Translation GLD Policy : " + str, "ChatOnFeature");
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                StringTokenizer stringTokenizer = new StringTokenizer(str, Config.KEYVALUE_SPLIT);
                new String();
                String str2 = new String();
                String str3 = new String();
                while (stringTokenizer.hasMoreTokens()) {
                    StringTokenizer stringTokenizer2 = new StringTokenizer(stringTokenizer.nextToken(), "=");
                    if (stringTokenizer2.hasMoreTokens()) {
                        str2 = stringTokenizer2.nextToken();
                        if (stringTokenizer2.hasMoreTokens()) {
                            str3 = stringTokenizer2.nextToken();
                        }
                    }
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                        if (str2.equals("ar") || str2.equals("ar-SA")) {
                            if (f8381c.containsKey("translate_language_arabic")) {
                                f8381c.remove("translate_language_arabic");
                            }
                            boolean z = Boolean.parseBoolean(str3);
                            C4809aa.m18104a().m18125b("chaton_trans_arabic_feature", Boolean.valueOf(z));
                            f8381c.put("translate_language_arabic", Boolean.valueOf(z));
                        } else if (str2.equals("hi-IN")) {
                            if (f8381c.containsKey("translate_language_hindi")) {
                                f8381c.remove("translate_language_hindi");
                            }
                            boolean z2 = Boolean.parseBoolean(str3);
                            C4809aa.m18104a().m18125b("chaton_trans_hindi_feature", Boolean.valueOf(z2));
                            f8381c.put("translate_language_hindi", Boolean.valueOf(z2));
                        } else if (str2.equals("tr-TR")) {
                            if (f8381c.containsKey("translate_language_turkish")) {
                                f8381c.remove("translate_language_turkish");
                            }
                            boolean z3 = Boolean.parseBoolean(str3);
                            C4809aa.m18104a().m18125b("chaton_trans_turkish_feature", Boolean.valueOf(z3));
                            f8381c.put("translate_language_turkish", Boolean.valueOf(z3));
                        } else if (str2.equals("fa-IR")) {
                            if (f8381c.containsKey("translate_language_farsi")) {
                                f8381c.remove("translate_language_farsi");
                            }
                            boolean z4 = Boolean.parseBoolean(str3);
                            C4809aa.m18104a().m18125b("chaton_trans_farsi_feature", Boolean.valueOf(z4));
                            f8381c.put("translate_language_farsi", Boolean.valueOf(z4));
                        }
                    }
                    str2 = "";
                    str3 = "";
                }
            }
        } catch (Exception e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, "ChatOnFeature");
            }
        }
    }
}
