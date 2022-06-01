package id.alpha.code.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.stockbit.model.CryptoModel
import id.alpha.code.main.R
import id.alpha.code.main.databinding.ItemCryptoLayoutBinding

class CryptoListAdapter :
    PagingDataAdapter<CryptoModel, CryptoListAdapter.ViewHolder>(CryptoListDiffUtil()) {

    class CryptoListDiffUtil : DiffUtil.ItemCallback<CryptoModel>() {
        override fun areItemsTheSame(
            oldItem: CryptoModel,
            newItem: CryptoModel
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: CryptoModel,
            newItem: CryptoModel
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class ViewHolder(private val binding: ItemCryptoLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CryptoModel?) {
            val resource = binding.root.context.resources
            binding.tvName.text = item?.name
            binding.tvPrice.text = item?.price?.toString()
            binding.tvFullName.text = item?.fullName
            binding.tvChanges.text = String.format(
                resource.getString(R.string.price_changes_format),
                item?.lastDayChange,
                item?.lastDayPercentChange
            )
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCryptoLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding)
    }
}