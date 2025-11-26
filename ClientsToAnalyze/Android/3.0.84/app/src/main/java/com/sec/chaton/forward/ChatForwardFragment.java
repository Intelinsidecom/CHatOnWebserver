package com.sec.chaton.forward;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.sec.chaton.C2310s;
import com.sec.chaton.EnumC3073u;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.buddy.InterfaceC0594cy;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgbox.InterfaceC1712ap;
import com.sec.chaton.msgbox.MsgboxSelectionFragment;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.StateButton;
import com.sec.common.p063a.AbstractC3271a;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* loaded from: classes.dex */
public class ChatForwardFragment extends Fragment implements View.OnClickListener {

    /* renamed from: c */
    MsgboxSelectionFragment f5465c;

    /* renamed from: d */
    BuddyFragment f5466d;

    /* renamed from: e */
    Bundle f5467e;

    /* renamed from: f */
    Bundle f5468f;

    /* renamed from: g */
    int f5469g;

    /* renamed from: h */
    private int f5470h;

    /* renamed from: i */
    private String f5471i;

    /* renamed from: j */
    private String f5472j;

    /* renamed from: k */
    private String f5473k;

    /* renamed from: l */
    private String f5474l;

    /* renamed from: m */
    private String f5475m;

    /* renamed from: n */
    private StateButton f5476n;

    /* renamed from: o */
    private StateButton f5477o;

    /* renamed from: p */
    private StateButton f5478p;

    /* renamed from: q */
    private View f5479q;

    /* renamed from: r */
    private InterfaceC0594cy f5480r;

    /* renamed from: s */
    private InterfaceC1712ap f5481s;

    /* renamed from: t */
    private MenuItem f5482t;

    /* renamed from: u */
    private MenuItem f5483u;

    /* renamed from: a */
    FragmentManager f5463a = null;

    /* renamed from: b */
    FragmentTransaction f5464b = null;

    /* renamed from: v */
    private boolean f5484v = false;

