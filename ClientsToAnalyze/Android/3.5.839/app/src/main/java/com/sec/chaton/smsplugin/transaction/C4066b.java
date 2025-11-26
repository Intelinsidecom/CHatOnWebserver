package com.sec.chaton.smsplugin.transaction;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Messenger;
import android.os.RemoteException;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import com.sec.chaton.smsplugin.C3778a;
import com.sec.chaton.smsplugin.C3781b;
import com.sec.chaton.smsplugin.C3805c;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.C3850f;
import com.sec.chaton.smsplugin.C3854g;
import com.sec.chaton.smsplugin.C3905j;
import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.chaton.smsplugin.p102b.C3789h;
import com.sec.chaton.smsplugin.p110g.AbstractC3863i;
import com.sec.chaton.smsplugin.p110g.C3855a;
import com.sec.chaton.smsplugin.p110g.C3856b;
import com.sec.chaton.smsplugin.p110g.C3861g;
import com.sec.chaton.smsplugin.p110g.C3869o;
import com.sec.chaton.smsplugin.p110g.C3870p;
import com.sec.chaton.smsplugin.p110g.C3872r;
import com.sec.chaton.smsplugin.p110g.C3873s;
import com.sec.chaton.smsplugin.p111h.AbstractC3900w;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p111h.C3896s;
import com.sec.chaton.smsplugin.p111h.C3903z;
import com.sec.chaton.smsplugin.p112ui.C4149cd;
import com.sec.google.android.p134a.C5111c;
import com.sec.google.android.p134a.p135a.C5082e;
import com.sec.google.android.p134a.p135a.C5086i;
import com.sec.google.android.p134a.p135a.C5097t;
import com.sec.google.android.p134a.p135a.C5103z;
import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: BackgroundSenderService.java */
/* renamed from: com.sec.chaton.smsplugin.transaction.b */
/* loaded from: classes.dex */
public class C4066b {

    /* renamed from: a */
    private String[] f14653a;

    /* renamed from: b */
    private String f14654b;

    /* renamed from: c */
    private final Uri f14655c;

    /* renamed from: d */
    private C5097t f14656d;

    /* renamed from: e */
    private C3870p f14657e;

    /* renamed from: f */
    private Uri f14658f;

    /* renamed from: g */
    private final Context f14659g;

    /* renamed from: h */
    private C5103z f14660h;

    /* renamed from: i */
    private final boolean f14661i = false;

    /* renamed from: j */
    private String f14662j;

    /* renamed from: k */
    private long f14663k;

    /* renamed from: l */
    private final int f14664l;

    /* renamed from: m */
    private final Messenger f14665m;

    public C4066b(Context context, Intent intent) {
        this.f14654b = null;
        this.f14658f = null;
        this.f14662j = null;
        this.f14663k = -1L;
        this.f14659g = context;
        String[] stringArrayExtra = intent.getStringArrayExtra("extra_bg_recipients");
        if (stringArrayExtra != null) {
            this.f14653a = m15656a(stringArrayExtra);
        }
        this.f14662j = intent.getStringExtra("extra_bg_message");
        this.f14664l = intent.getIntExtra("extra_bg_token", 1000);
        this.f14665m = (Messenger) intent.getParcelableExtra("extra_bg_cb_messenger");
        this.f14655c = intent.getData();
        if (this.f14655c != null) {
            this.f14654b = BackgroundSenderService.m15516b(this.f14659g, this.f14655c);
        }
        this.f14658f = (Uri) intent.getParcelableExtra("extra_message_uri");
        this.f14663k = intent.getLongExtra("extra_thread_id", -1L);
    }

