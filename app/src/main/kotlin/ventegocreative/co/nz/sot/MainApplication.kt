package ventegocreative.co.nz.sot

import android.app.Application
import io.fabric.sdk.android.Fabric
import com.crashlytics.android.Crashlytics

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val fabric = Fabric.Builder(this)
                .kits(Crashlytics())
                .debuggable(true)
                .build()
        Fabric.with(fabric)

    }
}
