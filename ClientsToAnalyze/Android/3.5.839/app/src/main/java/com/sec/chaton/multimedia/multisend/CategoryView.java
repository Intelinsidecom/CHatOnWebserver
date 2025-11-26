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
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p132g.C5007c;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class CategoryView extends Fragment {

    /* renamed from: a */
    private GridView f10513a;

    /* renamed from: b */
    private ArrayList<C2871e> f10514b;

    /* renamed from: c */
    private ArrayList<PreviewData> f10515c;

    /* renamed from: d */
    private HashMap<String, String> f10516d;

    /* renamed from: e */
    private C2868b f10517e;

    /* renamed from: f */
    private C5007c f10518f;

    /* renamed from: g */
    private String f10519g;

    /* renamed from: h */
    private String f10520h;

    /* renamed from: i */
    private TextView f10521i;

    /* renamed from: j */
    private int f10522j;

    /* renamed from: k */
    private Toast f10523k;

    /* renamed from: l */
    private Menu f10524l;

    /* renamed from: m */
    private boolean f10525m;

    /* renamed from: n */
    private int f10526n;

    /* renamed from: a */
    static /* synthetic */ int m11955a(CategoryView categoryView, int i) {
        int i2 = categoryView.f10522j - i;
        categoryView.f10522j = i2;
        return i2;
    }

    /* renamed from: b */
    static /* synthetic */ int m11959b(CategoryView categoryView, int i) {
        int i2 = categoryView.f10522j + i;
        categoryView.f10522j = i2;
        return i2;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getActivity().getIntent();
        this.f10519g = intent.getStringExtra("category");
        this.f10520h = intent.getStringExtra("categoryName");
        this.f10515c = intent.getParcelableArrayListExtra("preview_data");
        if ("POSTON".equals(intent.getExtras().getString("caller"))) {
            this.f10525m = true;
            this.f10526n = intent.getExtras().getInt("attachedimagecount");
        } else {
            this.f10525m = false;
            this.f10526n = 0;
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_smi_category, viewGroup, false);
        this.f10514b = new ArrayList<>();
        this.f10516d = new HashMap<>();
        this.f10518f = new C5007c();
        this.f10517e = new C2868b(getActivity(), R.layout.layout_smi_category_item, this.f10514b, this.f10518f, this.f10516d);
        this.f10513a = (GridView) viewInflate.findViewById(R.id.gridCategory);
        this.f10523k = C5179v.m19811a(CommonApplication.m18732r(), (CharSequence) null, 0);
        this.f10513a.setOnItemClickListener(new C2870d(this));
        this.f10521i = (TextView) viewInflate.findViewById(R.id.count);
        this.f10516d.clear();
        ((CategoryActivity) getActivity()).m11952a(this.f10514b, this.f10519g);
        if (this.f10515c != null && this.f10519g != null) {
            this.f10522j = this.f10515c.size();
            m11957a(this.f10515c, this.f10522j);
        }
        this.f10522j += this.f10526n;
        this.f10513a.setAdapter((ListAdapter) this.f10517e);
        setHasOptionsMenu(true);
        m11963a();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        ((CategoryActivity) getActivity()).m11954h().mo18823a(this.f10520h);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.smi_category_menu, menu);
        this.f10524l = menu;
        m11963a();
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.smi_category_cancel /* 2131166712 */:
                ((CategoryActivity) getActivity()).finish();
                return false;
            case R.id.smi_category_done /* 2131166713 */:
                if (this.f10525m) {
                    Intent intent = new Intent();
                    intent.putExtra("send_list", true);
                    intent.putParcelableArrayListExtra("preview_data", this.f10515c);
                    ((CategoryActivity) getActivity()).m11953b(intent);
                } else {
                    m11964a(this.f10516d);
                    Intent intent2 = new Intent(getActivity(), (Class<?>) PreviewPageActivity.class);
                    intent2.putParcelableArrayListExtra("preview_data", this.f10515c);
                    startActivityForResult(intent2, 0);
                }
                return false;
            default:
                return false;
        }
    }

    /* renamed from: a */
    void m11963a() {
        this.f10521i.setText(getString(R.string.anicon_volume_prefix) + " : " + this.f10522j + "/10");
        if (this.f10524l != null) {
            if (this.f10522j == 0) {
                this.f10524l.findItem(R.id.smi_category_done).setEnabled(false);
            } else {
                this.f10524l.findItem(R.id.smi_category_done).setEnabled(true);
            }
        }
    }

    /* renamed from: a */
    private HashMap<String, String> m11957a(ArrayList<PreviewData> arrayList, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f10519g.equals(arrayList.get(i2).m11980c())) {
                this.f10516d.put(arrayList.get(i2).m11976a(), arrayList.get(i2).m11978b());
            }
        }
        return this.f10516d;
    }

    /* renamed from: b */
    private void m11960b() {
        if (this.f10516d != null && !this.f10516d.isEmpty()) {
            this.f10516d.clear();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f10513a != null) {
            this.f10513a.setOnItemClickListener(null);
            this.f10513a.setAdapter((ListAdapter) null);
        }
        if (this.f10518f != null) {
            this.f10518f.m19014a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (C4904y.f17872b) {
            C4904y.m18639b("CategoryView.onDestroy()", CategoryView.class.getSimpleName());
        }
        m11960b();
        if (this.f10514b != null && !this.f10514b.isEmpty()) {
            this.f10514b.clear();
        }
        if (this.f10516d != null && !this.f10516d.isEmpty()) {
            this.f10516d.clear();
        }
        if (this.f10515c != null && !this.f10515c.isEmpty()) {
            this.f10515c.clear();
        }
        super.onDestroy();
    }

    /* renamed from: a */
    public void m11964a(HashMap<String, String> map) {
        boolean z;
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                Iterator<PreviewData> it = this.f10515c.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().m11976a().equals(entry.getKey())) {
                            z = false;
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    Iterator<C2871e> it2 = this.f10514b.iterator();
                    String str = null;
                    while (it2.hasNext()) {
                        C2871e next = it2.next();
                        if (next.f10567a.equals(entry.getKey())) {
                            str = next.f10569c;
                        }
                    }
                    this.f10515c.add(new PreviewData(entry.getKey(), entry.getValue(), this.f10519g, null, str));
                }
            }
            int i = 0;
            while (i < this.f10515c.size()) {
                if (this.f10515c.get(i).m11980c().equals(this.f10519g) && !map.containsKey(this.f10515c.get(i).m11976a())) {
                    this.f10515c.remove(i);
                    i = -1;
                }
                i++;
            }
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
                        this.f10515c = intent.getParcelableArrayListExtra("preview_data");
                        this.f10522j = this.f10515c.size();
                        if (booleanExtra) {
                            Intent intent2 = new Intent();
                            intent2.putParcelableArrayListExtra("preview_data", this.f10515c);
                            intent2.putExtra("send_list", booleanExtra);
                            ((CategoryActivity) getActivity()).m11953b(intent2);
                        }
                        m11963a();
                        this.f10516d.clear();
                        m11957a(this.f10515c, this.f10522j);
                        this.f10513a.invalidateViews();
                        break;
                    }
                    break;
            }
        }
    }
}
