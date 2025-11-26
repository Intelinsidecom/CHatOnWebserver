package com.sec.chaton.calllog.view;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.sso.p006a.C0045a;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.calllog.manager.HandlerC0838a;
import com.sec.chaton.calllog.manager.model.C0844c;
import com.sec.chaton.calllog.manager.model.CallLogDBData;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.calllog.manager.noti.C0846a;
import com.sec.chaton.calllog.manager.p022b.C0841a;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import twitter4j.internal.http.HttpResponseCode;

/* loaded from: classes.dex */
public class CallLogDetailFragment extends Fragment implements View.OnClickListener {

    /* renamed from: k */
    private static CallLogDetailInfoLayout f3227k;

    /* renamed from: A */
    private View f3228A;

    /* renamed from: H */
    private int f3235H;

    /* renamed from: I */
    private String f3236I;

    /* renamed from: K */
    private Toast f3238K;

    /* renamed from: L */
    private C0513c f3239L;

    /* renamed from: e */
    private ImageView f3246e;

    /* renamed from: f */
    private ImageButton f3247f;

    /* renamed from: g */
    private ImageButton f3248g;

    /* renamed from: h */
    private ImageButton f3249h;

    /* renamed from: i */
    private ListView f3250i;

    /* renamed from: j */
    private LinearLayout f3251j;

    /* renamed from: l */
    private TextView f3252l;

    /* renamed from: n */
    private CallLogData f3254n;

    /* renamed from: u */
    private int f3261u;

    /* renamed from: v */
    private int f3262v;

    /* renamed from: w */
    private ImageButton f3263w;

    /* renamed from: x */
    private ImageButton f3264x;

    /* renamed from: y */
    private ImageView f3265y;

    /* renamed from: z */
    private View f3266z;

    /* renamed from: d */
    private View f3245d = null;

    /* renamed from: m */
    private String f3253m = null;

    /* renamed from: o */
    private boolean f3255o = false;

    /* renamed from: p */
    private int f3256p = 0;

    /* renamed from: q */
    private boolean f3257q = false;

    /* renamed from: r */
    private boolean f3258r = false;

    /* renamed from: s */
    private boolean f3259s = false;

    /* renamed from: t */
    private boolean f3260t = false;

    /* renamed from: B */
    private final HandlerC0838a f3229B = CallLogFragment.f3288f;

    /* renamed from: C */
    private final C0841a f3230C = C0841a.m4451a();

    /* renamed from: D */
    private ArrayList<CallLogData> f3231D = new ArrayList<>();

    /* renamed from: E */
    private C0870l f3232E = null;

    /* renamed from: a */
    public HandlerC0867i f3242a = new HandlerC0867i(this);

    /* renamed from: F */
    private View f3233F = null;

    /* renamed from: G */
    private C0045a f3234G = new C0045a();

    /* renamed from: J */
    private ProgressDialog f3237J = null;

    /* renamed from: M */
    private String f3240M = "";

    /* renamed from: N */
    private int f3241N = -1;

    /* renamed from: b */
    Handler f3243b = new HandlerC0864f(this);

