package com.sec.chaton.localbackup.chatview;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.localbackup.database.C1641a;
import com.sec.chaton.localbackup.p045a.AsyncTaskC1610a;
import com.sec.chaton.localbackup.p045a.C1613d;
import com.sec.chaton.multimedia.doc.EnumC1794a;
import com.sec.chaton.multimedia.doc.FileExplorerActivity;
import com.sec.chaton.multimedia.image.ImagePagerActivity;
import com.sec.chaton.multimedia.vcalendar.VCalendarDetailActivity2;
import com.sec.chaton.multimedia.vcard.ReadVCardActivity;
import com.sec.chaton.p018b.ContextMenuC0453a;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.p027e.p029b.C1414e;
import com.sec.chaton.p035io.entry.ApplinkMsgEntry;
import com.sec.chaton.p035io.entry.MessageType4Entry;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p069e.C3326c;
import com.sec.common.util.C3364o;
import com.sec.widget.C3641ai;
import java.util.List;
import twitter4j.Query;

/* loaded from: classes.dex */
public class ChatViewFragment extends Fragment implements InterfaceC1622c, InterfaceC1626g {

    /* renamed from: c */
    private static final String f6029c = ChatViewFragment.class.getSimpleName();

    /* renamed from: f */
    private ChatViewActivity f6034f;

    /* renamed from: g */
    private C3326c f6035g;

    /* renamed from: h */
    private ViewOnClickListenerC1623d f6036h;

    /* renamed from: i */
    private C1377u f6037i;

    /* renamed from: j */
    private ListView f6038j;

    /* renamed from: k */
    private String f6039k;

    /* renamed from: l */
    private EnumC1450r f6040l;

    /* renamed from: m */
    private String f6041m;

    /* renamed from: n */
    private int f6042n;

    /* renamed from: o */
    private int f6043o;

    /* renamed from: q */
    private boolean f6045q;

    /* renamed from: d */
    private final int f6032d = 30;

    /* renamed from: e */
    private int f6033e = 30;

    /* renamed from: p */
    private boolean f6044p = true;

    /* renamed from: r */
    private boolean f6046r = true;

    /* renamed from: a */
    ContentObserver f6030a = new C1629j(this, new Handler());

    /* renamed from: b */
    InterfaceC1378v f6031b = new C1630k(this);

    /* renamed from: s */
    private Handler f6047s = new HandlerC1634o(this);

