package com.goldze.work.ui.viewmodel;

import android.app.Application;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.goldze.work.R;
import com.goldze.work.BR;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * Created by goldze on 2018/6/21.
 */

public class WorkViewModel extends BaseViewModel {
    public WorkViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        for (int i = 0; i < 10; i++) {
            observableList.add(new WorkItemViewModel(this, "条目" + i));
        }
    }
    //给RecyclerView添加ObservableList
    public ObservableList<WorkItemViewModel> observableList = new ObservableArrayList<>();
    //给RecyclerView添加ItemBinding
    public interface OnItemClickListener {
        void onItemClick(String item);
    }
    OnItemClickListener listener = new OnItemClickListener() {
        @Override
        public void onItemClick(String item) {
            Toast.makeText(getApplication(),item,Toast.LENGTH_SHORT).show();
        }
    };
    public ItemBinding<WorkItemViewModel> itemBinding = ItemBinding.<WorkItemViewModel>of(BR.viewModel, R.layout.grid_work)
            .bindExtra(BR.listener, listener);


}
