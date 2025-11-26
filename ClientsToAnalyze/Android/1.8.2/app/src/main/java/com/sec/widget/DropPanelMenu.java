package com.sec.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class DropPanelMenu extends LinearLayout {

    /* renamed from: a */
    private static final boolean f7697a;

    /* renamed from: b */
    private int f7698b;

    /* renamed from: c */
    private ArrayList f7699c;

    /* renamed from: d */
    private Menu f7700d;

    /* renamed from: e */
    private MenuC2144p f7701e;

    /* renamed from: f */
    private PopupWindow f7702f;

    /* renamed from: g */
    private Context f7703g;

    /* renamed from: h */
    private View f7704h;

    /* renamed from: i */
    private View f7705i;

    /* renamed from: j */
    private RelativeLayout f7706j;

    /* renamed from: k */
    private ScrollView f7707k;

    /* renamed from: l */
    private InterfaceC2143o f7708l;

    /* renamed from: m */
    private boolean f7709m;

    /* renamed from: n */
    private boolean f7710n;

    static {
        f7697a = Build.VERSION.SDK_INT >= 14 && !ViewConfiguration.get(GlobalApplication.m3260b()).hasPermanentMenuKey();
    }

    public DropPanelMenu(Activity activity) {
        this(activity, new C2139k(activity));
    }

    private DropPanelMenu(Context context, InterfaceC2143o interfaceC2143o) {
        super(context);
        this.f7699c = new ArrayList();
        this.f7703g = context;
        this.f7708l = interfaceC2143o;
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundColor(0);
        setOrientation(1);
        setFocusableInTouchMode(true);
        this.f7706j = (RelativeLayout) ((LayoutInflater) this.f7703g.getSystemService("layout_inflater")).inflate(R.layout.layout_droppanel_menu, (RelativeLayout) findViewById(R.id.droppanel_menu_rootview));
        this.f7707k = (ScrollView) this.f7706j.findViewById(R.id.droppanel_menu_scrollview);
        this.f7707k.addView(this);
        this.f7698b = getResources().getDimensionPixelSize(R.dimen.droppanel_menu_item_height);
        this.f7702f = new PopupWindow(this.f7706j);
        this.f7702f.setOutsideTouchable(true);
        this.f7702f.setBackgroundDrawable(new BitmapDrawable());
        this.f7702f.setTouchable(true);
        this.f7702f.setFocusable(true);
        this.f7702f.setSoftInputMode(3);
        this.f7702f.setOnDismissListener(new C2140l(this));
        this.f7701e = new MenuC2144p(this.f7703g);
        this.f7700d = this.f7701e;
        this.f7701e.m7504a(this);
        this.f7708l.mo7494a(this.f7700d);
        this.f7709m = true;
        this.f7710n = true;
        this.f7706j.setOnTouchListener(new ViewOnTouchListenerC2141m(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 82 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getRepeatCount() == 0 && this.f7702f.isShowing()) {
            this.f7702f.dismiss();
        }
        return true;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C1786r.m6061b("DropPanelMenu::onConfigurationChanged()", getClass().getSimpleName());
        if (this.f7702f.isShowing() && this.f7710n) {
            this.f7702f.dismiss();
            m7449a(this.f7705i, this.f7704h);
        }
    }

    /* renamed from: a */
    public void m7448a(View view) {
        C1786r.m6061b("DropPanelMenu::showAsDropDown()", getClass().getSimpleName());
        if (view != null) {
            this.f7705i = view;
            this.f7704h = view;
            this.f7708l.mo7496b(this.f7700d);
            if (this.f7704h != null) {
                m7447a();
                if (this.f7702f.isShowing()) {
                    this.f7702f.dismiss();
                }
                this.f7707k.scrollTo(0, 0);
                this.f7702f.showAsDropDown(this.f7704h);
                this.f7705i.setSelected(true);
            }
        }
    }

    /* renamed from: a */
    public void m7449a(View view, View view2) {
        C1786r.m6061b("DropPanelMenu::showAsDropDown()", getClass().getSimpleName());
        this.f7705i = view;
        this.f7704h = view2;
        this.f7708l.mo7496b(this.f7700d);
        if (this.f7704h != null) {
            m7447a();
            if (this.f7702f.isShowing()) {
                this.f7702f.dismiss();
            }
            this.f7707k.scrollTo(0, 0);
            this.f7702f.showAsDropDown(this.f7704h);
            this.f7705i.setSelected(true);
        }
    }

    public void setAutoResizeOnRotate(boolean z) {
        this.f7710n = z;
    }

    public void setLineHeight(int i) {
        this.f7698b = i;
    }

    public void setItemChanged(boolean z) {
        if (this.f7709m != z) {
            this.f7709m = z;
        }
        if (this.f7702f.isShowing()) {
            m7444c();
        }
    }

    /* renamed from: a */
    public void m7447a() {
        this.f7702f.setWidth(((WindowManager) this.f7703g.getSystemService("window")).getDefaultDisplay().getWidth());
        m7444c();
    }

    /* renamed from: a */
    private void m7441a(MenuItemC2145q menuItemC2145q) {
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.layout_droppanel_menuitem, (ViewGroup) this, false);
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.droppanel_menuitem_divider);
        ImageView imageView2 = (ImageView) linearLayout.findViewById(R.id.droppanel_menuitem_icon);
        TextView textView = (TextView) linearLayout.findViewById(R.id.droppanel_menuitem_text);
        linearLayout.setEnabled(menuItemC2145q.isEnabled());
        if (menuItemC2145q.getIcon() != null) {
            imageView2.setImageDrawable(menuItemC2145q.getIcon());
            imageView2.setEnabled(menuItemC2145q.isEnabled());
            imageView2.setVisibility(0);
        } else {
            textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        }
        if (menuItemC2145q.getTitle() != null) {
            textView.setText(menuItemC2145q.getTitle());
            textView.setEnabled(menuItemC2145q.isEnabled());
            textView.setVisibility(0);
        } else if (imageView2 != null) {
            imageView2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        }
        linearLayout.setClickable(true);
        linearLayout.setOnTouchListener(new ViewOnTouchListenerC2142n(this));
        imageView.setVisibility(0);
        this.f7699c.add(0, linearLayout);
        menuItemC2145q.m7511a(linearLayout);
    }

    /* renamed from: c */
    private boolean m7444c() {
        if (!this.f7709m) {
            return false;
        }
        int size = this.f7700d.size();
        this.f7699c.clear();
        for (int i = 0; i < size; i++) {
            m7441a((MenuItemC2145q) this.f7700d.getItem(i));
        }
        removeAllViews();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f7699c.size() != 0) {
                LinearLayout linearLayout = (LinearLayout) this.f7699c.get(i2);
                if (linearLayout.getParent() != null) {
                    ((LinearLayout) linearLayout.getParent()).removeAllViewsInLayout();
                }
                addView(linearLayout, 0);
            }
        }
        int i3 = (this.f7698b * size) + 1 + 7;
        if (i3 < m7450b()) {
            this.f7702f.setHeight(i3);
        } else {
            this.f7702f.setHeight(m7450b());
        }
        this.f7709m = false;
        return true;
    }

    /* renamed from: b */
    public int m7450b() {
        if (this.f7704h == null) {
            return -1;
        }
        int height = ((WindowManager) this.f7703g.getSystemService("window")).getDefaultDisplay().getHeight();
        Rect rect = new Rect();
        this.f7704h.getGlobalVisibleRect(rect);
        return height - rect.bottom;
    }

    public void setAnchorView(View view) {
        this.f7704h = view;
    }

    public void setDropDownButton(View view) {
        this.f7705i = view;
    }
}
