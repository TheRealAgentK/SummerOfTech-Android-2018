package ventegocreative.co.nz.sot

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

class MainActivity : AppCompatActivity() {

    @BindView(R.id.helloWorld)
    lateinit var helloWorld: TextView

    @OnClick(R.id.clickMe)
    fun clickedClickMe() {
        Log.d("MainActivity", "onClick: clickMe")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButterKnife.bind(this)
        helloWorld.text = "Hello via Butterknife"

  }
}
