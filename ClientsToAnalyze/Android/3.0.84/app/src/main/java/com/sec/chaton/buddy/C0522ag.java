package com.sec.chaton.buddy;

import android.app.ActivityManager;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.sec.multiwindow.MultiWindowManager;
import android.support.v4.util.LruCache;
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
import android.widget.RelativeLayout;
import android.widget.SectionIndexer;
import android.widget.TableRow;
import android.widget.TextView;
import com.coolots.sso.p006a.C0045a;
import com.renren.android.feed.FeedPublishRequestParam;
import com.samsung.android.sdk.look.airbutton.SlookAirButton;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p019a.C0511a;
import com.sec.chaton.buddy.p019a.C0512b;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.C1390ah;
import com.sec.chaton.plugin.C1948a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3178at;
import com.sec.chaton.util.C3180av;
import com.sec.chaton.util.C3190be;
import com.sec.chaton.util.C3205bt;
import com.sec.common.CommonApplication;
import com.sec.widget.FastScrollableExpandableListView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.ag */
/* loaded from: classes.dex */
public class C0522ag extends BaseExpandableListAdapter implements SectionIndexer {

    /* renamed from: a */
    public static LruCache<String, Bitmap> f2431a;

    /* renamed from: b */
    public static HashMap<String, Boolean> f2432b;

    /* renamed from: A */
    private ArrayList<C3180av> f2433A;

    /* renamed from: B */
    private ArrayList<String> f2434B;

    /* renamed from: F */
    private SlookAirButton.ItemSelectListener f2438F;

    /* renamed from: d */
    private FastScrollableExpandableListView f2441d;

    /* renamed from: e */
    private LayoutInflater f2442e;

    /* renamed from: f */
    private Context f2443f;

    /* renamed from: g */
    private ArrayList<C0511a> f2444g;

    /* renamed from: h */
    private int f2445h;

    /* renamed from: i */
    private ArrayList<ArrayList<C0513c>> f2446i;

    /* renamed from: j */
    private int f2447j;

    /* renamed from: k */
    private boolean f2448k;

    /* renamed from: l */
    private boolean f2449l;

    /* renamed from: m */
    private boolean f2450m;

    /* renamed from: n */
    private String[] f2451n;

    /* renamed from: o */
    private HashMap<String, Integer> f2452o;

    /* renamed from: r */
    private InterfaceC0533ar f2455r;

    /* renamed from: s */
    private InterfaceC0531ap f2456s;

    /* renamed from: t */
    private InterfaceC0532aq f2457t;

    /* renamed from: u */
    private BuddyFragment f2458u;

    /* renamed from: y */
    private int f2462y;

    /* renamed from: p */
    private String f2453p = null;

    /* renamed from: q */
    private String f2454q = null;

    /* renamed from: v */
    private Bitmap f2459v = null;

    /* renamed from: w */
    private int f2460w = -1;

    /* renamed from: x */
    private final int f2461x = 1;

    /* renamed from: C */
    private int f2435C = -1;

    /* renamed from: D */
    private int f2436D = -1;

    /* renamed from: E */
    private boolean f2437E = false;

    /* renamed from: G */
    private View.OnClickListener f2439G = new ViewOnClickListenerC0528am(this);

    /* renamed from: c */
    ContentObserver f2440c = new C0530ao(this, new Handler());

    /* renamed from: z */
    private String f2463z = "";

    /* renamed from: a */
    public void m4034a(InterfaceC0531ap interfaceC0531ap) {
        this.f2456s = interfaceC0531ap;
    }

    /* renamed from: a */
    public void m4035a(InterfaceC0532aq interfaceC0532aq) {
        this.f2457t = interfaceC0532aq;
    }

    /* renamed from: a */
    public void m4036a(InterfaceC0533ar interfaceC0533ar) {
        this.f2455r = interfaceC0533ar;
    }

