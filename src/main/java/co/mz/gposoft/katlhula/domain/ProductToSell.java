package co.mz.gposoft.katlhula.domain;

public class ProductToSell {


    private long id;

    private String description;

    private String location;

    private SellerContact contacts;

    //this might be an ENUM with punctuation rate from 1 to 5
    private String classification;

    //this might be an ENUM with the categories
    private String category;

    private UserPhoto photo;


}
