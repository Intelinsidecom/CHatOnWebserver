package com.coolots.chaton.buddy.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.BitmapCache;
import com.coolots.chaton.common.view.ConfigActivity;
import com.coolots.chaton.setting.data.ChatONHideMeImgData;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.coolotsinterface.FilePathInfoInterface;
import com.sds.coolots.common.util.FileUtil;
import com.sds.coolots.common.util.Log;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.apache.http.util.ByteArrayBuffer;

/* loaded from: classes.dex */
public class BuddyImageUtil implements FilePathInfoInterface {
    public static final String BUDDY_IMAGE_BUDDYS = "buddy";
    public static final String BUDDY_IMAGE_FOLDER = "images";
    public static final String BUDDY_IMAGE_GROUP = "group";
    public static final String BUDDY_IMAGE_PROFILE = "profile";
    public static final int IMAGEVIEW_HANDLER_DOWNLOAD_SUCCESS = 10000;
    public static final int IMAGEVIEW_MODE_BUDDY_IMAGE_UPDATE = 9;
    public static final int IMAGEVIEW_MODE_BUDDY_PROFILE = 1;
    public static final int IMAGEVIEW_MODE_BUDDY_THUMBNAIL = 0;
    public static final int IMAGEVIEW_MODE_GROUP_IMAGE_UPDATE = 10;
    public static final int IMAGEVIEW_MODE_GROUP_PROFILE = 5;
    public static final int IMAGEVIEW_MODE_GROUP_THUMBNAIL = 4;
    public static final int IMAGEVIEW_MODE_MY_IMAGE_UPDATE = 8;
    public static final int IMAGEVIEW_MODE_MY_PROFILE = 3;
    public static final int IMAGEVIEW_MODE_MY_THUMBNAIL = 2;
    public static final int IMAGEVIEW_MODE_VIDEOCALL_IMAGE_UPDATE_LAND = 12;
    public static final int IMAGEVIEW_MODE_VIDEOCALL_IMAGE_UPDATE_PORT = 11;
    public static final int IMAGEVIEW_MODE_VIDEOCALL_LANDSCAPE = 7;
    public static final int IMAGEVIEW_MODE_VIDEOCALL_PORTRAIT = 6;
    public static String IMAGE_BUDDY_PATH = null;
    public static String IMAGE_FOLDER_PATH = null;
    public static String IMAGE_GROUP_PATH = null;
    public static String IMAGE_MYPROFILE_PATH = null;
    private static final String IMAGE_SVR_URL_PROTOCOL = "http://";
    private static final String MY_PROFILE_IMAGE = "myprofile";
    private static final String MY_THUMBNAIL_IMAGE = "mythumbnail";
    private static final String PREFIX_REGION_DE = "de";
    private static final String PREFIX_REGION_KR = "kr";
    private static final String PREFIX_REGION_SG = "sg";
    private static final String PREFIX_REGION_US = "us";
    private static final String SVR_URL_FULL = "full/";
    private static final String SVR_URL_GROUP = "/group/";
    private static final String SVR_URL_PROFILE = "/profile/";
    private static final String SVR_URL_THUMBNAIL = "thumbnail/";
    private static final String SVR_URL_VIDEOCALL = "/videocall/";
    private static final String TEMP_FILE = "temp";
    private static final String THUMBNAIL_EXTENSION_PNG = ".png";
    public static final int THUMBNAIL_HEIGHT = 100;
    public static final int THUMBNAIL_WIDTH = 100;
    private static final String VIDEOCALL_LANDSCAPE_IMAGE = "videocall_land";
    private static final String VIDEOCALL_PORTRAIT_IMAGE = "videocall_port";

    static {
        if (MainApplication.mContext != null && MainApplication.mContext.getFilesDir() != null) {
            IMAGE_FOLDER_PATH = String.valueOf(MainApplication.mContext.getFilesDir().toString()) + "/" + BUDDY_IMAGE_FOLDER + "/";
        } else {
            IMAGE_FOLDER_PATH = "/data/data/com.coolots.chaton/files/images/";
        }
        IMAGE_MYPROFILE_PATH = String.valueOf(IMAGE_FOLDER_PATH) + BUDDY_IMAGE_PROFILE + "/";
        IMAGE_BUDDY_PATH = String.valueOf(IMAGE_FOLDER_PATH) + "buddy/";
        IMAGE_GROUP_PATH = String.valueOf(IMAGE_FOLDER_PATH) + BUDDY_IMAGE_GROUP + "/";
    }