    /* renamed from: a */
    static /* synthetic */ int m6868a(ChatViewFragment chatViewFragment, int i) {
        int i2 = chatViewFragment.f6033e + i;
        chatViewFragment.f6033e = i2;
        return i2;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.f6037i = new C1377u(this.f6034f.getContentResolver(), this.f6031b);
        this.f6035g = new C3326c();
        Bundle arguments = getArguments();
        this.f6039k = arguments.getString("inboxNO");
        this.f6040l = EnumC1450r.m6339a(arguments.getInt("chatType"));
        this.f6041m = arguments.getString("inbox_title");
        this.f6042n = arguments.getInt("inbox_participants");
        setHasOptionsMenu(true);
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Throwable {
        View viewInflate = layoutInflater.inflate(R.layout.layout_localbackup_chatview, viewGroup, false);
        this.f6036h = new ViewOnClickListenerC1623d(getActivity(), R.layout.layout_localbackup_chat_item_view, null, this.f6035g, this);
        this.f6038j = (ListView) viewInflate.findViewById(R.id.chat_view);
        this.f6038j.setAdapter((ListAdapter) this.f6036h);
        registerForContextMenu(this.f6038j);
        this.f6038j.setTranscriptMode(0);
        this.f6038j.setOnScrollListener(new C1627h(this));
        this.f6037i.startQuery(1, null, C1641a.m6917a(this.f6033e), null, "message_inbox_no=?", new String[]{this.f6039k}, null);
        if (this.f6040l == EnumC1450r.GROUPCHAT) {
            m6876a(getString(R.string.buddy_list_optionmenu_groupchat), this.f6042n + 1);
        } else if (EnumC1450r.m6340a(this.f6040l)) {
            m6876a(getString(R.string.buddy_list_optionmenu_broadcast), this.f6042n);
        } else {
            m6876a(getString(R.string.dialog_header_text), -1);
        }
        this.f6034f.getContentResolver().registerContentObserver(C1641a.f6102a, true, this.f6030a);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        m6884c();
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        this.f6034f.getContentResolver().unregisterContentObserver(this.f6030a);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    /* renamed from: c */
    private void m6884c() {
        if (getActivity() != null) {
            ((ChatViewActivity) getActivity()).m11543k().mo11583a(this.f6041m);
        }
    }

    /* renamed from: a */
    private void m6876a(String str, int i) throws Throwable {
        String strM11849a;
        if (getActivity() != null) {
            if (i <= 0) {
                strM11849a = "";
            } else {
                strM11849a = C3364o.m11849a("(", Integer.valueOf(i), ")");
            }
            ((ChatViewActivity) getActivity()).m11543k().mo11587b(C3364o.m11849a(str, strM11849a));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        this.f6034f = (ChatViewActivity) activity;
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        this.f6034f = null;
        super.onDetach();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.f6035g != null) {
            this.f6035g.m11731a();
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (this.f6034f != null) {
            this.f6034f.m6867c();
        }
        return true;
    }

    @Override // com.sec.chaton.localbackup.chatview.InterfaceC1626g
    /* renamed from: a */
    public void mo6896a(View view, int i, Cursor cursor) {
        boolean z;
        if (!C3223ck.m11327a()) {
            C3641ai.m13210a(this.f6034f, R.string.sdcard_not_found, 0).show();
        }
        if (!C3197bl.m11159a()) {
            if (!C3223ck.m11331e()) {
                AbstractC3271a.m11494a(this.f6034f).mo11495a(R.string.pop_up_attention).mo11506b(R.string.popup_not_enough_memory).mo11515d(R.string.dialog_ok, null).mo11512b();
                return;
            }
            if (cursor != null && !cursor.isClosed() && cursor.moveToPosition(i)) {
                EnumC1455w enumC1455wM6358a = EnumC1455w.m6358a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
                String string = cursor.getString(cursor.getColumnIndex("message_download_uri"));
                String string2 = cursor.getString(cursor.getColumnIndex("message_content"));
                String string3 = cursor.getString(cursor.getColumnIndex("message_inbox_no"));
                long j = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
                String string4 = cursor.getString(cursor.getColumnIndex("message_sender"));
                switch (enumC1455wM6358a) {
                    case IMAGE:
                    case AMS:
                    case VIDEO:
                        String string5 = cursor.getString(cursor.getColumnIndex("message_inbox_no"));
                        long j2 = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
                        long j3 = cursor.getLong(cursor.getColumnIndex("_id"));
                        Intent intent = new Intent(this.f6034f, (Class<?>) ImagePagerActivity.class);
                        if (j2 != 0) {
                            j3 = j2;
                        }
                        intent.putExtra("messageId", j3);
                        intent.putExtra("inboxNo", string5);
                        intent.putExtra("isValid", false);
                        intent.putExtra("chatType", EnumC1450r.BROADCAST.m6342a());
                        intent.putExtra("backup", true);
                        this.f6034f.startActivity(intent);
                        break;
                    case AUDIO:
                        if (!C3171am.m11072j() || !C3171am.m11073k()) {
                            C3641ai.m13210a(this.f6034f, R.string.chatroom_unable_to_record_during_call, 0).show();
                            break;
                        } else if (TextUtils.isEmpty(string) || C0816a.f3113b.equals(string)) {
                            new AsyncTaskC1610a(this.f6034f, string2, string3, j, string4, enumC1455wM6358a, view, this.f6047s, true).execute(new String[0]);
                            break;
                        } else {
                            C1620a.m6897a().m6899a(string, j, view);
                            break;
                        }
                        break;
                    case CALENDAR:
                        if (TextUtils.isEmpty(string) || C0816a.f3113b.equals(string)) {
                            new AsyncTaskC1610a(this.f6034f, string2, string3, j, string4, enumC1455wM6358a, view, this.f6047s, true).execute(new String[0]);
                            break;
                        } else {
                            m6887d(string);
                            break;
                        }
                        break;
                    case CONTACT:
                        if (TextUtils.isEmpty(string) || C0816a.f3113b.equals(string)) {
                            new AsyncTaskC1610a(this.f6034f, string2, string3, j, string4, enumC1455wM6358a, view, this.f6047s, true).execute(new String[0]);
                            break;
                        } else {
                            m6880b(string);
                            break;
                        }
                        break;
                    case GEO:
                        m6885c(string2);
                        break;
                    case DOCUMENT:
                    case FILE:
                        if (TextUtils.isEmpty(string) || C0816a.f3113b.equals(string)) {
                            new AsyncTaskC1610a(this.f6034f, string2, string3, j, string4, enumC1455wM6358a, view, this.f6047s, true).execute(new String[0]);
                            break;
                        } else {
                            m6875a(string);
                            break;
                        }
                        break;
                    case APPLINK:
                        try {
                            MessageType4Entry messageType4Entry = ApplinkMsgEntry.parse(string2);
                            if (messageType4Entry instanceof ApplinkMsgEntry) {
                                ApplinkMsgEntry applinkMsgEntry = (ApplinkMsgEntry) messageType4Entry;
                                if (C3250y.f11734b) {
                                    C3250y.m11450b("onMediaClicked()", f6029c);
                                    C3250y.m11450b(applinkMsgEntry.toString(), f6029c);
                                }
                                String appName = applinkMsgEntry.getAppName();
                                ApplinkMsgEntry.ContentEntry.AppInfoEntry.ParamEntry param = applinkMsgEntry.getParam("android", "phone");
                                if (param == null) {
                                    if (C3250y.f11734b) {
                                        C3250y.m11450b("-- not matched anything-- ", f6029c);
                                        break;
                                    }
                                } else {
                                    PackageManager packageManager = this.f6034f.getPackageManager();
                                    try {
                                    } catch (PackageManager.NameNotFoundException e) {
                                        C3250y.m11443a(e, f6029c);
                                    }
                                    if (packageManager.getPackageInfo(param.f5631id, 64) != null) {
                                        if (C3250y.f11734b) {
                                            C3250y.m11450b(param.f5631id + " is installed", f6029c);
                                        }
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (z) {
                                        try {
                                            new Intent("android.intent.action.SEND", Uri.parse(param.executeUri));
                                            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities((Intent) null, 65536);
                                            if (listQueryIntentActivities != null && listQueryIntentActivities.size() > 0) {
                                                if (C3250y.f11734b) {
                                                    C3250y.m11450b(param.f5631id + " supports this action", f6029c);
                                                }
                                                startActivity(null);
                                                break;
                                            } else if (C3250y.f11734b) {
                                                C3250y.m11450b(param.f5631id + " does not support this action", f6029c);
                                                break;
                                            }
                                        } catch (Exception e2) {
                                            if (C3250y.f11737e) {
                                                C3250y.m11443a(e2, f6029c);
                                                return;
                                            }
                                            return;
                                        }
                                    } else {
                                        if (C3250y.f11734b) {
                                            C3250y.m11450b(param.f5631id + " is not installed", f6029c);
                                        }
                                        if (TextUtils.isEmpty(param.installUrl)) {
                                            if (C3250y.f11734b) {
                                                C3250y.m11450b(param.f5631id + " does not have installUrl", f6029c);
                                                break;
                                            }
                                        } else {
                                            String str = param.installUrl;
                                            AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f6034f);
                                            abstractC3271aM11494a.mo11495a(R.string.setting_category_notice);
                                            abstractC3271aM11494a.mo11509b(String.format(getResources().getString(R.string.applink_popup_install), appName)).mo11511b(true).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC1632m(this, str)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1631l(this));
                                            abstractC3271aM11494a.mo11512b();
                                            break;
                                        }
                                    }
                                }
                            }
                        } catch (Exception e3) {
                            if (C3250y.f11737e) {
                                C3250y.m11443a(e3, f6029c);
                                return;
                            }
                            return;
                        }
                        break;
                }
            }
        }
    }

    /* renamed from: a */
    private void m6875a(String str) {
        if (str != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse("file://" + (str.startsWith("file://") ? str.substring(6) : str)), FileExplorerActivity.m7383a(str.substring(str.lastIndexOf(".") + 1)));
            if (BuddyProfileActivity.m3573a(this.f6034f, intent)) {
                startActivity(intent);
                return;
            }
            EnumC1794a enumC1794aM7386c = FileExplorerActivity.m7386c(str);
            if (enumC1794aM7386c == EnumC1794a.SNB) {
                AbstractC3271a.m11494a(this.f6034f).mo11495a(R.string.setting_category_notice).mo11506b(R.string.popup_install_office_viewer).mo11515d(R.string.dialog_ok, null).mo11512b();
                return;
            }
            if (enumC1794aM7386c != EnumC1794a.UNKNOWN && enumC1794aM7386c != EnumC1794a.DIRECTORY) {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                String str2 = "Office viewer";
                if (enumC1794aM7386c == EnumC1794a.HWP) {
                    str2 = "한글뷰어";
                } else if (enumC1794aM7386c == EnumC1794a.GUL) {
                    str2 = "훈민정음";
                } else if (enumC1794aM7386c == EnumC1794a.XLS || enumC1794aM7386c == EnumC1794a.PDF || enumC1794aM7386c == EnumC1794a.DOC || enumC1794aM7386c == EnumC1794a.PPT) {
                    str2 = "Office viewer";
                }
                String str3 = "market://search?q=" + str2 + "&c=apps";
                intent2.setData(Uri.parse(str3));
                boolean zM3573a = BuddyProfileActivity.m3573a(this.f6034f, intent2);
                if (C3250y.f11734b) {
                    C3250y.m11450b("isMarketAvailable: " + zM3573a + ", strUri : " + str3, f6029c);
                }
                AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f6034f);
                abstractC3271aM11494a.mo11495a(R.string.setting_category_notice).mo11506b(R.string.insert_need_install_viewer).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1633n(this, zM3573a, intent2));
                abstractC3271aM11494a.mo11512b();
            }
        }
    }

    /* renamed from: b */
    private void m6880b(String str) {
        Intent intent = new Intent(this.f6034f, (Class<?>) ReadVCardActivity.class);
        intent.putExtra("URI", str);
        startActivity(intent);
    }

    /* renamed from: c */
    private void m6885c(String str) {
        String strSubstring;
        if (!C0816a.m4365a()) {
            C3641ai.m13210a(this.f6034f, R.string.toast_googleMAP_unavailable, 0).show();
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            String[] strArrSplit = str.split("\n");
            if (strArrSplit.length > 5) {
                if (strArrSplit.length <= 6) {
                    strSubstring = null;
                } else {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i = 6; i < strArrSplit.length; i++) {
                        stringBuffer.append(strArrSplit[i] + "\n");
                    }
                    strSubstring = stringBuffer.toString().substring(0, stringBuffer.length() - 1);
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("http://maps.google.com/maps?q=loc:");
                stringBuffer2.append(strArrSplit[5]);
                if (strSubstring != null) {
                    stringBuffer2.append("(").append(strSubstring.replaceAll("[\\(\\)]", " ")).append(")");
                }
                try {
                    this.f6034f.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(stringBuffer2.toString())));
                } catch (ActivityNotFoundException e) {
                    C3641ai.m13210a(this.f6034f, R.string.no_applications_can_perform_this_action, 0).show();
                }
            }
        }
    }

    /* renamed from: d */
    private void m6887d(String str) {
        Intent intent = new Intent(this.f6034f, (Class<?>) VCalendarDetailActivity2.class);
        intent.putExtra("ACTIVITY_PURPOSE", 2);
        intent.putExtra("URI", str);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6872a(C1613d c1613d, String str) {
        switch (c1613d.m6855b()) {
            case AUDIO:
                C1620a.m6897a().m6899a(str, c1613d.m6854a(), c1613d.m6856c());
                break;
            case CALENDAR:
                m6887d(str);
                break;
            case CONTACT:
                m6880b(str);
                break;
            case DOCUMENT:
            case FILE:
                m6875a(str);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6871a(Cursor cursor) {
        Message messageM6267c = C1414e.m6265a().m6267c();
        messageM6267c.obj = cursor;
        C1414e.m6265a().m6266b().sendMessage(messageM6267c);
    }

    @Override // com.sec.chaton.localbackup.chatview.InterfaceC1622c
    /* renamed from: a */
    public void mo6895a() {
        C1620a.m6897a().m6903c();
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Cursor cursor;
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        ContextMenuC0453a contextMenuC0453a = new ContextMenuC0453a(this.f6034f, contextMenu);
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
        if (((C1625f) adapterContextMenuInfo.targetView.getTag()) != null && (cursor = (Cursor) this.f6038j.getAdapter().getItem(adapterContextMenuInfo.position)) != null && !cursor.isClosed()) {
            EnumC1455w enumC1455wM6358a = EnumC1455w.m6358a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
            String string = cursor.getString(cursor.getColumnIndex("message_content"));
            String string2 = cursor.getString(cursor.getColumnIndex("message_download_uri"));
            String string3 = cursor.getString(cursor.getColumnIndex("message_formatted"));
            if (enumC1455wM6358a != EnumC1455w.APPLINK && enumC1455wM6358a != EnumC1455w.AUDIO && enumC1455wM6358a != EnumC1455w.GEO) {
                contextMenuC0453a.setHeaderTitle(EnumC1455w.m6359a(enumC1455wM6358a));
                contextMenuC0453a.clear();
                String str = enumC1455wM6358a == EnumC1455w.TEXT ? string : string2;
                String strM6870a = m6870a(string, string3, enumC1455wM6358a);
                if (enumC1455wM6358a == EnumC1455w.TEXT) {
                    contextMenuC0453a.add(R.string.chat_view_menu_copy).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1635p(this, string));
                }
                if (!TextUtils.isEmpty(string2) || enumC1455wM6358a == EnumC1455w.TEXT) {
                    contextMenuC0453a.add(R.string.trunk_btn_share).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1636q(this, str, strM6870a, enumC1455wM6358a, string2));
                }
            }
        }
    }

    /* renamed from: a */
    private String m6870a(String str, String str2, EnumC1455w enumC1455w) {
        String[] strArr = new String[0];
        switch (enumC1455w) {
            case IMAGE:
            case AMS:
            case VIDEO:
                if (str != null) {
                    String[] strArrSplit = str.split("\n");
                    if (strArrSplit.length > 6 && Query.MIXED.equals(strArrSplit[0])) {
                        StringBuffer stringBuffer = new StringBuffer();
                        for (int i = 6; i < strArrSplit.length; i++) {
                            stringBuffer.append(strArrSplit[i] + "\n");
                        }
                        return stringBuffer.toString().substring(0, stringBuffer.length() - 1);
                    }
                }
                return null;
            case AUDIO:
            case GEO:
            default:
                return null;
            case CALENDAR:
            case CONTACT:
            case DOCUMENT:
            case FILE:
                return str2;
        }
    }
}
