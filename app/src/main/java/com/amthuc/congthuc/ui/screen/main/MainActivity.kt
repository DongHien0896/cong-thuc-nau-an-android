package com.amthuc.congthuc.ui.screen.main

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.amthuc.congthuc.R
import com.amthuc.congthuc.data.model.Category
import com.amthuc.congthuc.databinding.ActivityMainBinding
import com.amthuc.congthuc.ui.base.BaseActivity
import com.amthuc.congthuc.ui.screen.recipe.RecipeFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    private lateinit var drawerLayout: DrawerLayout

    override val viewModel: MainViewModel by viewModel()

    override val layoutId: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val adapter = CategoryDrawerAdapter(::openCategoryDetail)

        setSupportActionBar(toolbar)
        setupDrawer(toolbar, drawerLayout)
        setupActionBar()
        setupRecyclerCategoryDrawer(adapter)

        viewModel.categories.observe(this, Observer {
            adapter.submitList(it)
        })
        viewModel.fillDb()
    }

    private fun setupActionBar() {
        val host: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
                ?: return
        val navController = host.navController
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    private fun setupDrawer(toolbar: Toolbar, drawerLayout: DrawerLayout) {
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.nav_app_bar_open_drawer_description,
            R.string.nav_app_bar_navigate_up_description
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun setupRecyclerCategoryDrawer(adapter: CategoryDrawerAdapter) {
        recycler_category_drawer.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
            this.adapter = adapter
        }
    }

    private fun openCategoryDetail(category: Category) {
        findNavController(R.id.nav_host_fragment).navigate(
            R.id.recipe_dest,
            bundleOf(
                RecipeFragment.ARGUMENT_CATEGORY to category,
                RecipeFragment.ARGUMENT_TITLE to category.title
            )
        )
        drawerLayout.closeDrawers()
    }
}