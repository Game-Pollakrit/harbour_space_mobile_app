package com.example.finalproject

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database

class DogCounterViewModel : ViewModel() {
    private val database = Firebase.database
    private val counterRefLike = database.getReference("dog_counter_like")
    private val counterRefDis = database.getReference("dog_counter_dis")
    private val counterRefSound = database.getReference("dog_counter_sound")

    private val _counter_like = MutableLiveData<Int>()
    private val _counter_dis = MutableLiveData<Int>()
    private val _counter_sound = MutableLiveData<Int>()

    init {
        // Attach a ValueEventListener to update the counter
        counterRefLike.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue(Int::class.java) ?: 0
                _counter_like.value = value
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle errors
            }
        })

        counterRefDis.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue(Int::class.java) ?: 0
                _counter_dis.value = value
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle errors
            }
        })

        counterRefSound.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue(Int::class.java) ?: 0
                _counter_sound.value = value
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle errors
            }
        })
    }

    // Function to increment the counter in the database
    fun incrementCounterLike() {
        _counter_like.value = _counter_like.value?.plus(1)
        counterRefLike.setValue(_counter_like.value)
    }
    fun incrementCounterDis() {
        _counter_dis.value = _counter_dis.value?.plus(1)
        counterRefDis.setValue(_counter_dis.value)
    }
    fun incrementCounterSound() {
        _counter_sound.value = _counter_sound.value?.plus(1)
        counterRefSound.setValue(_counter_sound.value)
    }
}

class CatCounterViewModel : ViewModel() {
    private val database = Firebase.database
    private val counterRefLike = database.getReference("cat_counter_like")
    private val counterRefDis = database.getReference("cat_counter_dis")
    private val counterRefSound = database.getReference("cat_counter_sound")

    private val _counter_like = MutableLiveData<Int>()
    private val _counter_dis = MutableLiveData<Int>()
    private val _counter_sound = MutableLiveData<Int>()

    init {
        // Attach a ValueEventListener to update the counter
        counterRefLike.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue(Int::class.java) ?: 0
                _counter_like.value = value
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle errors
            }
        })

        counterRefDis.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue(Int::class.java) ?: 0
                _counter_dis.value = value
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle errors
            }
        })

        counterRefSound.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue(Int::class.java) ?: 0
                _counter_sound.value = value
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle errors
            }
        })

        counterRefSound.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue(Int::class.java) ?: 0
                _counter_sound.value = value
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle errors
            }
        })
    }

    // Function to increment the counter in the database
    fun incrementCounterLike() {
        _counter_like.value = _counter_like.value?.plus(1)
        counterRefLike.setValue(_counter_like.value)
    }
    fun incrementCounterDis() {
        _counter_dis.value = _counter_dis.value?.plus(1)
        counterRefDis.setValue(_counter_dis.value)
    }
    fun incrementCounterSound() {
        _counter_sound.value = _counter_sound.value?.plus(1)
        counterRefSound.setValue(_counter_sound.value)
    }

}