    public C0522ag(FastScrollableExpandableListView fastScrollableExpandableListView, Context context, ArrayList<C0511a> arrayList, int i, ArrayList<ArrayList<C0513c>> arrayList2, int i2, boolean z, boolean z2, InterfaceC0533ar interfaceC0533ar, boolean z3, SlookAirButton.ItemSelectListener itemSelectListener) {
        this.f2441d = fastScrollableExpandableListView;
        this.f2442e = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f2443f = context;
        this.f2444g = arrayList;
        this.f2445h = i;
        this.f2446i = arrayList2;
        this.f2447j = i2;
        this.f2448k = z;
        this.f2449l = z2;
        this.f2450m = z3;
        this.f2455r = interfaceC0533ar;
        this.f2438F = itemSelectListener;
        m4030a();
        m4045e();
        if (context != null) {
            context.getContentResolver().registerContentObserver(C1390ah.f5188a, true, this.f2440c);
        }
    }

    /* renamed from: a */
    public void m4030a() {
        Bitmap bitmapM11012b;
        if (Build.VERSION.SDK_INT >= 12) {
            f2431a = new C0523ah(this, (((ActivityManager) CommonApplication.m11493l().getSystemService("activity")).getMemoryClass() * FeedPublishRequestParam.MESSAGE_TOO_LONG) / 8);
            try {
                bitmapM11012b = C3162ad.m11012b(CommonApplication.m11493l(), Uri.parse(CommonApplication.m11493l().getFilesDir().getAbsoluteFile() + "/myprofile.png_"), 250);
            } catch (IOException e) {
                m4023b("Me", BitmapFactory.decodeResource(GlobalApplication.m6451b(), R.drawable.contacts_default_01));
                bitmapM11012b = null;
            }
            if (bitmapM11012b != null) {
                m4023b("Me", bitmapM11012b);
                return;
            } else {
                m4023b("Me", BitmapFactory.decodeResource(GlobalApplication.m6451b(), R.drawable.contacts_default_01));
                return;
            }
        }
        f2431a = null;
    }

    /* renamed from: a */
    public static void m4019a(String str, Bitmap bitmap) {
        if (f2431a != null) {
            f2431a.put(str, bitmap);
        }
    }

    /* renamed from: b */
    public static void m4023b(String str, Bitmap bitmap) {
        if (m4015a(str) == null && f2431a != null) {
            f2431a.put(str, bitmap);
        }
    }

    /* renamed from: a */
    public static Bitmap m4015a(String str) {
        if (f2431a != null) {
            return f2431a.get(str);
        }
        return null;
    }

    /* renamed from: a */
    protected void m4033a(BuddyFragment buddyFragment) {
        this.f2458u = buddyFragment;
    }

    /* renamed from: a */
    public void m4031a(int i) {
        this.f2462y = i;
    }

    /* renamed from: b */
    public void m4039b(String str) {
        this.f2463z = str;
    }

