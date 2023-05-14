package com.example.modul4praktikum

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class profil : Fragment() {

    lateinit var inputNama: String
    lateinit var inputNim: String
    lateinit var inputProdi: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inputNama = arguments?.getString("KeyNama").toString()
        inputNim = arguments?.getString("KeyNim").toString()
        inputProdi = arguments?.getString("KeyProdi").toString()

        val nama = view.findViewById<TextView>(R.id.namaTampil)
        val nim = view.findViewById<TextView>(R.id.nimTampil)
        val prodi = view.findViewById<TextView>(R.id.prodiTampil)
        val kembali = view.findViewById<Button>(R.id.back)

        nama.text = "$inputNama"
        nim.text = "$inputNim"
        prodi.text = "$inputProdi"

        kembali.setOnClickListener{
            findNavController().navigate(R.id.backAction)
        }
    }
}