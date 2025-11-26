package com.coolots.chaton.call.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.buddy.BuddyManager;
import com.coolots.chaton.buddy.util.BuddyImageUtil;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import java.io.File;

/* loaded from: classes.dex */
public class MobileMCUImageView extends ImageView {
    private static final String CLASSNAME = "[MobileMCUImageView]";
    Paint fontPaint;
    private boolean mIsActive;
    private String mUserID;
    private String mUserName;
    private long mUserNo;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public MobileMCUImageView(Context context) {
        super(context);
        this.mUserID = "";
        this.mUserName = "";
        this.mIsActive = false;
        this.fontPaint = new Paint();
        setVisibility(4);
    }

    public MobileMCUImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mUserID = "";
        this.mUserName = "";
        this.mIsActive = false;
        this.fontPaint = new Paint();
        setVisibility(4);
    }

    public MobileMCUImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mUserID = "";
        this.mUserName = "";
        this.mIsActive = false;
        this.fontPaint = new Paint();
        setVisibility(4);
    }

    public void setUserInfo(String id, String name) {
        logI("setUserInfo mUserID = " + this.mUserID + ", id = " + id + ", mIsActive = " + this.mIsActive);
        logI("setUserInfo mUserName = " + this.mUserName + ", name = " + name);
        if (!this.mUserID.equals(id) || !this.mUserName.equals(name)) {
            doAction(false);
            this.mUserID = id;
            this.mUserName = name;
            if (this.mUserID.equals("")) {
                this.mUserNo = 0L;
            } else {
                this.mUserNo = ((BuddyManager) MainApplication.mPhoneManager.getContactManager()).getUserNoByUserIDWithNoException(this.mUserID);
            }
        }
    }

    public String getUserID() {
        return this.mUserID;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public boolean isThumbnailExistInLocal(String filePath) {
        if (filePath == null || "".equals(filePath)) {
            return false;
        }
        File file = new File(filePath);
        boolean bFileExist = file.exists();
        return bFileExist;
    }

    private void loadImage() {
        String localImagePath;
        logI("loadImage mUserID = " + this.mUserID);
        if (this.mUserNo == 0) {
            localImagePath = BuddyImageUtil.getMyThumbnailImageUrlInLocal();
        } else {
            localImagePath = BuddyImageUtil.getBuddyThumbnailImageUrlInLocal(this.mUserNo);
        }
        logI("loadImage localImagePath = " + localImagePath);
        Bitmap bitmap = null;
        if (isThumbnailExistInLocal(localImagePath)) {
            bitmap = BuddyImageUtil.getLocalBitmap(localImagePath);
        }
        logI("loadImage bitmap = " + bitmap);
        if (bitmap == null) {
            setImageResource(C0000R.drawable.call_img_unknown);
        } else {
            setImageBitmap(bitmap);
        }
    }

    public void doAction(boolean isActive) {
        if (this.mIsActive != isActive) {
            if (isActive) {
                loadImage();
                setVisibility(0);
            } else {
                setVisibility(4);
            }
            this.mIsActive = isActive;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.fontPaint.setTextSize(20.0f);
        this.fontPaint.setColor(-16776961);
        this.fontPaint.setFakeBoldText(true);
        float startPositionX = (canvas.getWidth() - this.fontPaint.measureText(this.mUserName)) / 2.0f;
        float startPositionY = canvas.getHeight() - ((20.0f * 1.2f) * 3.0f);
        canvas.drawText(this.mUserName, startPositionX, startPositionY, this.fontPaint);
        float startPositionX2 = (canvas.getWidth() - this.fontPaint.measureText("음성 참가")) / 2.0f;
        float startPositionY2 = canvas.getHeight() - ((20.0f * 1.2f) * 2.0f);
        canvas.drawText("음성 참가", startPositionX2, startPositionY2, this.fontPaint);
    }
}
