package cu.sld.hlucia_kotlin_mvvm_retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.rxbinding.view.RxView
import cu.sld.hlucia_kotlin_mvvm_retrofit.R
import kotlinx.android.synthetic.main.items.view.*

class EmpAdapter(
    var context: MainActivity,
    var mEmpList: ArrayList<Android>,
    private val itemClick: ItemClickListener
) : RecyclerView.Adapter<EmpAdapter.EmpHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): EmpHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.items, parent, false)
        return EmpHolder(view)
    }

    class EmpHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvFname = view.textView
        val tvLname = view.textView2
        val mView = view

    }

    override fun getItemCount(): Int {
        return mEmpList.size
    }

    override fun onBindViewHolder(holder: EmpHolder, position: Int) {
        mItemClickListener = itemClick
        holder.tvFname?.text = mEmpList[position].name
        holder.tvLname?.text = mEmpList[position].name
        RxView.clicks(holder.mView).subscribe {
            mItemClickListener!!.onItemClick(position)
        }
    }

    companion object {
        var mItemClickListener: ItemClickListener? = null
    }
}


