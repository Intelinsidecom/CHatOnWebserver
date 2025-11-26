package com.sec.chaton.buddy;

import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p010a.C0255a;
import com.sec.chaton.buddy.p010a.C0256b;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.C0632d;
import com.sec.chaton.p017e.C0704s;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1791w;
import com.sec.chaton.widget.C1805i;
import com.sec.widget.ChoicePanel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.r */
/* loaded from: classes.dex */
public class C0442r extends BaseExpandableListAdapter implements SectionIndexer {

    /* renamed from: C */
    private ChoicePanel f1664C;

    /* renamed from: d */
    private ExpandableListView f1669d;

    /* renamed from: e */
    private LayoutInflater f1670e;

    /* renamed from: f */
    private Context f1671f;

    /* renamed from: g */
    private ArrayList f1672g;

    /* renamed from: h */
    private int f1673h;

    /* renamed from: i */
    private ArrayList f1674i;

    /* renamed from: j */
    private int f1675j;

    /* renamed from: k */
    private boolean f1676k;

    /* renamed from: l */
    private int f1677l;

    /* renamed from: m */
    private int f1678m;

    /* renamed from: n */
    private String[] f1679n;

    /* renamed from: o */
    private HashMap f1680o;

    /* renamed from: p */
    private LinearLayout f1681p;

    /* renamed from: q */
    private Menu f1682q;

    /* renamed from: r */
    private Bundle f1683r;

    /* renamed from: u */
    private EnumC0448x f1686u;

    /* renamed from: v */
    private BuddyFragment f1687v;

    /* renamed from: w */
    private ProgressDialog f1688w;

    /* renamed from: x */
    private String f1689x;

    /* renamed from: y */
    private String f1690y;

    /* renamed from: s */
    private String f1684s = null;

    /* renamed from: t */
    private String f1685t = null;

    /* renamed from: a */
    C0449y f1666a = null;

    /* renamed from: b */
    C0632d f1667b = null;

    /* renamed from: z */
    private View.OnClickListener f1691z = new ViewOnClickListenerC0443s(this);

    /* renamed from: A */
    private View.OnClickListener f1662A = new ViewOnClickListenerC0444t(this);

    /* renamed from: B */
    private View.OnClickListener f1663B = new ViewOnClickListenerC0445u(this);

    /* renamed from: c */
    Handler f1668c = new HandlerC0446v(this);

    /* renamed from: D */
    private View.OnClickListener f1665D = new ViewOnClickListenerC0447w(this);

    public C0442r(ExpandableListView expandableListView, Context context, ArrayList arrayList, int i, ArrayList arrayList2, int i2, boolean z, int i3, LinearLayout linearLayout, Menu menu, int i4, TextView textView, Bundle bundle, BuddyFragment buddyFragment) {
        this.f1687v = null;
        this.f1688w = null;
        this.f1669d = expandableListView;
        this.f1670e = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f1671f = context;
        this.f1672g = arrayList;
        this.f1673h = i;
        this.f1674i = arrayList2;
        this.f1675j = i2;
        this.f1676k = z;
        this.f1677l = i3;
        this.f1678m = i4;
        this.f1681p = linearLayout;
        this.f1682q = menu;
        this.f1683r = bundle;
        this.f1687v = buddyFragment;
        this.f1688w = (ProgressDialog) new C1805i(this.f1671f).m6139a(R.string.dialog_connecting_server);
    }

