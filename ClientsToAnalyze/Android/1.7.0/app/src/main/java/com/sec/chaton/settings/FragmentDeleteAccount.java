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
import com.sec.chaton.p013a.AbstractC0196ai;
import com.sec.chaton.p013a.C0192ae;
import com.sec.chaton.p013a.C0203b;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.widget.C1356c;
import com.sec.widget.AlertDialogBuilderC1625m;

/* loaded from: classes.dex */
public class FragmentDeleteAccount extends Fragment {
    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_delete_account, viewGroup, false);
        String string = C1323bs.m4575a().getString("msisdn", "");
        ((TextView) viewInflate.findViewById(R.id.setting_chaton_account)).setText(getString(R.string.setting_delete_account, ""));
        ((TextView) viewInflate.findViewById(R.id.txt_msisdn)).setText("+" + string);
        ((Button) viewInflate.findViewById(R.id.btn_delete_account)).setOnClickListener(new ViewOnClickListenerC1004ab(this));
        return viewInflate;
    }

    public class DeleteAMSAlertDialog extends DialogFragment {
        @Override // android.support.v4.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            AlertDialogBuilderC1625m alertDialogBuilderC1625m = new AlertDialogBuilderC1625m(getActivity());
            alertDialogBuilderC1625m.setTitle(R.string.setting_btn_delete_account_txt);
            alertDialogBuilderC1625m.setMessage(R.string.dialog_relrase).setCancelable(true).setPositiveButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1014al(this)).setNegativeButton(R.string.setting_delete_account_cancel, new DialogInterfaceOnClickListenerC1016an(this));
            return alertDialogBuilderC1625m.create();
        }

        @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setStyle(R.style.DataPacketDialog, 0);
        }
    }

    public class ErrorDialogFragment extends DialogFragment {

        /* renamed from: a */
        private int f3503a;

        /* renamed from: b */
        private int f3504b;

        /* renamed from: a */
        public static ErrorDialogFragment m3834a(int i, int i2) {
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
            this.f3503a = getArguments().getInt("message");
            this.f3504b = getArguments().getInt("okButton");
        }

        @Override // android.support.v4.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            AlertDialogBuilderC1625m alertDialogBuilderC1625m = new AlertDialogBuilderC1625m(getActivity());
            alertDialogBuilderC1625m.setMessage(this.f3503a).setPositiveButton(this.f3504b, (DialogInterface.OnClickListener) null).create();
            return alertDialogBuilderC1625m.create();
        }
    }

    public class ProgressDialogFragment extends DialogFragment {
        @Override // android.support.v4.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return new C1356c(getActivity()).m4728a(R.string.dialog_setting_delete_account);
        }
    }

    public class DeleteWorkFragment extends Fragment {

        /* renamed from: a */
        Handler f3498a = new HandlerC1005ac(this);

        /* renamed from: b */
        public Handler f3499b = new HandlerC1006ad(this);

        /* renamed from: c */
        private AbstractC0196ai f3500c;

        /* renamed from: d */
        private C0203b f3501d;

        /* renamed from: e */
        private ProgressDialogFragment f3502e;

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setRetainInstance(true);
            this.f3502e = new ProgressDialogFragment();
            this.f3502e.setCancelable(false);
            this.f3501d = new C0203b(this.f3499b);
            this.f3500c = C0192ae.m739a();
            this.f3500c.mo743b(this.f3498a);
            this.f3502e.show(getFragmentManager(), "progress_dialog");
        }
    }
}
