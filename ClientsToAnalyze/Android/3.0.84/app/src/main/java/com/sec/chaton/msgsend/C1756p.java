package com.sec.chaton.msgsend;

import android.content.Context;
import android.content.Intent;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C1323bi;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p037j.p040c.C1565k;
import java.util.ArrayList;

/* compiled from: MsgSendGateway.java */
/* renamed from: com.sec.chaton.msgsend.p */
/* loaded from: classes.dex */
public class C1756p {

    /* renamed from: a */
    private static final String f6474a = C1756p.class.getSimpleName();

    /* renamed from: a */
    private static void m7228a(EnumC1755o enumC1755o, Intent intent) {
        Context contextL = GlobalApplication.m11493l();
        intent.putExtra("cmd", enumC1755o.m7223a());
        contextL.startService(intent);
    }

    /* renamed from: e */
    private static Intent m7246e() {
        return new Intent(GlobalApplication.m11493l(), (Class<?>) ChatONMessageService.class);
    }

    /* renamed from: a */
    private static void m7238a(String str, EnumC1450r enumC1450r, String[] strArr, long j, String str2, String str3, EnumC1455w enumC1455w, String str4, String str5, int i, EnumC1741aa enumC1741aa) {
        C1759s.m7260a(f6474a, "Request Send Msg, chatType(%s), msgType(%s)", enumC1450r, enumC1455w);
        ChatONMsgEntity chatONMsgEntity = new ChatONMsgEntity(j, enumC1455w, str2, str3, str4, str5, i, enumC1741aa);
        Intent intentM7246e = m7246e();
        intentM7246e.putExtra(SlookAirButtonFrequentContactAdapter.DATA, chatONMsgEntity);
        intentM7246e.putExtra("inbox_no", str);
        intentM7246e.putExtra("chat_type", enumC1450r.m6342a());
        intentM7246e.putExtra("participants", strArr);
        m7228a(EnumC1755o.CMD_ADD_MSG, intentM7246e);
    }

    /* renamed from: a */
    public static void m7229a(EnumC1764x enumC1764x) {
        C1759s.m7260a(f6474a, "itsTimeToSend(), reason(%s)", enumC1764x);
        if (!C1757q.m7251b()) {
            C1759s.m7260a(f6474a, "Auto Resend is disabled, (ItsTimeToSend)", new Object[0]);
            return;
        }
        Intent intentM7246e = m7246e();
        intentM7246e.putExtra("send_retry_reason", enumC1764x.m7265a());
        m7228a(EnumC1755o.CMD_TRY_TO_SEND_MSG, intentM7246e);
    }

    /* renamed from: a */
    public static void m7225a() {
        if (!C1757q.m7251b()) {
            C1759s.m7260a(f6474a, "Auto Resend is disabled (isAutoResendEnabled)", new Object[0]);
            return;
        }
        Intent intentM7246e = m7246e();
        intentM7246e.putExtra("cmd_priority", 1);
        m7228a(EnumC1755o.CMD_LOAD_MSG, intentM7246e);
    }

    /* renamed from: a */
    public static void m7227a(int i, String str, C1323bi c1323bi, boolean z) {
        if (!C1757q.m7251b()) {
            C1759s.m7260a(f6474a, "Auto Resend is disabled (setSErverResult)", new Object[0]);
            return;
        }
        C1749i c1749iM7196b = C1749i.m7195a().m7196b();
        C1752l.m7203b().m7212a(i, str, c1323bi, z);
        C1759s.m7260a(f6474a, "setServerResult(), %s", c1749iM7196b.m7197c());
    }

    /* renamed from: a */
    public static void m7226a(int i, int i2, int i3, C1565k c1565k) {
        if (!C1757q.m7251b()) {
            C1759s.m7260a(f6474a, "Auto Resend is disabled (setFileUploadCompleteResult)", new Object[0]);
        } else {
            C1752l.m7203b().m7211a(i, i2, i3, c1565k);
        }
    }

    /* renamed from: b */
    public static void m7242b() {
        m7228a(EnumC1755o.CMD_PRINT_DEBUG, m7246e());
    }

    /* renamed from: a */
    public static void m7231a(String str, long j) {
        if (!C1757q.m7251b()) {
            C1759s.m7260a(f6474a, "Auto Resend is disabled (deleteMsg_direct)", new Object[0]);
        } else {
            C1752l.m7203b().m7214a(str, j);
        }
    }

    /* renamed from: a */
    public static void m7230a(String str) {
        if (!C1757q.m7251b()) {
            C1759s.m7260a(f6474a, "Auto Resend is disabled (deleteInbox_direct)", new Object[0]);
        } else {
            C1752l.m7203b().m7213a(str);
        }
    }

