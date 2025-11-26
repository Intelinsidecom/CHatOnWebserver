package com.sec.chaton.p015d.p016a;

import android.app.PendingIntent;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.R;
import com.sec.chaton.chat.C0493bg;
import com.sec.chaton.chat.C0494bh;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.anicon.C0921d;
import com.sec.chaton.p007a.C0118ak;
import com.sec.chaton.p007a.C0121an;
import com.sec.chaton.p007a.C0122ao;
import com.sec.chaton.p007a.C0123ap;
import com.sec.chaton.p007a.C0144bj;
import com.sec.chaton.p007a.p008a.EnumC0106g;
import com.sec.chaton.p015d.C0639k;
import com.sec.chaton.p017e.C0698m;
import com.sec.chaton.p017e.EnumC0690e;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.p017e.EnumC0705t;
import com.sec.chaton.p017e.p018a.C0657a;
import com.sec.chaton.p017e.p018a.C0660d;
import com.sec.chaton.p017e.p018a.C0662f;
import com.sec.chaton.p017e.p018a.C0665i;
import com.sec.chaton.p017e.p018a.C0670n;
import com.sec.chaton.p022h.C0770ab;
import com.sec.chaton.p022h.C0771ac;
import com.sec.chaton.p022h.C0810t;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1788t;
import com.sec.chaton.util.C1789u;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DeliveryChatTask.java */
/* renamed from: com.sec.chaton.d.a.r */
/* loaded from: classes.dex */
public class C0602r extends AbstractC0559b {

    /* renamed from: h */
    private String f2369h;

    /* renamed from: i */
    private C0118ak f2370i;

    /* renamed from: j */
    private ContentResolver f2371j;

    /* renamed from: k */
    private String f2372k;

    /* renamed from: l */
    private C0494bh f2373l;

    /* renamed from: m */
    private int f2374m;

