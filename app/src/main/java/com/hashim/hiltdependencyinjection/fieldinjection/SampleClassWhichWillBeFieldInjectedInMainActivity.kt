/*
 * Copyright (c) 2021/  4/ 17.  Created by Hashim Tahir
 */

package com.hashim.hiltdependencyinjection.fieldinjection

import javax.inject.Inject


/*Say we need to inject this class in main activity
* annotaited with @Inject constructor tells hilt how to create it*/
class SampleClassWhichWillBeFieldInjectedInMainActivity @Inject constructor() {

    fun hTestIfInjectionIsCompleted() =
        "Field Injection example"
}