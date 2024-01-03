package com.reshproject.learningjourney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.reshproject.learningjourney.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val list = ArrayList<Lesson>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Mendefinisikan variable binding lalu setContentView diubah menjadi binding.root
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list.addAll(getListIconic())
        showRecyclerList()

    }
    private fun getListIconic(): ArrayList<Lesson> {
        val dataName = resources.getStringArray(R.array.title_name)
        val listLesson = ArrayList<Lesson>()
        for (i in dataName.indices) {
            val icon = Lesson(dataName[i])
            listLesson.add(icon)
        }
        return listLesson
    }

    private fun showRecyclerList() {
        binding.rvCourse.layoutManager = LinearLayoutManager(this)
        val ListLessonAdapter = ListLessonAdapter(list)
        binding.rvCourse.adapter = ListLessonAdapter
        ListLessonAdapter.setOnItemClickCallback(object : ListLessonAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Lesson) {
//                val intentToDetail = Intent(this@MainActivity, IconDetail::class.java)
//                intentToDetail.putExtra("DATA", data)
//                startActivity(intentToDetail)
            }
        })
    }
}