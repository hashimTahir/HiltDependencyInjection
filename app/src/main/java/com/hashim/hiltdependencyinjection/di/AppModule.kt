/*
 * Copyright (c) 2021/  4/ 17.  Created by Hashim Tahir
 */

package com.hashim.hiltdependencyinjection.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent


/*
*Sometimes a type cannot be constructor-injected. This can happen for multiple reasons.
*  For example, One cannot constructor-inject an interface. One  also cannot
* constructor-inject a type that one do not own, such as a class from an external library.
*  In these cases, Hilt must to be provided with information how to create these objects.
*
A Hilt module is a class that is annotated with @Module. Like a Dagger module, it
* informs Hilt how to provide instances of certain types. Unlike Dagger modules,
* one must annotate Hilt modules with @InstallIn to tell Hilt which Android class
* each module will be used or installed in.
*
* ActivityComponent tells hilt to inject in activity. This annotation means that all
* of the dependencies in AppModule are available in all of the app's activities.
*
* SingletonComponent are app level dependencises and exist as long as the app is alive.
*
* */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
}