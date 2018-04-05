

# greendaoDemo
跟据官方demo写的案例


# 一、实现配制步骤
  ### 1.1、找表根目录中文件build.gradle位置如下
  ![image.png](https://upload-images.jianshu.io/upload_images/2391256-e71ef30ff8ae3388.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 1.2、分别添加如下代码
```
// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath 'org.greenrobot:greendao-gradle-plugin:3.0.0'
    }
}

allprojects {
    repositories {
        mavenCentral()
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}

```
如图案例所示：
![image.png](https://upload-images.jianshu.io/upload_images/2391256-7a775f3b638dfda0.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

###1.3、在需要的模块的build.gradle中添加如下代码
```
apply plugin: 'org.greenrobot.greendao'

greendao {
    schemaVersion 1
    daoPackage 'com.joychen.daomodel.dao'    //生成代码的目录
    targetGenDir 'src/main/java'    //放代码的根目录
}  

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    compile 'org.greenrobot:greendao:3.0.1'
    compile 'org.greenrobot:greendao-generator:3.0.0'
    compile 'net.zetetic:android-database-sqlcipher:3.5.2'
}

```


案例代码如下图
![image.png](https://upload-images.jianshu.io/upload_images/2391256-fda3295aeaa1da69.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

###1.4项目入口代码点Application中添加如下代码
```
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

```

二、开始写代码
###2.1新建实体类
User：
![image.png](https://upload-images.jianshu.io/upload_images/2391256-43f3b895e00df1ed.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
点击编译后，然后会在项目的配制文件中生成如下代码：

![image.png](https://upload-images.jianshu.io/upload_images/2391256-b448c6c61e2751b6.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


图中1和2是生成的两个工具类。所有的实体都通用
3：UserDao是跟据User类生成的。


#三、调用增删改查：
代码比较多，请自行下载Demo查看。
[请下载此Demo]()

# 四、案例步骤坑点

项目集成greenDao3.0用以操作本地数据库，在根据官方demo集成之后报错：

java.lang.NoClassDefFoundError: org.greenrobot.greendao.database.DatabaseOpenHelper$EncryptedHelper

解决方式： 引入加密依赖库，不知道明明新版本已经集成了为什么会提示NoClassDef
```
compile ‘net.zetetic:android-database-sqlcipher:3.5.2’

```




