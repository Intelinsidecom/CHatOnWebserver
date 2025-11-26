package com.sec.chaton.settings2;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.sso.p006a.C0045a;
import com.coolots.sso.p006a.InterfaceC0047c;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.AbstractC1144a;
import com.sec.chaton.p025d.C1302ao;
import com.sec.chaton.p025d.C1303ap;
import com.sec.chaton.p025d.p026a.C1156ak;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.plugin.C1954g;
import com.sec.chaton.plugin.EnumC1955h;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;
import com.sec.widget.C3641ai;

@TargetApi(11)
/* loaded from: classes.dex */
public class PrefFragmentDeregister extends Fragment implements InterfaceC0047c {
    private static final String TAG = SettingActivity.class.getSimpleName();
    private CheckBox mAgreeCheckBox;
    private C0045a mChatONV;
    private C1156ak mDeRegistrationTask;
    private TextView mDeregisterTextView;
    private InterfaceC3274d mErrorDialog;
    private Button mOkButton;
    private AbstractC1144a<?> pushControl;
    private C1303ap regControl;
    private ProgressDialog progressBar = null;
    Handler mPushHandler = new Handler() { // from class: com.sec.chaton.settings2.PrefFragmentDeregister.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (PrefFragmentDeregister.this.getActivity() != null) {
                if (((Boolean) message.obj).booleanValue()) {
                    C3250y.m11450b("Push deregistration is success. execute chaton deregistration.", PrefFragmentDeregister.TAG);
                    if (!C3223ck.m11330d()) {
                        PrefFragmentDeregister.this.dissmissProgress();
                        Toast.makeText(CommonApplication.m11493l(), R.string.popup_not_enough_memory, 0).show();
                        return;
                    } else {
                        PrefFragmentDeregister.this.mDeRegistrationTask = PrefFragmentDeregister.this.regControl.m5596a();
                        return;
                    }
                }
                C3250y.m11442a("Push deregistration is fail.", PrefFragmentDeregister.TAG);
                PrefFragmentDeregister.this.dissmissProgress();
                PrefFragmentDeregister.this.showErrorDialog(null);
            }
        }
    };
    public Handler mUiHandler = new Handler() { // from class: com.sec.chaton.settings2.PrefFragmentDeregister.4
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (PrefFragmentDeregister.this.getActivity() != null) {
                C0267d c0267d = (C0267d) message.obj;
                switch (message.what) {
                    case 202:
                        PrefFragmentDeregister.this.dissmissProgress();
                        if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR || PrefFragmentDeregister.this.mDeRegistrationTask == null || !PrefFragmentDeregister.this.mDeRegistrationTask.m5508i()) {
                            PrefFragmentDeregister.this.showErrorDialog(c0267d.m1356g());
                            C3250y.m11442a("ChatON deregistration is fail.", PrefFragmentDeregister.TAG);
                            break;
                        } else {
                            C3250y.m11450b("ChatON deregistration is success.", PrefFragmentDeregister.TAG);
                            Intent intent = new Intent();
                            intent.setAction("com.sec.chaton.action.USER_DEREGISTRATION");
                            CommonApplication.m11493l().sendBroadcast(intent);
                            C3641ai.m13211a(PrefFragmentDeregister.this.getActivity(), PrefFragmentDeregister.this.getResources().getString(R.string.toast_account_deleted2), 0).show();
                            GlobalApplication.m6449a(PrefFragmentDeregister.this.getActivity());
                            break;
                        }
                }
            }
        }
    };

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.regControl = new C1303ap(this.mUiHandler);
        this.pushControl = C1302ao.m5594a();
        this.mErrorDialog = null;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_deregister_device, viewGroup, false);
        LinearLayout linearLayout = (LinearLayout) viewGroup.getParent();
        if (Build.VERSION.SDK_INT >= 16) {
            linearLayout.setBackground(null);
        } else {
            linearLayout.setBackgroundDrawable(null);
        }
        linearLayout.setBackgroundColor(0);
        linearLayout.setPadding(0, 0, 0, 0);
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, 0, 0, 0);
            if (Build.VERSION.SDK_INT >= 17) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart(0);
                ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(0);
            }
        }
        View viewFindViewById = viewInflate.findViewById(R.id.breadcrumb);
        TextView textView = (TextView) viewFindViewById.findViewById(R.id.breadcrumb1);
        textView.setText(R.string.deregister_device);
        textView.setTextColor(getActivity().getResources().getColor(R.color.buddy_list_item_status_changed));
        ((TextView) viewFindViewById.findViewById(R.id.breadcrumb2)).setVisibility(8);
        ((ImageView) viewFindViewById.findViewById(R.id.separator1)).setVisibility(8);
        ((ImageView) viewFindViewById.findViewById(R.id.separator2)).setVisibility(8);
        this.mDeregisterTextView = (TextView) viewInflate.findViewById(R.id.deregister_textview);
        this.mAgreeCheckBox = (CheckBox) viewInflate.findViewById(R.id.agree_checkbox);
        this.mOkButton = (Button) viewInflate.findViewById(R.id.ok_button);
        if (C3214cb.m11256a(getActivity()) && new C0045a().m55d(getActivity())) {
            this.mDeregisterTextView.setText(getActivity().getResources().getString(R.string.multideivce_delete_account_chatonv));
        }
        this.mAgreeCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.sec.chaton.settings2.PrefFragmentDeregister.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                PrefFragmentDeregister.this.checkAcceptStatus();
            }
        });
        this.mOkButton.setOnClickListener(new View.OnClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentDeregister.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PrefFragmentDeregister.this.progressBar = ProgressDialogC3265l.m11489a(PrefFragmentDeregister.this.getActivity(), null, PrefFragmentDeregister.this.getResources().getString(R.string.deregister_device));
                PrefFragmentDeregister.this.progressBar.setCancelable(false);
                if (C3214cb.m11256a(PrefFragmentDeregister.this.getActivity())) {
                    PrefFragmentDeregister.this.mChatONV = new C0045a();
                    if (PrefFragmentDeregister.this.mChatONV.m55d(PrefFragmentDeregister.this.getActivity())) {
                        PrefFragmentDeregister.this.mChatONV.m51a(PrefFragmentDeregister.this.getActivity(), PrefFragmentDeregister.this);
                        C3214cb.m11260b(PrefFragmentDeregister.this.getActivity(), PrefFragmentDeregister.this.mChatONV);
                        return;
                    } else {
                        if (C3250y.f11734b) {
                            C3250y.m11450b("ChatONV was NOT registered", PrefFragmentDeregister.TAG);
                        }
                        PrefFragmentDeregister.this.pushControl.mo5481b(PrefFragmentDeregister.this.mPushHandler);
                        return;
                    }
                }
                if (C3250y.f11734b) {
                    C3250y.m11450b("ChatONV was NOT installed", PrefFragmentDeregister.TAG);
                }
                PrefFragmentDeregister.this.pushControl.mo5481b(PrefFragmentDeregister.this.mPushHandler);
            }
        });
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAcceptStatus() {
        if (this.mAgreeCheckBox.isChecked()) {
            this.mOkButton.setEnabled(true);
        } else {
            this.mOkButton.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dissmissProgress() {
        if (this.progressBar != null && this.progressBar.isShowing()) {
            this.progressBar.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorDialog(String str) {
        if (C3250y.f11734b) {
            C3250y.m11450b("showErrorDialog : " + str, TAG);
        }
        closeDialog();
        this.mErrorDialog = AbstractC3271a.m11494a(getActivity()).mo11495a(R.string.deregister_device).mo11509b(C3171am.m11046a(getResources().getString(R.string.toast_network_unable), getResources().getString(R.string.toast_error), str)).mo11511b(true).mo11515d(R.string.dialog_ok, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentDeregister.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).mo11512b();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (C1954g.m7916a().m7918a(getActivity(), EnumC1955h.ChatONV) && this.mChatONV != null) {
            this.mChatONV.m51a(getActivity(), (InterfaceC0047c) null);
            C3250y.m11450b("onDestroy:mChatonV.setListener(null)", TAG);
        }
        closeDialog();
    }

    private void closeDialog() {
        if (this.mErrorDialog != null && this.mErrorDialog.isShowing()) {
            this.mErrorDialog.dismiss();
        }
    }

    @Override // com.coolots.sso.p006a.InterfaceC0047c
    public void onReceiveCreateAccount(boolean z, String str) {
    }

    @Override // com.coolots.sso.p006a.InterfaceC0047c
    public void onReceiveRemoveAccount(boolean z) {
        if (C3250y.f11734b) {
            C3250y.m11450b("onReceiveRemoveAccount : " + z, TAG);
        }
        if (z) {
            this.pushControl.mo5481b(this.mPushHandler);
        } else {
            dissmissProgress();
            showErrorDialog(null);
        }
    }
}
