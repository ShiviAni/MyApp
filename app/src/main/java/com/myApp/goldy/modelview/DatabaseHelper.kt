package com.myApp.goldy.modelview

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import com.myApp.goldy.model.User
import com.myApp.goldy.modelview.DBContract.UserEntry.Companion.TABLE_NAME


class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    @Throws(SQLiteConstraintException::class)
    fun insertUser(user: User): Boolean {

        val values = ContentValues()
        //  values.put(DBContract.UserEntry.COLUMN_USER_ID, 1)
        values.put(DBContract.UserEntry.COLUMN_NAME, user.name)
        values.put(DBContract.UserEntry.COLUMN_PASSWORD, user.password)
        values.put(DBContract.UserEntry.Column_EMAIL, user.email)

        // Insert the new row, returning the primary key value of the new row
        //  val newRowId = db.insert(DBContract.UserEntry.TABLE_NAME, null, values)
        //      db.close();
        val db = writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
        return true
    }


    fun readAllUsers(): ArrayList<User> {
        val users = ArrayList<User>()
        val db = writableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery("select * from " + DBContract.UserEntry.TABLE_NAME, null)


        } catch (e: SQLiteException) {
            db.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList()
        }

        // var userid: String
        var name: String
        var password: String
        var email: String
        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {
                //  userid = cursor.getString(cursor.getColumnIndex(DBContract.UserEntry.COLUMN_USER_ID))
                name = cursor.getString(cursor.getColumnIndex(DBContract.UserEntry.COLUMN_NAME))
                password = cursor.getString(cursor.getColumnIndex(DBContract.UserEntry.COLUMN_PASSWORD))
                email = cursor.getString(cursor.getColumnIndex(DBContract.UserEntry.Column_EMAIL))


                users.add(User(name, password, email))
                cursor.moveToNext()
            }
        }
        return users
    }

/*
    fun checkName(name:String): Boolean{
        val db = readableDatabase

        var cursor: Cursor

        cursor = db.rawQuery("select * from "  + DBContract.UserEntry.TABLE_NAME + " where " + DBContract.UserEntry.COLUMN_NAME + "='" + name + "'", null)

        if(cursor.count>0) {
            return false
        }
           return true
    }



    fun checkPass(password:String): Boolean{
        val db = readableDatabase

        var cursor: Cursor

    //    cursor = db.rawQuery("select * from  TABLE_NAME where name=?", arrayOf<String>(password))
        cursor = db.rawQuery("select * from "   + DBContract.UserEntry.TABLE_NAME +  " where " + DBContract.UserEntry.COLUMN_PASSWORD + "='" + password + "'", null)

        if(cursor.count>0) {
            return true
        }
        return false
    }*/


    fun checkNamePass(name: String, password: String): Boolean {
        val db = readableDatabase

        var cursor: Cursor

        //   cursor = db.rawQuery("select * from  TABLE_NAME where name=? and password=?", arrayOf<String>(name,password))
/*
        cursor = db.rawQuery("select name,password from "  + DBContract.UserEntry.TABLE_NAME + "where" + DBContract.UserEntry.COLUMN_NAME + "='" + name + "'"  + DBContract.UserEntry.COLUMN_PASSWORD + "='" + password + "='", null)
*/

        cursor = db.rawQuery(
            "select" + DBContract.UserEntry.COLUMN_NAME + DBContract.UserEntry.COLUMN_PASSWORD + "from " + DBContract.UserEntry.TABLE_NAME + "where" + DBContract.UserEntry.COLUMN_NAME + "='" + name + "'" + DBContract.UserEntry.COLUMN_PASSWORD + "='" + password + "='",
            null
        )

        if (cursor.count > 0) {
            return true
        }
        return false
    }


    companion object {
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "RegisterData.db"

        private val SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DBContract.UserEntry.TABLE_NAME + " (" +
                    DBContract.UserEntry.COLUMN_USER_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT," +
                    DBContract.UserEntry.COLUMN_NAME + " TEXT," +
                    DBContract.UserEntry.COLUMN_PASSWORD + " TEXT," +
                    DBContract.UserEntry.Column_EMAIL + " TEXT)"

        private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + DBContract.UserEntry.TABLE_NAME
    }

}


