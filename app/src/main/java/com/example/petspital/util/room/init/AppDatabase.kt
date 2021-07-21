//package com.example.petspital.util.room.init
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.example.petspital.util.room.dao.HospDao
//import com.example.petspital.util.room.entity.Hosp
//
//@Database(entities = arrayOf(Hosp::class), version = 1)
//abstract class AppDatabase : RoomDatabase() {
//    abstract fun hospDao(): HospDao
//
//    companion object{
//        private var Instance : AppDatabase? = null
//        fun getInstance(context: Context) : AppDatabase?{
//            if(Instance == null){
//                synchronized(AppDatabase::class.java){
//                    Instance = Room.databaseBuilder(
//                        context,
//                        AppDatabase::class.java,
//                        "PetspitalDB"
//                    ).build()
//                }
//            }
//            return Instance
//        }
//        fun deleteInstance(){
//            Instance = null
//        }
//    }
//}