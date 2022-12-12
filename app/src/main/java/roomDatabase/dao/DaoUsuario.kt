package roomDatabase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import roomDatabase.entity.Usuario

@Dao
interface DaoUsuario {
    @Query("SELECT * FROM Usuario")
    fun obtenerUsuario():List<Usuario>

    @Query("SELECT * FROM Usuario WHERE mail=:mail")
    fun obtenerUsuario(mail: String): List<Usuario>

    @Query("SELECT * FROM Usuario WHERE mail=:mail AND contrasena=:contrasena")
    fun login(mail: String, contrasena: String): List<Usuario>

    @Insert
    fun agregarUsuario(usuario: Usuario):Long

    @Query("UPDATE  Usuario SET nombre=:nombre,contrasena=:contrasena WHERE mail=:mail")
    fun actualizarUsuario(nombre:String,mail: String,contrasena:String): Int

    @Query("DELETE FROM Usuario WHERE mail=:mail")
    fun borrarUsuario(mail: String)

}