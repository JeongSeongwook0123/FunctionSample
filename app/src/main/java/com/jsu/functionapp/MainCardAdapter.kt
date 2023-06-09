package com.jsu.functionapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.jsu.functionapp.databinding.ListviewCardViewMainBinding
import com.jsu.functionapp.dialog_sample.DialogSample01Activity
import com.jsu.functionapp.gallery_sample.GallerySampleActivity
import com.jsu.functionapp.recycler_sample.RecyclerViewSample01Activit
import com.jsu.functionapp.util.ExtensionFunction.onThrottleClick
import com.jsu.functionapp.webview_sample.WebViewListActivity


class MainCardAdapter(
    private var context: Context,
    private var arrayCardName: ArrayList<String>,
    private var intent : Intent? = null,
    private val sizeInvoke: () -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val listBinding = ListviewCardViewMainBinding.inflate(LayoutInflater.from(context),parent,false)

        return SampleListHolder(listBinding)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is SampleListHolder -> {

                //git test
                holder.tvName.text = arrayCardName[position]

                holder.view.onThrottleClick(1500) {
                    when(arrayCardName[position].split(" ")[0]){
                        "Recycler" -> {
                            intent = Intent(context,RecyclerViewSample01Activit::class.java)
                            context.startActivity(intent)
                        }
                        "Dialog" -> {
                            intent = Intent(context,DialogSample01Activity::class.java)
                            context.startActivity(intent)
                        }
                        "Device" -> {
                            sizeInvoke.invoke()
                        }
                        "WebView" -> {
                            intent = Intent(context,WebViewListActivity::class.java)
                            context.startActivity(intent)
                        }
                        "Gallery" -> {
                            intent = Intent(context,GallerySampleActivity::class.java)
                            context.startActivity(intent)
                        }
                        "Login" -> {
//                            intent = Intent(context,LoginSampleActivity::class.java)
//                            context.startActivity(intent)
                        }
                        else -> {
                            Toast.makeText(context,"기능 개발 중 입니다.",Toast.LENGTH_SHORT).show()
                        }
                    }

                }
            }

        }

    }

    override fun getItemCount(): Int = arrayCardName.size

    override fun getItemViewType(position: Int): Int = position

    inner class SampleListHolder(itemView: ListviewCardViewMainBinding) : RecyclerView.ViewHolder(itemView.root) {

        var view = itemView.root
        var tvName = itemView.tvCardName

    }


}

