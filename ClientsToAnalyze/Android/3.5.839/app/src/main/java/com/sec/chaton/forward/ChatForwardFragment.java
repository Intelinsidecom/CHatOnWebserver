package com.sec.chaton.forward;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.AbstractC0024aj;
import android.support.v4.app.AbstractC0069w;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.sec.chaton.C1071bk;
import com.sec.chaton.EnumC1094bm;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.buddy.InterfaceC1257dr;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgbox.InterfaceC2652bq;
import com.sec.chaton.msgbox.MsgboxSelectionFragment;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.StateButton;
import com.sec.common.p123a.AbstractC4932a;

/* loaded from: classes.dex */
public class ChatForwardFragment extends Fragment implements View.OnClickListener {

    /* renamed from: c */
    MsgboxSelectionFragment f8300c;

    /* renamed from: d */
    BuddyFragment f8301d;

    /* renamed from: e */
    Bundle f8302e;

    /* renamed from: f */
    Bundle f8303f;

    /* renamed from: g */
    int f8304g;

    /* renamed from: h */
    private int f8305h;

    /* renamed from: i */
    private String f8306i;

    /* renamed from: j */
    private String f8307j;

    /* renamed from: k */
    private String f8308k;

    /* renamed from: l */
    private String f8309l;

    /* renamed from: m */
    private String f8310m;

    /* renamed from: n */
    private StateButton f8311n;

    /* renamed from: o */
    private StateButton f8312o;

    /* renamed from: p */
    private StateButton f8313p;

    /* renamed from: q */
    private View f8314q;

    /* renamed from: r */
    private InterfaceC1257dr f8315r;

    /* renamed from: s */
    private InterfaceC2652bq f8316s;

    /* renamed from: t */
    private MenuItem f8317t;

    /* renamed from: u */
    private MenuItem f8318u;

    /* renamed from: a */
    AbstractC0069w f8298a = null;

    /* renamed from: b */
    AbstractC0024aj f8299b = null;

    /* renamed from: v */
    private boolean f8319v = false;

