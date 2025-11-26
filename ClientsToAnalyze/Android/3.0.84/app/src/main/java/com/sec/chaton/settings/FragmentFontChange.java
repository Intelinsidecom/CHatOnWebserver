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
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p035io.entry.inner.FontType;
import com.sec.chaton.settings.downloads.C2570bj;
import com.sec.chaton.settings2.PrefFragmentChats;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3225cm;
import com.sec.chaton.util.C3228cp;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p069e.C3326c;
import com.sec.widget.C3641ai;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class FragmentFontChange extends Fragment implements AdapterView.OnItemClickListener {

    /* renamed from: b */
    private TextView f9134b;

    /* renamed from: c */
    private TextView f9135c;

    /* renamed from: d */
    private int f9136d;

    /* renamed from: e */
    private int f9137e;

    /* renamed from: f */
    private View f9138f;

    /* renamed from: g */
    private C3326c f9139g;

    /* renamed from: h */
    private ListView f9140h;

    /* renamed from: i */
    private FontType f9141i;

    /* renamed from: j */
    private ActivityFontChange f9142j;

    /* renamed from: n */
    private ArrayList<FontType> f9146n;

    /* renamed from: p */
    private C2652dp f9148p;

    /* renamed from: a */
    String f9133a = PrefFragmentChats.ALL_CHAT;

    /* renamed from: o */
    private int f9147o = -1;

    /* renamed from: q */
    private HashMap<String, Typeface> f9149q = new HashMap<>();

    /* renamed from: k */
    private Map<Integer, String> f9143k = new HashMap();

    /* renamed from: l */
    private Map<FontType, Float> f9144l = new HashMap();

    /* renamed from: m */
    private Map<FontType, Typeface> f9145m = new HashMap();

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f9142j = (ActivityFontChange) activity;
    }

    /* renamed from: a */
    private void m9102a() {
        if (this.f9143k != null) {
            this.f9143k.clear();
        }
        if (this.f9144l != null) {
            this.f9144l.clear();
        }
        if (this.f9145m != null) {
            this.f9145m.clear();
        }
        Iterator<FontType> it = this.f9146n.iterator();
        while (it.hasNext()) {
            FontType next = it.next();
            if (this.f9143k != null && this.f9144l != null && this.f9145m != null) {
                this.f9143k.put(Integer.valueOf(next.getId()), next.getFontTitle());
                this.f9144l.put(next, Float.valueOf(next.getFontFileSize()));
                this.f9145m.put(next, next.getFontType());
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) throws Throwable {
        super.onCreate(bundle);
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(5, new ThreadFactoryC2507dn(this));
        BaseActivity.m3083b(this, true);
        this.f9139g = new C3326c(executorServiceNewFixedThreadPool);
        m9104b();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.done_download_menu, menu);
        C3228cp.m11346b(menu.findItem(R.id.menu_download));
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem menuItemFindItem = menu.findItem(R.id.menu_download);
        if (menuItemFindItem != null) {
            if (C2570bj.m9509a() > 0) {
                C3228cp.m11344a(menuItemFindItem, true);
            } else {
                C3228cp.m11344a(menuItemFindItem, false);
            }
        }
        super.onPrepareOptionsMenu(menu);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_done) {
            if (this.f9147o != -1) {
                C3159aa.m10962a().m10984b("Default Font Typeface", Integer.valueOf(this.f9146n.get(this.f9147o).getId()));
                C3159aa.m10962a().m10986b("Default Font Name", this.f9146n.get(this.f9147o).getFontTitle());
            }
            C3641ai.m13211a(CommonApplication.m11493l(), getResources().getString(R.string.buddy_profile_saveprofile_toast_success), 0).show();
            ((InterfaceC2508do) getActivity()).mo8966c();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0094 A[PHI: r1
  0x0094: PHI (r1v17 android.database.Cursor) = (r1v5 android.database.Cursor), (r1v23 android.database.Cursor) binds: [B:34:0x0102, B:13:0x0092] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0169  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m9104b() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 363
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.settings.FragmentFontChange.m9104b():void");
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f9138f = layoutInflater.inflate(R.layout.layout_change_font, viewGroup, false);
        try {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.skin_01));
            bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
            this.f9138f.setBackgroundDrawable(bitmapDrawable);
        } catch (Exception e) {
            e.printStackTrace();
        }
        m9102a();
        if (this.f9138f.findViewById(R.id.sent_font_size) != null) {
            this.f9134b = (TextView) this.f9138f.findViewById(R.id.sent_font_size);
        }
        if (this.f9138f.findViewById(R.id.read_font_size) != null) {
            this.f9135c = (TextView) this.f9138f.findViewById(R.id.read_font_size);
        }
        this.f9141i = new FontType();
        if (this.f9143k != null) {
            this.f9141i.setFontTitle(this.f9143k.get(C3159aa.m10962a().m10978a("Default Font Typeface", (Integer) (-1))));
        }
        this.f9140h = (ListView) this.f9138f.findViewById(android.R.id.list);
        this.f9148p = new C2652dp(this);
        this.f9140h.setAdapter((ListAdapter) this.f9148p);
        this.f9140h.setItemChecked(0, true);
        this.f9134b.setTypeface(Typeface.SANS_SERIF);
        this.f9135c.setTypeface(Typeface.SANS_SERIF);
        Iterator<FontType> it = this.f9146n.iterator();
        while (it.hasNext()) {
            FontType next = it.next();
            if (next.getFontTitle().equals(this.f9141i.getFontTitle())) {
                this.f9140h.setItemChecked(this.f9146n.indexOf(next), true);
                if (!next.getFontTitle().equals(GlobalApplication.m6451b().getString(R.string.chaton_default))) {
                    try {
                        Typeface typefaceCreateFromFile = Typeface.createFromFile(C2570bj.m9521c(CommonApplication.m11493l(), Integer.toString(next.getId())).getPath());
                        this.f9134b.setTypeface(typefaceCreateFromFile);
                        this.f9135c.setTypeface(typefaceCreateFromFile);
                    } catch (Exception e2) {
                        C3250y.m11450b("Cannot make font from file", getClass().getSimpleName());
                    }
                }
            }
        }
        this.f9140h.setOnItemClickListener(this);
        setHasOptionsMenu(true);
        return this.f9138f;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        C3225cm.m11337a(getActivity());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        m9106c();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() throws Throwable {
        super.onResume();
        if (this.f9137e == 0 || this.f9136d == 0) {
            m9106c();
        }
        m9104b();
        m9107d();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f9139g.m11731a();
    }

    /* renamed from: c */
    private void m9106c() {
        WindowManager windowManager = (WindowManager) getActivity().getSystemService("window");
        this.f9136d = windowManager.getDefaultDisplay().getWidth();
        this.f9137e = windowManager.getDefaultDisplay().getHeight();
        C3250y.m11450b("1. windows size=width:" + this.f9136d + " height:" + this.f9137e, getClass().getSimpleName());
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
        this.f9147o = i;
        if (this.f9146n.get(i).getId() == -1) {
            this.f9134b.setTypeface(Typeface.SANS_SERIF);
            this.f9135c.setTypeface(Typeface.SANS_SERIF);
            return;
        }
        try {
            if (!this.f9149q.containsKey(Integer.toString(this.f9146n.get(i).getId()))) {
                Typeface typefaceCreateFromFile = Typeface.createFromFile(C2570bj.m9521c(GlobalApplication.m11493l(), Integer.toString(this.f9146n.get(i).getId())).getPath());
                this.f9149q.put(Integer.toString(this.f9146n.get(i).getId()), typefaceCreateFromFile);
                this.f9134b.setTypeface(typefaceCreateFromFile);
                this.f9135c.setTypeface(typefaceCreateFromFile);
            } else {
                this.f9134b.setTypeface(this.f9149q.get(Integer.toString(this.f9146n.get(i).getId())));
                this.f9135c.setTypeface(this.f9149q.get(Integer.toString(this.f9146n.get(i).getId())));
            }
        } catch (Exception e) {
            C3250y.m11450b("Cannot make font from file", getClass().getSimpleName());
        }
    }

    /* renamed from: d */
    private void m9107d() {
        int iIntValue = C3159aa.m10962a().m10978a("Default Font Typeface", (Integer) (-1)).intValue();
        if (iIntValue == -1) {
            this.f9134b.setTypeface(Typeface.DEFAULT);
            this.f9135c.setTypeface(Typeface.DEFAULT);
        } else {
            Typeface typefaceCreateFromFile = Typeface.createFromFile(C2570bj.m9521c(GlobalApplication.m11493l(), Integer.toString(iIntValue)).getPath());
            this.f9134b.setTypeface(typefaceCreateFromFile);
            this.f9135c.setTypeface(typefaceCreateFromFile);
        }
    }
}
