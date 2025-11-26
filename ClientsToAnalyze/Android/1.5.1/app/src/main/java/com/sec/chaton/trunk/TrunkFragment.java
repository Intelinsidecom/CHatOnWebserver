package com.sec.chaton.trunk;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.trunk.constant.TrunkConstant;
import com.sec.chaton.trunk.control.TrunkMessageControl;
import com.sec.chaton.trunk.control.task.GetItemListTask;
import com.sec.chaton.trunk.database.DatabaseConstant;
import com.sec.chaton.trunk.util.TrunkUtil;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;

/* loaded from: classes.dex */
public class TrunkFragment extends Fragment implements OnContentClickListener {
    private static final String EXTRA_INBOX_NO_ID = "inboxNO";
    private static final String EXTRA_SESSION_ID = "sessionId";
    private static final int MENU_LIST_BY = 2;
    private static final int MENU_REFRESH = 1;
    private static final String TAG = TrunkFragment.class.getSimpleName();
    private TrunkAdapter mAdapter;
    private Activity mAttachedActivity;
    private GetItemListTask mGetItemListTask;
    private String mInboxNo;
    private Intent mIntent;
    private boolean mIsInited;
    private boolean mIsRefreshRequest;
    private boolean mIsToggleOrdering;
    private TrunkMessageControl.OrderingType mOrderType;
    private ProgressDialog mProgressDialog;
    private String mSessionId;
    private View mTrunkErrorNetowrk;
    private GridView mTrunkItemGridView;
    private TrunkMessageControl mTrunkMessageControl;
    private View mTrunkNothing;
    private Handler mUiHandler = new Handler() { // from class: com.sec.chaton.trunk.TrunkFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            HttpEntry httpEntry = (HttpEntry) message.obj;
            if (httpEntry.m1956e() != TrunkFragment.this.mGetItemListTask) {
                ChatONLogWriter.m3506b("This response is canceled.", TrunkFragment.TAG);
                if (TrunkFragment.this.mProgressDialog.isShowing()) {
                    TrunkFragment.this.mProgressDialog.dismiss();
                }
                return;
            }
            switch (message.what) {
                case TrunkMessageControl.METHOD_GET_ITEM_LIST /* 902 */:
                    if (httpEntry.m1951b() == HttpResultCode.SUCCESS && TrunkFragment.this.mIsToggleOrdering) {
                        TrunkFragment.this.mIsToggleOrdering = false;
                        TrunkFragment.this.toggleOrderingType();
                    }
                    Cursor cursorCreateTrunkItemCursor = TrunkFragment.this.createTrunkItemCursor();
                    if (cursorCreateTrunkItemCursor != null) {
                        if (httpEntry.m1951b() == HttpResultCode.SUCCESS) {
                            ChatONLogWriter.m3508c("Success: GetTrunkItem", TrunkFragment.TAG);
                            TrunkFragment.this.mTrunkErrorNetowrk.setVisibility(8);
                            if (TrunkFragment.this.mIsRefreshRequest) {
                                if (cursorCreateTrunkItemCursor.getCount() == 0) {
                                    TrunkFragment.this.mTrunkNothing.setVisibility(0);
                                    TrunkFragment.this.mTrunkItemGridView.setVisibility(8);
                                } else {
                                    TrunkFragment.this.mTrunkNothing.setVisibility(8);
                                    TrunkFragment.this.mTrunkItemGridView.setVisibility(0);
                                }
                            }
                        } else if (httpEntry.m1951b() == HttpResultCode.ERROR) {
                            ChatONLogWriter.m3499a("Fail: GetTrunkItem", TrunkFragment.TAG);
                            if (cursorCreateTrunkItemCursor.getCount() == 0) {
                                TrunkFragment.this.mTrunkNothing.setVisibility(8);
                                TrunkFragment.this.mTrunkItemGridView.setVisibility(8);
                                TrunkFragment.this.mTrunkErrorNetowrk.setVisibility(0);
                            } else {
                                TrunkFragment.this.mTrunkNothing.setVisibility(8);
                                TrunkFragment.this.mTrunkErrorNetowrk.setVisibility(8);
                                TrunkFragment.this.mTrunkItemGridView.setVisibility(0);
                            }
                            Toast.makeText(TrunkFragment.this.mAttachedActivity, TrunkFragment.this.mAttachedActivity.getResources().getString(C0062R.string.toast_network_unable), 1).show();
                        }
                        TrunkFragment.this.mAdapter.changeCursor(cursorCreateTrunkItemCursor);
                    }
                    if (TrunkFragment.this.mProgressDialog.isShowing()) {
                        TrunkFragment.this.mProgressDialog.dismiss();
                        break;
                    }
                    break;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public Cursor createTrunkItemCursor() {
        String str;
        String[] strArr;
        String str2;
        ContentResolver contentResolver = this.mAttachedActivity.getContentResolver();
        if (this.mOrderType == TrunkMessageControl.OrderingType.Recent) {
            str = "registration_time DESC";
            strArr = new String[]{this.mSessionId};
            str2 = "session_id = ?";
        } else {
            str = "last_comment_time DESC";
            strArr = new String[]{this.mSessionId, String.valueOf(DatabaseConstant.TrunkItemTable.ItemType.Item.getValue())};
            str2 = "session_id = ? AND item_type = ?";
        }
        Cursor cursorQuery = contentResolver.query(DatabaseConstant.TrunkItemTable.CONTENT_URI, null, str2, strArr, str);
        this.mAttachedActivity.startManagingCursor(cursorQuery);
        return cursorQuery;
    }

    private void moreTrunkItem(boolean z, String str) {
        if (z) {
            this.mProgressDialog.show();
        }
        this.mIsRefreshRequest = false;
        this.mGetItemListTask = this.mTrunkMessageControl.retrieveTrunkItemList(false, this.mSessionId, 31, this.mOrderType, TrunkConstant.THUMBNAIL_SIZE, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshTrunkItem(boolean z, TrunkMessageControl.OrderingType orderingType) {
        if (z) {
            this.mProgressDialog.show();
        }
        this.mIsRefreshRequest = true;
        this.mGetItemListTask = this.mTrunkMessageControl.retrieveTrunkItemList(true, this.mSessionId, 30, orderingType, TrunkConstant.THUMBNAIL_SIZE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleOrderingType() {
        if (this.mOrderType == TrunkMessageControl.OrderingType.Recent) {
            this.mOrderType = TrunkMessageControl.OrderingType.UnreadComment;
        } else if (this.mOrderType == TrunkMessageControl.OrderingType.UnreadComment) {
            this.mOrderType = TrunkMessageControl.OrderingType.Recent;
        }
        this.mAdapter.setOrderingType(this.mOrderType);
        ChatONPref.m3519a().edit().putString(TrunkConstant.PREF_ORDERING_TYPE, this.mOrderType.getValue()).commit();
    }

    @Override // com.sec.chaton.trunk.OnContentClickListener
    public void OnContentItemClickListener(View view, String str, DatabaseConstant.TrunkItemTable.ItemType itemType, String str2, TrunkUtil.ContentType contentType) {
        if (itemType == DatabaseConstant.TrunkItemTable.ItemType.Item) {
            ContentActivity.ActionStartContentActivity(this.mAttachedActivity, this.mSessionId, this.mInboxNo, str, str2, contentType);
        } else if (itemType == DatabaseConstant.TrunkItemTable.ItemType.LoadMore) {
            moreTrunkItem(true, str);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ChatONLogWriter.m3506b("TrunkFragment.onCreate()", TAG);
        this.mIsInited = false;
        this.mIsRefreshRequest = false;
        this.mIsToggleOrdering = false;
        this.mAttachedActivity = getActivity();
        this.mIntent = this.mAttachedActivity.getIntent();
        this.mSessionId = this.mIntent.getStringExtra(EXTRA_SESSION_ID);
        this.mInboxNo = this.mIntent.getStringExtra(EXTRA_INBOX_NO_ID);
        this.mOrderType = TrunkMessageControl.OrderingType.Convert(ChatONPref.m3519a().getString(TrunkConstant.PREF_ORDERING_TYPE, TrunkMessageControl.OrderingType.Recent.getValue()));
        this.mTrunkMessageControl = new TrunkMessageControl(this.mAttachedActivity, this.mUiHandler);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menu.add(0, 2, 1, C0062R.string.buddy_list_optionmenu_sortby).setIcon(C0062R.drawable.list_by);
        menu.add(0, 1, 2, C0062R.string.trunk_menu_refresh).setIcon(C0062R.drawable.refresh);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.mAttachedActivity.setTitle(C0062R.string.trunk_title);
        setHasOptionsMenu(true);
        this.mProgressDialog = new ProgressDialog(this.mAttachedActivity);
        this.mProgressDialog.setMessage(getString(C0062R.string.setting_webview_please_wait));
        this.mProgressDialog.setCancelable(false);
        View viewInflate = layoutInflater.inflate(C0062R.layout.trunk_fragment, viewGroup, false);
        this.mTrunkItemGridView = (GridView) viewInflate.findViewById(C0062R.id.trunkItemGridView);
        this.mTrunkNothing = viewInflate.findViewById(C0062R.id.trunkNothing);
        this.mTrunkErrorNetowrk = viewInflate.findViewById(C0062R.id.trunkNetworkError);
        if (this.mSessionId == null) {
            this.mTrunkErrorNetowrk.setVisibility(8);
            this.mTrunkItemGridView.setVisibility(8);
            this.mTrunkNothing.setVisibility(0);
        }
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ChatONLogWriter.m3506b("TrunkFragment.onDestroy()", TAG);
        this.mIsInited = false;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.mProgressDialog.isShowing()) {
            this.mProgressDialog.dismiss();
        }
        if (this.mGetItemListTask != null) {
            this.mGetItemListTask.cancel();
            this.mGetItemListTask = null;
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 1) {
            if (this.mSessionId == null) {
                ChatONLogWriter.m3506b("mSessionId is null. skip refresh logic.", TAG);
                return true;
            }
            refreshTrunkItem(true, this.mOrderType);
            return true;
        }
        if (menuItem.getItemId() != 2) {
            return false;
        }
        ChatONLogWriter.m3506b("Current order type: " + this.mOrderType + ", ordinal: " + this.mOrderType.ordinal(), TAG);
        new AlertDialog.Builder(this.mAttachedActivity).setTitle(C0062R.string.buddy_list_optionmenu_listby).setSingleChoiceItems(C0062R.array.trunk_ordering_types, this.mOrderType.ordinal(), new DialogInterface.OnClickListener() { // from class: com.sec.chaton.trunk.TrunkFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (TrunkFragment.this.mSessionId == null) {
                    ChatONLogWriter.m3506b("mSessionId is null. skip change order type logic.", TrunkFragment.TAG);
                    dialogInterface.dismiss();
                    return;
                }
                int iOrdinal = TrunkMessageControl.OrderingType.Recent.ordinal();
                int iOrdinal2 = TrunkMessageControl.OrderingType.UnreadComment.ordinal();
                if (i == TrunkFragment.this.mOrderType.ordinal()) {
                    ChatONLogWriter.m3506b("Current item == Selected item", TrunkFragment.TAG);
                    dialogInterface.dismiss();
                    return;
                }
                TrunkFragment.this.mIsToggleOrdering = true;
                if (i == iOrdinal) {
                    ChatONLogWriter.m3506b("Which: " + i + ", New: " + iOrdinal, TrunkFragment.TAG);
                    ChatONLogWriter.m3506b("Current: " + TrunkFragment.this.mOrderType + ", New: " + TrunkMessageControl.OrderingType.Recent, TrunkFragment.TAG);
                    TrunkFragment.this.refreshTrunkItem(true, TrunkMessageControl.OrderingType.Recent);
                } else if (i == iOrdinal2) {
                    ChatONLogWriter.m3506b("Which: " + i + ", New: " + iOrdinal2, TrunkFragment.TAG);
                    ChatONLogWriter.m3506b("Current: " + TrunkFragment.this.mOrderType + ", New: " + TrunkMessageControl.OrderingType.UnreadComment, TrunkFragment.TAG);
                    TrunkFragment.this.refreshTrunkItem(true, TrunkMessageControl.OrderingType.UnreadComment);
                } else {
                    ChatONLogWriter.m3510d("Unknown ordering type. " + i, TrunkFragment.TAG);
                }
                dialogInterface.dismiss();
            }
        }).show();
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        ChatONLogWriter.m3506b("TrunkFragment.onResume()", TAG);
        if (this.mSessionId == null) {
            ChatONLogWriter.m3506b("mSessionId is null. skip onResume logic.", TAG);
            return;
        }
        this.mAdapter = new TrunkAdapter(this.mAttachedActivity, createTrunkItemCursor(), 0, this.mOrderType, this.mInboxNo);
        this.mAdapter.setOnContentClickListener(this);
        this.mTrunkItemGridView.setAdapter((ListAdapter) this.mAdapter);
        if (this.mIsInited) {
            return;
        }
        this.mProgressDialog.show();
        refreshTrunkItem(true, this.mOrderType);
        this.mIsInited = true;
    }
}
