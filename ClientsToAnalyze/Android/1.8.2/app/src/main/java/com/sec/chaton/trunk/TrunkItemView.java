package com.sec.chaton.trunk;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.trunk.p053e.C1592a;
import com.sec.chaton.trunk.p053e.C1593b;
import com.sec.chaton.trunk.p053e.C1594c;
import com.sec.chaton.trunk.p053e.C1597f;
import com.sec.chaton.trunk.p053e.C1598g;
import com.sec.chaton.trunk.p053e.EnumC1599h;
import com.sec.chaton.trunk.p053e.InterfaceC1596e;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1791w;
import com.sec.chaton.widget.C1797a;
import com.sec.chaton.widget.C1798b;
import com.sec.chaton.widget.C1805i;
import com.sec.chaton.widget.ProgressDialogC1806j;
import com.sec.widget.AlertDialogBuilderC2120a;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* loaded from: classes.dex */
public class TrunkItemView extends Fragment implements InterfaceC1596e, InterfaceC1600f {

    /* renamed from: e */
    private static final String f5448e = TrunkItemView.class.getSimpleName();

    /* renamed from: A */
    private Dialog f5449A;

    /* renamed from: B */
    private Dialog f5450B;

    /* renamed from: C */
    private View f5451C;

    /* renamed from: D */
    private String f5452D;

    /* renamed from: E */
    private String f5453E;

    /* renamed from: F */
    private String f5454F;

    /* renamed from: G */
    private EnumC1599h f5455G;

    /* renamed from: H */
    private String f5456H;

    /* renamed from: I */
    private String f5457I;

    /* renamed from: J */
    private int f5458J;

    /* renamed from: K */
    private int f5459K;

    /* renamed from: L */
    private boolean f5460L;

    /* renamed from: M */
    private boolean f5461M;

    /* renamed from: N */
    private boolean f5462N;

    /* renamed from: O */
    private String f5463O;

    /* renamed from: P */
    private boolean f5464P;

    /* renamed from: Q */
    private C1593b f5465Q;

    /* renamed from: R */
    private EnumC1552ba f5466R;

    /* renamed from: S */
    private EnumC1540az f5467S;

    /* renamed from: T */
    private C1521ag f5468T;

    /* renamed from: U */
    private InterfaceC1603i f5469U;

    /* renamed from: V */
    private InterfaceC1602h f5470V;

    /* renamed from: W */
    private InterfaceC1602h f5471W;

    /* renamed from: X */
    private InterfaceC1602h f5472X;

    /* renamed from: Y */
    private InterfaceC1601g f5473Y;

    /* renamed from: Z */
    private InterfaceC1604j f5474Z;

    /* renamed from: a */
    Bitmap f5475a;

    /* renamed from: aa */
    private C1798b f5476aa;

    /* renamed from: ac */
    private C1797a f5478ac;

    /* renamed from: ad */
    private C1797a f5479ad;

    /* renamed from: ae */
    private C1797a f5480ae;

    /* renamed from: af */
    private ListView f5481af;

    /* renamed from: b */
    Bitmap f5484b;

    /* renamed from: c */
    Bitmap f5485c;

    /* renamed from: f */
    private Activity f5487f;

    /* renamed from: g */
    private InterfaceC1553bb f5488g;

    /* renamed from: h */
    private C1541b f5489h;

    /* renamed from: i */
    private String f5490i;

    /* renamed from: j */
    private String f5491j;

    /* renamed from: k */
    private long f5492k;

    /* renamed from: l */
    private View f5493l;

    /* renamed from: m */
    private ImageView f5494m;

    /* renamed from: n */
    private ProgressBar f5495n;

    /* renamed from: o */
    private View f5496o;

    /* renamed from: p */
    private View f5497p;

    /* renamed from: q */
    private View f5498q;

    /* renamed from: r */
    private View f5499r;

    /* renamed from: s */
    private View f5500s;

    /* renamed from: t */
    private TextView f5501t;

    /* renamed from: u */
    private View f5502u;

    /* renamed from: v */
    private ListView f5503v;

    /* renamed from: w */
    private RelativeLayout f5504w;

    /* renamed from: x */
    private TextView f5505x;

    /* renamed from: y */
    private Button f5506y;

    /* renamed from: z */
    private Dialog f5507z;

    /* renamed from: ab */
    private ArrayList f5477ab = new ArrayList();

    /* renamed from: ag */
    private Handler f5482ag = new HandlerC1529ao(this);

    /* renamed from: ah */
    private AdapterView.OnItemLongClickListener f5483ah = new C1532ar(this);

