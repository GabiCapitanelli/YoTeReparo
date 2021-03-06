package com.yotereparo.controller.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.yotereparo.model.Address;
import com.yotereparo.model.District;
import com.yotereparo.util.customvalidator.FieldsNullityMatch;

@FieldsNullityMatch.List({ 
    @FieldsNullityMatch(
    		nullField = "membresia", 
    		fieldNullityMatch = "barrios", 
    		message = "{user.barrios.not.allowed}"
    ), 
    @FieldsNullityMatch(
    		nullField = "barrios", 
    		fieldNullityMatch = "membresia", 
    		message = "{user.barrios.not.empty}"
    )
})
public class UserDto {
	
	@NotEmpty(message = "{user.id.not.empty}")
	@Size(min=3, max=15, message = "{user.id.size}")
	private String id;
	
	@NotEmpty(message = "{user.nombre.not.empty}")
	private String nombre;
	
	@NotEmpty(message = "{user.apellido.not.empty}")
	private String apellido;
	
	@NotEmpty(message = "{user.email.not.empty}")
	@Email(message = "{user.email.not.valid}")
	private String email;
	
	private LocalDate fechaNacimiento;
	
	private String telefonoPrincipal;
	
	private String telefonoAlternativo;
	
	@NotEmpty(message = "{user.ciudad.not.empty}")
	private String ciudad;
	
	@NotEmpty(message = "{user.contrasena.not.empty}")
	private String contrasena;
	
	private String descripcion;
	
	private String estado;
	
	private int intentosIngreso;
	
	private DateTime fechaUltimoCambioContrasena;
	
	private DateTime fechaUltimoIngreso;
	
	private DateTime fechaExpiracionContrasena;
	
	private DateTime fechaCreacion;
	
	@Size(max=10, message = "{user.membresia.size}")
	private String membresia;
	
	@NotEmpty(message = "{user.direcciones.not.empty}")
	private Set<Address> direcciones = new HashSet<Address>(0);
	
	private Set<District> barrios;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getTelefonoPrincipal() {
		return telefonoPrincipal;
	}
	public void setTelefonoPrincipal(String telefonoPrincipal) {
		this.telefonoPrincipal = telefonoPrincipal;
	}
	public String getTelefonoAlternativo() {
		return telefonoAlternativo;
	}
	public void setTelefonoAlternativo(String telefonoAlternativo) {
		this.telefonoAlternativo = telefonoAlternativo;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getIntentosIngreso() {
		return intentosIngreso;
	}
	public void setIntentosIngreso(int intentosIngreso) {
		this.intentosIngreso = intentosIngreso;
	}
	public DateTime getFechaUltimoCambioContrasena() {
		return fechaUltimoCambioContrasena;
	}
	public void setFechaUltimoCambioContrasena(DateTime fechaUltimoCambioContrasena) {
		this.fechaUltimoCambioContrasena = fechaUltimoCambioContrasena;
	}
	public DateTime getFechaUltimoIngreso() {
		return fechaUltimoIngreso;
	}
	public void setFechaUltimoIngreso(DateTime fechaUltimoIngreso) {
		this.fechaUltimoIngreso = fechaUltimoIngreso;
	}
	public DateTime getFechaExpiracionContrasena() {
		return fechaExpiracionContrasena;
	}
	public void setFechaExpiracionContrasena(DateTime fechaExpiracionContrasena) {
		this.fechaExpiracionContrasena = fechaExpiracionContrasena;
	}
	public DateTime getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(DateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getMembresia() {
		return membresia;
	}
	public void setMembresia(String membresia) {
		this.membresia = membresia;
	}
	public Set<Address> getDirecciones() {
		return direcciones;
	}
	public void setDirecciones(Set<Address> direcciones) {
		this.direcciones = direcciones;
	}
	public Set<District> getBarrios() {
		return barrios;
	}
	public void setBarrios(Set<District> barrios) {
		this.barrios = barrios;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((barrios == null) ? 0 : barrios.hashCode());
		result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
		result = prime * result + ((contrasena == null) ? 0 : contrasena.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((direcciones == null) ? 0 : direcciones.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + ((fechaExpiracionContrasena == null) ? 0 : fechaExpiracionContrasena.hashCode());
		result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
		result = prime * result + ((fechaUltimoCambioContrasena == null) ? 0 : fechaUltimoCambioContrasena.hashCode());
		result = prime * result + ((fechaUltimoIngreso == null) ? 0 : fechaUltimoIngreso.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + intentosIngreso;
		result = prime * result + ((membresia == null) ? 0 : membresia.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((telefonoAlternativo == null) ? 0 : telefonoAlternativo.hashCode());
		result = prime * result + ((telefonoPrincipal == null) ? 0 : telefonoPrincipal.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDto other = (UserDto) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (barrios == null) {
			if (other.barrios != null)
				return false;
		} else if (!barrios.equals(other.barrios))
			return false;
		if (ciudad == null) {
			if (other.ciudad != null)
				return false;
		} else if (!ciudad.equals(other.ciudad))
			return false;
		if (contrasena == null) {
			if (other.contrasena != null)
				return false;
		} else if (!contrasena.equals(other.contrasena))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (direcciones == null) {
			if (other.direcciones != null)
				return false;
		} else if (!direcciones.equals(other.direcciones))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
			return false;
		if (fechaExpiracionContrasena == null) {
			if (other.fechaExpiracionContrasena != null)
				return false;
		} else if (!fechaExpiracionContrasena.equals(other.fechaExpiracionContrasena))
			return false;
		if (fechaNacimiento == null) {
			if (other.fechaNacimiento != null)
				return false;
		} else if (!fechaNacimiento.equals(other.fechaNacimiento))
			return false;
		if (fechaUltimoCambioContrasena == null) {
			if (other.fechaUltimoCambioContrasena != null)
				return false;
		} else if (!fechaUltimoCambioContrasena.equals(other.fechaUltimoCambioContrasena))
			return false;
		if (fechaUltimoIngreso == null) {
			if (other.fechaUltimoIngreso != null)
				return false;
		} else if (!fechaUltimoIngreso.equals(other.fechaUltimoIngreso))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (intentosIngreso != other.intentosIngreso)
			return false;
		if (membresia == null) {
			if (other.membresia != null)
				return false;
		} else if (!membresia.equals(other.membresia))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (telefonoAlternativo == null) {
			if (other.telefonoAlternativo != null)
				return false;
		} else if (!telefonoAlternativo.equals(other.telefonoAlternativo))
			return false;
		if (telefonoPrincipal == null) {
			if (other.telefonoPrincipal != null)
				return false;
		} else if (!telefonoPrincipal.equals(other.telefonoPrincipal))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", fechaNacimiento=" + fechaNacimiento + ", telefonoPrincipal=" + telefonoPrincipal
				+ ", telefonoAlternativo=" + telefonoAlternativo + ", ciudad=" + ciudad + ", contrasena=" + contrasena
				+ ", descripcion=" + descripcion + ", estado=" + estado + ", intentosIngreso=" + intentosIngreso
				+ ", fechaUltimoCambioContrasena=" + fechaUltimoCambioContrasena + ", fechaUltimoIngreso="
				+ fechaUltimoIngreso + ", fechaExpiracionContrasena=" + fechaExpiracionContrasena + ", fechaCreacion="
				+ fechaCreacion + ", membresia=" + membresia + ", direcciones=" + direcciones + ", barrios=" + barrios
				+ "]";
	}
}
