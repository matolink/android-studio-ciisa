package roomDatabase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import roomDatabase.entity.Categoria

@Dao
interface DaoCategoria {
    @Query("SELECT * FROM Categoria")
    suspend fun obtenerCategoria():List<Categoria>

    @Query("SELECT * FROM Categoria WHERE id=:id")
    suspend fun obtenerCategoria(id: String): List<Categoria>

    @Insert
    suspend fun agregarCategoria(categoria: Categoria):Long

    @Query("UPDATE  Categoria SET nombre=:nombre WHERE id=:id")
    suspend fun actualizarCategoria(nombre:String,id: String): Int

    @Query("DELETE FROM Categoria WHERE id=:id")
    suspend fun borrarCategoria(id: String)
}
