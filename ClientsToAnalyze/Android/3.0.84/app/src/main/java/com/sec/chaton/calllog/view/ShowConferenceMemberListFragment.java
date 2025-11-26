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
import com.coolots.sso.p006a.C0045a;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.calllog.manager.HandlerC0838a;
import com.sec.chaton.calllog.manager.model.C0844c;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ShowConferenceMemberListFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: a */
    protected C0844c f3323a;

    /* renamed from: d */
    private ListView f3326d;

    /* renamed from: e */
    private C0858ak f3327e;

    /* renamed from: f */
    private CallLogData f3328f;

    /* renamed from: h */
    private InterfaceC0855ah f3330h;

    /* renamed from: i */
    private C0513c f3331i;

    /* renamed from: j */
    private ProgressDialog f3332j;

    /* renamed from: k */
    private Toast f3333k;

    /* renamed from: p */
    private RelativeLayout f3338p;

    /* renamed from: q */
    private CheckBox f3339q;

    /* renamed from: t */
    private String f3342t;

    /* renamed from: u */
    private Menu f3343u;

    /* renamed from: w */
    private int[] f3345w;

    /* renamed from: c */
    private View f3325c = null;

    /* renamed from: g */
    private final HandlerC0838a f3329g = CallLogFragment.f3288f;

    /* renamed from: l */
    private int f3334l = 0;

    /* renamed from: m */
    private int f3335m = -1;

    /* renamed from: n */
    private int f3336n = -1;

    /* renamed from: o */
    private boolean f3337o = false;

    /* renamed from: r */
    private List<Boolean> f3340r = new ArrayList();

    /* renamed from: s */
    private C0045a f3341s = new C0045a();

    /* renamed from: v */
    private boolean f3344v = false;

    /* renamed from: b */
    public Handler f3324b = new HandlerC0852ae(this);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.select_all_layout /* 2131165495 */:
                if (this.f3337o) {
                    if (m4616b(true)) {
                        this.f3339q.setChecked(false);
                        break;
                    } else {
                        if (this.f3339q.isChecked()) {
                            this.f3339q.setChecked(false);
                            m4619c(false);
                        } else {
                            this.f3339q.setChecked(true);
                            m4619c(true);
                        }
                        m4631a(this.f3339q.isChecked());
                        break;
                    }
                }
                break;
            case R.id.select_all_checkbox /* 2131165496 */:
                if (this.f3337o) {
                    if (m4616b(true)) {
                        this.f3339q.setChecked(false);
                        break;
                    } else {
                        if (this.f3339q.isChecked()) {
                            this.f3339q.setChecked(true);
                            m4619c(true);
                        } else {
                            this.f3339q.setChecked(false);
                            m4619c(false);
                        }
                        m4631a(this.f3339q.isChecked());
                        break;
                    }
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Context m4608a() {
        return getActivity();
    }

    /* renamed from: b */
    private void m4614b() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f3340r.size(); i++) {
            if (this.f3340r.get(i).booleanValue()) {
                arrayList.add(this.f3328f.userInfo.get(i).f3205a);
            }
        }
        if (this.f3336n != -1) {
            if ((this.f3336n == 0 || this.f3336n == 1) && m4612a(this.f3336n, (String[]) arrayList.toArray(new String[0]))) {
                ((InterfaceC0856ai) getActivity()).mo4607c();
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f3325c = layoutInflater.inflate(R.layout.layout_show_conference_members, viewGroup, false);
        this.f3326d = (ListView) this.f3325c.findViewById(R.id.member_list);
        this.f3338p = (RelativeLayout) this.f3325c.findViewById(R.id.select_all_layout);
        this.f3339q = (CheckBox) this.f3325c.findViewById(R.id.select_all_checkbox);
        m4613a(getActivity().getIntent());
        if (this.f3337o) {
            this.f3327e = new C0858ak(getActivity(), R.layout.member_conf_adapter_item, this.f3328f, this.f3340r);
            getActivity().setTitle(R.string.buddy_select_no_list_select_buddies);
        } else {
            this.f3330h = new C0851ad(this);
            this.f3327e = new C0858ak(getActivity(), R.layout.member_conf_adapter_item, this.f3328f, this.f3330h);
        }
        this.f3326d.setAdapter((ListAdapter) this.f3327e);
        this.f3326d.setOnItemClickListener(this);
        if (this.f3337o) {
            this.f3338p.setVisibility(0);
            this.f3339q.setVisibility(0);
            this.f3338p.setOnClickListener(this);
            this.f3339q.setOnClickListener(this);
        } else {
            this.f3338p.setVisibility(8);
            this.f3339q.setVisibility(8);
            this.f3338p.setOnClickListener(null);
            this.f3339q.setOnClickListener(null);
        }
        BaseActivity.m3081a(this, true);
        return this.f3325c;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m4625f();
    }

    /* renamed from: a */
    public void m4630a(String str, String str2) {
        C0513c c0513c = new C0513c(str, str2);
        this.f3331i = c0513c;
        m4617c();
        new C1330h(this.f3324b).m5730b(c0513c.m3975b());
    }

    /* renamed from: a */
    public void m4632a(String[] strArr, String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f3331i = new C0513c(strArr[0], str);
        for (String str2 : strArr) {
            arrayList.add(str2);
        }
        m4617c();
        new C1330h(this.f3324b).m5726a(arrayList, true);
    }

    /* renamed from: c */
    private void m4617c() {
        if (this.f3332j == null) {
            this.f3332j = ProgressDialogC3265l.m11490a(getActivity(), null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
        } else {
            this.f3332j.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m4620d() {
        if (this.f3332j != null) {
            this.f3332j.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4611a(CharSequence charSequence) {
        if (this.f3333k == null) {
            this.f3333k = C3641ai.m13211a(getActivity(), (CharSequence) null, 0);
        }
        this.f3333k.setText(charSequence);
        this.f3333k.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m4624e() {
        C3250y.m11450b("updateList() mOrder[" + this.f3335m + "], mSearchType" + this.f3334l + "]", ShowConferenceMemberList.class.getSimpleName());
        this.f3328f = CallLogDetailFragment.m4516b(CallLogDetailFragment.m4504a(this.f3335m, this.f3334l, this.f3329g));
        if (this.f3337o) {
            this.f3327e = new C0858ak(getActivity(), R.layout.member_conf_adapter_item, this.f3328f, this.f3340r);
        } else {
            this.f3327e = new C0858ak(getActivity(), R.layout.member_conf_adapter_item, this.f3328f, this.f3330h);
        }
        this.f3326d.setAdapter((ListAdapter) this.f3327e);
        this.f3327e.notifyDataSetChanged();
    }

    /* renamed from: a */
    private boolean m4613a(Intent intent) {
        Bundle extras = intent.getExtras();
        CallLogData callLogData = (CallLogData) extras.getParcelable("calllogdata");
        this.f3336n = extras.getInt("from_intent");
        this.f3335m = extras.getInt("order", 0);
        this.f3334l = extras.getInt("searchtype", 0);
        this.f3337o = extras.getBoolean("makecall", false);
        this.f3342t = intent.getExtras().getString("groupName", null);
        if (callLogData == null) {
            return false;
        }
        this.f3328f = CallLogDetailFragment.m4516b(callLogData);
        C3250y.m11450b("loadCallLogData(3) userInfo.size[" + this.f3328f.userInfo.size() + "] -1", ShowConferenceMemberList.class.getSimpleName());
        if (this.f3340r != null && this.f3340r.size() <= 0) {
            for (int i = 0; i < this.f3328f.userInfo.size(); i++) {
                this.f3340r.add(false);
            }
        }
        return true;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f3337o) {
            if (this.f3340r.get(i).booleanValue() || !m4616b(false)) {
                this.f3340r.set(i, Boolean.valueOf(!this.f3340r.get(i).booleanValue()));
                this.f3327e.notifyDataSetChanged();
                m4625f();
                return;
            }
            return;
        }
        C0844c c0844c = this.f3328f.userInfo.get(i);
        if (!TextUtils.isEmpty(c0844c.f3207c)) {
            Intent intent = new Intent(m4608a(), (Class<?>) BuddyProfileActivity.class);
            intent.putExtra("PROFILE_BUDDY_NO", c0844c.f3205a);
            intent.putExtra("PROFILE_BUDDY_NAME", c0844c.f3207c);
            m4608a().startActivity(intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menu.clear();
        menuInflater.inflate(R.menu.done_menu, menu);
        this.f3343u = menu;
        if (this.f3337o) {
            m4622d(true);
        } else {
            m4622d(false);
        }
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                ((InterfaceC0856ai) getActivity()).mo4607c();
                break;
            case R.id.menu_done /* 2131166604 */:
                m4614b();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* renamed from: b */
    private boolean m4616b(boolean z) {
        int iM53b;
        boolean z2;
        if (this.f3336n == 0) {
            iM53b = this.f3341s.m53b((Context) getActivity(), false) - 1;
        } else if (this.f3336n != 1) {
            iM53b = -1;
        } else {
            iM53b = this.f3341s.m53b((Context) getActivity(), true) - 1;
        }
        if (z) {
            if (this.f3340r.size() > iM53b) {
                C3641ai.m13211a(getActivity(), getResources().getString(R.string.calllog_max_invite_popup, Integer.valueOf(iM53b)), 0).show();
                z2 = true;
            } else {
                z2 = false;
            }
            C3250y.m11450b("overMax() maxCount[" + iM53b + "], mCheckedList.size()[" + this.f3340r.size() + "]", ShowConferenceMemberList.class.getSimpleName());
            return z2;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.f3340r.size(); i2++) {
            if (this.f3340r.get(i2).booleanValue()) {
                i++;
            }
        }
        C3250y.m11450b("overMax() maxCount[" + iM53b + "], checkedCallLogAmount[" + i + "]", ShowConferenceMemberList.class.getSimpleName());
        if (i < iM53b) {
            return false;
        }
        C3641ai.m13211a(getActivity(), getResources().getString(R.string.calllog_max_invite_popup, Integer.valueOf(iM53b)), 0).show();
        return true;
    }

    /* renamed from: f */
    private void m4625f() {
        int size = this.f3328f.userInfo.size();
        int i = 0;
        for (int i2 = 0; i2 < this.f3340r.size(); i2++) {
            if (this.f3340r.get(i2).booleanValue()) {
                i++;
            }
        }
        if (size <= i) {
            this.f3339q.setChecked(true);
        } else {
            this.f3339q.setChecked(false);
        }
        if (i == 0) {
            m4619c(false);
        } else {
            m4619c(true);
        }
    }

    /* renamed from: a */
    public void m4631a(boolean z) {
        for (int i = 0; i < this.f3327e.getCount(); i++) {
            this.f3340r.set(i, Boolean.valueOf(z));
        }
        this.f3327e.notifyDataSetChanged();
    }

    /* renamed from: c */
    private void m4619c(boolean z) {
        if (this.f3343u != null && this.f3343u.findItem(R.id.menu_done) != null) {
            this.f3343u.findItem(R.id.menu_done).setEnabled(z);
        }
    }

    /* renamed from: d */
    private void m4622d(boolean z) {
        if (this.f3343u != null && this.f3343u.findItem(R.id.menu_done) != null) {
            this.f3343u.findItem(R.id.menu_done).setVisible(z);
        }
    }

    /* renamed from: a */
    private boolean m4612a(int i, String[] strArr) {
        int iM48a = -1;
        if (strArr.length == 1) {
            C3250y.m11450b("makeCall() with single buddy", getClass().getSimpleName());
            if (m4628g()) {
                return false;
            }
            if (i == 0) {
                iM48a = this.f3341s.m47a(getActivity(), false, strArr[0], C3159aa.m10962a().m10979a("Push Name", ""), null);
            } else if (i == 1) {
                iM48a = this.f3341s.m47a(getActivity(), true, strArr[0], C3159aa.m10962a().m10979a("Push Name", ""), null);
            }
        } else {
            if (m4628g()) {
                return false;
            }
            if (i == 0) {
                iM48a = this.f3341s.m48a(getActivity(), false, strArr, C3159aa.m10962a().m10979a("Push Name", ""), null, this.f3342t);
            } else if (i == 1) {
                iM48a = this.f3341s.m48a(getActivity(), true, strArr, C3159aa.m10962a().m10979a("Push Name", ""), null, this.f3342t);
            }
        }
        if (iM48a == 0) {
            return true;
        }
        C3641ai.m13210a(getActivity(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
        return false;
    }

    /* renamed from: g */
    private boolean m4628g() {
        this.f3345w = new int[]{-1, -1};
        int i = 0;
        boolean z = false;
        for (int i2 = 0; i2 < this.f3340r.size(); i2++) {
            if (this.f3340r.get(i2).booleanValue() && this.f3328f.userInfo.get(i2).f3207c == null) {
                this.f3345w[i] = i2;
                i++;
                z = true;
            }
        }
        if (true == z) {
            if (i == 1) {
                AbstractC3271a.m11494a(m4608a()).mo11500a(getResources().getString(R.string.buddy_list_dialog_addbuddy_title)).mo11509b(getResources().getString(R.string.calllog_unsaved_one_buddy_popup, this.f3328f.userInfo.get(this.f3345w[0]).f3206b)).mo11510b(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0853af(this)).mo11501a(getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11512b();
            } else {
                AbstractC3271a.m11494a(m4608a()).mo11500a(getResources().getString(R.string.buddy_list_dialog_addbuddy_title)).mo11509b(getResources().getString(R.string.calllog_unsaved_two_buddy_popup, this.f3328f.userInfo.get(this.f3345w[0]).f3206b, this.f3328f.userInfo.get(this.f3345w[1]).f3206b)).mo11510b(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0854ag(this)).mo11501a(getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11512b();
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m4629h() {
        Intent intent = new Intent();
        intent.putExtra("MEMBERS_LIST_CHANGE_BUDDY_INFO", true);
        getActivity().setResult(-1, intent);
    }
}
