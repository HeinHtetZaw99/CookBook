package com.appbase

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.appbase.components.EmptyLoadingViewPod
import com.domain.exception.GenericErrorMessageFactory
import com.google.android.material.snackbar.Snackbar
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject
import kotlin.reflect.KClass

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity(),
    HasSupportFragmentInjector {

    @get:LayoutRes
    abstract val layoutResId: Int

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var genericErrorMessageFactory: GenericErrorMessageFactory

    protected abstract val viewModel: VM

    abstract fun loadData()

    abstract fun onError()

    abstract fun retry()

    private var displayMetrics: DisplayMetrics? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)


    }


    fun fetchDataFromNetwork(view: View, emptyLoadingView: EmptyLoadingViewPod?) {
        /*supportPostponeEnterTransition()
        if (Connectivity.isConnected(this)) {
            supportStartPostponedEnterTransition()
            loadData()
        } else {
            supportStartPostponedEnterTransition()
            emptyLoadingView?.setCurrentState(EmptyLoadingViewPod.EmptyViewState.NETWORK_ERROR)
            onError()
            showSnackBar(
                view,
                ErrorVO(getString(R.string.error_msg_no_network), ErrorVO.TYPE.ERROR),
                getString(R.string.btn_msg_ok)
            )
        }*/
        loadData()
    }


    /**For Showing snackbar with action btn
     * @param view -> parent view where the snackbar will be displayed
     * @param errorVO -> error data with status
     * @param buttonText -> the text for action button of snackbar
     */
    fun showSnackBar(view: View, errorVO: ErrorVO, buttonText: String) {
        val snackBar: Snackbar
        val message: String = getErrorContentMsg(errorVO)

        if (errorVO.errorType === ErrorVO.TYPE.ERROR) {
            snackBar = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
            snackBar.view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.error))
            snackBar.setAction(buttonText) {
                retry()
                snackBar.dismiss()
            }
            snackBar.setActionTextColor(ContextCompat.getColor(view.context, R.color.white))
        } else {
            snackBar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
            snackBar.view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.white))
            snackBar.setActionTextColor(ContextCompat.getColor(view.context, R.color.neutral))
        }
        snackBar.show()
    }

    /**method for getting the current screen's height with desired percentage */
    fun getScreenHeight(context: Context, percentage: Double): Int {
        if (displayMetrics == null)
            initDisplayMetrics(context)
        return (displayMetrics!!.heightPixels * percentage).toInt()
    }

    /**method for getting the current screen's width with desired percentage */
    fun getScreenWidth(context: Context, percentage: Double): Int {
        if (displayMetrics == null)
            initDisplayMetrics(context)
        return (displayMetrics!!.widthPixels * percentage).toInt()
    }


    /**helper method for returning String resources from ErrorVO
     * ErrorVO.getErrorMsg() can be either a String or a String Resource ID ( For Localization Purpose) */
    fun getErrorContentMsg(errorVO: ErrorVO) =
        if (errorVO.errorMsg is Int)
            getString(errorVO.errorMsg as Int)
        else
            errorVO.errorMsg.toString()

    fun initDisplayMetrics(context: Context) {
        displayMetrics = DisplayMetrics()
        (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector


    /**
     * Helper function for easily init of viewModel
     */
    inline fun <reified VM : BaseViewModel> contractedViewModels(): Lazy<VM> =
        ViewModelLazy(VM::class)

    inner class ViewModelLazy<VM : ViewModel>(
        private val viewModelClass: KClass<VM>
    ) : Lazy<VM> {
        private var cached: VM? = null

        override val value: VM
            get() {
                var viewModel = cached
                if (viewModel == null) {
                    viewModel = ViewModelProvider(
                        this@BaseActivity,
                        viewModelFactory
                    ).get(viewModelClass.java)
                    cached = viewModel
                }
                return viewModel
            }

        override fun isInitialized() = cached != null
    }
}