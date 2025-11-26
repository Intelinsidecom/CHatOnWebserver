package com.sec.chaton.trunk;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.media.ThumbnailUtils;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.constant.ChatONConst;
import com.sec.chaton.control.MessageControl;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.image.ViewOriginalImage;
import com.sec.chaton.multimedia.video.VideoPreviewActivity;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.trunk.constant.TrunkConstant;
import com.sec.chaton.trunk.control.TrunkMessageControl;
import com.sec.chaton.trunk.control.task.GetCommentListTask;
import com.sec.chaton.trunk.control.task.GetItemTask;
import com.sec.chaton.trunk.database.DatabaseConstant;
import com.sec.chaton.trunk.database.helper.TrunkDatabaseHelper;
import com.sec.chaton.trunk.entry.GetCommentListEntry;
import com.sec.chaton.trunk.entry.GetItemEntry;
import com.sec.chaton.trunk.network.FileDownloadManager;
import com.sec.chaton.trunk.network.FileDownloadTask;
import com.sec.chaton.trunk.util.TrunkUtil;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.ChatOnGraphics;
import com.sec.chaton.util.ShareUtil;
import com.sec.chaton.util.StorageStateInfoUtil;
import com.sec.vip.amschaton.AMSPlayerActivity;
import java.io.File;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes.dex */
public class ContentFragment3 extends Fragment {
    private static final int MENU_DELETE = 1;
    private static final int REQUEST_REMOVE_COMMENT = 2;
    private static final int REQUEST_VIEW_MEDIA = 1;
    private static final String TAG = ContentFragment3.class.getSimpleName();
    private Activity mAttachedActivity;
    private ContentAdapter mContentAdapter;
    private String mContentId;
    private TrunkUtil.ContentType mContentType;
    private String mDirectory;
    private String mDownloadUrl;
    private FileDownloadManager mFileDownloadManager;
    private FileDownloadTask mFileDownloadTask;
    private String mFileName;
    private String mFilePath;
    private GetCommentListTask mGetCommentListTask;
    private GetItemTask mGetItemTask;
    private String mInboxNo;
    private Intent mIntent;
    private String mLastCommentId;
    private ProgressDialog mProgressDialog;
    private long mRegistrationTime;
    private String mSenderName;
    private String mSenderUID;
    private String mSessionId;
    private int mTotalCommentCount;
    private Button mTrunkCommentButton;
    private ProgressBar mTrunkCommentLoadingProgressbar;
    private TextView mTrunkContentCommentCount;
    private ProgressBar mTrunkContentDownloadProgressbar;
    private ImageView mTrunkContentImage;
    private ListView mTrunkContentList;
    private TextView mTrunkContentTitle;
    private TextView mTrunkContentTitleTime;
    private TrunkDatabaseHelper mTrunkDatabaseHelper;
    private View mTrunkHeaderArea;
    private TrunkMessageControl mTrunkMessageControl;
    private TextView mTrunkNoCommentText;
    private View mTrunkPlayButton;
    private View mTrunkPreviousCommentArea;
    private Button mTrunkPreviousCommentButton;
    private Button mTrunkRefreshCommentButton;
    private Button mTrunkShareButton;
    private int mViewCommentCount;
    private Handler mUiHandler = new Handler() { // from class: com.sec.chaton.trunk.ContentFragment3.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            HttpEntry httpEntry = (HttpEntry) message.obj;
            Object objM1956e = httpEntry.m1956e();
            if (message.what == 901) {
                if (objM1956e != ContentFragment3.this.mGetItemTask) {
                    ChatONLogWriter.m3506b("This response is canceled.", ContentFragment3.TAG);
                    return;
                }
                if (httpEntry.m1951b() == HttpResultCode.SUCCESS) {
                    GetItemEntry getItemEntry = (GetItemEntry) httpEntry.m1955d();
                    if (getItemEntry != null) {
                        ContentFragment3.this.mTotalCommentCount = getItemEntry.item.totcmtcnt;
                    }
                    ContentFragment3.this.fillTotalCommentCountInformation();
                    ContentFragment3.this.onCommentChanged(false, true);
                    ContentFragment3.this.mTrunkMessageControl.markAsRead(ContentFragment3.this.mSessionId, ContentFragment3.this.mContentId);
                } else {
                    ContentFragment3.this.onCommentChanged(true, true);
                    if (httpEntry.m1957f() == 86411) {
                        ContentFragment3.this.showContentDeletedPopup();
                    } else {
                        Toast.makeText(ContentFragment3.this.mAttachedActivity, C0062R.string.toast_network_unable, 1).show();
                    }
                }
                ContentFragment3.this.mTrunkCommentLoadingProgressbar.setVisibility(8);
                return;
            }
            if (message.what == 903) {
                if (objM1956e != ContentFragment3.this.mGetCommentListTask) {
                    ChatONLogWriter.m3506b("This response is canceled.", ContentFragment3.TAG);
                    return;
                }
                if (httpEntry.m1951b() == HttpResultCode.SUCCESS) {
                    int size = ((GetCommentListEntry) httpEntry.m1955d()).comments.size();
                    if (ContentFragment3.this.mLastCommentId != null && size >= 1) {
                        size--;
                    }
                    ChatONLogWriter.m3506b("Loaded comment count: " + size, ContentFragment3.TAG);
                    if (size < 30) {
                        ContentFragment3.this.onCommentChanged(false, false);
                    } else {
                        ContentFragment3.this.onCommentChanged(false, true);
                    }
                } else {
                    ContentFragment3.this.mTrunkPreviousCommentButton.setVisibility(0);
                    Toast.makeText(ContentFragment3.this.mAttachedActivity, C0062R.string.toast_network_unable, 1).show();
                }
                ContentFragment3.this.mTrunkCommentLoadingProgressbar.setVisibility(8);
                return;
            }
            if (message.what == 905) {
                if (ContentFragment3.this.mProgressDialog.isShowing()) {
                    ContentFragment3.this.mProgressDialog.dismiss();
                }
                if (httpEntry.m1951b() == HttpResultCode.SUCCESS) {
                    Toast.makeText(ContentFragment3.this.mAttachedActivity, C0062R.string.trunk_toast_deleted, 1).show();
                    ContentFragment3.this.mAttachedActivity.finish();
                    return;
                } else {
                    if (httpEntry.m1951b() == HttpResultCode.ERROR) {
                        Toast.makeText(ContentFragment3.this.mAttachedActivity, C0062R.string.toast_network_unable, 1).show();
                        return;
                    }
                    return;
                }
            }
            if (message.what == 906) {
                if (ContentFragment3.this.mProgressDialog.isShowing()) {
                    ContentFragment3.this.mProgressDialog.dismiss();
                }
                if (httpEntry.m1951b() != HttpResultCode.SUCCESS) {
                    Toast.makeText(ContentFragment3.this.mAttachedActivity, C0062R.string.toast_network_unable, 1).show();
                    return;
                }
                ContentFragment3.access$210(ContentFragment3.this);
                ContentFragment3.this.fillTotalCommentCountInformation();
                ContentFragment3.this.onCommentChanged(false, true);
            }
        }
    };
    private Handler mFileDownloadHandler = new Handler() { // from class: com.sec.chaton.trunk.ContentFragment3.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 2) {
                FileDownloadTask.DownloadDoneResult downloadDoneResult = (FileDownloadTask.DownloadDoneResult) message.obj;
                if (downloadDoneResult == null) {
                    return;
                }
                ContentFragment3.this.mFilePath = downloadDoneResult.getDownloadUrl();
                MessageControl.m2017a(ContentFragment3.this.mInboxNo, downloadDoneResult.getDirectory(), downloadDoneResult.getFileName());
                ChatONLogWriter.m3506b("File download completed. File path: " + ContentFragment3.this.mFilePath, ContentFragment3.TAG);
                ContentFragment3.this.fillContentImageInformation();
                return;
            }
            if (message.what == 3 || message.what == 4) {
                if (message.what == 3) {
                    ChatONLogWriter.m3506b("File download canceled.", ContentFragment3.TAG);
                } else if (message.what == 4) {
                    ChatONLogWriter.m3506b("File download failed.", ContentFragment3.TAG);
                    Toast.makeText(ContentFragment3.this.mAttachedActivity, ContentFragment3.this.mAttachedActivity.getResources().getString(C0062R.string.toast_network_unable), 1).show();
                }
                if (ContentFragment3.this.mContentType == TrunkUtil.ContentType.IMAGE) {
                    ContentFragment3.this.mTrunkContentImage.setImageResource(C0062R.drawable.content_image_default);
                } else if (ContentFragment3.this.mContentType == TrunkUtil.ContentType.VIDEO) {
                    ContentFragment3.this.mTrunkContentImage.setImageResource(C0062R.drawable.content_default);
                }
                ContentFragment3.this.mTrunkContentDownloadProgressbar.setVisibility(8);
                ContentFragment3.this.mTrunkContentImage.setOnClickListener(null);
            }
        }
    };
    private AdapterView.OnItemLongClickListener mCommentItemLongClickListener = new AdapterView.OnItemLongClickListener() { // from class: com.sec.chaton.trunk.ContentFragment3.3
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
            Cursor cursor = (Cursor) adapterView.getAdapter().getItem(i);
            if (cursor == null) {
                ChatONLogWriter.m3510d("ContentFragment.onItemLongClick cursor is null.", ContentFragment3.TAG);
                return false;
            }
            String string = cursor.getString(cursor.getColumnIndex(DatabaseConstant.TrunkCommentColumns.KEY_WRITER_ID));
            final String string2 = cursor.getString(cursor.getColumnIndex(DatabaseConstant.TrunkCommentColumns.KEY_COMMENT_ID));
            if (!"ME".equals(string)) {
                ChatONLogWriter.m3508c("[TRUNK] MyUid == Sender, Disable delete button", ContentFragment3.TAG);
                return false;
            }
            AlertDialog alertDialogCreate = new AlertDialog.Builder(ContentFragment3.this.mAttachedActivity).setTitle(ChatONPref.m3519a().getString("Push Name", "")).setItems(C0062R.array.chat_date_bar, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.trunk.ContentFragment3.3.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    if (!ContentFragment3.this.mProgressDialog.isShowing()) {
                        ContentFragment3.this.mProgressDialog.show();
                    }
                    ContentFragment3.this.mTrunkMessageControl.removeComment(ContentFragment3.this.mSessionId, ContentFragment3.this.mContentId, string2);
                    dialogInterface.cancel();
                }
            }).create();
            alertDialogCreate.setCancelable(true);
            alertDialogCreate.show();
            return true;
        }
    };

    static /* synthetic */ int access$210(ContentFragment3 contentFragment3) {
        int i = contentFragment3.mTotalCommentCount;
        contentFragment3.mTotalCommentCount = i - 1;
        return i;
    }

    private Cursor createCommentCursor() {
        Cursor cursorQuery = this.mAttachedActivity.getContentResolver().query(DatabaseConstant.TrunkCommentTable.CONTENT_URI, null, "item_id=?", new String[]{this.mContentId}, "registration_time ASC");
        this.mAttachedActivity.startManagingCursor(cursorQuery);
        return cursorQuery;
    }

    private Cursor createTrunkItemCursor() {
        Cursor cursorQuery = this.mAttachedActivity.getContentResolver().query(DatabaseConstant.TrunkItemTable.CONTENT_URI, null, "item_id = ?", new String[]{this.mContentId}, null);
        this.mAttachedActivity.startManagingCursor(cursorQuery);
        return cursorQuery;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillContentImageInformation() {
        this.mTrunkContentDownloadProgressbar.setVisibility(8);
        if (this.mContentType != TrunkUtil.ContentType.IMAGE) {
            if (this.mContentType == TrunkUtil.ContentType.VIDEO) {
                this.mTrunkContentImage.setImageBitmap(ThumbnailUtils.createVideoThumbnail(this.mFilePath, 1));
                this.mTrunkPlayButton.setVisibility(0);
                this.mTrunkShareButton.setEnabled(true);
                return;
            }
            return;
        }
        boolean zIsAMSImage = TrunkUtil.IsAMSImage(this.mFilePath);
        ChatONLogWriter.m3506b("Is AMS image: " + zIsAMSImage, TAG);
        this.mTrunkContentImage.setImageBitmap(ChatOnGraphics.m3531a(this.mAttachedActivity, this.mFilePath));
        if (zIsAMSImage) {
            this.mTrunkPlayButton.setVisibility(0);
        }
        this.mTrunkShareButton.setEnabled(true);
    }

    private void fillPreviousCommentInformation() {
        this.mTrunkPreviousCommentButton.setText(this.mAttachedActivity.getString(C0062R.string.trunk_btn_previous_comments) + " (" + String.valueOf(this.mTotalCommentCount - this.mViewCommentCount) + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillTotalCommentCountInformation() {
        if (this.mTotalCommentCount == 0) {
            this.mTrunkContentCommentCount.setText("");
        } else if (this.mTotalCommentCount < 2) {
            this.mTrunkContentCommentCount.setText(C0062R.string.trunk_comment);
        } else {
            this.mTrunkContentCommentCount.setText(String.format(this.mAttachedActivity.getString(C0062R.string.trunk_comments), Integer.valueOf(this.mTotalCommentCount)));
        }
    }

    private String getDirectory(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(StorageStateInfoUtil.m3677a() ? GlobalApplication.m2387e().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m2387e().getFilesDir().getAbsolutePath());
        sb.append("/");
        sb.append(str);
        return sb.toString();
    }

    private void initDataFromDatabase() {
        ChatONLogWriter.m3506b("Load data from database.", TAG);
        Cursor cursorCreateTrunkItemCursor = createTrunkItemCursor();
        try {
            if (cursorCreateTrunkItemCursor == null) {
                ChatONLogWriter.m3499a("Cursor is null.", TAG);
                return;
            }
            try {
                if (cursorCreateTrunkItemCursor.moveToNext()) {
                    this.mSenderName = cursorCreateTrunkItemCursor.getString(cursorCreateTrunkItemCursor.getColumnIndex(DatabaseConstant.TrunkItemColumns.KEY_SENDER_NAME));
                    this.mRegistrationTime = cursorCreateTrunkItemCursor.getLong(cursorCreateTrunkItemCursor.getColumnIndex("registration_time"));
                    this.mDownloadUrl = cursorCreateTrunkItemCursor.getString(cursorCreateTrunkItemCursor.getColumnIndex(DatabaseConstant.TrunkItemColumns.KEY_DOWN_URL));
                    this.mContentType = TrunkUtil.GetContentType(cursorCreateTrunkItemCursor.getString(cursorCreateTrunkItemCursor.getColumnIndex(DatabaseConstant.TrunkItemColumns.KEY_CONTENT_TYPE)));
                    this.mTotalCommentCount = cursorCreateTrunkItemCursor.getInt(cursorCreateTrunkItemCursor.getColumnIndex(DatabaseConstant.TrunkItemColumns.KEY_TOTAL_COMMENT_COUNT));
                    this.mSenderUID = cursorCreateTrunkItemCursor.getString(cursorCreateTrunkItemCursor.getColumnIndex(DatabaseConstant.TrunkItemColumns.KEY_SENDER_UID));
                    if ("ME".equals(this.mSenderName)) {
                        this.mSenderName = this.mAttachedActivity.getResources().getString(C0062R.string.setting_interaction_me);
                    }
                    this.mDirectory = getDirectory(this.mInboxNo);
                    this.mFileName = TrunkUtil.ExtractFileNameFromUrl(this.mDownloadUrl);
                    this.mFilePath = this.mDirectory + File.separator + this.mFileName;
                }
                if (cursorCreateTrunkItemCursor == null) {
                    return;
                }
            } catch (MalformedURLException e) {
                ChatONLogWriter.m3499a("ContentFragment.initDataFromDatabase", TAG);
                ChatONLogWriter.m3501a(e, TAG);
                if (cursorCreateTrunkItemCursor == null) {
                    return;
                }
            }
            cursorCreateTrunkItemCursor.close();
        } catch (Throwable th) {
            if (cursorCreateTrunkItemCursor != null) {
                cursorCreateTrunkItemCursor.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCommentChanged(boolean z, boolean z2) {
        Cursor cursorCreateCommentCursor = createCommentCursor();
        this.mViewCommentCount = cursorCreateCommentCursor.getCount();
        ChatONLogWriter.m3506b("TotalCommentCount: " + this.mTotalCommentCount + ", ViewCommentCount: " + this.mViewCommentCount, TAG);
        this.mTrunkPreviousCommentArea.setVisibility(0);
        this.mTrunkPreviousCommentButton.setVisibility(8);
        this.mTrunkRefreshCommentButton.setVisibility(8);
        this.mTrunkNoCommentText.setVisibility(8);
        if (this.mTotalCommentCount == 0) {
            if (this.mViewCommentCount == 0 && z) {
                this.mTrunkRefreshCommentButton.setVisibility(0);
            } else {
                this.mTrunkPreviousCommentArea.setVisibility(8);
                this.mTrunkNoCommentText.setVisibility(0);
            }
        } else if (this.mTotalCommentCount <= this.mViewCommentCount) {
            this.mTrunkPreviousCommentArea.setVisibility(8);
        } else if (this.mViewCommentCount == 0 && z) {
            this.mTrunkRefreshCommentButton.setVisibility(0);
        } else {
            if (z2) {
                this.mTrunkPreviousCommentButton.setVisibility(0);
            } else {
                this.mTrunkPreviousCommentArea.setVisibility(8);
            }
            fillPreviousCommentInformation();
        }
        if (cursorCreateCommentCursor.moveToNext()) {
            this.mLastCommentId = cursorCreateCommentCursor.getString(cursorCreateCommentCursor.getColumnIndex(DatabaseConstant.TrunkCommentColumns.KEY_COMMENT_ID));
        } else {
            this.mLastCommentId = null;
        }
        this.mContentAdapter.changeCursor(cursorCreateCommentCursor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retrieveCommentList() {
        if (this.mGetCommentListTask != null) {
            this.mGetCommentListTask.cancel();
        }
        this.mGetCommentListTask = this.mTrunkMessageControl.retrieveCommentList(this.mSessionId, this.mContentId, this.mLastCommentId, 30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retrieveTrunkItem() {
        if (this.mGetItemTask != null) {
            this.mGetItemTask.cancel();
        }
        this.mGetItemTask = this.mTrunkMessageControl.retrieveTrunkItem(this.mSessionId, this.mContentId, 2, TrunkConstant.THUMBNAIL_SIZE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showContentDeletedPopup() {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this.mAttachedActivity).setTitle((CharSequence) null).setMessage(C0062R.string.trunk_content_deleted).setPositiveButton(C0062R.string.dialog_ok, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.trunk.ContentFragment3.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                new TrunkDatabaseHelper(ContentFragment3.this.mAttachedActivity).removeTrunkItem(ContentFragment3.this.mContentId);
                ContentFragment3.this.mAttachedActivity.finish();
            }
        }).create();
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.show();
    }

    public void fillTitleAndHeaderInformation() {
        initDataFromDatabase();
        this.mTrunkContentTitle.setText(this.mSenderName);
        this.mTrunkContentTitleTime.setText(new SimpleDateFormat("MMM d,yyyy HH:mm", Locale.ENGLISH).format(Long.valueOf(this.mRegistrationTime)));
        fillTotalCommentCountInformation();
        if (FileDownloadManager.getInstance().cache(this.mDirectory, this.mFileName) != null) {
            ChatONLogWriter.m3506b("Find cache data.", TAG);
            fillContentImageInformation();
            return;
        }
        ChatONLogWriter.m3506b("Can't find cached data.", TAG);
        if (this.mContentType == TrunkUtil.ContentType.IMAGE) {
            this.mTrunkContentDownloadProgressbar.setVisibility(0);
            this.mFileDownloadTask = this.mFileDownloadManager.download(this.mFileDownloadHandler, this.mDownloadUrl, this.mDirectory, this.mFileName, null);
        } else if (this.mContentType == TrunkUtil.ContentType.VIDEO) {
            this.mTrunkPlayButton.setVisibility(0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            if (i2 == 1) {
                this.mAttachedActivity.finish();
                return;
            }
            return;
        }
        if (i == 1) {
            if (intent.getBooleanExtra("SAVE", false)) {
                Toast.makeText(getActivity(), C0062R.string.toast_save_media, 0).show();
                return;
            } else {
                Toast.makeText(getActivity(), C0062R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                return;
            }
        }
        if (i == 2) {
            this.mTrunkDatabaseHelper.removeTrunkCommentsByItemId(this.mContentId);
            this.mContentAdapter.changeCursor(null);
            this.mTrunkPreviousCommentArea.setVisibility(0);
            this.mTrunkPreviousCommentButton.setVisibility(8);
            this.mTrunkRefreshCommentButton.setVisibility(8);
            this.mTrunkNoCommentText.setVisibility(8);
            this.mTrunkCommentLoadingProgressbar.setVisibility(0);
            retrieveTrunkItem();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAttachedActivity = getActivity();
        this.mIntent = this.mAttachedActivity.getIntent();
        this.mContentAdapter = new ContentAdapter(this.mAttachedActivity, null, 0);
        this.mTrunkMessageControl = new TrunkMessageControl(this.mAttachedActivity, this.mUiHandler);
        this.mTrunkDatabaseHelper = new TrunkDatabaseHelper(this.mAttachedActivity);
        this.mFileDownloadManager = FileDownloadManager.getInstance();
        this.mProgressDialog = new ProgressDialog(this.mAttachedActivity);
        this.mProgressDialog.setMessage(getString(C0062R.string.setting_webview_please_wait));
        this.mSessionId = this.mIntent.getStringExtra("sessionId");
        this.mInboxNo = this.mIntent.getStringExtra("inboxNO");
        this.mContentId = this.mIntent.getStringExtra("itemId");
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        MenuItem icon = menu.add(0, 1, 1, C0062R.string.chat_view_menu_delete).setIcon(C0062R.drawable.delete);
        if ("ME".equals(this.mSenderUID)) {
            icon.setEnabled(true);
        } else {
            icon.setEnabled(false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(C0062R.layout.trunk_content_fragment, viewGroup, false);
        this.mTrunkContentTitle = (TextView) viewInflate.findViewById(C0062R.id.trunkContentTitle);
        this.mTrunkContentTitleTime = (TextView) viewInflate.findViewById(C0062R.id.trunkContentTitleTime);
        this.mTrunkContentList = (ListView) viewInflate.findViewById(C0062R.id.trunkContentList);
        this.mTrunkContentList.setOnItemLongClickListener(this.mCommentItemLongClickListener);
        this.mTrunkHeaderArea = layoutInflater.inflate(C0062R.layout.item_trunkcontent_header_image, (ViewGroup) this.mTrunkContentList, false);
        this.mTrunkContentImage = (ImageView) this.mTrunkHeaderArea.findViewById(C0062R.id.trunkContentMainImage);
        this.mTrunkContentImage.setOnClickListener(new View.OnClickListener() { // from class: com.sec.chaton.trunk.ContentFragment3.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ContentFragment3.this.mFileDownloadTask == null || ContentFragment3.this.mFileDownloadTask.getStatus() == AsyncTask.Status.FINISHED) {
                    Intent intent = new Intent();
                    if (ContentFragment3.this.mContentType == TrunkUtil.ContentType.IMAGE) {
                        if (!TrunkUtil.IsAMSImage(ContentFragment3.this.mFilePath)) {
                            intent.setClass(ContentFragment3.this.mAttachedActivity, ViewOriginalImage.class);
                            intent.putExtra("URI", ContentFragment3.this.mFilePath);
                            intent.putExtra(ChatONConst.f1341e, true);
                        } else if (!"mounted".equals(Environment.getExternalStorageState())) {
                            Toast.makeText(ContentFragment3.this.mAttachedActivity, ContentFragment3.this.getString(C0062R.string.toast_sdcard_amount), 1).show();
                            return;
                        } else {
                            intent.setClass(ContentFragment3.this.mAttachedActivity, AMSPlayerActivity.class);
                            intent.putExtra("AMS_FILE_PATH", ContentFragment3.this.mFilePath);
                            intent.putExtra("VIEWER_MODE", 1002);
                        }
                    } else if (ContentFragment3.this.mContentType == TrunkUtil.ContentType.VIDEO) {
                        if (!"mounted".equals(Environment.getExternalStorageState())) {
                            Toast.makeText(ContentFragment3.this.mAttachedActivity, ContentFragment3.this.getString(C0062R.string.toast_sdcard_amount), 1).show();
                            return;
                        }
                        if (ContentFragment3.this.mFileDownloadManager.cache(ContentFragment3.this.mDirectory, ContentFragment3.this.mFileName) == null) {
                            ContentFragment3.this.mTrunkPlayButton.setVisibility(8);
                            ContentFragment3.this.mTrunkContentDownloadProgressbar.setVisibility(0);
                            ContentFragment3.this.mFileDownloadTask = ContentFragment3.this.mFileDownloadManager.download(ContentFragment3.this.mFileDownloadHandler, ContentFragment3.this.mDownloadUrl, ContentFragment3.this.mDirectory, ContentFragment3.this.mFileName, null);
                            return;
                        }
                        intent.setClass(ContentFragment3.this.mAttachedActivity, VideoPreviewActivity.class);
                        intent.putExtra("URI", ContentFragment3.this.mFilePath);
                        intent.putExtra("playDirectly", true);
                    }
                    ContentFragment3.this.startActivityForResult(intent, 1);
                }
            }
        });
        this.mTrunkPlayButton = this.mTrunkHeaderArea.findViewById(C0062R.id.defaultPlayBtn);
        this.mTrunkContentDownloadProgressbar = (ProgressBar) this.mTrunkHeaderArea.findViewById(C0062R.id.trunkContentDownloadProgressbar);
        this.mTrunkContentCommentCount = (TextView) this.mTrunkHeaderArea.findViewById(C0062R.id.trunkContentCommentCount);
        this.mTrunkPreviousCommentArea = this.mTrunkHeaderArea.findViewById(C0062R.id.trunkPreviousArea);
        this.mTrunkRefreshCommentButton = (Button) this.mTrunkHeaderArea.findViewById(C0062R.id.trunkRefreshCommentsButton);
        this.mTrunkRefreshCommentButton.setOnClickListener(new View.OnClickListener() { // from class: com.sec.chaton.trunk.ContentFragment3.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ContentFragment3.this.mTrunkRefreshCommentButton.setVisibility(8);
                ContentFragment3.this.mTrunkCommentLoadingProgressbar.setVisibility(0);
                ContentFragment3.this.retrieveTrunkItem();
            }
        });
        this.mTrunkPreviousCommentButton = (Button) this.mTrunkHeaderArea.findViewById(C0062R.id.trunkPreviousCommentsButton);
        this.mTrunkPreviousCommentButton.setOnClickListener(new View.OnClickListener() { // from class: com.sec.chaton.trunk.ContentFragment3.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ContentFragment3.this.mTrunkPreviousCommentButton.setVisibility(8);
                ContentFragment3.this.mTrunkCommentLoadingProgressbar.setVisibility(0);
                ContentFragment3.this.retrieveCommentList();
            }
        });
        this.mTrunkCommentLoadingProgressbar = (ProgressBar) this.mTrunkHeaderArea.findViewById(C0062R.id.trunkCommentsLoadingProgressbar);
        this.mTrunkNoCommentText = (TextView) this.mTrunkHeaderArea.findViewById(C0062R.id.trunkNoCommentTextView);
        this.mTrunkContentList.addHeaderView(this.mTrunkHeaderArea);
        this.mTrunkCommentButton = (Button) viewInflate.findViewById(C0062R.id.trunkContentCommentButton);
        this.mTrunkCommentButton.setOnClickListener(new View.OnClickListener() { // from class: com.sec.chaton.trunk.ContentFragment3.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CommentActivity.ActionStartCommentActivity(ContentFragment3.this.mAttachedActivity, ContentFragment3.this, 2, ContentFragment3.this.mSessionId, ContentFragment3.this.mContentId, ContentFragment3.this.mFilePath);
            }
        });
        this.mTrunkShareButton = (Button) viewInflate.findViewById(C0062R.id.trunkContentShareButton);
        this.mTrunkShareButton.setOnClickListener(new View.OnClickListener() { // from class: com.sec.chaton.trunk.ContentFragment3.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ContentFragment3.this.mContentType == TrunkUtil.ContentType.IMAGE) {
                    ShareUtil.m3657a(ContentFragment3.this.mAttachedActivity, ContentFragment3.this.mAttachedActivity.getString(C0062R.string.trunk_opt_header_share), ContentFragment3.this.mFilePath, (String) null, (String) null);
                } else if (ContentFragment3.this.mContentType == TrunkUtil.ContentType.VIDEO) {
                    ShareUtil.m3659b(ContentFragment3.this.mAttachedActivity, ContentFragment3.this.mAttachedActivity.getString(C0062R.string.trunk_opt_header_share), ContentFragment3.this.mFilePath, (String) null, (String) null);
                }
            }
        });
        setHasOptionsMenu(true);
        fillTitleAndHeaderInformation();
        this.mTrunkContentList.setAdapter((ListAdapter) this.mContentAdapter);
        this.mTrunkDatabaseHelper.removeTrunkCommentsByItemId(this.mContentId);
        retrieveTrunkItem();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ChatONLogWriter.m3506b("ContentFragment3.onDestroy()", TAG);
        if (this.mGetItemTask != null) {
            this.mGetItemTask.cancel();
            this.mGetItemTask = null;
        }
        if (this.mGetCommentListTask != null) {
            this.mGetCommentListTask.cancel();
            this.mGetCommentListTask = null;
        }
        if (this.mFileDownloadTask == null || this.mFileDownloadTask.getStatus() == AsyncTask.Status.FINISHED) {
            return;
        }
        ChatONLogWriter.m3506b("Cancel download.", TAG);
        this.mFileDownloadTask.cancel(true);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        switch (menuItem.getItemId()) {
            case 1:
                if (!this.mProgressDialog.isShowing()) {
                    this.mProgressDialog.show();
                }
                this.mTrunkMessageControl.deleteTrunkItem(this.mSessionId, this.mContentId);
                break;
        }
        return true;
    }
}
