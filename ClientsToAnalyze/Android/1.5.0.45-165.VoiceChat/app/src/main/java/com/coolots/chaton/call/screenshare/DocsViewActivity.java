package com.coolots.chaton.call.screenshare;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.screenshare.core.OverlayView;
import com.coolots.chaton.call.screenshare.filepicker.FilePickerActivity;
import com.coolots.chaton.call.screenshare.util.IDocsViewActivity;
import com.coolots.chaton.call.screenshare.util.IDocsViewTouchImage;
import com.coolots.chaton.call.screenshare.util.ScreenSharePacket;
import com.coolots.chaton.call.screenshare.util.ViewTouchImage;
import com.coolots.chaton.common.util.ChatONDialog;
import com.coolots.common.util.StringUtil;
import com.infraware.common.define.CMDefine;
import com.infraware.office.evengine.EvInterface;
import com.infraware.office.evengine.EvListener;
import com.infraware.office.evengine.InterfaceC0507E;
import com.samsung.android.sdk.pen.engine.SpenMultiView;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.EngineCallBackInterface;
import com.sds.coolots.common.util.FileUtil;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.io.File;

/* loaded from: classes.dex */
public class DocsViewActivity extends Activity implements EvListener.ViewerListener, View.OnClickListener, InterfaceC0507E.EV_ERROR_CODE, IDocsViewTouchImage, IDocsViewActivity, DisposeInterface {
    private static final String CLASSNAME = "[DocsViewActivity]";
    private static final int DELAY_SET_SPEN_DATA = 50;
    private static final int HIDE_DOCS_VIEW_INFO = 1000;
    private static final int LIMIT_PAGE_ABOUT_DOC_OPEN = 30;
    private static final int MYFILE_CALLBACK_CODE = 1000;
    private static final int SET_SPEN_DATA = 1002;
    private static final int START_DUMP_IMAGE = 1001;
    public DocsMenuView mDocsMenuView;
    private Button mDocsViewInfo;
    private FileUriArrayList mFileUriList;
    private ViewTouchImage mImage_src;
    private TextView mLayout_prepare;
    private EditText mPageEditText;
    public static final String EXTERNAL_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static final String ROOT_PATH = String.valueOf(EXTERNAL_PATH) + FileUtil.VIDEO_SAVE_PATH + "/DOCSVIEW/";
    private static boolean mStartDocsView = false;
    private boolean mIsSetSPenData = false;
    private EvInterface mEvInterface = null;
    private String mFilePath = "";
    private String mFirstDumpImage = "";
    private InnerHandler mInnerHandler = new InnerHandler(this, null);
    public boolean mIsDisplayZoom = false;
    private boolean isSelectViewMode = false;
    private boolean mIsSelectedFile = false;
    private boolean mCompletePrint = false;
    private int mUserID = 1;
    private int mPrintCount = 0;
    private DocsViewInfoHandler mDocsViewInfoHandler = new DocsViewInfoHandler();

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private class InnerHandler extends Handler {
        private InnerHandler() {
        }

        /* synthetic */ InnerHandler(DocsViewActivity docsViewActivity, InnerHandler innerHandler) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            DocsViewActivity.this.logI("haeri=<mInnerHandler> msg.what:" + msg.what);
            switch (msg.what) {
                case 1001:
                    DocsViewActivity.this.onClickDumpImageFile();
                    break;
                case 1002:
                    DocsViewActivity.this.continueDocsView();
                    break;
            }
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        logI("haeri= docsview activity onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(C0000R.layout.docsview);
        this.mDocsMenuView = null;
        this.mIsSelectedFile = false;
        this.mCompletePrint = false;
        Intent intent = getIntent();
        this.mUserID = intent.getIntExtra("UserID", 1);
        mStartDocsView = intent.getBooleanExtra("start_main", false);
        Init();
        createDocsMenuView();
        ScreenShareProc.mInstance.setDocsViewActivity(this);
        this.mFileUriList = new FileUriArrayList();
        if (this.mDocsMenuView.getDocsFilePath() != null) {
            restartFileDump();
        } else if (this.mDocsMenuView.getDocsImgeDumpPath() == null) {
            openFilePicker();
        } else {
            this.mIsSetSPenData = true;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.mIsSetSPenData) {
            this.mInnerHandler.sendEmptyMessageDelayed(1002, 50L);
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        logI("haeri= docsview activity onNewIntent()");
        if (intent.getBooleanExtra("KILL_APP", false)) {
            processEnd();
        }
        super.onNewIntent(intent);
    }

    public boolean isFileSelectView() {
        return this.isSelectViewMode;
    }

    public void setFileSelectView(boolean selectViewMode) {
        this.isSelectViewMode = selectViewMode;
    }

    private String getOpenFilePath(Intent intent) {
        if (intent == null) {
            return null;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String path = extras.getString(CMDefine.ExtraKey.OPEN_FILE);
            return path;
        }
        return "None";
    }

    private int getDensityDpi(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.densityDpi;
    }

    private int getDensityDpiForEvEngine(Activity activity) {
        int dpi = Math.round(getDensityDpi(activity) * 0.83125f);
        return dpi;
    }

    private void Init() {
        logI("haeri=init()");
        this.mFilePath = getOpenFilePath(getIntent());
        Display display = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        try {
            this.mEvInterface = EvInterface.getInterface(getApplicationInfo().dataDir);
            if (this.mEvInterface != null) {
                this.mEvInterface.ISetListener(this);
                this.mEvInterface.ISetInitialHeapSize(EngineCallBackInterface.SIP_RINGTONE_NONE);
                this.mEvInterface.IInitialize(display.getWidth(), display.getHeight(), getDensityDpiForEvEngine(this));
                if (this.mFilePath != null && !this.mFilePath.equals("None")) {
                    this.mEvInterface.IOpen(this.mFilePath, display.getWidth(), display.getHeight(), 0, 34, 0, "", "", "");
                }
                this.mLayout_prepare = (TextView) findViewById(C0000R.id.layout_prepare);
                this.mImage_src = (ViewTouchImage) findViewById(C0000R.id.image_src);
                if (this.mImage_src != null) {
                    this.mImage_src.setIDocsViewActivity(this);
                }
                this.mDocsViewInfo = (Button) findViewById(C0000R.id.docs_view_info_text);
                this.mDocsViewInfo.setOnClickListener(this);
                return;
            }
            finish();
        } catch (Exception e) {
            logI(" Docs View Activity exception: " + e);
            ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), "Can not operation Share Document ", 0);
            finish();
        }
    }

