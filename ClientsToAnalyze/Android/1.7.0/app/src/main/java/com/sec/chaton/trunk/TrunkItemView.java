package com.sec.chaton.trunk;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p018c.C0502i;
import com.sec.chaton.trunk.p045d.C1163a;
import com.sec.chaton.trunk.p045d.C1165c;
import com.sec.chaton.trunk.p045d.C1166d;
import com.sec.chaton.trunk.p045d.C1169g;
import com.sec.chaton.trunk.p045d.C1170h;
import com.sec.chaton.trunk.p045d.EnumC1168f;
import com.sec.chaton.trunk.p045d.InterfaceC1164b;
import com.sec.chaton.util.C1294aq;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1346u;
import com.sec.chaton.widget.C1356c;
import com.sec.chaton.widget.ProgressDialogC1354a;
import com.sec.p007b.p008a.p011c.C0119d;
import com.sec.widget.AlertDialogBuilderC1625m;
import com.sec.widget.C1619g;
import com.sec.widget.C1632t;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class TrunkItemView extends Fragment implements InterfaceC1164b, InterfaceC1197w {

    /* renamed from: a */
    private static final String f3767a = TrunkItemView.class.getSimpleName();

    /* renamed from: A */
    private Dialog f3768A;

    /* renamed from: B */
    private Dialog f3769B;

    /* renamed from: C */
    private Dialog f3770C;

    /* renamed from: D */
    private View f3771D;

    /* renamed from: E */
    private String f3772E;

    /* renamed from: F */
    private String f3773F;

    /* renamed from: G */
    private String f3774G;

    /* renamed from: H */
    private EnumC1168f f3775H;

    /* renamed from: I */
    private String f3776I;

    /* renamed from: J */
    private String f3777J;

    /* renamed from: K */
    private int f3778K;

    /* renamed from: L */
    private int f3779L;

    /* renamed from: M */
    private boolean f3780M;

    /* renamed from: N */
    private boolean f3781N;

    /* renamed from: O */
    private boolean f3782O;

    /* renamed from: P */
    private String f3783P;

    /* renamed from: Q */
    private boolean f3784Q;

    /* renamed from: R */
    private boolean f3785R;

    /* renamed from: S */
    private C1170h f3786S;

    /* renamed from: T */
    private EnumC1194t f3787T;

    /* renamed from: U */
    private EnumC1110ah f3788U;

    /* renamed from: V */
    private C1104ab f3789V;

    /* renamed from: W */
    private InterfaceC1148bl f3790W;

    /* renamed from: X */
    private InterfaceC1192r f3791X;

    /* renamed from: Y */
    private InterfaceC1192r f3792Y;

    /* renamed from: Z */
    private InterfaceC1192r f3793Z;

    /* renamed from: aa */
    private InterfaceC1198x f3794aa;

    /* renamed from: ab */
    private InterfaceC1185k f3795ab;

    /* renamed from: ac */
    private C0119d f3796ac;

    /* renamed from: b */
    private MenuItem f3799b;

    /* renamed from: c */
    private InputMethodManager f3800c;

    /* renamed from: e */
    private Activity f3802e;

    /* renamed from: f */
    private InterfaceC1126ax f3803f;

    /* renamed from: g */
    private C1183i f3804g;

    /* renamed from: h */
    private TextView f3805h;

    /* renamed from: i */
    private TextView f3806i;

    /* renamed from: j */
    private long f3807j;

    /* renamed from: k */
    private ImageButton f3808k;

    /* renamed from: l */
    private C1632t f3809l;

    /* renamed from: m */
    private ProgressBar f3810m;

    /* renamed from: n */
    private ImageView f3811n;

    /* renamed from: o */
    private View f3812o;

    /* renamed from: p */
    private View f3813p;

    /* renamed from: q */
    private View f3814q;

    /* renamed from: r */
    private View f3815r;

    /* renamed from: s */
    private View f3816s;

    /* renamed from: t */
    private TextView f3817t;

    /* renamed from: u */
    private View f3818u;

    /* renamed from: v */
    private ListView f3819v;

    /* renamed from: w */
    private Toast f3820w;

    /* renamed from: x */
    private Button f3821x;

    /* renamed from: y */
    private Button f3822y;

    /* renamed from: z */
    private Button f3823z;

    /* renamed from: d */
    private EditText f3801d = null;

    /* renamed from: ad */
    private Handler f3797ad = new HandlerC1124av(this);

    /* renamed from: ae */
    private AdapterView.OnItemLongClickListener f3798ae = new C1125aw(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3802e = activity;
        try {
            this.f3803f = (InterfaceC1126ax) this.f3802e;
        } catch (ClassCastException e) {
            throw new ClassCastException(C1163a.m4203a(activity.toString(), " must implement ITrunkItemViewListener."));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f3802e = null;
        this.f3803f = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f3772E = arguments.getString("sessionId");
        this.f3773F = arguments.getString("inboxNO");
        this.f3774G = arguments.getString("itemId");
        this.f3820w = C1619g.m5889a(GlobalApplication.m3100a(), (CharSequence) null, 0);
        this.f3786S = new C1170h();
        this.f3809l = new C1632t(this);
        this.f3804g = new C1183i(this.f3802e, null, 0);
        this.f3796ac = new C0119d();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(R.layout.layout_trunk_item, viewGroup, false);
        this.f3800c = (InputMethodManager) this.f3802e.getSystemService("input_method");
        viewInflate.findViewById(android.R.id.button1).setOnClickListener(new ViewOnClickListenerC1122at(this));
        this.f3819v = (ListView) viewInflate.findViewById(R.id.trunkContentList);
        this.f3805h = (TextView) viewInflate.findViewById(R.id.trunkContentTitle);
        this.f3806i = (TextView) viewInflate.findViewById(R.id.trunkContentTitleTime);
        this.f3808k = (ImageButton) viewInflate.findViewById(android.R.id.button2);
        this.f3808k.setOnClickListener(new ViewOnClickListenerC1123au(this));
        View viewInflate2 = layoutInflater.inflate(R.layout.layout_trunk_detail_image_header, (ViewGroup) this.f3819v, false);
        this.f3811n = (ImageView) viewInflate2.findViewById(R.id.trunkContentMainImage);
        this.f3811n.setOnClickListener(new ViewOnClickListenerC1120ar(this));
        this.f3812o = viewInflate2.findViewById(R.id.defaultPlayBtn);
        this.f3810m = (ProgressBar) viewInflate2.findViewById(R.id.trunkContentDownloadProgressbar);
        this.f3819v.addHeaderView(viewInflate2, null, false);
        View viewInflate3 = layoutInflater.inflate(R.layout.layout_trunk_detail_comment_header, (ViewGroup) this.f3819v, false);
        this.f3817t = (TextView) viewInflate3.findViewById(R.id.trunkContentCommentCount);
        this.f3813p = viewInflate3.findViewById(R.id.previousView);
        this.f3815r = viewInflate3.findViewById(R.id.refreshCommentButton);
        this.f3815r.setOnClickListener(new ViewOnClickListenerC1121as(this));
        this.f3814q = viewInflate3.findViewById(R.id.previousCommentButton);
        this.f3814q.setOnClickListener(new ViewOnClickListenerC1118ap(this));
        this.f3816s = viewInflate3.findViewById(R.id.trunkCommentsLoadingProgressbar);
        this.f3818u = viewInflate3.findViewById(R.id.trunkNoCommentTextView);
        this.f3819v.addHeaderView(viewInflate3, null, false);
        this.f3821x = (Button) viewInflate.findViewById(R.id.commentButton);
        if (this.f3821x != null) {
            this.f3821x.setOnClickListener(new ViewOnClickListenerC1119aq(this));
        }
        this.f3822y = (Button) viewInflate.findViewById(R.id.trunkContentShareButton);
        if (this.f3822y != null) {
            this.f3822y.setOnClickListener(new ViewOnClickListenerC1117ao(this));
        }
        this.f3823z = (Button) viewInflate.findViewById(R.id.trunkContentDeleteButton);
        if (this.f3823z != null) {
            this.f3823z.setOnClickListener(new ViewOnClickListenerC1111ai(this));
        }
        this.f3771D = viewInflate.findViewById(R.id.trunkEmptyView);
        this.f3819v.setOnItemLongClickListener(this.f3798ae);
        this.f3819v.setAdapter((ListAdapter) this.f3804g);
        BaseActivity.m2041a(this, true);
        m3996a(EnumC1194t.Hidden);
        m3995a(EnumC1110ah.Hidden);
        this.f3789V = new C1104ab(this, this.f3797ad, this.f3773F, this.f3772E, this.f3774G);
        this.f3789V.m4175f();
        m4019j();
        this.f3790W.mo4181a(2, 239);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        C1166d.m4209a(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f3789V.m4176g();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f3789V.m4177h();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        C1166d.m4211b(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f3789V.m4178i();
        if (this.f3796ac != null) {
            this.f3796ac.m601a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f3786S.m4217a();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        this.f3799b = menu.add(0, 1, 1, R.string.share).setIcon(R.drawable.share_icon);
        MenuItem icon = menu.add(0, 2, 2, R.string.chat_view_menu_delete).setIcon(R.drawable.delete);
        if ("ME".equals(this.f3777J)) {
            icon.setEnabled(true);
        } else {
            icon.setEnabled(false);
        }
        if (this.f3785R) {
            this.f3799b.setEnabled(true);
        } else {
            this.f3799b.setEnabled(false);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        switch (menuItem.getItemId()) {
            case 1:
                if (C1346u.m4676a()) {
                    return true;
                }
                if (this.f3803f != null) {
                    int iM2526a = C0502i.m2526a(GlobalApplication.m3100a());
                    if (-3 == iM2526a || -2 == iM2526a) {
                        m4023l();
                    } else {
                        this.f3803f.mo3962a(this.f3775H, this.f3776I);
                    }
                }
                return false;
            case 2:
                new AlertDialogBuilderC1625m(getActivity()).setTitle(getResources().getString(R.string.menu_chat_delete)).setPositiveButton(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1112aj(this)).setNegativeButton(getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).show();
                return true;
            default:
                return false;
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC1197w
    /* renamed from: a */
    public Activity mo4040a() {
        return this.f3802e;
    }

    @Override // com.sec.chaton.trunk.InterfaceC1197w
    /* renamed from: a */
    public void mo4048a(String str) {
        this.f3777J = str;
        if ("ME".equals(this.f3777J)) {
            if (this.f3823z != null) {
                this.f3823z.setEnabled(true);
            }
        } else if (this.f3823z != null) {
            this.f3823z.setEnabled(false);
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC1197w
    /* renamed from: b */
    public void mo4052b(String str) {
        this.f3805h.setText(str);
    }

    @Override // com.sec.chaton.trunk.InterfaceC1197w
    /* renamed from: a */
    public void mo4042a(long j) {
        this.f3807j = j;
        DateFormat mediumDateFormat = android.text.format.DateFormat.getMediumDateFormat(GlobalApplication.m3100a());
        if (android.text.format.DateFormat.is24HourFormat(GlobalApplication.m3100a())) {
            this.f3806i.setText(mediumDateFormat.format(new Date(this.f3807j)) + " " + new SimpleDateFormat("HH:mm").format(Long.valueOf(this.f3807j)));
        } else {
            this.f3806i.setText(mediumDateFormat.format(new Date(this.f3807j)) + " " + DateFormat.getTimeInstance(3, GlobalApplication.m3106g().getConfiguration().locale).format(new Date(this.f3807j)));
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC1197w
    /* renamed from: a */
    public void mo4044a(EnumC1168f enumC1168f, File file, String str) {
        if (!this.f3781N) {
            if (!this.f3782O || this.f3776I == null || !this.f3776I.equals(str)) {
                this.f3775H = enumC1168f;
                this.f3776I = str;
                m4003c(false);
                m3999b(false);
                if (this.f3776I == null || this.f3776I.trim().equals("")) {
                    this.f3796ac.m602a(this.f3811n);
                    return;
                }
                if (this.f3775H == EnumC1168f.IMAGE) {
                    Uri uriM4214a = C1169g.m4214a(this.f3776I);
                    if (uriM4214a == null) {
                        if (file.exists()) {
                            if (C1341p.f4578b) {
                                C1341p.m4658b(C1163a.m4203a("For thumbnail image exists, show it. ", file.getAbsolutePath()), f3767a);
                            }
                            this.f3796ac.m602a(this.f3811n);
                            this.f3811n.setImageBitmap(C1294aq.m4499a(this.f3802e, Uri.parse(file.getAbsolutePath())));
                        }
                        m4011f();
                        return;
                    }
                    m4003c(true);
                    boolean zM4207c = C1165c.m4207c(this.f3776I);
                    C1147bk c1147bk = new C1147bk(uriM4214a, this.f3775H, true);
                    if (C1341p.f4578b) {
                        C1341p.m4658b(C1163a.m4203a("Is AMS image: ", Boolean.valueOf(zM4207c)), f3767a);
                    }
                    if (zM4207c) {
                        m3999b(true);
                    } else {
                        m3999b(false);
                    }
                    this.f3796ac.m603a(this.f3811n, c1147bk);
                    return;
                }
                if (this.f3775H == EnumC1168f.VIDEO) {
                    Uri uriM4214a2 = C1169g.m4214a(this.f3776I);
                    m3999b(true);
                    if (uriM4214a2 == null) {
                        this.f3811n.setImageBitmap(null);
                        this.f3796ac.m602a(this.f3811n);
                    } else {
                        m4003c(true);
                        this.f3796ac.m603a(this.f3811n, new C1147bk(uriM4214a2, this.f3775H, true));
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private void m3999b(boolean z) {
        if (z) {
            m3996a(EnumC1194t.Playable);
        } else {
            m3996a(EnumC1194t.Hidden);
        }
    }

    /* renamed from: c */
    private void m4003c(boolean z) {
        this.f3785R = z;
        if (this.f3822y != null && this.f3799b != null) {
            if (z) {
                this.f3822y.setEnabled(true);
                this.f3799b.setEnabled(true);
            } else {
                this.f3822y.setEnabled(false);
                this.f3799b.setEnabled(false);
            }
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC1197w
    /* renamed from: a */
    public void mo4041a(int i, Cursor cursor) {
        this.f3778K = i;
        int count = cursor != null ? cursor.getCount() : 0;
        if (C1341p.f4578b) {
            C1341p.m4658b(C1163a.m4203a("setCommentList(). mTotalCommentCount: ", Integer.valueOf(i), ", mViewCommentCount: ", Integer.valueOf(count)), f3767a);
        }
        if (this.f3778K == 0) {
            this.f3817t.setText("");
        } else if (this.f3778K >= 2) {
            this.f3817t.setText(String.format(this.f3802e.getString(R.string.trunk_comments), Integer.valueOf(this.f3778K)));
        } else {
            this.f3817t.setText(R.string.trunk_comment);
        }
        if (count == 0) {
            this.f3783P = null;
            if (this.f3780M) {
                m3995a(EnumC1110ah.Refresh);
            } else if (i == 0) {
                m3995a(EnumC1110ah.NoComment);
            }
        } else {
            if (this.f3784Q) {
                m3995a(EnumC1110ah.Hidden);
            } else if (this.f3778K > count) {
                m3995a(EnumC1110ah.LoadPreviousComment);
            } else if (this.f3778K <= count) {
                m3995a(EnumC1110ah.Hidden);
            }
            if (cursor != null && cursor.moveToFirst()) {
                this.f3783P = cursor.getString(cursor.getColumnIndex("comment_id"));
                cursor.moveToFirst();
                if (C1341p.f4578b) {
                    C1341p.m4658b(C1163a.m4203a("Last Comment Id: ", this.f3783P), f3767a);
                }
            }
        }
        this.f3804g.changeCursor(cursor);
    }

    @Override // com.sec.chaton.trunk.InterfaceC1197w
    /* renamed from: a */
    public void mo4043a(InterfaceC1148bl interfaceC1148bl) {
        this.f3790W = interfaceC1148bl;
    }

    @Override // com.sec.chaton.trunk.InterfaceC1197w
    /* renamed from: a */
    public void mo4046a(InterfaceC1192r interfaceC1192r) {
        this.f3791X = interfaceC1192r;
    }

    @Override // com.sec.chaton.trunk.InterfaceC1197w
    /* renamed from: b */
    public void mo4051b(InterfaceC1192r interfaceC1192r) {
        this.f3792Y = interfaceC1192r;
    }

    @Override // com.sec.chaton.trunk.InterfaceC1197w
    /* renamed from: c */
    public void mo4054c(InterfaceC1192r interfaceC1192r) {
        this.f3793Z = interfaceC1192r;
    }

    @Override // com.sec.chaton.trunk.InterfaceC1197w
    /* renamed from: a */
    public void mo4047a(InterfaceC1198x interfaceC1198x) {
        this.f3794aa = interfaceC1198x;
    }

    @Override // com.sec.chaton.trunk.InterfaceC1197w
    /* renamed from: a */
    public void mo4045a(InterfaceC1185k interfaceC1185k) {
        this.f3795ab = interfaceC1185k;
    }

    @Override // com.sec.chaton.trunk.p045d.InterfaceC1164b
    /* renamed from: a */
    public void mo4049a(boolean z) {
        if (C1341p.f4580d) {
            C1341p.m4661d("Storage state is changed. finish activity.", f3767a);
        }
        if (this.f3803f != null) {
            this.f3803f.mo3965b_();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m4008e() {
        m4024m();
        if (this.f3800c != null) {
            this.f3801d = (EditText) this.f3802e.findViewById(R.id.trunkCommentEdit);
            if (this.f3801d != null) {
                this.f3800c.hideSoftInputFromWindow(this.f3801d.getWindowToken(), 0);
            }
        }
        this.f3791X.mo4087a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m4011f() {
        this.f3782O = true;
        m4015h();
        this.f3793Z.mo4087a();
    }

    /* renamed from: g */
    private boolean m4013g() {
        return this.f3786S.m4220c("comment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3996a(EnumC1194t enumC1194t) {
        this.f3787T = enumC1194t;
        if (!this.f3782O) {
            switch (this.f3787T) {
                case Playable:
                    this.f3812o.setVisibility(0);
                    break;
                case Hidden:
                    this.f3812o.setVisibility(8);
                    break;
            }
        }
    }

    /* renamed from: h */
    private void m4015h() {
        this.f3786S.m4218a("content");
        this.f3810m.setVisibility(0);
        this.f3812o.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m4017i() {
        this.f3786S.m4219b("content");
        if (!this.f3786S.m4220c("content")) {
            this.f3810m.setVisibility(8);
            m3996a(this.f3787T);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m4019j() {
        this.f3786S.m4218a("comment");
        this.f3816s.setVisibility(0);
        if (this.f3813p != null) {
            this.f3813p.setVisibility(8);
        }
        if (this.f3771D != null) {
            this.f3771D.setVisibility(8);
        }
        this.f3815r.setVisibility(8);
        this.f3814q.setVisibility(8);
        this.f3818u.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m4021k() {
        this.f3786S.m4219b("comment");
        if (!this.f3786S.m4220c("comment")) {
            this.f3816s.setVisibility(8);
            m3995a(this.f3788U);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3995a(EnumC1110ah enumC1110ah) {
        this.f3788U = enumC1110ah;
        if (!m4013g()) {
            switch (enumC1110ah) {
                case Refresh:
                    if (this.f3813p != null) {
                        this.f3813p.setVisibility(0);
                    }
                    if (this.f3771D != null) {
                        this.f3771D.setVisibility(0);
                    }
                    this.f3815r.setVisibility(0);
                    this.f3814q.setVisibility(8);
                    this.f3818u.setVisibility(8);
                    break;
                case LoadPreviousComment:
                    if (this.f3813p != null) {
                        this.f3813p.setVisibility(0);
                    }
                    if (this.f3771D != null) {
                        this.f3771D.setVisibility(8);
                    }
                    this.f3815r.setVisibility(8);
                    this.f3814q.setVisibility(0);
                    this.f3818u.setVisibility(8);
                    break;
                case NoComment:
                    if (this.f3813p != null) {
                        this.f3813p.setVisibility(8);
                    }
                    if (this.f3771D != null) {
                        this.f3771D.setVisibility(8);
                    }
                    this.f3815r.setVisibility(8);
                    this.f3814q.setVisibility(8);
                    this.f3818u.setVisibility(0);
                    break;
                case Hidden:
                    if (this.f3813p != null) {
                        this.f3813p.setVisibility(8);
                    }
                    if (this.f3771D != null) {
                        this.f3771D.setVisibility(8);
                    }
                    this.f3815r.setVisibility(8);
                    this.f3814q.setVisibility(8);
                    this.f3818u.setVisibility(8);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m4023l() {
        this.f3820w.setText(R.string.popup_no_network_connection);
        this.f3820w.setDuration(0);
        this.f3820w.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m4024m() {
        if (this.f3768A == null) {
            this.f3768A = (ProgressDialogC1354a) new C1356c(this.f3802e).m4728a(R.string.setting_webview_please_wait);
            this.f3768A.setCancelable(false);
        }
        if (this.f3768A != null) {
            this.f3768A.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m4002c(String str) {
        this.f3769B = new AlertDialogBuilderC1625m(this.f3802e).setTitle(R.string.setting_interaction_me).setItems(R.array.chat_date_bar, new DialogInterfaceOnClickListenerC1115am(this, str)).create();
        this.f3769B.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m4027n() {
        if (this.f3770C == null) {
            this.f3770C = new AlertDialogBuilderC1625m(this.f3802e).setTitle((CharSequence) null).setMessage(R.string.trunk_content_deleted).setPositiveButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1114al(this)).create();
            this.f3770C.setCancelable(false);
        }
        if (this.f3770C != null) {
            this.f3770C.show();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* renamed from: b */
    public void m4050b() {
        this.f3784Q = false;
        m3995a(EnumC1110ah.Hidden);
        if (this.f3790W != null) {
            m4019j();
            this.f3790W.mo4181a(2, 239);
        }
    }

    /* renamed from: c */
    public void m4053c() {
        this.f3809l.m5919a(getView().findViewById(android.R.id.button2));
    }
}
