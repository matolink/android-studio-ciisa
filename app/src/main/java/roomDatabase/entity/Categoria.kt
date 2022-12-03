package roomDatabase.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Categoria {
    @PrimaryKey
    var id:String
    var nombre:String? = null
    var id_usuario:String? = null

    constructor(id: String, nombre: String?, id_usuario: String?) {
        this.id = id
        this.nombre = nombre
        this.id_usuario = id_usuario
    }

    override fun toString(): String {
        return "Categoria(id='$id', nombre=$nombre, id_usuario=$id_usuario)"
    }

}