package com.sec.chaton.localbackup.chatview;

import android.annotation.SuppressLint;
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
import com.sec.chaton.localbackup.database.C2543a;
import com.sec.chaton.localbackup.p075a.AsyncTaskC2510a;
import com.sec.chaton.localbackup.p075a.C2513d;
import com.sec.chaton.multimedia.doc.EnumC2758b;
import com.sec.chaton.multimedia.doc.FileExplorerActivity;
import com.sec.chaton.multimedia.image.ImagePagerActivity;
import com.sec.chaton.multimedia.vcalendar.VCalendarDetailActivity2;
import com.sec.chaton.multimedia.vcard.ReadVCardActivity;
import com.sec.chaton.p049b.ContextMenuC1056a;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.p057e.p059b.C2244e;
import com.sec.chaton.p065io.entry.ApplinkMsgEntry;
import com.sec.chaton.p065io.entry.MessageType4Entry;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p132g.C5007c;
import com.sec.common.util.C5052r;
import com.sec.widget.C5179v;
import java.util.List;

/* loaded from: classes.dex */
public class ChatViewFragment extends Fragment implements InterfaceC2524c, InterfaceC2528g {

    /* renamed from: c */
    private static final String f9073c = ChatViewFragment.class.getSimpleName();

    /* renamed from: f */
    private ChatViewActivity f9078f;

    /* renamed from: g */
    private C5007c f9079g;

    /* renamed from: h */
    private ViewOnClickListenerC2525d f9080h;

    /* renamed from: i */
    private C2210x f9081i;

    /* renamed from: j */
    private ListView f9082j;

    /* renamed from: k */
    private String f9083k;

    /* renamed from: l */
    private EnumC2300t f9084l;

    /* renamed from: m */
    private String f9085m;

    /* renamed from: n */
    private int f9086n;

    /* renamed from: o */
    private int f9087o;

    /* renamed from: q */
    private boolean f9089q;

    /* renamed from: d */
    private final int f9076d = 30;

    /* renamed from: e */
    private int f9077e = 30;

    /* renamed from: p */
    private boolean f9088p = true;

    /* renamed from: r */
    private boolean f9090r = true;

    /* renamed from: a */
    ContentObserver f9074a = new C2531j(this, new Handler());

    /* renamed from: b */
    InterfaceC2211y f9075b = new C2532k(this);

    /* renamed from: s */
    private Handler f9091s = new HandlerC2536o(this);

