package com.sec.chaton.base;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.sec.chaton.util.ChatONLogWriter;
import java.util.Iterator;

/* loaded from: classes.dex */
public class BaseMultiPaneActivity extends BaseActivity {

    public class FragmentReplaceInfo {

        /* renamed from: b */
        private Class f342b;

        /* renamed from: c */
        private String f343c;

        /* renamed from: d */
        private int f344d;

        public FragmentReplaceInfo(Class cls, String str, int i) {
            this.f342b = cls;
            this.f343c = str;
            this.f344d = i;
        }

        /* renamed from: a */
        public Class m416a() {
            return this.f342b;
        }

        /* renamed from: b */
        public String m417b() {
            return this.f343c;
        }

        /* renamed from: c */
        public int m418c() {
            return this.f344d;
        }
    }

    /* renamed from: a */
    private void m414a(FragmentManager fragmentManager, FragmentReplaceInfo fragmentReplaceInfo, Intent intent) {
        Bundle bundleIntentToFragmentArgument = intentToFragmentArgument(intent);
        try {
            Fragment fragment = (Fragment) fragmentReplaceInfo.m416a().newInstance();
            fragment.setArguments(bundleIntentToFragmentArgument);
            FragmentTransaction fragmentTransactionMo6a = fragmentManager.mo6a();
            fragmentTransactionMo6a.mo16b(fragmentReplaceInfo.m418c(), fragment, fragmentReplaceInfo.m417b());
            m415a(fragmentManager, fragmentTransactionMo6a, fragment);
            fragmentTransactionMo6a.mo10a();
        } catch (IllegalAccessException e) {
            ChatONLogWriter.m3499a("Error creating new Fragmnet", getClass().getSimpleName());
        } catch (InstantiationException e2) {
            ChatONLogWriter.m3499a("Error creating new Fragmnet", getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    protected FragmentReplaceInfo mo378a(String str) {
        return null;
    }

    /* renamed from: a */
    protected void m415a(FragmentManager fragmentManager, FragmentTransaction fragmentTransaction, Fragment fragment) {
    }

    @Override // com.sec.chaton.base.BaseActivity
    public void openActivityOrFragment(Intent intent) {
        if (intent.getComponent().getClassName() != null) {
            FragmentReplaceInfo fragmentReplaceInfoMo378a = mo378a(intent.getComponent().getClassName());
            if (fragmentReplaceInfoMo378a != null) {
                m414a(getSupportFragmentManager(), fragmentReplaceInfoMo378a, intent);
                return;
            }
        } else {
            Iterator<ResolveInfo> it = getPackageManager().queryIntentActivities(intent, 65536).iterator();
            while (it.hasNext()) {
                FragmentReplaceInfo fragmentReplaceInfoMo378a2 = mo378a(it.next().activityInfo.name);
                if (fragmentReplaceInfoMo378a2 != null) {
                    m414a(getSupportFragmentManager(), fragmentReplaceInfoMo378a2, intent);
                    return;
                }
            }
        }
        super.openActivityOrFragment(intent);
    }
}
