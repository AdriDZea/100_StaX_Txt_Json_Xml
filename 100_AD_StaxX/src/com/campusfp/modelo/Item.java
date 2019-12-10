package com.campusfp.modelo;

public class Item {
	private String date;
	private String nombre;
    private String ciudad;
    private String salario;
    
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + nombre + ", Ciudad: " + ciudad + ", Salario: " + salario;
	}
	
	
	
    
    
    
    

}
