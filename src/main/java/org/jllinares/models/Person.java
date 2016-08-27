package org.jllinares.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

/**
 * The Class Persona.
 * @author Javier Llinares
 */
@Entity
@Table(name = "personas")
public class Person {
	
	/** The nombre. */
	 @NotBlank(message = "El nombre no puede ser vacio")
	private String nombre;
	
	/** The apellido. */
	 @NotBlank(message = "El apellido no puede ser vacio")
	private String apellido;
	
	/** The edad. */
	@NotNull(message = "Debe enviar una edad correcta")
	@Min(1)
	private Integer edad;
	
	/** The id. */
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(updatable = false)
	private String id;
	
	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Gets the apellido.
	 *
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	
	/**
	 * Sets the apellido.
	 *
	 * @param apellido the new apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/**
	 * Gets the edad.
	 *
	 * @return the edad
	 */
	public Integer getEdad() {
		return edad;
	}
	
	/**
	 * Sets the edad.
	 *
	 * @param edad the new edad
	 */
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}
}