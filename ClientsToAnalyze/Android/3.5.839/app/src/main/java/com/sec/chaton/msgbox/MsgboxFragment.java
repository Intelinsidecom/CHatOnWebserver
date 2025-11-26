package com.sec.chaton.msgbox;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.provider.Telephony;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.coolots.sso.p030a.InterfaceC0418c;
import com.samsung.android.sdk.look.airbutton.SlookAirButton;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1015an;
import com.sec.chaton.C1071bk;
import com.sec.chaton.InterfaceC2318el;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.p050a.EnumC1109f;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.chat.ChatInfoActivity;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p049b.ContextMenuC1056a;
import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p057e.C2287g;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p057e.p058a.C2192f;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.p057e.p059b.C2244e;
import com.sec.chaton.p065io.entry.InboxExtraEntry;
import com.sec.chaton.p072k.p073a.C2477a;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.qmlog.C3119a;
import com.sec.chaton.qmlog.EnumC3126h;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p112ui.C4149cd;
import com.sec.chaton.smsplugin.provider.C3947e;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4811ac;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4878cp;
import com.sec.chaton.util.C4902w;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4879cq;
import com.sec.chaton.widget.C4923p;
import com.sec.chaton.widget.ClearableEditText;
import com.sec.chaton.widget.ImageTextViewGroup;
import com.sec.common.CommonApplication;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.common.p132g.C5007c;
import com.sec.common.tooltip.C5013c;
import com.sec.common.util.C5034k;
import com.sec.common.util.log.collector.C5043h;
import com.sec.widget.C5179v;
import com.sec.widget.FastScrollableListView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

/* loaded from: classes.dex */
public class MsgboxFragment extends ListFragment implements InterfaceC0418c, InterfaceC2318el {

    /* renamed from: A */
    private TextView f9322A;

    /* renamed from: B */
    private TextView f9323B;

    /* renamed from: C */
    private C2608a f9324C;

    /* renamed from: D */
    private C2210x f9325D;

    /* renamed from: E */
    private String f9326E;

    /* renamed from: F */
    private String f9327F;

    /* renamed from: G */
    private long f9328G;

    /* renamed from: H */
    private EnumC2300t f9329H;

    /* renamed from: I */
    private String f9330I;

    /* renamed from: J */
    private int f9331J;

    /* renamed from: K */
    private int f9332K;

    /* renamed from: N */
    private ProgressDialog f9335N;

    /* renamed from: O */
    private View f9336O;

    /* renamed from: P */
    private ImageTextViewGroup f9337P;

    /* renamed from: S */
    private C5007c f9340S;

    /* renamed from: V */
    private View f9343V;

    /* renamed from: W */
    private ClearableEditText f9344W;

    /* renamed from: X */
    private View f9345X;

    /* renamed from: Z */
    private ImageButton f9347Z;

    /* renamed from: aa */
    private ImageButton f9348aa;

    /* renamed from: ae */
    private C2642bg f9351ae;

    /* renamed from: af */
    private InterfaceC4936e f9352af;

    /* renamed from: ai */
    private HandlerC2643bh f9355ai;

    /* renamed from: s */
    private FastScrollableListView f9364s;

    /* renamed from: t */
    private ViewStub f9365t;

    /* renamed from: u */
    private View f9366u;

    /* renamed from: v */
    private LinearLayout f9367v;

    /* renamed from: w */
    private View f9368w;

    /* renamed from: x */
    private View f9369x;

    /* renamed from: y */
    private LinearLayout f9370y;

    /* renamed from: z */
    private ImageView f9371z;

    /* renamed from: i */
    public static final String f9318i = MsgboxFragment.class.getSimpleName();

    /* renamed from: j */
    public static String f9319j = "extra_search_title";

    /* renamed from: k */
    public static String f9320k = "extra_search_cursor";

    /* renamed from: l */
    public static String f9321l = "chiness_chat_title";

    /* renamed from: ad */
    private static int f9317ad = 0;

    /* renamed from: L */
    private boolean f9333L = false;

    /* renamed from: M */
    private String f9334M = "";

    /* renamed from: Q */
    private boolean f9338Q = false;

    /* renamed from: R */
    private int f9339R = 1;

    /* renamed from: T */
    private boolean f9341T = false;

    /* renamed from: U */
    private boolean f9342U = false;

    /* renamed from: Y */
    private boolean f9346Y = false;

    /* renamed from: ab */
    private ExecutorService f9349ab = null;

    /* renamed from: ac */
    private C2660e f9350ac = null;

    /* renamed from: ag */
    private boolean f9353ag = true;

    /* renamed from: ah */
    private Handler f9354ah = new HandlerC2622an(this);

    /* renamed from: m */
    ContentObserver f9358m = new C2624ap(this, new Handler());

    /* renamed from: n */
    ContentObserver f9359n = new C2625aq(this, new Handler());

    /* renamed from: o */
    protected int f9360o = 0;

    /* renamed from: p */
    InterfaceC2211y f9361p = new C2626ar(this);

    /* renamed from: aj */
    private final TextWatcher f9356aj = new C2628at(this);

    /* renamed from: ak */
    private final SlookAirButton.ItemSelectListener f9357ak = new C2629au(this);

    /* renamed from: q */
    BroadcastReceiver f9362q = new C2630av(this);

