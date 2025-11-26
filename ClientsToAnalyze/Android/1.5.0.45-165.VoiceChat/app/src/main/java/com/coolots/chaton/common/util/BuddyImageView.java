package com.coolots.chaton.common.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.buddy.util.BuddyImageUtil;
import com.coolots.chaton.buddy.util.BuddyImageViewThread;
import com.coolots.chaton.common.view.ConfigActivity;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import com.sec.chaton.clientapi.GraphAPI;
import com.sec.chaton.clientapi.exception.IllegalArgumentClientAPIException;
import com.sec.chaton.clientapi.exception.NotActivatedClientAPIException;
import com.sec.chaton.clientapi.exception.NotAvailableClientAPIException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes.dex */
public class BuddyImageView extends ImageView implements DisposeInterface {
    private static final int CANCEL_DOWNLOAD_PROFILE_IMAGE = 1111;
    private static final String CLASSNAME = "[BuddyImageView]";
    private static final int COVER_IMAGE_HEIGHT = 1080;
    private static final int COVER_IMAGE_WIDTH = 1080;
    private Handler imageUpdateHandler;
    private int imageViewMode;
    private String localImagePath;
    private ImageUpdateHandler mHandler;
    private ImageViewBitmap mImageViewBitmap;
    private MyNetworkTask mNetworkTask;
    private long mUserNo;
    private String serverImagePath;

    /* JADX INFO: Access modifiers changed from: private */
    public static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private class ImageViewBitmap {
        private Bitmap mBitmap;
        private boolean mIsCachedImage;

        private ImageViewBitmap() {
            this.mIsCachedImage = false;
            this.mBitmap = null;
        }

        /* synthetic */ ImageViewBitmap(BuddyImageView buddyImageView, ImageViewBitmap imageViewBitmap) {
            this();
        }

        public void setImageViewBitmap(boolean isCachedImage, Bitmap bitmap) {
            this.mIsCachedImage = isCachedImage;
            this.mBitmap = bitmap;
        }
    }

    private class ImageUpdateHandler extends Handler {
        private boolean mIsDisposed;

        private ImageUpdateHandler() {
            this.mIsDisposed = false;
        }

        /* synthetic */ ImageUpdateHandler(BuddyImageView buddyImageView, ImageUpdateHandler imageUpdateHandler) {
            this();
        }

