package com.example.todolist.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.ProjectsViewModel
import com.example.todolist.ProjectsViewModelFactory
import com.example.todolist.database.ProjectsRepository
import com.example.todolist.databinding.FragmentProjectsBinding
import com.example.todolist.entities.Project
import com.example.todolist.projectRV.ProjectsItemTouchHelperCallback
import com.example.todolist.projectRV.ProjectsRVAdapter
import com.example.todolist.projectRV.VerticalSpaceItemDecoration


class ProjectsFragment : Fragment() {

    companion object {
        fun newInstance() = ProjectsFragment()
    }

    lateinit var projectsRepository: ProjectsRepository
    val viewModel: ProjectsViewModel by viewModels { ProjectsViewModelFactory(projectsRepository) }


    private var _binding: FragmentProjectsBinding? = null
    private val binding get() = _binding!!

    private val projectAdapter = ProjectsRVAdapter()

    val callback: ItemTouchHelper.Callback = ProjectsItemTouchHelperCallback(projectAdapter)
    val touchHelper = ItemTouchHelper(callback)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProjectsBinding.inflate(inflater, container, false)
        val listTemp = mutableListOf<Project>(
            Project(
                "first",
                "name",
                null,
                false
            )
        )
        projectAdapter.submit(listTemp)



        projectAdapter.onProjectClickListener = {
            findNavController().navigate(
               ProjectsFragmentDirections.actionProjectsFragmentToTaskListFragment(
                   it.id
               )
            )
        }

        with(binding.rvProjects) {
            touchHelper.attachToRecyclerView(this)
            adapter = projectAdapter
            layoutManager = LinearLayoutManager(requireContext())
                .apply {
                    addItemDecoration(
                        VerticalSpaceItemDecoration(50)
                    )
                }

        }




        return binding.root


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //  viewModel = ViewModelProvider(this).get(ProjectsViewModel::class.java)
        // TODO: Use the ViewModel
    }


}