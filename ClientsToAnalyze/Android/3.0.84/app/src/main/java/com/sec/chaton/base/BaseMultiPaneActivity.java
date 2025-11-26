package com.sec.chaton.base;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.sec.chaton.util.C3250y;
import java.util.Iterator;

/* loaded from: classes.dex */
public class BaseMultiPaneActivity extends BaseActivity {
    @Override // com.sec.chaton.base.BaseActivity
    /* renamed from: a */
    public void mo3084a(Intent intent) {
        if (intent.getComponent().getClassName() != null) {
            C0458c c0458cMo3086a = mo3086a(intent.getComponent().getClassName());
            if (c0458cMo3086a != null) {
                m3085a(getSupportFragmentManager(), c0458cMo3086a, intent);
                return;
            }
        } else {
            Iterator<ResolveInfo> it = getPackageManager().queryIntentActivities(intent, 65536).iterator();
            while (it.hasNext()) {
                C0458c c0458cMo3086a2 = mo3086a(it.next().activityInfo.name);
                if (c0458cMo3086a2 != null) {
                    m3085a(getSupportFragmentManager(), c0458cMo3086a2, intent);
                    return;
                }
            }
        }
        super.mo3084a(intent);
    }

    /* renamed from: a */
    private void m3085a(FragmentManager fragmentManager, C0458c c0458c, Intent intent) {
        Bundle bundleB = m3082b(intent);
        try {
            Fragment fragment = (Fragment) c0458c.m3091a().newInstance();
            fragment.setArguments(bundleB);
            FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
            fragmentTransactionBeginTransaction.replace(c0458c.m3093c(), fragment, c0458c.m3092b());
            m3087a(fragmentManager, fragmentTransactionBeginTransaction, fragment);
            fragmentTransactionBeginTransaction.commit();
        } catch (IllegalAccessException e) {
            C3250y.m11442a("Error creating new Fragmnet", getClass().getSimpleName());
        } catch (IllegalStateException e2) {
            C3250y.m11442a("Error creating new Fragmnet: IllegalStateException", getClass().getSimpleName());
        } catch (InstantiationException e3) {
            C3250y.m11442a("Error creating new Fragmnet", getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    protected C0458c mo3086a(String str) {
        return null;
    }

    /* renamed from: a */
    protected void m3087a(FragmentManager fragmentManager, FragmentTransaction fragmentTransaction, Fragment fragment) {
    }
}
