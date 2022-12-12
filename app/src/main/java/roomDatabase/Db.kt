package roomDatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import roomDatabase.dao.DaoCategoria
import roomDatabase.dao.DaoTarea
import roomDatabase.dao.DaoUsuario
import roomDatabase.entity.Categoria
import roomDatabase.entity.Usuario
import roomDatabase.entity.Tarea

@Database(
    entities = [Usuario::class, Categoria::class, Tarea::class],
    version = 1
)

abstract class Db:RoomDatabase(){
    abstract fun daoUsuario():DaoUsuario
    abstract fun daoCategoria(): DaoCategoria
    abstract fun daoTarea(): DaoTarea
}