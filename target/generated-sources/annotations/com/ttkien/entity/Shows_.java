package com.ttkien.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-27T16:48:22")
@StaticMetamodel(Shows.class)
public class Shows_ { 

    public static volatile SingularAttribute<Shows, BigInteger> duration;
    public static volatile SingularAttribute<Shows, String> cast;
    public static volatile SingularAttribute<Shows, byte[]> thumbnail;
    public static volatile SingularAttribute<Shows, BigInteger> year;
    public static volatile SingularAttribute<Shows, String> genres;
    public static volatile SingularAttribute<Shows, String> director;
    public static volatile SingularAttribute<Shows, String> description;
    public static volatile SingularAttribute<Shows, BigDecimal> id;
    public static volatile SingularAttribute<Shows, String> writer;
    public static volatile SingularAttribute<Shows, String> title;
    public static volatile SingularAttribute<Shows, String> type;

}