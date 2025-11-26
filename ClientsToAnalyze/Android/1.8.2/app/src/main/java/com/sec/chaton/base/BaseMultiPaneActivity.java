package com.sec.chaton.base;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.sec.chaton.util.C1786r;
import java.util.Iterator;

/* loaded from: classes.dex */
public class BaseMultiPaneActivity extends BaseActivity {
    @Override // com.sec.chaton.base.BaseActivity
    /* renamed from: a */
    public void mo1830a(Intent intent) {
        if (intent.getComponent().getClassName() != null) {
            C0240a c0240aMo608a = mo608a(intent.getComponent().getClassName());
            if (c0240aMo608a != null) {
                m1831a(getSupportFragmentManager(), c0240aMo608a, intent);
                return;
            }
        } else {
            Iterator<ResolveInfo> it = getPackageManager().queryIntentActivities(intent, 65536).iterator();
            while (it.hasNext()) {
                C0240a c0240aMo608a2 = mo608a(it.next().activityInfo.name);
                if (c0240aMo608a2 != null) {
                    m1831a(getSupportFragmentManager(), c0240aMo608a2, intent);
                    return;
                }
            }
        }
        super.mo1830a(intent);
    }

    /* renamed from: a */
    private void m1831a(FragmentManager fragmentManager, C0240a c0240a, Intent intent) {
        Bundle bundleB = m1828b(intent);
        try {
            Fragment fragment = (Fragment) c0240a.m1835a().newInstance();
            fragment.setArguments(bundleB);
            FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
            fragmentTransactionBeginTransaction.replace(c0240a.m1837c(), fragment, c0240a.m1836b());
            m1832a(fragmentManager, fragmentTransactionBeginTransaction, fragment);
            fragmentTransactionBeginTransaction.commit();
        } catch (IllegalAccessException e) {
            C1786r.m6054a("Error creating new Fragmnet", getClass().getSimpleName());
        } catch (InstantiationException e2) {
            C1786r.m6054a("Error creating new Fragmnet", getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    protected C0240a mo608a(String str) {
        return null;
    }

    /* renamed from: a */
    protected void m1832a(FragmentManager fragmentManager, FragmentTransaction fragmentTransaction, Fragment fragment) {
    }
}
