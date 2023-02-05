package com.harjot.custom_dialogues

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext
import com.harjot.custom_dialogues.databinding.ActivityMainBinding
import com.harjot.custom_dialogues.databinding.LayoutCustomDialogBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    var i=0
    lateinit var arrayAdapter : ArrayAdapter<String>
    var arrayList = arrayListOf<String>()

    override fun onCreate( savedInstanceState: Bundle?) {
        super.onCreate( savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)

        binding?.lvListView?.adapter = arrayAdapter

        binding?.fabBtn?.setOnClickListener {
            var alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle(resources.getString(R.string.add_data))
            alertDialog.setMessage(resources.getString(R.string.add_data_msg))
            alertDialog.setCancelable(false)

            alertDialog.setNeutralButton(resources.getString(R.string.three)){_,_->
                i=3
                arrayList.add((i).toString())
                //to update the list
                arrayAdapter.notifyDataSetChanged()
            }



            alertDialog.setNegativeButton(resources.getString(R.string.four)){_,_->
//                arrayList[position] = (arrayList[position].toInt()+2).toString()
//                arrayAdapter.notifyDataSetChanged()
                i=4
                arrayList.add((i).toString())
                //to update the list
                arrayAdapter.notifyDataSetChanged()
            }


            alertDialog.setPositiveButton(resources.getString(R.string.five)){_,_->
//                i=0
//                arrayList.removeAt(position)
//                arrayAdapter.notifyDataSetChanged()
                i=5
                arrayList.add((i).toString())
                //to update the list
                arrayAdapter.notifyDataSetChanged()
            }

            alertDialog.show()
//            i++
//            arrayList.add((i).toString())
//            //to update the list
//            arrayAdapter.notifyDataSetChanged()
        }

        binding.lvListView.setOnItemClickListener { _, _, position, _ ->
            var dialog = Dialog(this)
            var dialogBinding = LayoutCustomDialogBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)
            dialog.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT)
            dialogBinding.etName.setText("123")
            dialogBinding.btnAdd.setOnClickListener {
                if(dialogBinding.etName.text.toString().isNullOrEmpty()){
                    dialogBinding.etName.error = resources.getString(R.string.enter_name)
                }else
                    dialog.dismiss()
            }
            dialog.show()
            }
//            System.out.println(" in click $position")
//            //  arrayList.removeAt(position)
//            //  arrayAdapter.notifyDataSetChanged()
//            var alertDialog = AlertDialog.Builder(this)
//            alertDialog.setTitle(resources.getString(R.string.modify_data))
//            alertDialog.setMessage(resources.getString(R.string.modify_data_msg))
//            alertDialog.setCancelable(false)
//
//            alertDialog.setNeutralButton(resources.getString(R.string.cancel)){_,_->
//                alertDialog.setCancelable(true)
//            }
//            alertDialog.setPositiveButton(resources.getString(R.string.delete)){_,_->
//                i=0
//                arrayList.removeAt(position)
//                arrayAdapter.notifyDataSetChanged()
//
//            }
//            alertDialog.setNegativeButton(resources.getString(R.string.add)){_,_->
//                arrayList[position] = (arrayList[position].toInt()+2).toString()
//                arrayAdapter.notifyDataSetChanged()
//
//            }
//            alertDialog.show()

        }


    }


