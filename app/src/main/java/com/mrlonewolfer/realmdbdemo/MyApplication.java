package com.mrlonewolfer.realmdbdemo;

import android.app.Application;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class MyApplication extends Application {
    public static AtomicInteger id=new AtomicInteger();

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
//        Realm realm=Realm.getDefaultInstance();
//        id=getIdByTable(realm,PersonBean.class);
//        realm.close();

    }
    private <T extends RealmObject> AtomicInteger getIdByTable(Realm realm,Class<T> anyclass){
        RealmResults<T> results=realm.where(anyclass).findAll();

        return (results.size()>0)? new AtomicInteger(results.max("id").intValue()): new AtomicInteger();
    }
}
