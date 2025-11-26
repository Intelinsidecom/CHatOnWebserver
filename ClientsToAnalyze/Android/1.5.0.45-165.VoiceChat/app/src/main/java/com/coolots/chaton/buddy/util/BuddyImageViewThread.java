package com.coolots.chaton.buddy.util;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.sds.coolots.common.util.Log;
import java.io.ByteArrayOutputStream;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import org.apache.http.util.ByteArrayBuffer;

/* loaded from: classes.dex */
public class BuddyImageViewThread extends Thread {
    private static LinkedList<BuddyImageViewReqValue> qProfImgReq = new LinkedList<>();
    protected static BuddyImageViewThread instance = null;
    protected static Object mutex = new Object();

    public static void addImageReq(long userNo, String imagePath, int imageViewType, Handler updateHandler) {
        BuddyImageViewReqValue reqValue = new BuddyImageViewReqValue();
        reqValue.setImageURL(imagePath);
        reqValue.setImageViewType(imageViewType);
        reqValue.setUserNo(userNo);
        reqValue.setUpdateHandler(updateHandler);
        qProfImgReq.add(reqValue);
        synchronized (mutex) {
            if (instance == null) {
                instance = new BuddyImageViewThread();
                instance.start();
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (true) {
            ByteArrayBuffer downloadedlBuffer = null;
            if (!qProfImgReq.isEmpty()) {
                try {
                    BuddyImageViewReqValue reqValue = qProfImgReq.poll();
                    boolean bSuccess = false;
                    if (reqValue != null) {
                        if (reqValue.getImageViewType() != 5 && reqValue.getImageViewType() != 1) {
                            if (reqValue.getImagePath() != null) {
                                downloadedlBuffer = BuddyImageUtil.downloadProfileImageFromServer(reqValue.getImagePath());
                            } else {
                                downloadedlBuffer = null;
                                Log.m2958e("BUDDY_TRACE ImageURL is null ");
                            }
                        }
                        String imagePath = reqValue.getImagePath();
                        switch (reqValue.getImageViewType()) {
                            case 0:
                                if (downloadedlBuffer == null) {
                                    bSuccess = false;
                                    break;
                                } else {
                                    bSuccess = BuddyImageUtil.saveBuddyThumbnailImageToLocal(reqValue.getUserNo(), downloadedlBuffer);
                                    imagePath = BuddyImageUtil.getBuddyThumbnailImageUrlInLocal(reqValue.getUserNo());
                                    break;
                                }
                            case 1:
                                bSuccess = true;
                                break;
                            case 2:
                                if (downloadedlBuffer == null) {
                                    bSuccess = false;
                                    break;
                                } else {
                                    bSuccess = BuddyImageUtil.saveMyThumbnailImageToLocal(downloadedlBuffer);
                                    imagePath = BuddyImageUtil.getMyThumbnailImageUrlInLocal();
                                    break;
                                }
                            case 3:
                                if (downloadedlBuffer == null) {
                                    bSuccess = false;
                                    break;
                                } else {
                                    bSuccess = BuddyImageUtil.saveMyProfileImageToLocal(downloadedlBuffer);
                                    imagePath = BuddyImageUtil.getMyProfileImageUrlInLocal();
                                    break;
                                }
                            case 4:
                                if (downloadedlBuffer == null) {
                                    bSuccess = false;
                                    break;
                                } else {
                                    bSuccess = BuddyImageUtil.saveGroupThumbnailImageToLocal(reqValue.getUserNo(), downloadedlBuffer);
                                    imagePath = BuddyImageUtil.getGroupThumbnailImageUrlInLocal(reqValue.getUserNo());
                                    break;
                                }
                            case 5:
                                bSuccess = true;
                                break;
                            case 6:
                                if (downloadedlBuffer == null) {
                                    bSuccess = false;
                                    break;
                                } else {
                                    bSuccess = BuddyImageUtil.saveVideoCallPortraitImageToLocal(downloadedlBuffer);
                                    imagePath = BuddyImageUtil.getVideoCallPortraitImageUrlInLocal();
                                    break;
                                }
                            case 7:
                                if (downloadedlBuffer == null) {
                                    bSuccess = false;
                                    break;
                                } else {
                                    bSuccess = BuddyImageUtil.saveVideoCallLandscapeImageToLocal(downloadedlBuffer);
                                    imagePath = BuddyImageUtil.getVideoCallLandscapeImageUrlInLocal();
                                    break;
                                }
                            case 8:
                                if (BuddyImageUtil.saveMyProfileImageToLocal(downloadedlBuffer)) {
                                    imagePath = BuddyImageUtil.getMyProfileImageUrlInLocal();
                                    Bitmap bitmap = BuddyImageUtil.getLocalBitmap(imagePath);
                                    Bitmap transferBitmap = BuddyImageUtil.makeThumbnailImage(bitmap);
                                    if (bitmap != null) {
                                        bitmap.recycle();
                                    }
                                    ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                                    transferBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArray);
                                    ByteArrayBuffer bab = new ByteArrayBuffer(50);
                                    byte[] b = byteArray.toByteArray();
                                    bab.append(b, 0, b.length);
                                    BuddyImageUtil.saveMyThumbnailImageToLocal(bab);
                                    if (transferBitmap != null) {
                                        transferBitmap.recycle();
                                        break;
                                    }
                                } else {
                                    bSuccess = false;
                                    break;
                                }
                                break;
                            case 9:
                                if (BuddyImageUtil.saveBuddyThumbnailImageToLocal(reqValue.getUserNo(), downloadedlBuffer)) {
                                    bSuccess = true;
                                    break;
                                } else {
                                    bSuccess = false;
                                    break;
                                }
                            case 10:
                                if (BuddyImageUtil.saveGroupThumbnailImageToLocal(reqValue.getUserNo(), downloadedlBuffer)) {
                                    bSuccess = true;
                                    break;
                                } else {
                                    bSuccess = false;
                                    break;
                                }
                            case 11:
                                if (BuddyImageUtil.saveVideoCallPortraitImageToLocal(downloadedlBuffer)) {
                                    bSuccess = true;
                                    break;
                                } else {
                                    bSuccess = false;
                                    break;
                                }
                            case 12:
                                if (BuddyImageUtil.saveVideoCallLandscapeImageToLocal(downloadedlBuffer)) {
                                    bSuccess = true;
                                    break;
                                } else {
                                    bSuccess = false;
                                    break;
                                }
                        }
                        try {
                            if (reqValue.getUpdateHandler() != null && bSuccess && imagePath != null) {
                                Log.m2958e("BUDDY_TRACE onImageUpdate!!!!!!!!!!");
                                Message msg = new Message();
                                msg.what = 10000;
                                msg.obj = imagePath;
                                reqValue.getUpdateHandler().sendMessage(msg);
                            }
                        } catch (Exception e) {
                        }
                    }
                } catch (NoSuchElementException e2) {
                    e2.printStackTrace();
                }
            }
        }
        instance = null;
    }

    public static class BuddyImageViewReqValue {
        private String imagePath = "";
        private int viewType = -1;
        private long userNo = -1;
        private Handler updateHandler = null;

        public void setImageURL(String imagePath) {
            this.imagePath = imagePath;
        }

        public String getImagePath() {
            return this.imagePath;
        }

        public void setImageViewType(int viewType) {
            this.viewType = viewType;
        }

        public int getImageViewType() {
            return this.viewType;
        }

        public void setUserNo(long userNo) {
            this.userNo = userNo;
        }

        public long getUserNo() {
            return this.userNo;
        }

        public void setUpdateHandler(Handler updateHandler2) {
            this.updateHandler = updateHandler2;
        }

        public Handler getUpdateHandler() {
            return this.updateHandler;
        }
    }
}
