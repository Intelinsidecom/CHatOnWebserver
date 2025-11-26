package com.sec.chaton;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.sec.chaton.api.p048a.AbstractC1019a;
import com.sec.chaton.api.p048a.C1026h;
import com.sec.chaton.api.p048a.C1027i;
import com.sec.chaton.api.p048a.C1030l;
import com.sec.chaton.api.p048a.C1033o;
import com.sec.chaton.api.p048a.C1038t;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class BootstrapActivity extends Activity {

    /* renamed from: a */
    private static final String f1916a = BootstrapActivity.class.getSimpleName();

    /* renamed from: b */
    private static final C1027i f1917b = new C1027i(new AbstractC1019a[]{new C1033o(), new C1030l(), new C1038t()});

    @Deprecated
    /* renamed from: a */
    public static Intent m2878a(Context context, boolean z) {
        return m2877a(context, z ? 1 : 0);
    }

    /* renamed from: a */
    public static Intent m2877a(Context context, int i) {
        Intent intent = new Intent(context, (Class<?>) BootstrapActivity.class);
        intent.putExtra("skipSplash", i);
        return intent;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        boolean zM6130a;
        super.onCreate(bundle);
        try {
            zM6130a = f1917b.m6130a(this, getIntent());
        } catch (C1026h e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f1916a);
            }
            zM6130a = false;
        }
        if (!zM6130a) {
            if (C4904y.f17872b) {
                C4904y.m18639b("Can't find any processor go to ChatON.", f1916a);
            }
            startActivity(IntentControllerActivity.m2922a(this, getIntent(), getIntent().getIntExtra("skipSplash", 0)));
        }
        finish();
    }
}
