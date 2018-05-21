package ventegocreative.co.nz.sot.notifications

import android.util.Log;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

class NotificationJobService: JobService() {

    private val TAG = "MyJobService"

    override fun onStartJob(jobParameters: JobParameters): Boolean {
        Log.d(TAG, "Performing long running task in scheduled job")
        // TODO: add long running task here.
        return false
    }

    override fun onStopJob(jobParameters: JobParameters): Boolean {
        return false
    }

}

