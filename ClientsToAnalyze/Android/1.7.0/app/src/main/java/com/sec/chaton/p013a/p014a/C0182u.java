package com.sec.chaton.p013a.p014a;

import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.chat.C0520a;
import com.sec.chaton.chat.C0585by;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p013a.C0223v;
import com.sec.chaton.p013a.C0227z;
import com.sec.chaton.p015b.C0285ay;
import com.sec.chaton.p015b.C0305br;
import com.sec.chaton.p015b.C0315ca;
import com.sec.chaton.p015b.C0324cj;
import com.sec.chaton.p015b.C0329co;
import com.sec.chaton.p015b.p016a.EnumC0256d;
import com.sec.chaton.p018c.C0477ab;
import com.sec.chaton.p018c.C0507n;
import com.sec.chaton.p018c.C0510q;
import com.sec.chaton.p025d.C0662o;
import com.sec.chaton.p025d.EnumC0651d;
import com.sec.chaton.p025d.EnumC0664q;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p025d.EnumC0672y;
import com.sec.chaton.p025d.p026a.C0631k;
import com.sec.chaton.p025d.p026a.C0634n;
import com.sec.chaton.p025d.p026a.C0635o;
import com.sec.chaton.p025d.p026a.C0636p;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1332g;
import com.sec.chaton.util.C1341p;
import com.sec.spp.push.Config;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: DeliveryChatTask.java */
/* renamed from: com.sec.chaton.a.a.u */
/* loaded from: classes.dex */
public class C0182u extends AbstractC0164c {

    /* renamed from: h */
    private String f451h;

    /* renamed from: i */
    private C0305br f452i;

    /* renamed from: j */
    private ContentResolver f453j;

    /* renamed from: k */
    private String f454k;

    /* renamed from: l */
    private C0585by f455l;

    /* renamed from: m */
    private int f456m;

