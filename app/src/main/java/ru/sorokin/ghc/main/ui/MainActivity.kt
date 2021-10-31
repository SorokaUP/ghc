package ru.sorokin.ghc.main.ui

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.sorokin.ghc.AndroidScreens
import ru.sorokin.ghc.App
import ru.sorokin.ghc.R
import ru.sorokin.ghc.databinding.ActivityMainBinding
import ru.sorokin.ghc.model.IBackButtonListener
import ru.sorokin.ghc.model.IMainView

class MainActivity : MvpAppCompatActivity(), IMainView {
    private lateinit var binding: ActivityMainBinding
    private val navigator = AppNavigator(this, R.id.container)
    private val presenter by moxyPresenter { MainPresenter(App.instance.router, AndroidScreens()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        supportFragmentManager.fragments.forEach {
            if (it is IBackButtonListener && it.backPressed()) {
                return
            }
        }
        presenter.backClicked()
    }
}