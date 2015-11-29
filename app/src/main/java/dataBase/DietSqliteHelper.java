package dataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import interfaces.KeyIDS;

public class DietSqliteHelper extends SQLiteOpenHelper implements KeyIDS {

    private static final String DATABASE_NAME = "DoctorApp.db";
    private static final int DATABASE_VERSION = 1;

    /** Constants **/

    public static final String NAME="name";
    public static final String IMAGE="image";
    public static final String READ="read";

    private final String CREATE_TABLE_FOOD = "CREATE TABLE " + FOOD_TABLE + " ( "
            + FOOD_ID + " INTEGER, " + FOOD_NAME + " TEXT)";
    private final String CREATE_TIME_TABLE = "CREATE TABLE " + TIME_TABLE + " ( "
            + TIME_TABLE_DAY + " TEXT, " + TIME_TABLE_TYPE + " TEXT, " + TIME_TABLE_TIME + " TEXT, "+TIME_TABLE_PLAN_ID+" TEXT, " + TIME_TABLE_MEAL_ID + " TEXT, "
            + TIME_TABLE_MEAL_NAME + " TEXT)";
    private final String CREATE_LOG_TABLE = "CREATE TABLE " + LOG_TABLE + "( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + MEAL_ID + " BIGINT," + PLAN_ID + " BIGINT," + TIMING + " TEXT," + RESPONSE + " TEXT," + DETAILS + " TEXT," + SYNCHRONIZED + " boolean)";


    private static DietSqliteHelper dietSqliteHelper;

    private DietSqliteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DietSqliteHelper getHealthSqliteHelper(Context context) {
        if (dietSqliteHelper == null) {
            dietSqliteHelper = new DietSqliteHelper(context);
        }
        return dietSqliteHelper;
    }

    public static SQLiteDatabase getWritableDatabase(Context context) {
        return getHealthSqliteHelper(context).getWritableDatabase();
    }

    public static void closeDatabase(Context context) {
        getHealthSqliteHelper(context).close();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_FOOD);
        sqLiteDatabase.execSQL(CREATE_TIME_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
    }
}
