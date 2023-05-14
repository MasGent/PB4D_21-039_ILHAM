package com.example.modul4praktikum

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [home.newInstance] factory method to
 * create an instance of this fragment.
 */
class home : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnSend: Button = view.findViewById(R.id.btnKirim)
        btnSend.setOnClickListener{
            val inputNama = view.findViewById<EditText>(R.id.namaEdit).text.toString()
            val inputNim = view.findViewById<EditText>(R.id.nimEdit).text.toString()
            val inputProdi = view.findViewById<EditText>(R.id.prodiEdit).text.toString()

            if (inputNama.equals("") || inputProdi.equals("")||inputNim.equals("")){
                Toast.makeText(context,"Pastikan Semua Data Terisi !",Toast.LENGTH_SHORT).show()
            }else{
                val bundle = Bundle()

                bundle.putString("KeyNama",inputNama)
                bundle.putString("KeyNim",inputNim)
                bundle.putString("KeyProdi",inputProdi)

                Toast.makeText(context, "Data Tersimpan", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.sendAction,bundle)
            }
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment home.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onClick(v: View) {
    }
}