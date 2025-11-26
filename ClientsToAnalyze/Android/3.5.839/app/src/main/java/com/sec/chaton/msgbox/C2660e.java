package com.sec.chaton.msgbox;

import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1015an;
import com.sec.chaton.R;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.p046a.p047a.EnumC0791o;
import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.C2302v;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.plugin.p084c.C2934a;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4844bi;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.C4923p;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: MsgboxClose.java */
/* renamed from: com.sec.chaton.msgbox.e */
/* loaded from: classes.dex */
public class C2660e {

    /* renamed from: b */
    private static final String f9537b = C2660e.class.getSimpleName();

    /* renamed from: a */
    InterfaceC2211y f9538a;

    /* renamed from: c */
    private C2210x f9539c;

    /* renamed from: d */
    private Context f9540d;

    /* renamed from: e */
    private C2142w f9541e;

    /* renamed from: f */
    private ProgressDialog f9542f;

    /* renamed from: g */
    private ExecutorService f9543g;

    /* renamed from: h */
    private String f9544h;

    /* renamed from: i */
    private String f9545i;

    /* renamed from: j */
    private int f9546j;

    /* renamed from: k */
    private InterfaceC4936e f9547k;

    /* renamed from: l */
    private Handler f9548l;

    /* renamed from: m */
    private boolean f9549m;

    /* renamed from: n */
    private boolean f9550n;

    /* renamed from: o */
    private boolean f9551o;

    /* renamed from: p */
    private Handler f9552p;

    public C2660e(Context context, String str, int i) {
        this.f9543g = null;
        this.f9544h = null;
        this.f9545i = null;
        this.f9546j = -1;
        this.f9549m = false;
        this.f9538a = new C2670o(this);
        this.f9550n = true;
        this.f9551o = true;
        this.f9552p = new HandlerC2673r(this);
        this.f9540d = context;
        this.f9542f = (ProgressDialog) new C4923p(this.f9540d).m18724a(R.string.buddy_adaptor_wait_progress);
        this.f9544h = str;
        this.f9539c = new C2210x(context.getContentResolver(), this.f9538a);
        this.f9543g = Executors.newSingleThreadExecutor();
        this.f9546j = i;
        this.f9547k = null;
        if (C4904y.f17872b) {
            C4904y.m18639b("MsgboxClose created with inboxNo[" + this.f9544h + "] deleteMode[" + this.f9546j + "]", f9537b);
        }
    }

    public C2660e(Context context, int i) {
        this.f9543g = null;
        this.f9544h = null;
        this.f9545i = null;
        this.f9546j = -1;
        this.f9549m = false;
        this.f9538a = new C2670o(this);
        this.f9550n = true;
        this.f9551o = true;
        this.f9552p = new HandlerC2673r(this);
        this.f9540d = context;
        this.f9542f = (ProgressDialog) new C4923p(this.f9540d).m18724a(R.string.buddy_adaptor_wait_progress);
        this.f9539c = new C2210x(context.getContentResolver(), this.f9538a);
        this.f9543g = Executors.newSingleThreadExecutor();
        this.f9546j = i;
        this.f9547k = null;
        if (C4904y.f17872b) {
            C4904y.m18639b("MsgboxClose created with deleteMode[" + this.f9546j + "]", f9537b);
        }
    }

    /* renamed from: a */
    public void m11236a() {
        if (this.f9542f != null && this.f9542f.isShowing()) {
            this.f9542f.dismiss();
        }
        this.f9540d = null;
        if (this.f9543g != null) {
            this.f9543g.shutdown();
        }
        if (this.f9547k != null) {
            if (this.f9547k.isShowing()) {
                this.f9547k.dismiss();
            }
            this.f9547k = null;
        }
        if (this.f9548l != null) {
            this.f9548l = null;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("MsgboxClose finished", f9537b);
        }
    }

    /* renamed from: b */
    public int m11241b() {
        return this.f9546j;
    }

