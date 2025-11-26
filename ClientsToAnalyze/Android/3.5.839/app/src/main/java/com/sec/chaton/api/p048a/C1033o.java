package com.sec.chaton.api.p048a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.sec.chaton.registration.AuthenticatorActivity;
import com.sec.chaton.registration.EnumC3297gd;
import com.sec.chaton.registration.RegisterSMSActivity;
import com.sec.chaton.util.C4904y;
import java.io.UnsupportedEncodingException;

/* compiled from: RegistrationLinkProcessor.java */
/* renamed from: com.sec.chaton.api.a.o */
/* loaded from: classes.dex */
public class C1033o extends AbstractC1019a {

    /* renamed from: c */
    private static final String f3330c = C1033o.class.getSimpleName();

    @Override // com.sec.chaton.api.p048a.AbstractC1019a
    /* renamed from: a */
    public boolean mo6112a(Activity activity, Intent intent) {
        Uri data = intent.getData();
        if (data != null) {
            String host = data.getHost();
            String path = data.getPath();
            if ("registration".equals(host)) {
                if ("/phonenumber".equals(path)) {
                    try {
                        String strA = m6110a(data, "token", "UTF-8");
                        if (C4904y.f17872b) {
                            C4904y.m18639b("registration/phonenumber. token: " + strA, f3330c);
                        }
                        Intent intent2 = new Intent(activity, (Class<?>) RegisterSMSActivity.class);
                        intent2.addFlags(67108864);
                        intent2.addFlags(33554432);
                        intent2.putExtra("request_register", EnumC3297gd.auto_register);
                        intent2.putExtra("register_sms_token", strA);
                        activity.startActivity(intent2);
                        return true;
                    } catch (UnsupportedEncodingException e) {
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e, f3330c);
                        }
                        throw new IllegalArgumentException(e);
                    }
                }
                if (C4904y.f17874d) {
                    C4904y.m18645d("It is unknown path. Go to normal registration procedure.", f3330c);
                }
                Intent intent3 = new Intent(activity, (Class<?>) AuthenticatorActivity.class);
                intent3.addFlags(33554432);
                intent3.putExtra("key_skip_contact_sync", true);
                activity.startActivity(intent3);
                return true;
            }
        }
        return false;
    }
}
