package com.sec.chaton.settings;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.hardware.motion.MotionRecognitionManager;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.block.C1093u;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.C2074ag;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p065io.entry.GetPostONBlindList;
import com.sec.chaton.p065io.entry.inner.PostONBlind;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.poston.PostONHideListActivity;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4880cr;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.C4923p;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class PostONHideFragment extends Fragment implements InterfaceC3629fl {

    /* renamed from: a */
    static ProgressDialog f12795a;

    /* renamed from: c */
    private ListView f12797c;

    /* renamed from: d */
    private C2074ag f12798d;

    /* renamed from: e */
    private C3626fi f12799e;

    /* renamed from: f */
    private LinearLayout f12800f;

    /* renamed from: g */
    private LinearLayout f12801g;

    /* renamed from: h */
    private View f12802h;

    /* renamed from: i */
    private View f12803i;

    /* renamed from: l */
    private Boolean f12806l;

    /* renamed from: m */
    private String f12807m;

    /* renamed from: n */
    private int f12808n;

    /* renamed from: o */
    private ArrayList<C1093u> f12809o;

    /* renamed from: p */
    private boolean f12810p;

    /* renamed from: q */
    private PostONHideActivity f12811q;

    /* renamed from: r */
    private MenuItem f12812r;

    /* renamed from: s */
    private MenuItem f12813s;

    /* renamed from: t */
    private ViewStub f12814t;

    /* renamed from: b */
    ArrayList<String> f12796b = new ArrayList<>();

    /* renamed from: j */
    private ArrayList<String> f12804j = new ArrayList<>();

    /* renamed from: k */
    private ArrayList<String> f12805k = new ArrayList<>();

    /* renamed from: u */
    private final Handler f12815u = new HandlerC3631fn(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f12811q.m13648h().mo18823a(getText(R.string.poston_title));
        CommonApplication.m18732r().getContentResolver();
        this.f12798d = new C2074ag(this.f12815u);
        this.f12798d.m9294b();
        C4904y.m18639b("Start getInteractionBlindList Sync", getClass().getSimpleName());
        this.f12806l = false;
        this.f12807m = getString(R.string.unknown);
        this.f12810p = false;
        this.f12808n = 0;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f12811q = (PostONHideActivity) activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f12811q = null;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_poston_blind_list, viewGroup, false);
        this.f12811q.m13648h().mo18823a(((Object) getText(R.string.poston_title)) + " (" + this.f12808n + ")");
        this.f12797c = (ListView) viewInflate.findViewById(R.id.poston_blind_list);
        this.f12797c.setDescendantFocusability(MotionRecognitionManager.EVENT_CALL_POSE);
        this.f12809o = new ArrayList<>();
        this.f12800f = (LinearLayout) viewInflate.findViewById(R.id.llayout_poston_no_buddies);
        this.f12802h = viewInflate.findViewById(R.id.poston_no_buddies);
        ImageView imageView = (ImageView) this.f12802h.findViewById(R.id.image1);
        TextView textView = (TextView) this.f12802h.findViewById(R.id.text1);
        TextView textView2 = (TextView) this.f12802h.findViewById(R.id.text2);
        imageView.setImageResource(R.drawable.no_contents_buddies);
        textView.setText(R.string.blocked_buddies_no_contacts);
        textView2.setText(R.string.poston_buddies_not_visible);
        this.f12801g = (LinearLayout) viewInflate.findViewById(R.id.llayout_poston_network_error);
        this.f12814t = (ViewStub) viewInflate.findViewById(R.id.poston_network_error);
        this.f12797c.setVisibility(8);
        this.f12800f.setVisibility(0);
        this.f12801g.setVisibility(8);
        f12795a = (ProgressDialog) new C4923p(getActivity()).m18724a(R.string.dialog_connecting_server);
        f12795a.setOnKeyListener(new DialogInterfaceOnKeyListenerC3630fm(this));
        f12795a.show();
        BaseActivity.m6160a((Fragment) this, true);
        return viewInflate;
    }

    /* renamed from: a */
    private void m13650a() {
        if (this.f12803i != null) {
            this.f12803i = this.f12814t.inflate();
            ImageView imageView = (ImageView) this.f12803i.findViewById(R.id.image1);
            TextView textView = (TextView) this.f12803i.findViewById(R.id.text1);
            TextView textView2 = (TextView) this.f12803i.findViewById(R.id.text2);
            imageView.setImageResource(R.drawable.no_contents_network);
            textView.setText(R.string.toast_network_unable);
            textView2.setText((CharSequence) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.activity_hide_poston_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.f12812r = null;
        this.f12813s = null;
        this.f12812r = menu.findItem(R.id.hide_poston_menu_edit);
        this.f12813s = menu.findItem(R.id.hide_poston_menu_add);
        if (this.f12813s != null) {
            if (C2190d.m9798a(getActivity().getContentResolver()) <= 0) {
                this.f12813s.setEnabled(false);
            } else {
                this.f12813s.setEnabled(true);
            }
            C4880cr.m18523a(this.f12813s);
        }
        if (this.f12812r != null) {
            this.f12812r.setEnabled(false);
            C4880cr.m18523a(this.f12812r);
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.hide_poston_menu_add) {
            Intent intent = new Intent(getActivity(), (Class<?>) BuddyActivity2.class);
            intent.putExtra("BUDDY_SORT_STYLE", 11);
            intent.putExtra("ACTIVITY_PURPOSE", 9);
            intent.putExtra("ACTIVITY_PURPOSE_ARG", this.f12796b);
            intent.putExtra("ACTIVITY_PURPOSE_ARG2", 1);
            startActivityForResult(intent, 0);
        }
        if (menuItem.getItemId() == R.id.hide_poston_menu_edit) {
            if (C4847bl.m18333a()) {
                return true;
            }
            Intent intent2 = new Intent(CommonApplication.m18732r(), (Class<?>) PostONHideListActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("block_buddy_list", this.f12809o);
            bundle.putString("block_buddy_type", "post_on");
            intent2.putExtras(bundle);
            startActivityForResult(intent2, 1);
        }
        if (menuItem.getItemId() == 16908332) {
            getActivity().finish();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 0:
                if (i2 == -1) {
                    C4904y.m18646e("Get blind list from user", getClass().getSimpleName());
                    String[] stringArrayExtra = intent.getStringArrayExtra("blindlist");
                    this.f12808n = stringArrayExtra.length;
                    this.f12811q.m13648h().mo18823a(getActivity().getString(R.string.poston_title) + " (" + this.f12808n + ")");
                    if (this.f12812r != null) {
                        this.f12812r.setEnabled(true);
                        C4880cr.m18523a(this.f12812r);
                    }
                    this.f12804j.clear();
                    for (String str : stringArrayExtra) {
                        this.f12804j.add(str);
                    }
                    this.f12798d.m9293a(new ArrayList<>(), this.f12804j);
                    this.f12806l = false;
                    f12795a = ProgressDialogC4926s.m18728a(getActivity(), null, getResources().getString(R.string.wait_sending), true);
                    break;
                }
                break;
            case 1:
                if (i2 == -1) {
                    C4904y.m18646e("Remove multiple blinded buddy", getClass().getSimpleName());
                    this.f12796b.clear();
                    this.f12805k.clear();
                    this.f12811q.m13648h().mo18823a(((Object) getText(R.string.poston_title)) + " (" + this.f12808n + ")");
                    this.f12798d.m9294b();
                    f12795a.show();
                    if (C4904y.f17872b) {
                        C4904y.m18639b("Start getInteractionBlindList Sync", getClass().getSimpleName());
                    }
                    this.f12806l = false;
                    m13653a(intent.getStringArrayExtra("block_buddy_result"));
                    this.f12810p = true;
                    break;
                }
                break;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (getActivity() != null && !getActivity().isFinishing()) {
            String str = getActivity().getString(R.string.poston_title) + " (" + this.f12808n + ")";
            if (this.f12811q != null) {
                this.f12811q.m13648h().mo18823a(str);
            }
            if (this.f12810p) {
                this.f12810p = false;
                return;
            }
            this.f12798d.m9294b();
            if (this.f12811q != null && !f12795a.isShowing()) {
                f12795a.show();
            }
            C4904y.m18639b("Start getInteractionBlindList Sync", getClass().getSimpleName());
            this.f12806l = false;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (f12795a != null) {
            f12795a.dismiss();
        }
        super.onDestroyView();
    }

    /* renamed from: a */
    private void m13653a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < strArr.length; i++) {
            arrayList.add(new C1093u(strArr[i], C2190d.m9827c(CommonApplication.m18732r().getContentResolver(), strArr[i]), null));
        }
        this.f12809o.clear();
        this.f12809o.addAll(arrayList);
        this.f12808n = this.f12809o.size();
        if (getActivity() != null) {
            this.f12811q.m13648h().mo18823a(getActivity().getString(R.string.poston_title) + " (" + this.f12808n + ")");
        }
        if (this.f12796b.isEmpty()) {
            if (this.f12812r != null) {
                this.f12812r.setEnabled(false);
                C4880cr.m18523a(this.f12812r);
            }
            this.f12797c.setVisibility(8);
            this.f12800f.setVisibility(0);
            this.f12801g.setVisibility(8);
        } else {
            if (this.f12812r != null) {
                this.f12812r.setEnabled(true);
                C4880cr.m18523a(this.f12812r);
            }
            this.f12797c.setVisibility(0);
            this.f12800f.setVisibility(8);
            this.f12801g.setVisibility(8);
        }
        this.f12805k = this.f12796b;
        m13654b();
        if (this.f12806l.booleanValue() && getActivity() != null) {
            this.f12806l = false;
            C5179v.m19811a(getActivity(), getActivity().getResources().getString(R.string.setting_buddy_unblocked, this.f12807m), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m13651a(C0778b c0778b) {
        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            ArrayList<PostONBlind> arrayList = ((GetPostONBlindList) c0778b.m3110e()).blind;
            this.f12796b.clear();
            this.f12805k.clear();
            Iterator<PostONBlind> it = arrayList.iterator();
            while (it.hasNext()) {
                PostONBlind next = it.next();
                if (C2190d.m9846i(CommonApplication.m18732r().getContentResolver(), next.value)) {
                    this.f12796b.add(next.value);
                }
                C4904y.m18646e("Add blindedBuddies: " + next.value, getClass().getSimpleName());
            }
            int size = this.f12796b.size();
            String[] strArr = new String[size];
            for (int i = 0; i < size; i++) {
                strArr[i] = this.f12796b.get(i);
            }
            m13653a(strArr);
            return;
        }
        this.f12797c.setVisibility(8);
        this.f12800f.setVisibility(8);
        m13650a();
        this.f12801g.setVisibility(0);
        this.f12809o.clear();
        C5179v.m19810a(getActivity(), R.string.popup_no_network_connection, 0).show();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    /* renamed from: b */
    private void m13654b() {
        this.f12799e = new C3626fi(getActivity(), this.f12796b);
        this.f12799e.m13909a(this);
        this.f12797c.setAdapter((ListAdapter) this.f12799e);
    }

    @Override // com.sec.chaton.settings.InterfaceC3629fl
    /* renamed from: a */
    public void mo13655a(String str, String str2) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str2);
        f12795a.show();
        this.f12807m = str;
        this.f12806l = true;
        this.f12798d.m9293a(arrayList, new ArrayList<>());
        C4904y.m18639b("PostON Buddy Show: " + str2, getClass().getSimpleName());
    }
}
