package com.example.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModels extends ViewModel {


    MutableLiveData<Boolean> dataState = new MutableLiveData<>(false);
}
