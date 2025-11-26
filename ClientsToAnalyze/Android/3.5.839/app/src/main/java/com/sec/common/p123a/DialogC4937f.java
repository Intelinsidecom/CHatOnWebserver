package com.sec.common.p123a;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.hardware.motion.MotionRecognitionManager;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.widget.C0266z;
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
import com.sec.common.C4969b;
import com.sec.common.C4972c;
import com.sec.common.C4975d;
import com.sec.common.C4991e;
import com.sec.spp.push.dlc.api.IDlcApi;

/* compiled from: AlertDialogImpl.java */
/* renamed from: com.sec.common.a.f */
/* loaded from: classes.dex */
class DialogC4937f extends Dialog implements InterfaceC4936e {

    /* renamed from: A */
    private CharSequence f18025A;

    /* renamed from: B */
    private DialogInterface.OnClickListener f18026B;

    /* renamed from: C */
    private Message f18027C;

    /* renamed from: D */
    private CharSequence f18028D;

    /* renamed from: E */
    private DialogInterface.OnClickListener f18029E;

    /* renamed from: F */
    private Message f18030F;

    /* renamed from: G */
    private CharSequence f18031G;

    /* renamed from: H */
    private DialogInterface.OnClickListener f18032H;

    /* renamed from: I */
    private DialogInterface.OnCancelListener f18033I;

    /* renamed from: J */
    private DialogInterface.OnKeyListener f18034J;

    /* renamed from: K */
    private TextView f18035K;

    /* renamed from: L */
    private Button f18036L;

    /* renamed from: M */
    private Button f18037M;

    /* renamed from: N */
    private Button f18038N;

    /* renamed from: O */
    private ScrollView f18039O;

    /* renamed from: P */
    private TextView f18040P;

    /* renamed from: Q */
    private ListView f18041Q;

    /* renamed from: R */
    private HandlerC4944m f18042R;

    /* renamed from: S */
    private View.OnClickListener f18043S;

    /* renamed from: a */
    private Context f18044a;

    /* renamed from: b */
    private int f18045b;

    /* renamed from: c */
    private CharSequence f18046c;

    /* renamed from: d */
    private CharSequence f18047d;

    /* renamed from: e */
    private View f18048e;

    /* renamed from: f */
    private View f18049f;

    /* renamed from: g */
    private boolean f18050g;

    /* renamed from: h */
    private int f18051h;

    /* renamed from: i */
    private int f18052i;

    /* renamed from: j */
    private int f18053j;

    /* renamed from: k */
    private int f18054k;

    /* renamed from: l */
    private boolean f18055l;

    /* renamed from: m */
    private boolean f18056m;

    /* renamed from: n */
    private int f18057n;

    /* renamed from: o */
    private boolean[] f18058o;

    /* renamed from: p */
    private String f18059p;

    /* renamed from: q */
    private String f18060q;

    /* renamed from: r */
    private CharSequence[] f18061r;

    /* renamed from: s */
    private ListAdapter f18062s;

    /* renamed from: t */
    private Cursor f18063t;

    /* renamed from: u */
    private DialogInterface.OnClickListener f18064u;

    /* renamed from: v */
    private AdapterView.OnItemSelectedListener f18065v;

    /* renamed from: w */
    private DialogInterface.OnMultiChoiceClickListener f18066w;

    /* renamed from: x */
    private boolean f18067x;

    /* renamed from: y */
    private boolean f18068y;

    /* renamed from: z */
    private Message f18069z;

    public DialogC4937f(C4933b c4933b) {
        super(c4933b.f17996a, c4933b.f17997b);
        this.f18043S = new ViewOnClickListenerC4938g(this);
        this.f18042R = new HandlerC4944m(this);
        m18764a(c4933b);
    }

    /* renamed from: c */
    void m18783c() {
        if (this.f18061r != null || this.f18063t != null || this.f18062s != null) {
            this.f18041Q = m18762a((Dialog) this);
        }
    }

