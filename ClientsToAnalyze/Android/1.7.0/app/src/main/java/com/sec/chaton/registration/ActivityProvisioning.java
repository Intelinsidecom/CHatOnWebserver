package com.sec.chaton.registration;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.p013a.C0202ao;
import com.sec.chaton.p013a.C0218q;
import com.sec.chaton.util.C1341p;

/* loaded from: classes.dex */
public class ActivityProvisioning extends BaseSinglePaneActivity {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo664a() {
        return new SplashFragment();
    }

    public class SplashFragment extends Fragment {

        /* renamed from: a */
        private Bundle f3186a;

        /* renamed from: b */
        private JoinWorkerFragment f3187b;

        /* renamed from: c */
        private View f3188c;

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.f3186a = getArguments();
        }

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.f3188c = layoutInflater.inflate(R.layout.layout_settings_starting, viewGroup, false);
            m3685a(getResources().getConfiguration());
            this.f3188c.findViewById(R.id.logo_differerent_for_canada).setVisibility(8);
            return this.f3188c;
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            this.f3187b = (JoinWorkerFragment) getFragmentManager().findFragmentByTag("join");
            if (this.f3187b == null) {
                this.f3187b = new JoinWorkerFragment();
                this.f3187b.setArguments(this.f3186a);
                this.f3187b.setTargetFragment(this, 0);
                getFragmentManager().beginTransaction().add(this.f3187b, "join").commit();
            }
        }

        @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            C1341p.m4658b("onConfigurationChanged", getClass().getSimpleName());
            m3685a(configuration);
        }

        /* renamed from: a */
        void m3685a(Configuration configuration) {
            C1341p.m4658b("checkScreenMode : " + configuration.orientation, getClass().getSimpleName());
            ImageView imageView = (ImageView) this.f3188c.findViewById(R.id.logo_off);
            if (imageView != null) {
                if (configuration.orientation == 2) {
                    this.f3188c.findViewById(R.id.linear1).setVisibility(8);
                    this.f3188c.findViewById(R.id.linear2).setVisibility(8);
                    this.f3188c.findViewById(R.id.linear3).setVisibility(8);
                    this.f3188c.findViewById(R.id.linear4).setVisibility(8);
                    imageView.setImageResource(R.drawable.intro_icon_on_h);
                    return;
                }
                this.f3188c.findViewById(R.id.linear1).setVisibility(0);
                this.f3188c.findViewById(R.id.linear2).setVisibility(0);
                this.f3188c.findViewById(R.id.linear3).setVisibility(0);
                this.f3188c.findViewById(R.id.linear4).setVisibility(0);
                imageView.setImageResource(R.drawable.intro_icon_on);
            }
        }
    }

    public class JoinWorkerFragment extends Fragment {

        /* renamed from: a */
        public Handler f3181a = new HandlerC0975g(this);

        /* renamed from: b */
        private C0202ao f3182b;

        /* renamed from: c */
        private C0218q f3183c;

        /* renamed from: d */
        private String f3184d;

        /* renamed from: e */
        private String f3185e;

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setRetainInstance(true);
            if (getArguments() != null) {
                Bundle arguments = getArguments();
                if (arguments.containsKey("REG_PNO")) {
                    this.f3184d = arguments.getString("REG_PNO");
                }
                if (arguments.containsKey("REG_NAME")) {
                    this.f3185e = arguments.getString("REG_NAME");
                }
            }
            this.f3182b = new C0202ao(this.f3181a);
            this.f3183c = new C0218q(this.f3181a);
            this.f3183c.m799a();
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        C1341p.m4658b("BKP.............", null);
    }
}
