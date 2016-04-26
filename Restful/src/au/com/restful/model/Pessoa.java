package au.com.restful.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class responsible for holding attributes Pessoa's Object
 * 
 * @author Gustavo <gustavotavaresdias@gmail.com>
 * @date 22 Apr 2016
 *
 */
@XmlRootElement
public final class Pessoa {

	private Integer codigoPessoa;
	private String nomePessoa;
	
	public Integer getCodigoPessoa() {
		return codigoPessoa;
	}
	public void setCodigoPessoa(Integer codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}
	public String getNomePessoa() {
		return nomePessoa;
	}
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
	
	public Pessoa() {
		super();
	}
	
	@Override
	public String toString() {
		return "Pessoa [codigoPessoa=" + codigoPessoa + ", nomePessoa="
				+ nomePessoa + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codigoPessoa == null) ? 0 : codigoPessoa.hashCode());
		result = prime * result
				+ ((nomePessoa == null) ? 0 : nomePessoa.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (codigoPessoa == null) {
			if (other.codigoPessoa != null)
				return false;
		} else if (!codigoPessoa.equals(other.codigoPessoa))
			return false;
		if (nomePessoa == null) {
			if (other.nomePessoa != null)
				return false;
		} else if (!nomePessoa.equals(other.nomePessoa))
			return false;
		return true;
	}
	
	
}
