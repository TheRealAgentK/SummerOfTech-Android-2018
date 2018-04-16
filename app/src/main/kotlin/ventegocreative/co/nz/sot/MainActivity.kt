package ventegocreative.co.nz.sot

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        helloWorld.setText("Hello via KAE")

        // plain Kotlin:
        //
        // 1. findViewById(R.id.clickMe).setOnClickListener { view -> Log.d("MainActivity", "onClick: clickMe") }
        // or
        // 2. findViewById(R.id.clickMe).setOnClickListener({ view -> Log.d("MainActivity", "onClick: clickMe")})

        // with Kotlin Android Extensions:
        //
        clickMe.setOnClickListener { Log.d("MainActivity", "onClick: clickMe") }
    }
}
