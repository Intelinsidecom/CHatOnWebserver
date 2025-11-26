package com.sec.chaton.msgsend;

import android.content.Context;
import android.content.Intent;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p055d.C2119by;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p067j.p070c.C2442i;
import java.util.ArrayList;

/* compiled from: MsgSendGateway.java */
/* renamed from: com.sec.chaton.msgsend.x */
/* loaded from: classes.dex */
public class C2716x {

    /* renamed from: a */
    private static final String f9737a = C2716x.class.getSimpleName();

    /* renamed from: a */
    private static void m11376a(EnumC2710r enumC2710r, Intent intent) {
        Context contextR = GlobalApplication.m18732r();
        intent.putExtra("cmd", enumC2710r.m11351a());
        contextR.startService(intent);
    }

    /* renamed from: e */
    private static Intent m11391e() {
        return new Intent(GlobalApplication.m18732r(), (Class<?>) ChatONMessageService.class);
    }

    /* renamed from: a */
    private static void m11374a(EnumC2301u enumC2301u, String str, EnumC2300t enumC2300t, String[] strArr, long j, String str2, String str3, EnumC2214ab enumC2214ab, String str4, String str5, int i, EnumC2692aj enumC2692aj) {
        C2684ab.m11290a(f9737a, "Request Send Msg, chatType(%s), msgType(%s)", enumC2300t, enumC2214ab);
        ChatONMsgEntity chatONMsgEntity = new ChatONMsgEntity(j, enumC2214ab, str2, str3, str4, str5, i, enumC2692aj);
        Intent intentM11391e = m11391e();
        intentM11391e.putExtra(SlookAirButtonFrequentContactAdapter.DATA, chatONMsgEntity);
        intentM11391e.putExtra("inbox_no", str);
        intentM11391e.putExtra("chat_type", enumC2300t.m10210a());
        intentM11391e.putExtra("participants", strArr);
        intentM11391e.putExtra("roomtype", enumC2301u.m10212a());
        m11376a(EnumC2710r.CMD_ADD_MSG, intentM11391e);
    }

    /* renamed from: a */
    public static void m11375a(EnumC2689ag enumC2689ag) {
        C2684ab.m11290a(f9737a, "itsTimeToSend(), reason(%s)", enumC2689ag);
        if (!C2717y.m11398b()) {
            C2684ab.m11290a(f9737a, "Auto Resend is disabled, (ItsTimeToSend)", new Object[0]);
            return;
        }
        Intent intentM11391e = m11391e();
        intentM11391e.putExtra("send_retry_reason", enumC2689ag.m11295a());
        m11376a(EnumC2710r.CMD_TRY_TO_SEND_MSG, intentM11391e);
    }

    /* renamed from: a */
    public static void m11369a() {
        if (!C2717y.m11398b()) {
            C2684ab.m11290a(f9737a, "Auto Resend is disabled (isAutoResendEnabled)", new Object[0]);
            return;
        }
        Intent intentM11391e = m11391e();
        intentM11391e.putExtra("cmd_priority", 1);
        m11376a(EnumC2710r.CMD_LOAD_MSG, intentM11391e);
    }

    /* renamed from: a */
    public static void m11371a(int i, String str, C2119by c2119by, boolean z) {
        if (!C2717y.m11398b()) {
            C2684ab.m11290a(f9737a, "Auto Resend is disabled (setSErverResult)", new Object[0]);
            return;
        }
        C2704l c2704lM11323b = C2704l.m11322a().m11323b();
        C2707o.m11331b().m11339a(i, str, c2119by, z);
        C2684ab.m11290a(f9737a, "setServerResult(), %s", c2704lM11323b.m11324c());
    }

    /* renamed from: a */
    public static void m11370a(int i, int i2, int i3, C2442i c2442i) {
        if (!C2717y.m11398b()) {
            C2684ab.m11290a(f9737a, "Auto Resend is disabled (setFileUploadCompleteResult)", new Object[0]);
        } else {
            C2707o.m11331b().m11338a(i, i2, i3, c2442i);
        }
    }

    /* renamed from: b */
    public static void m11387b() {
        m11376a(EnumC2710r.CMD_PRINT_DEBUG, m11391e());
    }

    /* renamed from: a */
    public static void m11378a(String str, long j) {
        if (!C2717y.m11398b()) {
            C2684ab.m11290a(f9737a, "Auto Resend is disabled (deleteMsg_direct)", new Object[0]);
        } else {
            C2707o.m11331b().m11341a(str, j);
        }
    }

    /* renamed from: a */
    public static void m11377a(String str) {
        if (!C2717y.m11398b()) {
            C2684ab.m11290a(f9737a, "Auto Resend is disabled (deleteInbox_direct)", new Object[0]);
        } else {
            C2707o.m11331b().m11340a(str);
        }
    }

