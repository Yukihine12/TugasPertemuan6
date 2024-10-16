package lat.pam.arsitektur

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    private val _scoreA = MutableLiveData(0)
    val scoreA: LiveData<Int> = _scoreA

    private val _scoreB = MutableLiveData(0)
    val scoreB: LiveData<Int> = _scoreB

    // Tambahkan skor ke tim A atau tim B
    fun incrementScore(isTeamA: Boolean) {
        if (isTeamA) {
            _scoreA.value = (_scoreA.value ?: 0) + 1
        } else {
            _scoreB.value = (_scoreB.value ?: 0) + 1
        }
    }
}
