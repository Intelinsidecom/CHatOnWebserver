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
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.util.C3250y;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* loaded from: classes.dex */
public class ActivityProvisioning extends BaseSinglePaneActivity {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        return new JoinWorkerFragment();
    }

    public class SplashFragment extends Fragment {

        /* renamed from: a */
        private Bundle f8091a;

        /* renamed from: b */
        private JoinWorkerFragment f8092b;

        /* renamed from: c */
        private View f8093c;

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.f8091a = getArguments();
        }

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.f8093c = layoutInflater.inflate(R.layout.layout_settings_starting, viewGroup, false);
            m8390a(getResources().getConfiguration());
            return this.f8093c;
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            this.f8092b = (JoinWorkerFragment) getFragmentManager().findFragmentByTag("join");
            if (this.f8092b == null) {
                this.f8092b = new JoinWorkerFragment();
                this.f8092b.setArguments(this.f8091a);
                this.f8092b.setTargetFragment(this, 0);
                getFragmentManager().beginTransaction().add(this.f8092b, "join").commit();
            }
        }

        @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            C3250y.m11450b("onConfigurationChanged", getClass().getSimpleName());
        }

        /* renamed from: a */
        void m8390a(Configuration configuration) {
        }
    }

    public class JoinWorkerFragment extends Fragment {

        /* renamed from: a */
        public Handler f8089a = new HandlerC2291h(this);

        /* renamed from: b */
        private C1330h f8090b;

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setRetainInstance(true);
            this.f8090b = new C1330h(this.f8089a);
            this.f8090b.m5721a(RtspHeaders.Values.APPEND);
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        C3250y.m11450b("BKP.............", null);
    }
}
