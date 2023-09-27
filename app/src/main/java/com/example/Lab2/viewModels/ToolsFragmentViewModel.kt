package com.example.Lab2.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.Lab2.models.Tool
import com.example.Lab2.networks.ApiNetworkSource
import com.example.Lab2.networks.INetworkSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import androidx.lifecycle.viewModelScope
import com.example.Lab2.models.ResultOf
import kotlinx.coroutines.launch

class ToolsFragmentViewModel : ViewModel() {
    val liveData = MutableLiveData<ResultOf<List<Tool>?>>()
    private val network: INetworkSource = ApiNetworkSource()
    fun init() {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                network.getTools()
            }
            if (response.isSuccessful) {
                val responses = response.body()
                val tools = responses?.let { Tool.getTools(it) }
                val result = ResultOf.Success(tools)
                liveData.postValue(result)
            } else {
                liveData.postValue(ResultOf.Failure("internet error", "check your internet connection"))
            }
        }
    }
}