    public C0602r(Handler handler, String str, C0118ak c0118ak, C0639k c0639k) {
        super(handler);
        this.f2374m = 0;
        this.f2369h = str;
        this.f2370i = c0118ak;
        this.f2371j = GlobalApplication.m3260b().getContentResolver();
        this.f2372k = null;
        this.f2241g = c0639k;
        this.f2374m = 0;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractC0559b
    /* renamed from: c */
    protected C0770ab mo2748c() throws RemoteException, OperationApplicationException {
        int i;
        C0144bj c0144bj;
        boolean z;
        boolean z2;
        int i2;
        String strM2958j = this.f2369h;
        if (this.f2241g.m2956h()) {
            strM2958j = this.f2241g.m2958j();
        }
        this.f2373l = C0494bh.m2692b(strM2958j);
        EnumC0695j enumC0695jM3145a = EnumC0695j.m3145a(this.f2370i.m833f().getNumber());
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < this.f2370i.m834g().size(); i3++) {
            sb.append("[" + i3 + "] ChatMsg : " + this.f2370i.m828a(i3).m1118j()).append(", MsgType : " + this.f2370i.m828a(i3).m1122n()).append(", MsgID : " + this.f2370i.m828a(i3).m1116h()).append(", Time : " + this.f2370i.m828a(i3).m1120l()).append(", ChatType : " + this.f2370i.m828a(i3).m1124p()).append(", ReceiversList : " + C1786r.m6049a(this.f2370i.m828a(i3).m1113e())).append(", Sender : " + this.f2370i.m828a(i3).m1112d());
        }
        C1786r.m6063c("ch@t[" + this.f2370i.getClass().getSimpleName() + "]UID : " + C1789u.m6075a().getString("uid", "") + ", ChatType : " + this.f2370i.m833f() + ", InboxMessageCount : " + this.f2370i.m835h() + ", SessionID : " + this.f2370i.m831d() + sb.toString(), getClass().getSimpleName());
        C0122ao c0122aoM891a = C0121an.newBuilder().m891a(C1789u.m6075a().getString("uid", ""));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = this.f2370i.m834g().iterator();
        while (it.hasNext()) {
            arrayList2.add((C0144bj) it.next());
        }
        Collections.sort(arrayList2, new C0603s(this));
        ArrayList arrayList4 = new ArrayList();
        C0662f c0662fM3030d = C0660d.m3030d(this.f2371j, strM2958j);
        if (c0662fM3030d == null) {
            C1786r.m6054a("Error - InBoxData does not exist.", getClass().getSimpleName());
            return null;
        }
        int i4 = 0;
        C0144bj c0144bj2 = null;
        C0144bj c0144bj3 = null;
        boolean z3 = false;
        ArrayList<ContentProviderOperation> arrayList5 = new ArrayList<>();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            try {
                C0144bj c0144bj4 = (C0144bj) it2.next();
                switch (c0144bj4.m1122n().getNumber()) {
                    case 0:
                    case 1:
                        C1786r.m6063c("Delivery Chat, InboxNO : " + this.f2369h + ", Sender : " + c0144bj4.m1112d() + ", MsgType : " + c0144bj4.m1122n() + ", ChatMsg : " + c0144bj4.m1118j() + ", MsgID" + c0144bj4.m1116h(), getClass().getSimpleName());
                        C0144bj c0144bj5 = c0144bj3 == null ? c0144bj4 : c0144bj3;
                        EnumC0699n enumC0699nM3047a = C0665i.m3047a(c0144bj4.m1118j(), EnumC0699n.m3160a(c0144bj4.m1122n().getNumber()));
                        String[] strArrSplit = c0144bj4.m1118j().split("\n");
                        if ((enumC0699nM3047a == EnumC0699n.CONTACT || enumC0699nM3047a == EnumC0699n.CALENDAR || enumC0699nM3047a == EnumC0699n.DOCUMENT) && strArrSplit.length >= 6) {
                            this.f2372k = strArrSplit[5];
                        }
                        if (enumC0699nM3047a == EnumC0699n.IMAGE && C0921d.m3794b(c0144bj4.m1118j())) {
                            enumC0699nM3047a = EnumC0699n.ANICON;
                        }
                        EnumC0690e enumC0690eM3044a = C0665i.m3044a(this.f2371j, this.f2370i.m831d(), enumC0699nM3047a, c0144bj4, strM2958j, Long.valueOf(c0144bj4.m1116h()), this.f2372k, enumC0695jM3145a);
                        if (enumC0690eM3044a == EnumC0690e.INSERT) {
                            z = true;
                            this.f2374m++;
                            z2 = false;
                        } else if (enumC0690eM3044a != EnumC0690e.UPDATE) {
                            z = false;
                            z2 = false;
                        } else {
                            z2 = true;
                            z = false;
                        }
                        if (enumC0699nM3047a != EnumC0699n.TEXT && enumC0699nM3047a == EnumC0699n.IMAGE) {
                            if ((z || z2) && strArrSplit.length >= 5) {
                                new AsyncTaskC0607w(strArrSplit[2], strArrSplit[4], strArrSplit[3], true, strM2958j, c0144bj4.m1116h(), enumC0695jM3145a, c0144bj4.m1112d()).execute(new String[0]);
                            } else if (strArrSplit.length >= 4) {
                                C1786r.m6061b("No need to update and insert: " + strArrSplit[3], getClass().getName());
                            } else {
                                C1786r.m6054a("Token Error", getClass().getName());
                            }
                        }
                        if (GlobalApplication.f2776b != null && GlobalApplication.f2776b.equals(strM2958j)) {
                            arrayList.add(C0123ap.newBuilder().m927a(c0144bj4.m1116h()).m931a(c0144bj4.m1112d()).m930a(c0144bj4.m1122n()).m933b(C1789u.m6075a().getString("msisdn", "")).build());
                            i2 = i4;
                        } else {
                            this.f2373l.m2694a(c0144bj4);
                            i2 = z ? i4 + 1 : i4;
                        }
                        if (z || z2) {
                            i = i2;
                            c0144bj = c0144bj5;
                            continue;
                        } else {
                            c0144bj4 = c0144bj2;
                            i = i2;
                            c0144bj = c0144bj5;
                        }
                        c0144bj2 = c0144bj4;
                        i4 = i;
                        boolean z4 = z;
                        c0144bj3 = c0144bj;
                        z3 = z4;
                        break;
                    case 2:
                        arrayList4.add(c0144bj4);
                        arrayList.add(C0123ap.newBuilder().m927a(c0144bj4.m1116h()).m931a(c0144bj4.m1112d()).m930a(c0144bj4.m1122n()).m933b(C1789u.m6075a().getString("msisdn", "")).build());
                        c0144bj4 = c0144bj2;
                        i = i4;
                        boolean z5 = z3;
                        c0144bj = c0144bj3;
                        z = z5;
                        continue;
                        c0144bj2 = c0144bj4;
                        i4 = i;
                        boolean z42 = z;
                        c0144bj3 = c0144bj;
                        z3 = z42;
                    case 3:
                        String strValueOf = String.valueOf(c0144bj4.m1116h());
                        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C0698m.m3149a(strValueOf));
                        builderNewUpdate.withValue("message_sever_id", strValueOf);
                        arrayList5.add(builderNewUpdate.build());
                        arrayList.add(C0123ap.newBuilder().m927a(c0144bj4.m1116h()).m931a(c0144bj4.m1112d()).m930a(c0144bj4.m1122n()).m933b(c0144bj4.m1109a(0)).build());
                        break;
                }
                c0144bj4 = c0144bj2;
                i = i4;
                boolean z6 = z3;
                c0144bj = c0144bj3;
                z = z6;
                c0144bj2 = c0144bj4;
                i4 = i;
                boolean z422 = z;
                c0144bj3 = c0144bj;
                z3 = z422;
            } finally {
                arrayList5.clear();
            }
        }
        try {
            if (arrayList5.size() > 0) {
                this.f2371j.applyBatch("com.sec.chaton.provider", arrayList5);
            }
        } catch (Exception e) {
            C1786r.m6054a(e.getMessage(), getClass().getSimpleName());
        }
        if (c0144bj3 != null && !C0660d.m3032f(this.f2371j, strM2958j)) {
            ArrayList<ContentProviderOperation> arrayList6 = new ArrayList<>();
            String strM1112d = c0144bj3.m1112d();
            if (!C0670n.m3083a(this.f2371j, strM1112d, strM2958j)) {
                arrayList6.add(C0670n.m3078a(strM2958j, strM1112d));
                if (!arrayList3.contains(strM1112d) && C0657a.m2983c(this.f2371j, strM1112d).equals(strM1112d)) {
                    arrayList3.add(strM1112d);
                }
            }
            int iM1114f = c0144bj3.m1114f();
            for (int i5 = 0; i5 < iM1114f; i5++) {
                String strM1109a = c0144bj3.m1109a(i5);
                if (!strM1109a.equals(C1789u.m6075a().getString("msisdn", "")) && !C0670n.m3083a(this.f2371j, strM1109a, strM2958j)) {
                    C1786r.m6066e("Insert Participants : " + strM1109a, getClass().getSimpleName());
                    arrayList6.add(C0670n.m3078a(strM2958j, strM1109a));
                    if (!arrayList3.contains(strM1109a) && C0657a.m2983c(this.f2371j, strM1109a).equals(strM1109a)) {
                        arrayList3.add(strM1109a);
                    }
                }
            }
            if (!arrayList3.contains(c0144bj3.m1112d()) && GlobalApplication.m3262c().getString(R.string.unknown).equals(C0670n.m3089d(this.f2371j, c0144bj3.m1112d()))) {
                arrayList3.add(c0144bj3.m1112d());
            }
            try {
                if (arrayList6.size() > 0) {
                    this.f2371j.applyBatch("com.sec.chaton.provider", arrayList6);
                }
            } catch (Exception e2) {
                C1786r.m6054a(e2.getMessage(), getClass().getSimpleName());
            }
            C0660d.m3029c(this.f2371j, strM2958j, 11);
            c0662fM3030d.f2545l = 11;
        }
        if (c0144bj2 != null) {
            if (c0144bj2.m1120l() >= c0662fM3030d.f2539f) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(2).append(";");
                sb2.append(C0665i.m3047a(c0144bj2.m1118j(), EnumC0699n.m3160a(c0144bj2.m1122n().getNumber())).m3162a()).append(";");
                String strM2684a = C0493bg.m2684a(c0144bj2.m1118j());
                C1786r.m6061b("onPreExecute - (lastmsg) last msg sender : " + c0144bj2.m1112d().toString(), getClass().getSimpleName());
                C1786r.m6061b("onPreExecute - (lastmsg) last msg msg : " + c0144bj2.m1118j().toString(), getClass().getSimpleName());
                if (c0144bj2.m1112d().startsWith("0999")) {
                    try {
                        sb2.append(new JSONObject(strM2684a).getString("title")).append(";");
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                } else {
                    sb2.append(strM2684a).append(";");
                }
                sb2.append(C0493bg.m2684a(C0670n.m3089d(this.f2371j, c0144bj2.m1112d())));
                C1786r.m6061b("onPreExecute - (lastmsg) DB. LastMsg : " + sb2.toString(), getClass().getSimpleName());
                c0662fM3030d.f2537d = sb2.toString();
                c0662fM3030d.f2542i = c0144bj2.m1116h();
                c0662fM3030d.f2543j = c0144bj2.m1112d();
                c0662fM3030d.f2539f = c0144bj2.m1120l();
            }
            Iterator it3 = arrayList4.iterator();
            while (it3.hasNext()) {
                C0144bj c0144bj6 = (C0144bj) it3.next();
                String[] strArrSplit2 = c0144bj6.m1118j().split("\n");
                StringBuilder sb3 = new StringBuilder();
                for (String str : strArrSplit2) {
                    String[] strArrM2688a = C0493bg.m2688a(str, ",", 3);
                    if (strArrM2688a.length > 2) {
                        String str2 = strArrM2688a[1];
                        String strM3084b = C0670n.m3084b(this.f2371j, str2, strArrM2688a[2]);
                        if (EnumC0705t.m3170a(strArrM2688a[0]) == EnumC0705t.ENTER) {
                            if (!C0670n.m3083a(this.f2371j, str2, strM2958j)) {
                                sb3.append(String.format("%d,%s,%s", Integer.valueOf(EnumC0705t.ENTER.m3171a()), str2, C0493bg.m2684a(strM3084b))).append(";");
                                C0670n.m3082a(this.f2371j, strM2958j, str2, strM3084b);
                            }
                        } else if (EnumC0705t.m3170a(strArrM2688a[0]) == EnumC0705t.LEAVE && C0670n.m3083a(this.f2371j, str2, strM2958j)) {
                            sb3.append(String.format("%d,%s,%s", Integer.valueOf(EnumC0705t.LEAVE.m3171a()), str2, C0493bg.m2684a(strM3084b))).append(";");
                            C0670n.m3090d(this.f2371j, strM2958j, str2);
                        }
                    }
                }
                if (sb3.length() > 0) {
                    C0665i.m3041a(this.f2371j, strM2958j, sb3.toString(), c0144bj6.m1120l(), Long.toString(c0144bj6.m1116h()), c0144bj6.m1112d());
                }
            }
            c0662fM3030d.f2536c += i4;
            C0660d.m3005a(this.f2371j, strM2958j, c0662fM3030d);
            if (z3 && !this.f2241g.m2957i() && (GlobalApplication.f2776b == null || !GlobalApplication.f2776b.equals(strM2958j))) {
                EnumC0699n enumC0699nM3047a2 = C0665i.m3047a(c0144bj2.m1118j(), EnumC0699n.m3160a(c0144bj2.m1122n().getNumber()));
                Intent intent = new Intent(HomeActivity.m585a(GlobalApplication.m3260b(), true));
                switch (enumC0695jM3145a) {
                    case ONETOONE:
                    case BROADCAST:
                        intent.putExtra("inboxNO", strM2958j);
                        intent.putExtra("chatType", EnumC0695j.ONETOONE.m3146a());
                        intent.putExtra("fromPush", 1);
                        intent.putExtra(ChatFragment.f1754j, 1);
                        intent.putExtra("buddyNO", c0144bj2.m1112d());
                        break;
                    case GROUPCHAT:
                        intent.putExtra("inboxNO", strM2958j);
                        intent.putExtra("chatType", EnumC0695j.GROUPCHAT.m3146a());
                        intent.putExtra("fromPush", 1);
                        intent.putExtra(ChatFragment.f1754j, 1);
                        intent.putExtra("buddyNO", c0144bj2.m1112d());
                        break;
                }
                PendingIntent activity = PendingIntent.getActivity(GlobalApplication.m3260b(), 0, intent, 268435456);
                C1786r.m6063c("[NOTI] ChatType: " + enumC0695jM3145a + ", unReadCount: " + c0662fM3030d.f2536c + ", Memory Address:" + this, getClass().getSimpleName());
                C1788t.m6070a(GlobalApplication.m3260b()).m6074a(c0144bj2.m1112d(), c0144bj2.m1118j(), strM2958j, activity, c0144bj2.m1116h(), enumC0699nM3047a2, c0662fM3030d.f2536c, enumC0695jM3145a.m3146a(), c0662fM3030d.f2550q, this.f2370i.m831d());
            }
        } else {
            Iterator it4 = arrayList4.iterator();
            while (it4.hasNext()) {
                C0144bj c0144bj7 = (C0144bj) it4.next();
                String[] strArrSplit3 = c0144bj7.m1118j().split("\n");
                StringBuilder sb4 = new StringBuilder();
                for (String str3 : strArrSplit3) {
                    String[] strArrM2688a2 = C0493bg.m2688a(str3, ",", 3);
                    if (strArrM2688a2.length > 2) {
                        String str4 = strArrM2688a2[1];
                        String strM3084b2 = C0670n.m3084b(this.f2371j, str4, strArrM2688a2[2]);
                        EnumC0705t enumC0705t = EnumC0705t.UNKNOWN;
                        if (EnumC0705t.m3170a(strArrM2688a2[0]) == EnumC0705t.ENTER) {
                            if (!C0670n.m3083a(this.f2371j, str4, strM2958j)) {
                                C0670n.m3082a(this.f2371j, strM2958j, str4, strM3084b2);
                            }
                            enumC0705t = EnumC0705t.ENTER;
                        } else if (EnumC0705t.m3170a(strArrM2688a2[0]) == EnumC0705t.LEAVE) {
                            C0670n.m3090d(this.f2371j, strM2958j, str4);
                            enumC0705t = EnumC0705t.LEAVE;
                        }
                        sb4.append(String.format("%d,%s,%s", Integer.valueOf(enumC0705t.m3171a()), str4, C0493bg.m2684a(strM3084b2))).append(";");
                    }
                }
                C0665i.m3041a(this.f2371j, strM2958j, sb4.toString(), c0144bj7.m1120l(), Long.toString(c0144bj7.m1116h()), c0144bj7.m1112d());
            }
        }
        if (!arrayList3.isEmpty()) {
            this.f2241g.m2943a(arrayList3);
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            c0122aoM891a.m889a((C0123ap) it5.next());
        }
        StringBuilder sb5 = new StringBuilder();
        for (int i6 = 0; i6 < c0122aoM891a.m898f().size(); i6++) {
            sb5.append("[" + i6 + "] Receiver : " + c0122aoM891a.m892a(i6).m916f()).append(", MsgType : " + c0122aoM891a.m892a(i6).m920j()).append(", MsgID : " + c0122aoM891a.m892a(i6).m918h()).append(", Sender : " + c0122aoM891a.m892a(i6).m914d());
        }
        C1786r.m6063c("ch@t[" + c0122aoM891a.getClass().getSimpleName() + "]UID : " + C1789u.m6075a().getString("uid", "") + ", DeliveryChatReplyItemsCount: " + c0122aoM891a.m899g() + sb5.toString(), getClass().getSimpleName());
        C0810t.m3425a(this.f2237c, new C0771ac().m3294a(7).m3296a(c0122aoM891a.build()).m3299b());
        if (this.f2241g.m2956h()) {
            C0810t.m3431d(this.f2237c);
        }
        return null;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractC0559b
    /* renamed from: a */
    protected void mo2747a(int i, Object obj, Object obj2) {
        StringBuilder sb = new StringBuilder();
        if (obj2 != null) {
            C0121an c0121an = (C0121an) ((C0770ab) obj2).m3290c();
            for (int i2 = 0; i2 < c0121an.m874e().size(); i2++) {
                sb.append("[" + i2 + "] MsgID : " + c0121an.m870a(i2).m918h()).append(", MsgType : " + c0121an.m870a(i2).m920j()).append(", Receiver : " + c0121an.m870a(i2).m916f()).append(", Sender : " + c0121an.m870a(i2).m914d());
            }
            C1786r.m6063c("ch@t[" + c0121an.getClass().getSimpleName() + "]UID : " + C1789u.m6075a().getString("uid", "") + ", DeliveryChatReplyItemsCount : " + c0121an.m875f() + ", ResultCode : " + c0121an.m877h().m1467d() + ", ResultMsg : " + c0121an.m877h().m1469f() + ", DeliveryChatReplyItemsCount :" + c0121an.m875f() + sb.toString(), getClass().getSimpleName());
        } else {
            C1786r.m6063c(Config.EXTRA_ERROR, getClass().getSimpleName());
        }
        Message message = new Message();
        message.what = 6;
        if (this.f2370i.m838k()) {
            message.obj = new C0605u(this, true, this.f2370i.m831d(), EnumC0106g.SUCCESS, this.f2370i.m839l(), this.f2374m);
        } else {
            message.obj = new C0605u(this, true, this.f2370i.m831d(), EnumC0106g.SUCCESS, false, this.f2374m);
        }
        this.f2236b.sendMessage(message);
    }
}
