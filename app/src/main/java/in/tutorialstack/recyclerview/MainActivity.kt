package `in`.tutorialstack.recyclerview

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    internal var TAG = MainActivity::class.java.simpleName

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            context = this;
            recyclerView = findViewById<RecyclerView>(R.id.recycler_view) as RecyclerView
            recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

            val models = ArrayList<DataModel>()
            models.add(DataModel("Item Title 1", "01 Jan, 2018"))
            models.add(DataModel("Item Title 2", "02 Jan, 2018"))
            models.add(DataModel("Item Title 3", "03 Jan, 2018"))
            models.add(DataModel("Item Title 4", "04 Jan, 2018"))
            models.add(DataModel("Item Title 5", "05 Jan, 2018"))
            models.add(DataModel("Item Title 6", "06 Jan, 2018"))
            models.add(DataModel("Item Title 7", "07 Jan, 2018"))
            models.add(DataModel("Item Title 8", "08 Jan, 2018"))
            models.add(DataModel("Item Title 9", "09 Jan, 2018"))
            models.add(DataModel("Item Title 10", "10 Jan, 2018"))
            models.add(DataModel("Item Title 11", "11 Jan, 2018"))
            models.add(DataModel("Item Title 12", "12 Jan, 2018"))
            models.add(DataModel("Item Title 13", "13 Jan, 2018"))
            models.add(DataModel("Item Title 14", "14 Jan, 2018"))
            models.add(DataModel("Item Title 15", "15 Jan, 2018"))

            adapter = ItemAdapter(context, models)
            recyclerView.adapter = adapter
            recyclerView.addOnItemClickListener(object : OnItemClickListener {
                override fun onItemClicked(position: Int, view: View) {
                    Toast.makeText(context, "clicked on " + models.get(position).title, Toast.LENGTH_SHORT).show()
                }
            })

        } catch (e: Exception) {
            Log.e(TAG, e.message)
        }
    }

    interface OnItemClickListener {
        fun onItemClicked(position: Int, view: View)
    }

    fun RecyclerView.addOnItemClickListener(onClickListener: OnItemClickListener) {
        this.addOnChildAttachStateChangeListener(object : RecyclerView.OnChildAttachStateChangeListener {
            override fun onChildViewDetachedFromWindow(view: View?) {
                view?.setOnClickListener(null)
            }

            override fun onChildViewAttachedToWindow(view: View?) {
                view?.setOnClickListener({
                    val holder = getChildViewHolder(view)
                    onClickListener.onItemClicked(holder.adapterPosition, view)
                })
            }
        })
    }
}