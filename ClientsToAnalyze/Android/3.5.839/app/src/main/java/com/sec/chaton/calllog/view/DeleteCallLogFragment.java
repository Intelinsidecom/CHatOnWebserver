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
import com.sec.chaton.calllog.manager.HandlerC1449a;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.calllog.manager.model.SeperatorCallLog;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.p123a.AbstractC4932a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class DeleteCallLogFragment extends Fragment implements View.OnClickListener {

    /* renamed from: b */
    private Dialog f5284b;

    /* renamed from: c */
    private ProgressDialog f5285c;

    /* renamed from: d */
    private RelativeLayout f5286d;

    /* renamed from: e */
    private CheckBox f5287e;

    /* renamed from: f */
    private ListView f5288f;

    /* renamed from: g */
    private C1458a f5289g;

    /* renamed from: h */
    private ArrayList<CallLogData> f5290h;

    /* renamed from: j */
    private InterfaceC1492u f5292j;

    /* renamed from: m */
    private Menu f5295m;

    /* renamed from: a */
    private View f5283a = null;

    /* renamed from: i */
    private List<Boolean> f5291i = new ArrayList();

    /* renamed from: k */
    private final HandlerC1449a f5293k = CallLogFragment.f5260f;

    /* renamed from: l */
    private final HandlerC1459aa f5294l = new HandlerC1459aa(this, null);

    /* renamed from: c */
    private void m7747c() {
        String string;
        String string2;
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(getActivity());
        if (this.f5287e.isChecked()) {
            string = getString(R.string.create_delete_msg_dialog_title_with_count, Integer.valueOf(m7761b()));
            string2 = getString(R.string.calllog_all_delete);
        } else if (m7761b() == 1) {
            string = getString(R.string.create_delete_msg_dialog_title);
            string2 = getString(R.string.calllog_delete);
        } else {
            string = getString(R.string.create_delete_msg_dialog_title_with_count, Integer.valueOf(m7761b()));
            string2 = getString(R.string.calllog_some_delete);
        }
        abstractC4932aM18733a.mo18740a(string);
        abstractC4932aM18733a.mo18749b(string2);
        abstractC4932aM18733a.mo18756d(R.string.alert_dialog_ok, new DialogInterfaceOnClickListenerC1494w(this));
        abstractC4932aM18733a.mo18747b(R.string.cancel, new DialogInterfaceOnClickListenerC1495x(this));
        abstractC4932aM18733a.mo18751b(true);
        abstractC4932aM18733a.mo18737a(new DialogInterfaceOnCancelListenerC1496y(this));
        if (this.f5284b != null && this.f5284b.isShowing()) {
            if (this.f5284b.isShowing()) {
                this.f5284b.dismiss();
            }
            this.f5284b = null;
        }
        this.f5284b = abstractC4932aM18733a.mo18745a().mo18758a();
        this.f5284b.show();
    }

    /* renamed from: a */
    public void m7759a() {
        m7753f();
        this.f5289g.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m7749d() {
        ArrayList<CallLogData> arrayList = new ArrayList<>();
        arrayList.clear();
        for (int size = this.f5291i.size() - 1; size >= 0; size--) {
            if (this.f5291i.get(size).booleanValue()) {
                CallLogData callLogData = this.f5290h.get(size);
                if (!(callLogData instanceof SeperatorCallLog)) {
                    arrayList.add(callLogData);
                    this.f5291i.remove(size);
                }
            }
        }
        m7745b("<CIH> : 'mCheckedList.size()' = " + this.f5291i.size());
        this.f5293k.m7583b(arrayList);
    }

    /* renamed from: a */
    private void m7743a(String str) {
        C4904y.m18634a(str, "[DeleteCallLogActivity]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m7745b(String str) {
        C4904y.m18641c(str, "[DeleteCallLogActivity]");
    }

    /* renamed from: a */
    public void m7760a(boolean z) {
        if (this.f5295m != null && this.f5295m.findItem(R.id.menu_done) != null) {
            this.f5295m.findItem(R.id.menu_done).setEnabled(z);
        }
    }

    /* renamed from: e */
    private void m7751e() {
        C1458a.m7790a(true);
        this.f5286d = (RelativeLayout) this.f5283a.findViewById(R.id.select_all_layout);
        this.f5287e = (CheckBox) this.f5283a.findViewById(R.id.select_all_checkbox);
        this.f5288f = (ListView) this.f5283a.findViewById(R.id.calllog_list);
        this.f5293k.m7581a(this.f5294l);
        m7760a(false);
        this.f5286d.setOnClickListener(this);
        this.f5287e.setOnClickListener(this);
        this.f5288f.setOnItemClickListener(new C1497z(this));
    }

    /* renamed from: f */
    private void m7753f() {
        Intent intent = getActivity().getIntent();
        m7745b("<CIH> : 'intent' = " + intent.toString());
        Integer numValueOf = Integer.valueOf(intent.getExtras().getInt("from_intent"));
        HashMap<Set<String>, String> mapM7580a = this.f5293k.m7580a();
        m7745b("<CIH> : 'where' = " + numValueOf);
        if (numValueOf != null) {
            C1458a.m7790a(true);
            switch (numValueOf.intValue()) {
                case 1:
                    m7745b("<CIH> : 'where' = FROM_BUDDY_PROFILE_ACTIVITY");
                    long j = intent.getExtras().getLong("profile_userno");
                    this.f5292j = new C1493v();
                    this.f5290h = this.f5293k.m7576a(j, true);
                    this.f5289g = new C1458a(getActivity(), 0, this.f5290h, mapM7580a, this.f5294l, this.f5292j, this.f5291i, null);
                    break;
                case 2:
                    m7745b("<CIH> : 'where' = FROM_CALLLOG_ACTIVITY");
                    this.f5292j = new C1493v();
                    this.f5290h = this.f5293k.m7575a(CallLogFragment.m7719b(), true);
                    this.f5289g = new C1458a(getActivity(), 0, this.f5290h, mapM7580a, this.f5294l, this.f5292j, this.f5291i, null);
                    break;
                case 3:
                    m7745b("<CIH> : 'where' = FROM_CALLLOG_DETAIL_ACTIVITY");
                    CallLogData callLogData = (CallLogData) intent.getParcelableExtra("calllogdata");
                    this.f5290h = this.f5293k.m7578a(callLogData.m7625a(), true);
                    this.f5292j = new C1481l(callLogData);
                    this.f5289g = new C1458a(getActivity(), 0, this.f5290h, mapM7580a, this.f5294l, this.f5292j, this.f5291i, null);
                    break;
                default:
                    m7743a("<CIH> : Here is a access restriction area!");
                    break;
            }
            if (this.f5290h == null) {
                ((InterfaceC1460ab) getActivity()).mo7740h();
                return;
            }
            m7745b("<CIH> : 'mCallLogList.size()' = " + this.f5290h.size());
            if (this.f5291i != null && this.f5291i.size() <= 0) {
                for (int i = 0; i < this.f5290h.size(); i++) {
                    this.f5291i.add(false);
                }
            }
            if (numValueOf.intValue() == 2) {
                this.f5289g.m7793a(this.f5291i);
            }
            this.f5288f.setAdapter((ListAdapter) this.f5289g);
            return;
        }
        m7743a("<CIH> : <<<<<< intent 'where' is Emptry >>>>>>");
        m7743a("<CIH> : Here is a access restriction area!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m7754g() {
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.f5291i.size(); i3++) {
            CallLogData callLogData = this.f5290h.get(i3);
            if (!(callLogData instanceof SeperatorCallLog)) {
                i2++;
            }
            if (!(callLogData instanceof SeperatorCallLog) && this.f5291i.get(i3).booleanValue()) {
                i++;
            }
        }
        if (i2 <= i) {
            this.f5287e.setChecked(true);
        } else {
            this.f5287e.setChecked(false);
        }
        if (i == 0) {
            m7760a(false);
        } else {
            m7760a(true);
        }
    }

    /* renamed from: b */
    public void m7762b(boolean z) {
        m7745b("<CIH> 'mCheckedList.size()' = " + this.f5289g.m7792a());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f5289g.m7792a()) {
                if (!(this.f5290h.get(i2) instanceof SeperatorCallLog)) {
                    this.f5291i.set(i2, Boolean.valueOf(z));
                }
                i = i2 + 1;
            } else {
                this.f5289g.notifyDataSetChanged();
                return;
            }
        }
    }

    /* renamed from: b */
    public int m7761b() {
        int i = 0;
        int size = this.f5291i.size() - 1;
        while (size >= 0) {
            int i2 = ((this.f5290h.get(size) instanceof SeperatorCallLog) || !this.f5291i.get(size).booleanValue()) ? i : i + 1;
            size--;
            i = i2;
        }
        return i;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5283a = layoutInflater.inflate(R.layout.delete_calllog2, viewGroup, false);
        m7751e();
        m7753f();
        BaseActivity.m6160a((Fragment) this, true);
        return this.f5283a;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m7754g();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        C1458a.m7790a(false);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        C1458a.m7790a(false);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        m7745b("<CIH> onConfigurationChanged()");
        super.onConfigurationChanged(configuration);
        m7759a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.select_all_layout /* 2131165527 */:
                m7745b("<CIH> Select all layout is pressed");
                if (this.f5287e.isChecked()) {
                    this.f5287e.setChecked(false);
                    m7760a(false);
                } else {
                    this.f5287e.setChecked(true);
                    m7760a(true);
                }
                m7762b(this.f5287e.isChecked());
                break;
            case R.id.select_all_checkbox /* 2131165528 */:
                m7745b("<CIH> Select all button is pressed");
                if (this.f5287e.isChecked()) {
                    this.f5287e.setChecked(true);
                    m7760a(true);
                } else {
                    this.f5287e.setChecked(false);
                    m7760a(false);
                }
                m7762b(this.f5287e.isChecked());
                break;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menu.clear();
        menuInflater.inflate(R.menu.done_menu, menu);
        this.f5295m = menu;
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
                m7745b("<CIH> Back button is pressed");
                C1458a.m7790a(false);
                ((InterfaceC1460ab) getActivity()).mo7740h();
                break;
            case R.id.menu_done /* 2131166685 */:
                m7745b("<CIH> Done button is pressed");
                m7747c();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m7756h() {
        if (this.f5285c == null) {
            this.f5285c = ProgressDialogC4926s.m18728a(getActivity(), null, getResources().getString(R.string.buddy_adaptor_wait_progress), true);
        } else {
            this.f5285c.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m7758i() {
        if (this.f5285c != null && this.f5285c.isShowing()) {
            this.f5285c.dismiss();
        }
    }
}
