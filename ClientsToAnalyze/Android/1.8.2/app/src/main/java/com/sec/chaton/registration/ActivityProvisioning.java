package com.sec.chaton.registration;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.p015d.C0629as;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.util.C1786r;

/* loaded from: classes.dex */
public class ActivityProvisioning extends BaseSinglePaneActivity {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo649a() {
        return new SplashFragment();
    }

    public class SplashFragment extends Fragment {

        /* renamed from: a */
        private Bundle f4211a;

        /* renamed from: b */
        private JoinWorkerFragment f4212b;

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.f4211a = getArguments();
        }

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewInflate = layoutInflater.inflate(R.layout.layout_settings_starting, viewGroup, false);
            ((ImageSwitcher) viewInflate.findViewById(R.id.switcher)).setImageResource(R.drawable.intro_icon_on);
            viewInflate.findViewById(R.id.samsung_ltd).setVisibility(0);
            viewInflate.findViewById(R.id.logo_differerent_for_canada).setVisibility(4);
            return viewInflate;
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            this.f4212b = (JoinWorkerFragment) getFragmentManager().findFragmentByTag("join");
            if (this.f4212b == null) {
                this.f4212b = new JoinWorkerFragment();
                this.f4212b.setArguments(this.f4211a);
                this.f4212b.setTargetFragment(this, 0);
                getFragmentManager().beginTransaction().add(this.f4212b, "join").commit();
            }
        }
    }

    public class JoinWorkerFragment extends Fragment {

        /* renamed from: a */
        public Handler f4206a = new HandlerC1210w(this);

        /* renamed from: b */
        private C0633e f4207b;

        /* renamed from: c */
        private C0629as f4208c;

        /* renamed from: d */
        private String f4209d;

        /* renamed from: e */
        private String f4210e;

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setRetainInstance(true);
            if (getArguments() != null) {
                Bundle arguments = getArguments();
                if (arguments.containsKey("REG_PNO")) {
                    this.f4209d = arguments.getString("REG_PNO");
                }
                if (arguments.containsKey("REG_NAME")) {
                    this.f4210e = arguments.getString("REG_NAME");
                }
            }
            this.f4207b = new C0633e(this.f4206a);
            this.f4208c = new C0629as(this.f4206a);
            this.f4208c.m2832a();
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        C1786r.m6061b("BKP.............", null);
    }
}
