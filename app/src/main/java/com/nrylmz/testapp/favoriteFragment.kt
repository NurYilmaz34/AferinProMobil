package com.nrylmz.testapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_favorite.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [favoriteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class favoriteFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var gridview: GridView?=null
    private var arrayList:ArrayList<Product> ?= null
    private var productAdapter:ProductAdapter ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment favoriteFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            favoriteFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated (view: View, savedInstanceState: Bundle?){

        gridview = getActivity()?.findViewById(R.id.mygrid)
        arrayList = ArrayList()
        arrayList = setDataList()
        productAdapter = ProductAdapter(this.requireContext(), arrayList!!)
        gridview?.adapter=productAdapter
    }

    private fun setDataList():ArrayList<Product>{
        var arrayList:ArrayList<Product> =ArrayList()
        arrayList.add(Product(R.drawable.star_border,"product1"))
        arrayList.add(Product(R.drawable.star_border,"product2"))
        arrayList.add(Product(R.drawable.star_border,"product3"))
        arrayList.add(Product(R.drawable.star_border,"product4"))
        arrayList.add(Product(R.drawable.star_border,"product5"))
        arrayList.add(Product(R.drawable.star_border,"product6"))
        arrayList.add(Product(R.drawable.star_border,"product7"))
        arrayList.add(Product(R.drawable.star_border,"product8"))
        arrayList.add(Product(R.drawable.star_border,"product9"))
        arrayList.add(Product(R.drawable.star_border,"product10"))
        arrayList.add(Product(R.drawable.star_border,"product11"))
        arrayList.add(Product(R.drawable.star_border,"product12"))
        arrayList.add(Product(R.drawable.star_border,"product13"))

        return arrayList
    }

}