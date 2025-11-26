package com.sec.vip.amschaton.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.p025d.EnumC1327e;
import com.sec.chaton.settings.downloads.ActivityAmsItemDownloads;
import com.sec.chaton.settings.downloads.C2642q;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3172an;
import com.sec.chaton.util.C3228cp;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.vip.amschaton.AMSImageEditorActivity;
import com.sec.vip.amschaton.C3425b;
import com.sec.vip.amschaton.DialogInterfaceOnClickListenerC3449d;
import com.sec.vip.amschaton.InterfaceC3434bi;
import com.sec.vip.amschaton.p071a.C3396d;
import java.io.File;

/* loaded from: classes.dex */
public class AMSBgSelectionFragment extends AMSFragment implements View.OnClickListener, InterfaceC3434bi {

    /* renamed from: A */
    private CheckedTextView f12627A;

    /* renamed from: B */
    private View f12628B;

    /* renamed from: b */
    private GridView f12635b = null;

    /* renamed from: c */
    private LinearLayout f12636c = null;

    /* renamed from: m */
    private View f12637m = null;

    /* renamed from: n */
    private View f12638n = null;

    /* renamed from: o */
    private C3572y f12639o = null;

    /* renamed from: p */
    private C3396d f12640p = null;

    /* renamed from: q */
    private C3567t f12641q = null;

    /* renamed from: r */
    private int f12642r = 1000;

    /* renamed from: s */
    private int f12643s = 0;

    /* renamed from: t */
    private int f12644t = -16777216;

    /* renamed from: u */
    private int f12645u = 5001;

    /* renamed from: v */
    private int f12646v = 3000;

    /* renamed from: w */
    private boolean f12647w = false;

    /* renamed from: x */
    private ProgressDialogC3265l f12648x = null;

    /* renamed from: a */
    DialogInterfaceOnClickListenerC3449d f12634a = null;

    /* renamed from: y */
    private int f12649y = 0;

    /* renamed from: z */
    private long f12650z = 0;

    /* renamed from: C */
    private boolean f12629C = false;

    /* renamed from: D */
    private final View.OnClickListener f12630D = new ViewOnClickListenerC3555h(this);

    /* renamed from: E */
    private AdapterView.OnItemLongClickListener f12631E = new C3556i(this);

    /* renamed from: F */
    private AdapterView.OnItemClickListener f12632F = new C3557j(this);

    /* renamed from: G */
    private Handler f12633G = new HandlerC3552e(this);