        public void setDisposed() {
            this.mIsDisposed = true;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) throws Throwable {
            if (!this.mIsDisposed) {
                if (msg.what == 10000) {
                    String imagePath = (String) msg.obj;
                    BuddyImageView.logI("BUDDY_TRACE imagePath = " + imagePath);
                    switch (BuddyImageView.this.imageViewMode) {
                        case 0:
                        case 2:
                        case 3:
                        case 4:
                        case 6:
                        case 7:
                            BuddyImageView.this.mImageViewBitmap.setImageViewBitmap(false, BuddyImageUtil.getLocalBitmap(imagePath));
                            if (BuddyImageView.this.mImageViewBitmap.mBitmap != null) {
                                BuddyImageView.this.setImageBitmap(BuddyImageView.this.mImageViewBitmap.mBitmap);
                            } else {
                                if (BuddyImageView.this.imageViewMode != 0 && BuddyImageView.this.imageViewMode != 4) {
                                    BuddyImageView.this.saveDefaultImage();
                                    BuddyImageView.this.mImageViewBitmap.mBitmap = BuddyImageUtil.getLocalBitmap(BuddyImageView.this.localImagePath);
                                    BuddyImageView.this.setImageBitmap(BuddyImageView.this.mImageViewBitmap.mBitmap);
                                }
                                BuddyImageView.logI("BUDDY_TRACE IMAGEVIEW Decoding Fail - Save Default Image!!!");
                            }
                            BuddyImageView.this.postInvalidate();
                            break;
                        case 1:
                        case 5:
                            BuddyImageView.logI("IMAGEVIEW_MODE_BUDDY_PROFILE");
                            BuddyImageView.this.postInvalidate();
                            break;
                    }
                } else if (msg.what == BuddyImageView.CANCEL_DOWNLOAD_PROFILE_IMAGE) {
                    BuddyImageView.logI("Profile Image Download Time out!!!!!!!!!!!!!!");
                    if (BuddyImageView.this.mNetworkTask != null) {
                        if (BuddyImageView.this.mNetworkTask.getStatus() == AsyncTask.Status.RUNNING) {
                            BuddyImageView.this.mNetworkTask.cancel(true);
                            BuddyImageView.this.mNetworkTask.onCancelled();
                        }
                        BuddyImageView.logI("load thumnail!!!!!!!!");
                        if (BuddyImageView.this.imageViewMode == 1) {
                            BuddyImageView.this.setImageViewMode(0);
                            BuddyImageView.this.loadImage(BuddyImageView.this.mUserNo);
                        } else {
                            BuddyImageView.this.setImageViewMode(4);
                            BuddyImageView.this.loadImage(BuddyImageView.this.mUserNo);
                        }
                    }
                }
                if (BuddyImageView.this.imageUpdateHandler != null) {
                    BuddyImageView.this.imageUpdateHandler.sendEmptyMessage(10101010);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void saveDefaultImage() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coolots.chaton.common.util.BuddyImageView.saveDefaultImage():void");
    }

    public void setBuddyGroupDefaultImage() {
        switch (this.imageViewMode) {
            case 0:
            case 1:
            case 2:
                setImageResource(C0000R.drawable.call_img_unknown);
                break;
            case 4:
            case 5:
                setImageResource(C0000R.drawable.group_thumbnail_default);
                break;
        }
    }

    public void setBuddyGroupDefaultImageForCover(boolean isVoiceCall) {
        logI("BUDDY_TRACE setBuddyGroupDefaultImage!!!");
        switch (this.imageViewMode) {
            case 0:
                if (isVoiceCall) {
                    setImageResource(C0000R.drawable.call_chatonv_video_default_img);
                    break;
                } else {
                    setImageResource(C0000R.drawable.call_chatonv_voice_default_img);
                    break;
                }
            case 4:
                setImageResource(C0000R.drawable.group_thumbnail_default);
                break;
        }
    }

    public BuddyImageView(Context context) {
        super(context);
        this.localImagePath = null;
        this.serverImagePath = null;
        this.mImageViewBitmap = new ImageViewBitmap(this, null);
        this.mUserNo = 0L;
        this.mNetworkTask = null;
        this.mHandler = new ImageUpdateHandler(this, 0 == true ? 1 : 0);
        this.imageUpdateHandler = null;
        this.imageViewMode = -1;
    }

    public BuddyImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.localImagePath = null;
        this.serverImagePath = null;
        this.mImageViewBitmap = new ImageViewBitmap(this, null);
        this.mUserNo = 0L;
        this.mNetworkTask = null;
        this.mHandler = new ImageUpdateHandler(this, 0 == true ? 1 : 0);
        this.imageUpdateHandler = null;
        this.imageViewMode = -1;
    }

    public BuddyImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.localImagePath = null;
        this.serverImagePath = null;
        this.mImageViewBitmap = new ImageViewBitmap(this, null);
        this.mUserNo = 0L;
        this.mNetworkTask = null;
        this.mHandler = new ImageUpdateHandler(this, 0 == true ? 1 : 0);
        this.imageUpdateHandler = null;
        this.imageViewMode = -1;
    }

    public void setImageViewMode(int imageViewMode) {
        this.imageViewMode = imageViewMode;
    }