    /* renamed from: a */
    static /* synthetic */ int m10898a(ChatViewFragment chatViewFragment, int i) {
        int i2 = chatViewFragment.f9077e + i;
        chatViewFragment.f9077e = i2;
        return i2;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.f9081i = new C2210x(this.f9078f.getContentResolver(), this.f9075b);
        this.f9079g = new C5007c();
        Bundle arguments = getArguments();
        this.f9083k = arguments.getString("inboxNO");
        this.f9084l = EnumC2300t.m10207a(arguments.getInt("chatType"));
        this.f9085m = arguments.getString("inbox_title");
        this.f9086n = arguments.getInt("inbox_participants");
        setHasOptionsMenu(true);
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Throwable {
        View viewInflate = layoutInflater.inflate(R.layout.layout_localbackup_chatview, viewGroup, false);
        this.f9080h = new ViewOnClickListenerC2525d(getActivity(), R.layout.layout_localbackup_chat_item_view, null, this.f9079g, this);
        this.f9082j = (ListView) viewInflate.findViewById(R.id.chat_view);
        this.f9082j.setAdapter((ListAdapter) this.f9080h);
        registerForContextMenu(this.f9082j);
        this.f9082j.setTranscriptMode(0);
        this.f9082j.setOnScrollListener(new C2529h(this));
        this.f9081i.startQuery(1, null, C2543a.m10948a(this.f9077e), null, "message_inbox_no=?", new String[]{this.f9083k}, null);
        if (this.f9084l == EnumC2300t.GROUPCHAT) {
            m10906a(getString(R.string.buddy_list_optionmenu_groupchat), this.f9086n + 1);
        } else if (this.f9084l == EnumC2300t.TOPIC) {
            m10906a(getString(R.string.topic_chat), this.f9086n + 1);
        } else if (EnumC2300t.m10208a(this.f9084l)) {
            m10906a(getString(R.string.buddy_list_optionmenu_broadcast), this.f9086n);
        } else {
            m10906a(getString(R.string.dialog_header_text), -1);
        }
        this.f9078f.getContentResolver().registerContentObserver(C2543a.f9146a, true, this.f9074a);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        m10914c();
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        this.f9078f.getContentResolver().unregisterContentObserver(this.f9074a);
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    /* renamed from: c */
    private void m10914c() {
        if (getActivity() != null) {
            ((ChatViewActivity) getActivity()).m18784t().mo18823a(this.f9085m);
        }
    }

    /* renamed from: a */
    private void m10906a(String str, int i) throws Throwable {
        String strM19199a;
        if (getActivity() != null) {
            if (i <= 0) {
                strM19199a = "";
            } else {
                strM19199a = C5052r.m19199a("(", Integer.valueOf(i), ")");
            }
            ((ChatViewActivity) getActivity()).m18784t().mo18827b(C5052r.m19199a(str, strM19199a));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        this.f9078f = (ChatViewActivity) activity;
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        this.f9078f = null;
        super.onDetach();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.f9079g != null) {
            this.f9079g.m19014a();
        }
        C2522a.m10927a().m10933c();
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (this.f9078f != null) {
            this.f9078f.m10897h();
        }
        return true;
    }

    @Override // com.sec.chaton.localbackup.chatview.InterfaceC2528g
    /* renamed from: a */
    public void mo10926a(View view, int i, Cursor cursor) {
        boolean z;
        if (!C4873ck.m18500a()) {
            C5179v.m19810a(this.f9078f, R.string.sdcard_not_found, 0).show();
        }
        if (!C4847bl.m18333a()) {
            if (!C4873ck.m18504e()) {
                AbstractC4932a.m18733a(this.f9078f).mo18734a(R.string.pop_up_attention).mo18746b(R.string.popup_not_enough_memory).mo18756d(R.string.dialog_ok, null).mo18752b();
                return;
            }
            if (cursor != null && !cursor.isClosed() && cursor.moveToPosition(i)) {
                EnumC2214ab enumC2214abM10070a = EnumC2214ab.m10070a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
                String string = cursor.getString(cursor.getColumnIndex("message_download_uri"));
                String string2 = cursor.getString(cursor.getColumnIndex("message_content"));
                String string3 = cursor.getString(cursor.getColumnIndex("message_inbox_no"));
                long j = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
                String string4 = cursor.getString(cursor.getColumnIndex("message_sender"));
                switch (enumC2214abM10070a) {
                    case IMAGE:
                    case AMS:
                    case VIDEO:
                        String string5 = cursor.getString(cursor.getColumnIndex("message_inbox_no"));
                        long j2 = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
                        long j3 = cursor.getLong(cursor.getColumnIndex("_id"));
                        Intent intent = new Intent(this.f9078f, (Class<?>) ImagePagerActivity.class);
                        if (j2 != 0) {
                            j3 = j2;
                        }
                        intent.putExtra("messageId", j3);
                        intent.putExtra("inboxNo", string5);
                        intent.putExtra("isValid", false);
                        intent.putExtra("chatType", EnumC2300t.BROADCAST.m10210a());
                        intent.putExtra("backup", true);
                        this.f9078f.startActivity(intent);
                        break;
                    case AUDIO:
                        if (!C4822an.m18245m() || !C4822an.m18246n()) {
                            C5179v.m19810a(this.f9078f, R.string.chatroom_unable_to_record_during_call, 0).show();
                            break;
                        } else if (TextUtils.isEmpty(string) || C1427a.f5066d.equals(string)) {
                            new AsyncTaskC2510a(this.f9078f, string2, string3, j, string4, enumC2214abM10070a, view, this.f9091s, true).execute(new String[0]);
                            break;
                        } else {
                            C2522a.m10927a().m10929a(string, j, view);
                            break;
                        }
                        break;
                    case CALENDAR:
                        if (TextUtils.isEmpty(string) || C1427a.f5066d.equals(string)) {
                            new AsyncTaskC2510a(this.f9078f, string2, string3, j, string4, enumC2214abM10070a, view, this.f9091s, true).execute(new String[0]);
                            break;
                        } else {
                            m10917d(string);
                            break;
                        }
                        break;
                    case CONTACT:
                        if (TextUtils.isEmpty(string) || C1427a.f5066d.equals(string)) {
                            new AsyncTaskC2510a(this.f9078f, string2, string3, j, string4, enumC2214abM10070a, view, this.f9091s, true).execute(new String[0]);
                            break;
                        } else {
                            m10910b(string);
                            break;
                        }
                        break;
                    case GEO:
                        m10915c(string2);
                        break;
                    case DOCUMENT:
                    case FILE:
                        if (TextUtils.isEmpty(string) || C1427a.f5066d.equals(string)) {
                            new AsyncTaskC2510a(this.f9078f, string2, string3, j, string4, enumC2214abM10070a, view, this.f9091s, true).execute(new String[0]);
                            break;
                        } else {
                            m10905a(string);
                            break;
                        }
                        break;
                    case APPLINK:
                        try {
                            MessageType4Entry messageType4Entry = ApplinkMsgEntry.parse(string2);
                            if (messageType4Entry instanceof ApplinkMsgEntry) {
                                ApplinkMsgEntry applinkMsgEntry = (ApplinkMsgEntry) messageType4Entry;
                                if (C4904y.f17872b) {
                                    C4904y.m18639b("onMediaClicked()", f9073c);
                                    C4904y.m18639b(applinkMsgEntry.toString(), f9073c);
                                }
                                String appName = applinkMsgEntry.getAppName();
                                ApplinkMsgEntry.ContentEntry.AppInfoEntry.ParamEntry param = applinkMsgEntry.getParam("android", "phone");
                                if (param == null) {
                                    if (C4904y.f17872b) {
                                        C4904y.m18639b("-- not matched anything-- ", f9073c);
                                        break;
                                    }
                                } else {
                                    PackageManager packageManager = this.f9078f.getPackageManager();
                                    try {
                                    } catch (PackageManager.NameNotFoundException e) {
                                        C4904y.m18635a(e, f9073c);
                                    }
                                    if (packageManager.getPackageInfo(param.f8552id, 64) != null) {
                                        if (C4904y.f17872b) {
                                            C4904y.m18639b(param.f8552id + " is installed", f9073c);
                                        }
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (z) {
                                        try {
                                            Intent intent2 = new Intent("android.intent.action.SEND", Uri.parse(param.executeUri));
                                            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent2, 65536);
                                            if (listQueryIntentActivities != null && listQueryIntentActivities.size() > 0) {
                                                if (C4904y.f17872b) {
                                                    C4904y.m18639b(param.f8552id + " supports this action", f9073c);
                                                }
                                                startActivity(intent2);
                                                break;
                                            } else if (C4904y.f17872b) {
                                                C4904y.m18639b(param.f8552id + " does not support this action", f9073c);
                                                break;
                                            }
                                        } catch (Exception e2) {
                                            if (C4904y.f17875e) {
                                                C4904y.m18635a(e2, f9073c);
                                                return;
                                            }
                                            return;
                                        }
                                    } else {
                                        if (C4904y.f17872b) {
                                            C4904y.m18639b(param.f8552id + " is not installed", f9073c);
                                        }
                                        if (TextUtils.isEmpty(param.installUrl)) {
                                            if (C4904y.f17872b) {
                                                C4904y.m18639b(param.f8552id + " does not have installUrl", f9073c);
                                                break;
                                            }
                                        } else {
                                            String str = param.installUrl;
                                            AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f9078f);
                                            abstractC4932aM18733a.mo18734a(R.string.setting_category_notice);
                                            abstractC4932aM18733a.mo18749b(String.format(getResources().getString(R.string.applink_popup_install), appName)).mo18751b(true).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2534m(this, str)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2533l(this));
                                            abstractC4932aM18733a.mo18752b();
                                            break;
                                        }
                                    }
                                }
                            }
                        } catch (Exception e3) {
                            if (C4904y.f17875e) {
                                C4904y.m18635a(e3, f9073c);
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
    private void m10905a(String str) {
        if (str != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse("file://" + (str.startsWith("file://") ? str.substring(6) : str)), FileExplorerActivity.m11579b(str.substring(str.lastIndexOf(".") + 1)));
            if (BuddyProfileActivity.m6743a(this.f9078f, intent)) {
                startActivity(intent);
                return;
            }
            EnumC2758b enumC2758bM11581d = FileExplorerActivity.m11581d(str);
            if (enumC2758bM11581d == EnumC2758b.SNB) {
                AbstractC4932a.m18733a(this.f9078f).mo18734a(R.string.setting_category_notice).mo18746b(R.string.popup_install_office_viewer).mo18756d(R.string.dialog_ok, null).mo18752b();
                return;
            }
            if (enumC2758bM11581d != EnumC2758b.UNKNOWN && enumC2758bM11581d != EnumC2758b.DIRECTORY) {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                String str2 = "Office viewer";
                if (enumC2758bM11581d == EnumC2758b.HWP) {
                    str2 = "한글뷰어";
                } else if (enumC2758bM11581d == EnumC2758b.GUL) {
                    str2 = "훈민정음";
                } else if (enumC2758bM11581d == EnumC2758b.XLS || enumC2758bM11581d == EnumC2758b.PDF || enumC2758bM11581d == EnumC2758b.DOC || enumC2758bM11581d == EnumC2758b.PPT) {
                    str2 = "Office viewer";
                }
                String str3 = "market://search?q=" + str2 + "&c=apps";
                intent2.setData(Uri.parse(str3));
                boolean zM6743a = BuddyProfileActivity.m6743a(this.f9078f, intent2);
                if (C4904y.f17872b) {
                    C4904y.m18639b("isMarketAvailable: " + zM6743a + ", strUri : " + str3, f9073c);
                }
                AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f9078f);
                abstractC4932aM18733a.mo18734a(R.string.setting_category_notice).mo18746b(R.string.insert_need_install_viewer).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2535n(this, zM6743a, intent2));
                abstractC4932aM18733a.mo18752b();
            }
        }
    }

    /* renamed from: b */
    private void m10910b(String str) {
        Intent intent = new Intent(this.f9078f, (Class<?>) ReadVCardActivity.class);
        intent.putExtra("URI", str);
        startActivity(intent);
    }

    /* renamed from: c */
    private void m10915c(String str) {
        String strSubstring;
        if (!C1427a.m7518a()) {
            C5179v.m19810a(this.f9078f, R.string.toast_googleMAP_unavailable, 0).show();
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
                    this.f9078f.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(stringBuffer2.toString())));
                } catch (ActivityNotFoundException e) {
                    C5179v.m19810a(this.f9078f, R.string.no_applications_can_perform_this_action, 0).show();
                }
            }
        }
    }

    /* renamed from: d */
    private void m10917d(String str) {
        Intent intent = new Intent(this.f9078f, (Class<?>) VCalendarDetailActivity2.class);
        intent.putExtra("ACTIVITY_PURPOSE", 2);
        intent.putExtra("URI", str);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10902a(C2513d c2513d, String str) {
        switch (c2513d.m10883b()) {
            case AUDIO:
                C2522a.m10927a().m10929a(str, c2513d.m10882a(), c2513d.m10884c());
                break;
            case CALENDAR:
                m10917d(str);
                break;
            case CONTACT:
                m10910b(str);
                break;
            case DOCUMENT:
            case FILE:
                m10905a(str);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10901a(Cursor cursor) {
        Message messageM10105c = C2244e.m10103a().m10105c();
        messageM10105c.obj = cursor;
        C2244e.m10103a().m10104b().sendMessage(messageM10105c);
    }

    @Override // com.sec.chaton.localbackup.chatview.InterfaceC2524c
    /* renamed from: a */
    public void mo10925a() {
        C2522a.m10927a().m10933c();
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    @SuppressLint({"NewApi"})
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Cursor cursor;
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        ContextMenuC1056a contextMenuC1056a = new ContextMenuC1056a(this.f9078f, contextMenu);
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
        if (((C2527f) adapterContextMenuInfo.targetView.getTag()) != null && (cursor = (Cursor) this.f9082j.getAdapter().getItem(adapterContextMenuInfo.position)) != null && !cursor.isClosed()) {
            EnumC2214ab enumC2214abM10070a = EnumC2214ab.m10070a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
            String string = cursor.getString(cursor.getColumnIndex("message_content"));
            String string2 = cursor.getString(cursor.getColumnIndex("message_download_uri"));
            String string3 = cursor.getString(cursor.getColumnIndex("message_formatted"));
            if (enumC2214abM10070a != EnumC2214ab.APPLINK && enumC2214abM10070a != EnumC2214ab.GEO) {
                contextMenuC1056a.setHeaderTitle(EnumC2214ab.m10071a(enumC2214abM10070a));
                contextMenuC1056a.clear();
                String str = enumC2214abM10070a == EnumC2214ab.TEXT ? string : string2;
                String strM10900a = m10900a(string, string3, enumC2214abM10070a);
                if (enumC2214abM10070a == EnumC2214ab.TEXT) {
                    contextMenuC1056a.add(R.string.chat_view_menu_copy).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC2537p(this, string));
                }
                if (!TextUtils.isEmpty(string2) || enumC2214abM10070a == EnumC2214ab.TEXT) {
                    contextMenuC1056a.add(R.string.trunk_btn_share).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC2538q(this, str, strM10900a, enumC2214abM10070a));
                }
            }
        }
    }

    /* renamed from: a */
    private String m10900a(String str, String str2, EnumC2214ab enumC2214ab) {
        String[] strArr = new String[0];
        switch (enumC2214ab) {
            case IMAGE:
            case AMS:
            case VIDEO:
                if (str != null) {
                    String[] strArrSplit = str.split("\n");
                    if (strArrSplit.length > 6 && "mixed".equals(strArrSplit[0])) {
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
