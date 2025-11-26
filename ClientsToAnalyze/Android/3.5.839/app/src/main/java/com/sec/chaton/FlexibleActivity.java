package com.sec.chaton;

import android.app.ActionBar;
import android.content.res.Configuration;
import android.database.DataSetObserver;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.AbstractC0024aj;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.actionbar.AbstractC4946a;
import com.sec.common.actionbar.AbstractC4948c;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.common.actionbar.InterfaceC4947b;
import com.sec.common.actionbar.InterfaceC4949d;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class FlexibleActivity extends ActionBarFragmentActivity implements InterfaceC4947b, InterfaceC4949d {

    /* renamed from: n */
    private static final String f1937n = FlexibleActivity.class.getSimpleName();

    /* renamed from: o */
    private boolean f1938o;

    /* renamed from: p */
    private boolean f1939p;

    /* renamed from: t */
    private DataSetObserver f1943t = new C1070bj(this);

    /* renamed from: r */
    private int f1941r = -1;

    /* renamed from: s */
    private int f1942s = -1;

    /* renamed from: q */
    private boolean f1940q = false;

    /* renamed from: a */
    protected abstract void mo2906a(int i);

    /* renamed from: f */
    protected abstract BaseAdapter mo2911f();

    @Override // com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT <= 13) {
            setContentView(new FrameLayout(this));
        }
        m2905h();
        mo2911f().registerDataSetObserver(this.f1943t);
        m2903b(m2904g());
        this.f1942s = C4809aa.m18104a().m18120a("menuIndex", Integer.valueOf(this.f1941r)).intValue();
    }

    @Override // com.sec.common.actionbar.ActionBarFragmentActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        AbstractC4946a abstractC4946aT = m18784t();
        if (this.f1942s == -1) {
            abstractC4946aT.mo18832d(this.f1941r != -1 ? this.f1941r : 0);
        } else {
            abstractC4946aT.mo18832d(this.f1942s != -1 ? this.f1942s : 0);
            this.f1942s = -1;
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        C4809aa.m18106a("menuIndex", Integer.valueOf(this.f1941r));
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        mo2911f().unregisterDataSetObserver(this.f1943t);
    }

    @Override // com.sec.common.actionbar.InterfaceC4947b
    /* renamed from: a */
    public boolean mo2908a(int i, long j) {
        this.f1942s = -1;
        if (this.f1941r != i) {
            this.f1941r = i;
            mo2906a(this.f1941r);
            return false;
        }
        return false;
    }

    @Override // com.sec.common.actionbar.InterfaceC4949d
    /* renamed from: a */
    public void mo2907a(AbstractC4948c abstractC4948c, AbstractC0024aj abstractC0024aj) {
        if (!this.f1940q) {
            this.f1942s = -1;
            int iMo18841b = abstractC4948c.mo18841b();
            if (this.f1941r != iMo18841b) {
                this.f1941r = iMo18841b;
                mo2906a(this.f1941r);
            }
        }
    }

    @Override // com.sec.common.actionbar.InterfaceC4949d
    /* renamed from: b */
    public void mo2909b(AbstractC4948c abstractC4948c, AbstractC0024aj abstractC0024aj) {
    }

    @Override // com.sec.common.actionbar.InterfaceC4949d
    /* renamed from: c */
    public void mo2910c(AbstractC4948c abstractC4948c, AbstractC0024aj abstractC0024aj) {
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m2905h();
        AbstractC4946a abstractC4946aT = m18784t();
        if (abstractC4946aT != null) {
            m2903b(m2904g());
            abstractC4946aT.mo18832d(this.f1941r == -1 ? 0 : this.f1941r);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m2903b(int i) {
        AbstractC4946a abstractC4946aT = m18784t();
        BaseAdapter baseAdapterMo2911f = mo2911f();
        if (i == 1) {
            abstractC4946aT.mo18819a(1);
            if (!this.f1938o) {
                abstractC4946aT.mo18821a(baseAdapterMo2911f, this);
                this.f1938o = true;
                return;
            }
            return;
        }
        if (i == 2) {
            if (this.f1939p) {
                this.f1940q = true;
            }
            abstractC4946aT.mo18819a(2);
            this.f1940q = false;
            for (int i2 = 0; i2 < baseAdapterMo2911f.getCount(); i2++) {
                AbstractC4948c abstractC4948cM2900a = m2900a(abstractC4946aT, i2);
                if (abstractC4948cM2900a != null) {
                    abstractC4948cM2900a.mo18839a(baseAdapterMo2911f.getView(i2, abstractC4948cM2900a.mo18838a(), null));
                } else {
                    m2901a(abstractC4946aT, baseAdapterMo2911f.getView(i2, null, null));
                }
            }
            if (!this.f1939p) {
                this.f1939p = true;
            }
        }
    }

    /* renamed from: a */
    private AbstractC4948c m2900a(AbstractC4946a abstractC4946a, int i) {
        if (abstractC4946a.mo18829c() <= i) {
            return null;
        }
        return abstractC4946a.mo18830c(i);
    }

    /* renamed from: a */
    private AbstractC4948c m2901a(AbstractC4946a abstractC4946a, View view) {
        AbstractC4948c abstractC4948cMo18840a = abstractC4946a.mo18825b().mo18839a(view).mo18840a(this);
        abstractC4946a.mo18822a(abstractC4948cMo18840a, false);
        return abstractC4948cMo18840a;
    }

    /* renamed from: g */
    private int m2904g() {
        return getResources().getConfiguration().orientation == 2 ? 1 : 2;
    }

    /* renamed from: h */
    private void m2905h() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 11) {
            ActionBar actionBar = getActionBar();
            try {
                Method declaredMethod = actionBar.getClass().getDeclaredMethod("setHasEmbeddedTabs", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(actionBar, false);
            } catch (Exception e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f1937n);
                }
            }
        }
    }
}
