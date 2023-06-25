package org.hxl.common.test_conf

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner


open class AppTestRunner : AndroidJUnitRunner() {
    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {
        return super.newApplication(cl, HiltTestApp::class.java.name + "_Application", context)
    }
}

