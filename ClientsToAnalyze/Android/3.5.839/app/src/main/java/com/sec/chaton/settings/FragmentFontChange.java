package com.sec.chaton.settings;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p065io.entry.inner.FontType;
import com.sec.chaton.settings.p096a.C3471o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4875cm;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p132g.C5007c;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class FragmentFontChange extends Fragment implements AdapterView.OnItemClickListener {

    /* renamed from: c */
    private int f12687c;

    /* renamed from: d */
    private TextView f12688d;

    /* renamed from: e */
    private TextView f12689e;

    /* renamed from: f */
    private int f12690f;

    /* renamed from: g */
    private int f12691g;

    /* renamed from: h */
    private View f12692h;

    /* renamed from: i */
    private C5007c f12693i;

    /* renamed from: j */
    private ListView f12694j;

    /* renamed from: k */
    private FontType f12695k;

    /* renamed from: l */
    private ActivityFontChange f12696l;

    /* renamed from: p */
    private ArrayList<FontType> f12700p;

    /* renamed from: r */
    private C3599ei f12702r;

    /* renamed from: b */
    private Toast f12686b = null;

    /* renamed from: a */
    String f12685a = "all_chat";

    /* renamed from: q */
    private int f12701q = -1;

    /* renamed from: s */
    private HashMap<String, Typeface> f12703s = new HashMap<>();

    /* renamed from: m */
    private Map<Integer, String> f12697m = new HashMap();

    /* renamed from: n */
    private Map<FontType, Float> f12698n = new HashMap();

    /* renamed from: o */
    private Map<FontType, Typeface> f12699o = new HashMap();

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f12696l = (ActivityFontChange) activity;
    }

    /* renamed from: a */
    private void m13566a() {
        if (this.f12697m != null) {
            this.f12697m.clear();
        }
        if (this.f12698n != null) {
            this.f12698n.clear();
        }
        if (this.f12699o != null) {
            this.f12699o.clear();
        }
        Iterator<FontType> it = this.f12700p.iterator();
        while (it.hasNext()) {
            FontType next = it.next();
            if (this.f12697m != null && this.f12698n != null && this.f12699o != null) {
                this.f12697m.put(Integer.valueOf(next.getId()), next.getFontTitle());
                this.f12698n.put(next, Float.valueOf(next.getFontFileSize()));
                this.f12699o.put(next, next.getFontType());
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) throws Throwable {
        super.onCreate(bundle);
        this.f12693i = new C5007c(Executors.newFixedThreadPool(5, new ThreadFactoryC3597eg(this)));
        m13568b();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.cancel_done_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_done) {
            if (this.f12701q != -1) {
                if (this.f12687c == this.f12700p.get(this.f12701q).getId()) {
                    if (this.f12686b == null) {
                        this.f12686b = C5179v.m19810a(getActivity(), R.string.ams_msg_already_saved, 0);
                    }
                    this.f12686b.show();
                } else {
                    C4809aa.m18104a().m18126b("Default Font Typeface", Integer.valueOf(this.f12700p.get(this.f12701q).getId()));
                    C4809aa.m18104a().m18128b("Default Font Name", this.f12700p.get(this.f12701q).getFontTitle());
                    C5179v.m19811a(CommonApplication.m18732r(), getResources().getString(R.string.buddy_profile_saveprofile_toast_success), 0).show();
                    ((InterfaceC3598eh) getActivity()).mo13390h();
                }
            }
        } else if (menuItem.getItemId() == R.id.menu_cancel) {
            ((InterfaceC3598eh) getActivity()).mo13390h();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0092 A[PHI: r1
  0x0092: PHI (r1v16 android.database.Cursor) = (r1v4 android.database.Cursor), (r1v22 android.database.Cursor) binds: [B:31:0x0103, B:12:0x0090] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0166  */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.sec.chaton.io.entry.inner.FontType, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.database.Cursor] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m13568b() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.settings.FragmentFontChange.m13568b():void");
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f12692h = layoutInflater.inflate(R.layout.layout_change_font, viewGroup, false);
        try {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.skin_01));
            bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
            this.f12692h.setBackgroundDrawable(bitmapDrawable);
        } catch (Exception e) {
            e.printStackTrace();
        }
        m13566a();
        if (this.f12692h.findViewById(R.id.sent_font_size) != null) {
            this.f12688d = (TextView) this.f12692h.findViewById(R.id.sent_font_size);
        }
        if (this.f12692h.findViewById(R.id.read_font_size) != null) {
            this.f12689e = (TextView) this.f12692h.findViewById(R.id.read_font_size);
        }
        this.f12695k = new FontType();
        if (this.f12697m != null) {
            this.f12695k.setFontTitle(this.f12697m.get(C4809aa.m18104a().m18120a("Default Font Typeface", (Integer) (-1))));
        }
        this.f12694j = (ListView) this.f12692h.findViewById(android.R.id.list);
        this.f12702r = new C3599ei(this);
        this.f12694j.setAdapter((ListAdapter) this.f12702r);
        this.f12694j.setItemChecked(0, true);
        this.f12688d.setTypeface(Typeface.DEFAULT);
        this.f12689e.setTypeface(Typeface.DEFAULT);
        Iterator<FontType> it = this.f12700p.iterator();
        while (it.hasNext()) {
            FontType next = it.next();
            if (next.getFontTitle().equals(this.f12695k.getFontTitle())) {
                this.f12694j.setItemChecked(this.f12700p.indexOf(next), true);
                if (!next.getFontTitle().equals(GlobalApplication.m10283b().getString(R.string.chaton_default))) {
                    try {
                        Typeface typefaceCreateFromFile = Typeface.createFromFile(C3471o.m13807c(CommonApplication.m18732r(), Integer.toString(next.getId())).getPath());
                        this.f12688d.setTypeface(typefaceCreateFromFile);
                        this.f12689e.setTypeface(typefaceCreateFromFile);
                    } catch (Exception e2) {
                        C4904y.m18639b("Cannot make font from file", getClass().getSimpleName());
                    }
                }
            }
        }
        this.f12694j.setOnItemClickListener(this);
        setHasOptionsMenu(true);
        return this.f12692h;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        C4875cm.m18511a(getActivity());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        m13570c();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() throws Throwable {
        super.onResume();
        if (this.f12691g == 0 || this.f12690f == 0) {
            m13570c();
        }
        m13568b();
        m13571d();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f12693i.m19014a();
    }

    /* renamed from: c */
    private void m13570c() {
        WindowManager windowManager = (WindowManager) getActivity().getSystemService("window");
        this.f12690f = windowManager.getDefaultDisplay().getWidth();
        this.f12691g = windowManager.getDefaultDisplay().getHeight();
        C4904y.m18639b("1. windows size=width:" + this.f12690f + " height:" + this.f12691g, getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f12701q = i;
        if (this.f12700p.get(i).getId() == -1) {
            this.f12688d.setTypeface(Typeface.DEFAULT);
            this.f12689e.setTypeface(Typeface.DEFAULT);
            return;
        }
        try {
            if (!this.f12703s.containsKey(Integer.toString(this.f12700p.get(i).getId()))) {
                Typeface typefaceCreateFromFile = Typeface.createFromFile(C3471o.m13807c(GlobalApplication.m18732r(), Integer.toString(this.f12700p.get(i).getId())).getPath());
                this.f12703s.put(Integer.toString(this.f12700p.get(i).getId()), typefaceCreateFromFile);
                this.f12688d.setTypeface(typefaceCreateFromFile);
                this.f12689e.setTypeface(typefaceCreateFromFile);
            } else {
                this.f12688d.setTypeface(this.f12703s.get(Integer.toString(this.f12700p.get(i).getId())));
                this.f12689e.setTypeface(this.f12703s.get(Integer.toString(this.f12700p.get(i).getId())));
            }
        } catch (Exception e) {
            C4904y.m18639b("Cannot make font from file", getClass().getSimpleName());
        }
    }

    /* renamed from: d */
    private void m13571d() {
        this.f12687c = C4809aa.m18104a().m18120a("Default Font Typeface", (Integer) (-1)).intValue();
        if (this.f12687c == -1) {
            this.f12688d.setTypeface(Typeface.DEFAULT);
            this.f12689e.setTypeface(Typeface.DEFAULT);
        } else {
            Typeface typefaceCreateFromFile = Typeface.createFromFile(C3471o.m13807c(GlobalApplication.m18732r(), Integer.toString(this.f12687c)).getPath());
            this.f12688d.setTypeface(typefaceCreateFromFile);
            this.f12689e.setTypeface(typefaceCreateFromFile);
        }
    }
}
