package ventegocreative.co.nz.sot.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import ventegocreative.co.nz.sot.data.DataManager
import ventegocreative.co.nz.sot.data.models.Film

class MainViewModel : ViewModel() {
	
	val filmsList: LiveData<List<Film>> = DataManager.getFilms()
	
}