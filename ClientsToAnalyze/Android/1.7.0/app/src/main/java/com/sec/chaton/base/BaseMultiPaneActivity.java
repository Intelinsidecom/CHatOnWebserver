package com.sec.chaton.base;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.sec.chaton.util.C1341p;
import java.util.Iterator;

/* loaded from: classes.dex */
public class BaseMultiPaneActivity extends BaseActivity {
    @Override // com.sec.chaton.base.BaseActivity
    /* renamed from: a */
    public void mo2044a(Intent intent) {
        if (intent.getComponent().getClassName() != null) {
            C0353a c0353aMo655a = mo655a(intent.getComponent().getClassName());
            if (c0353aMo655a != null) {
                m2045a(getSupportFragmentManager(), c0353aMo655a, intent);
                return;
            }
        } else {
            Iterator<ResolveInfo> it = getPackageManager().queryIntentActivities(intent, 65536).iterator();
            while (it.hasNext()) {
                C0353a c0353aMo655a2 = mo655a(it.next().activityInfo.name);
                if (c0353aMo655a2 != null) {
                    m2045a(getSupportFragmentManager(), c0353aMo655a2, intent);
                    return;
                }
            }
        }
        super.mo2044a(intent);
    }

    /* renamed from: a */
    private void m2045a(FragmentManager fragmentManager, C0353a c0353a, Intent intent) {
        Bundle bundleB = m2042b(intent);
        try {
            Fragment fragment = (Fragment) c0353a.m2048a().newInstance();
            fragment.setArguments(bundleB);
            FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
            fragmentTransactionBeginTransaction.replace(c0353a.m2050c(), fragment, c0353a.m2049b());
            m2046a(fragmentManager, fragmentTransactionBeginTransaction, fragment);
            fragmentTransactionBeginTransaction.commit();
        } catch (IllegalAccessException e) {
            C1341p.m4651a("Error creating new Fragmnet", getClass().getSimpleName());
        } catch (InstantiationException e2) {
            C1341p.m4651a("Error creating new Fragmnet", getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    protected C0353a mo655a(String str) {
        return null;
    }

    /* renamed from: a */
    protected void m2046a(FragmentManager fragmentManager, FragmentTransaction fragmentTransaction, Fragment fragment) {
    }
}
