/*
 * Copyright (c) 2021/  4/ 18.  Created by Hashim Tahir
 */

package com.hashim.hiltdependencyinjection.viewmodelinjection

import androidx.lifecycle.ViewModel
import com.hashim.hiltdependencyinjection.multibindingsofsametype.MultipleBindingsModule
import com.hashim.hiltdependencyinjection.multibindingsofsametype.MultipleBindingsOfSameType
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

/*Required to inject viewmodel*/
@HiltViewModel
class MainviewModel @Inject constructor(
    @MultipleBindingsModule.TypeAExapmple val hMultiplebinding: MultipleBindingsOfSameType
) : ViewModel() {
    fun hTest() {
        Timber.d("Multiple bindings $hMultiplebinding")
    }
}