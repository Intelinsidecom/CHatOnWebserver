package com.sec.chaton.registration;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.C0062R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.control.ContactControl;
import com.sec.chaton.control.RegistrationControl;
import com.sec.chaton.control.VersionControl;
import com.sec.chaton.util.ChatONLogWriter;

/* loaded from: classes.dex */
public class ActivityProvisioning extends BaseSinglePaneActivity {

    public class JoinWorkerFragment extends Fragment {

        /* renamed from: a */
        Handler f2834a = new HandlerC0441q(this);

        /* renamed from: b */
        public Handler f2835b = new HandlerC0442r(this);

        /* renamed from: c */
        private RegistrationControl f2836c;

        /* renamed from: d */
        private ContactControl f2837d;

        /* renamed from: e */
        private VersionControl f2838e;

        /* renamed from: f */
        private String f2839f;

        /* renamed from: g */
        private String f2840g;

        @Override // android.support.v4.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
        }

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setRetainInstance(true);
            if (getArguments() != null) {
                Bundle arguments = getArguments();
                if (arguments.containsKey("REG_PNO")) {
                    this.f2839f = arguments.getString("REG_PNO");
                }
                if (arguments.containsKey("REG_NAME")) {
                    this.f2840g = arguments.getString("REG_NAME");
                }
            }
            this.f2837d = new ContactControl(this.f2835b);
            this.f2838e = new VersionControl(this.f2835b);
            this.f2838e.m2094a();
        }
    }

    public class SplashFragment extends Fragment {

        /* renamed from: a */
        private Bundle f2841a;

        /* renamed from: b */
        private JoinWorkerFragment f2842b;

        /* renamed from: c */
        private ImageView f2843c;

        /* renamed from: d */
        private TextView f2844d;

        @Override // android.support.v4.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            this.f2842b = (JoinWorkerFragment) getFragmentManager().mo5a("join");
            if (this.f2842b == null) {
                this.f2842b = new JoinWorkerFragment();
                this.f2842b.setArguments(this.f2841a);
                this.f2842b.setTargetFragment(this, 0);
                getFragmentManager().mo6a().mo14a(this.f2842b, "join").mo10a();
            }
        }

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.f2841a = getArguments();
        }

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewInflate = layoutInflater.inflate(C0062R.layout.layout_settings_starting, viewGroup, false);
            this.f2843c = (ImageView) viewInflate.findViewById(C0062R.id.logo);
            this.f2844d = (TextView) viewInflate.findViewById(C0062R.id.samsung_ltd);
            this.f2843c.setVisibility(4);
            this.f2844d.setVisibility(4);
            return viewInflate;
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        ChatONLogWriter.m3506b("BKP.............", null);
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    protected Fragment onCreatePane() {
        return new SplashFragment();
    }
}
