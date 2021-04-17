/*
 * Copyright (c) 2021/  4/ 17.  Created by Hashim Tahir
 */

package com.hashim.hiltdependencyinjection

import android.app.Application
import androidx.viewbinding.BuildConfig
import com.hashim.hiltdependencyinjection.Constants.hTag
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/*Base application class is a requirement for hilt to work it must
* be annotated with HiltAndroidApp */
@HiltAndroidApp
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        hInitTimber()
    }

    private fun hInitTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                override fun log(
                    priority: Int,
                    tag: String?,
                    message: String,
                    t: Throwable?
                ) {
                    super.log(
                        priority,
                        String.format(hTag, tag),
                        message,
                        t
                    )
                }
            })
        }
    }
}