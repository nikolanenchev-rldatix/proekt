package com.example.proekt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME="parking.db";
    private String username;
    private String password;

    public DBHelper(@Nullable Context context) {
        super(context, "parking.db",null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("Create table users(username text primary key,password text)");
        MyDB.execSQL("Create table city(cityname text primary key, citynumber int)");
        MyDB.execSQL("Create table park(parkName text primary key, cityNamee text,  parkSpaces int, takenSpaces int, lat double, long double)");
        MyDB.execSQL("Create table myreservations(id int primary key, citynamee text,parknamee text,hour text, date text)");
        MyDB.execSQL("Create table reservation(rowid int primary key, userR text, cityR text, parkR text, dateR text, timeR text )");
        fillCityWithData(MyDB);
        fillParkWithData(MyDB);
    }
    public boolean insertData(String username, String password){
        this.username = username;
        this.password = password;
        SQLiteDatabase MyDB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result=MyDB.insert("users",null,contentValues);
        if(result==-1) return false;
        else
            return true;

    }
    public boolean insertReservation(String user, String city, String park, String date, String time){

        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("userR", user);
        contentValues.put("cityR", city);
        contentValues.put("parkR", park);
        contentValues.put("dateR", date);
        contentValues.put("timeR", time);
        long ins = MyDB.insert("reservation", null, contentValues);
        if(ins == -1)
            return false;
        else return true;
    }
    public Boolean checkusername(String username){
        SQLiteDatabase MyDB=this.getReadableDatabase();
        Cursor cursor=MyDB.rawQuery("Select * from users where username=?",new String[]{username});
        if(cursor.getCount()>0)
            return false;
        else
            return true;
    }
    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB=this.getReadableDatabase();
        Cursor cursor=MyDB.rawQuery("Select * from users where username= ? and password= ? ",new String[]{username, password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }


    private void fillCityWithData(SQLiteDatabase MyDB) {
        String[] cities = {"Скопје", "Велес", "Струмица", "Битола", "Охрид", "Гостивар", "Тетово"};
        int[] numbers = {5, 2, 1, 2, 2, 2, 1, 1};

        ContentValues values = new ContentValues();

        for (int i=0; i < cities.length;i++) {
            values.put("cityname", cities[i]);
            values.put("citynumber", numbers[i]);
            MyDB.insert("city", null, values);
        }
    }
    private void fillParkWithData(SQLiteDatabase MyDB) {
        String[] parkingLots = {"Паркинг City Mall", "Паркинг ГТЦ", "Паркинг Нова Македонија", "Катна Гаража Илинден", "Катна Гаража Кресненско Востание",
                "Паркинг Хемиска Гимнаија", "Паркинг Пазариште",
                "Глобал Паркинг",
                "Паркинг Стара Болница", "Паркинг Широк Сокак",
                "ЈП Билјанини Извори", "Паркинг Пристаниште",
                "Паркинг Зона",
                "Паркинг Тетово",
        };
        String[] cityP= {"Скопје", "Скопје", "Скопје", "Скопје", "Скопје",
                "Велес", "Велес",
                "Струмица",
                "Битола","Битола",
                "Охрид","Охрид",
                "Гостивар",
                "Тетово"};
        double[] latitude = {42.005864, 41.994514, 41.993442, 41.985663 , 41.996776,
                41.718129, 41.713903,
                41.439633,
                41.026927, 41.030836,
                41.117588, 41.112351,
                41.796165,
                42.007646
        };
        double[] longitude = {21.392932, 21.437454, 21.422464, 21.465201, 21.437004,
                21.772912, 21.785763,
                22.639943,
                21.333055, 21.334509,
                20.798746, 20.799422,
                20.908620,
                20.968645
        };
        int[] free = {400, 250, 200, 180, 421,
                150, 200,
                200,
                165, 155,
                250, 265,
                220,
                100};
        int taken []= {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ContentValues values = new ContentValues();

        for (int i=0; i < parkingLots.length;i++) {

            values.put("parkName", parkingLots[i]);
            values.put("cityNamee", cityP[i]);
            values.put("parkSpaces", free[i]);
            values.put("takenSpaces", taken[i]);
            values.put("lat", latitude[i]);
            values.put("long",longitude[i] );
            MyDB.insert("park", null, values);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("drop table if exists city");
        MyDB.execSQL("drop table if exists park");
        MyDB.execSQL("drop table if exists reservation");
        MyDB.execSQL("drop table if exists myreservations");
        onCreate(MyDB);
    }
    public City query(int position) {
        String query = "SELECT * FROM city ORDER BY cityname ASC " +
                "LIMIT " + position + ",1";

        Cursor cursor = null;
        City entry = new City();

        SQLiteDatabase db = this.getReadableDatabase();
        cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        entry.setCityName(cursor.getString(cursor.getColumnIndex("cityname")));
        entry.setCityNumber(cursor.getInt(cursor.getColumnIndex("citynumber")));
        cursor.close();
        return entry;

    }
    public Park querypark(int position) {

        Cursor cursor;
        Park entry = new Park();

        SQLiteDatabase db = this.getReadableDatabase();
        cursor = db.rawQuery( "Select * from park order by parkName asc limit " + position + ",1", null);
        cursor.moveToFirst();

        entry.setParkName(cursor.getString(cursor.getColumnIndex("parkName")));
        entry.setParkCity(cursor.getString(cursor.getColumnIndex("cityNamee")));
        entry.setParkSpaces(cursor.getInt(cursor.getColumnIndex("parkSpaces")));
        entry.setTakenSpaces(cursor.getInt(cursor.getColumnIndex("takenSpaces")));


        cursor.close();

        return entry;

    }
    public ArrayList<MyReservationsC> getReservations(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<MyReservationsC> reservation = new ArrayList<MyReservationsC>();
        Cursor cursor = db.query("myreservations", null, null,
                null, null, null, "ID" + " DESC", null);
        int i=0;
        if (cursor != null && cursor.moveToFirst()) {
            do {
                String cityname = cursor.getString(1);
                String parkingname = cursor.getString(2);
                String hour = cursor.getString(3);
                String date = cursor.getString(4);
                MyReservationsC pom = new MyReservationsC(cityname,parkingname,hour,date);
                reservation.add(i,pom);
                i++;
            }
            while (cursor.moveToNext());
        }
        return reservation;
    }


    public long count() {
        SQLiteDatabase db = this.getReadableDatabase();
        return DatabaseUtils.queryNumEntries(this.getReadableDatabase(), "city");
    }

    public long countpark(){
        SQLiteDatabase db = this.getReadableDatabase();
        return DatabaseUtils.queryNumEntries(this.getReadableDatabase(), "park");
    }
    public int numberResPerUser(String user){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from reservation where userR=?", new String[]{user});
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getCount();
            cursor.close();
            return count;
        } else return 0;
    }

    public int numberResAtDateTime(String date, String time, String park){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from reservation where dateR=? and timeR=? and parkR=?", new String[]{date, time, park});
        int number = 0;
        if(cursor.moveToFirst()){
            number = cursor.getCount();
            cursor.close();
            return number;
        }else return 0;
    }

    public double latitude (String park){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from park where parkName=?", new String[]{park});
        if(cursor.moveToFirst()){
            return cursor.getDouble(4);
        }else return 0;
    }

    public double longitude (String park){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from park where parkName=?", new String[]{park});
        if(cursor.moveToFirst()){
            return cursor.getDouble(5);
        }else return 0;
    }


}