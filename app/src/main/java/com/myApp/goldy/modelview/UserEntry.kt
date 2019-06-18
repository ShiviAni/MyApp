package com.myApp.goldy.modelview

import android.provider.BaseColumns

object DBContract {

    /* Inner class that defines the table contents */
    class UserEntry : BaseColumns {
        companion object {
            val TABLE_NAME = "users"
            val COLUMN_USER_ID = "_id"
            val COLUMN_NAME = "name"
            val COLUMN_PASSWORD = "password"
            val Column_EMAIL="email"
        }
    }
}