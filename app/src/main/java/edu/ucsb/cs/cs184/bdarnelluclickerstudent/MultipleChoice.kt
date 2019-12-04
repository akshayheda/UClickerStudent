package edu.ucsb.cs.cs184.bdarnelluclickerstudent

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_multiple_choice.*

class MultipleChoice : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiple_choice)

        toolbar.setNavigationOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                back()
            }
        })
    }

    fun back() {
        val intent = Intent(this, StudentHome::class.java)
        startActivity(intent)
    }

}
