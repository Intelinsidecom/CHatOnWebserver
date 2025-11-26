package com.sec.common.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
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
import android.widget.ScrollView;
import android.widget.TextView;
import com.sec.common.C3310c;
import com.sec.common.C3313d;
import com.sec.common.C3330f;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class DropPanelMenu extends LinearLayout {

    /* renamed from: a */
    private static boolean f12118a;

    /* renamed from: b */
    private int f12119b;

    /* renamed from: c */
    private ArrayList<LinearLayout> f12120c;

    /* renamed from: d */
    private Menu f12121d;

    /* renamed from: e */
    private PopupWindow f12122e;

    /* renamed from: f */
    private Context f12123f;

    /* renamed from: g */
    private View f12124g;

    /* renamed from: h */
    private View f12125h;

    /* renamed from: i */
    private ScrollView f12126i;

    /* renamed from: j */
    private InterfaceC3369b f12127j;

    /* renamed from: k */
    private boolean f12128k;

    /* renamed from: l */
    private boolean f12129l;

    static {
        f12118a = Build.VERSION.SDK_INT >= 14 && !ViewConfiguration.get(CommonApplication.m11493l()).hasPermanentMenuKey();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 82 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getRepeatCount() == 0 && this.f12122e.isShowing()) {
            this.f12122e.dismiss();
        }
        return true;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(getClass().getSimpleName(), "DropPanelMenu::onConfigurationChanged()");
        }
        if (this.f12122e.isShowing() && this.f12129l) {
            this.f12122e.dismiss();
            m11863a(this.f12125h, this.f12124g);
        }
    }

    /* renamed from: a */
    public void m11863a(View view, View view2) {
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(getClass().getSimpleName(), "DropPanelMenu::showAsDropDown()");
        }
        this.f12125h = view;
        this.f12124g = view2;
        this.f12127j.m11934a(this.f12121d);
        if (this.f12124g != null) {
            m11862a();
            if (this.f12122e.isShowing()) {
                this.f12122e.dismiss();
            }
            this.f12126i.scrollTo(0, 0);
            this.f12122e.showAsDropDown(this.f12124g);
            this.f12125h.setSelected(true);
        }
    }

    public void setAutoResizeOnRotate(boolean z) {
        this.f12129l = z;
    }

    public void setLineHeight(int i) {
        this.f12119b = i;
    }

    public void setItemChanged(boolean z) {
        if (this.f12128k != z) {
            this.f12128k = z;
        }
        if (this.f12122e.isShowing()) {
            m11861c();
        }
    }

    /* renamed from: a */
    public void m11862a() {
        this.f12122e.setWidth(((WindowManager) this.f12123f.getSystemService("window")).getDefaultDisplay().getWidth());
        m11861c();
    }

    /* renamed from: a */
    private void m11858a(MenuItemC3371d menuItemC3371d) {
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(C3313d.layout_droppanel_menuitem, (ViewGroup) this, false);
        ImageView imageView = (ImageView) linearLayout.findViewById(C3310c.droppanel_menuitem_divider);
        ImageView imageView2 = (ImageView) linearLayout.findViewById(C3310c.droppanel_menuitem_icon);
        TextView textView = (TextView) linearLayout.findViewById(C3310c.droppanel_menuitem_text);
        linearLayout.setEnabled(menuItemC3371d.isEnabled());
        if (menuItemC3371d.getIcon() != null) {
            imageView2.setImageDrawable(menuItemC3371d.getIcon());
            imageView2.setEnabled(menuItemC3371d.isEnabled());
            imageView2.setVisibility(0);
        } else {
            textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        }
        if (menuItemC3371d.getTitle() != null) {
            textView.setText(menuItemC3371d.getTitle());
            textView.setEnabled(menuItemC3371d.isEnabled());
            textView.setVisibility(0);
        } else if (imageView2 != null) {
            imageView2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        }
        linearLayout.setClickable(true);
        linearLayout.setOnTouchListener(new ViewOnTouchListenerC3368a(this));
        imageView.setVisibility(0);
        this.f12120c.add(0, linearLayout);
        menuItemC3371d.m11949a(linearLayout);
    }

    /* renamed from: c */
    private boolean m11861c() {
        if (!this.f12128k) {
            return false;
        }
        int size = this.f12121d.size();
        this.f12120c.clear();
        for (int i = 0; i < size; i++) {
            m11858a((MenuItemC3371d) this.f12121d.getItem(i));
        }
        removeAllViews();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f12120c.size() != 0) {
                LinearLayout linearLayout = this.f12120c.get(i2);
                if (linearLayout.getParent() != null) {
                    ((LinearLayout) linearLayout.getParent()).removeAllViewsInLayout();
                }
                addView(linearLayout, 0);
            }
        }
        int i3 = (this.f12119b * size) + 1 + 7;
        if (i3 < m11864b()) {
            this.f12122e.setHeight(i3);
        } else {
            this.f12122e.setHeight(m11864b());
        }
        this.f12128k = false;
        return true;
    }

    /* renamed from: b */
    public int m11864b() {
        if (this.f12124g == null) {
            return -1;
        }
        int height = ((WindowManager) this.f12123f.getSystemService("window")).getDefaultDisplay().getHeight();
        Rect rect = new Rect();
        this.f12124g.getGlobalVisibleRect(rect);
        return height - rect.bottom;
    }

    public void setAnchorView(View view) {
        this.f12124g = view;
    }

    public void setDropDownButton(View view) {
        this.f12125h = view;
    }
}
