package com.zp.mvvmkotlindemo.ui.login


import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.zp.mvvmkotlindemo.MainActivity
import com.zp.mvvmkotlindemo.R
import com.zp.mvvmkotlindemo.databinding.ActivityLoginBinding
import com.zp.mvvmkotlindemo.util.InjectorUtil
import com.zp.mvvmkotlindemo.util.ToastUtil


class LoginActivity : AppCompatActivity() {
    private var progressDialog: ProgressDialog? = null

    val viewModel by lazy {
        ViewModelProviders.of(this, InjectorUtil.getLoginModelFactory()).get(LoginViewModel::class.java)
    }

    private val binding by lazy { DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.loginViewModel = viewModel

        binding.emailSignInButton.setOnClickListener {
            Toast.makeText(this, binding.email.text.toString(), Toast.LENGTH_SHORT).show()
            viewModel.postLogin(binding.email.text.toString(), binding.password.text.toString())
        }

        observe()
    }

    private fun observe() {
        viewModel.loginResult.observe(this, Observer {
            closeProgressDialog()
            if (it) {//
                ToastUtil.showToast("登录成功！")
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                ToastUtil.showToast("登录失败！")
            }
        })

        viewModel.isLoading.observe(this, Observer { isLoading ->
            if (isLoading) showProgressDialog()
            else closeProgressDialog()
        })
    }

    /**
     * 显示进度对话框
     */
    private fun showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = ProgressDialog(this)
            progressDialog?.setMessage("正在加载...")
            progressDialog?.setCanceledOnTouchOutside(false)
        }
        progressDialog?.show()
    }

    /**
     * 关闭进度对话框
     */
    private fun closeProgressDialog() {
        progressDialog?.dismiss()
    }
}
