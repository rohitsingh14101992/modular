package demo.m.base

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import com.bumptech.glide.Glide
import io.reactivex.Observable

fun <T> ObservableField<out T?>.toObservable(fireInitialValue: Boolean = true): Observable<T> =
    Observable.create { source ->
        if (fireInitialValue) get()?.let(source::onNext)
        val callback = object : androidx.databinding.Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: androidx.databinding.Observable?, propertyId: Int) {
                get()?.let(source::onNext)
            }
        }
        addOnPropertyChangedCallback(callback)
        source.setCancellable { removeOnPropertyChangedCallback(callback) }
    }

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String?) {
    Glide.with(imageView.context).load(url).into(imageView)
}