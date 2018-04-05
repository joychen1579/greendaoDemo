package com.joychen.daomodel.app;

import android.app.Application;

import com.joychen.daomodel.dao.DaoMaster;
import com.joychen.daomodel.dao.DaoSession;

import org.greenrobot.greendao.database.Database;

public class App extends Application {
    /**
     * 这个是用来标识数据库是否要加密
     */
    public static final boolean ENCRYPTED = true;

    private DaoSession daoSession;
    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,ENCRYPTED ? "notes-db-encrypted" : "notes-db");
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