    public static Bitmap getLocalBitmap(String path) {
        Bitmap retBitmap = null;
        boolean isNeedRetry = false;
        try {
            FileInputStream in = new FileInputStream(path);
            retBitmap = BitmapFactory.decodeStream(new BufferedInputStream(in));
            in.close();
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e2) {
            return null;
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
            System.gc();
            isNeedRetry = true;
        }
        if (isNeedRetry) {
            try {
                FileInputStream in2 = new FileInputStream(path);
                retBitmap = BitmapFactory.decodeStream(new BufferedInputStream(in2));
                in2.close();
            } catch (FileNotFoundException e4) {
                return null;
            } catch (IOException e5) {
                return null;
            } catch (OutOfMemoryError e6) {
                e6.printStackTrace();
                return null;
            }
        }
        if (retBitmap == null) {
            Log.m2958e("BUDDY_TRACE getLocalBitmap Decoded Bitmap is null");
        }
        return retBitmap;
    }

    public static String getBuddyProfileImageUrlByUserNoInServer(long userNo) {
        String regionURL = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getRegionImageURLByUserNo(userNo);
        return IMAGE_SVR_URL_PROTOCOL + regionURL + SVR_URL_PROFILE + SVR_URL_FULL + getSubDirectoryPath(userNo) + THUMBNAIL_EXTENSION_PNG;
    }

    public static String getBuddyThumbnailImageUrlByUserNoInServer(long userNo) {
        String regionURL = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getRegionImageURLByUserNo(userNo);
        return IMAGE_SVR_URL_PROTOCOL + regionURL + SVR_URL_PROFILE + SVR_URL_THUMBNAIL + getSubDirectoryPath(userNo) + THUMBNAIL_EXTENSION_PNG;
    }

    public static String getMyProfileImageUrlInServer() {
        long myUserNo = ConfigActivity.getUserNo();
        String region = ConfigActivity.getProfileNationalCode();
        String regionURL = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getRegionImageURLByRegion(Long.valueOf(region).longValue());
        return IMAGE_SVR_URL_PROTOCOL + regionURL + SVR_URL_PROFILE + SVR_URL_FULL + getSubDirectoryPath(myUserNo) + THUMBNAIL_EXTENSION_PNG;
    }

    public static String getMyProfileImageUrlByInfoInServer(String region, long userNo) {
        String regionURL = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getRegionImageURLByRegion(Long.valueOf(region).longValue());
        return IMAGE_SVR_URL_PROTOCOL + regionURL + SVR_URL_PROFILE + SVR_URL_FULL + getSubDirectoryPath(userNo) + THUMBNAIL_EXTENSION_PNG;
    }

    public static String getMyThumbnailImageUrlInServer() {
        long myUserNo = ConfigActivity.getUserNo();
        String region = ConfigActivity.getProfileNationalCode();
        String regionURL = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getRegionImageURLByRegion(Long.valueOf(region).longValue());
        return IMAGE_SVR_URL_PROTOCOL + regionURL + SVR_URL_PROFILE + SVR_URL_THUMBNAIL + getSubDirectoryPath(myUserNo) + THUMBNAIL_EXTENSION_PNG;
    }

    public static String getGroupProfileImageUrlInServer(long userCode, long groupCode) {
        String region = ConfigActivity.getProfileNationalCode();
        String regionURL = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getRegionImageURLByRegion(Long.valueOf(region).longValue());
        return IMAGE_SVR_URL_PROTOCOL + regionURL + SVR_URL_GROUP + SVR_URL_FULL + getSubDirectoryPathForGroup(userCode, groupCode) + THUMBNAIL_EXTENSION_PNG;
    }