    @Override // com.sec.common.p123a.InterfaceC4936e
    /* renamed from: a */
    public Dialog mo18758a() {
        return this;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.requestFeature(1);
        if (this.f18049f == null || !m18767a(this.f18049f)) {
            window.setFlags(MotionRecognitionManager.EVENT_OVER_TURN_LOW_POWER, MotionRecognitionManager.EVENT_OVER_TURN_LOW_POWER);
        }
        TypedArray typedArrayObtainStyledAttributes = this.f18044a.obtainStyledAttributes(null, C4991e.AlertDialogCompat, C4969b.alertDialogStyle, 0);
        setContentView(C4975d.layout_dialog);
        LinearLayout linearLayout = (LinearLayout) findViewById(C4972c.topPanel);
        boolean zM18769a = m18769a(linearLayout);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(C4972c.buttonPanel);
        boolean zM18766a = m18766a(this, linearLayout2);
        if (!zM18766a) {
            linearLayout2.setVisibility(8);
        }
        LinearLayout linearLayout3 = (LinearLayout) findViewById(C4972c.contentPanel);
        m18771b(linearLayout3);
        FrameLayout frameLayout = (FrameLayout) findViewById(C4972c.customPanel);
        if (!m18768a(frameLayout)) {
            frameLayout.setVisibility(8);
        }
        m18763a(typedArrayObtainStyledAttributes, linearLayout, linearLayout3, frameLayout, linearLayout2, zM18766a, zM18769a);
        if (this.f18041Q != null && this.f18062s != null) {
            this.f18041Q.setAdapter(this.f18062s);
            if (this.f18057n > -1) {
                this.f18041Q.setItemChecked(this.f18057n, true);
                this.f18041Q.setSelection(this.f18057n);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        setCancelable(this.f18067x);
        setOnCancelListener(this.f18033I);
        setOnKeyListener(this.f18034J);
    }

    @Override // com.sec.common.p123a.InterfaceC4936e
    /* renamed from: b */
    public ListView mo18760b() {
        return this.f18041Q;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f18039O == null || !this.f18039O.executeKeyEvent(keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f18039O == null || !this.f18039O.executeKeyEvent(keyEvent)) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f18046c = charSequence;
        if (this.f18035K != null) {
            this.f18035K.setText(this.f18046c);
        }
    }

    @Override // com.sec.common.p123a.InterfaceC4936e
    /* renamed from: a */
    public void mo18759a(View view, int i, int i2, int i3, int i4) {
        this.f18049f = view;
        this.f18050g = true;
        this.f18051h = i;
        this.f18052i = i2;
        this.f18053j = i3;
        this.f18054k = i4;
    }

    /* renamed from: a */
    private void m18764a(C4933b c4933b) {
        this.f18045b = c4933b.f17997b;
        if (this.f18045b == 0) {
            this.f18044a = c4933b.f17996a;
        } else {
            this.f18044a = new ContextThemeWrapper(c4933b.f17996a, c4933b.f17997b);
        }
        this.f18046c = c4933b.f18013r;
        this.f18047d = c4933b.f18015t;
        this.f18048e = c4933b.f18014s;
        this.f18049f = c4933b.f18016u;
        this.f18055l = c4933b.f18006k;
        this.f18056m = c4933b.f18007l;
        this.f18057n = c4933b.f18004i;
        this.f18058o = c4933b.f18005j;
        this.f18059p = c4933b.f18002g;
        this.f18060q = c4933b.f18003h;
        this.f18061r = c4933b.f17999d;
        this.f18062s = c4933b.f18000e;
        this.f18063t = c4933b.f18001f;
        this.f18064u = c4933b.f18008m;
        this.f18065v = c4933b.f18010o;
        this.f18066w = c4933b.f18009n;
        this.f18067x = c4933b.f18012q;
        this.f18068y = c4933b.f17998c;
        this.f18025A = c4933b.f18017v;
        this.f18026B = c4933b.f18018w;
        this.f18028D = c4933b.f18019x;
        this.f18029E = c4933b.f18020y;
        this.f18031G = c4933b.f18021z;
        this.f18032H = c4933b.f17994A;
        this.f18033I = c4933b.f17995B;
        this.f18034J = c4933b.f18011p;
    }

    /* renamed from: a */
    private boolean m18769a(LinearLayout linearLayout) {
        if (this.f18048e != null) {
            linearLayout.addView(this.f18048e, new LinearLayout.LayoutParams(-1, -2));
            linearLayout.findViewById(C4972c.title_template).setVisibility(8);
            return true;
        }
        if (!TextUtils.isEmpty(this.f18046c)) {
            this.f18035K = (TextView) linearLayout.findViewById(C4972c.alertTitle);
            this.f18035K.setText(this.f18046c);
            return true;
        }
        linearLayout.findViewById(C4972c.title_template).setVisibility(8);
        return false;
    }

    /* renamed from: b */
    private boolean m18771b(LinearLayout linearLayout) {
        this.f18039O = (ScrollView) linearLayout.findViewById(C4972c.scrollView);
        this.f18039O.setFocusable(false);
        this.f18040P = (TextView) linearLayout.findViewById(C4972c.message);
        if (this.f18047d != null) {
            this.f18040P.setText(this.f18047d);
        } else {
            this.f18040P.setVisibility(8);
            this.f18039O.removeView(this.f18040P);
            if (this.f18041Q != null) {
                linearLayout.removeView(this.f18039O);
                linearLayout.addView(this.f18041Q, new LinearLayout.LayoutParams(-1, -1));
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
            } else {
                linearLayout.setVisibility(8);
            }
        }
        return true;
    }

    /* renamed from: a */
    private ListView m18762a(Dialog dialog) {
        ListAdapter c0266z;
        ListView listView = (ListView) LayoutInflater.from(this.f18044a).inflate(C4975d.layout_dialog_lisview, (ViewGroup) null);
        if (this.f18056m) {
            if (this.f18063t == null) {
                c0266z = new C4939h(this, this.f18044a, C4975d.layout_dialog_listview_multichoice, R.id.text1, this.f18061r, listView);
            } else {
                c0266z = new C4940i(this, this.f18044a, this.f18063t, false, listView);
            }
        } else {
            int i = this.f18055l ? C4975d.layout_dialog_listview_singlechoice : C4975d.layout_dialog_listview_item;
            if (this.f18063t == null) {
                c0266z = this.f18062s != null ? this.f18062s : new ArrayAdapter(this.f18044a, i, R.id.text1, this.f18061r);
            } else {
                c0266z = new C0266z(this.f18044a, i, this.f18063t, new String[]{this.f18060q}, new int[]{R.id.text1});
            }
            if (this.f18064u != null) {
                listView.setOnItemClickListener(new C4941j(this, dialog));
            }
        }
        this.f18062s = c0266z;
        if (this.f18065v != null) {
            listView.setOnItemSelectedListener(this.f18065v);
        }
        if (this.f18055l) {
            listView.setChoiceMode(1);
        } else if (this.f18056m) {
            listView.setChoiceMode(2);
        }
        if (this.f18064u != null) {
            listView.setOnItemClickListener(new C4942k(this, dialog));
        } else if (this.f18066w != null) {
            listView.setOnItemClickListener(new C4943l(this, listView, dialog));
        }
        return listView;
    }

    /* renamed from: a */
    private boolean m18768a(FrameLayout frameLayout) {
        if (this.f18049f != null) {
            FrameLayout frameLayout2 = (FrameLayout) frameLayout.findViewById(C4972c.custom);
            frameLayout2.addView(this.f18049f, new ViewGroup.LayoutParams(-1, -1));
            if (this.f18050g) {
                frameLayout2.setPadding(this.f18051h, this.f18052i, this.f18053j, this.f18054k);
            }
            return true;
        }
        frameLayout.setVisibility(8);
        return false;
    }

    /* renamed from: a */
    private boolean m18765a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        Button button;
        if (message == null && onClickListener != null) {
            message = this.f18042R.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case IDlcApi.RC_APPLICATION_BLOCKED /* -3 */:
                button = this.f18037M;
                this.f18027C = message;
                this.f18028D = charSequence;
                break;
            case IDlcApi.RC_SVC_UNAVAILABLE /* -2 */:
                button = this.f18038N;
                this.f18030F = message;
                this.f18031G = charSequence;
                break;
            case -1:
                button = this.f18036L;
                this.f18069z = message;
                this.f18025A = charSequence;
                break;
            default:
                throw new IllegalArgumentException("Unknown button type.");
        }
        button.setOnClickListener(this.f18043S);
        if (!TextUtils.isEmpty(charSequence)) {
            button.setVisibility(0);
            button.setText(charSequence);
            return true;
        }
        button.setVisibility(8);
        return false;
    }

    /* renamed from: a */
    private boolean m18766a(Dialog dialog, LinearLayout linearLayout) {
        this.f18036L = (Button) linearLayout.findViewById(C4972c.button1);
        boolean zM18765a = false | m18765a(-1, this.f18025A, this.f18026B, null);
        this.f18037M = (Button) linearLayout.findViewById(C4972c.button2);
        boolean zM18765a2 = zM18765a | m18765a(-3, this.f18028D, this.f18029E, null);
        this.f18038N = (Button) linearLayout.findViewById(C4972c.button3);
        return m18765a(-2, this.f18031G, this.f18032H, null) | zM18765a2;
    }

    /* renamed from: a */
    private void m18763a(TypedArray typedArray, LinearLayout linearLayout, LinearLayout linearLayout2, View view, View view2, boolean z, boolean z2) {
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
        zArr[i] = this.f18041Q != null;
        int i2 = i + 1;
        if (view.getVisibility() == 0) {
            viewArr[i2] = view;
            zArr[i2] = this.f18068y;
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
    private boolean m18767a(View view) {
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
            if (m18767a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }
}
