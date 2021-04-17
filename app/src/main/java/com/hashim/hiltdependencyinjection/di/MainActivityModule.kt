/*
 * Copyright (c) 2021/  4/ 17.  Created by Hashim Tahir
 */

package com.hashim.hiltdependencyinjection.di

import com.hashim.hiltdependencyinjection.HInterface
import com.hashim.hiltdependencyinjection.hInterfaceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


/*ActivityComponent tells hilt to inject in activity. This annotation means that all
* of the dependencies in MainActivityModule are available in all of the app's activities.*/
@Module
@InstallIn(ActivityComponent::class)
abstract class MainActivityModule {

    @Binds
    abstract fun hProvideshHinterface(hInterfaceImpl: hInterfaceImpl): HInterface

}