    /* renamed from: w */
    private boolean f8320w = false;

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        C4904y.m18646e("onAttach, MemoryAddress : " + this, getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        if (this.f8304g != 1 && this.f8304g == 0) {
            menuInflater.inflate(R.menu.cancel_done_menu, menu);
            this.f8317t = menu.findItem(R.id.menu_done);
            this.f8318u = menu.findItem(R.id.menu_cancel);
            this.f8317t.setEnabled(false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_cancel) {
            getActivity().finish();
        }
        if (menuItem.getItemId() == R.id.menu_done) {
            if (this.f8304g == 1) {
                if (this.f8301d.m6605h() > 1) {
                    CharSequence[] charSequenceArr = {getString(R.string.menu_button_start_chat), getString(R.string.menu_inbox_broadcast)};
                    AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(getActivity());
                    abstractC4932aM18733a.mo18740a(GlobalApplication.m10283b().getString(R.string.chatview_menu_forward));
                    abstractC4932aM18733a.mo18744a(charSequenceArr, new DialogInterfaceOnClickListenerC2338a(this));
                    abstractC4932aM18733a.mo18745a().show();
                } else {
                    this.f8301d.m6601d();
                }
            } else if (this.f8304g == 0) {
                this.f8300c.m11145e();
            }
        }
        if (menuItem.getItemId() == 16908332) {
            getActivity().finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f8298a = getFragmentManager();
        this.f8302e = new Bundle();
        this.f8303f = new Bundle();
        setHasOptionsMenu(true);
        this.f8315r = new C2339b(this);
        this.f8316s = new C2340c(this);
        if (this.f8301d != null) {
            this.f8301d.m6585a(this.f8315r);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException {
        boolean z;
        boolean z2;
        int i;
        int i2;
        EnumC1094bm enumC1094bm;
        EnumC1094bm enumC1094bm2;
        Bundle arguments = getArguments();
        int iM10210a = EnumC2300t.UNKNOWN.m10210a();
        EnumC1094bm enumC1094bm3 = EnumC1094bm.INSIDE;
        if (arguments == null || arguments.size() <= 0) {
            z = false;
            z2 = false;
            i = iM10210a;
            i2 = -1;
            enumC1094bm = enumC1094bm3;
        } else {
            if (arguments.containsKey("content_type")) {
                this.f8305h = arguments.getInt("content_type");
                C4904y.m18644d("Forward content_type:" + this.f8305h);
            }
            if (arguments.containsKey("download_uri")) {
                this.f8306i = arguments.getString("download_uri");
                C4904y.m18644d("Forward download_uri:" + this.f8306i);
            }
            if (arguments.containsKey("sub_content")) {
                this.f8307j = arguments.getString("sub_content");
                C4904y.m18644d("Forward sub_content:" + this.f8307j);
            }
            if (arguments.containsKey("forward_sender_name")) {
                this.f8308k = arguments.getString("forward_sender_name");
                C4904y.m18644d("Forward sender name:" + this.f8308k);
            }
            if (arguments.containsKey("inboxNO")) {
                this.f8309l = arguments.getString("inboxNO");
                C4904y.m18644d("Forward mInboxNo:" + this.f8309l);
            }
            if (arguments.containsKey("chatType")) {
                iM10210a = arguments.getInt("chatType");
                C4904y.m18644d("Forward chatType:" + iM10210a);
            }
            int i3 = iM10210a;
            if (arguments.containsKey("is_forward_mode")) {
                boolean z3 = arguments.getBoolean("is_forward_mode");
                C4904y.m18644d("Forward isForward:" + z3);
                z2 = z3;
            } else {
                z2 = false;
            }
            if (arguments.containsKey(C1071bk.f3371e)) {
                enumC1094bm2 = (EnumC1094bm) arguments.get(C1071bk.f3371e);
                C4904y.m18644d("Forward intentFrom:" + enumC1094bm2);
            } else {
                enumC1094bm2 = enumC1094bm3;
            }
            if (arguments.containsKey("null")) {
                this.f8310m = arguments.getString("null");
                C4904y.m18644d("Forward BuddyName:" + this.f8310m);
            }
            if (!arguments.containsKey("ACTIVITY_PURPOSE_ARG2")) {
                i2 = -1;
            } else {
                i2 = arguments.getInt("ACTIVITY_PURPOSE_ARG2");
            }
            if (arguments.containsKey("forward_chat_message")) {
                boolean z4 = arguments.getBoolean("forward_chat_message");
                i = i3;
                z = z4;
                enumC1094bm = enumC1094bm2;
            } else {
                enumC1094bm = enumC1094bm2;
                i = i3;
                z = false;
            }
        }
        if ("android.intent.action.SEND".equals(getActivity().getIntent().getAction())) {
            ((ChatForwardActivity) getActivity()).setTitle(GlobalApplication.m10283b().getString(R.string.trunk_btn_share));
        }
        View viewInflate = layoutInflater.inflate(R.layout.layout_fragment_chatforward, viewGroup, false);
        this.f8311n = (StateButton) viewInflate.findViewById(R.id.tabForwardToBuddy);
        this.f8311n.setOnClickListener(this);
        this.f8312o = (StateButton) viewInflate.findViewById(R.id.tabForwardToChat);
        this.f8312o.setOnClickListener(this);
        this.f8314q = viewInflate.findViewById(R.id.layoutForwardContents);
        if (bundle == null) {
            this.f8302e.putInt("content_type", this.f8305h);
            this.f8302e.putString("download_uri", this.f8306i);
            this.f8302e.putString("inboxNO", this.f8309l);
            this.f8302e.putString("sub_content", this.f8307j);
            this.f8302e.putString("forward_sender_name", this.f8308k);
            this.f8302e.putInt("ACTIVITY_PURPOSE", 8);
            this.f8302e.putSerializable(C1071bk.f3371e, enumC1094bm);
            if (this.f8310m != null && this.f8310m.length() > 0) {
                this.f8302e.putString("null", this.f8310m);
            }
            if (i != EnumC2300t.UNKNOWN.m10210a()) {
                this.f8302e.putInt("chatType", i);
            }
            this.f8302e.putBoolean("is_forward_mode", z2);
            this.f8302e.putBoolean("forward_chat_message", z);
            if (i2 > 0) {
                this.f8302e.putInt("ACTIVITY_PURPOSE_ARG2", i2);
            }
            this.f8301d = new BuddyFragment();
        }
        if (bundle == null) {
            this.f8303f.putInt("content_type", this.f8305h);
            this.f8303f.putString("download_uri", this.f8306i);
            this.f8303f.putString("inboxNO", this.f8309l);
            this.f8303f.putString("sub_content", this.f8307j);
            this.f8303f.putString("forward_sender_name", this.f8308k);
            this.f8303f.putInt("mode", 3);
            this.f8303f.putSerializable(C1071bk.f3371e, enumC1094bm);
            this.f8303f.putBoolean("is_forward_mode", z2);
            if (i2 > 0) {
                this.f8303f.putInt("ACTIVITY_PURPOSE_ARG2", i2);
            }
            this.f8303f.putBoolean("forward_chat_message", z);
            this.f8300c = new MsgboxSelectionFragment();
        } else {
            this.f8301d = (BuddyFragment) getFragmentManager().mo182a("BUDDYFRAGMENT");
            if (this.f8301d == null) {
                this.f8301d = new BuddyFragment();
            } else {
                this.f8319v = true;
            }
            this.f8300c = (MsgboxSelectionFragment) getFragmentManager().mo182a("MSGFRAGMENT");
            if (this.f8300c == null) {
                this.f8300c = new MsgboxSelectionFragment();
            } else {
                this.f8320w = true;
            }
        }
        m10258a(this.f8311n);
        this.f8314q.setVisibility(0);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f8313p.setPressed(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    /* renamed from: a */
    private void m10258a(View view) throws Resources.NotFoundException {
        this.f8299b = this.f8298a.mo183a();
        if (view.getId() == this.f8312o.getId()) {
            if (getActivity().getCurrentFocus() != null) {
                ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
            }
            this.f8311n.setSelected(false);
            this.f8300c.m11143c();
            if (!this.f8300c.isAdded()) {
                this.f8300c.setArguments(this.f8303f);
            }
            this.f8313p = this.f8312o;
            this.f8312o.setPressed(true);
            this.f8311n.setPressed(false);
            if (!this.f8320w) {
                this.f8299b.mo96a(R.id.layoutForwardContents, this.f8300c, "MSGFRAGMENT");
                this.f8320w = true;
            }
            this.f8299b.mo102b(this.f8301d);
            this.f8299b.mo104c(this.f8300c);
            this.f8304g = 0;
            this.f8300c.m11141a(this.f8316s);
            this.f8299b.mo99b();
        } else if (view.getId() == this.f8311n.getId()) {
            this.f8312o.setSelected(false);
            this.f8300c.m11144d();
            if (!this.f8301d.isAdded()) {
                this.f8301d.setArguments(this.f8302e);
            }
            this.f8313p = this.f8311n;
            this.f8312o.setPressed(false);
            this.f8311n.setPressed(true);
            if (!this.f8319v) {
                this.f8299b.mo96a(R.id.layoutForwardContents, this.f8301d, "BUDDYFRAGMENT");
                this.f8319v = true;
            }
            this.f8299b.mo102b(this.f8300c);
            this.f8301d.m6595b(true);
            this.f8299b.mo104c(this.f8301d);
            this.f8304g = 1;
            this.f8301d.m6585a(this.f8315r);
            this.f8299b.mo99b();
        }
        this.f8313p.setSelected(true);
        this.f8314q.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        if (!C4847bl.m18333a()) {
            switch (view.getId()) {
                case R.id.tabForwardToBuddy /* 2131165881 */:
                    if (this.f8313p.getId() != R.id.tabForwardToBuddy) {
                        m10258a(view);
                        break;
                    }
                    break;
                case R.id.tabForwardToChat /* 2131165882 */:
                    if (this.f8313p.getId() != R.id.tabForwardToChat) {
                        m10258a(view);
                        break;
                    }
                    break;
            }
        }
    }
}
