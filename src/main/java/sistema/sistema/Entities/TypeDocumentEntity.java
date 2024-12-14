package sistema.sistema.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "type_document")
public class TypeDocumentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tpe_doc_id;
    @Column
    private String tpe_doc_name; 
    @Column
    private String tpe_doc_abbreviation;
    
    public TypeDocumentEntity(String tpe_doc_name, String tpe_doc_abbreviation) {
        this.tpe_doc_name = tpe_doc_name;
        this.tpe_doc_abbreviation = tpe_doc_abbreviation;
    }
    public TypeDocumentEntity() {
    }

    public int getTpe_doc_id() {
        return tpe_doc_id;
    }
    public void setTpe_doc_id(int tpe_doc_id) {
        this.tpe_doc_id = tpe_doc_id;
    }
    public String getTpe_doc_name() {
        return tpe_doc_name;
    }
    public void setTpe_doc_name(String tpe_doc_name) {
        this.tpe_doc_name = tpe_doc_name;
    }
    public String getTpe_doc_abbreviation() {
        return tpe_doc_abbreviation;
    }
    public void setTpe_doc_abbreviation(String tpe_doc_abbreviation) {
        this.tpe_doc_abbreviation = tpe_doc_abbreviation;
    }    
}