    public C0182u(Handler handler, String str, C0305br c0305br, C0223v c0223v) {
        super(handler);
        this.f456m = 0;
        this.f451h = str;
        this.f452i = c0305br;
        this.f453j = GlobalApplication.m3100a().getContentResolver();
        this.f454k = null;
        this.f392g = c0223v;
        this.f456m = 0;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractC0164c
    /* renamed from: a */
    protected C0510q mo665a() throws IllegalStateException, IllegalAccessException, NoSuchMethodException, RemoteException, SecurityException, IOException, IllegalArgumentException, OperationApplicationException, InvocationTargetException {
        int i;
        C0329co c0329co;
        boolean z;
        boolean z2;
        int i2;
        String strM861j = this.f451h;
        if (this.f392g.m859h()) {
            strM861j = this.f392g.m861j();
        }
        this.f455l = C0585by.m2770b(strM861j);
        EnumC0665r enumC0665rM3011a = EnumC0665r.m3011a(this.f452i.m1510f().getNumber());
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < this.f452i.m1511g().size(); i3++) {
            sb.append("[" + i3 + "] ChatMsg : " + this.f452i.m1505a(i3).m1824j()).append(", MsgType : " + this.f452i.m1505a(i3).m1828n()).append(", MsgID : " + this.f452i.m1505a(i3).m1822h()).append(", Time : " + this.f452i.m1505a(i3).m1826l()).append(", ChatType : " + this.f452i.m1505a(i3).m1830p()).append(", ReceiversList : " + C1341p.m4646a(this.f452i.m1505a(i3).m1819e())).append(", Sender : " + this.f452i.m1505a(i3).m1818d());
        }
        C1341p.m4660c("ch@t[" + this.f452i.getClass().getSimpleName() + "]UID : " + C1323bs.m4575a().getString("uid", "") + ", ChatType : " + this.f452i.m1510f() + ", InboxMessageCount : " + this.f452i.m1512h() + ", SessionID : " + this.f452i.m1508d() + sb.toString(), getClass().getSimpleName());
        C0324cj c0324cjM1763a = C0315ca.newBuilder().m1763a(C1323bs.m4575a().getString("uid", ""));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = this.f452i.m1511g().iterator();
        while (it.hasNext()) {
            arrayList2.add((C0329co) it.next());
        }
        Collections.sort(arrayList2, new C0186y(this));
        ArrayList arrayList3 = new ArrayList();
        C0636p c0636pM2913c = C0634n.m2913c(this.f453j, strM861j);
        if (c0636pM2913c == null) {
            C1341p.m4651a("Error - InBoxData does not exist.", getClass().getSimpleName());
            return null;
        }
        int i4 = 0;
        C0329co c0329co2 = null;
        C0329co c0329co3 = null;
        boolean z3 = false;
        ArrayList<ContentProviderOperation> arrayList4 = new ArrayList<>();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            try {
                C0329co c0329co4 = (C0329co) it2.next();
                switch (c0329co4.m1828n().getNumber()) {
                    case 0:
                    case 1:
                        C1341p.m4660c("Delivery Chat, InboxNO : " + this.f451h + ", Sender : " + c0329co4.m1818d() + ", MsgType : " + c0329co4.m1828n() + ", ChatMsg : " + c0329co4.m1824j() + ", MsgID" + c0329co4.m1822h(), getClass().getSimpleName());
                        C0329co c0329co5 = c0329co3 == null ? c0329co4 : c0329co3;
                        EnumC0651d enumC0651dM2932a = C0635o.m2932a(c0329co4.m1824j(), EnumC0651d.m2976a(c0329co4.m1828n().getNumber()));
                        String[] strArrSplit = c0329co4.m1824j().split("\n");
                        if ((enumC0651dM2932a == EnumC0651d.CONTACT || enumC0651dM2932a == EnumC0651d.CALENDAR) && strArrSplit.length >= 6) {
                            this.f454k = strArrSplit[5];
                        }
                        EnumC0672y enumC0672yM2933a = C0635o.m2933a(this.f453j, this.f452i.m1508d(), enumC0651dM2932a, c0329co4, strM861j, Long.valueOf(c0329co4.m1822h()), this.f454k, enumC0665rM3011a);
                        if (enumC0672yM2933a == EnumC0672y.INSERT) {
                            z = true;
                            this.f456m++;
                            z2 = false;
                        } else if (enumC0672yM2933a != EnumC0672y.UPDATE) {
                            z = false;
                            z2 = false;
                        } else {
                            z2 = true;
                            z = false;
                        }
                        if (enumC0651dM2932a != EnumC0651d.TEXT && enumC0651dM2932a == EnumC0651d.IMAGE) {
                            if ((z || z2) && strArrSplit.length >= 5) {
                                new Handler(Looper.getMainLooper()).post(new RunnableC0187z(this, strArrSplit[2], strArrSplit[4], strArrSplit[3], strM861j, c0329co4.m1822h(), enumC0665rM3011a, c0329co4.m1818d()));
                            } else if (strArrSplit.length >= 4) {
                                C1341p.m4658b("No need to update and insert: " + strArrSplit[3], getClass().getName());
                            } else {
                                C1341p.m4651a("Token Error", getClass().getName());
                            }
                        }
                        if (GlobalApplication.f2408b != null && GlobalApplication.f2408b.equals(strM861j)) {
                            arrayList.add(C0285ay.newBuilder().m1777a(c0329co4.m1822h()).m1781a(c0329co4.m1818d()).m1779a(c0329co4.m1828n()).m1783b(C1323bs.m4575a().getString("msisdn", "")).build());
                            i2 = i4;
                        } else {
                            this.f455l.m2772a(c0329co4);
                            i2 = z ? i4 + 1 : i4;
                        }
                        if (z || z2) {
                            i = i2;
                            c0329co = c0329co5;
                            continue;
                        } else {
                            c0329co4 = c0329co2;
                            i = i2;
                            c0329co = c0329co5;
                        }
                        c0329co2 = c0329co4;
                        i4 = i;
                        boolean z4 = z;
                        c0329co3 = c0329co;
                        z3 = z4;
                        break;
                    case 2:
                        arrayList3.add(c0329co4);
                        arrayList.add(C0285ay.newBuilder().m1777a(c0329co4.m1822h()).m1781a(c0329co4.m1818d()).m1779a(c0329co4.m1828n()).m1783b(C1323bs.m4575a().getString("msisdn", "")).build());
                        c0329co4 = c0329co2;
                        i = i4;
                        boolean z5 = z3;
                        c0329co = c0329co3;
                        z = z5;
                        continue;
                        c0329co2 = c0329co4;
                        i4 = i;
                        boolean z42 = z;
                        c0329co3 = c0329co;
                        z3 = z42;
                    case 3:
                        String strValueOf = String.valueOf(c0329co4.m1822h());
                        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C0662o.m2996a(strValueOf));
                        builderNewUpdate.withValue("message_sever_id", strValueOf);
                        arrayList4.add(builderNewUpdate.build());
                        arrayList.add(C0285ay.newBuilder().m1777a(c0329co4.m1822h()).m1781a(c0329co4.m1818d()).m1779a(c0329co4.m1828n()).m1783b(c0329co4.m1815a(0)).build());
                        break;
                }
                c0329co4 = c0329co2;
                i = i4;
                boolean z6 = z3;
                c0329co = c0329co3;
                z = z6;
                c0329co2 = c0329co4;
                i4 = i;
                boolean z422 = z;
                c0329co3 = c0329co;
                z3 = z422;
            } finally {
                arrayList4.clear();
            }
        }
        try {
            if (arrayList4.size() > 0) {
                this.f453j.applyBatch("com.sec.chaton.provider", arrayList4);
            }
        } catch (Exception e) {
            C1341p.m4651a(e.getMessage(), getClass().getSimpleName());
        }
        if (c0329co3 != null) {
            boolean z7 = false;
            if (!C0634n.m2915e(this.f453j, strM861j)) {
                ArrayList<ContentProviderOperation> arrayList5 = new ArrayList<>();
                String strM1818d = c0329co3.m1818d();
                if (!C0631k.m2864a(this.f453j, strM1818d, strM861j)) {
                    arrayList5.add(C0631k.m2860a(strM861j, strM1818d));
                    z7 = true;
                }
                int iM1820f = c0329co3.m1820f();
                for (int i5 = 0; i5 < iM1820f; i5++) {
                    String strM1815a = c0329co3.m1815a(i5);
                    if (!strM1815a.equals(C1323bs.m4575a().getString("msisdn", ""))) {
                        C1341p.m4662e("Insert Participants : " + strM1815a, getClass().getSimpleName());
                        arrayList5.add(C0631k.m2860a(strM861j, strM1815a));
                        z7 = true;
                    }
                }
                try {
                    if (arrayList5.size() > 0) {
                        this.f453j.applyBatch("com.sec.chaton.provider", arrayList5);
                    }
                } catch (Exception e2) {
                    C1341p.m4651a(e2.getMessage(), getClass().getSimpleName());
                }
                C0634n.m2912c(this.f453j, strM861j, 11);
                c0636pM2913c.f2210m = 11;
            }
            if (z7) {
                C0227z.m877a(null, strM861j, this.f452i.m1508d(), 0L);
            }
        }
        if (c0329co2 != null) {
            String strM2870d = C0631k.m2870d(this.f453j, c0329co2.m1818d());
            if (c0329co2.m1826l() >= c0636pM2913c.f2204g) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(2).append(";");
                sb2.append(C0635o.m2932a(c0329co2.m1824j(), EnumC0651d.m2976a(c0329co2.m1828n().getNumber())).m2978a()).append(";");
                sb2.append(C0520a.m2713a(c0329co2.m1824j())).append(";");
                sb2.append(C0520a.m2713a(strM2870d));
                c0636pM2913c.f2202e = sb2.toString();
                c0636pM2913c.f2207j = c0329co2.m1822h();
                c0636pM2913c.f2208k = c0329co2.m1818d();
                c0636pM2913c.f2204g = c0329co2.m1826l();
            }
            m723a(arrayList3, strM861j);
            c0636pM2913c.f2201d += i4;
            C0634n.m2891a(this.f453j, strM861j, c0636pM2913c);
            KeyguardManager keyguardManager = (KeyguardManager) GlobalApplication.m3100a().getSystemService("keyguard");
            if (z3 && !this.f392g.m860i() && (GlobalApplication.f2408b == null || !GlobalApplication.f2408b.equals(strM861j) || keyguardManager.inKeyguardRestrictedInputMode())) {
                EnumC0651d enumC0651dM2932a2 = C0635o.m2932a(c0329co2.m1824j(), EnumC0651d.m2976a(c0329co2.m1828n().getNumber()));
                Intent intent = new Intent(HomeActivity.m630a(GlobalApplication.m3100a(), true));
                switch (enumC0665rM3011a) {
                    case ONETOONE:
                    case BROADCAST:
                        intent.putExtra("inboxNO", strM861j);
                        intent.putExtra("chatType", EnumC0665r.ONETOONE.m3012a());
                        intent.putExtra("fromPush", 1);
                        intent.putExtra(ChatFragment.f1735h, 1);
                        intent.putExtra("buddyNO", c0329co2.m1818d());
                        break;
                    case GROUPCHAT:
                        intent.putExtra("inboxNO", strM861j);
                        intent.putExtra("chatType", EnumC0665r.GROUPCHAT.m3012a());
                        intent.putExtra("fromPush", 1);
                        intent.putExtra(ChatFragment.f1735h, 1);
                        intent.putExtra("buddyNO", c0329co2.m1818d());
                        break;
                }
                PendingIntent activity = PendingIntent.getActivity(GlobalApplication.m3100a(), 0, intent, 268435456);
                C1341p.m4660c("[NOTI] ChatType: " + enumC0665rM3011a + ", unReadCount: " + c0636pM2913c.f2201d + ", Memory Address:" + this, getClass().getSimpleName());
                C1332g.m4605a(GlobalApplication.m3100a()).m4611a(c0329co2.m1818d(), c0329co2.m1824j(), strM861j, activity, c0329co2.m1822h(), enumC0651dM2932a2, c0636pM2913c.f2201d, enumC0665rM3011a.m3012a(), this.f452i.m1508d(), c0636pM2913c.f2198a, strM2870d, c0636pM2913c.f2215r);
            }
        } else {
            m723a(arrayList3, strM861j);
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            c0324cjM1763a.m1760a((C0285ay) it3.next());
        }
        StringBuilder sb3 = new StringBuilder();
        for (int i6 = 0; i6 < c0324cjM1763a.m1769f().size(); i6++) {
            sb3.append("[" + i6 + "] Receiver : " + c0324cjM1763a.m1757a(i6).m1289f()).append(", MsgType : " + c0324cjM1763a.m1757a(i6).m1293j()).append(", MsgID : " + c0324cjM1763a.m1757a(i6).m1291h()).append(", Sender : " + c0324cjM1763a.m1757a(i6).m1287d());
        }
        C1341p.m4660c("ch@t[" + c0324cjM1763a.getClass().getSimpleName() + "]UID : " + C1323bs.m4575a().getString("uid", "") + ", DeliveryChatReplyItemsCount: " + c0324cjM1763a.m1770g() + sb3.toString(), getClass().getSimpleName());
        C0477ab.m2445a(this.f388c, new C0507n().m2556a(7).m2558a(c0324cjM1763a.build()).m2561b());
        if (this.f392g.m859h()) {
            C0477ab.m2451d(this.f388c);
        }
        return null;
    }

    /* renamed from: a */
    private void m723a(ArrayList arrayList, String str) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C0329co c0329co = (C0329co) it.next();
            String[] strArrSplit = c0329co.m1824j().split("\n");
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArrSplit) {
                String[] strArrM2717a = C0520a.m2717a(str2, ",", 3);
                if (strArrM2717a.length > 2) {
                    String str3 = strArrM2717a[1];
                    String strM2866b = C0631k.m2866b(this.f453j, str3, strArrM2717a[2]);
                    EnumC0664q enumC0664q = EnumC0664q.UNKNOWN;
                    if (EnumC0664q.m3009a(strArrM2717a[0]) == EnumC0664q.ENTER) {
                        if (!C0631k.m2864a(this.f453j, str3, str)) {
                            C0631k.m2863a(this.f453j, str, str3, strM2866b);
                        }
                        enumC0664q = EnumC0664q.ENTER;
                    } else if (EnumC0664q.m3009a(strArrM2717a[0]) == EnumC0664q.LEAVE) {
                        C0631k.m2871d(this.f453j, str, str3);
                        enumC0664q = EnumC0664q.LEAVE;
                    }
                    sb.append(String.format("%d,%s,%s", Integer.valueOf(enumC0664q.m3010a()), str3, C0520a.m2713a(strM2866b))).append(";");
                }
            }
            C0635o.m2929a(this.f453j, str, sb.toString(), c0329co.m1826l(), Long.toString(c0329co.m1822h()), c0329co.m1818d());
        }
        if (arrayList.size() > 0) {
            C0634n.m2916f(this.f453j, str);
        }
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractC0164c
    /* renamed from: a */
    protected void mo666a(int i, Object obj, Object obj2) {
        StringBuilder sb = new StringBuilder();
        if (obj2 != null) {
            C0315ca c0315ca = (C0315ca) ((C0510q) obj2).m2574c();
            for (int i2 = 0; i2 < c0315ca.m1676e().size(); i2++) {
                sb.append("[" + i2 + "] MsgID : " + c0315ca.m1672a(i2).m1291h()).append(", MsgType : " + c0315ca.m1672a(i2).m1293j()).append(", Receiver : " + c0315ca.m1672a(i2).m1289f()).append(", Sender : " + c0315ca.m1672a(i2).m1287d());
            }
            C1341p.m4660c("ch@t[" + c0315ca.getClass().getSimpleName() + "]UID : " + C1323bs.m4575a().getString("uid", "") + ", DeliveryChatReplyItemsCount : " + c0315ca.m1677f() + ", ResultCode : " + c0315ca.m1679h().m1626d() + ", ResultMsg : " + c0315ca.m1679h().m1628f() + ", DeliveryChatReplyItemsCount :" + c0315ca.m1677f() + sb.toString(), getClass().getSimpleName());
        } else {
            C1341p.m4660c(Config.EXTRA_ERROR, getClass().getSimpleName());
        }
        Message message = new Message();
        message.what = 6;
        if (this.f452i.m1515k()) {
            message.obj = new C0183v(this, true, this.f452i.m1508d(), EnumC0256d.SUCCESS, this.f452i.m1516l(), this.f456m);
        } else {
            message.obj = new C0183v(this, true, this.f452i.m1508d(), EnumC0256d.SUCCESS, false, this.f456m);
        }
        this.f387b.sendMessage(message);
    }
}
