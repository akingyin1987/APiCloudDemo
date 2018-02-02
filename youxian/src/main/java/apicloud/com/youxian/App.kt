package apicloud.com.youxian

import android.app.Application
import apicloud.com.youxian.component.AppComponent
import apicloud.com.youxian.component.DaggerAppComponent
import apicloud.com.youxian.moudle.AppModule
import apicloud.com.youxian.utils.SharedPreferencesUtil
import android.content.Context
import android.os.Handler
import android.os.Looper

/**
 * Created by MaQi on 2018/2/1.
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        SharedPreferencesUtil.init(this, packageName + "_preference", Context.MODE_PRIVATE)
    }

    companion object {
        lateinit var instance: App
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    val mainHandler: Handler by lazy {
        Handler(Looper.getMainLooper())
    }
}
