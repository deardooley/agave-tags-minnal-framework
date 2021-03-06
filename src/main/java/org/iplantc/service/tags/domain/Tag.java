package org.iplantc.service.tags.domain;

import java.util.HashSet;
import java.util.Set;

import org.minnal.jpa.entity.BaseDomain;
import org.minnal.instrument.entity.Searchable;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.AccessType;
import javax.persistence.Access;


// import org.hibernate.validator.constraints.NotEmpty;
import java.sql.Timestamp;

import org.minnal.instrument.entity.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
/**
 * Tag domain class
 *
 * @author Generated by minnal-generator
 */
@AggregateRoot
@Entity
@Table(name="tags")
@Access(AccessType.FIELD)
public class Tag extends BaseDomain {

	@Searchable
	// @NotEmpty
	private String name;

	// @NotEmpty
	private String owner;

	private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

	private Timestamp updatedAt = new Timestamp(System.currentTimeMillis());

	private String tenantId;

	// @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true, targetEntity=org.iplantc.service.tags.domain.Permission.class)
	// @JsonManagedReference("permissions")
  // @JoinColumn(name="tag_id")
  // private Set<Permission> permissions = new HashSet<Permission>();

	@OneToMany(cascade=CascadeType.ALL)
  @JsonManagedReference("resources")
  private Set<Resource> resources = new HashSet<Resource>();

	// @Id
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	// private Long id;
	//
	// /**
	//  * @return the id
	//  */
	// public Long getId() {
	// 	return id;
	// }
	//
	// /**
	//  * @param id the id to set
	//  */
	// public void setId(Long id) {
	// 	this.id = id;
	// }

  // /**
  //  * @return the tag permissions
  //  */
	// public Set<Permission> getPermissions() {
  //   return this.permissions;
  // }
	//
	// /**
	//  * @param permissions the permissions to set
	//  */
  // public void setPermissions(Set<Permission> permissions) {
  // 	this.permissions = permissions;
  // }

	/**
	 * @return the tagged resources
	 */
	public Set<Resource> getResources() {
    return this.resources;
  }

	/**
	 * @param Resources the Resources to set
	 */
  public void setResources(Set<Resource> resources) {
  	this.resources = resources;
  }

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @return the createdAt
	 */
	public Timestamp getCreatedAt() {
		return createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @return the tenantId
	 */
	public String getTenantId() {
		return tenantId;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @param tenantId the tenantId to set
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	// public void addPermission(Permission permission) {
	// 	permission.setTag(this);
	// 	this.permissions.add(permission);
	// }

	public void addResource(Resource resource) {
		resource.setTag(this);
		this.resources.add(resource);
	}

}
