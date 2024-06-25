package cusat.ddukk.mphoneauth

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cusat.ddukk.mphoneauth.adapter.WorkoutAdapter
import cusat.ddukk.mphoneauth.model.SampleData

class WorkoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_workout)

        var wkRecycler = findViewById<RecyclerView>(R.id.recyclerview_workout)
        wkRecycler.layoutManager = LinearLayoutManager(applicationContext)

        val data = SampleData.WkActivityDemo
        val adapter = WorkoutAdapter(data)
        wkRecycler.adapter = adapter
    }
}