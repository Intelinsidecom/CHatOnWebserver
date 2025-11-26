package com.sec.chaton.smsplugin.transaction;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.android.i18n.phonenumbers.NumberParseException;
import com.android.i18n.phonenumbers.PhoneNumberUtil;
import com.android.i18n.phonenumbers.Phonenumber;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.C2097bc;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p065io.entry.GetSMSAuthToken;
import com.sec.chaton.p065io.entry.SendFreeSMSEntry;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;

/* compiled from: FreeSmsSender.java */
/* renamed from: com.sec.chaton.smsplugin.transaction.i */
/* loaded from: classes.dex */
class HandlerC4073i extends Handler {

    /* renamed from: a */
    final /* synthetic */ C4072h f14679a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC4073i(C4072h c4072h, Looper looper) {
        super(looper);
        this.f14679a = c4072h;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws PendingIntent.CanceledException {
        boolean z;
        boolean z2 = true;
        C0778b c0778b = (C0778b) message.obj;
        switch (message.what) {
            case 1306:
                if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                    GetSMSAuthToken getSMSAuthToken = (GetSMSAuthToken) c0778b.m3110e();
                    if (getSMSAuthToken != null) {
                        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
                        try {
                            boolean z3 = !C2190d.m9840f(this.f14679a.f14676i).equals(this.f14679a.f14676i);
                            Phonenumber.PhoneNumber phoneNumber = phoneNumberUtil.parse(this.f14679a.f14676i, C4822an.m18236g().toUpperCase());
                            String[] strArr = {String.valueOf(phoneNumber.getCountryCode())};
                            String[] strArr2 = {String.valueOf(phoneNumber.getNationalNumber())};
                            C2097bc c2097bc = this.f14679a.f14674a;
                            String str = getSMSAuthToken.token;
                            String str2 = this.f14679a.f14616e;
                            String[] strArr3 = new String[1];
                            strArr3[0] = z3 ? Spam.ACTIVITY_REPORT : Spam.ACTIVITY_CANCEL;
                            c2097bc.m9374a(str, strArr, strArr2, str2, strArr3);
                            if (C4904y.f17872b) {
                                C4904y.m18639b("control.sendFreeSMSMsg: callingCode =" + strArr[0] + "number =" + strArr2[0] + " msg=" + this.f14679a.f14616e, "FreeSmsSender");
                            }
                            z = false;
                        } catch (NumberParseException e) {
                            e.printStackTrace();
                        }
                        z2 = z;
                    } else {
                        z = true;
                        z2 = z;
                    }
                } else {
                    Intent intent = new Intent("com.sec.chaton.smsplugin.transaction.MESSAGE_SENT", this.f14679a.f14677j, this.f14679a.f14614c, SmsReceiver.class);
                    intent.putExtra("errorCode", c0778b.m18953m());
                    try {
                        PendingIntent.getBroadcast(this.f14679a.f14614c, 0, intent, 0).send(this.f14679a.f14614c, 1, intent);
                    } catch (PendingIntent.CanceledException e2) {
                        e2.printStackTrace();
                    }
                    if (c0778b.m3111f() == 42000 || c0778b.m3111f() == 42001) {
                        C4809aa.m18105a("free_sms_is_available", (Boolean) false);
                        C4809aa.m18105a("pref_key_is_free_sms_enable", (Boolean) false);
                    }
                }
                if (z2) {
                    C4072h.f14673k.remove(Integer.valueOf(this.f14679a.f14678l));
                    if (C4904y.f17872b) {
                        C4904y.m18639b("instanceObjects.remove - mMessageText : " + this.f14679a.f14616e + " mHashIndex : " + this.f14679a.f14678l, "FreeSmsSender");
                        break;
                    }
                }
                break;
            case 1307:
                Intent intent2 = new Intent("com.sec.chaton.smsplugin.transaction.MESSAGE_SENT", this.f14679a.f14677j, this.f14679a.f14614c, SmsReceiver.class);
                PendingIntent broadcast = PendingIntent.getBroadcast(this.f14679a.f14614c, 0, intent2, 0);
                if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                    SendFreeSMSEntry sendFreeSMSEntry = (SendFreeSMSEntry) c0778b.m3110e();
                    if (sendFreeSMSEntry != null) {
                        try {
                            C4809aa.m18104a().m18126b("free_sms_remain_count", Integer.valueOf(sendFreeSMSEntry.remain));
                            C4809aa.m18104a().m18126b("free_sms_max_count", Integer.valueOf(sendFreeSMSEntry.max));
                            broadcast.send(this.f14679a.f14614c, -1, intent2);
                            if (C4904y.f17872b) {
                                C4904y.m18639b("Free SMS sent: address=" + this.f14679a.f14676i + " msg=" + this.f14679a.f14616e + ", threadId=" + this.f14679a.f14618g + ", uri=" + this.f14679a.f14677j, "FreeSmsSender");
                            }
                        } catch (PendingIntent.CanceledException e3) {
                            e3.printStackTrace();
                        }
                    }
                } else {
                    intent2.putExtra("errorCode", c0778b.m18953m());
                    try {
                        broadcast.send(this.f14679a.f14614c, 1, intent2);
                    } catch (PendingIntent.CanceledException e4) {
                        e4.printStackTrace();
                    }
                    if (c0778b.m3111f() == 42000 || c0778b.m3111f() == 42001) {
                        C4809aa.m18105a("free_sms_is_available", (Boolean) false);
                        C4809aa.m18105a("pref_key_is_free_sms_enable", (Boolean) false);
                    }
                }
                C4072h.f14673k.remove(Integer.valueOf(this.f14679a.f14678l));
                if (C4904y.f17872b) {
                    C4904y.m18639b("instanceObjects remove - mMessageText : " + this.f14679a.f14616e + " mHashIndex : " + this.f14679a.f14678l, "FreeSmsSender");
                    break;
                }
                break;
            default:
                C4072h.f14673k.remove(Integer.valueOf(this.f14679a.f14678l));
                if (C4904y.f17872b) {
                    C4904y.m18639b("instanceObjects remove - mMessageText : " + this.f14679a.f14616e + " mHashIndex : " + this.f14679a.f14678l, "FreeSmsSender");
                    break;
                }
                break;
        }
    }
}
