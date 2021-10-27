package com.example.todomanager05.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.todomanager05.R;
import com.example.todomanager05.databinding.FragmentHomeBinding;
import com.example.todomanager05.ui.create.TaskAdapter;
import com.example.todomanager05.ui.create.TaskModel;
import com.example.todomanager05.utils.App;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    TaskAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_nav_home_to_createTaskFragment);
            }
        });
        initAdapter();
    }

    private ArrayList<TaskModel> getDataFromDataBase() {
        return (ArrayList<TaskModel>) App.getInstance().getDataBase().taskDao().getAll();
    }

    private void startAnimationAndChangeThemeAndOpenMainActivity() {

    }

    private void initAdapter() {
        adapter = new TaskAdapter(getDataFromDataBase());
        binding.taskRecycler.setAdapter(adapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}