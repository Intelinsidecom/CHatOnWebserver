package com.sec.vip.amschaton.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
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
import com.sec.vip.amschaton.AMSEmoticonSelectionActivity;
import com.sec.vip.amschaton.AMSImageEditorActivity;
import com.sec.vip.amschaton.C3410al;
import com.sec.vip.amschaton.p071a.C3395c;
import com.sec.vip.amschaton.p071a.C3397e;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class AMSStampSelectionFragment extends AMSFragment implements View.OnClickListener {

    /* renamed from: y */
    private View f12766y;

    /* renamed from: a */
    private int f12751a = 0;

    /* renamed from: b */
    private GridView f12752b = null;

    /* renamed from: c */
    private C3529cw f12753c = null;

    /* renamed from: m */
    private int f12754m = 2000;

    /* renamed from: n */
    private CheckedTextView f12755n = null;

    /* renamed from: o */
    private boolean f12756o = false;

    /* renamed from: p */
    private ProgressDialogC3265l f12757p = null;

    /* renamed from: q */
    private int f12758q = 0;

    /* renamed from: r */
    private long f12759r = 0;

    /* renamed from: s */
    private LinearLayout f12760s = null;

    /* renamed from: t */
    private View f12761t = null;

    /* renamed from: u */
    private View f12762u = null;

    /* renamed from: v */
    private int f12763v = 5001;

    /* renamed from: w */
    private C3535db f12764w = null;

    /* renamed from: x */
    private C3397e f12765x = null;

    /* renamed from: z */
    private boolean f12767z = false;

    /* renamed from: A */
    private AdapterView.OnItemClickListener f12746A = new C3517ck(this);

    /* renamed from: B */
    private AdapterView.OnItemLongClickListener f12747B = new C3518cl(this);

    /* renamed from: C */
    private final View.OnClickListener f12748C = new ViewOnClickListenerC3508cb(this);

    /* renamed from: D */
    private Handler f12749D = new HandlerC3509cc(this);

    /* renamed from: E */
    private Handler f12750E = new HandlerC3513cg(this);

    @Override // com.sec.vip.amschaton.fragment.AMSFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        BaseActivity.m3081a(this, true);
        this.f12765x = new C3397e(getActivity());
        this.f12765x.m12118b();
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        getActivity().setTitle(R.string.ams_title_stamp);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        View viewInflate = layoutInflater.inflate(R.layout.layout_ams_list, viewGroup, false);
        ((FrameLayout) viewInflate.findViewById(R.id.ams_message_list)).setVisibility(8);
        ((FrameLayout) viewInflate.findViewById(R.id.ams_stamp_list)).setVisibility(0);
        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null) {
            i = extras.getInt("AMS_STAMP_INDEX", 0);
        } else {
            C3250y.m11450b("[onCreate] bundle is NULL!", getClass().getSimpleName());
            i = 0;
        }
        m12591a(viewInflate);
        m12612c(i);
        this.f12760s = (LinearLayout) viewInflate.findViewById(R.id.layout_recent_sample);
        this.f12761t = viewInflate.findViewById(R.id.btn_recently);
        this.f12762u = viewInflate.findViewById(R.id.btn_sample);
        this.f12760s.setVisibility(0);
        this.f12761t.setOnClickListener(this);
        this.f12762u.setOnClickListener(this);
        m12626f(5001);
        m12602b(viewInflate);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (this.f12754m == 2002) {
            getActivity().setTitle(R.string.ams_btn_delete);
            menuInflater.inflate(R.menu.cancel_done_menu, menu);
            if (!this.f12767z) {
                menu.findItem(R.id.menu_done).setEnabled(false);
            } else {
                menu.findItem(R.id.menu_done).setEnabled(true);
            }
        } else {
            getActivity().setTitle(R.string.ams_title_stamp);
            menuInflater.inflate(R.menu.ams_list_menu, menu);
            MenuItem menuItemFindItem = menu.findItem(R.id.ams_delete);
            if (this.f12754m == 2000 || this.f12763v == 5000) {
                menuItemFindItem.setEnabled(false);
                C3228cp.m11343a(menuItemFindItem);
            } else {
                menuItemFindItem.setEnabled(true);
                C3228cp.m11343a(menuItemFindItem);
            }
            m12590a(menu.findItem(R.id.ams_download));
        }
        super.onCreateOptionsMenu(menu, menuInflater);
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
            m12596a(false);
            m12607b(true);
            m12622e(2002);
            m12625f();
            getActivity().supportInvalidateOptionsMenu();
            z = true;
        } else if (itemId == R.id.menu_done) {
            m12596a(true);
            String string = getActivity().getApplicationContext().getString(R.string.ams_delete_single_item);
            boolean[] zArrM12644l = m12644l();
            if (zArrM12644l != null) {
                i = 0;
                for (boolean z2 : zArrM12644l) {
                    if (z2) {
                        i++;
                    }
                }
            } else {
                i = 0;
            }
            AbstractC3271a.m11494a(getActivity()).mo11495a(R.string.ams_btn_delete).mo11509b(i > 1 ? getActivity().getApplicationContext().getString(R.string.selected_items_deleted) : string).mo11515d(R.string.ams_btn_ok, new DialogInterfaceOnClickListenerC3515ci(this)).mo11507b(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC3507ca(this)).mo11505a().show();
            getActivity().supportInvalidateOptionsMenu();
            z = true;
        } else if (itemId == R.id.ams_download) {
            Intent intent = new Intent(getActivity(), (Class<?>) ActivityAmsItemDownloads.class);
            intent.putExtra("amsType", EnumC1327e.Stamp);
            startActivity(intent);
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
        if (this.f12765x != null) {
            this.f12765x.mo12098a();
        }
        m12656r();
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        m12633h();
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        if (view.equals(this.f12752b)) {
            contextMenu.setHeaderTitle(R.string.ams_title_stamp);
            getActivity().getMenuInflater().inflate(R.menu.ams_ics2_context_menu_stamp, contextMenu);
            if (this.f12763v == 5000) {
                contextMenu.findItem(R.id.context_menu_item_delete).setVisible(false);
            }
        }
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onContextItemSelected(MenuItem menuItem) {
        int iM12645m;
        Cursor cursorM12117b;
        int iM12194d;
        int i = 4002;
        int i2 = 4000;
        if (this.f12763v == 5000) {
            if (this.f12765x == null || (cursorM12117b = this.f12765x.m12117b(this.f12759r)) == null) {
                return true;
            }
            int i3 = cursorM12117b.getInt(cursorM12117b.getColumnIndex("ams_index"));
            if (i3 < 20000) {
                i = 4003;
                iM12194d = i3;
            } else if (i3 < 30000) {
                iM12194d = i3 - 20000;
            } else if (i3 < 40000) {
                iM12194d = C3410al.m12173a().m12194d(C3410al.m12173a().m12186b(i3 - 30000));
                i = 4001;
            } else {
                i = 4000;
                iM12194d = i3 - 40000;
            }
            if (iM12194d < 0) {
                C3250y.m11442a("Index is -1!", getClass().getSimpleName());
                return true;
            }
            switch (menuItem.getItemId()) {
                case R.id.context_menu_item_delete /* 2131166574 */:
                    m12587a(iM12194d, i);
                    break;
            }
            return super.onContextItemSelected(menuItem);
        }
        if (this.f12758q > 0 && this.f12758q < m12645m() + 1) {
            iM12645m = this.f12758q - 1;
        } else if (this.f12758q > m12645m() && this.f12758q < m12645m() + m12651p() + 1) {
            iM12645m = (this.f12758q - m12645m()) - 1;
            i2 = 4001;
        } else {
            if (this.f12758q <= m12645m() + m12651p() || this.f12758q >= m12645m() + m12651p() + m12647n() + 1) {
                return true;
            }
            iM12645m = ((this.f12758q - m12645m()) - m12651p()) - 1;
            i2 = 4002;
        }
        if (iM12645m < 0) {
            C3250y.m11442a("Index is -1!", getClass().getSimpleName());
            return true;
        }
        switch (menuItem.getItemId()) {
            case R.id.context_menu_item_delete /* 2131166574 */:
                m12587a(iM12645m, i2);
                break;
        }
        return super.onContextItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Bitmap bitmapM12584a;
        if (i2 == -1) {
            switch (i) {
                case 100:
                    Bundle extras = intent.getExtras();
                    if (extras != null && (bitmapM12584a = m12584a(intent, extras)) != null) {
                        m12589a(bitmapM12584a);
                        bitmapM12584a.recycle();
                        break;
                    }
                    break;
                case 101:
                    Bundle extras2 = intent.getExtras();
                    if (extras2 != null) {
                        int i3 = extras2.getInt("AMS_EMOTICON_INDEX", 0) + 30000;
                        extras2.putInt("AMS_STAMP_INDEX", i3);
                        m12588a(i3, System.currentTimeMillis());
                        m12601b(i3, System.currentTimeMillis());
                        C3410al.m12173a().m12192c();
                        Intent intent2 = new Intent();
                        intent2.putExtras(extras2);
                        getActivity().setResult(-1, intent2);
                        ((InterfaceC3474av) getActivity()).mo11978c();
                        break;
                    }
                    break;
                case 102:
                    Bundle extras3 = intent.getExtras();
                    if (extras3 != null) {
                        m12588a(extras3.getInt("AMS_STAMP_INDEX", 0), System.currentTimeMillis());
                        Intent intent3 = new Intent();
                        intent3.putExtras(extras3);
                        getActivity().setResult(-1, intent3);
                        ((InterfaceC3474av) getActivity()).mo11978c();
                        break;
                    }
                    break;
            }
            super.onActivityResult(i, i2, intent);
        }
    }

    /* renamed from: a */
    private void m12589a(Bitmap bitmap) {
        m12597a(bitmap, f12717h + m12585a("[STP]", System.currentTimeMillis(), ".png"));
        m12633h();
        this.f12751a = m12645m() + m12651p();
        m12634h(this.f12751a);
    }

    /* renamed from: a */
    private void m12591a(View view) {
        this.f12755n = (CheckedTextView) view.findViewById(R.id.layout_select_all);
        this.f12755n.setVisibility(8);
        this.f12755n.setOnClickListener(this.f12748C);
        this.f12752b = (GridView) view.findViewById(R.id.grid_user_stamp_file_list);
        this.f12752b.setSelector(R.drawable.ams_ics_selector_basic_dummy);
        this.f12752b.setOnScrollListener(new C3516cj(this));
        registerForContextMenu(this.f12752b);
        m12596a(true);
    }

    /* renamed from: a */
    private void m12596a(boolean z) {
        if (this.f12752b != null) {
            if (z) {
                this.f12752b.setOnItemClickListener(this.f12746A);
                if (this.f12763v != 5000) {
                    this.f12752b.setOnItemLongClickListener(this.f12747B);
                    registerForContextMenu(this.f12752b);
                    return;
                }
                return;
            }
            this.f12752b.setOnItemClickListener(null);
            this.f12752b.setOnItemLongClickListener(null);
            unregisterForContextMenu(this.f12752b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12586a() throws Resources.NotFoundException {
        if (C3171am.m11077o()) {
            AbstractC3271a.m11494a(getActivity()).mo11495a(R.string.ams_title_stamp).mo11497a(R.array.ams_strarr_add_stamp, new DialogInterfaceOnClickListenerC3520cn(this)).mo11507b(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC3519cm(this)).mo11505a().show();
            return;
        }
        CharSequence[] textArray = getResources().getTextArray(R.array.ams_strarr_add_stamp);
        if (textArray.length == 3) {
            AbstractC3271a.m11494a(getActivity()).mo11495a(R.string.ams_title_stamp).mo11504a(new CharSequence[]{textArray[1], textArray[2]}, new DialogInterfaceOnClickListenerC3522cp(this)).mo11507b(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC3521co(this)).mo11505a().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m12600b(int i) {
        Intent intent = new Intent(getActivity(), (Class<?>) AMSImageEditorActivity.class);
        intent.putExtra("IMAGE_SELECTOR", i);
        startActivityForResult(intent, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m12599b() {
        startActivityForResult(new Intent(getActivity(), (Class<?>) AMSEmoticonSelectionActivity.class), 101);
    }

    /* renamed from: c */
    private void m12612c(int i) {
        if (i < 20000) {
            int iM12206i = C3410al.m12173a().m12206i(i);
            if (iM12206i == -1) {
                this.f12751a = 0;
            } else if (iM12206i >= 0) {
                this.f12751a = iM12206i + m12651p() + m12645m() + m12647n();
            }
        } else if (i < 30000) {
            this.f12751a = ((m12651p() + m12645m()) + i) - 20000;
        } else if (i < 40000) {
            this.f12751a = C3410al.m12173a().m12194d(C3410al.m12173a().m12186b(i - 30000)) + m12645m();
        } else {
            this.f12751a = i - 40000;
        }
        if (this.f12752b != null) {
            m12634h(this.f12751a);
        }
        m12625f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public int m12620e() {
        int iM12202g;
        if (this.f12751a < m12645m()) {
            return this.f12751a + 40000;
        }
        if (this.f12751a < m12645m() + m12651p()) {
            return C3410al.m12173a().m12190c(C3410al.m12173a().m12197e(this.f12751a - m12645m())) + 30000;
        }
        if (this.f12751a < m12645m() + m12651p() + m12647n()) {
            return ((this.f12751a - m12645m()) - m12651p()) + 20000;
        }
        if (this.f12751a >= m12645m() + m12651p() + m12647n() + m12649o() || (iM12202g = C3410al.m12173a().m12202g(((this.f12751a - m12645m()) - m12651p()) - m12647n())) == -1) {
            return 0;
        }
        return iM12202g;
    }

    /* renamed from: a */
    private boolean m12597a(Bitmap bitmap, String str) {
        return m12609b(bitmap, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m12625f() {
        if (this.f12763v == 5000) {
            if (this.f12764w != null) {
                this.f12764w.notifyDataSetChanged();
            }
        } else if (this.f12753c != null) {
            this.f12753c.m12739b();
        }
    }

    /* renamed from: a */
    private void m12595a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m12606b(FileOutputStream fileOutputStream) throws IOException {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009a  */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.sec.vip.amschaton.fragment.AMSStampSelectionFragment, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.graphics.Bitmap] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m12609b(android.graphics.Bitmap r7, java.lang.String r8) throws java.lang.Throwable {
        /*
            r6 = this;
            r1 = 1
            r0 = 0
            java.lang.String r2 = r8.toLowerCase()
            java.lang.String r3 = ".png"
            boolean r2 = r2.endsWith(r3)
            if (r2 != 0) goto L1c
            java.lang.String r1 = "[saveBitmapToPNG] Wrong extension!"
            java.lang.Class r2 = r6.getClass()
            java.lang.String r2 = r2.getSimpleName()
            com.sec.chaton.util.C3250y.m11442a(r1, r2)
        L1b:
            return r0
        L1c:
            if (r7 != 0) goto L2c
            java.lang.String r1 = "[saveBitmapToPNG] Bitmap is null!"
            java.lang.Class r2 = r6.getClass()
            java.lang.String r2 = r2.getSimpleName()
            com.sec.chaton.util.C3250y.m11442a(r1, r2)
            goto L1b
        L2c:
            java.io.File r5 = new java.io.File
            r5.<init>(r8)
            r4 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.io.IOException -> L55 java.lang.Throwable -> L91
            r3.<init>(r5)     // Catch: java.io.IOException -> L55 java.lang.Throwable -> L91
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch: java.lang.Throwable -> Lb2 java.io.IOException -> Lb4
            r4 = 100
            r7.compress(r2, r4, r3)     // Catch: java.lang.Throwable -> Lb2 java.io.IOException -> Lb4
            r6.m12595a(r3)
            r6.m12606b(r3)
            r2 = r1
        L45:
            if (r2 != 0) goto L9a
            java.lang.String r1 = "[saveBitmapToPNG] Fail to save file!"
            java.lang.Class r2 = r6.getClass()
            java.lang.String r2 = r2.getSimpleName()
            com.sec.chaton.util.C3250y.m11442a(r1, r2)
            goto L1b
        L55:
            r2 = move-exception
            r3 = r4
        L57:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r2 = "[resizedJpegCopy] IO Exception!"
            java.lang.Class r4 = r6.getClass()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r4 = r4.getSimpleName()     // Catch: java.lang.Throwable -> Lb2
            com.sec.chaton.util.C3250y.m11442a(r2, r4)     // Catch: java.lang.Throwable -> Lb2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb2
            r2.<init>()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r4 = "[resizedJpegCopy] Out File: "
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r4 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> Lb2
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Lb2
            java.lang.Class r4 = r6.getClass()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r4 = r4.getSimpleName()     // Catch: java.lang.Throwable -> Lb2
            com.sec.chaton.util.C3250y.m11442a(r2, r4)     // Catch: java.lang.Throwable -> Lb2
            r6.m12595a(r3)
            r6.m12606b(r3)
            r2 = r0
            goto L45
        L91:
            r0 = move-exception
            r3 = r4
        L93:
            r6.m12595a(r3)
            r6.m12606b(r3)
            throw r0
        L9a:
            boolean r2 = r5.exists()
            if (r2 != 0) goto Laf
            java.lang.String r1 = "[saveBitmapToPNG] File does not exist!"
            java.lang.Class r2 = r6.getClass()
            java.lang.String r2 = r2.getSimpleName()
            com.sec.chaton.util.C3250y.m11442a(r1, r2)
            goto L1b
        Laf:
            r0 = r1
            goto L1b
        Lb2:
            r0 = move-exception
            goto L93
        Lb4:
            r2 = move-exception
            goto L57
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.fragment.AMSStampSelectionFragment.m12609b(android.graphics.Bitmap, java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m12617d(int i) {
        m12588a(i, System.currentTimeMillis());
        Intent intent = new Intent();
        intent.putExtra("AMS_STAMP_INDEX", i);
        getActivity().setResult(-1, intent);
        ((InterfaceC3474av) getActivity()).mo11978c();
    }

    /* renamed from: a */
    private void m12588a(int i, long j) {
        if (i >= 0 && this.f12765x != null) {
            String strM12179a = "";
            if (i >= 40000) {
                strM12179a = C3410al.m12173a().m12179a(i - 40000);
            }
            this.f12765x.m12115a(String.valueOf(i), strM12179a, String.valueOf(j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m12622e(int i) {
        this.f12754m = i;
    }

    /* renamed from: g */
    private void m12629g() {
        if (this.f12754m != 2002) {
            int iM12645m = 0;
            if (this.f12763v == 5000) {
                if (this.f12764w != null) {
                    iM12645m = this.f12764w.getCount();
                }
            } else {
                iM12645m = m12645m() + m12647n() + m12651p();
            }
            if (iM12645m > 0) {
                m12622e(2001);
            } else {
                m12622e(2000);
            }
            getActivity().supportInvalidateOptionsMenu();
        }
    }

    /* renamed from: a */
    private Bitmap m12584a(Intent intent, Bundle bundle) {
        Bitmap bitmapDecodeFile;
        if (bundle.getBoolean("exceed_size", true)) {
            C3250y.m11450b("[getBitmapFromExtras] exceed_size is true!", getClass().getSimpleName());
            String string = bundle.getString("temp_file_path");
            if (string == null) {
                return null;
            }
            C3250y.m11450b("tmpFilePath : " + string, getClass().getSimpleName());
            bitmapDecodeFile = BitmapFactory.decodeFile(string);
            if (bitmapDecodeFile == null) {
                return null;
            }
            File file = new File(string);
            if (file.exists()) {
                file.delete();
            }
        } else {
            C3250y.m11450b("[getBitmapFromExtras] exceed_size is false!", getClass().getSimpleName());
            bitmapDecodeFile = (Bitmap) bundle.getParcelable(SlookAirButtonFrequentContactAdapter.DATA);
        }
        C3250y.m11450b("[getBitmapFromExtras] bmp width and height : " + bitmapDecodeFile.getWidth() + "," + bitmapDecodeFile.getHeight(), getClass().getSimpleName());
        return bitmapDecodeFile;
    }

    /* renamed from: a */
    private String m12585a(String str, long j, String str2) {
        return str + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(j)) + str2;
    }

    /* renamed from: a */
    private void m12590a(MenuItem menuItem) {
        int iM9632a = C2642q.m9632a(EnumC1327e.Stamp);
        C3228cp.m11346b(menuItem);
        C3228cp.m11344a(menuItem, iM9632a > 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m12607b(boolean z) {
        if (this.f12755n != null && this.f12760s != null) {
            this.f12755n.setChecked(false);
            this.f12755n.setVisibility(z ? 0 : 8);
            this.f12760s.setVisibility(z ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m12613c(boolean z) {
        m12618d(z);
        m12625f();
    }

    /* renamed from: h */
    private void m12633h() {
        if (!this.f12756o) {
            this.f12756o = true;
            new AsyncTaskC3534da(this, null).execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m12626f(int i) {
        this.f12763v = i;
        switch (this.f12763v) {
            case 5000:
                this.f12761t.setSelected(true);
                this.f12762u.setSelected(false);
                m12636i();
                break;
            case 5001:
                this.f12762u.setSelected(true);
                this.f12761t.setSelected(false);
                m12639j();
                break;
        }
        m12640j(this.f12763v);
        m12629g();
    }

    /* renamed from: g */
    private void m12630g(int i) {
        if (i >= 0 && this.f12765x != null) {
            this.f12765x.m12119b(String.valueOf(i));
        }
    }

    /* renamed from: i */
    private void m12636i() {
        Cursor cursorM12120c;
        String string;
        String strM12181a;
        if (this.f12765x != null && this.f12752b != null && (cursorM12120c = this.f12765x.m12120c()) != null) {
            boolean z = false;
            for (boolean zMoveToFirst = cursorM12120c.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorM12120c.moveToNext()) {
                int iIntValue = Integer.valueOf(cursorM12120c.getString(cursorM12120c.getColumnIndex("ams_index"))).intValue();
                if (iIntValue >= 40000 && (string = cursorM12120c.getString(cursorM12120c.getColumnIndex("ams_path"))) != null && (strM12181a = C3410al.m12173a().m12181a(getActivity(), string)) != null && !new File(strM12181a).exists()) {
                    m12630g(iIntValue);
                    z = true;
                }
            }
            Cursor cursorM12120c2 = z ? this.f12765x.m12120c() : cursorM12120c;
            if (this.f12764w != null) {
                this.f12764w = null;
            }
            this.f12764w = new C3535db(this, getActivity(), cursorM12120c2);
            this.f12752b.setAdapter((ListAdapter) this.f12764w);
            this.f12764w.m12743a(this.f12750E);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m12634h(int i) {
        new Handler().post(new RunnableC3510cd(this, i));
    }

    /* renamed from: j */
    private void m12639j() {
        if (this.f12753c != null) {
            this.f12753c = null;
        }
        this.f12753c = new C3529cw(this, getActivity());
        this.f12753c.m12736a(this.f12750E);
        this.f12752b.setAdapter((ListAdapter) this.f12753c);
        m12625f();
    }

    /* renamed from: a */
    private void m12587a(int i, int i2) {
        AbstractC3271a.m11494a(getActivity()).mo11495a(R.string.ams_btn_delete).mo11506b(R.string.ams_delete_single_item).mo11515d(R.string.ams_btn_ok, new DialogInterfaceOnClickListenerC3512cf(this, i, i2)).mo11507b(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC3511ce(this)).mo11505a().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m12608b(int i, int i2) {
        String strM12200f;
        if (i < 0) {
            return false;
        }
        switch (i2) {
            case 4000:
                strM12200f = C3410al.m12173a().m12180a(getActivity(), i);
                i += 40000;
                break;
            case 4001:
                int iM12190c = C3410al.m12173a().m12190c(C3410al.m12173a().m12197e(i)) + 30000;
                m12630g(iM12190c);
                m12637i(i + 30000);
                i = iM12190c;
                strM12200f = null;
                break;
            case 4002:
                strM12200f = C3410al.m12173a().m12200f(i);
                i += 20000;
                break;
            case 4003:
                m12630g(i);
                strM12200f = null;
                break;
            default:
                i = 0;
                strM12200f = null;
                break;
        }
        if (strM12200f != null) {
            m12630g(i);
            File file = new File(strM12200f);
            if (file.exists()) {
                file.delete();
            }
        }
        m12524a(R.string.ams_msg_deleted);
        m12633h();
        return true;
    }

    /* renamed from: b */
    private void m12601b(int i, long j) {
        if (i >= 0) {
            C3395c c3395c = new C3395c(getActivity());
            c3395c.m12102b();
            c3395c.m12100a(String.valueOf(C3410al.m12173a().m12186b(i - 30000)), String.valueOf(j));
            c3395c.mo12098a();
        }
    }

    /* renamed from: i */
    private void m12637i(int i) {
        if (i >= 0) {
            C3395c c3395c = new C3395c(getActivity());
            c3395c.m12102b();
            c3395c.m12103b(String.valueOf(C3410al.m12173a().m12197e(i - 30000)));
            c3395c.mo12098a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m12641k() {
        String strM12200f;
        int iM12645m;
        int i;
        boolean[] zArrM12644l = m12644l();
        if (zArrM12644l != null) {
            int length = zArrM12644l.length;
            if (this.f12763v == 5000) {
                if (this.f12765x != null) {
                    Cursor cursorM12120c = this.f12765x.m12120c();
                    if (cursorM12120c == null || cursorM12120c.getCount() == 0 || cursorM12120c.getCount() != length) {
                        if (cursorM12120c != null && !cursorM12120c.isClosed()) {
                            cursorM12120c.close();
                            return;
                        }
                        return;
                    }
                    for (int i2 = 0; i2 < length; i2++) {
                        if (zArrM12644l[i2]) {
                            cursorM12120c.moveToPosition(i2);
                            int iM12194d = cursorM12120c.getInt(cursorM12120c.getColumnIndex("ams_index"));
                            if (iM12194d < 20000) {
                                i = 4003;
                            } else if (iM12194d < 30000) {
                                iM12194d -= 20000;
                                i = 4002;
                            } else if (iM12194d < 40000) {
                                iM12194d = C3410al.m12173a().m12194d(C3410al.m12173a().m12186b(iM12194d - 30000));
                                i = 4001;
                            } else {
                                iM12194d -= 40000;
                                i = 4000;
                            }
                            if (iM12194d < 0) {
                                C3250y.m11442a("Index is -1!", getClass().getSimpleName());
                            } else {
                                m12608b(iM12194d, i);
                            }
                        }
                    }
                    if (cursorM12120c != null && !cursorM12120c.isClosed()) {
                        cursorM12120c.close();
                    }
                } else {
                    return;
                }
            } else {
                for (int i3 = 0; i3 < length; i3++) {
                    if (zArrM12644l[i3]) {
                        if (i3 < m12645m()) {
                            strM12200f = C3410al.m12173a().m12180a(getActivity(), i3);
                            iM12645m = i3 + 40000;
                        } else if (i3 < m12645m() + m12651p()) {
                            m12630g(C3410al.m12173a().m12190c(C3410al.m12173a().m12197e(i3 - m12645m())) + 30000);
                            m12637i((i3 - m12645m()) + 30000);
                        } else if (i3 >= m12645m() + m12651p() + m12647n()) {
                            strM12200f = null;
                            iM12645m = 0;
                        } else {
                            strM12200f = C3410al.m12173a().m12200f((i3 - m12645m()) - m12651p());
                            iM12645m = ((i3 - m12645m()) - m12651p()) + 20000;
                        }
                        if (strM12200f != null) {
                            m12630g(iM12645m);
                            File file = new File(strM12200f);
                            if (file.exists()) {
                                file.delete();
                            }
                        }
                    }
                }
            }
            if (length > 0) {
                m12524a(R.string.ams_msg_deleted);
                m12633h();
            }
        }
    }

    /* renamed from: l */
    private boolean[] m12644l() {
        if (this.f12763v == 5000) {
            if (this.f12764w == null) {
                return null;
            }
            return this.f12764w.m12745a();
        }
        if (this.f12753c != null) {
            return this.f12753c.m12738a();
        }
        return null;
    }

    /* renamed from: d */
    private void m12618d(boolean z) {
        if (this.f12763v == 5000) {
            if (this.f12764w != null) {
                this.f12764w.m12744a(z);
            }
        } else if (this.f12753c != null) {
            this.f12753c.m12737a(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public int m12645m() {
        return C3410al.m12173a().m12193d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public int m12647n() {
        return C3410al.m12173a().m12203h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public int m12649o() {
        return C3410al.m12173a().m12201g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public int m12651p() {
        return C3410al.m12173a().m12199f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m12653q() {
        if (this.f12757p != null) {
            this.f12757p = null;
        }
        this.f12757p = new ProgressDialogC3265l(getActivity());
        this.f12757p.setProgressStyle(0);
        this.f12757p.setMessage(getString(R.string.ams_msg_progress_ams_file_loading));
        this.f12757p.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m12656r() {
        if (this.f12757p != null) {
            this.f12757p.dismiss();
            this.f12757p = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_recently /* 2131165790 */:
                if (!this.f12761t.isSelected()) {
                    m12626f(5000);
                    break;
                }
                break;
            case R.id.btn_sample /* 2131165791 */:
                if (!this.f12762u.isSelected()) {
                    m12626f(5001);
                    break;
                }
                break;
        }
    }

    @Override // com.sec.vip.amschaton.fragment.AMSFragment
    /* renamed from: c */
    public void mo12415c() {
        if (this.f12754m == 2002) {
            m12596a(true);
            m12618d(false);
            m12622e(2001);
            this.f12767z = false;
            m12625f();
            m12607b(false);
            getActivity().supportInvalidateOptionsMenu();
            return;
        }
        ((InterfaceC3474av) getActivity()).mo11978c();
    }

    /* renamed from: b */
    private void m12602b(View view) {
        this.f12766y = view.findViewById(R.id.layout_stamp_no_items);
        ((ImageView) this.f12766y.findViewById(R.id.image1)).setMinimumHeight((int) C3172an.m11086b(110.0f));
        ((ImageView) this.f12766y.findViewById(R.id.image1)).setMinimumWidth((int) C3172an.m11086b(110.0f));
        ((ImageView) this.f12766y.findViewById(R.id.image1)).setScaleType(ImageView.ScaleType.FIT_XY);
        ((TextView) this.f12766y.findViewById(R.id.text2)).setText(R.string.ams_no_recent_backgrounds);
        View viewFindViewById = this.f12766y.findViewById(R.id.image1);
        viewFindViewById.setOnClickListener(new ViewOnClickListenerC3514ch(this, viewFindViewById));
        this.f12752b.setEmptyView(this.f12766y);
        this.f12752b.setVisibility(4);
    }

    /* renamed from: j */
    private void m12640j(int i) {
        if (this.f12766y != null) {
            switch (i) {
                case 5000:
                    ((ImageView) this.f12766y.findViewById(R.id.image1)).setImageResource(R.drawable.no_contents_ams_recently);
                    ((TextView) this.f12766y.findViewById(R.id.text1)).setText(R.string.ams_no_recent_stamps);
                    ((TextView) this.f12766y.findViewById(R.id.text2)).setVisibility(8);
                    break;
                default:
                    ((ImageView) this.f12766y.findViewById(R.id.image1)).setImageResource(R.drawable.setting_add);
                    ((TextView) this.f12766y.findViewById(R.id.text1)).setText(R.string.ams_tap_create_stamp);
                    ((TextView) this.f12766y.findViewById(R.id.text2)).setVisibility(0);
                    break;
            }
        }
    }
}
