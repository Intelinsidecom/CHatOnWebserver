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
import com.sec.chaton.widget.C1805i;
import com.sec.chaton.widget.ProgressDialogC1806j;
import com.sec.widget.AlertDialogBuilderC2120a;

/* loaded from: classes.dex */
public class TrunkCommentView extends ITrunkCommentView {

    /* renamed from: a */
    private static final String f5435a = TrunkCommentView.class.getSimpleName();

    /* renamed from: b */
    private Activity f5436b;

    /* renamed from: c */
    private InterfaceC1520af f5437c;

    /* renamed from: d */
    private InputMethodManager f5438d;

    /* renamed from: e */
    private EditText f5439e;

    /* renamed from: f */
    private Button f5440f;

    /* renamed from: g */
    private Button f5441g;

    /* renamed from: h */
    private Dialog f5442h;

    /* renamed from: i */
    private Dialog f5443i;

    /* renamed from: j */
    private Dialog f5444j;

    /* renamed from: k */
    private C1616v f5445k;

    /* renamed from: l */
    private InterfaceC1591e f5446l;

    /* renamed from: m */
    private Handler f5447m = new HandlerC1619y(this);

    @Override // com.sec.chaton.trunk.ITrunkCommentView
    /* renamed from: a */
    public void mo5225a(InterfaceC1591e interfaceC1591e) {
        this.f5446l = interfaceC1591e;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f5436b = activity;
        try {
            this.f5437c = (InterfaceC1520af) this.f5436b;
        } catch (ClassCastException e) {
            throw new ClassCastException(String.format("%s must implement ITrunkCommentViewListener.", activity.toString()));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f5436b = null;
        this.f5437c = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5438d = (InputMethodManager) this.f5436b.getSystemService("input_method");
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(R.layout.trunk_comment_fragment, viewGroup, false);
        this.f5440f = (Button) viewInflate.findViewById(R.id.trunkCommentSendBtn);
        this.f5440f.setEnabled(false);
        this.f5439e = (EditText) viewInflate.findViewById(R.id.trunkCommentEdit);
        this.f5439e.addTextChangedListener(new C1620z(this));
        if (viewInflate.findViewById(R.id.trunkCommentSendBtn) != null) {
            this.f5440f.setOnClickListener(new ViewOnClickListenerC1515aa(this));
        }
        if (viewInflate.findViewById(R.id.trunkCommentCancelBtn) != null) {
            this.f5441g = (Button) viewInflate.findViewById(R.id.trunkCommentCancelBtn);
            this.f5441g.setOnClickListener(new ViewOnClickListenerC1516ab(this));
        }
        Bundle arguments = getArguments();
        this.f5445k = new C1616v(this, this.f5447m, arguments.getString("sessionId"), arguments.getString("contentId"));
        this.f5445k.m5354a();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f5445k.m5357d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m5237b() {
        if (this.f5442h == null) {
            this.f5442h = (ProgressDialogC1806j) new C1805i(this.f5436b).m6139a(R.string.setting_webview_please_wait);
            this.f5442h.setCancelable(false);
        }
        if (this.f5442h != null) {
            this.f5442h.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m5239c() {
        if (this.f5443i == null) {
            this.f5443i = new AlertDialogBuilderC2120a(this.f5436b).setTitle(getResources().getString(R.string.toast_error)).setMessage(getResources().getString(R.string.setting_profile_update_status_failed)).setNegativeButton(getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC1518ad(this)).setPositiveButton(getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC1517ac(this)).create();
            this.f5443i.setCancelable(false);
        }
        if (this.f5443i != null) {
            this.f5443i.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m5241d() {
        if (this.f5444j == null) {
            this.f5444j = new AlertDialogBuilderC2120a(this.f5436b).setTitle(getResources().getString(R.string.toast_error)).setMessage(R.string.trunk_content_deleted).setPositiveButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1519ae(this)).create();
            this.f5444j.setCancelable(false);
        }
        if (this.f5444j != null) {
            this.f5444j.show();
        }
    }
}
