package com.sec.chaton.api;

import android.content.Intent;
import android.net.Uri;
import com.sec.chaton.api.access_token.AccessTokenProvider;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3347i;
import java.util.concurrent.CancellationException;
import twitter4j.conf.PropertyConfiguration;

/* compiled from: BuddyBackgroundHandler.java */
/* renamed from: com.sec.chaton.api.a */
/* loaded from: classes.dex */
public class C0439a implements InterfaceC0441b {

    /* renamed from: a */
    private static final String f1503a = C0439a.class.getSimpleName();

    @Override // com.sec.chaton.api.InterfaceC0441b
    /* renamed from: a */
    public boolean mo3065a(Intent intent) {
        if (!"com.sec.chaton.api.background.ADD_BUDDY".equals(intent.getAction())) {
            return false;
        }
        String stringExtra = intent.getStringExtra("request_id");
        String stringExtra2 = intent.getStringExtra("packageName");
        String stringExtra3 = intent.getStringExtra(PropertyConfiguration.PASSWORD);
        String stringExtra4 = intent.getStringExtra("id");
        boolean booleanExtra = intent.getBooleanExtra("isChatONId", false);
        if (!AccessTokenProvider.m3068a(CommonApplication.m11493l(), stringExtra3)) {
            if (C3250y.f11736d) {
                C3250y.m11455d("Access token is invalid.", f1503a);
            }
            m3064a(stringExtra2, stringExtra, 3);
            return true;
        }
        if (!C3347i.m11788k()) {
            if (C3250y.f11736d) {
                C3250y.m11455d("Network isn't available.", f1503a);
            }
            m3064a(stringExtra2, stringExtra, 3);
            return true;
        }
        try {
            C0267d c0267dB = new C1330h(null).m5731b(stringExtra4, booleanExtra).m5491b();
            if (c0267dB.m1351b() == EnumC1587o.SUCCESS) {
                if (C3250y.f11734b) {
                    C3250y.m11450b("AddBuddy is success.", f1503a);
                }
                m3064a(stringExtra2, stringExtra, 1);
            } else if (c0267dB.m1351b() == EnumC1587o.NO_CONTENT) {
                if (C3250y.f11736d) {
                    C3250y.m11455d("Unknown buddy.", f1503a);
                }
                m3064a(stringExtra2, stringExtra, 100);
            } else if (c0267dB.m1355f() == 16003) {
                if (C3250y.f11737e) {
                    C3250y.m11442a("Can't add myself.", f1503a);
                }
                m3064a(stringExtra2, stringExtra, 101);
            } else if (c0267dB.m1355f() == 16004) {
                if (C3250y.f11737e) {
                    C3250y.m11442a("Already your buddy.", f1503a);
                }
                m3064a(stringExtra2, stringExtra, 102);
            } else if (c0267dB.m1355f() == 16005) {
                if (C3250y.f11737e) {
                    C3250y.m11442a("Blocked buddy.", f1503a);
                }
                m3064a(stringExtra2, stringExtra, 103);
            } else if (c0267dB.m1355f() == 16010) {
                if (C3250y.f11737e) {
                    C3250y.m11442a("Invalid phone number.", f1503a);
                }
                m3064a(stringExtra2, stringExtra, 104);
            } else {
                if (C3250y.f11737e) {
                    C3250y.m11442a("Network error.", f1503a);
                }
                m3064a(stringExtra2, stringExtra, 0);
            }
        } catch (InterruptedException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f1503a);
            }
            m3064a(stringExtra2, stringExtra, 0);
        } catch (CancellationException e2) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e2, f1503a);
            }
            m3064a(stringExtra2, stringExtra, 0);
        }
        return true;
    }

    /* renamed from: a */
    private void m3064a(String str, String str2, int i) {
        Intent intent = new Intent("com.sec.chaton.api.background.ADD_BUDDY_RESULT");
        intent.setData(new Uri.Builder().scheme(str).build());
        intent.putExtra("request_id", str2);
        if (i == 1) {
            intent.putExtra("result", true);
        } else {
            intent.putExtra("result", false);
        }
        intent.putExtra("result_code", i);
        CommonApplication.m11493l().sendBroadcast(intent);
    }
}