    public static String getGroupThumbnailImageUrlInServer(long userCode, long groupCode) {
        String region = ConfigActivity.getProfileNationalCode();
        String regionURL = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getRegionImageURLByRegion(Long.valueOf(region).longValue());
        return IMAGE_SVR_URL_PROTOCOL + regionURL + SVR_URL_GROUP + SVR_URL_THUMBNAIL + getSubDirectoryPathForGroup(userCode, groupCode) + THUMBNAIL_EXTENSION_PNG;
    }

    public static String getVideoCallPortraitImageUrlInServer() {
        long myUserNo = ConfigActivity.getUserNo();
        String region = ConfigActivity.getProfileNationalCode();
        String regionURL = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getRegionImageURLByRegion(Long.valueOf(region).longValue());
        return IMAGE_SVR_URL_PROTOCOL + regionURL + SVR_URL_VIDEOCALL + SVR_URL_FULL + getSubDirectoryPath(myUserNo) + THUMBNAIL_EXTENSION_PNG;
    }

    public static String getVideoCallLandscapeImageUrlInServer() {
        long myUserNo = ConfigActivity.getUserNo();
        String region = ConfigActivity.getProfileNationalCode();
        String regionURL = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getRegionImageURLByRegion(Long.valueOf(region).longValue());
        return IMAGE_SVR_URL_PROTOCOL + regionURL + SVR_URL_VIDEOCALL + SVR_URL_THUMBNAIL + getSubDirectoryPath(myUserNo) + THUMBNAIL_EXTENSION_PNG;
    }

    public static String getBuddyThumbnailImageUrlInLocal(long userNo) {
        return String.valueOf(IMAGE_BUDDY_PATH) + userNo + THUMBNAIL_EXTENSION_PNG;
    }

    public static String getMyProfileImageUrlInLocal() {
        return String.valueOf(IMAGE_MYPROFILE_PATH) + MY_PROFILE_IMAGE + THUMBNAIL_EXTENSION_PNG;
    }

    public static String getMyThumbnailImageUrlInLocal() {
        return String.valueOf(IMAGE_MYPROFILE_PATH) + MY_THUMBNAIL_IMAGE + THUMBNAIL_EXTENSION_PNG;
    }

    public static String getGroupThumbnailImageUrlInLocal(long groupCode) {
        return String.valueOf(IMAGE_GROUP_PATH) + groupCode + THUMBNAIL_EXTENSION_PNG;
    }

    public static String getVideoCallPortraitImageUrlInLocal() {
        return String.valueOf(IMAGE_MYPROFILE_PATH) + VIDEOCALL_PORTRAIT_IMAGE + THUMBNAIL_EXTENSION_PNG;
    }

    public static String getVideoCallLandscapeImageUrlInLocal() {
        return String.valueOf(IMAGE_MYPROFILE_PATH) + VIDEOCALL_LANDSCAPE_IMAGE + THUMBNAIL_EXTENSION_PNG;
    }

    public static Bitmap makeThumbnailImage(Bitmap sourceBitmap) {
        return Bitmap.createScaledBitmap(sourceBitmap, 100, 100, false);
    }

    public static boolean saveBuddyThumbnailImageToLocal(long userNo, ByteArrayBuffer thumbBuffer) {
        return saveImage(getBuddyThumbnailImageUrlInLocal(userNo), thumbBuffer);
    }

    public static boolean saveMyThumbnailImageToLocal(ByteArrayBuffer thumbBuffer) {
        return saveImage(getMyThumbnailImageUrlInLocal(), thumbBuffer);
    }

    public static boolean saveMyProfileImageToLocal(ByteArrayBuffer profileBuffer) {
        return saveImage(getMyProfileImageUrlInLocal(), profileBuffer);
    }

    public static boolean saveGroupThumbnailImageToLocal(long groupCode, ByteArrayBuffer thumbBuffer) {
        return saveImage(getGroupThumbnailImageUrlInLocal(groupCode), thumbBuffer);
    }

    public static boolean saveVideoCallPortraitImageToLocal(ByteArrayBuffer thumbBuffer) {
        saveImage(ChatONHideMeImgData.PORT_IMAGE_PATH, thumbBuffer);
        return saveImage(getVideoCallPortraitImageUrlInLocal(), thumbBuffer);
    }

