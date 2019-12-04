package edu.ucsb.cs.cs184.bdarnelluclickerstudent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import android.content.Intent



class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        studentActivityButton.setOnClickListener {
            val intent = Intent(this, StudentHome::class.java)
            startActivity(intent)
        }

        instructorActivityButton.setOnClickListener {
            val intent = Intent(this, InstructorHome::class.java)
            startActivity(intent)
        }

    }
}
