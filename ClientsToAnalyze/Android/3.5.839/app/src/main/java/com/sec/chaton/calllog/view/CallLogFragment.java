package com.sec.chaton.calllog.view;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.hardware.motion.MotionRecognitionManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.sso.p030a.C0416a;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyGroupProfileActivity;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.p050a.C1105b;
import com.sec.chaton.calllog.common.view.layout.ButtonTwoDialog;
import com.sec.chaton.calllog.common.view.layout.RadioButtonListDialog;
import com.sec.chaton.calllog.manager.HandlerC1449a;
import com.sec.chaton.calllog.manager.model.C1455c;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.calllog.manager.model.SeperatorCallLog;
import com.sec.chaton.calllog.manager.noti.C1457a;
import com.sec.chaton.calllog.manager.p053b.C1452a;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.chat.ChatInfoMoreActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p057e.p058a.C2191e;
import com.sec.chaton.settings.ActivityWebView;
import com.sec.chaton.settings.FragmentWebView;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class CallLogFragment extends Fragment implements AdapterView.OnItemClickListener, CompoundButton.OnCheckedChangeListener {

    /* renamed from: g */
    public C0416a f5264g;

    /* renamed from: j */
    private ViewStub f5266j;

    /* renamed from: k */
    private View f5267k;

    /* renamed from: l */
    private ImageView f5268l;

    /* renamed from: m */
    private TextView f5269m;

    /* renamed from: n */
    private TextView f5270n;

    /* renamed from: s */
    private List<Boolean> f5275s;

    /* renamed from: t */
    private ArrayList<CallLogData> f5276t;

    /* renamed from: u */
    private HashMap<Set<String>, String> f5277u;

    /* renamed from: w */
    private DialogFragment f5279w;

    /* renamed from: a */
    public static String f5255a = null;

    /* renamed from: b */
    public static String f5256b = null;

    /* renamed from: i */
    private static int f5261i = 0;

    /* renamed from: c */
    public static C1458a f5257c = null;

    /* renamed from: d */
    public static int f5258d = 0;

    /* renamed from: e */
    public static int f5259e = 0;

    /* renamed from: f */
    public static final HandlerC1449a f5260f = new HandlerC1449a();

    /* renamed from: C */
    private static String f5254C = null;

    /* renamed from: o */
    private Context f5271o = null;

    /* renamed from: p */
    private HandlerC1490s f5272p = new HandlerC1490s(this, null);

    /* renamed from: q */
    private View f5273q = null;

    /* renamed from: r */
    private ListView f5274r = null;

    /* renamed from: v */
    private int f5278v = -1;

    /* renamed from: x */
    private final C1452a f5280x = C1452a.m7605a();

    /* renamed from: y */
    private final C1493v f5281y = new C1493v();

    /* renamed from: z */
    private Dialog f5282z = null;

    /* renamed from: A */
    private int f5262A = -1;

    /* renamed from: B */
    private ProgressDialog f5263B = null;

    /* renamed from: h */
    public Handler f5265h = new HandlerC1489r(this);

    /* renamed from: b */
    private void m7722b(String str) {
        C4904y.m18634a(str, "[CallLogFragment]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m7725c(String str) {
        C4904y.m18641c(str, "[CallLogFragment]");
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5264g = new C0416a();
        f5261i = 0;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m7725c("<<YHT99>> onResume() called!!");
        C1457a.m7650a().m7652a(1000);
        f5260f.m7581a(this.f5272p);
        m7732h();
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
    public static String m7711a(Context context) {
        if (DateFormat.is24HourFormat(context)) {
            return "24";
        }
        return "12";
    }

    /* renamed from: b */
    public static String m7720b(Context context) {
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
        m7725c("onCreateView()");
        this.f5273q = layoutInflater.inflate(R.layout.calllog_list, viewGroup, false);
        this.f5271o = getActivity();
        C1458a.m7790a(false);
        f5255a = m7711a(this.f5271o);
        f5256b = m7720b(this.f5271o);
        if (f5255a == null || !f5255a.equals("24")) {
            C1458a.m7791b(false);
        } else {
            C1458a.m7791b(true);
        }
        if (f5256b == null || f5256b.equals("MM-dd-yyyy")) {
            C1458a.m7789a(0);
        } else if (f5256b.equals("dd-MM-yyyy")) {
            C1458a.m7789a(1);
        } else if (f5256b.equals("yyyy-MM-dd")) {
            C1458a.m7789a(2);
        }
        this.f5274r = (ListView) this.f5273q.findViewById(R.id.calllog_list);
        m7731g();
        this.f5266j = (ViewStub) this.f5273q.findViewById(R.id.calllog_empty);
        m7736a();
        this.f5274r.setOnItemClickListener(this);
        setHasOptionsMenu(true);
        registerForContextMenu(this.f5274r);
        return this.f5273q;
    }

    /* renamed from: d */
    private void m7726d() {
        if (C4904y.f17872b) {
            C4904y.m18639b("showEmptyList()", CallLogFragment.class.getSimpleName());
        }
        if (this.f5267k == null) {
            this.f5267k = this.f5266j.inflate();
        }
        if (this.f5268l == null) {
            this.f5268l = (ImageView) this.f5267k.findViewById(R.id.image1);
            this.f5268l.setImageResource(R.drawable.no_contents_calllog);
        }
        if (this.f5269m == null) {
            this.f5269m = (TextView) this.f5267k.findViewById(R.id.text1);
            this.f5269m.setText(getResources().getString(R.string.calllog_no_title));
        }
        if (this.f5270n == null) {
            this.f5270n = (TextView) this.f5267k.findViewById(R.id.text2);
            this.f5270n.setText(getResources().getString(R.string.calllog_no_data));
        }
        this.f5267k.setVisibility(0);
    }

    /* renamed from: e */
    private void m7729e() {
        if (this.f5267k != null) {
            this.f5267k.setVisibility(0);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        m7722b("onItemClick+position: " + i);
        m7737a(i);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (this.f5276t.isEmpty()) {
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
                C1458a.m7790a(false);
                ((InterfaceC1491t) getActivity()).mo7656h();
                break;
            case R.id.menu_calllog_delete /* 2131166679 */:
                if (this.f5276t.isEmpty()) {
                    Toast.makeText(getActivity(), getString(R.string.calllog_no_title), 0).show();
                } else {
                    Intent intent = new Intent().setClass(getActivity(), DeleteCallLogActivity.class);
                    intent.putExtra("from_intent", 2);
                    startActivityForResult(intent, 1);
                }
                getActivity().mo51u_();
                break;
            case R.id.menu_calllog_view_by /* 2131166681 */:
                m7738b(1);
                getActivity().mo51u_();
                break;
            case R.id.menu_calllog_data_usage /* 2131166682 */:
                Intent intentM1497f = new C0416a().m1497f(getActivity());
                if (intentM1497f != null) {
                    startActivity(intentM1497f);
                    getActivity().mo51u_();
                    break;
                }
                break;
            case R.id.menu_calllog_help /* 2131166683 */:
                Intent intent2 = new Intent(getActivity(), (Class<?>) ActivityWebView.class);
                intent2.putExtra(FragmentWebView.PARAM_MENU, "Help");
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* renamed from: a */
    public static int m7709a(C1455c c1455c) {
        int i = 0;
        if (c1455c.f5177c == null) {
            i = 4;
        }
        C4904y.m18639b("setBuddyType [" + i + "]", CallLogActivity.class.getSimpleName());
        return i;
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        MenuInflater menuInflater = getActivity().getMenuInflater();
        CallLogData callLogData = this.f5276t.get(m7735a(contextMenuInfo));
        if (!(callLogData instanceof SeperatorCallLog)) {
            if (callLogData.groupcallkey == null) {
                switch (m7709a(callLogData.userInfo.get(0))) {
                    case 0:
                        menuInflater.inflate(R.menu.calllog_contextual_menu_buddy, contextMenu);
                        contextMenu.setHeaderTitle(this.f5280x.m7616b(callLogData));
                        break;
                    case 1:
                        menuInflater.inflate(R.menu.calllog_contextual_menu_hided_buddy, contextMenu);
                        contextMenu.setHeaderTitle(this.f5280x.m7616b(callLogData));
                        break;
                    case 2:
                    case 4:
                        menuInflater.inflate(R.menu.calllog_contextual_menu_unsaved_buddy, contextMenu);
                        contextMenu.setHeaderTitle(this.f5280x.m7616b(callLogData));
                        break;
                    case 3:
                        menuInflater.inflate(R.menu.calllog_contextual_menu_unsaved_buddy, contextMenu);
                        contextMenu.setHeaderTitle(this.f5280x.m7616b(callLogData));
                        break;
                }
            } else {
                String strM7613a = this.f5280x.m7613a(callLogData, this.f5277u, callLogData.userInfo);
                if (strM7613a == null || TextUtils.isEmpty(strM7613a)) {
                    menuInflater.inflate(R.menu.calllog_contextual_menu_unsaved_group, contextMenu);
                    contextMenu.setHeaderTitle(this.f5280x.m7616b(callLogData));
                } else {
                    menuInflater.inflate(R.menu.calllog_contextual_menu_group, contextMenu);
                    contextMenu.setHeaderTitle(strM7613a);
                }
            }
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            m7730f();
        }
    }

    /* renamed from: f */
    private void m7730f() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        getActivity().dispatchTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, -1.0f, -1.0f, 0));
    }

    @Override // android.support.v4.app.Fragment
    public boolean onContextItemSelected(MenuItem menuItem) {
        int iM7735a = m7735a(menuItem.getMenuInfo());
        CallLogData callLogData = this.f5276t.get(iM7735a);
        String str = callLogData.userInfo.get(0).f5177c;
        String str2 = callLogData.userInfo.get(0).f5175a;
        ArrayList arrayList = new ArrayList();
        switch (menuItem.getItemId()) {
            case R.id.menu_calllog_voice_call /* 2131166672 */:
                if (callLogData.userInfo.size() > 1) {
                    startActivity(new Intent().setClass(getActivity(), ShowConferenceMemberList.class).putExtra("calllogdata", callLogData).putExtra("searchtype", f5261i).putExtra("order", iM7735a).putExtra("makecall", true).putExtra("groupName", CallLogDetailFragment.m7660a(f5260f.m7580a(), callLogData.userInfo, callLogData)).putExtra("from_intent", 0).setFlags(MotionRecognitionManager.EVENT_OVER_TURN_LOW_POWER).addFlags(536870912));
                    break;
                } else {
                    m7725c("single voice call start!!");
                    m7717a(str2, false);
                    break;
                }
            case R.id.menu_calllog_video_call /* 2131166673 */:
                if (callLogData.userInfo.size() > 1) {
                    startActivity(new Intent().setClass(getActivity(), ShowConferenceMemberList.class).putExtra("calllogdata", callLogData).putExtra("searchtype", f5261i).putExtra("order", iM7735a).putExtra("makecall", true).putExtra("groupName", CallLogDetailFragment.m7660a(f5260f.m7580a(), callLogData.userInfo, callLogData)).putExtra("from_intent", 1).setFlags(MotionRecognitionManager.EVENT_OVER_TURN_LOW_POWER).addFlags(536870912));
                    break;
                } else {
                    m7725c("single video call start!!");
                    m7717a(str2, true);
                    break;
                }
            case R.id.menu_calllog_delete_contextual /* 2131166674 */:
                AbstractC4932a.m18733a(getActivity()).mo18740a(getResources().getString(R.string.create_delete_msg_dialog_title)).mo18749b(getResources().getString(R.string.calllog_delete)).mo18755c(getResources().getString(R.string.alert_dialog_ok), new DialogInterfaceOnClickListenerC1485n(this, iM7735a)).mo18741a(getResources().getString(R.string.my_profile_question_cancel), new DialogInterfaceOnClickListenerC1484m(this)).mo18752b();
                break;
            case R.id.menu_calllog_detail /* 2131166675 */:
                Intent intent = new Intent(this.f5271o, (Class<?>) BuddyProfileActivity.class);
                intent.putExtra("PROFILE_BUDDY_NO", callLogData.userInfo.get(0).f5175a);
                intent.putExtra("PROFILE_BUDDY_NAME", this.f5280x.m7616b(callLogData));
                this.f5271o.startActivity(intent);
                break;
            case R.id.menu_calllog_view_group_profile /* 2131166676 */:
                arrayList.clear();
                ArrayList<String> arrayListM7661a = CallLogDetailFragment.m7661a(callLogData);
                String strM7613a = this.f5280x.m7613a(callLogData, f5260f.m7580a(), callLogData.userInfo);
                C1105b c1105b = new C1105b(C2191e.m9867d(GlobalApplication.m18732r().getContentResolver(), strM7613a), strM7613a, arrayListM7661a == null ? 0 : arrayListM7661a.size(), 2);
                Intent intent2 = new Intent(this.f5271o, (Class<?>) BuddyGroupProfileActivity.class);
                intent2.putExtra("ACTIVITY_PURPOSE", 18);
                intent2.putExtra("groupInfo", c1105b);
                intent2.putExtra("ACTIVITY_ARG_GROUP_MEMBER_NO_LIST", (String[]) arrayListM7661a.toArray(new String[0]));
                intent2.putExtra("GROUP_PROFILE_NAME", strM7613a);
                this.f5271o.startActivity(intent2);
                break;
            case R.id.menu_calllog_add_buddy /* 2131166677 */:
                m7716a(str2, callLogData.userInfo.get(0).f5176b);
                break;
            case R.id.menu_calllog_add_group /* 2131166678 */:
                arrayList.clear();
                ArrayList<String> arrayListM7661a2 = CallLogDetailFragment.m7661a(callLogData);
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < callLogData.userInfo.size(); i++) {
                    arrayList2.add(callLogData.userInfo.get(i).f5176b);
                }
                Intent intent3 = new Intent(this.f5271o, (Class<?>) ChatInfoMoreActivity.class);
                intent3.putExtra("ACTIVITY_PURPOSE", 6);
                intent3.putExtra(ChatFragment.f5465d, (String[]) arrayListM7661a2.toArray(new String[0]));
                intent3.putExtra("member_name", (String[]) arrayList2.toArray(new String[0]));
                intent3.putExtra("ACTIVITY_PURPOSE_ARG", false);
                intent3.putExtra("ACTIVITY_PURPOSE_CALLLOG_GROUP", true);
                startActivity(intent3);
                break;
        }
        return super.onContextItemSelected(menuItem);
    }

    /* renamed from: a */
    public void m7737a(int i) {
        Intent intent = new Intent();
        CallLogData callLogData = this.f5276t.get(i);
        if (!(callLogData instanceof SeperatorCallLog)) {
            intent.setClass(getActivity(), CallLogDetailActivity.class);
            intent.putExtra("normal", true);
            intent.putExtra("calllogdata", callLogData);
            intent.putExtra("searchtype", f5261i);
            intent.putExtra("order", i);
            if (i == 1 && callLogData.groupcallkey == null) {
                intent.putExtra("updateUIAfterCall", true);
            }
            startActivity(intent);
        }
    }

    /* renamed from: a */
    public int m7735a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        return ((AdapterView.AdapterContextMenuInfo) contextMenuInfo).position;
    }

    /* renamed from: g */
    private void m7731g() {
        this.f5274r.setOnScrollListener(new C1486o(this));
    }

    /* renamed from: a */
    public void m7736a() {
        this.f5276t = f5260f.m7575a(f5261i, true);
        this.f5277u = f5260f.m7580a();
        m7722b("<<RDJ>> calllog count: " + f5260f.m7585c());
        m7718a(this.f5276t.isEmpty());
        this.f5275s = new ArrayList();
        for (int i = 0; i <= this.f5276t.size() * 2; i++) {
            this.f5275s.add(false);
        }
        f5257c = new C1458a(this.f5271o, 0, this.f5276t, this.f5277u, this.f5272p, this.f5281y, this.f5275s, null);
        this.f5274r.setAdapter((ListAdapter) f5257c);
        ((ListView) this.f5273q.findViewById(R.id.calllog_list)).setSelectionFromTop(f5258d, f5259e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m7732h() {
        m7725c("handleEventContactUpdateUI()");
        m7736a();
        f5257c.notifyDataSetChanged();
    }

    /* renamed from: b */
    public void m7738b(int i) {
        switch (i) {
            case 1:
                RadioButtonListDialog.m7537a(getResources().getString(R.string.calllog_view_by_title), f5261i, this.f5264g.m1493b((Context) getActivity(), true) + (-1) > 1).m36a(getFragmentManager(), "viewbydialog");
                break;
            case 2:
                this.f5279w = ButtonTwoDialog.m7534a(2, getResources().getString(R.string.menu_buddy_delete), getResources().getString(R.string.group_delete_msg));
                this.f5279w.m32a(getFragmentManager().mo183a(), "groupdeletedialog");
                break;
        }
    }

    /* renamed from: c */
    public void m7739c(int i) {
        f5261i = i;
        this.f5276t = f5260f.m7575a(f5261i, true);
        m7718a(this.f5276t.isEmpty());
        f5257c = new C1458a(this.f5271o, 0, this.f5276t, this.f5277u, this.f5272p, this.f5281y, this.f5275s, null);
        this.f5274r.setAdapter((ListAdapter) f5257c);
        f5257c.notifyDataSetChanged();
    }

    /* renamed from: a */
    private void m7718a(boolean z) {
        getActivity().mo51u_();
        if (z) {
            this.f5274r.setVisibility(8);
            m7726d();
        } else {
            this.f5274r.setVisibility(0);
            m7729e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7713a(CallLogData callLogData) {
        ArrayList<CallLogData> arrayList = new ArrayList<>();
        arrayList.add(callLogData);
        f5260f.m7583b(arrayList);
    }

    /* renamed from: a */
    private void m7717a(String str, boolean z) {
        int iM1487a;
        if (z) {
            iM1487a = this.f5264g.m1487a(getActivity(), true, str, C4809aa.m18104a().m18121a("Push Name", ""), null);
        } else {
            iM1487a = this.f5264g.m1487a(getActivity(), false, str, C4809aa.m18104a().m18121a("Push Name", ""), null);
        }
        C4904y.m18639b("Return value from ChatonV= " + iM1487a, getClass().getSimpleName());
        if (iM1487a != 0) {
            C5179v.m19810a(getActivity(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        m7725c("onConfigurationChanged()");
        super.onConfigurationChanged(configuration);
        m7732h();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            AbstractC4932a.m18733a(getActivity()).mo18740a(getResources().getString(R.string.create_delete_msg_dialog_title_with_count, Integer.valueOf(this.f5276t.size()))).mo18749b(getResources().getText(R.string.calllog_all_delete)).mo18755c(getResources().getText(R.string.alert_dialog_cancel), new DialogInterfaceOnClickListenerC1488q(this)).mo18741a(getResources().getText(R.string.alert_dialog_ok), new DialogInterfaceOnClickListenerC1487p(this)).mo18752b();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 200) {
        }
    }

    /* renamed from: b */
    public static int m7719b() {
        return f5261i;
    }

    /* renamed from: a */
    private void m7716a(String str, String str2) {
        f5254C = str2;
        C4904y.m18639b("addBuddy() buddyNo[" + str + "]", CallLogActivity.class.getSimpleName());
        m7733i();
        new C2128i(this.f5265h).m9508b(str);
    }

    /* renamed from: i */
    private void m7733i() {
        if (this.f5263B == null) {
            this.f5263B = ProgressDialogC4926s.m18728a(this.f5271o, null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
        } else {
            this.f5263B.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m7734j() {
        if (this.f5263B != null) {
            this.f5263B.dismiss();
        }
    }
}
