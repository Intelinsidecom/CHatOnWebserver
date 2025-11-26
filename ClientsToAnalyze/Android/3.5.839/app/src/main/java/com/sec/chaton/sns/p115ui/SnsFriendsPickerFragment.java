package com.sec.chaton.sns.p115ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.sns.p113a.C4368e;
import com.sec.chaton.sns.p114b.AbstractC4439w;
import com.sec.chaton.sns.p114b.C4379ae;
import com.sec.chaton.sns.p114b.C4380af;
import com.sec.chaton.sns.p114b.C4382ah;
import com.sec.chaton.sns.p114b.C4384aj;
import com.sec.chaton.sns.p114b.C4386al;
import com.sec.chaton.sns.p114b.C4388an;
import com.sec.chaton.sns.p114b.C4392ar;
import com.sec.chaton.sns.p114b.InterfaceC4442z;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class SnsFriendsPickerFragment<T extends AbstractC4439w> extends Fragment implements View.OnClickListener, InterfaceC4511t {

    /* renamed from: d */
    private Activity f16019d;

    /* renamed from: e */
    private View f16020e;

    /* renamed from: f */
    private ListView f16021f;

    /* renamed from: g */
    private Button f16022g;

    /* renamed from: h */
    private Button f16023h;

    /* renamed from: i */
    private ViewStub f16024i;

    /* renamed from: j */
    private View f16025j;

    /* renamed from: k */
    private ImageView f16026k;

    /* renamed from: l */
    private TextView f16027l;

    /* renamed from: m */
    private TextView f16028m;

    /* renamed from: p */
    private Class<T> f16031p;

    /* renamed from: q */
    private T f16032q;

    /* renamed from: r */
    private C2128i f16033r;

    /* renamed from: c */
    private long[] f16018c = null;

    /* renamed from: n */
    private ProgressDialog f16029n = null;

    /* renamed from: o */
    private InterfaceC4936e f16030o = null;

    /* renamed from: a */
    public C4504q f16016a = null;

    /* renamed from: s */
    private ArrayList<C4379ae> f16034s = new ArrayList<>();

    /* renamed from: t */
    private final Map<String, C4379ae> f16035t = new HashMap();

    /* renamed from: u */
    private InterfaceC4442z f16036u = new C4521x(this);

    /* renamed from: b */
    public Handler f16017b = new HandlerC4522y(this);

    /* renamed from: a */
    protected abstract Class<T> mo16887a();

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f16032q = (T) m16866d();
        this.f16033r = new C2128i(this.f16017b);
        View viewM16851a = m16851a(layoutInflater, viewGroup);
        m16872g();
        return viewM16851a;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f16031p = mo16887a();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f16019d = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        m16880k();
        this.f16035t.clear();
        this.f16032q.mo16639a();
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f16019d = null;
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
        this.f16019d.finish();
        return true;
    }

    /* renamed from: a */
    private View m16851a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_tell_friends_chaton_list, viewGroup, false);
        this.f16021f = (ListView) viewInflate.findViewById(android.R.id.list);
        this.f16020e = viewInflate.findViewById(R.id.sns_ignore_add_all_button);
        this.f16022g = (Button) this.f16020e.findViewById(R.id.button2);
        this.f16022g.setText(getResources().getString(R.string.buddy_suggestion_ignore_all));
        this.f16023h = (Button) this.f16020e.findViewById(R.id.button3);
        this.f16023h.setText(getResources().getString(R.string.buddy_suggestion_add_all));
        this.f16022g.setOnClickListener(this);
        this.f16023h.setOnClickListener(this);
        ((TextView) viewInflate.findViewById(R.id.text2)).setText(m16864c());
        this.f16024i = (ViewStub) viewInflate.findViewById(R.id.empty);
        this.f16016a = new C4504q(this.f16019d, 0, new ArrayList(this.f16035t.values()));
        this.f16016a.m17055a(this);
        this.f16016a.m17056a(new C4515v(R.drawable.list_ic_add, m16870f()).m17088a(true).m17087a());
        this.f16021f.setAdapter((ListAdapter) this.f16016a);
        if (this.f16016a.getCount() <= 0) {
            m16886o();
        }
        this.f16019d.setTitle(m16860b());
        this.f16016a.notifyDataSetInvalidated();
        setHasOptionsMenu(true);
        return viewInflate;
    }

    /* renamed from: b */
    private int m16860b() {
        switch (m16868e()) {
            case FACEBOOK_TYPE:
                return R.string.tellfriends_via_facebook;
            case TWITTER_TYPE:
                return R.string.tellfriends_via_twitter;
            case WEIBO_TYPE:
                return R.string.tellfriends_via_weibo;
            case RENREN_TYPE:
            case VKONTAKTE_TYPE:
                return R.string.tellfriends_via_vkontakte;
            case ODNOKLASSNIKI_TYPE:
                return R.string.tellfriends_via_odnoklassniki;
            default:
                return 0;
        }
    }

    /* renamed from: c */
    private int m16864c() {
        switch (m16868e()) {
            case FACEBOOK_TYPE:
            case RENREN_TYPE:
                return R.string.friends_using_chaton_facebook_header_txt;
            case TWITTER_TYPE:
                return R.string.friends_using_chaton_twitter_header_txt;
            case WEIBO_TYPE:
                return R.string.friends_using_chaton_weibo_header_txt;
            case VKONTAKTE_TYPE:
                return R.string.friends_using_chaton_vkontakte_header_txt;
            case ODNOKLASSNIKI_TYPE:
                return R.string.friends_using_chaton_odnoklassniki_header_txt;
            default:
                return 0;
        }
    }

    /* renamed from: d */
    private T m16866d() {
        if (this.f16031p.equals(C4380af.class)) {
            return new C4380af(this.f16019d);
        }
        if (this.f16031p.equals(C4386al.class)) {
            return new C4386al(this.f16019d);
        }
        if (this.f16031p.equals(C4392ar.class)) {
            return new C4392ar(this.f16019d);
        }
        if (this.f16031p.equals(C4384aj.class)) {
            return new C4384aj(this.f16019d);
        }
        if (this.f16031p.equals(C4382ah.class)) {
            return new C4382ah(this.f16019d);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public EnumC4447aa m16868e() {
        if (this.f16032q instanceof C4380af) {
            return EnumC4447aa.FACEBOOK_TYPE;
        }
        if (this.f16032q instanceof C4386al) {
            return EnumC4447aa.TWITTER_TYPE;
        }
        if (this.f16032q instanceof C4392ar) {
            return EnumC4447aa.WEIBO_TYPE;
        }
        if (this.f16032q instanceof C4384aj) {
            return EnumC4447aa.RENREN_TYPE;
        }
        if (this.f16032q instanceof C4388an) {
            return EnumC4447aa.VKONTAKTE_TYPE;
        }
        if (this.f16032q instanceof C4382ah) {
            return EnumC4447aa.ODNOKLASSNIKI_TYPE;
        }
        return EnumC4447aa.NONE_TYPE;
    }

    /* renamed from: f */
    private int m16870f() {
        switch (m16868e()) {
            case FACEBOOK_TYPE:
                return R.drawable.sns_ic_facebook;
            case TWITTER_TYPE:
                return R.drawable.sns_ic_twitter;
            case WEIBO_TYPE:
                return R.drawable.sns_ic_weibo;
            case RENREN_TYPE:
            case VKONTAKTE_TYPE:
                return R.drawable.vkontakte_btn_normal;
            case ODNOKLASSNIKI_TYPE:
                return R.drawable.odnoklassniki_btn_normal;
            default:
                return 0;
        }
    }

    /* renamed from: g */
    private void m16872g() {
        m16874h();
        this.f16032q.mo16644a(this.f16036u);
    }

    /* renamed from: h */
    private void m16874h() {
        m16855a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m16877i() {
        if (this.f16029n != null) {
            this.f16029n.dismiss();
            this.f16029n = null;
        }
    }

    /* renamed from: a */
    private void m16855a(boolean z) {
        if (this.f16029n == null) {
            this.f16029n = ProgressDialog.show(this.f16019d, null, getResources().getString(R.string.dialog_provision_ing));
            this.f16029n.setCancelable(false);
            this.f16029n.setOnKeyListener(new DialogInterfaceOnKeyListenerC4518w(this, z));
            return;
        }
        this.f16029n.show();
    }

    /* renamed from: j */
    private void m16879j() {
        if (this.f16030o != null && this.f16030o.isShowing()) {
            this.f16030o.dismiss();
            this.f16030o = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m16880k() {
        m16877i();
        m16879j();
    }

    /* renamed from: b */
    private void m16863b(boolean z) {
        int iM10677a = C2471v.m10677a(this.f16019d);
        if (-3 == iM10677a) {
            m16854a(getResources().getString(R.string.popup_no_network_connection));
        } else if (-2 == iM10677a) {
            m16854a(getResources().getString(R.string.toast_network_unable));
        } else {
            m16854a(getResources().getString(R.string.download_failed));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m16883l() {
        m16880k();
        int iM10677a = C2471v.m10677a(this.f16019d);
        if (-3 == iM10677a) {
            m16854a(getResources().getString(R.string.popup_no_network_connection));
        } else if (-2 == iM10677a) {
            m16854a(getResources().getString(R.string.toast_network_unable));
        } else {
            C5179v.m19810a(this.f16019d, R.string.toast_network_unable, 0).show();
        }
    }

    /* renamed from: a */
    private void m16854a(String str) {
        Toast.makeText(this.f16019d, str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m16884m() {
        m16863b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16856a(long[] jArr) {
        new C2128i(this.f16017b).m9500a(m16885n(), this.f16032q.mo16648c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public String m16885n() {
        switch (m16868e()) {
            case FACEBOOK_TYPE:
                return C4368e.f15815a;
            case TWITTER_TYPE:
                return C4368e.f15816b;
            case WEIBO_TYPE:
                return C4368e.f15817c;
            case RENREN_TYPE:
                return C4368e.f15819e;
            case VKONTAKTE_TYPE:
                return C4368e.f15820f;
            case ODNOKLASSNIKI_TYPE:
                return C4368e.f15818d;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public long[] m16859a(ArrayList<C4379ae> arrayList) {
        long[] jArr = new long[arrayList.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                jArr[i2] = Long.parseLong(arrayList.get(i2).m16625a());
                i = i2 + 1;
            } else {
                return jArr;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16852a(int i) {
        if (i == 16003) {
            C5179v.m19810a(this.f16019d, R.string.buddy_list_dialog_addbuddy_failed_your_self, 0).show();
            return;
        }
        if (i == 16004) {
            C5179v.m19810a(this.f16019d, R.string.buddy_list_dialog_addbuddy_failed_already_added, 0).show();
        } else if (i == 16005) {
            C5179v.m19810a(this.f16019d, R.string.buddy_list_dialog_addbuddy_failed_block_buddy, 0).show();
        } else {
            C5179v.m19810a(this.f16019d, R.string.buddy_list_dialog_addbuddy_network_failed, 0).show();
            this.f16019d.finish();
        }
    }

    @Override // com.sec.chaton.sns.p115ui.InterfaceC4511t
    /* renamed from: a */
    public void mo16888a(C4379ae c4379ae) {
        String strM16629d = c4379ae.m16629d();
        m16874h();
        this.f16029n.setMessage(getResources().getString(R.string.wait_sending));
        if (!TextUtils.isEmpty(strM16629d)) {
            this.f16033r.m9508b(strM16629d);
        } else {
            m16880k();
        }
    }

    /* renamed from: o */
    private void m16886o() {
        if (this.f16025j == null) {
            this.f16025j = this.f16024i.inflate();
            this.f16026k = (ImageView) this.f16025j.findViewById(R.id.image1);
            this.f16026k.setImageResource(R.drawable.no_contents_buddies);
            this.f16027l = (TextView) this.f16025j.findViewById(R.id.text1);
            this.f16027l.setVisibility(8);
            this.f16028m = (TextView) this.f16025j.findViewById(R.id.text2);
            this.f16028m.setText(getResources().getString(R.string.dialog_title_noblock_item));
            this.f16021f.setEmptyView(this.f16024i);
        }
    }
}
