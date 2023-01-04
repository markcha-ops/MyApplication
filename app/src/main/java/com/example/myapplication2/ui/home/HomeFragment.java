package com.example.myapplication2.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.myapplication2.R;
import com.example.myapplication2.databinding.FragmentHomeBinding;
import com.example.myapplication2.requests.device.Device;
import com.example.myapplication2.requests.device.DeviceAdapter;
import com.example.myapplication2.requests.device.DeviceClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kotlinx.coroutines.ObsoleteCoroutinesApi;
import retrofit2.Call;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    @SuppressLint("ResourceType")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        ListView listView = (ListView) root.findViewById(R.id.device_list_view);

        List<Device> devices = new ArrayList<>();
        DeviceAdapter deviceArrayAdapter = new DeviceAdapter(getActivity(), R.layout.fragment_home, new ArrayList<>(devices));
        listView.setAdapter(deviceArrayAdapter);
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Call<List<Device>> deviceCallback = DeviceClient.getApiService().devices();
            deviceArrayAdapter.addAllItems(deviceCallback.execute().body());
        } catch (IOException e) {
            e.printStackTrace();
        }


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}