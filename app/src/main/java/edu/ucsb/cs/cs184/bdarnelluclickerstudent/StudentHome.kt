package edu.ucsb.cs.cs184.bdarnelluclickerstudent

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_student_home.*

class StudentHome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_home)

        backButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        getActiveQuestionButton.setOnClickListener {
            val intent = Intent(this, MultipleChoice::class.java)
            startActivity(intent)
        }
    }

}