    /* renamed from: d */
    AdapterView.OnItemSelectedListener f5486d = new C1530ap(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f5487f = activity;
        try {
            this.f5488g = (InterfaceC1553bb) this.f5487f;
        } catch (ClassCastException e) {
            throw new ClassCastException(C1597f.m5505a(activity.toString(), " must implement ITrunkItemViewListener."));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f5487f = null;
        this.f5488g = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        Bundle arguments = getArguments();
        this.f5452D = arguments.getString("sessionId");
        this.f5453E = arguments.getString("inboxNO");
        this.f5454F = arguments.getString("itemId");
        this.f5465Q = new C1593b();
        this.f5489h = new C1541b(this.f5487f, null, 0);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(R.layout.trunk_content_fragment, viewGroup, false);
        this.f5475a = null;
        this.f5484b = null;
        this.f5485c = null;
        this.f5494m = null;
        this.f5478ac = new C1797a(getResources().getString(R.string.share), R.drawable.share);
        this.f5479ad = new C1797a(getResources().getString(R.string.ams_btn_delete), R.drawable.delete);
        this.f5480ae = new C1797a(getResources().getString(R.string.trunk_menu_refresh), R.drawable.refresh);
        this.f5477ab.add(this.f5480ae);
        this.f5481af = (ListView) viewInflate.findViewById(R.id.itemOptions);
        this.f5481af.setAdapter((ListAdapter) m5314b());
        this.f5481af.setOnItemSelectedListener(m5320e());
        this.f5481af.setOnItemClickListener(new C1533as(this));
        this.f5503v = (ListView) viewInflate.findViewById(R.id.trunkContentList);
        this.f5505x = (TextView) viewInflate.findViewById(R.id.networkErrorView);
        this.f5505x.setVisibility(8);
        this.f5504w = (RelativeLayout) viewInflate.findViewById(R.id.titlelLayout);
        this.f5504w.setVisibility(8);
        this.f5493l = layoutInflater.inflate(R.layout.item_trunkcontent_header_image, (ViewGroup) this.f5503v, false);
        this.f5494m = (ImageView) this.f5493l.findViewById(R.id.trunkContentMainImage);
        this.f5494m.buildDrawingCache(false);
        this.f5494m.setOnClickListener(new ViewOnClickListenerC1534at(this));
        this.f5496o = this.f5493l.findViewById(R.id.defaultPlayBtn);
        this.f5495n = (ProgressBar) this.f5493l.findViewById(R.id.trunkContentDownloadProgressbar);
        this.f5501t = (TextView) this.f5493l.findViewById(R.id.trunkContentCommentCount);
        this.f5497p = this.f5493l.findViewById(R.id.previousView);
        this.f5499r = this.f5493l.findViewById(R.id.refreshCommentButton);
        this.f5499r.setOnClickListener(new ViewOnClickListenerC1535au(this));
        this.f5498q = this.f5493l.findViewById(R.id.previousCommentButton);
        this.f5498q.setOnClickListener(new ViewOnClickListenerC1536av(this));
        this.f5500s = this.f5493l.findViewById(R.id.trunkCommentsLoadingProgressbar);
        this.f5502u = this.f5493l.findViewById(R.id.trunkNoCommentTextView);
        this.f5503v.setOnItemLongClickListener(this.f5483ah);
        this.f5503v.addHeaderView(this.f5493l, null, false);
        this.f5506y = (Button) viewInflate.findViewById(R.id.commentButton);
        if (this.f5506y != null) {
            this.f5506y.setOnClickListener(new ViewOnClickListenerC1537aw(this));
        }
        this.f5451C = viewInflate.findViewById(R.id.trunkEmptyView);
        this.f5503v.setAdapter((ListAdapter) this.f5489h);
        BaseActivity.m1827a(this, true);
        m5260a(EnumC1552ba.Hidden);
        m5259a(EnumC1540az.Hidden);
        this.f5468T = new C1521ag(this, this.f5482ag, this.f5453E, this.f5452D, this.f5454F);
        this.f5468T.m5354a();
        m5285l();
        this.f5469U.mo5389a(20, 239);
        if (GlobalApplication.m3265f()) {
            if (getResources().getConfiguration().orientation == 1) {
                m5304a(75);
            } else {
                m5304a(125);
            }
        }
        return viewInflate;
    }

    /* renamed from: b */
    public C1798b m5314b() {
        this.f5476aa = new C1798b(getActivity(), this.f5477ab);
        return this.f5476aa;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        C1594c.m5500a(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        getActivity().setTitle(this.f5490i + " (" + this.f5491j + ')');
        this.f5468T.m5355b();
        this.f5494m.setClickable(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f5468T.m5356c();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        C1594c.m5502b(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        m5317c();
        super.onDestroyView();
        this.f5468T.m5357d();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f5465Q.m5495a();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.actionbar_menu_more_option, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                getActivity().finish();
                return false;
            case R.id.actionbar_menu_more_option /* 2131494125 */:
                if (this.f5481af.getVisibility() == 8) {
                    this.f5481af.setVisibility(0);
                } else {
                    this.f5481af.setVisibility(8);
                }
                return false;
            default:
                return false;
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC1600f
    /* renamed from: a */
    public Activity mo5303a() {
        return this.f5487f;
    }

    @Override // com.sec.chaton.trunk.InterfaceC1600f
    /* renamed from: a */
    public void mo5312a(String str) {
        this.f5457I = str;
        this.f5477ab.remove(this.f5479ad);
        if ("ME".equals(this.f5457I)) {
            this.f5477ab.add(this.f5479ad);
        }
        this.f5476aa.notifyDataSetChanged();
    }

    @Override // com.sec.chaton.trunk.InterfaceC1600f
    /* renamed from: b */
    public void mo5316b(String str) {
        this.f5490i = str;
    }

    @Override // com.sec.chaton.trunk.InterfaceC1600f
    /* renamed from: a */
    public void mo5306a(long j) {
        this.f5492k = j;
        if (DateFormat.is24HourFormat(GlobalApplication.m3260b())) {
            this.f5491j = java.text.DateFormat.getDateInstance(2, GlobalApplication.m3262c().getConfiguration().locale).format(new Date(this.f5492k)) + " " + new SimpleDateFormat("HH:mm").format(Long.valueOf(this.f5492k));
        } else {
            this.f5491j = java.text.DateFormat.getDateInstance(2, GlobalApplication.m3262c().getConfiguration().locale).format(new Date(this.f5492k)) + " " + java.text.DateFormat.getTimeInstance(3, GlobalApplication.m3262c().getConfiguration().locale).format(new Date(this.f5492k));
        }
        getActivity().setTitle(this.f5490i + " (" + this.f5491j + ')');
    }

    @Override // com.sec.chaton.trunk.InterfaceC1600f
    /* renamed from: a */
    public void mo5307a(EnumC1599h enumC1599h, File file, String str) {
        if (!this.f5461M) {
            if (!this.f5462N || this.f5456H == null || !this.f5456H.equals(str)) {
                this.f5455G = enumC1599h;
                this.f5456H = str;
                m5267c(false);
                m5263b(false);
                this.f5494m.setImageBitmap(null);
                if (this.f5456H != null && !this.f5456H.trim().equals("")) {
                    if (this.f5455G == EnumC1599h.IMAGE) {
                        if (C1592a.m5492a(this.f5456H) == null) {
                            if (file.exists()) {
                                if (C1786r.f6452b) {
                                    C1786r.m6061b(C1597f.m5505a("For thumbnail image exists, show it. ", file.getAbsolutePath()), f5448e);
                                }
                                this.f5475a = C1791w.m6086a(this.f5487f, Uri.parse(file.getAbsolutePath()));
                                this.f5494m.setImageBitmap(this.f5475a);
                            }
                            m5277h();
                            return;
                        }
                        m5267c(true);
                        boolean zM5509c = C1598g.m5509c(this.f5456H);
                        if (C1786r.f6452b) {
                            C1786r.m6061b(C1597f.m5505a("Is AMS image: ", Boolean.valueOf(zM5509c)), f5448e);
                        }
                        if (zM5509c) {
                            m5263b(true);
                        } else {
                            m5263b(false);
                        }
                        this.f5484b = C1791w.m6089a(this.f5487f, str);
                        this.f5494m.setImageBitmap(this.f5484b);
                        return;
                    }
                    if (this.f5455G == EnumC1599h.VIDEO) {
                        Uri uriM5492a = C1592a.m5492a(this.f5456H);
                        m5263b(true);
                        if (uriM5492a == null) {
                            this.f5494m.setImageBitmap(null);
                            return;
                        }
                        m5267c(true);
                        this.f5485c = ThumbnailUtils.createVideoThumbnail(this.f5456H, 1);
                        this.f5494m.setImageBitmap(this.f5485c);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public void m5317c() {
        if (this.f5475a != null && !this.f5475a.isRecycled()) {
            this.f5475a.recycle();
        }
        if (this.f5484b != null && !this.f5484b.isRecycled()) {
            this.f5484b.recycle();
        }
        if (this.f5485c != null && !this.f5485c.isRecycled()) {
            this.f5485c.recycle();
        }
        System.gc();
        Runtime.getRuntime().gc();
        this.f5494m.destroyDrawingCache();
        this.f5494m = null;
    }

    /* renamed from: b */
    private void m5263b(boolean z) {
        if (z) {
            m5260a(EnumC1552ba.Playable);
        } else {
            m5260a(EnumC1552ba.Hidden);
        }
    }

    /* renamed from: c */
    private void m5267c(boolean z) {
        this.f5477ab.remove(this.f5478ac);
        if (z) {
            this.f5477ab.add(this.f5478ac);
        }
        this.f5476aa.notifyDataSetChanged();
    }

    @Override // com.sec.chaton.trunk.InterfaceC1600f
    /* renamed from: a */
    public void mo5305a(int i, Cursor cursor) {
        this.f5458J = i;
        int count = cursor != null ? cursor.getCount() : 0;
        if (C1786r.f6452b) {
            C1786r.m6061b(C1597f.m5505a("setCommentList(). mTotalCommentCount: ", Integer.valueOf(i), ", mViewCommentCount: ", Integer.valueOf(count)), f5448e);
        }
        if (this.f5458J == 0) {
            this.f5501t.setText("");
        } else if (this.f5458J > 20) {
            if (this.f5458J >= 2) {
                this.f5501t.setText(String.format(this.f5487f.getString(R.string.trunk_comments), Integer.valueOf(this.f5458J)));
            } else {
                this.f5501t.setText(R.string.trunk_comment);
            }
        } else {
            this.f5501t.setVisibility(8);
        }
        if (count == 0) {
            this.f5463O = null;
            if (this.f5460L) {
                m5259a(EnumC1540az.Refresh);
            } else if (i == 0) {
                m5259a(EnumC1540az.NoComment);
            }
        } else {
            if (this.f5464P) {
                m5259a(EnumC1540az.Hidden);
            } else if (this.f5458J > count) {
                m5259a(EnumC1540az.LoadPreviousComment);
            } else if (this.f5458J <= count) {
                m5259a(EnumC1540az.Hidden);
            }
            if (cursor != null && cursor.moveToFirst()) {
                this.f5463O = cursor.getString(cursor.getColumnIndex("comment_id"));
                cursor.moveToFirst();
                if (C1786r.f6452b) {
                    C1786r.m6061b(C1597f.m5505a("Last Comment Id: ", this.f5463O), f5448e);
                }
            }
        }
        this.f5489h.changeCursor(cursor);
    }

    @Override // com.sec.chaton.trunk.InterfaceC1600f
    /* renamed from: a */
    public void mo5310a(InterfaceC1603i interfaceC1603i) {
        this.f5469U = interfaceC1603i;
    }

    @Override // com.sec.chaton.trunk.InterfaceC1600f
    /* renamed from: a */
    public void mo5309a(InterfaceC1602h interfaceC1602h) {
        this.f5470V = interfaceC1602h;
    }

    @Override // com.sec.chaton.trunk.InterfaceC1600f
    /* renamed from: b */
    public void mo5315b(InterfaceC1602h interfaceC1602h) {
        this.f5471W = interfaceC1602h;
    }

    @Override // com.sec.chaton.trunk.InterfaceC1600f
    /* renamed from: c */
    public void mo5318c(InterfaceC1602h interfaceC1602h) {
        this.f5472X = interfaceC1602h;
    }

    @Override // com.sec.chaton.trunk.InterfaceC1600f
    /* renamed from: a */
    public void mo5308a(InterfaceC1601g interfaceC1601g) {
        this.f5473Y = interfaceC1601g;
    }

    @Override // com.sec.chaton.trunk.InterfaceC1600f
    /* renamed from: a */
    public void mo5311a(InterfaceC1604j interfaceC1604j) {
        this.f5474Z = interfaceC1604j;
    }

    @Override // com.sec.chaton.trunk.p053e.InterfaceC1596e
    /* renamed from: a */
    public void mo5313a(boolean z) {
        if (C1786r.f6454d) {
            C1786r.m6065d("Storage state is changed. finish activity.", f5448e);
        }
        if (this.f5488g != null) {
            this.f5488g.mo5224b_();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m5275g() {
        m5288n();
        this.f5470V.mo5390a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m5277h() {
        this.f5462N = true;
        m5281j();
        this.f5472X.mo5390a();
    }

    /* renamed from: i */
    private boolean m5279i() {
        return this.f5465Q.m5498c("comment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5260a(EnumC1552ba enumC1552ba) {
        this.f5466R = enumC1552ba;
        if (!this.f5462N) {
            switch (this.f5466R) {
                case Playable:
                    this.f5496o.setVisibility(0);
                    break;
                case Hidden:
                    this.f5496o.setVisibility(8);
                    break;
            }
        }
    }

    /* renamed from: j */
    private void m5281j() {
        this.f5465Q.m5496a("content");
        this.f5495n.setVisibility(0);
        this.f5496o.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m5283k() {
        this.f5465Q.m5497b("content");
        if (!this.f5465Q.m5498c("content")) {
            this.f5495n.setVisibility(8);
            m5260a(this.f5466R);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m5285l() {
        this.f5465Q.m5496a("comment");
        this.f5500s.setVisibility(0);
        if (this.f5497p != null) {
            this.f5497p.setVisibility(8);
        }
        if (this.f5451C != null) {
            this.f5451C.setVisibility(8);
        }
        this.f5499r.setVisibility(8);
        this.f5498q.setVisibility(8);
        this.f5502u.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m5287m() {
        this.f5465Q.m5497b("comment");
        if (!this.f5465Q.m5498c("comment")) {
            this.f5500s.setVisibility(8);
            m5259a(this.f5467S);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5259a(EnumC1540az enumC1540az) {
        this.f5467S = enumC1540az;
        if (!m5279i()) {
            switch (enumC1540az) {
                case Refresh:
                    if (this.f5497p != null) {
                        this.f5497p.setVisibility(0);
                    }
                    if (this.f5451C != null) {
                        this.f5451C.setVisibility(0);
                    }
                    this.f5499r.setVisibility(0);
                    this.f5498q.setVisibility(8);
                    this.f5502u.setVisibility(8);
                    break;
                case LoadPreviousComment:
                    if (this.f5497p != null) {
                        this.f5497p.setVisibility(0);
                    }
                    if (this.f5451C != null) {
                        this.f5451C.setVisibility(8);
                    }
                    this.f5499r.setVisibility(8);
                    this.f5498q.setVisibility(0);
                    this.f5502u.setVisibility(8);
                    break;
                case NoComment:
                    if (this.f5497p != null) {
                        this.f5497p.setVisibility(8);
                    }
                    if (this.f5451C != null) {
                        this.f5451C.setVisibility(8);
                    }
                    this.f5499r.setVisibility(8);
                    this.f5498q.setVisibility(8);
                    this.f5502u.setVisibility(0);
                    break;
                case Hidden:
                    if (this.f5497p != null) {
                        this.f5497p.setVisibility(8);
                    }
                    if (this.f5451C != null) {
                        this.f5451C.setVisibility(8);
                    }
                    this.f5499r.setVisibility(8);
                    this.f5498q.setVisibility(8);
                    this.f5502u.setVisibility(8);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m5288n() {
        if (this.f5507z == null) {
            this.f5507z = (ProgressDialogC1806j) new C1805i(this.f5487f).m6139a(R.string.setting_webview_please_wait);
            this.f5507z.setCancelable(false);
        }
        if (this.f5507z != null) {
            this.f5507z.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m5266c(String str) {
        this.f5449A = new AlertDialogBuilderC2120a(this.f5487f).setTitle(R.string.setting_interaction_me).setItems(R.array.chat_date_bar, new DialogInterfaceOnClickListenerC1538ax(this, str)).create();
        this.f5449A.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m5291o() {
        if (this.f5450B == null) {
            this.f5450B = new AlertDialogBuilderC2120a(this.f5487f).setTitle(getResources().getString(R.string.trunk_toast_deleted)).setMessage(R.string.trunk_content_deleted).setPositiveButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1539ay(this)).create();
            this.f5450B.setCancelable(false);
        }
        if (this.f5450B != null) {
            this.f5450B.show();
        }
    }

    /* renamed from: a */
    public void m5304a(int i) {
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (GlobalApplication.m3265f()) {
            if (configuration.orientation == 1) {
                m5304a(75);
            } else {
                m5304a(125);
            }
        }
    }

    /* renamed from: d */
    public void m5319d() {
        this.f5464P = false;
        m5259a(EnumC1540az.Hidden);
        if (this.f5469U != null) {
            m5285l();
            this.f5469U.mo5389a(20, 239);
        }
    }

    /* renamed from: e */
    public AdapterView.OnItemSelectedListener m5320e() {
        return this.f5486d;
    }
}
