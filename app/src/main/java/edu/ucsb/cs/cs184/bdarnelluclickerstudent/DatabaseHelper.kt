package edu.ucsb.cs.cs184.bdarnelluclickerstudent

package edu.ucsb.cs.cs184.bdarnell.uclickerstudent.ui.login

import android.content.Context
import android.util.Log

import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.gson.Gson

import java.io.Serializable

/**
 * Created by Donghao Ren on 03/11/2017.
 * Modified by Ehsan Sayyad on 11/9/2018
 * Modified by Jake Guida on 11/6/2019
 */

/**
 * This is a Firebase helper starter class we have created for you
 * In your Activity, FirebaseHelper.Initialize() is called to setup the Firebase
 * Put your application logic in OnDatabaseInitialized where you'll have the database object initialized
 */
val FIREBASE_URL = "https://uclicker-1121a.firebaseio.com/"
val API_KEY = "AIzaSyBEqMXOi5m0N178WNLf9oGkJLEvoFxeJmg "
val APP_ID = "UClicker"

object DatabaseHelper {

    /** Keep track of initialized state, so we don't initialize multiple times  */
    private var initialized = false

    /** The Firebase database object  */
    private lateinit var db: FirebaseDatabase
    private lateinit var db_ref: DatabaseReference
    private var gson: Gson = Gson()

    /** This is a message data structure that mirrors our Firebase data structure for your convenience  */
    /*class Post(
        var longitude: Double = 0.0,
        var latitude: Double = 0.0,
        var title: Double = 0.0,
        var timestamp: Double = 0.0
    ) : Serializable*/

    /** Initialize the firebase instance  */
    fun initialize(context: Context) {
        if (!initialized) {
            initialized = true
            FirebaseApp.initializeApp(
                context, FirebaseOptions.Builder()
                    .setDatabaseUrl(FIREBASE_URL)
                    .setApiKey(API_KEY)
                    .setApplicationId(APP_ID)
                    .build()
            )

            // Call the OnDatabaseInitialized to setup application logic
            onDatabaseInitialized()
        }
    }

    /** This is called once we initialize the firebase database object  */
    private fun onDatabaseInitialized() {
        db = FirebaseDatabase.getInstance(FIREBASE_URL)
        db_ref = db.getReference("posts")
        db_ref.addChildEventListener(object: ChildEventListener {

            override fun onChildAdded(dataSnapshot: DataSnapshot, p1: String?) {
                if (mapsHelper != null)
                    mapsHelper!!.onPostAdded(gson.fromJson(dataSnapshot.value.toString(), Post::class.java))
            }

            override fun onChildChanged(dataSnapshot: DataSnapshot, p1: String?) {
                if (mapsHelper != null)
                    mapsHelper!!.onPostChanged(gson.fromJson(dataSnapshot.value.toString(), Post::class.java))
            }

            override fun onChildRemoved(dataSnapshot: DataSnapshot) {
                if (mapsHelper != null)
                    mapsHelper!!.onPostRemoved(gson.fromJson(dataSnapshot.value.toString(), Post::class.java))
            }

            override fun onCancelled(dataSnapshot: DatabaseError) {}

            override fun onChildMoved(dataSnapshot: DataSnapshot, p1: String?) {}

        })
        // TODO: Setup your callbacks to listen for /posts.
        // Your code should handle post added, post updated, and post deleted events.
        // An image can be identified by its title, an integer between 0 and 9, which corresponds to the resource file name

    }

    fun createClass() {

    }

    fun removeClass() {

    }

    fun createSession() {

    }

    fun removeSession() {

    }

    fun startSession() {

    }

    fun endSession() {

    }

    fun createQuestion() {

    }

    fun removeQuestion() {

    }

    fun activateQuestion() {

    }

    fun deactivateQuestion() {

    }

    fun addToClass() {

    }

    fun getActiveQuestion() {

    }

    fun sendResponse() {

    }

}