    /* renamed from: a */
    public void m11239a(C2679x c2679x, Handler handler) {
        if (C4904y.f17872b) {
            C4904y.m18639b("endChatSingle() with EndChatSingleData[" + c2679x + "]", f9537b);
        }
        if (handler != null) {
            this.f9548l = handler;
        }
        if (c2679x.f9606e.booleanValue()) {
            this.f9539c.startQuery(6, c2679x, C2302v.f8225a, new String[]{"inboxsms_mapping_sms_no"}, "inboxsms_mapping_inbox_no = ?", new String[]{c2679x.f9602a}, null);
        } else {
            m11211a(c2679x.f9602a, c2679x.f9603b, c2679x.f9604c, c2679x.f9605d, c2679x.f9606e.booleanValue(), (ArrayList<String>) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11208a(C2679x c2679x, ArrayList<String> arrayList) {
        m11211a(c2679x.f9602a, c2679x.f9603b, c2679x.f9604c, c2679x.f9605d, c2679x.f9606e.booleanValue(), arrayList);
    }

    /* renamed from: a */
    private void m11211a(String str, EnumC2300t enumC2300t, String str2, EnumC2301u enumC2301u, boolean z, ArrayList<String> arrayList) {
        boolean z2 = enumC2301u == EnumC2301u.SMS;
        if (C4904y.f17872b) {
            C4904y.m18639b("checkLockedMessageForDialog()", f9537b);
        }
        HandlerC2661f handlerC2661f = new HandlerC2661f(this, str, enumC2300t, str2, enumC2301u, z, arrayList, z2);
        if (z2 || z) {
            if (C2349a.m10301a("sms_feature")) {
                ArrayList arrayList2 = new ArrayList();
                if (z2) {
                    arrayList2.add(str);
                }
                if (z && arrayList != null && arrayList.size() > 0) {
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!str.equals(next)) {
                            arrayList2.add(next);
                        }
                    }
                }
                if (C4904y.f17872b) {
                    C4904y.m18639b("[SMS]request to find locked SMS", f9537b);
                }
                if (arrayList2 != null && arrayList2.size() > 0) {
                    new C2934a(handlerC2661f, this.f9540d, arrayList2).m12170a();
                    return;
                } else {
                    handlerC2661f.sendEmptyMessage(2);
                    return;
                }
            }
            handlerC2661f.sendEmptyMessage(2);
            return;
        }
        handlerC2661f.sendEmptyMessage(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11217a(boolean z, boolean z2, Runnable runnable, Runnable runnable2) {
        if (this.f9547k == null) {
            this.f9547k = m11192a(z, z2, runnable, runnable2, this.f9540d, this.f9546j);
        }
        if (!this.f9547k.isShowing()) {
            this.f9547k.show();
            if (C4904y.f17872b) {
                C4904y.m18639b("deleteDialog.show()", f9537b);
            }
        }
    }

    /* renamed from: a */
    public static InterfaceC4936e m11192a(boolean z, boolean z2, Runnable runnable, Runnable runnable2, Context context, int i) {
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(context);
        if (z) {
            abstractC4932aM18733a.mo18734a(R.string.menu_close_message_room);
        } else {
            abstractC4932aM18733a.mo18734a(R.string.menu_chat_close);
        }
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.layout_msgbox_close_popup, (ViewGroup) null);
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.isShowPopup);
        checkBox.setText(R.string.chat_delete_popup_include_protected);
        if (z2) {
            checkBox.setVisibility(0);
            checkBox.setChecked(true);
        } else {
            checkBox.setVisibility(8);
        }
        TextView textView = (TextView) viewInflate.findViewById(R.id.popupContent);
        if (i == 7 || i == 6) {
            textView.setText(R.string.this_chatroom_delete_body_message);
        } else {
            textView.setText(R.string.chatroom_deleted_message);
        }
        abstractC4932aM18733a.mo18742a(true);
        abstractC4932aM18733a.mo18748b(viewInflate);
        abstractC4932aM18733a.mo18751b(true).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2669n(checkBox, z2, runnable, runnable2)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2668m());
        return abstractC4932aM18733a.mo18745a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11212a(String str, EnumC2300t enumC2300t, String str2, EnumC2301u enumC2301u, boolean z, boolean z2, ArrayList<String> arrayList) {
        if (C4904y.f17872b) {
            C4904y.m18639b("endChatSingle()", f9537b);
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        if (enumC2301u == EnumC2301u.SMS) {
            arrayList2.add(str);
        } else if (!TextUtils.isEmpty(str2) && enumC2300t != EnumC2300t.BROADCAST) {
            arrayList3.add(str);
            if (z) {
                arrayList2.addAll(arrayList);
            }
        } else {
            arrayList4.add(str);
            if (z) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(it.next());
                }
            }
        }
        new C2681z(this, this.f9543g).m19059d(arrayList3, enumC2300t, arrayList4, arrayList2, str2, Boolean.valueOf(z2));
    }

