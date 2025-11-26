package com.sec.chaton.buddy;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.sec.multiwindow.MultiWindowManager;
import android.support.v4.p008c.C0083f;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.coolots.sso.p030a.C0416a;
import com.samsung.android.sdk.look.airbutton.SlookAirButton;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p050a.C1104a;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.C2230ar;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.chaton.plugin.C2923b;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4827as;
import com.sec.chaton.util.C4828at;
import com.sec.chaton.util.C4830av;
import com.sec.chaton.util.C4840be;
import com.sec.chaton.util.C4872cj;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.FastScrollableExpandableListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.ad */
/* loaded from: classes.dex */
public class C1113ad extends BaseExpandableListAdapter implements SectionIndexer {

    /* renamed from: a */
    public static C0083f<String, Bitmap> f4283a;

    /* renamed from: b */
    public static HashMap<String, Boolean> f4284b;

    /* renamed from: A */
    private boolean f4285A;

    /* renamed from: B */
    private ArrayList<C4830av> f4286B;

    /* renamed from: C */
    private ArrayList<String> f4287C;

    /* renamed from: F */
    private SlookAirButton.ItemSelectListener f4290F;

    /* renamed from: G */
    private C2210x f4291G;

    /* renamed from: H */
    private TypedArray f4292H;

    /* renamed from: I */
    private boolean f4293I;

    /* renamed from: J */
    private int f4294J;

    /* renamed from: e */
    private FastScrollableExpandableListView f4298e;

    /* renamed from: f */
    private LayoutInflater f4299f;

    /* renamed from: g */
    private Context f4300g;

    /* renamed from: h */
    private ArrayList<C1104a> f4301h;

    /* renamed from: i */
    private int f4302i;

    /* renamed from: j */
    private ArrayList<ArrayList<C1106c>> f4303j;

    /* renamed from: k */
    private int f4304k;

    /* renamed from: l */
    private boolean f4305l;

    /* renamed from: m */
    private boolean f4306m;

    /* renamed from: n */
    private boolean f4307n;

    /* renamed from: o */
    private String[] f4308o;

    /* renamed from: p */
    private HashMap<String, Integer> f4309p;

    /* renamed from: s */
    private InterfaceC1123an f4312s;

    /* renamed from: t */
    private InterfaceC1121al f4313t;

    /* renamed from: u */
    private InterfaceC1122am f4314u;

    /* renamed from: v */
    private BuddyFragment f4315v;

    /* renamed from: y */
    private int f4318y;

    /* renamed from: z */
    private String f4319z;

    /* renamed from: q */
    private String f4310q = null;

    /* renamed from: r */
    private String f4311r = null;

    /* renamed from: w */
    private Bitmap f4316w = null;

    /* renamed from: x */
    private int f4317x = -1;

    /* renamed from: D */
    private int f4288D = -1;

    /* renamed from: E */
    private int f4289E = -1;

    /* renamed from: K */
    private View.OnClickListener f4295K = new ViewOnClickListenerC1117ah(this);

    /* renamed from: c */
    ContentObserver f4296c = new C1119aj(this, new Handler());

    /* renamed from: d */
    InterfaceC2211y f4297d = new C1120ak(this);

    /* renamed from: a */
    public void m7120a(InterfaceC1121al interfaceC1121al) {
        this.f4313t = interfaceC1121al;
    }

    /* renamed from: a */
    public void m7121a(InterfaceC1122am interfaceC1122am) {
        this.f4314u = interfaceC1122am;
    }

    /* renamed from: a */
    public void m7122a(InterfaceC1123an interfaceC1123an) {
        this.f4312s = interfaceC1123an;
    }

