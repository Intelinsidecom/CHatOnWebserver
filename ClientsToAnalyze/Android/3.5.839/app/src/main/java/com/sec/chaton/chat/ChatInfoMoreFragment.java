package com.sec.chaton.chat;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.buddy.InterfaceC1260du;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p065io.entry.inner.Buddy;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ChatInfoMoreFragment extends Fragment implements InterfaceC1260du {

    /* renamed from: a */
    public static final String f5816a = ChatInfoMoreActivity.class.getSimpleName();

    /* renamed from: b */
    private Activity f5817b;

    /* renamed from: c */
    private String f5818c;

    /* renamed from: d */
    private String f5819d;

    /* renamed from: e */
    private int f5820e;

    /* renamed from: f */
    private String[] f5821f;

    /* renamed from: g */
    private ArrayList<String> f5822g;

    /* renamed from: h */
    private ArrayList<C1106c> f5823h;

    /* renamed from: i */
    private ArrayList<Buddy> f5824i;

    /* renamed from: k */
    private AlertDialogC1716fp f5826k;

    /* renamed from: l */
    private BuddyFragment f5827l;

    /* renamed from: j */
    private ProgressDialog f5825j = null;

    /* renamed from: m */
    private Handler f5828m = new HandlerC1712fl(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C4904y.m18639b("onCreate()", f5816a);
        m8336b();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.chat_info_more, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        BuddyFragment buddyFragment;
        super.onActivityCreated(bundle);
        if (bundle == null) {
            buddyFragment = new BuddyFragment();
            buddyFragment.setArguments(getArguments());
            getActivity().m50e().mo183a().mo96a(R.id.fragment_buddy_list, buddyFragment, "com.sec.chaton:buddy_fragment").mo99b();
            buddyFragment.m6586a(this);
        } else {
            buddyFragment = (BuddyFragment) getActivity().m50e().mo180a(R.id.fragment_buddy_list);
            buddyFragment.m6586a(this);
        }
        this.f5827l = buddyFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f5817b = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f5817b = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        m8341d();
    }

    @Override // com.sec.chaton.buddy.InterfaceC1260du
    /* renamed from: a */
    public void mo7417a(ArrayList<ArrayList<C1106c>> arrayList, String[] strArr) {
        if (strArr.length <= C1427a.m7524g()) {
            if (this.f5827l != null) {
                this.f5827l.m6590a(false);
            }
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                sb.append(str).append(",");
            }
            C4904y.m18641c(sb.toString(), f5816a);
            this.f5823h = new ArrayList<>();
            this.f5824i = new ArrayList<>();
            this.f5822g = new ArrayList<>();
            for (int i = 0; i < arrayList.size(); i++) {
                ArrayList<C1106c> arrayList2 = arrayList.get(i);
                for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                    C1106c c1106c = arrayList2.get(i2);
                    int i3 = 0;
                    while (true) {
                        if (i3 >= strArr.length) {
                            break;
                        }
                        if (!c1106c.m7046a().equals(strArr[i3])) {
                            i3++;
                        } else {
                            this.f5823h.add(c1106c);
                            break;
                        }
                    }
                }
            }
            StringBuilder sb2 = new StringBuilder();
            Iterator<C1106c> it = this.f5823h.iterator();
            while (it.hasNext()) {
                C1106c next = it.next();
                if ("unknown_buddy".equals(next.m7040C())) {
                    sb2.append(next.m7051b()).append(",");
                    this.f5822g.add(next.m7046a());
                }
            }
            if (sb2.length() > 0) {
                sb2.deleteCharAt(sb2.length() - 1);
                String strReplaceAll = sb2.toString().replaceAll("\n", " ");
                AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f5817b);
                abstractC4932aM18733a.mo18734a(R.string.buddy_add_contact).mo18751b(true);
                if (this.f5822g.size() > 1) {
                    abstractC4932aM18733a.mo18749b(getResources().getString(R.string.new_buddies_information, Integer.valueOf(this.f5822g.size())));
                } else {
                    abstractC4932aM18733a.mo18749b(getResources().getString(R.string.new_buddy_information, strReplaceAll));
                }
                abstractC4932aM18733a.mo18756d(R.string.edit_group_add_member, new DialogInterfaceOnClickListenerC1714fn(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1713fm(this));
                abstractC4932aM18733a.mo18752b();
                return;
            }
            m8350a();
            return;
        }
        C5179v.m19811a(GlobalApplication.m18732r(), getResources().getString(R.string.buddy_list_select_maximum_contacts, Integer.valueOf(C1427a.m7524g())), 0).show();
    }

    /* renamed from: a */
    public void m8350a() {
        if (this.f5817b == null) {
            if (C4904y.f17873c) {
                C4904y.m18641c("activity is null. don't show strong dialog", f5816a);
            }
        } else {
            this.f5826k = new AlertDialogC1716fp(this, getActivity());
            this.f5826k.show();
        }
    }

    /* renamed from: b */
    private void m8336b() {
        this.f5818c = getArguments().getString("inboxNO");
        this.f5819d = getArguments().getString("buddyNO");
        this.f5820e = getArguments().getInt("chatType");
        if (getArguments().containsKey(ChatFragment.f5465d)) {
            this.f5821f = getArguments().getStringArray(ChatFragment.f5465d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        C4904y.m18639b("onActivityResult()", f5816a);
        if (i == 5 && i2 == -1) {
            String[] stringArrayExtra = intent.getStringArrayExtra("receivers");
            Intent intent2 = new Intent(getActivity(), (Class<?>) ChatActivity.class);
            intent2.putExtra("receivers", stringArrayExtra);
            intent2.putExtra("inboxNO", this.f5818c);
            intent2.putExtra("buddyNO", this.f5819d);
            intent2.putExtra("chatType", this.f5820e);
            getActivity().setResult(-1, intent2);
            ((InterfaceC1722fv) getActivity()).mo8333h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m8339c() throws Resources.NotFoundException {
        if (this.f5817b == null) {
            if (C4904y.f17873c) {
                C4904y.m18641c("activity is null. don't show strong dialog", f5816a);
                return;
            }
            return;
        }
        m8335a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m8341d() {
        if (this.f5825j != null) {
            this.f5825j.dismiss();
            this.f5825j = null;
        }
    }

    /* renamed from: a */
    private void m8335a(boolean z) throws Resources.NotFoundException {
        if (this.f5825j == null) {
            this.f5825j = ProgressDialog.show(getActivity(), null, getResources().getString(R.string.dialog_connecting_server));
            this.f5825j.setCancelable(false);
            this.f5825j.setOnKeyListener(new DialogInterfaceOnKeyListenerC1715fo(this, z));
            return;
        }
        this.f5825j.show();
    }
}
