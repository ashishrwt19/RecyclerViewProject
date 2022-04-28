package com.ashish.physicswallah

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ashish.physicswallah.databinding.FragmentUsersBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment() {
    private var _binding: FragmentUsersBinding? = null

    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var myAdapter: RecyclerView.Adapter<*>

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        manager = LinearLayoutManager(this.context)
        getAllData()


    }

    private fun getAllData() {

        Api.retrofitService.getUsers().enqueue(object : Callback<List<UserObject>> {
            override fun onResponse(
                call: Call<List<UserObject>>,
                response: Response<List<UserObject>>
            ) {
                binding.progressBar.hide()
                binding.recyclerView.apply {
                    myAdapter = UsersAdapter(response.body()!!)
                    layoutManager = manager
                    adapter = myAdapter
                }
            }

            override fun onFailure(call: Call<List<UserObject>>, t: Throwable) {
                t.printStackTrace()
            }

        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}