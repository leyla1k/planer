package com.example.todolist.ui.alertDialogs

import android.R
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.todolist.database.ProjectsRepository
import com.example.todolist.entities.Project
import com.example.todolist.ui.activities.MainActivity
import com.example.todolist.ui.fragments.ProjectsFragment
import java.util.Date

const val TAG = "onCreateDialog"

class NewProjectDialogFragment : DialogFragment() {

    lateinit var projectsRepository: ProjectsRepository
    val viewModel: NewProjectDialogViewModel by viewModels {
        NewProjectDialogViewModelFactory(
            projectsRepository
        )
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Create new project!")

            val customLayout: View =
                layoutInflater.inflate(com.example.todolist.R.layout.alert_dialog_new_project, null)
            builder.setView(customLayout)
            val editText =
                customLayout.findViewById<EditText>(com.example.todolist.R.id.editTexttemp)

            builder.setPositiveButton("Save new project") { dialog, id ->
                dialog.cancel()

                if (editText.text.isEmpty()) {
                    Toast.makeText(context, "Fill in neccesary input field", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    viewModel.addNewProject(Project( "sdfgs",
                        editText.text.toString(),
                    null,
                    false))
                }


            }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")

    }
}