    /* renamed from: a */
    public void m11240a(C2680y c2680y, Handler handler) {
        if (handler != null) {
            this.f9548l = handler;
        }
        if (c2680y != null) {
            m11212a(c2680y.f9607a.f9602a, c2680y.f9607a.f9603b, c2680y.f9607a.f9604c, c2680y.f9607a.f9605d, c2680y.f9607a.f9606e.booleanValue(), c2680y.f9609c, c2680y.f9608b);
        } else if (C4904y.f17872b) {
            C4904y.m18639b("endChatSingleForChatInfo() data is null", f9537b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11210a(String str, EnumC2300t enumC2300t, String str2) {
        if (C4904y.f17872b) {
            C4904y.m18639b("endChat()", f9537b);
        }
        this.f9541e = C2142w.m9593a(str, enumC2300t);
        this.f9541e.m9246a(this.f9552p);
        this.f9541e.mo9252a(str, C4844bi.m18323a().m18328c().m18329a(), C4844bi.m18323a().m18328c().m18332b());
        this.f9541e.mo9243a(Long.MAX_VALUE);
        if (!this.f9542f.isShowing()) {
            this.f9542f.show();
        }
        this.f9541e.m9621a(enumC2300t, str2, str);
        this.f9541e.m9645b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11216a(boolean z, C0788l c0788l) {
        boolean z2 = false;
        m11232g();
        if (this.f9550n && this.f9551o && z) {
            C0991aa.m6037a().m18961c(new C1015an(new String[0]));
        }
        switch (this.f9546j) {
            case 2:
                if (C4904y.f17872b) {
                    C4904y.m18639b("closeEndChatProgress[DELETE_MODE_MULTI]", f9537b);
                }
                if (this.f9550n && this.f9551o && z) {
                    m11230f();
                    break;
                } else {
                    C5179v.m19810a(this.f9540d, R.string.toast_end_chat_fail, 0).show();
                    break;
                }
                break;
            case 3:
            case 4:
                if (C4904y.f17872b) {
                    C4904y.m18639b("closeEndChatProgress[DELETE_MODE_OLDCHAT or DELETE_MODE_OLDCHAT_VIA_CHATLIST]", f9537b);
                }
                if (this.f9550n && this.f9551o && z) {
                    m11194a(0);
                    break;
                } else {
                    m11194a(-1);
                    break;
                }
            case 5:
                if (C4904y.f17872b) {
                    C4904y.m18639b("closeEndChatProgress[DELETE_MODE_SMSCHAT]", f9537b);
                }
                if (this.f9548l != null) {
                    this.f9548l.sendEmptyMessage(5);
                    break;
                }
                break;
            case 6:
            default:
                if (C4904y.f17875e) {
                    C4904y.m18634a("closeEndChatProgress() do nothing with mDeleteMode[" + this.f9546j + "]", f9537b);
                    break;
                }
                break;
            case 7:
                if (C4904y.f17872b) {
                    C4904y.m18639b("closeEndChatProgress[DELETE_MODE_CHATROOM]", f9537b);
                }
                Message message = new Message();
                message.what = 7;
                if (c0788l != null) {
                    message.obj = c0788l;
                } else {
                    if (this.f9550n && this.f9551o && z) {
                        z2 = true;
                    }
                    message.obj = new C0788l(z2, EnumC0791o.SUCCESS);
                }
                if (this.f9548l != null) {
                    this.f9548l.sendMessage(message);
                    break;
                }
                break;
        }
    }

    /* renamed from: f */
    private void m11230f() {
        if (this.f9540d instanceof MsgboxSelectionActivity) {
            ((MsgboxSelectionActivity) this.f9540d).m11101i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11218a(boolean z, boolean z2, boolean z3, Runnable runnable, Runnable runnable2, int i) {
        if (this.f9547k == null) {
            AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f9540d);
            if (z) {
                abstractC4932aM18733a.mo18734a(R.string.delete_all_items);
            } else {
                abstractC4932aM18733a.mo18734a(R.string.delete);
            }
            View viewInflate = ((LayoutInflater) this.f9540d.getSystemService("layout_inflater")).inflate(R.layout.layout_msgbox_close_popup, (ViewGroup) null);
            CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.isShowPopup);
            checkBox.setText(R.string.chat_delete_popup_include_protected);
            if (z3) {
                checkBox.setVisibility(0);
                checkBox.setChecked(true);
            } else {
                checkBox.setVisibility(8);
            }
            TextView textView = (TextView) viewInflate.findViewById(R.id.popupContent);
            if (i > 1) {
                textView.setText(R.string.multi_chatroom_deleted_message);
            } else {
                textView.setText(R.string.chatroom_deleted_message);
            }
            abstractC4932aM18733a.mo18742a(true);
            abstractC4932aM18733a.mo18748b(viewInflate);
            abstractC4932aM18733a.mo18751b(true).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2675t(this, z3, checkBox, runnable, runnable2)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2674s(this));
            this.f9547k = abstractC4932aM18733a.mo18745a();
        }
        if (!this.f9547k.isShowing()) {
            this.f9547k.show();
            if (C4904y.f17872b) {
                C4904y.m18639b("deleteMultiDialog.show()", f9537b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11209a(Runnable runnable, boolean z) {
        String str;
        if (this.f9547k == null) {
            AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f9540d);
            if (z) {
                abstractC4932aM18733a.mo18734a(R.string.menu_chat_close);
            } else {
                abstractC4932aM18733a.mo18734a(R.string.delete);
            }
            View viewInflate = ((LayoutInflater) this.f9540d.getSystemService("layout_inflater")).inflate(R.layout.layout_msgbox_close_popup, (ViewGroup) null);
            CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.isShowPopup);
            checkBox.setText(R.string.ams_never_show_again);
            if (z) {
                checkBox.setVisibility(8);
            } else {
                checkBox.setVisibility(0);
            }
            TextView textView = (TextView) viewInflate.findViewById(R.id.popupContent);
            if (C4822an.m18194D()) {
                str = String.format(Locale.US, GlobalApplication.m10283b().getString(R.string.settings_chat_delete_old_chat_rooms_popup_text), 3);
                if (C4904y.f17872b) {
                    C4904y.m18639b("deleteOldChatroom country[" + GlobalApplication.m10283b().getConfiguration().locale.getLanguage() + "]", getClass().getSimpleName());
                }
            } else {
                str = String.format(GlobalApplication.m10283b().getString(R.string.settings_chat_delete_old_chat_rooms_popup_text), 3);
            }
            textView.setText(str);
            abstractC4932aM18733a.mo18742a(true);
            abstractC4932aM18733a.mo18748b(viewInflate);
            abstractC4932aM18733a.mo18751b(true).mo18756d(R.string.menu_chat_delete, new DialogInterfaceOnClickListenerC2677v(this, checkBox, runnable)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2676u(this, checkBox));
            this.f9547k = abstractC4932aM18733a.mo18745a();
        }
        if (!this.f9547k.isShowing()) {
            this.f9547k.show();
            if (C4904y.f17872b) {
                C4904y.m18639b("deleteOldchatDialog.show()", f9537b);
            }
        }
    }

    /* renamed from: a */
    public void m11238a(SparseBooleanArray sparseBooleanArray, ListAdapter listAdapter, boolean z, int i) {
        Boolean bool;
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList<>();
        ArrayList<String> arrayList4 = new ArrayList<>();
        HashSet hashSet = new HashSet();
        EnumC2300t enumC2300t = EnumC2300t.UNKNOWN;
        EnumC2301u enumC2301u = EnumC2301u.NORMAL;
        Boolean bool2 = false;
        EnumC2300t enumC2300t2 = EnumC2300t.UNKNOWN;
        int i2 = 0;
        while (i2 < sparseBooleanArray.size()) {
            if (sparseBooleanArray.valueAt(i2)) {
                Cursor cursor = (Cursor) listAdapter.getItem(sparseBooleanArray.keyAt(i2));
                String string = cursor.getString(cursor.getColumnIndex("inbox_session_id"));
                EnumC2300t enumC2300tM10207a = EnumC2300t.m10207a(cursor.getInt(cursor.getColumnIndex("inbox_chat_type")));
                String string2 = cursor.getString(cursor.getColumnIndex("inbox_no"));
                EnumC2301u enumC2301uM10211a = EnumC2301u.m10211a(cursor.getInt(cursor.getColumnIndex("inbox_room_type")));
                String string3 = cursor.getString(cursor.getColumnIndex("sms_unread_count"));
                bool = (TextUtils.isEmpty(string3) || string3.length() <= 0) ? bool2 : true;
                if (C4904y.f17872b) {
                    C4904y.m18639b("endChatMultiple() sessionID[" + string + "]", getClass().getSimpleName());
                }
                if (enumC2301uM10211a.equals(EnumC2301u.SMS)) {
                    arrayList3.add(string2);
                } else {
                    if (bool.booleanValue()) {
                        arrayList4.add(string2);
                    }
                    if (hashSet.contains(string) || enumC2300tM10207a == EnumC2300t.BROADCAST || TextUtils.isEmpty(string)) {
                        arrayList2.add(string2);
                    } else {
                        arrayList.add(string2);
                        if (arrayList.size() == 1) {
                            enumC2300t = enumC2300tM10207a;
                        }
                        hashSet.add(string);
                    }
                }
            } else {
                bool = bool2;
            }
            i2++;
            bool2 = bool;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("endChatMultiple() sessionIDs[" + hashSet + "]", getClass().getSimpleName());
        }
        if (arrayList4.size() > 0) {
            m11207a(new C2678w(arrayList, arrayList2, arrayList3, enumC2300t, z, i), arrayList4);
        } else {
            m11215a(arrayList, arrayList2, arrayList3, enumC2300t, z, i);
        }
    }

    /* renamed from: a */
    private void m11207a(C2678w c2678w, ArrayList<String> arrayList) {
        if (C4904y.f17872b) {
            C4904y.m18639b("queryMappedSMSMultiple() with data[" + c2678w + "] and mappedInbox[" + arrayList + "]", f9537b);
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (sb.length() == 0) {
                sb.append("(");
            } else {
                sb.append(", ");
            }
            sb.append("'").append(next).append("'");
        }
        sb.append(")");
        this.f9539c.startQuery(7, c2678w, C2302v.f8225a, new String[]{"inboxsms_mapping_sms_no"}, "inboxsms_mapping_inbox_no IN " + sb.toString(), null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11195a(Cursor cursor) {
        if (!cursor.moveToFirst()) {
            m11194a(-1);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList<>();
        HashSet hashSet = new HashSet();
        EnumC2300t enumC2300t = EnumC2300t.UNKNOWN;
        EnumC2301u enumC2301u = EnumC2301u.NORMAL;
        Boolean bool = false;
        EnumC2300t enumC2300t2 = EnumC2300t.UNKNOWN;
        int columnIndex = cursor.getColumnIndex("inbox_session_id");
        int i = cursor.getInt(cursor.getColumnIndex("inbox_chat_type"));
        int columnIndex2 = cursor.getColumnIndex("inbox_no");
        int columnIndex3 = cursor.getColumnIndex("inbox_room_type");
        int columnIndex4 = cursor.getColumnIndex("sms_unread_count");
        do {
            try {
                try {
                    String string = cursor.getString(columnIndex);
                    EnumC2300t enumC2300tM10207a = EnumC2300t.m10207a(i);
                    String string2 = cursor.getString(columnIndex2);
                    EnumC2301u enumC2301uM10211a = EnumC2301u.m10211a(cursor.getInt(columnIndex3));
                    String string3 = cursor.getString(columnIndex4);
                    if (!TextUtils.isEmpty(string3) && string3.length() > 0) {
                        bool = true;
                    }
                    if (C4904y.f17872b) {
                        C4904y.m18639b("endChatMultiple() for old chat sessionID[" + string + "]", getClass().getSimpleName());
                    }
                    if (!enumC2301uM10211a.equals(EnumC2301u.SMS)) {
                        if (bool.booleanValue()) {
                            arrayList3.add(string2);
                        }
                        if (hashSet.contains(string) || enumC2300tM10207a == EnumC2300t.BROADCAST || TextUtils.isEmpty(string)) {
                            arrayList2.add(string2);
                        } else {
                            arrayList.add(string2);
                            if (arrayList.size() == 1) {
                                enumC2300t = enumC2300tM10207a;
                            }
                            hashSet.add(string);
                        }
                    }
                } catch (SQLException e) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, C2660e.class.getSimpleName());
                    }
                }
            } catch (Throwable th) {
                cursor.close();
                throw th;
            }
        } while (cursor.moveToNext());
        cursor.close();
        if (C4904y.f17872b) {
            C4904y.m18639b("endChatMultiple() for old chat sessionIDs[" + hashSet + "]", getClass().getSimpleName());
        }
        if (arrayList3.size() > 0) {
            m11207a(new C2678w(arrayList, arrayList2, null, enumC2300t, true, -1), arrayList3);
        } else {
            m11214a(arrayList, arrayList2, enumC2300t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m11222b(C2678w c2678w, ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (c2678w.f9598c != null && c2678w.f9598c.size() > 0) {
            arrayList2.addAll(c2678w.f9598c);
        }
        if (arrayList != null && arrayList.size() > 0) {
            arrayList2.addAll(arrayList);
        }
        if (c2678w.f9601f > 0) {
            m11215a(c2678w.f9596a, c2678w.f9597b, arrayList2, c2678w.f9599d, c2678w.f9600e, c2678w.f9601f);
        } else {
            m11214a(c2678w.f9596a, c2678w.f9597b, c2678w.f9599d);
        }
    }

    /* renamed from: a */
    private void m11215a(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, EnumC2300t enumC2300t, boolean z, int i) {
        boolean z2 = arrayList3 != null && arrayList3.size() > 0;
        if (C4904y.f17872b) {
            C4904y.m18639b("checkLockedMessageForDialog()", f9537b);
        }
        HandlerC2664i handlerC2664i = new HandlerC2664i(this, z, z2, arrayList, enumC2300t, arrayList2, arrayList3, i);
        if (z2) {
            if (C2349a.m10301a("sms_feature")) {
                new C2934a(handlerC2664i, this.f9540d, arrayList3).m12170a();
                return;
            } else {
                handlerC2664i.sendEmptyMessage(2);
                return;
            }
        }
        handlerC2664i.sendEmptyMessage(2);
    }

    /* renamed from: a */
    private void m11214a(ArrayList<String> arrayList, ArrayList<String> arrayList2, EnumC2300t enumC2300t) {
        if (C4904y.f17872b) {
            C4904y.m18639b("checkLockedMessageForOldchatDialog()", f9537b);
        }
        m11209a(new RunnableC2667l(this, arrayList, enumC2300t, arrayList2), this.f9546j == 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11213a(ArrayList<String> arrayList, EnumC2300t enumC2300t) {
        if (C4904y.f17872b) {
            C4904y.m18639b("asyncEndChat()", f9537b);
        }
        this.f9541e = C2142w.m9593a(arrayList.get(0), enumC2300t);
        this.f9541e.m9246a(this.f9552p);
        this.f9541e.mo9252a(arrayList.get(0), C4844bi.m18323a().m18328c().m18329a(), C4844bi.m18323a().m18328c().m18332b());
        this.f9541e.mo9243a(Long.MAX_VALUE);
        if (!this.f9542f.isShowing()) {
            this.f9542f.show();
        }
        this.f9541e.m9629a(arrayList);
    }

    /* renamed from: g */
    private void m11232g() {
        if (this.f9542f.isShowing()) {
            this.f9542f.dismiss();
            if (C4904y.f17872b) {
                C4904y.m18639b("closeEndChatProgressDialog()", f9537b);
            }
        }
    }

    /* renamed from: c */
    public void m11242c() {
        if (C4904y.f17872b) {
            C4904y.m18639b("endOldChatViaSettings() start", f9537b);
        }
        this.f9539c.startQuery(3, null, C2299s.f8209a, new String[]{"inbox_no"}, "inbox_room_type != " + EnumC2301u.SMS.m10212a(), null, null);
    }

    /* renamed from: d */
    public void m11243d() {
        long jCurrentTimeMillis = System.currentTimeMillis() - 7776000000L;
        if (C4904y.f17872b) {
            C4904y.m18639b("start QUERY_OLD_MSGBOX ", f9537b);
        }
        this.f9539c.startQuery(4, null, C2299s.m10205r(), new String[]{"inbox_no", "inbox_session_id", "inbox_chat_type", "inbox_room_type", "sms_unread_count"}, "inbox_room_type != " + EnumC2301u.SMS.m10212a() + " AND inbox_last_chat_type != 12 AND (inbox_last_time IS NULL OR inbox_last_time = 0 OR inbox_last_time < ?)", new String[]{String.valueOf(jCurrentTimeMillis)}, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11194a(int i) {
        switch (i) {
            case -1:
                Toast.makeText(this.f9540d, R.string.settings_chat_delete_old_chat_rooms_failed_toast, 0).show();
                if (C4904y.f17872b) {
                    C4904y.m18639b("No old Chatroom", f9537b);
                    break;
                }
                break;
            case 0:
                Toast.makeText(this.f9540d, R.string.settings_chat_delete_old_chat_rooms_success_toast, 0).show();
                if (C4904y.f17872b) {
                    C4904y.m18639b("Delete old Chat Rooms", f9537b);
                    break;
                }
                break;
            case 1:
            case 2:
                Toast.makeText(this.f9540d, R.string.settings_chat_delete_old_chat_rooms_no_chatroom_toast, 0).show();
                if (C4904y.f17872b) {
                    C4904y.m18639b("No old Chatroom", f9537b);
                    break;
                }
                break;
            default:
                if (C4904y.f17872b) {
                    C4904y.m18639b("Delete old failed", f9537b);
                    break;
                }
                break;
        }
    }

    /* renamed from: a */
    public void m11237a(Handler handler) {
        if (C4904y.f17872b) {
            C4904y.m18639b("endSMSChat() start", f9537b);
        }
        if (handler != null) {
            this.f9548l = handler;
        }
        this.f9539c.startQuery(5, null, C2299s.f8209a, new String[]{"inbox_no"}, "inbox_room_type = " + EnumC2301u.SMS.m10212a(), null, null);
    }
}
