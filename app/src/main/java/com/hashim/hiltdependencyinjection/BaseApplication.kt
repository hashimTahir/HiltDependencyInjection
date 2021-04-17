/*
 * Copyright (c) 2021/  4/ 17.  Created by Hashim Tahir
 */

package com.hashim.hiltdependencyinjection

import android.app.Application
import com.hashim.hiltdependencyinjection.Constants.hTag
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/*Base application class is a requirement for hilt to work it must
* be annotated with HiltAndroidApp
*
* @HiltAndroidApp triggers Hilt's code generation, including a base class for the application
* that serves as the application-level dependency container.
*
* Unlike dagger 2 hilt does this by iteself and dosent require any effort on developer's part,
* In dagger 2, One has to build the application class, initilize dagger 2,
* Build the appcompnets, build modules for the components, Use the builder or factory pattern
* to build the components. Save the refrence fo componets in the application class. Rebuild the
* project. which then just initilizes dagger 2.
*
*
* None of  this is required in Hilt which does it all behind the scenes, it also removes all
*  the boilerplate code one has to write , just to setup dagger 2  as explained above.
* */
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