package com.sec.chaton.specialbuddy;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.ExitAppDialogActivity;
import com.sec.chaton.HomeTabletFragment;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.SpecialBuddyActivity;
import com.sec.chaton.chat.C0493bg;
import com.sec.chaton.chat.InterfaceC0454a;
import com.sec.chaton.chat.InterfaceC0495bi;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgbox.MsgboxFragment;
import com.sec.chaton.multimedia.audio.RecordAudio;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p007a.p008a.C0103d;
import com.sec.chaton.p007a.p008a.EnumC0104e;
import com.sec.chaton.p007a.p008a.EnumC0106g;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.p015d.C0639k;
import com.sec.chaton.p015d.p016a.C0605u;
import com.sec.chaton.p017e.C0694i;
import com.sec.chaton.p017e.C0698m;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.p017e.p018a.C0660d;
import com.sec.chaton.p017e.p018a.C0666j;
import com.sec.chaton.p017e.p018a.C0672p;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import com.sec.chaton.p022h.C0776c;
import com.sec.chaton.p022h.C0795e;
import com.sec.chaton.p022h.C0809s;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.specialbuddy.SpecialBuddyFilePlayerEntry;
import com.sec.chaton.p028io.entry.specialbuddy.SpecialBuddyFilecreateUploadEntry;
import com.sec.chaton.p028io.entry.specialbuddy.SpecialBuddyHandshakeEntry;
import com.sec.chaton.p028io.entry.specialbuddy.SpecialBuddyProxyEntry;
import com.sec.chaton.receiver.PushReceiver;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.util.C1785q;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1788t;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.EnumC1764bt;
import com.sec.chaton.util.EnumC1765bu;
import com.sec.chaton.widget.C1797a;
import com.sec.chaton.widget.C1798b;
import com.sec.chaton.widget.C1805i;
import com.sec.common.p056b.p061e.C1830a;
import com.sec.common.p056b.p061e.C1836g;
import com.sec.common.widget.AlertDialogC1839a;
import com.sec.widget.AlertDialogBuilderC2120a;
import com.sec.widget.C2153y;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SpecialBuddyChatFragment extends Fragment implements View.OnClickListener, InterfaceC0454a, InterfaceC0495bi {
    private static final int QUERY_DELETE_CHAT = 3;
    private static final int QUERY_DELETE_INBOX = 2;
    private static final int QUERY_INBOX = 1;
    private static final int QUERY_UPDATE_INBOX = 4;
    private static final int REQ_CODE_BASE = 0;
    private static final int REQ_CODE_CHAT_PROFILE = 1;
    private static final int REQ_CODE_RECORD_AUDIO = 2;
    private static final String TAG_classname = SpecialBuddyChatFragment.class.getSimpleName();
    private AlertDialogBuilderC2120a builder;
    private TextView headerTitle;
    private String mChatTitle;
    private EnumC0695j mChatType;
    private AlertDialogC1839a mDownloadProgressDialog;
    SpecialBuddyFilecreateUploadEntry mEntryFileCreator;
    SpecialBuddyFilePlayerEntry mEntryFilePlayer;
    SpecialBuddyHandshakeEntry mEntryHandshake;
    SpecialBuddyProxyEntry mEntryProxy;
    private boolean mIsEnableNoti;
    private Long mLastMsgID;
    String mLastRecordedFilename;
    private long mLastTimeStamp;
    private C0639k mMessageControl;
    private LinearLayout mProgressBar;
    private C0666j mQueryHandler;
    String mRequestUrl;
    private String mSessionID;
    private C1798b mSpinnerAdapter;
    private String mWebURL;
    private WebView mWebView;
    private View networkError;
    private ImageView profileIcon;
    private boolean mIsStartedContents = false;
    private boolean mIsPause = false;
    private ProgressDialog mProgressDialog = null;
    private String mBuddyNo = null;
    private String mInboxNo = null;
    private int mInboxRowID = -1;
    private String mBuddyName = null;
    private boolean mIsInBoxValid = true;
    Set progressShowReason = new HashSet();
    AdapterView.OnItemSelectedListener mOnItemSelectedListener = new AdapterView.OnItemSelectedListener() { // from class: com.sec.chaton.specialbuddy.SpecialBuddyChatFragment.5
        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
            if (SpecialBuddyChatFragment.this.getActivity() != null) {
                if (view.isPressed() || view.isInTouchMode()) {
                    switch (i) {
                        case 0:
                            SpecialBuddyChatFragment.this.goChatInfo();
                            break;
                        case 1:
                            SpecialBuddyChatFragment.this.requestEndChat();
                            break;
                        case 2:
                            if (SpecialBuddyChatFragment.this.mBuddyNo != null) {
                                Intent intent = new Intent(SpecialBuddyChatFragment.this.getActivity(), (Class<?>) SpecialBuddyActivity.class);
                                intent.putExtra("specialuserid", SpecialBuddyChatFragment.this.mBuddyNo);
                                intent.putExtra("specialBuddyAdded", true);
                                SpecialBuddyChatFragment.this.startActivity(intent);
                                break;
                            }
                            break;
                    }
                }
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    };
    Handler mMessageHandler = new Handler() { // from class: com.sec.chaton.specialbuddy.SpecialBuddyChatFragment.8
        @Override // android.os.Handler
        public void handleMessage(Message message) throws JSONException {
            int iM680a;
            AlertDialogBuilderC2120a alertDialogBuilderC2120aAuthErrorPopup;
            if (SpecialBuddyChatFragment.this.getActivity() != null) {
                C0103d c0103d = (C0103d) message.obj;
                if (C0493bg.m2680a(message.what, c0103d.m680a()) == EnumC0104e.END_APP) {
                    if (!ExitAppDialogActivity.m580a()) {
                        ExitAppDialogActivity.m581b();
                        return;
                    }
                    return;
                }
                if (C0493bg.m2680a(message.what, c0103d.m680a()) == EnumC0104e.RESTART_APP && (alertDialogBuilderC2120aAuthErrorPopup = SpecialBuddyChatFragment.this.authErrorPopup(EnumC0104e.RESTART_APP)) != null) {
                    alertDialogBuilderC2120aAuthErrorPopup.create().show();
                }
                if (!c0103d.f333a && (((iM680a = c0103d.m680a()) == 24 || iM680a == 23 || iM680a == 21) && SpecialBuddyChatFragment.this.mMessageControl != null)) {
                    SpecialBuddyChatFragment.this.mMessageControl.m2954f();
                    SpecialBuddyChatFragment.this.mMessageControl.m2947a(SpecialBuddyChatFragment.this.mInboxNo, GlobalApplication.m3263d().m5922b().m5923a(), GlobalApplication.m3263d().m5922b().m5926b());
                }
                C1786r.m6061b("spbd_refresh, messageControl return : " + message.what, getClass().getSimpleName());
                switch (message.what) {
                    case 2:
                        if (c0103d.f333a || SpecialBuddyChatFragment.this.mChatType != EnumC0695j.GROUPCHAT || c0103d.f334b == EnumC0106g.NETWORKFAIL) {
                        }
                        break;
                    case 6:
                        int iM2786c = ((C0605u) c0103d).m2786c();
                        if (iM2786c > 0 && !SpecialBuddyChatFragment.this.enableAutoScroll()) {
                            SpecialBuddyChatFragment.this.setPreviewText(iM2786c);
                            break;
                        }
                        break;
                    case AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END /* 1024 */:
                        SpecialBuddyChatFragment.this.dismissProgressDialog(ProgressDialogReason.reqUploadVoiceFile);
                        if (SpecialBuddyChatFragment.this.mEntryFileCreator == null || TextUtils.isEmpty(SpecialBuddyChatFragment.this.mEntryFileCreator.success)) {
                            C1786r.m6054a("spbd_kpop, mUiHandler(), entry or entry.success is null. ", getClass().getSimpleName());
                            break;
                        } else if (c0103d.f333a) {
                            String[] strArrSplit = c0103d.f335c.split("\n");
                            String str = strArrSplit[0];
                            String str2 = strArrSplit[1];
                            String str3 = str + "?uid=" + C1789u.m6075a().getString("uid", "") + "&" + ("imei=" + C1721ad.m5873a() + "&buddyid=" + strArrSplit[2] + "&filename=" + str2);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(RtspHeaders.Values.URL, str3);
                                jSONObject.put("filename", str2);
                            } catch (JSONException e) {
                                e.printStackTrace();
                                C1786r.m6054a("spbd_kpop, error occured when FileUploading", getClass().getSimpleName());
                            }
                            SpecialBuddyChatFragment.this.mWebView.loadUrl(String.format("javascript:%s(%s)", SpecialBuddyChatFragment.this.mEntryFileCreator.success.toString(), jSONObject.toString()));
                            C1786r.m6061b("spbd_kpop, mUiHandler(), last url : " + str3.toString(), getClass().getSimpleName());
                            break;
                        } else {
                            SpecialBuddyChatFragment.this.showRetryUploadVoice();
                            break;
                        }
                        break;
                }
            }
        }
    };
    InterfaceC0667k onQueryReturn = new InterfaceC0667k() { // from class: com.sec.chaton.specialbuddy.SpecialBuddyChatFragment.13
        @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
        public void onQueryComplete(int i, Object obj, Cursor cursor) {
            switch (i) {
                case 1:
                    C1786r.m6061b("spbd_refresh, onQueryComplete(), QUERY_INBOX #2", getClass().getSimpleName());
                    C1786r.m6061b("onQueryCompleted - QUERY_INBOX", getClass().getSimpleName());
                    if (cursor == null) {
                        C1786r.m6061b("onQueryCompleted - QUERY_INBOX, #1 null", getClass().getSimpleName());
                        break;
                    } else if (cursor.getCount() > 0) {
                        if (SpecialBuddyChatFragment.this.mIsPause || SpecialBuddyChatFragment.this.getActivity() == null || SpecialBuddyChatFragment.this.getActivity().isFinishing()) {
                            cursor.close();
                            C1786r.m6061b("onQueryCompleted - QUERY_INBOX, #3 (conditional return).", getClass().getSimpleName());
                            break;
                        } else if (!cursor.moveToFirst()) {
                            cursor.close();
                            C1786r.m6061b("onQueryCompleted - QUERY_INBOX, #4 fail : moveToFirst.", getClass().getSimpleName());
                            break;
                        } else {
                            int i2 = cursor.getInt(cursor.getColumnIndex("inbox_last_chat_type"));
                            SpecialBuddyChatFragment.this.mInboxNo = cursor.getString(cursor.getColumnIndex("inbox_no"));
                            SpecialBuddyChatFragment.this.setChatSelection(SpecialBuddyChatFragment.this.mInboxNo);
                            SpecialBuddyChatFragment.this.mWebURL = cursor.getString(cursor.getColumnIndex("inbox_web_url"));
                            if (SpecialBuddyChatFragment.this.mWebURL == null) {
                                SpecialBuddyChatFragment.this.mWebURL = C0672p.m3095b(GlobalApplication.m3260b(), SpecialBuddyChatFragment.this.mBuddyNo);
                                C0660d.m3019a(GlobalApplication.m3260b().getContentResolver(), SpecialBuddyChatFragment.this.mInboxNo, SpecialBuddyChatFragment.this.mWebURL);
                                C1786r.m6061b("onQueryComplete(), recoverty ??", getClass().getSimpleName());
                            }
                            if (i2 == 12) {
                                if (SpecialBuddyChatFragment.this.setMessageControl()) {
                                    SpecialBuddyChatFragment.this.mMessageControl.m2947a(SpecialBuddyChatFragment.this.mInboxNo, GlobalApplication.m3263d().m5922b().m5923a(), GlobalApplication.m3263d().m5922b().m5926b());
                                    SpecialBuddyChatFragment.this.mMessageControl.m2930a(Long.MAX_VALUE);
                                    SpecialBuddyChatFragment.this.mMessageControl.m2955g();
                                } else {
                                    cursor.close();
                                    break;
                                }
                            } else {
                                SpecialBuddyChatFragment.this.mSessionID = cursor.getString(cursor.getColumnIndex("inbox_session_id"));
                                SpecialBuddyChatFragment.this.mLastMsgID = Long.valueOf(cursor.getLong(cursor.getColumnIndex("inbox_last_msg_no")));
                                SpecialBuddyChatFragment.this.mChatTitle = cursor.getString(cursor.getColumnIndex("inbox_title"));
                                if (!TextUtils.isEmpty(SpecialBuddyChatFragment.this.mChatTitle)) {
                                    SpecialBuddyChatFragment.this.headerTitle.setText(SpecialBuddyChatFragment.this.mChatTitle);
                                }
                                SpecialBuddyChatFragment.this.mInboxRowID = cursor.getInt(cursor.getColumnIndex("_id"));
                                SpecialBuddyChatFragment.this.mBuddyName = cursor.getString(cursor.getColumnIndex("buddy_name"));
                                SpecialBuddyChatFragment.this.mBuddyNo = cursor.getString(cursor.getColumnIndex("buddy_no"));
                                SpecialBuddyChatFragment.this.mIsInBoxValid = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_valid")));
                                SpecialBuddyChatFragment.this.mLastTimeStamp = cursor.getLong(cursor.getColumnIndex("inbox_last_timestamp"));
                                SpecialBuddyChatFragment.this.mIsEnableNoti = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_enable_noti")));
                                String str = SpecialBuddyChatFragment.this.mBuddyNo;
                                if (SpecialBuddyChatFragment.this.mChatType == EnumC0695j.GROUPCHAT) {
                                    str = SpecialBuddyChatFragment.this.mInboxNo;
                                }
                                if (SpecialBuddyChatFragment.this.setMessageControl()) {
                                    C1788t.m6070a(SpecialBuddyChatFragment.this.getActivity()).m6073a(SpecialBuddyChatFragment.this.mInboxRowID);
                                    SpecialBuddyChatFragment.this.mMessageControl.m2947a(SpecialBuddyChatFragment.this.mInboxNo, GlobalApplication.m3263d().m5922b().m5923a(), GlobalApplication.m3263d().m5922b().m5926b());
                                    SpecialBuddyChatFragment.this.mMessageControl.m2930a(Long.MAX_VALUE);
                                    if (SpecialBuddyChatFragment.this.mIsInBoxValid) {
                                        C1786r.m6061b("spbd_refresh, onQueryComplete(), QUERY_INBOX, call allowChat() #2-1", getClass().getSimpleName());
                                        SpecialBuddyChatFragment.this.mMessageControl.m2946a(EnumC0695j.BROADCAST, str, SpecialBuddyChatFragment.this.mLastMsgID, SpecialBuddyChatFragment.this.mSessionID, SpecialBuddyChatFragment.this.mInboxNo, SpecialBuddyChatFragment.this.mLastTimeStamp, true);
                                    }
                                } else {
                                    cursor.close();
                                    break;
                                }
                            }
                            cursor.close();
                            if (!TextUtils.isEmpty(SpecialBuddyChatFragment.this.mWebURL)) {
                                if (!TextUtils.isEmpty(SpecialBuddyChatFragment.this.mBuddyNo)) {
                                    if (!SpecialBuddyChatFragment.this.mIsStartedContents) {
                                        SpecialBuddyChatFragment.this.startWebContents(SpecialBuddyChatFragment.this.mWebURL, SpecialBuddyChatFragment.this.mBuddyNo);
                                    } else {
                                        SpecialBuddyChatFragment.this.refreshWebContents();
                                    }
                                } else {
                                    C1786r.m6061b("onQueryComplete(), mBuddyNo is null", getClass().getSimpleName());
                                    SpecialBuddyChatFragment.this.dismissProgressDialog();
                                }
                            } else {
                                C1786r.m6061b("onQueryComplete(), mWebURL is null", getClass().getSimpleName());
                                SpecialBuddyChatFragment.this.dismissProgressDialog();
                            }
                            SpecialBuddyChatFragment.this.updateUnreadCount();
                            break;
                        }
                    } else {
                        cursor.close();
                        C1786r.m6061b("onQueryCompleted - QUERY_INBOX, #2 nothing", getClass().getSimpleName());
                        break;
                    }
                    break;
                default:
                    if (cursor != null) {
                        cursor.close();
                        break;
                    }
                    break;
            }
        }

        @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
        public void onInsertComplete(int i, Object obj, Uri uri) {
        }

        @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
        public void onUpdateComplete(int i, Object obj, int i2) {
        }

        @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
        public void onDeleteComplete(int i, Object obj, int i2) {
        }
    };
    Handler mMobileWebHandler = new Handler() { // from class: com.sec.chaton.specialbuddy.SpecialBuddyChatFragment.14
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    new MobileWebHandshakeTask().execute((String) message.obj);
                    break;
                case 2:
                    new MobileWebProxyTask().execute((String) message.obj);
                    break;
                case 3:
                    new MobileWebFileCreatorTask().execute((String) message.obj);
                    break;
                case 4:
                    new MobileWebFilePlayerTask().execute((String) message.obj);
                    break;
                default:
                    super.handleMessage(message);
                    break;
            }
        }
    };
    private Handler mUiHandler = new Handler() { // from class: com.sec.chaton.specialbuddy.SpecialBuddyChatFragment.17
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (SpecialBuddyChatFragment.this.getActivity() != null) {
                if (message.what == 1) {
                    if (SpecialBuddyChatFragment.this.mDownloadProgressDialog.isShowing()) {
                        SpecialBuddyChatFragment.this.mDownloadProgressDialog.m6242c(message.arg1);
                    }
                } else {
                    if (message.what == 2) {
                        if (C1786r.f6452b) {
                            C1786r.m6061b("File download is completed", SpecialBuddyChatFragment.class.getSimpleName());
                        }
                        File fileM6231b = ((C1836g) message.obj).m6231b();
                        SpecialBuddyChatFragment.this.closeDownloadProgressDialog();
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        intent.setDataAndType(Uri.fromFile(fileM6231b), "audio/*");
                        SpecialBuddyChatFragment.this.startActivity(intent);
                        return;
                    }
                    super.handleMessage(message);
                }
            }
        }
    };
    private Handler mSpecialBuddyContentsReceiveHandler = new Handler() { // from class: com.sec.chaton.specialbuddy.SpecialBuddyChatFragment.18
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            JSONObject jSONObject;
            String str;
            try {
                jSONObject = new JSONObject("{}");
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = null;
            }
            C0101b c0101b = (C0101b) message.obj;
            C1786r.m6061b("spbd_procedure #4 [from Contact server] : " + c0101b.m665b().toString(), SpecialBuddyChatFragment.class.getSimpleName());
            if (c0101b != null && c0101b.m671d() != null && c0101b.m664a() && c0101b.m665b() == EnumC0803m.SUCCESS) {
                try {
                    jSONObject = new JSONObject((String) c0101b.m671d());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            String str2 = SpecialBuddyChatFragment.this.mEntryProxy.error;
            if (c0101b == null || c0101b.m671d() == null || !c0101b.m664a()) {
                str = str2;
            } else {
                EnumC0803m enumC0803mM665b = c0101b.m665b();
                str = (enumC0803mM665b == EnumC0803m.SUCCESS || enumC0803mM665b == EnumC0803m.NO_CONTENT) ? SpecialBuddyChatFragment.this.mEntryProxy.success : str2;
            }
            String str3 = String.format("javascript:%s(%s)", str, jSONObject);
            SpecialBuddyChatFragment.this.mWebView.loadUrl(str3);
            int length = 80;
            if (str3.length() < 80) {
                length = str3.length();
            }
            C1786r.m6061b("spbd_procedure #5 [to MobileWeb] : " + str3.substring(0, length).toString() + " ......", SpecialBuddyChatFragment.class.getSimpleName());
        }
    };

    enum ProgressDialogReason {
        reqUploadVoiceFile
    }

    private void showProgressDialog(ProgressDialogReason progressDialogReason, int i) {
        if (getActivity() != null && !getActivity().isFinishing()) {
            this.progressShowReason.add(progressDialogReason);
            if (this.mProgressDialog == null) {
                this.mProgressDialog = (ProgressDialog) new C1805i(getActivity()).m6139a(i);
                this.mProgressDialog.setCancelable(false);
                this.mProgressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.sec.chaton.specialbuddy.SpecialBuddyChatFragment.1
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                        if (i2 != 4) {
                            return false;
                        }
                        SpecialBuddyChatFragment.this.mProgressDialog.dismiss();
                        SpecialBuddyChatFragment.this.getActivity().finish();
                        return true;
                    }
                });
            } else {
                this.mProgressDialog.setMessage(getString(i));
                this.mProgressDialog.show();
            }
        }
    }

    private void showProgressDialog(int i) {
        if (getActivity() != null && !getActivity().isFinishing()) {
            if (this.mProgressDialog == null) {
                this.mProgressDialog = (ProgressDialog) new C1805i(getActivity()).m6139a(i);
                this.mProgressDialog.setCancelable(false);
                this.mProgressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.sec.chaton.specialbuddy.SpecialBuddyChatFragment.2
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                        if (i2 != 4) {
                            return false;
                        }
                        SpecialBuddyChatFragment.this.mProgressDialog.dismiss();
                        SpecialBuddyChatFragment.this.getActivity().finish();
                        return true;
                    }
                });
            } else {
                this.mProgressDialog.setMessage(getString(i));
                this.mProgressDialog.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissProgressDialog(ProgressDialogReason progressDialogReason) {
        if (getActivity() != null && !getActivity().isFinishing()) {
            this.progressShowReason.remove(progressDialogReason);
            if (this.mProgressDialog != null && this.progressShowReason.isEmpty()) {
                this.mProgressDialog.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissProgressDialog() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            this.progressShowReason.clear();
            if (this.mProgressDialog != null && this.progressShowReason.isEmpty()) {
                this.mProgressDialog.dismiss();
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BaseActivity.m1827a(this, true);
        View viewInflate = layoutInflater.inflate(R.layout.layout_special_buddy_chat_fragment, viewGroup, false);
        this.profileIcon = (ImageView) viewInflate.findViewById(R.id.Chaticon);
        this.profileIcon.setOnClickListener(new View.OnClickListener() { // from class: com.sec.chaton.specialbuddy.SpecialBuddyChatFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(SpecialBuddyChatFragment.this.getActivity(), (Class<?>) SpecialBuddyActivity.class);
                intent.putExtra("specialuserid", SpecialBuddyChatFragment.this.mBuddyNo);
                intent.putExtra("specialBuddyAdded", true);
                try {
                    SpecialBuddyChatFragment.this.getActivity().startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        this.headerTitle = (TextView) viewInflate.findViewById(R.id.chatTitle);
        this.headerTitle.setOnClickListener(new View.OnClickListener() { // from class: com.sec.chaton.specialbuddy.SpecialBuddyChatFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SpecialBuddyChatFragment.this.goChatInfo();
            }
        });
        this.mProgressBar = (LinearLayout) viewInflate.findViewById(R.id.progressbar);
        this.mWebView = (WebView) viewInflate.findViewById(R.id.spbd_webview);
        WebSettings settings = this.mWebView.getSettings();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (displayMetrics != null) {
            int i = displayMetrics.densityDpi;
            if (i == 240) {
                settings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
            } else if (i == 160) {
                settings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
            } else if (i == 120) {
                settings.setDefaultZoom(WebSettings.ZoomDensity.CLOSE);
            } else {
                settings.setDefaultZoom(WebSettings.ZoomDensity.CLOSE);
            }
        } else {
            settings.setDefaultZoom(WebSettings.ZoomDensity.CLOSE);
        }
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        this.mWebView.addJavascriptInterface(new SpbdWebBridgeClass(), "ChatONBridge");
        this.mWebView.setWebViewClient(new SpbdWebViewClient());
        this.mWebView.setWebChromeClient(new InternalWebChromeClient());
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setVerticalScrollbarOverlay(true);
        this.networkError = viewInflate.findViewById(R.id.network_error);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C1797a(getResources().getString(R.string.chat_view_menu_info2), R.drawable.chat_info));
        arrayList.add(new C1797a(getResources().getString(R.string.chat_view_menu_close), R.drawable.close_chat));
        arrayList.add(new C1797a(getResources().getString(R.string.buddy_list_contextual_menu_viewprofile), R.drawable.view_profile));
        this.mSpinnerAdapter = new C1798b(getActivity(), arrayList);
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUnreadCount() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_unread_count", (Integer) 0);
        this.mQueryHandler.startUpdate(4, null, C0694i.f2616a, contentValues, "inbox_no='" + this.mInboxNo + "'", null);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mQueryHandler = new C0666j(getActivity().getContentResolver(), this.onQueryReturn);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            if (arguments.containsKey("inboxNO")) {
                this.mInboxNo = arguments.getString("inboxNO");
            }
            if (arguments.containsKey("receivers")) {
                String[] stringArray = arguments.getStringArray("receivers");
                if (stringArray.length >= 1) {
                    this.mBuddyNo = stringArray[0];
                }
            }
            if (arguments.containsKey("chatType")) {
                this.mChatType = EnumC0695j.m3145a(arguments.getInt("chatType"));
            }
            if (this.mBuddyNo != null) {
                C1786r.m6061b("onActivityCreated(), spbd_intent, recv intent, buddy_no : " + this.mBuddyNo.toString(), TAG_classname);
            } else {
                C1786r.m6061b("onActivityCreated(), spbd_intent, recv intent, buddy_no : (null)", TAG_classname);
            }
            if (this.mInboxNo != null) {
                C1786r.m6061b("onActivityCreated(), spbd_intent, recv intent, inbox_no : " + this.mInboxNo.toString(), TAG_classname);
            } else {
                C1786r.m6061b("onActivityCreated(), spbd_intent, recv intent, inbox_no : (null)", TAG_classname);
            }
            C1786r.m6061b("onActivityCreated(), spbd_intent, recv intent, char_type : " + this.mChatType, TAG_classname);
            if (this.mInboxNo != null) {
                C1786r.m6061b("onActivityCreated(), spbd_intent, recv intent, inbox_no : " + this.mInboxNo.toString(), TAG_classname);
            } else {
                C1786r.m6061b("onActivityCreated(), spbd_intent, recv intent, inbox_no : (null)", TAG_classname);
            }
            this.mBuddyName = C0672p.m3094a(getActivity(), this.mBuddyNo);
            if (this.mBuddyName != null) {
                this.headerTitle.setText(this.mBuddyName);
            }
            C1746bb.m5945a(getActivity()).m5959a(this.profileIcon, this.mBuddyNo);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mIsPause = false;
        PushReceiver.m4324a(this);
        askInboxNoAsync();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.mIsPause = true;
        if (this.mMessageControl != null) {
            this.mMessageControl.m2930a(SystemClock.elapsedRealtime() + 480000);
        }
        C0795e.m3383a().m3388c();
        GlobalApplication.f2776b = null;
        PushReceiver.m4324a((InterfaceC0495bi) null);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.mMessageControl != null) {
            this.mMessageControl.m2954f();
        }
        super.onDestroyView();
        BaseActivity.m1827a(this, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.header_title /* 2131493303 */:
                goChatInfo();
                break;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (intent.hasExtra("isClosing")) {
                        endChat();
                        return;
                    }
                    break;
                case 2:
                    this.mLastRecordedFilename = intent.getStringExtra("extra fileuri");
                    sendLastRecordedVoiceFile();
                    break;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendLastRecordedVoiceFile() {
        File file = new File(this.mLastRecordedFilename);
        this.mLastRecordedFilename.substring(this.mLastRecordedFilename.lastIndexOf(46));
        this.mMessageControl.m2929a(file, EnumC0699n.AUDIO, this.mChatType, this.mSessionID, new String[]{this.mBuddyNo}, true, (String) null, (String) null, false);
        showProgressDialog(ProgressDialogReason.reqUploadVoiceFile, R.string.media_file_upload);
    }

    private void askInboxNoAsync() {
        C1786r.m6061b("spbd_refresh, askInboxNoAsync(), #1", getClass().getSimpleName());
        if (TextUtils.isEmpty(this.mInboxNo)) {
            this.mQueryHandler.startQuery(1, null, C0694i.m3144d(), null, "buddy_no=?", new String[]{this.mBuddyNo, null, String.valueOf(EnumC0695j.ONETOONE.m3146a())}, null);
        } else {
            this.mQueryHandler.startQuery(1, null, C0694i.m3139a(), null, "inbox_no=?", new String[]{this.mInboxNo}, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean requestEndChat() {
        int iM3420a = C0809s.m3420a(GlobalApplication.m3260b());
        if (-3 == iM3420a || -2 == iM3420a) {
            C2153y.m7535a(getActivity(), R.string.popup_no_network_connection, 0).show();
            return false;
        }
        AlertDialogBuilderC2120a alertDialogBuilderC2120a = new AlertDialogBuilderC2120a(getActivity());
        alertDialogBuilderC2120a.setTitle(R.string.menu_chat_close);
        alertDialogBuilderC2120a.setMessage(R.string.chat_deleted_popup);
        alertDialogBuilderC2120a.setCancelable(true).setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.specialbuddy.SpecialBuddyChatFragment.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                SpecialBuddyChatFragment.this.endChat();
            }
        }).setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.specialbuddy.SpecialBuddyChatFragment.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        alertDialogBuilderC2120a.show();
        return true;
    }

    public void endChat() {
        if (this.mInboxRowID >= 0) {
            C1788t.m6070a(getActivity()).m6073a(this.mInboxRowID);
        }
        if (!TextUtils.isEmpty(this.mInboxNo)) {
            this.mQueryHandler.startDelete(2, null, C0694i.f2616a, "inbox_no IN ('" + this.mInboxNo + "')", null);
            this.mQueryHandler.startDelete(3, null, C0698m.f2626a, "message_inbox_no='" + this.mInboxNo + "'", null);
        }
        this.mMessageControl.m2954f();
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeTabletFragment.EmptyFragment(), "container").commitAllowingStateLoss();
    }

    void goChatInfo() {
        if (!TextUtils.isEmpty(this.mInboxNo)) {
            Intent intent = new Intent(getActivity(), (Class<?>) SpecialBuddyInfo.class);
            intent.putExtra("buddy_no", this.mBuddyNo);
            intent.putExtra("buddy_name", this.mBuddyName);
            intent.putExtra("inbox_no", this.mInboxNo);
            startActivityForResult(intent, 1);
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC0454a
    public boolean isBackKeyIgnore() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean setMessageControl() {
        if (this.mIsPause) {
            return false;
        }
        GlobalApplication.f2776b = this.mInboxNo;
        this.mMessageControl = C0639k.m2904a(this.mMessageHandler, this.mInboxNo, this.mChatType);
        if (this.mMessageControl == null) {
            return false;
        }
        C0795e.m3383a().m3387b();
        return true;
    }

    private void sendErrorFileCreator() {
        if (this.mWebView != null && this.mEntryFileCreator != null) {
            this.mWebView.loadUrl(String.format("javascript:%s(\"\")", this.mEntryFileCreator.error.toString()));
            C1786r.m6061b("spbd_kpop, sendErrorFileCreator(), filecreator error send ", getClass().getSimpleName());
        }
    }

    public void showRetryUploadVoice() {
        AlertDialogBuilderC2120a alertDialogBuilderC2120a = new AlertDialogBuilderC2120a(GlobalApplication.m3260b());
        alertDialogBuilderC2120a.setTitle(R.string.app_name);
        alertDialogBuilderC2120a.setMessage(R.string.toast_file_upload_fail);
        alertDialogBuilderC2120a.create();
        alertDialogBuilderC2120a.setPositiveButton(R.string.buddy_list_dialog_addbuddy_button_retry, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.specialbuddy.SpecialBuddyChatFragment.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                SpecialBuddyChatFragment.this.sendLastRecordedVoiceFile();
            }
        });
        alertDialogBuilderC2120a.setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.specialbuddy.SpecialBuddyChatFragment.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alertDialogBuilderC2120a.show();
    }

    public AlertDialogBuilderC2120a authErrorPopup(EnumC0104e enumC0104e) {
        this.builder = new AlertDialogBuilderC2120a(getActivity());
        if (enumC0104e == EnumC0104e.END_APP) {
            this.builder.setMessage(R.string.provision_error_end).setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.specialbuddy.SpecialBuddyChatFragment.11
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    GlobalApplication.m3258a(GlobalApplication.m3260b());
                }
            });
            return this.builder;
        }
        if (enumC0104e == EnumC0104e.RESTART_APP) {
            this.builder.setMessage(R.string.auth_error_restart).setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.specialbuddy.SpecialBuddyChatFragment.12
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    GlobalApplication.m3261b(GlobalApplication.m3260b());
                }
            });
            return this.builder;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopDownloadMyVoiceFile() {
        C1830a.m6211a().m6216a(this.mUiHandler, this.mRequestUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeDownloadProgressDialog() {
        if (this.mDownloadProgressDialog != null && this.mDownloadProgressDialog.isShowing()) {
            this.mDownloadProgressDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDownloadProgressDialog() {
        if (this.mDownloadProgressDialog == null) {
            this.mDownloadProgressDialog = new AlertDialogC1839a(getActivity());
            this.mDownloadProgressDialog.setTitle(getString(R.string.media_file_download));
            this.mDownloadProgressDialog.m6239a();
            this.mDownloadProgressDialog.setButton(getString(R.string.dialog_cancel), new DialogInterface.OnClickListener() { // from class: com.sec.chaton.specialbuddy.SpecialBuddyChatFragment.15
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    SpecialBuddyChatFragment.this.stopDownloadMyVoiceFile();
                }
            });
            this.mDownloadProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.sec.chaton.specialbuddy.SpecialBuddyChatFragment.16
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    SpecialBuddyChatFragment.this.stopDownloadMyVoiceFile();
                }
            });
        }
        if (!this.mDownloadProgressDialog.isShowing()) {
            this.mDownloadProgressDialog.show();
            this.mDownloadProgressDialog.m6242c(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startWebContents(String str, String str2) {
        this.mProgressBar.setVisibility(0);
        this.mIsStartedContents = true;
        String str3 = str + "?" + ("specialuserid=" + str2) + "&" + ("myid=" + C1789u.m6075a().getString("msisdn", ""));
        this.mWebView.loadUrl(str3);
        C1786r.m6061b("spbd_refresh, startWebContents() is called //" + str2, getClass().getSimpleName());
        C1786r.m6061b("spbd_procedure #1 [to MobileWeb] request url : " + str3.toString(), getClass().getSimpleName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshWebContents() {
        C1786r.m6061b("spbd_refresh, refreshWebContents()", getClass().getSimpleName());
        this.mWebView.loadUrl("javascript:chaton.loadNewer()");
    }

    class SpbdWebViewClient extends WebViewClient {
        private SpbdWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            C1786r.m6061b("hslee_web, view, onPageStarted : " + (TextUtils.isEmpty(str) ? "(null)" : str).toString(), getClass().getSimpleName());
            SpecialBuddyChatFragment.this.mProgressBar.setVisibility(0);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            C1786r.m6061b("hslee_web, view, onPageFinished : " + (TextUtils.isEmpty(str) ? "(null)" : str).toString(), getClass().getSimpleName());
            SpecialBuddyChatFragment.this.mProgressBar.setVisibility(4);
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            C1786r.m6061b("hslee_web, view, onLoadResource()", getClass().getSimpleName());
            super.onLoadResource(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            C1786r.m6061b("hslee_web, view, onReceivedError : " + i + "/" + (TextUtils.isEmpty(str) ? "(null)" : str).toString() + "/" + (TextUtils.isEmpty(str2) ? "(null)" : str2).toString(), getClass().getSimpleName());
            super.onReceivedError(webView, i, str, str2);
            SpecialBuddyChatFragment.this.mWebView.setVisibility(8);
            SpecialBuddyChatFragment.this.networkError.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            C1786r.m6061b("hslee_web, view, onReceivedHttpAuthRequest : " + (TextUtils.isEmpty(str) ? "(null)" : str).toString() + "/" + (TextUtils.isEmpty(str2) ? "(null)" : str2).toString(), getClass().getSimpleName());
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onTooManyRedirects(WebView webView, Message message, Message message2) {
            C1786r.m6061b("hslee_web, view, onTooManyRedirects()", getClass().getSimpleName());
            super.onTooManyRedirects(webView, message, message2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            C1786r.m6061b("hslee_web, view, onReceivedSslError ", getClass().getSimpleName());
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        @Override // android.webkit.WebViewClient
        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            C1786r.m6061b("hslee_web, view, onUnhandledKeyEvent : " + keyEvent.toString(), getClass().getSimpleName());
            super.onUnhandledKeyEvent(webView, keyEvent);
        }

        @Override // android.webkit.WebViewClient
        public void onScaleChanged(WebView webView, float f, float f2) {
            C1786r.m6061b("hslee_web, view, onScaleChanged : " + f + "/" + f2, getClass().getSimpleName());
            super.onScaleChanged(webView, f, f2);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            C1786r.m6061b("hslee_web, view, shouldOverrideUrlLoading : " + (TextUtils.isEmpty(str) ? "(null)" : str).toString(), getClass().getSimpleName());
            if (str.startsWith("http")) {
                SpecialBuddyChatFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } else {
                webView.loadUrl(str);
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            C1786r.m6061b("hslee_web, view, shouldOverrideKeyEvent()", getClass().getSimpleName());
            return super.shouldOverrideKeyEvent(webView, keyEvent);
        }
    }

    class InternalWebChromeClient extends WebChromeClient {
        private InternalWebChromeClient() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            C1786r.m6061b("hslee_web, chrome, onProgressChanged : " + i, getClass().getSimpleName());
            super.onProgressChanged(webView, i);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            C1786r.m6061b("hslee_web, chrome, onCreateWindow", getClass().getSimpleName());
            return super.onCreateWindow(webView, z, z2, message);
        }

        @Override // android.webkit.WebChromeClient
        public void onCloseWindow(WebView webView) {
            C1786r.m6061b("hslee_web, chrome, onCloseWindow", getClass().getSimpleName());
            super.onCloseWindow(webView);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            C1786r.m6061b("hslee_web, chrome, onJsConfirm" + (TextUtils.isEmpty(str) ? "(null)" : str).toString() + "/" + (TextUtils.isEmpty(str2) ? "(null)" : str2).toString() + "/" + jsResult.toString(), getClass().getSimpleName());
            return super.onJsConfirm(webView, str, str2, jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            C1786r.m6061b("hslee_web, chrome, onJsPrompt" + (TextUtils.isEmpty(str) ? "(null)" : str).toString() + "/" + (TextUtils.isEmpty(str2) ? "(null)" : str2).toString() + "/" + (TextUtils.isEmpty(str3) ? "(null)" : str3).toString(), getClass().getSimpleName());
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            C1786r.m6061b("hslee_web, chrome, onJsBeforeUnload" + (TextUtils.isEmpty(str) ? "(null)" : str).toString() + "/" + (TextUtils.isEmpty(str2) ? "(null)" : str2).toString(), getClass().getSimpleName());
            return super.onJsBeforeUnload(webView, str, str2, jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsTimeout() {
            C1786r.m6061b("hslee_web, chrome, onJsTimeout", getClass().getSimpleName());
            return super.onJsTimeout();
        }

        public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
            C1786r.m6061b("hslee_web, chrome, onReachedMaxAppCacheSize", getClass().getSimpleName());
            super.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            C1786r.m6061b("hslee_web, chrome, onReceivedTitle :" + (TextUtils.isEmpty(str) ? "(null)" : str).toString(), getClass().getSimpleName());
            super.onReceivedTitle(webView, str);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            C1786r.m6061b("hslee_web, chrome, onReceivedIcon", getClass().getSimpleName());
            super.onReceivedIcon(webView, bitmap);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
            C1786r.m6061b("hslee_web, chrome, onReceivedTouchIconUrl : " + (TextUtils.isEmpty(str) ? "(null)" : str).toString() + "/" + z, getClass().getSimpleName());
            super.onReceivedTouchIconUrl(webView, str, z);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
            if (TextUtils.isEmpty(str)) {
                str = "(null)";
            }
            String str3 = TextUtils.isEmpty(str2) ? "(null)" : str2;
            SpecialBuddyChatFragment.this.dismissProgressDialog();
            C1786r.m6061b("hslee_web, chrome, onJsAlert : " + str.toString() + "/" + str3.toString(), getClass().getSimpleName());
            AlertDialogBuilderC2120a alertDialogBuilderC2120a = new AlertDialogBuilderC2120a(SpecialBuddyChatFragment.this.getActivity());
            alertDialogBuilderC2120a.setTitle(R.string.app_name);
            alertDialogBuilderC2120a.setMessage(str2);
            alertDialogBuilderC2120a.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.specialbuddy.SpecialBuddyChatFragment.InternalWebChromeClient.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            });
            AlertDialog alertDialogCreate = alertDialogBuilderC2120a.create();
            alertDialogCreate.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.sec.chaton.specialbuddy.SpecialBuddyChatFragment.InternalWebChromeClient.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    jsResult.cancel();
                }
            });
            alertDialogCreate.show();
            return true;
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC0495bi
    public void allowWithPush(String str, int i, String str2, String str3, EnumC0695j enumC0695j) {
        if (this.mMessageControl != null) {
            if (enumC0695j == EnumC0695j.BROADCAST || str3 == null || "null".equals(str3)) {
                String strValueOf = String.valueOf(System.currentTimeMillis());
                C0639k c0639kM2904a = C0639k.m2904a(this.mMessageHandler, strValueOf, enumC0695j);
                if (c0639kM2904a != null) {
                    c0639kM2904a.m2947a(strValueOf, str, i);
                    c0639kM2904a.m2944a(true);
                    c0639kM2904a.m2951c(this.mInboxNo);
                    this.mMessageControl.m2930a(Long.MAX_VALUE);
                    c0639kM2904a.m2946a(EnumC0695j.BROADCAST, str2, this.mLastMsgID, str3, this.mInboxNo, this.mLastTimeStamp, true);
                }
            } else {
                this.mMessageControl.m2954f();
                this.mMessageControl.m2947a(this.mInboxNo, str, i);
                this.mMessageControl.m2946a(enumC0695j, str2, this.mLastMsgID, str3, this.mInboxNo, this.mLastTimeStamp, true);
            }
            refreshWebContents();
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC0495bi
    public void setPreviewText(int i) {
    }

    @Override // com.sec.chaton.chat.InterfaceC0495bi
    public boolean enableAutoScroll() {
        return false;
    }

    @Override // com.sec.chaton.chat.InterfaceC0495bi
    public C1798b getMenu() {
        return this.mSpinnerAdapter;
    }

    @Override // com.sec.chaton.chat.InterfaceC0495bi
    public AdapterView.OnItemSelectedListener getMenuListener() {
        return this.mOnItemSelectedListener;
    }

    class SpbdWebBridgeClass {
        private static final int PROCESS_MOBILE_WEB_FILECREATOR = 3;
        private static final int PROCESS_MOBILE_WEB_FILEPLAYER = 4;
        private static final int PROCESS_MOBILE_WEB_HANDSHAKE = 1;
        private static final int PROCESS_MOBILE_WEB_PROXY = 2;

        private SpbdWebBridgeClass() {
        }

        public void handshake(String str) {
            C1786r.m6061b("handshake() is called", getClass().getSimpleName());
            Message messageObtainMessage = SpecialBuddyChatFragment.this.mMobileWebHandler.obtainMessage();
            messageObtainMessage.what = 1;
            messageObtainMessage.obj = str;
            SpecialBuddyChatFragment.this.mMobileWebHandler.sendMessage(messageObtainMessage);
        }

        public void proxy(String str) {
            C1786r.m6061b("proxy() is called", getClass().getSimpleName());
            Message messageObtainMessage = SpecialBuddyChatFragment.this.mMobileWebHandler.obtainMessage();
            messageObtainMessage.what = 2;
            messageObtainMessage.obj = str;
            SpecialBuddyChatFragment.this.mMobileWebHandler.sendMessage(messageObtainMessage);
        }

        public void filecreator(String str) {
            C1786r.m6061b("filecreator() is called", getClass().getSimpleName());
            Message messageObtainMessage = SpecialBuddyChatFragment.this.mMobileWebHandler.obtainMessage();
            messageObtainMessage.what = 3;
            messageObtainMessage.obj = str;
            SpecialBuddyChatFragment.this.mMobileWebHandler.sendMessage(messageObtainMessage);
        }

        public void fileplayer(String str) {
            C1786r.m6061b("fileplayer() is called", getClass().getSimpleName());
            Message messageObtainMessage = SpecialBuddyChatFragment.this.mMobileWebHandler.obtainMessage();
            messageObtainMessage.what = 4;
            messageObtainMessage.obj = str;
            SpecialBuddyChatFragment.this.mMobileWebHandler.sendMessage(messageObtainMessage);
        }
    }

    class MobileWebHandshakeTask extends AsyncTask {
        private MobileWebHandshakeTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(String... strArr) {
            StringBuilder sb = new StringBuilder();
            sb.append("proxy_v1").append(",");
            sb.append("handshake_v1").append(",");
            sb.append("filecreator_v2").append(",");
            sb.append("fileplayer_v1");
            C1786r.m6061b("handshake() makes method list : " + sb.toString(), getClass().getSimpleName());
            try {
                SpecialBuddyChatFragment.this.mEntryHandshake = (SpecialBuddyHandshakeEntry) new C1785q(strArr[0]).m6046a(SpecialBuddyHandshakeEntry.class);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InstantiationException e3) {
                e3.printStackTrace();
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            if (SpecialBuddyChatFragment.this.mEntryHandshake == null) {
                C1786r.m6054a("handshake(), entry is (null)", SpbdWebBridgeClass.class.getSimpleName());
                return null;
            }
            if (TextUtils.isEmpty(SpecialBuddyChatFragment.this.mEntryHandshake.success)) {
                C1786r.m6054a("handshake(), entry.success is (null)", SpbdWebBridgeClass.class.getSimpleName());
                return null;
            }
            if (TextUtils.isEmpty(sb)) {
                C1786r.m6054a("handshake(), method_name is (null)", SpbdWebBridgeClass.class.getSimpleName());
                return null;
            }
            C1786r.m6061b("spbd_procedure #2 [native] call proxy() ", SpecialBuddyChatFragment.class.getSimpleName());
            if (TextUtils.isEmpty(SpecialBuddyChatFragment.this.mEntryHandshake.success)) {
                C1786r.m6061b("  - success : (null)", SpecialBuddyChatFragment.class.getSimpleName());
            } else {
                C1786r.m6061b("  - success : " + SpecialBuddyChatFragment.this.mEntryHandshake.success.toString(), SpecialBuddyChatFragment.class.getSimpleName());
            }
            String str = String.format("javascript:%s(\"%s\")", SpecialBuddyChatFragment.this.mEntryHandshake.success.toString(), sb.toString());
            C1786r.m6061b("handshake() request LoadUrl : " + str.toString(), getClass().getSimpleName());
            return str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            if (!TextUtils.isEmpty(str)) {
                SpecialBuddyChatFragment.this.mWebView.loadUrl(str);
            }
            super.onPostExecute((MobileWebHandshakeTask) str);
        }
    }

    class MobileWebProxyTask extends AsyncTask {
        private MobileWebProxyTask() {
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... strArr) {
            try {
                SpecialBuddyChatFragment.this.mEntryProxy = (SpecialBuddyProxyEntry) new C1785q(strArr[0]).m6046a(SpecialBuddyProxyEntry.class);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InstantiationException e3) {
                e3.printStackTrace();
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            if (SpecialBuddyChatFragment.this.mEntryProxy == null) {
                C1786r.m6054a("proxy(), entry is (null)", SpbdWebBridgeClass.class.getSimpleName());
                return false;
            }
            C1786r.m6061b("spbd_procedure #2 [native] call proxy() ", SpecialBuddyChatFragment.class.getSimpleName());
            if (TextUtils.isEmpty(SpecialBuddyChatFragment.this.mEntryProxy.server)) {
                C1786r.m6061b("  - server : (null)", SpecialBuddyChatFragment.class.getSimpleName());
            } else {
                C1786r.m6061b("  - server : " + SpecialBuddyChatFragment.this.mEntryProxy.server.toString(), SpecialBuddyChatFragment.class.getSimpleName());
            }
            if (TextUtils.isEmpty(SpecialBuddyChatFragment.this.mEntryProxy.type)) {
                C1786r.m6061b("  - type : (null)", SpecialBuddyChatFragment.class.getSimpleName());
            } else {
                C1786r.m6061b("  - type: " + SpecialBuddyChatFragment.this.mEntryProxy.type.toString(), SpecialBuddyChatFragment.class.getSimpleName());
            }
            if (TextUtils.isEmpty(SpecialBuddyChatFragment.this.mEntryProxy.url)) {
                C1786r.m6061b("  - url : (null)", SpecialBuddyChatFragment.class.getSimpleName());
            } else {
                C1786r.m6061b("  - url : " + SpecialBuddyChatFragment.this.mEntryProxy.url.toString(), SpecialBuddyChatFragment.class.getSimpleName());
            }
            if (TextUtils.isEmpty(SpecialBuddyChatFragment.this.mEntryProxy.success)) {
                C1786r.m6061b("  - success : (null)", SpecialBuddyChatFragment.class.getSimpleName());
            } else {
                C1786r.m6061b("  - success : " + SpecialBuddyChatFragment.this.mEntryProxy.success.toString(), SpecialBuddyChatFragment.class.getSimpleName());
            }
            if (TextUtils.isEmpty(SpecialBuddyChatFragment.this.mEntryProxy.error)) {
                C1786r.m6061b("  - error : (null)", SpecialBuddyChatFragment.class.getSimpleName());
            } else {
                C1786r.m6061b("  - error : " + SpecialBuddyChatFragment.this.mEntryProxy.error.toString(), SpecialBuddyChatFragment.class.getSimpleName());
            }
            new C0633e(SpecialBuddyChatFragment.this.mSpecialBuddyContentsReceiveHandler).m2857a(SpecialBuddyChatFragment.this.mEntryProxy);
            return true;
        }
    }

    class MobileWebFileCreatorTask extends AsyncTask {
        private MobileWebFileCreatorTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... strArr) {
            C1786r.m6061b("filecreator() is called", getClass().getSimpleName());
            try {
                SpecialBuddyChatFragment.this.mEntryFileCreator = (SpecialBuddyFilecreateUploadEntry) new C1785q(strArr[0]).m6046a(SpecialBuddyFilecreateUploadEntry.class);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InstantiationException e3) {
                e3.printStackTrace();
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            if (SpecialBuddyChatFragment.this.mEntryFileCreator == null) {
                C1786r.m6054a("filecreator(), entry is (null)", SpbdWebBridgeClass.class.getSimpleName());
                return false;
            }
            C1786r.m6061b("filecreator(),  ", SpecialBuddyChatFragment.class.getSimpleName());
            if (TextUtils.isEmpty(SpecialBuddyChatFragment.this.mEntryFileCreator.creator)) {
                C1786r.m6061b("  - creator : (null)", SpecialBuddyChatFragment.class.getSimpleName());
            } else {
                C1786r.m6061b("  - creator : " + SpecialBuddyChatFragment.this.mEntryFileCreator.creator.toString(), SpecialBuddyChatFragment.class.getSimpleName());
            }
            if (TextUtils.isEmpty(SpecialBuddyChatFragment.this.mEntryFileCreator.success)) {
                C1786r.m6061b("  - success: (null)", SpecialBuddyChatFragment.class.getSimpleName());
            } else {
                C1786r.m6061b("  - success: " + SpecialBuddyChatFragment.this.mEntryFileCreator.success.toString(), SpecialBuddyChatFragment.class.getSimpleName());
            }
            if (TextUtils.isEmpty(SpecialBuddyChatFragment.this.mEntryFileCreator.error)) {
                C1786r.m6061b("  - error : (null)", SpecialBuddyChatFragment.class.getSimpleName());
            } else {
                C1786r.m6061b("  - error : " + SpecialBuddyChatFragment.this.mEntryFileCreator.error.toString(), SpecialBuddyChatFragment.class.getSimpleName());
            }
            if (TextUtils.isEmpty(SpecialBuddyChatFragment.this.mEntryFileCreator.success)) {
                return false;
            }
            if (SpecialBuddyFilecreateUploadEntry.CREATOR_RECORDER.equals(SpecialBuddyChatFragment.this.mEntryFileCreator.creator)) {
                Intent intent = new Intent(SpecialBuddyChatFragment.this.getActivity(), (Class<?>) RecordAudio.class);
                intent.putExtra("inbox_NO", SpecialBuddyChatFragment.this.mInboxNo);
                SpecialBuddyChatFragment.this.startActivityForResult(intent, 2);
            }
            return true;
        }
    }

    class MobileWebFilePlayerTask extends AsyncTask {
        private MobileWebFilePlayerTask() {
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            SpecialBuddyChatFragment.this.showDownloadProgressDialog();
            super.onPreExecute();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... strArr) {
            String str;
            try {
                SpecialBuddyChatFragment.this.mEntryFilePlayer = (SpecialBuddyFilePlayerEntry) new C1785q(strArr[0]).m6046a(SpecialBuddyFilePlayerEntry.class);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InstantiationException e3) {
                e3.printStackTrace();
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            if (SpecialBuddyChatFragment.this.mEntryFilePlayer == null) {
                C1786r.m6054a("mEntryFilePlayer(), entry is (null)", SpbdWebBridgeClass.class.getSimpleName());
                return false;
            }
            C1786r.m6061b("entry for player is : " + SpecialBuddyChatFragment.this.mEntryFilePlayer.toString(), getClass().getSimpleName());
            if (C1789u.m6075a().getBoolean("is_file_server_primary ", true)) {
                str = C0776c.m3308a(EnumC1764bt.PRIMARY, EnumC1765bu.FILE) + "/file";
            } else {
                str = C0776c.m3308a(EnumC1764bt.SECONDARY, EnumC1765bu.FILE) + "/file";
            }
            String string = C1789u.m6075a().getString("uid", "");
            SpecialBuddyChatFragment.this.mRequestUrl = str + "?uid=" + string + "&" + ("imei=" + C1721ad.m5873a() + "&buddyid=" + string + "&filename=" + SpecialBuddyChatFragment.this.mEntryFilePlayer.filename);
            try {
                C1830a.m6211a().m6214a(SpecialBuddyChatFragment.this.mUiHandler, SpecialBuddyChatFragment.this.mRequestUrl, new File(C1830a.m6212a(SpecialBuddyChatFragment.this.getActivity()), SpecialBuddyChatFragment.this.mEntryFilePlayer.filename), null);
                return true;
            } catch (IOException e5) {
                e5.printStackTrace();
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChatSelection(String str) {
        Fragment fragmentFindFragmentById = getFragmentManager().findFragmentById(R.id.fragment_msg_box);
        if (fragmentFindFragmentById instanceof MsgboxFragment) {
            ((MsgboxFragment) fragmentFindFragmentById).m3533a(str);
        }
    }
}
