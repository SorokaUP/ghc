package ru.sorokin.ghc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.sorokin.ghc.databinding.ActivityMainBinding
import ru.sorokin.ghc.room.GhUserRepo

class MainActivity : MvpAppCompatActivity(), IMainView {
    private lateinit var binding: ActivityMainBinding
    private val presenter by moxyPresenter { MainPresenter(GhUserRepo()) }
    private var adapter: UsersRVAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun init() {
        binding.rvUsers.layoutManager = LinearLayoutManager(this)
        adapter = UsersRVAdapter(presenter.userListPresenter)
        binding.rvUsers.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }
}