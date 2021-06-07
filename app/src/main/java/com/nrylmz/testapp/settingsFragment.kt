package com.nrylmz.testapp

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_settings.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [settingsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class settingsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var constList = ArrayList<Settings>()
    var adapter: SettingsAdapter?=null

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated (view: View, savedInstanceState: Bundle?) {

        constList.add(Settings("Account",R.drawable.account))
        constList.add(Settings("Address",R.drawable.location))
        constList.add(Settings("Order Tracking",R.drawable.ordertracking))
        constList.add(Settings("My Coupons",R.drawable.gift))
        constList.add(Settings("Exit",R.drawable.exit))
        adapter=SettingsAdapter(this.requireContext(), constList)
        listViewSettings.adapter = adapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment settingsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            settingsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    class SettingsAdapter: BaseAdapter {
        var constList = ArrayList<Settings>()
        var context: Context?=null

        constructor(context: Context, constList:ArrayList<Settings>):super()
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
            //var posSettings = constList[position]
            //var inflator = context!!.getSystemService(AppCompatActivity.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            //var settingsCard = inflator.inflate(R.layout.settings_card,null)
            //settingsCard.CategoryName.text = posSettings.constSettingsType
            //settingsCard.cardIcon.setImageResource(posSettings.constSettingsTypeIcon!!)
            //return settingsCard

            var view: View = View.inflate(context, R.layout.settings_card,null)

            var icons: ImageView = view.findViewById(R.id.imageSettingsType)
            var names: TextView = view.findViewById(R.id.SettingsType)

            var settings:Settings=constList.get(position)
            icons.setImageResource(settings.constSettingsTypeIcon!!)
            names.text=settings.constSettingsType

            return view
        }

    }
}