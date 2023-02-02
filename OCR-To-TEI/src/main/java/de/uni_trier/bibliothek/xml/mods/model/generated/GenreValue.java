//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v4.0.0 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
//


package de.uni_trier.bibliothek.xml.mods.model.generated;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für genreValue.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <pre>{@code
 * <simpleType name="genreValue">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="book"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "genreValue")
@XmlEnum
public enum GenreValue {

    @XmlEnumValue("book")
    BOOK("book");
    private final String value;

    GenreValue(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GenreValue fromValue(String v) {
        for (GenreValue c: GenreValue.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
