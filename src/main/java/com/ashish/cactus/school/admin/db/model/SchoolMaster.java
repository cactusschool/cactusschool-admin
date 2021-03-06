package com.ashish.cactus.school.admin.db.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;


/**
 * The persistent class for the school_master database table.
 * 
 */
@Entity
@Table(name="school_master")
@NamedQuery(name="SchoolMaster.findAll", query="SELECT s FROM SchoolMaster s")
@Where(clause="delete_ind is NULL or delete_ind='N'")
public class SchoolMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="school_id", unique=true, nullable=false)
	private int schoolId;

	@Column(name="address_id", nullable=false)
	private int addressId;

	@Column(name="context_root", nullable=false, length=50)
	private String contextRoot;

	@Column(name="contract_id", nullable=false)
	private int contractId;

	@Column(name="create_date", nullable=false)
	private Timestamp createDate;

	@Column(name="create_user", nullable=false, length=100)
	private String createUser;

	@Column(name="db_name", nullable=false, length=50)
	private String dbName;

	@Column(name="delete_ind", nullable=false, length=2)
	private String deleteInd;

	@Column(name="delete_reason", nullable=false, length=100)
	private String deleteReason;

	@Column(name="school_code", nullable=false, length=50)
	private String schoolCode;

	@Column(name="school_group_name", length=150)
	private String schoolGroupName;

	@Column(name="school_name", nullable=false, length=150)
	private String schoolName;

	@Column(name="school_parent_id", nullable=false)
	private int schoolParentId;

	@Column(name="sms_sender_id", nullable=false, length=50)
	private String smsSenderId;

	@Column(name="update_date", nullable=false)
	private Timestamp updateDate;

	@Column(name="update_user", nullable=false, length=100)
	private String updateUser;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="schoolMaster", cascade={CascadeType.REMOVE,CascadeType.MERGE, CascadeType.REFRESH}, fetch=FetchType.LAZY)
	private List<Address> addresses;

	//bi-directional many-to-one association to SchoolUser
	@OneToMany(mappedBy="schoolMaster")
	private List<SchoolUser> schoolUsers;

	//bi-directional many-to-one association to ModulesPermission
	@OneToMany(mappedBy="schoolMaster", cascade={CascadeType.REMOVE,CascadeType.MERGE, CascadeType.REFRESH}, fetch=FetchType.LAZY)
	private List<ModulesPermission> modulesPermissions;
	
	//bi-directional many-to-one association to LicenseDetail
	@OneToMany(mappedBy="schoolMaster", cascade={CascadeType.REMOVE,CascadeType.MERGE, CascadeType.REFRESH}, fetch=FetchType.LAZY)
	private List<LicenseDetail> licenseDetails;
		
	public SchoolMaster() {
	}

	public int getSchoolId() {
		return this.schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getContextRoot() {
		return this.contextRoot;
	}

	public void setContextRoot(String contextRoot) {
		this.contextRoot = contextRoot;
	}

	public int getContractId() {
		return this.contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getDbName() {
		return this.dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getDeleteInd() {
		return this.deleteInd;
	}

	public void setDeleteInd(String deleteInd) {
		this.deleteInd = deleteInd;
	}

	public String getDeleteReason() {
		return this.deleteReason;
	}

	public void setDeleteReason(String deleteReason) {
		this.deleteReason = deleteReason;
	}

	public String getSchoolCode() {
		return this.schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public String getSchoolGroupName() {
		return this.schoolGroupName;
	}

	public void setSchoolGroupName(String schoolGroupName) {
		this.schoolGroupName = schoolGroupName;
	}

	public String getSchoolName() {
		return this.schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public int getSchoolParentId() {
		return this.schoolParentId;
	}

	public void setSchoolParentId(int schoolParentId) {
		this.schoolParentId = schoolParentId;
	}

	public String getSmsSenderId() {
		return this.smsSenderId;
	}

	public void setSmsSenderId(String smsSenderId) {
		this.smsSenderId = smsSenderId;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setSchoolMaster(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setSchoolMaster(null);

		return address;
	}

	public List<SchoolUser> getSchoolUsers() {
		return this.schoolUsers;
	}

	public void setSchoolUsers(List<SchoolUser> schoolUsers) {
		this.schoolUsers = schoolUsers;
	}

	public SchoolUser addSchoolUser(SchoolUser schoolUser) {
		getSchoolUsers().add(schoolUser);
		schoolUser.setSchoolMaster(this);

		return schoolUser;
	}

	public SchoolUser removeSchoolUser(SchoolUser schoolUser) {
		getSchoolUsers().remove(schoolUser);
		schoolUser.setSchoolMaster(null);

		return schoolUser;
	}

	public List<ModulesPermission> getModulesPermissions() {
		return this.modulesPermissions;
	}

	public void setModulesPermissions(List<ModulesPermission> modulesPermissions) {
		this.modulesPermissions = modulesPermissions;
	}

	public ModulesPermission addModulesPermission(ModulesPermission modulesPermission) {
		getModulesPermissions().add(modulesPermission);
		modulesPermission.setSchoolMaster(this);

		return modulesPermission;
	}

	public ModulesPermission removeModulesPermission(ModulesPermission modulesPermission) {
		getModulesPermissions().remove(modulesPermission);
		modulesPermission.setSchoolMaster(null);

		return modulesPermission;
	}

	public List<LicenseDetail> getLicenseDetails() {
		return this.licenseDetails;
	}

	public void setLicenseDetails(List<LicenseDetail> licenseDetails) {
		this.licenseDetails = licenseDetails;
	}

	public LicenseDetail addLicenseDetail(LicenseDetail licenseDetail) {
		getLicenseDetails().add(licenseDetail);
		licenseDetail.setSchoolMaster(this);

		return licenseDetail;
	}

	public LicenseDetail removeLicenseDetail(LicenseDetail licenseDetail) {
		getLicenseDetails().remove(licenseDetail);
		licenseDetail.setSchoolMaster(null);

		return licenseDetail;
	}
	
	@Override
	public String toString() {
		return "SchoolMaster [schoolId=" + schoolId + ", addressId="
				+ addressId + ", contextRoot=" + contextRoot + ", contractId="
				+ contractId + ", createDate=" + createDate + ", createUser="
				+ createUser + ", dbName=" + dbName + ", deleteInd="
				+ deleteInd + ", deleteReason=" + deleteReason
				+ ", schoolCode=" + schoolCode + ", schoolGroupName="
				+ schoolGroupName + ", schoolName=" + schoolName
				+ ", schoolParentId=" + schoolParentId + ", smsSenderId="
				+ smsSenderId + ", updateDate=" + updateDate + ", updateUser="
				+ updateUser + ", addresses=" + addresses + ", schoolUsers="
				+ schoolUsers + ", modulesPermissions=" + modulesPermissions
				+ "]";
	}
}