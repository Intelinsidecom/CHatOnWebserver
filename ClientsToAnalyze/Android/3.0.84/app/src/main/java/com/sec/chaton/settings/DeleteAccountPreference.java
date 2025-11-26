package com.sec.chaton.settings;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.preference.Preference;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;
import com.coolots.sso.p006a.C0045a;
import com.coolots.sso.p006a.InterfaceC0047c;
import com.sec.chaton.R;
import com.sec.chaton.p025d.AbstractC1144a;
import com.sec.chaton.p025d.C1302ao;
import com.sec.chaton.p025d.C1303ap;
import com.sec.chaton.p025d.p026a.C1156ak;
import com.sec.chaton.plugin.C1954g;
import com.sec.chaton.plugin.EnumC1955h;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.C3263j;
import com.sec.common.p063a.AbstractC3271a;

@Deprecated
/* loaded from: classes.dex */
public class DeleteAccountPreference extends Preference {

    /* renamed from: a */
    private static FragmentManager f9102a;

    /* renamed from: b */
    private static final String f9103b = DeleteAccountPreference.class.getSimpleName();

    @Override // android.preference.Preference
    public void onBindView(View view) {
        super.onBindView(view);
        ((Button) view.findViewById(R.id.btn_delete_account)).setOnClickListener(new ViewOnClickListenerC2494da(this));
    }

    public class DeleteAMSAlertDialog extends DialogFragment {
        @Override // android.support.v4.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            FragmentActivity activity = getActivity();
            AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(activity);
            abstractC3271aM11494a.mo11495a(R.string.deregister_device).mo11509b(activity.getString(R.string.multideivce_delete_account2)).mo11511b(true).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2496dc(this)).mo11507b(R.string.setting_delete_account_cancel, new DialogInterfaceOnClickListenerC2495db(this));
            return abstractC3271aM11494a.mo11505a().mo11517a();
        }
    }

    public class ErrorDialogFragment extends DialogFragment {

        /* renamed from: a */
        private int f9112a;

        /* renamed from: b */
        private int f9113b;

        /* renamed from: c */
        private int f9114c;

        /* renamed from: a */
        public static ErrorDialogFragment m9080a(int i, int i2, int i3) {
            ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("title", i);
            bundle.putInt("message", i2);
            bundle.putInt("okButton", i3);
            errorDialogFragment.setArguments(bundle);
            return errorDialogFragment;
        }

        @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.f9113b = getArguments().getInt("message");
            this.f9114c = getArguments().getInt("okButton");
            this.f9112a = getArguments().getInt("title");
        }

        @Override // android.support.v4.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(getActivity());
            abstractC3271aM11494a.mo11495a(this.f9112a).mo11506b(this.f9113b).mo11515d(this.f9114c, null).mo11505a();
            return abstractC3271aM11494a.mo11505a().mo11517a();
        }
    }

    public class ProgressDialogFragment extends DialogFragment {
        @Override // android.support.v4.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return new C3263j(getActivity()).m11487a(R.string.settings_deleting_account);
        }
    }

    public class DeleteWorkFragment extends Fragment implements InterfaceC0047c {

        /* renamed from: a */
        Handler f9104a = new HandlerC2497dd(this);

        /* renamed from: b */
        public Handler f9105b = new HandlerC2498de(this);

        /* renamed from: c */
        private AbstractC1144a<?> f9106c;

        /* renamed from: d */
        private C1303ap f9107d;

        /* renamed from: e */
        private ProgressDialogFragment f9108e;

        /* renamed from: f */
        private C1156ak f9109f;

        /* renamed from: g */
        private C0045a f9110g;

        /* renamed from: h */
        private Context f9111h;

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setRetainInstance(true);
            this.f9108e = new ProgressDialogFragment();
            this.f9108e.setCancelable(false);
            this.f9107d = new C1303ap(this.f9105b);
            this.f9106c = C1302ao.m5594a();
            this.f9111h = getActivity();
            if (C1954g.m7916a().m7918a(this.f9111h, EnumC1955h.ChatONV)) {
                this.f9110g = new C0045a();
                if (this.f9110g.m55d(this.f9111h)) {
                    this.f9110g.m51a(this.f9111h, this);
                    C3250y.m11450b("onCreate:mChatonV.setListener()", DeleteAccountPreference.class.getSimpleName());
                }
            }
            if (C1954g.m7916a().m7918a(this.f9111h, EnumC1955h.ChatONV) && this.f9110g.m55d(this.f9111h)) {
                this.f9110g.m54c(this.f9111h);
                C3250y.m11450b("onCreate:mChatonV.removeAccountInDevice()", DeleteAccountPreference.class.getSimpleName());
            } else {
                this.f9106c.mo5481b(this.f9104a);
            }
            this.f9108e.show(DeleteAccountPreference.f9102a, "progress_dialog");
        }

        @Override // android.support.v4.app.Fragment
        public void onDestroy() {
            super.onDestroy();
            if (C1954g.m7916a().m7918a(this.f9111h, EnumC1955h.ChatONV)) {
                this.f9110g.m51a(this.f9111h, (InterfaceC0047c) null);
                C3250y.m11450b("onCreate:mChatonV.setListener(null)", DeleteAccountPreference.class.getSimpleName());
            }
        }

        @Override // com.coolots.sso.p006a.InterfaceC0047c
        public void onReceiveCreateAccount(boolean z, String str) {
        }

        @Override // com.coolots.sso.p006a.InterfaceC0047c
        public void onReceiveRemoveAccount(boolean z) {
            C3250y.m11450b("onReceiveRemoveAccount" + z, DeleteAccountPreference.class.getSimpleName());
            if (z) {
                if (this.f9106c != null) {
                    this.f9106c.mo5481b(this.f9104a);
                }
            } else {
                this.f9109f = null;
                this.f9105b.sendEmptyMessage(202);
            }
        }
    }
}
