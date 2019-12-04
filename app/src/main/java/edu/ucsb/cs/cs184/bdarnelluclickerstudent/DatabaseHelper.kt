package edu.ucsb.cs.cs184.bdarnelluclickerstudent

import android.content.Context
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignInAccount

import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.gson.Gson

import java.io.Serializable
import java.util.*

/*
* Created by Donghao Ren on 03/11/2017.
* Modified by Ehsan Sayyad on 11/9/2018
* Modified by Jake Guida on 11/6/2019
*/

/*
* This is a Firebase helper starter class we have created for you
* In your Activity, FirebaseHelper.Initialize() is called to setup the Firebase
* Put your application logic in OnDatabaseInitialized where you'll have the database object initialized
*/
val FIREBASE_URL = "https://uclicker-1121a.firebaseio.com/"
val API_KEY = "AIzaSyBMtCNVCaa4cen85MNXLeWeWceNbTWcrkg\n "
val APP_ID = "UClicker"



object DatabaseHelper {
    /* Keep track of initialized state, so we don't initialize multiple times  */
    private var initialized = false
    private lateinit var email:String
    /* The Firebase database object  */
    private lateinit var db: FirebaseDatabase
    private lateinit var db_ref: DatabaseReference
    private var gson: Gson = Gson()

    / This is a message data structure that mirrors our Firebase data structure for your convenience  */
    /*class Post(
        var longitude: Double = 0.0,
        var latitude: Double = 0.0,
        var title: Double = 0.0,
        var timestamp: Double = 0.0
    ) : Serializable*/

    / Initialize the firebase instance  */
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
            db_ref = db.reference
        }
    }

    fun setEmail(_email: String) {
        email = _email
    }

    fun createUser() {
        db_ref.child(email).push()
    }

    fun createClass(classId: Int) {
        db_ref.child(email).child(classId.toString()).push()
    }

    fun removeClass(classId: Int) {
        db_ref.child(email).child(classId.toString()).removeValue()
    }

    fun createSession(classId: Int) {
        var uniqueID = UUID.randomUUID().toString()
        db_ref.child(email).child(classId.toString()).child(uniqueID)
    }

    fun removeSession(UUID: String) {
        db_ref.child(email)
    }

    fun startSession() {
        db_ref
    }

    fun endSession() {
        db_ref
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