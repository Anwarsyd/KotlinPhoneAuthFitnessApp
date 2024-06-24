package cusat.ddukk.mphoneauth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        val btnStartWorkout = findViewById<Button>(R.id.btnStartWorkout)
        val btnViewProgress = findViewById<Button>(R.id.btnViewProgress)
        val btnSetGoals = findViewById<Button>(R.id.btnSetGoals)

        btnStartWorkout.setOnClickListener {
//            val intent = Intent(this, StartWorkoutActivity::class.java)
            val intent = Intent(this, WorkoutActivity::class.java)

            startActivity(intent)
        }

        btnViewProgress.setOnClickListener {
//            val intent = Intent(this, ViewProgressActivity::class.java)
            val intent = Intent(this, ProgressActivity::class.java)

            startActivity(intent)
        }

        btnSetGoals.setOnClickListener {
            // Navigate to Set Goals Activity
//            val intent = Intent(this, SetGoalsActivity::class.java)
            val intent = Intent(this, GoalsActivity::class.java)
            startActivity(intent)
        }


    }
}