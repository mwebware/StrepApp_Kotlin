// SymptomsViewModel.kt
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SymptomsViewModel : ViewModel() {
    private val _selectedSymptoms = MutableStateFlow<Map<String, String>>(mutableMapOf())
    val selectedSymptoms = _selectedSymptoms.asStateFlow()

    fun updateSymptom(symptom: String, value: String) {
        _selectedSymptoms.value = _selectedSymptoms.value.toMutableMap().apply {
            put(symptom, value)
        }
    }
    fun clearSymptoms() {
        _selectedSymptoms.value = mutableMapOf()
    }
}