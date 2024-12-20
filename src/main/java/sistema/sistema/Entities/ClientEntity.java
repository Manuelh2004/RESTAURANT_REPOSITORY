package sistema.sistema.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int cli_id;
    @Column
    private String cli_name; 
    @Column
    private String cli_last_name; 
    @Column
    private String cli_number; 
    @Column
    private String cli_birthdate; 
    @Column
    private String cli_phone; 
    @Column 
    private String cli_gender; 

    @ManyToOne
    @JoinColumn(name = "tpe_cli_id")
    private TypeClientEntity type_client; 
    @ManyToOne
    @JoinColumn(name = "tpe_doc_id")
    private TypeDocumentEntity type_document;    
    
    public ClientEntity(String cli_name, String cli_last_name, String cli_number, String cli_birthdate,
            String cli_phone, String cli_gender, TypeClientEntity type_client, TypeDocumentEntity type_document) {
        this.cli_name = cli_name;
        this.cli_last_name = cli_last_name;
        this.cli_number = cli_number;
        this.cli_birthdate = cli_birthdate;
        this.cli_phone = cli_phone;
        this.cli_gender = cli_gender;
        this.type_client = type_client;
        this.type_document = type_document;
    }
    public ClientEntity() {
    }

    public String getCli_name() {
        return cli_name;
    }
    public void setCli_name(String cli_name) {
        this.cli_name = cli_name;
    }
    public String getCli_last_name() {
        return cli_last_name;
    }
    public void setCli_last_name(String cli_last_name) {
        this.cli_last_name = cli_last_name;
    }
    public String getCli_number() {
        return cli_number;
    }
    public void setCli_number(String cli_number) {
        this.cli_number = cli_number;
    }
    public String getCli_birthdate() {
        return cli_birthdate;
    }
    public void setCli_birthdate(String cli_birthdate) {
        this.cli_birthdate = cli_birthdate;
    }
    public String getCli_phone() {
        return cli_phone;
    }
    public void setCli_phone(String cli_phone) {
        this.cli_phone = cli_phone;
    }
    public String getCli_gender() {
        return cli_gender;
    }
    public void setCli_gender(String cli_gender) {
        this.cli_gender = cli_gender;
    }
    public TypeClientEntity getType_client() {
        return type_client;
    }
    public void setType_client(TypeClientEntity type_client) {
        this.type_client = type_client;
    }
    public TypeDocumentEntity getType_document() {
        return type_document;
    }
    public void setType_document(TypeDocumentEntity type_document) {
        this.type_document = type_document;
    }        
}