    @Override // com.sec.vip.amschaton.fragment.AMSFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        BaseActivity.m3081a(this, true);
        this.f12640p = new C3396d(getActivity());
        this.f12640p.m12110b();
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_ams_list, viewGroup, false);
        Bundle extras = getActivity().getIntent().getExtras();
        this.f12642r = extras.getInt("AMS_FRAME", 1000);
        this.f12643s = extras.getInt("BACKGROUND_INDEX", 0);
        this.f12644t = extras.getInt("BACKGROUND_COLOR");
        this.f12627A = (CheckedTextView) viewInflate.findViewById(R.id.layout_select_all);
        this.f12627A.setVisibility(8);
        this.f12627A.setOnClickListener(this.f12630D);
        ((FrameLayout) viewInflate.findViewById(R.id.ams_message_list)).setVisibility(0);
        ((FrameLayout) viewInflate.findViewById(R.id.ams_stamp_list)).setVisibility(8);
        this.f12635b = (GridView) viewInflate.findViewById(R.id.grid_user_file_list);
        registerForContextMenu(this.f12635b);
        this.f12635b.setOnItemLongClickListener(this.f12631E);
        m12376c(true);
        m12363a(viewInflate);
        this.f12636c = (LinearLayout) viewInflate.findViewById(R.id.layout_recent_sample);
        this.f12637m = viewInflate.findViewById(R.id.btn_recently);
        this.f12638n = viewInflate.findViewById(R.id.btn_sample);
        this.f12636c.setVisibility(0);
        this.f12637m.setOnClickListener(this);
        this.f12638n.setOnClickListener(this);
        m12397h(5001);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        getActivity().setTitle(R.string.ams_background);
    }

    /* renamed from: b */
    private void m12370b(int i) {
        if (this.f12628B != null) {
            switch (i) {
                case 5000:
                    ((ImageView) this.f12628B.findViewById(R.id.image1)).setImageResource(R.drawable.no_contents_ams_recently);
                    ((TextView) this.f12628B.findViewById(R.id.text1)).setText(R.string.ams_no_recent_backgrounds);
                    ((TextView) this.f12628B.findViewById(R.id.text2)).setVisibility(8);
                    break;
                default:
                    ((ImageView) this.f12628B.findViewById(R.id.image1)).setImageResource(R.drawable.nocontents_ams_backgroud);
                    ((TextView) this.f12628B.findViewById(R.id.text1)).setText(R.string.ams_tap_create_background);
                    ((TextView) this.f12628B.findViewById(R.id.text2)).setVisibility(0);
                    break;
            }
        }
    }

    /* renamed from: a */
    private void m12363a(View view) {
        this.f12628B = view.findViewById(R.id.layout_no_items);
        ((ImageView) this.f12628B.findViewById(R.id.image1)).setMinimumHeight((int) C3172an.m11086b(110.0f));
        ((ImageView) this.f12628B.findViewById(R.id.image1)).setMinimumWidth((int) C3172an.m11086b(110.0f));
        ((ImageView) this.f12628B.findViewById(R.id.image1)).setScaleType(ImageView.ScaleType.FIT_XY);
        ((TextView) this.f12628B.findViewById(R.id.text2)).setText(R.string.ams_no_recent_backgrounds);
        View viewFindViewById = this.f12628B.findViewById(R.id.image1);
        viewFindViewById.setOnClickListener(new ViewOnClickListenerC3452a(this, viewFindViewById));
        this.f12635b.setEmptyView(this.f12628B);
        this.f12635b.setVisibility(4);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int i;
        boolean z = false;
        int itemId = menuItem.getItemId();
        if (itemId == R.id.menu_cancel) {
            mo12415c();
            z = true;
        } else if (itemId == R.id.ams_delete) {
            m12376c(false);
            m12381d(true);
            m12380d(3002);
            m12392g();
            getActivity().supportInvalidateOptionsMenu();
            z = true;
        } else if (itemId == R.id.menu_done) {
            m12376c(true);
            String string = getActivity().getApplicationContext().getString(R.string.ams_delete_single_item);
            boolean[] zArrM12414q = m12414q();
            if (zArrM12414q != null) {
                i = 0;
                for (boolean z2 : zArrM12414q) {
                    if (z2) {
                        i++;
                    }
                }
            } else {
                i = 0;
            }
            AbstractC3271a.m11494a(getActivity()).mo11495a(R.string.ams_btn_delete).mo11509b(i > 1 ? getActivity().getApplicationContext().getString(R.string.selected_items_deleted) : string).mo11515d(R.string.ams_btn_ok, new DialogInterfaceOnClickListenerC3554g(this)).mo11507b(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC3553f(this)).mo11505a().show();
            getActivity().supportInvalidateOptionsMenu();
            z = true;
        } else if (itemId == R.id.ams_download) {
            Intent intent = new Intent(getActivity(), (Class<?>) ActivityAmsItemDownloads.class);
            intent.putExtra("amsType", EnumC1327e.Background);
            startActivityForResult(intent, 201);
            z = true;
        }
        if (!z) {
            return super.onOptionsItemSelected(menuItem);
        }
        return z;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        C3250y.m11453c("[onDestroy]", getClass().getName());
        if (this.f12640p != null) {
            this.f12640p.mo12098a();
        }
        m12407m();
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        C3250y.m11453c("[onPause]", getClass().getName());
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        C3250y.m11453c("[onResume]", getClass().getName());
        m12396h();
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 0:
                    m12361a(intent.getExtras());
                    break;
            }
        }
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        if (view.equals(this.f12635b)) {
            contextMenu.setHeaderTitle(R.string.ams_background);
            getActivity().getMenuInflater().inflate(R.menu.ams_ics2_context_menu_my_works, contextMenu);
            contextMenu.findItem(R.id.context_menu_item_send).setVisible(false);
            contextMenu.findItem(R.id.context_menu_item_play).setVisible(false);
            contextMenu.findItem(R.id.context_menu_item_edit).setVisible(false);
            if (this.f12645u == 5000) {
                contextMenu.findItem(R.id.context_menu_item_delete).setVisible(false);
            }
        }
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onContextItemSelected(MenuItem menuItem) {
        Cursor cursorM12109b;
        int i = 1002;
        if (this.f12645u == 5000) {
            if (this.f12640p != null && (cursorM12109b = this.f12640p.m12109b(this.f12650z)) != null) {
                int i2 = cursorM12109b.getInt(cursorM12109b.getColumnIndex("ams_index"));
                int i3 = i2 >= 10000 ? 1002 : 1003;
                int i4 = i3 == 1002 ? i2 - 10000 : i2;
                if (i4 < 0) {
                    C3250y.m11442a("Wrong index", getClass().getSimpleName());
                    return true;
                }
                switch (menuItem.getItemId()) {
                    case R.id.context_menu_item_delete /* 2131166574 */:
                        m12360a(i4, i3);
                        break;
                }
                return super.onContextItemSelected(menuItem);
            }
            return true;
        }
        int i5 = this.f12649y - 2;
        if (i5 >= m12409n()) {
            if (i5 < m12409n() + m12411o()) {
                i = 1003;
            } else if (i5 != m12409n() + m12411o()) {
                i = 1000;
            } else {
                i = 1004;
            }
        }
        switch (menuItem.getItemId()) {
            case R.id.context_menu_item_delete /* 2131166574 */:
                m12360a(i5, i);
                break;
        }
        return super.onContextItemSelected(menuItem);
    }

    /* renamed from: a */
    private void m12361a(Bundle bundle) {
        if (bundle == null) {
            ((InterfaceC3474av) getActivity()).mo11978c();
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.putExtra("AMS_FRAME", 1001);
        intent.putExtra("BACKGROUND_INDEX", this.f12643s);
        getActivity().setResult(-1, intent);
        ((InterfaceC3474av) getActivity()).mo11978c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12367a(boolean z) {
        m12372b(z);
        m12392g();
    }

    /* renamed from: b */
    private void m12372b(boolean z) {
        if (this.f12645u == 5000) {
            if (this.f12639o != null) {
                this.f12639o.m12762a(z);
            }
        } else if (this.f12641q != null) {
            this.f12641q.m12755a(z);
        }
    }

    /* renamed from: c */
    private void m12376c(boolean z) {
        if (this.f12635b != null) {
            this.f12635b.setOnItemClickListener(null);
            if (z) {
                this.f12635b.setOnItemClickListener(this.f12632F);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m12381d(boolean z) {
        if (this.f12627A != null && this.f12636c != null) {
            this.f12627A.setChecked(false);
            this.f12627A.setVisibility(z ? 0 : 8);
            this.f12636c.setVisibility(z ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m12384e() throws Resources.NotFoundException {
        if (C3171am.m11077o()) {
            AbstractC3271a.m11494a(getActivity()).mo11495a(R.string.ams_background).mo11497a(R.array.ams_strarr_add_bg_image, new DialogInterfaceOnClickListenerC3559l(this)).mo11507b(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC3558k(this)).mo11505a().show();
            return;
        }
        CharSequence[] textArray = getResources().getTextArray(R.array.ams_strarr_add_bg_image);
        if (textArray.length == 2) {
            AbstractC3271a.m11494a(getActivity()).mo11495a(R.string.ams_background).mo11504a(new CharSequence[]{textArray[1]}, new DialogInterfaceOnClickListenerC3479b(this)).mo11507b(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC3560m(this)).mo11505a().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m12375c(int i) {
        Intent intent = new Intent(getActivity(), (Class<?>) AMSImageEditorActivity.class);
        intent.putExtra("IMAGE_SELECTOR", i);
        startActivityForResult(intent, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m12388f() {
        boolean zM12357e = false;
        int iM12358f = this.f12644t;
        if (this.f12634a != null) {
            zM12357e = this.f12634a.m12357e();
            iM12358f = this.f12634a.m12358f();
            this.f12634a.m12356d();
            this.f12634a = null;
        }
        this.f12634a = new DialogInterfaceOnClickListenerC3449d(getActivity());
        this.f12634a.m12351a(this.f12644t);
        this.f12634a.m12352a(this);
        this.f12634a.m12355c();
        if (zM12357e) {
            this.f12634a.m12354b(iM12358f);
        }
    }

    /* renamed from: a */
    private void m12360a(int i, int i2) {
        AbstractC3271a.m11494a(getActivity()).mo11495a(R.string.ams_btn_delete).mo11506b(R.string.ams_delete_single_item).mo11515d(R.string.ams_btn_ok, new DialogInterfaceOnClickListenerC3533d(this, i2, i)).mo11507b(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC3506c(this)).mo11505a().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m12380d(int i) {
        this.f12646v = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m12392g() {
        if (this.f12645u == 5000) {
            if (this.f12639o != null) {
                this.f12639o.notifyDataSetChanged();
            }
        } else if (this.f12641q != null) {
            this.f12641q.m12757b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m12385e(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("BACKGROUND_INDEX", this.f12643s);
        bundle.putInt("AMS_FRAME", i);
        switch (i) {
            case 1002:
                bundle.putInt("BG_SKIN_INDEX", this.f12643s);
                m12389f(this.f12643s + 10000);
                break;
            case 1003:
                bundle.putInt("BG_SKIN_INDEX", this.f12643s);
                m12389f(this.f12643s);
                break;
            case 1004:
                bundle.putInt("BACKGROUND_COLOR", this.f12644t);
                break;
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        getActivity().setResult(-1, intent);
        ((InterfaceC3474av) getActivity()).mo11978c();
    }

    /* renamed from: f */
    private void m12389f(int i) {
        if (i >= 0) {
            String strM12278a = "";
            if (i >= 10000) {
                strM12278a = C3425b.m12268a().m12278a(i - 10000);
            }
            this.f12640p.m12107a(String.valueOf(i), strM12278a, String.valueOf(System.currentTimeMillis()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m12396h() {
        if (!this.f12647w) {
            this.f12647w = true;
            new AsyncTaskC3571x(this, null).execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m12393g(int i) {
        if (i >= 0) {
            this.f12640p.m12111b(String.valueOf(i));
        }
    }

    /* renamed from: a */
    private void m12362a(MenuItem menuItem) {
        int iM9632a = C2642q.m9632a(EnumC1327e.Background);
        C3228cp.m11346b(menuItem);
        C3228cp.m11344a(menuItem, iM9632a > 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m12397h(int i) {
        this.f12645u = i;
        switch (this.f12645u) {
            case 5000:
                this.f12637m.setSelected(true);
                this.f12638n.setSelected(false);
                m12403k();
                break;
            case 5001:
                this.f12638n.setSelected(true);
                this.f12637m.setSelected(false);
                m12399i();
                break;
        }
        m12370b(this.f12645u);
        m12402j();
    }

    /* renamed from: i */
    private void m12399i() {
        if (this.f12641q != null) {
            this.f12641q = null;
        }
        this.f12641q = new C3567t(this, getActivity());
        this.f12641q.m12754a(this.f12633G);
        this.f12635b.setAdapter((ListAdapter) this.f12641q);
        m12392g();
    }

    /* renamed from: j */
    private void m12402j() {
        if (this.f12646v != 3002) {
            int iM12409n = 0;
            if (this.f12645u == 5000) {
                if (this.f12639o != null) {
                    iM12409n = this.f12639o.getCount();
                }
            } else {
                iM12409n = m12409n();
            }
            if (iM12409n > 0) {
                m12380d(3001);
            } else {
                m12380d(3000);
            }
            if (getActivity() != null) {
                getActivity().supportInvalidateOptionsMenu();
            }
        }
    }

    /* renamed from: k */
    private void m12403k() {
        Cursor cursorM12112c;
        String string;
        String strM12280a;
        if (this.f12640p != null && this.f12635b != null && (cursorM12112c = this.f12640p.m12112c()) != null) {
            boolean z = false;
            for (boolean zMoveToFirst = cursorM12112c.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorM12112c.moveToNext()) {
                int iIntValue = Integer.valueOf(cursorM12112c.getString(cursorM12112c.getColumnIndex("ams_index"))).intValue();
                if (iIntValue >= 10000 && (string = cursorM12112c.getString(cursorM12112c.getColumnIndex("ams_path"))) != null && (strM12280a = C3425b.m12268a().m12280a(getActivity(), string)) != null && !new File(strM12280a).exists()) {
                    m12393g(iIntValue);
                    z = true;
                }
            }
            Cursor cursorM12112c2 = z ? this.f12640p.m12112c() : cursorM12112c;
            if (this.f12639o != null) {
                this.f12639o = null;
            }
            this.f12639o = new C3572y(this, getActivity(), cursorM12112c2);
            this.f12635b.setAdapter((ListAdapter) this.f12639o);
            this.f12639o.m12761a(this.f12633G);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m12405l() {
        if (this.f12648x != null) {
            this.f12648x = null;
        }
        this.f12648x = new ProgressDialogC3265l(getActivity());
        this.f12648x.setProgressStyle(0);
        this.f12648x.setMessage(getString(R.string.ams_msg_progress_ams_file_loading));
        this.f12648x.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m12407m() {
        if (this.f12648x != null) {
            this.f12648x.dismiss();
            this.f12648x = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public int m12409n() {
        return C3425b.m12268a().m12283b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public int m12411o() {
        return C3425b.m12268a().m12287c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m12413p() {
        boolean[] zArrM12414q = m12414q();
        if (zArrM12414q != null) {
            int length = zArrM12414q.length;
            if (this.f12645u == 5000) {
                if (this.f12640p != null) {
                    Cursor cursorM12112c = this.f12640p.m12112c();
                    if (cursorM12112c == null || cursorM12112c.getCount() == 0 || cursorM12112c.getCount() != length) {
                        if (cursorM12112c != null && !cursorM12112c.isClosed()) {
                            cursorM12112c.close();
                            return;
                        }
                        return;
                    }
                    for (int i = 0; i < length; i++) {
                        if (zArrM12414q[i]) {
                            cursorM12112c.moveToPosition(i);
                            int i2 = cursorM12112c.getInt(cursorM12112c.getColumnIndex("ams_index"));
                            char c = i2 < 10000 ? (char) 1003 : (char) 1002;
                            if (c == 1002) {
                                i2 -= 10000;
                            }
                            if (i2 < 0) {
                                C3250y.m11442a("Wrong index", getClass().getSimpleName());
                            } else {
                                switch (c) {
                                    case 1002:
                                        C3425b.m12268a().m12285b(getActivity(), i2);
                                        m12393g(i2 + 10000);
                                        break;
                                    case 1003:
                                        m12393g(i2);
                                        break;
                                }
                            }
                        }
                    }
                    if (cursorM12112c != null && !cursorM12112c.isClosed()) {
                        cursorM12112c.close();
                    }
                } else {
                    return;
                }
            } else {
                for (int i3 = 0; i3 < length; i3++) {
                    if (zArrM12414q[i3] && i3 < m12409n()) {
                        C3425b.m12268a().m12285b(getActivity(), i3);
                        m12393g(i3 + 10000);
                    }
                }
            }
            if (length > 0) {
                m12524a(R.string.ams_msg_deleted);
                m12396h();
            }
        }
    }

    /* renamed from: q */
    private boolean[] m12414q() {
        if (this.f12645u == 5000) {
            if (this.f12639o == null) {
                return null;
            }
            return this.f12639o.m12763a();
        }
        if (this.f12641q != null) {
            return this.f12641q.m12756a();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_recently /* 2131165790 */:
                if (!this.f12637m.isSelected()) {
                    m12397h(5000);
                    break;
                }
                break;
            case R.id.btn_sample /* 2131165791 */:
                if (!this.f12638n.isSelected()) {
                    m12397h(5001);
                    break;
                }
                break;
        }
    }

    @Override // com.sec.vip.amschaton.InterfaceC3434bi
    /* renamed from: b */
    public boolean mo12235b() {
        this.f12643s = 0;
        this.f12642r = 1004;
        this.f12644t = this.f12634a.m12353b();
        m12392g();
        m12385e(this.f12642r);
        return false;
    }

    @Override // com.sec.vip.amschaton.InterfaceC3434bi
    /* renamed from: a */
    public boolean mo12234a() {
        return false;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (this.f12646v == 3002) {
            getActivity().setTitle(R.string.ams_btn_delete);
            menuInflater.inflate(R.menu.cancel_done_menu, menu);
            if (!this.f12629C) {
                menu.findItem(R.id.menu_done).setEnabled(false);
            } else {
                menu.findItem(R.id.menu_done).setEnabled(true);
            }
        } else {
            getActivity().setTitle(R.string.ams_background);
            menuInflater.inflate(R.menu.ams_list_menu, menu);
            MenuItem menuItemFindItem = menu.findItem(R.id.ams_delete);
            if (this.f12646v == 3000 || this.f12645u == 5000) {
                menuItemFindItem.setEnabled(false);
                C3228cp.m11343a(menuItemFindItem);
            } else {
                menuItemFindItem.setEnabled(true);
                C3228cp.m11343a(menuItemFindItem);
            }
            m12362a(menu.findItem(R.id.ams_download));
        }
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // com.sec.vip.amschaton.fragment.AMSFragment
    /* renamed from: c */
    public void mo12415c() {
        if (this.f12646v == 3002) {
            m12376c(true);
            m12372b(false);
            m12380d(3001);
            this.f12629C = false;
            m12392g();
            m12381d(false);
            getActivity().supportInvalidateOptionsMenu();
            return;
        }
        super.mo12415c();
    }
}
