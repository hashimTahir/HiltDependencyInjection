/*
 * Copyright (c) 2021/  4/ 18.  Created by Hashim Tahir
 */

package com.hashim.hiltdependencyinjection.predefinedqualifiers

import android.content.Context
import com.hashim.hiltdependencyinjection.MainActivity
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

/*
if needs to be field injected then use @ActivityContext in MainActivityModule
* which uses ActivityComponent
* */
class SomeClassThatRequiresActivityContext @Inject constructor(
    @ActivityContext val hContext: Context
) {
    fun hTest(): String {
        val hActivityContext = hContext as MainActivity
        return hActivityContext.filesDir.toString()
    }
}