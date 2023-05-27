package com.jobmastery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompany;
    
    private String nameCompany;
    
    private String adresseCompany;
    
    private String cityCompany;
    
    private String phoneCompany;
    
    private String webSiteCompany;
    
    private String publicEmail;
    
    private String imageLogo;
    
    // empty constructor 
    
    public Company() {
    	
    }
    
    // Getters, setters,

	public Long getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(Long idCompany) {
		this.idCompany = idCompany;
	}

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	public String getAdresseCompany() {
		return adresseCompany;
	}

	public void setAdresseCompany(String adresseCompany) {
		this.adresseCompany = adresseCompany;
	}

	public String getCityCompany() {
		return cityCompany;
	}

	public void setCityCompany(String cityCompany) {
		this.cityCompany = cityCompany;
	}

	public String getPhoneCompany() {
		return phoneCompany;
	}

	public void setPhoneCompany(String phoneCompany) {
		this.phoneCompany = phoneCompany;
	}

	public String getWebSiteCompany() {
		return webSiteCompany;
	}

	public void setWebSiteCompany(String webSiteCompany) {
		this.webSiteCompany = webSiteCompany;
	}

	public String getPublicEmail() {
		return publicEmail;
	}

	public void setPublicEmail(String publicEmail) {
		this.publicEmail = publicEmail;
	}

	public String getImageLogo() {
		return imageLogo;
	}

	public void setImageLogo(String imageLogo) {
		this.imageLogo = imageLogo;
	}

	// constructors using fields 
	
	public Company(String nameCompany, String adresseCompany, String cityCompany, String phoneCompany,
			String webSiteCompany, String publicEmail, String imageLogo) {
		super();
		this.nameCompany = nameCompany;
		this.adresseCompany = adresseCompany;
		this.cityCompany = cityCompany;
		this.phoneCompany = phoneCompany;
		this.webSiteCompany = webSiteCompany;
		this.publicEmail = publicEmail;
		this.imageLogo = imageLogo;
	} 
}
