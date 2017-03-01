package cn.powerdash.libsystem.book.domain;
// Generated 2017-3-2 0:17:49 by Hibernate Tools 3.5.0.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Permission generated by hbm2java
 */
@Entity
@Table(name = "PERMISSION", catalog = "libsystem")
public class Permission implements java.io.Serializable {

	private String permission;
	private String description;

	public Permission() {
	}

	public Permission(String permission) {
		this.permission = permission;
	}

	public Permission(String permission, String description) {
		this.permission = permission;
		this.description = description;
	}

	@Id

	@Column(name = "PERMISSION", unique = true, nullable = false, length = 25)
	public String getPermission() {
		return this.permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	@Column(name = "DESCRIPTION", length = 80)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
