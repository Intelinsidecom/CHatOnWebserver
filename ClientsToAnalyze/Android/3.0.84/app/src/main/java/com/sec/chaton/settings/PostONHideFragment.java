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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.block.C0475ac;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1344v;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.p035io.entry.GetPostONBlindList;
import com.sec.chaton.p035io.entry.inner.PostONBlind;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.poston.PostONHideListActivity;
import com.sec.chaton.settings2.PrefFragmentPostONHide;
import com.sec.chaton.util.C3228cp;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.C3263j;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class PostONHideFragment extends Fragment implements InterfaceC2677en {

    /* renamed from: a */
    static ProgressDialog f9221a;

    /* renamed from: c */
    private ListView f9223c;

    /* renamed from: d */
    private C1344v f9224d;

    /* renamed from: e */
    private C2674ek f9225e;

    /* renamed from: f */
    private LinearLayout f9226f;

    /* renamed from: g */
    private LinearLayout f9227g;

    /* renamed from: h */
    private View f9228h;

    /* renamed from: i */
    private View f9229i;

    /* renamed from: l */
    private Boolean f9232l;

    /* renamed from: m */
    private String f9233m;

    /* renamed from: n */
    private int f9234n;

    /* renamed from: o */
    private ArrayList<C0475ac> f9235o;

    /* renamed from: p */
    private boolean f9236p;

    /* renamed from: q */
    private PostONHideActivity f9237q;

    /* renamed from: r */
    private MenuItem f9238r;

    /* renamed from: s */
    private MenuItem f9239s;

    /* renamed from: b */
    ArrayList<String> f9222b = new ArrayList<>();

    /* renamed from: j */
    private ArrayList<String> f9230j = new ArrayList<>();

    /* renamed from: k */
    private ArrayList<String> f9231k = new ArrayList<>();

    /* renamed from: t */
    private final Handler f9240t = new HandlerC2679ep(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9237q.m9163c().mo11583a(getText(R.string.poston_title));
        CommonApplication.m11493l().getContentResolver();
        this.f9224d = new C1344v(this.f9240t);
        this.f9224d.m5920b();
        C3250y.m11450b("Start getInteractionBlindList Sync", getClass().getSimpleName());
        this.f9232l = false;
        this.f9233m = getString(R.string.unknown);
        this.f9236p = false;
        this.f9234n = 0;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f9237q = (PostONHideActivity) activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f9237q = null;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_poston_blind_list, viewGroup, false);
        this.f9237q.m9163c().mo11583a(((Object) getText(R.string.poston_title)) + " (" + this.f9234n + ")");
        this.f9223c = (ListView) viewInflate.findViewById(R.id.poston_blind_list);
        this.f9223c.setDescendantFocusability(MotionRecognitionManager.EVENT_CALL_POSE);
        this.f9235o = new ArrayList<>();
        this.f9226f = (LinearLayout) viewInflate.findViewById(R.id.llayout_poston_no_buddies);
        this.f9228h = viewInflate.findViewById(R.id.poston_no_buddies);
        ImageView imageView = (ImageView) this.f9228h.findViewById(R.id.image1);
        TextView textView = (TextView) this.f9228h.findViewById(R.id.text1);
        TextView textView2 = (TextView) this.f9228h.findViewById(R.id.text2);
        imageView.setImageResource(R.drawable.no_contents_buddies);
        textView.setText(R.string.chat_title_no_buddies);
        textView2.setText(R.string.poston_buddies_not_visible);
        this.f9227g = (LinearLayout) viewInflate.findViewById(R.id.llayout_poston_network_error);
        this.f9229i = viewInflate.findViewById(R.id.poston_network_error);
        ImageView imageView2 = (ImageView) this.f9229i.findViewById(R.id.image1);
        TextView textView3 = (TextView) this.f9229i.findViewById(R.id.text1);
        TextView textView4 = (TextView) this.f9229i.findViewById(R.id.text2);
        imageView2.setImageResource(R.drawable.no_contents_network);
        textView3.setText(R.string.toast_network_unable);
        textView4.setText((CharSequence) null);
        this.f9223c.setVisibility(8);
        this.f9226f.setVisibility(0);
        this.f9227g.setVisibility(8);
        f9221a = (ProgressDialog) new C3263j(getActivity()).m11487a(R.string.dialog_connecting_server);
        f9221a.setOnKeyListener(new DialogInterfaceOnKeyListenerC2678eo(this));
        f9221a.show();
        BaseActivity.m3081a(this, true);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.activity_hide_poston_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.f9238r = null;
        this.f9239s = null;
        this.f9238r = menu.findItem(R.id.hide_poston_menu_edit);
        this.f9239s = menu.findItem(R.id.hide_poston_menu_add);
        if (this.f9239s != null) {
            if (C1360d.m6034b(getActivity().getContentResolver()) <= 0) {
                this.f9239s.setEnabled(false);
            } else {
                this.f9239s.setEnabled(true);
            }
            C3228cp.m11343a(this.f9239s);
        }
        if (this.f9238r != null) {
            this.f9238r.setEnabled(false);
            C3228cp.m11343a(this.f9238r);
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.hide_poston_menu_add) {
            Intent intent = new Intent(getActivity(), (Class<?>) BuddyActivity2.class);
            intent.putExtra("BUDDY_SORT_STYLE", 11);
            intent.putExtra("ACTIVITY_PURPOSE", 9);
            intent.putExtra("ACTIVITY_PURPOSE_ARG", this.f9222b);
            startActivityForResult(intent, 0);
        }
        if (menuItem.getItemId() == R.id.hide_poston_menu_edit) {
            Intent intent2 = new Intent(CommonApplication.m11493l(), (Class<?>) PostONHideListActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable(PrefFragmentPostONHide.BLOCK_BUDDY_LIST, this.f9235o);
            bundle.putString(PrefFragmentPostONHide.BLOCK_BUDDY_TYPE, "post_on");
            intent2.putExtras(bundle);
            startActivityForResult(intent2, 1);
        }
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        getActivity().finish();
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 0:
                if (i2 == -1) {
                    C3250y.m11456e("Get blind list from user", getClass().getSimpleName());
                    String[] stringArrayExtra = intent.getStringArrayExtra("blindlist");
                    this.f9234n = stringArrayExtra.length;
                    this.f9237q.m9163c().mo11583a(getActivity().getString(R.string.poston_title) + " (" + this.f9234n + ")");
                    if (this.f9238r != null) {
                        this.f9238r.setEnabled(true);
                        C3228cp.m11343a(this.f9238r);
                    }
                    this.f9230j.clear();
                    for (String str : stringArrayExtra) {
                        this.f9230j.add(str);
                    }
                    this.f9224d.m5919a(this.f9231k, this.f9230j);
                    this.f9232l = false;
                    f9221a = ProgressDialogC3265l.m11490a(getActivity(), null, getResources().getString(R.string.wait_sending), true);
                    break;
                }
                break;
            case 1:
                if (i2 == -1) {
                    C3250y.m11456e("Remove multiple blinded buddy", getClass().getSimpleName());
                    this.f9222b.clear();
                    this.f9231k.clear();
                    this.f9237q.m9163c().mo11583a(((Object) getText(R.string.poston_title)) + " (" + this.f9234n + ")");
                    this.f9224d.m5920b();
                    f9221a.show();
                    if (C3250y.f11734b) {
                        C3250y.m11450b("Start getInteractionBlindList Sync", getClass().getSimpleName());
                    }
                    this.f9232l = false;
                    m9168a(intent.getStringArrayExtra(PrefFragmentPostONHide.BLOCK_BUDDY_RESULT));
                    this.f9236p = true;
                    break;
                }
                break;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f9237q.m9163c().mo11583a(getActivity().getString(R.string.poston_title) + " (" + this.f9234n + ")");
        if (this.f9236p) {
            this.f9236p = false;
            return;
        }
        this.f9224d.m5920b();
        f9221a.show();
        C3250y.m11450b("Start getInteractionBlindList Sync", getClass().getSimpleName());
        this.f9232l = false;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (f9221a != null) {
            f9221a.dismiss();
        }
        super.onDestroyView();
    }

    /* renamed from: a */
    private void m9168a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < strArr.length; i++) {
            arrayList.add(new C0475ac(strArr[i], C1360d.m6037b(CommonApplication.m11493l().getContentResolver(), strArr[i]), null));
        }
        this.f9235o.clear();
        this.f9235o.addAll(arrayList);
        this.f9234n = this.f9235o.size();
        if (getActivity() != null) {
            this.f9237q.m9163c().mo11583a(getActivity().getString(R.string.poston_title) + " (" + this.f9234n + ")");
        }
        if (this.f9222b.isEmpty()) {
            if (this.f9238r != null) {
                this.f9238r.setEnabled(false);
                C3228cp.m11343a(this.f9238r);
            }
            this.f9223c.setVisibility(8);
            this.f9226f.setVisibility(0);
            this.f9227g.setVisibility(8);
        } else {
            if (this.f9238r != null) {
                this.f9238r.setEnabled(true);
                C3228cp.m11343a(this.f9238r);
            }
            this.f9223c.setVisibility(0);
            this.f9226f.setVisibility(8);
            this.f9227g.setVisibility(8);
        }
        this.f9231k = this.f9222b;
        m9165a();
        if (this.f9232l.booleanValue() && getActivity() != null) {
            this.f9232l = false;
            C3641ai.m13211a(getActivity(), getActivity().getResources().getString(R.string.setting_buddy_unblocked, this.f9233m), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9166a(C0267d c0267d) {
        if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
            ArrayList<PostONBlind> arrayList = ((GetPostONBlindList) c0267d.m1354e()).blind;
            this.f9222b.clear();
            this.f9231k.clear();
            Iterator<PostONBlind> it = arrayList.iterator();
            while (it.hasNext()) {
                PostONBlind next = it.next();
                if (C1360d.m6054h(CommonApplication.m11493l().getContentResolver(), next.value)) {
                    this.f9222b.add(next.value);
                }
                C3250y.m11456e("Add blindedBuddies: " + next.value, getClass().getSimpleName());
            }
            int size = this.f9222b.size();
            String[] strArr = new String[size];
            for (int i = 0; i < size; i++) {
                strArr[i] = this.f9222b.get(i);
            }
            m9168a(strArr);
            return;
        }
        this.f9223c.setVisibility(8);
        this.f9226f.setVisibility(8);
        this.f9227g.setVisibility(0);
        this.f9235o.clear();
        C3641ai.m13210a(getActivity(), R.string.popup_no_network_connection, 0).show();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    /* renamed from: a */
    private void m9165a() {
        this.f9225e = new C2674ek(getActivity(), this.f9222b);
        this.f9225e.m9684a(this);
        this.f9223c.setAdapter((ListAdapter) this.f9225e);
    }

    @Override // com.sec.chaton.settings.InterfaceC2677en
    public void onItemClicked(String str, String str2) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str2);
        f9221a.show();
        this.f9233m = str;
        this.f9232l = true;
        this.f9224d.m5919a(arrayList, new ArrayList<>());
        C3250y.m11450b("PostON Buddy Show: " + str2, getClass().getSimpleName());
    }
}
