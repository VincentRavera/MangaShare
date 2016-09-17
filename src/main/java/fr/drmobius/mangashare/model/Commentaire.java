package fr.drmobius.mangashare.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Commentaire implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String commentaire;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Manga manga;
	
	private Date dateDuPost;

	public Commentaire() {
		super();
	}

	public Commentaire(Long id, String commentaire, Manga manga, Date date) {
		super();
		this.id = id;
		this.commentaire = commentaire;
		this.manga = manga;
		this.dateDuPost = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Manga getManga() {
		return manga;
	}

	public void setManga(Manga manga) {
		this.manga = manga;
	}

	public Date getDateDuPost() {
		return dateDuPost;
	}

	public void setDateDuPost(Date dateDuPost) {
		this.dateDuPost = dateDuPost;
	}
	
}