    /* renamed from: w */
    private boolean f5485w = false;

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        C3250y.m11456e("onAttach, MemoryAddress : " + this, getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        if (this.f5469g != 1 && this.f5469g == 0) {
            menuInflater.inflate(R.menu.cancel_done_menu, menu);
            this.f5482t = menu.findItem(R.id.menu_done);
            this.f5483u = menu.findItem(R.id.menu_cancel);
            this.f5482t.setEnabled(false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_cancel) {
            getActivity().finish();
        }
        if (menuItem.getItemId() == R.id.menu_done) {
            if (this.f5469g == 1) {
                if (this.f5466d.m3444i() > 1) {
                    CharSequence[] charSequenceArr = {getString(R.string.menu_button_start_chat), getString(R.string.menu_inbox_broadcast)};
                    AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(getActivity());
                    abstractC3271aM11494a.mo11500a(GlobalApplication.m6451b().getString(R.string.dialog_header_text));
                    abstractC3271aM11494a.mo11504a(charSequenceArr, new DialogInterfaceOnClickListenerC1479a(this));
                    abstractC3271aM11494a.mo11505a().show();
                } else {
                    this.f5466d.m3440e();
                }
            } else if (this.f5469g == 0) {
                this.f5465c.m7118e();
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
        this.f5463a = getFragmentManager();
        this.f5467e = new Bundle();
        this.f5468f = new Bundle();
        setHasOptionsMenu(true);
        this.f5480r = new C1480b(this);
        this.f5481s = new C1481c(this);
        if (this.f5466d != null) {
            this.f5466d.m3425a(this.f5480r);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        boolean z;
        int i;
        EnumC3073u enumC3073u;
        Bundle arguments = getArguments();
        int iM6342a = EnumC1450r.UNKNOWN.m6342a();
        EnumC3073u enumC3073u2 = EnumC3073u.INSIDE;
        if (arguments == null || arguments.size() <= 0) {
            z = false;
            i = iM6342a;
        } else {
            if (arguments.containsKey("content_type")) {
                this.f5470h = arguments.getInt("content_type");
                C3250y.m11454d("Forward content_type:" + this.f5470h);
            }
            if (arguments.containsKey("download_uri")) {
                this.f5471i = arguments.getString("download_uri");
                C3250y.m11454d("Forward download_uri:" + this.f5471i);
            }
            if (arguments.containsKey("sub_content")) {
                this.f5472j = arguments.getString("sub_content");
                C3250y.m11454d("Forward sub_content:" + this.f5472j);
            }
            if (arguments.containsKey("forward_sender_name")) {
                this.f5473k = arguments.getString("forward_sender_name");
                C3250y.m11454d("Forward sender name:" + this.f5473k);
            }
            if (arguments.containsKey("inboxNO")) {
                this.f5474l = arguments.getString("inboxNO");
                C3250y.m11454d("Forward mInboxNo:" + this.f5474l);
            }
            if (arguments.containsKey("chatType")) {
                iM6342a = arguments.getInt("chatType");
                C3250y.m11454d("Forward chatType:" + iM6342a);
            }
            i = iM6342a;
            if (arguments.containsKey("is_forward_mode")) {
                boolean z2 = arguments.getBoolean("is_forward_mode");
                C3250y.m11454d("Forward isForward:" + z2);
                z = z2;
            } else {
                z = false;
            }
            if (arguments.containsKey(C2310s.f8621e)) {
                enumC3073u = (EnumC3073u) arguments.get(C2310s.f8621e);
                C3250y.m11454d("Forward intentFrom:" + enumC3073u);
            } else {
                enumC3073u = enumC3073u2;
            }
            if (arguments.containsKey("null")) {
                this.f5475m = arguments.getString("null");
                C3250y.m11454d("Forward BuddyName:" + this.f5475m);
            }
            enumC3073u2 = enumC3073u;
        }
        if ("android.intent.action.SEND".equals(getActivity().getIntent().getAction())) {
            ((ChatForwardActivity) getActivity()).setTitle(GlobalApplication.m6451b().getString(R.string.trunk_btn_share));
        }
        View viewInflate = layoutInflater.inflate(R.layout.layout_fragment_chatforward, viewGroup, false);
        this.f5476n = (StateButton) viewInflate.findViewById(R.id.tabForwardToBuddy);
        this.f5476n.setOnClickListener(this);
        this.f5477o = (StateButton) viewInflate.findViewById(R.id.tabForwardToChat);
        this.f5477o.setOnClickListener(this);
        this.f5479q = viewInflate.findViewById(R.id.layoutForwardContents);
        if (bundle == null) {
            this.f5467e.putInt("content_type", this.f5470h);
            this.f5467e.putString("download_uri", this.f5471i);
            this.f5467e.putString("inboxNO", this.f5474l);
            this.f5467e.putString("sub_content", this.f5472j);
            this.f5467e.putString("forward_sender_name", this.f5473k);
            this.f5467e.putInt("ACTIVITY_PURPOSE", 8);
            this.f5467e.putSerializable(C2310s.f8621e, enumC3073u2);
            if (this.f5475m != null && this.f5475m.length() > 0) {
                this.f5467e.putString("null", this.f5475m);
            }
            if (i != EnumC1450r.UNKNOWN.m6342a()) {
                this.f5467e.putInt("chatType", i);
            }
            this.f5467e.putBoolean("is_forward_mode", z);
            this.f5466d = new BuddyFragment();
        }
        if (bundle == null) {
            this.f5468f.putInt("content_type", this.f5470h);
            this.f5468f.putString("download_uri", this.f5471i);
            this.f5468f.putString("inboxNO", this.f5474l);
            this.f5468f.putString("sub_content", this.f5472j);
            this.f5468f.putString("forward_sender_name", this.f5473k);
            this.f5468f.putInt(RtspHeaders.Values.MODE, 3);
            this.f5468f.putSerializable(C2310s.f8621e, enumC3073u2);
            this.f5468f.putBoolean("is_forward_mode", z);
            this.f5465c = new MsgboxSelectionFragment();
        } else {
            this.f5466d = (BuddyFragment) getFragmentManager().findFragmentByTag("BUDDYFRAGMENT");
            if (this.f5466d == null) {
                this.f5466d = new BuddyFragment();
            } else {
                this.f5484v = true;
            }
            this.f5465c = (MsgboxSelectionFragment) getFragmentManager().findFragmentByTag("MSGFRAGMENT");
            if (this.f5465c == null) {
                this.f5465c = new MsgboxSelectionFragment();
            } else {
                this.f5485w = true;
            }
        }
        m6415a(this.f5476n);
        this.f5479q.setVisibility(0);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f5478p.setPressed(true);
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
    private void m6415a(View view) {
        this.f5464b = this.f5463a.beginTransaction();
        if (view.getId() == this.f5477o.getId()) {
            if (getActivity().getCurrentFocus() != null) {
                ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
            }
            this.f5476n.setSelected(false);
            this.f5465c.m7116c();
            if (!this.f5465c.isAdded()) {
                this.f5465c.setArguments(this.f5468f);
            }
            this.f5478p = this.f5477o;
            this.f5477o.setPressed(true);
            this.f5476n.setPressed(false);
            if (!this.f5485w) {
                this.f5464b.add(R.id.layoutForwardContents, this.f5465c, "MSGFRAGMENT");
                this.f5485w = true;
            }
            this.f5464b.hide(this.f5466d);
            this.f5464b.show(this.f5465c);
            this.f5469g = 0;
            this.f5465c.m7112a(this.f5481s);
            this.f5464b.commit();
        } else if (view.getId() == this.f5476n.getId()) {
            this.f5477o.setSelected(false);
            this.f5465c.m7117d();
            if (!this.f5466d.isAdded()) {
                this.f5466d.setArguments(this.f5467e);
            }
            this.f5478p = this.f5476n;
            this.f5477o.setPressed(false);
            this.f5476n.setPressed(true);
            if (!this.f5484v) {
                this.f5464b.add(R.id.layoutForwardContents, this.f5466d, "BUDDYFRAGMENT");
                this.f5484v = true;
            }
            this.f5464b.hide(this.f5465c);
            this.f5466d.m3430a(true);
            this.f5464b.show(this.f5466d);
            this.f5469g = 1;
            this.f5466d.m3425a(this.f5480r);
            this.f5464b.commit();
        }
        this.f5478p.setSelected(true);
        this.f5479q.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C3197bl.m11159a()) {
            switch (view.getId()) {
                case R.id.tabForwardToBuddy /* 2131165967 */:
                    if (this.f5478p.getId() != R.id.tabForwardToBuddy) {
                        m6415a(view);
                        break;
                    }
                    break;
                case R.id.tabForwardToChat /* 2131165968 */:
                    if (this.f5478p.getId() != R.id.tabForwardToChat) {
                        m6415a(view);
                        break;
                    }
                    break;
            }
        }
    }
}