    /* renamed from: c */
    protected Handler f3244c = new HandlerC0866h(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m4520b(String str) {
        C3250y.m11453c(str, "[CallLogDetailActivity]");
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f3245d = layoutInflater.inflate(R.layout.calllog_detail_main, viewGroup, false);
        if (!m4515a(getActivity().getIntent())) {
            ((InterfaceC0868j) getActivity()).mo4503c();
            return null;
        }
        m4522c();
        m4527e();
        setHasOptionsMenu(true);
        return this.f3245d;
    }

    /* renamed from: c */
    private void m4522c() {
        f3227k = (CallLogDetailInfoLayout) this.f3245d.findViewById(R.id.calllog_detail_info);
        m4524d();
    }

    /* renamed from: d */
    private void m4524d() {
        List<Integer> list = this.f3254n.groupcallkey;
        if (list == null || (list != null && list.contains(0))) {
            if (this.f3254n.userInfo.get(0).f3207c != null) {
                this.f3262v = 0;
                f3227k.m4553a(0);
                return;
            } else {
                this.f3262v = 4;
                f3227k.m4553a(4);
                return;
            }
        }
        if (list != null && !list.contains(0)) {
            this.f3259s = true;
        }
    }

    /* renamed from: e */
    private void m4527e() {
        C0847a.m4634a(false);
        this.f3250i = (ListView) this.f3245d.findViewById(R.id.calllog_detail_main_list);
        m4508a(this.f3252l, this.f3252l);
        this.f3232E = new C0870l(this.f3254n);
        m4530f();
    }

    /* renamed from: f */
    private void m4530f() {
        this.f3246e = (ImageView) this.f3245d.findViewById(R.id.profile_image);
        f3227k = (CallLogDetailInfoLayout) this.f3245d.findViewById(R.id.calllog_detail_info);
        this.f3251j = (LinearLayout) this.f3245d.findViewById(R.id.btn_calllog);
        this.f3247f = (ImageButton) this.f3245d.findViewById(R.id.profile_v_voice);
        this.f3248g = (ImageButton) this.f3245d.findViewById(R.id.profile_v_video);
        this.f3247f.setNextFocusUpId(f3227k.findViewById(R.id.btn_add_group).getId());
        this.f3248g.setNextFocusUpId(f3227k.findViewById(R.id.btn_add_group).getId());
        this.f3263w = (ImageButton) this.f3245d.findViewById(R.id.profile_chat);
        this.f3249h = (ImageButton) this.f3245d.findViewById(R.id.profile_contact);
        this.f3264x = (ImageButton) this.f3245d.findViewById(R.id.profile_broadcast);
        this.f3266z = this.f3245d.findViewById(R.id.profile_broadcast_divider);
        this.f3228A = this.f3245d.findViewById(R.id.profile_contact_divider);
        m4539k();
        if (this.f3259s) {
            if (this.f3258r) {
                f3227k.m4553a(10);
                this.f3262v = 10;
            } else {
                f3227k.m4553a(11);
                this.f3262v = 11;
            }
            this.f3263w.setVisibility(0);
            this.f3264x.setVisibility(0);
            this.f3266z.setVisibility(0);
        }
        m4538j();
        m4531g();
        this.f3247f.setOnClickListener(this);
        this.f3248g.setOnClickListener(this);
        this.f3263w.setOnClickListener(this);
        this.f3249h.setOnClickListener(this);
        this.f3264x.setOnClickListener(this);
    }

    /* renamed from: g */
    private void m4531g() {
        List<String> listM4521c = m4521c(this.f3254n.userInfo.get(0).f3213i);
        if (listM4521c.size() > 0 && !this.f3259s) {
            this.f3236I = "+" + listM4521c.get(0);
            this.f3249h.setVisibility(0);
            this.f3228A.setVisibility(0);
        } else {
            this.f3249h.setVisibility(8);
            this.f3228A.setVisibility(8);
        }
    }

    /* renamed from: h */
    private void m4534h() {
        if (this.f3263w == null || this.f3265y == null || this.f3257q) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m4536i() {
        this.f3231D = this.f3229B.m4424a(m4544p(), true);
        if (this.f3231D == null || this.f3231D.isEmpty()) {
            ((InterfaceC0868j) getActivity()).mo4503c();
        }
        HashMap<Set<String>, String> mapM4426a = this.f3229B.m4426a();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i <= this.f3231D.size(); i++) {
            arrayList.add(false);
        }
        C0847a c0847a = new C0847a(getActivity(), 0, this.f3231D, mapM4426a, this.f3242a, this.f3232E, arrayList, null);
        this.f3250i.setAdapter((ListAdapter) c0847a);
        this.f3250i.setItemsCanFocus(false);
        c0847a.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m4538j() {
        C3250y.m11450b("setDisplayUpdate()", getClass().getSimpleName());
        m4539k();
        m4540l();
        m4541m();
        m4534h();
    }

    /* renamed from: k */
    private void m4539k() {
        if (this.f3254n.groupcallkey != null) {
            this.f3253m = m4506a(this.f3229B.m4426a(), this.f3254n.userInfo, this.f3254n);
            if (this.f3253m == null || this.f3253m.equals("")) {
                getActivity().setTitle(this.f3230C.m4461b(this.f3254n));
            } else {
                getActivity().setTitle(this.f3253m + " (" + this.f3254n.userInfo.size() + ")");
            }
            m4546r();
        } else if (this.f3230C.m4461b(this.f3254n) == this.f3254n.userInfo.get(0).f3205a) {
            getActivity().setTitle(this.f3254n.userInfo.get(0).f3207c);
        } else {
            getActivity().setTitle(this.f3230C.m4461b(this.f3254n));
        }
        if (this.f3253m != null) {
            this.f3258r = true;
        }
    }

    /* renamed from: a */
    public static String m4506a(HashMap<Set<String>, String> map, List<C0844c> list, CallLogData callLogData) {
        return C0841a.m4451a().m4458a(callLogData, map, list);
    }

    /* renamed from: l */
    private void m4540l() {
    }

    /* renamed from: m */
    private void m4541m() {
        C3250y.m11450b("setBuddyDisplayUpdate()mBuddyType" + this.f3262v, getClass().getSimpleName());
        switch (this.f3262v) {
            case 0:
                C3205bt.m11182a(getActivity()).m11210a(this.f3246e, this.f3254n.userInfo.get(0).f3205a.toString());
                this.f3251j.setVisibility(0);
                break;
            case 1:
            case 2:
            case 3:
            case 4:
                this.f3251j.setVisibility(8);
                break;
            case 10:
            case 11:
                if (this.f3253m != null) {
                    C3205bt.m11182a(getActivity()).m11226b(this.f3246e, this.f3253m);
                } else {
                    this.f3246e.setImageResource(R.drawable.contacts_default_group);
                }
                this.f3257q = true;
                break;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        int i = 0;
        menu.clear();
        switch (this.f3262v) {
            case 0:
                i = R.menu.calllog_detail_menu;
                break;
            case 1:
                i = R.menu.calllog_detail_menu_hide;
                break;
            case 2:
            case 3:
            case 4:
                i = R.menu.calllog_detail_menu_not_saved;
                break;
            case 10:
                i = R.menu.calllog_detail_menu_group;
                break;
            case 11:
                i = R.menu.calllog_detail_menu_group_not_saved;
                break;
        }
        menuInflater.inflate(i, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                ((InterfaceC0868j) getActivity()).mo4503c();
                break;
            case R.id.menu_calllog_delete /* 2131166598 */:
                if (this.f3254n.groupcallkey == null) {
                    Intent intent = new Intent().setClass(getActivity(), DeleteCallLogActivity.class);
                    intent.putExtra("calllogdata", this.f3254n);
                    intent.putExtra("from_intent", 3);
                    intent.setFlags(131072);
                    intent.addFlags(536870912);
                    startActivityForResult(intent, 1);
                    getActivity().supportInvalidateOptionsMenu();
                    break;
                } else {
                    AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(getActivity());
                    String string = getString(R.string.create_delete_msg_dialog_title);
                    String string2 = getString(R.string.calllog_all_delete);
                    abstractC3271aM11494a.mo11500a(string);
                    abstractC3271aM11494a.mo11509b(string2);
                    abstractC3271aM11494a.mo11515d(R.string.alert_dialog_ok, new DialogInterfaceOnClickListenerC0860b(this));
                    abstractC3271aM11494a.mo11507b(R.string.cancel, new DialogInterfaceOnClickListenerC0861c(this));
                    abstractC3271aM11494a.mo11511b(true);
                    abstractC3271aM11494a.mo11498a(new DialogInterfaceOnCancelListenerC0862d(this));
                    abstractC3271aM11494a.mo11505a().show();
                    break;
                }
            case R.id.menu_calllog_show_member /* 2131166599 */:
                Intent intent2 = new Intent();
                intent2.setClass(getActivity(), ShowConferenceMemberList.class);
                intent2.putExtra("calllogdata", this.f3254n);
                intent2.putExtra("searchtype", this.f3256p);
                intent2.putExtra("order", this.f3241N);
                intent2.putExtra("makecall", false);
                startActivityForResult(intent2, HttpResponseCode.f13733OK);
                getActivity().supportInvalidateOptionsMenu();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public Context m4542n() {
        return getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m4543o() {
        int iM4428b;
        m4520b("addDuplicatedCallLog()");
        if (this.f3260t && this.f3261u != (iM4428b = this.f3229B.m4428b())) {
            this.f3260t = false;
            CallLogDBData callLogDBData = new CallLogDBData();
            callLogDBData._id = iM4428b;
            CallLogData callLogData = this.f3229B.m4423a(callLogDBData, false).get(0);
            if ((this.f3254n.userInfo.get(0).f3205a.equals(callLogData.userInfo.get(0).f3205a) || this.f3254n.groupcallkey != null) && ((this.f3254n.userInfo.get(0).f3216l == callLogData.userInfo.get(0).f3216l || ((this.f3254n.userInfo.get(0).f3216l == 0 && callLogData.userInfo.get(0).f3216l == 1) || (this.f3254n.userInfo.get(0).f3216l == 1 && callLogData.userInfo.get(0).f3216l == 0))) && (this.f3254n.callmethod == callLogData.callmethod || ((this.f3254n.callmethod > 3 && callLogData.callmethod > 3) || (this.f3254n.callmethod < 3 && callLogData.callmethod < 3))))) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(iM4428b));
                m4520b("add calllog!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                this.f3254n.totalIDList.add(arrayList);
            }
        }
        m4536i();
    }

    /* renamed from: p */
    private ArrayList<Integer> m4544p() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f3261u = this.f3229B.m4428b();
        Iterator<List<Integer>> it = this.f3254n.totalIDList.iterator();
        while (it.hasNext()) {
            for (Integer num : it.next()) {
                if (this.f3261u == num.intValue()) {
                    this.f3260t = true;
                }
                arrayList.add(num);
            }
        }
        return arrayList;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m4520b("onResume()");
        if (this.f3255o) {
            ArrayList<CallLogData> arrayListM4421a = this.f3229B.m4421a(this.f3256p, true);
            if (arrayListM4421a.size() > 0 && arrayListM4421a.get(1).userInfo.get(0).f3205a.equals(this.f3254n.userInfo.get(0).f3205a)) {
                this.f3254n = arrayListM4421a.get(1);
                C0846a.m4496a().m4497a(1000);
            }
        }
        m4545q();
        m4536i();
        this.f3242a.sendEmptyMessage(8000);
    }

    /* renamed from: q */
    private void m4545q() {
        String strM4556a = CallLogFragment.m4556a(getActivity());
        String strM4565b = CallLogFragment.m4565b(getActivity());
        if (strM4556a == null || !strM4556a.equals("24")) {
            C0847a.m4635b(false);
        } else {
            C0847a.m4635b(true);
        }
        if (strM4565b != null) {
            if (strM4565b.equals("MM-dd-yyyy")) {
                C0847a.m4633a(0);
                return;
            } else if (strM4565b.equals("dd-MM-yyyy")) {
                C0847a.m4633a(1);
                return;
            } else {
                if (strM4565b.equals("yyyy-MM-dd")) {
                    C0847a.m4633a(2);
                    return;
                }
                return;
            }
        }
        C0847a.m4633a(0);
    }

    /* renamed from: a */
    private boolean m4515a(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras.getBoolean("updateUIAfterCall", false)) {
            this.f3255o = true;
        }
        this.f3256p = extras.getInt("searchtype", 0);
        if (extras.getBoolean("normal")) {
            m4520b("normal");
            this.f3254n = (CallLogData) extras.getParcelable("calllogdata");
            this.f3241N = extras.getInt("order", 0);
            if (this.f3254n == null) {
                m4520b("mCallLog is NULL");
                return false;
            }
        } else if (extras.getBoolean("rejected_call")) {
            m4520b("rejected call");
            this.f3254n = this.f3229B.m4425a(true).get(1);
            if (this.f3254n == null) {
                m4520b("mCallLog is NULL");
                return false;
            }
        } else if (extras.getBoolean("missed_call")) {
            this.f3254n = m4505a(this.f3229B);
            if (this.f3254n == null) {
                return false;
            }
            this.f3256p = 5;
        }
        return true;
    }

    /* renamed from: a */
    private static CallLogData m4505a(HandlerC0838a handlerC0838a) {
        ArrayList<CallLogData> arrayListM4430b = handlerC0838a.m4430b(true);
        CallLogData callLogData = null;
        if (arrayListM4430b.isEmpty()) {
            C3250y.m11450b("getMissedCallLog missed_call:CallLogList is Empty", CallLogDetailActivity.class.getSimpleName());
        } else {
            callLogData = arrayListM4430b.get(1);
            if (callLogData == null) {
                C3250y.m11450b("getMissedCallLog callLog is NULL", CallLogDetailActivity.class.getSimpleName());
            }
        }
        return callLogData;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        CallLogData callLogDataM4504a;
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            C0847a.m4634a(false);
            return;
        }
        m4520b("onActivityResult()");
        if (i == 1) {
            m4520b("DELETE_RESULT");
            if (true == intent.getExtras().getBoolean("DELETE_DETAIL_CALLLOG_ALL")) {
                ((InterfaceC0868j) getActivity()).mo4503c();
                return;
            } else {
                m4538j();
                return;
            }
        }
        if (i == 200) {
            m4520b("SELECT_GROUP_LIST");
            if (true == intent.getExtras().getBoolean("MEMBERS_LIST_CHANGE_BUDDY_INFO") && (callLogDataM4504a = m4504a(this.f3241N, this.f3256p, this.f3229B)) != null) {
                this.f3254n = callLogDataM4504a;
                m4524d();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.profile_chat /* 2131165403 */:
                m4514a(this.f3257q, false);
                break;
            case R.id.profile_broadcast /* 2131165405 */:
                m4514a(this.f3257q, true);
                break;
            case R.id.profile_v_voice /* 2131165407 */:
                if (this.f3257q) {
                    C3250y.m11450b("onClick() profile_v_voice group", getClass().getSimpleName());
                    startActivityForResult(new Intent().setClass(getActivity(), ShowConferenceMemberList.class).putExtra("calllogdata", this.f3254n).putExtra("searchtype", this.f3256p).putExtra("order", this.f3241N).putExtra("makecall", true).putExtra("groupName", this.f3253m).putExtra("from_intent", 0).setFlags(131072).addFlags(536870912), HttpResponseCode.f13733OK);
                    break;
                } else {
                    C3250y.m11450b("onClick() profile_v_voice", getClass().getSimpleName());
                    m4513a(false);
                    break;
                }
            case R.id.profile_v_video /* 2131165409 */:
                if (this.f3257q) {
                    C3250y.m11450b("onClick() profile_v_video group", getClass().getSimpleName());
                    startActivityForResult(new Intent().setClass(getActivity(), ShowConferenceMemberList.class).putExtra("calllogdata", this.f3254n).putExtra("searchtype", this.f3256p).putExtra("order", this.f3241N).putExtra("makecall", true).putExtra("groupName", this.f3253m).putExtra("from_intent", 1).setFlags(131072).addFlags(536870912), HttpResponseCode.f13733OK);
                    break;
                } else {
                    m4513a(true);
                    break;
                }
            case R.id.profile_contact /* 2131165411 */:
                m4526d(this.f3236I);
                break;
        }
    }

    /* renamed from: a */
    private void m4514a(boolean z, boolean z2) {
        Intent intentM1226a = TabActivity.m1226a(getActivity());
        intentM1226a.putExtra("callChatList", true);
        if (!z) {
            intentM1226a.putExtra("receivers", new String[]{this.f3254n.userInfo.get(0).f3205a});
        } else {
            new ArrayList();
            intentM1226a.putExtra("receivers", (String[]) m4507a(this.f3254n).toArray(new String[0]));
        }
        if (z2) {
            intentM1226a.putExtra("chatType", EnumC1450r.BROADCAST.m6342a());
        } else if (!z) {
            intentM1226a.putExtra("chatType", EnumC1450r.ONETOONE.m6342a());
        } else {
            intentM1226a.putExtra("chatType", EnumC1450r.GROUPCHAT.m6342a());
        }
        startActivity(intentM1226a);
    }

    /* renamed from: r */
    private void m4546r() {
    }

    /* renamed from: a */
    public static ArrayList<String> m4507a(CallLogData callLogData) {
        ArrayList<String> arrayList = new ArrayList<>();
        CallLogData callLogDataM4516b = m4516b(callLogData);
        if (callLogDataM4516b == null) {
            return arrayList;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= callLogDataM4516b.userInfo.size()) {
                return arrayList;
            }
            arrayList.add(callLogDataM4516b.userInfo.get(i2).f3205a);
            i = i2 + 1;
        }
    }

    /* renamed from: b */
    public static CallLogData m4516b(CallLogData callLogData) {
        if (callLogData != null && callLogData.userInfo.size() > 1) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < callLogData.userInfo.size() - 1) {
                    for (int size = callLogData.userInfo.size() - 1; size > i2; size--) {
                        if (callLogData.userInfo.get(i2).f3205a.equals(callLogData.userInfo.get(size).f3205a)) {
                            callLogData.userInfo.remove(size);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return callLogData;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static CallLogData m4504a(int i, int i2, HandlerC0838a handlerC0838a) {
        if (i2 == 5) {
            CallLogData callLogDataM4505a = m4505a(handlerC0838a);
            C3250y.m11450b("updateBuddyInfo() with missed call", CallLogDetailActivity.class.getSimpleName());
            return callLogDataM4505a;
        }
        if (i < 0) {
            return null;
        }
        CallLogData callLogData = handlerC0838a.m4421a(i2, true).get(i);
        C3250y.m11450b("updateBuddyInfo() normal case", CallLogDetailActivity.class.getSimpleName());
        return callLogData;
    }

    /* renamed from: a */
    private void m4513a(boolean z) {
        int iM47a;
        if (z) {
            iM47a = this.f3234G.m47a(getActivity(), true, this.f3254n.userInfo.get(0).f3205a, C3159aa.m10962a().m10979a("Push Name", ""), null);
        } else {
            iM47a = this.f3234G.m47a(getActivity(), false, this.f3254n.userInfo.get(0).f3205a, C3159aa.m10962a().m10979a("Push Name", ""), null);
        }
        if (iM47a != 0) {
            C3641ai.m13210a(getActivity(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        m4520b("onConfigurationChanged()");
        if (f3227k != null) {
            f3227k.setBtnTextUpdate();
        }
        C3250y.m11453c("YKYU onConfigurationChanged()", "");
        if (configuration.orientation == 1) {
            C3250y.m11453c("YKYU onConfigurationChanged()  ORIENTATION_PORTRAIT is called!!!!!!!!", "");
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        if (f3227k != null) {
            f3227k.m4552a();
        }
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    /* renamed from: a */
    private void m4508a(View view, View view2) {
        if (view != null || view2 != null) {
            view.setOnHoverListener(new ViewOnHoverListenerC0863e(this, view, view2));
        }
    }

    /* renamed from: c */
    private List<String> m4521c(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, "|");
            while (stringTokenizer.hasMoreTokens()) {
                new String();
                String strNextToken = stringTokenizer.nextToken();
                if (strNextToken.length() >= 19 && strNextToken.startsWith("10")) {
                    C3250y.m11450b("chaton id : " + strNextToken, "CallLogDetailActivity");
                } else if (strNextToken.startsWith("0")) {
                    C3250y.m11450b("pin number : " + strNextToken, "CallLogDetailActivity");
                } else {
                    C3250y.m11450b("msisdn: " + strNextToken, "CallLogDetailActivity");
                    arrayList.add(strNextToken);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00da  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m4550a(java.lang.String r10) throws java.lang.Throwable {
        /*
            r9 = this;
            r7 = 1
            r8 = 0
            r6 = 0
            java.lang.String r0 = "[contactSavedCheck] Contact Saved Find Start"
            java.lang.String r1 = "CallLogDetailActivity"
            com.sec.chaton.util.C3250y.m11450b(r0, r1)     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc4
            android.net.Uri r0 = android.provider.ContactsContract.PhoneLookup.CONTENT_FILTER_URI     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc4
            java.lang.String r1 = android.net.Uri.encode(r10)     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc4
            android.net.Uri r1 = android.net.Uri.withAppendedPath(r0, r1)     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc4
            android.support.v4.app.FragmentActivity r0 = r9.getActivity()     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc4
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc4
            r2 = 3
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc4
            r3 = 0
            java.lang.String r4 = "display_name"
            r2[r3] = r4     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc4
            r3 = 1
            java.lang.String r4 = "number"
            r2[r3] = r4     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc4
            r3 = 2
            java.lang.String r4 = "_id"
            r2[r3] = r4     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc4
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc4
            if (r1 == 0) goto Lda
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> Ld2 java.lang.Exception -> Ld4
            if (r0 <= 0) goto Lda
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Throwable -> Ld2 java.lang.Exception -> Ld4
            if (r0 == 0) goto Lda
            java.lang.String r0 = "_id"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> Ld2 java.lang.Exception -> Ld7
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> Ld2 java.lang.Exception -> Ld7
            r9.f3235H = r0     // Catch: java.lang.Throwable -> Ld2 java.lang.Exception -> Ld7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld2 java.lang.Exception -> Ld7
            r0.<init>()     // Catch: java.lang.Throwable -> Ld2 java.lang.Exception -> Ld7
            java.lang.String r2 = "[contactSavedCheck] Found in Contact Number : "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Ld2 java.lang.Exception -> Ld7
            java.lang.StringBuilder r0 = r0.append(r10)     // Catch: java.lang.Throwable -> Ld2 java.lang.Exception -> Ld7
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Ld2 java.lang.Exception -> Ld7
            java.lang.String r2 = "CallLogDetailActivity"
            com.sec.chaton.util.C3250y.m11450b(r0, r2)     // Catch: java.lang.Throwable -> Ld2 java.lang.Exception -> Ld7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld2 java.lang.Exception -> Ld7
            r0.<init>()     // Catch: java.lang.Throwable -> Ld2 java.lang.Exception -> Ld7
            java.lang.String r2 = "[contactSavedCheck] ContactSaved id : "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Ld2 java.lang.Exception -> Ld7
            int r2 = r9.f3235H     // Catch: java.lang.Throwable -> Ld2 java.lang.Exception -> Ld7
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Ld2 java.lang.Exception -> Ld7
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Ld2 java.lang.Exception -> Ld7
            java.lang.String r2 = "CallLogDetailActivity"
            com.sec.chaton.util.C3250y.m11450b(r0, r2)     // Catch: java.lang.Throwable -> Ld2 java.lang.Exception -> Ld7
        L81:
            if (r1 == 0) goto L8c
            boolean r0 = r1.isClosed()
            if (r0 != 0) goto L8c
            r1.close()
        L8c:
            if (r7 != 0) goto La8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "[contactSavedCheck] No PhoneNumber in Contact : "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "CallLogDetailActivity"
            com.sec.chaton.util.C3250y.m11450b(r0, r1)
            r9.f3235H = r8
        La8:
            return r7
        La9:
            r0 = move-exception
            r1 = r6
            r2 = r8
        Lac:
            java.lang.Class r3 = r9.getClass()     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r3 = r3.getSimpleName()     // Catch: java.lang.Throwable -> Ld2
            com.sec.chaton.util.C3250y.m11443a(r0, r3)     // Catch: java.lang.Throwable -> Ld2
            if (r1 == 0) goto Lc2
            boolean r0 = r1.isClosed()
            if (r0 != 0) goto Lc2
            r1.close()
        Lc2:
            r7 = r2
            goto L8c
        Lc4:
            r0 = move-exception
            r1 = r6
        Lc6:
            if (r1 == 0) goto Ld1
            boolean r2 = r1.isClosed()
            if (r2 != 0) goto Ld1
            r1.close()
        Ld1:
            throw r0
        Ld2:
            r0 = move-exception
            goto Lc6
        Ld4:
            r0 = move-exception
            r2 = r8
            goto Lac
        Ld7:
            r0 = move-exception
            r2 = r7
            goto Lac
        Lda:
            r7 = r8
            goto L81
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.calllog.view.CallLogDetailFragment.m4550a(java.lang.String):boolean");
    }

    /* renamed from: d */
    private void m4526d(String str) {
        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        if (!m4550a(str)) {
            Bundle bundle = new Bundle();
            bundle.putString("phone", str);
            bundle.putString("name", this.f3254n.userInfo.get(0).f3207c);
            C3250y.m11450b("phoneNum: " + str, "CallLogDetailActivity");
            C3250y.m11450b("NAME: " + this.f3254n.userInfo.get(0).f3207c, "CallLogDetailActivity");
            Intent intent = new Intent("android.intent.action.INSERT", uri);
            intent.putExtras(bundle);
            intent.putExtra("return-data", true);
            try {
                startActivity(intent);
                return;
            } catch (ActivityNotFoundException e) {
                C3250y.m11443a(e, getClass().getSimpleName());
                C3641ai.m13210a(getActivity(), R.string.toast_contact_not_found, 0).show();
                return;
            }
        }
        long j = 0 == 0 ? this.f3235H : 0L;
        C3250y.m11450b("id: " + j, "CallLogDetailActivity");
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse(uri + "/" + j));
        try {
            startActivity(intent2);
        } catch (ActivityNotFoundException e2) {
            C3250y.m11443a(e2, getClass().getSimpleName());
            C3641ai.m13210a(getActivity(), R.string.toast_contact_not_found, 0).show();
        }
    }

    /* renamed from: a */
    public void m4549a() {
        C0513c c0513c = new C0513c(this.f3254n.userInfo.get(0).f3205a, this.f3230C.m4461b(this.f3254n));
        this.f3239L = c0513c;
        m4547s();
        C1330h c1330h = new C1330h(this.f3243b);
        this.f3240M = c0513c.m3976c();
        c1330h.m5730b(c0513c.m3975b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public void m4547s() {
        if (this.f3237J == null) {
            this.f3237J = ProgressDialogC3265l.m11490a(getActivity(), null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
        } else {
            this.f3237J.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public void m4548t() {
        if (this.f3237J != null) {
            this.f3237J.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4512a(CharSequence charSequence) {
        if (this.f3238K == null) {
            this.f3238K = C3641ai.m13211a(getActivity(), (CharSequence) null, 0);
        }
        this.f3238K.setText(charSequence);
        this.f3238K.show();
    }
}
