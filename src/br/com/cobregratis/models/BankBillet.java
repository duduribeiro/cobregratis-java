package br.com.cobregratis.models;

import java.math.BigDecimal;
import java.util.Date;

import com.google.gson.annotations.SerializedName;


public class BankBillet {
	private String acceptance;
	private String address;
	private BigDecimal amount;

	@SerializedName("assignor_code")
	private String assignorCode;

	@SerializedName("bank_billet_account_id")
	private Integer bankBilletAccountId;

	@SerializedName("bank_billet_subscription_id")
	private Integer bankBilletSubscriptionId;

	private String city;

	@SerializedName("cnpj_cpf")
	private CnpjCpf cnpjCpf;

	private String comments;

	@SerializedName("created_at")
	private Date createdAt;

	@SerializedName("created_by_api")
	private Boolean createdByApi;

	private String currency;

	@SerializedName("customer_id")
	private Integer customerId;

	@SerializedName("decimal_character")
	private String decimalCharacter;

	@SerializedName("deleted_at")
	private Date deletedAt;

	private String description;

	@SerializedName("discount_amount")
	private BigDecimal discountAmount;

	@SerializedName("document_amount")
	private BigDecimal documentAmount;

	@SerializedName("document_date")
	private Date documentDate;

	@SerializedName("document_number")
	private String documentNumber;

	@SerializedName("document_type")
	private String documentType;

	@SerializedName("due_date_business_day")
	private String dueDateBusinessDay;

	@SerializedName("email_delayed_at")
	private Date emailDelayedAt;

	@SerializedName("email_sent_at")
	private Date emailSentAt;

	@SerializedName("email_state")
	private Integer emailState;

	@SerializedName("expire_at")
	private Date expireAt;

	@SerializedName("external_form_id")
	private Integer externalFormId;

	@SerializedName("generated_at")
	private Date generatedAt;

	private String guarantor;
	private Boolean homologation;

	@SerializedName("html_created_at")
	private Date htmlCreatedAt;

	@SerializedName("html_delayed_at")
	private Date htmlDelayedAt;

	@SerializedName("html_state")
	private Integer htmlState;

	private Integer id;
	private String instructions;
	private String kind;
	private String line;
	private byte[] meta;
	private String name;
	private String neighborhood;

	@SerializedName("notify_overdue")
	private Boolean notifyOverdue;

	@SerializedName("other_amount_to_add")
	private BigDecimal otherAmountToAdd;

	@SerializedName("our_number")
	private String ourNumber;

	@SerializedName("our_number_prefix")
	private String ourNumberPrefix;

	@SerializedName("our_number_raw")
	private String ourNumberRaw;

	@SerializedName("overdue_notified_at")
	private Date overdueNotifiedAt;

	@SerializedName("paid_amount")
	private BigDecimal paidAmount;

	@SerializedName("paid_at")
	private Date paidAt;

	private Integer parcel;

	@SerializedName("pdf_created_at")
	private Date pdfCreatedAt;

	@SerializedName("pdf_delayed_at")
	private Date pdfDelayedAt;

	@SerializedName("pdf_state")
	private Integer pdfState;

	@SerializedName("percent_fines")
	private BigDecimal percentFines;

	@SerializedName("percent_interest_day")
	private BigDecimal percentInterestDay;

	@SerializedName("processed_our_number")
	private String processedOurNumber;

	private String quantity;

	@SerializedName("service_id")
	private Integer serviceId;

	private String state;
	private String status;

	@SerializedName("subdivision_parent_id")
	private Integer subdivisionParentId;

	@SerializedName("thousand_character")
	private String thousandCharacter;

	@SerializedName("updated_at")
	private Date updatedAt;

	private String zipcode;

	@SerializedName("external_link")
	private String externalLink;

	private String hashcode;

	@SerializedName("carnet_external_link")
	private String carnetExternalLink;


	//--getters and setters

	public String getAcceptance() {
		return acceptance;
	}

