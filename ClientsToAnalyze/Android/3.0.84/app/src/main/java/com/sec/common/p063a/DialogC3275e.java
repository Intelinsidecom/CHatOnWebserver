package com.sec.common.p063a;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.sec.common.C3307b;
import com.sec.common.C3310c;
import com.sec.common.C3313d;
import com.sec.common.C3323e;

/* compiled from: AlertDialogImpl.java */
/* renamed from: com.sec.common.a.e */
/* loaded from: classes.dex */
class DialogC3275e extends Dialog implements InterfaceC3274d {

    /* renamed from: A */
    private CharSequence f11826A;

    /* renamed from: B */
    private DialogInterface.OnClickListener f11827B;

    /* renamed from: C */
    private Message f11828C;

    /* renamed from: D */
    private CharSequence f11829D;

    /* renamed from: E */
    private DialogInterface.OnClickListener f11830E;

    /* renamed from: F */
    private Message f11831F;

    /* renamed from: G */
    private CharSequence f11832G;

    /* renamed from: H */
    private DialogInterface.OnClickListener f11833H;

    /* renamed from: I */
    private DialogInterface.OnCancelListener f11834I;

    /* renamed from: J */
    private DialogInterface.OnKeyListener f11835J;

    /* renamed from: K */
    private TextView f11836K;

    /* renamed from: L */
    private Button f11837L;

    /* renamed from: M */
    private Button f11838M;

    /* renamed from: N */
    private Button f11839N;

    /* renamed from: O */
    private ScrollView f11840O;

    /* renamed from: P */
    private TextView f11841P;

    /* renamed from: Q */
    private ListView f11842Q;

    /* renamed from: R */
    private HandlerC3282l f11843R;

    /* renamed from: S */
    private View.OnClickListener f11844S;

    /* renamed from: a */
    private Context f11845a;

    /* renamed from: b */
    private int f11846b;

    /* renamed from: c */
    private CharSequence f11847c;

    /* renamed from: d */
    private CharSequence f11848d;

    /* renamed from: e */
    private View f11849e;

    /* renamed from: f */
    private View f11850f;

    /* renamed from: g */
    private boolean f11851g;

    /* renamed from: h */
    private int f11852h;

    /* renamed from: i */
    private int f11853i;

    /* renamed from: j */
    private int f11854j;

    /* renamed from: k */
    private int f11855k;

    /* renamed from: l */
    private boolean f11856l;

    /* renamed from: m */
    private boolean f11857m;

    /* renamed from: n */
    private int f11858n;

    /* renamed from: o */
    private boolean[] f11859o;

    /* renamed from: p */
    private String f11860p;

    /* renamed from: q */
    private String f11861q;

    /* renamed from: r */
    private CharSequence[] f11862r;

    /* renamed from: s */
    private ListAdapter f11863s;

    /* renamed from: t */
    private Cursor f11864t;

    /* renamed from: u */
    private DialogInterface.OnClickListener f11865u;

    /* renamed from: v */
    private AdapterView.OnItemSelectedListener f11866v;

    /* renamed from: w */
    private DialogInterface.OnMultiChoiceClickListener f11867w;

    /* renamed from: x */
    private boolean f11868x;

    /* renamed from: y */
    private boolean f11869y;

    /* renamed from: z */
    private Message f11870z;

    public DialogC3275e(C3272b c3272b) {
        super(c3272b.f11798a, c3272b.f11799b);
        this.f11844S = new ViewOnClickListenerC3276f(this);
        this.f11843R = new HandlerC3282l(this);
        m11523a(c3272b);
    }

    /* renamed from: c */
    void m11542c() {
        if (this.f11862r != null || this.f11864t != null || this.f11863s != null) {
            this.f11842Q = m11521a((Dialog) this);
        }
    }

