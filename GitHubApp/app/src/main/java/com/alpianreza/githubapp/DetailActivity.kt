package com.alpianreza.githubapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.alpianreza.githubapp.databinding.ActivityDetailBinding
import com.alpianreza.githubapp.model.Users

class DetailActivity : AppCompatActivity() {
    private lateinit var users: Users

    companion object {
        const val EXTRA_USERS = "extra_users"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Detail User"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        users = intent.getParcelableExtra<Users>(EXTRA_USERS) as Users

        binding.myAvatar.setImageResource(users.avatar)
        binding.tvName.text = users.name
        binding.tvUsername.text = users.username
        binding.tvRepositories.text = users.repository
        binding.tvFollowers.text = users.follower
        binding.tvFollowing.text = users.following
        binding.tvLocation.text = users.location
        binding.tvCompany.text = users.company
    }

    private fun shareProfile() {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, users.toString())

        val  chooseIntent = Intent.createChooser(shareIntent, "Share Profile")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_share -> {
                shareProfile()
                true
            }
            else -> {
                onBackPressed()
                true
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}