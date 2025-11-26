package com.sec.chaton.trunk;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
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
import com.sec.chaton.multimedia.emoticon.C2799k;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.chaton.trunk.p121c.C4636a;
import com.sec.chaton.trunk.p121c.C4637b;
import com.sec.chaton.trunk.p121c.C4638c;
import com.sec.chaton.trunk.p121c.C4641f;
import com.sec.chaton.trunk.p121c.EnumC4642g;
import com.sec.chaton.trunk.p121c.InterfaceC4640e;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4812ad;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4869cg;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.AdaptableEditText;
import com.sec.chaton.widget.C4923p;
import com.sec.common.CommonApplication;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p132g.C5007c;
import com.sec.common.util.C5034k;
import com.sec.common.util.C5052r;
import com.sec.widget.C5179v;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class TrunkItemView extends Fragment implements InterfaceC4588am, InterfaceC4640e, InterfaceC4675i {

    /* renamed from: a */
    private static final String f16512a = TrunkItemView.class.getSimpleName();

    /* renamed from: A */
    private Dialog f16513A;

    /* renamed from: B */
    private String f16514B;

    /* renamed from: C */
    private String f16515C;

    /* renamed from: D */
    private String f16516D;

    /* renamed from: E */
    private EnumC4642g f16517E;

    /* renamed from: F */
    private String f16518F;

    /* renamed from: G */
    private String f16519G;

    /* renamed from: H */
    private int f16520H;

    /* renamed from: I */
    private int f16521I;

    /* renamed from: J */
    private boolean f16522J;

    /* renamed from: K */
    private boolean f16523K;

    /* renamed from: L */
    private boolean f16524L;

    /* renamed from: M */
    private String f16525M;

    /* renamed from: N */
    private boolean f16526N;

    /* renamed from: O */
    private boolean f16527O;

    /* renamed from: P */
    private C4637b f16528P;

    /* renamed from: Q */
    private C4611bc f16529Q;

    /* renamed from: R */
    private boolean f16530R;

    /* renamed from: S */
    private InterfaceC4678l f16531S;

    /* renamed from: T */
    private InterfaceC4677k f16532T;

    /* renamed from: U */
    private InterfaceC4677k f16533U;

    /* renamed from: V */
    private InterfaceC4677k f16534V;

    /* renamed from: W */
    private InterfaceC4676j f16535W;

    /* renamed from: X */
    private InterfaceC4679m f16536X;

    /* renamed from: Y */
    private C5007c f16537Y;

    /* renamed from: Z */
    private Uri f16538Z;

    /* renamed from: aa */
    private TextView f16539aa;

    /* renamed from: ab */
    private String f16540ab;

    /* renamed from: ac */
    private String f16541ac;

    /* renamed from: ad */
    private String f16542ad;

    /* renamed from: ae */
    private boolean f16543ae;

    /* renamed from: af */
    private String f16544af;

    /* renamed from: ag */
    private boolean f16545ag;

    /* renamed from: ah */
    private LinearLayout f16546ah;

    /* renamed from: ai */
    private boolean f16547ai = false;

    /* renamed from: aj */
    private Handler f16548aj = new HandlerC4619bk(this);

    /* renamed from: ak */
    private AdapterView.OnItemLongClickListener f16549ak = new C4621bm(this);

    /* renamed from: b */
    private InputMethodManager f16550b;

    /* renamed from: c */
    private AdaptableEditText f16551c;

    /* renamed from: d */
    private Menu f16552d;

    /* renamed from: e */
    private Activity f16553e;

    /* renamed from: f */
    private InterfaceC4628bt f16554f;

    /* renamed from: g */
    private C4602b f16555g;

    /* renamed from: h */
    private ImageView f16556h;

    /* renamed from: i */
    private TextView f16557i;

    /* renamed from: j */
    private TextView f16558j;

    /* renamed from: k */
    private ProgressBar f16559k;

    /* renamed from: l */
    private ProgressBar f16560l;

    /* renamed from: m */
    private ImageView f16561m;

    /* renamed from: n */
    private ImageView f16562n;

    /* renamed from: o */
    private FrameLayout f16563o;

    /* renamed from: p */
    private LinearLayout f16564p;

    /* renamed from: q */
    private LinearLayout f16565q;

    /* renamed from: r */
    private TextView f16566r;

    /* renamed from: s */
    private Toast f16567s;

    /* renamed from: t */
    private boolean f16568t;

    /* renamed from: u */
    private boolean f16569u;

    /* renamed from: v */
    private View f16570v;

    /* renamed from: w */
    private View f16571w;

    /* renamed from: x */
    private ListView f16572x;

    /* renamed from: y */
    private Dialog f16573y;

    /* renamed from: z */
    private Dialog f16574z;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17357a(C0778b c0778b) {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            m17361a(EnumC4629bu.Nonetwork);
            return;
        }
        if (c0778b.m3111f() == 80210) {
            C5179v.m19810a(this.f16553e, R.string.buddy_information_changed, 1).show();
            this.f16543ae = false;
            if ("ME".equals(this.f16519G)) {
                this.f16552d.findItem(R.id.trunkitem_delete).setEnabled(false);
                return;
            }
            return;
        }
        m17361a(EnumC4629bu.NetworkErr);
    }

    /* renamed from: d */
    public void m17424d() {
        if (this.f16572x != null) {
            this.f16572x.setTranscriptMode(2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f16553e = activity;
        try {
            this.f16554f = (InterfaceC4628bt) this.f16553e;
        } catch (ClassCastException e) {
            throw new ClassCastException(C5052r.m19199a(activity.toString(), " must implement ITrunkItemViewListener."));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f16553e = null;
        this.f16554f = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f16514B = arguments.getString("sessionId");
        this.f16515C = arguments.getString("inboxNo");
        this.f16516D = arguments.getString("itemId");
        this.f16541ac = arguments.getString("ownerUid");
        this.f16542ad = arguments.getString("fileName");
        this.f16520H = arguments.getInt("totalcomment");
        this.f16543ae = arguments.getBoolean("isvalid");
        this.f16544af = arguments.getString("mediaUri");
        this.f16545ag = arguments.getBoolean("isVideo");
        this.f16567s = C5179v.m19811a(CommonApplication.m18732r(), (CharSequence) null, 0);
        this.f16528P = new C4637b();
        this.f16555g = new C4602b(this.f16553e, null, 0, this);
        this.f16537Y = new C5007c();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(R.layout.layout_trunk_item, viewGroup, false);
        this.f16550b = (InputMethodManager) this.f16553e.getSystemService("input_method");
        this.f16572x = (ListView) viewInflate.findViewById(R.id.trunkContentList);
        this.f16546ah = (LinearLayout) viewInflate.findViewById(R.id.moreCommentLoadbar);
        this.f16570v = layoutInflater.inflate(R.layout.layout_common_detail, (ViewGroup) this.f16572x, false);
        this.f16561m = (ImageView) this.f16570v.findViewById(R.id.image2);
        this.f16563o = (FrameLayout) this.f16570v.findViewById(R.id.space1);
        this.f16562n = new ImageView(this.f16553e);
        this.f16562n.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f16564p = new LinearLayout(this.f16553e);
        this.f16564p.setGravity(17);
        this.f16559k = new ProgressBar(new ContextThemeWrapper(this.f16553e, R.style.ProgressBarStyle_Large));
        this.f16559k.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.f16565q = new LinearLayout(this.f16553e);
        this.f16560l = new ProgressBar(new ContextThemeWrapper(this.f16553e, R.style.ProgressBarStyle_Small));
        this.f16560l.setLayoutParams(new FrameLayout.LayoutParams((int) C5034k.m19088a(17.0f), (int) C5034k.m19088a(17.0f)));
        this.f16565q.addView(this.f16560l);
        this.f16565q.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.f16565q.setPadding(0, (int) C5034k.m19088a(7.0f), 0, 0);
        this.f16564p.addView(this.f16559k);
        ((ViewGroup) this.f16570v).addView(this.f16565q);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f16563o.getLayoutParams();
        layoutParams.gravity = 17;
        this.f16563o.setLayoutParams(layoutParams);
        this.f16563o.addView(this.f16562n);
        this.f16563o.addView(this.f16564p);
        this.f16563o.setVisibility(0);
        this.f16564p.setVisibility(8);
        this.f16539aa = (TextView) this.f16570v.findViewById(R.id.text3);
        this.f16556h = (ImageView) this.f16570v.findViewById(R.id.image1);
        this.f16557i = (TextView) this.f16570v.findViewById(R.id.text1);
        this.f16558j = (TextView) this.f16570v.findViewById(R.id.text2);
        this.f16539aa.setVisibility(8);
        this.f16563o.setOnClickListener(new ViewOnClickListenerC4622bn(this));
        this.f16572x.addHeaderView(this.f16570v, null, false);
        this.f16571w = layoutInflater.inflate(R.layout.layout_common_text_icon_line, (ViewGroup) this.f16572x, false);
        this.f16566r = (TextView) this.f16571w.findViewById(R.id.text1);
        this.f16572x.addHeaderView(this.f16571w, null, false);
        this.f16572x.setOnItemLongClickListener(this.f16549ak);
        this.f16572x.setAdapter((ListAdapter) this.f16555g);
        BaseActivity.m6160a((Fragment) this, true);
        m17366b(false);
        this.f16529Q = new C4611bc(this, this.f16548aj, this.f16515C, this.f16514B, this.f16516D, this.f16541ac, this.f16542ad);
        this.f16529Q.m17508a();
        m17362a((Boolean) false);
        this.f16531S.mo17597a(100, 239);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        C4638c.m17609a(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f16529Q.m17509b();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f16529Q.m17510c();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        C4638c.m17611b(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f16529Q.m17511d();
        if (this.f16537Y != null) {
            this.f16537Y.m19014a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f16528P.m17604a();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.trunkitem_menu, menu);
        this.f16552d = menu;
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if (!"ME".equals(this.f16519G) || !this.f16543ae) {
            this.f16552d.removeItem(R.id.trunkitem_delete);
        }
        if (this.f16568t) {
            this.f16552d.findItem(R.id.trunkitem_share).setEnabled(true);
        } else {
            this.f16552d.findItem(R.id.trunkitem_share).setEnabled(false);
        }
        if (this.f16517E != EnumC4642g.AMS) {
            if (this.f16569u) {
                this.f16552d.findItem(R.id.trunkitem_save).setEnabled(true);
                return;
            } else {
                this.f16552d.findItem(R.id.trunkitem_save).setEnabled(false);
                return;
            }
        }
        this.f16552d.removeItem(R.id.trunkitem_save);
    }

    /* renamed from: e */
    public void m17426e() {
        if (this.f16554f != null) {
            this.f16554f.mo17302a(false, this.f16547ai);
        }
        if (this.f16550b != null) {
            this.f16551c = (AdaptableEditText) this.f16553e.findViewById(R.id.edit_text1);
            if (this.f16551c != null) {
                this.f16550b.hideSoftInputFromWindow(this.f16551c.getWindowToken(), 0);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        switch (menuItem.getItemId()) {
            case R.id.trunkitem_save /* 2131166722 */:
                ((TrunkDetailActivity) getActivity()).m17304c(this.f16518F);
                break;
            case R.id.trunkitem_share /* 2131166723 */:
                if (!C4847bl.m18333a()) {
                    if (this.f16554f != null) {
                        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
                        if (-3 == iM10677a || -2 == iM10677a) {
                            m17361a(EnumC4629bu.Nonetwork);
                            break;
                        } else if (!C4809aa.m18104a().m18119a("TrunkShareCheckPopup", (Boolean) false).booleanValue() && C4641f.m17617b(this.f16518F)) {
                            m17427f();
                            break;
                        } else {
                            this.f16554f.mo17301a(this.f16517E, this.f16518F, this.f16540ab);
                            break;
                        }
                    }
                } else {
                    return true;
                }
                break;
            case R.id.trunkitem_delete /* 2131166724 */:
                AbstractC4932a.m18733a(getActivity()).mo18740a(getResources().getString(R.string.menu_chat_delete)).mo18749b(getResources().getString(R.string.ams_delete_single_item)).mo18755c(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC4623bo(this)).mo18741a(getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo18752b();
                return true;
            case R.id.trunkitem_refresh /* 2131166725 */:
                int iM10677a2 = C2471v.m10677a(CommonApplication.m18732r());
                if (-3 == iM10677a2 || -2 == iM10677a2) {
                    m17361a(EnumC4629bu.Nonetwork);
                    break;
                } else {
                    m17362a((Boolean) false);
                    this.f16526N = false;
                    this.f16531S.mo17597a(100, 239);
                    break;
                }
        }
        return false;
    }

    @Override // com.sec.chaton.trunk.InterfaceC4675i
    /* renamed from: a */
    public Activity mo17409a() {
        return this.f16553e;
    }

    @Override // com.sec.chaton.trunk.InterfaceC4675i
    /* renamed from: a */
    public void mo17417a(String str) {
        this.f16519G = str;
        ((ActionBarFragmentActivity) this.f16553e).mo51u_();
    }

    @Override // com.sec.chaton.trunk.InterfaceC4675i
    /* renamed from: c */
    public void mo17423c(String str) {
        if ("ME".equals(str)) {
            C2496n.m10763a(this.f16556h, EnumC2498p.ROUND);
        } else {
            C2496n.m10765a(this.f16556h, str, EnumC2498p.ROUND);
        }
        if (C4822an.m18218a()) {
            this.f16556h.setBackgroundResource(R.drawable.circle_background);
        }
    }

    /* renamed from: f */
    public void m17427f() {
        C4869cg.m18497a(this.f16553e, new DialogInterfaceOnClickListenerC4624bp(this)).mo18752b();
    }

    @Override // com.sec.chaton.trunk.InterfaceC4675i
    /* renamed from: d */
    public void mo17425d(String str) {
        this.f16557i.setText(str);
    }

    @Override // com.sec.chaton.trunk.InterfaceC4675i
    /* renamed from: a */
    public void mo17411a(long j) {
        String str = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(j));
        String str2 = new SimpleDateFormat("yyyy").format(Long.valueOf(j));
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str3 = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(jCurrentTimeMillis));
        String str4 = new SimpleDateFormat("yyyy").format(Long.valueOf(jCurrentTimeMillis));
        if (str3.equals(str)) {
            this.f16558j.setText(DateFormat.getTimeFormat(CommonApplication.m18732r()).format(new Date(j)));
        } else if (str2.equals(str4)) {
            this.f16558j.setText(DateFormat.getDateFormat(CommonApplication.m18732r()).format(new Date(j)));
        } else {
            this.f16558j.setText(DateFormat.getDateFormat(CommonApplication.m18732r()).format(new Date(j)));
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC4675i
    /* renamed from: a */
    public void mo17412a(EnumC4642g enumC4642g, File file, String str) {
        if (!this.f16523K) {
            if (!this.f16524L || this.f16518F == null || !this.f16518F.equals(str)) {
                this.f16517E = enumC4642g;
                this.f16518F = str;
                m17368c(false);
                if (this.f16518F == null || this.f16518F.trim().equals("")) {
                    this.f16537Y.m19015a((View) this.f16561m);
                    return;
                }
                if (this.f16517E == EnumC4642g.IMAGE || this.f16517E == EnumC4642g.AMS) {
                    this.f16538Z = C4636a.m17601a(this.f16518F);
                    if (this.f16517E == EnumC4642g.AMS || !C4641f.m17617b(this.f16518F)) {
                        this.f16561m.setClickable(false);
                    }
                    if (this.f16538Z == null) {
                        if (file.exists()) {
                            if (C4904y.f17872b) {
                                C4904y.m18639b(C5052r.m19199a("For thumbnail image exists, show it. ", file.getAbsolutePath()), f16512a);
                            }
                            this.f16537Y.m19015a((View) this.f16561m);
                            this.f16561m.setImageBitmap(C4812ad.m18148a(Uri.parse(file.getAbsolutePath())));
                        }
                        m17399q();
                        m17386k();
                        return;
                    }
                    m17368c(true);
                    boolean zM17617b = C4641f.m17617b(this.f16518F);
                    if (zM17617b) {
                        this.f16517E = EnumC4642g.AMS;
                    }
                    C4589an c4589an = new C4589an(this.f16538Z, this.f16517E, true, this.f16562n);
                    if (C4904y.f17872b) {
                        C4904y.m18639b(C5052r.m19199a("Is AMS image: ", Boolean.valueOf(zM17617b)), f16512a);
                    }
                    if (zM17617b) {
                        m17366b(true);
                        m17372d(false);
                    } else {
                        m17366b(false);
                        m17372d(true);
                    }
                    this.f16537Y.m19023b(this.f16561m, c4589an);
                    return;
                }
                if (this.f16517E == EnumC4642g.VIDEO) {
                    this.f16538Z = C4636a.m17601a(this.f16518F);
                    if (this.f16538Z == null) {
                        this.f16561m.setImageResource(R.drawable.turnk_no_veido_default);
                        this.f16562n.setImageResource(R.drawable.chat_btn_play);
                        this.f16562n.setVisibility(0);
                        this.f16537Y.m19015a((View) this.f16561m);
                        return;
                    }
                    m17368c(true);
                    m17372d(true);
                    this.f16537Y.m19023b(this.f16561m, new C4589an(this.f16538Z, this.f16517E, true, this.f16562n));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m17366b(boolean z) {
        if (!this.f16524L && z) {
        }
    }

    /* renamed from: c */
    private void m17368c(boolean z) {
        this.f16568t = z;
        ((ActionBarFragmentActivity) this.f16553e).mo51u_();
    }

    /* renamed from: d */
    private void m17372d(boolean z) {
        this.f16569u = z;
        ((ActionBarFragmentActivity) this.f16553e).mo51u_();
    }

    @Override // com.sec.chaton.trunk.InterfaceC4675i
    /* renamed from: a */
    public void mo17410a(int i, Cursor cursor) {
        this.f16520H = i;
        int count = cursor != null ? cursor.getCount() : 0;
        if (C4904y.f17872b) {
            C4904y.m18639b(C5052r.m19199a("setCommentList(). mTotalCommentCount: ", Integer.valueOf(i), ", mViewCommentCount: ", Integer.valueOf(count)), f16512a);
        }
        if (this.f16520H == 1 || this.f16520H == 0) {
            this.f16566r.setText(String.valueOf(this.f16520H));
            this.f16526N = true;
        } else if (this.f16520H > 1) {
            this.f16566r.setText(String.valueOf(this.f16520H));
            if (count >= this.f16520H) {
                this.f16526N = true;
            } else {
                this.f16526N = false;
            }
        }
        if (count == 0 || this.f16522J) {
            this.f16525M = null;
        } else if (cursor != null && cursor.moveToLast()) {
            this.f16525M = cursor.getString(cursor.getColumnIndex("comment_id"));
            if (C4904y.f17872b) {
                C4904y.m18639b(C5052r.m19199a("Last Comment Id: ", this.f16525M), f16512a);
            }
        }
        this.f16555g.mo875a(cursor);
    }

    @Override // com.sec.chaton.trunk.InterfaceC4675i
    /* renamed from: a */
    public void mo17415a(InterfaceC4678l interfaceC4678l) {
        this.f16531S = interfaceC4678l;
    }

    @Override // com.sec.chaton.trunk.InterfaceC4675i
    /* renamed from: a */
    public void mo17414a(InterfaceC4677k interfaceC4677k) {
        this.f16532T = interfaceC4677k;
    }

    @Override // com.sec.chaton.trunk.InterfaceC4675i
    /* renamed from: b */
    public void mo17419b(InterfaceC4677k interfaceC4677k) {
        this.f16533U = interfaceC4677k;
    }

    @Override // com.sec.chaton.trunk.InterfaceC4675i
    /* renamed from: c */
    public void mo17422c(InterfaceC4677k interfaceC4677k) {
        this.f16534V = interfaceC4677k;
    }

    @Override // com.sec.chaton.trunk.InterfaceC4675i
    /* renamed from: a */
    public void mo17413a(InterfaceC4676j interfaceC4676j) {
        this.f16535W = interfaceC4676j;
    }

    @Override // com.sec.chaton.trunk.InterfaceC4675i
    /* renamed from: a */
    public void mo17416a(InterfaceC4679m interfaceC4679m) {
        this.f16536X = interfaceC4679m;
    }

    @Override // com.sec.chaton.trunk.p121c.InterfaceC4640e
    /* renamed from: a */
    public void mo17343a(boolean z) {
        if (C4904y.f17874d) {
            C4904y.m18645d("Storage state is changed. finish activity.", f16512a);
        }
        if (this.f16554f != null) {
            this.f16554f.mo17302a(false, this.f16547ai);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m17385j() {
        m17395o();
        if (this.f16550b != null) {
            this.f16551c = (AdaptableEditText) this.f16553e.findViewById(R.id.edit_text1);
            if (this.f16551c != null) {
                this.f16550b.hideSoftInputFromWindow(this.f16551c.getWindowToken(), 0);
            }
        }
        this.f16532T.mo17598a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m17386k() {
        this.f16524L = true;
        m17388l();
        this.f16534V.mo17598a();
    }

    /* renamed from: l */
    private void m17388l() {
        this.f16528P.m17605a("content");
        this.f16564p.setVisibility(0);
        this.f16562n.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m17391m() {
        this.f16528P.m17606b("content");
        if (!this.f16528P.m17607c("content")) {
            this.f16564p.setVisibility(8);
            if (this.f16517E == EnumC4642g.VIDEO) {
                this.f16562n.setImageResource(R.drawable.chat_btn_play);
                this.f16562n.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17362a(Boolean bool) {
        this.f16528P.m17605a("comment");
        if (bool.booleanValue()) {
            this.f16546ah.setVisibility(0);
            this.f16565q.setVisibility(8);
        } else {
            this.f16571w.setVisibility(8);
            this.f16546ah.setVisibility(8);
            this.f16565q.setVisibility(0);
        }
        this.f16530R = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m17393n() {
        this.f16528P.m17606b("comment");
        if (!this.f16528P.m17607c("comment")) {
            this.f16571w.setVisibility(0);
            this.f16565q.setVisibility(8);
            this.f16546ah.setVisibility(8);
        }
        this.f16530R = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17361a(EnumC4629bu enumC4629bu) {
        switch (C4627bs.f16803a[enumC4629bu.ordinal()]) {
            case 1:
                this.f16567s.setText(R.string.popup_no_network_connection);
                this.f16567s.setDuration(0);
                this.f16567s.show();
                break;
            case 2:
                this.f16567s.setText(R.string.toast_network_unable);
                this.f16567s.setDuration(0);
                this.f16567s.show();
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m17395o() {
        if (this.f16573y == null) {
            this.f16573y = new C4923p(this.f16553e).m18724a(R.string.setting_webview_please_wait);
            this.f16573y.setCancelable(false);
        }
        if (this.f16573y != null) {
            this.f16573y.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m17374e(String str) {
        this.f16574z = AbstractC4932a.m18733a(this.f16553e).mo18734a(R.string.setting_interaction_me).mo18736a(R.array.chat_date_bar, new DialogInterfaceOnClickListenerC4625bq(this, str)).mo18745a().mo18758a();
        this.f16574z.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m17396p() {
        if (this.f16513A == null) {
            this.f16513A = AbstractC4932a.m18733a(this.f16553e).mo18734a(R.string.trunk_title).mo18746b(R.string.trunk_content_deleted).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC4626br(this)).mo18745a().mo18758a();
            this.f16513A.setCancelable(false);
        }
        if (this.f16513A != null) {
            this.f16513A.show();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        if (this.f16553e != null) {
            BaseActivity.m6159a(this.f16553e);
        }
        m17399q();
    }

    /* renamed from: q */
    private void m17399q() {
        Display defaultDisplay = ((WindowManager) GlobalApplication.m10279a().getSystemService("window")).getDefaultDisplay();
        BitmapDrawable bitmapDrawable = (BitmapDrawable) this.f16561m.getDrawable();
        if (bitmapDrawable != null) {
            Bitmap bitmap = bitmapDrawable.getBitmap();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f16561m.getLayoutParams();
            if (bitmap != null) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                this.f16561m.setImageBitmap(bitmap);
                this.f16561m.setScaleType(ImageView.ScaleType.FIT_XY);
                layoutParams.height = (int) ((((defaultDisplay.getWidth() - C5034k.m19088a(10.0f)) - C5034k.m19097b(10.0f)) * height) / width);
                this.f16561m.setLayoutParams(layoutParams);
                this.f16561m.invalidate();
            }
        }
    }

    /* renamed from: g */
    public void m17428g() {
        this.f16526N = false;
        if (this.f16531S != null) {
            m17362a((Boolean) false);
            this.f16531S.mo17597a(100, 239);
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC4675i
    /* renamed from: b */
    public void mo17420b(String str) {
        this.f16540ab = str;
        if (this.f16540ab != null) {
            this.f16539aa.setText(C2799k.m11709a(getActivity().getApplicationContext(), str, (int) C5034k.m19088a(30.0f)));
            this.f16539aa.setVisibility(0);
        }
    }

    /* renamed from: h */
    public void m17429h() {
        if (this.f16529Q != null) {
            this.f16529Q.m17596j();
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC4675i
    /* renamed from: b */
    public void mo17418b() {
        if (!this.f16523K) {
            if (!this.f16524L || this.f16518F == null || !this.f16518F.equals(this.f16544af)) {
                this.f16518F = this.f16544af;
                m17368c(false);
                if (this.f16518F == null || this.f16518F.trim().equals("")) {
                    this.f16537Y.m19015a((View) this.f16561m);
                    return;
                }
                if (this.f16518F.contains("file://")) {
                    this.f16518F = this.f16518F.substring(7);
                }
                if (!this.f16545ag) {
                    this.f16538Z = C4636a.m17601a(this.f16518F);
                    this.f16517E = EnumC4642g.IMAGE;
                    if (this.f16538Z == null) {
                        this.f16561m.setImageResource(R.drawable.turnk_no_image_default);
                        this.f16537Y.m19015a((View) this.f16561m);
                        return;
                    }
                    m17368c(true);
                    boolean zM17617b = C4641f.m17617b(this.f16518F);
                    if (!zM17617b) {
                        this.f16561m.setClickable(false);
                    } else {
                        this.f16517E = EnumC4642g.AMS;
                    }
                    C4589an c4589an = new C4589an(this.f16538Z, this.f16517E, true, this.f16562n);
                    if (C4904y.f17872b) {
                        C4904y.m18639b(C5052r.m19199a("Is AMS image: ", Boolean.valueOf(zM17617b)), f16512a);
                    }
                    if (zM17617b) {
                        m17366b(true);
                        m17372d(false);
                    } else {
                        m17366b(false);
                        m17372d(true);
                    }
                    this.f16537Y.m19023b(this.f16561m, c4589an);
                    return;
                }
                this.f16538Z = C4636a.m17601a(this.f16518F);
                this.f16517E = EnumC4642g.VIDEO;
                if (this.f16538Z == null) {
                    this.f16561m.setImageResource(R.drawable.turnk_no_veido_default);
                    this.f16562n.setImageResource(R.drawable.chat_btn_play);
                    this.f16562n.setVisibility(0);
                    this.f16537Y.m19015a((View) this.f16561m);
                    return;
                }
                m17368c(true);
                m17372d(true);
                this.f16537Y.m19023b(this.f16561m, new C4589an(this.f16538Z, this.f16517E, true, this.f16562n));
            }
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC4588am
    /* renamed from: c */
    public void mo17421c() {
        if (this.f16554f != null) {
            this.f16554f.mo17302a(false, this.f16547ai);
        }
    }
}
