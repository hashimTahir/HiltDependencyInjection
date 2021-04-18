/*
 * Copyright (c) 2021/  4/ 18.  Created by Hashim Tahir
 */

package com.hashim.hiltdependencyinjection.viewmodelinjection

import com.hashim.hiltdependencyinjection.multibindingsofsametype.MultipleBindingsModule
import com.hashim.hiltdependencyinjection.multibindingsofsametype.MultipleBindingsOfSameType
import com.hashim.hiltdependencyinjection.multibindingsofsametype.TypeA
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object TestModule {
    @Provides
    fun hProvidesTypeA(): TypeA {
        return TypeA()
    }

    @MultipleBindingsModule.TypeAExapmple
    @Provides
    fun hProvidesMultipleBindingsOfSameTypeA(typeA: TypeA): MultipleBindingsOfSameType {
        return MultipleBindingsOfSameType(typeA)
    }

}