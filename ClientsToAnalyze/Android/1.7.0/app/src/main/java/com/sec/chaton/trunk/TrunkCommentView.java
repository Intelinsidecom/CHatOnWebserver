package com.sec.chaton.trunk;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import com.sec.chaton.R;
import com.sec.chaton.widget.C1356c;
import com.sec.chaton.widget.ProgressDialogC1354a;
import com.sec.widget.AlertDialogBuilderC1625m;

/* loaded from: classes.dex */
public class TrunkCommentView extends ITrunkCommentView {

    /* renamed from: a */
    private static final String f3753a = TrunkCommentView.class.getSimpleName();

    /* renamed from: b */
    private Activity f3754b;

    /* renamed from: c */
    private InterfaceC1107ae f3755c;

    /* renamed from: d */
    private InputMethodManager f3756d;

    /* renamed from: e */
    private EditText f3757e;

    /* renamed from: f */
    private Button f3758f;

    /* renamed from: g */
    private Button f3759g;

    /* renamed from: h */
    private Dialog f3760h;

    /* renamed from: i */
    private Dialog f3761i;

    /* renamed from: j */
    private Dialog f3762j;

    /* renamed from: k */
    private C1149bm f3763k;

    /* renamed from: l */
    private InterfaceC1146bj f3764l;

    /* renamed from: m */
    private Handler f3765m = new HandlerC1127ay(this);

    @Override // com.sec.chaton.trunk.ITrunkCommentView
    /* renamed from: a */
    public void mo3966a(InterfaceC1146bj interfaceC1146bj) {
        this.f3764l = interfaceC1146bj;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3754b = activity;
        try {
            this.f3755c = (InterfaceC1107ae) this.f3754b;
        } catch (ClassCastException e) {
            throw new ClassCastException(String.format("%s must implement ITrunkCommentViewListener.", activity.toString()));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f3754b = null;
        this.f3755c = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3756d = (InputMethodManager) this.f3754b.getSystemService("input_method");
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(R.layout.layout_trunk_comment, viewGroup, false);
        this.f3757e = (EditText) viewInflate.findViewById(R.id.trunkCommentEdit);
        this.f3757e.addTextChangedListener(new C1128az(this));
        if (viewInflate.findViewById(R.id.trunkCommentSendBtn) != null) {
            this.f3758f = (Button) viewInflate.findViewById(R.id.trunkCommentSendBtn);
            this.f3758f.setEnabled(false);
            this.f3758f.setOnClickListener(new ViewOnClickListenerC1137ba(this));
        }
        if (viewInflate.findViewById(R.id.trunkCommentCancelBtn) != null) {
            this.f3759g = (Button) viewInflate.findViewById(R.id.trunkCommentCancelBtn);
            this.f3759g.setOnClickListener(new ViewOnClickListenerC1138bb(this));
        }
        Bundle arguments = getArguments();
        this.f3763k = new C1149bm(this, this.f3765m, arguments.getString("sessionId"), arguments.getString("contentId"));
        this.f3763k.m4175f();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f3763k.m4178i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m3974b() {
        if (this.f3760h == null) {
            this.f3760h = (ProgressDialogC1354a) new C1356c(this.f3754b).m4728a(R.string.setting_webview_please_wait);
            this.f3760h.setCancelable(false);
        }
        if (this.f3760h != null) {
            this.f3760h.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m3976c() {
        if (this.f3761i == null) {
            this.f3761i = new AlertDialogBuilderC1625m(this.f3754b).setMessage(getResources().getString(R.string.setting_profile_update_status_failed)).setPositiveButton(getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC1140bd(this)).setNegativeButton(getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC1139bc(this)).create();
            this.f3761i.setCancelable(false);
        }
        if (this.f3761i != null) {
            this.f3761i.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m3978d() {
        if (this.f3762j == null) {
            this.f3762j = new AlertDialogBuilderC1625m(this.f3754b).setTitle((CharSequence) null).setMessage(R.string.trunk_content_deleted).setPositiveButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1141be(this)).create();
            this.f3762j.setCancelable(false);
        }
        if (this.f3762j != null) {
            this.f3762j.show();
        }
    }
}
