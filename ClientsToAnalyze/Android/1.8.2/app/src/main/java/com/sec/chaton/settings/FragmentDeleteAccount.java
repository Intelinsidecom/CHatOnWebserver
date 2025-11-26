package com.sec.chaton.settings;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p015d.AbstractC0531a;
import com.sec.chaton.p015d.C0620aj;
import com.sec.chaton.p015d.C0621ak;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.C1805i;
import com.sec.widget.AlertDialogBuilderC2120a;

/* loaded from: classes.dex */
public class FragmentDeleteAccount extends Fragment {

    /* renamed from: a */
    private static boolean f4614a = false;

    /* renamed from: b */
    private static boolean f4615b = false;

    /* renamed from: c */
    private static ProgressDialogFragment f4616c;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_delete_account, viewGroup, false);
        String string = C1789u.m6075a().getString("msisdn", "");
        ((TextView) viewInflate.findViewById(R.id.setting_chaton_account)).setText(getString(R.string.setting_delete_account, ""));
        ((TextView) viewInflate.findViewById(R.id.txt_msisdn)).setText("+" + string);
        ((Button) viewInflate.findViewById(R.id.btn_delete_account)).setOnClickListener(new ViewOnClickListenerC1269bu(this));
        return viewInflate;
    }

    public class DeleteAlertDialog extends DialogFragment {
        @Override // android.support.v4.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            AlertDialogBuilderC2120a alertDialogBuilderC2120a = new AlertDialogBuilderC2120a(getActivity());
            TextView textView = new TextView(getActivity());
            textView.setText(R.string.dialog_relrase);
            textView.setTextSize(22.0f);
            textView.setTextColor(-1);
            textView.setPadding(22, 10, 0, 10);
            alertDialogBuilderC2120a.setTitle(R.string.settings_delete).setMessage(R.string.setting_delete_account_warning).setCancelable(true).setNegativeButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1271bw(this)).setPositiveButton(R.string.setting_delete_account_cancel, new DialogInterfaceOnClickListenerC1270bv(this));
            return alertDialogBuilderC2120a.create();
        }
    }

    public class ErrorDialogFragment extends DialogFragment {

        /* renamed from: a */
        private int f4621a;

        /* renamed from: b */
        private int f4622b;

        /* renamed from: a */
        public static ErrorDialogFragment m4603a(int i, int i2) {
            ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("message", i);
            bundle.putInt("okButton", i2);
            errorDialogFragment.setArguments(bundle);
            return errorDialogFragment;
        }

        @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.f4621a = getArguments().getInt("message");
            this.f4622b = getArguments().getInt("okButton");
        }

        @Override // android.support.v4.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            AlertDialogBuilderC2120a alertDialogBuilderC2120a = new AlertDialogBuilderC2120a(getActivity());
            alertDialogBuilderC2120a.setMessage(this.f4621a).setPositiveButton(this.f4622b, (DialogInterface.OnClickListener) null).create();
            return alertDialogBuilderC2120a.create();
        }
    }

    public class ProgressDialogFragment extends DialogFragment {
        @Override // android.support.v4.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return new C1805i(getActivity()).m6139a(R.string.settings_deleting_account);
        }

        @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setRetainInstance(true);
        }
    }

    public class DeleteWorkFragment extends Fragment {

        /* renamed from: a */
        Handler f4617a = new HandlerC1272bx(this);

        /* renamed from: b */
        public Handler f4618b = new HandlerC1273by(this);

        /* renamed from: c */
        private AbstractC0531a f4619c;

        /* renamed from: d */
        private C0621ak f4620d;

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setRetainInstance(true);
            ProgressDialogFragment unused = FragmentDeleteAccount.f4616c = new ProgressDialogFragment();
            FragmentDeleteAccount.f4616c.setCancelable(false);
            this.f4620d = new C0621ak(this.f4618b);
            this.f4619c = C0620aj.m2804a();
            this.f4619c.mo2704b(this.f4617a);
            FragmentDeleteAccount.f4616c.show(getFragmentManager(), "progress_dialog");
        }

        @Override // android.support.v4.app.Fragment
        public void onResume() {
            if (FragmentDeleteAccount.f4614a && FragmentDeleteAccount.f4616c != null) {
                getFragmentManager().beginTransaction().detach(FragmentDeleteAccount.f4616c).commit();
            }
            if (FragmentDeleteAccount.f4615b) {
                ErrorDialogFragment.m4603a(R.string.toast_dereg_failed, R.string.dialog_ok).show(getFragmentManager(), "error_dialog");
            }
            boolean unused = FragmentDeleteAccount.f4614a = false;
            boolean unused2 = FragmentDeleteAccount.f4615b = false;
            super.onResume();
        }
    }
}
