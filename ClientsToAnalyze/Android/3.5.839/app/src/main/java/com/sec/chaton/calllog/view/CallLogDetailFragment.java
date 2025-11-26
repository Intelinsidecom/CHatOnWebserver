package com.sec.chaton.calllog.view;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.hardware.motion.MotionRecognitionManager;
import android.net.Uri;
import android.os.Build;
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
import com.coolots.sso.p030a.C0416a;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.calllog.manager.HandlerC1449a;
import com.sec.chaton.calllog.manager.model.C1455c;
import com.sec.chaton.calllog.manager.model.CallLogDBData;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.calllog.manager.noti.C1457a;
import com.sec.chaton.calllog.manager.p053b.C1452a;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4855bt;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class CallLogDetailFragment extends Fragment implements View.OnClickListener {

    /* renamed from: k */
    private static CallLogDetailInfoLayout f5199k;

    /* renamed from: A */
    private View f5200A;

    /* renamed from: H */
    private int f5207H;

    /* renamed from: I */
    private String f5208I;

    /* renamed from: K */
    private Toast f5210K;

    /* renamed from: L */
    private C1106c f5211L;

    /* renamed from: e */
    private ImageView f5218e;

    /* renamed from: f */
    private ImageButton f5219f;

    /* renamed from: g */
    private ImageButton f5220g;

    /* renamed from: h */
    private ImageButton f5221h;

    /* renamed from: i */
    private ListView f5222i;

    /* renamed from: j */
    private LinearLayout f5223j;

    /* renamed from: l */
    private TextView f5224l;

    /* renamed from: n */
    private CallLogData f5226n;

    /* renamed from: u */
    private int f5233u;

    /* renamed from: v */
    private int f5234v;

    /* renamed from: w */
    private ImageButton f5235w;

    /* renamed from: x */
    private ImageButton f5236x;

    /* renamed from: y */
    private ImageView f5237y;

    /* renamed from: z */
    private View f5238z;

    /* renamed from: d */
    private View f5217d = null;

    /* renamed from: m */
    private String f5225m = null;

    /* renamed from: o */
    private boolean f5227o = false;

    /* renamed from: p */
    private int f5228p = 0;

    /* renamed from: q */
    private boolean f5229q = false;

    /* renamed from: r */
    private boolean f5230r = false;

    /* renamed from: s */
    private boolean f5231s = false;

    /* renamed from: t */
    private boolean f5232t = false;

    /* renamed from: B */
    private final HandlerC1449a f5201B = CallLogFragment.f5260f;

    /* renamed from: C */
    private final C1452a f5202C = C1452a.m7605a();

    /* renamed from: D */
    private ArrayList<CallLogData> f5203D = new ArrayList<>();

    /* renamed from: E */
    private C1481l f5204E = null;

    /* renamed from: a */
    public HandlerC1478i f5214a = new HandlerC1478i(this);

    /* renamed from: F */
    private View f5205F = null;

    /* renamed from: G */
    private C0416a f5206G = new C0416a();

    /* renamed from: J */
    private ProgressDialog f5209J = null;

    /* renamed from: M */
    private String f5212M = "";

    /* renamed from: N */
    private int f5213N = -1;

    /* renamed from: b */
    Handler f5215b = new HandlerC1475f(this);

    /* renamed from: c */
    protected Handler f5216c = new HandlerC1477h(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m7674b(String str) {
        C4904y.m18641c(str, "[CallLogDetailActivity]");
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5217d = layoutInflater.inflate(R.layout.calllog_detail_main, viewGroup, false);
        if (!m7669a(getActivity().getIntent())) {
            ((InterfaceC1479j) getActivity()).mo7657h();
            return null;
        }
        m7676c();
        m7681e();
        setHasOptionsMenu(true);
        return this.f5217d;
    }

    /* renamed from: c */
    private void m7676c() {
        f5199k = (CallLogDetailInfoLayout) this.f5217d.findViewById(R.id.calllog_detail_info);
        m7678d();
    }

    /* renamed from: d */
    private void m7678d() {
        List<Integer> list = this.f5226n.groupcallkey;
        if (list == null || (list != null && list.contains(0))) {
            if (this.f5226n.userInfo.get(0).f5177c != null) {
                this.f5234v = 0;
                f5199k.m7708a(0);
                return;
            } else {
                this.f5234v = 4;
                f5199k.m7708a(4);
                return;
            }
        }
        if (list != null && !list.contains(0)) {
            this.f5231s = true;
        }
    }

    /* renamed from: e */
    private void m7681e() {
        C1458a.m7790a(false);
        this.f5222i = (ListView) this.f5217d.findViewById(R.id.calllog_detail_main_list);
        m7662a(this.f5224l, this.f5224l);
        this.f5204E = new C1481l(this.f5226n);
        m7684f();
    }

    /* renamed from: f */
    private void m7684f() {
        this.f5218e = (ImageView) this.f5217d.findViewById(R.id.profile_image);
        f5199k = (CallLogDetailInfoLayout) this.f5217d.findViewById(R.id.calllog_detail_info);
        this.f5223j = (LinearLayout) this.f5217d.findViewById(R.id.btn_calllog);
        this.f5219f = (ImageButton) this.f5217d.findViewById(R.id.profile_v_voice);
        this.f5220g = (ImageButton) this.f5217d.findViewById(R.id.profile_v_video);
        this.f5219f.setNextFocusUpId(f5199k.findViewById(R.id.btn_add_group).getId());
        this.f5220g.setNextFocusUpId(f5199k.findViewById(R.id.btn_add_group).getId());
        this.f5235w = (ImageButton) this.f5217d.findViewById(R.id.profile_chat);
        this.f5221h = (ImageButton) this.f5217d.findViewById(R.id.profile_contact);
        this.f5236x = (ImageButton) this.f5217d.findViewById(R.id.profile_broadcast);
        this.f5238z = this.f5217d.findViewById(R.id.profile_broadcast_divider);
        this.f5200A = this.f5217d.findViewById(R.id.profile_contact_divider);
        m7694l();
        if (this.f5231s) {
            m7688h();
        }
        m7693k();
        m7685g();
        this.f5219f.setOnClickListener(this);
        this.f5220g.setOnClickListener(this);
        this.f5235w.setOnClickListener(this);
        this.f5221h.setOnClickListener(this);
        this.f5236x.setOnClickListener(this);
    }

    /* renamed from: g */
    private void m7685g() {
        List<String> listM7675c = m7675c(this.f5226n.userInfo.get(0).f5183i);
        if (listM7675c.size() > 0 && !this.f5231s) {
            this.f5208I = "+" + listM7675c.get(0);
            this.f5221h.setVisibility(0);
            this.f5200A.setVisibility(0);
        } else {
            this.f5221h.setVisibility(8);
            this.f5200A.setVisibility(8);
        }
    }

    /* renamed from: h */
    private void m7688h() {
        if (this.f5230r) {
            f5199k.m7708a(10);
            this.f5234v = 10;
        } else {
            f5199k.m7708a(11);
            this.f5234v = 11;
        }
        this.f5235w.setVisibility(0);
        this.f5236x.setVisibility(0);
        this.f5238z.setVisibility(0);
    }

    /* renamed from: i */
    private void m7690i() {
        if (this.f5235w == null || this.f5237y == null || this.f5229q) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m7692j() {
        this.f5203D = this.f5201B.m7578a(m7699q(), true);
        if (this.f5203D == null || this.f5203D.isEmpty()) {
            ((InterfaceC1479j) getActivity()).mo7657h();
        }
        HashMap<Set<String>, String> mapM7580a = this.f5201B.m7580a();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i <= this.f5203D.size(); i++) {
            arrayList.add(false);
        }
        C1458a c1458a = new C1458a(getActivity(), 0, this.f5203D, mapM7580a, this.f5214a, this.f5204E, arrayList, null);
        this.f5222i.setAdapter((ListAdapter) c1458a);
        this.f5222i.setItemsCanFocus(false);
        c1458a.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m7693k() {
        C4904y.m18639b("setDisplayUpdate()", getClass().getSimpleName());
        m7694l();
        m7695m();
        m7696n();
        m7690i();
    }

    /* renamed from: l */
    private void m7694l() {
        if (this.f5226n.groupcallkey != null) {
            this.f5225m = m7660a(this.f5201B.m7580a(), this.f5226n.userInfo, this.f5226n);
            if (this.f5225m == null || this.f5225m.equals("")) {
                getActivity().setTitle(this.f5202C.m7616b(this.f5226n));
            } else {
                getActivity().setTitle(this.f5225m + " (" + this.f5226n.userInfo.size() + ")");
            }
            m7701s();
        } else if (this.f5202C.m7616b(this.f5226n).equals(this.f5226n.userInfo.get(0).f5175a)) {
            getActivity().setTitle(this.f5226n.userInfo.get(0).f5177c);
        } else {
            getActivity().setTitle(this.f5202C.m7616b(this.f5226n));
        }
        if (this.f5225m != null) {
            this.f5230r = true;
        }
    }

    /* renamed from: a */
    public static String m7660a(HashMap<Set<String>, String> map, List<C1455c> list, CallLogData callLogData) {
        return C1452a.m7605a().m7613a(callLogData, map, list);
    }

    /* renamed from: m */
    private void m7695m() {
    }

    /* renamed from: n */
    private void m7696n() {
        C4904y.m18639b("setBuddyDisplayUpdate()mBuddyType" + this.f5234v, getClass().getSimpleName());
        switch (this.f5234v) {
            case 0:
                C4855bt.m18351a(getActivity()).m18360a(this.f5218e, this.f5226n.userInfo.get(0).f5175a.toString());
                this.f5223j.setVisibility(0);
                break;
            case 1:
            case 2:
            case 3:
            case 4:
                this.f5223j.setVisibility(8);
                break;
            case 10:
            case 11:
                if (this.f5225m != null) {
                    C4855bt.m18351a(getActivity()).m18367b(this.f5218e, this.f5225m);
                } else {
                    this.f5218e.setImageResource(R.drawable.profile_photo_group_default);
                }
                this.f5229q = true;
                break;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        int i = 0;
        menu.clear();
        switch (this.f5234v) {
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
                ((InterfaceC1479j) getActivity()).mo7657h();
                break;
            case R.id.menu_calllog_delete /* 2131166679 */:
                if (this.f5226n.groupcallkey == null) {
                    Intent intent = new Intent().setClass(getActivity(), DeleteCallLogActivity.class);
                    intent.putExtra("calllogdata", this.f5226n);
                    intent.putExtra("from_intent", 3);
                    intent.setFlags(MotionRecognitionManager.EVENT_OVER_TURN_LOW_POWER);
                    intent.addFlags(536870912);
                    startActivityForResult(intent, 1);
                    getActivity().mo51u_();
                    break;
                } else {
                    AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(getActivity());
                    String string = getString(R.string.create_delete_msg_dialog_title);
                    String string2 = getString(R.string.calllog_all_delete);
                    abstractC4932aM18733a.mo18740a(string);
                    abstractC4932aM18733a.mo18749b(string2);
                    abstractC4932aM18733a.mo18756d(R.string.alert_dialog_ok, new DialogInterfaceOnClickListenerC1471b(this));
                    abstractC4932aM18733a.mo18747b(R.string.cancel, new DialogInterfaceOnClickListenerC1472c(this));
                    abstractC4932aM18733a.mo18751b(true);
                    abstractC4932aM18733a.mo18737a(new DialogInterfaceOnCancelListenerC1473d(this));
                    abstractC4932aM18733a.mo18745a().show();
                    break;
                }
            case R.id.menu_calllog_show_member /* 2131166680 */:
                Intent intent2 = new Intent();
                intent2.setClass(getActivity(), ShowConferenceMemberList.class);
                intent2.putExtra("calllogdata", this.f5226n);
                intent2.putExtra("searchtype", this.f5228p);
                intent2.putExtra("order", this.f5213N);
                intent2.putExtra("makecall", false);
                startActivityForResult(intent2, 200);
                getActivity().mo51u_();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public Context m7697o() {
        return getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m7698p() {
        int iM7582b;
        m7674b("addDuplicatedCallLog()");
        if (this.f5232t && this.f5233u != (iM7582b = this.f5201B.m7582b())) {
            this.f5232t = false;
            CallLogDBData callLogDBData = new CallLogDBData();
            callLogDBData._id = iM7582b;
            CallLogData callLogData = this.f5201B.m7577a(callLogDBData, false).get(0);
            if ((this.f5226n.userInfo.get(0).f5175a.equals(callLogData.userInfo.get(0).f5175a) || this.f5226n.groupcallkey != null) && ((this.f5226n.userInfo.get(0).f5186l == callLogData.userInfo.get(0).f5186l || ((this.f5226n.userInfo.get(0).f5186l == 0 && callLogData.userInfo.get(0).f5186l == 1) || (this.f5226n.userInfo.get(0).f5186l == 1 && callLogData.userInfo.get(0).f5186l == 0))) && (this.f5226n.callmethod == callLogData.callmethod || ((this.f5226n.callmethod > 3 && callLogData.callmethod > 3) || (this.f5226n.callmethod < 3 && callLogData.callmethod < 3))))) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(iM7582b));
                m7674b("add calllog!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                this.f5226n.totalIDList.add(arrayList);
            }
        }
        m7692j();
    }

    /* renamed from: q */
    private ArrayList<Integer> m7699q() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f5233u = this.f5201B.m7582b();
        Iterator<List<Integer>> it = this.f5226n.totalIDList.iterator();
        while (it.hasNext()) {
            for (Integer num : it.next()) {
                if (this.f5233u == num.intValue()) {
                    this.f5232t = true;
                }
                arrayList.add(num);
            }
        }
        return arrayList;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m7674b("onResume()");
        if (this.f5227o) {
            ArrayList<CallLogData> arrayListM7575a = this.f5201B.m7575a(this.f5228p, true);
            if (arrayListM7575a.size() > 0 && arrayListM7575a.get(1).userInfo.get(0).f5175a.equals(this.f5226n.userInfo.get(0).f5175a)) {
                this.f5226n = arrayListM7575a.get(1);
                C1457a.m7650a().m7652a(1000);
            }
        }
        m7700r();
        m7692j();
        this.f5214a.sendEmptyMessage(8000);
    }

    /* renamed from: r */
    private void m7700r() {
        String strM7711a = CallLogFragment.m7711a(getActivity());
        String strM7720b = CallLogFragment.m7720b(getActivity());
        if (strM7711a == null || !strM7711a.equals("24")) {
            C1458a.m7791b(false);
        } else {
            C1458a.m7791b(true);
        }
        if (strM7720b != null) {
            if (strM7720b.equals("MM-dd-yyyy")) {
                C1458a.m7789a(0);
                return;
            } else if (strM7720b.equals("dd-MM-yyyy")) {
                C1458a.m7789a(1);
                return;
            } else {
                if (strM7720b.equals("yyyy-MM-dd")) {
                    C1458a.m7789a(2);
                    return;
                }
                return;
            }
        }
        C1458a.m7789a(0);
    }

    /* renamed from: a */
    private boolean m7669a(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras.getBoolean("updateUIAfterCall", false)) {
            this.f5227o = true;
        }
        this.f5228p = extras.getInt("searchtype", 0);
        if (extras.getBoolean("normal")) {
            m7674b("normal");
            this.f5226n = (CallLogData) extras.getParcelable("calllogdata");
            this.f5213N = extras.getInt("order", 0);
            if (this.f5226n == null) {
                m7674b("mCallLog is NULL");
                return false;
            }
        } else if (extras.getBoolean("rejected_call")) {
            m7674b("rejected call");
            this.f5226n = this.f5201B.m7579a(true).get(1);
            if (this.f5226n == null) {
                m7674b("mCallLog is NULL");
                return false;
            }
        } else if (extras.getBoolean("missed_call")) {
            this.f5226n = m7659a(this.f5201B);
            if (this.f5226n == null) {
                return false;
            }
            this.f5228p = 5;
        }
        return true;
    }

    /* renamed from: a */
    private static CallLogData m7659a(HandlerC1449a handlerC1449a) {
        ArrayList<CallLogData> arrayListM7584b = handlerC1449a.m7584b(true);
        CallLogData callLogData = null;
        if (arrayListM7584b.isEmpty()) {
            C4904y.m18639b("getMissedCallLog missed_call:CallLogList is Empty", CallLogDetailActivity.class.getSimpleName());
        } else {
            callLogData = arrayListM7584b.get(1);
            if (callLogData == null) {
                C4904y.m18639b("getMissedCallLog callLog is NULL", CallLogDetailActivity.class.getSimpleName());
            }
        }
        return callLogData;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        CallLogData callLogDataM7658a;
        super.onActivityResult(i, i2, intent);
        if ((i == 1 || i == 200) && i2 != -1) {
            C1458a.m7790a(false);
            return;
        }
        m7674b("onActivityResult()");
        if (i == 1) {
            m7674b("DELETE_RESULT");
            if (true == intent.getExtras().getBoolean("DELETE_DETAIL_CALLLOG_ALL")) {
                ((InterfaceC1479j) getActivity()).mo7657h();
                return;
            } else {
                m7693k();
                return;
            }
        }
        if (i == 200) {
            m7674b("SELECT_GROUP_LIST");
            if (true == intent.getExtras().getBoolean("MEMBERS_LIST_CHANGE_BUDDY_INFO") && (callLogDataM7658a = m7658a(this.f5213N, this.f5228p, this.f5201B)) != null) {
                this.f5226n = callLogDataM7658a;
                m7678d();
                return;
            }
            return;
        }
        if (i == 2) {
            if (C4904y.f17872b) {
                C4904y.m18639b("get ADDGROUP_RESULT", "CallLogDetailActivity");
            }
            CallLogData callLogDataM7658a2 = m7658a(this.f5213N, this.f5228p, this.f5201B);
            if (callLogDataM7658a2 != null) {
                this.f5226n = callLogDataM7658a2;
                m7678d();
                m7694l();
                if (this.f5231s) {
                    m7688h();
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.profile_chat /* 2131165406 */:
                m7668a(this.f5229q, false);
                break;
            case R.id.profile_broadcast /* 2131165408 */:
                m7668a(this.f5229q, true);
                break;
            case R.id.profile_v_voice /* 2131165410 */:
                if (this.f5229q) {
                    C4904y.m18639b("onClick() profile_v_voice group", getClass().getSimpleName());
                    startActivityForResult(new Intent().setClass(getActivity(), ShowConferenceMemberList.class).putExtra("calllogdata", this.f5226n).putExtra("searchtype", this.f5228p).putExtra("order", this.f5213N).putExtra("makecall", true).putExtra("groupName", this.f5225m).putExtra("from_intent", 0).setFlags(MotionRecognitionManager.EVENT_OVER_TURN_LOW_POWER).addFlags(536870912), 200);
                    break;
                } else {
                    C4904y.m18639b("onClick() profile_v_voice", getClass().getSimpleName());
                    m7667a(false);
                    break;
                }
            case R.id.profile_v_video /* 2131165412 */:
                if (this.f5229q) {
                    C4904y.m18639b("onClick() profile_v_video group", getClass().getSimpleName());
                    startActivityForResult(new Intent().setClass(getActivity(), ShowConferenceMemberList.class).putExtra("calllogdata", this.f5226n).putExtra("searchtype", this.f5228p).putExtra("order", this.f5213N).putExtra("makecall", true).putExtra("groupName", this.f5225m).putExtra("from_intent", 1).setFlags(MotionRecognitionManager.EVENT_OVER_TURN_LOW_POWER).addFlags(536870912), 200);
                    break;
                } else {
                    m7667a(true);
                    break;
                }
            case R.id.profile_contact /* 2131165414 */:
                m7680d(this.f5208I);
                break;
        }
    }

    /* renamed from: a */
    private void m7668a(boolean z, boolean z2) {
        Intent intentM3014a = TabActivity.m3014a(getActivity());
        intentM3014a.putExtra("callChatList", true);
        if (!z) {
            intentM3014a.putExtra("receivers", new String[]{this.f5226n.userInfo.get(0).f5175a});
        } else {
            new ArrayList();
            intentM3014a.putExtra("receivers", (String[]) m7661a(this.f5226n).toArray(new String[0]));
        }
        if (z2) {
            intentM3014a.putExtra("chatType", EnumC2300t.BROADCAST.m10210a());
        } else if (!z) {
            intentM3014a.putExtra("chatType", EnumC2300t.ONETOONE.m10210a());
        } else {
            intentM3014a.putExtra("chatType", EnumC2300t.GROUPCHAT.m10210a());
        }
        startActivity(intentM3014a);
    }

    /* renamed from: s */
    private void m7701s() {
    }

    /* renamed from: a */
    public static ArrayList<String> m7661a(CallLogData callLogData) {
        ArrayList<String> arrayList = new ArrayList<>();
        CallLogData callLogDataM7670b = m7670b(callLogData);
        if (callLogDataM7670b == null) {
            return arrayList;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= callLogDataM7670b.userInfo.size()) {
                return arrayList;
            }
            arrayList.add(callLogDataM7670b.userInfo.get(i2).f5175a);
            i = i2 + 1;
        }
    }

    /* renamed from: b */
    public static CallLogData m7670b(CallLogData callLogData) {
        if (callLogData != null && callLogData.userInfo.size() > 1) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < callLogData.userInfo.size() - 1) {
                    for (int size = callLogData.userInfo.size() - 1; size > i2; size--) {
                        if (callLogData.userInfo.get(i2).f5175a.equals(callLogData.userInfo.get(size).f5175a)) {
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
    public static CallLogData m7658a(int i, int i2, HandlerC1449a handlerC1449a) {
        if (i2 == 5) {
            CallLogData callLogDataM7659a = m7659a(handlerC1449a);
            C4904y.m18639b("updateBuddyInfo() with missed call", CallLogDetailActivity.class.getSimpleName());
            return callLogDataM7659a;
        }
        if (i < 0) {
            return null;
        }
        CallLogData callLogData = handlerC1449a.m7575a(i2, true).get(i);
        C4904y.m18639b("updateBuddyInfo() normal case", CallLogDetailActivity.class.getSimpleName());
        return callLogData;
    }

    /* renamed from: a */
    private void m7667a(boolean z) {
        int iM1487a;
        if (z) {
            iM1487a = this.f5206G.m1487a(getActivity(), true, this.f5226n.userInfo.get(0).f5175a, C4809aa.m18104a().m18121a("Push Name", ""), null);
        } else {
            iM1487a = this.f5206G.m1487a(getActivity(), false, this.f5226n.userInfo.get(0).f5175a, C4809aa.m18104a().m18121a("Push Name", ""), null);
        }
        if (iM1487a != 0) {
            C5179v.m19810a(getActivity(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        m7674b("onConfigurationChanged()");
        if (f5199k != null) {
            f5199k.setBtnTextUpdate();
        }
        C4904y.m18641c("YKYU onConfigurationChanged()", "");
        if (configuration.orientation == 1) {
            C4904y.m18641c("YKYU onConfigurationChanged()  ORIENTATION_PORTRAIT is called!!!!!!!!", "");
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        if (f5199k != null) {
            f5199k.m7707a();
        }
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private void m7662a(View view, View view2) {
        if (Build.VERSION.SDK_INT >= 14) {
            if (view != null || view2 != null) {
                view.setOnHoverListener(new ViewOnHoverListenerC1474e(this, view, view2));
            }
        }
    }

    /* renamed from: c */
    private List<String> m7675c(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, "|");
            while (stringTokenizer.hasMoreTokens()) {
                new String();
                String strNextToken = stringTokenizer.nextToken();
                if (strNextToken.length() >= 19 && strNextToken.startsWith("10")) {
                    C4904y.m18639b("chaton id : " + strNextToken, "CallLogDetailActivity");
                } else if (strNextToken.startsWith(Spam.ACTIVITY_CANCEL)) {
                    C4904y.m18639b("pin number : " + strNextToken, "CallLogDetailActivity");
                } else {
                    C4904y.m18639b("msisdn: " + strNextToken, "CallLogDetailActivity");
                    arrayList.add(strNextToken);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d4  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m7705a(java.lang.String r10) throws java.lang.Throwable {
        /*
            r9 = this;
            r7 = 1
            r8 = 0
            r6 = 0
            java.lang.String r0 = "[contactSavedCheck] Contact Saved Find Start"
            java.lang.String r1 = "CallLogDetailActivity"
            com.sec.chaton.util.C4904y.m18639b(r0, r1)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc4
            android.net.Uri r0 = android.provider.ContactsContract.PhoneLookup.CONTENT_FILTER_URI     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc4
            java.lang.String r1 = android.net.Uri.encode(r10)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc4
            android.net.Uri r1 = android.net.Uri.withAppendedPath(r0, r1)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc4
            android.support.v4.app.FragmentActivity r0 = r9.getActivity()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc4
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc4
            r2 = 3
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc4
            r3 = 0
            java.lang.String r4 = "display_name"
            r2[r3] = r4     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc4
            r3 = 1
            java.lang.String r4 = "number"
            r2[r3] = r4     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc4
            r3 = 2
            java.lang.String r4 = "_id"
            r2[r3] = r4     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc4
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc4
            if (r1 == 0) goto Ld4
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> Lcc java.lang.Exception -> Lce
            if (r0 <= 0) goto Ld4
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Throwable -> Lcc java.lang.Exception -> Lce
            if (r0 == 0) goto Ld4
            java.lang.String r0 = "_id"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> Lcc java.lang.Exception -> Ld1
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> Lcc java.lang.Exception -> Ld1
            r9.f5207H = r0     // Catch: java.lang.Throwable -> Lcc java.lang.Exception -> Ld1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lcc java.lang.Exception -> Ld1
            r0.<init>()     // Catch: java.lang.Throwable -> Lcc java.lang.Exception -> Ld1
            java.lang.String r2 = "[contactSavedCheck] Found in Contact Number : "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Lcc java.lang.Exception -> Ld1
            java.lang.StringBuilder r0 = r0.append(r10)     // Catch: java.lang.Throwable -> Lcc java.lang.Exception -> Ld1
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lcc java.lang.Exception -> Ld1
            java.lang.String r2 = "CallLogDetailActivity"
            com.sec.chaton.util.C4904y.m18639b(r0, r2)     // Catch: java.lang.Throwable -> Lcc java.lang.Exception -> Ld1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lcc java.lang.Exception -> Ld1
            r0.<init>()     // Catch: java.lang.Throwable -> Lcc java.lang.Exception -> Ld1
            java.lang.String r2 = "[contactSavedCheck] ContactSaved id : "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Lcc java.lang.Exception -> Ld1
            int r2 = r9.f5207H     // Catch: java.lang.Throwable -> Lcc java.lang.Exception -> Ld1
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Lcc java.lang.Exception -> Ld1
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lcc java.lang.Exception -> Ld1
            java.lang.String r2 = "CallLogDetailActivity"
            com.sec.chaton.util.C4904y.m18639b(r0, r2)     // Catch: java.lang.Throwable -> Lcc java.lang.Exception -> Ld1
        L8b:
            if (r1 == 0) goto L90
            r1.close()
        L90:
            if (r7 != 0) goto Lae
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "[contactSavedCheck] No PhoneNumber in Contact : "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "CallLogDetailActivity"
            com.sec.chaton.util.C4904y.m18639b(r0, r1)
            r9.f5207H = r8
        Lae:
            return r7
        Laf:
            r0 = move-exception
            r1 = r6
            r2 = r8
        Lb2:
            java.lang.Class r3 = r9.getClass()     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r3 = r3.getSimpleName()     // Catch: java.lang.Throwable -> Lcc
            com.sec.chaton.util.C4904y.m18635a(r0, r3)     // Catch: java.lang.Throwable -> Lcc
            if (r1 == 0) goto Lc2
            r1.close()
        Lc2:
            r7 = r2
            goto L90
        Lc4:
            r0 = move-exception
            r1 = r6
        Lc6:
            if (r1 == 0) goto Lcb
            r1.close()
        Lcb:
            throw r0
        Lcc:
            r0 = move-exception
            goto Lc6
        Lce:
            r0 = move-exception
            r2 = r8
            goto Lb2
        Ld1:
            r0 = move-exception
            r2 = r7
            goto Lb2
        Ld4:
            r7 = r8
            goto L8b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.calllog.view.CallLogDetailFragment.m7705a(java.lang.String):boolean");
    }

    /* renamed from: d */
    private void m7680d(String str) {
        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        if (!m7705a(str)) {
            Bundle bundle = new Bundle();
            bundle.putString("phone", str);
            bundle.putString("name", this.f5226n.userInfo.get(0).f5177c);
            C4904y.m18639b("phoneNum: " + str, "CallLogDetailActivity");
            C4904y.m18639b("NAME: " + this.f5226n.userInfo.get(0).f5177c, "CallLogDetailActivity");
            Intent intent = new Intent("android.intent.action.INSERT", uri);
            intent.putExtras(bundle);
            intent.putExtra("return-data", true);
            try {
                startActivity(intent);
                return;
            } catch (ActivityNotFoundException e) {
                C4904y.m18635a(e, getClass().getSimpleName());
                C5179v.m19810a(getActivity(), R.string.toast_contact_not_found, 0).show();
                return;
            }
        }
        long j = 0 == 0 ? this.f5207H : 0L;
        C4904y.m18639b("id: " + j, "CallLogDetailActivity");
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse(uri + "/" + j));
        try {
            startActivity(intent2);
        } catch (ActivityNotFoundException e2) {
            C4904y.m18635a(e2, getClass().getSimpleName());
            C5179v.m19810a(getActivity(), R.string.toast_contact_not_found, 0).show();
        }
    }

    /* renamed from: a */
    public void m7704a() {
        C1106c c1106c = new C1106c(this.f5226n.userInfo.get(0).f5175a, this.f5202C.m7616b(this.f5226n));
        this.f5211L = c1106c;
        m7702t();
        C2128i c2128i = new C2128i(this.f5215b);
        this.f5212M = c1106c.m7051b();
        c2128i.m9508b(c1106c.m7046a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public void m7702t() {
        if (this.f5209J == null) {
            this.f5209J = ProgressDialogC4926s.m18728a(getActivity(), null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
        } else {
            this.f5209J.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public void m7703u() {
        if (this.f5209J != null) {
            this.f5209J.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7666a(CharSequence charSequence) {
        if (this.f5210K == null) {
            this.f5210K = C5179v.m19811a(getActivity(), (CharSequence) null, 0);
        }
        this.f5210K.setText(charSequence);
        this.f5210K.show();
    }
}
