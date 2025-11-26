package com.sec.chaton.trunk;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.ContextThemeWrapper;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.C1835j;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.trunk.p061c.C3020a;
import com.sec.chaton.trunk.p061c.C3021b;
import com.sec.chaton.trunk.p061c.C3022c;
import com.sec.chaton.trunk.p061c.C3025f;
import com.sec.chaton.trunk.p061c.EnumC3026g;
import com.sec.chaton.trunk.p061c.InterfaceC3024e;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3172an;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3220ch;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.C3263j;
import com.sec.common.CommonApplication;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p069e.C3326c;
import com.sec.common.util.C3364o;
import com.sec.widget.C3641ai;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class TrunkItemView extends Fragment implements InterfaceC2969aj, InterfaceC3024e, InterfaceC3055i {

    /* renamed from: a */
    private static final String f10565a = TrunkItemView.class.getSimpleName();

    /* renamed from: A */
    private Dialog f10566A;

    /* renamed from: B */
    private Dialog f10567B;

    /* renamed from: C */
    private Dialog f10568C;

    /* renamed from: D */
    private String f10569D;

    /* renamed from: E */
    private String f10570E;

    /* renamed from: F */
    private String f10571F;

    /* renamed from: G */
    private EnumC3026g f10572G;

    /* renamed from: H */
    private String f10573H;

    /* renamed from: I */
    private String f10574I;

    /* renamed from: J */
    private int f10575J;

    /* renamed from: K */
    private int f10576K;

    /* renamed from: L */
    private boolean f10577L;

    /* renamed from: M */
    private boolean f10578M;

    /* renamed from: N */
    private boolean f10579N;

    /* renamed from: O */
    private String f10580O;

    /* renamed from: P */
    private boolean f10581P;

    /* renamed from: Q */
    private boolean f10582Q;

    /* renamed from: R */
    private C3021b f10583R;

    /* renamed from: S */
    private C2985az f10584S;

    /* renamed from: T */
    private boolean f10585T;

    /* renamed from: U */
    private InterfaceC3058l f10586U;

    /* renamed from: V */
    private InterfaceC3057k f10587V;

    /* renamed from: W */
    private InterfaceC3057k f10588W;

    /* renamed from: X */
    private InterfaceC3057k f10589X;

    /* renamed from: Y */
    private InterfaceC3056j f10590Y;

    /* renamed from: Z */
    private InterfaceC3059m f10591Z;

    /* renamed from: aa */
    private C3326c f10592aa;

    /* renamed from: ab */
    private Uri f10593ab;

    /* renamed from: ac */
    private TextView f10594ac;

    /* renamed from: ad */
    private String f10595ad;

    /* renamed from: ae */
    private String f10596ae;

    /* renamed from: af */
    private String f10597af;

    /* renamed from: ag */
    private boolean f10598ag;

    /* renamed from: ah */
    private String f10599ah;

    /* renamed from: ai */
    private boolean f10600ai;

    /* renamed from: aj */
    private LinearLayout f10601aj;

    /* renamed from: ak */
    private boolean f10602ak = false;

    /* renamed from: al */
    private Handler f10603al = new HandlerC3000bh(this);

    /* renamed from: am */
    private AdapterView.OnItemLongClickListener f10604am = new C3002bj(this);

    /* renamed from: b */
    private InputMethodManager f10605b;

    /* renamed from: c */
    private EditText f10606c;

    /* renamed from: d */
    private Menu f10607d;

    /* renamed from: e */
    private Activity f10608e;

    /* renamed from: f */
    private InterfaceC3009bq f10609f;

    /* renamed from: g */
    private C2986b f10610g;

    /* renamed from: h */
    private ImageView f10611h;

    /* renamed from: i */
    private TextView f10612i;

    /* renamed from: j */
    private TextView f10613j;

    /* renamed from: k */
    private ProgressBar f10614k;

    /* renamed from: l */
    private ProgressBar f10615l;

    /* renamed from: m */
    private ImageView f10616m;

    /* renamed from: n */
    private ImageView f10617n;

    /* renamed from: o */
    private FrameLayout f10618o;

    /* renamed from: p */
    private LinearLayout f10619p;

    /* renamed from: q */
    private LinearLayout f10620q;

    /* renamed from: r */
    private TextView f10621r;

    /* renamed from: s */
    private Toast f10622s;

    /* renamed from: t */
    private boolean f10623t;

    /* renamed from: u */
    private boolean f10624u;

    /* renamed from: v */
    private View f10625v;

    /* renamed from: w */
    private View f10626w;

    /* renamed from: x */
    private View f10627x;

    /* renamed from: y */
    private View f10628y;

    /* renamed from: z */
    private ListView f10629z;

    /* renamed from: d */
    public void m10329d() {
        if (this.f10629z != null) {
            this.f10629z.setTranscriptMode(2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f10608e = activity;
        try {
            this.f10609f = (InterfaceC3009bq) this.f10608e;
        } catch (ClassCastException e) {
            throw new ClassCastException(C3364o.m11849a(activity.toString(), " must implement ITrunkItemViewListener."));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f10608e = null;
        this.f10609f = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f10569D = arguments.getString("sessionId");
        this.f10570E = arguments.getString("inboxNo");
        this.f10571F = arguments.getString("itemId");
        this.f10596ae = arguments.getString("ownerUid");
        this.f10597af = arguments.getString("fileName");
        this.f10575J = arguments.getInt("totalcomment");
        this.f10598ag = arguments.getBoolean("isvalid");
        this.f10599ah = arguments.getString("mediaUri");
        this.f10600ai = arguments.getBoolean("isVideo");
        this.f10622s = C3641ai.m13211a(CommonApplication.m11493l(), (CharSequence) null, 0);
        this.f10583R = new C3021b();
        this.f10610g = new C2986b(this.f10608e, null, 0, this);
        this.f10592aa = new C3326c();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(R.layout.layout_trunk_item, viewGroup, false);
        this.f10605b = (InputMethodManager) this.f10608e.getSystemService("input_method");
        this.f10629z = (ListView) viewInflate.findViewById(R.id.trunkContentList);
        this.f10601aj = (LinearLayout) viewInflate.findViewById(R.id.moreCommentLoadbar);
        this.f10625v = layoutInflater.inflate(R.layout.layout_common_detail, (ViewGroup) this.f10629z, false);
        this.f10616m = (ImageView) this.f10625v.findViewById(R.id.image2);
        this.f10618o = (FrameLayout) this.f10625v.findViewById(R.id.space1);
        this.f10617n = new ImageView(this.f10608e);
        this.f10617n.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f10619p = new LinearLayout(this.f10608e);
        this.f10619p.setGravity(17);
        this.f10614k = new ProgressBar(new ContextThemeWrapper(this.f10608e, R.style.ProgressBarStyle_Large));
        this.f10614k.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.f10620q = new LinearLayout(this.f10608e);
        this.f10615l = new ProgressBar(new ContextThemeWrapper(this.f10608e, R.style.ProgressBarStyle_Small));
        this.f10615l.setLayoutParams(new FrameLayout.LayoutParams((int) C3172an.m11085a(17.0f), (int) C3172an.m11085a(17.0f)));
        this.f10620q.addView(this.f10615l);
        this.f10620q.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.f10620q.setPadding(0, (int) C3172an.m11085a(7.0f), 0, 0);
        this.f10619p.addView(this.f10614k);
        ((ViewGroup) this.f10625v).addView(this.f10620q);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f10618o.getLayoutParams();
        layoutParams.gravity = 17;
        this.f10618o.setLayoutParams(layoutParams);
        this.f10618o.addView(this.f10617n);
        this.f10618o.addView(this.f10619p);
        this.f10618o.setVisibility(0);
        this.f10619p.setVisibility(8);
        this.f10594ac = (TextView) this.f10625v.findViewById(R.id.text3);
        this.f10611h = (ImageView) this.f10625v.findViewById(R.id.image1);
        this.f10612i = (TextView) this.f10625v.findViewById(R.id.text1);
        this.f10613j = (TextView) this.f10625v.findViewById(R.id.text2);
        this.f10594ac.setVisibility(8);
        this.f10618o.setOnClickListener(new ViewOnClickListenerC3003bk(this));
        this.f10629z.addHeaderView(this.f10625v, null, false);
        this.f10626w = layoutInflater.inflate(R.layout.layout_common_text_icon_line, (ViewGroup) this.f10629z, false);
        this.f10621r = (TextView) this.f10626w.findViewById(R.id.text1);
        this.f10627x = layoutInflater.inflate(R.layout.layout_trunk_detail_comment_bottom, (ViewGroup) this.f10629z, false);
        this.f10629z.addFooterView(this.f10627x, null, false);
        this.f10629z.addHeaderView(this.f10626w, null, false);
        this.f10628y = layoutInflater.inflate(R.layout.layout_trunk_detail_footer, (ViewGroup) this.f10629z, false);
        this.f10629z.addFooterView(this.f10628y, null, false);
        this.f10629z.setOnItemLongClickListener(this.f10604am);
        this.f10629z.setAdapter((ListAdapter) this.f10610g);
        BaseActivity.m3081a(this, true);
        m10269b(false);
        this.f10584S = new C2985az(this, this.f10603al, this.f10570E, this.f10569D, this.f10571F, this.f10596ae, this.f10597af);
        this.f10584S.m10411a();
        m10265a((Boolean) false);
        this.f10586U.mo10499a(100, 239);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        C3022c.m10532a(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f10584S.m10412b();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f10584S.m10413c();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        C3022c.m10534b(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f10584S.m10414d();
        if (this.f10592aa != null) {
            this.f10592aa.m11731a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f10583R.m10527a();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.trunkitem_menu, menu);
        this.f10607d = menu;
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if (!"ME".equals(this.f10574I) || !this.f10598ag) {
            this.f10607d.removeItem(R.id.trunkitem_delete);
        }
        if (this.f10623t) {
            this.f10607d.findItem(R.id.trunkitem_share).setEnabled(true);
        } else {
            this.f10607d.findItem(R.id.trunkitem_share).setEnabled(false);
        }
        if (this.f10624u) {
            this.f10607d.findItem(R.id.trunkitem_save).setEnabled(true);
        } else {
            this.f10607d.findItem(R.id.trunkitem_save).setEnabled(false);
        }
    }

    /* renamed from: e */
    public void m10330e() {
        if (this.f10609f != null) {
            this.f10609f.mo10204a(false, this.f10602ak);
        }
        if (this.f10605b != null) {
            this.f10606c = (EditText) this.f10608e.findViewById(R.id.trunkCommentEdit);
            if (this.f10606c != null) {
                this.f10605b.hideSoftInputFromWindow(this.f10606c.getWindowToken(), 0);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) throws Throwable {
        super.onOptionsItemSelected(menuItem);
        switch (menuItem.getItemId()) {
            case R.id.trunkitem_save /* 2131166625 */:
                ((TrunkDetailActivity) getActivity()).m10208c(this.f10573H);
                break;
            case R.id.trunkitem_share /* 2131166626 */:
                if (!C3197bl.m11159a()) {
                    if (this.f10609f != null) {
                        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
                        if (-3 == iM6733a || -2 == iM6733a) {
                            m10264a(EnumC3010br.Nonetwork);
                            break;
                        } else if (!C3159aa.m10962a().m10977a("TrunkShareCheckPopup", (Boolean) false).booleanValue() && C3025f.m10540b(this.f10573H)) {
                            m10331f();
                            break;
                        } else {
                            this.f10609f.mo10203a(this.f10572G, this.f10573H, this.f10595ad);
                            break;
                        }
                    }
                } else {
                    return true;
                }
                break;
            case R.id.trunkitem_delete /* 2131166627 */:
                AbstractC3271a.m11494a(getActivity()).mo11500a(getResources().getString(R.string.menu_chat_delete)).mo11509b(getResources().getString(R.string.trunk_item_deleted)).mo11510b(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC3004bl(this)).mo11501a(getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11512b();
                return true;
            case R.id.trunkitem_refresh /* 2131166628 */:
                int iM6733a2 = C1594v.m6733a(CommonApplication.m11493l());
                if (-3 == iM6733a2 || -2 == iM6733a2) {
                    m10264a(EnumC3010br.Nonetwork);
                    break;
                } else {
                    m10265a((Boolean) false);
                    this.f10581P = false;
                    this.f10586U.mo10499a(100, 239);
                    break;
                }
        }
        return false;
    }

    @Override // com.sec.chaton.trunk.InterfaceC3055i
    /* renamed from: a */
    public Activity mo10313a() {
        return this.f10608e;
    }

    @Override // com.sec.chaton.trunk.InterfaceC3055i
    /* renamed from: a */
    public void mo10322a(String str) {
        this.f10574I = str;
        ((ActionBarFragmentActivity) this.f10608e).supportInvalidateOptionsMenu();
    }

    @Override // com.sec.chaton.trunk.InterfaceC3055i
    /* renamed from: a */
    public void mo10316a(Bitmap bitmap) {
        if (bitmap != null) {
            this.f10611h.setImageBitmap(bitmap);
        } else {
            this.f10611h.setImageResource(R.drawable.contacts_default_01);
        }
    }

    /* renamed from: f */
    public void m10331f() {
        C3220ch.m11325a(this.f10608e, new DialogInterfaceOnClickListenerC3005bm(this)).mo11512b();
    }

    @Override // com.sec.chaton.trunk.InterfaceC3055i
    /* renamed from: c */
    public void mo10328c(String str) {
        this.f10612i.setText(str);
    }

    @Override // com.sec.chaton.trunk.InterfaceC3055i
    /* renamed from: a */
    public void mo10315a(long j) {
        String str = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(j));
        String str2 = new SimpleDateFormat("yyyy").format(Long.valueOf(j));
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str3 = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(jCurrentTimeMillis));
        String str4 = new SimpleDateFormat("yyyy").format(Long.valueOf(jCurrentTimeMillis));
        if (str3.equals(str)) {
            this.f10613j.setText(DateFormat.getTimeFormat(CommonApplication.m11493l()).format(new Date(j)));
        } else if (str2.equals(str4)) {
            this.f10613j.setText(DateFormat.getDateFormat(CommonApplication.m11493l()).format(new Date(j)));
        } else {
            this.f10613j.setText(DateFormat.getDateFormat(CommonApplication.m11493l()).format(new Date(j)));
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC3055i
    /* renamed from: a */
    public void mo10317a(EnumC3026g enumC3026g, File file, String str) {
        if (!this.f10578M) {
            if (!this.f10579N || this.f10573H == null || !this.f10573H.equals(str)) {
                this.f10572G = enumC3026g;
                this.f10573H = str;
                m10271c(false);
                if (this.f10573H == null || this.f10573H.trim().equals("")) {
                    this.f10592aa.m11732a(this.f10616m);
                    return;
                }
                if (this.f10572G == EnumC3026g.IMAGE || this.f10572G == EnumC3026g.AMS) {
                    this.f10593ab = C3020a.m10524a(this.f10573H);
                    if (this.f10572G == EnumC3026g.AMS || !C3025f.m10540b(this.f10573H)) {
                        this.f10616m.setClickable(false);
                    }
                    if (this.f10593ab == null) {
                        if (file.exists()) {
                            if (C3250y.f11734b) {
                                C3250y.m11450b(C3364o.m11849a("For thumbnail image exists, show it. ", file.getAbsolutePath()), f10565a);
                            }
                            this.f10592aa.m11732a(this.f10616m);
                            this.f10616m.setImageBitmap(C3162ad.m11003a(Uri.parse(file.getAbsolutePath())));
                        }
                        m10301p();
                        m10290j();
                        return;
                    }
                    m10271c(true);
                    boolean zM10540b = C3025f.m10540b(this.f10573H);
                    if (zM10540b) {
                        this.f10572G = EnumC3026g.AMS;
                    }
                    C2970ak c2970ak = new C2970ak(this.f10593ab, this.f10572G, true, this.f10617n);
                    if (C3250y.f11734b) {
                        C3250y.m11450b(C3364o.m11849a("Is AMS image: ", Boolean.valueOf(zM10540b)), f10565a);
                    }
                    if (zM10540b) {
                        m10269b(true);
                        m10276d(false);
                    } else {
                        m10269b(false);
                        m10276d(true);
                    }
                    this.f10592aa.m11730a(this.f10616m, c2970ak);
                    return;
                }
                if (this.f10572G == EnumC3026g.VIDEO) {
                    this.f10593ab = C3020a.m10524a(this.f10573H);
                    if (this.f10593ab == null) {
                        this.f10616m.setImageResource(R.drawable.turnk_no_veido_default);
                        this.f10617n.setImageResource(R.drawable.chat_btn_play);
                        this.f10617n.setVisibility(0);
                        this.f10592aa.m11732a(this.f10616m);
                        return;
                    }
                    m10271c(true);
                    m10276d(true);
                    this.f10592aa.m11730a(this.f10616m, new C2970ak(this.f10593ab, this.f10572G, true, this.f10617n));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m10269b(boolean z) {
        if (!this.f10579N && z) {
        }
    }

    /* renamed from: c */
    private void m10271c(boolean z) {
        this.f10623t = z;
        if (this.f10607d != null && this.f10607d.findItem(R.id.trunkitem_share) != null) {
            if (z) {
                this.f10607d.findItem(R.id.trunkitem_share).setEnabled(true);
            } else {
                this.f10607d.findItem(R.id.trunkitem_share).setEnabled(false);
            }
        }
    }

    /* renamed from: d */
    private void m10276d(boolean z) {
        this.f10624u = z;
        if (this.f10607d != null && this.f10607d.findItem(R.id.trunkitem_save) != null) {
            if (z) {
                this.f10607d.findItem(R.id.trunkitem_save).setEnabled(true);
            } else {
                this.f10607d.findItem(R.id.trunkitem_save).setEnabled(false);
            }
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC3055i
    /* renamed from: a */
    public void mo10314a(int i, Cursor cursor) {
        this.f10575J = i;
        int count = cursor != null ? cursor.getCount() : 0;
        if (C3250y.f11734b) {
            C3250y.m11450b(C3364o.m11849a("setCommentList(). mTotalCommentCount: ", Integer.valueOf(i), ", mViewCommentCount: ", Integer.valueOf(count)), f10565a);
        }
        if (this.f10575J == 1 || this.f10575J == 0) {
            this.f10621r.setText(String.valueOf(this.f10575J));
            this.f10581P = true;
        } else if (this.f10575J > 1) {
            this.f10621r.setText(String.valueOf(this.f10575J));
            if (count >= this.f10575J) {
                this.f10581P = true;
            } else {
                this.f10581P = false;
            }
        }
        if (count == 0 || this.f10577L) {
            this.f10580O = null;
        } else if (cursor != null && cursor.moveToLast()) {
            this.f10580O = cursor.getString(cursor.getColumnIndex("comment_id"));
            if (C3250y.f11734b) {
                C3250y.m11450b(C3364o.m11849a("Last Comment Id: ", this.f10580O), f10565a);
            }
        }
        this.f10610g.changeCursor(cursor);
    }

    @Override // com.sec.chaton.trunk.InterfaceC3055i
    /* renamed from: a */
    public void mo10320a(InterfaceC3058l interfaceC3058l) {
        this.f10586U = interfaceC3058l;
    }

    @Override // com.sec.chaton.trunk.InterfaceC3055i
    /* renamed from: a */
    public void mo10319a(InterfaceC3057k interfaceC3057k) {
        this.f10587V = interfaceC3057k;
    }

    @Override // com.sec.chaton.trunk.InterfaceC3055i
    /* renamed from: b */
    public void mo10324b(InterfaceC3057k interfaceC3057k) {
        this.f10588W = interfaceC3057k;
    }

    @Override // com.sec.chaton.trunk.InterfaceC3055i
    /* renamed from: c */
    public void mo10327c(InterfaceC3057k interfaceC3057k) {
        this.f10589X = interfaceC3057k;
    }

    @Override // com.sec.chaton.trunk.InterfaceC3055i
    /* renamed from: a */
    public void mo10318a(InterfaceC3056j interfaceC3056j) {
        this.f10590Y = interfaceC3056j;
    }

    @Override // com.sec.chaton.trunk.InterfaceC3055i
    /* renamed from: a */
    public void mo10321a(InterfaceC3059m interfaceC3059m) {
        this.f10591Z = interfaceC3059m;
    }

    @Override // com.sec.chaton.trunk.p061c.InterfaceC3024e
    /* renamed from: a */
    public void mo10245a(boolean z) {
        if (C3250y.f11736d) {
            C3250y.m11455d("Storage state is changed. finish activity.", f10565a);
        }
        if (this.f10609f != null) {
            this.f10609f.mo10204a(false, this.f10602ak);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m10288i() {
        m10298n();
        if (this.f10605b != null) {
            this.f10606c = (EditText) this.f10608e.findViewById(R.id.trunkCommentEdit);
            if (this.f10606c != null) {
                this.f10605b.hideSoftInputFromWindow(this.f10606c.getWindowToken(), 0);
            }
        }
        this.f10587V.mo10500a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m10290j() {
        this.f10579N = true;
        m10291k();
        this.f10589X.mo10500a();
    }

    /* renamed from: k */
    private void m10291k() {
        this.f10583R.m10528a("content");
        this.f10619p.setVisibility(0);
        this.f10617n.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m10293l() {
        this.f10583R.m10529b("content");
        if (!this.f10583R.m10530c("content")) {
            this.f10619p.setVisibility(8);
            if (this.f10572G == EnumC3026g.VIDEO) {
                this.f10617n.setImageResource(R.drawable.chat_btn_play);
                this.f10617n.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10265a(Boolean bool) {
        this.f10583R.m10528a("comment");
        if (bool.booleanValue()) {
            this.f10621r.setVisibility(8);
            this.f10601aj.setVisibility(0);
            this.f10620q.setVisibility(8);
        } else {
            this.f10626w.setVisibility(8);
            this.f10601aj.setVisibility(8);
            this.f10620q.setVisibility(0);
        }
        this.f10585T = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m10296m() {
        this.f10583R.m10529b("comment");
        if (!this.f10583R.m10530c("comment")) {
            this.f10626w.setVisibility(0);
            this.f10620q.setVisibility(8);
            this.f10601aj.setVisibility(8);
        }
        this.f10585T = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10264a(EnumC3010br enumC3010br) {
        switch (enumC3010br) {
            case Nonetwork:
                this.f10622s.setText(R.string.popup_no_network_connection);
                this.f10622s.setDuration(0);
                this.f10622s.show();
                break;
            case NetworkErr:
                this.f10622s.setText(R.string.toast_network_unable);
                this.f10622s.setDuration(0);
                this.f10622s.show();
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m10298n() {
        if (this.f10566A == null) {
            this.f10566A = new C3263j(this.f10608e).m11487a(R.string.setting_webview_please_wait);
            this.f10566A.setCancelable(false);
        }
        if (this.f10566A != null) {
            this.f10566A.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m10275d(String str) {
        this.f10567B = AbstractC3271a.m11494a(this.f10608e).mo11495a(R.string.setting_interaction_me).mo11497a(R.array.chat_date_bar, new DialogInterfaceOnClickListenerC3006bn(this, str)).mo11505a().mo11517a();
        this.f10567B.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m10300o() {
        if (this.f10568C == null) {
            this.f10568C = AbstractC3271a.m11494a(this.f10608e).mo11500a((CharSequence) null).mo11506b(R.string.trunk_content_deleted).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3007bo(this)).mo11505a().mo11517a();
            this.f10568C.setCancelable(false);
        }
        if (this.f10568C != null) {
            this.f10568C.show();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m10301p();
    }

    /* renamed from: p */
    private void m10301p() {
        Display defaultDisplay = ((WindowManager) GlobalApplication.m6447a().getSystemService("window")).getDefaultDisplay();
        BitmapDrawable bitmapDrawable = (BitmapDrawable) this.f10616m.getDrawable();
        if (bitmapDrawable != null) {
            Bitmap bitmap = bitmapDrawable.getBitmap();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f10616m.getLayoutParams();
            if (bitmap != null) {
                this.f10616m.setScaleType(ImageView.ScaleType.CENTER_CROP);
                layoutParams.width = (int) (defaultDisplay.getWidth() - C3172an.m11085a(20.0f));
                layoutParams.height = (int) C3172an.m11085a(220.0f);
                this.f10616m.setLayoutParams(layoutParams);
                this.f10616m.invalidate();
            }
        }
    }

    /* renamed from: g */
    public void m10332g() {
        this.f10581P = false;
        if (this.f10586U != null) {
            m10265a((Boolean) false);
            this.f10586U.mo10499a(100, 239);
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC3055i
    /* renamed from: b */
    public void mo10325b(String str) {
        this.f10595ad = str;
        if (this.f10595ad != null) {
            this.f10594ac.setText(C1835j.m7508a(getActivity().getApplicationContext(), str, (int) C3172an.m11085a(30.0f)));
            this.f10594ac.setVisibility(0);
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC3055i
    /* renamed from: b */
    public void mo10323b() {
        if (!this.f10578M) {
            if (!this.f10579N || this.f10573H == null || !this.f10573H.equals(this.f10599ah)) {
                this.f10573H = this.f10599ah;
                m10271c(false);
                if (this.f10573H == null || this.f10573H.trim().equals("")) {
                    this.f10592aa.m11732a(this.f10616m);
                    return;
                }
                if (this.f10573H.contains("file://")) {
                    this.f10573H = this.f10573H.substring(7);
                }
                if (!this.f10600ai) {
                    this.f10593ab = C3020a.m10524a(this.f10573H);
                    this.f10572G = EnumC3026g.IMAGE;
                    if (this.f10593ab == null) {
                        this.f10616m.setImageResource(R.drawable.turnk_no_image_default);
                        this.f10592aa.m11732a(this.f10616m);
                        return;
                    }
                    m10271c(true);
                    boolean zM10540b = C3025f.m10540b(this.f10573H);
                    if (!zM10540b) {
                        this.f10616m.setClickable(false);
                    } else {
                        this.f10572G = EnumC3026g.AMS;
                    }
                    C2970ak c2970ak = new C2970ak(this.f10593ab, this.f10572G, true, this.f10617n);
                    if (C3250y.f11734b) {
                        C3250y.m11450b(C3364o.m11849a("Is AMS image: ", Boolean.valueOf(zM10540b)), f10565a);
                    }
                    if (zM10540b) {
                        m10269b(true);
                        m10276d(false);
                    } else {
                        m10269b(false);
                        m10276d(true);
                    }
                    this.f10592aa.m11730a(this.f10616m, c2970ak);
                    return;
                }
                this.f10593ab = C3020a.m10524a(this.f10573H);
                this.f10572G = EnumC3026g.VIDEO;
                if (this.f10593ab == null) {
                    this.f10616m.setImageResource(R.drawable.turnk_no_veido_default);
                    this.f10617n.setImageResource(R.drawable.chat_btn_play);
                    this.f10617n.setVisibility(0);
                    this.f10592aa.m11732a(this.f10616m);
                    return;
                }
                m10271c(true);
                m10276d(true);
                this.f10592aa.m11730a(this.f10616m, new C2970ak(this.f10593ab, this.f10572G, true, this.f10617n));
            }
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC2969aj
    /* renamed from: c */
    public void mo10326c() {
        this.f10609f.mo10204a(false, this.f10602ak);
    }
}
