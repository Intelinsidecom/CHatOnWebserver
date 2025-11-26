package com.sec.chaton.calllog.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.coolots.sso.p030a.C0416a;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.calllog.manager.HandlerC1449a;
import com.sec.chaton.calllog.manager.model.C1455c;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ShowConferenceMemberListFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: a */
    protected C1455c f5296a;

    /* renamed from: d */
    private ListView f5299d;

    /* renamed from: e */
    private C1469ak f5300e;

    /* renamed from: f */
    private CallLogData f5301f;

    /* renamed from: h */
    private InterfaceC1466ah f5303h;

    /* renamed from: i */
    private C1106c f5304i;

    /* renamed from: j */
    private ProgressDialog f5305j;

    /* renamed from: k */
    private Toast f5306k;

    /* renamed from: p */
    private RelativeLayout f5311p;

    /* renamed from: q */
    private CheckBox f5312q;

    /* renamed from: t */
    private String f5315t;

    /* renamed from: u */
    private Menu f5316u;

    /* renamed from: w */
    private int[] f5318w;

    /* renamed from: c */
    private View f5298c = null;

    /* renamed from: g */
    private final HandlerC1449a f5302g = CallLogFragment.f5260f;

    /* renamed from: l */
    private int f5307l = 0;

    /* renamed from: m */
    private int f5308m = -1;

    /* renamed from: n */
    private int f5309n = -1;

    /* renamed from: o */
    private boolean f5310o = false;

    /* renamed from: r */
    private List<Boolean> f5313r = new ArrayList();

    /* renamed from: s */
    private C0416a f5314s = new C0416a();

    /* renamed from: v */
    private boolean f5317v = false;

    /* renamed from: b */
    public Handler f5297b = new HandlerC1463ae(this);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.select_all_layout /* 2131165527 */:
                if (this.f5310o) {
                    if (m7772b(true)) {
                        this.f5312q.setChecked(false);
                        break;
                    } else {
                        if (this.f5312q.isChecked()) {
                            this.f5312q.setChecked(false);
                            m7775c(false);
                        } else {
                            this.f5312q.setChecked(true);
                            m7775c(true);
                        }
                        m7787a(this.f5312q.isChecked());
                        break;
                    }
                }
                break;
            case R.id.select_all_checkbox /* 2131165528 */:
                if (this.f5310o) {
                    if (m7772b(true)) {
                        this.f5312q.setChecked(false);
                        break;
                    } else {
                        if (this.f5312q.isChecked()) {
                            this.f5312q.setChecked(true);
                            m7775c(true);
                        } else {
                            this.f5312q.setChecked(false);
                            m7775c(false);
                        }
                        m7787a(this.f5312q.isChecked());
                        break;
                    }
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Context m7764a() {
        return getActivity();
    }

    /* renamed from: b */
    private void m7770b() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f5313r.size(); i++) {
            if (this.f5313r.get(i).booleanValue()) {
                arrayList.add(this.f5301f.userInfo.get(i).f5175a);
            }
        }
        if (this.f5309n != -1) {
            if ((this.f5309n == 0 || this.f5309n == 1) && m7768a(this.f5309n, (String[]) arrayList.toArray(new String[0]))) {
                ((InterfaceC1467ai) getActivity()).mo7763h();
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5298c = layoutInflater.inflate(R.layout.layout_show_conference_members, viewGroup, false);
        this.f5299d = (ListView) this.f5298c.findViewById(R.id.member_list);
        this.f5311p = (RelativeLayout) this.f5298c.findViewById(R.id.select_all_layout);
        this.f5312q = (CheckBox) this.f5298c.findViewById(R.id.select_all_checkbox);
        m7769a(getActivity().getIntent());
        if (this.f5310o) {
            this.f5300e = new C1469ak(getActivity(), R.layout.member_conf_adapter_item, this.f5301f, this.f5313r);
            getActivity().setTitle(R.string.buddy_select_no_list_select_buddies);
        } else {
            this.f5303h = new C1462ad(this);
            this.f5300e = new C1469ak(getActivity(), R.layout.member_conf_adapter_item, this.f5301f, this.f5303h);
        }
        this.f5299d.setAdapter((ListAdapter) this.f5300e);
        this.f5299d.setOnItemClickListener(this);
        if (this.f5310o) {
            this.f5311p.setVisibility(0);
            this.f5312q.setVisibility(0);
            this.f5311p.setOnClickListener(this);
            this.f5312q.setOnClickListener(this);
        } else {
            this.f5311p.setVisibility(8);
            this.f5312q.setVisibility(8);
            this.f5311p.setOnClickListener(null);
            this.f5312q.setOnClickListener(null);
        }
        BaseActivity.m6160a((Fragment) this, true);
        return this.f5298c;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m7781f();
    }

    /* renamed from: a */
    public void m7786a(String str, String str2) {
        C1106c c1106c = new C1106c(str, str2);
        this.f5304i = c1106c;
        m7773c();
        new C2128i(this.f5297b).m9508b(c1106c.m7046a());
    }

    /* renamed from: a */
    public void m7788a(String[] strArr, String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f5304i = new C1106c(strArr[0], str);
        for (String str2 : strArr) {
            arrayList.add(str2);
        }
        m7773c();
        new C2128i(this.f5297b).m9503a(arrayList, true);
    }

    /* renamed from: c */
    private void m7773c() {
        if (this.f5305j == null) {
            this.f5305j = ProgressDialogC4926s.m18728a(getActivity(), null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
        } else {
            this.f5305j.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m7776d() {
        if (this.f5305j != null) {
            this.f5305j.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7767a(CharSequence charSequence) {
        if (this.f5306k == null) {
            this.f5306k = C5179v.m19811a(getActivity(), (CharSequence) null, 0);
        }
        this.f5306k.setText(charSequence);
        this.f5306k.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m7780e() {
        C4904y.m18639b("updateList() mOrder[" + this.f5308m + "], mSearchType" + this.f5307l + "]", ShowConferenceMemberList.class.getSimpleName());
        this.f5301f = CallLogDetailFragment.m7670b(CallLogDetailFragment.m7658a(this.f5308m, this.f5307l, this.f5302g));
        if (this.f5310o) {
            this.f5300e = new C1469ak(getActivity(), R.layout.member_conf_adapter_item, this.f5301f, this.f5313r);
        } else {
            this.f5300e = new C1469ak(getActivity(), R.layout.member_conf_adapter_item, this.f5301f, this.f5303h);
        }
        this.f5299d.setAdapter((ListAdapter) this.f5300e);
        this.f5300e.notifyDataSetChanged();
    }

    /* renamed from: a */
    private boolean m7769a(Intent intent) {
        Bundle extras = intent.getExtras();
        CallLogData callLogData = (CallLogData) extras.getParcelable("calllogdata");
        this.f5309n = extras.getInt("from_intent");
        this.f5308m = extras.getInt("order", 0);
        this.f5307l = extras.getInt("searchtype", 0);
        this.f5310o = extras.getBoolean("makecall", false);
        this.f5315t = null;
        this.f5315t = intent.getExtras().getString("groupName");
        if (callLogData == null) {
            return false;
        }
        this.f5301f = CallLogDetailFragment.m7670b(callLogData);
        if (this.f5301f != null) {
            C4904y.m18639b("loadCallLogData(3) userInfo.size[" + this.f5301f.userInfo.size() + "] -1", ShowConferenceMemberList.class.getSimpleName());
        } else {
            C4904y.m18639b("loadCallLogData(3) mMemberData is null", ShowConferenceMemberList.class.getSimpleName());
        }
        if (this.f5313r != null && this.f5313r.size() <= 0 && this.f5301f != null) {
            for (int i = 0; i < this.f5301f.userInfo.size(); i++) {
                this.f5313r.add(false);
            }
        }
        return true;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f5310o) {
            if (this.f5313r.get(i).booleanValue() || !m7772b(false)) {
                this.f5313r.set(i, Boolean.valueOf(!this.f5313r.get(i).booleanValue()));
                this.f5300e.notifyDataSetChanged();
                m7781f();
                return;
            }
            return;
        }
        C1455c c1455c = this.f5301f.userInfo.get(i);
        if (!TextUtils.isEmpty(c1455c.f5177c)) {
            Intent intent = new Intent(m7764a(), (Class<?>) BuddyProfileActivity.class);
            intent.putExtra("PROFILE_BUDDY_NO", c1455c.f5175a);
            intent.putExtra("PROFILE_BUDDY_NAME", c1455c.f5177c);
            m7764a().startActivity(intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menu.clear();
        menuInflater.inflate(R.menu.done_menu, menu);
        this.f5316u = menu;
        if (this.f5310o) {
            m7778d(true);
        } else {
            m7778d(false);
        }
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                ((InterfaceC1467ai) getActivity()).mo7763h();
                break;
            case R.id.menu_done /* 2131166685 */:
                m7770b();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* renamed from: b */
    private boolean m7772b(boolean z) {
        int iM1493b;
        boolean z2;
        if (this.f5309n == 0) {
            iM1493b = this.f5314s.m1493b((Context) getActivity(), false) - 1;
        } else if (this.f5309n != 1) {
            iM1493b = -1;
        } else {
            iM1493b = this.f5314s.m1493b((Context) getActivity(), true) - 1;
        }
        if (z) {
            if (this.f5313r.size() > iM1493b) {
                C5179v.m19811a(getActivity(), getResources().getString(R.string.calllog_max_invite_popup, Integer.valueOf(iM1493b)), 0).show();
                z2 = true;
            } else {
                z2 = false;
            }
            C4904y.m18639b("overMax() maxCount[" + iM1493b + "], mCheckedList.size()[" + this.f5313r.size() + "]", ShowConferenceMemberList.class.getSimpleName());
            return z2;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.f5313r.size(); i2++) {
            if (this.f5313r.get(i2).booleanValue()) {
                i++;
            }
        }
        C4904y.m18639b("overMax() maxCount[" + iM1493b + "], checkedCallLogAmount[" + i + "]", ShowConferenceMemberList.class.getSimpleName());
        if (i < iM1493b) {
            return false;
        }
        C5179v.m19811a(getActivity(), getResources().getString(R.string.calllog_max_invite_popup, Integer.valueOf(iM1493b)), 0).show();
        return true;
    }

    /* renamed from: f */
    private void m7781f() {
        int size = this.f5301f.userInfo.size();
        int i = 0;
        for (int i2 = 0; i2 < this.f5313r.size(); i2++) {
            if (this.f5313r.get(i2).booleanValue()) {
                i++;
            }
        }
        if (size <= i) {
            this.f5312q.setChecked(true);
        } else {
            this.f5312q.setChecked(false);
        }
        if (i == 0) {
            m7775c(false);
        } else {
            m7775c(true);
        }
    }

    /* renamed from: a */
    public void m7787a(boolean z) {
        for (int i = 0; i < this.f5300e.getCount(); i++) {
            this.f5313r.set(i, Boolean.valueOf(z));
        }
        this.f5300e.notifyDataSetChanged();
    }

    /* renamed from: c */
    private void m7775c(boolean z) {
        if (this.f5316u != null && this.f5316u.findItem(R.id.menu_done) != null) {
            this.f5316u.findItem(R.id.menu_done).setEnabled(z);
        }
    }

    /* renamed from: d */
    private void m7778d(boolean z) {
        if (this.f5316u != null && this.f5316u.findItem(R.id.menu_done) != null) {
            this.f5316u.findItem(R.id.menu_done).setVisible(z);
        }
    }

    /* renamed from: a */
    private boolean m7768a(int i, String[] strArr) {
        int iM1488a = -1;
        if (strArr.length == 1) {
            C4904y.m18639b("makeCall() with single buddy", getClass().getSimpleName());
            if (m7784g()) {
                return false;
            }
            if (i == 0) {
                iM1488a = this.f5314s.m1487a(getActivity(), false, strArr[0], C4809aa.m18104a().m18121a("Push Name", ""), null);
            } else if (i == 1) {
                iM1488a = this.f5314s.m1487a(getActivity(), true, strArr[0], C4809aa.m18104a().m18121a("Push Name", ""), null);
            }
        } else {
            if (m7784g()) {
                return false;
            }
            if (i == 0) {
                iM1488a = this.f5314s.m1488a(getActivity(), false, strArr, C4809aa.m18104a().m18121a("Push Name", ""), null, this.f5315t);
            } else if (i == 1) {
                iM1488a = this.f5314s.m1488a(getActivity(), true, strArr, C4809aa.m18104a().m18121a("Push Name", ""), null, this.f5315t);
            }
        }
        if (iM1488a == 0) {
            return true;
        }
        C5179v.m19810a(getActivity(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
        return false;
    }

    /* renamed from: g */
    private boolean m7784g() {
        this.f5318w = new int[]{-1, -1};
        int i = 0;
        boolean z = false;
        for (int i2 = 0; i2 < this.f5313r.size(); i2++) {
            if (this.f5313r.get(i2).booleanValue() && this.f5301f.userInfo.get(i2).f5177c == null) {
                this.f5318w[i] = i2;
                i++;
                z = true;
            }
        }
        if (true == z) {
            if (i == 1) {
                AbstractC4932a.m18733a(m7764a()).mo18740a(getResources().getString(R.string.buddy_add_contact)).mo18749b(getResources().getString(R.string.calllog_unsaved_one_buddy_popup, this.f5301f.userInfo.get(this.f5318w[0]).f5176b)).mo18755c(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1464af(this)).mo18741a(getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo18752b();
            } else {
                AbstractC4932a.m18733a(m7764a()).mo18740a(getResources().getString(R.string.buddy_add_contact)).mo18749b(getResources().getString(R.string.calllog_unsaved_two_buddy_popup, this.f5301f.userInfo.get(this.f5318w[0]).f5176b, this.f5301f.userInfo.get(this.f5318w[1]).f5176b)).mo18755c(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1465ag(this)).mo18741a(getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo18752b();
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m7785h() {
        Intent intent = new Intent();
        intent.putExtra("MEMBERS_LIST_CHANGE_BUDDY_INFO", true);
        getActivity().setResult(-1, intent);
    }
}
