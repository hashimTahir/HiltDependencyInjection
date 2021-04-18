/*
 * Copyright (c) 2021/  4/ 18.  Created by Hashim Tahir
 */

package com.hashim.hiltdependencyinjection.multibindingsofsametype

import timber.log.Timber

class MultipleBindingsOfSameType {
    constructor(aType: TypeA?) {
        Timber.d("Type a Constructor used")
    }

    constructor(bType: TypeB?) {
        Timber.d("Type b Constructor used")

    }
}