package com.sec.chaton.multimedia.vcard;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class VCardReadContactFragment extends ListFragment implements InterfaceC2909n {

    /* renamed from: i */
    public static final String f10696i = VCardReadContactFragment.class.getSimpleName();

    /* renamed from: j */
    private AbstractC2896a f10697j;

    /* renamed from: m */
    private C2897b f10700m;

    /* renamed from: o */
    private String f10702o;

    /* renamed from: p */
    private ProgressDialog f10703p;

    /* renamed from: r */
    private Context f10705r;

    /* renamed from: s */
    private String f10706s;

    /* renamed from: t */
    private LinearLayout f10707t;

    /* renamed from: u */
    private String f10708u;

    /* renamed from: v */
    private MenuItem f10709v;

    /* renamed from: k */
    private C2910o f10698k = null;

    /* renamed from: l */
    private List<C2898c> f10699l = new ArrayList();

    /* renamed from: n */
    private int f10701n = 0;

    /* renamed from: q */
    private String f10704q = null;

    /* renamed from: w */
    private Runnable f10710w = new RunnableC2913r(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10706s = getArguments().getString("inbox_NO");
        this.f10697j = AbstractC2896a.m12090a(getActivity());
        this.f10705r = getActivity();
        setHasOptionsMenu(true);
    }

    @Override // android.support.v4.app.ListFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_multimedia_vcard_send, viewGroup, false);
        this.f10707t = (LinearLayout) viewInflate.findViewById(R.id.vcard_nocontact_layout);
        this.f10703p = new ProgressDialogC4926s(this.f10705r);
        this.f10703p.setProgressStyle(0);
        this.f10703p.setMessage(getString(R.string.wait_sending));
        if (bundle == null) {
            m12085d();
        } else if (bundle.containsKey("dataUriString")) {
            this.f10708u = bundle.getString("dataUriString");
            if (!TextUtils.isEmpty(this.f10708u)) {
                m12081a(Uri.parse(this.f10708u));
            }
        }
        return viewInflate;
    }

    /* renamed from: c */
    private void m12084c() {
        int i = 0;
        for (int i2 = 0; this.f10699l.size() > i2; i2++) {
            if (this.f10699l.get(i2).f10725d == 9 && !this.f10699l.get(i2).f10727f) {
                this.f10700m.f10715d = null;
            }
            if (this.f10699l.get(i2).f10727f) {
                i++;
                if (this.f10699l.get(i2).f10725d == 5) {
                    this.f10700m.m12091a(this.f10699l.get(i2).f10722a, this.f10699l.get(i2).f10723b, this.f10699l.get(i2).f10724c, true);
                } else if (this.f10699l.get(i2).f10725d == 1) {
                    this.f10700m.m12092b(this.f10699l.get(i2).f10722a, this.f10699l.get(i2).f10723b, this.f10699l.get(i2).f10724c, true);
                }
            }
        }
        if (i <= 0) {
            getActivity().finish();
        } else {
            this.f10703p.show();
            new Thread((ThreadGroup) null, this.f10710w).start();
        }
    }

    /* renamed from: d */
    private void m12085d() {
        try {
            startActivityForResult(this.f10697j.mo12060a(), 1);
        } catch (ActivityNotFoundException e) {
            C4904y.m18635a(e, getClass().getSimpleName());
            C5179v.m19810a(this.f10705r, R.string.toast_contact_not_found, 0).show();
            getActivity().finish();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("dataUriString", this.f10708u);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.support.v4.app.ListFragment
    /* renamed from: a */
    public void mo62a(ListView listView, View view, int i, long j) {
        super.mo62a(listView, view, i, j);
        C4904y.m18639b("POSITION : " + i, "VCardReadContactActivity");
        C4904y.m18639b("CONTACT KIND : " + this.f10699l.get(i).f10725d, "VCardReadContactActivity");
        C4904y.m18639b("CONTACT TYPE : " + this.f10699l.get(i).f10722a, "VCardReadContactActivity");
        C4904y.m18639b("CONTACT DATA : " + this.f10699l.get(i).f10723b, "VCardReadContactActivity");
        if (this.f10699l.get(i) != null) {
            this.f10699l.get(i).f10727f = !this.f10699l.get(i).f10727f;
            if (this.f10699l.get(i).f10727f) {
                this.f10701n++;
                if (m12079a(this.f10699l.get(i).f10725d) > 3) {
                    if (this.f10699l.get(i).f10725d == 5) {
                        C5179v.m19811a(this.f10705r, getString(R.string.vcard_list_checked_over_phone, 3), 0).show();
                    } else if (this.f10699l.get(i).f10725d == 1) {
                        C5179v.m19811a(this.f10705r, getString(R.string.vcard_list_checked_over_email, 3), 0).show();
                    }
                    this.f10699l.get(i).f10727f = false;
                    this.f10701n--;
                }
            } else {
                this.f10701n--;
            }
            if (this.f10701n > 0) {
                this.f10709v.setEnabled(true);
            } else {
                this.f10709v.setEnabled(false);
            }
            ((C2911p) view.getTag()).f10776c.setChecked(this.f10699l.get(i).f10727f);
        }
    }

    /* renamed from: a */
    private int m12079a(int i) {
        int i2 = 0;
        Iterator<C2898c> it = this.f10699l.iterator();
        while (true) {
            int i3 = i2;
            if (it.hasNext()) {
                C2898c next = it.next();
                if (next.f10725d == i && next.f10727f) {
                    i3++;
                }
                i2 = i3;
            } else {
                return i3;
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            m12081a(intent.getData());
            this.f10708u = intent.getDataString();
        } else {
            getActivity().finish();
        }
    }

    /* renamed from: a */
    private void m12081a(Uri uri) {
        new AsyncTaskC2912q(this).execute(uri);
    }

    /* renamed from: a */
    protected void m12087a(C2897b c2897b) {
        ArrayList arrayList = new ArrayList();
        this.f10700m = new C2897b();
        if (c2897b.f10712a != null) {
            this.f10700m.f10712a = c2897b.f10712a;
        }
        if (c2897b.f10713b != null) {
            this.f10700m.f10713b = c2897b.f10713b;
        }
        if (c2897b.f10714c != null) {
            this.f10700m.f10714c = c2897b.f10714c;
        }
        if (c2897b.f10715d != null && c2897b.f10715d.length() > 0) {
            this.f10700m.f10715d = c2897b.f10715d;
        }
        if (c2897b.f10717f != null) {
            int i = 0;
            while (c2897b.f10717f.size() > i) {
                String str = c2897b.f10717f.get(i).f10739c;
                if (c2897b.f10717f.get(i).f10737a == 1 || c2897b.f10717f.get(i).f10737a == 2 || c2897b.f10717f.get(i).f10737a == 3 || c2897b.f10717f.get(i).f10737a == 4) {
                    String str2 = c2897b.f10717f.get(i).f10738b;
                    C4904y.m18639b("ORIGINAL PHONE NUMBER : " + c2897b.f10717f.get(i).f10738b, f10696i);
                    C4904y.m18639b("EDITED PHONE NUMBER : " + str2, f10696i);
                    arrayList.add(new C2898c(c2897b.f10717f.get(i).f10737a, str2, str, 5, i == 0));
                }
                i++;
            }
        }
        if (c2897b.f10718g != null && c2897b.f10718g.size() > 0) {
            arrayList.add(new C2898c(c2897b.f10718g.get(0).f10728a, c2897b.f10718g.get(0).f10729b, c2897b.f10718g.get(0).f10730c, 1, true));
        }
        if (c2897b.f10715d != null && !c2897b.f10715d.equals("")) {
            arrayList.add(new C2898c(0, c2897b.f10715d, null, 9, true));
        }
        String str3 = "";
        if (c2897b.f10712a != null) {
            if (c2897b.f10713b != null) {
                str3 = c2897b.f10712a + " " + c2897b.f10713b;
            } else {
                str3 = c2897b.f10712a;
            }
        } else if (c2897b.f10713b != null) {
            str3 = c2897b.f10713b;
        } else if (c2897b.f10714c != null) {
            str3 = c2897b.f10714c;
        } else if (c2897b.f10717f != null) {
            str3 = c2897b.f10717f.get(0).f10738b;
        } else if (c2897b.f10718g != null) {
            str3 = c2897b.f10718g.get(0).f10729b;
        }
        m12083b(str3);
        this.f10699l = arrayList;
        if (arrayList.size() > 0) {
            this.f10698k = C2910o.m12118a(getActivity(), this.f10699l);
            m61a(this.f10698k);
            m60a().setVisibility(0);
            this.f10707t.setVisibility(8);
            return;
        }
        m60a().setVisibility(8);
        this.f10707t.setVisibility(0);
    }

    /* renamed from: b */
    private void m12083b(String str) {
        if (getActivity() != null) {
            ((VCardReadContactActivity) getActivity()).m12078h().mo18823a(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0141  */
    /* JADX WARN: Type inference failed for: r1v25, types: [android.support.v4.app.FragmentActivity] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m12088a(java.lang.String r6) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 365
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.multimedia.vcard.VCardReadContactFragment.m12088a(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m12086e() throws Throwable {
        try {
            this.f10704q = new C2906k().m12110a(this.f10700m, 1);
            C4904y.m18639b("*** VCARD CONTENTS : " + this.f10704q, f10696i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.f10704q != null) {
            m12088a(this.f10704q);
        } else {
            getActivity().finish();
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            if (getActivity() != null) {
                getActivity().finish();
                return true;
            }
        } else if (menuItem.getItemId() == R.id.menu_done) {
            m12084c();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.done_menu, menu);
        this.f10709v = menu.findItem(R.id.menu_done);
        this.f10709v.setEnabled(false);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // com.sec.chaton.multimedia.vcard.InterfaceC2909n
    /* renamed from: l_ */
    public void mo12089l_() {
        this.f10701n = 0;
        this.f10709v.setEnabled(false);
        m12085d();
    }
}
