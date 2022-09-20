package dev.waceramercythird.workoutLog.ui

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import dev.waceramercythird.workoutLog.R
import dev.waceramercythird.workoutLog.viewmodel.ExerciseViewModel

class HomeActivity : AppCompatActivity() {
    lateinit var bnvHome: BottomNavigationView
    lateinit var fcvHome: FragmentContainerView
    var exerciseViewModel: ExerciseViewModel by viewModels()

    lateinit var sharedPrefs: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        castViews()
        setupBottomNav()
        triggerFetchExerciseCategories()
    }

    fun triggerFetchExerciseCategories(){
        sharePrefs = getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)
        var accessToken = sharedPrefs.getString("ACCESS_TOKEN", "")

        exerciseViewModel.fetchExerciseCategories(accessToken!!)
    }
    fun onResume(){
        super.onResume()
        exerciseViewModel.exerciseCategoryLiveData.observe(this, observe{ catogory ->
            Toast.makeText(this, "fetched ${categoryResponse.size} categories")
        })

        exerciseViewModel.errorLiveData.observe(this, observe { erroMsg ->
            Toast.makeText(this, erroMsg, Toast.LENGTH_LONG).show()

        })
    }

    fun castViews(){
        bnvHome = findViewById(R.id.bottomNavigationView)
        fcvHome = findViewById(R.id.fcvHome)
    }
    fun setupBottomNav(){
        bnvHome.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.page_1 ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, PlanFragment()).commit()
                    true
                }
                R.id.page_2 ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, TrackFragment()).commit()
                    true

                }
                R.id.page_3 ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, ProfileFragment()).commit()
                    true
                }
                else-> false
            }

        }

    }
}