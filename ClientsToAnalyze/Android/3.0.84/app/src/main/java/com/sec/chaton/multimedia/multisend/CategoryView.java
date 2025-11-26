package com.sec.chaton.multimedia.multisend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;
import com.sec.common.p069e.C3326c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class CategoryView extends Fragment {

    /* renamed from: a */
    private GridView f7192a;

    /* renamed from: b */
    private ArrayList<C1902e> f7193b;

    /* renamed from: c */
    private ArrayList<PreviewData> f7194c;

    /* renamed from: d */
    private HashMap<String, String> f7195d;

    /* renamed from: e */
    private C1899b f7196e;

    /* renamed from: f */
    private C3326c f7197f;

    /* renamed from: g */
    private String f7198g;

    /* renamed from: h */
    private String f7199h;

    /* renamed from: i */
    private TextView f7200i;

    /* renamed from: j */
    private int f7201j;

    /* renamed from: k */
    private Toast f7202k;

    /* renamed from: l */
    private Menu f7203l;

    /* renamed from: m */
    private boolean f7204m;

    /* renamed from: n */
    private int f7205n;

    /* renamed from: a */
    static /* synthetic */ int m7724a(CategoryView categoryView, int i) {
        int i2 = categoryView.f7201j - i;
        categoryView.f7201j = i2;
        return i2;
    }

    /* renamed from: b */
    static /* synthetic */ int m7729b(CategoryView categoryView, int i) {
        int i2 = categoryView.f7201j + i;
        categoryView.f7201j = i2;
        return i2;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getActivity().getIntent();
        this.f7198g = intent.getStringExtra("category");
        this.f7199h = intent.getStringExtra("categoryName");
        this.f7194c = intent.getParcelableArrayListExtra("preview_data");
        if ("POSTON".equals(intent.getExtras().getString("caller"))) {
            this.f7204m = true;
            this.f7205n = intent.getExtras().getInt("attachedimagecount");
        } else {
            this.f7204m = false;
            this.f7205n = 0;
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_smi_category, viewGroup, false);
        this.f7193b = new ArrayList<>();
        this.f7195d = new HashMap<>();
        this.f7197f = new C3326c();
        this.f7196e = new C1899b(getActivity(), R.layout.layout_smi_category_item, this.f7193b, this.f7197f, this.f7195d);
        this.f7192a = (GridView) viewInflate.findViewById(R.id.gridCategory);
        this.f7192a.setOnItemClickListener(new C1901d(this));
        this.f7200i = (TextView) viewInflate.findViewById(R.id.count);
        this.f7195d.clear();
        ((CategoryActivity) getActivity()).m7721a(this.f7193b, this.f7198g);
        if (this.f7194c != null && this.f7198g != null) {
            this.f7201j = this.f7194c.size();
            m7727a(this.f7194c, this.f7201j);
        }
        this.f7201j += this.f7205n;
        this.f7192a.setAdapter((ListAdapter) this.f7196e);
        setHasOptionsMenu(true);
        m7733a();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        ((CategoryActivity) getActivity()).m7722c().mo11583a(this.f7199h);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.smi_category_menu, menu);
        this.f7203l = menu;
        m7733a();
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.smi_category_done /* 2131166619 */:
                if (this.f7204m) {
                    Intent intent = new Intent();
                    intent.putExtra("send_list", true);
                    intent.putParcelableArrayListExtra("preview_data", this.f7194c);
                    ((CategoryActivity) getActivity()).m7723c(intent);
                } else {
                    m7734a(this.f7195d);
                    Intent intent2 = new Intent(getActivity(), (Class<?>) PreviewPageActivity.class);
                    intent2.putParcelableArrayListExtra("preview_data", this.f7194c);
                    startActivityForResult(intent2, 0);
                }
            default:
                return false;
        }
    }

    /* renamed from: a */
    void m7733a() {
        this.f7200i.setText(getString(R.string.anicon_volume_prefix) + " : " + this.f7201j + "/10");
        if (this.f7203l != null) {
            if (this.f7201j == 0) {
                this.f7203l.findItem(R.id.smi_category_done).setEnabled(false);
            } else {
                this.f7203l.findItem(R.id.smi_category_done).setEnabled(true);
            }
        }
    }

    /* renamed from: a */
    private HashMap<String, String> m7727a(ArrayList<PreviewData> arrayList, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f7198g.equals(arrayList.get(i2).m7750c())) {
                this.f7195d.put(arrayList.get(i2).m7746a(), arrayList.get(i2).m7748b());
            }
        }
        return this.f7195d;
    }

    /* renamed from: b */
    private void m7730b() {
        if (this.f7195d != null && !this.f7195d.isEmpty()) {
            this.f7195d.clear();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f7192a != null) {
            this.f7192a.setOnItemClickListener(null);
            this.f7192a.setAdapter((ListAdapter) null);
        }
        if (this.f7197f != null) {
            this.f7197f.m11731a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (C3250y.f11734b) {
            C3250y.m11450b("CategoryView.onDestroy()", CategoryView.class.getSimpleName());
        }
        m7730b();
        if (this.f7193b != null && !this.f7193b.isEmpty()) {
            this.f7193b.clear();
        }
        if (this.f7195d != null && !this.f7195d.isEmpty()) {
            this.f7195d.clear();
        }
        if (this.f7194c != null && !this.f7194c.isEmpty()) {
            this.f7194c.clear();
        }
        super.onDestroy();
    }

    /* renamed from: a */
    public void m7734a(HashMap<String, String> map) {
        boolean z;
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                Iterator<PreviewData> it = this.f7194c.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().m7746a().equals(entry.getKey())) {
                            z = false;
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    Iterator<C1902e> it2 = this.f7193b.iterator();
                    String str = null;
                    while (it2.hasNext()) {
                        C1902e next = it2.next();
                        if (next.f7246a.equals(entry.getKey())) {
                            str = next.f7248c;
                        }
                    }
                    this.f7194c.add(new PreviewData(entry.getKey(), entry.getValue(), this.f7198g, null, str));
                }
            }
        }
        int i = 0;
        while (i < this.f7194c.size()) {
            if (this.f7194c.get(i).m7750c().equals(this.f7198g) && !map.containsKey(this.f7194c.get(i).m7746a())) {
                this.f7194c.remove(i);
                i = -1;
            }
            i++;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 0:
                    if (intent != null) {
                        boolean booleanExtra = intent.getBooleanExtra("send_list", false);
                        this.f7194c = intent.getParcelableArrayListExtra("preview_data");
                        this.f7201j = this.f7194c.size();
                        if (booleanExtra) {
                            Intent intent2 = new Intent();
                            intent2.putParcelableArrayListExtra("preview_data", this.f7194c);
                            intent2.putExtra("send_list", booleanExtra);
                            ((CategoryActivity) getActivity()).m7723c(intent2);
                        }
                        m7733a();
                        this.f7195d.clear();
                        m7727a(this.f7194c, this.f7201j);
                        this.f7192a.invalidateViews();
                        break;
                    }
                    break;
            }
        }
    }
}