    /* renamed from: r */
    ContentObserver f9363r = new C2631aw(this, new Handler());

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        C2610ab c2610ab = null;
        super.onCreate(bundle);
        this.f9325D = new C2210x(getActivity().getContentResolver(), this.f9361p);
        this.f9351ae = new C2642bg(this, c2610ab);
        C0991aa.m6037a().m18959a(this.f9351ae);
        this.f9355ai = new HandlerC2643bh(this, c2610ab);
    }

    /* renamed from: c */
    private int m11050c() {
        return R.layout.list_item_common_6_non_checkable;
    }

    @Override // android.support.v4.app.ListFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException {
        if (C4904y.f17872b) {
            C4904y.m18639b("onCreateView()", f9318i);
        }
        this.f9340S = new C5007c();
        View viewInflate = layoutInflater.inflate(R.layout.layout_msgbox, viewGroup, false);
        this.f9343V = viewInflate.findViewById(R.id.chatRoomSearchField);
        this.f9343V.setBackgroundColor(Color.parseColor("#fafafa"));
        this.f9344W = (ClearableEditText) this.f9343V.findViewById(R.id.text1);
        this.f9344W.setFilters(new InputFilter[]{new C4902w(getActivity(), 30)});
        this.f9346Y = false;
        this.f9344W.setImeOptions(268435459);
        this.f9344W.setOnEditorActionListener(new C2610ab(this));
        this.f9344W.m18659a(this.f9356aj);
        String string = getResources().getString(R.string.chat_search_chat_title);
        if (!C4822an.m18218a()) {
            string = getResources().getString(R.string.chat_search_message_title);
        }
        this.f9344W.setHint(string);
        this.f9344W.setOnFocusChangeListener(new ViewOnFocusChangeListenerC2621am(this));
        this.f9345X = viewInflate.findViewById(R.id.chatlist_no_search_result);
        m11064i();
        this.f9348aa = (ImageButton) this.f9343V.findViewById(R.id.button2);
        this.f9348aa.setContentDescription(getResources().getString(R.string.layout_chat_fragment_delete));
        this.f9348aa.setVisibility(0);
        this.f9348aa.setEnabled(false);
        this.f9348aa.setImageResource(R.drawable.selector_ic_delete);
        this.f9348aa.setOnClickListener(new ViewOnClickListenerC2632ax(this));
        this.f9365t = (ViewStub) viewInflate.findViewById(R.id.msg_no);
        this.f9368w = viewInflate.findViewById(R.id.msg_header);
        this.f9368w.setOnClickListener(new ViewOnClickListenerC2634az(this));
        this.f9368w.setVisibility(8);
        this.f9367v = (LinearLayout) viewInflate.findViewById(R.id.linList);
        this.f9370y = (LinearLayout) viewInflate.findViewById(R.id.msg_loading);
        this.f9364s = (FastScrollableListView) viewInflate.findViewById(android.R.id.list);
        this.f9364s.setDivider(null);
        this.f9364s.setOnScrollListener(new C2636ba(this));
        if (C2349a.m10301a("sms_feature")) {
            m11086t();
        }
        this.f9336O = viewInflate.findViewById(R.id.first_chatlist_sync);
        this.f9336O.setFocusable(false);
        this.f9336O.setEnabled(false);
        this.f9336O.setClickable(false);
        this.f9337P = (ImageTextViewGroup) this.f9336O.findViewById(R.id.button4);
        this.f9337P.setText(R.string.load_chat_list_history_button);
        this.f9337P.setImageResource(R.drawable.sync_ic_sync);
        this.f9337P.setGravity(17);
        this.f9337P.setContentDescription(getString(R.string.load_chat_list_history_button));
        this.f9337P.setFocusable(true);
        this.f9337P.setOnClickListener(new ViewOnClickListenerC2637bb(this));
        this.f9324C = new C2608a(getActivity(), this.f9364s, m11050c(), null, this.f9340S, this.f9357ak);
        this.f9324C.m11159b("");
        this.f9341T = true;
        this.f9342U = true;
        m11080q();
        this.f9349ab = Executors.newSingleThreadExecutor();
        return viewInflate;
    }

    /* renamed from: a */
    public void m11098a(String str) {
        this.f9325D.startQuery(2, str, Uri.withAppendedPath(C2287g.f8193a, "inbox/fullsearch").buildUpon().appendQueryParameter("pattern", str).build(), null, null, null, null);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            if (arguments.containsKey("content_type")) {
                this.f9333L = true;
            }
            if (arguments.containsKey("download_uri")) {
            }
            if (arguments.containsKey("sub_content")) {
            }
            if (arguments.containsKey("forward_sender_name")) {
            }
            if (arguments.containsKey("inboxNO")) {
            }
            if (arguments.containsKey("mode")) {
                this.f9339R = arguments.getInt("mode");
            }
            if (arguments.containsKey(C1071bk.f3371e)) {
            }
            if (arguments.containsKey("is_forward_mode")) {
            }
            BaseActivity.m6160a((Fragment) this, true);
        }
        m61a(this.f9324C);
        m60a().setChoiceMode(0);
        this.f9324C.m11156a(0);
        m60a().setItemsCanFocus(false);
        registerForContextMenu(m60a());
        if (this.f9339R == 3) {
            m60a().setChoiceMode(1);
            this.f9324C.m11156a(1);
        } else if (this.f9339R == 4) {
            m60a().setChoiceMode(2);
            this.f9324C.m11156a(2);
        }
        m11055d();
        this.f9335N = (ProgressDialog) new C4923p(getActivity()).m18724a(R.string.buddy_adaptor_wait_progress);
        this.f9353ag = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m11055d() {
        if (this.f9364s.getCount() <= 1) {
            if (!C4822an.m18218a() || this.f9364s.getCount() <= 0) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("showEmptyList()", f9318i);
                }
                if (this.f9366u == null) {
                    this.f9366u = this.f9365t.inflate();
                }
                if (this.f9371z == null) {
                    this.f9371z = (ImageView) this.f9366u.findViewById(R.id.image1);
                    this.f9371z.setImageResource(R.drawable.no_contents_chat);
                }
                if (this.f9322A == null) {
                    this.f9322A = (TextView) this.f9366u.findViewById(R.id.text1);
                    this.f9322A.setText(getResources().getString(R.string.no_chats));
                }
                if (this.f9323B == null) {
                    this.f9323B = (TextView) this.f9366u.findViewById(R.id.text2);
                    this.f9323B.setText(getResources().getString(R.string.chatlist_no_chat_2));
                }
                this.f9366u.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m11057e() {
        if (C4904y.f17872b) {
            C4904y.m18639b("hideEmptyList()", f9318i);
        }
        if (this.f9366u != null) {
            this.f9366u.setVisibility(0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f9338Q = false;
        if (C4904y.f17872b) {
            C4904y.m18639b("onResume()", f9318i);
        }
        if (!TextUtils.isEmpty(GlobalApplication.f8359e)) {
            GlobalApplication.f8359e = null;
            this.f9340S.m19014a();
            this.f9340S = new C5007c();
            this.f9324C.m11157a(this.f9340S);
        }
        m60a().setChoiceMode(0);
        this.f9324C.m11156a(0);
        m60a().setItemsCanFocus(false);
        if (C3847e.m14656aG()) {
            this.f9359n.dispatchChange(true);
        }
        m11084s();
        m11031a(m11090v());
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (C4904y.f17872b) {
            C4904y.m18639b("onPause()", f9318i);
        }
        this.f9338Q = true;
        m11073m();
        if (this.f9344W != null) {
            this.f9344W.setText("");
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        m11063h();
        m11066j();
        if (C4904y.f17872b) {
            C4904y.m18639b("onStart()", f9318i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        if (C4904y.f17872b) {
            C4904y.m18639b("onStop()", f9318i);
        }
        super.onStop();
    }

    @Override // android.support.v4.app.ListFragment
    /* renamed from: a */
    public void mo62a(ListView listView, View view, int i, long j) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onListItemClick() position[" + i + "]", f9318i);
        }
        int iM11045b = m11045b(i);
        switch (this.f9339R) {
            case 1:
                Cursor cursor = (Cursor) m63b().getItem(iM11045b);
                if (C2349a.m10301a("sms_feature") && EnumC2301u.m10211a(cursor.getInt(cursor.getColumnIndex("inbox_room_type"))) == EnumC2301u.SMS) {
                    String string = cursor.getString(cursor.getColumnIndex("inbox_no"));
                    if (!C3947e.m15262c(getActivity().getContentResolver(), Long.parseLong(string))) {
                        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(getActivity());
                        abstractC4932aM18733a.mo18734a(R.string.chat_delete_toast_already_deleted);
                        abstractC4932aM18733a.mo18746b(R.string.chat_delete_toast_already_deleted_body);
                        abstractC4932aM18733a.mo18751b(true).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2638bc(this, string));
                        abstractC4932aM18733a.mo18752b();
                        break;
                    }
                }
                if (this.f9344W != null) {
                    this.f9344W.setText("");
                }
                m11073m();
                ((InterfaceC2641bf) getActivity()).mo3084a(cursor, this.f9333L);
                break;
        }
    }

    /* renamed from: a */
    private String m11030a(String str, EnumC2300t enumC2300t, String str2, String str3, int i) throws Resources.NotFoundException {
        if (enumC2300t == EnumC2300t.ONETOONE) {
            if (str3.equals("Y") || str == null) {
            }
        } else if (EnumC2300t.m10208a(enumC2300t)) {
            C1736gi.m8634a(str3, str2);
        } else if (enumC2300t == EnumC2300t.MONOLOGUE) {
            if (TextUtils.isEmpty(str2)) {
                GlobalApplication.m10283b().getString(R.string.buddy_profile_interaction_me);
            }
        } else if (i == 0) {
            getResources().getString(R.string.no_contacts);
        }
        return str2;
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) throws Throwable {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        ContextMenuC1056a contextMenuC1056a = new ContextMenuC1056a(getActivity(), contextMenu);
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
        if (adapterContextMenuInfo != null) {
            adapterContextMenuInfo.position = m11045b(adapterContextMenuInfo.position);
            Cursor cursor = (Cursor) m63b().getItem(adapterContextMenuInfo.position);
            this.f9326E = cursor.getString(cursor.getColumnIndex("inbox_no"));
            String string = cursor.getString(cursor.getColumnIndex("inbox_title"));
            this.f9327F = cursor.getString(cursor.getColumnIndex("inbox_session_id"));
            this.f9328G = cursor.getLong(cursor.getColumnIndex("lasst_session_merge_time"));
            this.f9329H = EnumC2300t.m10207a(cursor.getInt(cursor.getColumnIndex("inbox_chat_type")));
            this.f9330I = cursor.getString(cursor.getColumnIndex("inbox_server_ip"));
            this.f9331J = cursor.getInt(cursor.getColumnIndex("inbox_server_port"));
            this.f9332K = cursor.getInt(cursor.getColumnIndex("inbox_participants"));
            String string2 = cursor.getString(cursor.getColumnIndex("buddy_name"));
            String string3 = cursor.getString(cursor.getColumnIndex("inbox_title_fixed"));
            String string4 = cursor.getString(cursor.getColumnIndex("profile_url"));
            String string5 = cursor.getString(cursor.getColumnIndex("buddy_no"));
            boolean zEquals = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_valid")));
            boolean zEquals2 = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_enable_noti")));
            String string6 = cursor.getString(cursor.getColumnIndex("relation_buddy_no"));
            EnumC2301u enumC2301uM10211a = EnumC2301u.m10211a(cursor.getInt(cursor.getColumnIndex("inbox_room_type")));
            String string7 = cursor.getString(cursor.getColumnIndex("sms_unread_count"));
            boolean z = !TextUtils.isEmpty(string7) && string7.length() > 0;
            String string8 = cursor.getString(cursor.getColumnIndex("participants_sms_address"));
            int i = cursor.getInt(cursor.getColumnIndex("inbox_last_chat_type"));
            int i2 = cursor.getInt(cursor.getColumnIndex("inbox_cmas_thread_type"));
            EnumC1109f enumC1109fM7094a = EnumC1109f.m7094a(cursor.getString(cursor.getColumnIndex("participants_user_type")));
            String string9 = cursor.getString(cursor.getColumnIndex("inbox_topic_type"));
            String str = "";
            String str2 = "";
            if (!TextUtils.isEmpty(string9)) {
                try {
                    InboxExtraEntry inboxExtraEntry = (InboxExtraEntry) new C2477a(string9).m10709a(InboxExtraEntry.class);
                    str = inboxExtraEntry.topicchattype.suid;
                    str2 = inboxExtraEntry.topicchattype.ctid;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (InstantiationException e3) {
                    e3.printStackTrace();
                } catch (JSONException e4) {
                    e4.printStackTrace();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            C2142w.m9593a(this.f9326E, this.f9329H).mo9244a(this.f9327F);
            C2142w.m9593a(this.f9326E, this.f9329H).mo9266b(this.f9328G);
            C4904y.m18644d("serverIP:" + this.f9330I);
            C4904y.m18644d("serverPort:" + this.f9331J);
            if (TextUtils.isEmpty(string)) {
                if (zEquals && this.f9329H == EnumC2300t.GROUPCHAT) {
                    string = getResources().getString(R.string.no_contacts);
                }
                if (zEquals && this.f9329H == EnumC2300t.ONETOONE) {
                    string = getResources().getString(R.string.unknown);
                }
                if (zEquals && EnumC2300t.m10208a(this.f9329H)) {
                    string = getResources().getString(R.string.no_contacts);
                }
            }
            contextMenuC1056a.setHeaderTitle(string);
            if (C2349a.m10301a("sms_feature") && enumC2301uM10211a == EnumC2301u.SMS) {
                if (!C3847e.m14656aG() || !C3847e.m14649a(i2)) {
                    contextMenuC1056a.add(R.string.chat_view_menu_info2).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC2639bd(this, string));
                    if (this.f9329H == EnumC2300t.ONETOONE) {
                        if (zEquals2) {
                            contextMenuC1056a.add(R.string.chaton_live_buddy_alert_off).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC2640be(this, zEquals2));
                        } else {
                            contextMenuC1056a.add(R.string.chaton_live_buddy_alert_on).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC2611ac(this, zEquals2));
                        }
                        if (!TextUtils.isEmpty(string8)) {
                            String strM9884h = C2192f.m9884h(string8);
                            int i3 = R.string.menu_view_contact;
                            if (TextUtils.isEmpty(strM9884h)) {
                                i3 = R.string.add_to_contact;
                            }
                            contextMenuC1056a.add(i3).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC2612ad(this, strM9884h, string8, string));
                        }
                        if (C3847e.m14671ac() && !TextUtils.isEmpty(string8)) {
                            if (C4149cd.m16431d(getActivity(), string8)) {
                                contextMenuC1056a.add(R.string.menu_unregister_as_spamnumber).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC2613ae(this, string8));
                            } else {
                                contextMenuC1056a.add(R.string.menu_register_as_spamnumber).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC2614af(this, string8));
                            }
                        }
                    }
                }
                contextMenuC1056a.add(R.string.menu_chat_close).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC2615ag(this, enumC2301uM10211a, z));
                return;
            }
            if (zEquals) {
                if (enumC1109fM7094a != EnumC1109f.CONTENTS) {
                    contextMenuC1056a.add(R.string.chat_view_menu_info2).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC2616ah(this, enumC2301uM10211a, string5, string2, str, str2, zEquals2, string, string3, string6, i, z));
                }
                if (!EnumC2300t.m10208a(this.f9329H) && this.f9329H != EnumC2300t.MONOLOGUE) {
                    if (zEquals2) {
                        contextMenuC1056a.add(R.string.chaton_live_buddy_alert_off).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC2617ai(this, zEquals2));
                    } else {
                        contextMenuC1056a.add(R.string.chaton_live_buddy_alert_on).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC2618aj(this, zEquals2));
                    }
                }
                contextMenuC1056a.add(R.string.buddy_list_add_to_home_screen).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC2619ak(this, zEquals, string2, string5, string, string3, string6, string4, enumC2301uM10211a));
            }
            contextMenuC1056a.add(R.string.menu_chat_close).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC2620al(this, enumC2301uM10211a, z));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11042a(String str, String str2, boolean z, String str3, String str4, EnumC2300t enumC2300t, String str5, String str6, int i, String str7, String str8, EnumC2301u enumC2301u, int i2, boolean z2, int i3) throws Resources.NotFoundException {
        if (TextUtils.isEmpty(str8) || str8.equals(str)) {
            str8 = null;
        }
        if (enumC2300t == EnumC2300t.MONOLOGUE && TextUtils.isEmpty(str4)) {
            str4 = getResources().getString(R.string.buddy_profile_interaction_me);
        }
        Intent intent = new Intent(getActivity(), (Class<?>) ChatInfoActivity.class);
        intent.putExtra("ACTIVITY_PURPOSE", 6);
        intent.putExtra(ChatFragment.f5472h, true);
        intent.putExtra(ChatFragment.f5469e, str4);
        intent.putExtra("inboxNO", str3);
        intent.putExtra("chatType", enumC2300t.m10210a());
        intent.putExtra("buddyNO", str);
        intent.putExtra("inboxValid", true);
        intent.putExtra(ChatFragment.f5476l, z);
        intent.putExtra("sessionID", str5);
        intent.putExtra("inbox_server_ip", str6);
        intent.putExtra("inbox_server_port", i);
        intent.putExtra("ACTIVITY_PURPOSE_ARG", true);
        intent.putExtra("inbox_title_fixed", str7);
        if (!TextUtils.isEmpty(str8)) {
            intent.putExtra("groupId", str8);
        }
        intent.putExtra("roomType", enumC2301u.m10212a());
        intent.putExtra("inbox_last_chat_type", i2);
        intent.putExtra("isMapping", z2);
        intent.putExtra("inbox_participants", i3);
        if (enumC2300t == EnumC2300t.TOPIC) {
            intent.putExtra("topicChatLiveId", str);
            intent.putExtra("topicChatCtid", str2);
        }
        startActivityForResult(intent, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m11048b(boolean z, String str) {
        int iM9913a;
        if (z) {
            iM9913a = C2198l.m9913a(CommonApplication.m18732r().getContentResolver(), str, false);
        } else {
            iM9913a = C2198l.m9913a(CommonApplication.m18732r().getContentResolver(), str, true);
        }
        if (iM9913a > 0) {
            C0991aa.m6037a().m18961c(new C1015an(new String[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11043a(boolean z, String str, String str2, String str3, EnumC2300t enumC2300t, String str4, int i, String str5, String str6, String str7, EnumC2301u enumC2301u) throws Resources.NotFoundException {
        File fileM10771b;
        String string;
        C4904y.m18641c("[SHORTCUT] CONTEXT_MENU_ADD_SHORTCUT start, Memory Address:" + this, f9318i);
        String strM11030a = m11030a(str, enumC2300t, str4, str5, i);
        Intent intentM18134a = C4811ac.m18134a(getActivity(), enumC2300t == EnumC2300t.ONETOONE ? str2 : str3, enumC2300t, enumC2301u);
        int i2 = R.drawable.shortcut_chat_icon;
        if (enumC2301u == EnumC2301u.LIVE) {
            i2 = R.drawable.shortcut_livepartner_icon;
        }
        if (enumC2300t == EnumC2300t.ONETOONE) {
            fileM10771b = C2496n.m10757a(getActivity(), str2);
        } else {
            fileM10771b = C2496n.m10771b(getActivity(), str3);
        }
        try {
            Bitmap bitmapM18135a = C4811ac.m18135a(fileM10771b, C2496n.m10752a(enumC2300t), i2);
            if (TextUtils.isEmpty(strM11030a)) {
                string = (z && enumC2300t == EnumC2300t.GROUPCHAT) ? getResources().getString(R.string.no_contacts) : strM11030a;
                if (z && enumC2300t == EnumC2300t.ONETOONE) {
                    string = getResources().getString(R.string.unknown);
                }
                if (z && EnumC2300t.m10208a(enumC2300t)) {
                    string = getResources().getString(R.string.no_contacts);
                }
                if (enumC2300t == EnumC2300t.MONOLOGUE) {
                    string = getResources().getString(R.string.buddy_profile_interaction_me);
                }
            } else {
                string = strM11030a;
            }
            if (enumC2300t == EnumC2300t.ONETOONE) {
                if (string.length() > 30) {
                    string = string.substring(0, 29) + "...";
                }
            } else if (enumC2300t == EnumC2300t.GROUPCHAT || EnumC2300t.m10208a(enumC2300t) || enumC2300t == EnumC2300t.TOPIC) {
                if (string.length() > 30) {
                    string = string.substring(0, 29) + "...";
                }
                string = string + "(" + (i + 1) + ")";
            }
            C4811ac.m18136a(getActivity(), intentM18134a, string, bitmapM18135a);
            C4904y.m18641c("[SHORTCUT] CONTEXT_MENU_ADD_SHORTCUT end, Memory Address:" + this, f9318i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11041a(String str, String str2, EnumC2300t enumC2300t, String str3, int i, EnumC2301u enumC2301u, Boolean bool) {
        try {
            this.f9344W.setText("");
            m11073m();
            m11047b(str, str2, enumC2300t, str3, i, enumC2301u, bool);
        } catch (Exception e) {
            C4904y.m18634a(e.toString(), f9318i);
        }
    }

    /* renamed from: b */
    private void m11047b(String str, String str2, EnumC2300t enumC2300t, String str3, int i, EnumC2301u enumC2301u, Boolean bool) {
        if (enumC2301u == EnumC2301u.NORMAL && !C5034k.m19106k()) {
            C5179v.m19810a(getActivity(), R.string.popup_no_network_connection, 0).show();
        } else {
            this.f9350ac = new C2660e(getActivity(), str, 1);
            this.f9350ac.m11239a(new C2679x(str, enumC2300t, str2, enumC2301u, bool), (Handler) null);
        }
    }

    /* renamed from: a */
    private void m11040a(C2680y c2680y) {
        this.f9350ac = new C2660e(getActivity(), this.f9326E, 1);
        this.f9350ac.m11240a(c2680y, (Handler) null);
    }

    /* renamed from: f */
    private void m11059f() {
        this.f9350ac = new C2660e(getActivity(), 5);
        this.f9350ac.m11237a(this.f9354ah);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m11061g() {
        if (!C4809aa.m18104a().m18119a("do_not_show_delete_chat_list_popup", (Boolean) false).booleanValue() && ((TabActivity) getActivity()).m3094l() == R.id.fragment_msg_box) {
            this.f9353ag = false;
            if (this.f9350ac == null || this.f9350ac.m11241b() != 4) {
                this.f9350ac = new C2660e(getActivity(), 4);
            }
            this.f9350ac.m11243d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m11063h() {
        if (C4822an.m18255w()) {
            if (this.f9336O == null) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("updateSyncButton() mChatListSync is null. ERROR.", f9318i);
                    return;
                }
                return;
            }
            long jM18118a = C4809aa.m18104a().m18118a("multidevice_chatlist_sync_last_call_time", 0L);
            if (jM18118a != 0) {
                this.f9336O.setVisibility(8);
                this.f9337P.setVisibility(8);
                ((ActionBarFragmentActivity) getActivity()).mo51u_();
            } else if (this.f9336O.getVisibility() == 8) {
                this.f9336O.setVisibility(0);
                this.f9337P.setVisibility(0);
                if (C4904y.f17872b) {
                    C4904y.m18639b("updateSyncButton() lastChatListSyncCallTime[" + jM18118a + "]", f9318i);
                }
            }
        }
    }

    /* renamed from: i */
    private void m11064i() {
        this.f9347Z = (ImageButton) this.f9343V.findViewById(R.id.button1);
        this.f9347Z.setImageResource(R.drawable.input_ic_call_log);
        this.f9347Z.setContentDescription(getResources().getString(R.string.more_call_log));
    }

    /* renamed from: j */
    private void m11066j() {
        if (C4859bx.m18386a(CommonApplication.m18732r())) {
            this.f9347Z.setVisibility(0);
            this.f9347Z.setOnClickListener(new ViewOnClickListenerC2623ao(this));
        } else {
            this.f9347Z.setVisibility(8);
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getResources().getConfiguration().orientation == 1) {
            m11077o();
        } else if (getResources().getConfiguration().orientation == 2 && this.f9344W != null && this.f9344W.m18658a().toString().length() > 0) {
            m11079p();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 3:
                    String stringExtra = intent.getStringExtra("inboxNO");
                    int intExtra = intent.getIntExtra("chatType", 0);
                    if (intent.hasExtra("isClosing")) {
                        m11040a(new C2680y(new C2679x(stringExtra, EnumC2300t.m10207a(intExtra), intent.getStringExtra("sessionID"), EnumC2301u.m10211a(intent.getIntExtra("roomType", 0)), Boolean.valueOf(intent.getBooleanExtra("isMapping", false))), intent.getStringArrayListExtra("mappedSMS"), intent.getBooleanExtra("removeLockedSMS", false)));
                        break;
                    } else {
                        String stringExtra2 = intent.getStringExtra("buddyNO");
                        String[] stringArrayExtra = intent.getStringArrayExtra("receivers");
                        if (stringArrayExtra != null) {
                            ArrayList arrayList = new ArrayList();
                            for (String str : stringArrayExtra) {
                                arrayList.add(str);
                            }
                            Intent intentM3014a = TabActivity.m3014a(CommonApplication.m18732r());
                            intentM3014a.putExtra("callChatList", true);
                            if (intExtra == EnumC2300t.ONETOONE.m10210a()) {
                                intentM3014a.putExtra("chatType", EnumC2300t.GROUPCHAT.m10210a());
                                intentM3014a.putExtra(ChatFragment.f5473i, true);
                                arrayList.add(stringExtra2);
                            } else {
                                intentM3014a.putExtra("inboxNO", stringExtra);
                                intentM3014a.putExtra("chatType", intExtra);
                                intentM3014a.putExtra(ChatFragment.f5475k, true);
                            }
                            intentM3014a.putExtra("inboxValid", true);
                            intentM3014a.putExtra("receivers", (String[]) arrayList.toArray(new String[0]));
                            startActivity(intentM3014a);
                            break;
                        }
                    }
                    break;
            }
        }
    }

    /* renamed from: b */
    public void m11099b(String str) {
        this.f9334M = str;
        this.f9324C.m11158a(str);
        this.f9364s.invalidateViews();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        C0991aa.m6037a().m18960b(this.f9351ae);
        if (this.f9355ai != null) {
            this.f9355ai = null;
        }
        m11083r();
        super.onDestroy();
    }

    @Override // android.support.v4.app.ListFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f9344W.setText("");
        this.f9344W.m18661b(this.f9356aj);
        this.f9324C.m11161d();
        this.f9364s.setAdapter((ListAdapter) null);
        this.f9364s.setOnScrollListener(null);
        Cursor cursorA = this.f9324C.mo871a();
        if (cursorA != null && !cursorA.isClosed()) {
            cursorA.close();
            if (C4904y.f17872b) {
                C4904y.m18639b("The Cursor of Adapter was cosed", f9318i);
            }
        }
        if (this.f9335N != null && this.f9335N.isShowing()) {
            this.f9335N.dismiss();
        }
        if (this.f9350ac != null) {
            this.f9350ac.m11236a();
            this.f9350ac = null;
        }
        m11071l();
        if (this.f9340S != null) {
            this.f9340S.m19014a();
        }
        if (this.f9349ab != null) {
            this.f9349ab.shutdown();
        }
    }

    @Override // com.sec.chaton.InterfaceC2318el
    /* renamed from: j_ */
    public void mo2964j_() {
        if (C4904y.f17872b) {
            C4904y.m18639b("[MSGBOX] onTabSelected()", f9318i);
        }
        if (C2349a.m10301a("chaton_qmlog_sending")) {
            C3119a.m12716a().m12718a(EnumC3126h.CHATS, System.currentTimeMillis());
        }
        if (C4822an.m18218a()) {
            C5043h.m19179a().m19185a("2000", "2102", false);
        } else {
            C5043h.m19179a().m19185a("0200", "2109", false);
        }
        if (this.f9342U) {
            this.f9341T = true;
            m11075n();
        }
        C2654bs.m11169a().m11187a(1, this.f9355ai);
        BaseActivity.m6160a((Fragment) this, true);
        m11094x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m11052c(String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b(" :: SMS sync :: deletedInbox[" + str + "]", f9318i);
        }
        new AsyncTaskC2627as(this).execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m11069k() {
        if (this.f9352af == null) {
            this.f9352af = C2654bs.m11171a(getActivity());
        }
        if (!this.f9352af.isShowing()) {
            this.f9352af.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m11071l() {
        if (this.f9352af != null && this.f9352af.isShowing()) {
            this.f9352af.dismiss();
        }
    }

    @Override // com.sec.chaton.InterfaceC2318el
    /* renamed from: k_ */
    public void mo2965k_() {
        C4904y.m18646e("[MSGBOX] onTabUnSelected()", f9318i);
        if (this.f9344W != null) {
            this.f9344W.setText("");
        }
        m11073m();
        BaseActivity.m6160a((Fragment) this, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m11073m() {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
        if (inputMethodManager != null) {
            try {
                if (this.f9344W != null) {
                    inputMethodManager.hideSoftInputFromWindow(this.f9344W.getWindowToken(), 0);
                }
            } catch (Exception e) {
                C4904y.m18646e("[MSGBOX] mSearchFieldText.setOnFocusChangeListener() Exception :: " + e.toString(), f9318i);
            }
        }
    }

    /* renamed from: a */
    private void m11031a(int i) {
        if (i > 0) {
            C2654bs.m11169a().m11187a(3, this.f9355ai);
        } else if (i < 0) {
            m11059f();
        } else {
            m11075n();
        }
        m11092w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m11075n() {
        if (this.f9341T) {
            this.f9341T = false;
            C4904y.m18646e("[MSGBOX] updateMsgbox()", f9318i);
            this.f9325D.startQuery(1, null, C2299s.m10188b(), null, null, null, null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.msgbox_menu_sync);
        if (menuItemFindItem != null) {
            if (C4822an.m18218a()) {
                menuItemFindItem.setTitle(R.string.chat_list_sync_menu);
            } else {
                menuItemFindItem.setTitle(R.string.chat_list_sync_menu_for_lite_feature);
            }
        }
        if (C4822an.m18255w()) {
            if (C4809aa.m18104a().m18118a("multidevice_chatlist_sync_last_call_time", 0L) != 0) {
                menu.setGroupVisible(R.id.msgbox_menu_group_sync_option, true);
                return;
            } else {
                menu.setGroupVisible(R.id.msgbox_menu_group_sync_option, false);
                return;
            }
        }
        if (C4822an.m18226c()) {
            menu.setGroupVisible(R.id.msgbox_menu_group_sync_option, true);
        } else {
            menu.setGroupVisible(R.id.msgbox_menu_group_sync_option, false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        switch (menuItem.getItemId()) {
            case R.id.msgbox_menu_sync /* 2131166656 */:
                C4904y.m18639b("onOptionsItemSelected():msgbox_menu_sync", f9318i);
                C2654bs.m11169a().m11187a(2, this.f9355ai);
                return true;
            default:
                return false;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.activity_msgbox_menu, menu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11032a(Cursor cursor) {
        Message messageM10105c = C2244e.m10103a().m10105c();
        messageM10105c.obj = cursor;
        C2244e.m10103a().m10104b().sendMessage(messageM10105c);
    }

    @Override // com.coolots.sso.p030a.InterfaceC0418c
    /* renamed from: a */
    public void mo1508a(boolean z, String str) {
        if (!isDetached() && z) {
            if (C4904y.f17872b) {
                C4904y.m18639b("onReceiveCreateAccount()", f9318i);
            }
            if (this.f9347Z == null) {
                m11064i();
            }
            m11066j();
        }
    }

    @Override // com.coolots.sso.p030a.InterfaceC0418c
    /* renamed from: a_ */
    public void mo1509a_(boolean z) {
        if (!isDetached() && z && this.f9347Z != null) {
            this.f9347Z.setVisibility(8);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m11077o() {
        if (getActivity() != null && !((ActionBarFragmentActivity) getActivity()).m18784t().mo18834d()) {
            ((ActionBarFragmentActivity) getActivity()).m18784t().mo18835e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m11079p() {
        if (getActivity() != null && ((ActionBarFragmentActivity) getActivity()).m18784t().mo18834d()) {
            ((ActionBarFragmentActivity) getActivity()).m18784t().mo18837f();
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: q */
    private void m11080q() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DATE_CHANGED");
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        getActivity().registerReceiver(this.f9362q, intentFilter);
        getActivity().getContentResolver().registerContentObserver(Settings.System.getUriFor("date_format"), true, this.f9363r);
        if (C3847e.m14656aG() && Build.VERSION.SDK_INT > 18) {
            getActivity().getContentResolver().registerContentObserver(Telephony.Threads.CONTENT_URI, true, this.f9359n);
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("registerListener for system event", f9318i);
        }
    }

    /* renamed from: r */
    private void m11083r() {
        getActivity().unregisterReceiver(this.f9362q);
        getActivity().getContentResolver().unregisterContentObserver(this.f9363r);
        if (C3847e.m14656aG()) {
            getActivity().getContentResolver().unregisterContentObserver(this.f9359n);
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("unregisterListener for system event", f9318i);
        }
    }

    /* renamed from: s */
    private void m11084s() {
        if (C4822an.m18218a()) {
            if (this.f9368w != null) {
                this.f9368w.setVisibility(8);
            }
            m11089u();
        }
    }

    /* renamed from: t */
    private void m11086t() {
        if (C4822an.m18218a()) {
            if (C4904y.f17872b) {
                C4904y.m18639b("[addListHeaderView] isFullFeatureUserMode() is true ", f9318i);
            }
        } else if (this.f9369x != null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("[addListHeaderView] mRegistListHeaderView is exist ", f9318i);
            }
        } else {
            this.f9369x = LayoutInflater.from(getActivity()).inflate(R.layout.msgbox_header, (ViewGroup) this.f9364s, false);
            this.f9369x.setOnClickListener(new ViewOnClickListenerC2633ay(this));
            if (this.f9364s != null) {
                this.f9364s.addHeaderView(this.f9369x, null, true);
            }
        }
    }

    /* renamed from: u */
    private void m11089u() {
        if (this.f9364s != null && this.f9369x != null) {
            this.f9364s.removeHeaderView(this.f9369x);
            this.f9369x = null;
        }
    }

    /* renamed from: b */
    private int m11045b(int i) {
        if (this.f9369x != null) {
            return i - 1;
        }
        return i;
    }

    /* renamed from: v */
    private int m11090v() {
        int i;
        if (C4822an.m18226c()) {
            i = 1;
        } else {
            i = -1;
        }
        if (i == f9317ad) {
            i = 0;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("getSMSSetting result[" + i + "]", f9318i);
        }
        return i;
    }

    /* renamed from: w */
    private void m11092w() {
        int i;
        if (C4822an.m18226c()) {
            i = 1;
        } else {
            i = -1;
        }
        if (i == f9317ad) {
            f9317ad = i;
        } else {
            f9317ad = i;
        }
    }

    /* renamed from: x */
    private void m11094x() {
        if (C4878cp.m18516a().m18518b(EnumC4879cq.MSGBOX_CONTEXT)) {
            if (this.f9348aa != null && this.f9348aa.getVisibility() == 0 && this.f9348aa.isEnabled()) {
                new C5013c().m19049a(R.string.tooltip_msgbox_context).m19048a().m19042a(getActivity());
                C4878cp.m18516a().m18517a(EnumC4879cq.MSGBOX_CONTEXT);
                return;
            }
            return;
        }
        if (C4878cp.m18516a().m18518b(EnumC4879cq.MSGBOX_CALLLOG) && this.f9347Z != null && this.f9347Z.getVisibility() == 0 && this.f9347Z.isEnabled()) {
            new C5013c().m19050a(this.f9347Z).m19049a(R.string.tooltip_msgbox_calllog).m19048a().m19042a(getActivity());
            C4878cp.m18516a().m18517a(EnumC4879cq.MSGBOX_CALLLOG);
        }
    }
}
