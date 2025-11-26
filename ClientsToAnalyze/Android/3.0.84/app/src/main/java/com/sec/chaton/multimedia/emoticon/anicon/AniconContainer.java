package com.sec.chaton.multimedia.emoticon.anicon;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.emoticon.CategoryActivity;
import com.sec.chaton.p025d.C1332j;
import com.sec.chaton.p027e.C1396an;
import com.sec.chaton.p027e.C1398ap;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.p027e.p028a.C1358b;
import com.sec.chaton.p027e.p028a.C1359c;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.settings.downloads.ActivityAniconPackageDetail;
import com.sec.chaton.settings.downloads.C2646u;
import com.sec.chaton.settings.downloads.InterfaceC2535ab;
import com.sec.chaton.settings.downloads.InterfaceC2536ac;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3228cp;
import com.sec.chaton.util.C3250y;
import com.sec.common.p069e.C3326c;
import com.sec.common.util.C3364o;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

/* loaded from: classes.dex */
public class AniconContainer extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener, InterfaceC2535ab, InterfaceC2536ac {

    /* renamed from: b */
    private static final String f6754b = AniconContainer.class.getSimpleName();

    /* renamed from: a */
    InterfaceC1378v f6755a = new C1816f(this);

    /* renamed from: c */
    private C1332j f6756c;

    /* renamed from: d */
    private C3326c f6757d;

    /* renamed from: e */
    private C3326c f6758e;

    /* renamed from: f */
    private Activity f6759f;

    /* renamed from: g */
    private HorizontalScrollView f6760g;

    /* renamed from: h */
    private LinearLayout f6761h;

    /* renamed from: i */
    private GridView f6762i;

    /* renamed from: j */
    private View f6763j;

    /* renamed from: k */
    private View f6764k;

    /* renamed from: l */
    private TextView f6765l;

    /* renamed from: m */
    private Button f6766m;

    /* renamed from: n */
    private C1811a f6767n;

    /* renamed from: o */
    private Map<String, View> f6768o;

    /* renamed from: p */
    private int f6769p;

    /* renamed from: q */
    private String f6770q;

    /* renamed from: r */
    private Cursor f6771r;

    /* renamed from: s */
    private InterfaceC1819i f6772s;

    /* renamed from: t */
    private int f6773t;

    /* renamed from: u */
    private C1377u f6774u;

    /* renamed from: v */
    private RelativeLayout f6775v;

    /* renamed from: w */
    private LinearLayout f6776w;

    /* renamed from: a */
    public static final AniconContainer m7458a(int i) {
        return m7459a(i, (String) null);
    }

    /* renamed from: a */
    public static final AniconContainer m7459a(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("layoutResId", i);
        AniconContainer aniconContainer = new AniconContainer();
        aniconContainer.setArguments(bundle);
        return aniconContainer;
    }