    /* renamed from: a */
    public void m4037a(boolean z) {
        this.f2449l = z;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f2444g.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return this.f2446i.get(i).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        return this.f2444g.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        return this.f2446i.get(i).get(i2);
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
        return this.f2455r.mo3436b(this.f2446i.get(i).get(i2));
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        C0535at c0535at;
        if (getGroupType(i) == 0) {
            if (view == null) {
                View viewInflate = this.f2442e.inflate(this.f2445h, viewGroup, false);
                C0535at c0535at2 = new C0535at((ViewGroup) viewInflate);
                viewInflate.setTag(c0535at2);
                view = viewInflate;
                c0535at = c0535at2;
            } else {
                c0535at = (C0535at) view.getTag();
            }
            if (this.f2444g.size() > i) {
                C0511a c0511a = this.f2444g.get(i);
                c0535at.f2491a.setText(c0511a.m3954b());
                String strM3954b = c0511a.m3954b();
                if (!c0535at.f2491a.getText().equals(this.f2443f.getResources().getString(R.string.setting_interaction_me))) {
                    if (c0535at.f2491a.getText().equals(this.f2443f.getResources().getString(R.string.more_live_partner_button_name))) {
                        String[] strArrSplit = strM3954b.split(" ");
                        if (strArrSplit.length == 2 && strArrSplit[1].equalsIgnoreCase("live")) {
                            c0535at.f2491a.setText(strArrSplit[0] + " \u202a(" + this.f2444g.get(i).m3955c() + ") \u202c" + strArrSplit[1]);
                        } else {
                            c0535at.f2491a.setText(c0511a.m3954b() + " (" + this.f2444g.get(i).m3955c() + ")");
                        }
                    } else {
                        c0535at.f2491a.setText(c0511a.m3954b() + " (" + this.f2444g.get(i).m3955c() + ")");
                    }
                }
            }
            if (z) {
                c0535at.f2491a.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.list_ic_arrow_up, 0);
            } else {
                c0535at.f2491a.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.list_ic_arrow_down, 0);
            }
            if (GlobalApplication.m6456e() && this.f2462y == 1) {
                c0535at.f2494d.setVisibility(0);
                if (this.f2437E) {
                    c0535at.f2494d.setBackgroundResource(R.drawable.tablet_tw_preference_contents_list_no_arrow_left_pressed_holo_light);
                } else {
                    c0535at.f2494d.setBackgroundResource(R.drawable.tablet_tw_preference_contents_list_no_arrow_left_holo_light);
                }
            }
            view.setTag(c0535at);
            return view;
        }
        if (view == null) {
            View view2 = new View(this.f2442e.getContext());
            view2.setVisibility(8);
            return view2;
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        C0534as c0534as;
        View viewInflate;
        C0513c c0513c = this.f2446i.get(i).get(i2);
        if (view == null) {
            if (GlobalApplication.m6456e()) {
                viewInflate = this.f2442e.inflate(getChildType(i, i2) == 1 ? R.layout.list_item_common_6 : this.f2447j, viewGroup, false);
            } else {
                viewInflate = this.f2442e.inflate(getChildType(i, i2) == 1 ? R.layout.list_item_common_7 : this.f2447j, viewGroup, false);
            }
            C0534as c0534as2 = new C0534as((ViewGroup) viewInflate, this.f2443f);
            if (getChildType(i, i2) == 1) {
                c0534as2.f2486l.setPadding(viewInflate.getPaddingLeft(), viewInflate.getPaddingTop(), viewInflate.getPaddingRight(), viewInflate.getPaddingBottom());
                if (GlobalApplication.m6456e()) {
                    c0534as2.f2486l.setBackgroundResource(R.drawable.listview_selector_highlight);
                } else {
                    viewInflate.setBackgroundResource(R.drawable.listview_selector_highlight);
                }
                if (GlobalApplication.m6456e() && this.f2462y == 1) {
                    c0534as2.f2489o.setVisibility(0);
                }
            } else if (GlobalApplication.m6456e()) {
                if (this.f2462y == 1) {
                    c0534as2.f2489o.setVisibility(8);
                }
                c0534as2.f2486l.setPadding(viewInflate.getPaddingLeft(), viewInflate.getPaddingTop(), viewInflate.getPaddingRight(), viewInflate.getPaddingBottom());
                c0534as2.f2486l.setBackgroundResource(R.drawable.tablet_listview_selector);
            }
            if (!this.f2448k && this.f2450m && c0513c.m3975b().startsWith("0999")) {
                c0534as2.f2476b.setOnClickListener(this.f2439G);
                view = viewInflate;
                c0534as = c0534as2;
            } else {
                view = viewInflate;
                c0534as = c0534as2;
            }
        } else {
            c0534as = (C0534as) view.getTag();
        }
        c0534as.f2476b.setTag(c0513c);
        c0534as.f2481g.setVisibility(0);
        if (this.f2448k) {
            if (c0513c.m3975b().startsWith("0999") || c0513c.m3975b().equals(this.f2443f.getResources().getString(R.string.setting_interaction_me)) || (this.f2462y != 1000 && this.f2462y != 1 && c0513c.m3997x())) {
                c0534as.f2475a.setVisibility(4);
                if (!GlobalApplication.m6456e() && (c0513c.m3975b().equals(this.f2443f.getResources().getString(R.string.setting_interaction_me)) || c0513c.m3975b().startsWith("0999") || (this.f2462y != 1000 && this.f2462y != 1 && c0513c.m3997x()))) {
                    c0534as.f2481g.setTag(c0513c);
                    if (c0513c.m3975b().equals(this.f2443f.getResources().getString(R.string.setting_interaction_me)) || c0513c.m3975b().startsWith("0999")) {
                        c0534as.f2481g.setOnClickListener(this.f2439G);
                    }
                }
            } else {
                c0534as.f2475a.setVisibility(0);
                if (this.f2457t != null) {
                    if (!GlobalApplication.m6456e()) {
                        c0534as.f2481g.setOnClickListener(new ViewOnClickListenerC0524ai(this, c0513c));
                    }
                    c0534as.f2475a.setOnClickListener(new ViewOnClickListenerC0525aj(this, c0513c));
                }
                c0534as.f2475a.setChecked(this.f2441d.m13107a(c0513c.m3975b()));
                if (c0513c.m3997x()) {
                    c0534as.f2475a.setChecked(this.f2441d.m13108a((String[]) c0513c.m3999z().keySet().toArray(new String[0])));
                }
            }
        } else {
            if (c0513c.m3975b().startsWith("0999") || (this.f2462y != 1000 && this.f2462y != 1)) {
                c0534as.f2476b.setOnClickListener(this.f2439G);
            }
            c0534as.f2475a.setVisibility(4);
        }
        String strM3967D = c0513c.m3967D();
        if (c0534as.f2480f != null) {
            if (this.f2456s != null && "unknown_buddy".equals(strM3967D)) {
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(-2, -2);
                layoutParams.gravity = 21;
                c0534as.f2481g.setLayoutParams(layoutParams);
                c0534as.f2481g.setVisibility(0);
                c0534as.f2475a.setVisibility(8);
                c0534as.f2480f.setVisibility(0);
                c0534as.f2480f.setOnClickListener(new ViewOnClickListenerC0526ak(this, c0513c));
            } else {
                c0534as.f2480f.setVisibility(8);
            }
        }
        if (c0513c.m3997x()) {
            HashMap<String, String> mapM3999z = c0513c.m3999z();
            C0512b c0512b = new C0512b(Integer.parseInt(c0513c.m3975b()), c0513c.m3976c(), mapM3999z == null ? 0 : mapM3999z.size(), 2);
            if (c0513c.m3986m()) {
                c0534as.f2476b.setImageBitmap(C3205bt.m11177a(c0534as.f2476b.getContext(), R.drawable.contacts_default_group));
                C3205bt.m11182a(this.f2443f).m11226b(c0534as.f2476b, c0512b.m3962b());
            } else {
                if (!C3205bt.m11182a(this.f2443f).m11220a(c0512b.m3962b())) {
                    c0534as.f2476b.setImageBitmap(C3205bt.m11177a(c0534as.f2476b.getContext(), R.drawable.contacts_default_group));
                }
                C3205bt.m11182a(this.f2443f).m11226b(c0534as.f2476b, c0512b.m3962b());
            }
        } else if (c0513c.m3975b().equals(this.f2443f.getResources().getString(R.string.setting_interaction_me))) {
            C3205bt.m11182a(this.f2443f).m11231c(c0534as.f2476b, C3159aa.m10962a().m10979a("chaton_id", ""));
        } else {
            C3205bt.m11182a(this.f2443f).m11211a(c0534as.f2476b, c0513c.m3975b(), c0513c.m3994u());
        }
        if (c0513c.m3997x()) {
            int size = 0;
            if (c0513c.m3999z() != null) {
                size = c0513c.m3999z().size();
            }
            c0534as.f2477c.setEllipsize(TextUtils.TruncateAt.END);
            c0534as.f2477c.setText(c0513c.m3976c() + " (" + size + ")", TextView.BufferType.SPANNABLE);
        } else {
            c0534as.f2477c.setEllipsize(TextUtils.TruncateAt.END);
            c0534as.f2477c.setText(c0513c.m3976c(), TextView.BufferType.SPANNABLE);
        }
        String strM3977d = c0513c.m3977d();
        if (c0513c.m3997x()) {
            if (c0513c.m3999z() != null) {
                Iterator<String> it = c0513c.m3999z().keySet().iterator();
                StringBuffer stringBuffer = new StringBuffer();
                while (it.hasNext()) {
                    stringBuffer.append(c0513c.m3999z().get(it.next()) + ", ");
                }
                strM3977d = stringBuffer.toString();
                if (strM3977d.endsWith(", ")) {
                    strM3977d = strM3977d.substring(0, strM3977d.length() - 2);
                }
            } else {
                strM3977d = "";
            }
        } else if (strM3977d == null || strM3977d.trim().length() == 0) {
            strM3977d = "";
        }
        c0534as.f2478d.setText(strM3977d);
        if (c0513c.m3986m()) {
            c0534as.f2478d.setTextColor(this.f2443f.getResources().getColor(R.color.buddy_list_item_status_highlight));
        } else if (c0513c.m3995v()) {
            c0534as.f2478d.setTextColor(this.f2443f.getResources().getColor(R.color.buddy_list_item_status_changed));
        }
        if (this.f2455r.mo3436b(c0513c)) {
            c0534as.f2479e.setEnabled(true);
            if (c0513c.m3986m()) {
                c0534as.f2477c.setTextColor(this.f2443f.getResources().getColor(R.color.buddy_list_item_name_highlight));
            } else {
                c0534as.f2477c.setTextColor(this.f2443f.getResources().getColor(R.color.buddy_list_item_name));
            }
        } else {
            c0534as.f2479e.setEnabled(false);
            c0534as.f2477c.setTextColor(this.f2443f.getResources().getColor(R.color.gray));
        }
        if (GlobalApplication.m6456e()) {
            c0534as.f2482h.setVisibility(0);
        }
        if (!c0513c.m3997x() || c0513c.m3969F() != -1) {
            c0534as.f2478d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (C1948a.m7903a(GlobalApplication.m11493l())) {
            if (this.f2462y == 1000) {
                if (this.f2463z != null && this.f2463z.equals("voip")) {
                    if (c0513c.m3997x()) {
                        if (c0513c.m3969F() != -1) {
                            if (c0513c.m3969F() == 1) {
                                c0534as.f2484j.setVisibility(0);
                                if (!GlobalApplication.m6456e()) {
                                    c0534as.f2478d.setCompoundDrawablesWithIntrinsicBounds(GlobalApplication.m6451b().getDrawable(R.drawable.buddies_videocall), (Drawable) null, (Drawable) null, (Drawable) null);
                                    c0534as.f2478d.setCompoundDrawablePadding(m4029a(7.0f));
                                }
                            } else {
                                c0534as.f2484j.setVisibility(8);
                                c0534as.f2478d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                            }
                        }
                    } else if (BuddyFragment.m3357b(c0513c.m3975b()) || m4028h(c0513c.m3975b())) {
                        c0534as.f2484j.setVisibility(0);
                        if (!GlobalApplication.m6456e()) {
                            c0534as.f2478d.setCompoundDrawablesWithIntrinsicBounds(GlobalApplication.m6451b().getDrawable(R.drawable.buddies_videocall), (Drawable) null, (Drawable) null, (Drawable) null);
                            c0534as.f2478d.setCompoundDrawablePadding(m4029a(7.0f));
                        }
                    } else {
                        c0534as.f2484j.setVisibility(8);
                        c0534as.f2478d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                } else {
                    c0534as.f2484j.setVisibility(8);
                    c0534as.f2478d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
            } else if (c0513c.m3997x()) {
                if (c0513c.m3969F() != -1) {
                    if (c0513c.m3969F() == 1) {
                        c0534as.f2484j.setVisibility(0);
                        if (!GlobalApplication.m6456e()) {
                            c0534as.f2478d.setCompoundDrawablesWithIntrinsicBounds(GlobalApplication.m6451b().getDrawable(R.drawable.buddies_videocall), (Drawable) null, (Drawable) null, (Drawable) null);
                            c0534as.f2478d.setCompoundDrawablePadding(m4029a(7.0f));
                        }
                    } else {
                        c0534as.f2484j.setVisibility(8);
                        c0534as.f2478d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            } else if (BuddyFragment.m3357b(c0513c.m3975b()) || m4028h(c0513c.m3975b())) {
                c0534as.f2484j.setVisibility(0);
                if (!GlobalApplication.m6456e()) {
                    c0534as.f2478d.setCompoundDrawablesWithIntrinsicBounds(GlobalApplication.m6451b().getDrawable(R.drawable.buddies_videocall), (Drawable) null, (Drawable) null, (Drawable) null);
                    c0534as.f2478d.setCompoundDrawablePadding(m4029a(7.0f));
                }
            } else {
                c0534as.f2484j.setVisibility(8);
                c0534as.f2478d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
        } else {
            c0534as.f2484j.setVisibility(8);
            c0534as.f2478d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (!c0513c.m3975b().equals(this.f2443f.getResources().getString(R.string.setting_interaction_me)) && !c0513c.m3975b().startsWith("0999") && !c0513c.m3997x() && !TextUtils.isEmpty(Integer.toString(c0513c.m3968E())) && c0513c.m3968E() == 1) {
            c0534as.f2483i.setVisibility(0);
            if (!GlobalApplication.m6456e()) {
                c0534as.f2478d.setCompoundDrawablesWithIntrinsicBounds(GlobalApplication.m6451b().getDrawable(R.drawable.buddies_webonly), (Drawable) null, (Drawable) null, (Drawable) null);
                c0534as.f2478d.setCompoundDrawablePadding(m4029a(7.0f));
            }
        } else {
            c0534as.f2483i.setVisibility(8);
        }
        if (c0513c.m3975b().startsWith("0999") && m4042c(c0513c.m3975b())) {
            c0534as.f2485k.setVisibility(0);
            if (!GlobalApplication.m6456e()) {
                c0534as.f2478d.setCompoundDrawablesWithIntrinsicBounds(GlobalApplication.m6451b().getDrawable(R.drawable.buddies_like), (Drawable) null, (Drawable) null, (Drawable) null);
                c0534as.f2478d.setCompoundDrawablePadding(m4029a(7.0f));
            }
        } else {
            c0534as.f2485k.setVisibility(8);
        }
        if (this.f2454q != null && this.f2454q.length() > 0) {
            if (C3178at.m11103a().m11118c(c0534as.f2477c.getText().toString().toLowerCase())) {
                this.f2433A = C3178at.m11103a().m11117a(c0534as.f2477c.getText().toString());
                C3178at.m11103a();
                C3178at.m11109a(this.f2433A, this.f2454q.toString().toLowerCase());
                this.f2434B = new ArrayList<>();
                String string = c0534as.f2477c.getText().toString();
                C3178at.m11103a();
                String strSubstring = string.substring(C3178at.m11115d());
                this.f2433A = C3178at.m11103a().m11117a(strSubstring);
                this.f2434B.add(c0534as.f2477c.getText().toString().replace(strSubstring, ""));
                C3178at.m11103a();
                if (C3178at.m11110b() != -1) {
                    Spannable spannable = (Spannable) c0534as.f2477c.getText();
                    ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(GlobalApplication.m6451b().getColor(R.color.buddy_list_item_status_highlight));
                    C3178at.m11103a();
                    int iM11110b = C3178at.m11110b();
                    C3178at.m11103a();
                    int iM11115d = iM11110b + C3178at.m11115d();
                    C3178at.m11103a();
                    int iM11114c = C3178at.m11114c();
                    C3178at.m11103a();
                    spannable.setSpan(foregroundColorSpan, iM11115d, iM11114c + C3178at.m11115d() + 1, 33);
                    c0534as.f2477c.setText(spannable);
                    C3178at.m11103a();
                    C3178at.m11116e();
                }
            } else {
                int iIndexOf = c0534as.f2477c.getText().toString().toLowerCase().indexOf(this.f2454q.toString().toLowerCase());
                if (iIndexOf >= 0) {
                    int length = this.f2454q.length() + c0534as.f2477c.getText().toString().toLowerCase().indexOf(this.f2454q.toString().toLowerCase());
                    Spannable spannable2 = (Spannable) c0534as.f2477c.getText();
                    int iM11138a = C3190be.m11138a(spannable2.charAt(iIndexOf));
                    int iM11138a2 = C3190be.m11138a(spannable2.charAt(length - 1));
                    if (iM11138a >= 1 && iM11138a <= 10) {
                        iIndexOf -= C3190be.m11139a(spannable2.toString(), iIndexOf);
                    }
                    if (iM11138a2 >= 1 && iM11138a2 <= 10) {
                        length += C3190be.m11140a(spannable2.toString(), length - 1, spannable2.length());
                    }
                    spannable2.setSpan(new ForegroundColorSpan(GlobalApplication.m6451b().getColor(R.color.buddy_list_item_status_highlight)), iIndexOf, length, 33);
                    c0534as.f2477c.setText(spannable2);
                }
            }
        }
        if (GlobalApplication.m6456e() && this.f2462y == 1) {
            c0534as.f2489o.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
            if (this.f2435C == i && this.f2436D == i2) {
                if (this.f2437E) {
                    c0534as.f2488n.setBackgroundResource(R.drawable.tablet_tw_preference_contents_list_arrow_pressed_holo_light);
                } else {
                    c0534as.f2488n.setBackgroundResource(R.drawable.tablet_tw_preference_contents_list_arrow_holo_light);
                }
                c0534as.f2488n.setLayoutParams(layoutParams2);
                c0534as.f2488n.setVisibility(0);
                c0534as.f2489o.setVisibility(8);
            } else {
                if (this.f2437E) {
                    c0534as.f2489o.setBackgroundResource(R.drawable.tablet_tw_preference_contents_list_no_arrow_left_pressed_holo_light);
                } else {
                    c0534as.f2489o.setBackgroundResource(R.drawable.tablet_tw_preference_contents_list_no_arrow_left_holo_light);
                }
                c0534as.f2488n.setVisibility(8);
                c0534as.f2489o.setLayoutParams(layoutParams2);
                c0534as.f2489o.setVisibility(0);
            }
        }
        if (MultiWindowManager.isMultiWindowServiceEnabled(this.f2443f)) {
            view.setOnDragListener(new ViewOnDragListenerC0527al(this, c0513c));
        }
        view.setTag(c0534as);
        return view;
    }

    /* renamed from: h */
    private boolean m4028h(String str) {
        return str.compareTo(this.f2443f.getResources().getString(R.string.setting_interaction_me)) == 0 && m4026f();
    }

    /* renamed from: f */
    private boolean m4026f() {
        try {
            return new C0045a().m55d(GlobalApplication.m11493l());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    public void m4038b() {
        if (this.f2441d != null) {
            this.f2441d = null;
        }
        this.f2443f.getContentResolver().unregisterContentObserver(this.f2440c);
        this.f2438F = null;
    }

    /* renamed from: c */
    public boolean m4042c(String str) {
        return f2432b.get(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static View m4020b(Context context, CheckBox checkBox, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) ((CommonApplication.m11493l().getResources().getDisplayMetrics().density * 44.0f) + 0.5f), -1);
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
        imageView4.setOnTouchListener(new ViewOnTouchListenerC0529an());
        imageView4.setVisibility(8);
        linearLayout.addView(checkBox);
        linearLayout.addView(imageView4);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static View m4021b(Context context, ImageView imageView, ImageView imageView2, ImageView imageView3) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        if (GlobalApplication.m6456e()) {
            linearLayout.setPadding(0, 0, (int) ((CommonApplication.m11493l().getResources().getDisplayMetrics().density * 14.0f) + 0.5f), 0);
        }
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setGravity(21);
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundResource(R.drawable.buddies_webonly);
        imageView.setVisibility(8);
        imageView2.setLayoutParams(layoutParams);
        imageView2.setBackgroundResource(R.drawable.buddies_videocall);
        imageView2.setVisibility(8);
        imageView3.setLayoutParams(layoutParams);
        imageView3.setBackgroundResource(R.drawable.buddies_like);
        imageView3.setVisibility(8);
        linearLayout2.addView(imageView);
        linearLayout2.addView(imageView2);
        linearLayout2.addView(imageView3);
        linearLayout.addView(linearLayout2);
        return linearLayout;
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int i) {
        if (i < this.f2451n.length) {
            return this.f2452o.get(this.f2451n[i]).intValue();
        }
        return -1;
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int i) {
        return 0;
    }

    @Override // android.widget.SectionIndexer
    public Object[] getSections() {
        return this.f2451n;
    }

    /* renamed from: c */
    public void m4041c() {
        this.f2452o = new HashMap<>();
        for (int i = 0; i < this.f2444g.size(); i++) {
            if (this.f2444g.get(i).m3956d() == 2) {
                this.f2452o.put(this.f2444g.get(i).m3954b(), Integer.valueOf(i));
            }
        }
        this.f2451n = new String[this.f2444g.size()];
        for (int i2 = 0; i2 < this.f2444g.size(); i2++) {
            if (this.f2444g.get(i2).m3956d() == 0 || this.f2444g.get(i2).m3956d() == -1 || this.f2444g.get(i2).m3956d() == 4 || this.f2444g.get(i2).m3956d() == 7) {
                this.f2451n[i2] = "";
            } else if (this.f2444g.get(i2).m3956d() == 1) {
                this.f2451n[i2] = "★";
            } else if (this.f2444g.get(i2).m3956d() == -2) {
                this.f2451n[i2] = "";
            } else if (this.f2444g.get(i2).m3956d() == 6) {
                this.f2451n[i2] = "";
            } else {
                this.f2451n[i2] = this.f2444g.get(i2).m3954b().substring(0, 1);
            }
        }
    }

    /* renamed from: d */
    public void m4044d(String str) {
        if (str == null || str.trim().length() > 0) {
            this.f2453p = str;
            this.f2441d.invalidateViews();
        }
    }

    /* renamed from: a */
    public void m4032a(int i, int i2) {
        this.f2435C = i;
        this.f2436D = i2;
        this.f2441d.invalidateViews();
    }

    /* renamed from: e */
    public void m4046e(String str) {
        this.f2454q = str;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getGroupType(int i) {
        return this.f2449l ? 0 : 1;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getGroupTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildType(int i, int i2) {
        return this.f2446i.get(i).get(i2).m3986m() ? 1 : 0;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildTypeCount() {
        return 2;
    }

    /* renamed from: d */
    public ArrayList<ArrayList<C0513c>> m4043d() {
        return this.f2446i;
    }

    /* renamed from: e */
    public void m4045e() {
        Cursor cursorQuery;
        Cursor cursor = null;
        f2432b = new HashMap<>();
        try {
            cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1390ah.f5188a, null, "islike = 'Y'", null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() != 0) {
                        cursorQuery.moveToFirst();
                        do {
                            f2432b.put(cursorQuery.getString(cursorQuery.getColumnIndex("buddy_no")), true);
                        } while (cursorQuery.moveToNext());
                    }
                } catch (Exception e) {
                    if (cursorQuery == null) {
                        return;
                    }
                    cursorQuery.close();
                } catch (Throwable th) {
                    cursor = cursorQuery;
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery == null) {
                return;
            }
        } catch (Exception e2) {
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
        }
        cursorQuery.close();
    }

    /* renamed from: f */
    public static void m4025f(String str) {
        if (f2432b != null) {
            f2432b.put(str, true);
        }
    }

    /* renamed from: g */
    public static void m4027g(String str) {
        if (f2432b != null) {
            f2432b.remove(str);
        }
    }

    /* renamed from: b */
    public void m4040b(boolean z) {
        this.f2437E = z;
    }

    /* renamed from: a */
    public int m4029a(float f) {
        return (int) ((CommonApplication.m11493l().getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
