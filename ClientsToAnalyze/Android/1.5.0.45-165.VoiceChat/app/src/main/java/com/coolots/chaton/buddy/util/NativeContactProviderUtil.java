package com.coolots.chaton.buddy.util;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.provider.ContactsContract;
import com.coolots.chaton.buddy.model.NativeContactSyncData;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.view.ConfigActivity;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.DatabaseHelper;
import com.sds.coolots.common.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class NativeContactProviderUtil {
    public static String ACCOUNT_TYPE = MainApplication.mContext.getPackageName();
    private static final String MIME_TYPE = "vnd.vapp.item/vnd.com.app.account";
    private static Bitmap bitmap;

    public static boolean doContactSync() {
        new Thread(new Runnable() { // from class: com.coolots.chaton.buddy.util.NativeContactProviderUtil.1
            @Override // java.lang.Runnable
            public void run() throws RemoteException, OperationApplicationException {
                Log.m2958e("BUDDY_TRACE NativeContactProviderUtil doContactSync AccountType : " + NativeContactProviderUtil.ACCOUNT_TYPE);
                String[] RawContacts_PROJECTION = {DatabaseHelper.KEY_ROWID, "sync1"};
                Cursor cursor = MainApplication.mContext.getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, RawContacts_PROJECTION, "account_type = '" + NativeContactProviderUtil.ACCOUNT_TYPE + "' AND deleted = 0", null, null);
                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        int ID = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.KEY_ROWID));
                        String nativeSA = cursor.getString(cursor.getColumnIndex("sync1"));
                        if (ID != -100 && ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().isNeedDeleteContactSync(nativeSA)) {
                            NativeContactProviderUtil.deleteContactByRawContactsID(ID);
                            Log.m2958e("BUDDY_TRACE find id : " + ID);
                        }
                    } while (cursor.moveToNext());
                    cursor.close();
                } else if (cursor != null) {
                    cursor.close();
                }
                ArrayList<NativeContactSyncData> contactSyncList = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getPBListFromNativeForContactSync();
                ArrayList<NativeContactSyncData> contactSyncInsertList = new ArrayList<>();
                String[] PROJECTION = {DatabaseHelper.KEY_ROWID};
                if (contactSyncList != null && !contactSyncList.isEmpty()) {
                    Iterator<NativeContactSyncData> it = contactSyncList.iterator();
                    while (it.hasNext()) {
                        NativeContactSyncData syncData = it.next();
                        Cursor nativeCursor = MainApplication.mContext.getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, PROJECTION, "account_type = '" + NativeContactProviderUtil.ACCOUNT_TYPE + "' AND sync1 = '" + syncData.getSamsungAccount() + "' AND deleted = 0", null, null);
                        if (nativeCursor != null && nativeCursor.moveToFirst()) {
                            nativeCursor.close();
                        } else {
                            if (nativeCursor != null) {
                                nativeCursor.close();
                            }
                            contactSyncInsertList.add(syncData);
                        }
                    }
                    if (contactSyncInsertList == null || contactSyncInsertList.isEmpty()) {
                        return;
                    }
                    NativeContactProviderUtil.insertContact(contactSyncInsertList);
                }
            }
        }).start();
        return true;
    }

    private static boolean updateContact(ArrayList<NativeContactSyncData> contactSyncList) {
        Iterator<NativeContactSyncData> it = contactSyncList.iterator();
        while (it.hasNext()) {
            NativeContactSyncData sd = it.next();
            insertPhoto(sd.getRawContactID(), sd.getUserNo());
        }
        return true;
    }

    protected static boolean insertPhoto(long rawContactId, long userNo) {
        String imagePath = BuddyImageUtil.getBuddyThumbnailImageUrlInLocal(userNo);
        if (isThumbnailExistInLocal(imagePath)) {
            bitmap = BuddyImageUtil.getLocalBitmap(imagePath);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 75, stream);
            ContentValues values = new ContentValues();
            values.put("raw_contact_id", Long.valueOf(rawContactId));
            values.put("mimetype", "vnd.android.cursor.item/photo");
            values.put("data15", stream.toByteArray());
            MainApplication.mContext.getContentResolver().insert(ContactsContract.Data.CONTENT_URI, values);
            return true;
        }
        return true;
    }

    public static boolean isThumbnailExistInLocal(String filePath) {
        if (filePath == null || "".equals(filePath)) {
            return false;
        }
        File file = new File(filePath);
        boolean bFileExist = file.exists();
        return bFileExist;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean insertContact(ArrayList<NativeContactSyncData> contactSyncList) throws RemoteException, OperationApplicationException {
        Log.m2958e("BUDDY_TRACE NativeContactProviderUtil insertContact");
        ArrayList<ContentProviderOperation> ops = new ArrayList<>();
        String mySamsungAccount = ConfigActivity.getSamsungAccountID();
        if (contactSyncList != null && mySamsungAccount != null && !contactSyncList.isEmpty() && !mySamsungAccount.isEmpty()) {
            Iterator<NativeContactSyncData> it = contactSyncList.iterator();
            while (it.hasNext()) {
                NativeContactSyncData sd = it.next();
                int rawContactInsertIndex = ops.size();
                String buddySamsungAccount = sd.getSamsungAccount();
                String nativeName = sd.getNativeName();
                if (buddySamsungAccount != null && nativeName != null) {
                    ops.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI).withValue("account_type", ACCOUNT_TYPE).withValue("account_name", mySamsungAccount).withValue("sync1", buddySamsungAccount).build());
                    ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", rawContactInsertIndex).withValue("mimetype", "vnd.android.cursor.item/name").withValue("data1", nativeName).build());
                    ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", rawContactInsertIndex).withValue("mimetype", MIME_TYPE).withValue("data1", buddySamsungAccount).build());
                    String imagePath = BuddyImageUtil.getBuddyThumbnailImageUrlInLocal(sd.getUserNo());
                    if (isThumbnailExistInLocal(imagePath)) {
                        bitmap = BuddyImageUtil.getLocalBitmap(imagePath);
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 75, stream);
                        ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", rawContactInsertIndex).withValue("mimetype", "vnd.android.cursor.item/photo").withValue("data15", stream.toByteArray()).build());
                    }
                }
            }
            if (ops.size() > 0) {
                try {
                    MainApplication.mContext.getContentResolver().applyBatch("com.android.contacts", ops);
                } catch (OperationApplicationException e) {
                    e.printStackTrace();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return true;
    }

    public static boolean deleteContactByRawContactsID(int rawContactID) {
        Log.m2958e("BUDDY_TRACE NativeContactProviderUtil deleteContactByRawContactsID");
        Log.m2958e("BUDDY_TRACE NativeContactProviderUtil where rawContacts_id : " + rawContactID);
        MainApplication.mContext.getContentResolver().delete(ContactsContract.RawContacts.CONTENT_URI, "_id=?", new String[]{String.valueOf(rawContactID)});
        return true;
    }

    public static boolean deleteContactBySA(String SA) {
        Log.m2958e("BUDDY_TRACE NativeContactProviderUtil deleteContactBySA");
        if (SA == null || SA.isEmpty()) {
            String[] RawContacts_PROJECTION = {DatabaseHelper.KEY_ROWID};
            ArrayList<Long> IDList = new ArrayList<>();
            Cursor cursor = MainApplication.mContext.getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, RawContacts_PROJECTION, "account_type = '" + ACCOUNT_TYPE + "' AND sync1 = '" + SA + "'", null, null);
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    long ID = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.KEY_ROWID));
                    if (ID != -100) {
                        IDList.add(Long.valueOf(ID));
                        Log.m2958e("BUDDY_TRACE find id : " + ID);
                    }
                } while (cursor.moveToNext());
                cursor.close();
                if (IDList != null && !IDList.isEmpty()) {
                    Iterator<Long> it = IDList.iterator();
                    while (it.hasNext()) {
                        long _ID = it.next().longValue();
                        Log.m2958e("BUDDY_TRACE delete from raw_contacts where id : " + _ID);
                        MainApplication.mContext.getContentResolver().delete(ContactsContract.RawContacts.CONTENT_URI, "_id=?", new String[]{String.valueOf(_ID)});
                    }
                }
            } else if (cursor != null) {
                cursor.close();
            }
        }
        return true;
    }

    public static boolean deleteContactAll() throws RemoteException, OperationApplicationException {
        Log.m2958e("BUDDY_TRACE NativeContactProviderUtil deleteContactAll");
        ArrayList<ContentProviderOperation> ops = new ArrayList<>();
        ContentProviderOperation.Builder builder = ContentProviderOperation.newDelete(ContactsContract.RawContacts.CONTENT_URI);
        builder.withYieldAllowed(true);
        builder.withSelection("account_type=?", new String[]{ACCOUNT_TYPE});
        ops.add(builder.build());
        if (ops.size() > 0) {
            try {
                MainApplication.mContext.getContentResolver().applyBatch("com.android.contacts", ops);
            } catch (OperationApplicationException e) {
                e.printStackTrace();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        return true;
    }
}