	public void setAcceptance(String acceptance) {
		this.acceptance = acceptance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getAssignorCode() {
		return assignorCode;
	}

	public void setAssignorCode(String assignorCode) {
		this.assignorCode = assignorCode;
	}

	public Integer getBankBilletAccountId() {
		return bankBilletAccountId;
	}

	public void setBankBilletAccountId(Integer bankBilletAccountId) {
		this.bankBilletAccountId = bankBilletAccountId;
	}

	public Integer getBankBilletSubscriptionId() {
		return bankBilletSubscriptionId;
	}

	public void setBankBilletSubscriptionId(Integer bankBilletSubscriptionId) {
		this.bankBilletSubscriptionId = bankBilletSubscriptionId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public CnpjCpf getCnpjCpf() {
		return cnpjCpf;
	}

	public void setCnpjCpf(CnpjCpf cnpjCpf) {
		this.cnpjCpf = cnpjCpf;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getDecimalCharacter() {
		return decimalCharacter;
	}

	public void setDecimalCharacter(String decimalCharacter) {
		this.decimalCharacter = decimalCharacter;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	public BigDecimal getDocumentAmount() {
		return documentAmount;
	}

	public void setDocumentAmount(BigDecimal documentAmount) {
		this.documentAmount = documentAmount;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public Date getDocumentDate() {
		return documentDate;
	}

	public void setDocumentDate(Date documentDate) {
		this.documentDate = documentDate;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDueDateBusinessDay() {
		return dueDateBusinessDay;
	}

	public void setDueDateBusinessDay(String dueDateBusinessDay) {
		this.dueDateBusinessDay = dueDateBusinessDay;
	}

	public Date getEmailDelayedAt() {
		return emailDelayedAt;
	}

	public void setEmailDelayedAt(Date emailDelayedAt) {
		this.emailDelayedAt = emailDelayedAt;
	}

	public Date getEmailSentAt() {
		return emailSentAt;
	}

	public void setEmailSentAt(Date emailSentAt) {
		this.emailSentAt = emailSentAt;
	}

	public Integer getEmailState() {
		return emailState;
	}

	public void setEmailState(Integer emailState) {
		this.emailState = emailState;
	}

	public Date getExpireAt() {
		return expireAt;
	}

	public void setExpireAt(Date expireAt) {
		this.expireAt = expireAt;
	}

	public Integer getExternalFormId() {
		return externalFormId;
	}

	public void setExternalFormId(Integer externalFormId) {
		this.externalFormId = externalFormId;
	}

	public Date getGeneratedAt() {
		return generatedAt;
	}

	public void setGeneratedAt(Date generatedAt) {
		this.generatedAt = generatedAt;
	}

	public String getGuarantor() {
		return guarantor;
	}

	public void setGuarantor(String guarantor) {
		this.guarantor = guarantor;
	}

	public Boolean getHomologation() {
		return homologation;
	}

	public void setHomologation(Boolean homologation) {
		this.homologation = homologation;
	}

	public Date getHtmlCreatedAt() {
		return htmlCreatedAt;
	}

	public void setHtmlCreatedAt(Date htmlCreatedAt) {
		this.htmlCreatedAt = htmlCreatedAt;
	}

	public Date getHtmlDelayedAt() {
		return htmlDelayedAt;
	}

	public void setHtmlDelayedAt(Date htmlDelayedAt) {
		this.htmlDelayedAt = htmlDelayedAt;
	}

	public Integer getHtmlState() {
		return htmlState;
	}

	public void setHtmlState(Integer htmlState) {
		this.htmlState = htmlState;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public byte[] getMeta() {
		return meta;
	}

	public void setMeta(byte[] meta) {
		this.meta = meta;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public Boolean getNotifyOverdue() {
		return notifyOverdue;
	}

	public void setNotifyOverdue(Boolean notifyOverdue) {
		this.notifyOverdue = notifyOverdue;
	}

	public BigDecimal getOtherAmountToAdd() {
		return otherAmountToAdd;
	}

	public void setOtherAmountToAdd(BigDecimal otherAmountToAdd) {
		this.otherAmountToAdd = otherAmountToAdd;
	}

	public String getOurNumber() {
		return ourNumber;
	}

	public void setOurNumber(String ourNumber) {
		this.ourNumber = ourNumber;
	}

	public String getOurNumberPrefix() {
		return ourNumberPrefix;
	}

	public void setOurNumberPrefix(String ourNumberPrefix) {
		this.ourNumberPrefix = ourNumberPrefix;
	}

	public String getOurNumberRaw() {
		return ourNumberRaw;
	}

	public void setOurNumberRaw(String ourNumberRaw) {
		this.ourNumberRaw = ourNumberRaw;
	}

	public Date getOverdueNotifiedAt() {
		return overdueNotifiedAt;
	}

	public void setOverdueNotifiedAt(Date overdueNotifiedAt) {
		this.overdueNotifiedAt = overdueNotifiedAt;
	}

	public BigDecimal getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(BigDecimal paidAmount) {
		this.paidAmount = paidAmount;
	}

	public Date getPaidAt() {
		return paidAt;
	}

	public void setPaidAt(Date paidAt) {
		this.paidAt = paidAt;
	}

	public Integer getParcel() {
		return parcel;
	}

	public void setParcel(Integer parcel) {
		this.parcel = parcel;
	}

	public Date getPdfCreatedAt() {
		return pdfCreatedAt;
	}

	public void setPdfCreatedAt(Date pdfCreatedAt) {
		this.pdfCreatedAt = pdfCreatedAt;
	}

	public Date getPdfDelayedAt() {
		return pdfDelayedAt;
	}

	public void setPdfDelayedAt(Date pdfDelayedAt) {
		this.pdfDelayedAt = pdfDelayedAt;
	}

	public Integer getPdfState() {
		return pdfState;
	}

	public void setPdfState(Integer pdfState) {
		this.pdfState = pdfState;
	}

	public BigDecimal getPercentFines() {
		return percentFines;
	}

	public void setPercentFines(BigDecimal percentFines) {
		this.percentFines = percentFines;
	}

	public BigDecimal getPercentInterestDay() {
		return percentInterestDay;
	}

	public void setPercentInterestDay(BigDecimal percentInterestDay) {
		this.percentInterestDay = percentInterestDay;
	}

	public String getProcessedOurNumber() {
		return processedOurNumber;
	}

	public void setProcessedOurNumber(String processedOurNumber) {
		this.processedOurNumber = processedOurNumber;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getSubdivisionParentId() {
		return subdivisionParentId;
	}

	public void setSubdivisionParentId(Integer subdivisionParentId) {
		this.subdivisionParentId = subdivisionParentId;
	}

	public String getThousandCharacter() {
		return thousandCharacter;
	}

	public void setThousandCharacter(String thousandCharacter) {
		this.thousandCharacter = thousandCharacter;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getExternalLink() {
		return externalLink;
	}

	public void setExternalLink(String externalLink) {
		this.externalLink = externalLink;
	}

	public String getHashcode() {
		return hashcode;
	}

	public void setHashcode(String hashcode) {
		this.hashcode = hashcode;
	}

	public String getCarnetExternalLink() {
		return carnetExternalLink;
	}

	public void setCarnetExternalLink(String carnetExternalLink) {
		this.carnetExternalLink = carnetExternalLink;
	}

	public Boolean getCreatedByApi() {
		return createdByApi;
	}

	public void setCreatedByApi(Boolean createdByApi) {
		this.createdByApi = createdByApi;
	}


	//inner class

	public class CnpjCpf {
		private String numero;
		private Integer match;
		@SerializedName("numero_puro")
		private String numeroPuro;
		@SerializedName("para_verificacao")
		private String paraVerificacao;

		public String getNumero() {
			return numero;
		}

		public void setNumero(String numero) {
			this.numero = numero;
		}

		public Integer getMatch() {
			return match;
		}

		public void setMatch(Integer match) {
			this.match = match;
		}

		public String getNumeroPuro() {
			return numeroPuro;
		}

		public void setNumeroPuro(String numeroPuro) {
			this.numeroPuro = numeroPuro;
		}
	}

}