    /* renamed from: a */
    public static void m7239a(String str, ArrayList<Integer> arrayList) {
        if (!C1757q.m7251b()) {
            C1759s.m7260a(f6474a, "Auto Resend is disabled (deleteAllMsgWithStatus)", new Object[0]);
        } else {
            C1752l.m7203b().m7217b(str, arrayList);
        }
    }

    /* renamed from: b */
    public static int m7240b(String str, ArrayList<Integer> arrayList) {
        if (!C1757q.m7251b()) {
            C1759s.m7260a(f6474a, "Auto Resend is disabled (deleteInboxMsgExclude)", new Object[0]);
            return -1;
        }
        return C1752l.m7203b().m7206a(str, arrayList);
    }

    /* renamed from: c */
    public static void m7244c() {
        C1752l.m7203b().m7220d();
    }

    /* renamed from: d */
    public static void m7245d() {
        m7244c();
    }

    /* renamed from: a */
    public static int m7224a(String str, ArrayList<Long> arrayList, ArrayList<Integer> arrayList2) {
        if (!C1757q.m7251b()) {
            C1759s.m7260a(f6474a, "Auto Resend is disabled (deleteAllMsgWithExceptionMsgList)", new Object[0]);
            return -1;
        }
        return C1752l.m7203b().m7207a(str, arrayList, arrayList2);
    }

    /* renamed from: b */
    public static int m7241b(String str, ArrayList<Long> arrayList, ArrayList<Integer> arrayList2) {
        if (!C1757q.m7251b()) {
            C1759s.m7260a(f6474a, "Auto Resend is disabled (deleteMsgWithTargetList)", new Object[0]);
            return -1;
        }
        return C1752l.m7203b().m7218b(str, arrayList, arrayList2);
    }

    /* renamed from: a */
    public static void m7236a(String str, EnumC1450r enumC1450r, long j, EnumC1455w enumC1455w, String str2, String str3, EnumC1741aa enumC1741aa, String[] strArr) {
        if (!C1757q.m7251b()) {
            C1759s.m7260a(f6474a, "Auto Resend is disabled (insertSendMessageWithoutUpload)", new Object[0]);
        } else {
            m7238a(str, enumC1450r, strArr, j, str2, str3, enumC1455w, (String) null, (String) null, 0, enumC1741aa);
        }
    }

    /* renamed from: a */
    public static void m7237a(String str, EnumC1450r enumC1450r, long j, EnumC1455w enumC1455w, String str2, String str3, EnumC1741aa enumC1741aa, String[] strArr, String str4, int i, String str5) {
        if (!C1757q.m7251b()) {
            C1759s.m7260a(f6474a, "Auto Resend is disabled insertMediaMessageWithUpload)", new Object[0]);
        } else {
            m7238a(str, enumC1450r, strArr, j, str2, str3, enumC1455w, str5, str4, i, enumC1741aa);
        }
    }

    /* renamed from: a */
    public static void m7235a(String str, long j, String str2) {
        if (!C1757q.m7251b()) {
            C1759s.m7260a(f6474a, "Auto Resend is disabled, (update_updateAttchMessage)", new Object[0]);
        } else {
            m7234a(str, j, null, str2, null);
        }
    }

    /* renamed from: a */
    public static void m7232a(String str, long j, EnumC1741aa enumC1741aa) {
        if (!C1757q.m7251b()) {
            C1759s.m7260a(f6474a, "Auto Resend is disabled, update_updateSentMessage)", new Object[0]);
        } else {
            C1752l.m7203b().m7215a(str, j, enumC1741aa, (String) null, (Integer) null);
        }
    }

    /* renamed from: a */
    public static void m7233a(String str, long j, EnumC1741aa enumC1741aa, Integer num) {
        if (!C1757q.m7251b()) {
            C1759s.m7260a(f6474a, "Auto Resend is disabled (update_updateFileUploaded)", new Object[0]);
        } else {
            C1752l.m7203b().m7215a(str, j, enumC1741aa, (String) null, num);
        }
    }

    /* renamed from: a */
    private static void m7234a(String str, long j, EnumC1741aa enumC1741aa, String str2, Integer num) {
        if (!C1757q.m7251b()) {
            C1759s.m7260a(f6474a, "Auto Resend is disabled (updateStatus)", new Object[0]);
        } else {
            C1752l.m7203b().m7215a(str, j, enumC1741aa, str2, num);
        }
    }

    /* renamed from: b */
    public static void m7243b(String str, long j, String str2) {
        if (!C1757q.m7251b()) {
            C1759s.m7260a(f6474a, "Auto Resend is disabled (update_messageContents)", new Object[0]);
        } else {
            C1752l.m7203b().m7216a(str, j, str2);
        }
    }
}
