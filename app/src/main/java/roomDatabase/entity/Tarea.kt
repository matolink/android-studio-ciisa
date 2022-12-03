package roomDatabase.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Tarea {
    @PrimaryKey
    var id:String
    var tarea:String? = null
    var fecha_creacion:String? = null
    var id_categoria:String? = null
    var id_usuario:String? = null
    var estado:Boolean? = null

    constructor(
        id: String,
        tarea: String?,
        fecha_creacion: String?,
        id_categoria: String?,
        id_usuario: String?,
        estado: Boolean?
    ) {
        this.id = id
        this.tarea = tarea
        this.fecha_creacion = fecha_creacion
        this.id_categoria = id_categoria
        this.id_usuario = id_usuario
        this.estado = estado
    }

    override fun toString(): String {
        return "Tarea(id='$id', tarea=$tarea, fecha_creacion=$fecha_creacion, id_categoria=$id_categoria, id_usuario=$id_usuario, estado=$estado)"
    }

}