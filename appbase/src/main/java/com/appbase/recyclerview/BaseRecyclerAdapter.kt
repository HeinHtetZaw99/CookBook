package com.appbase.recyclerview


import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import java.util.*


abstract class BaseRecyclerAdapter<itemType, viewType : BaseViewHolder<itemType>>() :
    RecyclerView.Adapter<viewType>() {

    protected var mData: MutableList<itemType>? = null


    val items: List<itemType>
        get() = if (mData == null) ArrayList() else mData!!

    init {
        mData = ArrayList()

    }


    override fun onBindViewHolder(holder: viewType, position: Int) {
        if (mData!!.isNotEmpty())
            holder.setData(mData!![position])
    }

    override fun getItemCount(): Int {

        return mData!!.size
    }

    fun getItemAt(position: Int): itemType? {
        return if (position < mData!!.size - 1) mData!![position] else null

    }

    fun addNewData(newItem: itemType, position: Int) {
        if (mData != null) {
            mData!!.add(position, newItem)
            notifyDataSetChanged()
        }
    }

    fun update(newDataList: List<itemType>) {
        val diffResult = mData?.let { DiffUtils(it, newDataList) }?.let {
            DiffUtil.calculateDiff(
                it
            )
        }
        diffResult!!.dispatchUpdatesTo(this)
    }

    fun appendNewData(newData: List<itemType>) {
        clearData()
        if (mData!!.isEmpty())
            mData!!.addAll(newData)
        else
            update(newData)
        notifyDataSetChanged()
    }

    fun removeData(data: itemType) {
        mData!!.remove(data)
        notifyDataSetChanged()
    }

    fun addNewData(data: itemType) {
        mData!!.add(data)
        notifyDataSetChanged()
    }

    fun addNewDataList(dataList: List<itemType>) {
        mData!!.addAll(dataList)
        notifyDataSetChanged()
    }

    fun clearData() {
        mData = ArrayList()
        notifyDataSetChanged()
    }

}
