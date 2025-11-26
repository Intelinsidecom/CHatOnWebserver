package com.sec.chaton.calllog.view;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.calllog.manager.HandlerC0838a;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.calllog.manager.model.SeperatorCallLog;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.p063a.AbstractC3271a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class DeleteCallLogFragment extends Fragment implements View.OnClickListener {

    /* renamed from: b */
    private Dialog f3311b;

    /* renamed from: c */
    private ProgressDialog f3312c;

    /* renamed from: d */
    private RelativeLayout f3313d;

    /* renamed from: e */
    private CheckBox f3314e;

    /* renamed from: f */
    private ListView f3315f;

    /* renamed from: g */
    private C0847a f3316g;

    /* renamed from: h */
    private ArrayList<CallLogData> f3317h;

    /* renamed from: j */
    private InterfaceC0881u f3319j;

    /* renamed from: m */
    private Menu f3322m;

    /* renamed from: a */
    private View f3310a = null;

    /* renamed from: i */
    private List<Boolean> f3318i = new ArrayList();

    /* renamed from: k */
    private final HandlerC0838a f3320k = CallLogFragment.f3288f;

    /* renamed from: l */
    private final HandlerC0848aa f3321l = new HandlerC0848aa(this, null);

    /* renamed from: c */
    private void m4591c() {
        String string;
        String string2;
        AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(getActivity());
        if (this.f3314e.isChecked()) {
            string = getString(R.string.create_delete_msg_dialog_title_with_count, Integer.valueOf(m4605b()));
            string2 = getString(R.string.calllog_all_delete);
        } else if (m4605b() == 1) {
            string = getString(R.string.create_delete_msg_dialog_title);
            string2 = getString(R.string.calllog_delete);
        } else {
            string = getString(R.string.create_delete_msg_dialog_title_with_count, Integer.valueOf(m4605b()));
            string2 = getString(R.string.calllog_some_delete);
        }
        abstractC3271aM11494a.mo11500a(string);
        abstractC3271aM11494a.mo11509b(string2);
        abstractC3271aM11494a.mo11515d(R.string.alert_dialog_ok, new DialogInterfaceOnClickListenerC0883w(this));
        abstractC3271aM11494a.mo11507b(R.string.cancel, new DialogInterfaceOnClickListenerC0884x(this));
        abstractC3271aM11494a.mo11511b(true);
        abstractC3271aM11494a.mo11498a(new DialogInterfaceOnCancelListenerC0885y(this));
        if (this.f3311b != null && this.f3311b.isShowing()) {
            if (this.f3311b.isShowing()) {
                this.f3311b.dismiss();
            }
            this.f3311b = null;
        }
        this.f3311b = abstractC3271aM11494a.mo11505a().mo11517a();
        this.f3311b.show();
    }

    /* renamed from: a */
    public void m4603a() {
        m4597f();
        this.f3316g.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m4593d() {
        ArrayList<CallLogData> arrayList = new ArrayList<>();
        arrayList.clear();
        for (int size = this.f3318i.size() - 1; size >= 0; size--) {
            if (this.f3318i.get(size).booleanValue()) {
                CallLogData callLogData = this.f3317h.get(size);
                if (!(callLogData instanceof SeperatorCallLog)) {
                    arrayList.add(callLogData);
                    this.f3318i.remove(size);
                }
            }
        }
        m4589b("<CIH> : 'mCheckedList.size()' = " + this.f3318i.size());
        this.f3320k.m4429b(arrayList);
    }

    /* renamed from: a */
    private void m4587a(String str) {
        C3250y.m11442a(str, "[DeleteCallLogActivity]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m4589b(String str) {
        C3250y.m11453c(str, "[DeleteCallLogActivity]");
    }

    /* renamed from: a */
    public void m4604a(boolean z) {
        if (this.f3322m != null && this.f3322m.findItem(R.id.menu_done) != null) {
            this.f3322m.findItem(R.id.menu_done).setEnabled(z);
        }
    }

    /* renamed from: e */
    private void m4595e() {
        C0847a.m4634a(true);
        this.f3313d = (RelativeLayout) this.f3310a.findViewById(R.id.select_all_layout);
        this.f3314e = (CheckBox) this.f3310a.findViewById(R.id.select_all_checkbox);
        this.f3315f = (ListView) this.f3310a.findViewById(R.id.calllog_list);
        this.f3320k.m4427a(this.f3321l);
        m4604a(false);
        this.f3313d.setOnClickListener(this);
        this.f3314e.setOnClickListener(this);
        this.f3315f.setOnItemClickListener(new C0886z(this));
    }

    /* renamed from: f */
    private void m4597f() {
        Intent intent = getActivity().getIntent();
        m4589b("<CIH> : 'intent' = " + intent.toString());
        Integer numValueOf = Integer.valueOf(intent.getExtras().getInt("from_intent"));
        HashMap<Set<String>, String> mapM4426a = this.f3320k.m4426a();
        m4589b("<CIH> : 'where' = " + numValueOf);
        if (numValueOf != null) {
            C0847a.m4634a(true);
            switch (numValueOf.intValue()) {
                case 1:
                    m4589b("<CIH> : 'where' = FROM_BUDDY_PROFILE_ACTIVITY");
                    long j = intent.getExtras().getLong("profile_userno");
                    this.f3319j = new C0882v();
                    this.f3317h = this.f3320k.m4422a(j, true);
                    this.f3316g = new C0847a(getActivity(), 0, this.f3317h, mapM4426a, this.f3321l, this.f3319j, this.f3318i, null);
                    break;
                case 2:
                    m4589b("<CIH> : 'where' = FROM_CALLLOG_ACTIVITY");
                    this.f3319j = new C0882v();
                    this.f3317h = this.f3320k.m4421a(CallLogFragment.m4564b(), true);
                    this.f3316g = new C0847a(getActivity(), 0, this.f3317h, mapM4426a, this.f3321l, this.f3319j, this.f3318i, null);
                    break;
                case 3:
                    m4589b("<CIH> : 'where' = FROM_CALLLOG_DETAIL_ACTIVITY");
                    CallLogData callLogData = (CallLogData) intent.getParcelableExtra("calllogdata");
                    this.f3317h = this.f3320k.m4424a(callLogData.m4471a(), true);
                    this.f3319j = new C0870l(callLogData);
                    this.f3316g = new C0847a(getActivity(), 0, this.f3317h, mapM4426a, this.f3321l, this.f3319j, this.f3318i, null);
                    break;
                default:
                    m4587a("<CIH> : Here is a access restriction area!");
                    break;
            }
            if (this.f3317h == null) {
                ((InterfaceC0849ab) getActivity()).mo4584c();
                return;
            }
            m4589b("<CIH> : 'mCallLogList.size()' = " + this.f3317h.size());
            if (this.f3318i != null && this.f3318i.size() <= 0) {
                for (int i = 0; i < this.f3317h.size(); i++) {
                    this.f3318i.add(false);
                }
            }
            if (numValueOf.intValue() == 2) {
                this.f3316g.m4637a(this.f3318i);
            }
            this.f3315f.setAdapter((ListAdapter) this.f3316g);
            return;
        }
        m4587a("<CIH> : <<<<<< intent 'where' is Emptry >>>>>>");
        m4587a("<CIH> : Here is a access restriction area!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m4598g() {
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.f3318i.size(); i3++) {
            CallLogData callLogData = this.f3317h.get(i3);
            if (!(callLogData instanceof SeperatorCallLog)) {
                i2++;
            }
            if (!(callLogData instanceof SeperatorCallLog) && this.f3318i.get(i3).booleanValue()) {
                i++;
            }
        }
        if (i2 <= i) {
            this.f3314e.setChecked(true);
        } else {
            this.f3314e.setChecked(false);
        }
        if (i == 0) {
            m4604a(false);
        } else {
            m4604a(true);
        }
    }

    /* renamed from: b */
    public void m4606b(boolean z) {
        m4589b("<CIH> 'mCheckedList.size()' = " + this.f3316g.m4636a());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f3316g.m4636a()) {
                if (!(this.f3317h.get(i2) instanceof SeperatorCallLog)) {
                    this.f3318i.set(i2, Boolean.valueOf(z));
                }
                i = i2 + 1;
            } else {
                this.f3316g.notifyDataSetChanged();
                return;
            }
        }
    }

    /* renamed from: b */
    public int m4605b() {
        int i = 0;
        int size = this.f3318i.size() - 1;
        while (size >= 0) {
            int i2 = ((this.f3317h.get(size) instanceof SeperatorCallLog) || !this.f3318i.get(size).booleanValue()) ? i : i + 1;
            size--;
            i = i2;
        }
        return i;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f3310a = layoutInflater.inflate(R.layout.delete_calllog2, viewGroup, false);
        m4595e();
        m4597f();
        BaseActivity.m3081a(this, true);
        return this.f3310a;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m4598g();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        C0847a.m4634a(false);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        C0847a.m4634a(false);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        m4589b("<CIH> onConfigurationChanged()");
        super.onConfigurationChanged(configuration);
        m4603a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.select_all_layout /* 2131165495 */:
                m4589b("<CIH> Select all layout is pressed");
                if (this.f3314e.isChecked()) {
                    this.f3314e.setChecked(false);
                    m4604a(false);
                } else {
                    this.f3314e.setChecked(true);
                    m4604a(true);
                }
                m4606b(this.f3314e.isChecked());
                break;
            case R.id.select_all_checkbox /* 2131165496 */:
                m4589b("<CIH> Select all button is pressed");
                if (this.f3314e.isChecked()) {
                    this.f3314e.setChecked(true);
                    m4604a(true);
                } else {
                    this.f3314e.setChecked(false);
                    m4604a(false);
                }
                m4606b(this.f3314e.isChecked());
                break;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menu.clear();
        menuInflater.inflate(R.menu.done_menu, menu);
        this.f3322m = menu;
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.menu_done).setEnabled(false);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                m4589b("<CIH> Back button is pressed");
                C0847a.m4634a(false);
                ((InterfaceC0849ab) getActivity()).mo4584c();
                break;
            case R.id.menu_done /* 2131166604 */:
                m4589b("<CIH> Done button is pressed");
                m4591c();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m4600h() {
        if (this.f3312c == null) {
            this.f3312c = ProgressDialogC3265l.m11490a(getActivity(), null, getResources().getString(R.string.buddy_adaptor_wait_progress), true);
        } else {
            this.f3312c.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m4602i() {
        if (this.f3312c != null && this.f3312c.isShowing()) {
            this.f3312c.dismiss();
        }
    }
}
