package com.example.todolist.ui.activities

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.example.todolist.R

import com.example.todolist.databinding.ActivityMainBinding

import com.example.todolist.ui.alertDialogs.NewProjectDialogFragment


class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home->Toast.makeText(this, "ghbdtn", Toast.LENGTH_SHORT).show()
                R.id.menu_new->{




                   val newProjectialogFragment = NewProjectDialogFragment()
                    val manager = supportFragmentManager
                    val transaction: FragmentTransaction = manager.beginTransaction()
                    newProjectialogFragment.show(transaction, "dialog")

                }
                R.id.menu_profile->Toast.makeText(this, "ghbdtn", Toast.LENGTH_SHORT).show()

            }
            true
        }





    }



    private fun sendDialogDataToActivity(data: String) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show()
    }
}
