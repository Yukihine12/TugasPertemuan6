package lat.pam.arsitektur

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import lat.pam.arsitektur.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Menggunakan ViewModel
    private val scoreViewModel: ScoreViewModel by viewModels()

    // Binding untuk mengakses UI dari XML
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Mengatur binding untuk activity_main.xml
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengamati perubahan skor tim A dan B, dan memperbarui UI
        scoreViewModel.scoreA.observe(this, Observer { scoreA ->
            binding.scoreA.text = "Team A: $scoreA"
        })

        scoreViewModel.scoreB.observe(this, Observer { scoreB ->
            binding.scoreB.text = "Team B: $scoreB"
        })

        // Tambahkan 1 poin untuk Team A
        binding.btnAddTeamA.setOnClickListener {
            scoreViewModel.incrementScore(true)
        }

        // Tambahkan 1 poin untuk Team B
        binding.btnAddTeamB.setOnClickListener {
            scoreViewModel.incrementScore(false)
        }
    }
}
