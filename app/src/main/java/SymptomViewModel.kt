import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SymptomViewModel : ViewModel() {
    private val _selectedSymptoms = MutableStateFlow<Map<String, String>>(emptyMap())
    val selectedSymptoms: StateFlow<Map<String, String>> = _selectedSymptoms

    fun updateSymptom(symptom: String, status: String) {
        _selectedSymptoms.value = _selectedSymptoms.value.toMutableMap().apply {
            this[symptom] = status
        }
    }
}
