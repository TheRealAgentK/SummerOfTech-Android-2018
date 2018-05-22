package ventegocreative.co.nz.sot

import android.app.Application
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric
import ventegocreative.co.nz.sot.data.DataManager

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val fabric = Fabric.Builder(this)
                .kits(Crashlytics())
                .debuggable(true)
                .build()
        Fabric.with(fabric)
    
        DataManager.init(applicationContext)
    
    }
}