    /* renamed from: a */
    public static void m11383a(String str, ArrayList<Integer> arrayList) {
        if (!C2717y.m11398b()) {
            C2684ab.m11290a(f9737a, "Auto Resend is disabled (deleteAllMsgWithStatus)", new Object[0]);
        } else {
            C2707o.m11331b().m11345b(str, arrayList);
        }
    }

    /* renamed from: b */
    public static int m11385b(String str, ArrayList<Integer> arrayList) {
        if (!C2717y.m11398b()) {
            C2684ab.m11290a(f9737a, "Auto Resend is disabled (deleteInboxMsgExclude)", new Object[0]);
            return -1;
        }
        return C2707o.m11331b().m11333a(str, arrayList);
    }

    /* renamed from: c */
    public static void m11389c() {
        C2707o.m11331b().m11348d();
    }

    /* renamed from: a */
    public static boolean m11384a(String str, String str2) {
        return C2707o.m11331b().m11344a(str, str2);
    }

    /* renamed from: d */
    public static void m11390d() {
        m11389c();
    }

    /* renamed from: a */
    public static int m11368a(String str, ArrayList<Long> arrayList, ArrayList<Integer> arrayList2) {
        if (!C2717y.m11398b()) {
            C2684ab.m11290a(f9737a, "Auto Resend is disabled (deleteAllMsgWithExceptionMsgList)", new Object[0]);
            return -1;
        }
        return C2707o.m11331b().m11334a(str, arrayList, arrayList2);
    }

    /* renamed from: b */
    public static int m11386b(String str, ArrayList<Long> arrayList, ArrayList<Integer> arrayList2) {
        if (!C2717y.m11398b()) {
            C2684ab.m11290a(f9737a, "Auto Resend is disabled (deleteMsgWithTargetList)", new Object[0]);
            return -1;
        }
        return C2707o.m11331b().m11346b(str, arrayList, arrayList2);
    }

    /* renamed from: a */
    public static void m11372a(EnumC2301u enumC2301u, String str, EnumC2300t enumC2300t, long j, EnumC2214ab enumC2214ab, String str2, String str3, EnumC2692aj enumC2692aj, String[] strArr) {
        if (!C2717y.m11398b()) {
            C2684ab.m11290a(f9737a, "Auto Resend is disabled (insertSendMessageWithoutUpload)", new Object[0]);
        } else {
            m11374a(enumC2301u, str, enumC2300t, strArr, j, str2, str3, enumC2214ab, (String) null, (String) null, 0, enumC2692aj);
        }
    }

    /* renamed from: a */
    public static void m11373a(EnumC2301u enumC2301u, String str, EnumC2300t enumC2300t, long j, EnumC2214ab enumC2214ab, String str2, String str3, EnumC2692aj enumC2692aj, String[] strArr, String str4, int i, String str5) {
        if (!C2717y.m11398b()) {
            C2684ab.m11290a(f9737a, "Auto Resend is disabled insertMediaMessageWithUpload)", new Object[0]);
        } else {
            m11374a(enumC2301u, str, enumC2300t, strArr, j, str2, str3, enumC2214ab, str5, str4, i, enumC2692aj);
        }
    }

    /* renamed from: a */
    public static void m11382a(String str, long j, String str2) {
        if (!C2717y.m11398b()) {
            C2684ab.m11290a(f9737a, "Auto Resend is disabled, (update_updateAttchMessage)", new Object[0]);
        } else {
            m11381a(str, j, null, str2, null);
        }
    }

    /* renamed from: a */
    public static void m11379a(String str, long j, EnumC2692aj enumC2692aj) {
        if (!C2717y.m11398b()) {
            C2684ab.m11290a(f9737a, "Auto Resend is disabled, update_updateSentMessage)", new Object[0]);
        } else {
            C2707o.m11331b().m11342a(str, j, enumC2692aj, null, null);
        }
    }

    /* renamed from: a */
    public static void m11380a(String str, long j, EnumC2692aj enumC2692aj, Integer num) {
        if (!C2717y.m11398b()) {
            C2684ab.m11290a(f9737a, "Auto Resend is disabled (update_updateFileUploaded)", new Object[0]);
        } else {
            C2707o.m11331b().m11342a(str, j, enumC2692aj, null, num);
        }
    }

    /* renamed from: a */
    private static void m11381a(String str, long j, EnumC2692aj enumC2692aj, String str2, Integer num) {
        if (!C2717y.m11398b()) {
            C2684ab.m11290a(f9737a, "Auto Resend is disabled (updateStatus)", new Object[0]);
        } else {
            C2707o.m11331b().m11342a(str, j, enumC2692aj, str2, num);
        }
    }

    /* renamed from: b */
    public static void m11388b(String str, long j, String str2) {
        if (!C2717y.m11398b()) {
            C2684ab.m11290a(f9737a, "Auto Resend is disabled (update_messageContents)", new Object[0]);
        } else {
            C2707o.m11331b().m11343a(str, j, str2);
        }
    }
}
