package com.sec.chaton.trunk;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.util.C4902w;
import com.sec.chaton.widget.AdaptableEditText;
import com.sec.chaton.widget.C4923p;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;

/* loaded from: classes.dex */
public class TrunkCommentView extends ITrunkCommentView {

    /* renamed from: a */
    private static final String f16441a = TrunkCommentView.class.getSimpleName();

    /* renamed from: b */
    private Activity f16442b;

    /* renamed from: c */
    private InterfaceC4585aj f16443c;

    /* renamed from: d */
    private InputMethodManager f16444d;

    /* renamed from: e */
    private AdaptableEditText f16445e;

    /* renamed from: f */
    private ImageButton f16446f;

    /* renamed from: g */
    private Dialog f16447g;

    /* renamed from: h */
    private Dialog f16448h;

    /* renamed from: i */
    private Dialog f16449i;

    /* renamed from: j */
    private boolean f16450j;

    /* renamed from: k */
    private boolean f16451k;

    /* renamed from: l */
    private Toast f16452l;

    /* renamed from: m */
    private C4691y f16453m;

    /* renamed from: n */
    private InterfaceC4671e f16454n;

    /* renamed from: o */
    private View f16455o;

    /* renamed from: p */
    private String f16456p;

    /* renamed from: q */
    private Handler f16457q = new HandlerC4577ab(this);

    @Override // com.sec.chaton.trunk.ITrunkCommentView
    /* renamed from: a */
    public void mo17264a(InterfaceC4671e interfaceC4671e) {
        this.f16454n = interfaceC4671e;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f16442b = activity;
        try {
            this.f16443c = (InterfaceC4585aj) this.f16442b;
        } catch (ClassCastException e) {
            throw new ClassCastException(String.format("%s must implement ITrunkCommentViewListener.", activity.toString()));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f16442b = null;
        this.f16443c = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f16444d = (InputMethodManager) this.f16442b.getSystemService("input_method");
        this.f16452l = C5179v.m19811a(CommonApplication.m18732r(), (CharSequence) null, 0);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f16455o = layoutInflater.inflate(R.layout.layout_common_write, viewGroup, false);
        ((ImageButton) this.f16455o.findViewById(R.id.button1)).setVisibility(8);
        this.f16445e = (AdaptableEditText) this.f16455o.findViewById(R.id.edit_text1);
        this.f16445e.setMaxLines(5);
        this.f16445e.setHint(R.string.trunk_item_write_a_comment);
        this.f16445e.setFilters(new InputFilter[]{new C4902w(this.f16442b, 140)});
        this.f16445e.setOnClickListener(new ViewOnClickListenerC4578ac(this));
        this.f16445e.addTextChangedListener(new C4579ad(this));
        this.f16445e.setOnEditorActionListener(new C4580ae(this));
        if (this.f16455o.findViewById(R.id.button2) != null) {
            this.f16446f = (ImageButton) this.f16455o.findViewById(R.id.button2);
            this.f16446f.setEnabled(false);
            this.f16446f.setBackgroundResource(R.drawable.button6);
            this.f16446f.setContentDescription(getString(R.string.buddy_group_edit_menubar_add));
            this.f16446f.setImageResource(R.drawable.chat_btn_icon_send);
            this.f16446f.setOnClickListener(new ViewOnClickListenerC4581af(this));
        }
        Bundle arguments = getArguments();
        String string = arguments.getString("sessionId");
        String string2 = arguments.getString("itemId");
        this.f16451k = arguments.getBoolean("isvalid");
        this.f16456p = string2;
        this.f16453m = new C4691y(this, this.f16457q, string, string2);
        this.f16453m.m17508a();
        if (!this.f16451k) {
            this.f16455o.setVisibility(8);
        }
        if (GlobalApplication.m10286e()) {
            this.f16442b.getWindow().setSoftInputMode(4);
        }
        return this.f16455o;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f16453m.m17511d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m17278b() {
        if (this.f16447g == null) {
            this.f16447g = new C4923p(this.f16442b).m18724a(R.string.setting_webview_please_wait);
            this.f16447g.setCancelable(false);
        }
        if (this.f16447g != null) {
            this.f16447g.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17274a(C0778b c0778b) throws Resources.NotFoundException {
        String string = getResources().getString(R.string.setting_profile_update_status_failed);
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            this.f16452l.setText(R.string.popup_no_network_connection);
            this.f16452l.setDuration(0);
            this.f16452l.show();
        } else {
            if (c0778b != null && c0778b.m3111f() == 89405) {
                if (!this.f16450j) {
                    C5179v.m19810a(this.f16442b, R.string.trunk_comment_already_exist, 1).show();
                    if (this.f16443c != null) {
                        this.f16443c.mo17305c_(true);
                    }
                    this.f16450j = false;
                    return;
                }
                return;
            }
            this.f16448h = AbstractC4932a.m18733a(this.f16442b).mo18740a(string).mo18755c(getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC4583ah(this)).mo18741a(getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC4582ag(this)).mo18745a().mo18758a();
            this.f16450j = true;
            if (this.f16448h != null) {
                this.f16448h.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m17281c() {
        if (this.f16449i == null) {
            this.f16449i = AbstractC4932a.m18733a(this.f16442b).mo18734a(R.string.chat_alert).mo18746b(R.string.trunk_content_deleted).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC4584ai(this)).mo18745a().mo18758a();
            this.f16449i.setCancelable(false);
        }
        if (this.f16449i != null) {
            this.f16449i.show();
        }
    }
}
