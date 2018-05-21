package ventegocreative.co.nz.sot.notifications

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceIdService
import com.google.firebase.iid.FirebaseInstanceId

class FBInstanceIDService:FirebaseInstanceIdService() {

    override fun onTokenRefresh() {

        val refreshedToken = FirebaseInstanceId.getInstance().token
        Log.d("FBInstanceIDService", "Refreshed token: " + refreshedToken!!)

    }

}