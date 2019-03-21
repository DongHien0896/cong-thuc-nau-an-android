package com.amthuc.congthuc.utils

import android.content.res.ColorStateList
import android.net.Uri
import android.os.Build
import android.os.SystemClock
import android.text.Html
import android.text.TextUtils
import android.view.View
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.amthuc.congthuc.BuildConfig
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("onRefreshListener")
fun SwipeRefreshLayout.customRefreshListener(listener: SwipeRefreshLayout.OnRefreshListener?) {
    if (listener != null) setOnRefreshListener(listener)
}

@BindingAdapter("isRefreshing")
fun SwipeRefreshLayout.customRefreshing(refreshing: Boolean?) {
    isRefreshing = refreshing == true
}

@BindingAdapter("onScrollListener")
fun RecyclerView.customScrollListener(listener: RecyclerView.OnScrollListener?) {
    if (listener != null) addOnScrollListener(listener)
}

@BindingAdapter("glideUrl")
fun ImageView.setGlideUrl(url: String?) {
    Glide.with(context)
        .load(url)
        .into(this)
}

@BindingAdapter("glideUrlCrop")
fun ImageView.setImageUrlCrop(url: String?) {
    Glide.with(context)
        .load(url)
        .apply(RequestOptions.bitmapTransform(RoundedCorners(Constants.RADIUS_CATEGORY_IMAGE)))
        .into(this)
}

@BindingAdapter("glideSrc")
fun ImageView.setGlideSrc(@DrawableRes src: Int?) {
    Glide.with(context).load(src).into(this)
}

@BindingAdapter("loadUri")
fun ImageView.loadLocalImage(uri: Uri?) {
    Glide.with(context).load(uri).into(this)
}

@BindingAdapter(value = ["loadImageLocal"])
fun ImageView.loadImage(imageName: String?) {
    if (!TextUtils.isEmpty(imageName)) {
        setImageResource(resources.getIdentifier(imageName, "drawable", BuildConfig.APPLICATION_ID))
    }
}

@BindingAdapter("clickSafe")
fun View.setClickSafe(listener: View.OnClickListener?) {
    setOnClickListener(object : View.OnClickListener {
        var lastClickTime: Long = 0

        override fun onClick(v: View) {
            if (SystemClock.elapsedRealtime() - lastClickTime < Constants.THRESHOLD_CLICK_TIME) {
                return
            }
            listener?.onClick(v)
            lastClickTime = SystemClock.elapsedRealtime()
        }
    })
}

@BindingAdapter("onSingleClick")
fun View.setSingleClick(execution: () -> Unit) {
    setOnClickListener(object : View.OnClickListener {
        var lastClickTime: Long = 0

        override fun onClick(p0: View?) {
            if (SystemClock.elapsedRealtime() - lastClickTime < Constants.THRESHOLD_CLICK_TIME) {
                return
            }
            lastClickTime = SystemClock.elapsedRealtime()
            execution.invoke()
        }
    })
}

@BindingAdapter("loadUrl")
fun WebView.loadWebUrl(url: String?) {
    url?.apply {
        loadUrl(url)
    }
}

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
@BindingAdapter("backgroundTint")
fun TextView?.customBackgroundTint(color: Int?) {
    if (this == null || color == null) return
    background?.setTint(color)
}

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
@BindingAdapter("tint")
fun ImageView?.customTint(color: Int?) {
    if (this == null || color == null) return
    imageTintList = ColorStateList.valueOf(color)
}

@BindingAdapter("background")
fun View?.customBackground(color: Int?) {
    if (this == null || color == null) return
    setBackgroundColor(color)
}

@BindingAdapter("onEditorActionListener")
fun TextView.onEditorAction(listener: TextView.OnEditorActionListener) {
    setOnEditorActionListener(listener)
}

@BindingAdapter("textQuantity", "textUnit", "textName")
fun TextView.setTextHtml(quantity: String, unit: String, name: String) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        var x = Html.fromHtml(quantity, Html.FROM_HTML_MODE_COMPACT).toString()
        x = "$x ($unit) $name"
        this.text = x
    } else {
        var x = Html.fromHtml(quantity).toString()
        x = "$x ($unit) $name"
        this.text = x
    }
}