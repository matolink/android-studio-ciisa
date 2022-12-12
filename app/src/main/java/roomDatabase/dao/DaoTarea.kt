package roomDatabase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import roomDatabase.entity.Tarea

@Dao
interface DaoTarea {
    @Query("SELECT * FROM Tarea")
    suspend fun obtenerTarea():List<Tarea>

    @Query("SELECT * FROM Tarea WHERE id=:id")
    suspend fun obtenerTarea(id: String): List<Tarea>

    @Query("SELECT * FROM Tarea WHERE id_categoria=:id_categoria")
    suspend fun obtenerTareaByCategory(id_categoria: String): List<Tarea>

    @Insert
    suspend fun agregarTarea(tarea: Tarea):Long

    @Query("UPDATE Tarea SET tarea=:tarea ,fecha_creacion=:fecha_creacion, id_categoria=:id_categoria WHERE id=:id")
    suspend fun actualizarTarea(tarea:String,fecha_creacion: String,id_categoria:String, id:String): Int

    @Query("UPDATE Tarea SET estado=:estado WHERE id=:id")
    suspend fun actualizarEstadoTarea(estado:String, id: String): Int

    @Query("DELETE FROM Tarea WHERE id=:id")
    suspend fun borrarTarea(id: String)

}
