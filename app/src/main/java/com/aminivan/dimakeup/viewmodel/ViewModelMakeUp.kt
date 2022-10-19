package com.aminivan.dimakeup.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aminivan.dimakeup.model.ResponseDataMakeUpItem
import com.aminivan.dimakeup.network.RestfulApi
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ViewModelMakeUp @Inject constructor(var api : RestfulApi) : ViewModel(){

    lateinit var liveDataMakeup: MutableLiveData<List<ResponseDataMakeUpItem>>


    init {
        liveDataMakeup = MutableLiveData()
    }

    fun getLiveDataMakeUp() : MutableLiveData<List<ResponseDataMakeUpItem>> {
        return  liveDataMakeup
    }

    fun calApiMakeUp(){
        api.getAllMakup()
            .enqueue(object : Callback<List<ResponseDataMakeUpItem>> {
                override fun onResponse(
                    call: Call<List<ResponseDataMakeUpItem>>,
                    response: Response<List<ResponseDataMakeUpItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataMakeup.postValue(response.body())
                    }else{
                        liveDataMakeup.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<ResponseDataMakeUpItem>>, t: Throwable) {
                    liveDataMakeup.postValue(null)
                }

            })
    }

}