/*
package com.myApp.goldy.modelview

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.myApp.goldy.model.User


class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    // create table sql query
    private val CREATE_USER_TABLE = ("CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_PASSWORD + " TEXT" + ")")

    // drop table sql query
    private val DROP_USER_TABLE = "DROP TABLE IF EXISTS $TABLE_USER"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_USER_TABLE)
    }


    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE)

        // Create tables again
      //  onCreate(db)

    }


    fun getAllUser(): List<User> {

        // array of columns to fetch
        val columns = arrayOf(COLUMN_USER_ID, COLUMN_USER_EMAIL, COLUMN_USER_NAME, COLUMN_USER_PASSWORD)

        // sorting orders
        val sortOrder = "$COLUMN_USER_NAME ASC"
        val userList = ArrayList<User>()

        val db = this.readableDatabase

        // query the user table
        val cursor = db.query(TABLE_USER, //Table to query
            columns,            //columns to return
            null,     //columns for the WHERE clause
            null,  //The values for the WHERE clause
            null,      //group the rows
            null,       //filter by row groups
            sortOrder)         //The sort order
        if (cursor.moveToFirst()) {
            do {
                val user = User(id = cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID)).toInt(),
                    name = cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)),
                    email = cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)),
                    password = cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)))

                userList.add(user)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return userList
    }




    fun addUser(user: User) {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(COLUMN_USER_NAME, user.name)
        values.put(COLUMN_USER_EMAIL, user.email)
        values.put(COLUMN_USER_PASSWORD, user.password)

        // Inserting Row
        db.insert(TABLE_USER, null, values)
        db.close()
    }



    fun updateUser(user: User) {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(COLUMN_USER_NAME, user.name)
        values.put(COLUMN_USER_EMAIL, user.email)
        values.put(COLUMN_USER_PASSWORD, user.password)

        // updating row
        db.update(TABLE_USER, values, "$COLUMN_USER_ID = ?",
            arrayOf(user.id.toString()))
        db.close()
    }



    fun deleteUser(user: User) {

        val db = this.writableDatabase
        // delete user record by id
        db.delete(TABLE_USER, "$COLUMN_USER_ID = ?",
            arrayOf(user.id.toString()))
        db.close()


    }



    fun checkUser(email: String): Boolean {

        // array of columns to fetch
        val columns = arrayOf(COLUMN_USER_ID)
        val db = this.readableDatabase

        // selection criteria
        val selection = "$COLUMN_USER_EMAIL = ?"

        // selection argument
        val selectionArgs = arrayOf(email)

        // query user table with condition



        val cursor = db.query(TABLE_USER, //Table to query
            columns,        //columns to return
            selection,      //columns for the WHERE clause
            selectionArgs,  //The values for the WHERE clause
            null,  //group the rows
            null,   //filter by row groups
            null)  //The sort order


        val cursorCount = cursor.count
        cursor.close()
        db.close()

        if (cursorCount > 0) {
            return true
        }

        return false
    }



    fun checkUser(email: String, password: String): Boolean {

        // array of columns to fetch
        val columns = arrayOf(COLUMN_USER_ID)

        val db = this.readableDatabase

        // selection criteria
        val selection = "$COLUMN_USER_EMAIL = ? AND $COLUMN_USER_PASSWORD = ?"

        // selection arguments
        val selectionArgs = arrayOf(email, password)

        // query user table with conditions

        val cursor = db.query(TABLE_USER, //Table to query
            columns, //columns to return
            selection, //columns for the WHERE clause
            selectionArgs, //The values for the WHERE clause
            null,  //group the rows
            null, //filter by row groups
            null) //The sort order

        val cursorCount = cursor.count
        cursor.close()
        db.close()

        if (cursorCount > 0)
            return true

        return false

    }

    companion object {

        // Database Version
        private val DATABASE_VERSION = 1

        // Database Name
        private val DATABASE_NAME = "UserManager.db"

        // User table name
        private val TABLE_USER = "user"

        // User Table Columns names
        private val COLUMN_USER_ID = "user_id"
        private val COLUMN_USER_NAME = "user_name"
        private val COLUMN_USER_EMAIL = "user_email"
        private val COLUMN_USER_PASSWORD = "user_password"
    }
}
*/
