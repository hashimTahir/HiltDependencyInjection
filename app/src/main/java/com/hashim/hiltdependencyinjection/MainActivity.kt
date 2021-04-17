/*
 * Copyright (c) 2021/  4/ 17.  Created by Hashim Tahir
 */

package com.hashim.hiltdependencyinjection

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hashim.hiltdependencyinjection.databinding.ActivityMainBinding
import com.hashim.hiltdependencyinjection.fieldconstructorinjection.SampleClassWhichWillBeFieldInjectedInMainActivity
import com.hashim.hiltdependencyinjection.multibindingsofsametype.MultipleBindingsModule
import com.hashim.hiltdependencyinjection.multibindingsofsametype.MultipleBindingsOfSameType
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject


/*Any class which requires dependencies injected into it needs to be annotaited with
* @AndroidEntryPoint
* which add this to the dependency graph so that dependenies can be injected.
* */

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var hActivityMainBinding: ActivityMainBinding

    /*To Inject a dependeny annotate it @Inject annotation*/

    /*Field injection
    * When a class or variable is injected as a field, Hilt will instansiate this class itself
    * and will provide it where it is requied.
    *Fields injected by Hilt cannot be private. Attempting to inject a private field with
    *  Hilt results in a compilation error.
    * */

    @Inject
    lateinit var hSampleClassWhichWillBeFieldInjectedInMainActivity:
            SampleClassWhichWillBeFieldInjectedInMainActivity

    @Inject
    lateinit var hInterface: HInterface

    @Inject
    lateinit var hRetroService: RetroService


    /*When Injection Use Qualifier. which tells hilt what type should be used.*/
    @Inject
    @MultipleBindingsModule.TypeAExapmple
    lateinit var hMultipleBindingsOfSameTypeA: MultipleBindingsOfSameType


    @Inject
    @MultipleBindingsModule.TypeBExample
    lateinit var hMultipleBindingsOfSameTypeB: MultipleBindingsOfSameType

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(hActivityMainBinding.root)


        Timber.d(
            "This is Field injection example ${
                hSampleClassWhichWillBeFieldInjectedInMainActivity.hTestIfFieldInjectionIsCompleted()
            }"
        )

        Timber.d(
            "This is Constructor injection example ${
                hSampleClassWhichWillBeFieldInjectedInMainActivity.hTestIfConstructorInjectionIsCompleted()
            }"
        )

        Timber.d("Activity component injection ${hInterface.hTestInterface()}")


        Timber.d("Retrofit instance injected ${hRetroService}")


        Timber.d("Multiple Instance injected $hMultipleBindingsOfSameTypeA")
        Timber.d("Multiple Instance injected $hMultipleBindingsOfSameTypeB")
    }


}