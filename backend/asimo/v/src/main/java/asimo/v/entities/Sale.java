package asimo.v.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import asimo.v.entities.enums.DocType;
import asimo.v.entities.enums.SaleType;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name = "venda")
public class Sale{

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	@Column(name="saleidentifier")
	private String saleIdentifier;

    @Column(name = "nrprotocolo")
    private String protocol = String.format("%05d",id.toString());;

    @Column(name="nrvalorvenda")
    private Long price;

    @Column(name = "dtvenda")
    private Date saleDate;

    @ManyToOne
    @JoinColumn(name = "idusuario", referencedColumnName = "id")
    private User user;

    @Column(name = "formadepagamento")
    private String paymentForm;

    @Column(name = "tipovenda")
    private SaleType saleType;

    @Column(name="nomecliente")
    private String userName;

    @Column(name = "tipodedocumento")
    private DocType docType;

    @Column(name = "nrdocumento")
	@GeneratedValue()
    private String doc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String generateProtocol(){
		return String.format("%05d",id.toString());
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPaymentForm() {
		return paymentForm;
	}

	public void setPaymentForm(String paymentForm) {
		this.paymentForm = paymentForm;
	}

	public SaleType getSaleType() {
		return saleType;
	}

	public void setSaleType(SaleType saleType) {
		this.saleType = saleType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public DocType getDocType() {
		return docType;
	}

	public void setDocType(DocType docType) {
		this.docType = docType;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	public Sale() {
	}

	public Sale(String saleIdentifier, Long price, Date saleDate, User user, String paymentForm, SaleType saleType, String userName, DocType docType, String doc) {
		this.saleIdentifier = saleIdentifier;
		this.price = price;
		this.saleDate = saleDate;
		this.user = user;
		this.paymentForm = paymentForm;
		this.saleType = saleType;
		this.userName = userName;
		this.docType = docType;
		this.doc = doc;
	}

	@Override
	public String toString() {
		return "Sale{" +
				"saleIdentifier='" + saleIdentifier + '\'' +
				", protocol=" + protocol +
				", price=" + price +
				", saleDate=" + saleDate +
				", user=" + user +
				", paymentForm='" + paymentForm + '\'' +
				", saleType=" + saleType +
				", userName='" + userName + '\'' +
				", docType=" + docType +
				", doc='" + doc + '\'' +
				'}';
	}
}
