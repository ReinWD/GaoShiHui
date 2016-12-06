package com.example.gaoshihui;


import android.content.Context;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

/**
 * Created by 张巍 on 2016/11/24.
 */

public class AccountManager {

    File mAccount, mPassword;
    public int userCounts = 1;
    private final String ACCOUNT = "Account.txt";
    private final String PASSWORD = "Password.txt";
    public HashMap<String, String> mAccountNum = new HashMap<>();

    AccountManager() {
    }

    public void readAccountList(Context context) {
        String b = context.getFilesDir().getPath() + "libs/";
        mAccount = new File(b, ACCOUNT);
        try {
            FileReader fileReader = new FileReader(mAccount);
            BufferedReader reader = new BufferedReader(fileReader);
            String cache;int j = 0;
            Boolean done = false;

            do {
                cache = reader.readLine();
                if (cache == null) done = true;
                else {mAccountNum.put(cache,Integer.valueOf(j).toString());
                j++;}
            } while (!done);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void signIn(String account, String password) throws IOException {
        if (accountExist()) {
            mAccountNum.put(account, String.valueOf(userCounts));
            fileSaver(account, password);
            userCounts++;
        } else {
        }
    }


    public boolean logIn(String account, String password, Context context) throws NullPointerException, NotExistException, IOException {
        String path = context.getFilesDir().getPath() + "/libs/";
        mAccount = new File(path, ACCOUNT);


        if (accountExist())
            throw new NotExistException();
        int num = Integer.valueOf(mAccountNum.get(account));
        InputStreamReader a = new InputStreamReader(new FileInputStream(mPassword));
        BufferedReader b = new BufferedReader(a);
        for (int i = 0; i < num ; i++) {
            b.readLine();
        }
        return b.readLine().equals(password);
    }

    public void fileSaver(String account, String password) {

        OutputStreamWriter HarukiMurakami;
        try {
            HarukiMurakami = new FileWriter(mAccount);
            HarukiMurakami.write(account + "\n");
            HarukiMurakami.close();

            HarukiMurakami = new FileWriter(mPassword);
            HarukiMurakami.write(password + "\n");
            HarukiMurakami.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createFile(Context context) throws IOException {
        String b = context.getFilesDir().getPath() + "/libs/";
        new File(b).mkdirs();
        mAccount = new File(b, ACCOUNT);
        mAccount.createNewFile();
        mPassword = new File(b, PASSWORD);
        mPassword.createNewFile();
    }
    public boolean accountExist(){
        return  false;
    }

    public class NotExistException extends Exception {
    }

}

