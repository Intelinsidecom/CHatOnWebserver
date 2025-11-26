package com.sec.chaton.chat;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.buddy.InterfaceC0597da;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.p035io.entry.inner.Buddy;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ChatInfoMoreFragment extends Fragment implements InterfaceC0597da {

    /* renamed from: a */
    public static final String f3759a = ChatInfoMoreActivity.class.getSimpleName();

    /* renamed from: b */
    private Activity f3760b;

    /* renamed from: d */
    private String f3762d;

    /* renamed from: e */
    private String f3763e;

    /* renamed from: f */
    private int f3764f;

    /* renamed from: g */
    private String[] f3765g;

    /* renamed from: h */
    private ArrayList<String> f3766h;

    /* renamed from: i */
    private ArrayList<C0513c> f3767i;

    /* renamed from: l */
    private AlertDialogC1060eb f3770l;

    /* renamed from: c */
    private Context f3761c = null;

    /* renamed from: j */
    private ArrayList<Buddy> f3768j = new ArrayList<>();

    /* renamed from: k */
    private ProgressDialog f3769k = null;

    /* renamed from: m */
    private Handler f3771m = new HandlerC1055dx(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3250y.m11458g("onCreate()", f3759a);
        this.f3761c = getActivity();
        getActivity().setContentView(R.layout.chat_info_more);
        if (bundle == null) {
            BuddyFragment buddyFragment = new BuddyFragment();
            buddyFragment.setArguments(getArguments());
            getActivity().getSupportFragmentManager().beginTransaction().add(R.id.fragment_controller, buddyFragment, "com.sec.chaton:single_pane_fragment").commit();
            buddyFragment.m3426a(this);
        } else {
            ((BuddyFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment_controller)).m3426a(this);
        }
        m5069b();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3760b = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f3760b = null;
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
        m5073d();
        this.f3761c = null;
    }

    @Override // com.sec.chaton.buddy.InterfaceC0597da
    /* renamed from: a */
    public void mo4067a(ArrayList<ArrayList<C0513c>> arrayList, String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str).append(",");
        }
        C3250y.m11453c(sb.toString(), f3759a);
        this.f3767i = new ArrayList<>();
        this.f3766h = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            ArrayList<C0513c> arrayList2 = arrayList.get(i);
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                C0513c c0513c = arrayList2.get(i2);
                int i3 = 0;
                while (true) {
                    if (i3 >= strArr.length) {
                        break;
                    }
                    if (!c0513c.m3975b().equals(strArr[i3])) {
                        i3++;
                    } else {
                        this.f3767i.add(c0513c);
                        break;
                    }
                }
            }
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<C0513c> it = this.f3767i.iterator();
        while (it.hasNext()) {
            C0513c next = it.next();
            if ("unknown_buddy".equals(next.m3967D())) {
                sb2.append(next.m3976c()).append(",");
                this.f3766h.add(next.m3975b());
            }
        }
        if (sb2.length() > 0) {
            sb2.deleteCharAt(sb2.length() - 1);
            String string = sb2.toString();
            AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(getActivity());
            abstractC3271aM11494a.mo11495a(R.string.buddy_list_dialog_addbuddy_title).mo11511b(true);
            if (this.f3766h.size() > 1) {
                abstractC3271aM11494a.mo11509b(getResources().getString(R.string.new_buddies_information, string));
            } else {
                abstractC3271aM11494a.mo11509b(getResources().getString(R.string.new_buddy_information, string));
            }
            abstractC3271aM11494a.mo11515d(R.string.edit_group_add_member, new DialogInterfaceOnClickListenerC1057dz(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1056dy(this));
            abstractC3271aM11494a.mo11512b();
            return;
        }
        m5081a();
    }

    /* renamed from: a */
    public void m5081a() {
        if (this.f3761c == null) {
            if (C3250y.f11735c) {
                C3250y.m11453c("activity is null. don't show strong dialog", f3759a);
            }
        } else {
            this.f3770l = new AlertDialogC1060eb(this, getActivity());
            this.f3770l.show();
        }
    }

    /* renamed from: b */
    private void m5069b() {
        this.f3762d = getArguments().getString("inboxNO");
        this.f3763e = getArguments().getString("buddyNO");
        this.f3764f = getArguments().getInt("chatType");
        if (getArguments().containsKey(ChatFragment.f3489f)) {
            this.f3765g = getArguments().getStringArray(ChatFragment.f3489f);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        C3250y.m11458g("onActivityResult()", f3759a);
        if (i == 5 && i2 == -1) {
            String[] stringArrayExtra = intent.getStringArrayExtra("receivers");
            Intent intent2 = new Intent(getActivity(), (Class<?>) ChatActivity.class);
            intent2.putExtra("receivers", stringArrayExtra);
            intent2.putExtra("inboxNO", this.f3762d);
            intent2.putExtra("buddyNO", this.f3763e);
            intent2.putExtra("chatType", this.f3764f);
            getActivity().setResult(-1, intent2);
            ((InterfaceC1066eh) getActivity()).mo5065c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m5071c() {
        if (this.f3761c == null) {
            if (C3250y.f11735c) {
                C3250y.m11453c("activity is null. don't show strong dialog", f3759a);
                return;
            }
            return;
        }
        m5066a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m5073d() {
        if (this.f3769k != null) {
            this.f3769k.dismiss();
            this.f3769k = null;
        }
    }

    /* renamed from: a */
    private void m5066a(boolean z) {
        if (this.f3769k == null) {
            this.f3769k = ProgressDialog.show(getActivity(), null, getResources().getString(R.string.dialog_connecting_server));
            this.f3769k.setCancelable(false);
            this.f3769k.setOnKeyListener(new DialogInterfaceOnKeyListenerC1059ea(this, z));
            return;
        }
        this.f3769k.show();
    }
}
