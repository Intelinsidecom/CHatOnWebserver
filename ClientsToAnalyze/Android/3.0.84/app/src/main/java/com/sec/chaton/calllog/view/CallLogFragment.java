package com.sec.chaton.calllog.view;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.sso.p006a.C0045a;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyGroupProfileActivity;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.p019a.C0512b;
import com.sec.chaton.calllog.common.view.layout.ButtonTwoDialog;
import com.sec.chaton.calllog.common.view.layout.RadioButtonListDialog;
import com.sec.chaton.calllog.manager.HandlerC0838a;
import com.sec.chaton.calllog.manager.model.C0844c;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.calllog.manager.model.SeperatorCallLog;
import com.sec.chaton.calllog.manager.noti.C0846a;
import com.sec.chaton.calllog.manager.p022b.C0841a;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.chat.ChatInfoMoreActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p027e.p028a.C1362f;
import com.sec.chaton.settings.ActivityWebView;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class CallLogFragment extends Fragment implements AdapterView.OnItemClickListener, CompoundButton.OnCheckedChangeListener {

    /* renamed from: g */
    public C0045a f3291g;

    /* renamed from: j */
    private LinearLayout f3293j;

    /* renamed from: k */
    private ImageView f3294k;

    /* renamed from: l */
    private TextView f3295l;

    /* renamed from: m */
    private TextView f3296m;

    /* renamed from: r */
    private List<Boolean> f3301r;

    /* renamed from: s */
    private ArrayList<CallLogData> f3302s;

    /* renamed from: t */
    private HashMap<Set<String>, String> f3303t;

    /* renamed from: v */
    private DialogFragment f3305v;

    /* renamed from: a */
    public static String f3283a = null;

    /* renamed from: b */
    public static String f3284b = null;

    /* renamed from: i */
    private static int f3289i = 0;

    /* renamed from: c */
    public static C0847a f3285c = null;

    /* renamed from: d */
    public static int f3286d = 0;

    /* renamed from: e */
    public static int f3287e = 0;

    /* renamed from: f */
    public static final HandlerC0838a f3288f = new HandlerC0838a();

    /* renamed from: B */
    private static String f3282B = null;

    /* renamed from: n */
    private Context f3297n = null;

    /* renamed from: o */
    private HandlerC0879s f3298o = new HandlerC0879s(this, null);

    /* renamed from: p */
    private View f3299p = null;

    /* renamed from: q */
    private ListView f3300q = null;

    /* renamed from: u */
    private int f3304u = -1;

    /* renamed from: w */
    private final C0841a f3306w = C0841a.m4451a();

    /* renamed from: x */
    private final C0882v f3307x = new C0882v();

    /* renamed from: y */
    private Dialog f3308y = null;

    /* renamed from: z */
    private int f3309z = -1;

    /* renamed from: A */
    private ProgressDialog f3290A = null;

    /* renamed from: h */
    public Handler f3292h = new HandlerC0878r(this);

    /* renamed from: b */
    private void m4567b(String str) {
        C3250y.m11442a(str, "[CallLogFragment]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m4570c(String str) {
        C3250y.m11453c(str, "[CallLogFragment]");
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3291g = new C0045a();
        f3289i = 0;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m4570c("<<YHT99>> onResume() called!!");
        C0846a.m4496a().m4497a(1000);
        f3288f.m4427a(this.f3298o);
        m4576g();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    /* renamed from: a */
    public static String m4556a(Context context) {
        if (DateFormat.is24HourFormat(context)) {
            return "24";
        }
        return "12";
    }

    /* renamed from: b */
    public static String m4565b(Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] dateFormatOrder = DateFormat.getDateFormatOrder(context);
        if (dateFormatOrder != null && dateFormatOrder.length > 0) {
            for (int i = 0; i < dateFormatOrder.length; i++) {
                if (dateFormatOrder[i] == 'y') {
                    stringBuffer.append("yyyy-");
                }
                if (dateFormatOrder[i] == 'M') {
                    stringBuffer.append("MM-");
                }
                if (dateFormatOrder[i] == 'd') {
                    stringBuffer.append("dd-");
                }
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m4570c("onCreateView()");
        this.f3299p = layoutInflater.inflate(R.layout.calllog_list, viewGroup, false);
        this.f3297n = getActivity();
        C0847a.m4634a(false);
        f3283a = m4556a(this.f3297n);
        f3284b = m4565b(this.f3297n);
        if (f3283a == null || !f3283a.equals("24")) {
            C0847a.m4635b(false);
        } else {
            C0847a.m4635b(true);
        }
        if (f3284b == null || f3284b.equals("MM-dd-yyyy")) {
            C0847a.m4633a(0);
        } else if (f3284b.equals("dd-MM-yyyy")) {
            C0847a.m4633a(1);
        } else if (f3284b.equals("yyyy-MM-dd")) {
            C0847a.m4633a(2);
        }
        this.f3300q = (ListView) this.f3299p.findViewById(R.id.calllog_list);
        m4575f();
        m4571d();
        m4580a();
        this.f3300q.setOnItemClickListener(this);
        setHasOptionsMenu(true);
        registerForContextMenu(this.f3300q);
        return this.f3299p;
    }

    /* renamed from: d */
    private void m4571d() {
        this.f3293j = (LinearLayout) this.f3299p.findViewById(R.id.calllog_empty);
        this.f3294k = (ImageView) this.f3293j.findViewById(R.id.image1);
        this.f3294k.setImageResource(R.drawable.no_contents_calllog);
        this.f3295l = (TextView) this.f3293j.findViewById(R.id.text1);
        this.f3295l.setText(getResources().getString(R.string.calllog_no_title));
        this.f3296m = (TextView) this.f3293j.findViewById(R.id.text2);
        this.f3296m.setText(getResources().getString(R.string.calllog_no_data));
        this.f3293j.setVisibility(8);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        m4567b("onItemClick+position: " + i);
        m4581a(i);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (this.f3302s.isEmpty()) {
            menuInflater.inflate(R.menu.calllog_menu_no_list, menu);
        } else {
            menuInflater.inflate(R.menu.calllog_menu, menu);
        }
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                C0847a.m4634a(false);
                ((InterfaceC0880t) getActivity()).mo4502c();
                break;
            case R.id.menu_calllog_delete /* 2131166598 */:
                if (this.f3302s.isEmpty()) {
                    Toast.makeText(getActivity(), getString(R.string.calllog_no_title), 0).show();
                } else {
                    Intent intent = new Intent().setClass(getActivity(), DeleteCallLogActivity.class);
                    intent.putExtra("from_intent", 2);
                    startActivityForResult(intent, 1);
                }
                getActivity().supportInvalidateOptionsMenu();
                break;
            case R.id.menu_calllog_view_by /* 2131166600 */:
                m4582b(1);
                getActivity().supportInvalidateOptionsMenu();
                break;
            case R.id.menu_calllog_data_usage /* 2131166601 */:
                Intent intentM57f = new C0045a().m57f(getActivity());
                if (intentM57f != null) {
                    startActivity(intentM57f);
                    getActivity().supportInvalidateOptionsMenu();
                    break;
                }
                break;
            case R.id.menu_calllog_help /* 2131166602 */:
                Intent intent2 = new Intent(getActivity(), (Class<?>) ActivityWebView.class);
                intent2.putExtra("PARAM_MENU", "Help");
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* renamed from: a */
    public static int m4554a(C0844c c0844c) {
        int i = 0;
        if (c0844c.f3207c == null) {
            i = 4;
        }
        C3250y.m11450b("setBuddyType [" + i + "]", CallLogActivity.class.getSimpleName());
        return i;
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        MenuInflater menuInflater = getActivity().getMenuInflater();
        CallLogData callLogData = this.f3302s.get(m4579a(contextMenuInfo));
        if (!(callLogData instanceof SeperatorCallLog)) {
            if (callLogData.groupcallkey == null) {
                switch (m4554a(callLogData.userInfo.get(0))) {
                    case 0:
                        menuInflater.inflate(R.menu.calllog_contextual_menu_buddy, contextMenu);
                        contextMenu.setHeaderTitle(this.f3306w.m4461b(callLogData));
                        break;
                    case 1:
                        menuInflater.inflate(R.menu.calllog_contextual_menu_hided_buddy, contextMenu);
                        contextMenu.setHeaderTitle(this.f3306w.m4461b(callLogData));
                        break;
                    case 2:
                    case 4:
                        menuInflater.inflate(R.menu.calllog_contextual_menu_unsaved_buddy, contextMenu);
                        contextMenu.setHeaderTitle(this.f3306w.m4461b(callLogData));
                        break;
                    case 3:
                        menuInflater.inflate(R.menu.calllog_contextual_menu_unsaved_buddy, contextMenu);
                        contextMenu.setHeaderTitle(this.f3306w.m4461b(callLogData));
                        break;
                }
            } else {
                String strM4458a = this.f3306w.m4458a(callLogData, this.f3303t, callLogData.userInfo);
                if (strM4458a == null || strM4458a.isEmpty()) {
                    menuInflater.inflate(R.menu.calllog_contextual_menu_unsaved_group, contextMenu);
                    contextMenu.setHeaderTitle(this.f3306w.m4461b(callLogData));
                } else {
                    menuInflater.inflate(R.menu.calllog_contextual_menu_group, contextMenu);
                    contextMenu.setHeaderTitle(strM4458a);
                }
            }
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            m4574e();
        }
    }

    /* renamed from: e */
    private void m4574e() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        getActivity().dispatchTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, -1.0f, -1.0f, 0));
    }

    @Override // android.support.v4.app.Fragment
    public boolean onContextItemSelected(MenuItem menuItem) {
        int iM4579a = m4579a(menuItem.getMenuInfo());
        CallLogData callLogData = this.f3302s.get(iM4579a);
        String str = callLogData.userInfo.get(0).f3207c;
        String str2 = callLogData.userInfo.get(0).f3205a;
        ArrayList arrayList = new ArrayList();
        switch (menuItem.getItemId()) {
            case R.id.menu_calllog_voice_call /* 2131166591 */:
                if (callLogData.userInfo.size() > 1) {
                    startActivity(new Intent().setClass(getActivity(), ShowConferenceMemberList.class).putExtra("calllogdata", callLogData).putExtra("searchtype", f3289i).putExtra("order", iM4579a).putExtra("makecall", true).putExtra("groupName", CallLogDetailFragment.m4506a(f3288f.m4426a(), callLogData.userInfo, callLogData)).putExtra("from_intent", 0).setFlags(131072).addFlags(536870912));
                    break;
                } else {
                    m4570c("single voice call start!!");
                    m4562a(str2, false);
                    break;
                }
            case R.id.menu_calllog_video_call /* 2131166592 */:
                if (callLogData.userInfo.size() > 1) {
                    startActivity(new Intent().setClass(getActivity(), ShowConferenceMemberList.class).putExtra("calllogdata", callLogData).putExtra("searchtype", f3289i).putExtra("order", iM4579a).putExtra("makecall", true).putExtra("groupName", CallLogDetailFragment.m4506a(f3288f.m4426a(), callLogData.userInfo, callLogData)).putExtra("from_intent", 1).setFlags(131072).addFlags(536870912));
                    break;
                } else {
                    m4570c("single video call start!!");
                    m4562a(str2, true);
                    break;
                }
            case R.id.menu_calllog_delete_contextual /* 2131166593 */:
                AbstractC3271a.m11494a(getActivity()).mo11500a(getResources().getString(R.string.create_delete_msg_dialog_title)).mo11509b(getResources().getString(R.string.calllog_delete)).mo11510b(getResources().getString(R.string.alert_dialog_ok), new DialogInterfaceOnClickListenerC0874n(this, iM4579a)).mo11501a(getResources().getString(R.string.my_profile_question_cancel), new DialogInterfaceOnClickListenerC0873m(this)).mo11512b();
                break;
            case R.id.menu_calllog_detail /* 2131166594 */:
                Intent intent = new Intent(this.f3297n, (Class<?>) BuddyProfileActivity.class);
                intent.putExtra("PROFILE_BUDDY_NO", callLogData.userInfo.get(0).f3205a);
                intent.putExtra("PROFILE_BUDDY_NAME", this.f3306w.m4461b(callLogData));
                this.f3297n.startActivity(intent);
                break;
            case R.id.menu_calllog_view_group_profile /* 2131166595 */:
                arrayList.clear();
                ArrayList<String> arrayListM4507a = CallLogDetailFragment.m4507a(callLogData);
                String strM4458a = this.f3306w.m4458a(callLogData, f3288f.m4426a(), callLogData.userInfo);
                C0512b c0512b = new C0512b(C1362f.m6072d(GlobalApplication.m11493l().getContentResolver(), strM4458a), strM4458a, arrayListM4507a == null ? 0 : arrayListM4507a.size(), 2);
                Intent intent2 = new Intent(this.f3297n, (Class<?>) BuddyGroupProfileActivity.class);
                intent2.putExtra("ACTIVITY_PURPOSE", 18);
                intent2.putExtra("groupInfo", c0512b);
                intent2.putExtra("ACTIVITY_ARG_GROUP_MEMBER_NO_LIST", (String[]) arrayListM4507a.toArray(new String[0]));
                intent2.putExtra("GROUP_PROFILE_NAME", strM4458a);
                this.f3297n.startActivity(intent2);
                break;
            case R.id.menu_calllog_add_buddy /* 2131166596 */:
                m4561a(str2, callLogData.userInfo.get(0).f3206b);
                break;
            case R.id.menu_calllog_add_group /* 2131166597 */:
                arrayList.clear();
                ArrayList<String> arrayListM4507a2 = CallLogDetailFragment.m4507a(callLogData);
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < callLogData.userInfo.size(); i++) {
                    arrayList2.add(callLogData.userInfo.get(i).f3206b);
                }
                Intent intent3 = new Intent(this.f3297n, (Class<?>) ChatInfoMoreActivity.class);
                intent3.putExtra("ACTIVITY_PURPOSE", 6);
                intent3.putExtra(ChatFragment.f3489f, (String[]) arrayListM4507a2.toArray(new String[0]));
                intent3.putExtra("member_name", (String[]) arrayList2.toArray(new String[0]));
                intent3.putExtra("ACTIVITY_PURPOSE_ARG", false);
                intent3.putExtra("ACTIVITY_PURPOSE_CALLLOG_GROUP", true);
                startActivity(intent3);
                break;
        }
        return super.onContextItemSelected(menuItem);
    }

    /* renamed from: a */
    public void m4581a(int i) {
        Intent intent = new Intent();
        CallLogData callLogData = this.f3302s.get(i);
        if (!(callLogData instanceof SeperatorCallLog)) {
            intent.setClass(getActivity(), CallLogDetailActivity.class);
            intent.putExtra("normal", true);
            intent.putExtra("calllogdata", callLogData);
            intent.putExtra("searchtype", f3289i);
            intent.putExtra("order", i);
            if (i == 1 && callLogData.groupcallkey == null) {
                intent.putExtra("updateUIAfterCall", true);
            }
            startActivity(intent);
        }
    }

    /* renamed from: a */
    public int m4579a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        return ((AdapterView.AdapterContextMenuInfo) contextMenuInfo).position;
    }

    /* renamed from: f */
    private void m4575f() {
        this.f3300q.setOnScrollListener(new C0875o(this));
    }

    /* renamed from: a */
    public void m4580a() {
        this.f3302s = f3288f.m4421a(f3289i, true);
        this.f3303t = f3288f.m4426a();
        m4567b("<<RDJ>> calllog count: " + f3288f.m4431c());
        m4563a(this.f3302s.isEmpty());
        this.f3301r = new ArrayList();
        for (int i = 0; i <= this.f3302s.size() * 2; i++) {
            this.f3301r.add(false);
        }
        f3285c = new C0847a(this.f3297n, 0, this.f3302s, this.f3303t, this.f3298o, this.f3307x, this.f3301r, null);
        this.f3300q.setAdapter((ListAdapter) f3285c);
        ((ListView) this.f3299p.findViewById(R.id.calllog_list)).setSelectionFromTop(f3286d, f3287e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m4576g() {
        m4570c("handleEventContactUpdateUI()");
        m4580a();
        f3285c.notifyDataSetChanged();
    }

    /* renamed from: b */
    public void m4582b(int i) {
        switch (i) {
            case 1:
                RadioButtonListDialog.m4384a(getResources().getString(R.string.calllog_view_by_title), f3289i).show(getFragmentManager(), "viewbydialog");
                break;
            case 2:
                this.f3305v = ButtonTwoDialog.m4382a(2, getResources().getString(R.string.menu_buddy_delete), getResources().getString(R.string.group_delete_msg));
                this.f3305v.show(getFragmentManager().beginTransaction(), "groupdeletedialog");
                break;
        }
    }

    /* renamed from: c */
    public void m4583c(int i) {
        f3289i = i;
        this.f3302s = f3288f.m4421a(f3289i, true);
        m4563a(this.f3302s.isEmpty());
        f3285c = new C0847a(this.f3297n, 0, this.f3302s, this.f3303t, this.f3298o, this.f3307x, this.f3301r, null);
        this.f3300q.setAdapter((ListAdapter) f3285c);
        f3285c.notifyDataSetChanged();
    }

    /* renamed from: a */
    private void m4563a(boolean z) {
        getActivity().supportInvalidateOptionsMenu();
        if (z) {
            this.f3300q.setVisibility(8);
            this.f3293j.setVisibility(0);
        } else {
            this.f3300q.setVisibility(0);
            this.f3293j.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4558a(CallLogData callLogData) {
        ArrayList<CallLogData> arrayList = new ArrayList<>();
        arrayList.add(callLogData);
        f3288f.m4429b(arrayList);
    }

    /* renamed from: a */
    private void m4562a(String str, boolean z) {
        int iM47a;
        if (z) {
            iM47a = this.f3291g.m47a(getActivity(), true, str, C3159aa.m10962a().m10979a("Push Name", ""), null);
        } else {
            iM47a = this.f3291g.m47a(getActivity(), false, str, C3159aa.m10962a().m10979a("Push Name", ""), null);
        }
        C3250y.m11450b("Return value from ChatonV= " + iM47a, getClass().getSimpleName());
        if (iM47a != 0) {
            C3641ai.m13210a(getActivity(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        m4570c("onConfigurationChanged()");
        super.onConfigurationChanged(configuration);
        m4576g();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            AbstractC3271a.m11494a(getActivity()).mo11500a(getResources().getString(R.string.create_delete_msg_dialog_title_with_count, Integer.valueOf(this.f3302s.size()))).mo11509b(getResources().getText(R.string.calllog_all_delete)).mo11510b(getResources().getText(R.string.alert_dialog_cancel), new DialogInterfaceOnClickListenerC0877q(this)).mo11501a(getResources().getText(R.string.alert_dialog_ok), new DialogInterfaceOnClickListenerC0876p(this)).mo11512b();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 200) {
        }
    }

    /* renamed from: b */
    public static int m4564b() {
        return f3289i;
    }

    /* renamed from: a */
    private void m4561a(String str, String str2) {
        f3282B = str2;
        C3250y.m11450b("addBuddy() buddyNo[" + str + "]", CallLogActivity.class.getSimpleName());
        m4577h();
        new C1330h(this.f3292h).m5730b(str);
    }

    /* renamed from: h */
    private void m4577h() {
        if (this.f3290A == null) {
            this.f3290A = ProgressDialogC3265l.m11490a(this.f3297n, null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
        } else {
            this.f3290A.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m4578i() {
        if (this.f3290A != null) {
            this.f3290A.dismiss();
        }
    }
}