    public void loadImage(long userNo) throws Throwable {
        this.mUserNo = userNo;
        switch (this.imageViewMode) {
            case 0:
                this.localImagePath = BuddyImageUtil.getBuddyThumbnailImageUrlInLocal(userNo);
                this.mImageViewBitmap.setImageViewBitmap(true, getBitmapCache(this.localImagePath));
                if (this.mImageViewBitmap.mBitmap != null) {
                    setImageBitmap(this.mImageViewBitmap.mBitmap);
                    break;
                } else if (isThumbnailExistInLocal(this.localImagePath)) {
                    logI("BUDDY_TRACE Local");
                    this.mImageViewBitmap.setImageViewBitmap(false, BuddyImageUtil.getLocalBitmap(this.localImagePath));
                    if (this.mImageViewBitmap.mBitmap != null) {
                        setImageBitmap(this.mImageViewBitmap.mBitmap);
                    } else {
                        setBuddyGroupDefaultImage();
                    }
                    putBitmapCache(this.localImagePath, this.mImageViewBitmap.mBitmap);
                    break;
                } else {
                    setBuddyGroupDefaultImage();
                    this.serverImagePath = BuddyImageUtil.getBuddyThumbnailImageUrlByUserNoInServer(userNo);
                    BuddyImageViewThread.addImageReq(userNo, this.serverImagePath, 0, this.mHandler);
                    break;
                }
            case 1:
                this.serverImagePath = BuddyImageUtil.getBuddyProfileImageUrlByUserNoInServer(userNo);
                BuddyImageViewThread.addImageReq(userNo, this.serverImagePath, 1, this.mHandler);
                try {
                    URL onLineURL = new URL(this.serverImagePath);
                    logI("serverImagePath?" + this.serverImagePath);
                    this.mNetworkTask = new MyNetworkTask(this);
                    this.mNetworkTask.execute(onLineURL);
                    break;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    return;
                }
            case 2:
                this.localImagePath = BuddyImageUtil.getMyThumbnailImageUrlInLocal();
                if (isThumbnailExistInLocal(this.localImagePath)) {
                    this.mImageViewBitmap.setImageViewBitmap(false, BuddyImageUtil.getLocalBitmap(this.localImagePath));
                    if (this.mImageViewBitmap.mBitmap != null) {
                        setImageBitmap(this.mImageViewBitmap.mBitmap);
                    } else {
                        setBuddyGroupDefaultImage();
                    }
                    if (this.imageUpdateHandler != null) {
                        this.imageUpdateHandler.sendEmptyMessage(10101010);
                        break;
                    }
                } else {
                    saveDefaultImage();
                    setImageBitmap(this.mImageViewBitmap.mBitmap);
                    this.serverImagePath = BuddyImageUtil.getMyThumbnailImageUrlInServer();
                    BuddyImageViewThread.addImageReq(userNo, this.serverImagePath, 2, this.mHandler);
                    break;
                }
                break;
            case 3:
                this.localImagePath = BuddyImageUtil.getMyProfileImageUrlInLocal();
                if (isThumbnailExistInLocal(this.localImagePath)) {
                    this.mImageViewBitmap.setImageViewBitmap(false, BuddyImageUtil.getLocalBitmap(this.localImagePath));
                    setImageBitmap(this.mImageViewBitmap.mBitmap);
                    break;
                } else {
                    saveDefaultImage();
                    setImageBitmap(this.mImageViewBitmap.mBitmap);
                    this.serverImagePath = BuddyImageUtil.getMyProfileImageUrlInServer();
                    BuddyImageViewThread.addImageReq(userNo, this.serverImagePath, 3, this.mHandler);
                    break;
                }
            case 4:
                this.localImagePath = BuddyImageUtil.getGroupThumbnailImageUrlInLocal(userNo);
                this.mImageViewBitmap.setImageViewBitmap(true, getBitmapCache(this.localImagePath));
                if (this.mImageViewBitmap.mBitmap != null) {
                    setImageBitmap(this.mImageViewBitmap.mBitmap);
                    break;
                } else if (isThumbnailExistInLocal(this.localImagePath)) {
                    this.mImageViewBitmap.setImageViewBitmap(false, BuddyImageUtil.getLocalBitmap(this.localImagePath));
                    if (this.mImageViewBitmap.mBitmap != null) {
                        setImageBitmap(this.mImageViewBitmap.mBitmap);
                    } else {
                        setBuddyGroupDefaultImage();
                    }
                    putBitmapCache(this.localImagePath, this.mImageViewBitmap.mBitmap);
                    break;
                } else {
                    setBuddyGroupDefaultImage();
                    this.serverImagePath = BuddyImageUtil.getGroupThumbnailImageUrlInServer(ConfigActivity.getUserNo(), userNo);
                    BuddyImageViewThread.addImageReq(userNo, this.serverImagePath, 4, this.mHandler);
                    break;
                }
            case 5:
                this.serverImagePath = BuddyImageUtil.getGroupProfileImageUrlInServer(ConfigActivity.getUserNo(), userNo);
                BuddyImageViewThread.addImageReq(userNo, this.serverImagePath, 5, this.mHandler);
                try {
                    URL imageURL = new URL(this.serverImagePath);
                    logI("serverImagePath?" + this.serverImagePath);
                    this.mNetworkTask = new MyNetworkTask(this);
                    this.mNetworkTask.execute(imageURL);
                    break;
                } catch (MalformedURLException e2) {
                    e2.printStackTrace();
                    return;
                }
            case 6:
                this.localImagePath = BuddyImageUtil.getVideoCallPortraitImageUrlInLocal();
                if (isThumbnailExistInLocal(this.localImagePath)) {
                    this.mImageViewBitmap.setImageViewBitmap(false, BuddyImageUtil.getLocalBitmap(this.localImagePath));
                    setImageBitmap(this.mImageViewBitmap.mBitmap);
                    break;
                } else {
                    this.serverImagePath = BuddyImageUtil.getVideoCallPortraitImageUrlInServer();
                    BuddyImageViewThread.addImageReq(userNo, this.serverImagePath, 6, this.mHandler);
                    break;
                }
            case 7:
                this.localImagePath = BuddyImageUtil.getVideoCallLandscapeImageUrlInLocal();
                if (isThumbnailExistInLocal(this.localImagePath)) {
                    this.mImageViewBitmap.setImageViewBitmap(false, BuddyImageUtil.getLocalBitmap(this.localImagePath));
                    setImageBitmap(this.mImageViewBitmap.mBitmap);
                    break;
                } else {
                    this.serverImagePath = BuddyImageUtil.getVideoCallLandscapeImageUrlInServer();
                    BuddyImageViewThread.addImageReq(userNo, this.serverImagePath, 7, this.mHandler);
                    break;
                }
        }
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-789517);
        canvas.drawRoundRect(rectF, 9.0f, 9.0f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

    public void loadThumbImage(String BuddyID) throws IOException {
        Bitmap profileImage = null;
        switch (this.imageViewMode) {
            case 0:
                try {
                    profileImage = GraphAPI.getBuddyProfileImage(this.mContext, ChatONStringConvert.getInstance().removeFooter(BuddyID));
                } catch (IllegalArgumentClientAPIException e) {
                    e.printStackTrace();
                } catch (NotActivatedClientAPIException e2) {
                    e2.printStackTrace();
                } catch (NotAvailableClientAPIException e3) {
                    e3.printStackTrace();
                }
                if (profileImage == null) {
                    logI("profileImage is null");
                    Bitmap bmfd = BitmapFactory.decodeResource(getResources(), C0000R.drawable.call_img_unknown_list);
                    setImageBitmap(bmfd);
                    break;
                } else {
                    logI("profileImage is imageOn");
                    setImageBitmap(getRoundedCornerBitmap(profileImage));
                    break;
                }
            case 4:
            case 5:
                try {
                    profileImage = GraphAPI.getGroupProfileImage(this.mContext, BuddyID);
                } catch (IllegalArgumentClientAPIException e4) {
                    e4.printStackTrace();
                } catch (NotActivatedClientAPIException e5) {
                    e5.printStackTrace();
                } catch (NotAvailableClientAPIException e6) {
                    e6.printStackTrace();
                }
                if (profileImage == null) {
                    logI("Group profileImage is null");
                    setImageResource(C0000R.drawable.call_img_conference);
                    break;
                } else {
                    logI("Group profileImage is imageOn");
                    setImageBitmap(profileImage);
                    break;
                }
        }
    }

    public void loadImage(String BuddyID, boolean isConnected) throws IOException {
        Bitmap bmfd;
        Bitmap profileImage = null;
        switch (this.imageViewMode) {
            case 0:
                try {
                    profileImage = GraphAPI.getBuddyProfileImage(this.mContext, ChatONStringConvert.getInstance().removeFooter(BuddyID));
                } catch (IllegalArgumentClientAPIException e) {
                    e.printStackTrace();
                } catch (NotActivatedClientAPIException e2) {
                    e2.printStackTrace();
                } catch (NotAvailableClientAPIException e3) {
                    e3.printStackTrace();
                }
                if (profileImage == null) {
                    logI("profileImage is null");
                    if (isConnected) {
                        bmfd = BitmapFactory.decodeResource(getResources(), C0000R.drawable.call_img_unknown);
                    } else {
                        bmfd = BitmapFactory.decodeResource(getResources(), C0000R.drawable.call_image);
                    }
                    setImageBitmap(bmfd);
                    break;
                } else {
                    logI("profileImage is imageOn");
                    setImageBitmap(profileImage);
                    break;
                }
            case 4:
            case 5:
                try {
                    profileImage = GraphAPI.getGroupProfileImage(this.mContext, BuddyID);
                } catch (IllegalArgumentClientAPIException e4) {
                    e4.printStackTrace();
                } catch (NotActivatedClientAPIException e5) {
                    e5.printStackTrace();
                } catch (NotAvailableClientAPIException e6) {
                    e6.printStackTrace();
                }
                if (profileImage == null) {
                    logI("Group profileImage is null");
                    setImageResource(C0000R.drawable.call_img_conference);
                    break;
                } else {
                    logI("Group profileImage is imageOn");
                    setImageBitmap(profileImage);
                    break;
                }
        }
    }

    public void loadImageForCover(String BuddyID, boolean isVoiceCall) throws IOException {
        Bitmap profileImage = null;
        switch (this.imageViewMode) {
            case 0:
                try {
                    profileImage = GraphAPI.getBuddyProfileImage(this.mContext, ChatONStringConvert.getInstance().removeFooter(BuddyID));
                    if (profileImage != null) {
                        profileImage = Bitmap.createScaledBitmap(profileImage, 1080, 1080, true);
                        break;
                    }
                } catch (IllegalArgumentClientAPIException e) {
                    e.printStackTrace();
                    break;
                } catch (NotActivatedClientAPIException e2) {
                    e2.printStackTrace();
                    break;
                } catch (NotAvailableClientAPIException e3) {
                    e3.printStackTrace();
                    break;
                }
                break;
            case 4:
            case 5:
                try {
                    profileImage = GraphAPI.getGroupProfileImage(this.mContext, BuddyID);
                    break;
                } catch (IllegalArgumentClientAPIException e4) {
                    e4.printStackTrace();
                    break;
                } catch (NotActivatedClientAPIException e5) {
                    e5.printStackTrace();
                    break;
                } catch (NotAvailableClientAPIException e6) {
                    e6.printStackTrace();
                    break;
                }
        }
        if (profileImage == null) {
            logI("profile image is null");
            if (isVoiceCall) {
                setImageResource(C0000R.drawable.call_chatonv_voice_default_img);
                return;
            } else {
                setImageResource(C0000R.drawable.call_chatonv_video_default_img);
                return;
            }
        }
        logI("profile image is imageOn");
        setImageBitmap(profileImage);
    }

    public boolean isThumbnailExistInLocal(String filePath) {
        if (filePath == null || "".equals(filePath)) {
            return false;
        }
        File file = new File(filePath);
        boolean bFileExist = file.exists();
        return bFileExist;
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.localImagePath != null) {
            this.localImagePath = null;
        }
        if (this.serverImagePath != null) {
            this.serverImagePath = null;
        }
        if (this.mHandler != null) {
            this.mHandler.setDisposed();
            this.mHandler = null;
        }
        if (this.mImageViewBitmap != null && this.mImageViewBitmap.mBitmap != null) {
            if (!this.mImageViewBitmap.mIsCachedImage) {
                this.mImageViewBitmap.mBitmap.recycle();
            }
            this.mImageViewBitmap.mBitmap = null;
            this.mImageViewBitmap = null;
        }
        if (this.imageUpdateHandler != null) {
            this.imageUpdateHandler = null;
        }
        if (this.mNetworkTask != null) {
            this.mNetworkTask = null;
        }
    }

