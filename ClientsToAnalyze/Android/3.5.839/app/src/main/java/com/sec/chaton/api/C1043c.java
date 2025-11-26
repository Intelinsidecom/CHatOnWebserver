package com.sec.chaton.api;

import android.content.Intent;
import android.net.Uri;
import com.sec.chaton.api.access_token.AccessTokenProvider;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p067j.EnumC2463n;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5034k;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* compiled from: BuddyBackgroundHandler.java */
/* renamed from: com.sec.chaton.api.c */
/* loaded from: classes.dex */
public class C1043c implements InterfaceC1044d {

    /* renamed from: a */
    private static final String f3340a = C1043c.class.getSimpleName();

    @Override // com.sec.chaton.api.InterfaceC1044d
    /* renamed from: a */
    public boolean mo6152a(Intent intent) throws ExecutionException, InterruptedException {
        if (!"com.sec.chaton.api.background.ADD_BUDDY".equals(intent.getAction())) {
            return false;
        }
        String stringExtra = intent.getStringExtra("request_id");
        String stringExtra2 = intent.getStringExtra("packageName");
        String stringExtra3 = intent.getStringExtra("password");
        String stringExtra4 = intent.getStringExtra("id");
        boolean booleanExtra = intent.getBooleanExtra("isChatONId", false);
        if (!AccessTokenProvider.m6136a(CommonApplication.m18732r(), stringExtra3)) {
            if (C4904y.f17874d) {
                C4904y.m18645d("Access token is invalid.", f3340a);
            }
            m6151a(stringExtra2, stringExtra, 3);
            return true;
        }
        if (!C5034k.m19106k()) {
            if (C4904y.f17874d) {
                C4904y.m18645d("Network isn't available.", f3340a);
            }
            m6151a(stringExtra2, stringExtra, 3);
            return true;
        }
        try {
            C0778b c0778b = new C2128i(null).m9494a(stringExtra4, booleanExtra, EnumC2463n.BACKGROUND).get();
            if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("AddBuddy is success.", f3340a);
                }
                m6151a(stringExtra2, stringExtra, 1);
            } else if (c0778b.m3107b() == EnumC2464o.NO_CONTENT) {
                if (C4904y.f17874d) {
                    C4904y.m18645d("Unknown buddy.", f3340a);
                }
                m6151a(stringExtra2, stringExtra, 100);
            } else if (c0778b.m3111f() == 16003) {
                if (C4904y.f17875e) {
                    C4904y.m18634a("Can't add myself.", f3340a);
                }
                m6151a(stringExtra2, stringExtra, 101);
            } else if (c0778b.m3111f() == 16004) {
                if (C4904y.f17875e) {
                    C4904y.m18634a("Already your buddy.", f3340a);
                }
                m6151a(stringExtra2, stringExtra, 102);
            } else if (c0778b.m3111f() == 16005) {
                if (C4904y.f17875e) {
                    C4904y.m18634a("Blocked buddy.", f3340a);
                }
                m6151a(stringExtra2, stringExtra, 103);
            } else if (c0778b.m3111f() == 16010) {
                if (C4904y.f17875e) {
                    C4904y.m18634a("Invalid phone number.", f3340a);
                }
                m6151a(stringExtra2, stringExtra, 104);
            } else {
                if (C4904y.f17875e) {
                    C4904y.m18634a("Network error.", f3340a);
                }
                m6151a(stringExtra2, stringExtra, 0);
            }
        } catch (InterruptedException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f3340a);
            }
            m6151a(stringExtra2, stringExtra, 0);
        } catch (CancellationException e2) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e2, f3340a);
            }
            m6151a(stringExtra2, stringExtra, 0);
        } catch (ExecutionException e3) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e3, f3340a);
            }
            m6151a(stringExtra2, stringExtra, 0);
        }
        return true;
    }

    /* renamed from: a */
    private void m6151a(String str, String str2, int i) {
        Intent intent = new Intent("com.sec.chaton.api.background.ADD_BUDDY_RESULT");
        intent.setData(new Uri.Builder().scheme(str).build());
        intent.putExtra("request_id", str2);
        if (i == 1) {
            intent.putExtra("result", true);
        } else {
            intent.putExtra("result", false);
        }
        intent.putExtra("result_code", i);
        CommonApplication.m18732r().sendBroadcast(intent);
    }
}
