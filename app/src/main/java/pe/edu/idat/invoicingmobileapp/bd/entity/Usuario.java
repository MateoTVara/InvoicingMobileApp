package pe.edu.idat.invoicingmobileapp.bd.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName ="usuario")
public class Usuario {

    @PrimaryKey
    private int idusu;
    private String usuario;
    private String contrasenia;
    private String nombre;

    public int getIdusu() {
        return idusu;
    }

    public void setIdusu(int idusu) {
        this.idusu = idusu;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