    public C1113ad(FastScrollableExpandableListView fastScrollableExpandableListView, Context context, ArrayList<C1104a> arrayList, int i, ArrayList<ArrayList<C1106c>> arrayList2, int i2, boolean z, boolean z2, InterfaceC1123an interfaceC1123an, boolean z3, SlookAirButton.ItemSelectListener itemSelectListener, boolean z4) {
        this.f4293I = false;
        this.f4294J = 0;
        if (context != null) {
            this.f4298e = fastScrollableExpandableListView;
            this.f4299f = (LayoutInflater) context.getSystemService("layout_inflater");
            this.f4300g = context;
            this.f4301h = arrayList;
            this.f4302i = i;
            this.f4303j = arrayList2;
            this.f4304k = i2;
            this.f4305l = z;
            this.f4306m = z2;
            this.f4307n = z3;
            this.f4285A = z4;
            this.f4312s = interfaceC1123an;
            this.f4319z = "";
            this.f4290F = itemSelectListener;
            this.f4292H = this.f4300g.getTheme().obtainStyledAttributes(new int[]{R.attr.ftList07Color});
            this.f4293I = C2923b.m12153h(this.f4300g);
            context.getContentResolver().registerContentObserver(C2230ar.f7958a, true, this.f4296c);
            this.f4291G = new C2210x(context.getContentResolver(), this.f4297d);
            this.f4291G.startQuery(1000, null, C2230ar.f7958a, null, "islike = 'Y'", null, null);
        }
        this.f4294J = context.getResources().getDisplayMetrics().widthPixels;
    }

    /* renamed from: a */
    public static void m7106a(String str, Bitmap bitmap) {
        if (f4283a != null) {
            f4283a.m266a(str, bitmap);
        }
    }

    /* renamed from: b */
    public static void m7109b(String str, Bitmap bitmap) {
        if (m7103a(str) == null && f4283a != null) {
            f4283a.m266a(str, bitmap);
        }
    }

    /* renamed from: a */
    public static Bitmap m7103a(String str) {
        if (f4283a != null) {
            return f4283a.m265a((C0083f<String, Bitmap>) str);
        }
        return null;
    }

    /* renamed from: a */
    protected void m7119a(BuddyFragment buddyFragment) {
        this.f4315v = buddyFragment;
    }

    /* renamed from: a */
    public void m7118a(int i) {
        this.f4318y = i;
    }

    /* renamed from: b */
    public void m7125b(String str) {
        this.f4319z = str;
    }

