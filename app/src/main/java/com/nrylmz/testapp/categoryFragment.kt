package com.nrylmz.testapp

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.category_card.view.*
import kotlinx.android.synthetic.main.fragment_category.*
import kotlinx.android.synthetic.main.fragment_category.listView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [categoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class categoryFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var constList = ArrayList<Category>()
    var adapter: CategoryAdapter?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated (view: View, savedInstanceState: Bundle?) {

        constList.add(Category("Category1","Description1",R.drawable.done))
        constList.add(Category("Category2","Description2",R.drawable.done))
        constList.add(Category("Category3","Description3",R.drawable.done))
        constList.add(Category("Category4","Description4",R.drawable.done))
        constList.add(Category("Category5","Description5",R.drawable.done))
        constList.add(Category("Category6","Description6",R.drawable.done))
        constList.add(Category("Category7","Description7",R.drawable.done))
        adapter= CategoryAdapter(this.requireContext(), constList)
        listView.adapter = adapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment categoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            categoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    class CategoryAdapter: BaseAdapter {
        var constList = ArrayList<Category>()
        var context: Context?=null

        constructor(context: Context, constList:ArrayList<Category>):super()
        {
            this.constList=constList
            this.context=context
        }

        override fun getCount(): Int {
            return constList.size
        }

        override fun getItem(position: Int): Any {
            return constList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        @SuppressLint("ViewHolder")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var posCategory = constList[position]
            var inflator = context!!.getSystemService(AppCompatActivity.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var categoryCard = inflator.inflate(R.layout.category_card,null)
            categoryCard.CategoryName.text = posCategory.constCategoryName
            categoryCard.Description.text = posCategory.constDescription
            categoryCard.cardIcon.setImageResource(posCategory.constCategoryIcon!!)
            return categoryCard
        }

    }

}