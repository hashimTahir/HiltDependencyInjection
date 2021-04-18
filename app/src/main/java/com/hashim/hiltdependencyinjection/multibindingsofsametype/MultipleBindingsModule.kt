/*
 * Copyright (c) 2021/  4/ 18.  Created by Hashim Tahir
 */

package com.hashim.hiltdependencyinjection.multibindingsofsametype

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Qualifier


/*
* Provide multiple bindings for the same type
* In cases where Hilt needs to provide different implementations of the same type
*  as dependencies, then hilt must be provided Hilt with multiple bindings.
* Multiple bindings for the same type can be provided with qualifiers.
*
* A qualifier is an annotation that is  used to identify a specific binding for a
* type when that type has multiple bindings defined.
*
* Say we have a class MultipleBindingsOfSameType which can be instanciated either with
* TypeA calls or TypeB class. And This MultipleBindingsOfSameType needs to be injected in
* MainActivity class.
* */

@Module
@InstallIn(ActivityComponent::class)
object MultipleBindingsModule {

    /*let Hilt know how to create TypeA and TypeB*/
    @Provides
    fun hProvidesTypeA(): TypeA {
        return TypeA()
    }

    @Provides
    fun hProvidesTypeB(): TypeB {
        return TypeB()
    }


    /*Annotate the required type, in this case TypeAExapmple*/
    @TypeAExapmple
    @Provides
    fun hProvidesMultipleBindingsOfSameTypeA(typeA: TypeA): MultipleBindingsOfSameType {
        return MultipleBindingsOfSameType(typeA)
    }


    /*Annotate the required type, in this case TypeBExapmple*/
    @TypeBExample
    @Provides
    fun hProvidesMultipleBindingsOfSameTypeB(typeb: TypeB): MultipleBindingsOfSameType {
        return MultipleBindingsOfSameType(typeb)
    }


    /*Qualifies */
    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class TypeAExapmple

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class TypeBExample



}