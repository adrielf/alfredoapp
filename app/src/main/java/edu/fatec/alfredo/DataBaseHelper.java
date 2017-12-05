package edu.fatec.alfredo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper{

    /** An instance variable for SQLiteDatabase */
    private SQLiteDatabase db;

    /** Database name */
    private static String DBNAME = "AlfredoDB";
    private static int VERSION = 1;

    /** A constant, stores the the table name */
    private static final String TABLE_MAPS = "locations";
    private static final String TABLE_WIFI = "networks";
    private static final String TABLE_PROFILE = "preferences";

    public static final String MAPS_NAME = "name";
    public static final String MAPS_LAT = "latitude";
    public static final String MAPS_LONG = "longitude";
    public static final String MAPS_ZOOM = "zoom";

    public static final String PROF_NAME = "name";
    public static final String PROF_LOC_GPS = "loc_gps";
    public static final String PROF_LOC_WIFI = "loc_wifi";
    public static final String PROF_WIFI = "wifi";
    public static final String PROF_GPS = "gps";
    public static final String PROF_DATA3G = "data3g";
    public static final String PROF_VIBRATE = "vibrate";
    public static final String PROF_SILENCE = "silence";

    public static final String WIFI_NAME = "name";
    public static final String WIFI_SSID = "ssid";

    /** Constructor */
    public DataBaseHelper(Context context) {
        super(context, DBNAME, null, VERSION);
        SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql1 =     "CREATE TABLE " + TABLE_MAPS + " ( " +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                MAPS_NAME + "VARCHAR(50) NOT NULL, " +
                MAPS_LAT  + "DOUBLE , " +
                MAPS_LONG + "DOUBLE , " +
                MAPS_ZOOM + "VARCHAR(20)" +
                ")";

        String sql2 =     "CREATE TABLE " + TABLE_PROFILE + " ( " +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PROF_NAME     + "VARCHAR(50) NOT NULL, " +
                PROF_LOC_GPS  + "VARCHAR(50)"+
                PROF_LOC_WIFI + "VARCHAR(50)"+
                PROF_WIFI     + "BOOLEAN, " +
                PROF_GPS      + "BOOLEAN, " +
                PROF_DATA3G   + "BOOLEAN, " +
                PROF_VIBRATE  + "BOOLEAN, " +
                PROF_SILENCE  + "BOOLEAN, " +
                ")";

        String sql3 =     "CREATE TABLE " + TABLE_WIFI + " ( " +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                WIFI_NAME + "VARCHAR(50) NOT NULL, " +
                WIFI_SSID + "VARCHAR(50)" +
                ")";

        this.db.execSQL(sql1);
        this.db.execSQL(sql2);
        this.db.execSQL(sql3);
    }

    /** Inserts a new location to the table Maps */
    public String insertMap(String name, double lat, double lon, String zoo ){
        ContentValues contentValues = new ContentValues();
        contentValues.put(MAPS_NAME, name);
        contentValues.put(MAPS_LAT, lat);
        contentValues.put(MAPS_LONG, lon);
        contentValues.put(MAPS_ZOOM, zoo);
        long result = db.insert(TABLE_MAPS, null, contentValues);

        if(result == -1) {
            return "Erro ao salvar!";
        } else {
            return "Salvo!";
        }
    }

    /** Inserts a new location to the table WiFi */
    public String insertWifi(String name, String ssid){
        ContentValues contentValues = new ContentValues();
        contentValues.put(WIFI_NAME, name);
        contentValues.put(WIFI_SSID, ssid);
        long result = db.insert(TABLE_WIFI, null, contentValues);

        if(result == -1) {
            return "Erro ao salvar!";
        } else {
            return "Salvo!";
        }
    }
    /** Inserts a new profile to the table Profile */
    //public String insertProfile(Profile profile)
    public String insertProfile(String name, String loc_gps, String loc_wifi,boolean wifi, boolean gps,
            boolean data3G, boolean vibrate, boolean silence){
        ContentValues contentValues = new ContentValues();
        contentValues.put(PROF_NAME, name);
        contentValues.put(PROF_LOC_GPS, loc_gps);
        contentValues.put(PROF_LOC_WIFI, loc_wifi);
        contentValues.put(PROF_WIFI, wifi);
        contentValues.put(PROF_GPS, gps);
        contentValues.put(PROF_DATA3G, data3G);
        contentValues.put(PROF_VIBRATE, vibrate);
        contentValues.put(PROF_SILENCE, silence);
        long result = db.insert(TABLE_PROFILE, null, contentValues);

        if(result == -1) {
            return "Erro ao salvar!";
        } else {
            return "Salvo!";
        }
    }

    /** Delete locations from the table Map*/
    public void deleteMap(String name){
        db.delete(TABLE_MAPS, MAPS_NAME +" = " + name, null);
    }

    /** Delete locations from the table Map*/
    public void deleteWifi(String name){
        db.delete(TABLE_WIFI, WIFI_NAME +" = " + name, null);
    }

    /** Delete locations from the table Profile*/
    public void deleteProfile(String name){
        db.delete(TABLE_PROFILE, PROF_NAME +" = " + name, null);
    }

    /** Returns all the locations from the table Map*/
    public Cursor getAllLocations(){
        return db.query(TABLE_MAPS, new String[] { MAPS_NAME,  MAPS_LAT, MAPS_LONG, MAPS_ZOOM } , null, null, null, null, null);
    }

    /** Returns all the locations from the table Profile*/
    public List<Profile> getAllProfiles(){
        List<Profile> list = new ArrayList<Profile>();
        String[] colunas = new String[]{"name"};
        Cursor cursor = db.query(TABLE_PROFILE, colunas, null,null,null,null,"name ASC");
        if(cursor.getCount() > 0 ) {
            cursor.moveToFirst();
            do {
                Profile p = new Profile();
                p.setName(cursor.getString(0));
                list.add(p);
            } while (cursor.moveToNext());
        }
        return list;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

         db.execSQL("DROP TABLE " + TABLE_MAPS + ";");
         onCreate(db);
    }

}
