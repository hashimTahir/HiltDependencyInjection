/*
 * Copyright (c) 2021/  4/ 18.  Created by Hashim Tahir
 */

package com.hashim.hiltdependencyinjection.predefinedqualifiers

import android.content.Context
import com.hashim.hiltdependencyinjection.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/*if needs to be field injected then use @ApplicationContext in AppModule
* which uses SingletonComponent*/
class SomeClassThatRequiresApplicationContext @Inject constructor(
    @ApplicationContext val hContext: Context
) {
    fun hTest(): String {
        return hContext.getString(R.string.app_name)
    }
}