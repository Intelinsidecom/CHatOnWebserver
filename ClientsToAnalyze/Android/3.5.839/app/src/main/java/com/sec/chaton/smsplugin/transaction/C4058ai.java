package com.sec.chaton.smsplugin.transaction;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Messenger;
import android.provider.Telephony;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.text.TextUtils;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p102b.C3790i;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p111h.C3896s;
import com.sec.chaton.smsplugin.p112ui.C4149cd;
import com.sec.google.android.p134a.C5111c;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* compiled from: SmsSingleRecipientSender.java */
/* renamed from: com.sec.chaton.smsplugin.transaction.ai */
/* loaded from: classes.dex */
public class C4058ai extends C4052ac {

    /* renamed from: a */
    private final boolean f14632a;

    /* renamed from: b */
    private String f14633b;

    /* renamed from: i */
    private Uri f14634i;

    /* renamed from: j */
    private final int f14635j;

    /* renamed from: k */
    private final Messenger f14636k;

    public C4058ai(Context context, String str, String str2, long j, boolean z, Uri uri, int i, Messenger messenger) {
        super(context, null, str2, j);
        this.f14632a = z;
        this.f14633b = str;
        this.f14634i = uri;
        this.f14635j = i;
        this.f14636k = messenger;
    }

    @Override // com.sec.chaton.smsplugin.transaction.C4052ac, com.sec.chaton.smsplugin.transaction.InterfaceC4075k
    /* renamed from: a */
    public boolean mo15606a(long j) throws C5111c {
        ArrayList<String> arrayListDivideMessage;
        if (this.f14616e == null) {
            throw new C5111c("Null message body or have multiple destinations.");
        }
        SmsManager smsManager = SmsManager.getDefault();
        if (C3847e.m14705k() != null && (Telephony.Mms.isEmailAddress(this.f14633b) || C4149cd.m16418a(this.f14633b))) {
            String str = this.f14633b + " " + this.f14616e;
            this.f14633b = C3847e.m14705k();
            arrayListDivideMessage = smsManager.divideMessage(str);
        } else {
            arrayListDivideMessage = smsManager.divideMessage(this.f14616e);
            this.f14633b = PhoneNumberUtils.stripSeparators(this.f14633b);
            this.f14633b = C3790i.m14322a(this.f14614c, this.f14618g, this.f14633b);
        }
        int size = arrayListDivideMessage.size();
        if (size == 0) {
            throw new C5111c("SmsMessageSender.sendMessage: divideMessage returned empty messages. Original message is \"" + this.f14616e + "\"");
        }
        if (!Telephony.Sms.moveMessageToFolder(this.f14614c, this.f14634i, 4, 0)) {
            throw new C5111c("SmsMessageSender.sendMessage: couldn't move message to outbox: " + this.f14634i);
        }
        ArrayList<PendingIntent> arrayList = new ArrayList<>(size);
        ArrayList<PendingIntent> arrayList2 = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            if (this.f14632a && i == size - 1) {
                arrayList.add(PendingIntent.getBroadcast(this.f14614c, 0, new Intent("com.sec.chaton.smsplugin.transaction.MessageStatusReceiver.MESSAGE_STATUS_RECEIVED", this.f14634i, this.f14614c, MessageStatusReceiver.class), 0));
            } else {
                arrayList.add(null);
            }
            Intent intent = new Intent("com.sec.chaton.smsplugin.transaction.MESSAGE_SENT", this.f14634i, this.f14614c, SmsReceiver.class);
            C3896s.m15045c("SentIntent BG token == " + this.f14635j, "SmsSingleRecipientSender");
            intent.putExtra("extra_bg_token", this.f14635j);
            intent.putExtra("extra_bg_cb_messenger", this.f14636k);
            int i2 = 0;
            if (i == size - 1) {
                i2 = 1;
                intent.putExtra("SendNextMsg", true);
            }
            arrayList2.add(PendingIntent.getBroadcast(this.f14614c, i2, intent, 0));
        }
        try {
            if (C3847e.m14657aH()) {
                m15609a();
            }
            smsManager.sendMultipartTextMessage(this.f14633b, this.f14617f, arrayListDivideMessage, arrayList2, arrayList);
            return false;
        } catch (Exception e) {
            C3890m.m14995a("SmsSingleRecipientSender", "SmsMessageSender.sendMessage: caught", e);
            throw new C5111c("SmsMessageSender.sendMessage: caught " + e + " from SmsManager.sendTextMessage()");
        }
    }

    /* renamed from: a */
    private boolean m15609a() {
        Method methodM15608a = m15608a(PhoneNumberUtils.class, "convertSMSDestinationAddress", (Class<?>[]) new Class[]{String.class, Context.class, Integer.TYPE});
        String str = methodM15608a != null ? (String) m15607a((Object) null, methodM15608a, this.f14633b, this.f14614c, 0) : null;
        if (TextUtils.isEmpty(str)) {
            C3890m.m14996b("SmsSingleRecipientSender", "convertSMSAddress() result is null");
            return false;
        }
        this.f14633b = str;
        return true;
    }

    /* renamed from: a */
    private static <T> Method m15608a(Class<T> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            C3890m.m14996b("SmsSingleRecipientSender", str + " NoSuchMethodException");
            return null;
        }
    }

    /* renamed from: a */
    private static Object m15607a(Object obj, Method method, Object... objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (method == null) {
            C3890m.m14996b("SmsSingleRecipientSender", "method is null");
            return null;
        }
        try {
            Object objInvoke = method.invoke(obj, objArr);
            C3890m.m14996b("SmsSingleRecipientSender", method.getName() + " is called");
            return objInvoke;
        } catch (IllegalAccessException e) {
            C3890m.m14996b("SmsSingleRecipientSender", method.getName() + " IllegalAccessException");
            return null;
        } catch (InvocationTargetException e2) {
            C3890m.m14996b("SmsSingleRecipientSender", method.getName() + " InvocationTargetException");
            return null;
        }
    }
}
