package com.sec.chaton.trunk;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.widget.C3263j;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;

/* loaded from: classes.dex */
public class TrunkCommentView extends ITrunkCommentView {

    /* renamed from: a */
    private static final String f10502a = TrunkCommentView.class.getSimpleName();

    /* renamed from: b */
    private Activity f10503b;

    /* renamed from: c */
    private InterfaceC2968ai f10504c;

    /* renamed from: d */
    private InputMethodManager f10505d;

    /* renamed from: e */
    private EditText f10506e;

    /* renamed from: f */
    private ImageButton f10507f;

    /* renamed from: g */
    private Dialog f10508g;

    /* renamed from: h */
    private Dialog f10509h;

    /* renamed from: i */
    private Dialog f10510i;

    /* renamed from: j */
    private boolean f10511j;

    /* renamed from: k */
    private boolean f10512k;

    /* renamed from: l */
    private Toast f10513l;

    /* renamed from: m */
    private C3071y f10514m;

    /* renamed from: n */
    private InterfaceC3051e f10515n;

    /* renamed from: o */
    private View f10516o;

    /* renamed from: p */
    private Handler f10517p = new HandlerC2961ab(this);

    @Override // com.sec.chaton.trunk.ITrunkCommentView
    /* renamed from: a */
    public void mo10176a(InterfaceC3051e interfaceC3051e) {
        this.f10515n = interfaceC3051e;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f10503b = activity;
        try {
            this.f10504c = (InterfaceC2968ai) this.f10503b;
        } catch (ClassCastException e) {
            throw new ClassCastException(String.format("%s must implement ITrunkCommentViewListener.", activity.toString()));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f10503b = null;
        this.f10504c = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10505d = (InputMethodManager) this.f10503b.getSystemService("input_method");
        this.f10513l = C3641ai.m13211a(CommonApplication.m11493l(), (CharSequence) null, 0);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f10516o = layoutInflater.inflate(R.layout.layout_trunk_comment, viewGroup, false);
        this.f10506e = (EditText) this.f10516o.findViewById(R.id.trunkCommentEdit);
        this.f10506e.setOnClickListener(new ViewOnClickListenerC2962ac(this));
        this.f10506e.addTextChangedListener(new C2963ad(this));
        if (this.f10516o.findViewById(R.id.trunkCommentSendBtn) != null) {
            this.f10507f = (ImageButton) this.f10516o.findViewById(R.id.trunkCommentSendBtn);
            this.f10507f.setEnabled(false);
            this.f10507f.setOnClickListener(new ViewOnClickListenerC2964ae(this));
        }
        Bundle arguments = getArguments();
        String string = arguments.getString("sessionId");
        String string2 = arguments.getString("itemId");
        this.f10512k = arguments.getBoolean("isvalid");
        this.f10514m = new C3071y(this, this.f10517p, string, string2);
        this.f10514m.m10411a();
        if (!this.f10512k) {
            this.f10516o.setVisibility(8);
        }
        return this.f10516o;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f10514m.m10414d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m10188b() {
        if (this.f10508g == null) {
            this.f10508g = new C3263j(this.f10503b).m11487a(R.string.setting_webview_please_wait);
            this.f10508g.setCancelable(false);
        }
        if (this.f10508g != null) {
            this.f10508g.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10184a(C0267d c0267d) throws Resources.NotFoundException {
        String string = getResources().getString(R.string.setting_profile_update_status_failed);
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            this.f10513l.setText(R.string.popup_no_network_connection);
            this.f10513l.setDuration(0);
            this.f10513l.show();
        } else {
            if (c0267d != null && c0267d.m1355f() == 89405) {
                if (!this.f10511j) {
                    C3641ai.m13210a(this.f10503b, R.string.trunk_comment_already_exist, 1).show();
                    if (this.f10504c != null) {
                        this.f10504c.mo10201a();
                    }
                    this.f10511j = false;
                    return;
                }
                return;
            }
            this.f10509h = AbstractC3271a.m11494a(this.f10503b).mo11500a(getResources().getString(R.string.toast_error)).mo11509b(string).mo11510b(getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC2966ag(this)).mo11501a(getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC2965af(this)).mo11505a().mo11517a();
            this.f10511j = true;
            if (this.f10509h != null) {
                this.f10509h.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m10191c() {
        if (this.f10510i == null) {
            this.f10510i = AbstractC3271a.m11494a(this.f10503b).mo11495a(R.string.chat_alert).mo11506b(R.string.trunk_content_deleted).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2967ah(this)).mo11505a().mo11517a();
            this.f10510i.setCancelable(false);
        }
        if (this.f10510i != null) {
            this.f10510i.show();
        }
    }
}
