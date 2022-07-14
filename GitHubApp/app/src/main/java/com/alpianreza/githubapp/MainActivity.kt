package com.alpianreza.githubapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.alpianreza.githubapp.adapter.ListUserAdapter
import com.alpianreza.githubapp.databinding.ActivityMainBinding
import com.alpianreza.githubapp.model.Users

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<Users>()

    companion object {
        const val TAG = "Main Activity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "GitHubApp"

        binding.rvUser.setHasFixedSize(true)

        list.addAll(listUsers)
        showRecycleList(binding)
    }

    private val  listUsers: ArrayList<Users>
    get() {
        val dataUsername = resources.getStringArray(R.array.username)
        val dataName = resources.getStringArray(R.array.name)
        val dataCompany = resources.getStringArray(R.array.company)
        val dataAvatar = resources.obtainTypedArray(R.array.avatar)
        val dataFollowers = resources.getStringArray(R.array.followers)
        val dataFollowing = resources.getStringArray(R.array.following)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataRepository = resources.getStringArray(R.array.repository)

        val listProfile = ArrayList<Users>()

        for (i in dataName.indices){
            val profile = Users(
                username = dataUsername[i],
                name = dataName[i],
                company = dataCompany[i],
                avatar = dataAvatar.getResourceId(i, -1),
                follower = dataFollowers[i],
                following = dataFollowing[i],
                location = dataLocation[i],
                repository = dataRepository[i],
            )
            listProfile.add(profile)
        }
        dataAvatar.recycle()

        return listProfile
    }

    private fun showRecycleList(binding: ActivityMainBinding) {
        binding.rvUser.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        binding.rvUser.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallBack(object : ListUserAdapter.OnItemClickCallBack {
            override fun onItemClicked(data: Users) = openDetail(data)
        })
    }

    fun openDetail(data: Users) {
        Log.d(TAG, data.toString())

        val moveToDetailIntent = Intent(this@MainActivity, DetailActivity::class.java)
        moveToDetailIntent.putExtra(DetailActivity.EXTRA_USERS, data)
        startActivity(moveToDetailIntent)
    }
}