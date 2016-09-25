package fr.drmobius.mangashare.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Manga implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="mangas")
	private List<Genre> genres;
	
	private String nom;
	
	private Date date;
	
	private String desc;
	
	private String url;
	
	private Date dateDeCreationDuPost;
	
	private Boolean aLire;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private List<Commentaire> commentaires;

	public Manga() {

	}

	public Manga(Long id, List<Genre> lg, String descr,
			String url, List<Commentaire> coms, Date date, Boolean toRead) {
		this.id = id;
		this.genres = lg;
		this.desc = descr;
		this.url = url;
		this.commentaires = coms;
		this.dateDeCreationDuPost = date;
		this.aLire = toRead;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getDateDeCreationDuPost() {
		return dateDeCreationDuPost;
	}

	public void setDateDeCreationDuPost(Date dateDeCreationDuPost) {
		this.dateDeCreationDuPost = dateDeCreationDuPost;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Boolean getaLire() {
		return aLire;
	}

	public void setaLire(Boolean aLire) {
		this.aLire = aLire;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