    /* renamed from: a */
    private String[] m15656a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (String str : strArr) {
            arrayList.add(C3789h.m14307c(C3782a.m14228c(str)));
            i++;
        }
        String[] strArr2 = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            strArr2[i2] = (String) arrayList.get(i2);
        }
        return strArr2;
    }

    /* renamed from: a */
    private boolean m15655a(Uri uri, String str) {
        int[] iArrM16442k;
        if (!C3847e.m14642Z()) {
            iArrM16442k = SmsMessage.calculateLength(this.f14662j, false);
        } else {
            iArrM16442k = C4149cd.m16442k(this.f14662j.toString());
        }
        if (uri != null || iArrM16442k[0] > C3847e.m14643a()) {
            C3890m.m14997c("Mms/MsgBGSendReceiver", "try to send mms");
            return true;
        }
        C3890m.m14997c("Mms/MsgBGSendReceiver", "try to send sms");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15647a() {
        if (this.f14658f != null) {
            m15648a(this.f14658f, this.f14663k);
        } else if (!m15655a(this.f14655c, this.f14662j)) {
            new C4067c(this).start();
        } else {
            new C4068d(this).start();
        }
    }

    /* renamed from: a */
    private void m15648a(Uri uri, long j) {
        String authority = uri.getAuthority();
        if (authority != null && !"sms".equals(authority)) {
            C3903z.m15074a(Long.valueOf(ContentUris.parseId(this.f14658f)), j);
            Intent intent = new Intent(this.f14659g, (Class<?>) TransactionService.class);
            C3896s.m15045c("SentIntent BG token == " + this.f14664l, "Mms/MsgBGSendReceiver");
            if (this.f14664l != -1) {
                intent.putExtra("extra_bg_token", this.f14664l);
                intent.putExtra("extra_bg_cb_messenger", this.f14665m);
            }
            this.f14659g.startService(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m15658b() {
        new Thread(new RunnableC4069e(this)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15653a(String str, String[] strArr, long j) {
        try {
            new C4052ac(this.f14659g, strArr, str, j, this.f14664l, this.f14665m).mo15606a(j);
            AbstractC3900w.m15065a().m15068a(this.f14659g, j);
        } catch (Exception e) {
            C3890m.m14995a("Mms/MsgBGSendReceiver", "Failed to send SMS message, threadId=" + j, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m15662c() {
        new Thread(new RunnableC4070f(this, this.f14658f, this.f14657e)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15649a(Uri uri, C3870p c3870p, int i, Messenger messenger) {
        if (uri != null) {
            try {
                new C4081q(this.f14659g, uri, c3870p.m14907b(), i, messenger).mo15606a(m15657b(this.f14659g, this.f14653a));
            } catch (C5111c e) {
                C3890m.m14999e("Mms/MsgBGSendReceiver", "Failed to send message: " + uri + e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m15664d() {
        try {
            this.f14657e = m15665e();
            if (this.f14657e != null) {
                this.f14660h = m15668f();
            }
        } catch (C5111c e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    private C3870p m15665e() throws RemoteException {
        C3855a c3855a;
        AbstractC3863i c3856b;
        C3872r c3872r;
        C3870p c3870pM14880a = C3870p.m14880a(this.f14659g);
        c3870pM14880a.add(new C3869o(c3870pM14880a));
        if (this.f14654b == null) {
            c3855a = null;
            c3856b = null;
        } else if (this.f14654b.startsWith("image/")) {
            c3856b = new C3861g(this.f14659g, this.f14655c, c3870pM14880a.m14913d().m14786a());
            c3855a = null;
        } else if (this.f14654b.startsWith("video/")) {
            c3856b = new C3873s(this.f14659g, this.f14655c, c3870pM14880a.m14913d().m14786a());
            c3855a = null;
        } else if (this.f14654b.startsWith("audio/")) {
            c3856b = new C3856b(this.f14659g, this.f14655c);
            c3855a = null;
        } else {
            c3855a = new C3855a(this.f14659g, this.f14655c, false);
            c3856b = null;
        }
        if (this.f14662j != null) {
            c3872r = new C3872r(this.f14659g, "text/plain", "cid:text_1.txt", c3870pM14880a.m14913d().m14790b());
            c3872r.m14942a((CharSequence) this.f14662j, true);
        } else {
            c3872r = null;
        }
        C3869o c3869oM14914d = c3870pM14880a.get(0);
        if (c3872r != null) {
            try {
                c3869oM14914d.add((AbstractC3863i) c3872r);
            } catch (C3781b e) {
                BackgroundSenderService.m15511a(-9, this.f14664l, this.f14665m);
                return null;
            } catch (C3805c e2) {
                BackgroundSenderService.m15511a(-2, this.f14664l, this.f14665m);
                return null;
            } catch (C3850f e3) {
                BackgroundSenderService.m15511a(-4, this.f14664l, this.f14665m);
                return null;
            } catch (C3854g e4) {
                BackgroundSenderService.m15511a(-8, this.f14664l, this.f14665m);
                return null;
            } catch (C3905j e5) {
                BackgroundSenderService.m15511a(-3, this.f14664l, this.f14665m);
                return null;
            } catch (C3778a e6) {
                BackgroundSenderService.m15511a(-5, this.f14664l, this.f14665m);
                return null;
            }
        }
        if (c3856b != null) {
            if (this.f14654b.startsWith("image/")) {
                ((C3861g) c3856b).m14779h();
            }
            c3869oM14914d.add(c3856b);
        } else if (c3855a != null) {
            c3870pM14880a.m14904a(c3855a);
        }
        return c3870pM14880a;
    }

    /* renamed from: f */
    private C5103z m15668f() {
        C5103z c5103z = new C5103z();
        m15654a(this.f14653a, c5103z);
        C5086i c5086iM14899a = this.f14657e.m14899a();
        c5103z.m19312a(c5086iM14899a);
        this.f14658f = this.f14656d.m19447a(c5103z, Telephony.Mms.Draft.CONTENT_URI);
        this.f14657e.m14905a(c5086iM14899a);
        return c5103z;
    }

    /* renamed from: a */
    private void m15654a(String[] strArr, C5103z c5103z) {
        C5082e[] c5082eArrM15660b = m15660b(strArr);
        if (c5082eArrM15660b != null) {
            c5103z.m19466a(c5082eArrM15660b);
        }
    }

    /* renamed from: b */
    private static C5082e[] m15660b(String[] strArr) {
        int length = strArr.length;
        if (length > 0) {
            C5082e[] c5082eArr = new C5082e[length];
            for (int i = 0; i < length; i++) {
                c5082eArr[i] = new C5082e(strArr[i]);
            }
            return c5082eArr;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static long m15657b(Context context, String[] strArr) {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            if (str != null) {
                hashSet.add(str);
            }
        }
        return Telephony.Threads.getOrCreateThreadId(context, hashSet);
    }
}
