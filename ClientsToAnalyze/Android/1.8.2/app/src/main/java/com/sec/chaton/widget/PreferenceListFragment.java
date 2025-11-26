package com.sec.chaton.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes.dex */
public class PreferenceListFragment extends ListFragment {

    /* renamed from: a */
    private PreferenceManager f6472a;

    /* renamed from: b */
    private Handler f6473b = new HandlerC1799c(this);

    /* renamed from: c */
    private ListView f6474c;

    /* renamed from: d */
    private int f6475d;

    public PreferenceListFragment(int i) {
        this.f6475d = i;
    }

    public PreferenceListFragment() {
    }

    @Override // android.support.v4.app.ListFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m6117a();
        return this.f6474c;
    }

    @Override // android.support.v4.app.ListFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ViewParent parent = this.f6474c.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this.f6474c);
        }
    }

    /* renamed from: a */
    public void m6124a(List list) {
        setListAdapter(new C1800d(getActivity(), 0, list));
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) throws NoSuchMethodException, SecurityException {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f6475d = bundle.getInt("xml");
        }
        this.f6472a = m6120c();
        this.f6474c = (ListView) LayoutInflater.from(getActivity()).inflate(R.layout.preference_list_content, (ViewGroup) null);
        this.f6474c.setScrollBarStyle(0);
        C1786r.m6061b("onCreate. b:" + bundle + ", xmlId:" + this.f6475d, getClass().getSimpleName());
        m6122a(this.f6475d);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        C1786r.m6063c("onActivityCreated", getClass().getSimpleName());
        m6117a();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.onStop();
        try {
            Method declaredMethod = PreferenceManager.class.getDeclaredMethod("dispatchActivityStop", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this.f6472a, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.onDestroy();
        this.f6474c = null;
        try {
            Method declaredMethod = PreferenceManager.class.getDeclaredMethod("dispatchActivityDestroy", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this.f6472a, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("xml", this.f6475d);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.onActivityResult(i, i2, intent);
        try {
            Method declaredMethod = PreferenceManager.class.getDeclaredMethod("dispatchActivityResult", Integer.TYPE, Integer.TYPE, Intent.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this.f6472a, Integer.valueOf(i), Integer.valueOf(i2), intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m6117a() {
        if (!this.f6473b.hasMessages(0)) {
            this.f6473b.obtainMessage(0).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6119b() throws NoSuchMethodException, SecurityException {
        PreferenceScreen preferenceScreenM6125f = m6125f();
        if (preferenceScreenM6125f != null && this.f6474c != null) {
            preferenceScreenM6125f.bind(this.f6474c);
        }
    }

    /* renamed from: c */
    private PreferenceManager m6120c() throws NoSuchMethodException, SecurityException {
        try {
            Constructor declaredConstructor = PreferenceManager.class.getDeclaredConstructor(Activity.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return (PreferenceManager) declaredConstructor.newInstance(getActivity(), 100);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public void m6123a(PreferenceScreen preferenceScreen) throws NoSuchMethodException, SecurityException {
        try {
            Method declaredMethod = PreferenceManager.class.getDeclaredMethod("setPreferences", PreferenceScreen.class);
            declaredMethod.setAccessible(true);
            if (((Boolean) declaredMethod.invoke(this.f6472a, preferenceScreen)).booleanValue() && preferenceScreen != null) {
                m6117a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: f */
    public PreferenceScreen m6125f() throws NoSuchMethodException, SecurityException {
        try {
            Method declaredMethod = PreferenceManager.class.getDeclaredMethod("getPreferenceScreen", new Class[0]);
            declaredMethod.setAccessible(true);
            return (PreferenceScreen) declaredMethod.invoke(this.f6472a, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public void m6122a(int i) throws NoSuchMethodException, SecurityException {
        if (i == 0) {
            C1786r.m6061b("addPreferencesFromResource. preferencesResId is invalid.", getClass().getSimpleName());
            return;
        }
        C1786r.m6061b("addPreferencesFromResource. preferencesResId:" + i, getClass().getSimpleName());
        try {
            Method declaredMethod = PreferenceManager.class.getDeclaredMethod("inflateFromResource", Context.class, Integer.TYPE, PreferenceScreen.class);
            declaredMethod.setAccessible(true);
            m6123a((PreferenceScreen) declaredMethod.invoke(this.f6472a, getActivity(), Integer.valueOf(i), m6125f()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public Preference m6121a(CharSequence charSequence) {
        if (this.f6472a == null) {
            return null;
        }
        return this.f6472a.findPreference(charSequence);
    }
}
