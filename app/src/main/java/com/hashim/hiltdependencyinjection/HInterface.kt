/*
 * Copyright (c) 2021/  4/ 17.  Created by Hashim Tahir
 */

package com.hashim.hiltdependencyinjection

import javax.inject.Inject


/*Say we need to inject this interface*/
interface HInterface {
    fun hTestInterface(): String
}


/*Create implementation of the interface
* inject constructor to let Hilt know, how to provide it.*/
class hInterfaceImpl @Inject constructor() : HInterface {
    override fun hTestInterface(): String {
        return "Injected with hilt"
    }

}

