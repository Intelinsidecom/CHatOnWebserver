package com.sec.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
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
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;

@TargetApi(14)
/* loaded from: classes.dex */
public final class DropPanelMenu extends LinearLayout {

    /* renamed from: a */
    @SuppressLint({"NewApi"})
    private static boolean f18733a;

    /* renamed from: b */
    private int f18734b;

    /* renamed from: c */
    private ArrayList<LinearLayout> f18735c;

    /* renamed from: d */
    private Menu f18736d;

    /* renamed from: e */
    private MenuC5165h f18737e;

    /* renamed from: f */
    private PopupWindow f18738f;

    /* renamed from: g */
    private Context f18739g;

    /* renamed from: h */
    private View f18740h;

    /* renamed from: i */
    private View f18741i;

    /* renamed from: j */
    private RelativeLayout f18742j;

    /* renamed from: k */
    private ScrollView f18743k;

    /* renamed from: l */
    private InterfaceC5164g f18744l;

    /* renamed from: m */
    private boolean f18745m;

    /* renamed from: n */
    private boolean f18746n;

    static {
        f18733a = Build.VERSION.SDK_INT >= 14 && !ViewConfiguration.get(GlobalApplication.m18732r()).hasPermanentMenuKey();
    }

    public DropPanelMenu(Fragment fragment) {
        this(fragment.getActivity(), new C5160c(fragment));
    }

    private DropPanelMenu(Context context, InterfaceC5164g interfaceC5164g) {
        super(context);
        this.f18735c = new ArrayList<>();
        this.f18739g = context;
        this.f18744l = interfaceC5164g;
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundColor(0);
        setOrientation(1);
        setFocusableInTouchMode(true);
        this.f18742j = (RelativeLayout) ((LayoutInflater) this.f18739g.getSystemService("layout_inflater")).inflate(R.layout.layout_droppanel_menu, (RelativeLayout) findViewById(R.id.droppanel_menu_rootview));
        this.f18743k = (ScrollView) this.f18742j.findViewById(R.id.droppanel_menu_scrollview);
        this.f18743k.addView(this);
        this.f18734b = getResources().getDimensionPixelSize(R.dimen.droppanel_menu_item_height);
        this.f18738f = new PopupWindow(this.f18742j);
        this.f18738f.setOutsideTouchable(true);
        this.f18738f.setBackgroundDrawable(new BitmapDrawable());
        this.f18738f.setTouchable(true);
        this.f18738f.setFocusable(true);
        this.f18738f.setSoftInputMode(3);
        this.f18738f.setOnDismissListener(new C5161d(this));
        this.f18737e = new MenuC5165h(this.f18739g);
        this.f18736d = this.f18737e;
        this.f18737e.m19758a(this);
        this.f18744l.mo19748a(this.f18736d);
        this.f18745m = true;
        this.f18746n = true;
        this.f18742j.setOnTouchListener(new ViewOnTouchListenerC5162e(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 82 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getRepeatCount() == 0 && this.f18738f.isShowing()) {
            this.f18738f.dismiss();
        }
        return true;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C4904y.m18639b("DropPanelMenu::onConfigurationChanged()", getClass().getSimpleName());
        if (this.f18738f.isShowing() && this.f18746n) {
            this.f18738f.dismiss();
            m19626a(this.f18741i, this.f18740h);
        }
    }

    /* renamed from: a */
    public void m19626a(View view, View view2) {
        C4904y.m18639b("DropPanelMenu::showAsDropDown()", getClass().getSimpleName());
        this.f18741i = view;
        this.f18740h = view2;
        this.f18744l.mo19750b(this.f18736d);
        if (this.f18740h != null) {
            m19625a();
            if (this.f18738f.isShowing()) {
                this.f18738f.dismiss();
            }
            this.f18743k.scrollTo(0, 0);
            this.f18738f.showAsDropDown(this.f18740h);
            this.f18741i.setSelected(true);
        }
    }

    public void setAutoResizeOnRotate(boolean z) {
        this.f18746n = z;
    }

    public void setLineHeight(int i) {
        this.f18734b = i;
    }

    public void setItemChanged(boolean z) {
        if (this.f18745m != z) {
            this.f18745m = z;
        }
        if (this.f18738f.isShowing()) {
            m19622c();
        }
    }

    /* renamed from: a */
    public void m19625a() {
        this.f18738f.setWidth(((WindowManager) this.f18739g.getSystemService("window")).getDefaultDisplay().getWidth());
        m19622c();
    }

    /* renamed from: a */
    private void m19619a(MenuItemC5166i menuItemC5166i) {
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.layout_droppanel_menuitem, (ViewGroup) this, false);
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.droppanel_menuitem_divider);
        ImageView imageView2 = (ImageView) linearLayout.findViewById(R.id.droppanel_menuitem_icon);
        TextView textView = (TextView) linearLayout.findViewById(R.id.droppanel_menuitem_text);
        linearLayout.setEnabled(menuItemC5166i.isEnabled());
        if (menuItemC5166i.getIcon() != null) {
            imageView2.setImageDrawable(menuItemC5166i.getIcon());
            imageView2.setEnabled(menuItemC5166i.isEnabled());
            imageView2.setVisibility(0);
        } else {
            textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        }
        if (menuItemC5166i.getTitle() != null) {
            textView.setText(menuItemC5166i.getTitle());
            textView.setEnabled(menuItemC5166i.isEnabled());
            textView.setVisibility(0);
        } else if (imageView2 != null) {
            imageView2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        }
        linearLayout.setClickable(true);
        linearLayout.setOnTouchListener(new ViewOnTouchListenerC5163f(this));
        imageView.setVisibility(0);
        this.f18735c.add(0, linearLayout);
        menuItemC5166i.m19765a(linearLayout);
    }

    /* renamed from: c */
    private boolean m19622c() {
        if (!this.f18745m) {
            return false;
        }
        int size = this.f18736d.size();
        this.f18735c.clear();
        for (int i = 0; i < size; i++) {
            m19619a((MenuItemC5166i) this.f18736d.getItem(i));
        }
        removeAllViews();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f18735c.size() != 0) {
                LinearLayout linearLayout = this.f18735c.get(i2);
                if (linearLayout.getParent() != null) {
                    ((LinearLayout) linearLayout.getParent()).removeAllViewsInLayout();
                }
                addView(linearLayout, 0);
            }
        }
        int i3 = (this.f18734b * size) + 1 + 7;
        if (i3 < m19627b()) {
            this.f18738f.setHeight(i3);
        } else {
            this.f18738f.setHeight(m19627b());
        }
        this.f18745m = false;
        return true;
    }

    /* renamed from: b */
    public int m19627b() {
        if (this.f18740h == null) {
            return -1;
        }
        int height = ((WindowManager) this.f18739g.getSystemService("window")).getDefaultDisplay().getHeight();
        Rect rect = new Rect();
        this.f18740h.getGlobalVisibleRect(rect);
        return height - rect.bottom;
    }

    public void setAnchorView(View view) {
        this.f18740h = view;
    }

    public void setDropDownButton(View view) {
        this.f18741i = view;
    }
}
