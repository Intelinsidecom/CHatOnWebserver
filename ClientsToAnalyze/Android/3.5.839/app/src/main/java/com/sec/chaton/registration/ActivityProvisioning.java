package com.sec.chaton.registration;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class ActivityProvisioning extends BaseSinglePaneActivity {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        return new JoinWorkerFragment();
    }

    public class SplashFragment extends Fragment {

        /* renamed from: a */
        private Bundle f11547a;

        /* renamed from: b */
        private JoinWorkerFragment f11548b;

        /* renamed from: c */
        private View f11549c;

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.f11547a = getArguments();
        }

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.f11549c = layoutInflater.inflate(R.layout.layout_settings_starting, viewGroup, false);
            m12772a(getResources().getConfiguration());
            return this.f11549c;
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            this.f11548b = (JoinWorkerFragment) getFragmentManager().mo182a("join");
            if (this.f11548b == null) {
                this.f11548b = new JoinWorkerFragment();
                this.f11548b.setArguments(this.f11547a);
                this.f11548b.setTargetFragment(this, 0);
                getFragmentManager().mo183a().mo98a(this.f11548b, "join").mo99b();
            }
        }

        @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            C4904y.m18639b("onConfigurationChanged", getClass().getSimpleName());
        }

        /* renamed from: a */
        void m12772a(Configuration configuration) {
        }
    }

    public class JoinWorkerFragment extends Fragment {

        /* renamed from: a */
        public Handler f11545a = new HandlerC3293g(this);

        /* renamed from: b */
        private C2128i f11546b;

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setRetainInstance(true);
            this.f11546b = new C2128i(this.f11545a);
            this.f11546b.m9497a("append");
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        C4904y.m18639b("BKP.............", null);
    }
}
