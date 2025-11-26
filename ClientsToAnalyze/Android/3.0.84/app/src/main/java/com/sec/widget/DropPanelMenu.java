package com.sec.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.v4.app.Fragment;
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
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class DropPanelMenu extends LinearLayout {

    /* renamed from: a */
    private static boolean f13366a;

    /* renamed from: b */
    private int f13367b;

    /* renamed from: c */
    private ArrayList<LinearLayout> f13368c;

    /* renamed from: d */
    private Menu f13369d;

    /* renamed from: e */
    private MenuC3687u f13370e;

    /* renamed from: f */
    private PopupWindow f13371f;

    /* renamed from: g */
    private Context f13372g;

    /* renamed from: h */
    private View f13373h;

    /* renamed from: i */
    private View f13374i;

    /* renamed from: j */
    private RelativeLayout f13375j;

    /* renamed from: k */
    private ScrollView f13376k;

    /* renamed from: l */
    private InterfaceC3686t f13377l;

    /* renamed from: m */
    private boolean f13378m;

    /* renamed from: n */
    private boolean f13379n;

    static {
        f13366a = Build.VERSION.SDK_INT >= 14 && !ViewConfiguration.get(GlobalApplication.m11493l()).hasPermanentMenuKey();
    }

    public DropPanelMenu(Fragment fragment) {
        this(fragment.getActivity(), new C3682p(fragment));
    }

    private DropPanelMenu(Context context, InterfaceC3686t interfaceC3686t) {
        super(context);
        this.f13368c = new ArrayList<>();
        this.f13372g = context;
        this.f13377l = interfaceC3686t;
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundColor(0);
        setOrientation(1);
        setFocusableInTouchMode(true);
        this.f13375j = (RelativeLayout) ((LayoutInflater) this.f13372g.getSystemService("layout_inflater")).inflate(R.layout.layout_droppanel_menu, (RelativeLayout) findViewById(R.id.droppanel_menu_rootview));
        this.f13376k = (ScrollView) this.f13375j.findViewById(R.id.droppanel_menu_scrollview);
        this.f13376k.addView(this);
        this.f13367b = getResources().getDimensionPixelSize(R.dimen.droppanel_menu_item_height);
        this.f13371f = new PopupWindow(this.f13375j);
        this.f13371f.setOutsideTouchable(true);
        this.f13371f.setBackgroundDrawable(new BitmapDrawable());
        this.f13371f.setTouchable(true);
        this.f13371f.setFocusable(true);
        this.f13371f.setSoftInputMode(3);
        this.f13371f.setOnDismissListener(new C3683q(this));
        this.f13370e = new MenuC3687u(this.f13372g);
        this.f13369d = this.f13370e;
        this.f13370e.m13273a(this);
        this.f13377l.mo13263a(this.f13369d);
        this.f13378m = true;
        this.f13379n = true;
        this.f13375j.setOnTouchListener(new ViewOnTouchListenerC3684r(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 82 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getRepeatCount() == 0 && this.f13371f.isShowing()) {
            this.f13371f.dismiss();
        }
        return true;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C3250y.m11450b("DropPanelMenu::onConfigurationChanged()", getClass().getSimpleName());
        if (this.f13371f.isShowing() && this.f13379n) {
            this.f13371f.dismiss();
            m13094a(this.f13374i, this.f13373h);
        }
    }

    /* renamed from: a */
    public void m13094a(View view, View view2) {
        C3250y.m11450b("DropPanelMenu::showAsDropDown()", getClass().getSimpleName());
        this.f13374i = view;
        this.f13373h = view2;
        this.f13377l.mo13265b(this.f13369d);
        if (this.f13373h != null) {
            m13093a();
            if (this.f13371f.isShowing()) {
                this.f13371f.dismiss();
            }
            this.f13376k.scrollTo(0, 0);
            this.f13371f.showAsDropDown(this.f13373h);
            this.f13374i.setSelected(true);
        }
    }

    public void setAutoResizeOnRotate(boolean z) {
        this.f13379n = z;
    }

    public void setLineHeight(int i) {
        this.f13367b = i;
    }

    public void setItemChanged(boolean z) {
        if (this.f13378m != z) {
            this.f13378m = z;
        }
        if (this.f13371f.isShowing()) {
            m13090c();
        }
    }

    /* renamed from: a */
    public void m13093a() {
        this.f13371f.setWidth(((WindowManager) this.f13372g.getSystemService("window")).getDefaultDisplay().getWidth());
        m13090c();
    }

    /* renamed from: a */
    private void m13087a(MenuItemC3688v menuItemC3688v) {
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.layout_droppanel_menuitem, (ViewGroup) this, false);
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.droppanel_menuitem_divider);
        ImageView imageView2 = (ImageView) linearLayout.findViewById(R.id.droppanel_menuitem_icon);
        TextView textView = (TextView) linearLayout.findViewById(R.id.droppanel_menuitem_text);
        linearLayout.setEnabled(menuItemC3688v.isEnabled());
        if (menuItemC3688v.getIcon() != null) {
            imageView2.setImageDrawable(menuItemC3688v.getIcon());
            imageView2.setEnabled(menuItemC3688v.isEnabled());
            imageView2.setVisibility(0);
        } else {
            textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        }
        if (menuItemC3688v.getTitle() != null) {
            textView.setText(menuItemC3688v.getTitle());
            textView.setEnabled(menuItemC3688v.isEnabled());
            textView.setVisibility(0);
        } else if (imageView2 != null) {
            imageView2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        }
        linearLayout.setClickable(true);
        linearLayout.setOnTouchListener(new ViewOnTouchListenerC3685s(this));
        imageView.setVisibility(0);
        this.f13368c.add(0, linearLayout);
        menuItemC3688v.m13280a(linearLayout);
    }

    /* renamed from: c */
    private boolean m13090c() {
        if (!this.f13378m) {
            return false;
        }
        int size = this.f13369d.size();
        this.f13368c.clear();
        for (int i = 0; i < size; i++) {
            m13087a((MenuItemC3688v) this.f13369d.getItem(i));
        }
        removeAllViews();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f13368c.size() != 0) {
                LinearLayout linearLayout = this.f13368c.get(i2);
                if (linearLayout.getParent() != null) {
                    ((LinearLayout) linearLayout.getParent()).removeAllViewsInLayout();
                }
                addView(linearLayout, 0);
            }
        }
        int i3 = (this.f13367b * size) + 1 + 7;
        if (i3 < m13095b()) {
            this.f13371f.setHeight(i3);
        } else {
            this.f13371f.setHeight(m13095b());
        }
        this.f13378m = false;
        return true;
    }

    /* renamed from: b */
    public int m13095b() {
        if (this.f13373h == null) {
            return -1;
        }
        int height = ((WindowManager) this.f13372g.getSystemService("window")).getDefaultDisplay().getHeight();
        Rect rect = new Rect();
        this.f13373h.getGlobalVisibleRect(rect);
        return height - rect.bottom;
    }

    public void setAnchorView(View view) {
        this.f13373h = view;
    }

    public void setDropDownButton(View view) {
        this.f13374i = view;
    }
}
