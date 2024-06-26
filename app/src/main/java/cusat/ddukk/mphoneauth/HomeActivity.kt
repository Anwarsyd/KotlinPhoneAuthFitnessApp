package cusat.ddukk.mphoneauth

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        val btnStartWorkout = findViewById<Button>(R.id.btnStartWorkout)
        val btnViewProgress = findViewById<Button>(R.id.btnViewProgress)
        val btnSetGoals = findViewById<Button>(R.id.btnSetGoals)

//        val toolbar = findViewById<Toolbar>(R.id.toolbar)
//        setSupportActionBar(toolbar)

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.Logoutid -> {
                Toast.makeText(applicationContext, "Logout Successfully ", Toast.LENGTH_SHORT).show()
                FirebaseAuth.getInstance().signOut()
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}