    /* renamed from: a */
    public void m2451a(int i) {
        this.f1677l = i;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f1672g.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return ((ArrayList) this.f1674i.get(i)).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        return this.f1672g.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        return ((ArrayList) this.f1674i.get(i)).get(i2);
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
        return this.f1687v.m2038a((C0257c) ((ArrayList) this.f1674i.get(i)).get(i2));
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        C0450z c0450z;
        if (view == null) {
            View viewInflate = this.f1670e.inflate(this.f1673h, viewGroup, false);
            C0450z c0450z2 = new C0450z((LinearLayout) viewInflate);
            viewInflate.setTag(c0450z2);
            view = viewInflate;
            c0450z = c0450z2;
        } else {
            c0450z = (C0450z) view.getTag();
        }
        if (this.f1677l == 21) {
            c0450z.m2466a(8);
            view.setLayoutParams(new AbsListView.LayoutParams(0, 0));
            view.setBackgroundResource(0);
        } else {
            c0450z.m2466a(0);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, 40));
            view.setBackgroundResource(R.drawable.buddy_group_background);
            c0450z.f1716a.setText(((C0255a) this.f1672g.get(i)).m2307b() + " (" + ((C0255a) this.f1672g.get(i)).m2308c() + ")");
            if (GlobalApplication.m3265f()) {
                if (z) {
                    if (this.f1676k) {
                        c0450z.f1718c.setBackgroundResource(R.drawable.buddy_arrow_down);
                    } else {
                        c0450z.f1718c.setBackgroundResource(R.drawable.title_arrow_up);
                    }
                } else {
                    c0450z.f1718c.setBackgroundResource(R.drawable.title_arrow_down);
                }
                if (this.f1678m == 6) {
                    c0450z.f1718c.setVisibility(4);
                }
            } else if (z) {
                c0450z.f1718c.setBackgroundResource(R.drawable.messenger_subtitle_icon_up);
            } else {
                c0450z.f1718c.setBackgroundResource(R.drawable.messenger_subtitle_icon_down);
            }
            if (this.f1678m == 6) {
                view.setBackgroundDrawable(this.f1671f.getResources().getDrawable(R.drawable.buddyprofile_buddysay_title_xml));
            }
            view.setTag(c0450z);
        }
        return view;
    }

    /* renamed from: a */
    public void m2452a(ImageView imageView) {
        Bitmap bitmapM6100b;
        File absoluteFile = GlobalApplication.m3260b().getFilesDir().getAbsoluteFile();
        File file = new File(absoluteFile, "myprofile.png_");
        C1786r.m6061b("photoFile=" + file, getClass().getSimpleName());
        if (file.exists() && file.length() > 0) {
            try {
                bitmapM6100b = C1791w.m6100b(this.f1671f, Uri.parse(absoluteFile + "/myprofile.png_"), 170);
            } catch (IOException e) {
                C1786r.m6061b(e.getMessage(), getClass().getSimpleName());
                bitmapM6100b = null;
            }
            if (bitmapM6100b != null) {
                imageView.setImageBitmap(C1746bb.m5942a(bitmapM6100b));
            } else {
                imageView.setImageResource(R.drawable.co_default_image_add);
            }
        } else {
            imageView.setImageResource(R.drawable.co_default_image_add);
        }
        imageView.postInvalidate();
    }

    /* renamed from: a */
    public void m2453a(ImageView imageView, int i) {
        Bitmap bitmapM6100b;
        File absoluteFile = GlobalApplication.m3260b().getFilesDir().getAbsoluteFile();
        StringBuilder sb = new StringBuilder();
        toString();
        File file = new File(absoluteFile, sb.append(String.valueOf(i)).append("_group_profile.png_").toString());
        C1786r.m6061b("photoFile=" + file, getClass().getSimpleName());
        if (file.exists() && file.length() > 0) {
            try {
                Context context = this.f1671f;
                StringBuilder sbAppend = new StringBuilder().append(absoluteFile).append("/");
                toString();
                bitmapM6100b = C1791w.m6100b(context, Uri.parse(sbAppend.append(String.valueOf(i)).append("_group_profile.png_").toString()), 170);
            } catch (IOException e) {
                C1786r.m6061b(e.getMessage(), getClass().getSimpleName());
                bitmapM6100b = null;
            }
            if (bitmapM6100b != null) {
                imageView.setImageBitmap(C1746bb.m5942a(bitmapM6100b));
            } else {
                imageView.setImageResource(R.drawable.contacts_default_image_group);
            }
        } else {
            imageView.setImageResource(R.drawable.contacts_default_image_group);
        }
        imageView.postInvalidate();
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            View viewInflate = this.f1670e.inflate(this.f1675j, viewGroup, false);
            if (GlobalApplication.m3265f()) {
                this.f1666a = new C0449y((LinearLayout) viewInflate);
            } else {
                this.f1666a = new C0449y((RelativeLayout) viewInflate);
            }
            if (!this.f1676k) {
                this.f1666a.f1705b.setOnClickListener(this.f1691z);
            }
            if (!this.f1676k) {
                this.f1666a.f1713j.setOnClickListener(this.f1662A);
            }
            this.f1666a.f1714k.setOnClickListener(this.f1663B);
            view = viewInflate;
        } else {
            this.f1666a = (C0449y) view.getTag();
        }
        C0257c c0257c = (C0257c) ((ArrayList) this.f1674i.get(i)).get(i2);
        this.f1666a.f1705b.setTag(c0257c);
        this.f1666a.f1713j.setTag(c0257c);
        this.f1666a.f1714k.setTag(c0257c);
        C0255a c0255a = (C0255a) this.f1672g.get(i);
        if (GlobalApplication.m3265f()) {
            if (c0257c.m2350v()) {
                if (!c0257c.m2338j()) {
                    if (this.f1684s != null && c0257c.m2318a().equals(this.f1684s)) {
                        this.f1666a.f1710g.setBackgroundResource(R.drawable.buddy_item_selected_xml);
                    } else {
                        this.f1666a.f1710g.setBackgroundResource(R.drawable.buddy_item_xml);
                    }
                }
            } else if (!c0257c.m2338j()) {
                this.f1666a.f1710g.setBackgroundResource(R.drawable.buddy_item_xml);
            }
        } else if (c0257c.m2338j()) {
            this.f1666a.f1709f.setBackgroundColor(Color.parseColor("#4C91BD"));
        } else {
            this.f1666a.f1709f.setBackgroundResource(R.drawable.buddy_item_xml);
        }
        if (this.f1676k) {
            this.f1666a.f1713j.setVisibility(8);
            this.f1666a.f1714k.setVisibility(8);
            if (c0257c.m2350v()) {
                this.f1666a.f1704a.setVisibility(8);
            } else {
                this.f1666a.f1704a.setVisibility(0);
                if (c0257c.m2345q()) {
                    this.f1666a.f1704a.setChecked(true);
                } else {
                    this.f1666a.f1704a.setChecked(false);
                }
            }
        } else {
            this.f1666a.f1704a.setVisibility(8);
            if (this.f1683r != null) {
                if (this.f1683r.containsKey("ACTIVITY_TYPE") && this.f1683r.getInt("ACTIVITY_TYPE") == 101) {
                    this.f1666a.f1713j.setVisibility(8);
                    if (!this.f1687v.m2048e(c0257c.m2318a())) {
                        this.f1666a.f1714k.setVisibility(0);
                    }
                } else {
                    if (this.f1678m == 6) {
                        this.f1666a.f1713j.setVisibility(8);
                    } else {
                        this.f1666a.f1713j.setVisibility(0);
                    }
                    this.f1666a.f1714k.setVisibility(8);
                }
            } else {
                C1786r.m6061b("mBundle = null", "BuddyAdapter");
            }
        }
        if (i == 0 && !c0257c.m2350v()) {
            if (c0255a.m2307b().equals(GlobalApplication.m3260b().getString(R.string.buddy_list_group_new_buddy))) {
                if (GlobalApplication.m3265f()) {
                    this.f1666a.f1710g.setBackgroundResource(R.drawable.buddy_item_new_xml);
                } else {
                    this.f1666a.f1709f.setBackgroundResource(R.drawable.buddy_item_xml);
                }
                this.f1666a.f1707d.setTextColor(this.f1671f.getResources().getColor(R.color.ics_main_font_color_2));
                this.f1666a.f1708e.setTextColor(this.f1671f.getResources().getColor(R.color.buddy_list_item_status_highlight));
            } else {
                if (GlobalApplication.m3265f()) {
                    this.f1666a.f1710g.setBackgroundResource(R.drawable.buddy_item_xml);
                } else {
                    this.f1666a.f1709f.setBackgroundResource(R.drawable.buddy_item_xml);
                }
                this.f1666a.f1707d.setTextColor(this.f1671f.getResources().getColor(R.color.buddy_list_item_name));
                if (c0257c.m2348t() && !c0257c.m2338j()) {
                    this.f1666a.f1708e.setTextColor(this.f1671f.getResources().getColor(R.color.buddy_list_item_status_highlight));
                } else {
                    this.f1666a.f1708e.setTextColor(this.f1671f.getResources().getColor(R.color.ics_buddy_profile_status));
                }
            }
        } else {
            if (GlobalApplication.m3265f()) {
                this.f1666a.f1710g.setBackgroundResource(R.drawable.buddy_item_xml);
            } else {
                this.f1666a.f1709f.setBackgroundResource(R.drawable.buddy_item_xml);
            }
            this.f1666a.f1707d.setTextColor(this.f1671f.getResources().getColor(R.color.buddy_list_item_name));
            if (c0257c.m2348t() && !c0257c.m2338j()) {
                this.f1666a.f1708e.setTextColor(this.f1671f.getResources().getColor(R.color.buddy_list_item_status_highlight));
            } else {
                this.f1666a.f1708e.setTextColor(this.f1671f.getResources().getColor(R.color.ics_buddy_profile_status));
            }
        }
        if (c0257c.m2350v()) {
            HashMap mapM2351w = c0257c.m2351w();
            m2453a(this.f1666a.f1705b, new C0256b(Integer.parseInt(c0257c.m2318a()), c0257c.m2324b(), mapM2351w == null ? 0 : mapM2351w.size(), 2).m2313a());
        } else if (c0257c.m2318a().equals(this.f1671f.getResources().getString(R.string.setting_interaction_me))) {
            m2452a(this.f1666a.f1705b);
        } else {
            C1746bb.m5945a(this.f1671f).m5960a(this.f1666a.f1705b, c0257c.m2318a(), c0257c.m2346r());
        }
        if (this.f1666a.f1706c != null) {
            if (m2459a(c0257c.m2318a())) {
                this.f1666a.f1706c.setVisibility(0);
            } else {
                this.f1666a.f1706c.setVisibility(8);
            }
        }
        c0257c.m2320a(this.f1666a.f1705b);
        if (c0257c.m2350v()) {
            int size = 0;
            if (c0257c.m2351w() != null) {
                size = c0257c.m2351w().size();
            }
            this.f1666a.f1707d.setText(c0257c.m2324b() + " (" + size + ")");
        } else {
            this.f1666a.f1707d.setText(c0257c.m2324b());
        }
        if (this.f1676k) {
            this.f1666a.f1715l.setVisibility(8);
            this.f1666a.f1712i.setVisibility(8);
        }
        String strM2327c = c0257c.m2327c();
        if (c0257c.m2350v()) {
            if (c0257c.m2351w() != null) {
                Iterator it = c0257c.m2351w().keySet().iterator();
                StringBuffer stringBuffer = new StringBuffer();
                while (it.hasNext()) {
                    stringBuffer.append(((String) c0257c.m2351w().get(it.next())) + ", ");
                }
                C1786r.m6067f(stringBuffer.toString(), "BuddyFragment");
                strM2327c = stringBuffer.toString();
                if (strM2327c.endsWith(", ")) {
                    strM2327c = strM2327c.substring(0, strM2327c.length() - 2);
                }
            } else {
                strM2327c = "";
            }
        } else if (strM2327c == null || strM2327c.trim().length() == 0) {
            strM2327c = "";
        }
        this.f1666a.f1708e.setText(strM2327c);
        if (!GlobalApplication.m3265f()) {
            if (c0257c.m2348t()) {
                this.f1666a.f1708e.setTextColor(Color.parseColor("#F6FF00"));
            } else {
                this.f1666a.f1708e.setTextColor(Color.parseColor("#EFAD51"));
            }
        }
        if (this.f1687v != null) {
            if (this.f1687v.m2038a(c0257c)) {
                this.f1666a.f1710g.setEnabled(true);
                if (c0257c.m2338j()) {
                    this.f1666a.f1710g.setBackgroundResource(R.drawable.buddy_item_new_xml);
                    this.f1666a.f1707d.setTextColor(this.f1671f.getResources().getColor(R.color.ics_main_font_color_2));
                } else {
                    this.f1666a.f1707d.setTextColor(this.f1671f.getResources().getColor(R.color.ics_main_font_color_2));
                }
            } else {
                this.f1666a.f1710g.setEnabled(false);
                this.f1666a.f1707d.setTextColor(this.f1671f.getResources().getColor(R.color.ics_main_font_color_2));
            }
        }
        if (GlobalApplication.m3265f()) {
            if (c0257c.m2350v()) {
                if (m2463c() != null && m2463c().equals(c0257c.m2318a())) {
                    this.f1666a.f1712i.setVisibility(0);
                    this.f1666a.f1715l.setVisibility(8);
                } else {
                    this.f1666a.f1712i.setVisibility(8);
                    this.f1666a.f1715l.setVisibility(0);
                }
            } else if (!TextUtils.isEmpty(m2464d()) && m2464d().equals(c0257c.m2318a())) {
                if ((c0255a.m2309d() == 0 && this.f1686u == EnumC0448x.BIRTHDAY) || ((c0255a.m2309d() == 1 && this.f1686u == EnumC0448x.FAVOURITE) || ((c0255a.m2309d() == -1 && this.f1686u == EnumC0448x.NEWBUDDY) || ((c0255a.m2309d() == 2 && this.f1686u == EnumC0448x.ALPHA) || (c0255a.m2309d() == 7 && this.f1686u == EnumC0448x.SPECIAL_BUDDY))))) {
                    this.f1666a.f1712i.setVisibility(0);
                    this.f1666a.f1715l.setVisibility(8);
                    this.f1666a.f1707d.setTextColor(this.f1671f.getResources().getColor(R.color.buddy_list_item_status_highlight));
                    this.f1666a.f1708e.setTextColor(this.f1671f.getResources().getColor(R.color.buddy_list_item_status_highlight));
                } else {
                    this.f1666a.f1712i.setVisibility(8);
                    this.f1666a.f1715l.setVisibility(0);
                }
            } else {
                this.f1666a.f1712i.setVisibility(8);
                this.f1666a.f1715l.setVisibility(0);
            }
        }
        view.setTag(this.f1666a);
        return view;
    }

    /* renamed from: a */
    public boolean m2459a(String str) {
        boolean zEquals;
        Cursor cursorQuery = GlobalApplication.m3260b().getContentResolver().query(C0704s.f2647a, null, "buddy_no=?", new String[]{str}, null);
        if (cursorQuery == null || cursorQuery.getCount() <= 0) {
            zEquals = false;
        } else {
            cursorQuery.moveToFirst();
            zEquals = cursorQuery.getString(cursorQuery.getColumnIndex("islike")).equals("Y");
        }
        cursorQuery.close();
        return zEquals;
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int i) {
        if (i < this.f1679n.length) {
            return ((Integer) this.f1680o.get(this.f1679n[i])).intValue();
        }
        return -1;
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int i) {
        return 0;
    }

    @Override // android.widget.SectionIndexer
    public Object[] getSections() {
        return this.f1679n;
    }

    /* renamed from: a */
    public void m2450a() {
        if (this.f1677l == 11) {
            this.f1680o = new HashMap();
            for (int i = 0; i < this.f1672g.size(); i++) {
                if (((C0255a) this.f1672g.get(i)).m2309d() == 2) {
                    this.f1680o.put(((C0255a) this.f1672g.get(i)).m2307b(), Integer.valueOf(i));
                }
            }
            this.f1679n = new String[this.f1672g.size()];
            for (int i2 = 0; i2 < this.f1672g.size(); i2++) {
                if (((C0255a) this.f1672g.get(i2)).m2309d() == 0 || ((C0255a) this.f1672g.get(i2)).m2309d() == -1 || ((C0255a) this.f1672g.get(i2)).m2309d() == 4 || ((C0255a) this.f1672g.get(i2)).m2309d() == 7) {
                    this.f1679n[i2] = "";
                } else if (((C0255a) this.f1672g.get(i2)).m2309d() == 1) {
                    this.f1679n[i2] = "★";
                } else {
                    this.f1679n[i2] = ((C0255a) this.f1672g.get(i2)).m2307b().substring(0, 1);
                }
            }
        }
    }

    /* renamed from: b */
    public void m2460b() {
        m2457a((ArrayList) null);
    }

    /* renamed from: a */
    public void m2457a(ArrayList arrayList) {
        HashSet hashSet = new HashSet();
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                hashSet.add((String) it.next());
            }
        }
        Iterator it2 = this.f1674i.iterator();
        while (it2.hasNext()) {
            Iterator it3 = ((ArrayList) it2.next()).iterator();
            while (it3.hasNext()) {
                C0257c c0257c = (C0257c) it3.next();
                if (c0257c.m2345q()) {
                    hashSet.add(c0257c.m2318a());
                }
            }
        }
        if (hashSet.size() > 0) {
            if (GlobalApplication.m3265f() && this.f1678m == 2) {
                if (hashSet.size() + 1 > 199) {
                    Toast.makeText(this.f1671f, String.format(this.f1671f.getString(R.string.buddy_list_groupchat_toast_failed_exceed), 198), 0).show();
                    this.f1681p.findViewById(R.id.buddy_menu_group_chat).setEnabled(false);
                    if (GlobalApplication.m3265f()) {
                        this.f1682q.findItem(R.id.actionbar_menu_done).setVisible(true).setEnabled(false);
                    }
                } else {
                    this.f1681p.findViewById(R.id.buddy_menu_group_chat).setEnabled(true);
                    if (GlobalApplication.m3265f()) {
                        this.f1682q.findItem(R.id.actionbar_menu_done).setVisible(true).setEnabled(true);
                    }
                }
            }
            if (GlobalApplication.m3265f() && this.f1678m == 3) {
                if (hashSet.size() > 200) {
                    Toast.makeText(this.f1671f, String.format(this.f1671f.getString(R.string.buddy_list_broadcast_toast_failed_exceed), Integer.valueOf(HttpResponseCode.f7897OK)), 0).show();
                    this.f1681p.findViewById(R.id.buddy_menu_broadcast).setEnabled(false);
                    if (GlobalApplication.m3265f()) {
                        this.f1682q.findItem(R.id.actionbar_menu_done).setVisible(true).setEnabled(false);
                    }
                } else {
                    this.f1681p.findViewById(R.id.buddy_menu_broadcast).setEnabled(true);
                    if (GlobalApplication.m3265f()) {
                        this.f1682q.findItem(R.id.actionbar_menu_done).setVisible(true).setEnabled(true);
                    }
                }
            }
            if (GlobalApplication.m3265f() && this.f1678m == 5) {
                int length = this.f1683r.getStringArray(ChatFragment.f1749e).length;
                if (this.f1683r.getInt("chatType") == EnumC0695j.ONETOONE.m3146a() || this.f1683r.getInt("chatType") == EnumC0695j.GROUPCHAT.m3146a()) {
                    if (length + hashSet.size() + 1 > 199) {
                        Toast.makeText(this.f1671f, String.format(this.f1671f.getString(R.string.buddy_list_groupchat_toast_failed_exceed), 198), 0).show();
                        this.f1681p.findViewById(R.id.buddy_menu_invite).setEnabled(false);
                        if (GlobalApplication.m3265f()) {
                            this.f1682q.findItem(R.id.actionbar_menu_done).setVisible(true).setEnabled(false);
                        }
                    } else {
                        this.f1681p.findViewById(R.id.buddy_menu_invite).setEnabled(true);
                        if (GlobalApplication.m3265f()) {
                            this.f1682q.findItem(R.id.actionbar_menu_done).setVisible(true).setEnabled(true);
                        }
                    }
                } else if (this.f1683r.getInt("chatType") == EnumC0695j.BROADCAST.m3146a()) {
                    if (length + hashSet.size() > 200) {
                        Toast.makeText(this.f1671f, String.format(this.f1671f.getString(R.string.buddy_list_broadcast_toast_failed_exceed), Integer.valueOf(HttpResponseCode.f7897OK)), 0).show();
                        this.f1681p.findViewById(R.id.buddy_menu_invite).setEnabled(false);
                        if (GlobalApplication.m3265f()) {
                            this.f1682q.findItem(R.id.actionbar_menu_done).setVisible(true).setEnabled(false);
                        }
                    } else {
                        this.f1681p.findViewById(R.id.buddy_menu_invite).setEnabled(true);
                        if (GlobalApplication.m3265f()) {
                            this.f1682q.findItem(R.id.actionbar_menu_done).setVisible(true).setEnabled(true);
                        }
                    }
                }
            }
            if (!GlobalApplication.m3265f()) {
                this.f1681p.findViewById(R.id.buddy_menu_group_chat).setEnabled(true);
                this.f1681p.findViewById(R.id.buddy_menu_broadcast).setEnabled(true);
                this.f1681p.findViewById(R.id.buddy_menu_invite).setEnabled(true);
            }
            this.f1681p.findViewById(R.id.buddy_menu_add_group).setEnabled(true);
            this.f1681p.findViewById(R.id.buddy_menu_blind_memo).setEnabled(true);
            return;
        }
        this.f1681p.findViewById(R.id.buddy_menu_group_chat).setEnabled(false);
        this.f1681p.findViewById(R.id.buddy_menu_broadcast).setEnabled(false);
        this.f1681p.findViewById(R.id.buddy_menu_invite).setEnabled(false);
        this.f1681p.findViewById(R.id.buddy_menu_add_group).setEnabled(false);
        if (GlobalApplication.m3265f()) {
            if ((this.f1678m == 2 || this.f1678m == 3 || this.f1678m == 5) && this.f1682q != null) {
                this.f1682q.findItem(R.id.actionbar_menu_done).setVisible(true).setEnabled(false);
            }
        }
    }

    /* renamed from: a */
    public void m2456a(String str, boolean z) {
        Iterator it = this.f1674i.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                C0257c c0257c = (C0257c) it2.next();
                if (c0257c.m2318a().equals(str)) {
                    c0257c.m2322a(z);
                    if (z && this.f1678m != 9) {
                        this.f1664C.m7439a(str, c0257c.m2324b());
                    } else {
                        this.f1664C.m7438a(str);
                    }
                }
            }
        }
        if (GlobalApplication.m3265f() && this.f1664C != null) {
            m2445b(((LinearLayout) this.f1664C.getChildAt(0)).getChildCount());
        }
    }

    /* renamed from: a */
    public void m2454a(ChoicePanel choicePanel) {
        this.f1664C = choicePanel;
        this.f1664C.setVisibility(0);
    }

    /* renamed from: a */
    public void m2458a(String[] strArr, boolean z) {
        Iterator it = this.f1674i.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                C0257c c0257c = (C0257c) it2.next();
                for (String str : strArr) {
                    if (c0257c.m2318a().equals(str)) {
                        this.f1664C.m7439a(str, c0257c.m2324b());
                        C1786r.m6067f("PARUL: buddyNo:" + str.toString() + "buddy.getName():" + c0257c.m2324b(), "BuddyAdapter");
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public void m2462b(String str) {
        if (str == null || str.trim().length() > 0) {
            this.f1684s = str;
            this.f1669d.invalidateViews();
        }
    }

    /* renamed from: c */
    public String m2463c() {
        return this.f1684s;
    }

    /* renamed from: a */
    public void m2455a(String str, EnumC0448x enumC0448x) {
        if (str == null || str.trim().length() > 0) {
            this.f1685t = str;
            this.f1669d.invalidateViews();
            this.f1686u = enumC0448x;
        }
    }

    /* renamed from: d */
    public String m2464d() {
        return this.f1685t;
    }

    /* renamed from: b */
    public void m2461b(ChoicePanel choicePanel) {
        this.f1664C = choicePanel;
        this.f1664C.setVisibility(8);
    }

    /* renamed from: b */
    private void m2445b(int i) {
        C1786r.m6067f("setTitle() : " + i, "BuddyFragment");
        this.f1687v.m2033a(i);
    }

    /* renamed from: e */
    public void m2465e() {
        if (this.f1688w != null && this.f1688w.isShowing()) {
            this.f1688w.dismiss();
        }
        if (this.f1667b != null) {
            this.f1667b.m2849b();
        }
    }
}