    @Override // com.sec.common.p063a.InterfaceC3274d
    /* renamed from: a */
    public Dialog mo11517a() {
        return this;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.requestFeature(1);
        if (this.f11850f == null || !m11526a(this.f11850f)) {
            window.setFlags(131072, 131072);
        }
        TypedArray typedArrayObtainStyledAttributes = this.f11845a.obtainStyledAttributes(null, C3323e.AlertDialogCompat, C3307b.alertDialogStyle, 0);
        setContentView(C3313d.layout_dialog);
        LinearLayout linearLayout = (LinearLayout) findViewById(C3310c.topPanel);
        boolean zM11528a = m11528a(linearLayout);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(C3310c.buttonPanel);
        boolean zM11525a = m11525a(this, linearLayout2);
        if (!zM11525a) {
            linearLayout2.setVisibility(8);
        }
        LinearLayout linearLayout3 = (LinearLayout) findViewById(C3310c.contentPanel);
        m11530b(linearLayout3);
        FrameLayout frameLayout = (FrameLayout) findViewById(C3310c.customPanel);
        if (!m11527a(frameLayout)) {
            frameLayout.setVisibility(8);
        }
        m11522a(typedArrayObtainStyledAttributes, linearLayout, linearLayout3, frameLayout, linearLayout2, zM11525a, zM11528a);
        if (this.f11842Q != null && this.f11863s != null) {
            this.f11842Q.setAdapter(this.f11863s);
            if (this.f11858n > -1) {
                this.f11842Q.setItemChecked(this.f11858n, true);
                this.f11842Q.setSelection(this.f11858n);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        setCancelable(this.f11868x);
        setOnCancelListener(this.f11834I);
        setOnKeyListener(this.f11835J);
    }

    @Override // com.sec.common.p063a.InterfaceC3274d
    /* renamed from: b */
    public ListView mo11519b() {
        return this.f11842Q;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f11840O == null || !this.f11840O.executeKeyEvent(keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f11840O == null || !this.f11840O.executeKeyEvent(keyEvent)) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f11847c = charSequence;
        if (this.f11836K != null) {
            this.f11836K.setText(this.f11847c);
        }
    }

    @Override // com.sec.common.p063a.InterfaceC3274d
    /* renamed from: a */
    public void mo11518a(View view, int i, int i2, int i3, int i4) {
        this.f11850f = view;
        this.f11851g = true;
        this.f11852h = i;
        this.f11853i = i2;
        this.f11854j = i3;
        this.f11855k = i4;
    }

    /* renamed from: a */
    private void m11523a(C3272b c3272b) {
        this.f11846b = c3272b.f11799b;
        if (this.f11846b == 0) {
            this.f11845a = c3272b.f11798a;
        } else {
            this.f11845a = new ContextThemeWrapper(c3272b.f11798a, c3272b.f11799b);
        }
        this.f11847c = c3272b.f11815r;
        this.f11848d = c3272b.f11817t;
        this.f11849e = c3272b.f11816s;
        this.f11850f = c3272b.f11818u;
        this.f11856l = c3272b.f11808k;
        this.f11857m = c3272b.f11809l;
        this.f11858n = c3272b.f11806i;
        this.f11859o = c3272b.f11807j;
        this.f11860p = c3272b.f11804g;
        this.f11861q = c3272b.f11805h;
        this.f11862r = c3272b.f11801d;
        this.f11863s = c3272b.f11802e;
        this.f11864t = c3272b.f11803f;
        this.f11865u = c3272b.f11810m;
        this.f11866v = c3272b.f11812o;
        this.f11867w = c3272b.f11811n;
        this.f11868x = c3272b.f11814q;
        this.f11869y = c3272b.f11800c;
        this.f11826A = c3272b.f11819v;
        this.f11827B = c3272b.f11820w;
        this.f11829D = c3272b.f11821x;
        this.f11830E = c3272b.f11822y;
        this.f11832G = c3272b.f11823z;
        this.f11833H = c3272b.f11796A;
        this.f11834I = c3272b.f11797B;
        this.f11835J = c3272b.f11813p;
    }

    /* renamed from: a */
    private boolean m11528a(LinearLayout linearLayout) {
        if (this.f11849e != null) {
            linearLayout.addView(this.f11849e, new LinearLayout.LayoutParams(-1, -2));
            linearLayout.findViewById(C3310c.title_template).setVisibility(8);
            return true;
        }
        if (!TextUtils.isEmpty(this.f11847c)) {
            this.f11836K = (TextView) linearLayout.findViewById(C3310c.alertTitle);
            this.f11836K.setText(this.f11847c);
            return true;
        }
        linearLayout.findViewById(C3310c.title_template).setVisibility(8);
        return false;
    }

    /* renamed from: b */
    private boolean m11530b(LinearLayout linearLayout) {
        this.f11840O = (ScrollView) linearLayout.findViewById(C3310c.scrollView);
        this.f11840O.setFocusable(false);
        this.f11841P = (TextView) linearLayout.findViewById(C3310c.message);
        if (this.f11848d != null) {
            this.f11841P.setText(this.f11848d);
        } else {
            this.f11841P.setVisibility(8);
            this.f11840O.removeView(this.f11841P);
            if (this.f11842Q != null) {
                linearLayout.removeView(this.f11840O);
                linearLayout.addView(this.f11842Q, new LinearLayout.LayoutParams(-1, -1));
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
            } else {
                linearLayout.setVisibility(8);
            }
        }
        return true;
    }

    /* renamed from: a */
    private ListView m11521a(Dialog dialog) {
        ListAdapter simpleCursorAdapter;
        ListView listView = (ListView) LayoutInflater.from(this.f11845a).inflate(C3313d.layout_dialog_lisview, (ViewGroup) null);
        if (this.f11857m) {
            if (this.f11864t == null) {
                simpleCursorAdapter = new C3277g(this, this.f11845a, C3313d.layout_dialog_listview_multichoice, R.id.text1, this.f11862r, listView);
            } else {
                simpleCursorAdapter = new C3278h(this, this.f11845a, this.f11864t, false, listView);
            }
        } else {
            int i = this.f11856l ? C3313d.layout_dialog_listview_singlechoice : C3313d.layout_dialog_listview_item;
            if (this.f11864t == null) {
                simpleCursorAdapter = this.f11863s != null ? this.f11863s : new ArrayAdapter(this.f11845a, i, R.id.text1, this.f11862r);
            } else {
                simpleCursorAdapter = new SimpleCursorAdapter(this.f11845a, i, this.f11864t, new String[]{this.f11861q}, new int[]{R.id.text1});
            }
            if (this.f11865u != null) {
                listView.setOnItemClickListener(new C3279i(this, dialog));
            }
        }
        this.f11863s = simpleCursorAdapter;
        if (this.f11866v != null) {
            listView.setOnItemSelectedListener(this.f11866v);
        }
        if (this.f11856l) {
            listView.setChoiceMode(1);
        } else if (this.f11857m) {
            listView.setChoiceMode(2);
        }
        if (this.f11865u != null) {
            listView.setOnItemClickListener(new C3280j(this, dialog));
        } else if (this.f11867w != null) {
            listView.setOnItemClickListener(new C3281k(this, listView, dialog));
        }
        return listView;
    }

    /* renamed from: a */
    private boolean m11527a(FrameLayout frameLayout) {
        if (this.f11850f != null) {
            FrameLayout frameLayout2 = (FrameLayout) frameLayout.findViewById(C3310c.custom);
            frameLayout2.addView(this.f11850f, new ViewGroup.LayoutParams(-1, -1));
            if (this.f11851g) {
                frameLayout2.setPadding(this.f11852h, this.f11853i, this.f11854j, this.f11855k);
            }
            return true;
        }
        frameLayout.setVisibility(8);
        return false;
    }

    /* renamed from: a */
    private boolean m11524a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        Button button;
        if (message == null && onClickListener != null) {
            message = this.f11843R.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                button = this.f11838M;
                this.f11828C = message;
                this.f11829D = charSequence;
                break;
            case -2:
                button = this.f11839N;
                this.f11831F = message;
                this.f11832G = charSequence;
                break;
            case -1:
                button = this.f11837L;
                this.f11870z = message;
                this.f11826A = charSequence;
                break;
            default:
                throw new IllegalArgumentException("Unknown button type.");
        }
        button.setOnClickListener(this.f11844S);
        if (!TextUtils.isEmpty(charSequence)) {
            button.setVisibility(0);
            button.setText(charSequence);
            return true;
        }
        button.setVisibility(8);
        return false;
    }

    /* renamed from: a */
    private boolean m11525a(Dialog dialog, LinearLayout linearLayout) {
        this.f11837L = (Button) linearLayout.findViewById(C3310c.button1);
        boolean zM11524a = false | m11524a(-1, this.f11826A, this.f11827B, null);
        this.f11838M = (Button) linearLayout.findViewById(C3310c.button2);
        boolean zM11524a2 = zM11524a | m11524a(-3, this.f11829D, this.f11830E, null);
        this.f11839N = (Button) linearLayout.findViewById(C3310c.button3);
        return m11524a(-2, this.f11832G, this.f11833H, null) | zM11524a2;
    }

    /* renamed from: a */
    private void m11522a(TypedArray typedArray, LinearLayout linearLayout, LinearLayout linearLayout2, View view, View view2, boolean z, boolean z2) {
        int resourceId = typedArray.getResourceId(0, 0);
        int resourceId2 = typedArray.getResourceId(4, 0);
        int resourceId3 = typedArray.getResourceId(1, 0);
        int resourceId4 = typedArray.getResourceId(2, 0);
        int resourceId5 = typedArray.getResourceId(3, 0);
        int resourceId6 = typedArray.getResourceId(5, 0);
        int resourceId7 = typedArray.getResourceId(6, 0);
        int resourceId8 = typedArray.getResourceId(7, 0);
        int resourceId9 = typedArray.getResourceId(8, 0);
        View[] viewArr = new View[4];
        boolean[] zArr = new boolean[4];
        int i = 0;
        if (z2) {
            viewArr[0] = linearLayout;
            zArr[0] = false;
            i = 1;
        }
        if (linearLayout2.getVisibility() == 8) {
            linearLayout2 = null;
        }
        viewArr[i] = linearLayout2;
        zArr[i] = this.f11842Q != null;
        int i2 = i + 1;
        if (view.getVisibility() == 0) {
            viewArr[i2] = view;
            zArr[i2] = this.f11869y;
            i2++;
        }
        if (z) {
            viewArr[i2] = view2;
            zArr[i2] = true;
        }
        boolean z3 = false;
        boolean z4 = false;
        View view3 = null;
        for (int i3 = 0; i3 < viewArr.length; i3++) {
            View view4 = viewArr[i3];
            if (view4 != null) {
                if (view3 != null) {
                    if (!z3) {
                        view3.setBackgroundResource(z4 ? resourceId6 : resourceId3);
                    } else {
                        view3.setBackgroundResource(z4 ? resourceId7 : resourceId4);
                    }
                    z3 = true;
                }
                z4 = zArr[i3];
                view3 = view4;
            }
        }
        if (view3 != null) {
            if (z3) {
                view3.setBackgroundResource(z4 ? z ? resourceId9 : resourceId8 : resourceId5);
            } else {
                view3.setBackgroundResource(z4 ? resourceId2 : resourceId);
            }
        }
    }

    /* renamed from: a */
    private boolean m11526a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (m11526a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }
}
