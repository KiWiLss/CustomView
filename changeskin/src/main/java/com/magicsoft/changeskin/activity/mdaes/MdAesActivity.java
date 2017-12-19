package com.magicsoft.changeskin.activity.mdaes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.gcssloop.encrypt.encode.Base64Util;
import com.gcssloop.encrypt.symmetric.AESUtil;
import com.gcssloop.encrypt.symmetric.DESUtil;
import com.gcssloop.encrypt.unsymmetric.RSAUtil;
import com.magicsoft.changeskin.R;
import com.magicsoft.changeskin.utils.Utils;

import java.security.SecureRandom;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: MdAesActivity.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/18 16:14
 * @Changes (from 2017/12/18)
 * -----------------------------------------------------------------
 * 2017/12/18 : Create MdAesActivity.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class MdAesActivity extends AppCompatActivity {

    public static final String TAG = "MMM";
    private EditText mEt;
    private TextView mTvAdd;
    private TextView mTvDecrpty;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mdaes);
        initView();
        try {
            SecretKey secretKey = generateKey("123456");
            SecretKey secretKey2 = generateKey("123456");
            Log.e("MMM", "onCreate: "+secretKey.toString() +"||"+ secretKey2.toString()+"||"+(secretKey==secretKey2));
        } catch (Exception e) {
            e.printStackTrace();
        }


        String keyByPass = Utils.getKeyByPass();
        String keyByPass2 = Utils.getKeyByPass();

        Log.e(TAG, "onCreate: "+keyByPass+"|"+keyByPass2+"|"+(keyByPass==keyByPass2) );

    }



    private void initView() {
        mEt = (EditText) findViewById(R.id.et);
        mTvAdd = (TextView) findViewById(R.id.tv_add);
        mTvDecrpty = (TextView) findViewById(R.id.tv_decrpty);
    }

    public void base64(View view) {
        String content = judge();
        if (content==null){
            return;
        }

        String encode = Base64Util.base64EncodeStr(content);
        mTvAdd.setText(encode);
    }

    private String judge() {
        String content = mEt.getText().toString();
        if (TextUtils.isEmpty(content)){
            return null;
        }
        return content;
    }

    public void base64decode(View view) {
        String content = mTvAdd.getText().toString();
        String decode = Base64Util.base64DecodedStr(content);
        mTvDecrpty.setText(decode);

    }

    String mAesKey="1234567890123456";//至少16位
    public void aes(View view) {
        String content = judge();
        if (content==null){
            return;
        }
        //加密
        String aes = AESUtil.aes(content, mAesKey, Cipher.ENCRYPT_MODE);
        mTvAdd.setText(aes);
        //解密
        String aes1 = AESUtil.aes(aes, mAesKey, Cipher.DECRYPT_MODE);
        mTvDecrpty.setText(aes1);
    }

    public void aes2(View view) {
        String content = judge();
        if (content==null){
            return;
        }
        //加密
        String des = DESUtil.des(content, mAesKey, Cipher.ENCRYPT_MODE);
        mTvAdd.setText(des);
        //解密
        String des1 = DESUtil.des(des, mAesKey, Cipher.DECRYPT_MODE);
        mTvDecrpty.setText(des1);

    }

    /**AES加密密钥生成
     * @param seed
     * @return
     * @throws Exception
     */
    private SecretKey generateKey(String seed) throws Exception {
        // 获取秘钥生成器
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        // 通过种子初始化
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.setSeed(seed.getBytes("UTF-8"));
        keyGenerator.init(128, secureRandom);
        // 生成秘钥并返回
        return keyGenerator.generateKey();
    }

    /**非对称加密
     * @param view
     */
    public void rsa(View view) throws Exception {
        String content = judge();
        if (content==null){
            return;
        }

        //加密
        // 密钥与数字签名获取
        Map<String, Object> keyMap = RSAUtil.getKeyPair();
        String publicKey = RSAUtil.getKey(keyMap, true);
        Log.e(TAG, "rsa获取公钥： " + publicKey);
        String privateKey = RSAUtil.getKey(keyMap, false);
        Log.e(TAG, "rsa获取私钥： " + privateKey);
// 公钥加密私钥解密
        byte[] rsaPublic =
                RSAUtil.rsa(content.getBytes(), publicKey, RSAUtil.RSA_PUBLIC_ENCRYPT);
        Log.e(TAG, "rsa公钥加密： " + new String(rsaPublic));
        Log.e(TAG, "rsa私钥解密： " + new String(
                RSAUtil.rsa(rsaPublic, privateKey, RSAUtil.RSA_PRIVATE_DECRYPT)));

    }
}