    public boolean isDefaultImage() {
        switch (this.imageViewMode) {
            case 2:
                if (ConfigActivity.getProfileImgUpdateDate().getTime() == 0) {
                    return true;
                }
            default:
                return false;
        }
    }

    public void SetImageUpdateHandler(Handler handler) {
        switch (this.imageViewMode) {
            case 6:
            case 7:
                this.imageUpdateHandler = handler;
                break;
        }
    }

    private void putBitmapCache(String Url, Bitmap image) {
        if (this.imageViewMode == 0 || this.imageViewMode == 4) {
            BitmapCache.getInstance().put(Url, image);
        }
    }

    private Bitmap getBitmapCache(String Url) {
        if (this.imageViewMode == 0 || this.imageViewMode == 4) {
            return BitmapCache.getInstance().getBitmap(Url);
        }
        return null;
    }

    private class MyNetworkTask extends AsyncTask<URL, Void, Bitmap> {
        private ProgressDialog dialog;
        private final ImageView tIV;

        public MyNetworkTask(ImageView imageView) {
            this.tIV = imageView;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            this.dialog = new ProgressDialog(BuddyImageView.this.mContext, C0000R.style.ChatOnVProgress);
            this.dialog.setMessage(BuddyImageView.this.getResources().getString(C0000R.string.buddy_adaptor_wait_progress));
            this.dialog.setIndeterminateDrawable(BuddyImageView.this.mContext.getResources().getDrawable(C0000R.drawable.chaton_ani_progress));
            this.dialog.show();
            BuddyImageView.this.mHandler.sendEmptyMessageDelayed(BuddyImageView.CANCEL_DOWNLOAD_PROFILE_IMAGE, 10000L);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(URL... urls) throws IOException {
            URL networkUrl = urls[0];
            try {
                URLConnection con = networkUrl.openConnection();
                Bitmap networkBitmap = BitmapFactory.decodeStream(con.getInputStream());
                return networkBitmap;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap result) {
            this.dialog.dismiss();
            if (result == null) {
                BuddyImageView.this.mHandler.removeMessages(BuddyImageView.CANCEL_DOWNLOAD_PROFILE_IMAGE);
                BuddyImageView.this.mHandler.sendEmptyMessage(BuddyImageView.CANCEL_DOWNLOAD_PROFILE_IMAGE);
            } else {
                this.tIV.setImageBitmap(result);
            }
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            BuddyImageView.logI("onCancelled()");
            cancel(true);
            this.dialog.dismiss();
        }
    }
}
