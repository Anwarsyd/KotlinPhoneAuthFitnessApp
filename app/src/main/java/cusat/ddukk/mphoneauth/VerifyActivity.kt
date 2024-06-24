package cusat.ddukk.mphoneauth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider

class VerifyActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify)

        firebaseAuth = FirebaseAuth.getInstance()

        // Retrieve verification ID passed from MainActivity
        val storedVerificationId = intent.getStringExtra("Stored_code")

        val verifyButton = findViewById<Button>(R.id.bt_verify)

        val otpFields = listOf<EditText>(
            findViewById(R.id.et_otp_1),
            findViewById(R.id.et_otp_2),
            findViewById(R.id.et_otp_3),
            findViewById(R.id.et_otp_4),
            findViewById(R.id.et_otp_5),
            findViewById(R.id.et_otp_6)
        )

        verifyButton.setOnClickListener {
            // Extract OTP from EditText fields
            val otp = otpFields.joinToString(separator = "") { it.text.toString().trim() }

            // Validate OTP input
            if (otp.length == 6) {
                // Create PhoneAuthCredential object
                val credential = PhoneAuthProvider.getCredential(storedVerificationId!!, otp)
                // Perform signIn operation
                signInWithPhoneAuthCredential(credential)
            } else {
                // Show error message if OTP is invalid
                Toast.makeText(this, "Enter valid OTP", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Function to sign in with PhoneAuthCredential
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = firebaseAuth.currentUser
                    Toast.makeText(this, "Sign in successful", Toast.LENGTH_SHORT).show()
                    // Proceed to HomeActivity or any other desired activity
                    val intent = Intent(applicationContext, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Sign in failed, display a message to the user.
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        Toast.makeText(this, "Invalid OTP, please try again", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Authentication failed, please try again", Toast.LENGTH_SHORT).show()
                    }
                }
            }
    }
}
