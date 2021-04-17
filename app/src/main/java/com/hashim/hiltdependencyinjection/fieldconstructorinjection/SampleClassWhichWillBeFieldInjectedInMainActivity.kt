/*
 * Copyright (c) 2021/  4/ 17.  Created by Hashim Tahir
 */

package com.hashim.hiltdependencyinjection.fieldconstructorinjection

import javax.inject.Inject


/*Say we need to inject this class in main activity
* annotaited with @Inject constructor tells hilt how to create it*/

/*Now if SampleClassWhichWillBeFieldInjectedInMainActivity need some other class
* say TestClass, for it to be created. we can use constructor injection*/


class SampleClassWhichWillBeFieldInjectedInMainActivity @Inject constructor(
    val hTestClass: TestClass
) {

    fun hTestIfFieldInjectionIsCompleted() =
        "Field Injection example"

    fun hTestIfConstructorInjectionIsCompleted() = hTestClass.hTestConstructorInjection()

}

class TestClass @Inject constructor() {
    fun hTestConstructorInjection() = "Constructor Injection Example"
}