    /* renamed from: a */
    public void m7123a(boolean z) {
        this.f4306m = z;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f4301h.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return this.f4303j.get(i).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        return this.f4301h.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        return this.f4303j.get(i).get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i, int i2) {
        return this.f4312s.mo6597b(this.f4303j.get(i).get(i2));
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        C1125ap c1125ap;
        if (getGroupType(i) == 0) {
            if (view == null) {
                View viewInflate = this.f4299f.inflate(this.f4302i, viewGroup, false);
                C1125ap c1125ap2 = new C1125ap((ViewGroup) viewInflate);
                viewInflate.setTag(c1125ap2);
                view = viewInflate;
                c1125ap = c1125ap2;
            } else {
                c1125ap = (C1125ap) view.getTag();
            }
            if (this.f4301h.size() > i) {
                C1104a c1104a = this.f4301h.get(i);
                c1125ap.f4343a.setText(c1104a.m7028b());
                String strM7028b = c1104a.m7028b();
                if (!c1125ap.f4343a.getText().equals(this.f4300g.getResources().getString(R.string.setting_interaction_me))) {
                    if (c1125ap.f4343a.getText().equals(this.f4300g.getResources().getString(R.string.live))) {
                        String[] strArrSplit = strM7028b.split(" ");
                        if (strArrSplit.length == 2 && strArrSplit[1].equalsIgnoreCase("live")) {
                            c1125ap.f4343a.setText(strArrSplit[0] + " \u202a(" + this.f4301h.get(i).m7029c() + ") \u202c" + strArrSplit[1]);
                        } else {
                            c1125ap.f4343a.setText(c1104a.m7028b() + " (" + this.f4301h.get(i).m7029c() + ")");
                        }
                    } else {
                        c1125ap.f4343a.setText(c1104a.m7028b() + " (" + this.f4301h.get(i).m7029c() + ")");
                    }
                }
            }
            if (z) {
                c1125ap.f4343a.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.list_ic_arrow_up, 0);
            } else {
                c1125ap.f4343a.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.list_ic_arrow_down, 0);
            }
            view.setTag(c1125ap);
            return view;
        }
        if (view == null) {
            View view2 = new View(this.f4299f.getContext());
            view2.setVisibility(8);
            return view2;
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    @TargetApi(14)
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        C1124ao c1124ao;
        C1106c c1106c = this.f4303j.get(i).get(i2);
        if (view == null) {
            View viewInflate = this.f4299f.inflate(getChildType(i, i2) == 1 ? R.layout.list_item_common_7_non_checkable : this.f4304k, viewGroup, false);
            C1124ao c1124ao2 = new C1124ao((ViewGroup) viewInflate, this.f4300g);
            if (getChildType(i, i2) == 1) {
                int paddingLeft = viewInflate.getPaddingLeft();
                int paddingTop = viewInflate.getPaddingTop();
                int paddingRight = viewInflate.getPaddingRight();
                int paddingBottom = viewInflate.getPaddingBottom();
                viewInflate.setBackgroundResource(R.drawable.listview_selector_highlight);
                viewInflate.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
            if (!this.f4305l && this.f4307n && c1106c.m7046a().startsWith("0999")) {
                c1124ao2.f4330b.setOnClickListener(this.f4295K);
                view = viewInflate;
                c1124ao = c1124ao2;
            } else {
                view = viewInflate;
                c1124ao = c1124ao2;
            }
        } else {
            c1124ao = (C1124ao) view.getTag();
        }
        if (c1106c.m7046a() != null && c1124ao != null && c1124ao.f4330b != null) {
            c1124ao.f4330b.setTag(c1106c);
            if (getChildType(i, i2) != 1) {
                c1124ao.f4342n.setVisibility(8);
                if (this.f4318y == 1000 && this.f4285A && c1106c.m7045H()) {
                    c1124ao.f4342n.setVisibility(0);
                }
            }
            c1124ao.f4335g.setVisibility(0);
            if (this.f4305l) {
                if (c1106c.m7046a().startsWith("0999") || c1106c.m7046a().equals(this.f4300g.getResources().getString(R.string.setting_interaction_me)) || (this.f4318y != 1000 && this.f4318y != 1 && c1106c.m7074w())) {
                    c1124ao.f4329a.setVisibility(4);
                    if ((c1106c.m7046a().equals(this.f4300g.getResources().getString(R.string.setting_interaction_me)) || c1106c.m7046a().startsWith("0999") || (this.f4318y != 1000 && this.f4318y != 1 && c1106c.m7074w())) && !c1106c.m7046a().equals(this.f4300g.getResources().getString(R.string.setting_interaction_me)) && c1106c.m7046a().startsWith("0999")) {
                    }
                } else {
                    c1124ao.f4329a.setVisibility(0);
                    if (this.f4314u != null) {
                        c1124ao.f4329a.setOnClickListener(new ViewOnClickListenerC1114ae(this, c1106c));
                    }
                    c1124ao.f4329a.setChecked(this.f4298e.m19639a(c1106c.m7046a()));
                    if (c1106c.m7074w()) {
                        c1124ao.f4329a.setChecked(this.f4298e.m19640a(c1106c.m7076y().keySet()));
                    }
                }
            } else {
                if (c1106c.m7046a().startsWith("0999") || (this.f4318y != 1000 && this.f4318y != 1)) {
                    c1124ao.f4330b.setOnClickListener(this.f4295K);
                }
                c1124ao.f4329a.setVisibility(4);
            }
            String strM7040C = c1106c.m7040C();
            if (c1124ao.f4334f != null) {
                if (this.f4313t != null && "unknown_buddy".equals(strM7040C)) {
                    c1124ao.f4335g.setVisibility(0);
                    c1124ao.f4329a.setVisibility(8);
                    c1124ao.f4334f.setVisibility(0);
                    c1124ao.f4334f.setOnClickListener(new ViewOnClickListenerC1115af(this, c1106c));
                } else {
                    c1124ao.f4334f.setVisibility(8);
                }
                if (C4809aa.m18104a().m18121a("chaton_id", "").compareTo(c1106c.m7046a()) == 0) {
                    c1124ao.f4334f.setVisibility(8);
                    c1124ao.f4335g.setVisibility(8);
                }
            }
            if (c1106c.m7074w()) {
                C2496n.m10777b(c1124ao.f4330b, c1106c.m7051b(), EnumC2498p.ROUND);
                c1124ao.f4330b.setBackgroundResource(R.drawable.circle_background);
            } else if (c1106c.m7046a().equals(this.f4300g.getResources().getString(R.string.setting_interaction_me))) {
                C2496n.m10763a(c1124ao.f4330b, EnumC2498p.ROUND);
                c1124ao.f4330b.setBackgroundResource(R.drawable.circle_background);
            } else if (!c1106c.m7046a().startsWith("0999") && c1106c.m7043F() != null && c1106c.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
                C2496n.m10784c(c1124ao.f4330b, c1106c.m7046a(), EnumC2498p.SQUARE);
                c1124ao.f4330b.setBackgroundResource(R.drawable.frame_background);
            } else {
                C2496n.m10765a(c1124ao.f4330b, c1106c.m7046a(), EnumC2498p.ROUND);
                c1124ao.f4330b.setBackgroundResource(R.drawable.circle_background);
            }
            if (c1106c.m7074w()) {
                int size = 0;
                if (c1106c.m7076y() != null) {
                    size = c1106c.m7076y().size();
                }
                c1124ao.f4331c.setEllipsize(TextUtils.TruncateAt.END);
                c1124ao.f4331c.setText(c1106c.m7051b() + " (" + size + ")", TextView.BufferType.SPANNABLE);
            } else {
                c1124ao.f4331c.setEllipsize(TextUtils.TruncateAt.END);
                c1124ao.f4331c.setText(c1106c.m7051b(), TextView.BufferType.SPANNABLE);
            }
            String strM7054c = c1106c.m7054c();
            if (c1106c.m7074w()) {
                if (c1106c.m7076y() != null) {
                    Iterator<String> it = c1106c.m7076y().keySet().iterator();
                    StringBuffer stringBuffer = new StringBuffer();
                    while (it.hasNext()) {
                        stringBuffer.append(c1106c.m7076y().get(it.next()) + ", ");
                        if (new Paint().measureText(stringBuffer.toString()) > this.f4294J) {
                            break;
                        }
                    }
                    strM7054c = stringBuffer.toString();
                    if (strM7054c.endsWith(", ")) {
                        strM7054c = strM7054c.substring(0, strM7054c.length() - 2);
                    }
                } else {
                    strM7054c = "";
                }
            } else if (strM7054c == null || strM7054c.trim().length() == 0) {
                strM7054c = "";
            }
            c1124ao.f4332d.setText(strM7054c);
            if (c1106c.m7063l()) {
                c1124ao.f4332d.setTextColor(this.f4300g.getResources().getColor(R.color.buddy_list_item_status_highlight));
            } else if (c1106c.m7072u()) {
                c1124ao.f4332d.setTextColor(this.f4300g.getResources().getColor(R.color.buddy_list_item_status_changed));
            } else {
                c1124ao.f4332d.setTextColor(this.f4292H.getColorStateList(this.f4292H.getIndex(0)).getDefaultColor());
            }
            if (this.f4312s.mo6597b(c1106c)) {
                c1124ao.f4333e.setEnabled(true);
                if (c1106c.m7063l()) {
                    c1124ao.f4331c.setTextColor(this.f4300g.getResources().getColor(R.color.buddy_list_item_name_highlight));
                } else {
                    c1124ao.f4331c.setTextColor(this.f4300g.getResources().getColor(R.color.buddy_list_item_name));
                }
            } else {
                c1124ao.f4333e.setEnabled(false);
                c1124ao.f4331c.setTextColor(this.f4300g.getResources().getColor(R.color.gray));
            }
            if (c1106c.m7074w()) {
                c1124ao.f4332d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (this.f4300g == null || !this.f4293I || !c1106c.m7074w() || c1106c.m7042E() != -1) {
                c1124ao.f4332d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (this.f4293I) {
                if (this.f4318y == 1000) {
                    if (this.f4319z != null && this.f4319z.equals("voip")) {
                        if (c1106c.m7074w()) {
                            if (c1106c.m7042E() != -1) {
                                if (c1106c.m7042E() != 1) {
                                    c1124ao.f4337i.setVisibility(8);
                                } else {
                                    c1124ao.f4337i.setVisibility(0);
                                    c1124ao.f4332d.setCompoundDrawablesWithIntrinsicBounds(GlobalApplication.m10283b().getDrawable(R.drawable.buddies_videocall), (Drawable) null, (Drawable) null, (Drawable) null);
                                    c1124ao.f4332d.setCompoundDrawablePadding(m7116a(7.0f));
                                }
                            }
                        } else if (BuddyFragment.m6463b(c1106c.m7046a()) || m7115h(c1106c.m7046a())) {
                            c1124ao.f4337i.setVisibility(0);
                            c1124ao.f4332d.setCompoundDrawablesWithIntrinsicBounds(GlobalApplication.m10283b().getDrawable(R.drawable.buddies_videocall), (Drawable) null, (Drawable) null, (Drawable) null);
                            c1124ao.f4332d.setCompoundDrawablePadding(m7116a(7.0f));
                        } else {
                            c1124ao.f4337i.setVisibility(8);
                        }
                    } else {
                        c1124ao.f4337i.setVisibility(8);
                    }
                } else if (c1106c.m7074w()) {
                    if (c1106c.m7042E() != -1) {
                        if (c1106c.m7042E() == 1) {
                            c1124ao.f4337i.setVisibility(0);
                            c1124ao.f4332d.setCompoundDrawablesWithIntrinsicBounds(GlobalApplication.m10283b().getDrawable(R.drawable.buddies_videocall), (Drawable) null, (Drawable) null, (Drawable) null);
                            c1124ao.f4332d.setCompoundDrawablePadding(m7116a(7.0f));
                        } else {
                            c1124ao.f4337i.setVisibility(8);
                        }
                    }
                } else if (BuddyFragment.m6463b(c1106c.m7046a()) || m7115h(c1106c.m7046a())) {
                    c1124ao.f4337i.setVisibility(0);
                    c1124ao.f4332d.setCompoundDrawablesWithIntrinsicBounds(GlobalApplication.m10283b().getDrawable(R.drawable.buddies_videocall), (Drawable) null, (Drawable) null, (Drawable) null);
                    c1124ao.f4332d.setCompoundDrawablePadding(m7116a(7.0f));
                } else {
                    c1124ao.f4337i.setVisibility(8);
                }
            } else {
                c1124ao.f4337i.setVisibility(8);
            }
            if (!c1106c.m7046a().equals(this.f4300g.getResources().getString(R.string.setting_interaction_me)) && !c1106c.m7046a().startsWith("0999") && !c1106c.m7074w() && !TextUtils.isEmpty(Integer.toString(c1106c.m7041D())) && c1106c.m7041D() == 1) {
                c1124ao.f4336h.setVisibility(0);
                c1124ao.f4332d.setCompoundDrawablesWithIntrinsicBounds(GlobalApplication.m10283b().getDrawable(R.drawable.buddies_webonly), (Drawable) null, (Drawable) null, (Drawable) null);
                c1124ao.f4332d.setCompoundDrawablePadding(m7116a(7.0f));
            } else {
                c1124ao.f4336h.setVisibility(8);
            }
            if (c1106c.m7046a().startsWith("0999") && m7127c(c1106c.m7046a())) {
                c1124ao.f4338j.setVisibility(0);
                c1124ao.f4332d.setCompoundDrawablesWithIntrinsicBounds(GlobalApplication.m10283b().getDrawable(R.drawable.buddies_like), (Drawable) null, (Drawable) null, (Drawable) null);
                c1124ao.f4332d.setCompoundDrawablePadding(m7116a(7.0f));
            } else {
                c1124ao.f4338j.setVisibility(8);
            }
            if (this.f4311r != null && this.f4311r.length() > 0) {
                if (C4828at.m18276a().m18291c(c1124ao.f4331c.getText().toString().toLowerCase())) {
                    this.f4286B = C4828at.m18276a().m18290a(c1124ao.f4331c.getText().toString());
                    C4828at.m18276a();
                    C4828at.m18282a(this.f4286B, this.f4311r.toString().toLowerCase());
                    this.f4287C = new ArrayList<>();
                    String string = c1124ao.f4331c.getText().toString();
                    C4828at.m18276a();
                    String strSubstring = string.substring(C4828at.m18288d());
                    this.f4286B = C4828at.m18276a().m18290a(strSubstring);
                    this.f4287C.add(c1124ao.f4331c.getText().toString().replace(strSubstring, ""));
                    C4828at.m18276a();
                    if (C4828at.m18283b() != -1) {
                        Spannable spannable = (Spannable) c1124ao.f4331c.getText();
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(GlobalApplication.m10283b().getColor(R.color.buddy_list_item_status_highlight));
                        C4828at.m18276a();
                        int iM18283b = C4828at.m18283b();
                        C4828at.m18276a();
                        int iM18288d = iM18283b + C4828at.m18288d();
                        C4828at.m18276a();
                        int iM18287c = C4828at.m18287c();
                        C4828at.m18276a();
                        spannable.setSpan(foregroundColorSpan, iM18288d, iM18287c + C4828at.m18288d() + 1, 33);
                        c1124ao.f4331c.setText(spannable);
                        C4828at.m18276a();
                        C4828at.m18289e();
                    }
                } else {
                    int iM18499b = 0;
                    int iIndexOf = c1124ao.f4331c.getText().toString().toLowerCase().indexOf(this.f4311r.toString().toLowerCase());
                    Spannable spannable2 = (Spannable) c1124ao.f4331c.getText();
                    if (iIndexOf >= 0) {
                        iM18499b = c1124ao.f4331c.getText().toString().toLowerCase().indexOf(this.f4311r.toString().toLowerCase()) + this.f4311r.length();
                        int iM18312a = C4840be.m18312a(spannable2.charAt(iIndexOf));
                        int iM18312a2 = C4840be.m18312a(spannable2.charAt(iM18499b - 1));
                        if (iM18312a >= 1 && iM18312a <= 10) {
                            iIndexOf -= C4840be.m18313a(spannable2.toString(), iIndexOf);
                        }
                        if (iM18312a2 >= 1 && iM18312a2 <= 10) {
                            iM18499b += C4840be.m18314a(spannable2.toString(), iM18499b - 1, spannable2.length());
                        }
                    } else if (iIndexOf == -1) {
                        C4872cj c4872cjM18264a = C4827as.m18264a(c1124ao.f4331c.getText().toString().toLowerCase(), this.f4311r.toString().toLowerCase(), "");
                        if (c4872cjM18264a != null && c4872cjM18264a.m18498a() != -1 && c4872cjM18264a.m18499b() != -1) {
                            iIndexOf = c4872cjM18264a.m18498a();
                            iM18499b = c4872cjM18264a.m18499b() + 1;
                        } else {
                            iIndexOf = 0;
                            iM18499b = 0;
                        }
                    }
                    spannable2.setSpan(new ForegroundColorSpan(GlobalApplication.m10283b().getColor(R.color.buddy_list_item_status_highlight)), iIndexOf, iM18499b, 33);
                    c1124ao.f4331c.setText(spannable2);
                }
            }
            try {
                if (MultiWindowManager.isMultiWindowServiceEnabled(this.f4300g)) {
                    view.setOnDragListener(new ViewOnDragListenerC1116ag(this, c1106c));
                }
            } catch (NullPointerException e) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("MultiWindowManager null pointer exception occured", C1113ad.class.getSimpleName());
                }
            }
            view.setTag(c1124ao);
        }
        return view;
    }

    /* renamed from: h */
    private boolean m7115h(String str) {
        return str.compareTo(this.f4300g.getResources().getString(R.string.setting_interaction_me)) == 0 && m7112d();
    }

    /* renamed from: d */
    private boolean m7112d() {
        try {
            return new C0416a().m1495d(GlobalApplication.m18732r());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public void m7117a() {
        if (this.f4298e != null) {
            this.f4298e = null;
        }
        this.f4300g.getContentResolver().unregisterContentObserver(this.f4296c);
        this.f4290F = null;
    }

    /* renamed from: c */
    public boolean m7127c(String str) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static View m7107b(Context context, CheckBox checkBox, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) ((CommonApplication.m18732r().getResources().getDisplayMetrics().density * 44.0f) + 0.5f), -1);
        layoutParams.gravity = 117;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(21);
        linearLayout.setOrientation(1);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        checkBox.setLayoutParams(layoutParams2);
        checkBox.setVisibility(8);
        imageView4.setLayoutParams(layoutParams2);
        imageView4.setImageResource(R.drawable.list_ic_add);
        imageView4.setBackgroundResource(R.drawable.actionbar_item_background);
        imageView4.setOnTouchListener(new ViewOnTouchListenerC1118ai());
        imageView4.setVisibility(8);
        linearLayout.addView(checkBox);
        linearLayout.addView(imageView4);
        return linearLayout;
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int i) {
        if (i < this.f4308o.length) {
            return this.f4309p.get(this.f4308o[i]).intValue();
        }
        return -1;
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int i) {
        return 0;
    }

    @Override // android.widget.SectionIndexer
    public Object[] getSections() {
        return this.f4308o;
    }

    /* renamed from: b */
    public void m7124b() {
        this.f4309p = new HashMap<>();
        for (int i = 0; i < this.f4301h.size(); i++) {
            if (this.f4301h.get(i).m7030d() == 2 || this.f4301h.get(i).m7030d() == 5) {
                this.f4309p.put(this.f4301h.get(i).m7028b(), Integer.valueOf(i));
            }
        }
        this.f4308o = new String[this.f4301h.size()];
        for (int i2 = 0; i2 < this.f4301h.size(); i2++) {
            if (this.f4301h.get(i2).m7030d() == 0 || this.f4301h.get(i2).m7030d() == -1 || this.f4301h.get(i2).m7030d() == 4 || this.f4301h.get(i2).m7030d() == 7) {
                this.f4308o[i2] = "";
            } else if (this.f4301h.get(i2).m7030d() == 1) {
                this.f4308o[i2] = "★";
            } else if (this.f4301h.get(i2).m7030d() == -2) {
                this.f4308o[i2] = "";
            } else if (this.f4301h.get(i2).m7030d() == 6) {
                this.f4308o[i2] = "";
            } else if (this.f4301h.get(i2).m7030d() == 5) {
                if (C4822an.m18218a()) {
                    this.f4308o[i2] = this.f4301h.get(i2).m7028b().replace(" ", "").replace("-", "").replace(this.f4300g.getResources().getString(R.string.vcard_type_other), "").substring(0, 1);
                } else {
                    this.f4308o[i2] = this.f4301h.get(i2).m7028b().substring(0, 1);
                }
            } else {
                this.f4308o[i2] = this.f4301h.get(i2).m7028b().substring(0, 1);
            }
        }
    }

    /* renamed from: d */
    public void m7128d(String str) {
        if (str == null || str.trim().length() > 0) {
            this.f4310q = str;
            this.f4298e.invalidateViews();
        }
    }

    /* renamed from: e */
    public void m7129e(String str) {
        this.f4311r = str;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getGroupType(int i) {
        return this.f4306m ? 0 : 1;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getGroupTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildType(int i, int i2) {
        return this.f4303j.get(i).get(i2).m7063l() ? 1 : 0;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildTypeCount() {
        return 2;
    }

    /* renamed from: c */
    public ArrayList<ArrayList<C1106c>> m7126c() {
        return this.f4303j;
    }

    /* renamed from: f */
    public static void m7113f(String str) {
        if (f4284b != null) {
            f4284b.put(str, true);
        }
    }

    /* renamed from: g */
    public static void m7114g(String str) {
        if (f4284b != null) {
            f4284b.remove(str);
        }
    }

    /* renamed from: a */
    public int m7116a(float f) {
        return (int) ((CommonApplication.m18732r().getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
