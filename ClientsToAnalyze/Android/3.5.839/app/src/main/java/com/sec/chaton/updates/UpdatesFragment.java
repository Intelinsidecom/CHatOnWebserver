package com.sec.chaton.updates;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.api.p048a.AbstractC1019a;
import com.sec.chaton.api.p048a.C1020b;
import com.sec.chaton.api.p048a.C1021c;
import com.sec.chaton.api.p048a.C1026h;
import com.sec.chaton.api.p048a.C1027i;
import com.sec.chaton.api.p048a.C1031m;
import com.sec.chaton.api.p048a.C1032n;
import com.sec.chaton.api.p048a.C1039u;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.chat.notification.C1820i;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.C2120bz;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p065io.entry.NewUpdateListEntry;
import com.sec.chaton.p065io.entry.inner.NewUpdateBuddyEntry;
import com.sec.chaton.p065io.entry.inner.NewUpdateEntry;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4847bl;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class UpdatesFragment extends Fragment implements InterfaceC4702i {

    /* renamed from: a */
    public static final String f16967a = UpdatesFragment.class.getSimpleName();

    /* renamed from: d */
    private View f16970d;

    /* renamed from: e */
    private LinearLayout f16971e;

    /* renamed from: f */
    private LinearLayout f16972f;

    /* renamed from: g */
    private View f16973g;

    /* renamed from: h */
    private ViewStub f16974h;

    /* renamed from: i */
    private View f16975i;

    /* renamed from: j */
    private ListView f16976j;

    /* renamed from: k */
    private C4694a f16977k;

    /* renamed from: m */
    private boolean f16979m;

    /* renamed from: n */
    private boolean f16980n;

    /* renamed from: o */
    private boolean f16981o;

    /* renamed from: p */
    private C2120bz f16982p;

    /* renamed from: q */
    private String f16983q;

    /* renamed from: r */
    private String f16984r;

    /* renamed from: s */
    private String f16985s;

    /* renamed from: t */
    private InterfaceC4936e f16986t;

    /* renamed from: l */
    private ArrayList<C4709p> f16978l = new ArrayList<>();

    /* renamed from: b */
    C1027i f16968b = new C1027i(new AbstractC1019a[]{new C1020b(), new C1021c(), new C1031m(), new C1039u(), new C1032n()});

    /* renamed from: c */
    AbsListView.OnScrollListener f16969c = new C4706m(this);

    /* renamed from: u */
    private Handler f16987u = new HandlerC4707n(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f16982p = new C2120bz(this.f16987u);
        this.f16983q = "";
        this.f16984r = "";
        this.f16979m = true;
        this.f16985s = "";
        this.f16980n = false;
        this.f16981o = false;
        this.f16982p.m9466a();
        C4809aa.m18104a().m18125b("updates_show_new_badge", (Boolean) false);
        C4809aa.m18104a().m18126b("updates_notification_count", (Integer) 0);
        C1820i.m8948a().m8952b();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f16970d = layoutInflater.inflate(R.layout.updates_refresh_footer, (ViewGroup) null);
        this.f16971e = (LinearLayout) this.f16970d.findViewById(R.id.footer_progress);
        this.f16975i = layoutInflater.inflate(R.layout.layout_updates, viewGroup, false);
        this.f16972f = (LinearLayout) this.f16975i.findViewById(R.id.layout_loading);
        this.f16972f.setVisibility(0);
        this.f16974h = (ViewStub) this.f16975i.findViewById(R.id.layout_no_contents);
        this.f16973g = this.f16974h.inflate();
        ImageView imageView = (ImageView) this.f16973g.findViewById(R.id.image1);
        TextView textView = (TextView) this.f16973g.findViewById(R.id.text1);
        imageView.setImageResource(R.drawable.no_contents_trunk);
        textView.setText(R.string.dialog_title_noblock_item);
        this.f16973g.setVisibility(8);
        this.f16976j = (ListView) this.f16975i.findViewById(R.id.update_list);
        this.f16978l.clear();
        this.f16977k = new C4694a(getActivity(), this.f16978l, R.layout.list_item_updates);
        this.f16977k.m17752a(this);
        this.f16976j.setFocusable(true);
        this.f16976j.setFocusableInTouchMode(true);
        this.f16976j.setItemsCanFocus(true);
        this.f16976j.addFooterView(this.f16970d, null, false);
        this.f16976j.setAdapter((ListAdapter) this.f16977k);
        this.f16976j.setOnItemClickListener(new C4703j(this));
        this.f16976j.setScrollbarFadingEnabled(true);
        this.f16976j.setOnScrollListener(this.f16969c);
        BaseActivity.m6160a((Fragment) this, true);
        return this.f16975i;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.updates_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_delete /* 2131166726 */:
                Intent intent = new Intent(getActivity(), (Class<?>) UpdatesSelectionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("DATA_LIST", this.f16978l);
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (i2 == -1) {
                    this.f16980n = true;
                    this.f16972f.setVisibility(0);
                    this.f16982p.m9466a();
                    break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17725a(int i) {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addCategory("android.intent.category.BROWSABLE");
        EnumC4697d enumC4697dM17773j = this.f16978l.get(i).m17773j();
        StringBuilder sb = new StringBuilder(this.f16978l.get(i).m17764b());
        if (enumC4697dM17773j == EnumC4697d.INVITE || enumC4697dM17773j == EnumC4697d.JOIN) {
            intent.setAction("android.intent.action.SEND");
            sb.append("&").append("updatePushName").append("=").append(this.f16978l.get(i).m17765b(0));
            sb.append("&").append("fromUpdatePush").append("=").append("true");
        } else {
            intent.setAction("android.intent.action.VIEW");
        }
        intent.setData(Uri.parse(sb.toString()));
        try {
            this.f16968b.m6130a(getActivity(), intent);
        } catch (C1026h e) {
            e.printStackTrace();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f16977k != null) {
            this.f16977k = null;
        }
        if (this.f16986t != null) {
            this.f16986t.dismiss();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.f16981o) {
            this.f16977k.notifyDataSetChanged();
            this.f16981o = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17726a(C0778b c0778b) throws Throwable {
        if (c0778b != null) {
            if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.SUCCESS) {
                NewUpdateListEntry newUpdateListEntry = (NewUpdateListEntry) c0778b.m3110e();
                if (newUpdateListEntry != null) {
                    this.f16983q = newUpdateListEntry.hasmore;
                    if (this.f16980n) {
                        this.f16978l.clear();
                        this.f16980n = false;
                    }
                    Iterator<NewUpdateEntry> it = newUpdateListEntry.newupdate.iterator();
                    while (it.hasNext()) {
                        NewUpdateEntry next = it.next();
                        Iterator<NewUpdateBuddyEntry> it2 = next.sender.buddy.iterator();
                        while (it2.hasNext()) {
                            NewUpdateBuddyEntry next2 = it2.next();
                            String strM9833d = C2190d.m9833d(CommonApplication.m18732r().getContentResolver(), next2.f8575id);
                            if (strM9833d != null) {
                                next2.name = strM9833d;
                            }
                        }
                        this.f16978l.add(new C4709p(next.sender, next.service, next.action, next.status, next.url_scheme, next.created, next.unread, next.additional));
                        this.f16984r = next.created;
                    }
                    if (this.f16978l.size() < 1) {
                        this.f16973g.setVisibility(0);
                    } else {
                        this.f16973g.setVisibility(8);
                        if (this.f16971e != null) {
                            if (this.f16983q != null && "true".equals(this.f16983q)) {
                                this.f16971e.setVisibility(0);
                            } else {
                                this.f16971e.setVisibility(8);
                            }
                        }
                        if (this.f16977k == null) {
                            this.f16977k = new C4694a(getActivity(), this.f16978l, R.layout.list_item_updates);
                            this.f16976j.setAdapter((ListAdapter) this.f16977k);
                        } else {
                            this.f16977k.notifyDataSetChanged();
                        }
                    }
                } else {
                    this.f16973g.setVisibility(0);
                }
            } else {
                int iM10677a = C2471v.m10677a(getActivity().getApplicationContext());
                if (-3 == iM10677a || -2 == iM10677a) {
                    C5179v.m19810a(getActivity(), R.string.popup_no_network_connection, 0).show();
                } else {
                    C5179v.m19810a(getActivity(), R.string.toast_network_unable, 0).show();
                }
                getActivity().finish();
            }
            this.f16979m = false;
        }
    }

    @Override // com.sec.chaton.updates.InterfaceC4702i
    /* renamed from: a */
    public void mo17738a(String str, String str2) {
        if (!C4847bl.m18333a()) {
            Intent intent = new Intent(getActivity(), (Class<?>) BuddyDialog.class);
            intent.putExtra("BUDDY_DIALOG_BUDDY_NO", str);
            intent.putExtra("BUDDY_DIALOG_BUDDY_NAME", str2);
            if (getActivity() instanceof Activity) {
                intent.setFlags(67108864);
            } else {
                intent.setFlags(335544320);
            }
            startActivity(intent);
        }
    }
}
