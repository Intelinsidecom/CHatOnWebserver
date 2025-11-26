package com.sec.chaton;

import android.app.ActionBar;
import android.content.res.Configuration;
import android.database.DataSetObserver;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.common.actionbar.AbstractC3284a;
import com.sec.common.actionbar.AbstractC3286c;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.common.actionbar.InterfaceC3285b;
import com.sec.common.actionbar.InterfaceC3287d;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class FlexibleActivity extends ActionBarFragmentActivity implements InterfaceC3285b, InterfaceC3287d {

    /* renamed from: a */
    private static final String f683a = FlexibleActivity.class.getSimpleName();

    /* renamed from: b */
    private boolean f684b;

    /* renamed from: c */
    private boolean f685c;

    /* renamed from: g */
    private DataSetObserver f689g = new C2119r(this);

    /* renamed from: e */
    private int f687e = -1;

    /* renamed from: f */
    private int f688f = -1;

    /* renamed from: d */
    private boolean f686d = false;

    /* renamed from: a */
    protected abstract BaseAdapter mo1151a();

    /* renamed from: a */
    protected abstract void mo1152a(int i);

    @Override // com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT <= 13) {
            setContentView(new FrameLayout(this));
        }
        m1150c();
        mo1151a().registerDataSetObserver(this.f689g);
        m1149b(m1148b());
        this.f688f = C3159aa.m10962a().m10978a("menuIndex", Integer.valueOf(this.f687e)).intValue();
    }

    @Override // com.sec.common.actionbar.ActionBarFragmentActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        AbstractC3284a abstractC3284aK = m11543k();
        if (this.f688f == -1) {
            abstractC3284aK.mo11592d(this.f687e != -1 ? this.f687e : 0);
        } else {
            abstractC3284aK.mo11592d(this.f688f != -1 ? this.f688f : 0);
            this.f688f = -1;
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        C3159aa.m10964a("menuIndex", Integer.valueOf(this.f687e));
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        mo1151a().unregisterDataSetObserver(this.f689g);
    }

    @Override // com.sec.common.actionbar.InterfaceC3285b
    /* renamed from: a */
    public boolean mo1154a(int i, long j) {
        this.f688f = -1;
        if (this.f687e != i) {
            this.f687e = i;
            mo1152a(this.f687e);
            return false;
        }
        return false;
    }

    @Override // com.sec.common.actionbar.InterfaceC3287d
    /* renamed from: a */
    public void mo1153a(AbstractC3286c abstractC3286c, FragmentTransaction fragmentTransaction) {
        if (!this.f686d) {
            this.f688f = -1;
            int iMo11602b = abstractC3286c.mo11602b();
            if (this.f687e != iMo11602b) {
                this.f687e = iMo11602b;
                mo1152a(this.f687e);
            }
        }
    }

    @Override // com.sec.common.actionbar.InterfaceC3287d
    /* renamed from: b */
    public void mo1155b(AbstractC3286c abstractC3286c, FragmentTransaction fragmentTransaction) {
    }

    @Override // com.sec.common.actionbar.InterfaceC3287d
    /* renamed from: c */
    public void mo1156c(AbstractC3286c abstractC3286c, FragmentTransaction fragmentTransaction) {
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m1150c();
        AbstractC3284a abstractC3284aK = m11543k();
        if (abstractC3284aK != null) {
            m1149b(m1148b());
            abstractC3284aK.mo11592d(this.f687e == -1 ? 0 : this.f687e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m1149b(int i) {
        AbstractC3284a abstractC3284aK = m11543k();
        BaseAdapter baseAdapterMo1151a = mo1151a();
        if (i == 1) {
            abstractC3284aK.mo11579a(1);
            if (!this.f684b) {
                abstractC3284aK.mo11581a(baseAdapterMo1151a, this);
                this.f684b = true;
                return;
            }
            return;
        }
        if (i == 2) {
            if (this.f685c) {
                this.f686d = true;
            }
            abstractC3284aK.mo11579a(2);
            this.f686d = false;
            for (int i2 = 0; i2 < baseAdapterMo1151a.getCount(); i2++) {
                AbstractC3286c abstractC3286cM1145a = m1145a(abstractC3284aK, i2);
                if (abstractC3286cM1145a != null) {
                    abstractC3286cM1145a.mo11600a(baseAdapterMo1151a.getView(i2, abstractC3286cM1145a.mo11599a(), null));
                } else {
                    m1146a(abstractC3284aK, baseAdapterMo1151a.getView(i2, null, null));
                }
            }
            if (!this.f685c) {
                this.f685c = true;
            }
        }
    }

    /* renamed from: a */
    private AbstractC3286c m1145a(AbstractC3284a abstractC3284a, int i) {
        if (abstractC3284a.mo11589c() <= i) {
            return null;
        }
        return abstractC3284a.mo11590c(i);
    }

    /* renamed from: a */
    private AbstractC3286c m1146a(AbstractC3284a abstractC3284a, View view) {
        AbstractC3286c abstractC3286cMo11601a = abstractC3284a.mo11585b().mo11600a(view).mo11601a(this);
        abstractC3284a.mo11582a(abstractC3286cMo11601a, false);
        return abstractC3286cMo11601a;
    }

    /* renamed from: b */
    private int m1148b() {
        return (!GlobalApplication.m6456e() && getResources().getConfiguration().orientation == 2) ? 1 : 2;
    }

    /* renamed from: c */
    private void m1150c() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (!GlobalApplication.m6456e() && Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT <= 15) {
            ActionBar actionBar = getActionBar();
            try {
                Method declaredMethod = actionBar.getClass().getDeclaredMethod("setHasEmbeddedTabs", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(actionBar, false);
            } catch (Exception e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, f683a);
                }
            }
        }
    }
}