    public void openFilePicker() {
        Intent intent = new Intent(this, (Class<?>) FilePickerActivity.class);
        startActivityForResult(intent, 1000);
        this.isSelectViewMode = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void continueDocsView() {
        this.mFileUriList.setFilePath(this.mDocsMenuView.getDocsImgeDumpPath());
        this.mFileUriList.makeFileUriList();
        this.mLayout_prepare.setVisibility(8);
        setDocsViewImage();
        this.mIsSelectedFile = true;
        this.mCompletePrint = true;
        showStartDocsView();
        ScreenShareProc.mInstance.startOtherDocsView(true);
        setDocsPageInfo();
        hideDocsViewInfo();
        if (this.mDocsMenuView != null) {
            this.mDocsMenuView.enableTouch(true);
        }
        this.mIsSetSPenData = false;
    }

    public void sendDocsViewCanvasMatrix() {
        if (this.mDocsMenuView != null) {
            this.mDocsMenuView.sendMatrix();
        }
    }

    public void onClickDumpImageFile() {
        logI("haeri=Dump Image File Start~~!!");
        checkPrintStatus();
    }

    protected void checkPrintStatus() {
        String dumpImagePath = String.valueOf(ROOT_PATH) + System.currentTimeMillis();
        logI("haeri=checkPrintStatus() mDumpImagePath = " + dumpImagePath);
        this.mDocsMenuView.setDocsImgeDumpPath(dumpImagePath);
        this.mFileUriList.setFilePath(dumpImagePath);
        File newFolder = new File(dumpImagePath);
        if (!newFolder.exists() && newFolder.mkdirs()) {
            FileUtil.makeNoMediaFile(ROOT_PATH);
            logI("haeri=checkPrintStatus() mDumpImagePath =newFolder.mkdirs() ");
            int nTotalPage = this.mEvInterface.IGetConfig().nTotalPages;
            logI("haeri=checkPrintStatus()- dump image nTotalPage? " + nTotalPage);
            if (nTotalPage > 0) {
                if (nTotalPage >= 30) {
                    logI("<CIH> nTotalPage = " + nTotalPage);
                    this.mDocsMenuView.disposeDataController();
                    ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), getString(C0000R.string.screenshare_docs_view_file_too_large), 0);
                    resumeShareScreen();
                    return;
                }
                this.mFirstDumpImage = "";
                this.mEvInterface.ISetWHByPrint(1, nTotalPage, this.mFilePath, 2, dumpImagePath, 564, 814);
                this.mEvInterface.ISetPrintEx(2, 1, nTotalPage, this.mFilePath, 2, 1, null, dumpImagePath);
                logI("EvInterface.ISetPrintEx() \n:: DumpImageFilePath = " + dumpImagePath + "/");
            }
        }
    }

    public void onClickShowDumpImage() {
        logI("haeri=onClickShowDumpImage()");
        this.mLayout_prepare.setVisibility(8);
        this.mFileUriList.makeFileUriList();
        setDocsViewImage();
        if (this.mPrintCount == 0) {
            ScreenShareProc.setModeChangeForDocsView(1);
            if (this.mDocsMenuView != null) {
                this.mDocsMenuView.enableTouch(true);
            }
        }
        setDocsPageInfo();
        hideDocsViewInfo();
        this.mPrintCount++;
    }

    private void setDocsViewImage() {
        if (this.mFileUriList != null && this.mFileUriList.getSize() > 0) {
            DocsViewImageResize resizeDocsViewImage = new DocsViewImageResize(this.mFileUriList.getFileUri().getPath());
            if (this.mImage_src != null) {
                this.mImage_src.setImageBitmap(resizeDocsViewImage.getResutBitmap());
            }
            if (this.mDocsMenuView != null) {
                this.mDocsMenuView.getPageCanvas(this.mFileUriList.getCurrentIdx());
                this.mDocsMenuView.setBackGroudSyncImageTouchView();
            }
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        logI("haeri=request code?" + requestCode + "/result code?" + resultCode + "/intent?" + data);
        this.isSelectViewMode = false;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            if (resultCode == -1) {
                if (data != null) {
                    Bundle bundle = data.getExtras();
                    this.mIsSelectedFile = true;
                    showStartDocsView();
                    ScreenShareProc.mInstance.startOtherDocsView(true);
                    this.mFilePath = (String) bundle.get("TARGET_FILE_PATH");
                    logI("haeri=file path?" + this.mFilePath);
                    this.mDocsMenuView.setDocsFilePath(this.mFilePath);
                    this.mCompletePrint = false;
                    this.mEvInterface.IOpen(this.mFilePath, 0, 0, 0, 34, 0, "/mnt/sdcard/", "/mnt/sdcard/", "");
                    setDocumentName(this.mFilePath);
                    logI("haeri=file name1?" + this.mDocsMenuView.getDocsName());
                    ScreenShareProc.mInstance.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_VIEW_FILE_OPEN, null);
                    return;
                }
                return;
            }
            logI("haeri=file name2?" + this.mDocsMenuView.getDocsName());
            ScreenShareProc.mOtherStateMode = 0;
            resumeShareScreen();
            ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), getString(C0000R.string.share_docs_cancelled_restart), 0);
        }
    }

    private void resumeShareScreen() {
        MainApplication.mPhoneManager.getShareScreenManager().resumeShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), null, true);
        finishDocsView();
    }

    @Override // com.infraware.office.evengine.EvListener.ViewerListener
    public void OnLoadComplete() {
        logI("haeri=OnLoadComplete");
    }

    @Override // com.infraware.office.evengine.EvListener.ViewerListener
    public void OnTotalLoadComplete() {
        logI("haeri=OnTotalLoadCompleteTotalPage = " + this.mEvInterface.IGetConfig().nTotalPages);
        this.mDocsMenuView.setDocsTotalPageNum(this.mEvInterface.IGetConfig().nTotalPages);
        this.mInnerHandler.sendEmptyMessage(1001);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0012. Please report as an issue. */
    @Override // com.infraware.office.evengine.EvListener.ViewerListener
    public void OnLoadFail(int EEV_ERROR_CODE) {
        logI("OnLoadFail() :: EEV_ERROR_CODE = " + EEV_ERROR_CODE);
        switch (EEV_ERROR_CODE) {
        }
        this.mDocsMenuView.disposeDataController();
        ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), getString(C0000R.string.share_docs_fileselected_fail), 0);
        resumeShareScreen();
    }

    @Override // com.infraware.office.evengine.EvListener.ViewerListener
    public void OnCloseDoc() {
    }

    @Override // com.infraware.office.evengine.EvListener.ViewerListener
    public void OnPageMove(int nCurrentPage, int nTotalPage, int nErrorCode) {
    }

    @Override // com.infraware.office.evengine.EvListener.ViewerListener
    public void OnProgressStart(int EV_PROGRESS_TYPE) {
        logI("haeri=OnProgressStart + mode?" + EV_PROGRESS_TYPE);
    }

    @Override // com.infraware.office.evengine.EvListener.ViewerListener
    public void OnProgress(int EV_PROGRESS_TYPE, int nProgressValue) {
        logI("<CIH> OnProgress() = EV_PROGRESS_TYPE = " + EV_PROGRESS_TYPE + ", nProgressValue = " + nProgressValue);
    }

    @Override // com.infraware.office.evengine.EvListener.ViewerListener
    public void OnTerminate() {
    }

    @Override // com.infraware.office.evengine.EvListener.ViewerListener
    public Bitmap GetBitmap(int w, int h) {
        return null;
    }

    @Override // com.infraware.office.evengine.EvListener.ViewerListener
    public void OnDrawBitmap(int nCallId, int bShowAutomap) {
    }

    @Override // com.infraware.office.evengine.EvListener.ViewerListener
    public void OnPrintMode(String strPrintFile) {
        if (this.mFirstDumpImage.length() == 0) {
            this.mFirstDumpImage = strPrintFile;
        }
        if (strPrintFile != null) {
            int index = strPrintFile.lastIndexOf(47);
            logI("haeri=OnPrintMode?" + strPrintFile.substring(index + 1, strPrintFile.length()));
            onClickShowDumpImage();
        }
    }

    @Override // com.infraware.office.evengine.EvListener.ViewerListener
    public void OnPrintedCount(int nTotalCount) {
        this.mCompletePrint = true;
        logI("haeri=OnPrintedCount() :: nTotalCount = " + nTotalCount + "\n");
        this.mEvInterface.ISetHeapSize(this.mEvInterface.IGetInitialHeapSize());
        if (nTotalCount == 0) {
            logI("Dump Image File Fail!!");
            return;
        }
        logI("Dump Image File Success!!");
        this.mDocsMenuView.setDocsFilePath(null);
        onMediaDBBroadCast();
    }

    public void onMediaDBBroadCast() {
        Context context = getApplicationContext();
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + EXTERNAL_PATH)));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case C0000R.id.left_page_button /* 2131492975 */:
                moveToPrev();
                break;
            case C0000R.id.right_page_button /* 2131492976 */:
                moveToNext();
                break;
            case C0000R.id.docs_view_info_text /* 2131492980 */:
                if (!this.mIsDisplayZoom) {
                    showDialogForPageSetting();
                    break;
                }
                break;
        }
    }

    @Override // com.coolots.chaton.call.screenshare.util.IDocsViewActivity
    public void moveToPrev() {
        if (this.mCompletePrint || this.mFileUriList.getCurrentIdx() > 0) {
            this.mFileUriList.moveToPrev();
            if (this.mPageEditText != null) {
                this.mPageEditText.setText(Integer.toString(this.mFileUriList.getCurrentIdx() + 1));
            }
            setDocsViewImage();
        }
    }

    @Override // com.coolots.chaton.call.screenshare.util.IDocsViewActivity
    public void moveToNext() {
        if (this.mCompletePrint || this.mFileUriList.getCurrentIdx() < this.mPrintCount) {
            this.mFileUriList.moveToNext();
            if (this.mPageEditText != null) {
                this.mPageEditText.setText(Integer.toString(this.mFileUriList.getCurrentIdx() + 1));
            }
            setDocsViewImage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToPageNumber(int page) {
        this.mFileUriList.setCurrentIdx(page - 1);
        setDocsViewImage();
    }

    private void processEnd() {
        ScreenShareProc.setModeChangeForDocsView(0);
        finish();
    }

    private void showDocsViewInfo() {
        this.mDocsViewInfoHandler.removeMessages(1000);
        if (this.mDocsViewInfo.getVisibility() != 0) {
            this.mDocsViewInfo.setVisibility(0);
        }
    }

    public void hideDocsViewInfo() {
        if (this.mDocsViewInfo.getVisibility() == 0) {
            this.mDocsViewInfoHandler.removeMessages(1000);
            this.mDocsViewInfoHandler.sendEmptyMessageDelayed(1000, 2000L);
        }
    }

    public void setZoomRateInfo(String text) {
        this.mDocsViewInfo.setClickable(false);
        this.mDocsViewInfo.setText(String.valueOf(text) + " %");
        this.mIsDisplayZoom = true;
        showDocsViewInfo();
    }

    public void setDocsPageInfo() {
        if (this.mDocsViewInfo != null) {
            this.mDocsViewInfo.setClickable(true);
            String pageInfo = String.valueOf(this.mFileUriList.getCurrentIdx() + 1) + StringUtil.LOG_DELIMITER + Integer.toString(this.mDocsMenuView.getDocsToltalPageNum());
            this.mDocsViewInfo.setText(pageInfo);
            this.mIsDisplayZoom = false;
        }
        showDocsViewInfo();
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        ScreenShareProc.mInstance.setDocsViewActivity(null);
        if (this.mDocsMenuView != null) {
            this.mDocsMenuView.dispose();
            this.mDocsMenuView.removeAllViewsInLayout();
            this.mDocsMenuView = null;
        }
    }

    public class DocsViewInfoHandler extends Handler {
        public DocsViewInfoHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1000:
                    DocsViewActivity.this.mIsDisplayZoom = false;
                    DocsViewActivity.this.mDocsViewInfo.setVisibility(8);
                    break;
            }
        }
    }

    private static class PageTextFilter implements TextWatcher {
        private String beforeText;
        private EditText editText;
        private int maxPage;

        public PageTextFilter(EditText et, int maxPage) {
            this.editText = et;
            this.maxPage = maxPage;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            if (s.toString().length() > 0) {
                if (s.charAt(0) == '0') {
                    this.editText.setText(this.beforeText);
                    this.editText.setSelection(this.beforeText.length() - 1);
                } else if (Integer.parseInt(s.toString()) > this.maxPage) {
                    this.editText.setText(this.beforeText);
                    this.editText.setSelection(this.beforeText.length() - 1);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int arg1, int arg2, int arg3) {
            this.beforeText = s.toString();
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
        }
    }

    private void showDialogForPageSetting() {
        LayoutInflater layout = getLayoutInflater();
        View popupBody = layout.inflate(C0000R.layout.dialog_select_page_layout, (ViewGroup) null);
        this.mPageEditText = (EditText) popupBody.findViewById(C0000R.id.page_edit_text);
        this.mPageEditText.setText(Integer.toString(this.mFileUriList.getCurrentIdx() + 1));
        this.mPageEditText.setBackgroundColor(0);
        this.mPageEditText.setSelection(this.mPageEditText.getText().length(), this.mPageEditText.getText().length());
        this.mPageEditText.addTextChangedListener(new PageTextFilter(this.mPageEditText, this.mFileUriList.getSize()));
        Button leftPageBtn = (Button) popupBody.findViewById(C0000R.id.left_page_button);
        leftPageBtn.setOnClickListener(this);
        Button rightPageBtn = (Button) popupBody.findViewById(C0000R.id.right_page_button);
        rightPageBtn.setOnClickListener(this);
        ChatONDialog dialog = new ChatONDialog.Builder(this).setTitle(C0000R.string.preference_5_4_title).setPositiveButton(C0000R.string.ok, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.DocsViewActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog2, int which) {
                if (DocsViewActivity.this.mPageEditText.getText().length() > 0) {
                    DocsViewActivity.this.moveToPageNumber(Integer.parseInt(DocsViewActivity.this.mPageEditText.getText().toString()));
                }
                dialog2.dismiss();
            }
        }).setNegativeButton(C0000R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.DocsViewActivity.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog2, int which) {
                dialog2.dismiss();
            }
        }).setView(popupBody).create();
        dialog.setCancelable(true);
        dialog.show();
    }

    protected void createDocsMenuView() {
        logI("createDocsMenuView: mStartDocsView: " + mStartDocsView);
        if (mStartDocsView) {
            if (this.mDocsMenuView == null) {
                this.mDocsMenuView = new DocsMenuView(this, this);
                this.mDocsMenuView.dismiss();
                this.mDocsMenuView.setUserID(this.mUserID);
                this.mDocsMenuView.SetOnSendCommandData(new OverlayView.OnSendCommandData() { // from class: com.coolots.chaton.call.screenshare.DocsViewActivity.3
                    @Override // com.coolots.chaton.call.screenshare.core.OverlayView.OnSendCommandData
                    public void onSendData(int command, byte[] data) {
                        ScreenShareProc.mInstance.onSendData(command, data);
                    }
                });
                this.mDocsMenuView.setIChatOnSCanvasView(this);
            }
            if (this.mDocsMenuView != null) {
                this.mDocsMenuView.show();
            }
        }
    }

    public void setUserID(int userid) {
        this.mUserID = userid;
    }

    public void OnRecveData(int command, byte[] commandData) {
        if (this.mDocsMenuView != null) {
            this.mDocsMenuView.OnRecveData(command, commandData);
        }
    }

    public void onOtherPartyPage(int page) {
        if (this.mDocsMenuView != null) {
            this.mDocsMenuView.onOtherPartyPage(page);
        }
    }

    public void showStartDocsView() {
        if (this.mDocsMenuView == null) {
            createDocsMenuView();
            return;
        }
        logI("showStartDocsView");
        this.mDocsMenuView.showStartDocsView();
        this.mDocsMenuView.show();
    }

    public void setNormalMode(boolean isNormal) {
        if (this.mDocsMenuView != null) {
            this.mDocsMenuView.setNormalMode(isNormal);
            this.mDocsMenuView.setDocsViewMode(isNormal);
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        logI("onUserLeaveHint : " + this.mIsSelectedFile);
        if (this.mIsSelectedFile) {
            this.mDocsMenuView.pressHomeKey(true);
            finishDocsView();
        }
    }

    @Override // com.coolots.chaton.call.screenshare.util.IDocsViewTouchImage
    public void finishDocsView() {
        if (!this.mCompletePrint && this.mEvInterface != null) {
            this.mEvInterface.IClose();
        }
        if (this.mDocsMenuView != null) {
            this.mDocsMenuView.OnUserLeaveHintDocsView();
            this.mDocsMenuView.dispose();
        }
        ScreenShareProc.mInstance.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_CHANGE_SHARE_MODE, null);
        ScreenShareProc.endDocsView();
        ScreenShareProc.mInstance.setDocsView(false);
        processEnd();
    }

    public void setDocumentName(String docFilePath) {
        if (docFilePath != null) {
            int index = docFilePath.lastIndexOf(47);
            String documentName = docFilePath.substring(index + 1, docFilePath.length());
            this.mDocsMenuView.setDocsName(documentName);
        }
    }

    public void ViewRecursionF(Object vg) {
        if (vg instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) vg).getChildCount(); i++) {
                ViewRecursionF(((ViewGroup) vg).getChildAt(i));
            }
            return;
        }
        if (vg instanceof View) {
            float[] values = new float[18];
            ((View) vg).getMatrix().getValues(values);
        }
    }

    private void restartFileDump() {
        this.mIsSelectedFile = true;
        showStartDocsView();
        ScreenShareProc.mInstance.startOtherDocsView(true);
        this.mFilePath = this.mDocsMenuView.getDocsFilePath();
        this.mCompletePrint = false;
        this.mEvInterface.IOpen(this.mFilePath, 0, 0, 0, 34, 0, "", "", "");
        ScreenShareProc.mInstance.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_VIEW_FILE_OPEN, null);
    }

    @Override // com.coolots.chaton.call.screenshare.util.IDocsViewTouchImage
    public ViewTouchImage getViewTouchImage() {
        if (this.mImage_src != null) {
            return this.mImage_src;
        }
        return null;
    }

    @Override // com.coolots.chaton.call.screenshare.util.IDocsViewTouchImage
    public void setSCanvas(SpenMultiView spenmultiview) {
        if (this.mImage_src != null) {
            this.mImage_src.setSCanvas(spenmultiview);
        }
    }

    @Override // com.coolots.chaton.call.screenshare.util.IDocsViewTouchImage
    public int getCurrentPageNumber() {
        return this.mFileUriList.getCurrentIdx();
    }

    @Override // com.coolots.chaton.call.screenshare.util.IDocsViewTouchImage
    public boolean TouchEvent(MotionEvent event) {
        if (this.mImage_src != null) {
            this.mImage_src.onTouch(this.mImage_src, event);
            return false;
        }
        return false;
    }

    @Override // com.coolots.chaton.call.screenshare.util.IDocsViewTouchImage
    public Matrix getMatrix() {
        if (this.mImage_src != null) {
            return this.mImage_src.getMatrix();
        }
        return null;
    }

    @Override // com.coolots.chaton.call.screenshare.util.IDocsViewTouchImage
    public String getPageInfo() {
        return this.mDocsViewInfo.getText().toString();
    }

    @Override // com.coolots.chaton.call.screenshare.util.IDocsViewTouchImage
    public int getMaxPageNumber() {
        return this.mFileUriList.getSize();
    }

    @Override // com.coolots.chaton.call.screenshare.util.IDocsViewTouchImage
    public void setPageSwap(int pagenum) {
        moveToPageNumber(pagenum);
    }

    @Override // com.coolots.chaton.call.screenshare.util.IDocsViewTouchImage
    public boolean isDocsViewInfoZoom() {
        return this.mIsDisplayZoom;
    }
}