    /* renamed from: a */
    public void m7472a(InterfaceC1819i interfaceC1819i) {
        this.f6772s = interfaceC1819i;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f6759f = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f6759f = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6769p = getArguments().getInt("layoutResId");
        this.f6770q = null;
        this.f6768o = new HashMap();
        this.f6757d = new C3326c(m7468e());
        this.f6758e = new C3326c(m7470f());
        this.f6756c = new C1332j(this.f6759f, null);
        this.f6774u = new C1377u(this.f6759f.getContentResolver(), this.f6755a);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        String string;
        super.onCreateView(layoutInflater, viewGroup, bundle);
        if (bundle != null) {
            string = bundle.getString("currentTabId");
            i = bundle.getInt("currentIndicatorPosition");
        } else {
            i = 0;
            string = null;
        }
        if (C3250y.f11734b) {
            C3250y.m11450b(C3364o.m11849a("Restored. PackageId: ", string, ", Tab Indicator Position: ", Integer.valueOf(i)), f6754b);
        }
        View viewInflate = layoutInflater.inflate(this.f6769p, viewGroup, false);
        this.f6760g = (HorizontalScrollView) viewInflate.findViewById(R.id.panelScrollView);
        this.f6761h = (LinearLayout) viewInflate.findViewById(R.id.panelContainer);
        this.f6762i = (GridView) viewInflate.findViewById(R.id.emoticonGridView);
        this.f6763j = viewInflate.findViewById(R.id.emoticonEmptyView);
        this.f6764k = viewInflate.findViewById(R.id.emoticonDownloadView);
        this.f6766m = (Button) viewInflate.findViewById(R.id.aniconDownloadButton);
        this.f6766m.setOnClickListener(this);
        this.f6765l = (TextView) viewInflate.findViewById(R.id.aniconDownloadDescription);
        this.f6775v = (RelativeLayout) viewInflate.findViewById(R.id.characterDownloadView);
        this.f6776w = (LinearLayout) viewInflate.findViewById(R.id.characterButtonLayout);
        this.f6776w.setOnClickListener(this);
        this.f6771r = m7464c();
        this.f6767n = new C1811a(this.f6759f, null, 1, this.f6758e);
        this.f6762i.setAdapter((ListAdapter) this.f6767n);
        this.f6762i.setOnItemClickListener(this);
        m7465c(string);
        C2646u.m9650a((InterfaceC2535ab) this);
        C2646u.m9651a((InterfaceC2536ac) this);
        this.f6773t = i;
        this.f6760g.post(new RunnableC1813c(this, i));
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        TextView textView = (TextView) this.f6768o.get("-1").findViewById(R.id.emoticon_tab_indicator_badge);
        int iM9642a = C2646u.m9642a();
        if (iM9642a == 0) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            C3228cp.m11345a(textView, iM9642a);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        C2646u.m9658b((InterfaceC2535ab) this);
        C2646u.m9659b((InterfaceC2536ac) this);
        if (this.f6767n != null) {
            this.f6767n.changeCursor(null);
        }
        if (this.f6771r != null && !this.f6771r.isClosed()) {
            this.f6771r.close();
        }
        m7467d();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f6757d.m11731a();
        this.f6758e.m11731a();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("currentTabId", this.f6770q);
        if (this.f6773t == -1) {
            bundle.putInt("currentIndicatorPosition", this.f6760g.getScrollX());
        } else {
            bundle.putInt("currentIndicatorPosition", this.f6773t);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String str = ((C1812b) view.getTag()).f6783c;
        if (!TextUtils.isEmpty(str) && this.f6772s != null) {
            this.f6772s.mo7443a(this, str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        if (!C3197bl.m11159a()) {
            if (view.equals(this.f6766m)) {
                m7463b();
                return;
            }
            if (view.equals(this.f6776w)) {
                Intent intent = new Intent(this.f6759f, (Class<?>) ActivityAniconPackageDetail.class);
                intent.putExtra("ANICON_PACKAGE_ID", "");
                startActivity(intent);
            } else {
                String str = (String) view.getTag();
                m7471f(str);
                m7469e(str);
            }
        }
    }

    @Override // com.sec.chaton.settings.downloads.InterfaceC2535ab
    /* renamed from: a */
    public void mo7473a(String str) {
        this.f6762i.post(new RunnableC1814d(this));
    }

    @Override // com.sec.chaton.settings.downloads.InterfaceC2536ac
    /* renamed from: b */
    public void mo7474b(String str) {
        this.f6762i.post(new RunnableC1815e(this));
    }

    /* renamed from: b */
    private void m7463b() {
        this.f6759f.startActivity(new Intent(this.f6759f, (Class<?>) CategoryActivity.class));
    }

    /* renamed from: c */
    private Cursor m7464c() {
        return this.f6759f.getContentResolver().query(C1398ap.m6249a(EnumC1399aq.Anicon).buildUpon().appendPath("anicon_group").build(), null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m7465c(String str) {
        int i;
        boolean z;
        m7467d();
        ((ImageView) m7466d("-1").findViewById(R.id.emoticon_tab_indicator_image)).setImageResource(R.drawable.chat_anicon_btn_down);
        ((ImageView) m7466d("-2").findViewById(R.id.emoticon_tab_indicator_image)).setImageResource(R.drawable.chat_anicon_btn_recent);
        this.f6771r.moveToPosition(-1);
        boolean z2 = false;
        while (this.f6771r.moveToNext()) {
            String string = this.f6771r.getString(this.f6771r.getColumnIndex("item_id"));
            boolean z3 = this.f6771r.getInt(this.f6771r.getColumnIndex("newly_installed")) != 0;
            String string2 = this.f6771r.getString(this.f6771r.getColumnIndex("data1"));
            String string3 = this.f6771r.getString(this.f6771r.getColumnIndex("data2"));
            if (this.f6771r.getPosition() == 0 && TextUtils.isEmpty(str)) {
                str = string;
            }
            try {
                C1359c c1359cM6004a = C1358b.m6004a(this.f6771r.getString(this.f6771r.getColumnIndex("extras")));
                if ("0036".equals(string2) && "001".equals(string3)) {
                    i = 2;
                    z = true;
                } else {
                    i = -1;
                    z = z2;
                }
                try {
                    ImageView imageView = (ImageView) m7456a(string, z3, i).findViewById(R.id.emoticon_tab_indicator_image);
                    if (i == -1) {
                        this.f6757d.m11730a(imageView, new C1820j(string, c1359cM6004a.m6016e(), this.f6756c));
                    } else {
                        imageView.setImageResource(R.drawable.chat_anicon_btn_anicon);
                    }
                    z2 = z;
                } catch (JSONException e) {
                    e = e;
                    z2 = z;
                    if (C3250y.f11737e) {
                        C3250y.m11443a(e, f6754b);
                    }
                }
            } catch (JSONException e2) {
                e = e2;
            }
        }
        if (!z2) {
            ((ImageView) m7456a("-4", false, 2).findViewById(R.id.emoticon_tab_indicator_image)).setImageResource(R.drawable.chat_anicon_btn_anicon);
        }
        if (TextUtils.isEmpty(str)) {
            str = "-4";
        }
        m7469e(str);
    }

    /* renamed from: d */
    private View m7466d(String str) {
        return m7456a(str, false, -1);
    }

    /* renamed from: a */
    private View m7456a(String str, boolean z, int i) {
        View viewInflate = LayoutInflater.from(this.f6759f).inflate(R.layout.item_emoticon_tab_indicator, (ViewGroup) null);
        viewInflate.setLayoutParams(new ViewGroup.LayoutParams(this.f6759f.getResources().getDimensionPixelOffset(R.dimen.anicon_tab_indicator_width), this.f6759f.getResources().getDimensionPixelOffset(R.dimen.anicon_tab_indicator_height)));
        viewInflate.setTag(str);
        viewInflate.setOnClickListener(this);
        if (this.f6761h.getChildCount() >= i) {
            this.f6761h.addView(viewInflate, i);
        } else {
            this.f6761h.addView(viewInflate);
        }
        this.f6768o.put(str, viewInflate);
        if (z) {
            viewInflate.setBackgroundResource(R.drawable.anicon_indicator_new_bg);
        } else {
            viewInflate.setBackgroundResource(R.drawable.tab_center_button_background);
        }
        return viewInflate;
    }

    /* renamed from: d */
    private void m7467d() {
        this.f6770q = null;
        for (String str : this.f6768o.keySet()) {
            if (!"-1".equals(str) && !"-2".equals(str)) {
                this.f6757d.m11732a((ImageView) this.f6768o.get(str).findViewById(R.id.emoticon_tab_indicator_image));
            }
        }
        this.f6768o.clear();
        this.f6761h.removeAllViews();
    }

    /* renamed from: e */
    private void m7469e(String str) {
        if (TextUtils.isEmpty(str) || !str.equals(this.f6770q)) {
            if (!TextUtils.isEmpty(this.f6770q)) {
                this.f6768o.get(this.f6770q).setSelected(false);
            }
            this.f6770q = str;
            this.f6768o.get(str).setSelected(true);
            if (str.equals("-2")) {
                this.f6762i.setVisibility(0);
                this.f6763j.setVisibility(8);
                this.f6764k.setVisibility(8);
                this.f6775v.setVisibility(8);
                this.f6767n.changeCursor(this.f6759f.getContentResolver().query(C1396an.f5203a.buildUpon().appendPath("recentused").build(), null, null, null, null));
                this.f6767n.notifyDataSetInvalidated();
                if (this.f6767n.isEmpty()) {
                    this.f6762i.setVisibility(8);
                    this.f6763j.setVisibility(0);
                    return;
                }
                return;
            }
            if (str.equals("-1")) {
                this.f6762i.setVisibility(8);
                this.f6763j.setVisibility(8);
                this.f6764k.setVisibility(0);
                this.f6775v.setVisibility(8);
                this.f6765l.setText(R.string.anicon_no_downloaded_title);
                this.f6767n.changeCursor(null);
                this.f6767n.notifyDataSetInvalidated();
                return;
            }
            if (str.equals("-4")) {
                this.f6762i.setVisibility(8);
                this.f6763j.setVisibility(8);
                this.f6764k.setVisibility(8);
                this.f6775v.setVisibility(0);
                return;
            }
            this.f6762i.setVisibility(0);
            this.f6763j.setVisibility(8);
            this.f6764k.setVisibility(8);
            this.f6775v.setVisibility(8);
            this.f6767n.changeCursor(this.f6759f.getContentResolver().query(C1396an.f5203a.buildUpon().appendPath("group").appendPath(str).build(), null, null, null, null));
            this.f6767n.notifyDataSetInvalidated();
            this.f6762i.setSelection(0);
        }
    }

    /* renamed from: f */
    private void m7471f(String str) throws Throwable {
        View view = this.f6768o.get(str);
        if (!view.getBackground().equals(getResources().getDrawable(R.drawable.tab_center_button_background))) {
            view.setBackgroundResource(R.drawable.tab_center_button_background);
            String strM11849a = C3364o.m11849a("item_id", " IN ( SELECT ", "item_id", " FROM ( ", "\tSELECT ", "data1", ",", "data2", "\tFROM ", "download_item", "\tWHERE ", "item_type", "='", EnumC1399aq.Anicon.m6252a(), "' AND ", "install", " != 0 AND ", "item_id", "=?) D1", "\tINNER JOIN ", "download_item", " D2 ", "\tON D1.", "data1", " = D2.", "data1", " AND D1.", "data2", " = D2.", "data2", ")");
            ContentValues contentValues = new ContentValues();
            contentValues.put("newly_installed", (Integer) 0);
            this.f6774u.startUpdate(0, null, C1398ap.f5204a.buildUpon().appendPath("init_newly_installed").build(), contentValues, strM11849a, new String[]{str});
        }
    }

    /* renamed from: e */
    private ExecutorService m7468e() {
        return Executors.newCachedThreadPool(new ThreadFactoryC1817g(this));
    }

    /* renamed from: f */
    private ExecutorService m7470f() {
        return Executors.newSingleThreadExecutor(new ThreadFactoryC1818h(this));
    }
}
