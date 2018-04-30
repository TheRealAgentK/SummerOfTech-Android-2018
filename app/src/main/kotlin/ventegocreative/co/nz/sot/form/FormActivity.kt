package ventegocreative.co.nz.sot.form

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import ventegocreative.co.nz.sot.R
import ventegocreative.co.nz.sot.databinding.ActivityFormBinding

class FormActivity : AppCompatActivity() {
	
	lateinit var binding: ActivityFormBinding
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, R.layout.activity_form)
		
		supportActionBar?.setDisplayHomeAsUpEnabled(true)
		
	}
	
	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		if (item.itemId == android.R.id.home) {
			onBackPressed()
			return true
		}
		
		return super.onOptionsItemSelected(item)
	}
	
	companion object {
		
		fun getIntent(context: Context): Intent = Intent(context, FormActivity::class.java)
		
	}
}
