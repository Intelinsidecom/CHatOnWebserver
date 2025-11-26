package com.sec.chaton.settings.tellfriends.common;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.settings.tellfriends.AbstractC2724aa;
import com.sec.chaton.settings.tellfriends.C2732ai;
import com.sec.chaton.settings.tellfriends.C2733aj;
import com.sec.chaton.settings.tellfriends.C2735al;
import com.sec.chaton.settings.tellfriends.C2737an;
import com.sec.chaton.settings.tellfriends.C2739ap;
import com.sec.chaton.settings.tellfriends.C2831y;
import com.sec.chaton.settings.tellfriends.InterfaceC2727ad;
import com.sec.common.p063a.InterfaceC3274d;
import com.sec.widget.C3641ai;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class SnsFriendsPickerFragment<T extends AbstractC2724aa> extends Fragment implements View.OnClickListener, InterfaceC2791g {

    /* renamed from: d */
    private Activity f10222d;

    /* renamed from: e */
    private View f10223e;

    /* renamed from: f */
    private ListView f10224f;

    /* renamed from: g */
    private Button f10225g;

    /* renamed from: h */
    private Button f10226h;

    /* renamed from: k */
    private Class<T> f10229k;

    /* renamed from: l */
    private T f10230l;

    /* renamed from: m */
    private C1330h f10231m;

    /* renamed from: c */
    private long[] f10221c = null;

    /* renamed from: i */
    private ProgressDialog f10227i = null;

    /* renamed from: j */
    private InterfaceC3274d f10228j = null;

    /* renamed from: a */
    public C2788d f10219a = null;

    /* renamed from: n */
    private ArrayList<C2732ai> f10232n = new ArrayList<>();

    /* renamed from: o */
    private final Map<String, C2732ai> f10233o = new HashMap();

    /* renamed from: p */
    private InterfaceC2727ad f10234p = new C2795k(this);

    /* renamed from: b */
    public Handler f10220b = new HandlerC2796l(this);

    /* renamed from: a */
    protected abstract Class<T> mo9703a();

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f10230l = (T) m9942d();
        this.f10231m = new C1330h(this.f10220b);
        View viewM9927a = m9927a(layoutInflater, viewGroup);
        m9948g();
        return viewM9927a;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10229k = mo9703a();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f10222d = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        m9956k();
        this.f10233o.clear();
        this.f10230l.mo9767a();
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f10222d = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.f10222d.finish();
        return true;
    }

    /* renamed from: a */
    private View m9927a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_tell_friends_chaton_list, viewGroup, false);
        this.f10224f = (ListView) viewInflate.findViewById(android.R.id.list);
        this.f10223e = viewInflate.findViewById(R.id.sns_ignore_add_all_button);
        this.f10225g = (Button) this.f10223e.findViewById(R.id.button2);
        this.f10225g.setText(getResources().getString(R.string.buddy_suggestion_ignore_all));
        this.f10226h = (Button) this.f10223e.findViewById(R.id.button3);
        this.f10226h.setText(getResources().getString(R.string.buddy_suggestion_add_all));
        this.f10225g.setOnClickListener(this);
        this.f10226h.setOnClickListener(this);
        ((TextView) viewInflate.findViewById(R.id.text2)).setText(m9940c());
        View viewFindViewById = viewInflate.findViewById(R.id.empty);
        ((TextView) viewFindViewById.findViewById(R.id.text1)).setVisibility(8);
        ((TextView) viewFindViewById.findViewById(R.id.text2)).setText(R.string.dialog_title_noblock_item);
        ((ImageView) viewFindViewById.findViewById(R.id.image1)).setImageResource(R.drawable.no_contents_buddies);
        this.f10219a = new C2788d(this.f10222d, 0, new ArrayList(this.f10233o.values()));
        this.f10219a.m10003a(this);
        this.f10219a.m10004a(new C2793i(R.drawable.list_ic_add, m9946f()).m10012a(true).m10011a());
        this.f10224f.setAdapter((ListAdapter) this.f10219a);
        this.f10224f.setEmptyView(viewFindViewById);
        this.f10222d.setTitle(m9936b());
        this.f10219a.notifyDataSetInvalidated();
        setHasOptionsMenu(true);
        return viewInflate;
    }

    /* renamed from: b */
    private int m9936b() {
        switch (m9944e()) {
            case FACEBOOK_TYPE:
                return R.string.tellfriends_via_facebook;
            case TWITTER_TYPE:
                return R.string.tellfriends_via_twitter;
            case WEIBO_TYPE:
            case RENREN_TYPE:
                return R.string.tellfriends_via_weibo;
            default:
                return 0;
        }
    }

    /* renamed from: c */
    private int m9940c() {
        switch (m9944e()) {
            case FACEBOOK_TYPE:
            case RENREN_TYPE:
                return R.string.friends_using_chaton_facebook_header_txt;
            case TWITTER_TYPE:
                return R.string.friends_using_chaton_twitter_header_txt;
            case WEIBO_TYPE:
                return R.string.friends_using_chaton_weibo_header_txt;
            default:
                return 0;
        }
    }

    /* renamed from: d */
    private T m9942d() {
        if (this.f10229k.equals(C2733aj.class)) {
            return new C2733aj(this.f10222d);
        }
        if (this.f10229k.equals(C2737an.class)) {
            return new C2737an(this.f10222d);
        }
        if (this.f10229k.equals(C2739ap.class)) {
            return new C2739ap(this.f10222d);
        }
        if (this.f10229k.equals(C2735al.class)) {
            return new C2735al(this.f10222d);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public EnumC2798n m9944e() {
        if (this.f10230l instanceof C2733aj) {
            return EnumC2798n.FACEBOOK_TYPE;
        }
        if (this.f10230l instanceof C2737an) {
            return EnumC2798n.TWITTER_TYPE;
        }
        if (this.f10230l instanceof C2739ap) {
            return EnumC2798n.WEIBO_TYPE;
        }
        if (this.f10230l instanceof C2735al) {
            return EnumC2798n.RENREN_TYPE;
        }
        return EnumC2798n.NONE_TYPE;
    }

    /* renamed from: f */
    private int m9946f() {
        switch (m9944e()) {
            case FACEBOOK_TYPE:
                return R.drawable.sns_ic_facebook;
            case TWITTER_TYPE:
                return R.drawable.sns_ic_twitter;
            case WEIBO_TYPE:
                return R.drawable.sns_ic_weibo;
            case RENREN_TYPE:
                return R.drawable.sns_ic_renren;
            default:
                return 0;
        }
    }

    /* renamed from: g */
    private void m9948g() {
        m9950h();
        this.f10230l.mo9770a(this.f10234p);
    }

    /* renamed from: h */
    private void m9950h() {
        m9931a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m9953i() {
        if (this.f10227i != null) {
            this.f10227i.dismiss();
            this.f10227i = null;
        }
    }

    /* renamed from: a */
    private void m9931a(boolean z) {
        if (this.f10227i == null) {
            this.f10227i = ProgressDialog.show(this.f10222d, null, getResources().getString(R.string.dialog_provision_ing));
            this.f10227i.setCancelable(false);
            this.f10227i.setOnKeyListener(new DialogInterfaceOnKeyListenerC2794j(this, z));
            return;
        }
        this.f10227i.show();
    }

    /* renamed from: j */
    private void m9955j() {
        if (this.f10228j != null && this.f10228j.isShowing()) {
            this.f10228j.dismiss();
            this.f10228j = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m9956k() {
        m9953i();
        m9955j();
    }

    /* renamed from: b */
    private void m9939b(boolean z) {
        int iM6733a = C1594v.m6733a(this.f10222d);
        if (-3 == iM6733a) {
            m9930a(getResources().getString(R.string.popup_no_network_connection));
        } else if (-2 == iM6733a) {
            m9930a(getResources().getString(R.string.toast_network_unable));
        } else {
            m9930a(getResources().getString(R.string.download_failed));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m9959l() {
        m9956k();
        int iM6733a = C1594v.m6733a(this.f10222d);
        if (-3 == iM6733a) {
            m9930a(getResources().getString(R.string.popup_no_network_connection));
        } else if (-2 == iM6733a) {
            m9930a(getResources().getString(R.string.toast_network_unable));
        } else {
            C3641ai.m13210a(this.f10222d, R.string.toast_network_unable, 0).show();
        }
    }

    /* renamed from: a */
    private void m9930a(String str) {
        Toast.makeText(this.f10222d, str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m9960m() {
        m9939b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9932a(long[] jArr) {
        new C1330h(this.f10220b).m5724a(m9961n(), this.f10230l.mo9773c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public String m9961n() {
        switch (m9944e()) {
            case FACEBOOK_TYPE:
                return C2831y.f10362a;
            case TWITTER_TYPE:
                return C2831y.f10363b;
            case WEIBO_TYPE:
                return C2831y.f10364c;
            case RENREN_TYPE:
                return C2831y.f10365d;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public long[] m9935a(ArrayList<C2732ai> arrayList) {
        long[] jArr = new long[arrayList.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                jArr[i2] = Long.parseLong(arrayList.get(i2).m9783a());
                i = i2 + 1;
            } else {
                return jArr;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9928a(int i) {
        if (i == 16003) {
            C3641ai.m13210a(this.f10222d, R.string.buddy_list_dialog_addbuddy_failed_your_self, 0).show();
            return;
        }
        if (i == 16004) {
            C3641ai.m13210a(this.f10222d, R.string.buddy_list_dialog_addbuddy_failed_already_added, 0).show();
        } else if (i == 16005) {
            C3641ai.m13210a(this.f10222d, R.string.buddy_list_dialog_addbuddy_failed_block_buddy, 0).show();
        } else {
            C3641ai.m13210a(this.f10222d, R.string.buddy_list_dialog_addbuddy_network_failed, 0).show();
            this.f10222d.finish();
        }
    }

    @Override // com.sec.chaton.settings.tellfriends.common.InterfaceC2791g
    /* renamed from: a */
    public void mo9718a(C2732ai c2732ai) {
        String strM9787d = c2732ai.m9787d();
        m9950h();
        this.f10227i.setMessage(getResources().getString(R.string.wait_sending));
        if (strM9787d != null && !strM9787d.isEmpty()) {
            this.f10231m.m5730b(strM9787d);
        } else {
            m9956k();
        }
    }
}