    public static boolean saveVideoCallLandscapeImageToLocal(ByteArrayBuffer thumbBuffer) {
        saveImage(ChatONHideMeImgData.LAND_IMAGE_PATH, thumbBuffer);
        return saveImage(getVideoCallLandscapeImageUrlInLocal(), thumbBuffer);
    }

    public static Bitmap getDownloadImageBitmap(ByteArrayBuffer source) {
        if (!saveImage(String.valueOf(IMAGE_MYPROFILE_PATH) + TEMP_FILE + THUMBNAIL_EXTENSION_PNG, source)) {
            return null;
        }
        Bitmap retBitmap = getLocalBitmap(String.valueOf(IMAGE_MYPROFILE_PATH) + TEMP_FILE + THUMBNAIL_EXTENSION_PNG);
        File file = new File(String.valueOf(IMAGE_MYPROFILE_PATH) + TEMP_FILE + THUMBNAIL_EXTENSION_PNG);
        file.delete();
        Log.m2958e("BUDDY_TRACE Download Transform Done!!!!!!!!!!");
        return retBitmap;
    }

    public static boolean saveImage(String path, ByteArrayBuffer buffer) throws Throwable {
        File fileCacheItem = new File(path);
        OutputStream out = null;
        if (!mkDIR() || buffer == null) {
            return false;
        }
        try {
            try {
                if (fileCacheItem.exists()) {
                    fileCacheItem.delete();
                }
                fileCacheItem.createNewFile();
                OutputStream out2 = new FileOutputStream(fileCacheItem);
                try {
                    out2.write(buffer.toByteArray());
                    out2.flush();
                    out2.close();
                    if (out2 != null) {
                        try {
                            out2.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                            return false;
                        }
                    }
                    removeBitmapCache(path);
                    Log.m2958e("BUDDY_TRACE IMAGE Saved!!!");
                    return true;
                } catch (Exception e2) {
                    e = e2;
                    out = out2;
                    e.printStackTrace();
                    if (out == null) {
                        return false;
                    }
                    try {
                        out.close();
                        return false;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    out = out2;
                    if (out != null) {
                        try {
                            out.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            return false;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    private static void removeBitmapCache(String Url) {
        BitmapCache.getInstance().remove(Url);
    }

    public static String getRegionPrefixString(long region) {
        if ("1".equals(String.valueOf(region))) {
            return PREFIX_REGION_DE;
        }
        if ("2".equals(String.valueOf(region))) {
            return "kr";
        }
        if ("3".equals(String.valueOf(region))) {
            return PREFIX_REGION_US;
        }
        if (SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(String.valueOf(region))) {
            return PREFIX_REGION_SG;
        }
        return "kr";
    }

    public static void deleteVideoCallPortraitImage() {
        String path = getVideoCallPortraitImageUrlInLocal();
        File deletePortraitFile = new File(path);
        deletePortraitFile.delete();
        removeBitmapCache(path);
    }

    public static void deleteVideoCallLandscapeImage() {
        String path = getVideoCallLandscapeImageUrlInLocal();
        File deleteLandscapeFile = new File(path);
        deleteLandscapeFile.delete();
        removeBitmapCache(path);
    }

    public static void deleteBuddyThumbnailImage(long userNo) {
        String path = getBuddyThumbnailImageUrlInLocal(userNo);
        File deleteFile = new File(path);
        deleteFile.delete();
        removeBitmapCache(path);
    }

    public static void deleteGroupThumbnailImage(long groupNo) {
        String path = getGroupThumbnailImageUrlInLocal(groupNo);
        File deleteFile = new File(path);
        deleteFile.delete();
        removeBitmapCache(path);
    }

    public static void deleteMyImageInLocal() {
        String profilePath = getMyProfileImageUrlInLocal();
        File deleteProFile = new File(profilePath);
        deleteProFile.delete();
        removeBitmapCache(profilePath);
        String thumbnailPath = getMyThumbnailImageUrlInLocal();
        File deleteThumbnail = new File(thumbnailPath);
        deleteThumbnail.delete();
        removeBitmapCache(thumbnailPath);
    }

    public static ByteArrayBuffer downloadProfileImageFromServer(String imageURLString) {
        ByteArrayBuffer baf = new ByteArrayBuffer(50);
        try {
            if (!mkDIR()) {
                return null;
            }
            URL imageURL = new URL(imageURLString);
            URLConnection conn = imageURL.openConnection();
            conn.connect();
            int nSize = conn.getContentLength();
            InputStream is = null;
            try {
                is = conn.getInputStream();
            } catch (FileNotFoundException e) {
            }
            BufferedInputStream bis = new BufferedInputStream(is, nSize);
            while (true) {
                try {
                    int current = bis.read();
                    if (current != -1) {
                        baf.append((byte) current);
                    } else {
                        bis.close();
                        return baf;
                    }
                } catch (MalformedURLException e2) {
                    e = e2;
                    e.printStackTrace();
                    return null;
                } catch (IOException e3) {
                    return null;
                } catch (Exception e4) {
                    return null;
                }
            }
        } catch (MalformedURLException e5) {
            e = e5;
        } catch (IOException e6) {
        } catch (Exception e7) {
        }
    }

    public static boolean mkDIR() {
        File fileImage = new File(IMAGE_FOLDER_PATH);
        if (!fileImage.exists() && !fileImage.mkdirs()) {
            return false;
        }
        FileUtil.makeNoMediaFile(IMAGE_FOLDER_PATH);
        File fileBuddy = new File(IMAGE_BUDDY_PATH);
        if (!fileBuddy.exists() && !fileBuddy.mkdirs()) {
            return false;
        }
        FileUtil.makeNoMediaFile(IMAGE_BUDDY_PATH);
        File fileGroup = new File(IMAGE_GROUP_PATH);
        if (!fileGroup.exists() && !fileGroup.mkdirs()) {
            return false;
        }
        FileUtil.makeNoMediaFile(IMAGE_GROUP_PATH);
        File fileProfile = new File(IMAGE_MYPROFILE_PATH);
        if (!fileProfile.exists() && !fileProfile.mkdirs()) {
            return false;
        }
        FileUtil.makeNoMediaFile(IMAGE_MYPROFILE_PATH);
        return true;
    }

    public static void updateBuddyThumbnail(long userNo) {
        BuddyImageViewThread.addImageReq(userNo, getBuddyThumbnailImageUrlByUserNoInServer(userNo), 9, null);
    }

    public static void updateGroupThumbnail(long groupCode) {
        BuddyImageViewThread.addImageReq(groupCode, getGroupThumbnailImageUrlInServer(ConfigActivity.getUserNo(), groupCode), 10, null);
    }

    public static void updateMyProfile() {
        BuddyImageViewThread.addImageReq(ConfigActivity.getUserNo(), getMyProfileImageUrlInServer(), 8, null);
    }

    public static void updateVideoCallPortrait() {
        BuddyImageViewThread.addImageReq(ConfigActivity.getUserNo(), getVideoCallPortraitImageUrlInServer(), 11, null);
    }

    public static void updateVideoCallLandscape() {
        BuddyImageViewThread.addImageReq(ConfigActivity.getUserNo(), getVideoCallLandscapeImageUrlInServer(), 12, null);
    }

    public static String getSubDirectoryPath(long code) {
        return String.valueOf(code / 1000000) + "/" + ((code % 1000000) / 1000) + "/" + code;
    }

    public static String getSubDirectoryPathForGroup(long userCode, long groupCode) {
        return String.valueOf(userCode / 1000000) + "/" + ((userCode % 1000000) / 1000) + "/" + userCode + "_" + groupCode;
    }

    @Override // com.sds.coolots.common.coolotsinterface.FilePathInfoInterface
    public String getGroupImagePath() {
        return IMAGE_GROUP_PATH;
    }

    @Override // com.sds.coolots.common.coolotsinterface.FilePathInfoInterface
    public String getBuddyImagePath() {
        return IMAGE_BUDDY_PATH;
    }

    @Override // com.sds.coolots.common.coolotsinterface.FilePathInfoInterface
    public String getMyProfileImagePath() {
        return IMAGE_MYPROFILE_PATH;
    }

    @Override // com.sds.coolots.common.coolotsinterface.FilePathInfoInterface
    public String getImageFolderPath() {
        return IMAGE_FOLDER_PATH;
    }
}
