package com.one.core.common_ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.one.core.common.CLICK_INTERVAL_TIME
import com.one.core.common_ui.R
import com.one.core.common_ui.databinding.ToolbarBaseBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import reactivecircus.flowbinding.activity.backPresses
import reactivecircus.flowbinding.android.view.clicks

// BaseFragment에서 사용하는 typealias
typealias FragmentInflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding>(
    private val inflate: FragmentInflate<VB>,
) : Fragment() {

    private var _binding: VB? = null
    val binding get() = _binding!!
    protected open fun savedInstanceStateNull() {} // 필요하면 재정의
    protected open fun savedInstanceStateNotNull(savedInstanceState: Bundle) {} // 필요하면 재정의
    protected open fun onCreateView() {} // 필요하면 재정의
    protected open fun onDestroyViewInFragMent() {} // 필요하면 재정의
    protected abstract fun onViewCreated() // 반드시 재정의

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        if (savedInstanceState == null) { // onSaveInstanceState로 데이터를 넘긴 것이 있다면 null이 아니므로 작동X -> onSaveInstanceState 전에 한번만 호출되었으면 하는 것
            savedInstanceStateNull()
        } else {
            savedInstanceStateNotNull(savedInstanceState)
        }
        initBackPressCallback()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (_binding != null) onViewCreated()
        val inflater = LayoutInflater.from(requireContext())
    }

    override fun onDestroyView() {
        onDestroyViewInFragMent()
        _binding = null
        super.onDestroyView()
    }

    protected fun ToolbarBaseBinding.initBackKey() {
        this.ivToolbarbaseBack.setImageResource(R.drawable.ic_toolbarbase_back)
        this.ivToolbarbaseBack.setOnAvoidDuplicateClickFlow {
            backPress()
        }
    }

    protected fun ToolbarBaseBinding.initTitle(title: String) {
        this.tvToolbarbaseTitle.text = title
    }

    protected fun View.setOnAvoidDuplicateClickFlow(actionInMainThread: () -> Unit) {
        this.clicks().flowOn(Dispatchers.Main) // 이후 chain의 메서드들은 쓰레드 io 영역에서 처리
            .throttleFirst(CLICK_INTERVAL_TIME)
            .flowOn(Dispatchers.IO) // 이후 chain의 메서드들은 쓰레드 main 영역에서 처리
            .onEach {// onEach{}를 main에서 실행
                actionInMainThread()
            }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    // throttleFirst()는 Flow에 없기 때문에 직접 구현해줘야 한다. debounce()는 있다.
    private fun <T> Flow<T>.throttleFirst(intervalTime: Long): Flow<T> = flow {
        var throttleTime = 0L
        collect { upStream ->
            val currentTime = System.currentTimeMillis()
            if ((currentTime - throttleTime) > intervalTime) {
                throttleTime = currentTime
                emit(upStream)
            }
        }
    }

    /**
     * Init back press callback
     *
     * backPress키 이벤트 처리 메서드
     *
     * RxBinding에 onBackPressedDispatcher와 관련된 메서드가 없어서 FlowBinding을 활용했다.
     */
    private fun initBackPressCallback() {
        // FlowBinding의 backPresses 확장함수를 활용하는 방법
        requireActivity().onBackPressedDispatcher.backPresses(viewLifecycleOwner).onEach {
            if (!findNavController().popBackStack()) requireActivity().finish()
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    protected fun backPress() {
        requireActivity().onBackPressedDispatcher.onBackPressed()
    }
}