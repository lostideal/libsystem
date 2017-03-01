package cn.powerdash.libsystem.book.domain;
// Generated 2017-3-2 0:17:49 by Hibernate Tools 3.5.0.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * RolePermission generated by hbm2java
 */
@Entity
@Table(name = "ROLE_PERMISSION", catalog = "libsystem")
public class RolePermission implements java.io.Serializable {

	private RolePermissionId id;
	private Role role;

	public RolePermission() {
	}

	public RolePermission(RolePermissionId id, Role role) {
		this.id = id;
		this.role = role;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "rolename", column = @Column(name = "ROLENAME", nullable = false, length = 25)),
			@AttributeOverride(name = "permission", column = @Column(name = "PERMISSION", nullable = false, length = 25)) })
	public RolePermissionId getId() {
		return this.id;
	}

	public void setId(RolePermissionId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLENAME", nullable = false, insertable = false, updatable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
