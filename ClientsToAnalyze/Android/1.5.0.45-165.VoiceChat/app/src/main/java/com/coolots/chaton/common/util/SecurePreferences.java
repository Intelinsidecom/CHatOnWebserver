package com.coolots.chaton.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.util.Base64;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class SecurePreferences implements SharedPreferences {
    private static final String CLASSNAME = "[SecurePreferences]";
    private static final String LOGIN_PREF = "com.coolots.login_preferences";
    private static boolean mIsSecure = true;
    private static SharedPreferences sFile;
    private static byte[] sKey;

    private static void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public SecurePreferences(Context context) {
        if (sFile == null) {
            sFile = MainApplication.mContext.getSharedPreferences(LOGIN_PREF, 0);
        }
        if (mIsSecure) {
            try {
                String key = generateAesKeyName(context);
                String value = sFile.getString(key, null);
                if (value == null) {
                    value = generateAesKeyValue();
                    sFile.edit().putString(key, value).commit();
                }
                sKey = decode(value);
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public static void setSecure(boolean isSecure) {
        mIsSecure = isSecure;
    }

    private static String encode(byte[] input) {
        return Base64.encodeToString(input, 3);
    }

    private static byte[] decode(String input) {
        return Base64.decode(input, 3);
    }

    private static String generateAesKeyName(Context context) throws InvalidKeySpecException, NoSuchAlgorithmException {
        char[] password = context.getPackageName().toCharArray();
        byte[] salt = Settings.Secure.getString(context.getContentResolver(), "android_id").getBytes();
        KeySpec spec = new PBEKeySpec(password, salt, 1000, 256);
        return encode(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(spec).getEncoded());
    }

    private static String generateAesKeyValue() throws NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom();
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        try {
            generator.init(256, random);
        } catch (Exception e) {
            try {
                generator.init(192, random);
            } catch (Exception e2) {
                generator.init(128, random);
            }
        }
        return encode(generator.generateKey().getEncoded());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String encrypt(String cleartext) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        if (cleartext != null && cleartext.length() != 0) {
            try {
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(1, new SecretKeySpec(sKey, "AES"));
                return encode(cipher.doFinal(cleartext.getBytes("UTF-8")));
            } catch (Exception e) {
                logE("encrypt error!!" + e.getMessage());
                return null;
            }
        }
        return cleartext;
    }

    private static String decrypt(String ciphertext) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        if (ciphertext != null && ciphertext.length() != 0) {
            try {
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(2, new SecretKeySpec(sKey, "AES"));
                return new String(cipher.doFinal(decode(ciphertext)), "UTF-8");
            } catch (Exception e) {
                logE("decrypt error!!" + e.getMessage());
                return null;
            }
        }
        return ciphertext;
    }

    @Override // android.content.SharedPreferences
    public Map<String, String> getAll() {
        Map<String, ?> encryptedMap = sFile.getAll();
        Map<String, String> decryptedMap = new HashMap<>(encryptedMap.size());
        for (Map.Entry<String, ?> entry : encryptedMap.entrySet()) {
            try {
                decryptedMap.put(decrypt(entry.getKey()), decrypt(entry.getValue().toString()));
            } catch (Exception e) {
            }
        }
        return decryptedMap;
    }

    @Override // android.content.SharedPreferences
    public String getString(String key, String defaultValue) {
        if (!mIsSecure) {
            return key != null ? sFile.getString(key, null) : defaultValue;
        }
        String encryptedValue = sFile.getString(encrypt(key), null);
        return encryptedValue != null ? decrypt(encryptedValue) : defaultValue;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String key, Set<String> defaultValues) {
        if (mIsSecure) {
            Set<String> encryptedSet = sFile.getStringSet(encrypt(key), null);
            if (encryptedSet != null) {
                Set<String> decryptedSet = new HashSet<>(encryptedSet.size());
                for (String encryptedValue : encryptedSet) {
                    decryptedSet.add(decrypt(encryptedValue));
                }
                return decryptedSet;
            }
            return defaultValues;
        }
        Set<String> valueSet = sFile.getStringSet(key, null);
        return valueSet != null ? valueSet : defaultValues;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String key, int defaultValue) {
        if (mIsSecure) {
            String encryptedValue = sFile.getString(encrypt(key), null);
            if (encryptedValue != null) {
                try {
                    return Integer.parseInt(decrypt(encryptedValue));
                } catch (NumberFormatException e) {
                    throw new ClassCastException(e.getMessage());
                }
            }
            return defaultValue;
        }
        String value = sFile.getString(key, null);
        return value != null ? Integer.parseInt(value) : defaultValue;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String key, long defaultValue) {
        if (mIsSecure) {
            String encryptedValue = sFile.getString(encrypt(key), null);
            if (encryptedValue != null) {
                try {
                    return Long.parseLong(decrypt(encryptedValue));
                } catch (NumberFormatException e) {
                    throw new ClassCastException(e.getMessage());
                }
            }
            return defaultValue;
        }
        String value = sFile.getString(key, null);
        return value != null ? Long.parseLong(value) : defaultValue;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String key, float defaultValue) {
        if (mIsSecure) {
            String encryptedValue = sFile.getString(encrypt(key), null);
            if (encryptedValue != null) {
                try {
                    return Float.parseFloat(decrypt(encryptedValue));
                } catch (NumberFormatException e) {
                    throw new ClassCastException(e.getMessage());
                }
            }
            return defaultValue;
        }
        String value = sFile.getString(key, null);
        return value != null ? Float.parseFloat(value) : defaultValue;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String key, boolean defaultValue) {
        if (mIsSecure) {
            String encryptedValue = sFile.getString(encrypt(key), null);
            if (encryptedValue != null) {
                try {
                    return Boolean.parseBoolean(decrypt(encryptedValue));
                } catch (NumberFormatException e) {
                    throw new ClassCastException(e.getMessage());
                }
            }
            return defaultValue;
        }
        String value = sFile.getString(key, null);
        return value != null ? Boolean.parseBoolean(value) : defaultValue;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String key) {
        return mIsSecure ? sFile.contains(encrypt(key)) : sFile.contains(key);
    }

    @Override // android.content.SharedPreferences
    public Editor edit() {
        return new Editor(null);
    }

    public static class Editor implements SharedPreferences.Editor {
        private SharedPreferences.Editor mEditor;

        private Editor() {
            this.mEditor = SecurePreferences.sFile.edit();
        }

        /* synthetic */ Editor(Editor editor) {
            this();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String key, String value) {
            if (SecurePreferences.mIsSecure) {
                this.mEditor.putString(SecurePreferences.encrypt(key), SecurePreferences.encrypt(value));
            } else {
                this.mEditor.putString(key, value);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String key, Set<String> values) {
            Set<String> encryptedValues = new HashSet<>(values.size());
            if (SecurePreferences.mIsSecure) {
                for (String value : values) {
                    encryptedValues.add(SecurePreferences.encrypt(value));
                }
                this.mEditor.putStringSet(SecurePreferences.encrypt(key), encryptedValues);
            } else {
                for (String value2 : values) {
                    encryptedValues.add(value2);
                }
                this.mEditor.putStringSet(key, values);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String key, int value) {
            if (SecurePreferences.mIsSecure) {
                this.mEditor.putString(SecurePreferences.encrypt(key), SecurePreferences.encrypt(Integer.toString(value)));
            } else {
                this.mEditor.putString(key, Integer.toString(value));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String key, long value) {
            if (SecurePreferences.mIsSecure) {
                this.mEditor.putString(SecurePreferences.encrypt(key), SecurePreferences.encrypt(Long.toString(value)));
            } else {
                this.mEditor.putString(key, Long.toString(value));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String key, float value) {
            if (SecurePreferences.mIsSecure) {
                this.mEditor.putString(SecurePreferences.encrypt(key), SecurePreferences.encrypt(Float.toString(value)));
            } else {
                this.mEditor.putString(key, Float.toString(value));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String key, boolean value) {
            if (SecurePreferences.mIsSecure) {
                this.mEditor.putString(SecurePreferences.encrypt(key), SecurePreferences.encrypt(Boolean.toString(value)));
            } else {
                this.mEditor.putString(key, Boolean.toString(value));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String key) {
            if (SecurePreferences.mIsSecure) {
                this.mEditor.remove(SecurePreferences.encrypt(key));
            } else {
                this.mEditor.remove(key);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.mEditor.clear();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return this.mEditor.commit();
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            this.mEditor.apply();
        }
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        sFile.registerOnSharedPreferenceChangeListener(listener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        sFile.unregisterOnSharedPreferenceChangeListener(listener);
    }
}
