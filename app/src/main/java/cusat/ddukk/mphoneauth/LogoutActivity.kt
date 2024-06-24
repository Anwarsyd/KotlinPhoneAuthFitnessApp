package cusat.ddukk.mphoneauth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class LogoutActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_logout)

        firebaseAuth = FirebaseAuth.getInstance()

        val currentUser = firebaseAuth.currentUser

        val logoutButton = findViewById<Button>(R.id.logout_btn)

        if (currentUser == null){
            var i = Intent(applicationContext, MainActivity::class.java)
            startActivity(i)
            finish()
        }

        logoutButton.setOnClickListener {
            firebaseAuth.signOut()
            var i = Intent(applicationContext, MainActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}